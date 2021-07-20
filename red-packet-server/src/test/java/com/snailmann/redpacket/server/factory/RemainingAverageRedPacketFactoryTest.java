package com.snailmann.redpacket.server.factory;

import com.snailmann.redpacket.common.model.bo.RedPacket;
import com.snailmann.redpacket.common.model.bo.Unit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author liwenjie
 */
public class RemainingAverageRedPacketFactoryTest {

    @Test
    void take() {
        RemainingAverageRedPacketFactory factory = new RemainingAverageRedPacketFactory();
        RedPacket packet = RedPacket.create(1, 10000, 1880);
        double sum = 0;
        while (packet.getRemainSize() != 0) {
            double value = factory.take(packet);
            sum += value;
            System.out.println(value);
        }
        System.out.println(sum);
    }

}