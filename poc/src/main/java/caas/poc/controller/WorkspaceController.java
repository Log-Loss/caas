package caas.poc.controller;


import caas.poc.service.WorkspaceService;
import caas.poc.util.BodyCheck;
import caas.poc.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class WorkspaceController {
    @Autowired
    WorkspaceService workspaceService;

    @RequestMapping(value = "/workspace/{id}", method = RequestMethod.GET)
    public Object get(@PathVariable Integer id) {
        Object result = workspaceService.find(id);
        return new Response(200, "OK", result);
    }

    @RequestMapping(value = "/workspace", method = RequestMethod.POST)
    public Object post(@RequestBody Map<String, String> body) {
        if (!BodyCheck.check(body, "userId", "name")) {
            return new Response(501);
        }
        Object result = workspaceService.create(Integer.parseInt(body.get("userId")), body.get("name"));
        return new Response(200, "OK", result);
    }

    @RequestMapping(value = "/workspace", method = RequestMethod.PUT)
    public Object put(@RequestBody Map<String, String> body) {
        if (!BodyCheck.check(body, "id", "name")) {
            return new Response(501);
        }
        Integer id = Integer.parseInt(body.get("id"));
        String name = body.get("name");

        Object result = workspaceService.update(id, name);
        return new Response(200, "OK", result);
    }

    @RequestMapping(value = "/workspace", method = RequestMethod.DELETE)
    public Object delete(@RequestBody Map<String, String> body) {
        if (!BodyCheck.check(body, "id")) {
            return new Response(501);
        }
        Integer id = Integer.parseInt(body.get("id"));

        workspaceService.remove(id);
        return new Response(200, "OK", "success");
    }
}
