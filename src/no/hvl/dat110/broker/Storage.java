package no.hvl.dat110.broker;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;

import no.hvl.dat110.common.TODO;
import no.hvl.dat110.messages.Message;
import no.hvl.dat110.messages.PublishMsg;
import no.hvl.dat110.common.Logger;
import no.hvl.dat110.messagetransport.Connection;

public class Storage {

	// data structure for managing subscriptions
	// maps from a topic to set of subscribed users
	protected ConcurrentHashMap<String, Set<String>> subscriptions;
	
	// data structure for managing currently connected clients
	// maps from user to corresponding client session object
	
	protected ConcurrentHashMap<String, ClientSession> clients;
	
	protected ConcurrentHashMap<String, Stack<Message>> messageBuffer;

	public Storage() {
		subscriptions = new ConcurrentHashMap<String, Set<String>>();
		clients = new ConcurrentHashMap<String, ClientSession>();
		messageBuffer = new ConcurrentHashMap<String, Stack<Message>>();
	}

	public Collection<ClientSession> getSessions() {
		return clients.values();
	}

	public Set<String> getTopics() {

		return subscriptions.keySet();

	}

	// get the session object for a given user
	// session object can be used to send a message to the user
	
	public ClientSession getSession(String user) {

		ClientSession session = clients.get(user);

		return session;
	}

	public Set<String> getSubscribers(String topic) {

		return (subscriptions.get(topic));

	}
	

	public void addClientSession(String user, Connection connection) {
		 
		clients.put(user,  new ClientSession(user, connection));
		// TODO: add corresponding client session to the storage
		
//		throw new UnsupportedOperationException(TODO.method());
		
	}

	public void removeClientSession(String user) {

		// TODO: remove client session for user from the storage'
		clients.remove(user);

//		throw new UnsupportedOperationException(TODO.method());
		
	}

	public void createTopic(String topic) {
		
		
		Set<String> subs = new HashSet<String>();
		subscriptions.put(topic, subs);
		// TODO: create topic in the storage

//		throw new UnsupportedOperationException(TODO.method());
	
	}

	public void deleteTopic(String topic) {

		subscriptions.remove(topic);
		// TODO: delete topic from the storage

//		throw new UnsupportedOperationException(TODO.method());
		
	}

	public void addSubscriber(String user, String topic) {

		this.getSubscribers(topic).add(user);
		// TODO: add the user as subscriber to the topic
		
//		throw new UnsupportedOperationException(TODO.method());
		
	}

	public void removeSubscriber(String user, String topic) {
		subscriptions.get(topic).remove(user);
		// TODO: remove the user as subscriber to the topic

//		throw new UnsupportedOperationException(TODO.method());
	}
	
	
// For oppgave e	
	public Set<String> getUsersWithMessages(){
		return messageBuffer.keySet();
	}
	
	public Stack<Message> getBufferedMessages(String user){
		return messageBuffer.get(user);
	}

	public void addMessageToBuffer(String user, PublishMsg message) {
		messageBuffer.get(user).add(message);
	}

	public void addMessageBuffer(String user) {
		messageBuffer.put(user, new Stack<Message>());		
	}
	
	
	
}
