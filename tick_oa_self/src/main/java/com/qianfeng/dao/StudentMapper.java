package com.qianfeng.dao;

import com.qianfeng.entity.Student;

public interface StudentMapper {
    int deleteByPrimaryKey(String no);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(String no);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
}