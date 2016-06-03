/**
 * 
 */
package com.ravi.spring.jms;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author vibhor
 *
 */
public class JMSApp {

	public static void main(String[] args) {

		/**
		 * initializing spring context...
		 */
		final ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("appContext.xml");

		/**
		 * finding bean from spring container by bean type
		 */
		final JMSSender jmsSender = ctx.getBean(JMSSender.class);

		/**
		 * sending message to default queue 'testQueue'
		 */
		jmsSender.send("test message");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ctx.close();
	}
}
