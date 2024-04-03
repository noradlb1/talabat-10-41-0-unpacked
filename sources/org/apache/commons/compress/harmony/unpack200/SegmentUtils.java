package org.apache.commons.compress.harmony.unpack200;

import android.support.v4.media.session.PlaybackStateCompat;

public final class SegmentUtils {
    public static int countArgs(String str) {
        return countArgs(str, 1);
    }

    public static int countBit16(int[] iArr) {
        int i11 = 0;
        for (int i12 : iArr) {
            if ((i12 & 65536) != 0) {
                i11++;
            }
        }
        return i11;
    }

    public static int countInvokeInterfaceArgs(String str) {
        return countArgs(str, 2);
    }

    public static int countMatches(long[] jArr, IMatcher iMatcher) {
        int i11 = 0;
        for (long matches : jArr) {
            if (iMatcher.matches(matches)) {
                i11++;
            }
        }
        return i11;
    }

    public static int countArgs(String str, int i11) {
        int indexOf = str.indexOf(40);
        int indexOf2 = str.indexOf(41);
        if (indexOf == -1 || indexOf2 == -1 || indexOf2 < indexOf) {
            throw new IllegalArgumentException("No arguments");
        }
        int i12 = 0;
        boolean z11 = false;
        boolean z12 = false;
        for (int i13 = indexOf + 1; i13 < indexOf2; i13++) {
            char charAt = str.charAt(i13);
            if (z11 && charAt == ';') {
                z11 = false;
                z12 = false;
            } else if (!z11 && charAt == 'L') {
                i12++;
                z11 = true;
            } else if (charAt == '[') {
                z12 = true;
            } else if (!z11) {
                if (z12) {
                    i12++;
                    z12 = false;
                } else {
                    i12 = (charAt == 'D' || charAt == 'J') ? i12 + i11 : i12 + 1;
                }
            }
        }
        return i12;
    }

    public static int countBit16(long[] jArr) {
        int i11 = 0;
        for (long j11 : jArr) {
            if ((j11 & PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) != 0) {
                i11++;
            }
        }
        return i11;
    }

    public static int countMatches(long[][] jArr, IMatcher iMatcher) {
        int i11 = 0;
        for (long[] countMatches : jArr) {
            i11 += countMatches(countMatches, iMatcher);
        }
        return i11;
    }

    public static int countBit16(long[][] jArr) {
        int i11 = 0;
        for (long[] jArr2 : jArr) {
            int i12 = 0;
            while (true) {
                if (i12 >= jArr2.length) {
                    break;
                }
                if ((jArr2[i12] & PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) != 0) {
                    i11++;
                }
                i12++;
            }
        }
        return i11;
    }
}
