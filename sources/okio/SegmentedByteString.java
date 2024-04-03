package okio;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.internal._SegmentedByteStringKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0010\u0005\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001d\b\u0000\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J(\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0015H\u0016J\u0015\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u0010H\u0010¢\u0006\u0002\b\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0002J\r\u0010 \u001a\u00020\u0015H\u0010¢\u0006\u0002\b!J\b\u0010\"\u001a\u00020\u0015H\u0016J\b\u0010#\u001a\u00020\u0010H\u0016J\u001d\u0010$\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u00102\u0006\u0010%\u001a\u00020\u0001H\u0010¢\u0006\u0002\b&J\u0018\u0010'\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u0015H\u0016J\r\u0010)\u001a\u00020\u0004H\u0010¢\u0006\u0002\b*J\u0015\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0015H\u0010¢\u0006\u0002\b.J\u0018\u0010/\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u0015H\u0016J(\u00100\u001a\u00020\u001d2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u00101\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0015H\u0016J(\u00100\u001a\u00020\u001d2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u00012\u0006\u00101\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0015H\u0016J\u0010\u00102\u001a\u00020\u00102\u0006\u00103\u001a\u000204H\u0016J\u0018\u00105\u001a\u00020\u00012\u0006\u00106\u001a\u00020\u00152\u0006\u00107\u001a\u00020\u0015H\u0016J\b\u00108\u001a\u00020\u0001H\u0016J\b\u00109\u001a\u00020\u0001H\u0016J\b\u0010:\u001a\u00020\u0004H\u0016J\b\u0010;\u001a\u00020\u0001H\u0002J\b\u0010<\u001a\u00020\u0010H\u0016J\u0010\u0010=\u001a\u00020\u00132\u0006\u0010>\u001a\u00020?H\u0016J%\u0010=\u001a\u00020\u00132\u0006\u0010@\u001a\u00020A2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0015H\u0010¢\u0006\u0002\bBJ\b\u0010C\u001a\u00020DH\u0002R\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006E"}, d2 = {"Lokio/SegmentedByteString;", "Lokio/ByteString;", "segments", "", "", "directory", "", "([[B[I)V", "getDirectory$okio", "()[I", "getSegments$okio", "()[[B", "[[B", "asByteBuffer", "Ljava/nio/ByteBuffer;", "base64", "", "base64Url", "copyInto", "", "offset", "", "target", "targetOffset", "byteCount", "digest", "algorithm", "digest$okio", "equals", "", "other", "", "getSize", "getSize$okio", "hashCode", "hex", "hmac", "key", "hmac$okio", "indexOf", "fromIndex", "internalArray", "internalArray$okio", "internalGet", "", "pos", "internalGet$okio", "lastIndexOf", "rangeEquals", "otherOffset", "string", "charset", "Ljava/nio/charset/Charset;", "substring", "beginIndex", "endIndex", "toAsciiLowercase", "toAsciiUppercase", "toByteArray", "toByteString", "toString", "write", "out", "Ljava/io/OutputStream;", "buffer", "Lokio/Buffer;", "write$okio", "writeReplace", "Ljava/lang/Object;", "okio"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class SegmentedByteString extends ByteString {
    @NotNull
    private final transient int[] directory;
    @NotNull
    private final transient byte[][] segments;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SegmentedByteString(@NotNull byte[][] bArr, @NotNull int[] iArr) {
        super(ByteString.EMPTY.getData$okio());
        Intrinsics.checkNotNullParameter(bArr, "segments");
        Intrinsics.checkNotNullParameter(iArr, "directory");
        this.segments = bArr;
        this.directory = iArr;
    }

    private final ByteString toByteString() {
        return new ByteString(toByteArray());
    }

    private final Object writeReplace() {
        return toByteString();
    }

    @NotNull
    public ByteBuffer asByteBuffer() {
        ByteBuffer asReadOnlyBuffer = ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer();
        Intrinsics.checkNotNullExpressionValue(asReadOnlyBuffer, "wrap(toByteArray()).asReadOnlyBuffer()");
        return asReadOnlyBuffer;
    }

    @NotNull
    public String base64() {
        return toByteString().base64();
    }

    @NotNull
    public String base64Url() {
        return toByteString().base64Url();
    }

    public void copyInto(int i11, @NotNull byte[] bArr, int i12, int i13) {
        int i14;
        Intrinsics.checkNotNullParameter(bArr, "target");
        long j11 = (long) i13;
        _UtilKt.checkOffsetAndCount((long) size(), (long) i11, j11);
        _UtilKt.checkOffsetAndCount((long) bArr.length, (long) i12, j11);
        int i15 = i13 + i11;
        int segment = _SegmentedByteStringKt.segment(this, i11);
        while (i11 < i15) {
            if (segment == 0) {
                i14 = 0;
            } else {
                i14 = getDirectory$okio()[segment - 1];
            }
            int i16 = getDirectory$okio()[getSegments$okio().length + segment];
            int min = Math.min(i15, (getDirectory$okio()[segment] - i14) + i14) - i11;
            int i17 = i16 + (i11 - i14);
            byte[] unused = ArraysKt___ArraysJvmKt.copyInto(getSegments$okio()[segment], bArr, i12, i17, i17 + min);
            i12 += min;
            i11 += min;
            segment++;
        }
    }

    @NotNull
    public ByteString digest$okio(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "algorithm");
        MessageDigest instance = MessageDigest.getInstance(str);
        int length = getSegments$okio().length;
        int i11 = 0;
        int i12 = 0;
        while (i11 < length) {
            int i13 = getDirectory$okio()[length + i11];
            int i14 = getDirectory$okio()[i11];
            instance.update(getSegments$okio()[i11], i13, i14 - i12);
            i11++;
            i12 = i14;
        }
        byte[] digest = instance.digest();
        Intrinsics.checkNotNullExpressionValue(digest, "digestBytes");
        return new ByteString(digest);
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            if (byteString.size() == size() && rangeEquals(0, byteString, 0, size())) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public final int[] getDirectory$okio() {
        return this.directory;
    }

    @NotNull
    public final byte[][] getSegments$okio() {
        return this.segments;
    }

    public int getSize$okio() {
        return getDirectory$okio()[getSegments$okio().length - 1];
    }

    public int hashCode() {
        int hashCode$okio = getHashCode$okio();
        if (hashCode$okio != 0) {
            return hashCode$okio;
        }
        int length = getSegments$okio().length;
        int i11 = 0;
        int i12 = 1;
        int i13 = 0;
        while (i11 < length) {
            int i14 = getDirectory$okio()[length + i11];
            int i15 = getDirectory$okio()[i11];
            byte[] bArr = getSegments$okio()[i11];
            int i16 = (i15 - i13) + i14;
            while (i14 < i16) {
                i12 = (i12 * 31) + bArr[i14];
                i14++;
            }
            i11++;
            i13 = i15;
        }
        setHashCode$okio(i12);
        return i12;
    }

    @NotNull
    public String hex() {
        return toByteString().hex();
    }

    @NotNull
    public ByteString hmac$okio(@NotNull String str, @NotNull ByteString byteString) {
        Intrinsics.checkNotNullParameter(str, "algorithm");
        Intrinsics.checkNotNullParameter(byteString, "key");
        try {
            Mac instance = Mac.getInstance(str);
            instance.init(new SecretKeySpec(byteString.toByteArray(), str));
            int length = getSegments$okio().length;
            int i11 = 0;
            int i12 = 0;
            while (i11 < length) {
                int i13 = getDirectory$okio()[length + i11];
                int i14 = getDirectory$okio()[i11];
                instance.update(getSegments$okio()[i11], i13, i14 - i12);
                i11++;
                i12 = i14;
            }
            byte[] doFinal = instance.doFinal();
            Intrinsics.checkNotNullExpressionValue(doFinal, "mac.doFinal()");
            return new ByteString(doFinal);
        } catch (InvalidKeyException e11) {
            throw new IllegalArgumentException(e11);
        }
    }

    public int indexOf(@NotNull byte[] bArr, int i11) {
        Intrinsics.checkNotNullParameter(bArr, "other");
        return toByteString().indexOf(bArr, i11);
    }

    @NotNull
    public byte[] internalArray$okio() {
        return toByteArray();
    }

    public byte internalGet$okio(int i11) {
        int i12;
        _UtilKt.checkOffsetAndCount((long) getDirectory$okio()[getSegments$okio().length - 1], (long) i11, 1);
        int segment = _SegmentedByteStringKt.segment(this, i11);
        if (segment == 0) {
            i12 = 0;
        } else {
            i12 = getDirectory$okio()[segment - 1];
        }
        return getSegments$okio()[segment][(i11 - i12) + getDirectory$okio()[getSegments$okio().length + segment]];
    }

    public int lastIndexOf(@NotNull byte[] bArr, int i11) {
        Intrinsics.checkNotNullParameter(bArr, "other");
        return toByteString().lastIndexOf(bArr, i11);
    }

    public boolean rangeEquals(int i11, @NotNull ByteString byteString, int i12, int i13) {
        int i14;
        Intrinsics.checkNotNullParameter(byteString, "other");
        if (i11 < 0 || i11 > size() - i13) {
            return false;
        }
        int i15 = i13 + i11;
        int segment = _SegmentedByteStringKt.segment(this, i11);
        while (i11 < i15) {
            if (segment == 0) {
                i14 = 0;
            } else {
                i14 = getDirectory$okio()[segment - 1];
            }
            int i16 = getDirectory$okio()[getSegments$okio().length + segment];
            int min = Math.min(i15, (getDirectory$okio()[segment] - i14) + i14) - i11;
            if (!byteString.rangeEquals(i12, getSegments$okio()[segment], i16 + (i11 - i14), min)) {
                return false;
            }
            i12 += min;
            i11 += min;
            segment++;
        }
        return true;
    }

    @NotNull
    public String string(@NotNull Charset charset) {
        Intrinsics.checkNotNullParameter(charset, "charset");
        return toByteString().string(charset);
    }

    @NotNull
    public ByteString substring(int i11, int i12) {
        boolean z11;
        boolean z12;
        boolean z13;
        int resolveDefaultParameter = _UtilKt.resolveDefaultParameter(this, i12);
        int i13 = 0;
        if (i11 >= 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            if (resolveDefaultParameter <= size()) {
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
                } else if (i11 == 0 && resolveDefaultParameter == size()) {
                    return this;
                } else {
                    if (i11 == resolveDefaultParameter) {
                        return ByteString.EMPTY;
                    }
                    int segment = _SegmentedByteStringKt.segment(this, i11);
                    int segment2 = _SegmentedByteStringKt.segment(this, resolveDefaultParameter - 1);
                    byte[][] bArr = (byte[][]) ArraysKt___ArraysJvmKt.copyOfRange((T[]) getSegments$okio(), segment, segment2 + 1);
                    int[] iArr = new int[(bArr.length * 2)];
                    if (segment <= segment2) {
                        int i15 = 0;
                        int i16 = segment;
                        while (true) {
                            int i17 = i16 + 1;
                            iArr[i15] = Math.min(getDirectory$okio()[i16] - i11, i14);
                            int i18 = i15 + 1;
                            iArr[i15 + bArr.length] = getDirectory$okio()[getSegments$okio().length + i16];
                            if (i16 == segment2) {
                                break;
                            }
                            i16 = i17;
                            i15 = i18;
                        }
                    }
                    if (segment != 0) {
                        i13 = getDirectory$okio()[segment - 1];
                    }
                    int length = bArr.length;
                    iArr[length] = iArr[length] + (i11 - i13);
                    return new SegmentedByteString(bArr, iArr);
                }
            } else {
                throw new IllegalArgumentException(("endIndex=" + resolveDefaultParameter + " > length(" + size() + ')').toString());
            }
        } else {
            throw new IllegalArgumentException(("beginIndex=" + i11 + " < 0").toString());
        }
    }

    @NotNull
    public ByteString toAsciiLowercase() {
        return toByteString().toAsciiLowercase();
    }

    @NotNull
    public ByteString toAsciiUppercase() {
        return toByteString().toAsciiUppercase();
    }

    @NotNull
    public byte[] toByteArray() {
        byte[] bArr = new byte[size()];
        int length = getSegments$okio().length;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (i11 < length) {
            int i14 = getDirectory$okio()[length + i11];
            int i15 = getDirectory$okio()[i11];
            int i16 = i15 - i12;
            byte[] unused = ArraysKt___ArraysJvmKt.copyInto(getSegments$okio()[i11], bArr, i13, i14, i14 + i16);
            i13 += i16;
            i11++;
            i12 = i15;
        }
        return bArr;
    }

    @NotNull
    public String toString() {
        return toByteString().toString();
    }

    public void write(@NotNull OutputStream outputStream) throws IOException {
        Intrinsics.checkNotNullParameter(outputStream, "out");
        int length = getSegments$okio().length;
        int i11 = 0;
        int i12 = 0;
        while (i11 < length) {
            int i13 = getDirectory$okio()[length + i11];
            int i14 = getDirectory$okio()[i11];
            outputStream.write(getSegments$okio()[i11], i13, i14 - i12);
            i11++;
            i12 = i14;
        }
    }

    public void write$okio(@NotNull Buffer buffer, int i11, int i12) {
        int i13;
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        int i14 = i11 + i12;
        int segment = _SegmentedByteStringKt.segment(this, i11);
        while (i11 < i14) {
            if (segment == 0) {
                i13 = 0;
            } else {
                i13 = getDirectory$okio()[segment - 1];
            }
            int i15 = getDirectory$okio()[getSegments$okio().length + segment];
            int min = Math.min(i14, (getDirectory$okio()[segment] - i13) + i13) - i11;
            int i16 = i15 + (i11 - i13);
            Segment segment2 = new Segment(getSegments$okio()[segment], i16, i16 + min, true, false);
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

    public boolean rangeEquals(int i11, @NotNull byte[] bArr, int i12, int i13) {
        int i14;
        Intrinsics.checkNotNullParameter(bArr, "other");
        if (i11 < 0 || i11 > size() - i13 || i12 < 0 || i12 > bArr.length - i13) {
            return false;
        }
        int i15 = i13 + i11;
        int segment = _SegmentedByteStringKt.segment(this, i11);
        while (i11 < i15) {
            if (segment == 0) {
                i14 = 0;
            } else {
                i14 = getDirectory$okio()[segment - 1];
            }
            int i16 = getDirectory$okio()[getSegments$okio().length + segment];
            int min = Math.min(i15, (getDirectory$okio()[segment] - i14) + i14) - i11;
            if (!_UtilKt.arrayRangeEquals(getSegments$okio()[segment], i16 + (i11 - i14), bArr, i12, min)) {
                return false;
            }
            i12 += min;
            i11 += min;
            segment++;
        }
        return true;
    }
}
