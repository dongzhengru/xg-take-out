package top.zhengru.service;

import org.springframework.stereotype.Service;
import top.zhengru.dto.SetmealDTO;
import top.zhengru.dto.SetmealPageQueryDTO;
import top.zhengru.entity.Setmeal;
import top.zhengru.result.PageResult;
import top.zhengru.vo.DishItemVO;
import top.zhengru.vo.SetmealVO;

import java.util.List;

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

    /**
     * 套餐分页查询
     * @param setmealPageQueryDTO
     * @return
     */
    PageResult pageQuery(SetmealPageQueryDTO setmealPageQueryDTO);

    /**
     * 批量删除套餐
     * @param ids
     */
    void deleteBatch(List<Long> ids);

    /**
     * 根据id查询套餐
     * @param id
     * @return
     */
    SetmealVO getByIdWithDish(Long id);

    /**
     * 修改套餐
     * @param setmealDTO
     */
    void update(SetmealDTO setmealDTO);

    /**
     * 套餐起售、停售
     * @param status
     * @param id
     */
    void startOrStop(Integer status, Long id);

    /**
     * 条件查询
     * @param setmeal
     * @return
     */
    List<Setmeal> list(Setmeal setmeal);

    /**
     * 根据id查询菜品选项
     * @param id
     * @return
     */
    List<DishItemVO> getDishItemById(Long id);
}
