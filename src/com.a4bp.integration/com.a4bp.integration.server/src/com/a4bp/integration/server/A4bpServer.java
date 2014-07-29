package com.a4bp.integration.server;

import java.io.File;

import org.glassfish.embeddable.Deployer;
import org.glassfish.embeddable.GlassFish;
import org.glassfish.embeddable.GlassFishException;
import org.glassfish.embeddable.GlassFishProperties;
import org.glassfish.embeddable.GlassFishRuntime;

/**
 * 
 * @author alvarojose
 * 
 */
public class A4bpServer {
	private static A4bpServer INSTANCE = null;
	
	private GlassFish glassfish = null;
	
	public static A4bpServer instance(){
		if(INSTANCE == null){
			INSTANCE = new A4bpServer();
		}
		return INSTANCE;
	}
	
	public static void main(String[] args) {
		try {
			A4bpServer.instance().startEmbedServer();
			A4bpServer.instance().deployA4bpIntegration();
		} catch (GlassFishException e) {
			e.printStackTrace();
		}
	}

	private void deployA4bpIntegration() throws GlassFishException {
		// Obtain the deployer from the glassfish which is embedded via the
		// piece of code above.
		Deployer deployer = glassfish.getDeployer();

		// syntax of deployment params are same as how they are passed to
		// 'asadmin deploy' command.
		deployer.deploy(new File("com.a4bp.integration.soap.war"), "--contextroot=a4bp",
				"--name=a4bp", "--force=true");
	}

	private void startEmbedServer() throws GlassFishException {
		/** Create and start GlassFish which listens at 8080 http port */
		GlassFishProperties gfProps = new GlassFishProperties();
		gfProps.setPort("http-listener", 8080); // refer JavaDocs for the
												// details of this API.
		glassfish = GlassFishRuntime.bootstrap()
				.newGlassFish(gfProps);
		glassfish.start();
	}
}
