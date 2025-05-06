package mylab.notification.di.annot.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import mylab.notification.di.annot.EmailNotificationService;
import mylab.notification.di.annot.NotificationManager;
import mylab.notification.di.annot.SmsNotificationService;
import notification.di.annot.config.NotificationConfig;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = NotificationConfig.class)
public class NotificationConfigTest {
	@Autowired
	private NotificationManager notificationManager;
	
	@Test
	void testNotificationManager() {
		assertNotNull(notificationManager);
		
		EmailNotificationService emailService = (EmailNotificationService) notificationManager.getEmailService();
        SmsNotificationService smsService = (SmsNotificationService) notificationManager.getSmsService();
		
		assertEquals("smtp.gmail.com", emailService.getSmtpServer());
		assertEquals(587, emailService.getPort());
		assertEquals("SKT", smsService.getProvider());
	}
}
