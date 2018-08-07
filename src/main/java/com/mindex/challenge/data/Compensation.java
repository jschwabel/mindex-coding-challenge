
package com.mindex.challenge.data;

import java.util.Date;

/**
Create a new type, Compensation. A Compensation has the following fields: employee, salary, and effectiveDate. 
*/
public class Compensation {
    private String compensationId;
    private Employee employee;
    private float salary;
    private Date effectiveDate;
    
    public String getCompensationId() {
        return compensationId;
    }

    public void setCompensationId(String x) {
        this.compensationId = x;
    }
    
    public Employee getEmployee(){
        return employee;
    }
    
    public void setEmployee(Employee x){
        employee=x;
    }
    
    public float getSalary(){
        return salary;
    }
    
    public void setSalary(float x){
        salary=x;
    }
    
    public Date getEffectiveDate(){
        return effectiveDate;
    }
    
    public void setEffectiveDate(Date x){
        effectiveDate=x;
    }
}
