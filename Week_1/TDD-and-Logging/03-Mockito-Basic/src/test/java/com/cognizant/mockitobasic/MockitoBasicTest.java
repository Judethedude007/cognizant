package com.cognizant.mockitobasic;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MockitoBasicTest {

    @Test
    public void testMockingAndStubbing() {
        ExternalApi mockApi = mock(ExternalApi.class);
        when(mockApi.getData()).thenReturn("Mock Data");

        MyService service = new MyService(mockApi);

        String result = service.fetchData();

        assertEquals("Mock Data", result);
    }

    @Test
    public void testVerifyingInteractions() {
        ExternalApi mockApi = mock(ExternalApi.class);
        MyService service = new MyService(mockApi);

        service.fetchData();

        verify(mockApi).getData();
    }

    @Test
    public void testArgumentMatching() {
        ExternalApi mockApi = mock(ExternalApi.class);
        when(mockApi.getDataById(anyString())).thenReturn("Customer Data");

        MyService service = new MyService(mockApi);

        String result = service.fetchDataById("C101");

        assertEquals("Customer Data", result);
        verify(mockApi).getDataById(eq("C101"));
    }

    @Test
    public void testHandlingVoidMethods() {
        ExternalApi mockApi = mock(ExternalApi.class);
        doNothing().when(mockApi).saveData(anyString());

        MyService service = new MyService(mockApi);

        service.saveData("Report Data");

        verify(mockApi).saveData("Report Data");
    }

    @Test
    public void testMockingWithMultipleReturns() {
        ExternalApi mockApi = mock(ExternalApi.class);
        when(mockApi.getData())
                .thenReturn("First Mock Data")
                .thenReturn("Second Mock Data");

        MyService service = new MyService(mockApi);

        String result = service.fetchDataTwice();

        assertEquals("First Mock Data | Second Mock Data", result);
    }

    @Test
    public void testVerifyingInteractionOrder() {
        WorkflowApi mockWorkflowApi = mock(WorkflowApi.class);
        WorkflowService workflowService = new WorkflowService(mockWorkflowApi);

        workflowService.runWorkflow();

        InOrder inOrder = inOrder(mockWorkflowApi);
        inOrder.verify(mockWorkflowApi).login();
        inOrder.verify(mockWorkflowApi).fetchRecords();
        inOrder.verify(mockWorkflowApi).logout();
    }

    @Test
    public void testVoidMethodWithException() {
        ExternalApi mockApi = mock(ExternalApi.class);
        doThrow(new RuntimeException("Delete failed"))
                .when(mockApi)
                .deleteData("D101");

        MyService service = new MyService(mockApi);

        RuntimeException exception = assertThrows(
                RuntimeException.class,
                () -> service.deleteData("D101")
        );

        assertEquals("Delete failed", exception.getMessage());
        verify(mockApi).deleteData("D101");
    }
}
