package com.mindex.challenge.service.impl;

import com.mindex.challenge.data.*;
import com.mindex.challenge.service.EmployeeService;
import com.mindex.challenge.service.ReportingStructureService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ReportingStructureServiceImpl implements ReportingStructureService {

    private static final Logger LOG = LoggerFactory.getLogger(ReportingStructureServiceImpl.class);
    
    @Autowired
    private EmployeeService employeeService;
    
    @Override
    public ReportingStructure calculate(String id) {
        ReportingStructure rs = null;
        try {
            LOG.debug("calculate id["+id+"]");
            rs = new ReportingStructure();
            Employee emp = employeeService.read(id);
            rs.setEmployee(emp);
            rs.setNumberOfReports(calcNumberOfReports(emp));
        } catch(Exception e) {
            LOG.error(e.getMessage());
        }
        return rs;
    }
    
    public int calcNumberOfReports(Employee e){
        int numDirReports=0;
        int numSubReports=0;
        int totalSubReports=0;
        try {
            if(e!=null){
                LOG.debug("1 e.id["+e.getEmployeeId()+"]");
                List<Employee> directReports=e.getDirectReports();
                if(directReports!=null) {
                    Employee eDR=null;
                    numDirReports=directReports.size();
                    for(int i=0;i<directReports.size();++i) {
                        eDR = employeeService.read(directReports.get(i).getEmployeeId());
                        if(eDR!=null) {
                            LOG.debug("3 e.id["+e.getEmployeeId()+"] eDR.id["+eDR.getEmployeeId()+"] eDR.lastName["+eDR.getLastName()+"] numDirReports["+numDirReports+"] numSubReports["+numSubReports+"] totalSubReports["+totalSubReports+"] ["+i+"]"); 
                            numSubReports = calcNumberOfReports(eDR);
                            totalSubReports=totalSubReports+numSubReports;
                            LOG.debug("4 e.id["+e.getEmployeeId()+"] eDR.id["+eDR.getEmployeeId()+"] eDR.lastName["+eDR.getLastName()+"] numDirReports["+numDirReports+"] numSubReports["+numSubReports+"] totalSubReports["+totalSubReports+"] ["+i+"]"); 
                        }
                    }
                }
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
