package top.zhengru.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import top.zhengru.entity.DishFlavor;

import java.util.List;

/**
 * @Author: dongzhengru
 * @Blog: zhengru.top
 * @Date: 2023/7/14
 * @Time: 0:29
 */
@Mapper
public interface DishFlavorMapper {
    /**
     * 批量插入菜品对应口味
     * @param flavors
     */
    void insertBatch(List<DishFlavor> flavors);

    /**
     * 根据菜品删除对应口味
     * @param id
     */
    @Delete("delete from dish_flavor where dish_id = #{id}")
    void deleteById(Long id);
}
