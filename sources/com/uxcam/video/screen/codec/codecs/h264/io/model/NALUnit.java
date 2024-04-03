package com.uxcam.video.screen.codec.codecs.h264.io.model;

import com.google.common.base.Ascii;
import java.nio.ByteBuffer;

public class NALUnit {
    public int nal_ref_idc;
    public NALUnitType type;

    public NALUnit(NALUnitType nALUnitType, int i11) {
        this.type = nALUnitType;
        this.nal_ref_idc = i11;
    }

    public static NALUnit read(ByteBuffer byteBuffer) {
        byte b11 = byteBuffer.get() & 255;
        return new NALUnit(NALUnitType.fromValue(b11 & Ascii.US), (b11 >> 5) & 3);
    }

    public void write(ByteBuffer byteBuffer) {
        byteBuffer.put((byte) (this.type.getValue() | (this.nal_ref_idc << 5)));
    }
}
