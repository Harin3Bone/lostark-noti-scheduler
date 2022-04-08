package com.player.casual.lostark.notification.job;

import com.player.casual.lostark.notification.config.TriggerConfig;
import com.player.casual.lostark.notification.service.impl.DiscordServiceImpl;
import com.player.casual.lostark.notification.service.impl.SecretMerchantServiceImpl;
import lombok.extern.log4j.Log4j2;
import org.quartz.CronScheduleBuilder;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;

@Log4j2
@Component
public class SecretMerchantJob implements Job {

    private static final String JOB_NAME = "SecretMerchantJob";
    private static final String TRIGGER_NAME = "SecretMerchantTrigger";

    private final TriggerConfig triggerConfig;

    @Autowired
    private SecretMerchantServiceImpl secretMerchantService;

    @Autowired
    private DiscordServiceImpl discordService;

    public SecretMerchantJob(TriggerConfig triggerConfig) {
        this.triggerConfig = triggerConfig;
    }

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        log.info("SecretMerchantJob Execute.");
        var continentList = secretMerchantService.getMerchantTown(ZonedDateTime.now());
        discordService.sendMessage(secretMerchantService.getMessage(continentList));
    }

    @Bean
    @Qualifier(JOB_NAME)
    public JobDetail secretMerchantJobDetail() {
        return JobBuilder.newJob().ofType(this.getClass())
                .storeDurably()
                .withIdentity(JOB_NAME)
                .withDescription("")
                .build();
    }

    @Bean
    public Trigger secretMerchantJobTrigger(@Qualifier(JOB_NAME) JobDetail job) {
        return TriggerBuilder.newTrigger().forJob(job)
                .withIdentity(TRIGGER_NAME)
                .withDescription("")
                .withSchedule(CronScheduleBuilder.cronSchedule(triggerConfig.getSecretMerchant()))
                .build();
    }

}
