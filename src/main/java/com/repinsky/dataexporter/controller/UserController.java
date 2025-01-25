package com.repinsky.dataexporter.controller;

import com.repinsky.dataexporter.service.DataExporterService;
import com.repinsky.dataexporter.util.CriteriaSort;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/users")
public class UserController {
    private final DataExporterService dataExporterService;

    @GetMapping("/export")
    public void exportUserToExcel(@RequestParam(required = false) String[] sort, HttpServletResponse response) throws IOException {
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=users.xlsx");

        Sort sortCriteria = CriteriaSort.criteriaSort(sort);

        dataExporterService.exportToExcel(response.getOutputStream(), sortCriteria);
    }
}
