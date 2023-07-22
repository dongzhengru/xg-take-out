package top.zhengru.mapper;

import org.apache.ibatis.annotations.Mapper;
import top.zhengru.entity.Orders;

/**
 * @Author: dongzhengru
 * @Blog: blog.zhengru.top
 * @Date: 2023/7/22
 * @Time: 23:50
 */
@Mapper
public interface OrderMapper {
    /**
     * 插入订单数据
     * @param order
     */
    void insert(Orders order);
}
