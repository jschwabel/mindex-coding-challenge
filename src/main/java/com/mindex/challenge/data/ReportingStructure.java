package com.mindex.challenge.data;

import com.mindex.challenge.DataBootstrap;
import com.mindex.challenge.dao.EmployeeRepository;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

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
    
    @Autowired
    private EmployeeRepository employeeRepository;
    
    public int calcNumberOfReports(Employee e){
        int numDirReports=0;
        int numSubReports=0;
        int totalSubReports=0;
        try {
            if(e!=null){
                LOG.debug("1 e.id["+e.getEmployeeId()+"]");
//                List<Employee> directReports = e.getDirectReports();
//                if(directReports!=null) {
//                    Employee eDR=null;
//                    numDirReports=directReports.size();
//                    LOG.debug("2 e.id["+e.getEmployeeId()+"] numDirReports["+numDirReports+"] numSubReports["+numSubReports+"] totalSubReports["+totalSubReports+"]");
//                    
//                    for(int i=0;i<directReports.size();++i) {
//                        eDR = directReports.get(i);
//                        if(eDR!=null) {
//                            numSubReports = calcNumberOfReports(eDR);
//                            totalSubReports=totalSubReports+numSubReports;
//                            LOG.debug("4 e.id["+e.getEmployeeId()+"] eDR.id["+eDR.getEmployeeId()+"] numDirReports["+numDirReports+"] numSubReports["+numSubReports+"] totalSubReports["+totalSubReports+"] ["+i+"]"); 
//                        }
//                    }   
//                }
//                    List<String> directReportIds=e.getDirectReports();
//                    if(directReportIds!=null) {
//                        Employee eDR=null;
//                        numDirReports=directReportIds.size();
//                        for(int i=0;i<directReportIds.size();++i) {
//                            eDR = employeeRepository.findByEmployeeId(directReportIds.get(i));
//                            if(eDR!=null) {
//                                numSubReports = calcNumberOfReports(eDR);
//                                totalSubReports=totalSubReports+numSubReports;
//                                LOG.debug("4 e.id["+e.getEmployeeId()+"] eDR.id["+eDR.getEmployeeId()+"] eDR.lastName["+eDR.getLastName()+"] numDirReports["+numDirReports+"] numSubReports["+numSubReports+"] totalSubReports["+totalSubReports+"] ["+i+"]"); 
//                            }
//                        }
//                    }
            
                
            LOG.debug("5 e.id["+e.getEmployeeId()+"] numDirReports["+numDirReports+"] numSubReports["+numSubReports+"] totalSubReports["+totalSubReports+"]");
            }
        } catch(Exception ex) {
            LOG.error(ex.getMessage());
            ex.printStackTrace();
        }
        
        int grandTotal =  totalSubReports+numDirReports;
        LOG.debug("6 numDirReports["+numDirReports+"] numSubReports["+numSubReports+"] totalSubReports["+totalSubReports+"] grandTotal["+grandTotal+"]");
        return grandTotal;
    }
}
