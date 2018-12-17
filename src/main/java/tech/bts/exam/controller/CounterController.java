package tech.bts.exam.controller;

import com.github.jknack.handlebars.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.bts.exam.service.CounterService;
import tech.bts.exam.util.HandlebarsUtil;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(path = "/counters")
public class CounterController {

    private CounterService counterService;

    @Autowired
    public CounterController(CounterService counterService){

        this.counterService = counterService;
    }


    @RequestMapping(method = GET)
    public String getCounter() throws IOException {

        Template template = HandlebarsUtil.compile("counter-list");

        Map<String, Object> values = new HashMap<>();
        values.put("counter", counterService.getAllCounters());

        return template.apply(values);
    }


    @RequestMapping(method = GET, path = "/increment")
    public void incrementCounter(HttpServletResponse response) throws IOException {

        counterService.increaseCounter();
        response.sendRedirect("/counters");
    }

    @RequestMapping(method = GET, path ="/add")
    public void addCounter(HttpServletResponse response) throws IOException{

        counterService.addCounter();

        response.sendRedirect("/counters");
    }





}
