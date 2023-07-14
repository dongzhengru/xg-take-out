package top.zhengru.controller.admin;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.zhengru.dto.SetmealDTO;
import top.zhengru.dto.SetmealPageQueryDTO;
import top.zhengru.entity.Setmeal;
import top.zhengru.result.PageResult;
import top.zhengru.result.Result;
import top.zhengru.service.SetMealService;
import top.zhengru.vo.SetmealVO;

import java.util.List;

/**
 * @Author: dongzhengru
 * @Blog: zhengru.top
 * @Date: 2023/7/14
 * @Time: 21:25
 */
@RestController
@Api(tags = "套餐相关接口")
@RequestMapping("/admin/setmeal")
@Slf4j
public class SetMealController {
    @Autowired
    SetMealService setMealService;

    /**
     * 新增套餐
     * @param setmealDTO
     * @return
     */
    @PostMapping
    @ApiOperation("新增套餐")
    public Result<String> addSetMeal(@RequestBody SetmealDTO setmealDTO) {
        setMealService.addSetMeal(setmealDTO);
        return Result.success();
    }

    /**
     * 套餐分页查询
     * @param setmealPageQueryDTO
     * @return
     */
    @GetMapping("/page")
    @ApiOperation("套餐分页查询")
    public Result<PageResult> page(SetmealPageQueryDTO setmealPageQueryDTO) {
        PageResult page = setMealService.pageQuery(setmealPageQueryDTO);
        return Result.success(page);
    }

    /**
     * 批量删除套餐
     * @param ids
     * @return
     */
    @DeleteMapping
    @ApiOperation("批量删除套餐")
    public Result<String> delete(@RequestParam List<Long> ids) {
        setMealService.deleteBatch(ids);
        return Result.success();
    }

    /**
     * 根据id查询套餐
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    @ApiOperation("根据id查询套餐")
    public Result<SetmealVO> getById(@PathVariable Long id) {
        SetmealVO setmealVO = setMealService.getByIdWithDish(id);
        return Result.success(setmealVO);
    }

    /**
     * 修改套餐
     * @param setmealDTO
     * @return
     */
    @PutMapping
    @ApiOperation("修改套餐")
    public Result update(@RequestBody SetmealDTO setmealDTO) {
        setMealService.update(setmealDTO);
        return Result.success();
    }

}
