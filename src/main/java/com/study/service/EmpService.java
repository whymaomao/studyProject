package com.study.service;

import com.study.bean.Employee;
import com.study.mapper.EmpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class EmpService {

    @Autowired
    private EmpMapper empMapper;

    SimpleDateFormat birthdayFormat = new SimpleDateFormat("yyyy-MM-dd");

    public List<Employee> getEmployeeByPage(Integer page, Integer size, String keywords,  Long politicId, Long nationId, Long posId, Long jobLevelId, String engageForm, Long departmentId, String beginDateScope){
        int start = (page - 1) * size;
        Date startBeginDate = null;
        Date endBeginDate = null;

        if(beginDateScope != null && beginDateScope.contains(",")) {
            try{
                String[] split = beginDateScope.split(",");
                startBeginDate = birthdayFormat.parse(split[0]);
                endBeginDate = birthdayFormat.parse(split[1]);
            }catch (ParseException e){

            }
        }
        return empMapper.getEmployeeByPage(start, size, keywords, politicId, nationId, posId, jobLevelId, engageForm, departmentId, startBeginDate, endBeginDate);
    }


    public Long getCountByKeywords(String keywords,  Long politicId, Long nationId, Long posId, Long jobLevelId, String engageForm, Long departmentId, String beginDateScope){
        Date startBeginDate = null;
        Date endBeginDate = null;

        if(beginDateScope != null && beginDateScope.contains(",")) {
            try{
                String[] split = beginDateScope.split(",");
                startBeginDate = birthdayFormat.parse(split[0]);
                endBeginDate = birthdayFormat.parse(split[1]);
            }catch (ParseException e){

            }
        }
        return empMapper.getCountByKeywords(keywords, politicId, nationId, posId, jobLevelId, engageForm, departmentId, startBeginDate, endBeginDate);
    }
}
