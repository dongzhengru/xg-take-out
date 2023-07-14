package top.zhengru.service;

import org.springframework.stereotype.Service;
import top.zhengru.dto.SetmealDTO;

/**
 * @Author: dongzhengru
 * @Blog: zhengru.top
 * @Date: 2023/7/14
 * @Time: 21:27
 */
public interface SetMealService {
    /**
     * 新增套餐
     * @param setmealDTO
     */
    void addSetMeal(SetmealDTO setmealDTO);
}
