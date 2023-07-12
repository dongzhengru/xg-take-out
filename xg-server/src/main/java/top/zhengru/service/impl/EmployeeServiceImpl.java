package top.zhengru.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.util.DigestUtils;
import top.zhengru.constant.MessageConstant;
import top.zhengru.constant.PasswordConstant;
import top.zhengru.constant.StatusConstant;
import top.zhengru.context.BaseContext;
import top.zhengru.dto.EmployeeDTO;
import top.zhengru.dto.EmployeeLoginDTO;
import top.zhengru.entity.Employee;
import top.zhengru.exception.AccountLockedException;
import top.zhengru.exception.AccountNotFoundException;
import top.zhengru.exception.PasswordErrorException;
import top.zhengru.mapper.EmployeeMapper;
import top.zhengru.result.Result;
import top.zhengru.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    /**
     * 员工登录
     *
     * @param employeeLoginDTO
     * @return
     */
    public Employee login(EmployeeLoginDTO employeeLoginDTO) {
        String username = employeeLoginDTO.getUsername();
        String password = employeeLoginDTO.getPassword();

        //1、根据用户名查询数据库中的数据
        Employee employee = employeeMapper.getByUsername(username);

        //2、处理各种异常情况（用户名不存在、密码不对、账号被锁定）
        if (employee == null) {
            //账号不存在
            throw new AccountNotFoundException(MessageConstant.ACCOUNT_NOT_FOUND);
        }

        //密码比对
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        if (!password.equals(employee.getPassword())) {
            //密码错误
            throw new PasswordErrorException(MessageConstant.PASSWORD_ERROR);
        }

        if (employee.getStatus() == StatusConstant.DISABLE) {
            //账号被锁定
            throw new AccountLockedException(MessageConstant.ACCOUNT_LOCKED);
        }

        //3、返回实体对象
        return employee;
    }

    /**
     * 添加员工
     * @param employeeDTO
     * @return
     */
    @Override
    public Result<String> addEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDTO,employee);
        employee.setStatus(StatusConstant.ENABLE);
        employee.setPassword(DigestUtils.md5DigestAsHex(PasswordConstant.DEFAULT_PASSWORD.getBytes()));
        employee.setCreateTime(LocalDateTime.now());
        employee.setUpdateTime(LocalDateTime.now());
        employee.setCreateUser(BaseContext.getCurrentId());
        employee.setUpdateUser(BaseContext.getCurrentId());
        Integer result = employeeMapper.addEmployee(employee);
        if (result == 1) {
            return Result.success();
        }
        return Result.error("添加失败");
    }

}
