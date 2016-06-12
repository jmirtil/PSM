/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package my.PSM.PSM_Logic;

/**
 *
 * @author clarkep
 */
public class LogicFacade {
    private appController app;
    private Authenticate aut;
    private FutureTimer futureTime;
    private InterfaceController ic;
    
    public LogicFacade(){
    	app = new appController();
    	futureTime = new FutureTimer();
    	ic = new InterfaceController();
    }
}
