package com.jmu.lodgesystem.service.impl;

import com.jmu.lodgesystem.dao.CommentMapper;
import com.jmu.lodgesystem.entity.Comment;
import com.jmu.lodgesystem.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commap;

    @Override
    public int insertComment(Comment c) {
        return commap.insertComment(c);
    }

    @Override
    public double avgcount(String id) {
        return commap.avgcount(id);
    }

    @Override
    public List<Comment> returnAllComment(String id) {
        return commap.returnAllComment(id);
    }

    @Override
    public int commentCount(String id) {
        return commap.commentCount(id);
    }
}
