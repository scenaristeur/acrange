package com.example;

import io.janusproject.Boot;
import io.janusproject.kernel.Kernel;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        ServletOutputStream out = resp.getOutputStream();
        
        Kernel kernel;
        
        try {
            // For booting Janus:
            // a) Use Boot.startJanus for a programmatic launching with
            //    the default configuration.
            // b) Use Boot.main for controlling the launching parameters.
            //    (issue janus-project/janusproject#90 will provide a
            //    better mechanism).
			kernel = Boot.startJanus(
					null, // Use the default module
					AgentA.class, // Type of the agent
					"Albert"); // Parameter for Initialize event
		} catch (Exception e) {
			throw new ServletException(e);
		}
        
        // We cannot get the identifier of the first agent yet;
        // see janus-project/janusproject#94
        String idA = "unknown";
        
        // The other agents are launch pragrammatically
        String idB = kernel.spawn(
        		AgentB.class, // Type of the agent
        		"Bernardo") // Parameter for Initialize event
        		.toString();
        out.write("Developpement agents avec Janus-project<br/>idA=".getBytes());
        out.write(idA.getBytes());
        out.write("<br/>idB=".getBytes());
        out.write(idB.getBytes());
        
        out.flush();
        out.close();
        
    }
    
}
