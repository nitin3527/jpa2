package com.example.jpa2.repositories;

import com.example.jpa2.entity.Employee;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
    @Query("select firstName, lastName from Employee where " +
            "salary > (select AVG(salary) from Employee)" +
            " ORDER BY age ASC, salary DESC")
    List<Object[]> finadAllEmployee();

    @Modifying
    @Transactional
    @Query("update Employee e set e.salary=:salary where e.salary< (select AVG(e.salary) from Employee)")
    void updateSalaryOfEmployeeLessThanAvg(@Param("salary") double salary);

    @Modifying
    @Query("DELETE FROM Employee WHERE salary < (select AVG(salary) FROM Employee)")
    void deleteEmployeeSalary();

    @Query(value = "select empid,empfirstname from employee where emplastname like '%singh'", nativeQuery = true)
    List<Object[]> getAllEmployeeWhoesNameEndsWith();

    @Modifying
    @Query(value = "delete from employee where empage>:age", nativeQuery = true)
    void deleteEmployeeHaingAgeGreaterThan(@Param("age") int age);
}
