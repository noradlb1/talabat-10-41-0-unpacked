package okio.internal;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.EOFException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Options;
import okio.PeekSource;
import okio.RealBufferedSource;
import okio.Sink;
import okio.Source;
import okio.Timeout;
import okio._UtilKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000j\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\b\u001a\r\u0010\u0003\u001a\u00020\u0004*\u00020\u0002H\b\u001a%\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\b\u001a\u001d\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u0006H\b\u001a\u001d\u0010\r\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u0006H\b\u001a\r\u0010\u000f\u001a\u00020\u0010*\u00020\u0002H\b\u001a-\u0010\u0011\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\b\u001a%\u0010\u0016\u001a\u00020\u0014*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\b\u001a\u001d\u0010\u0016\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\u0006H\b\u001a\u0015\u0010\u001a\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u001bH\b\u001a\r\u0010\u001c\u001a\u00020\b*\u00020\u0002H\b\u001a\r\u0010\u001d\u001a\u00020\u0018*\u00020\u0002H\b\u001a\u0015\u0010\u001d\u001a\u00020\u0018*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0006H\b\u001a\r\u0010\u001e\u001a\u00020\f*\u00020\u0002H\b\u001a\u0015\u0010\u001e\u001a\u00020\f*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0006H\b\u001a\r\u0010\u001f\u001a\u00020\u0006*\u00020\u0002H\b\u001a\u0015\u0010 \u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0018H\b\u001a\u001d\u0010 \u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\u0006H\b\u001a\r\u0010!\u001a\u00020\u0006*\u00020\u0002H\b\u001a\r\u0010\"\u001a\u00020\u0014*\u00020\u0002H\b\u001a\r\u0010#\u001a\u00020\u0014*\u00020\u0002H\b\u001a\r\u0010$\u001a\u00020\u0006*\u00020\u0002H\b\u001a\r\u0010%\u001a\u00020\u0006*\u00020\u0002H\b\u001a\r\u0010&\u001a\u00020'*\u00020\u0002H\b\u001a\r\u0010(\u001a\u00020'*\u00020\u0002H\b\u001a\r\u0010)\u001a\u00020**\u00020\u0002H\b\u001a\u0015\u0010)\u001a\u00020**\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0006H\b\u001a\r\u0010+\u001a\u00020\u0014*\u00020\u0002H\b\u001a\u000f\u0010,\u001a\u0004\u0018\u00010**\u00020\u0002H\b\u001a\u0015\u0010-\u001a\u00020**\u00020\u00022\u0006\u0010.\u001a\u00020\u0006H\b\u001a\u0015\u0010/\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0006H\b\u001a\u0015\u00100\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0006H\b\u001a\u0015\u00101\u001a\u00020\u0014*\u00020\u00022\u0006\u00102\u001a\u000203H\b\u001a\u0015\u00104\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0006H\b\u001a\r\u00105\u001a\u000206*\u00020\u0002H\b\u001a\r\u00107\u001a\u00020**\u00020\u0002H\b¨\u00068"}, d2 = {"commonClose", "", "Lokio/RealBufferedSource;", "commonExhausted", "", "commonIndexOf", "", "b", "", "fromIndex", "toIndex", "bytes", "Lokio/ByteString;", "commonIndexOfElement", "targetBytes", "commonPeek", "Lokio/BufferedSource;", "commonRangeEquals", "offset", "bytesOffset", "", "byteCount", "commonRead", "sink", "", "Lokio/Buffer;", "commonReadAll", "Lokio/Sink;", "commonReadByte", "commonReadByteArray", "commonReadByteString", "commonReadDecimalLong", "commonReadFully", "commonReadHexadecimalUnsignedLong", "commonReadInt", "commonReadIntLe", "commonReadLong", "commonReadLongLe", "commonReadShort", "", "commonReadShortLe", "commonReadUtf8", "", "commonReadUtf8CodePoint", "commonReadUtf8Line", "commonReadUtf8LineStrict", "limit", "commonRequest", "commonRequire", "commonSelect", "options", "Lokio/Options;", "commonSkip", "commonTimeout", "Lokio/Timeout;", "commonToString", "okio"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class _RealBufferedSourceKt {
    public static final void commonClose(@NotNull RealBufferedSource realBufferedSource) {
        Intrinsics.checkNotNullParameter(realBufferedSource, "<this>");
        if (!realBufferedSource.closed) {
            realBufferedSource.closed = true;
            realBufferedSource.source.close();
            realBufferedSource.bufferField.clear();
        }
    }

    public static final boolean commonExhausted(@NotNull RealBufferedSource realBufferedSource) {
        Intrinsics.checkNotNullParameter(realBufferedSource, "<this>");
        if (!(!realBufferedSource.closed)) {
            throw new IllegalStateException("closed".toString());
        } else if (!realBufferedSource.bufferField.exhausted() || realBufferedSource.source.read(realBufferedSource.bufferField, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != -1) {
            return false;
        } else {
            return true;
        }
    }

    public static final long commonIndexOf(@NotNull RealBufferedSource realBufferedSource, byte b11, long j11, long j12) {
        Intrinsics.checkNotNullParameter(realBufferedSource, "<this>");
        boolean z11 = true;
        if (!realBufferedSource.closed) {
            if (0 > j11 || j11 > j12) {
                z11 = false;
            }
            if (z11) {
                while (j11 < j12) {
                    long indexOf = realBufferedSource.bufferField.indexOf(b11, j11, j12);
                    if (indexOf == -1) {
                        long size = realBufferedSource.bufferField.size();
                        if (size >= j12 || realBufferedSource.source.read(realBufferedSource.bufferField, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                            break;
                        }
                        j11 = Math.max(j11, size);
                    } else {
                        return indexOf;
                    }
                }
                return -1;
            }
            throw new IllegalArgumentException(("fromIndex=" + j11 + " toIndex=" + j12).toString());
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final long commonIndexOfElement(@NotNull RealBufferedSource realBufferedSource, @NotNull ByteString byteString, long j11) {
        Intrinsics.checkNotNullParameter(realBufferedSource, "<this>");
        Intrinsics.checkNotNullParameter(byteString, "targetBytes");
        if (!realBufferedSource.closed) {
            while (true) {
                long indexOfElement = realBufferedSource.bufferField.indexOfElement(byteString, j11);
                if (indexOfElement != -1) {
                    return indexOfElement;
                }
                long size = realBufferedSource.bufferField.size();
                if (realBufferedSource.source.read(realBufferedSource.bufferField, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                    return -1;
                }
                j11 = Math.max(j11, size);
            }
        } else {
            throw new IllegalStateException("closed".toString());
        }
    }

    @NotNull
    public static final BufferedSource commonPeek(@NotNull RealBufferedSource realBufferedSource) {
        Intrinsics.checkNotNullParameter(realBufferedSource, "<this>");
        return Okio.buffer((Source) new PeekSource(realBufferedSource));
    }

    public static final boolean commonRangeEquals(@NotNull RealBufferedSource realBufferedSource, long j11, @NotNull ByteString byteString, int i11, int i12) {
        Intrinsics.checkNotNullParameter(realBufferedSource, "<this>");
        Intrinsics.checkNotNullParameter(byteString, "bytes");
        if (!(!realBufferedSource.closed)) {
            throw new IllegalStateException("closed".toString());
        } else if (j11 < 0 || i11 < 0 || i12 < 0 || byteString.size() - i11 < i12) {
            return false;
        } else {
            if (i12 > 0) {
                int i13 = 0;
                while (true) {
                    int i14 = i13 + 1;
                    long j12 = ((long) i13) + j11;
                    if (!realBufferedSource.request(1 + j12) || realBufferedSource.bufferField.getByte(j12) != byteString.getByte(i13 + i11)) {
                        return false;
                    }
                    if (i14 >= i12) {
                        break;
                    }
                    i13 = i14;
                }
            }
            return true;
        }
    }

    public static final long commonRead(@NotNull RealBufferedSource realBufferedSource, @NotNull Buffer buffer, long j11) {
        Intrinsics.checkNotNullParameter(realBufferedSource, "<this>");
        Intrinsics.checkNotNullParameter(buffer, "sink");
        if (!(j11 >= 0)) {
            throw new IllegalArgumentException(Intrinsics.stringPlus("byteCount < 0: ", Long.valueOf(j11)).toString());
        } else if (!(!realBufferedSource.closed)) {
            throw new IllegalStateException("closed".toString());
        } else if (realBufferedSource.bufferField.size() == 0 && realBufferedSource.source.read(realBufferedSource.bufferField, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
            return -1;
        } else {
            return realBufferedSource.bufferField.read(buffer, Math.min(j11, realBufferedSource.bufferField.size()));
        }
    }

    public static final long commonReadAll(@NotNull RealBufferedSource realBufferedSource, @NotNull Sink sink) {
        Intrinsics.checkNotNullParameter(realBufferedSource, "<this>");
        Intrinsics.checkNotNullParameter(sink, "sink");
        long j11 = 0;
        while (realBufferedSource.source.read(realBufferedSource.bufferField, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != -1) {
            long completeSegmentByteCount = realBufferedSource.bufferField.completeSegmentByteCount();
            if (completeSegmentByteCount > 0) {
                j11 += completeSegmentByteCount;
                sink.write(realBufferedSource.bufferField, completeSegmentByteCount);
            }
        }
        if (realBufferedSource.bufferField.size() <= 0) {
            return j11;
        }
        long size = j11 + realBufferedSource.bufferField.size();
        Buffer buffer = realBufferedSource.bufferField;
        sink.write(buffer, buffer.size());
        return size;
    }

    public static final byte commonReadByte(@NotNull RealBufferedSource realBufferedSource) {
        Intrinsics.checkNotNullParameter(realBufferedSource, "<this>");
        realBufferedSource.require(1);
        return realBufferedSource.bufferField.readByte();
    }

    @NotNull
    public static final byte[] commonReadByteArray(@NotNull RealBufferedSource realBufferedSource, long j11) {
        Intrinsics.checkNotNullParameter(realBufferedSource, "<this>");
        realBufferedSource.require(j11);
        return realBufferedSource.bufferField.readByteArray(j11);
    }

    @NotNull
    public static final ByteString commonReadByteString(@NotNull RealBufferedSource realBufferedSource, long j11) {
        Intrinsics.checkNotNullParameter(realBufferedSource, "<this>");
        realBufferedSource.require(j11);
        return realBufferedSource.bufferField.readByteString(j11);
    }

    public static final long commonReadDecimalLong(@NotNull RealBufferedSource realBufferedSource) {
        int i11;
        Intrinsics.checkNotNullParameter(realBufferedSource, "<this>");
        realBufferedSource.require(1);
        long j11 = 0;
        while (true) {
            long j12 = j11 + 1;
            if (!realBufferedSource.request(j12)) {
                break;
            }
            byte b11 = realBufferedSource.bufferField.getByte(j11);
            if ((b11 >= ((byte) 48) && b11 <= ((byte) 57)) || (j11 == 0 && b11 == ((byte) 45))) {
                j11 = j12;
            } else if (i11 == 0) {
                String num = Integer.toString(b11, CharsKt__CharJVMKt.checkRadix(CharsKt__CharJVMKt.checkRadix(16)));
                Intrinsics.checkNotNullExpressionValue(num, "java.lang.Integer.toStri…(this, checkRadix(radix))");
                throw new NumberFormatException(Intrinsics.stringPlus("Expected a digit or '-' but was 0x", num));
            }
        }
        return realBufferedSource.bufferField.readDecimalLong();
    }

    public static final void commonReadFully(@NotNull RealBufferedSource realBufferedSource, @NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(realBufferedSource, "<this>");
        Intrinsics.checkNotNullParameter(bArr, "sink");
        try {
            realBufferedSource.require((long) bArr.length);
            realBufferedSource.bufferField.readFully(bArr);
        } catch (EOFException e11) {
            int i11 = 0;
            while (realBufferedSource.bufferField.size() > 0) {
                Buffer buffer = realBufferedSource.bufferField;
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

    /* JADX WARNING: Removed duplicated region for block: B:17:0x003f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final long commonReadHexadecimalUnsignedLong(@org.jetbrains.annotations.NotNull okio.RealBufferedSource r5) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            r0 = 1
            r5.require(r0)
            r0 = 0
        L_0x000b:
            int r1 = r0 + 1
            long r2 = (long) r1
            boolean r2 = r5.request(r2)
            if (r2 == 0) goto L_0x005e
            okio.Buffer r2 = r5.bufferField
            long r3 = (long) r0
            byte r2 = r2.getByte(r3)
            r3 = 48
            byte r3 = (byte) r3
            if (r2 < r3) goto L_0x0025
            r3 = 57
            byte r3 = (byte) r3
            if (r2 <= r3) goto L_0x003a
        L_0x0025:
            r3 = 97
            byte r3 = (byte) r3
            if (r2 < r3) goto L_0x002f
            r3 = 102(0x66, float:1.43E-43)
            byte r3 = (byte) r3
            if (r2 <= r3) goto L_0x003a
        L_0x002f:
            r3 = 65
            byte r3 = (byte) r3
            if (r2 < r3) goto L_0x003c
            r3 = 70
            byte r3 = (byte) r3
            if (r2 <= r3) goto L_0x003a
            goto L_0x003c
        L_0x003a:
            r0 = r1
            goto L_0x000b
        L_0x003c:
            if (r0 == 0) goto L_0x003f
            goto L_0x005e
        L_0x003f:
            java.lang.NumberFormatException r5 = new java.lang.NumberFormatException
            r0 = 16
            int r0 = kotlin.text.CharsKt__CharJVMKt.checkRadix(r0)
            int r0 = kotlin.text.CharsKt__CharJVMKt.checkRadix(r0)
            java.lang.String r0 = java.lang.Integer.toString(r2, r0)
            java.lang.String r1 = "java.lang.Integer.toStri…(this, checkRadix(radix))"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.lang.String r1 = "Expected leading [0-9a-fA-F] character but was 0x"
            java.lang.String r0 = kotlin.jvm.internal.Intrinsics.stringPlus(r1, r0)
            r5.<init>(r0)
            throw r5
        L_0x005e:
            okio.Buffer r5 = r5.bufferField
            long r0 = r5.readHexadecimalUnsignedLong()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal._RealBufferedSourceKt.commonReadHexadecimalUnsignedLong(okio.RealBufferedSource):long");
    }

    public static final int commonReadInt(@NotNull RealBufferedSource realBufferedSource) {
        Intrinsics.checkNotNullParameter(realBufferedSource, "<this>");
        realBufferedSource.require(4);
        return realBufferedSource.bufferField.readInt();
    }

    public static final int commonReadIntLe(@NotNull RealBufferedSource realBufferedSource) {
        Intrinsics.checkNotNullParameter(realBufferedSource, "<this>");
        realBufferedSource.require(4);
        return realBufferedSource.bufferField.readIntLe();
    }

    public static final long commonReadLong(@NotNull RealBufferedSource realBufferedSource) {
        Intrinsics.checkNotNullParameter(realBufferedSource, "<this>");
        realBufferedSource.require(8);
        return realBufferedSource.bufferField.readLong();
    }

    public static final long commonReadLongLe(@NotNull RealBufferedSource realBufferedSource) {
        Intrinsics.checkNotNullParameter(realBufferedSource, "<this>");
        realBufferedSource.require(8);
        return realBufferedSource.bufferField.readLongLe();
    }

    public static final short commonReadShort(@NotNull RealBufferedSource realBufferedSource) {
        Intrinsics.checkNotNullParameter(realBufferedSource, "<this>");
        realBufferedSource.require(2);
        return realBufferedSource.bufferField.readShort();
    }

    public static final short commonReadShortLe(@NotNull RealBufferedSource realBufferedSource) {
        Intrinsics.checkNotNullParameter(realBufferedSource, "<this>");
        realBufferedSource.require(2);
        return realBufferedSource.bufferField.readShortLe();
    }

    @NotNull
    public static final String commonReadUtf8(@NotNull RealBufferedSource realBufferedSource, long j11) {
        Intrinsics.checkNotNullParameter(realBufferedSource, "<this>");
        realBufferedSource.require(j11);
        return realBufferedSource.bufferField.readUtf8(j11);
    }

    public static final int commonReadUtf8CodePoint(@NotNull RealBufferedSource realBufferedSource) {
        Intrinsics.checkNotNullParameter(realBufferedSource, "<this>");
        realBufferedSource.require(1);
        byte b11 = realBufferedSource.bufferField.getByte(0);
        if ((b11 & 224) == 192) {
            realBufferedSource.require(2);
        } else if ((b11 & 240) == 224) {
            realBufferedSource.require(3);
        } else if ((b11 & 248) == 240) {
            realBufferedSource.require(4);
        }
        return realBufferedSource.bufferField.readUtf8CodePoint();
    }

    @Nullable
    public static final String commonReadUtf8Line(@NotNull RealBufferedSource realBufferedSource) {
        Intrinsics.checkNotNullParameter(realBufferedSource, "<this>");
        long indexOf = realBufferedSource.indexOf((byte) 10);
        if (indexOf != -1) {
            return _BufferKt.readUtf8Line(realBufferedSource.bufferField, indexOf);
        }
        if (realBufferedSource.bufferField.size() != 0) {
            return realBufferedSource.readUtf8(realBufferedSource.bufferField.size());
        }
        return null;
    }

    @NotNull
    public static final String commonReadUtf8LineStrict(@NotNull RealBufferedSource realBufferedSource, long j11) {
        boolean z11;
        long j12;
        Intrinsics.checkNotNullParameter(realBufferedSource, "<this>");
        if (j11 >= 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            if (j11 == Long.MAX_VALUE) {
                j12 = Long.MAX_VALUE;
            } else {
                j12 = j11 + 1;
            }
            byte b11 = (byte) 10;
            long indexOf = realBufferedSource.indexOf(b11, 0, j12);
            if (indexOf != -1) {
                return _BufferKt.readUtf8Line(realBufferedSource.bufferField, indexOf);
            }
            if (j12 < Long.MAX_VALUE && realBufferedSource.request(j12) && realBufferedSource.bufferField.getByte(j12 - 1) == ((byte) 13) && realBufferedSource.request(1 + j12) && realBufferedSource.bufferField.getByte(j12) == b11) {
                return _BufferKt.readUtf8Line(realBufferedSource.bufferField, j12);
            }
            Buffer buffer = new Buffer();
            Buffer buffer2 = realBufferedSource.bufferField;
            buffer2.copyTo(buffer, 0, Math.min((long) 32, buffer2.size()));
            throw new EOFException("\\n not found: limit=" + Math.min(realBufferedSource.bufferField.size(), j11) + " content=" + buffer.readByteString().hex() + Typography.ellipsis);
        }
        throw new IllegalArgumentException(Intrinsics.stringPlus("limit < 0: ", Long.valueOf(j11)).toString());
    }

    public static final boolean commonRequest(@NotNull RealBufferedSource realBufferedSource, long j11) {
        boolean z11;
        Intrinsics.checkNotNullParameter(realBufferedSource, "<this>");
        if (j11 >= 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            throw new IllegalArgumentException(Intrinsics.stringPlus("byteCount < 0: ", Long.valueOf(j11)).toString());
        } else if (!realBufferedSource.closed) {
            while (realBufferedSource.bufferField.size() < j11) {
                if (realBufferedSource.source.read(realBufferedSource.bufferField, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                    return false;
                }
            }
            return true;
        } else {
            throw new IllegalStateException("closed".toString());
        }
    }

    public static final void commonRequire(@NotNull RealBufferedSource realBufferedSource, long j11) {
        Intrinsics.checkNotNullParameter(realBufferedSource, "<this>");
        if (!realBufferedSource.request(j11)) {
            throw new EOFException();
        }
    }

    public static final int commonSelect(@NotNull RealBufferedSource realBufferedSource, @NotNull Options options) {
        Intrinsics.checkNotNullParameter(realBufferedSource, "<this>");
        Intrinsics.checkNotNullParameter(options, "options");
        if (!realBufferedSource.closed) {
            do {
                int selectPrefix = _BufferKt.selectPrefix(realBufferedSource.bufferField, options, true);
                if (selectPrefix != -2) {
                    if (selectPrefix == -1) {
                        return -1;
                    }
                    realBufferedSource.bufferField.skip((long) options.getByteStrings$okio()[selectPrefix].size());
                    return selectPrefix;
                }
            } while (realBufferedSource.source.read(realBufferedSource.bufferField, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != -1);
            return -1;
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final void commonSkip(@NotNull RealBufferedSource realBufferedSource, long j11) {
        Intrinsics.checkNotNullParameter(realBufferedSource, "<this>");
        if (!realBufferedSource.closed) {
            while (j11 > 0) {
                if (realBufferedSource.bufferField.size() == 0 && realBufferedSource.source.read(realBufferedSource.bufferField, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                    throw new EOFException();
                }
                long min = Math.min(j11, realBufferedSource.bufferField.size());
                realBufferedSource.bufferField.skip(min);
                j11 -= min;
            }
            return;
        }
        throw new IllegalStateException("closed".toString());
    }

    @NotNull
    public static final Timeout commonTimeout(@NotNull RealBufferedSource realBufferedSource) {
        Intrinsics.checkNotNullParameter(realBufferedSource, "<this>");
        return realBufferedSource.source.timeout();
    }

    @NotNull
    public static final String commonToString(@NotNull RealBufferedSource realBufferedSource) {
        Intrinsics.checkNotNullParameter(realBufferedSource, "<this>");
        return "buffer(" + realBufferedSource.source + ')';
    }

    @NotNull
    public static final byte[] commonReadByteArray(@NotNull RealBufferedSource realBufferedSource) {
        Intrinsics.checkNotNullParameter(realBufferedSource, "<this>");
        realBufferedSource.bufferField.writeAll(realBufferedSource.source);
        return realBufferedSource.bufferField.readByteArray();
    }

    @NotNull
    public static final ByteString commonReadByteString(@NotNull RealBufferedSource realBufferedSource) {
        Intrinsics.checkNotNullParameter(realBufferedSource, "<this>");
        realBufferedSource.bufferField.writeAll(realBufferedSource.source);
        return realBufferedSource.bufferField.readByteString();
    }

    @NotNull
    public static final String commonReadUtf8(@NotNull RealBufferedSource realBufferedSource) {
        Intrinsics.checkNotNullParameter(realBufferedSource, "<this>");
        realBufferedSource.bufferField.writeAll(realBufferedSource.source);
        return realBufferedSource.bufferField.readUtf8();
    }

    public static final void commonReadFully(@NotNull RealBufferedSource realBufferedSource, @NotNull Buffer buffer, long j11) {
        Intrinsics.checkNotNullParameter(realBufferedSource, "<this>");
        Intrinsics.checkNotNullParameter(buffer, "sink");
        try {
            realBufferedSource.require(j11);
            realBufferedSource.bufferField.readFully(buffer, j11);
        } catch (EOFException e11) {
            buffer.writeAll(realBufferedSource.bufferField);
            throw e11;
        }
    }

    public static final long commonIndexOf(@NotNull RealBufferedSource realBufferedSource, @NotNull ByteString byteString, long j11) {
        Intrinsics.checkNotNullParameter(realBufferedSource, "<this>");
        Intrinsics.checkNotNullParameter(byteString, "bytes");
        if (!realBufferedSource.closed) {
            while (true) {
                long indexOf = realBufferedSource.bufferField.indexOf(byteString, j11);
                if (indexOf != -1) {
                    return indexOf;
                }
                long size = realBufferedSource.bufferField.size();
                if (realBufferedSource.source.read(realBufferedSource.bufferField, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                    return -1;
                }
                j11 = Math.max(j11, (size - ((long) byteString.size())) + 1);
            }
        } else {
            throw new IllegalStateException("closed".toString());
        }
    }

    public static final int commonRead(@NotNull RealBufferedSource realBufferedSource, @NotNull byte[] bArr, int i11, int i12) {
        Intrinsics.checkNotNullParameter(realBufferedSource, "<this>");
        Intrinsics.checkNotNullParameter(bArr, "sink");
        long j11 = (long) i12;
        _UtilKt.checkOffsetAndCount((long) bArr.length, (long) i11, j11);
        if (realBufferedSource.bufferField.size() == 0 && realBufferedSource.source.read(realBufferedSource.bufferField, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
            return -1;
        }
        return realBufferedSource.bufferField.read(bArr, i11, (int) Math.min(j11, realBufferedSource.bufferField.size()));
    }
}
