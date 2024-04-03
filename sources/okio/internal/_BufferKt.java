package okio.internal;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import com.google.common.base.Ascii;
import java.io.EOFException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import okhttp3.internal.connection.RealConnection;
import okio.Buffer;
import okio.ByteString;
import okio.Options;
import okio.Segment;
import okio.SegmentPool;
import okio.SegmentedByteString;
import okio.Sink;
import okio.Source;
import okio.Utf8;
import okio._JvmPlatformKt;
import okio._UtilKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a0\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\nH\u0000\u001a\r\u0010\u0013\u001a\u00020\u0014*\u00020\u0015H\b\u001a\r\u0010\u0016\u001a\u00020\u0014*\u00020\u0017H\b\u001a\r\u0010\u0018\u001a\u00020\u0007*\u00020\u0015H\b\u001a\r\u0010\u0019\u001a\u00020\u0015*\u00020\u0015H\b\u001a%\u0010\u001a\u001a\u00020\u0015*\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0007H\b\u001a\u0017\u0010\u001e\u001a\u00020\f*\u00020\u00152\b\u0010\u001f\u001a\u0004\u0018\u00010 H\b\u001a\u0015\u0010!\u001a\u00020\u0007*\u00020\u00172\u0006\u0010\"\u001a\u00020\nH\b\u001a\u0015\u0010#\u001a\u00020$*\u00020\u00152\u0006\u0010%\u001a\u00020\u0007H\b\u001a\r\u0010&\u001a\u00020\n*\u00020\u0015H\b\u001a%\u0010'\u001a\u00020\u0007*\u00020\u00152\u0006\u0010(\u001a\u00020$2\u0006\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u0007H\b\u001a\u001d\u0010'\u001a\u00020\u0007*\u00020\u00152\u0006\u0010\u0010\u001a\u00020+2\u0006\u0010)\u001a\u00020\u0007H\b\u001a\u001d\u0010,\u001a\u00020\u0007*\u00020\u00152\u0006\u0010-\u001a\u00020+2\u0006\u0010)\u001a\u00020\u0007H\b\u001a\r\u0010.\u001a\u00020\n*\u00020\u0017H\b\u001a-\u0010/\u001a\u00020\f*\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020+2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\nH\b\u001a\u0015\u00100\u001a\u00020\n*\u00020\u00152\u0006\u00101\u001a\u00020\u0001H\b\u001a%\u00100\u001a\u00020\n*\u00020\u00152\u0006\u00101\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\nH\b\u001a\u001d\u00100\u001a\u00020\u0007*\u00020\u00152\u0006\u00101\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u0007H\b\u001a\u0015\u00102\u001a\u00020\u0007*\u00020\u00152\u0006\u00101\u001a\u000203H\b\u001a\u0014\u00104\u001a\u00020\u0017*\u00020\u00152\u0006\u00105\u001a\u00020\u0017H\u0000\u001a\r\u00106\u001a\u00020$*\u00020\u0015H\b\u001a\r\u00107\u001a\u00020\u0001*\u00020\u0015H\b\u001a\u0015\u00107\u001a\u00020\u0001*\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u0007H\b\u001a\r\u00108\u001a\u00020+*\u00020\u0015H\b\u001a\u0015\u00108\u001a\u00020+*\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u0007H\b\u001a\r\u00109\u001a\u00020\u0007*\u00020\u0015H\b\u001a\u0015\u0010:\u001a\u00020\u0014*\u00020\u00152\u0006\u00101\u001a\u00020\u0001H\b\u001a\u001d\u0010:\u001a\u00020\u0014*\u00020\u00152\u0006\u00101\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u0007H\b\u001a\r\u0010;\u001a\u00020\u0007*\u00020\u0015H\b\u001a\r\u0010<\u001a\u00020\n*\u00020\u0015H\b\u001a\r\u0010=\u001a\u00020\u0007*\u00020\u0015H\b\u001a\r\u0010>\u001a\u00020?*\u00020\u0015H\b\u001a\u0014\u0010@\u001a\u00020\u0017*\u00020\u00152\u0006\u00105\u001a\u00020\u0017H\u0000\u001a\u0015\u0010A\u001a\u00020B*\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u0007H\b\u001a\r\u0010C\u001a\u00020\n*\u00020\u0015H\b\u001a\u000f\u0010D\u001a\u0004\u0018\u00010B*\u00020\u0015H\b\u001a\u0015\u0010E\u001a\u00020B*\u00020\u00152\u0006\u0010F\u001a\u00020\u0007H\b\u001a\u0015\u0010G\u001a\u00020\u0007*\u00020\u00172\u0006\u0010H\u001a\u00020\u0007H\b\u001a\u0015\u0010I\u001a\u00020\n*\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u0007H\b\u001a\u0015\u0010J\u001a\u00020\n*\u00020\u00152\u0006\u0010K\u001a\u00020LH\b\u001a\u0015\u0010M\u001a\u00020\u0014*\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u0007H\b\u001a\r\u0010N\u001a\u00020+*\u00020\u0015H\b\u001a\u0015\u0010N\u001a\u00020+*\u00020\u00152\u0006\u0010\u001d\u001a\u00020\nH\b\u001a\u0015\u0010O\u001a\u00020\u000e*\u00020\u00152\u0006\u0010P\u001a\u00020\nH\b\u001a\u0015\u0010Q\u001a\u00020\u0015*\u00020\u00152\u0006\u0010R\u001a\u00020\u0001H\b\u001a%\u0010Q\u001a\u00020\u0015*\u00020\u00152\u0006\u0010R\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\nH\b\u001a\u001d\u0010Q\u001a\u00020\u0014*\u00020\u00152\u0006\u0010R\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u0007H\b\u001a)\u0010Q\u001a\u00020\u0015*\u00020\u00152\u0006\u0010S\u001a\u00020+2\b\b\u0002\u0010\u001c\u001a\u00020\n2\b\b\u0002\u0010\u001d\u001a\u00020\nH\b\u001a\u001d\u0010Q\u001a\u00020\u0015*\u00020\u00152\u0006\u0010R\u001a\u00020T2\u0006\u0010\u001d\u001a\u00020\u0007H\b\u001a\u0015\u0010U\u001a\u00020\u0007*\u00020\u00152\u0006\u0010R\u001a\u00020TH\b\u001a\u0015\u0010V\u001a\u00020\u0015*\u00020\u00152\u0006\u0010(\u001a\u00020\nH\b\u001a\u0015\u0010W\u001a\u00020\u0015*\u00020\u00152\u0006\u0010X\u001a\u00020\u0007H\b\u001a\u0015\u0010Y\u001a\u00020\u0015*\u00020\u00152\u0006\u0010X\u001a\u00020\u0007H\b\u001a\u0015\u0010Z\u001a\u00020\u0015*\u00020\u00152\u0006\u0010[\u001a\u00020\nH\b\u001a\u0015\u0010\\\u001a\u00020\u0015*\u00020\u00152\u0006\u0010X\u001a\u00020\u0007H\b\u001a\u0015\u0010]\u001a\u00020\u0015*\u00020\u00152\u0006\u0010^\u001a\u00020\nH\b\u001a%\u0010_\u001a\u00020\u0015*\u00020\u00152\u0006\u0010`\u001a\u00020B2\u0006\u0010a\u001a\u00020\n2\u0006\u0010b\u001a\u00020\nH\b\u001a\u0015\u0010c\u001a\u00020\u0015*\u00020\u00152\u0006\u0010d\u001a\u00020\nH\b\u001a\u0014\u0010e\u001a\u00020B*\u00020\u00152\u0006\u0010f\u001a\u00020\u0007H\u0000\u001a?\u0010g\u001a\u0002Hh\"\u0004\b\u0000\u0010h*\u00020\u00152\u0006\u0010)\u001a\u00020\u00072\u001a\u0010i\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u0002Hh0jH\bø\u0001\u0000¢\u0006\u0002\u0010k\u001a\u001e\u0010l\u001a\u00020\n*\u00020\u00152\u0006\u0010K\u001a\u00020L2\b\b\u0002\u0010m\u001a\u00020\fH\u0000\"\u001c\u0010\u0000\u001a\u00020\u00018\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006n"}, d2 = {"HEX_DIGIT_BYTES", "", "getHEX_DIGIT_BYTES$annotations", "()V", "getHEX_DIGIT_BYTES", "()[B", "OVERFLOW_DIGIT_START", "", "OVERFLOW_ZONE", "SEGMENTING_THRESHOLD", "", "rangeEquals", "", "segment", "Lokio/Segment;", "segmentPos", "bytes", "bytesOffset", "bytesLimit", "commonClear", "", "Lokio/Buffer;", "commonClose", "Lokio/Buffer$UnsafeCursor;", "commonCompleteSegmentByteCount", "commonCopy", "commonCopyTo", "out", "offset", "byteCount", "commonEquals", "other", "", "commonExpandBuffer", "minByteCount", "commonGet", "", "pos", "commonHashCode", "commonIndexOf", "b", "fromIndex", "toIndex", "Lokio/ByteString;", "commonIndexOfElement", "targetBytes", "commonNext", "commonRangeEquals", "commonRead", "sink", "commonReadAll", "Lokio/Sink;", "commonReadAndWriteUnsafe", "unsafeCursor", "commonReadByte", "commonReadByteArray", "commonReadByteString", "commonReadDecimalLong", "commonReadFully", "commonReadHexadecimalUnsignedLong", "commonReadInt", "commonReadLong", "commonReadShort", "", "commonReadUnsafe", "commonReadUtf8", "", "commonReadUtf8CodePoint", "commonReadUtf8Line", "commonReadUtf8LineStrict", "limit", "commonResizeBuffer", "newSize", "commonSeek", "commonSelect", "options", "Lokio/Options;", "commonSkip", "commonSnapshot", "commonWritableSegment", "minimumCapacity", "commonWrite", "source", "byteString", "Lokio/Source;", "commonWriteAll", "commonWriteByte", "commonWriteDecimalLong", "v", "commonWriteHexadecimalUnsignedLong", "commonWriteInt", "i", "commonWriteLong", "commonWriteShort", "s", "commonWriteUtf8", "string", "beginIndex", "endIndex", "commonWriteUtf8CodePoint", "codePoint", "readUtf8Line", "newline", "seek", "T", "lambda", "Lkotlin/Function2;", "(Lokio/Buffer;JLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "selectPrefix", "selectTruncated", "okio"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class _BufferKt {
    @NotNull
    private static final byte[] HEX_DIGIT_BYTES = _JvmPlatformKt.asUtf8ToByteArray("0123456789abcdef");
    public static final long OVERFLOW_DIGIT_START = -7;
    public static final long OVERFLOW_ZONE = -922337203685477580L;
    public static final int SEGMENTING_THRESHOLD = 4096;

    public static final void commonClear(@NotNull Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        buffer.skip(buffer.size());
    }

    public static final void commonClose(@NotNull Buffer.UnsafeCursor unsafeCursor) {
        boolean z11;
        Intrinsics.checkNotNullParameter(unsafeCursor, "<this>");
        if (unsafeCursor.buffer != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            unsafeCursor.buffer = null;
            unsafeCursor.setSegment$okio((Segment) null);
            unsafeCursor.offset = -1;
            unsafeCursor.data = null;
            unsafeCursor.start = -1;
            unsafeCursor.end = -1;
            return;
        }
        throw new IllegalStateException("not attached to a buffer".toString());
    }

    public static final long commonCompleteSegmentByteCount(@NotNull Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        long size = buffer.size();
        if (size == 0) {
            return 0;
        }
        Segment segment = buffer.head;
        Intrinsics.checkNotNull(segment);
        Segment segment2 = segment.prev;
        Intrinsics.checkNotNull(segment2);
        int i11 = segment2.limit;
        if (i11 >= 8192 || !segment2.owner) {
            return size;
        }
        return size - ((long) (i11 - segment2.pos));
    }

    @NotNull
    public static final Buffer commonCopy(@NotNull Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Buffer buffer2 = new Buffer();
        if (buffer.size() == 0) {
            return buffer2;
        }
        Segment segment = buffer.head;
        Intrinsics.checkNotNull(segment);
        Segment sharedCopy = segment.sharedCopy();
        buffer2.head = sharedCopy;
        sharedCopy.prev = sharedCopy;
        sharedCopy.next = sharedCopy;
        for (Segment segment2 = segment.next; segment2 != segment; segment2 = segment2.next) {
            Segment segment3 = sharedCopy.prev;
            Intrinsics.checkNotNull(segment3);
            Intrinsics.checkNotNull(segment2);
            segment3.push(segment2.sharedCopy());
        }
        buffer2.setSize$okio(buffer.size());
        return buffer2;
    }

    @NotNull
    public static final Buffer commonCopyTo(@NotNull Buffer buffer, @NotNull Buffer buffer2, long j11, long j12) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(buffer2, "out");
        _UtilKt.checkOffsetAndCount(buffer.size(), j11, j12);
        if (j12 == 0) {
            return buffer;
        }
        buffer2.setSize$okio(buffer2.size() + j12);
        Segment segment = buffer.head;
        while (true) {
            Intrinsics.checkNotNull(segment);
            int i11 = segment.limit;
            int i12 = segment.pos;
            if (j11 < ((long) (i11 - i12))) {
                break;
            }
            j11 -= (long) (i11 - i12);
            segment = segment.next;
        }
        while (j12 > 0) {
            Intrinsics.checkNotNull(segment);
            Segment sharedCopy = segment.sharedCopy();
            int i13 = sharedCopy.pos + ((int) j11);
            sharedCopy.pos = i13;
            sharedCopy.limit = Math.min(i13 + ((int) j12), sharedCopy.limit);
            Segment segment2 = buffer2.head;
            if (segment2 == null) {
                sharedCopy.prev = sharedCopy;
                sharedCopy.next = sharedCopy;
                buffer2.head = sharedCopy;
            } else {
                Intrinsics.checkNotNull(segment2);
                Segment segment3 = segment2.prev;
                Intrinsics.checkNotNull(segment3);
                segment3.push(sharedCopy);
            }
            j12 -= (long) (sharedCopy.limit - sharedCopy.pos);
            segment = segment.next;
            j11 = 0;
        }
        return buffer;
    }

    /* JADX WARNING: type inference failed for: r19v0, types: [java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean commonEquals(@org.jetbrains.annotations.NotNull okio.Buffer r18, @org.jetbrains.annotations.Nullable java.lang.Object r19) {
        /*
            r0 = r18
            r1 = r19
            java.lang.String r2 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r2)
            r2 = 1
            if (r0 != r1) goto L_0x000d
            return r2
        L_0x000d:
            boolean r3 = r1 instanceof okio.Buffer
            r4 = 0
            if (r3 != 0) goto L_0x0013
            return r4
        L_0x0013:
            long r5 = r18.size()
            okio.Buffer r1 = (okio.Buffer) r1
            long r7 = r1.size()
            int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r3 == 0) goto L_0x0022
            return r4
        L_0x0022:
            long r5 = r18.size()
            r7 = 0
            int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r3 != 0) goto L_0x002d
            return r2
        L_0x002d:
            okio.Segment r3 = r0.head
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            okio.Segment r1 = r1.head
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            int r5 = r3.pos
            int r6 = r1.pos
            r9 = r7
        L_0x003c:
            long r11 = r18.size()
            int r11 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r11 >= 0) goto L_0x008c
            int r11 = r3.limit
            int r11 = r11 - r5
            int r12 = r1.limit
            int r12 = r12 - r6
            int r11 = java.lang.Math.min(r11, r12)
            long r11 = (long) r11
            int r13 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r13 >= 0) goto L_0x0074
            r13 = r7
        L_0x0054:
            r15 = 1
            long r13 = r13 + r15
            byte[] r15 = r3.data
            int r16 = r5 + 1
            byte r5 = r15[r5]
            byte[] r15 = r1.data
            int r17 = r6 + 1
            byte r6 = r15[r6]
            if (r5 == r6) goto L_0x0066
            return r4
        L_0x0066:
            int r5 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r5 < 0) goto L_0x006f
            r5 = r16
            r6 = r17
            goto L_0x0074
        L_0x006f:
            r5 = r16
            r6 = r17
            goto L_0x0054
        L_0x0074:
            int r13 = r3.limit
            if (r5 != r13) goto L_0x007f
            okio.Segment r3 = r3.next
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            int r5 = r3.pos
        L_0x007f:
            int r13 = r1.limit
            if (r6 != r13) goto L_0x008a
            okio.Segment r1 = r1.next
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            int r6 = r1.pos
        L_0x008a:
            long r9 = r9 + r11
            goto L_0x003c
        L_0x008c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal._BufferKt.commonEquals(okio.Buffer, java.lang.Object):boolean");
    }

    public static final long commonExpandBuffer(@NotNull Buffer.UnsafeCursor unsafeCursor, int i11) {
        boolean z11;
        Intrinsics.checkNotNullParameter(unsafeCursor, "<this>");
        boolean z12 = true;
        if (i11 > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            if (i11 > 8192) {
                z12 = false;
            }
            if (z12) {
                Buffer buffer = unsafeCursor.buffer;
                if (buffer == null) {
                    throw new IllegalStateException("not attached to a buffer".toString());
                } else if (unsafeCursor.readWrite) {
                    long size = buffer.size();
                    Segment writableSegment$okio = buffer.writableSegment$okio(i11);
                    int i12 = 8192 - writableSegment$okio.limit;
                    writableSegment$okio.limit = 8192;
                    long j11 = (long) i12;
                    buffer.setSize$okio(size + j11);
                    unsafeCursor.setSegment$okio(writableSegment$okio);
                    unsafeCursor.offset = size;
                    unsafeCursor.data = writableSegment$okio.data;
                    unsafeCursor.start = 8192 - i12;
                    unsafeCursor.end = 8192;
                    return j11;
                } else {
                    throw new IllegalStateException("expandBuffer() only permitted for read/write buffers".toString());
                }
            } else {
                throw new IllegalArgumentException(Intrinsics.stringPlus("minByteCount > Segment.SIZE: ", Integer.valueOf(i11)).toString());
            }
        } else {
            throw new IllegalArgumentException(Intrinsics.stringPlus("minByteCount <= 0: ", Integer.valueOf(i11)).toString());
        }
    }

    public static final byte commonGet(@NotNull Buffer buffer, long j11) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        _UtilKt.checkOffsetAndCount(buffer.size(), j11, 1);
        Segment segment = buffer.head;
        if (segment == null) {
            Intrinsics.checkNotNull((Object) null);
            throw null;
        } else if (buffer.size() - j11 < j11) {
            long size = buffer.size();
            while (size > j11) {
                segment = segment.prev;
                Intrinsics.checkNotNull(segment);
                size -= (long) (segment.limit - segment.pos);
            }
            Intrinsics.checkNotNull(segment);
            return segment.data[(int) ((((long) segment.pos) + j11) - size)];
        } else {
            long j12 = 0;
            while (true) {
                long j13 = ((long) (segment.limit - segment.pos)) + j12;
                if (j13 > j11) {
                    Intrinsics.checkNotNull(segment);
                    return segment.data[(int) ((((long) segment.pos) + j11) - j12)];
                }
                segment = segment.next;
                Intrinsics.checkNotNull(segment);
                j12 = j13;
            }
        }
    }

    public static final int commonHashCode(@NotNull Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Segment segment = buffer.head;
        if (segment == null) {
            return 0;
        }
        int i11 = 1;
        do {
            int i12 = segment.limit;
            for (int i13 = segment.pos; i13 < i12; i13++) {
                i11 = (i11 * 31) + segment.data[i13];
            }
            segment = segment.next;
            Intrinsics.checkNotNull(segment);
        } while (segment != buffer.head);
        return i11;
    }

    public static final long commonIndexOf(@NotNull Buffer buffer, byte b11, long j11, long j12) {
        Segment segment;
        long j13;
        int i11;
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        long j14 = 0;
        boolean z11 = false;
        if (0 <= j11 && j11 <= j12) {
            z11 = true;
        }
        if (z11) {
            if (j12 > buffer.size()) {
                j12 = buffer.size();
            }
            long j15 = j12;
            if (j11 == j15 || (segment = buffer.head) == null) {
                return -1;
            }
            if (buffer.size() - j11 < j11) {
                j13 = buffer.size();
                while (j13 > j11) {
                    segment = segment.prev;
                    Intrinsics.checkNotNull(segment);
                    j13 -= (long) (segment.limit - segment.pos);
                }
                while (j13 < j15) {
                    byte[] bArr = segment.data;
                    int min = (int) Math.min((long) segment.limit, (((long) segment.pos) + j15) - j13);
                    i11 = (int) ((((long) segment.pos) + j11) - j13);
                    while (i11 < min) {
                        if (bArr[i11] != b11) {
                            i11++;
                        }
                    }
                    j13 += (long) (segment.limit - segment.pos);
                    segment = segment.next;
                    Intrinsics.checkNotNull(segment);
                    j11 = j13;
                }
                return -1;
            }
            while (true) {
                long j16 = ((long) (segment.limit - segment.pos)) + j14;
                if (j16 > j11) {
                    break;
                }
                segment = segment.next;
                Intrinsics.checkNotNull(segment);
                j14 = j16;
            }
            while (j13 < j15) {
                byte[] bArr2 = segment.data;
                int min2 = (int) Math.min((long) segment.limit, (((long) segment.pos) + j15) - j13);
                int i12 = (int) ((((long) segment.pos) + j11) - j13);
                while (i11 < min2) {
                    if (bArr2[i11] != b11) {
                        i12 = i11 + 1;
                    }
                }
                j14 = j13 + ((long) (segment.limit - segment.pos));
                segment = segment.next;
                Intrinsics.checkNotNull(segment);
                j11 = j14;
            }
            return -1;
            return ((long) (i11 - segment.pos)) + j13;
        }
        throw new IllegalArgumentException(("size=" + buffer.size() + " fromIndex=" + j11 + " toIndex=" + j12).toString());
    }

    public static final long commonIndexOfElement(@NotNull Buffer buffer, @NotNull ByteString byteString, long j11) {
        boolean z11;
        long j12;
        int i11;
        int i12;
        int i13;
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(byteString, "targetBytes");
        long j13 = 0;
        if (j11 >= 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            Segment segment = buffer.head;
            if (segment == null) {
                return -1;
            }
            if (buffer.size() - j11 < j11) {
                j12 = buffer.size();
                while (j12 > j11) {
                    segment = segment.prev;
                    Intrinsics.checkNotNull(segment);
                    j12 -= (long) (segment.limit - segment.pos);
                }
                if (byteString.size() == 2) {
                    byte b11 = byteString.getByte(0);
                    byte b12 = byteString.getByte(1);
                    while (j12 < buffer.size()) {
                        byte[] bArr = segment.data;
                        i12 = (int) ((((long) segment.pos) + j11) - j12);
                        int i14 = segment.limit;
                        while (i12 < i14) {
                            byte b13 = bArr[i12];
                            if (!(b13 == b11 || b13 == b12)) {
                                i12++;
                            }
                        }
                        j12 += (long) (segment.limit - segment.pos);
                        segment = segment.next;
                        Intrinsics.checkNotNull(segment);
                        j11 = j12;
                    }
                } else {
                    byte[] internalArray$okio = byteString.internalArray$okio();
                    while (j12 < buffer.size()) {
                        byte[] bArr2 = segment.data;
                        i11 = (int) ((((long) segment.pos) + j11) - j12);
                        int i15 = segment.limit;
                        while (i11 < i15) {
                            byte b14 = bArr2[i11];
                            int length = internalArray$okio.length;
                            int i16 = 0;
                            while (i16 < length) {
                                byte b15 = internalArray$okio[i16];
                                i16++;
                                if (b14 == b15) {
                                    i13 = segment.pos;
                                    return ((long) (i12 - i13)) + j12;
                                }
                            }
                            i11++;
                        }
                        j12 += (long) (segment.limit - segment.pos);
                        segment = segment.next;
                        Intrinsics.checkNotNull(segment);
                        j11 = j12;
                    }
                }
                return -1;
            }
            while (true) {
                long j14 = ((long) (segment.limit - segment.pos)) + j13;
                if (j14 > j11) {
                    break;
                }
                segment = segment.next;
                Intrinsics.checkNotNull(segment);
                j13 = j14;
            }
            if (byteString.size() == 2) {
                byte b16 = byteString.getByte(0);
                byte b17 = byteString.getByte(1);
                while (j12 < buffer.size()) {
                    byte[] bArr3 = segment.data;
                    int i17 = (int) ((((long) segment.pos) + j11) - j12);
                    int i18 = segment.limit;
                    while (i12 < i18) {
                        byte b18 = bArr3[i12];
                        if (!(b18 == b16 || b18 == b17)) {
                            i17 = i12 + 1;
                        }
                    }
                    j13 = j12 + ((long) (segment.limit - segment.pos));
                    segment = segment.next;
                    Intrinsics.checkNotNull(segment);
                    j11 = j13;
                }
            } else {
                byte[] internalArray$okio2 = byteString.internalArray$okio();
                while (j12 < buffer.size()) {
                    byte[] bArr4 = segment.data;
                    int i19 = (int) ((((long) segment.pos) + j11) - j12);
                    int i21 = segment.limit;
                    while (i11 < i21) {
                        byte b19 = bArr4[i11];
                        int length2 = internalArray$okio2.length;
                        int i22 = 0;
                        while (i22 < length2) {
                            byte b21 = internalArray$okio2[i22];
                            i22++;
                            if (b19 == b21) {
                                i13 = segment.pos;
                                return ((long) (i12 - i13)) + j12;
                            }
                        }
                        i19 = i11 + 1;
                    }
                    j13 = j12 + ((long) (segment.limit - segment.pos));
                    segment = segment.next;
                    Intrinsics.checkNotNull(segment);
                    j11 = j13;
                }
            }
            return -1;
            i13 = segment.pos;
            return ((long) (i12 - i13)) + j12;
        }
        throw new IllegalArgumentException(Intrinsics.stringPlus("fromIndex < 0: ", Long.valueOf(j11)).toString());
    }

    public static final int commonNext(@NotNull Buffer.UnsafeCursor unsafeCursor) {
        boolean z11;
        long j11;
        Intrinsics.checkNotNullParameter(unsafeCursor, "<this>");
        long j12 = unsafeCursor.offset;
        Buffer buffer = unsafeCursor.buffer;
        Intrinsics.checkNotNull(buffer);
        if (j12 != buffer.size()) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            long j13 = unsafeCursor.offset;
            if (j13 == -1) {
                j11 = 0;
            } else {
                j11 = j13 + ((long) (unsafeCursor.end - unsafeCursor.start));
            }
            return unsafeCursor.seek(j11);
        }
        throw new IllegalStateException("no more bytes".toString());
    }

    public static final boolean commonRangeEquals(@NotNull Buffer buffer, long j11, @NotNull ByteString byteString, int i11, int i12) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(byteString, "bytes");
        if (j11 < 0 || i11 < 0 || i12 < 0 || buffer.size() - j11 < ((long) i12) || byteString.size() - i11 < i12) {
            return false;
        }
        if (i12 <= 0) {
            return true;
        }
        int i13 = 0;
        while (true) {
            int i14 = i13 + 1;
            if (buffer.getByte(((long) i13) + j11) != byteString.getByte(i13 + i11)) {
                return false;
            }
            if (i14 >= i12) {
                return true;
            }
            i13 = i14;
        }
    }

    public static final int commonRead(@NotNull Buffer buffer, @NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(bArr, "sink");
        return buffer.read(bArr, 0, bArr.length);
    }

    public static final long commonReadAll(@NotNull Buffer buffer, @NotNull Sink sink) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(sink, "sink");
        long size = buffer.size();
        if (size > 0) {
            sink.write(buffer, size);
        }
        return size;
    }

    @NotNull
    public static final Buffer.UnsafeCursor commonReadAndWriteUnsafe(@NotNull Buffer buffer, @NotNull Buffer.UnsafeCursor unsafeCursor) {
        boolean z11;
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(unsafeCursor, "unsafeCursor");
        Buffer.UnsafeCursor resolveDefaultParameter = _UtilKt.resolveDefaultParameter(unsafeCursor);
        if (resolveDefaultParameter.buffer == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            resolveDefaultParameter.buffer = buffer;
            resolveDefaultParameter.readWrite = true;
            return resolveDefaultParameter;
        }
        throw new IllegalStateException("already attached to a buffer".toString());
    }

    public static final byte commonReadByte(@NotNull Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        if (buffer.size() != 0) {
            Segment segment = buffer.head;
            Intrinsics.checkNotNull(segment);
            int i11 = segment.pos;
            int i12 = segment.limit;
            int i13 = i11 + 1;
            byte b11 = segment.data[i11];
            buffer.setSize$okio(buffer.size() - 1);
            if (i13 == i12) {
                buffer.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i13;
            }
            return b11;
        }
        throw new EOFException();
    }

    @NotNull
    public static final byte[] commonReadByteArray(@NotNull Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        return buffer.readByteArray(buffer.size());
    }

    @NotNull
    public static final ByteString commonReadByteString(@NotNull Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        return buffer.readByteString(buffer.size());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x007e, code lost:
        if (r12 != r13) goto L_0x008a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0080, code lost:
        r0.head = r10.pop();
        okio.SegmentPool.recycle(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x008a, code lost:
        r10.pos = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x008c, code lost:
        if (r5 != false) goto L_0x0096;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0090, code lost:
        if (r0.head != null) goto L_0x0093;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0096, code lost:
        r0.setSize$okio(r16.size() - ((long) r1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x009f, code lost:
        if (r2 == false) goto L_0x00a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00a1, code lost:
        r14 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00a3, code lost:
        r14 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00a4, code lost:
        if (r1 >= r14) goto L_0x00e1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00ae, code lost:
        if (r16.size() == 0) goto L_0x00db;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00b0, code lost:
        if (r2 == false) goto L_0x00b5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00b2, code lost:
        r1 = "Expected a digit";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00b5, code lost:
        r1 = "Expected a digit or '-'";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00da, code lost:
        throw new java.lang.NumberFormatException(r1 + " but was 0x" + okio._UtilKt.toHexString(r0.getByte(0)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00e0, code lost:
        throw new java.io.EOFException();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00e1, code lost:
        if (r2 == false) goto L_0x00e4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:?, code lost:
        return -r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:?, code lost:
        return r8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final long commonReadDecimalLong(@org.jetbrains.annotations.NotNull okio.Buffer r16) {
        /*
            r0 = r16
            java.lang.String r1 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            long r1 = r16.size()
            r3 = 0
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 == 0) goto L_0x00e6
            r1 = 0
            r5 = -7
            r2 = r1
            r8 = r3
            r6 = r5
            r5 = r2
        L_0x0018:
            okio.Segment r10 = r0.head
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10)
            byte[] r11 = r10.data
            int r12 = r10.pos
            int r13 = r10.limit
        L_0x0023:
            if (r12 >= r13) goto L_0x007e
            byte r15 = r11[r12]
            r14 = 48
            byte r14 = (byte) r14
            if (r15 < r14) goto L_0x006b
            r3 = 57
            byte r3 = (byte) r3
            if (r15 > r3) goto L_0x006b
            int r14 = r14 - r15
            r3 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            int r3 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r3 < 0) goto L_0x0049
            if (r3 != 0) goto L_0x0043
            long r3 = (long) r14
            int r3 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r3 >= 0) goto L_0x0043
            goto L_0x0049
        L_0x0043:
            r3 = 10
            long r8 = r8 * r3
            long r3 = (long) r14
            long r8 = r8 + r3
            goto L_0x0076
        L_0x0049:
            okio.Buffer r0 = new okio.Buffer
            r0.<init>()
            okio.Buffer r0 = r0.writeDecimalLong((long) r8)
            okio.Buffer r0 = r0.writeByte((int) r15)
            if (r2 != 0) goto L_0x005b
            r0.readByte()
        L_0x005b:
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.String r2 = "Number too large: "
            java.lang.String r0 = r0.readUtf8()
            java.lang.String r0 = kotlin.jvm.internal.Intrinsics.stringPlus(r2, r0)
            r1.<init>(r0)
            throw r1
        L_0x006b:
            r3 = 45
            byte r3 = (byte) r3
            if (r15 != r3) goto L_0x007d
            if (r1 != 0) goto L_0x007d
            r2 = 1
            long r6 = r6 - r2
            r2 = 1
        L_0x0076:
            int r12 = r12 + 1
            int r1 = r1 + 1
            r3 = 0
            goto L_0x0023
        L_0x007d:
            r5 = 1
        L_0x007e:
            if (r12 != r13) goto L_0x008a
            okio.Segment r3 = r10.pop()
            r0.head = r3
            okio.SegmentPool.recycle(r10)
            goto L_0x008c
        L_0x008a:
            r10.pos = r12
        L_0x008c:
            if (r5 != 0) goto L_0x0096
            okio.Segment r3 = r0.head
            if (r3 != 0) goto L_0x0093
            goto L_0x0096
        L_0x0093:
            r3 = 0
            goto L_0x0018
        L_0x0096:
            long r3 = r16.size()
            long r5 = (long) r1
            long r3 = r3 - r5
            r0.setSize$okio(r3)
            if (r2 == 0) goto L_0x00a3
            r14 = 2
            goto L_0x00a4
        L_0x00a3:
            r14 = 1
        L_0x00a4:
            if (r1 >= r14) goto L_0x00e1
            long r3 = r16.size()
            r5 = 0
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 == 0) goto L_0x00db
            if (r2 == 0) goto L_0x00b5
            java.lang.String r1 = "Expected a digit"
            goto L_0x00b7
        L_0x00b5:
            java.lang.String r1 = "Expected a digit or '-'"
        L_0x00b7:
            java.lang.NumberFormatException r2 = new java.lang.NumberFormatException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r1)
            java.lang.String r1 = " but was 0x"
            r3.append(r1)
            r4 = 0
            byte r0 = r0.getByte(r4)
            java.lang.String r0 = okio._UtilKt.toHexString((byte) r0)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r2.<init>(r0)
            throw r2
        L_0x00db:
            java.io.EOFException r0 = new java.io.EOFException
            r0.<init>()
            throw r0
        L_0x00e1:
            if (r2 == 0) goto L_0x00e4
            goto L_0x00e5
        L_0x00e4:
            long r8 = -r8
        L_0x00e5:
            return r8
        L_0x00e6:
            java.io.EOFException r0 = new java.io.EOFException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal._BufferKt.commonReadDecimalLong(okio.Buffer):long");
    }

    public static final void commonReadFully(@NotNull Buffer buffer, @NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(bArr, "sink");
        int i11 = 0;
        while (i11 < bArr.length) {
            int read = buffer.read(bArr, i11, bArr.length - i11);
            if (read != -1) {
                i11 += read;
            } else {
                throw new EOFException();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0089 A[EDGE_INSN: B:44:0x0089->B:28:0x0089 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:5:0x001f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final long commonReadHexadecimalUnsignedLong(@org.jetbrains.annotations.NotNull okio.Buffer r14) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            long r0 = r14.size()
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 == 0) goto L_0x00a7
            r0 = 0
            r1 = r0
            r4 = r2
        L_0x0012:
            okio.Segment r6 = r14.head
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)
            byte[] r7 = r6.data
            int r8 = r6.pos
            int r9 = r6.limit
        L_0x001d:
            if (r8 >= r9) goto L_0x0089
            byte r10 = r7[r8]
            r11 = 48
            byte r11 = (byte) r11
            if (r10 < r11) goto L_0x002e
            r12 = 57
            byte r12 = (byte) r12
            if (r10 > r12) goto L_0x002e
            int r11 = r10 - r11
            goto L_0x0048
        L_0x002e:
            r11 = 97
            byte r11 = (byte) r11
            if (r10 < r11) goto L_0x003d
            r12 = 102(0x66, float:1.43E-43)
            byte r12 = (byte) r12
            if (r10 > r12) goto L_0x003d
        L_0x0038:
            int r11 = r10 - r11
            int r11 = r11 + 10
            goto L_0x0048
        L_0x003d:
            r11 = 65
            byte r11 = (byte) r11
            if (r10 < r11) goto L_0x0075
            r12 = 70
            byte r12 = (byte) r12
            if (r10 > r12) goto L_0x0075
            goto L_0x0038
        L_0x0048:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r12 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r12 != 0) goto L_0x0058
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r0 = r0 + 1
            goto L_0x001d
        L_0x0058:
            okio.Buffer r14 = new okio.Buffer
            r14.<init>()
            okio.Buffer r14 = r14.writeHexadecimalUnsignedLong((long) r4)
            okio.Buffer r14 = r14.writeByte((int) r10)
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.String r1 = "Number too large: "
            java.lang.String r14 = r14.readUtf8()
            java.lang.String r14 = kotlin.jvm.internal.Intrinsics.stringPlus(r1, r14)
            r0.<init>(r14)
            throw r0
        L_0x0075:
            if (r0 == 0) goto L_0x0079
            r1 = 1
            goto L_0x0089
        L_0x0079:
            java.lang.NumberFormatException r14 = new java.lang.NumberFormatException
            java.lang.String r0 = "Expected leading [0-9a-fA-F] character but was 0x"
            java.lang.String r1 = okio._UtilKt.toHexString((byte) r10)
            java.lang.String r0 = kotlin.jvm.internal.Intrinsics.stringPlus(r0, r1)
            r14.<init>(r0)
            throw r14
        L_0x0089:
            if (r8 != r9) goto L_0x0095
            okio.Segment r7 = r6.pop()
            r14.head = r7
            okio.SegmentPool.recycle(r6)
            goto L_0x0097
        L_0x0095:
            r6.pos = r8
        L_0x0097:
            if (r1 != 0) goto L_0x009d
            okio.Segment r6 = r14.head
            if (r6 != 0) goto L_0x0012
        L_0x009d:
            long r1 = r14.size()
            long r6 = (long) r0
            long r1 = r1 - r6
            r14.setSize$okio(r1)
            return r4
        L_0x00a7:
            java.io.EOFException r14 = new java.io.EOFException
            r14.<init>()
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal._BufferKt.commonReadHexadecimalUnsignedLong(okio.Buffer):long");
    }

    public static final int commonReadInt(@NotNull Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        if (buffer.size() >= 4) {
            Segment segment = buffer.head;
            Intrinsics.checkNotNull(segment);
            int i11 = segment.pos;
            int i12 = segment.limit;
            if (((long) (i12 - i11)) < 4) {
                return (buffer.readByte() & 255) | ((buffer.readByte() & 255) << Ascii.CAN) | ((buffer.readByte() & 255) << Ascii.DLE) | ((buffer.readByte() & 255) << 8);
            }
            byte[] bArr = segment.data;
            int i13 = i11 + 1;
            int i14 = i13 + 1;
            byte b11 = ((bArr[i11] & 255) << Ascii.CAN) | ((bArr[i13] & 255) << Ascii.DLE);
            int i15 = i14 + 1;
            byte b12 = b11 | ((bArr[i14] & 255) << 8);
            int i16 = i15 + 1;
            byte b13 = b12 | (bArr[i15] & 255);
            buffer.setSize$okio(buffer.size() - 4);
            if (i16 == i12) {
                buffer.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i16;
            }
            return b13;
        }
        throw new EOFException();
    }

    public static final long commonReadLong(@NotNull Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        if (buffer.size() >= 8) {
            Segment segment = buffer.head;
            Intrinsics.checkNotNull(segment);
            int i11 = segment.pos;
            int i12 = segment.limit;
            if (((long) (i12 - i11)) < 8) {
                return ((((long) buffer.readInt()) & 4294967295L) << 32) | (4294967295L & ((long) buffer.readInt()));
            }
            byte[] bArr = segment.data;
            int i13 = i11 + 1;
            int i14 = i13 + 1;
            int i15 = i14 + 1;
            int i16 = i15 + 1;
            int i17 = i16 + 1;
            int i18 = i17 + 1;
            long j11 = ((((long) bArr[i11]) & 255) << 56) | ((((long) bArr[i13]) & 255) << 48) | ((((long) bArr[i14]) & 255) << 40) | ((((long) bArr[i15]) & 255) << 32) | ((((long) bArr[i16]) & 255) << 24) | ((((long) bArr[i17]) & 255) << 16);
            int i19 = i18 + 1;
            int i21 = i19 + 1;
            long j12 = j11 | ((((long) bArr[i18]) & 255) << 8) | (((long) bArr[i19]) & 255);
            buffer.setSize$okio(buffer.size() - 8);
            if (i21 == i12) {
                buffer.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i21;
            }
            return j12;
        }
        throw new EOFException();
    }

    public static final short commonReadShort(@NotNull Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        if (buffer.size() >= 2) {
            Segment segment = buffer.head;
            Intrinsics.checkNotNull(segment);
            int i11 = segment.pos;
            int i12 = segment.limit;
            if (i12 - i11 < 2) {
                return (short) ((buffer.readByte() & 255) | ((buffer.readByte() & 255) << 8));
            }
            byte[] bArr = segment.data;
            int i13 = i11 + 1;
            int i14 = i13 + 1;
            byte b11 = ((bArr[i11] & 255) << 8) | (bArr[i13] & 255);
            buffer.setSize$okio(buffer.size() - 2);
            if (i14 == i12) {
                buffer.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i14;
            }
            return (short) b11;
        }
        throw new EOFException();
    }

    @NotNull
    public static final Buffer.UnsafeCursor commonReadUnsafe(@NotNull Buffer buffer, @NotNull Buffer.UnsafeCursor unsafeCursor) {
        boolean z11;
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(unsafeCursor, "unsafeCursor");
        Buffer.UnsafeCursor resolveDefaultParameter = _UtilKt.resolveDefaultParameter(unsafeCursor);
        if (resolveDefaultParameter.buffer == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            resolveDefaultParameter.buffer = buffer;
            resolveDefaultParameter.readWrite = false;
            return resolveDefaultParameter;
        }
        throw new IllegalStateException("already attached to a buffer".toString());
    }

    @NotNull
    public static final String commonReadUtf8(@NotNull Buffer buffer, long j11) {
        boolean z11;
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        int i11 = (j11 > 0 ? 1 : (j11 == 0 ? 0 : -1));
        if (i11 < 0 || j11 > 2147483647L) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (!z11) {
            throw new IllegalArgumentException(Intrinsics.stringPlus("byteCount: ", Long.valueOf(j11)).toString());
        } else if (buffer.size() < j11) {
            throw new EOFException();
        } else if (i11 == 0) {
            return "";
        } else {
            Segment segment = buffer.head;
            Intrinsics.checkNotNull(segment);
            int i12 = segment.pos;
            if (((long) i12) + j11 > ((long) segment.limit)) {
                return _Utf8Kt.commonToUtf8String$default(buffer.readByteArray(j11), 0, 0, 3, (Object) null);
            }
            int i13 = (int) j11;
            String commonToUtf8String = _Utf8Kt.commonToUtf8String(segment.data, i12, i12 + i13);
            segment.pos += i13;
            buffer.setSize$okio(buffer.size() - j11);
            if (segment.pos == segment.limit) {
                buffer.head = segment.pop();
                SegmentPool.recycle(segment);
            }
            return commonToUtf8String;
        }
    }

    public static final int commonReadUtf8CodePoint(@NotNull Buffer buffer) {
        byte b11;
        int i11;
        byte b12;
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        if (buffer.size() != 0) {
            byte b13 = buffer.getByte(0);
            boolean z11 = false;
            if ((b13 & 128) == 0) {
                b12 = b13 & Byte.MAX_VALUE;
                b11 = 0;
                i11 = 1;
            } else if ((b13 & 224) == 192) {
                b12 = b13 & Ascii.US;
                i11 = 2;
                b11 = 128;
            } else if ((b13 & 240) == 224) {
                b12 = b13 & Ascii.SI;
                i11 = 3;
                b11 = 2048;
            } else if ((b13 & 248) == 240) {
                b12 = b13 & 7;
                i11 = 4;
                b11 = 65536;
            } else {
                buffer.skip(1);
                return Utf8.REPLACEMENT_CODE_POINT;
            }
            long j11 = (long) i11;
            if (buffer.size() >= j11) {
                if (1 < i11) {
                    int i12 = 1;
                    while (true) {
                        int i13 = i12 + 1;
                        long j12 = (long) i12;
                        byte b14 = buffer.getByte(j12);
                        if ((b14 & 192) == 128) {
                            b12 = (b12 << 6) | (b14 & Utf8.REPLACEMENT_BYTE);
                            if (i13 >= i11) {
                                break;
                            }
                            i12 = i13;
                        } else {
                            buffer.skip(j12);
                            return Utf8.REPLACEMENT_CODE_POINT;
                        }
                    }
                }
                buffer.skip(j11);
                if (b12 > 1114111) {
                    return Utf8.REPLACEMENT_CODE_POINT;
                }
                if (55296 <= b12 && b12 <= 57343) {
                    z11 = true;
                }
                if (!z11 && b12 >= b11) {
                    return b12;
                }
                return Utf8.REPLACEMENT_CODE_POINT;
            }
            throw new EOFException("size < " + i11 + ": " + buffer.size() + " (to read code point prefixed 0x" + _UtilKt.toHexString(b13) + ')');
        }
        throw new EOFException();
    }

    @Nullable
    public static final String commonReadUtf8Line(@NotNull Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        long indexOf = buffer.indexOf((byte) 10);
        if (indexOf != -1) {
            return readUtf8Line(buffer, indexOf);
        }
        if (buffer.size() != 0) {
            return buffer.readUtf8(buffer.size());
        }
        return null;
    }

    @NotNull
    public static final String commonReadUtf8LineStrict(@NotNull Buffer buffer, long j11) {
        boolean z11;
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        if (j11 >= 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            long j12 = Long.MAX_VALUE;
            if (j11 != Long.MAX_VALUE) {
                j12 = j11 + 1;
            }
            byte b11 = (byte) 10;
            long indexOf = buffer.indexOf(b11, 0, j12);
            if (indexOf != -1) {
                return readUtf8Line(buffer, indexOf);
            }
            if (j12 < buffer.size() && buffer.getByte(j12 - 1) == ((byte) 13) && buffer.getByte(j12) == b11) {
                return readUtf8Line(buffer, j12);
            }
            Buffer buffer2 = new Buffer();
            buffer.copyTo(buffer2, 0, Math.min((long) 32, buffer.size()));
            throw new EOFException("\\n not found: limit=" + Math.min(buffer.size(), j11) + " content=" + buffer2.readByteString().hex() + Typography.ellipsis);
        }
        throw new IllegalArgumentException(Intrinsics.stringPlus("limit < 0: ", Long.valueOf(j11)).toString());
    }

    public static final long commonResizeBuffer(@NotNull Buffer.UnsafeCursor unsafeCursor, long j11) {
        boolean z11;
        Buffer.UnsafeCursor unsafeCursor2 = unsafeCursor;
        long j12 = j11;
        Intrinsics.checkNotNullParameter(unsafeCursor2, "<this>");
        Buffer buffer = unsafeCursor2.buffer;
        if (buffer == null) {
            throw new IllegalStateException("not attached to a buffer".toString());
        } else if (unsafeCursor2.readWrite) {
            long size = buffer.size();
            int i11 = (j12 > size ? 1 : (j12 == size ? 0 : -1));
            int i12 = 1;
            if (i11 <= 0) {
                if (j12 >= 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z11) {
                    long j13 = size - j12;
                    while (true) {
                        if (j13 <= 0) {
                            break;
                        }
                        Segment segment = buffer.head;
                        Intrinsics.checkNotNull(segment);
                        Segment segment2 = segment.prev;
                        Intrinsics.checkNotNull(segment2);
                        int i13 = segment2.limit;
                        long j14 = (long) (i13 - segment2.pos);
                        if (j14 > j13) {
                            segment2.limit = i13 - ((int) j13);
                            break;
                        }
                        buffer.head = segment2.pop();
                        SegmentPool.recycle(segment2);
                        j13 -= j14;
                    }
                    unsafeCursor2.setSegment$okio((Segment) null);
                    unsafeCursor2.offset = j12;
                    unsafeCursor2.data = null;
                    unsafeCursor2.start = -1;
                    unsafeCursor2.end = -1;
                } else {
                    throw new IllegalArgumentException(Intrinsics.stringPlus("newSize < 0: ", Long.valueOf(j11)).toString());
                }
            } else if (i11 > 0) {
                long j15 = j12 - size;
                boolean z12 = true;
                while (j15 > 0) {
                    Segment writableSegment$okio = buffer.writableSegment$okio(i12);
                    int min = (int) Math.min(j15, (long) (8192 - writableSegment$okio.limit));
                    writableSegment$okio.limit += min;
                    j15 -= (long) min;
                    if (z12) {
                        unsafeCursor2.setSegment$okio(writableSegment$okio);
                        unsafeCursor2.offset = size;
                        unsafeCursor2.data = writableSegment$okio.data;
                        int i14 = writableSegment$okio.limit;
                        unsafeCursor2.start = i14 - min;
                        unsafeCursor2.end = i14;
                        z12 = false;
                    }
                    i12 = 1;
                }
            }
            buffer.setSize$okio(j12);
            return size;
        } else {
            throw new IllegalStateException("resizeBuffer() only permitted for read/write buffers".toString());
        }
    }

    public static final int commonSeek(@NotNull Buffer.UnsafeCursor unsafeCursor, long j11) {
        Segment segment;
        Intrinsics.checkNotNullParameter(unsafeCursor, "<this>");
        Buffer buffer = unsafeCursor.buffer;
        if (buffer != null) {
            int i11 = (j11 > -1 ? 1 : (j11 == -1 ? 0 : -1));
            if (i11 < 0 || j11 > buffer.size()) {
                throw new ArrayIndexOutOfBoundsException("offset=" + j11 + " > size=" + buffer.size());
            } else if (i11 == 0 || j11 == buffer.size()) {
                unsafeCursor.setSegment$okio((Segment) null);
                unsafeCursor.offset = j11;
                unsafeCursor.data = null;
                unsafeCursor.start = -1;
                unsafeCursor.end = -1;
                return -1;
            } else {
                long size = buffer.size();
                Segment segment2 = buffer.head;
                long j12 = 0;
                if (unsafeCursor.getSegment$okio() != null) {
                    long j13 = unsafeCursor.offset;
                    int i12 = unsafeCursor.start;
                    Segment segment$okio = unsafeCursor.getSegment$okio();
                    Intrinsics.checkNotNull(segment$okio);
                    long j14 = j13 - ((long) (i12 - segment$okio.pos));
                    if (j14 > j11) {
                        segment = segment2;
                        segment2 = unsafeCursor.getSegment$okio();
                        size = j14;
                    } else {
                        segment = unsafeCursor.getSegment$okio();
                        j12 = j14;
                    }
                } else {
                    segment = segment2;
                }
                if (size - j11 > j11 - j12) {
                    while (true) {
                        Intrinsics.checkNotNull(segment);
                        int i13 = segment.limit;
                        int i14 = segment.pos;
                        if (j11 < ((long) (i13 - i14)) + j12) {
                            break;
                        }
                        j12 += (long) (i13 - i14);
                        segment = segment.next;
                    }
                } else {
                    while (size > j11) {
                        Intrinsics.checkNotNull(segment2);
                        segment2 = segment2.prev;
                        Intrinsics.checkNotNull(segment2);
                        size -= (long) (segment2.limit - segment2.pos);
                    }
                    j12 = size;
                    segment = segment2;
                }
                if (unsafeCursor.readWrite) {
                    Intrinsics.checkNotNull(segment);
                    if (segment.shared) {
                        Segment unsharedCopy = segment.unsharedCopy();
                        if (buffer.head == segment) {
                            buffer.head = unsharedCopy;
                        }
                        segment = segment.push(unsharedCopy);
                        Segment segment3 = segment.prev;
                        Intrinsics.checkNotNull(segment3);
                        segment3.pop();
                    }
                }
                unsafeCursor.setSegment$okio(segment);
                unsafeCursor.offset = j11;
                Intrinsics.checkNotNull(segment);
                unsafeCursor.data = segment.data;
                int i15 = segment.pos + ((int) (j11 - j12));
                unsafeCursor.start = i15;
                int i16 = segment.limit;
                unsafeCursor.end = i16;
                return i16 - i15;
            }
        } else {
            throw new IllegalStateException("not attached to a buffer".toString());
        }
    }

    public static final int commonSelect(@NotNull Buffer buffer, @NotNull Options options) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(options, "options");
        int selectPrefix$default = selectPrefix$default(buffer, options, false, 2, (Object) null);
        if (selectPrefix$default == -1) {
            return -1;
        }
        buffer.skip((long) options.getByteStrings$okio()[selectPrefix$default].size());
        return selectPrefix$default;
    }

    public static final void commonSkip(@NotNull Buffer buffer, long j11) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        while (j11 > 0) {
            Segment segment = buffer.head;
            if (segment != null) {
                int min = (int) Math.min(j11, (long) (segment.limit - segment.pos));
                long j12 = (long) min;
                buffer.setSize$okio(buffer.size() - j12);
                j11 -= j12;
                int i11 = segment.pos + min;
                segment.pos = i11;
                if (i11 == segment.limit) {
                    buffer.head = segment.pop();
                    SegmentPool.recycle(segment);
                }
            } else {
                throw new EOFException();
            }
        }
    }

    @NotNull
    public static final ByteString commonSnapshot(@NotNull Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        if (buffer.size() <= 2147483647L) {
            return buffer.snapshot((int) buffer.size());
        }
        throw new IllegalStateException(Intrinsics.stringPlus("size > Int.MAX_VALUE: ", Long.valueOf(buffer.size())).toString());
    }

    @NotNull
    public static final Segment commonWritableSegment(@NotNull Buffer buffer, int i11) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        boolean z11 = true;
        if (i11 < 1 || i11 > 8192) {
            z11 = false;
        }
        if (z11) {
            Segment segment = buffer.head;
            if (segment == null) {
                Segment take = SegmentPool.take();
                buffer.head = take;
                take.prev = take;
                take.next = take;
                return take;
            }
            Intrinsics.checkNotNull(segment);
            Segment segment2 = segment.prev;
            Intrinsics.checkNotNull(segment2);
            if (segment2.limit + i11 > 8192 || !segment2.owner) {
                return segment2.push(SegmentPool.take());
            }
            return segment2;
        }
        throw new IllegalArgumentException("unexpected capacity".toString());
    }

    @NotNull
    public static final Buffer commonWrite(@NotNull Buffer buffer, @NotNull ByteString byteString, int i11, int i12) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(byteString, "byteString");
        byteString.write$okio(buffer, i11, i12);
        return buffer;
    }

    public static /* synthetic */ Buffer commonWrite$default(Buffer buffer, ByteString byteString, int i11, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i11 = 0;
        }
        if ((i13 & 4) != 0) {
            i12 = byteString.size();
        }
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(byteString, "byteString");
        byteString.write$okio(buffer, i11, i12);
        return buffer;
    }

    public static final long commonWriteAll(@NotNull Buffer buffer, @NotNull Source source) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        long j11 = 0;
        while (true) {
            long read = source.read(buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
            if (read == -1) {
                return j11;
            }
            j11 += read;
        }
    }

    @NotNull
    public static final Buffer commonWriteByte(@NotNull Buffer buffer, int i11) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Segment writableSegment$okio = buffer.writableSegment$okio(1);
        byte[] bArr = writableSegment$okio.data;
        int i12 = writableSegment$okio.limit;
        writableSegment$okio.limit = i12 + 1;
        bArr[i12] = (byte) i11;
        buffer.setSize$okio(buffer.size() + 1);
        return buffer;
    }

    @NotNull
    public static final Buffer commonWriteDecimalLong(@NotNull Buffer buffer, long j11) {
        boolean z11;
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        int i11 = (j11 > 0 ? 1 : (j11 == 0 ? 0 : -1));
        if (i11 == 0) {
            return buffer.writeByte(48);
        }
        int i12 = 1;
        if (i11 < 0) {
            j11 = -j11;
            if (j11 < 0) {
                return buffer.writeUtf8("-9223372036854775808");
            }
            z11 = true;
        } else {
            z11 = false;
        }
        if (j11 < 100000000) {
            if (j11 < 10000) {
                if (j11 < 100) {
                    if (j11 >= 10) {
                        i12 = 2;
                    }
                } else if (j11 < 1000) {
                    i12 = 3;
                } else {
                    i12 = 4;
                }
            } else if (j11 < 1000000) {
                if (j11 < 100000) {
                    i12 = 5;
                } else {
                    i12 = 6;
                }
            } else if (j11 < 10000000) {
                i12 = 7;
            } else {
                i12 = 8;
            }
        } else if (j11 < MediaPeriodQueue.INITIAL_RENDERER_POSITION_OFFSET_US) {
            if (j11 < RealConnection.IDLE_CONNECTION_HEALTHY_NS) {
                if (j11 < C.NANOS_PER_SECOND) {
                    i12 = 9;
                } else {
                    i12 = 10;
                }
            } else if (j11 < 100000000000L) {
                i12 = 11;
            } else {
                i12 = 12;
            }
        } else if (j11 < 1000000000000000L) {
            if (j11 < 10000000000000L) {
                i12 = 13;
            } else if (j11 < 100000000000000L) {
                i12 = 14;
            } else {
                i12 = 15;
            }
        } else if (j11 < 100000000000000000L) {
            if (j11 < 10000000000000000L) {
                i12 = 16;
            } else {
                i12 = 17;
            }
        } else if (j11 < 1000000000000000000L) {
            i12 = 18;
        } else {
            i12 = 19;
        }
        if (z11) {
            i12++;
        }
        Segment writableSegment$okio = buffer.writableSegment$okio(i12);
        byte[] bArr = writableSegment$okio.data;
        int i13 = writableSegment$okio.limit + i12;
        while (j11 != 0) {
            long j12 = (long) 10;
            i13--;
            bArr[i13] = getHEX_DIGIT_BYTES()[(int) (j11 % j12)];
            j11 /= j12;
        }
        if (z11) {
            bArr[i13 - 1] = (byte) 45;
        }
        writableSegment$okio.limit += i12;
        buffer.setSize$okio(buffer.size() + ((long) i12));
        return buffer;
    }

    @NotNull
    public static final Buffer commonWriteHexadecimalUnsignedLong(@NotNull Buffer buffer, long j11) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        if (j11 == 0) {
            return buffer.writeByte(48);
        }
        long j12 = (j11 >>> 1) | j11;
        long j13 = j12 | (j12 >>> 2);
        long j14 = j13 | (j13 >>> 4);
        long j15 = j14 | (j14 >>> 8);
        long j16 = j15 | (j15 >>> 16);
        long j17 = j16 | (j16 >>> 32);
        long j18 = j17 - ((j17 >>> 1) & 6148914691236517205L);
        long j19 = ((j18 >>> 2) & 3689348814741910323L) + (j18 & 3689348814741910323L);
        long j21 = ((j19 >>> 4) + j19) & 1085102592571150095L;
        long j22 = j21 + (j21 >>> 8);
        long j23 = j22 + (j22 >>> 16);
        int i11 = (int) ((((j23 & 63) + ((j23 >>> 32) & 63)) + ((long) 3)) / ((long) 4));
        Segment writableSegment$okio = buffer.writableSegment$okio(i11);
        byte[] bArr = writableSegment$okio.data;
        int i12 = writableSegment$okio.limit;
        for (int i13 = (i12 + i11) - 1; i13 >= i12; i13--) {
            bArr[i13] = getHEX_DIGIT_BYTES()[(int) (15 & j11)];
            j11 >>>= 4;
        }
        writableSegment$okio.limit += i11;
        buffer.setSize$okio(buffer.size() + ((long) i11));
        return buffer;
    }

    @NotNull
    public static final Buffer commonWriteInt(@NotNull Buffer buffer, int i11) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Segment writableSegment$okio = buffer.writableSegment$okio(4);
        byte[] bArr = writableSegment$okio.data;
        int i12 = writableSegment$okio.limit;
        int i13 = i12 + 1;
        bArr[i12] = (byte) ((i11 >>> 24) & 255);
        int i14 = i13 + 1;
        bArr[i13] = (byte) ((i11 >>> 16) & 255);
        int i15 = i14 + 1;
        bArr[i14] = (byte) ((i11 >>> 8) & 255);
        bArr[i15] = (byte) (i11 & 255);
        writableSegment$okio.limit = i15 + 1;
        buffer.setSize$okio(buffer.size() + 4);
        return buffer;
    }

    @NotNull
    public static final Buffer commonWriteLong(@NotNull Buffer buffer, long j11) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Segment writableSegment$okio = buffer.writableSegment$okio(8);
        byte[] bArr = writableSegment$okio.data;
        int i11 = writableSegment$okio.limit;
        int i12 = i11 + 1;
        bArr[i11] = (byte) ((int) ((j11 >>> 56) & 255));
        int i13 = i12 + 1;
        bArr[i12] = (byte) ((int) ((j11 >>> 48) & 255));
        int i14 = i13 + 1;
        bArr[i13] = (byte) ((int) ((j11 >>> 40) & 255));
        int i15 = i14 + 1;
        bArr[i14] = (byte) ((int) ((j11 >>> 32) & 255));
        int i16 = i15 + 1;
        bArr[i15] = (byte) ((int) ((j11 >>> 24) & 255));
        int i17 = i16 + 1;
        bArr[i16] = (byte) ((int) ((j11 >>> 16) & 255));
        int i18 = i17 + 1;
        bArr[i17] = (byte) ((int) ((j11 >>> 8) & 255));
        bArr[i18] = (byte) ((int) (j11 & 255));
        writableSegment$okio.limit = i18 + 1;
        buffer.setSize$okio(buffer.size() + 8);
        return buffer;
    }

    @NotNull
    public static final Buffer commonWriteShort(@NotNull Buffer buffer, int i11) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Segment writableSegment$okio = buffer.writableSegment$okio(2);
        byte[] bArr = writableSegment$okio.data;
        int i12 = writableSegment$okio.limit;
        int i13 = i12 + 1;
        bArr[i12] = (byte) ((i11 >>> 8) & 255);
        bArr[i13] = (byte) (i11 & 255);
        writableSegment$okio.limit = i13 + 1;
        buffer.setSize$okio(buffer.size() + 2);
        return buffer;
    }

    @NotNull
    public static final Buffer commonWriteUtf8(@NotNull Buffer buffer, @NotNull String str, int i11, int i12) {
        boolean z11;
        boolean z12;
        boolean z13;
        char c11;
        boolean z14;
        char charAt;
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(str, TypedValues.Custom.S_STRING);
        if (i11 >= 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            if (i12 >= i11) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (z12) {
                if (i12 <= str.length()) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                if (z13) {
                    while (i11 < i12) {
                        char charAt2 = str.charAt(i11);
                        if (charAt2 < 128) {
                            Segment writableSegment$okio = buffer.writableSegment$okio(1);
                            byte[] bArr = writableSegment$okio.data;
                            int i13 = writableSegment$okio.limit - i11;
                            int min = Math.min(i12, 8192 - i13);
                            int i14 = i11 + 1;
                            bArr[i11 + i13] = (byte) charAt2;
                            while (true) {
                                i11 = i14;
                                if (i11 >= min || (charAt = str.charAt(i11)) >= 128) {
                                    int i15 = writableSegment$okio.limit;
                                    int i16 = (i13 + i11) - i15;
                                    writableSegment$okio.limit = i15 + i16;
                                    buffer.setSize$okio(buffer.size() + ((long) i16));
                                } else {
                                    i14 = i11 + 1;
                                    bArr[i11 + i13] = (byte) charAt;
                                }
                            }
                            int i152 = writableSegment$okio.limit;
                            int i162 = (i13 + i11) - i152;
                            writableSegment$okio.limit = i152 + i162;
                            buffer.setSize$okio(buffer.size() + ((long) i162));
                        } else {
                            if (charAt2 < 2048) {
                                Segment writableSegment$okio2 = buffer.writableSegment$okio(2);
                                byte[] bArr2 = writableSegment$okio2.data;
                                int i17 = writableSegment$okio2.limit;
                                bArr2[i17] = (byte) ((charAt2 >> 6) | 192);
                                bArr2[i17 + 1] = (byte) ((charAt2 & '?') | 128);
                                writableSegment$okio2.limit = i17 + 2;
                                buffer.setSize$okio(buffer.size() + 2);
                            } else if (charAt2 < 55296 || charAt2 > 57343) {
                                Segment writableSegment$okio3 = buffer.writableSegment$okio(3);
                                byte[] bArr3 = writableSegment$okio3.data;
                                int i18 = writableSegment$okio3.limit;
                                bArr3[i18] = (byte) ((charAt2 >> 12) | 224);
                                bArr3[i18 + 1] = (byte) ((63 & (charAt2 >> 6)) | 128);
                                bArr3[i18 + 2] = (byte) ((charAt2 & '?') | 128);
                                writableSegment$okio3.limit = i18 + 3;
                                buffer.setSize$okio(buffer.size() + 3);
                            } else {
                                int i19 = i11 + 1;
                                if (i19 < i12) {
                                    c11 = str.charAt(i19);
                                } else {
                                    c11 = 0;
                                }
                                if (charAt2 <= 56319) {
                                    if (56320 > c11 || c11 > 57343) {
                                        z14 = false;
                                    } else {
                                        z14 = true;
                                    }
                                    if (z14) {
                                        int i21 = (((charAt2 & 1023) << 10) | (c11 & 1023)) + 0;
                                        Segment writableSegment$okio4 = buffer.writableSegment$okio(4);
                                        byte[] bArr4 = writableSegment$okio4.data;
                                        int i22 = writableSegment$okio4.limit;
                                        bArr4[i22] = (byte) ((i21 >> 18) | PsExtractor.VIDEO_STREAM_MASK);
                                        bArr4[i22 + 1] = (byte) (((i21 >> 12) & 63) | 128);
                                        bArr4[i22 + 2] = (byte) (((i21 >> 6) & 63) | 128);
                                        bArr4[i22 + 3] = (byte) ((i21 & 63) | 128);
                                        writableSegment$okio4.limit = i22 + 4;
                                        buffer.setSize$okio(buffer.size() + 4);
                                        i11 += 2;
                                    }
                                }
                                buffer.writeByte(63);
                                i11 = i19;
                            }
                            i11++;
                        }
                    }
                    return buffer;
                }
                throw new IllegalArgumentException(("endIndex > string.length: " + i12 + " > " + str.length()).toString());
            }
            throw new IllegalArgumentException(("endIndex < beginIndex: " + i12 + " < " + i11).toString());
        }
        throw new IllegalArgumentException(Intrinsics.stringPlus("beginIndex < 0: ", Integer.valueOf(i11)).toString());
    }

    @NotNull
    public static final Buffer commonWriteUtf8CodePoint(@NotNull Buffer buffer, int i11) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        if (i11 < 128) {
            buffer.writeByte(i11);
        } else if (i11 < 2048) {
            Segment writableSegment$okio = buffer.writableSegment$okio(2);
            byte[] bArr = writableSegment$okio.data;
            int i12 = writableSegment$okio.limit;
            bArr[i12] = (byte) ((i11 >> 6) | 192);
            bArr[i12 + 1] = (byte) ((i11 & 63) | 128);
            writableSegment$okio.limit = i12 + 2;
            buffer.setSize$okio(buffer.size() + 2);
        } else {
            boolean z11 = false;
            if (55296 <= i11 && i11 <= 57343) {
                z11 = true;
            }
            if (z11) {
                buffer.writeByte(63);
            } else if (i11 < 65536) {
                Segment writableSegment$okio2 = buffer.writableSegment$okio(3);
                byte[] bArr2 = writableSegment$okio2.data;
                int i13 = writableSegment$okio2.limit;
                bArr2[i13] = (byte) ((i11 >> 12) | 224);
                bArr2[i13 + 1] = (byte) (((i11 >> 6) & 63) | 128);
                bArr2[i13 + 2] = (byte) ((i11 & 63) | 128);
                writableSegment$okio2.limit = i13 + 3;
                buffer.setSize$okio(buffer.size() + 3);
            } else if (i11 <= 1114111) {
                Segment writableSegment$okio3 = buffer.writableSegment$okio(4);
                byte[] bArr3 = writableSegment$okio3.data;
                int i14 = writableSegment$okio3.limit;
                bArr3[i14] = (byte) ((i11 >> 18) | PsExtractor.VIDEO_STREAM_MASK);
                bArr3[i14 + 1] = (byte) (((i11 >> 12) & 63) | 128);
                bArr3[i14 + 2] = (byte) (((i11 >> 6) & 63) | 128);
                bArr3[i14 + 3] = (byte) ((i11 & 63) | 128);
                writableSegment$okio3.limit = i14 + 4;
                buffer.setSize$okio(buffer.size() + 4);
            } else {
                throw new IllegalArgumentException(Intrinsics.stringPlus("Unexpected code point: 0x", _UtilKt.toHexString(i11)));
            }
        }
        return buffer;
    }

    @NotNull
    public static final byte[] getHEX_DIGIT_BYTES() {
        return HEX_DIGIT_BYTES;
    }

    public static /* synthetic */ void getHEX_DIGIT_BYTES$annotations() {
    }

    public static final boolean rangeEquals(@NotNull Segment segment, int i11, @NotNull byte[] bArr, int i12, int i13) {
        Intrinsics.checkNotNullParameter(segment, "segment");
        Intrinsics.checkNotNullParameter(bArr, "bytes");
        int i14 = segment.limit;
        byte[] bArr2 = segment.data;
        while (i12 < i13) {
            if (i11 == i14) {
                segment = segment.next;
                Intrinsics.checkNotNull(segment);
                byte[] bArr3 = segment.data;
                int i15 = segment.pos;
                bArr2 = bArr3;
                i11 = i15;
                i14 = segment.limit;
            }
            if (bArr2[i11] != bArr[i12]) {
                return false;
            }
            i11++;
            i12++;
        }
        return true;
    }

    @NotNull
    public static final String readUtf8Line(@NotNull Buffer buffer, long j11) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        if (j11 > 0) {
            long j12 = j11 - 1;
            if (buffer.getByte(j12) == ((byte) 13)) {
                String readUtf8 = buffer.readUtf8(j12);
                buffer.skip(2);
                return readUtf8;
            }
        }
        String readUtf82 = buffer.readUtf8(j11);
        buffer.skip(1);
        return readUtf82;
    }

    public static final <T> T seek(@NotNull Buffer buffer, long j11, @NotNull Function2<? super Segment, ? super Long, ? extends T> function2) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(function2, "lambda");
        Segment segment = buffer.head;
        if (segment == null) {
            return function2.invoke(null, -1L);
        }
        if (buffer.size() - j11 < j11) {
            long size = buffer.size();
            while (size > j11) {
                segment = segment.prev;
                Intrinsics.checkNotNull(segment);
                size -= (long) (segment.limit - segment.pos);
            }
            return function2.invoke(segment, Long.valueOf(size));
        }
        long j12 = 0;
        while (true) {
            long j13 = ((long) (segment.limit - segment.pos)) + j12;
            if (j13 > j11) {
                return function2.invoke(segment, Long.valueOf(j12));
            }
            segment = segment.next;
            Intrinsics.checkNotNull(segment);
            j12 = j13;
        }
    }

    public static final int selectPrefix(@NotNull Buffer buffer, @NotNull Options options, boolean z11) {
        int i11;
        int i12;
        boolean z12;
        int i13;
        Segment segment;
        int i14;
        Buffer buffer2 = buffer;
        Intrinsics.checkNotNullParameter(buffer2, "<this>");
        Intrinsics.checkNotNullParameter(options, "options");
        Segment segment2 = buffer2.head;
        if (segment2 != null) {
            byte[] bArr = segment2.data;
            int i15 = segment2.pos;
            int i16 = segment2.limit;
            int[] trie$okio = options.getTrie$okio();
            Segment segment3 = segment2;
            int i17 = -1;
            int i18 = 0;
            loop0:
            while (true) {
                int i19 = i18 + 1;
                int i21 = trie$okio[i18];
                int i22 = i19 + 1;
                int i23 = trie$okio[i19];
                if (i23 != -1) {
                    i17 = i23;
                }
                if (segment3 == null) {
                    break;
                }
                if (i21 < 0) {
                    int i24 = i22 + (i21 * -1);
                    while (true) {
                        int i25 = i15 + 1;
                        int i26 = i22 + 1;
                        if ((bArr[i15] & 255) != trie$okio[i22]) {
                            return i17;
                        }
                        if (i26 == i24) {
                            z12 = true;
                        } else {
                            z12 = false;
                        }
                        if (i25 == i16) {
                            Intrinsics.checkNotNull(segment3);
                            Segment segment4 = segment3.next;
                            Intrinsics.checkNotNull(segment4);
                            i14 = segment4.pos;
                            byte[] bArr2 = segment4.data;
                            i13 = segment4.limit;
                            if (segment4 != segment2) {
                                byte[] bArr3 = bArr2;
                                segment = segment4;
                                bArr = bArr3;
                            } else if (!z12) {
                                break loop0;
                            } else {
                                bArr = bArr2;
                                segment = null;
                            }
                        } else {
                            Segment segment5 = segment3;
                            i13 = i16;
                            i14 = i25;
                            segment = segment5;
                        }
                        if (z12) {
                            i12 = trie$okio[i26];
                            i11 = i14;
                            i16 = i13;
                            segment3 = segment;
                            break;
                        }
                        i15 = i14;
                        i16 = i13;
                        i22 = i26;
                        segment3 = segment;
                    }
                } else {
                    i11 = i15 + 1;
                    byte b11 = bArr[i15] & 255;
                    int i27 = i22 + i21;
                    while (i22 != i27) {
                        if (b11 == trie$okio[i22]) {
                            i12 = trie$okio[i22 + i21];
                            if (i11 == i16) {
                                segment3 = segment3.next;
                                Intrinsics.checkNotNull(segment3);
                                i11 = segment3.pos;
                                bArr = segment3.data;
                                i16 = segment3.limit;
                                if (segment3 == segment2) {
                                    segment3 = null;
                                }
                            }
                        } else {
                            i22++;
                        }
                    }
                    return i17;
                }
                if (i12 >= 0) {
                    return i12;
                }
                i18 = -i12;
                i15 = i11;
            }
            if (z11) {
                return -2;
            }
            return i17;
        } else if (z11) {
            return -2;
        } else {
            return -1;
        }
    }

    public static /* synthetic */ int selectPrefix$default(Buffer buffer, Options options, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        return selectPrefix(buffer, options, z11);
    }

    public static final int commonRead(@NotNull Buffer buffer, @NotNull byte[] bArr, int i11, int i12) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(bArr, "sink");
        _UtilKt.checkOffsetAndCount((long) bArr.length, (long) i11, (long) i12);
        Segment segment = buffer.head;
        if (segment == null) {
            return -1;
        }
        int min = Math.min(i12, segment.limit - segment.pos);
        byte[] bArr2 = segment.data;
        int i13 = segment.pos;
        byte[] unused = ArraysKt___ArraysJvmKt.copyInto(bArr2, bArr, i11, i13, i13 + min);
        segment.pos += min;
        buffer.setSize$okio(buffer.size() - ((long) min));
        if (segment.pos == segment.limit) {
            buffer.head = segment.pop();
            SegmentPool.recycle(segment);
        }
        return min;
    }

    @NotNull
    public static final byte[] commonReadByteArray(@NotNull Buffer buffer, long j11) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        if (!(j11 >= 0 && j11 <= 2147483647L)) {
            throw new IllegalArgumentException(Intrinsics.stringPlus("byteCount: ", Long.valueOf(j11)).toString());
        } else if (buffer.size() >= j11) {
            byte[] bArr = new byte[((int) j11)];
            buffer.readFully(bArr);
            return bArr;
        } else {
            throw new EOFException();
        }
    }

    @NotNull
    public static final ByteString commonReadByteString(@NotNull Buffer buffer, long j11) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        if (!(j11 >= 0 && j11 <= 2147483647L)) {
            throw new IllegalArgumentException(Intrinsics.stringPlus("byteCount: ", Long.valueOf(j11)).toString());
        } else if (buffer.size() < j11) {
            throw new EOFException();
        } else if (j11 < PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM) {
            return new ByteString(buffer.readByteArray(j11));
        } else {
            ByteString snapshot = buffer.snapshot((int) j11);
            buffer.skip(j11);
            return snapshot;
        }
    }

    @NotNull
    public static final Buffer commonWrite(@NotNull Buffer buffer, @NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(bArr, "source");
        return buffer.write(bArr, 0, bArr.length);
    }

    @NotNull
    public static final Buffer commonWrite(@NotNull Buffer buffer, @NotNull byte[] bArr, int i11, int i12) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(bArr, "source");
        long j11 = (long) i12;
        _UtilKt.checkOffsetAndCount((long) bArr.length, (long) i11, j11);
        int i13 = i12 + i11;
        while (i11 < i13) {
            Segment writableSegment$okio = buffer.writableSegment$okio(1);
            int min = Math.min(i13 - i11, 8192 - writableSegment$okio.limit);
            int i14 = i11 + min;
            byte[] unused = ArraysKt___ArraysJvmKt.copyInto(bArr, writableSegment$okio.data, writableSegment$okio.limit, i11, i14);
            writableSegment$okio.limit += min;
            i11 = i14;
        }
        buffer.setSize$okio(buffer.size() + j11);
        return buffer;
    }

    public static final void commonReadFully(@NotNull Buffer buffer, @NotNull Buffer buffer2, long j11) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(buffer2, "sink");
        if (buffer.size() >= j11) {
            buffer2.write(buffer, j11);
        } else {
            buffer2.write(buffer, buffer.size());
            throw new EOFException();
        }
    }

    @NotNull
    public static final ByteString commonSnapshot(@NotNull Buffer buffer, int i11) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        if (i11 == 0) {
            return ByteString.EMPTY;
        }
        _UtilKt.checkOffsetAndCount(buffer.size(), 0, (long) i11);
        Segment segment = buffer.head;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        while (i13 < i11) {
            Intrinsics.checkNotNull(segment);
            int i15 = segment.limit;
            int i16 = segment.pos;
            if (i15 != i16) {
                i13 += i15 - i16;
                i14++;
                segment = segment.next;
            } else {
                throw new AssertionError("s.limit == s.pos");
            }
        }
        byte[][] bArr = new byte[i14][];
        int[] iArr = new int[(i14 * 2)];
        Segment segment2 = buffer.head;
        int i17 = 0;
        while (i12 < i11) {
            Intrinsics.checkNotNull(segment2);
            bArr[i17] = segment2.data;
            i12 += segment2.limit - segment2.pos;
            iArr[i17] = Math.min(i12, i11);
            iArr[i17 + i14] = segment2.pos;
            segment2.shared = true;
            i17++;
            segment2 = segment2.next;
        }
        return new SegmentedByteString(bArr, iArr);
    }

    @NotNull
    public static final Buffer commonWrite(@NotNull Buffer buffer, @NotNull Source source, long j11) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        while (j11 > 0) {
            long read = source.read(buffer, j11);
            if (read != -1) {
                j11 -= read;
            } else {
                throw new EOFException();
            }
        }
        return buffer;
    }

    public static final long commonRead(@NotNull Buffer buffer, @NotNull Buffer buffer2, long j11) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(buffer2, "sink");
        if (!(j11 >= 0)) {
            throw new IllegalArgumentException(Intrinsics.stringPlus("byteCount < 0: ", Long.valueOf(j11)).toString());
        } else if (buffer.size() == 0) {
            return -1;
        } else {
            if (j11 > buffer.size()) {
                j11 = buffer.size();
            }
            buffer2.write(buffer, j11);
            return j11;
        }
    }

    public static final void commonWrite(@NotNull Buffer buffer, @NotNull Buffer buffer2, long j11) {
        Segment segment;
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(buffer2, "source");
        if (buffer2 != buffer) {
            _UtilKt.checkOffsetAndCount(buffer2.size(), 0, j11);
            while (j11 > 0) {
                Segment segment2 = buffer2.head;
                Intrinsics.checkNotNull(segment2);
                int i11 = segment2.limit;
                Segment segment3 = buffer2.head;
                Intrinsics.checkNotNull(segment3);
                if (j11 < ((long) (i11 - segment3.pos))) {
                    Segment segment4 = buffer.head;
                    if (segment4 != null) {
                        Intrinsics.checkNotNull(segment4);
                        segment = segment4.prev;
                    } else {
                        segment = null;
                    }
                    if (segment != null && segment.owner) {
                        if ((((long) segment.limit) + j11) - ((long) (segment.shared ? 0 : segment.pos)) <= PlaybackStateCompat.ACTION_PLAY_FROM_URI) {
                            Segment segment5 = buffer2.head;
                            Intrinsics.checkNotNull(segment5);
                            segment5.writeTo(segment, (int) j11);
                            buffer2.setSize$okio(buffer2.size() - j11);
                            buffer.setSize$okio(buffer.size() + j11);
                            return;
                        }
                    }
                    Segment segment6 = buffer2.head;
                    Intrinsics.checkNotNull(segment6);
                    buffer2.head = segment6.split((int) j11);
                }
                Segment segment7 = buffer2.head;
                Intrinsics.checkNotNull(segment7);
                long j12 = (long) (segment7.limit - segment7.pos);
                buffer2.head = segment7.pop();
                Segment segment8 = buffer.head;
                if (segment8 == null) {
                    buffer.head = segment7;
                    segment7.prev = segment7;
                    segment7.next = segment7;
                } else {
                    Intrinsics.checkNotNull(segment8);
                    Segment segment9 = segment8.prev;
                    Intrinsics.checkNotNull(segment9);
                    segment9.push(segment7).compact();
                }
                buffer2.setSize$okio(buffer2.size() - j12);
                buffer.setSize$okio(buffer.size() + j12);
                j11 -= j12;
            }
            return;
        }
        throw new IllegalArgumentException("source == this".toString());
    }

    public static final long commonIndexOf(@NotNull Buffer buffer, @NotNull ByteString byteString, long j11) {
        long j12;
        Segment segment;
        boolean z11;
        int i11;
        Buffer buffer2 = buffer;
        Intrinsics.checkNotNullParameter(buffer2, "<this>");
        Intrinsics.checkNotNullParameter(byteString, "bytes");
        boolean z12 = true;
        if (byteString.size() > 0) {
            long j13 = 0;
            if (j11 >= 0) {
                Segment segment2 = buffer2.head;
                long j14 = -1;
                if (segment2 == null) {
                    return -1;
                }
                if (buffer.size() - j11 < j11) {
                    long size = buffer.size();
                    while (size > j11) {
                        segment2 = segment2.prev;
                        Intrinsics.checkNotNull(segment2);
                        size -= (long) (segment2.limit - segment2.pos);
                    }
                    byte[] internalArray$okio = byteString.internalArray$okio();
                    byte b11 = internalArray$okio[0];
                    int size2 = byteString.size();
                    long size3 = (buffer.size() - ((long) size2)) + 1;
                    j12 = size;
                    segment = segment2;
                    long j15 = j11;
                    loop1:
                    while (j12 < size3) {
                        byte[] bArr = segment.data;
                        int min = (int) Math.min((long) segment.limit, (((long) segment.pos) + size3) - j12);
                        i11 = (int) ((((long) segment.pos) + j15) - j12);
                        if (i11 < min) {
                            while (true) {
                                int i12 = i11 + 1;
                                if (bArr[i11] == b11 && rangeEquals(segment, i12, internalArray$okio, 1, size2)) {
                                    break loop1;
                                } else if (i12 >= min) {
                                    break;
                                } else {
                                    i11 = i12;
                                }
                            }
                        }
                        j12 += (long) (segment.limit - segment.pos);
                        segment = segment.next;
                        Intrinsics.checkNotNull(segment);
                        j15 = j12;
                        j14 = -1;
                    }
                    return j14;
                }
                while (true) {
                    long j16 = ((long) (segment2.limit - segment2.pos)) + j13;
                    if (j16 > j11) {
                        break;
                    }
                    segment2 = segment2.next;
                    Intrinsics.checkNotNull(segment2);
                    j13 = j16;
                    z12 = z12;
                }
                byte[] internalArray$okio2 = byteString.internalArray$okio();
                byte b12 = internalArray$okio2[0];
                int size4 = byteString.size();
                long size5 = (buffer.size() - ((long) size4)) + 1;
                long j17 = j13;
                Segment segment3 = segment2;
                long j18 = j11;
                loop4:
                while (j12 < size5) {
                    byte[] bArr2 = segment3.data;
                    int min2 = (int) Math.min((long) segment3.limit, (((long) segment3.pos) + size5) - j12);
                    segment = segment3;
                    int i13 = (int) ((((long) segment.pos) + j18) - j12);
                    if (i13 < min2) {
                        while (true) {
                            int i14 = i11 + 1;
                            if (bArr2[i11] == b12) {
                                z11 = true;
                                if (rangeEquals(segment, i14, internalArray$okio2, 1, size4)) {
                                    break loop4;
                                }
                            } else {
                                z11 = true;
                            }
                            if (i14 >= min2) {
                                break;
                            }
                            i13 = i14;
                        }
                    } else {
                        z11 = true;
                    }
                    j17 = j12 + ((long) (segment.limit - segment.pos));
                    segment3 = segment.next;
                    Intrinsics.checkNotNull(segment3);
                    j18 = j17;
                    boolean z13 = z11;
                }
                return -1;
                return ((long) (i11 - segment.pos)) + j12;
            }
            throw new IllegalArgumentException(Intrinsics.stringPlus("fromIndex < 0: ", Long.valueOf(j11)).toString());
        }
        throw new IllegalArgumentException("bytes is empty".toString());
    }
}
