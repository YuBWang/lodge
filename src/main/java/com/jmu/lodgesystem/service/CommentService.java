package com.jmu.lodgesystem.service;

import com.jmu.lodgesystem.entity.Comment;

import java.util.List;

public interface CommentService {
    public int insertComment(Comment c);
    public double avgcount(String id);
    public List<Comment> returnAllComment(String id);
    public int  commentCount(String id);
}
