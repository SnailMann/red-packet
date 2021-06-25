package com.snailmann.redpacket.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @author liwenjie
 */
@Slf4j
@Configuration
public class RedPacketCommonAutoConfiguration {

    @PostConstruct
    public void init() {
        log.info("RedPacketCommonAutoConfiguration Initialization");
    }

}
