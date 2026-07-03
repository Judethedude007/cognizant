package com.cognizant.mockitobasic;

public class WorkflowService {

    private final WorkflowApi workflowApi;

    public WorkflowService(WorkflowApi workflowApi) {
        this.workflowApi = workflowApi;
    }

    public void runWorkflow() {
        workflowApi.login();
        workflowApi.fetchRecords();
        workflowApi.logout();
    }
}
