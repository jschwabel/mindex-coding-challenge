package com.mindex.challenge;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.dao.CompensationRepository;
import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class DataBootstrap {
    private static final String DATASTORE_LOCATION = "/static/employee_database.json";
    private static final String DATASTORE2_LOCATION = "/static/compensation_database.json";
    private static final Logger LOG = LoggerFactory.getLogger(DataBootstrap.class);
    
    @Autowired
    private EmployeeRepository employeeRepository;
    
    @Autowired
    private CompensationRepository compensationRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @PostConstruct
    public void init() {
        InputStream inputStream = this.getClass().getResourceAsStream(DATASTORE_LOCATION);

        Employee[] employees = null;

        try {
            employees = objectMapper.readValue(inputStream, Employee[].class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (Employee employee : employees) {
            LOG.debug("e.id["+employee.getEmployeeId()+"]");
            employeeRepository.insert(employee);
            
        }
        
        InputStream inputStream2 = this.getClass().getResourceAsStream(DATASTORE2_LOCATION);

        Compensation[] compensations = null;

        try {
            compensations = objectMapper.readValue(inputStream2, Compensation[].class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (Compensation compensation : compensations) {
            LOG.debug("c.id["+compensation.getCompensationId()+"]");
            compensationRepository.insert(compensation);
            
        }
    }
}
