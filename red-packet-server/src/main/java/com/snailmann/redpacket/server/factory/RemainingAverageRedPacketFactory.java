package com.snailmann.redpacket.server.factory;

import com.snailmann.redpacket.common.factory.RedPacketFactory;
import com.snailmann.redpacket.common.model.bo.RedPacket;
import org.apache.commons.lang3.RandomUtils;

/**
 * 实时计算，剩余平均值算法 (二倍均值法)
 *
 * @author liwenjie
 */
public class RemainingAverageRedPacketFactory implements RedPacketFactory {


    /**
     * 红包算法就是在 [1 cent, (remainValue/remainSize) * 2]
     *
     * @param packet red packet
     * @return value
     */
    @Override
    public double take(RedPacket packet) {
        if (packet.getRemainSize() == 1) {
            packet.reduceSize();
            int value = packet.getRemainValue();
            packet.reduceValue(value);
            return value;
        }

        int min = packet.getMinValue();
        int max = (packet.getRemainValue() / packet.getRemainSize()) * 2;
        int value = RandomUtils.nextInt(min, max);
        value = Math.max(value, min);
        packet.reduceSize();
        packet.reduceValue(value);
        return value;
    }
}

