package com.jmu.lodgesystem.dao;

import com.jmu.lodgesystem.entity.Meals;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Controller;

import java.util.List;

@Mapper
public interface MealsMapper {
    public int inserts(Meals m);
    public List<Meals> findById(String id);
    public int deleteById(String id);
    public List<Meals> findNearThreeMeal(String id);
}
