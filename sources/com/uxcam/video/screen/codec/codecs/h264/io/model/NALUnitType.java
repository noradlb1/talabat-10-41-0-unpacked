package com.uxcam.video.screen.codec.codecs.h264.io.model;

import java.util.EnumSet;
import java.util.Iterator;

public enum NALUnitType {
    NON_IDR_SLICE(1, "non IDR slice"),
    SLICE_PART_A(2, "slice part a"),
    SLICE_PART_B(3, "slice part b"),
    SLICE_PART_C(4, "slice part c"),
    IDR_SLICE(5, "idr slice"),
    SEI(6, "sei"),
    SPS(7, "sequence parameter set"),
    PPS(8, "picture parameter set"),
    ACC_UNIT_DELIM(9, "access unit delimiter"),
    END_OF_SEQ(10, "end of sequence"),
    END_OF_STREAM(11, "end of stream"),
    FILLER_DATA(12, "filter data"),
    SEQ_PAR_SET_EXT(13, "sequence parameter set extension"),
    AUX_SLICE(19, "auxilary slice");
    

    /* renamed from: name  reason: collision with root package name */
    private final String f13680name;
    private final int value;

    private NALUnitType(int i11, String str) {
        this.value = i11;
        this.f13680name = str;
    }

    public static NALUnitType fromValue(int i11) {
        Iterator<E> it = EnumSet.allOf(NALUnitType.class).iterator();
        while (it.hasNext()) {
            NALUnitType nALUnitType = (NALUnitType) it.next();
            if (nALUnitType.value == i11) {
                return nALUnitType;
            }
        }
        return null;
    }

    public String getName() {
        return this.f13680name;
    }

    public int getValue() {
        return this.value;
    }
}
