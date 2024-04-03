package com.google.android.exoplayer2.video;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.CodecSpecificDataUtil;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.Collections;
import java.util.List;

public final class HevcConfig {
    private static final int SPS_NAL_UNIT_TYPE = 33;
    @Nullable
    public final String codecs;
    public final int colorRange;
    public final int colorSpace;
    public final int colorTransfer;
    public final int height;
    public final List<byte[]> initializationData;
    public final int nalUnitLengthFieldLength;
    public final float pixelWidthHeightRatio;
    public final int width;

    private HevcConfig(List<byte[]> list, int i11, int i12, int i13, float f11, @Nullable String str, int i14, int i15, int i16) {
        this.initializationData = list;
        this.nalUnitLengthFieldLength = i11;
        this.width = i12;
        this.height = i13;
        this.pixelWidthHeightRatio = f11;
        this.codecs = str;
        this.colorSpace = i14;
        this.colorRange = i15;
        this.colorTransfer = i16;
    }

    public static HevcConfig parse(ParsableByteArray parsableByteArray) throws ParserException {
        List list;
        int i11;
        int i12;
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        try {
            parsableByteArray2.skipBytes(21);
            int readUnsignedByte = parsableByteArray.readUnsignedByte() & 3;
            int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
            int position = parsableByteArray.getPosition();
            int i13 = 0;
            int i14 = 0;
            for (int i15 = 0; i15 < readUnsignedByte2; i15++) {
                parsableByteArray2.skipBytes(1);
                int readUnsignedShort = parsableByteArray.readUnsignedShort();
                for (int i16 = 0; i16 < readUnsignedShort; i16++) {
                    int readUnsignedShort2 = parsableByteArray.readUnsignedShort();
                    i14 += readUnsignedShort2 + 4;
                    parsableByteArray2.skipBytes(readUnsignedShort2);
                }
            }
            parsableByteArray2.setPosition(position);
            byte[] bArr = new byte[i14];
            int i17 = -1;
            int i18 = -1;
            int i19 = -1;
            int i21 = -1;
            int i22 = -1;
            float f11 = 1.0f;
            String str = null;
            int i23 = 0;
            int i24 = 0;
            while (i23 < readUnsignedByte2) {
                int readUnsignedByte3 = parsableByteArray.readUnsignedByte() & 63;
                int readUnsignedShort3 = parsableByteArray.readUnsignedShort();
                int i25 = i13;
                while (i25 < readUnsignedShort3) {
                    int readUnsignedShort4 = parsableByteArray.readUnsignedShort();
                    byte[] bArr2 = NalUnitUtil.NAL_START_CODE;
                    int i26 = readUnsignedByte2;
                    System.arraycopy(bArr2, i13, bArr, i24, bArr2.length);
                    int length = i24 + bArr2.length;
                    System.arraycopy(parsableByteArray.getData(), parsableByteArray.getPosition(), bArr, length, readUnsignedShort4);
                    if (readUnsignedByte3 == 33 && i25 == 0) {
                        NalUnitUtil.H265SpsData parseH265SpsNalUnit = NalUnitUtil.parseH265SpsNalUnit(bArr, length, length + readUnsignedShort4);
                        int i27 = parseH265SpsNalUnit.width;
                        i18 = parseH265SpsNalUnit.height;
                        int i28 = parseH265SpsNalUnit.colorSpace;
                        int i29 = parseH265SpsNalUnit.colorRange;
                        int i31 = parseH265SpsNalUnit.colorTransfer;
                        float f12 = parseH265SpsNalUnit.pixelWidthHeightRatio;
                        i12 = readUnsignedByte3;
                        i11 = readUnsignedShort3;
                        i17 = i27;
                        i22 = i31;
                        str = CodecSpecificDataUtil.buildHevcCodecString(parseH265SpsNalUnit.generalProfileSpace, parseH265SpsNalUnit.generalTierFlag, parseH265SpsNalUnit.generalProfileIdc, parseH265SpsNalUnit.generalProfileCompatibilityFlags, parseH265SpsNalUnit.constraintBytes, parseH265SpsNalUnit.generalLevelIdc);
                        int i32 = i28;
                        i21 = i29;
                        f11 = f12;
                        i19 = i32;
                    } else {
                        i12 = readUnsignedByte3;
                        i11 = readUnsignedShort3;
                    }
                    i24 = length + readUnsignedShort4;
                    parsableByteArray2.skipBytes(readUnsignedShort4);
                    i25++;
                    readUnsignedByte2 = i26;
                    readUnsignedByte3 = i12;
                    readUnsignedShort3 = i11;
                    i13 = 0;
                }
                int i33 = readUnsignedByte2;
                i23++;
                i13 = 0;
            }
            if (i14 == 0) {
                list = Collections.emptyList();
            } else {
                list = Collections.singletonList(bArr);
            }
            return new HevcConfig(list, readUnsignedByte + 1, i17, i18, f11, str, i19, i21, i22);
        } catch (ArrayIndexOutOfBoundsException e11) {
            throw ParserException.createForMalformedContainer("Error parsing HEVC config", e11);
        }
    }
}
