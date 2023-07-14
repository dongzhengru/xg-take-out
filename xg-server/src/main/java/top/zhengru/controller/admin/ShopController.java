package top.zhengru.controller.admin;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import top.zhengru.constant.StatusConstant;
import top.zhengru.result.Result;

import javax.validation.constraints.Past;

/**
 * @Author: dongzhengru
 * @Blog: zhengru.top
 * @Date: 2023/7/15
 * @Time: 0:02
 */
@RestController("adminShopController")
@RequestMapping("/admin/shop")
@Api(tags = "店铺操作相关接口")
@Slf4j
public class ShopController {
    public static final String KEY = "SHOP_STATUS";
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 设置营业状态
     * @param status
     * @return
     */
    @PutMapping("/{status}")
    @ApiOperation("设置营业状态")
    public Result<String> setStatus(@PathVariable Integer status) {
        redisTemplate.opsForValue().set(KEY, status);
        return Result.success();
    }

    /**
     * 查询店铺营业状态
     * @return
     */
    @GetMapping("/status")
    @ApiOperation("查询店铺营业状态")
    public Result<Integer> getStatus() {
        Integer status = (Integer) redisTemplate.opsForValue().get(KEY);
        return Result.success(status);
    }
}
