package top.zhengru.service;

import org.springframework.stereotype.Service;
import top.zhengru.dto.OrdersSubmitDTO;
import top.zhengru.vo.OrderSubmitVO;

/**
 * @Author: dongzhengru
 * @Blog: blog.zhengru.top
 * @Date: 2023/7/22
 * @Time: 23:46
 */
public interface OrderService {
    /**
     * 用户下单
     * @param ordersSubmitDTO
     * @return
     */
    OrderSubmitVO submitOrder(OrdersSubmitDTO ordersSubmitDTO);
}
