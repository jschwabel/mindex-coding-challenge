package com.mindex.challenge.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
Create a new type, ReportingStructure, that has two properties: employee and numberOfReports.

For the field "numberOfReports", this should equal the total number of reports under a given employee. The number of 
reports is determined to be the number of directReports for an employee and all of their direct reports
*/
public class ReportingStructure {
    
    private static final Logger LOG = LoggerFactory.getLogger(ReportingStructure.class);
    private Employee employee;
    private int numberOfReports;
    
    public Employee getEmployee(){
        return employee;
    }
    
    public void setEmployee(Employee e){
        employee=e;
    }
    
    public int getNumberOfReports(){
        return numberOfReports;
    }
    
    public void setNumberOfReports(int x){
        numberOfReports=x;
    }
    
}
