package com.jmu.lodgesystem.service.impl;

import com.jmu.lodgesystem.dao.MealsMapper;
import com.jmu.lodgesystem.entity.Meals;
import com.jmu.lodgesystem.service.MealsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealsServiceImpl implements MealsService {
    @Autowired
    private MealsMapper meal;
    @Override
    public int inserts(Meals m) {
        return meal.inserts(m);
    }

    @Override
    public List<Meals> findById(String id) {
        return meal.findById(id);
    }

    @Override
    public int deleteById(String id) {
        return meal.deleteById(id);
    }

    @Override
    public List<Meals> findNearThreeMeal(String id) {
        return meal.findNearThreeMeal(id);
    }
}
