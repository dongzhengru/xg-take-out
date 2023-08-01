package top.zhengru.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import top.zhengru.entity.User;

import java.util.List;
import java.util.Map;

/**
 * @Author: dongzhengru
 * @Blog: zhengru.top
 * @Date: 2023/7/15
 * @Time: 13:36
 */
@Mapper
public interface UserMapper {
    /**
     * 根据openid查找用户
     * @param openId
     * @return
     */
    @Select("select * from user where openid = #{openId}")
    User getByOpenId(String openId);

    /**
     * 新增用户
     * @param user
     */
    void insert(User user);

    /**
     * 根据userId查询用户信息
     * @param userId
     * @return
     */
    @Select("select * from user where id = #{id}")
    User getById(Long userId);

    /**
     * 根据动态条件统计用户数量
     * @param map
     * @return
     */
    Integer countByMap(Map map);
}
