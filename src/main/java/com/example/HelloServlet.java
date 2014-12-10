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
		String idA, idB;
		try {
			Kernel kernel;

			Boot.setOffline(true);
			
			kernel = Boot.startJanus(
					null, // Use the default module
					AgentA.class, // Type of the agent
					"Albert"); // Parameter for Initialize event

			// We cannot get the identifier of the first agent yet;
			// see janus-project/janusproject#94
			idA = Boot.getBootAgentIdentifier().toString();

			// The other agents are launch pragrammatically
			UUID id = kernel.spawn(
					AgentB.class, // Type of the agent
					"Bernardo"); // Parameter for Initialize event
			idB = id.toString();
		} catch (Exception e) {
			throw new ServletException(e);
		}

		ServletOutputStream out = resp.getOutputStream();
		out.write("Developpement agents avec Janus-project<br/>identifier agent A: ".getBytes());
		out.write(idA.getBytes());
		out.write("<br/>identifier agent B: ".getBytes());
		out.write(idB.getBytes());
		out.flush();
		out.close();
	}

}
