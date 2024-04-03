package okio;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.EOFException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import okio.internal._BufferKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\rH\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0012H\u0016J \u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0012H\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u0012H\u0016J\u0010\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u0018H\u0016J\u0018\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u0012H\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\rH\u0016J\b\u0010\u001e\u001a\u00020\u0001H\u0016J\u0018\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J(\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"H\u0016J\u0010\u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020&H\u0016J\u0010\u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020'H\u0016J \u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020'2\u0006\u0010 \u001a\u00020\"2\u0006\u0010#\u001a\u00020\"H\u0016J\u0018\u0010$\u001a\u00020\u00122\u0006\u0010%\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u0012H\u0016J\u0010\u0010(\u001a\u00020\u00122\u0006\u0010%\u001a\u00020)H\u0016J\b\u0010*\u001a\u00020\u0014H\u0016J\b\u0010+\u001a\u00020'H\u0016J\u0010\u0010+\u001a\u00020'2\u0006\u0010#\u001a\u00020\u0012H\u0016J\b\u0010,\u001a\u00020\u0018H\u0016J\u0010\u0010,\u001a\u00020\u00182\u0006\u0010#\u001a\u00020\u0012H\u0016J\b\u0010-\u001a\u00020\u0012H\u0016J\u0010\u0010.\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020'H\u0016J\u0018\u0010.\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u0012H\u0016J\b\u0010/\u001a\u00020\u0012H\u0016J\b\u00100\u001a\u00020\"H\u0016J\b\u00101\u001a\u00020\"H\u0016J\b\u00102\u001a\u00020\u0012H\u0016J\b\u00103\u001a\u00020\u0012H\u0016J\b\u00104\u001a\u000205H\u0016J\b\u00106\u001a\u000205H\u0016J\u0010\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:H\u0016J\u0018\u00107\u001a\u0002082\u0006\u0010#\u001a\u00020\u00122\u0006\u00109\u001a\u00020:H\u0016J\b\u0010;\u001a\u000208H\u0016J\u0010\u0010;\u001a\u0002082\u0006\u0010#\u001a\u00020\u0012H\u0016J\b\u0010<\u001a\u00020\"H\u0016J\n\u0010=\u001a\u0004\u0018\u000108H\u0016J\b\u0010>\u001a\u000208H\u0016J\u0010\u0010>\u001a\u0002082\u0006\u0010?\u001a\u00020\u0012H\u0016J\u0010\u0010@\u001a\u00020\r2\u0006\u0010#\u001a\u00020\u0012H\u0016J\u0010\u0010A\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\u0012H\u0016J\u0010\u0010B\u001a\u00020\"2\u0006\u0010C\u001a\u00020DH\u0016J\u0010\u0010E\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\u0012H\u0016J\b\u0010F\u001a\u00020GH\u0016J\b\u0010H\u001a\u000208H\u0016R\u001b\u0010\u0005\u001a\u00020\u00068Ö\u0002X\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\r8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006I"}, d2 = {"Lokio/RealBufferedSource;", "Lokio/BufferedSource;", "source", "Lokio/Source;", "(Lokio/Source;)V", "buffer", "Lokio/Buffer;", "getBuffer$annotations", "()V", "getBuffer", "()Lokio/Buffer;", "bufferField", "closed", "", "close", "", "exhausted", "indexOf", "", "b", "", "fromIndex", "toIndex", "bytes", "Lokio/ByteString;", "indexOfElement", "targetBytes", "inputStream", "Ljava/io/InputStream;", "isOpen", "peek", "rangeEquals", "offset", "bytesOffset", "", "byteCount", "read", "sink", "Ljava/nio/ByteBuffer;", "", "readAll", "Lokio/Sink;", "readByte", "readByteArray", "readByteString", "readDecimalLong", "readFully", "readHexadecimalUnsignedLong", "readInt", "readIntLe", "readLong", "readLongLe", "readShort", "", "readShortLe", "readString", "", "charset", "Ljava/nio/charset/Charset;", "readUtf8", "readUtf8CodePoint", "readUtf8Line", "readUtf8LineStrict", "limit", "request", "require", "select", "options", "Lokio/Options;", "skip", "timeout", "Lokio/Timeout;", "toString", "okio"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class RealBufferedSource implements BufferedSource {
    @NotNull
    @JvmField
    public final Buffer bufferField = new Buffer();
    @JvmField
    public boolean closed;
    @NotNull
    @JvmField
    public final Source source;

    public RealBufferedSource(@NotNull Source source2) {
        Intrinsics.checkNotNullParameter(source2, "source");
        this.source = source2;
    }

    public static /* synthetic */ void getBuffer$annotations() {
    }

    @NotNull
    public Buffer buffer() {
        return this.bufferField;
    }

    public void close() {
        if (!this.closed) {
            this.closed = true;
            this.source.close();
            this.bufferField.clear();
        }
    }

    public boolean exhausted() {
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        } else if (!this.bufferField.exhausted() || this.source.read(this.bufferField, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != -1) {
            return false;
        } else {
            return true;
        }
    }

    @NotNull
    public Buffer getBuffer() {
        return this.bufferField;
    }

    public long indexOf(byte b11) {
        return indexOf(b11, 0, Long.MAX_VALUE);
    }

    public long indexOfElement(@NotNull ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "targetBytes");
        return indexOfElement(byteString, 0);
    }

    @NotNull
    public InputStream inputStream() {
        return new RealBufferedSource$inputStream$1(this);
    }

    public boolean isOpen() {
        return !this.closed;
    }

    @NotNull
    public BufferedSource peek() {
        return Okio.buffer((Source) new PeekSource(this));
    }

    public boolean rangeEquals(long j11, @NotNull ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "bytes");
        return rangeEquals(j11, byteString, 0, byteString.size());
    }

    public int read(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "sink");
        return read(bArr, 0, bArr.length);
    }

    public long readAll(@NotNull Sink sink) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        long j11 = 0;
        while (this.source.read(this.bufferField, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != -1) {
            long completeSegmentByteCount = this.bufferField.completeSegmentByteCount();
            if (completeSegmentByteCount > 0) {
                j11 += completeSegmentByteCount;
                sink.write(this.bufferField, completeSegmentByteCount);
            }
        }
        if (this.bufferField.size() <= 0) {
            return j11;
        }
        long size = j11 + this.bufferField.size();
        Buffer buffer = this.bufferField;
        sink.write(buffer, buffer.size());
        return size;
    }

    public byte readByte() {
        require(1);
        return this.bufferField.readByte();
    }

    @NotNull
    public byte[] readByteArray() {
        this.bufferField.writeAll(this.source);
        return this.bufferField.readByteArray();
    }

    @NotNull
    public ByteString readByteString() {
        this.bufferField.writeAll(this.source);
        return this.bufferField.readByteString();
    }

    public long readDecimalLong() {
        int i11;
        require(1);
        long j11 = 0;
        while (true) {
            long j12 = j11 + 1;
            if (!request(j12)) {
                break;
            }
            byte b11 = this.bufferField.getByte(j11);
            if ((b11 >= ((byte) 48) && b11 <= ((byte) 57)) || (j11 == 0 && b11 == ((byte) 45))) {
                j11 = j12;
            } else if (i11 == 0) {
                String num = Integer.toString(b11, CharsKt__CharJVMKt.checkRadix(CharsKt__CharJVMKt.checkRadix(16)));
                Intrinsics.checkNotNullExpressionValue(num, "java.lang.Integer.toStri…(this, checkRadix(radix))");
                throw new NumberFormatException(Intrinsics.stringPlus("Expected a digit or '-' but was 0x", num));
            }
        }
        return this.bufferField.readDecimalLong();
    }

    public void readFully(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "sink");
        try {
            require((long) bArr.length);
            this.bufferField.readFully(bArr);
        } catch (EOFException e11) {
            int i11 = 0;
            while (this.bufferField.size() > 0) {
                Buffer buffer = this.bufferField;
                int read = buffer.read(bArr, i11, (int) buffer.size());
                if (read != -1) {
                    i11 += read;
                } else {
                    throw new AssertionError();
                }
            }
            throw e11;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x003a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long readHexadecimalUnsignedLong() {
        /*
            r5 = this;
            r0 = 1
            r5.require(r0)
            r0 = 0
        L_0x0006:
            int r1 = r0 + 1
            long r2 = (long) r1
            boolean r2 = r5.request(r2)
            if (r2 == 0) goto L_0x0059
            okio.Buffer r2 = r5.bufferField
            long r3 = (long) r0
            byte r2 = r2.getByte(r3)
            r3 = 48
            byte r3 = (byte) r3
            if (r2 < r3) goto L_0x0020
            r3 = 57
            byte r3 = (byte) r3
            if (r2 <= r3) goto L_0x0035
        L_0x0020:
            r3 = 97
            byte r3 = (byte) r3
            if (r2 < r3) goto L_0x002a
            r3 = 102(0x66, float:1.43E-43)
            byte r3 = (byte) r3
            if (r2 <= r3) goto L_0x0035
        L_0x002a:
            r3 = 65
            byte r3 = (byte) r3
            if (r2 < r3) goto L_0x0037
            r3 = 70
            byte r3 = (byte) r3
            if (r2 <= r3) goto L_0x0035
            goto L_0x0037
        L_0x0035:
            r0 = r1
            goto L_0x0006
        L_0x0037:
            if (r0 == 0) goto L_0x003a
            goto L_0x0059
        L_0x003a:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            r1 = 16
            int r1 = kotlin.text.CharsKt__CharJVMKt.checkRadix(r1)
            int r1 = kotlin.text.CharsKt__CharJVMKt.checkRadix(r1)
            java.lang.String r1 = java.lang.Integer.toString(r2, r1)
            java.lang.String r2 = "java.lang.Integer.toStri…(this, checkRadix(radix))"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.String r2 = "Expected leading [0-9a-fA-F] character but was 0x"
            java.lang.String r1 = kotlin.jvm.internal.Intrinsics.stringPlus(r2, r1)
            r0.<init>(r1)
            throw r0
        L_0x0059:
            okio.Buffer r0 = r5.bufferField
            long r0 = r0.readHexadecimalUnsignedLong()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.RealBufferedSource.readHexadecimalUnsignedLong():long");
    }

    public int readInt() {
        require(4);
        return this.bufferField.readInt();
    }

    public int readIntLe() {
        require(4);
        return this.bufferField.readIntLe();
    }

    public long readLong() {
        require(8);
        return this.bufferField.readLong();
    }

    public long readLongLe() {
        require(8);
        return this.bufferField.readLongLe();
    }

    public short readShort() {
        require(2);
        return this.bufferField.readShort();
    }

    public short readShortLe() {
        require(2);
        return this.bufferField.readShortLe();
    }

    @NotNull
    public String readString(long j11, @NotNull Charset charset) {
        Intrinsics.checkNotNullParameter(charset, "charset");
        require(j11);
        return this.bufferField.readString(j11, charset);
    }

    @NotNull
    public String readUtf8() {
        this.bufferField.writeAll(this.source);
        return this.bufferField.readUtf8();
    }

    public int readUtf8CodePoint() {
        require(1);
        byte b11 = this.bufferField.getByte(0);
        if ((b11 & 224) == 192) {
            require(2);
        } else if ((b11 & 240) == 224) {
            require(3);
        } else if ((b11 & 248) == 240) {
            require(4);
        }
        return this.bufferField.readUtf8CodePoint();
    }

    @Nullable
    public String readUtf8Line() {
        long indexOf = indexOf((byte) 10);
        if (indexOf != -1) {
            return _BufferKt.readUtf8Line(this.bufferField, indexOf);
        }
        if (this.bufferField.size() != 0) {
            return readUtf8(this.bufferField.size());
        }
        return null;
    }

    @NotNull
    public String readUtf8LineStrict() {
        return readUtf8LineStrict(Long.MAX_VALUE);
    }

    public boolean request(long j11) {
        boolean z11;
        if (j11 >= 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            throw new IllegalArgumentException(Intrinsics.stringPlus("byteCount < 0: ", Long.valueOf(j11)).toString());
        } else if (!this.closed) {
            while (this.bufferField.size() < j11) {
                if (this.source.read(this.bufferField, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                    return false;
                }
            }
            return true;
        } else {
            throw new IllegalStateException("closed".toString());
        }
    }

    public void require(long j11) {
        if (!request(j11)) {
            throw new EOFException();
        }
    }

    public int select(@NotNull Options options) {
        Intrinsics.checkNotNullParameter(options, "options");
        if (!this.closed) {
            while (true) {
                int selectPrefix = _BufferKt.selectPrefix(this.bufferField, options, true);
                if (selectPrefix == -2) {
                    if (this.source.read(this.bufferField, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                        break;
                    }
                } else if (selectPrefix != -1) {
                    this.bufferField.skip((long) options.getByteStrings$okio()[selectPrefix].size());
                    return selectPrefix;
                }
            }
            return -1;
        }
        throw new IllegalStateException("closed".toString());
    }

    public void skip(long j11) {
        if (!this.closed) {
            while (j11 > 0) {
                if (this.bufferField.size() == 0 && this.source.read(this.bufferField, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                    throw new EOFException();
                }
                long min = Math.min(j11, this.bufferField.size());
                this.bufferField.skip(min);
                j11 -= min;
            }
            return;
        }
        throw new IllegalStateException("closed".toString());
    }

    @NotNull
    public Timeout timeout() {
        return this.source.timeout();
    }

    @NotNull
    public String toString() {
        return "buffer(" + this.source + ')';
    }

    public long indexOf(byte b11, long j11) {
        return indexOf(b11, j11, Long.MAX_VALUE);
    }

    public long indexOfElement(@NotNull ByteString byteString, long j11) {
        Intrinsics.checkNotNullParameter(byteString, "targetBytes");
        if (!this.closed) {
            while (true) {
                long indexOfElement = this.bufferField.indexOfElement(byteString, j11);
                if (indexOfElement != -1) {
                    return indexOfElement;
                }
                long size = this.bufferField.size();
                if (this.source.read(this.bufferField, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                    return -1;
                }
                j11 = Math.max(j11, size);
            }
        } else {
            throw new IllegalStateException("closed".toString());
        }
    }

    public long read(@NotNull Buffer buffer, long j11) {
        Intrinsics.checkNotNullParameter(buffer, "sink");
        if (!(j11 >= 0)) {
            throw new IllegalArgumentException(Intrinsics.stringPlus("byteCount < 0: ", Long.valueOf(j11)).toString());
        } else if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        } else if (this.bufferField.size() == 0 && this.source.read(this.bufferField, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
            return -1;
        } else {
            return this.bufferField.read(buffer, Math.min(j11, this.bufferField.size()));
        }
    }

    @NotNull
    public String readUtf8LineStrict(long j11) {
        if (j11 >= 0) {
            long j12 = j11 == Long.MAX_VALUE ? Long.MAX_VALUE : j11 + 1;
            byte b11 = (byte) 10;
            long indexOf = indexOf(b11, 0, j12);
            if (indexOf != -1) {
                return _BufferKt.readUtf8Line(this.bufferField, indexOf);
            }
            if (j12 < Long.MAX_VALUE && request(j12) && this.bufferField.getByte(j12 - 1) == ((byte) 13) && request(1 + j12) && this.bufferField.getByte(j12) == b11) {
                return _BufferKt.readUtf8Line(this.bufferField, j12);
            }
            Buffer buffer = new Buffer();
            Buffer buffer2 = this.bufferField;
            buffer2.copyTo(buffer, 0, Math.min((long) 32, buffer2.size()));
            throw new EOFException("\\n not found: limit=" + Math.min(this.bufferField.size(), j11) + " content=" + buffer.readByteString().hex() + Typography.ellipsis);
        }
        throw new IllegalArgumentException(Intrinsics.stringPlus("limit < 0: ", Long.valueOf(j11)).toString());
    }

    public long indexOf(@NotNull ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "bytes");
        return indexOf(byteString, 0);
    }

    public boolean rangeEquals(long j11, @NotNull ByteString byteString, int i11, int i12) {
        Intrinsics.checkNotNullParameter(byteString, "bytes");
        if (!this.closed) {
            if (j11 >= 0 && i11 >= 0 && i12 >= 0 && byteString.size() - i11 >= i12) {
                if (i12 > 0) {
                    int i13 = 0;
                    while (true) {
                        int i14 = i13 + 1;
                        long j12 = ((long) i13) + j11;
                        if (!request(1 + j12) || this.bufferField.getByte(j12) != byteString.getByte(i13 + i11)) {
                            break;
                        } else if (i14 >= i12) {
                            return true;
                        } else {
                            i13 = i14;
                        }
                    }
                } else {
                    return true;
                }
            }
            return false;
        }
        throw new IllegalStateException("closed".toString());
    }

    public long indexOf(byte b11, long j11, long j12) {
        boolean z11 = true;
        if (!this.closed) {
            if (0 > j11 || j11 > j12) {
                z11 = false;
            }
            if (z11) {
                while (j11 < j12) {
                    long indexOf = this.bufferField.indexOf(b11, j11, j12);
                    if (indexOf != -1) {
                        return indexOf;
                    }
                    long size = this.bufferField.size();
                    if (size >= j12 || this.source.read(this.bufferField, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                        return -1;
                    }
                    j11 = Math.max(j11, size);
                }
                return -1;
            }
            throw new IllegalArgumentException(("fromIndex=" + j11 + " toIndex=" + j12).toString());
        }
        throw new IllegalStateException("closed".toString());
    }

    @NotNull
    public String readString(@NotNull Charset charset) {
        Intrinsics.checkNotNullParameter(charset, "charset");
        this.bufferField.writeAll(this.source);
        return this.bufferField.readString(charset);
    }

    @NotNull
    public byte[] readByteArray(long j11) {
        require(j11);
        return this.bufferField.readByteArray(j11);
    }

    @NotNull
    public ByteString readByteString(long j11) {
        require(j11);
        return this.bufferField.readByteString(j11);
    }

    @NotNull
    public String readUtf8(long j11) {
        require(j11);
        return this.bufferField.readUtf8(j11);
    }

    public void readFully(@NotNull Buffer buffer, long j11) {
        Intrinsics.checkNotNullParameter(buffer, "sink");
        try {
            require(j11);
            this.bufferField.readFully(buffer, j11);
        } catch (EOFException e11) {
            buffer.writeAll(this.bufferField);
            throw e11;
        }
    }

    public int read(@NotNull byte[] bArr, int i11, int i12) {
        Intrinsics.checkNotNullParameter(bArr, "sink");
        long j11 = (long) i12;
        _UtilKt.checkOffsetAndCount((long) bArr.length, (long) i11, j11);
        if (this.bufferField.size() == 0 && this.source.read(this.bufferField, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
            return -1;
        }
        return this.bufferField.read(bArr, i11, (int) Math.min(j11, this.bufferField.size()));
    }

    public long indexOf(@NotNull ByteString byteString, long j11) {
        Intrinsics.checkNotNullParameter(byteString, "bytes");
        if (!this.closed) {
            while (true) {
                long indexOf = this.bufferField.indexOf(byteString, j11);
                if (indexOf != -1) {
                    return indexOf;
                }
                long size = this.bufferField.size();
                if (this.source.read(this.bufferField, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                    return -1;
                }
                j11 = Math.max(j11, (size - ((long) byteString.size())) + 1);
            }
        } else {
            throw new IllegalStateException("closed".toString());
        }
    }

    public int read(@NotNull ByteBuffer byteBuffer) {
        Intrinsics.checkNotNullParameter(byteBuffer, "sink");
        if (this.bufferField.size() == 0 && this.source.read(this.bufferField, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
            return -1;
        }
        return this.bufferField.read(byteBuffer);
    }
}
