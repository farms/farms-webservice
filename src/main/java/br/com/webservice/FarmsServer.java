package br.com.webservice;
import org.restlet.Component;
import org.restlet.Server;
import org.restlet.data.Protocol;
import org.restlet.ext.jaxrs.JaxRsApplication;

import br.com.service.FarmsPersistence;


public class FarmsServer {

	public static void main(String[] args) throws Exception {
		// create Component (as ever for Restlet)
        Component comp = new Component();
        Server server = comp.getServers().add(Protocol.HTTP, 8182);
        server.setAddress("0.0.0.0");

        // create JAX-RS runtime environment
        JaxRsApplication application = new JaxRsApplication(comp.getContext());

        // attach Application
        application.add(new FarmsApplication());

        // Attach the application to the component and start it
       /* VirtualHost host = new VirtualHost(comp.getContext().createChildContext());
        host.setServerAddress("0.0.0.0");
        host.attach(application);
        comp.getHosts().add(host);*/
       // comp.getDefaultHost().setServerAddress("0.0.0.0");
        comp.getDefaultHost().attach(application);
        comp.start();
        FarmsPersistence.instance();
        System.out.println("Server started on port " + server.getPort());
        System.out.println("Press key to stop server");
        
        System.in.read();
        System.out.println("Stopping server");
        comp.stop();
        System.out.println("Server stopped");
	}

}
