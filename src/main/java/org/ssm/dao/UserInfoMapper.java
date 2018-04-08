package org.ssm.dao;

import org.springframework.stereotype.Component;
import org.ssm.dao.base.MyBatisRepository;
import org.ssm.pojo.UserInfo;
@MyBatisRepository
@Component
public interface UserInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);
}