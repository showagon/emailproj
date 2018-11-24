package com.x.Email;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;




import com.x.scheduler.SchedulerOneHr;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SchedulerException
    {
    	
    	
    	
    	
    	
        //System.out.println( "Hello World!" );
     // define the job and tie it to our HelloJob class
        JobDetail job1 =JobBuilder.newJob(SchedulerOneHr.class).build();
           
        Trigger trigger =TriggerBuilder.newTrigger().withIdentity("CroneTrigger")
        		.withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(10)
        				.repeatForever()).build();
        
        Scheduler schedule = StdSchedulerFactory.getDefaultScheduler();
        
        schedule.start();
        schedule.scheduleJob(job1, trigger);

        
        
    }
}
