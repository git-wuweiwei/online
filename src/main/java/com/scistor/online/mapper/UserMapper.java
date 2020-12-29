package com.scistor.online.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.scistor.online.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 巍(Vision)
 * @version 1.0
 * @date 2020/12/29 18:08
 */

@Mapper
public interface UserMapper extends BaseMapper<User> {

}
