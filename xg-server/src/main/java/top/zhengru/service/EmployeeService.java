package top.zhengru.service;

import top.zhengru.dto.EmployeeDTO;
import top.zhengru.dto.EmployeeLoginDTO;
import top.zhengru.entity.Employee;
import top.zhengru.result.Result;

public interface EmployeeService {

    /**
     * 员工登录
     * @param employeeLoginDTO
     * @return
     */
    Employee login(EmployeeLoginDTO employeeLoginDTO);

    Result<String> addEmployee(EmployeeDTO employeeDTO);
}
