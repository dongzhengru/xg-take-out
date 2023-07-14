package top.zhengru.service;

import top.zhengru.dto.DishDTO;
import top.zhengru.dto.DishPageQueryDTO;
import top.zhengru.result.PageResult;

/**
 * @Author: dongzhengru
 * @Blog: zhengru.top
 * @Date: 2023/7/13
 * @Time: 23:48
 */
public interface DishService {
    /**
     * 新增菜品和对应口味
     * @param dishDTO
     */
    void addDish(DishDTO dishDTO);

    /**
     * 菜品分页查询
     * @param dishPageQueryDTO
     * @return
     */
    PageResult pageQuery(DishPageQueryDTO dishPageQueryDTO);
}
