package com.snailmann.redpacket.common.model.bo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

/**
 * @author liwenjie
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RedPacket {

    private int minValue;

    private int preAllocValue;

    private int totalValue;

    private int remainValue;

    private int totalSize;

    private int remainSize;

    public void reduceSize() {
        this.remainSize--;
    }

    public void reduceValue(double delta) {
        this.remainValue -= delta;
    }

    public double allow2allocValue() {
        return this.getRemainValue() - this.getPreAllocValue();
    }

    /**
     * create a RedPacket
     *
     * @param minValue   minuium value
     * @param totalValue total value
     * @param size       red-packet size
     * @return RedPacket
     */
    public static RedPacket create(int minValue, int totalValue, int size) {
        Assert.isTrue(totalValue >= minValue * size,
                "the value of single red-packet should be more than 1 cent");
        return RedPacket.builder()
                .minValue(minValue)
                .preAllocValue(minValue * size)
                .totalValue(totalValue).totalSize(size)
                .remainValue(totalValue).remainSize(size)
                .build();
    }


}
