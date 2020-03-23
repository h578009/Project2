package no.hvl.dat110.iotsystem;

import no.hvl.dat110.client.Client;
import no.hvl.dat110.messages.Message;
import no.hvl.dat110.messages.PublishMsg;
import no.hvl.dat110.common.TODO;

public class DisplayDevice {
	
	private static final int COUNT = 10;

	public static void main (String[] args) {
		
		System.out.println("Display starting ...");
		
		// TODO - START
				
		// create a client object and use it to
		Client displayClient = new Client("display",Common.BROKERHOST,Common.BROKERPORT);
		
		displayClient.connect();
		displayClient.createTopic(Common.TEMPTOPIC);
		displayClient.subscribe(Common.TEMPTOPIC);
		for(int i=0; i<COUNT;i++) {
			PublishMsg incoming=(PublishMsg) displayClient.receive();
			System.out.println("Reading"+i);
			incoming.getMessage();
		}
		displayClient.unsubscribe(Common.TEMPTOPIC);
		displayClient.disconnect();
		// - connect to the broker
		// - create the temperature topic on the broker
		// - subscribe to the topic
		// - receive messages on the topic
		// - unsubscribe from the topic
		// - disconnect from the broker
		
		// TODO - END
		
		System.out.println("Display stopping ... ");
		
//		throw new UnsupportedOperationException(TODO.method());
		
	}
}
