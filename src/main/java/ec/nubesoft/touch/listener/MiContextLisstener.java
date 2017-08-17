package ec.nubesoft.touch.listener;

import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.flowable.engine.ProcessEngine;
import org.flowable.engine.ProcessEngines;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.repository.Deployment;

/**
 * Application Lifecycle Listener implementation class MiContextLisstener
 *
 */

public class MiContextLisstener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public MiContextLisstener() {
        
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  {
    	Logger loger=Logger.getLogger(MiContextLisstener.class.getCanonicalName());
        ProcessEngine defaultProcessEngine = ProcessEngines.getDefaultProcessEngine();
        RepositoryService repositoryService = defaultProcessEngine.getRepositoryService();
        List<Deployment> list = repositoryService.createDeploymentQuery().list();
        if(list.isEmpty()) {
        	loger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>deployando el proceso");
        	repositoryService.createDeployment().addClasspathResource("/alarmasMonedasBilletes.bpmn20.xml").deploy();
        	
        }
        loger.info("proceso desplegado<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
    }
	
}
