package top.zhengru.service;

import top.zhengru.dto.EmployeeDTO;
import top.zhengru.dto.EmployeeLoginDTO;
import top.zhengru.dto.EmployeePageQueryDTO;
import top.zhengru.entity.Employee;
import top.zhengru.result.PageResult;
import top.zhengru.result.Result;

public interface EmployeeService {

    /**
     * 员工登录
     * @param employeeLoginDTO
     * @return
     */
    Employee login(EmployeeLoginDTO employeeLoginDTO);

    /**
     * 新增员工
     * @param employeeDTO
     * @return
     */
    Result<String> addEmployee(EmployeeDTO employeeDTO);

    /**
     * 员工分页查询
     * @param employeePageQueryDTO
     * @return
     */
    PageResult pageQuery(EmployeePageQueryDTO employeePageQueryDTO);
}
