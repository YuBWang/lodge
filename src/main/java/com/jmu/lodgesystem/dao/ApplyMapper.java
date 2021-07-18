package com.jmu.lodgesystem.dao;

import com.jmu.lodgesystem.entity.Apply;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ApplyMapper {
    public int inserts(Apply ap);
    //更改状态
    public int upstatus(Apply ap);
    public int returnStatus(String id);
    public Apply returnAply(String id);
    public int deleteOne(String id);



}
