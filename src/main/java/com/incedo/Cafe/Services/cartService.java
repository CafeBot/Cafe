package com.incedo.Cafe.Services;

import com.incedo.Cafe.Pojo.Cart;
import com.incedo.Cafe.Pojo.Snack;
import com.incedo.Cafe.Repository.CartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class cartService {
    CartRepo crp = new CartRepo();


    public int saveOrder(Cart cart) {
        return crp.insert_details(cart);
    }

    public void UpdateStatus(Cart carts) {
        crp.updateStatus(carts);
    }
}

