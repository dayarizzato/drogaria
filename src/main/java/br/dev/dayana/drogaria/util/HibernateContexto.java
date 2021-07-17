package br.dev.dayana.drogaria.util;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class HibernateContexto implements ServletContextListener {

	@Override
	//quando ligo o tomcat
	public void contextInitialized(ServletContextEvent event) {
		HibernateUtil.getFabricaDeSessoes().openSession();
		
	}

	@Override
	//quando desligo o tomcat - destruo fabrica de sessões
	public void contextDestroyed(ServletContextEvent sce) { 
		HibernateUtil.getFabricaDeSessoes().close();
		
	}

}
