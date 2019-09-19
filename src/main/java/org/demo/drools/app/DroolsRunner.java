package org.demo.drools.app;

import org.demo.drools.pojo.Account;
import org.demo.drools.pojo.Person;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class DroolsRunner {

	public static void main(String[] args) {
		try {
			// load up the knowledge base
			KieServices ks = KieServices.Factory.get();
			System.out.println("KieServices ready.");
			
			
			KieContainer kContainer = ks.getKieClasspathContainer();
			System.out.println("KieContainer ready.");
			System.out.println(" . releaseId : " +  kContainer.getReleaseId() );
			
			String kSessionName = "ksession-demo"; // ksession name defined in 'kmodule.xml'
			System.out.println("Asking for a new KieSession...");
			// New Session => Rules compilation
			KieSession kSession = kContainer.newKieSession(kSessionName); 
			if ( kSession == null ) {
				System.out.println("ERROR : Cannot create KieSession with name '" + kSessionName + "'");
				System.exit(1);
			}
			System.out.println("KieSession ready.");

			System.out.println(" . entryPointId : " + kSession.getEntryPointId() );
			
			// Facts in Drools session
			System.out.println("Adding 'Person' instances in session...");
			kSession.insert(new Person("Bart", 17, "Drools"));
			kSession.insert(new Person("Joe", 22, "Spring"));
			kSession.insert(new Person("Joe", 22, "Spring"));
			//kSession.insert(new Person("Bob", 25, "Drools"));
			Person kim = new Person("Kim", 25, "Java");
			kSession.insert(kim);
			kSession.insert(kim); // Do not store the same instance twice 
			System.out.println("Session size : " + kSession.getObjects().size() ); // 4 ( not 5 ! )

			System.out.println("Adding 'Account' instances in session...");
			kSession.insert(new Account("A", 200));
			kSession.insert(new Account("B", 450));
			kSession.insert(new Account("C", 50));
			System.out.println("Session size : " + kSession.getObjects().size() );

			System.out.println("------------------------------------------");
			System.out.println("Calling kSession.fireAllRules()...");
			kSession.fireAllRules();
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

}
