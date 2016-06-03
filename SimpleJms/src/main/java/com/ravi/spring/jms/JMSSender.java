/**
 * 
 */
package com.ravi.spring.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

/**
 * @author vibhor
 *
 *         this class uses JmsTemplate to send messages to destination
 */
public class JMSSender {

	private final JmsTemplate jmsTemplate;

	public JMSSender(final JmsTemplate jmsTemplate) {

		this.jmsTemplate = jmsTemplate;
	}

	public void send(final String msg) {

		jmsTemplate.send(new MessageCreator() {

			public Message createMessage(Session session) throws JMSException {

				final TextMessage message = session.createTextMessage();

				message.setText(msg);

				return message;
			}
		});
	}
}
