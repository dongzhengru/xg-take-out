package top.zhengru.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import top.zhengru.entity.SetmealDish;

import java.util.List;

/**
 * @Author: dongzhengru
 * @Blog: zhengru.top
 * @Date: 2023/7/14
 * @Time: 13:57
 */
@Mapper
public interface SetmealDishMapper {
    /**
     * 根据菜品id查询套餐id
     * @param ids
     * @return
     */
    List<Long> getSetmealIdsByDishIds(List<Long> ids);

    /**
     * 批量新增套餐对应菜品关系
     * @param setmealDishes
     */
    void insertBatch(List<SetmealDish> setmealDishes);

    /**
     * 根据套餐id删除套餐对应菜品关系
     * @param setmealId
     */
    @Delete("delete from setmeal_dish where setmeal_id = #{setmealId}")
    void deleteBySetmealId(Long setmealId);

    /**
     * 根据套餐id查询对应菜品信息
     * @param id
     * @return
     */
    @Select("select * from setmeal_dish where setmeal_id = #{setmealId}")
    List<SetmealDish> getBySetmealId(Long id);
}
