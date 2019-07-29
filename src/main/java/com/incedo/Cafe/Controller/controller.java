package com.incedo.Cafe.Controller;

import com.incedo.Cafe.Greeting;
import org.springframework.web.bind.annotation.*;


@RestController
public class controller {

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        Greeting g = new Greeting(1,"akash");
        return g;
    }
    @PostMapping("/abc")
    public void hello(@RequestBody Greeting g){
        System.out.println(g.getContent()+" "+g.getId());

    }

}

