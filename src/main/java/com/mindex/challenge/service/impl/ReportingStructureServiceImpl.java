package com.mindex.challenge.service.impl;

import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.*;
import com.mindex.challenge.service.ReportingStructureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ReportingStructureServiceImpl implements ReportingStructureService {

    private static final Logger LOG = LoggerFactory.getLogger(ReportingStructureServiceImpl.class);
    
    @Autowired
    private EmployeeRepository employeeRepository;
    
    @Override
    public ReportingStructure calculate(String id) {
        ReportingStructure rs = null;
        try {
            LOG.debug("calculate id["+id+"]");
            rs = new ReportingStructure();
            Employee emp = employeeRepository.findByEmployeeId(id);
            rs.setEmployee(emp);
            rs.setNumberOfReports(rs.calcNumberOfReports(emp));
        } catch(Exception e) {
            LOG.error(e.getMessage());
        }
        return rs;
    }
}
