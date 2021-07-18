package com.jmu.lodgesystem.dao;

import com.jmu.lodgesystem.entity.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {
    public int insertComment(Comment c);
    public double avgcount(String id);
    public List<Comment> returnAllComment(String id);
    public int  commentCount(String id);
}
