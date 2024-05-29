package cn.maoyanluo.resttemplate.service;

import cn.maoyanluo.resttemplate.mapper.TemplateMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TemplateService {

    @Resource
    private TemplateMapper templateMapper;


    public List<Map<String, Object>> getAll(String tableName) {
        return templateMapper.getAll(tableName);
    }

    public Map<String, Object> getById(String tableName, int id) {
        return templateMapper.getById(tableName, id);
    }

    public int insertNewItem(String tableName, HashMap<String, Object> map) {
        return templateMapper.insert(tableName, map);
    }

    public int updateById(String tableName, HashMap<String, Object> map) {
        return templateMapper.updateById(tableName, Integer.valueOf(map.get("id").toString()), map);
    }


    public int deleteById(String tableName, int id) {
        return templateMapper.deleteById(tableName, id);
    }
}
