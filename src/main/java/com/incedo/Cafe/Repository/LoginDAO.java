package com.incedo.Cafe.Repository;

import com.incedo.Cafe.Pojo.Login;
import com.incedo.Cafe.Pojo.Registration;
import com.incedo.Cafe.Pojo.User_details;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.print.attribute.standard.RequestingUserName;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

public class LoginDAO {
    @Autowired
    CreateJdbcTemplate createJdbcTemplate = new CreateJdbcTemplate();
    JdbcTemplate jdbcTemplate;

    {
        try {
            jdbcTemplate = createJdbcTemplate.CreateTemplate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public Registration Authenticate(Login loginCredentials){
        String sql = "select * from loginDetail where userName ='"+loginCredentials.getUserName()+"' and Passkey='"+loginCredentials.getPassword()+"'";
        List<Login> user = jdbcTemplate.query(
                sql,
                new BeanPropertyRowMapper(Login.class));
        System.out.println(user);

        if(user.isEmpty())
            return new Registration();
        else {
            Registration registration = new Registration();
            registration.setLogin_details(new Login(user.get(0).getUserName(),null,user.get(0).getRole()));

            String sql1 = "select * from user_details where emp_id ='"+user.get(0).getUserName()+"' ";
            List<User_details> user1 = jdbcTemplate.query(
                    sql1,
                    new BeanPropertyRowMapper(User_details.class));

            registration.setUser_details(new User_details(user1.get(0).getEmp_id(),user1.get(0).getName(),user1.get(0).getPhone_no()));
            System.out.println(registration);
            return registration;
        }
    }

    public String RegisterUser(Registration register) {
        int x=0,y=0;
        try {
            x = jdbcTemplate.update("insert into user_details values(" + register.getUser_details().getEmp_id() + ",'" + register.getUser_details().getName() + "'," + register.getUser_details().getPhone_no() + ")");
            System.out.println("interted user_details of :"+x+" users");
            y=  jdbcTemplate.update("insert into LoginDetail values('"+register.getLogin_details().getUserName()+"','"+register.getLogin_details().getPassword()+"','"+register.getLogin_details().getRole()+"')");
            System.out.println("interted Login_details of :"+y+" users");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    if(x==1 && y==1){
        return "Successfully Register";
    }
    else if(x!=0 && y!=0){
        if(x!=1 && y==1){
            x=jdbcTemplate.update("delete from LoginDetail where username ='"+register.getLogin_details().getUserName()+"'");
            if(x==1)
                System.out.println("deleted user with login Username = "+register.getLogin_details().getUserName()+"");
            else
                System.out.println("unable to delete record");
        }
        if(y!=1 && y==1){
            y=jdbcTemplate.update("delete from user_details where emp_id ='"+register.getUser_details().getEmp_id()+"'");
            if(y==1)
                System.out.println("deleted user with emp_id = "+register.getUser_details().getEmp_id()+"");
            else
                System.out.println("unable to delete record");

        }
        return "Failed To register";
    }
    else
        return "User Exist";

    }
}
