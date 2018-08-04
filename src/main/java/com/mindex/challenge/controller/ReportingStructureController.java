package com.mindex.challenge.controller;

import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.ReportingStructureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReportingStructureController {
    private static final Logger LOG = LoggerFactory.getLogger(ReportingStructureController.class);

    @Autowired
    private ReportingStructureService rsService;

    @GetMapping("/reporting-structure/{id}")
    public ReportingStructure calculate(@PathVariable String id) {
        LOG.debug("reporting-structure calulate for id [{}]", id);

        return rsService.calculate(id);
    }
}
