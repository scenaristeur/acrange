package com.example;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.janusproject.kernel.Kernel;
import org.janusproject.kernel.address.Address;
import org.janusproject.kernel.agent.Kernels;

public class HelloServlet extends HttpServlet {

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        ServletOutputStream out = resp.getOutputStream();
        
        HelloAgent a = new HelloAgent();
		Kernel k = Kernels.get();
		k.launchLightAgent(a);
		Address address = a.getAddress();
		String addresse = address.toString();
        
        out.write("Developpement d'agents avec Janus-project".getBytes());
        out.write(addresse.getBytes());
        out.flush();
        out.close();
        
    }
    
}
