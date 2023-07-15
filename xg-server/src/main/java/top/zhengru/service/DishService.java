package top.zhengru.service;

import top.zhengru.dto.DishDTO;
import top.zhengru.dto.DishPageQueryDTO;
import top.zhengru.entity.Dish;
import top.zhengru.result.PageResult;
import top.zhengru.vo.DishVO;

import java.util.List;

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

    /**
     * 批量删除菜品
     * @param ids
     */
    void deleteBatch(List<Long> ids);

    /**
     * 根据id查询菜品和关联的口味数据
     * @param id
     * @return
     */
    DishVO getByIdWithFlavor(Long id);

    /**
     * 编辑菜品
     * @param dishDTO
     */
    void update(DishDTO dishDTO);

    /**
     * 菜品起售、停售
     *
     * @param status
     * @param id
     */
    void status(Integer status, Long id);

    /**
     * 根据分类id查询菜品
     * @param categoryId
     * @return
     */
    List<Dish> list(Long categoryId);

    /**
     * 条件查询菜品和口味
     * @param dish
     * @return
     */
    List<DishVO> listWithFlavor(Dish dish);
}
