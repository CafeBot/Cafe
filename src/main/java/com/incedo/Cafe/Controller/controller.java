package com.incedo.Cafe.Controller;

import com.incedo.Cafe.Greeting;
import com.incedo.Cafe.Repository.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.quartz.QuartzProperties;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;


@RestController
public class controller {

    @Autowired
    JdbcTemplate jdbcTemplate;


    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        Greeting g = new Greeting(1,"akash");
        return g;
    }
    @PostMapping("/abc")
    public void hello(@RequestBody Greeting g){
        System.out.println(g.getContent()+" "+g.getId());
        jdbcTemplate.execute("insert into user_details values(1,'alkash',98728327)");
    }

}

