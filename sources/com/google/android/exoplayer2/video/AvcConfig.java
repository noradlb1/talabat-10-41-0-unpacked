package com.google.android.exoplayer2.video;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.CodecSpecificDataUtil;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.ArrayList;
import java.util.List;

public final class AvcConfig {
    @Nullable
    public final String codecs;
    public final int height;
    public final List<byte[]> initializationData;
    public final int nalUnitLengthFieldLength;
    public final float pixelWidthHeightRatio;
    public final int width;

    private AvcConfig(List<byte[]> list, int i11, int i12, int i13, float f11, @Nullable String str) {
        this.initializationData = list;
        this.nalUnitLengthFieldLength = i11;
        this.width = i12;
        this.height = i13;
        this.pixelWidthHeightRatio = f11;
        this.codecs = str;
    }

    private static byte[] buildNalUnitForChild(ParsableByteArray parsableByteArray) {
        int readUnsignedShort = parsableByteArray.readUnsignedShort();
        int position = parsableByteArray.getPosition();
        parsableByteArray.skipBytes(readUnsignedShort);
        return CodecSpecificDataUtil.buildNalUnit(parsableByteArray.getData(), position, readUnsignedShort);
    }

    public static AvcConfig parse(ParsableByteArray parsableByteArray) throws ParserException {
        String str;
        float f11;
        int i11;
        int i12;
        try {
            parsableByteArray.skipBytes(4);
            int readUnsignedByte = (parsableByteArray.readUnsignedByte() & 3) + 1;
            if (readUnsignedByte != 3) {
                ArrayList arrayList = new ArrayList();
                int readUnsignedByte2 = parsableByteArray.readUnsignedByte() & 31;
                for (int i13 = 0; i13 < readUnsignedByte2; i13++) {
                    arrayList.add(buildNalUnitForChild(parsableByteArray));
                }
                int readUnsignedByte3 = parsableByteArray.readUnsignedByte();
                for (int i14 = 0; i14 < readUnsignedByte3; i14++) {
                    arrayList.add(buildNalUnitForChild(parsableByteArray));
                }
                if (readUnsignedByte2 > 0) {
                    NalUnitUtil.SpsData parseSpsNalUnit = NalUnitUtil.parseSpsNalUnit((byte[]) arrayList.get(0), readUnsignedByte, ((byte[]) arrayList.get(0)).length);
                    int i15 = parseSpsNalUnit.width;
                    int i16 = parseSpsNalUnit.height;
                    float f12 = parseSpsNalUnit.pixelWidthHeightRatio;
                    str = CodecSpecificDataUtil.buildAvcCodecString(parseSpsNalUnit.profileIdc, parseSpsNalUnit.constraintsFlagsAndReservedZero2Bits, parseSpsNalUnit.levelIdc);
                    i12 = i15;
                    i11 = i16;
                    f11 = f12;
                } else {
                    i12 = -1;
                    i11 = -1;
                    f11 = 1.0f;
                    str = null;
                }
                return new AvcConfig(arrayList, readUnsignedByte, i12, i11, f11, str);
            }
            throw new IllegalStateException();
        } catch (ArrayIndexOutOfBoundsException e11) {
            throw ParserException.createForMalformedContainer("Error parsing AVC config", e11);
        }
    }
}
