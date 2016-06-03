/**
 * 
 */
package com.ravi.spring.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.jms.listener.SessionAwareMessageListener;

/**
 */
public class JMSListener implements SessionAwareMessageListener<Message> {

	@Override
	public void onMessage(final Message msg, final Session session) throws JMSException {
		try {

			processMessage((TextMessage) msg);

			session.commit();

		} catch (final Exception e) {

			e.printStackTrace();

			session.rollback();
		}
	}

	private void processMessage(TextMessage msg) throws JMSException {

		System.out.println("hello spring jms...., processing msg: " + msg.getText());
	}
}
