package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableByteArray;

public final class CeaUtil {
    private static final int COUNTRY_CODE = 181;
    private static final int PAYLOAD_TYPE_CC = 4;
    private static final int PROVIDER_CODE_ATSC = 49;
    private static final int PROVIDER_CODE_DIRECTV = 47;
    private static final String TAG = "CeaUtil";
    public static final int USER_DATA_IDENTIFIER_GA94 = 1195456820;
    public static final int USER_DATA_TYPE_CODE_MPEG_CC = 3;

    private CeaUtil() {
    }

    public static void consume(long j11, ParsableByteArray parsableByteArray, TrackOutput[] trackOutputArr) {
        int i11;
        boolean z11;
        while (true) {
            boolean z12 = true;
            if (parsableByteArray.bytesLeft() > 1) {
                int readNon255TerminatedValue = readNon255TerminatedValue(parsableByteArray);
                int readNon255TerminatedValue2 = readNon255TerminatedValue(parsableByteArray);
                int position = parsableByteArray.getPosition() + readNon255TerminatedValue2;
                if (readNon255TerminatedValue2 == -1 || readNon255TerminatedValue2 > parsableByteArray.bytesLeft()) {
                    Log.w(TAG, "Skipping remainder of malformed SEI NAL unit.");
                    position = parsableByteArray.limit();
                } else if (readNon255TerminatedValue == 4 && readNon255TerminatedValue2 >= 8) {
                    int readUnsignedByte = parsableByteArray.readUnsignedByte();
                    int readUnsignedShort = parsableByteArray.readUnsignedShort();
                    if (readUnsignedShort == 49) {
                        i11 = parsableByteArray.readInt();
                    } else {
                        i11 = 0;
                    }
                    int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
                    if (readUnsignedShort == 47) {
                        parsableByteArray.skipBytes(1);
                    }
                    if (readUnsignedByte == 181 && ((readUnsignedShort == 49 || readUnsignedShort == 47) && readUnsignedByte2 == 3)) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    if (readUnsignedShort == 49) {
                        if (i11 != 1195456820) {
                            z12 = false;
                        }
                        z11 &= z12;
                    }
                    if (z11) {
                        consumeCcData(j11, parsableByteArray, trackOutputArr);
                    }
                }
                parsableByteArray.setPosition(position);
            } else {
                return;
            }
        }
    }

    public static void consumeCcData(long j11, ParsableByteArray parsableByteArray, TrackOutput[] trackOutputArr) {
        boolean z11;
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        if ((readUnsignedByte & 64) != 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            parsableByteArray.skipBytes(1);
            int i11 = (readUnsignedByte & 31) * 3;
            int position = parsableByteArray.getPosition();
            for (TrackOutput trackOutput : trackOutputArr) {
                parsableByteArray.setPosition(position);
                trackOutput.sampleData(parsableByteArray, i11);
                if (j11 != C.TIME_UNSET) {
                    trackOutput.sampleMetadata(j11, 1, i11, 0, (TrackOutput.CryptoData) null);
                }
            }
        }
    }

    private static int readNon255TerminatedValue(ParsableByteArray parsableByteArray) {
        int i11 = 0;
        while (parsableByteArray.bytesLeft() != 0) {
            int readUnsignedByte = parsableByteArray.readUnsignedByte();
            i11 += readUnsignedByte;
            if (readUnsignedByte != 255) {
                return i11;
            }
        }
        return -1;
    }
}
