package com.jmu.lodgesystem.service;

import com.jmu.lodgesystem.entity.Apply;

public interface ApplyService {
    public int inserts(Apply ap);
    //更改状态
    public int upstatus(Apply ap);
    public int returnStatus(String id);
    public Apply returnAply(String id);
    public int deleteOne(String id);
}
