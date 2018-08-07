package com.mindex.challenge.service;

import com.mindex.challenge.data.Compensation;
/*
Create two new Compensation REST endpoints. One to create and one to read by employeeId. 
These should persist and query the Compensation from the persistence layer.
*/
public interface CompensationService {
    Compensation create(Compensation c);
    Compensation read(String id);
    Compensation readByEmployeeId(String id);
}
