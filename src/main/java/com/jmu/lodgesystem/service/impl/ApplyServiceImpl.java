package com.jmu.lodgesystem.service.impl;

import com.jmu.lodgesystem.dao.ApplyMapper;
import com.jmu.lodgesystem.entity.Apply;
import com.jmu.lodgesystem.service.ApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplyServiceImpl implements ApplyService {
    @Autowired
    private ApplyMapper apm;

    @Override
    public int inserts(Apply ap) {
        return apm.inserts(ap);
    }

    @Override
    public int upstatus(Apply ap) {
        return apm.upstatus(ap);
    }

    @Override
    public int returnStatus(String id) {
        return apm.returnStatus(id);
    }

    @Override
    public Apply returnAply(String id) {
        return apm.returnAply(id);
    }

    @Override
    public int deleteOne(String id) {
        return apm.deleteOne(id);
    }


}
