package br.com.webservice;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;


public class FarmsApplication extends Application {
	public Set<Class<?>> getClasses() {
        Set<Class<?>> rrcs = new HashSet<Class<?>>();
        rrcs.add(ProjectResource.class);
        return rrcs;
    }
}
