package org.ensa.schoolmanagementbackend.dao.impl;

import org.ensa.schoolmanagementbackend.dao.entity.Prof;
import org.ensa.schoolmanagementbackend.dao.repository.ProfRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProfImpl {
    @Autowired
    private ProfRepository profRepository;
    public List<Prof> getprofs(){
//        System.out.println("-------------------"+profRepository.findAll());
        return profRepository.findAll();
    }
    public void deletprof(Prof prof){
        profRepository.delete(prof);
    }
    public Prof getprof(long id){
        return profRepository.findById(id).get();
    }
    public Prof updateprof(Prof prof){
        return profRepository.save(prof);
    }
    public void addprof(Prof prof){
        profRepository.save(prof);
    }

}