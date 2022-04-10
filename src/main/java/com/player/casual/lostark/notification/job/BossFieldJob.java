package com.player.casual.lostark.notification.job;

import com.player.casual.lostark.notification.config.TriggerConfig;
import com.player.casual.lostark.notification.service.impl.BossFieldServiceImpl;
import com.player.casual.lostark.notification.service.impl.DiscordServiceImpl;
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

@Log4j2
@Component
public class BossFieldJob implements Job {

    private static final String JOB_NAME = "BossFieldJob";
    private static final String TRIGGER_NAME = "BossFieldTrigger";

    private final TriggerConfig triggerConfig;

    @Autowired
    private BossFieldServiceImpl bossFieldService;

    @Autowired
    private DiscordServiceImpl discordService;

    public BossFieldJob(TriggerConfig triggerConfig) {
        this.triggerConfig = triggerConfig;
    }

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        log.info("BossFieldJob Execute.");
        discordService.sendMessage(bossFieldService.getMessage());
    }

    @Bean
    @Qualifier(JOB_NAME)
    public JobDetail bossFieldJobDetail() {
        return JobBuilder.newJob().ofType(this.getClass())
                .storeDurably()
                .withIdentity(JOB_NAME)
                .withDescription("")
                .build();
    }

    @Bean
    public Trigger bossFieldJobTrigger(@Qualifier(JOB_NAME) JobDetail job) {
        CronScheduleBuilder.cronSchedule(triggerConfig.getChaosGate());
        return TriggerBuilder.newTrigger().forJob(job)
                .withIdentity(TRIGGER_NAME)
                .withDescription("")
                .withSchedule(CronScheduleBuilder.cronSchedule(triggerConfig.getBossField()))
                .build();
    }
}
