package top.zhengru.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import top.zhengru.entity.User;

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
}
