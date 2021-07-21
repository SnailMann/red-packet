package com.snailmann.redpacket.server.factory;

import com.snailmann.redpacket.common.factory.RedPacketFactory;
import com.snailmann.redpacket.common.model.bo.RedPacket;

import static java.util.concurrent.ThreadLocalRandom.current;

/**
 * 实时计算，剩余平均值算法 (二倍均值法)
 *
 * @author liwenjie
 */
public class RemainingAverageRedPacketFactory implements RedPacketFactory {

    private int remainOne = 1;
    private int remainTwo = 2;

    /**
     * 红包算法就是在 [1 cent, (remainValue/remainSize) * 2]
     *
     * @param packet red packet
     * @return value
     */
    @Override
    public double take(RedPacket packet) {
        int min = packet.getMinValue();
        int max = (packet.getRemainValue() / packet.getRemainSize()) * 2;
        int value;
        if (packet.getRemainSize() == remainOne) {
            value = packet.getRemainValue();
        } else if (packet.getRemainSize() == remainTwo) {
            value = current().nextInt(min, max - min);
        } else {
            value = current().nextInt(min, max);
        }
        value = Math.min(value, max);
        packet.reduceSize();
        packet.reduceValue(value);
        return value;
    }
}

