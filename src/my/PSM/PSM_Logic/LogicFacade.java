/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package my.PSM.PSM_Logic;

import my.PSM.PSM_Storage.DataStoreFacade;

/**
 *
 * @author clarkep
 */
public class LogicFacade {
    private appController app;
    public LogicFacade(DataStoreFacade dataFacade){
    	app = new appController();
    	app.setDataStoreFacade(dataFacade);
    }
    
    public String fetchCourses(){
    	return app.fetchCourses();
    }
}
