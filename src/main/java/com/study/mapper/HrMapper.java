package com.study.mapper;

import com.study.bean.Hr;
import com.study.bean.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HrMapper {

    Hr loadUserByUsername(String username);

    List<Role> getRolesByHrId(Long id);

    List<Hr>getAllHr(@Param("currentId") Long currentId);
}
