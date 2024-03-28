package com.atguigu.junit;

import com.atguigu.domain.Employee;
import com.atguigu.service.NameListService;
import com.atguigu.service.TeamException;
import org.junit.Test;

/**
 * ClassName: NameListServiceTest
 * Description:
 *
 * @Author Wei Wang
 * @Create 2024/3/25 14:11
 * @Version 1.0
 */
public class NameListServiceTest {

    @Test
    public void testGetAllEmployees(){
        NameListService nameListService = new NameListService();
        Employee[] employees = nameListService.getAllEmployees();
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i]);

        }
    }
    @Test
    public void testGetEmployee(){
        try {
            NameListService nameListService = new NameListService();
            int id = 13;
            Employee employee = nameListService.getEmployee(id);
            System.out.println(employee);
        } catch (TeamException e) {
            System.out.println(e.getMessage());
        }
    }
}
