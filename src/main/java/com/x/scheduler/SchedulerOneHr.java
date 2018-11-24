package com.x.scheduler;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.io.IOException;
import java.util.Properties;
import com.sendgrid.Content;
import com.sendgrid.Email;
import com.sendgrid.Mail;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;

public class SchedulerOneHr implements Job{

	
	
	
	public void execute(JobExecutionContext context) throws JobExecutionException {
		
		try {
			generateAndSendEmail();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static void generateAndSendEmail() throws IOException{
	     
		
		Email from = new Email("abdulheru@gmail.com");
        String subject = "Sending with SendGrid is Fun";
        Email to = new Email("ttlservercare@gmail.com");
        Content content = new Content("text/plain", "and easy to do anywhere, even with Java");
        Mail mail = new Mail(from, subject, to, content);

        SendGrid sg = new SendGrid("SG.xxxxxxxxxxxxxxxx");
        Request request = new Request();
        try {
          request.setMethod(Method.POST);
          request.setEndpoint("mail/send");
          request.setBody(mail.build());
          Response response = sg.api(request);
          System.out.println(response.getStatusCode());
          System.out.println(response.getBody());
          System.out.println(response.getHeaders());
        } catch (IOException ex) {
          throw ex;
        }
		
		System.out.println("\n\n ===> Your Java Program has just sent an Email successfully. Check your email..");
	}
	

}
