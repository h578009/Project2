package no.hvl.dat110.iotsystem;

import no.hvl.dat110.client.Client;
import no.hvl.dat110.common.TODO;

public class TemperatureDevice {

	private static final int COUNT = 10;

	public static void main(String[] args) {

		// simulated / virtual temperature sensor
		TemperatureSensor sn = new TemperatureSensor();

		// TODO - start

		Client deviceClient = new Client("device", Common.BROKERHOST,Common.BROKERPORT);
		
		deviceClient.connect();
		
		for(int i=0; i<COUNT; i++) {
			deviceClient.publish(Common.TEMPTOPIC, sn.read()+"");
			
		}
		deviceClient.disconnect();
		// create a client object and use it to

		// - connect to the broker
		// - publish the temperature(s)
		// - disconnect from the broker

		// TODO - end

		System.out.println("Temperature device stopping ... ");

//		throw new UnsupportedOperationException(TODO.method());

	}
}
