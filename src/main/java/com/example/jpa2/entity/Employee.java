package com.example.jpa2.entity;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
    @Column(name = "empid")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int empId;
    @Column(name="empfirstname")
    String firstName;
    @Column(name="emplastname")
    String lastName;
    @Column(name="empsalary")
    double salary;
    @Column(name="empage")
    int age;

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }
}
