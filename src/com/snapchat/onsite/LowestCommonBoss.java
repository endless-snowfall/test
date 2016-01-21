package com.snapchat.onsite;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class LowestCommonBoss {

    @Getter
    @AllArgsConstructor
    public static class Employee {

        private String name;
        private List<Employee> directReports;
    }

    @Getter
    @AllArgsConstructor
    public static class Result {

        private Employee employee;
        private boolean foundE1;
        private boolean foundE2;
    }

    public String getManager(Employee ceo, String e1, String e2) {
        return helper(ceo, e1, e2).getEmployee().getName();
    }

    private Result helper(Employee employee, String e1, String e2) {
        boolean foundE1 = false;
        boolean foundE2 = false;

        for (Employee directReport : employee.getDirectReports()) {
            Result directReportResult = helper(directReport, e1, e2);

            if (directReportResult.isFoundE1() &&
                directReportResult.isFoundE2()) {
                return directReportResult;
            }

            if (directReport.getName().equals(e1) || directReportResult.isFoundE1()) {
                foundE1 = true;
            }

            if (directReport.getName().equals(e2) || directReportResult.isFoundE2()) {
                foundE2 = true;
            }
        }

        Employee result = (foundE1 || foundE2) ? employee : null;
        return new Result(result, foundE1, foundE2);
    }
}
