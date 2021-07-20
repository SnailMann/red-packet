package com.snailmann.redpacket.common.factory;

import com.snailmann.redpacket.common.model.bo.RedPacket;
import com.snailmann.redpacket.common.model.bo.Unit;

/**
 * @author liwenjie
 */
public interface RedPacketFactory {

    double take(RedPacket packet);

    /**
     * convert unit
     *
     * @param value value
     * @param unit  unit
     * @return double value
     */
    default double convertUnit(int value, Unit unit) {
        return Math.floor(value * unit.getUnit()) / unit.getUnit();
    }

}

