package caas.poc.controller;

import caas.poc.service.UserService;
import caas.poc.util.BodyCheck;
import caas.poc.util.Response;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public Object get(@PathVariable Integer id) {
        Object result = userService.find(id);
        return new Response(200, "OK", result);
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public Object post(@RequestBody Map<String, String> body) {
        if (!BodyCheck.check(body, "name", "password")) {
            return new Response(501);
        }
        Object result = userService.create(body.get("name"), body.get("password"));
        return new Response(200, "OK", result);
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public Object put(@RequestBody Map<String, String> body) {
        if (!BodyCheck.check(body, "id", "name", "password")) {
            return new Response(501);
        }
        Integer id = Integer.parseInt(body.get("id"));
        String name = body.get("name");
        String password = body.get("password");

        Object result = userService.update(id, name, password);
        return new Response(200, "OK", result);
    }

    @RequestMapping(value = "/user", method = RequestMethod.DELETE)
    @Before("checkId()")
    public Object delete(@RequestBody Map<String, String> body) {
        if (!BodyCheck.check(body, "id")) {
            return new Response(501);
        }
        Integer id = Integer.parseInt(body.get("id"));

        userService.remove(id);
        return new Response(200, "OK", "success");
    }
}
