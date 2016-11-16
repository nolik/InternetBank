package com.NovikIgor.controller;

import com.NovikIgor.recourceManagment.ConfigurationManager;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *  Use JUnit & Mockito for testing controller.
 */
public class ControllerTest {
    private Controller controller;
    @Before
    public void setUp() throws Exception {
        this.controller = new Controller();
    }

    @Test
    public void test_of_doGet() throws Exception {
    //init
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
      //  Mockito.when(request.getParameter("command")).thenReturn(null);
        //use
        controller.doGet(request,response);

        //check
 //  Mockito.verify(request).getRequestDispatcher("/jsp/index.jsp").forward(request,response);
        Mockito.verify(response).sendRedirect(ConfigurationManager.getProperty("path.page.index"));
    }
}
