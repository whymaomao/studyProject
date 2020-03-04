package com.study.controller.emp;

import com.study.bean.Employee;
import com.study.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employee/basic/")
public class EmpBasicController {
    @Autowired
    EmpService empService;

    /**
     *
     * @return
     */
    @RequestMapping(value = "/emp", method = RequestMethod.GET)
    public Map<String, Object> getEmployeeByPage(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size,
            @RequestParam(defaultValue = "") String keywords,
            Long politicId, Long nationId, Long posId, Long jobLevelId,
            String engageForm, Long departmentId, String beginDateScope
    ){
        Map<String, Object> map = new HashMap<>();
        List<Employee> employeesByPage = empService.getEmployeeByPage(page, size, keywords, politicId, nationId, posId, jobLevelId, engageForm, departmentId, beginDateScope);
        Long count = empService.getCountByKeywords(keywords, politicId, nationId, posId, jobLevelId, engageForm, departmentId, beginDateScope);
        map.put("emps", employeesByPage);
        map.put("count", count);
        return map;
    }

    @RequestMapping( value = "/basicdata", method = RequestMethod.GET)
    public Map<String, Object> getEmployeeBasicData() {
        Map<String, Object> map = new HashMap<>();
//        map.put("nations", empService.getAllNations());
//        map.put("politics", empService.getAllPolitics());
//        map.put("deps", departmentService.getDepByPid(-1L));
//        map.put("positions", positionService.getAllPos());
////        map.put("joblevels", jobLevelService.getAllJobLevels());
//        map.put("workID", String.format("%08d", empService.getMaxWorkID() + 1));
        return map;
    }


}
