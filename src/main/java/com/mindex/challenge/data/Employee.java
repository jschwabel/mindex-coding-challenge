package com.mindex.challenge.data;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Employee {
    private String employeeId;
    private String firstName;
    private String lastName;
    private String position;
    private String department;
    private List<Employee> directReports;
    private static final Logger LOG = LoggerFactory.getLogger(Employee.class);
    
    public Employee() {
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String x) {
        this.firstName = x;
        LOG.debug("employeeId["+employeeId+"] x["+x+"] firstName["+firstName+"]");
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String x) {
        this.lastName = x;
        LOG.debug("employeeId["+employeeId+"] x["+x+"] lastName["+lastName+"]");
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public List<Employee> getDirectReports() {
        return directReports;
    }

    public void setDirectReports(List<Employee> x) {
        LOG.debug("employeeId["+employeeId+"] x["+x+"]");
        if(x!=null) {
            for(int i=0;i<x.size();++i){
                 LOG.debug("employeeId["+employeeId+"] employeeId["+(x.get(i)).getEmployeeId()+"] lastName["+(x.get(i)).getLastName()+"]");

            }
        }
        this.directReports = x;
    }
}
