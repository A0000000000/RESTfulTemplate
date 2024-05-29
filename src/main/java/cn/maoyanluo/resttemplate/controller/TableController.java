package cn.maoyanluo.resttemplate.controller;


import cn.maoyanluo.resttemplate.bean.Response;
import cn.maoyanluo.resttemplate.bean.Table;
import cn.maoyanluo.resttemplate.service.TableService;
import cn.maoyanluo.resttemplate.tools.JWTTools;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/table")
public class TableController {

    @Resource
    private TableService tableService;

    @PostMapping("/create")
    public Response<Object> create(@RequestBody Table table) {
        table.setName(JWTTools.tl.get().getUsername() + "_" + table.getName());
        int res = tableService.create(table);
        if (res == 0) {
            return Response.success(null);
        } else {
            return Response.failed("创建失败");
        }
    }

}
