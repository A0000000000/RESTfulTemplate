package cn.maoyanluo.resttemplate.service;

import cn.maoyanluo.resttemplate.bean.Table;
import cn.maoyanluo.resttemplate.mapper.TableMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class TableService {

    @Resource
    private TableMapper tableMapper;

    public int create(Table table) {
        int ret = tableMapper.createTable(table);
        int tableId = tableMapper.insertTableItem(table.getName());
        tableMapper.insertTableColumn(tableId, table.getColumns());
        return ret;
    }


}
