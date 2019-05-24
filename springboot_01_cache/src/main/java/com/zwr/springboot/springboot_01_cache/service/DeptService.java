package com.zwr.springboot.springboot_01_cache.service;


import com.zwr.springboot.springboot_01_cache.bean.Department;
import com.zwr.springboot.springboot_01_cache.bean.Employee;
import com.zwr.springboot.springboot_01_cache.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.Cache;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;



@Service
public class DeptService {

    @Autowired(required = false)
    DepartmentMapper departmentMapper;


    //直接使用 自定义的empRedisTemplate来操作缓存
    @Autowired
    RedisTemplate<Object, Department> deptRedisTemplate;

    /**
     * 使用自定义的缓存管理器
     * @param id
     * @return
     */
    @Cacheable(cacheNames = "dept")
    public Department getDeptById(Integer id){
        System.out.println("查询部门"+id);
        Department department = departmentMapper.getDeptById(id);
        deptRedisTemplate.opsForValue().set("部门",department);
        return department;
    }





}
