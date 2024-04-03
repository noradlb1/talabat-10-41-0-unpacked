package okio.internal;

import com.facebook.internal.NativeProtocol;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.ByteString;
import okio.Segment;
import okio.SegmentedByteString;
import okio._UtilKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a$\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0000\u001a-\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0001H\b\u001a\u0017\u0010\u000e\u001a\u00020\u000f*\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\b\u001a\r\u0010\u0012\u001a\u00020\u0001*\u00020\bH\b\u001a\r\u0010\u0013\u001a\u00020\u0001*\u00020\bH\b\u001a\u0015\u0010\u0014\u001a\u00020\u0015*\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0001H\b\u001a-\u0010\u0017\u001a\u00020\u000f*\u00020\b2\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0001H\b\u001a-\u0010\u0017\u001a\u00020\u000f*\u00020\b2\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0001H\b\u001a\u001d\u0010\u001a\u001a\u00020\u0019*\u00020\b2\u0006\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u0001H\b\u001a\r\u0010\u001d\u001a\u00020\u000b*\u00020\bH\b\u001a%\u0010\u001e\u001a\u00020\u0007*\u00020\b2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0001H\b\u001a]\u0010!\u001a\u00020\u0007*\u00020\b2K\u0010\"\u001aG\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00070#H\bø\u0001\u0000\u001aj\u0010!\u001a\u00020\u0007*\u00020\b2\u0006\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u00012K\u0010\"\u001aG\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00070#H\b\u001a\u0014\u0010'\u001a\u00020\u0001*\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0001H\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006("}, d2 = {"binarySearch", "", "", "value", "fromIndex", "toIndex", "commonCopyInto", "", "Lokio/SegmentedByteString;", "offset", "target", "", "targetOffset", "byteCount", "commonEquals", "", "other", "", "commonGetSize", "commonHashCode", "commonInternalGet", "", "pos", "commonRangeEquals", "otherOffset", "Lokio/ByteString;", "commonSubstring", "beginIndex", "endIndex", "commonToByteArray", "commonWrite", "buffer", "Lokio/Buffer;", "forEachSegment", "action", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "data", "segment", "okio"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class _SegmentedByteStringKt {
    public static final int binarySearch(@NotNull int[] iArr, int i11, int i12, int i13) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        int i14 = i13 - 1;
        while (i12 <= i14) {
            int i15 = (i12 + i14) >>> 1;
            int i16 = iArr[i15];
            if (i16 < i11) {
                i12 = i15 + 1;
            } else if (i16 <= i11) {
                return i15;
            } else {
                i14 = i15 - 1;
            }
        }
        return (-i12) - 1;
    }

    public static final void commonCopyInto(@NotNull SegmentedByteString segmentedByteString, int i11, @NotNull byte[] bArr, int i12, int i13) {
        int i14;
        Intrinsics.checkNotNullParameter(segmentedByteString, "<this>");
        Intrinsics.checkNotNullParameter(bArr, "target");
        long j11 = (long) i13;
        _UtilKt.checkOffsetAndCount((long) segmentedByteString.size(), (long) i11, j11);
        _UtilKt.checkOffsetAndCount((long) bArr.length, (long) i12, j11);
        int i15 = i13 + i11;
        int segment = segment(segmentedByteString, i11);
        while (i11 < i15) {
            if (segment == 0) {
                i14 = 0;
            } else {
                i14 = segmentedByteString.getDirectory$okio()[segment - 1];
            }
            int i16 = segmentedByteString.getDirectory$okio()[segmentedByteString.getSegments$okio().length + segment];
            int min = Math.min(i15, (segmentedByteString.getDirectory$okio()[segment] - i14) + i14) - i11;
            int i17 = i16 + (i11 - i14);
            byte[] unused = ArraysKt___ArraysJvmKt.copyInto(segmentedByteString.getSegments$okio()[segment], bArr, i12, i17, i17 + min);
            i12 += min;
            i11 += min;
            segment++;
        }
    }

    public static final boolean commonEquals(@NotNull SegmentedByteString segmentedByteString, @Nullable Object obj) {
        Intrinsics.checkNotNullParameter(segmentedByteString, "<this>");
        if (obj == segmentedByteString) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            if (byteString.size() == segmentedByteString.size() && segmentedByteString.rangeEquals(0, byteString, 0, segmentedByteString.size())) {
                return true;
            }
        }
        return false;
    }

    public static final int commonGetSize(@NotNull SegmentedByteString segmentedByteString) {
        Intrinsics.checkNotNullParameter(segmentedByteString, "<this>");
        return segmentedByteString.getDirectory$okio()[segmentedByteString.getSegments$okio().length - 1];
    }

    public static final int commonHashCode(@NotNull SegmentedByteString segmentedByteString) {
        Intrinsics.checkNotNullParameter(segmentedByteString, "<this>");
        int hashCode$okio = segmentedByteString.getHashCode$okio();
        if (hashCode$okio != 0) {
            return hashCode$okio;
        }
        int length = segmentedByteString.getSegments$okio().length;
        int i11 = 0;
        int i12 = 1;
        int i13 = 0;
        while (i11 < length) {
            int i14 = segmentedByteString.getDirectory$okio()[length + i11];
            int i15 = segmentedByteString.getDirectory$okio()[i11];
            byte[] bArr = segmentedByteString.getSegments$okio()[i11];
            int i16 = (i15 - i13) + i14;
            while (i14 < i16) {
                i12 = (i12 * 31) + bArr[i14];
                i14++;
            }
            i11++;
            i13 = i15;
        }
        segmentedByteString.setHashCode$okio(i12);
        return i12;
    }

    public static final byte commonInternalGet(@NotNull SegmentedByteString segmentedByteString, int i11) {
        int i12;
        Intrinsics.checkNotNullParameter(segmentedByteString, "<this>");
        _UtilKt.checkOffsetAndCount((long) segmentedByteString.getDirectory$okio()[segmentedByteString.getSegments$okio().length - 1], (long) i11, 1);
        int segment = segment(segmentedByteString, i11);
        if (segment == 0) {
            i12 = 0;
        } else {
            i12 = segmentedByteString.getDirectory$okio()[segment - 1];
        }
        return segmentedByteString.getSegments$okio()[segment][(i11 - i12) + segmentedByteString.getDirectory$okio()[segmentedByteString.getSegments$okio().length + segment]];
    }

    public static final boolean commonRangeEquals(@NotNull SegmentedByteString segmentedByteString, int i11, @NotNull ByteString byteString, int i12, int i13) {
        int i14;
        Intrinsics.checkNotNullParameter(segmentedByteString, "<this>");
        Intrinsics.checkNotNullParameter(byteString, "other");
        if (i11 < 0 || i11 > segmentedByteString.size() - i13) {
            return false;
        }
        int i15 = i13 + i11;
        int segment = segment(segmentedByteString, i11);
        while (i11 < i15) {
            if (segment == 0) {
                i14 = 0;
            } else {
                i14 = segmentedByteString.getDirectory$okio()[segment - 1];
            }
            int i16 = segmentedByteString.getDirectory$okio()[segmentedByteString.getSegments$okio().length + segment];
            int min = Math.min(i15, (segmentedByteString.getDirectory$okio()[segment] - i14) + i14) - i11;
            if (!byteString.rangeEquals(i12, segmentedByteString.getSegments$okio()[segment], i16 + (i11 - i14), min)) {
                return false;
            }
            i12 += min;
            i11 += min;
            segment++;
        }
        return true;
    }

    @NotNull
    public static final ByteString commonSubstring(@NotNull SegmentedByteString segmentedByteString, int i11, int i12) {
        boolean z11;
        boolean z12;
        boolean z13;
        Intrinsics.checkNotNullParameter(segmentedByteString, "<this>");
        int resolveDefaultParameter = _UtilKt.resolveDefaultParameter(segmentedByteString, i12);
        int i13 = 0;
        if (i11 >= 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            if (resolveDefaultParameter <= segmentedByteString.size()) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (z12) {
                int i14 = resolveDefaultParameter - i11;
                if (i14 >= 0) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                if (!z13) {
                    throw new IllegalArgumentException(("endIndex=" + resolveDefaultParameter + " < beginIndex=" + i11).toString());
                } else if (i11 == 0 && resolveDefaultParameter == segmentedByteString.size()) {
                    return segmentedByteString;
                } else {
                    if (i11 == resolveDefaultParameter) {
                        return ByteString.EMPTY;
                    }
                    int segment = segment(segmentedByteString, i11);
                    int segment2 = segment(segmentedByteString, resolveDefaultParameter - 1);
                    byte[][] bArr = (byte[][]) ArraysKt___ArraysJvmKt.copyOfRange((T[]) segmentedByteString.getSegments$okio(), segment, segment2 + 1);
                    int[] iArr = new int[(bArr.length * 2)];
                    if (segment <= segment2) {
                        int i15 = 0;
                        int i16 = segment;
                        while (true) {
                            int i17 = i16 + 1;
                            iArr[i15] = Math.min(segmentedByteString.getDirectory$okio()[i16] - i11, i14);
                            int i18 = i15 + 1;
                            iArr[i15 + bArr.length] = segmentedByteString.getDirectory$okio()[segmentedByteString.getSegments$okio().length + i16];
                            if (i16 == segment2) {
                                break;
                            }
                            i16 = i17;
                            i15 = i18;
                        }
                    }
                    if (segment != 0) {
                        i13 = segmentedByteString.getDirectory$okio()[segment - 1];
                    }
                    int length = bArr.length;
                    iArr[length] = iArr[length] + (i11 - i13);
                    return new SegmentedByteString(bArr, iArr);
                }
            } else {
                throw new IllegalArgumentException(("endIndex=" + resolveDefaultParameter + " > length(" + segmentedByteString.size() + ')').toString());
            }
        } else {
            throw new IllegalArgumentException(("beginIndex=" + i11 + " < 0").toString());
        }
    }

    @NotNull
    public static final byte[] commonToByteArray(@NotNull SegmentedByteString segmentedByteString) {
        Intrinsics.checkNotNullParameter(segmentedByteString, "<this>");
        byte[] bArr = new byte[segmentedByteString.size()];
        int length = segmentedByteString.getSegments$okio().length;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (i11 < length) {
            int i14 = segmentedByteString.getDirectory$okio()[length + i11];
            int i15 = segmentedByteString.getDirectory$okio()[i11];
            int i16 = i15 - i12;
            byte[] unused = ArraysKt___ArraysJvmKt.copyInto(segmentedByteString.getSegments$okio()[i11], bArr, i13, i14, i14 + i16);
            i13 += i16;
            i11++;
            i12 = i15;
        }
        return bArr;
    }

    public static final void commonWrite(@NotNull SegmentedByteString segmentedByteString, @NotNull Buffer buffer, int i11, int i12) {
        int i13;
        Intrinsics.checkNotNullParameter(segmentedByteString, "<this>");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        int i14 = i11 + i12;
        int segment = segment(segmentedByteString, i11);
        while (i11 < i14) {
            if (segment == 0) {
                i13 = 0;
            } else {
                i13 = segmentedByteString.getDirectory$okio()[segment - 1];
            }
            int i15 = segmentedByteString.getDirectory$okio()[segmentedByteString.getSegments$okio().length + segment];
            int min = Math.min(i14, (segmentedByteString.getDirectory$okio()[segment] - i13) + i13) - i11;
            int i16 = i15 + (i11 - i13);
            Segment segment2 = new Segment(segmentedByteString.getSegments$okio()[segment], i16, i16 + min, true, false);
            Segment segment3 = buffer.head;
            if (segment3 == null) {
                segment2.prev = segment2;
                segment2.next = segment2;
                buffer.head = segment2;
            } else {
                Intrinsics.checkNotNull(segment3);
                Segment segment4 = segment3.prev;
                Intrinsics.checkNotNull(segment4);
                segment4.push(segment2);
            }
            i11 += min;
            segment++;
        }
        buffer.setSize$okio(buffer.size() + ((long) i12));
    }

    public static final void forEachSegment(@NotNull SegmentedByteString segmentedByteString, @NotNull Function3<? super byte[], ? super Integer, ? super Integer, Unit> function3) {
        Intrinsics.checkNotNullParameter(segmentedByteString, "<this>");
        Intrinsics.checkNotNullParameter(function3, NativeProtocol.WEB_DIALOG_ACTION);
        int length = segmentedByteString.getSegments$okio().length;
        int i11 = 0;
        int i12 = 0;
        while (i11 < length) {
            int i13 = segmentedByteString.getDirectory$okio()[length + i11];
            int i14 = segmentedByteString.getDirectory$okio()[i11];
            function3.invoke(segmentedByteString.getSegments$okio()[i11], Integer.valueOf(i13), Integer.valueOf(i14 - i12));
            i11++;
            i12 = i14;
        }
    }

    public static final int segment(@NotNull SegmentedByteString segmentedByteString, int i11) {
        Intrinsics.checkNotNullParameter(segmentedByteString, "<this>");
        int binarySearch = binarySearch(segmentedByteString.getDirectory$okio(), i11 + 1, 0, segmentedByteString.getSegments$okio().length);
        if (binarySearch >= 0) {
            return binarySearch;
        }
        return ~binarySearch;
    }

    private static final void forEachSegment(SegmentedByteString segmentedByteString, int i11, int i12, Function3<? super byte[], ? super Integer, ? super Integer, Unit> function3) {
        int i13;
        int segment = segment(segmentedByteString, i11);
        while (i11 < i12) {
            if (segment == 0) {
                i13 = 0;
            } else {
                i13 = segmentedByteString.getDirectory$okio()[segment - 1];
            }
            int i14 = segmentedByteString.getDirectory$okio()[segmentedByteString.getSegments$okio().length + segment];
            int min = Math.min(i12, (segmentedByteString.getDirectory$okio()[segment] - i13) + i13) - i11;
            function3.invoke(segmentedByteString.getSegments$okio()[segment], Integer.valueOf(i14 + (i11 - i13)), Integer.valueOf(min));
            i11 += min;
            segment++;
        }
    }

    public static final boolean commonRangeEquals(@NotNull SegmentedByteString segmentedByteString, int i11, @NotNull byte[] bArr, int i12, int i13) {
        int i14;
        Intrinsics.checkNotNullParameter(segmentedByteString, "<this>");
        Intrinsics.checkNotNullParameter(bArr, "other");
        if (i11 < 0 || i11 > segmentedByteString.size() - i13 || i12 < 0 || i12 > bArr.length - i13) {
            return false;
        }
        int i15 = i13 + i11;
        int segment = segment(segmentedByteString, i11);
        while (i11 < i15) {
            if (segment == 0) {
                i14 = 0;
            } else {
                i14 = segmentedByteString.getDirectory$okio()[segment - 1];
            }
            int i16 = segmentedByteString.getDirectory$okio()[segmentedByteString.getSegments$okio().length + segment];
            int min = Math.min(i15, (segmentedByteString.getDirectory$okio()[segment] - i14) + i14) - i11;
            if (!_UtilKt.arrayRangeEquals(segmentedByteString.getSegments$okio()[segment], i16 + (i11 - i14), bArr, i12, min)) {
                return false;
            }
            i12 += min;
            i11 += min;
            segment++;
        }
        return true;
    }
}
