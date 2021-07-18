package com.jmu.lodgesystem.service;

import com.jmu.lodgesystem.entity.Meals;

import java.util.List;

public interface MealsService {
    public int inserts(Meals m);
    public List<Meals> findById(String id);
    public int deleteById(String id);
    public List<Meals> findNearThreeMeal(String id);

}
