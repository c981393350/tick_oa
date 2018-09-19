package com.qianfeng.dao;

import com.qianfeng.entity.Check;

public interface CheckMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Check record);

    int insertSelective(Check record);

    Check selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Check record);

    int updateByPrimaryKey(Check record);
}