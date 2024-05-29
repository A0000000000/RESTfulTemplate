package cn.maoyanluo.resttemplate.controller;


import cn.maoyanluo.resttemplate.bean.Response;
import cn.maoyanluo.resttemplate.service.TemplateService;
import cn.maoyanluo.resttemplate.tools.JWTTools;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/template")
public class TemplateController {

    @Resource
    private TemplateService templateService;

    @GetMapping("/{table}")
    public Response<Object> get(@PathVariable("table") String table) {
        String tableName = JWTTools.tl.get().getUsername() + "_" + table;
        return Response.success(templateService.getAll(tableName));
    }


    @GetMapping("/{table}/{id}")
    public Response<Object> get(@PathVariable("table") String table, @PathVariable("id") int id) {
        String tableName = JWTTools.tl.get().getUsername() + "_" + table;
        return Response.success(templateService.getById(tableName, id));
    }


    @PostMapping("/{table}")
    public Response<Object> post(@PathVariable("table") String table, @RequestBody HashMap<String, Object> map) {
        String tableName = JWTTools.tl.get().getUsername() + "_" + table;
        int ret = templateService.insertNewItem(tableName, map);
        return Response.success(ret);
    }

    @PutMapping("/{table}")
    public Response<Object> put(@PathVariable("table") String table, @RequestBody HashMap<String, Object> map) {
        String tableName = JWTTools.tl.get().getUsername() + "_" + table;
        int ret = templateService.updateById(tableName, map);
        return Response.success(ret);
    }

    @DeleteMapping("/{table}/{id}")
    public Response<Object> delete(@PathVariable("table") String table, @PathVariable("id") int id) {
        String tableName = JWTTools.tl.get().getUsername() + "_" + table;
        int ret = templateService.deleteById(tableName, id);
        return Response.success(ret);
    }

}
