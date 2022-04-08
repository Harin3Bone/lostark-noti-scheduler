package com.player.casual.lostark.notification.job;

import com.player.casual.lostark.notification.config.TriggerConfig;
import com.player.casual.lostark.notification.constant.NotifyMsg;
import com.player.casual.lostark.notification.service.impl.ChaosGateServiceImpl;
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
public class ChaosGateJob implements Job {

    private static final String JOB_NAME = "ChaosGateJob";
    private static final String TRIGGER_NAME = "ChaosGateTrigger";

    private final TriggerConfig triggerConfig;

    @Autowired
    private ChaosGateServiceImpl chaosGateService;

    @Autowired
    private DiscordServiceImpl discordService;

    public ChaosGateJob(TriggerConfig triggerConfig) {
        this.triggerConfig = triggerConfig;
    }

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        log.info("ChaosGateJob Execute.");
        var continents = chaosGateService.getChaosGateContinents();
        var message = String.format(NotifyMsg.CHAOS_GATE, chaosGateService.getMessage(continents));
        discordService.sendMessage(message);
    }

    @Bean
    @Qualifier(JOB_NAME)
    public JobDetail chaosGateJobDetail() {
        return JobBuilder.newJob().ofType(this.getClass())
                .storeDurably()
                .withIdentity(JOB_NAME)
                .withDescription("")
                .build();
    }

    @Bean
    public Trigger chaosGateJobTrigger(@Qualifier(JOB_NAME) JobDetail job) {
        log.debug("chaosGateJobTrigger trigger= " + triggerConfig.getChaosGate());
        CronScheduleBuilder.cronSchedule(triggerConfig.getChaosGate());
        return TriggerBuilder.newTrigger().forJob(job)
                .withIdentity(TRIGGER_NAME)
                .withDescription("")
                .withSchedule(CronScheduleBuilder.cronSchedule(triggerConfig.getChaosGate()))
                .build();
    }
}
