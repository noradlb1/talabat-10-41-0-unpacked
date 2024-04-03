package com.huawei.location.nlp.network.request.cell;

public class HwCellInfo extends CurrentCell {
    private static final int DEFAULT = -1;
    private int channelNumber = -1;

    public int getChannelNumber() {
        return this.channelNumber;
    }

    public void setChannelNumber(int i11) {
        this.channelNumber = i11;
    }
}
