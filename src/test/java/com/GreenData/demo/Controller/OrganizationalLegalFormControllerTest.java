package com.GreenData.demo.Controller;

import com.GreenData.demo.Model.OrganizationalLegalForm;
import com.GreenData.demo.Service.OrganizationalLegalFormService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

class OrganizationalLegalFormControllerTest {

    @InjectMocks
    private OrganizationalLegalFormController controller;

    @Mock
    private OrganizationalLegalFormService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAllOrganizationalLegalForms() {
        OrganizationalLegalForm form1 = new OrganizationalLegalForm("Form1");
        OrganizationalLegalForm form2 = new OrganizationalLegalForm("Form2");
        List<OrganizationalLegalForm> forms = Arrays.asList(form1, form2);

        when(service.findAllOrganizationalLegalForms()).thenReturn(forms);

        List<OrganizationalLegalForm> result = controller.findAllStudent();

        assertEquals(2, result.size());
        assertEquals("Form1", result.get(0).getName());
    }

    @Test
    void testSaveOrganizationalLegalForm() {
        OrganizationalLegalForm form = new OrganizationalLegalForm("Form3");
        when(service.saveOrganizationalLegalForm(any(OrganizationalLegalForm.class))).thenReturn(form);

        ResponseEntity<OrganizationalLegalForm> response = controller.saveOrganizationalLegalForm(form);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("Form3", response.getBody().getName());
    }

    @Test
    void testFindById() {
        OrganizationalLegalForm form = new OrganizationalLegalForm("Form4");
        when(service.findById(anyInt())).thenReturn(form);

        ResponseEntity<OrganizationalLegalForm> response = controller.findById(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Form4", response.getBody().getName());
    }

    @Test
    void testUpdateOrganizationalLegalForm() {
        OrganizationalLegalForm form = new OrganizationalLegalForm("Form5");
        when(service.updateOrganizationalLegalForm(anyInt(), any(OrganizationalLegalForm.class))).thenReturn(form);

        ResponseEntity<OrganizationalLegalForm> response = controller.updateOrganizationalLegalForm(form, 1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Form5", response.getBody().getName());
    }

    @Test
    void testDeleteOrganizationalLegalForm() {
        when(service.organizationalLegalFormExists(1)).thenReturn(true);  // Форма существует
        doNothing().when(service).deleteOrganizationalLegalForm(anyInt());

        ResponseEntity<Void> response = controller.deleteOrganizationalLegalForm(1);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(service, times(1)).deleteOrganizationalLegalForm(1);
    }

}
