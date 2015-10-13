package de.deacix;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import javax.servlet.ServletException;
import java.io.File;

public class Webserver {
	public Webserver() throws ServletException, LifecycleException {
		this("src/main/webapp/", "8080");
	}

	public Webserver(String appDir, String port) throws ServletException, LifecycleException {
		Tomcat tomcat = new Tomcat();
		tomcat.setPort(Integer.valueOf(port));

		tomcat.addWebapp("/", new File(appDir).getAbsolutePath());
		System.out.println("configuring app with basedir: " + new File("./" + appDir).getAbsolutePath());

		tomcat.start();
		tomcat.getServer().await();
	}
}
