package com.google.android.exoplayer2.audio;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.nio.ByteBuffer;
import net.bytebuddy.jar.asm.Opcodes;
import okio.Utf8;
import org.apache.commons.compress.archivers.tar.TarConstants;

public final class Ac3Util {
    public static final int AC3_MAX_RATE_BYTES_PER_SECOND = 80000;
    private static final int AC3_SYNCFRAME_AUDIO_SAMPLE_COUNT = 1536;
    private static final int AUDIO_SAMPLES_PER_AUDIO_BLOCK = 256;
    private static final int[] BITRATE_BY_HALF_FRMSIZECOD = {32, 40, 48, 56, 64, 80, 96, 112, 128, Opcodes.IF_ICMPNE, 192, 224, 256, 320, RendererCapabilities.MODE_SUPPORT_MASK, 448, 512, 576, 640};
    private static final int[] BLOCKS_PER_SYNCFRAME_BY_NUMBLKSCOD = {1, 2, 3, 6};
    private static final int[] CHANNEL_COUNT_BY_ACMOD = {2, 1, 2, 3, 3, 4, 4, 5};
    public static final int E_AC3_MAX_RATE_BYTES_PER_SECOND = 768000;
    private static final int[] SAMPLE_RATE_BY_FSCOD = {OpusUtil.SAMPLE_RATE, 44100, 32000};
    private static final int[] SAMPLE_RATE_BY_FSCOD2 = {24000, 22050, AacUtil.AAC_HE_V1_MAX_RATE_BYTES_PER_SECOND};
    private static final int[] SYNCFRAME_SIZE_WORDS_BY_HALF_FRMSIZECOD_44_1 = {69, 87, 104, 121, Opcodes.F2I, Opcodes.FRETURN, 208, 243, 278, 348, 417, 487, 557, 696, 835, 975, 1114, 1253, 1393};
    public static final int TRUEHD_MAX_RATE_BYTES_PER_SECOND = 3062500;
    public static final int TRUEHD_RECHUNK_SAMPLE_COUNT = 16;
    public static final int TRUEHD_SYNCFRAME_PREFIX_LENGTH = 10;

    public static final class SyncFrameInfo {
        public static final int STREAM_TYPE_TYPE0 = 0;
        public static final int STREAM_TYPE_TYPE1 = 1;
        public static final int STREAM_TYPE_TYPE2 = 2;
        public static final int STREAM_TYPE_UNDEFINED = -1;
        public final int bitrate;
        public final int channelCount;
        public final int frameSize;
        @Nullable
        public final String mimeType;
        public final int sampleCount;
        public final int sampleRate;
        public final int streamType;

        @Documented
        @Target({ElementType.TYPE_USE})
        @Retention(RetentionPolicy.SOURCE)
        public @interface StreamType {
        }

        private SyncFrameInfo(@Nullable String str, int i11, int i12, int i13, int i14, int i15, int i16) {
            this.mimeType = str;
            this.streamType = i11;
            this.channelCount = i12;
            this.sampleRate = i13;
            this.frameSize = i14;
            this.sampleCount = i15;
            this.bitrate = i16;
        }
    }

    private Ac3Util() {
    }

    private static int calculateEac3Bitrate(int i11, int i12, int i13) {
        return (i11 * i12) / (i13 * 32);
    }

    public static int findTrueHdSyncframeOffset(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int limit = byteBuffer.limit() - 10;
        for (int i11 = position; i11 <= limit; i11++) {
            if ((Util.getBigEndianInt(byteBuffer, i11 + 4) & -2) == -126718022) {
                return i11 - position;
            }
        }
        return -1;
    }

    private static int getAc3SyncframeSize(int i11, int i12) {
        int i13 = i12 / 2;
        if (i11 < 0) {
            return -1;
        }
        int[] iArr = SAMPLE_RATE_BY_FSCOD;
        if (i11 >= iArr.length || i12 < 0) {
            return -1;
        }
        int[] iArr2 = SYNCFRAME_SIZE_WORDS_BY_HALF_FRMSIZECOD_44_1;
        if (i13 >= iArr2.length) {
            return -1;
        }
        int i14 = iArr[i11];
        if (i14 == 44100) {
            return (iArr2[i13] + (i12 % 2)) * 2;
        }
        int i15 = BITRATE_BY_HALF_FRMSIZECOD[i13];
        if (i14 == 32000) {
            return i15 * 6;
        }
        return i15 * 4;
    }

    public static Format parseAc3AnnexFFormat(ParsableByteArray parsableByteArray, String str, String str2, @Nullable DrmInitData drmInitData) {
        ParsableBitArray parsableBitArray = new ParsableBitArray();
        parsableBitArray.reset(parsableByteArray);
        int i11 = SAMPLE_RATE_BY_FSCOD[parsableBitArray.readBits(2)];
        parsableBitArray.skipBits(8);
        int i12 = CHANNEL_COUNT_BY_ACMOD[parsableBitArray.readBits(3)];
        if (parsableBitArray.readBits(1) != 0) {
            i12++;
        }
        int i13 = BITRATE_BY_HALF_FRMSIZECOD[parsableBitArray.readBits(5)] * 1000;
        parsableBitArray.byteAlign();
        parsableByteArray.setPosition(parsableBitArray.getBytePosition());
        return new Format.Builder().setId(str).setSampleMimeType(MimeTypes.AUDIO_AC3).setChannelCount(i12).setSampleRate(i11).setDrmInitData(drmInitData).setLanguage(str2).setAverageBitrate(i13).setPeakBitrate(i13).build();
    }

    public static int parseAc3SyncframeAudioSampleCount(ByteBuffer byteBuffer) {
        boolean z11;
        int i11 = 3;
        if (((byteBuffer.get(byteBuffer.position() + 5) & 248) >> 3) > 10) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            return AC3_SYNCFRAME_AUDIO_SAMPLE_COUNT;
        }
        if (((byteBuffer.get(byteBuffer.position() + 4) & 192) >> 6) != 3) {
            i11 = (byteBuffer.get(byteBuffer.position() + 4) & TarConstants.LF_NORMAL) >> 4;
        }
        return BLOCKS_PER_SYNCFRAME_BY_NUMBLKSCOD[i11] * 256;
    }

    public static SyncFrameInfo parseAc3SyncframeInfo(ParsableBitArray parsableBitArray) {
        boolean z11;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        String str;
        int i16;
        String str2;
        int i17;
        int i18;
        int i19;
        int i21;
        int i22;
        String str3;
        int i23;
        int i24;
        ParsableBitArray parsableBitArray2 = parsableBitArray;
        int position = parsableBitArray.getPosition();
        parsableBitArray2.skipBits(40);
        if (parsableBitArray2.readBits(5) > 10) {
            z11 = true;
        } else {
            z11 = false;
        }
        parsableBitArray2.setPosition(position);
        int i25 = -1;
        if (z11) {
            parsableBitArray2.skipBits(16);
            int readBits = parsableBitArray2.readBits(2);
            if (readBits == 0) {
                i25 = 0;
            } else if (readBits == 1) {
                i25 = 1;
            } else if (readBits == 2) {
                i25 = 2;
            }
            parsableBitArray2.skipBits(3);
            int readBits2 = (parsableBitArray2.readBits(11) + 1) * 2;
            int readBits3 = parsableBitArray2.readBits(2);
            if (readBits3 == 3) {
                i21 = SAMPLE_RATE_BY_FSCOD2[parsableBitArray2.readBits(2)];
                i19 = 3;
                i18 = 6;
            } else {
                int readBits4 = parsableBitArray2.readBits(2);
                int i26 = BLOCKS_PER_SYNCFRAME_BY_NUMBLKSCOD[readBits4];
                i19 = readBits4;
                i21 = SAMPLE_RATE_BY_FSCOD[readBits3];
                i18 = i26;
            }
            int i27 = i18 * 256;
            int calculateEac3Bitrate = calculateEac3Bitrate(readBits2, i21, i18);
            int readBits5 = parsableBitArray2.readBits(3);
            boolean readBit = parsableBitArray.readBit();
            i16 = CHANNEL_COUNT_BY_ACMOD[readBits5] + (readBit ? 1 : 0);
            parsableBitArray2.skipBits(10);
            if (parsableBitArray.readBit()) {
                parsableBitArray2.skipBits(8);
            }
            if (readBits5 == 0) {
                parsableBitArray2.skipBits(5);
                if (parsableBitArray.readBit()) {
                    parsableBitArray2.skipBits(8);
                }
            }
            if (i25 == 1 && parsableBitArray.readBit()) {
                parsableBitArray2.skipBits(16);
            }
            if (parsableBitArray.readBit()) {
                if (readBits5 > 2) {
                    parsableBitArray2.skipBits(2);
                }
                if ((readBits5 & 1) == 0 || readBits5 <= 2) {
                    i23 = 6;
                } else {
                    i23 = 6;
                    parsableBitArray2.skipBits(6);
                }
                if ((readBits5 & 4) != 0) {
                    parsableBitArray2.skipBits(i23);
                }
                if (readBit && parsableBitArray.readBit()) {
                    parsableBitArray2.skipBits(5);
                }
                if (i25 == 0) {
                    if (parsableBitArray.readBit()) {
                        i24 = 6;
                        parsableBitArray2.skipBits(6);
                    } else {
                        i24 = 6;
                    }
                    if (readBits5 == 0 && parsableBitArray.readBit()) {
                        parsableBitArray2.skipBits(i24);
                    }
                    if (parsableBitArray.readBit()) {
                        parsableBitArray2.skipBits(i24);
                    }
                    int readBits6 = parsableBitArray2.readBits(2);
                    if (readBits6 == 1) {
                        parsableBitArray2.skipBits(5);
                    } else if (readBits6 == 2) {
                        parsableBitArray2.skipBits(12);
                    } else if (readBits6 == 3) {
                        int readBits7 = parsableBitArray2.readBits(5);
                        if (parsableBitArray.readBit()) {
                            parsableBitArray2.skipBits(5);
                            if (parsableBitArray.readBit()) {
                                parsableBitArray2.skipBits(4);
                            }
                            if (parsableBitArray.readBit()) {
                                parsableBitArray2.skipBits(4);
                            }
                            if (parsableBitArray.readBit()) {
                                parsableBitArray2.skipBits(4);
                            }
                            if (parsableBitArray.readBit()) {
                                parsableBitArray2.skipBits(4);
                            }
                            if (parsableBitArray.readBit()) {
                                parsableBitArray2.skipBits(4);
                            }
                            if (parsableBitArray.readBit()) {
                                parsableBitArray2.skipBits(4);
                            }
                            if (parsableBitArray.readBit()) {
                                parsableBitArray2.skipBits(4);
                            }
                            if (parsableBitArray.readBit()) {
                                if (parsableBitArray.readBit()) {
                                    parsableBitArray2.skipBits(4);
                                }
                                if (parsableBitArray.readBit()) {
                                    parsableBitArray2.skipBits(4);
                                }
                            }
                        }
                        if (parsableBitArray.readBit()) {
                            parsableBitArray2.skipBits(5);
                            if (parsableBitArray.readBit()) {
                                parsableBitArray2.skipBits(7);
                                if (parsableBitArray.readBit()) {
                                    parsableBitArray2.skipBits(8);
                                }
                            }
                        }
                        parsableBitArray2.skipBits((readBits7 + 2) * 8);
                        parsableBitArray.byteAlign();
                    }
                    if (readBits5 < 2) {
                        if (parsableBitArray.readBit()) {
                            parsableBitArray2.skipBits(14);
                        }
                        if (readBits5 == 0 && parsableBitArray.readBit()) {
                            parsableBitArray2.skipBits(14);
                        }
                    }
                    if (parsableBitArray.readBit()) {
                        if (i19 == 0) {
                            parsableBitArray2.skipBits(5);
                        } else {
                            for (int i28 = 0; i28 < i18; i28++) {
                                if (parsableBitArray.readBit()) {
                                    parsableBitArray2.skipBits(5);
                                }
                            }
                        }
                    }
                }
            }
            if (parsableBitArray.readBit()) {
                parsableBitArray2.skipBits(5);
                if (readBits5 == 2) {
                    parsableBitArray2.skipBits(4);
                }
                if (readBits5 >= 6) {
                    parsableBitArray2.skipBits(2);
                }
                if (parsableBitArray.readBit()) {
                    parsableBitArray2.skipBits(8);
                }
                if (readBits5 == 0 && parsableBitArray.readBit()) {
                    parsableBitArray2.skipBits(8);
                }
                if (readBits3 < 3) {
                    parsableBitArray.skipBit();
                }
            }
            if (i25 == 0 && i19 != 3) {
                parsableBitArray.skipBit();
            }
            if (i25 != 2 || (i19 != 3 && !parsableBitArray.readBit())) {
                i22 = 6;
            } else {
                i22 = 6;
                parsableBitArray2.skipBits(6);
            }
            if (parsableBitArray.readBit() && parsableBitArray2.readBits(i22) == 1 && parsableBitArray2.readBits(8) == 1) {
                str3 = MimeTypes.AUDIO_E_AC3_JOC;
            } else {
                str3 = MimeTypes.AUDIO_E_AC3;
            }
            str = str3;
            i15 = i25;
            i12 = i27;
            i13 = readBits2;
            i14 = i21;
            i11 = calculateEac3Bitrate;
        } else {
            parsableBitArray2.skipBits(32);
            int readBits8 = parsableBitArray2.readBits(2);
            if (readBits8 == 3) {
                str2 = null;
            } else {
                str2 = MimeTypes.AUDIO_AC3;
            }
            int readBits9 = parsableBitArray2.readBits(6);
            int i29 = BITRATE_BY_HALF_FRMSIZECOD[readBits9 / 2] * 1000;
            int ac3SyncframeSize = getAc3SyncframeSize(readBits8, readBits9);
            parsableBitArray2.skipBits(8);
            int readBits10 = parsableBitArray2.readBits(3);
            if (!((readBits10 & 1) == 0 || readBits10 == 1)) {
                parsableBitArray2.skipBits(2);
            }
            if ((readBits10 & 4) != 0) {
                parsableBitArray2.skipBits(2);
            }
            if (readBits10 == 2) {
                parsableBitArray2.skipBits(2);
            }
            int[] iArr = SAMPLE_RATE_BY_FSCOD;
            if (readBits8 < iArr.length) {
                i17 = iArr[readBits8];
            } else {
                i17 = -1;
            }
            i16 = CHANNEL_COUNT_BY_ACMOD[readBits10] + (parsableBitArray.readBit() ? 1 : 0);
            i15 = -1;
            str = str2;
            i12 = AC3_SYNCFRAME_AUDIO_SAMPLE_COUNT;
            i11 = i29;
            i13 = ac3SyncframeSize;
            i14 = i17;
        }
        return new SyncFrameInfo(str, i15, i16, i14, i13, i12, i11);
    }

    public static int parseAc3SyncframeSize(byte[] bArr) {
        boolean z11;
        if (bArr.length < 6) {
            return -1;
        }
        if (((bArr[5] & 248) >> 3) > 10) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return (((bArr[3] & 255) | ((bArr[2] & 7) << 8)) + 1) * 2;
        }
        byte b11 = bArr[4];
        return getAc3SyncframeSize((b11 & 192) >> 6, b11 & Utf8.REPLACEMENT_BYTE);
    }

    public static Format parseEAc3AnnexFFormat(ParsableByteArray parsableByteArray, String str, String str2, @Nullable DrmInitData drmInitData) {
        String str3;
        ParsableBitArray parsableBitArray = new ParsableBitArray();
        parsableBitArray.reset(parsableByteArray);
        int readBits = parsableBitArray.readBits(13) * 1000;
        parsableBitArray.skipBits(3);
        int i11 = SAMPLE_RATE_BY_FSCOD[parsableBitArray.readBits(2)];
        parsableBitArray.skipBits(10);
        int i12 = CHANNEL_COUNT_BY_ACMOD[parsableBitArray.readBits(3)];
        if (parsableBitArray.readBits(1) != 0) {
            i12++;
        }
        parsableBitArray.skipBits(3);
        int readBits2 = parsableBitArray.readBits(4);
        parsableBitArray.skipBits(1);
        if (readBits2 > 0) {
            parsableBitArray.skipBytes(6);
            if (parsableBitArray.readBits(1) != 0) {
                i12 += 2;
            }
            parsableBitArray.skipBits(1);
        }
        if (parsableBitArray.bitsLeft() > 7) {
            parsableBitArray.skipBits(7);
            if (parsableBitArray.readBits(1) != 0) {
                str3 = MimeTypes.AUDIO_E_AC3_JOC;
                parsableBitArray.byteAlign();
                parsableByteArray.setPosition(parsableBitArray.getBytePosition());
                return new Format.Builder().setId(str).setSampleMimeType(str3).setChannelCount(i12).setSampleRate(i11).setDrmInitData(drmInitData).setLanguage(str2).setPeakBitrate(readBits).build();
            }
        }
        str3 = MimeTypes.AUDIO_E_AC3;
        parsableBitArray.byteAlign();
        parsableByteArray.setPosition(parsableBitArray.getBytePosition());
        return new Format.Builder().setId(str).setSampleMimeType(str3).setChannelCount(i12).setSampleRate(i11).setDrmInitData(drmInitData).setLanguage(str2).setPeakBitrate(readBits).build();
    }

    public static int parseTrueHdSyncframeAudioSampleCount(byte[] bArr) {
        boolean z11 = false;
        if (bArr[4] == -8 && bArr[5] == 114 && bArr[6] == 111) {
            byte b11 = bArr[7];
            if ((b11 & 254) == 186) {
                if ((b11 & 255) == 187) {
                    z11 = true;
                }
                return 40 << ((bArr[z11 ? (char) 9 : 8] >> 4) & 7);
            }
        }
        return 0;
    }

    public static int parseTrueHdSyncframeAudioSampleCount(ByteBuffer byteBuffer, int i11) {
        return 40 << ((byteBuffer.get((byteBuffer.position() + i11) + ((byteBuffer.get((byteBuffer.position() + i11) + 7) & 255) == 187 ? 9 : 8)) >> 4) & 7);
    }
}
