package com.google.android.exoplayer2.extractor.mp4;

import android.support.v4.media.session.PlaybackStateCompat;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.IOException;

final class Sniffer {
    public static final int BRAND_HEIC = 1751476579;
    public static final int BRAND_QUICKTIME = 1903435808;
    private static final int[] COMPATIBLE_BRANDS = {1769172845, 1769172786, 1769172787, 1769172788, 1769172789, 1769172790, 1769172793, Atom.TYPE_avc1, Atom.TYPE_hvc1, Atom.TYPE_hev1, Atom.TYPE_av01, 1836069937, 1836069938, 862401121, 862401122, 862417462, 862417718, 862414134, 862414646, 1295275552, 1295270176, 1714714144, 1801741417, 1295275600, BRAND_QUICKTIME, 1297305174, 1684175153, 1769172332, 1885955686};
    private static final int SEARCH_LENGTH = 4096;

    private Sniffer() {
    }

    private static boolean isCompatibleBrand(int i11, boolean z11) {
        if ((i11 >>> 8) == 3368816) {
            return true;
        }
        if (i11 == 1751476579 && z11) {
            return true;
        }
        for (int i12 : COMPATIBLE_BRANDS) {
            if (i12 == i11) {
                return true;
            }
        }
        return false;
    }

    public static boolean sniffFragmented(ExtractorInput extractorInput) throws IOException {
        return sniffInternal(extractorInput, true, false);
    }

    private static boolean sniffInternal(ExtractorInput extractorInput, boolean z11, boolean z12) throws IOException {
        boolean z13;
        boolean z14;
        boolean z15;
        int i11;
        boolean z16;
        ExtractorInput extractorInput2 = extractorInput;
        long length = extractorInput.getLength();
        long j11 = -1;
        int i12 = (length > -1 ? 1 : (length == -1 ? 0 : -1));
        long j12 = PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
        if (i12 != 0 && length <= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM) {
            j12 = length;
        }
        int i13 = (int) j12;
        ParsableByteArray parsableByteArray = new ParsableByteArray(64);
        boolean z17 = false;
        int i14 = 0;
        boolean z18 = false;
        while (true) {
            if (i14 >= i13) {
                break;
            }
            parsableByteArray.reset(8);
            if (!extractorInput2.peekFully(parsableByteArray.getData(), z17 ? 1 : 0, 8, true)) {
                break;
            }
            long readUnsignedInt = parsableByteArray.readUnsignedInt();
            int readInt = parsableByteArray.readInt();
            if (readUnsignedInt == 1) {
                extractorInput2.peekFully(parsableByteArray.getData(), 8, 8);
                parsableByteArray.setLimit(16);
                i11 = 16;
                readUnsignedInt = parsableByteArray.readLong();
            } else {
                if (readUnsignedInt == 0) {
                    long length2 = extractorInput.getLength();
                    if (length2 != j11) {
                        readUnsignedInt = (length2 - extractorInput.getPeekPosition()) + ((long) 8);
                    }
                }
                i11 = 8;
            }
            long j13 = (long) i11;
            if (readUnsignedInt < j13) {
                return z17;
            }
            i14 += i11;
            if (readInt == 1836019574) {
                i13 += (int) readUnsignedInt;
                if (i12 != 0 && ((long) i13) > length) {
                    i13 = (int) length;
                }
            } else if (readInt == 1836019558 || readInt == 1836475768) {
                z14 = z17;
                z13 = true;
                z15 = true;
            } else {
                int i15 = i12;
                int i16 = i14;
                if ((((long) i14) + readUnsignedInt) - j13 >= ((long) i13)) {
                    z14 = false;
                    z13 = true;
                    break;
                }
                int i17 = (int) (readUnsignedInt - j13);
                i14 = i16 + i17;
                if (readInt != 1718909296) {
                    boolean z19 = z12;
                    z16 = false;
                    if (i17 != 0) {
                        extractorInput2.advancePeekPosition(i17);
                    }
                } else if (i17 < 8) {
                    return false;
                } else {
                    parsableByteArray.reset(i17);
                    extractorInput2.peekFully(parsableByteArray.getData(), 0, i17);
                    int i18 = i17 / 4;
                    int i19 = 0;
                    while (true) {
                        if (i19 >= i18) {
                            boolean z21 = z12;
                            break;
                        }
                        if (i19 == 1) {
                            parsableByteArray.skipBytes(4);
                            boolean z22 = z12;
                        } else if (isCompatibleBrand(parsableByteArray.readInt(), z12)) {
                            z18 = true;
                            break;
                        }
                        i19++;
                    }
                    if (!z18) {
                        return false;
                    }
                    z16 = false;
                }
                z17 = z16;
                i12 = i15;
            }
            j11 = -1;
        }
        z14 = z17;
        z13 = true;
        z15 = z14;
        if (!z18 || z11 != z15) {
            return z14;
        }
        return z13;
    }

    public static boolean sniffUnfragmented(ExtractorInput extractorInput) throws IOException {
        return sniffInternal(extractorInput, false, false);
    }

    public static boolean sniffUnfragmented(ExtractorInput extractorInput, boolean z11) throws IOException {
        return sniffInternal(extractorInput, false, z11);
    }
}
