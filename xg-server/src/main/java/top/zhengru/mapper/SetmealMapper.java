package top.zhengru.mapper;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import top.zhengru.annotation.AutoFill;
import top.zhengru.entity.Setmeal;
import top.zhengru.enumeration.OperationType;
import top.zhengru.vo.SetmealVO;

@Mapper
public interface SetmealMapper {

    /**
     * 根据分类id查询套餐的数量
     * @param id
     * @return
     */
    @Select("select count(id) from setmeal where category_id = #{categoryId}")
    Integer countByCategoryId(Long id);

    /**
     * 新增套餐
     * @param setmeal
     */
    @AutoFill(value = OperationType.INSERT)
    void addSetMeal(Setmeal setmeal);

    /**
     * 套餐与分类分页查询
     * @param setmeal
     * @return
     */
    Page<SetmealVO> pageQuery(Setmeal setmeal);

    /**
     * 根据id查询套餐
     * @param id
     * @return
     */
    @Select("select * from setmeal where id = #{id}")
    Setmeal getById(Long id);

    /**
     * 根据id删除套餐
     * @param setmealId
     */
    @Delete("delete from setmeal where id = #{setmealId};")
    void deleteById(Long setmealId);

    /**
     * 修改套餐
     * @param setmeal
     */
    void update(Setmeal setmeal);
}
