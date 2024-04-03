package okio;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.adjust.sdk.Constants;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import com.google.common.base.Ascii;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.Typography;
import okhttp3.internal.connection.RealConnection;
import okio.internal._BufferKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002\u0001B\u0005¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0000H\u0016J\u0006\u0010\u0011\u001a\u00020\u0012J\b\u0010\u0013\u001a\u00020\u0000H\u0016J\b\u0010\u0014\u001a\u00020\u0012H\u0016J\u0006\u0010\u0015\u001a\u00020\fJ\u0006\u0010\u0016\u001a\u00020\u0000J$\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\f2\b\b\u0002\u0010\u001b\u001a\u00020\fH\u0007J\u0018\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u001a\u001a\u00020\fJ \u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\fJ\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010 \u001a\u00020\u0000H\u0016J\b\u0010!\u001a\u00020\u0000H\u0016J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0002J\b\u0010&\u001a\u00020#H\u0016J\b\u0010'\u001a\u00020\u0012H\u0016J\u0016\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\fH\u0002¢\u0006\u0002\b+J\u0015\u0010+\u001a\u00020)2\u0006\u0010,\u001a\u00020\fH\u0007¢\u0006\u0002\b-J\b\u0010.\u001a\u00020/H\u0016J\u0018\u00100\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u00101\u001a\u00020\u001dH\u0002J\u000e\u00102\u001a\u00020\u001d2\u0006\u00101\u001a\u00020\u001dJ\u000e\u00103\u001a\u00020\u001d2\u0006\u00101\u001a\u00020\u001dJ\u000e\u00104\u001a\u00020\u001d2\u0006\u00101\u001a\u00020\u001dJ\u0010\u00105\u001a\u00020\f2\u0006\u00106\u001a\u00020)H\u0016J\u0018\u00105\u001a\u00020\f2\u0006\u00106\u001a\u00020)2\u0006\u00107\u001a\u00020\fH\u0016J \u00105\u001a\u00020\f2\u0006\u00106\u001a\u00020)2\u0006\u00107\u001a\u00020\f2\u0006\u00108\u001a\u00020\fH\u0016J\u0010\u00105\u001a\u00020\f2\u0006\u00109\u001a\u00020\u001dH\u0016J\u0018\u00105\u001a\u00020\f2\u0006\u00109\u001a\u00020\u001d2\u0006\u00107\u001a\u00020\fH\u0016J\u0010\u0010:\u001a\u00020\f2\u0006\u0010;\u001a\u00020\u001dH\u0016J\u0018\u0010:\u001a\u00020\f2\u0006\u0010;\u001a\u00020\u001d2\u0006\u00107\u001a\u00020\fH\u0016J\b\u0010<\u001a\u00020=H\u0016J\b\u0010>\u001a\u00020#H\u0016J\u0006\u0010?\u001a\u00020\u001dJ\b\u0010@\u001a\u00020\u0019H\u0016J\b\u0010A\u001a\u00020\u0001H\u0016J\u0018\u0010B\u001a\u00020#2\u0006\u0010\u001a\u001a\u00020\f2\u0006\u00109\u001a\u00020\u001dH\u0016J(\u0010B\u001a\u00020#2\u0006\u0010\u001a\u001a\u00020\f2\u0006\u00109\u001a\u00020\u001d2\u0006\u0010C\u001a\u00020/2\u0006\u0010\u001b\u001a\u00020/H\u0016J\u0010\u0010D\u001a\u00020/2\u0006\u0010E\u001a\u00020FH\u0016J\u0010\u0010D\u001a\u00020/2\u0006\u0010E\u001a\u00020GH\u0016J \u0010D\u001a\u00020/2\u0006\u0010E\u001a\u00020G2\u0006\u0010\u001a\u001a\u00020/2\u0006\u0010\u001b\u001a\u00020/H\u0016J\u0018\u0010D\u001a\u00020\f2\u0006\u0010E\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\fH\u0016J\u0010\u0010H\u001a\u00020\f2\u0006\u0010E\u001a\u00020IH\u0016J\u0012\u0010J\u001a\u00020K2\b\b\u0002\u0010L\u001a\u00020KH\u0007J\b\u0010M\u001a\u00020)H\u0016J\b\u0010N\u001a\u00020GH\u0016J\u0010\u0010N\u001a\u00020G2\u0006\u0010\u001b\u001a\u00020\fH\u0016J\b\u0010O\u001a\u00020\u001dH\u0016J\u0010\u0010O\u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\fH\u0016J\b\u0010P\u001a\u00020\fH\u0016J\u000e\u0010Q\u001a\u00020\u00002\u0006\u0010R\u001a\u00020=J\u0016\u0010Q\u001a\u00020\u00002\u0006\u0010R\u001a\u00020=2\u0006\u0010\u001b\u001a\u00020\fJ \u0010Q\u001a\u00020\u00122\u0006\u0010R\u001a\u00020=2\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010S\u001a\u00020#H\u0002J\u0010\u0010T\u001a\u00020\u00122\u0006\u0010E\u001a\u00020GH\u0016J\u0018\u0010T\u001a\u00020\u00122\u0006\u0010E\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\fH\u0016J\b\u0010U\u001a\u00020\fH\u0016J\b\u0010V\u001a\u00020/H\u0016J\b\u0010W\u001a\u00020/H\u0016J\b\u0010X\u001a\u00020\fH\u0016J\b\u0010Y\u001a\u00020\fH\u0016J\b\u0010Z\u001a\u00020[H\u0016J\b\u0010\\\u001a\u00020[H\u0016J\u0010\u0010]\u001a\u00020\u001f2\u0006\u0010^\u001a\u00020_H\u0016J\u0018\u0010]\u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010^\u001a\u00020_H\u0016J\u0012\u0010`\u001a\u00020K2\b\b\u0002\u0010L\u001a\u00020KH\u0007J\b\u0010a\u001a\u00020\u001fH\u0016J\u0010\u0010a\u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\fH\u0016J\b\u0010b\u001a\u00020/H\u0016J\n\u0010c\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010d\u001a\u00020\u001fH\u0016J\u0010\u0010d\u001a\u00020\u001f2\u0006\u0010e\u001a\u00020\fH\u0016J\u0010\u0010f\u001a\u00020#2\u0006\u0010\u001b\u001a\u00020\fH\u0016J\u0010\u0010g\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\fH\u0016J\u0010\u0010h\u001a\u00020/2\u0006\u0010i\u001a\u00020jH\u0016J\u0006\u0010k\u001a\u00020\u001dJ\u0006\u0010l\u001a\u00020\u001dJ\u0006\u0010m\u001a\u00020\u001dJ\r\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0002\bnJ\u0010\u0010o\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\fH\u0016J\u0006\u0010p\u001a\u00020\u001dJ\u000e\u0010p\u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020/J\b\u0010q\u001a\u00020rH\u0016J\b\u0010s\u001a\u00020\u001fH\u0016J\u0015\u0010t\u001a\u00020\n2\u0006\u0010u\u001a\u00020/H\u0000¢\u0006\u0002\bvJ\u0010\u0010w\u001a\u00020/2\u0006\u0010x\u001a\u00020FH\u0016J\u0010\u0010w\u001a\u00020\u00002\u0006\u0010x\u001a\u00020GH\u0016J \u0010w\u001a\u00020\u00002\u0006\u0010x\u001a\u00020G2\u0006\u0010\u001a\u001a\u00020/2\u0006\u0010\u001b\u001a\u00020/H\u0016J\u0018\u0010w\u001a\u00020\u00122\u0006\u0010x\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\fH\u0016J\u0010\u0010w\u001a\u00020\u00002\u0006\u0010y\u001a\u00020\u001dH\u0016J \u0010w\u001a\u00020\u00002\u0006\u0010y\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020/2\u0006\u0010\u001b\u001a\u00020/H\u0016J\u0018\u0010w\u001a\u00020\u00002\u0006\u0010x\u001a\u00020z2\u0006\u0010\u001b\u001a\u00020\fH\u0016J\u0010\u0010{\u001a\u00020\f2\u0006\u0010x\u001a\u00020zH\u0016J\u0010\u0010|\u001a\u00020\u00002\u0006\u00106\u001a\u00020/H\u0016J\u0010\u0010}\u001a\u00020\u00002\u0006\u0010~\u001a\u00020\fH\u0016J\u0010\u0010\u001a\u00020\u00002\u0006\u0010~\u001a\u00020\fH\u0016J\u0012\u0010\u0001\u001a\u00020\u00002\u0007\u0010\u0001\u001a\u00020/H\u0016J\u0012\u0010\u0001\u001a\u00020\u00002\u0007\u0010\u0001\u001a\u00020/H\u0016J\u0011\u0010\u0001\u001a\u00020\u00002\u0006\u0010~\u001a\u00020\fH\u0016J\u0011\u0010\u0001\u001a\u00020\u00002\u0006\u0010~\u001a\u00020\fH\u0016J\u0012\u0010\u0001\u001a\u00020\u00002\u0007\u0010\u0001\u001a\u00020/H\u0016J\u0012\u0010\u0001\u001a\u00020\u00002\u0007\u0010\u0001\u001a\u00020/H\u0016J\u001a\u0010\u0001\u001a\u00020\u00002\u0007\u0010\u0001\u001a\u00020\u001f2\u0006\u0010^\u001a\u00020_H\u0016J,\u0010\u0001\u001a\u00020\u00002\u0007\u0010\u0001\u001a\u00020\u001f2\u0007\u0010\u0001\u001a\u00020/2\u0007\u0010\u0001\u001a\u00020/2\u0006\u0010^\u001a\u00020_H\u0016J\u001b\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001b\u001a\u00020\fH\u0007J\u0012\u0010\u0001\u001a\u00020\u00002\u0007\u0010\u0001\u001a\u00020\u001fH\u0016J$\u0010\u0001\u001a\u00020\u00002\u0007\u0010\u0001\u001a\u00020\u001f2\u0007\u0010\u0001\u001a\u00020/2\u0007\u0010\u0001\u001a\u00020/H\u0016J\u0012\u0010\u0001\u001a\u00020\u00002\u0007\u0010\u0001\u001a\u00020/H\u0016R\u0014\u0010\u0006\u001a\u00020\u00008VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u0004\u0018\u00010\n8\u0000@\u0000X\u000e¢\u0006\u0002\n\u0000R&\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f8G@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0001"}, d2 = {"Lokio/Buffer;", "Lokio/BufferedSource;", "Lokio/BufferedSink;", "", "Ljava/nio/channels/ByteChannel;", "()V", "buffer", "getBuffer", "()Lokio/Buffer;", "head", "Lokio/Segment;", "<set-?>", "", "size", "()J", "setSize$okio", "(J)V", "clear", "", "clone", "close", "completeSegmentByteCount", "copy", "copyTo", "out", "Ljava/io/OutputStream;", "offset", "byteCount", "digest", "Lokio/ByteString;", "algorithm", "", "emit", "emitCompleteSegments", "equals", "", "other", "", "exhausted", "flush", "get", "", "pos", "getByte", "index", "-deprecated_getByte", "hashCode", "", "hmac", "key", "hmacSha1", "hmacSha256", "hmacSha512", "indexOf", "b", "fromIndex", "toIndex", "bytes", "indexOfElement", "targetBytes", "inputStream", "Ljava/io/InputStream;", "isOpen", "md5", "outputStream", "peek", "rangeEquals", "bytesOffset", "read", "sink", "Ljava/nio/ByteBuffer;", "", "readAll", "Lokio/Sink;", "readAndWriteUnsafe", "Lokio/Buffer$UnsafeCursor;", "unsafeCursor", "readByte", "readByteArray", "readByteString", "readDecimalLong", "readFrom", "input", "forever", "readFully", "readHexadecimalUnsignedLong", "readInt", "readIntLe", "readLong", "readLongLe", "readShort", "", "readShortLe", "readString", "charset", "Ljava/nio/charset/Charset;", "readUnsafe", "readUtf8", "readUtf8CodePoint", "readUtf8Line", "readUtf8LineStrict", "limit", "request", "require", "select", "options", "Lokio/Options;", "sha1", "sha256", "sha512", "-deprecated_size", "skip", "snapshot", "timeout", "Lokio/Timeout;", "toString", "writableSegment", "minimumCapacity", "writableSegment$okio", "write", "source", "byteString", "Lokio/Source;", "writeAll", "writeByte", "writeDecimalLong", "v", "writeHexadecimalUnsignedLong", "writeInt", "i", "writeIntLe", "writeLong", "writeLongLe", "writeShort", "s", "writeShortLe", "writeString", "string", "beginIndex", "endIndex", "writeTo", "writeUtf8", "writeUtf8CodePoint", "codePoint", "UnsafeCursor", "okio"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class Buffer implements BufferedSource, BufferedSink, Cloneable, ByteChannel {
    @Nullable
    @JvmField
    public Segment head;
    private long size;

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u000e\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\bJ\u0006\u0010\u0018\u001a\u00020\bJ\u000e\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\nJ\u000e\u0010\u001b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\n8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0012\u0010\u0013\u001a\u00020\b8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lokio/Buffer$UnsafeCursor;", "Ljava/io/Closeable;", "()V", "buffer", "Lokio/Buffer;", "data", "", "end", "", "offset", "", "readWrite", "", "segment", "Lokio/Segment;", "getSegment$okio", "()Lokio/Segment;", "setSegment$okio", "(Lokio/Segment;)V", "start", "close", "", "expandBuffer", "minByteCount", "next", "resizeBuffer", "newSize", "seek", "okio"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class UnsafeCursor implements Closeable {
        @Nullable
        @JvmField
        public Buffer buffer;
        @Nullable
        @JvmField
        public byte[] data;
        @JvmField
        public int end = -1;
        @JvmField
        public long offset = -1;
        @JvmField
        public boolean readWrite;
        @Nullable
        private Segment segment;
        @JvmField
        public int start = -1;

        public void close() {
            boolean z11;
            if (this.buffer != null) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                this.buffer = null;
                setSegment$okio((Segment) null);
                this.offset = -1;
                this.data = null;
                this.start = -1;
                this.end = -1;
                return;
            }
            throw new IllegalStateException("not attached to a buffer".toString());
        }

        public final long expandBuffer(int i11) {
            boolean z11;
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
                    Buffer buffer2 = this.buffer;
                    if (buffer2 == null) {
                        throw new IllegalStateException("not attached to a buffer".toString());
                    } else if (this.readWrite) {
                        long size = buffer2.size();
                        Segment writableSegment$okio = buffer2.writableSegment$okio(i11);
                        int i12 = 8192 - writableSegment$okio.limit;
                        writableSegment$okio.limit = 8192;
                        long j11 = (long) i12;
                        buffer2.setSize$okio(size + j11);
                        setSegment$okio(writableSegment$okio);
                        this.offset = size;
                        this.data = writableSegment$okio.data;
                        this.start = 8192 - i12;
                        this.end = 8192;
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

        @Nullable
        public final Segment getSegment$okio() {
            return this.segment;
        }

        public final int next() {
            boolean z11;
            long j11;
            long j12 = this.offset;
            Buffer buffer2 = this.buffer;
            Intrinsics.checkNotNull(buffer2);
            if (j12 != buffer2.size()) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                long j13 = this.offset;
                if (j13 == -1) {
                    j11 = 0;
                } else {
                    j11 = j13 + ((long) (this.end - this.start));
                }
                return seek(j11);
            }
            throw new IllegalStateException("no more bytes".toString());
        }

        public final long resizeBuffer(long j11) {
            boolean z11;
            long j12 = j11;
            Buffer buffer2 = this.buffer;
            if (buffer2 == null) {
                throw new IllegalStateException("not attached to a buffer".toString());
            } else if (this.readWrite) {
                long size = buffer2.size();
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
                            Segment segment2 = buffer2.head;
                            Intrinsics.checkNotNull(segment2);
                            Segment segment3 = segment2.prev;
                            Intrinsics.checkNotNull(segment3);
                            int i13 = segment3.limit;
                            long j14 = (long) (i13 - segment3.pos);
                            if (j14 > j13) {
                                segment3.limit = i13 - ((int) j13);
                                break;
                            }
                            buffer2.head = segment3.pop();
                            SegmentPool.recycle(segment3);
                            j13 -= j14;
                        }
                        setSegment$okio((Segment) null);
                        this.offset = j12;
                        this.data = null;
                        this.start = -1;
                        this.end = -1;
                    } else {
                        throw new IllegalArgumentException(Intrinsics.stringPlus("newSize < 0: ", Long.valueOf(j11)).toString());
                    }
                } else if (i11 > 0) {
                    long j15 = j12 - size;
                    boolean z12 = true;
                    while (j15 > 0) {
                        Segment writableSegment$okio = buffer2.writableSegment$okio(i12);
                        int min = (int) Math.min(j15, (long) (8192 - writableSegment$okio.limit));
                        writableSegment$okio.limit += min;
                        j15 -= (long) min;
                        if (z12) {
                            setSegment$okio(writableSegment$okio);
                            this.offset = size;
                            this.data = writableSegment$okio.data;
                            int i14 = writableSegment$okio.limit;
                            this.start = i14 - min;
                            this.end = i14;
                            z12 = false;
                        }
                        i12 = 1;
                    }
                }
                buffer2.setSize$okio(j12);
                return size;
            } else {
                throw new IllegalStateException("resizeBuffer() only permitted for read/write buffers".toString());
            }
        }

        public final int seek(long j11) {
            Segment segment2;
            Buffer buffer2 = this.buffer;
            if (buffer2 != null) {
                int i11 = (j11 > -1 ? 1 : (j11 == -1 ? 0 : -1));
                if (i11 < 0 || j11 > buffer2.size()) {
                    throw new ArrayIndexOutOfBoundsException("offset=" + j11 + " > size=" + buffer2.size());
                } else if (i11 == 0 || j11 == buffer2.size()) {
                    setSegment$okio((Segment) null);
                    this.offset = j11;
                    this.data = null;
                    this.start = -1;
                    this.end = -1;
                    return -1;
                } else {
                    long size = buffer2.size();
                    Segment segment3 = buffer2.head;
                    long j12 = 0;
                    if (getSegment$okio() != null) {
                        long j13 = this.offset;
                        int i12 = this.start;
                        Segment segment$okio = getSegment$okio();
                        Intrinsics.checkNotNull(segment$okio);
                        long j14 = j13 - ((long) (i12 - segment$okio.pos));
                        if (j14 > j11) {
                            segment2 = segment3;
                            segment3 = getSegment$okio();
                            size = j14;
                        } else {
                            segment2 = getSegment$okio();
                            j12 = j14;
                        }
                    } else {
                        segment2 = segment3;
                    }
                    if (size - j11 > j11 - j12) {
                        while (true) {
                            Intrinsics.checkNotNull(segment2);
                            int i13 = segment2.limit;
                            int i14 = segment2.pos;
                            if (j11 < ((long) (i13 - i14)) + j12) {
                                break;
                            }
                            j12 += (long) (i13 - i14);
                            segment2 = segment2.next;
                        }
                    } else {
                        while (size > j11) {
                            Intrinsics.checkNotNull(segment3);
                            segment3 = segment3.prev;
                            Intrinsics.checkNotNull(segment3);
                            size -= (long) (segment3.limit - segment3.pos);
                        }
                        j12 = size;
                        segment2 = segment3;
                    }
                    if (this.readWrite) {
                        Intrinsics.checkNotNull(segment2);
                        if (segment2.shared) {
                            Segment unsharedCopy = segment2.unsharedCopy();
                            if (buffer2.head == segment2) {
                                buffer2.head = unsharedCopy;
                            }
                            segment2 = segment2.push(unsharedCopy);
                            Segment segment4 = segment2.prev;
                            Intrinsics.checkNotNull(segment4);
                            segment4.pop();
                        }
                    }
                    setSegment$okio(segment2);
                    this.offset = j11;
                    Intrinsics.checkNotNull(segment2);
                    this.data = segment2.data;
                    int i15 = segment2.pos + ((int) (j11 - j12));
                    this.start = i15;
                    int i16 = segment2.limit;
                    this.end = i16;
                    return i16 - i15;
                }
            } else {
                throw new IllegalStateException("not attached to a buffer".toString());
            }
        }

        public final void setSegment$okio(@Nullable Segment segment2) {
            this.segment = segment2;
        }
    }

    public static /* synthetic */ Buffer copyTo$default(Buffer buffer, OutputStream outputStream, long j11, long j12, int i11, Object obj) throws IOException {
        if ((i11 & 2) != 0) {
            j11 = 0;
        }
        long j13 = j11;
        if ((i11 & 4) != 0) {
            j12 = buffer.size - j13;
        }
        return buffer.copyTo(outputStream, j13, j12);
    }

    private final ByteString digest(String str) {
        MessageDigest instance = MessageDigest.getInstance(str);
        Segment segment = this.head;
        if (segment != null) {
            byte[] bArr = segment.data;
            int i11 = segment.pos;
            instance.update(bArr, i11, segment.limit - i11);
            Segment segment2 = segment.next;
            Intrinsics.checkNotNull(segment2);
            while (segment2 != segment) {
                byte[] bArr2 = segment2.data;
                int i12 = segment2.pos;
                instance.update(bArr2, i12, segment2.limit - i12);
                segment2 = segment2.next;
                Intrinsics.checkNotNull(segment2);
            }
        }
        byte[] digest = instance.digest();
        Intrinsics.checkNotNullExpressionValue(digest, "messageDigest.digest()");
        return new ByteString(digest);
    }

    private final ByteString hmac(String str, ByteString byteString) {
        try {
            Mac instance = Mac.getInstance(str);
            instance.init(new SecretKeySpec(byteString.internalArray$okio(), str));
            Segment segment = this.head;
            if (segment != null) {
                byte[] bArr = segment.data;
                int i11 = segment.pos;
                instance.update(bArr, i11, segment.limit - i11);
                Segment segment2 = segment.next;
                Intrinsics.checkNotNull(segment2);
                while (segment2 != segment) {
                    byte[] bArr2 = segment2.data;
                    int i12 = segment2.pos;
                    instance.update(bArr2, i12, segment2.limit - i12);
                    segment2 = segment2.next;
                    Intrinsics.checkNotNull(segment2);
                }
            }
            byte[] doFinal = instance.doFinal();
            Intrinsics.checkNotNullExpressionValue(doFinal, "mac.doFinal()");
            return new ByteString(doFinal);
        } catch (InvalidKeyException e11) {
            throw new IllegalArgumentException(e11);
        }
    }

    public static /* synthetic */ UnsafeCursor readAndWriteUnsafe$default(Buffer buffer, UnsafeCursor unsafeCursor, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            unsafeCursor = _UtilKt.getDEFAULT__new_UnsafeCursor();
        }
        return buffer.readAndWriteUnsafe(unsafeCursor);
    }

    public static /* synthetic */ UnsafeCursor readUnsafe$default(Buffer buffer, UnsafeCursor unsafeCursor, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            unsafeCursor = _UtilKt.getDEFAULT__new_UnsafeCursor();
        }
        return buffer.readUnsafe(unsafeCursor);
    }

    public static /* synthetic */ Buffer writeTo$default(Buffer buffer, OutputStream outputStream, long j11, int i11, Object obj) throws IOException {
        if ((i11 & 2) != 0) {
            j11 = buffer.size;
        }
        return buffer.writeTo(outputStream, j11);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to operator function", replaceWith = @ReplaceWith(expression = "this[index]", imports = {}))
    @JvmName(name = "-deprecated_getByte")
    /* renamed from: -deprecated_getByte  reason: not valid java name */
    public final byte m8051deprecated_getByte(long j11) {
        return getByte(j11);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "size", imports = {}))
    @JvmName(name = "-deprecated_size")
    /* renamed from: -deprecated_size  reason: not valid java name */
    public final long m8052deprecated_size() {
        return this.size;
    }

    @NotNull
    public Buffer buffer() {
        return this;
    }

    public final void clear() {
        skip(size());
    }

    public void close() {
    }

    public final long completeSegmentByteCount() {
        long size2 = size();
        if (size2 == 0) {
            return 0;
        }
        Segment segment = this.head;
        Intrinsics.checkNotNull(segment);
        Segment segment2 = segment.prev;
        Intrinsics.checkNotNull(segment2);
        int i11 = segment2.limit;
        if (i11 < 8192 && segment2.owner) {
            size2 -= (long) (i11 - segment2.pos);
        }
        return size2;
    }

    @NotNull
    public final Buffer copy() {
        Buffer buffer = new Buffer();
        if (size() != 0) {
            Segment segment = this.head;
            Intrinsics.checkNotNull(segment);
            Segment sharedCopy = segment.sharedCopy();
            buffer.head = sharedCopy;
            sharedCopy.prev = sharedCopy;
            sharedCopy.next = sharedCopy;
            for (Segment segment2 = segment.next; segment2 != segment; segment2 = segment2.next) {
                Segment segment3 = sharedCopy.prev;
                Intrinsics.checkNotNull(segment3);
                Intrinsics.checkNotNull(segment2);
                segment3.push(segment2.sharedCopy());
            }
            buffer.setSize$okio(size());
        }
        return buffer;
    }

    @NotNull
    @JvmOverloads
    public final Buffer copyTo(@NotNull OutputStream outputStream) throws IOException {
        Intrinsics.checkNotNullParameter(outputStream, "out");
        return copyTo$default(this, outputStream, 0, 0, 6, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final Buffer copyTo(@NotNull OutputStream outputStream, long j11) throws IOException {
        Intrinsics.checkNotNullParameter(outputStream, "out");
        return copyTo$default(this, outputStream, j11, 0, 4, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final Buffer copyTo(@NotNull OutputStream outputStream, long j11, long j12) throws IOException {
        Intrinsics.checkNotNullParameter(outputStream, "out");
        _UtilKt.checkOffsetAndCount(this.size, j11, j12);
        if (j12 == 0) {
            return this;
        }
        Segment segment = this.head;
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
            int i13 = (int) (((long) segment.pos) + j11);
            int min = (int) Math.min((long) (segment.limit - i13), j12);
            outputStream.write(segment.data, i13, min);
            j12 -= (long) min;
            segment = segment.next;
            j11 = 0;
        }
        return this;
    }

    @NotNull
    public Buffer emit() {
        return this;
    }

    @NotNull
    public Buffer emitCompleteSegments() {
        return this;
    }

    /* JADX WARNING: type inference failed for: r19v0, types: [java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r19) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = 1
            if (r0 != r1) goto L_0x0009
            goto L_0x008a
        L_0x0009:
            boolean r3 = r1 instanceof okio.Buffer
            r4 = 0
            if (r3 != 0) goto L_0x0011
        L_0x000e:
            r2 = r4
            goto L_0x008a
        L_0x0011:
            long r5 = r18.size()
            okio.Buffer r1 = (okio.Buffer) r1
            long r7 = r1.size()
            int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r3 == 0) goto L_0x0020
            goto L_0x000e
        L_0x0020:
            long r5 = r18.size()
            r7 = 0
            int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r3 != 0) goto L_0x002b
            goto L_0x008a
        L_0x002b:
            okio.Segment r3 = r0.head
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            okio.Segment r1 = r1.head
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            int r5 = r3.pos
            int r6 = r1.pos
            r9 = r7
        L_0x003a:
            long r11 = r18.size()
            int r11 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r11 >= 0) goto L_0x008a
            int r11 = r3.limit
            int r11 = r11 - r5
            int r12 = r1.limit
            int r12 = r12 - r6
            int r11 = java.lang.Math.min(r11, r12)
            long r11 = (long) r11
            int r13 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r13 >= 0) goto L_0x0072
            r13 = r7
        L_0x0052:
            r15 = 1
            long r13 = r13 + r15
            byte[] r15 = r3.data
            int r16 = r5 + 1
            byte r5 = r15[r5]
            byte[] r15 = r1.data
            int r17 = r6 + 1
            byte r6 = r15[r6]
            if (r5 == r6) goto L_0x0064
            goto L_0x000e
        L_0x0064:
            int r5 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r5 < 0) goto L_0x006d
            r5 = r16
            r6 = r17
            goto L_0x0072
        L_0x006d:
            r5 = r16
            r6 = r17
            goto L_0x0052
        L_0x0072:
            int r13 = r3.limit
            if (r5 != r13) goto L_0x007d
            okio.Segment r3 = r3.next
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            int r5 = r3.pos
        L_0x007d:
            int r13 = r1.limit
            if (r6 != r13) goto L_0x0088
            okio.Segment r1 = r1.next
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            int r6 = r1.pos
        L_0x0088:
            long r9 = r9 + r11
            goto L_0x003a
        L_0x008a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Buffer.equals(java.lang.Object):boolean");
    }

    public boolean exhausted() {
        return this.size == 0;
    }

    public void flush() {
    }

    @NotNull
    public Buffer getBuffer() {
        return this;
    }

    @JvmName(name = "getByte")
    public final byte getByte(long j11) {
        _UtilKt.checkOffsetAndCount(size(), j11, 1);
        Segment segment = this.head;
        if (segment == null) {
            Intrinsics.checkNotNull((Object) null);
            throw null;
        } else if (size() - j11 < j11) {
            long size2 = size();
            while (size2 > j11) {
                segment = segment.prev;
                Intrinsics.checkNotNull(segment);
                size2 -= (long) (segment.limit - segment.pos);
            }
            Intrinsics.checkNotNull(segment);
            return segment.data[(int) ((((long) segment.pos) + j11) - size2)];
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

    public int hashCode() {
        Segment segment = this.head;
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
        } while (segment != this.head);
        return i11;
    }

    @NotNull
    public final ByteString hmacSha1(@NotNull ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "key");
        return hmac("HmacSHA1", byteString);
    }

    @NotNull
    public final ByteString hmacSha256(@NotNull ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "key");
        return hmac("HmacSHA256", byteString);
    }

    @NotNull
    public final ByteString hmacSha512(@NotNull ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "key");
        return hmac("HmacSHA512", byteString);
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
        return new Buffer$inputStream$1(this);
    }

    public boolean isOpen() {
        return true;
    }

    @NotNull
    public final ByteString md5() {
        return digest("MD5");
    }

    @NotNull
    public OutputStream outputStream() {
        return new Buffer$outputStream$1(this);
    }

    @NotNull
    public BufferedSource peek() {
        return Okio.buffer((Source) new PeekSource(this));
    }

    public boolean rangeEquals(long j11, @NotNull ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "bytes");
        return rangeEquals(j11, byteString, 0, byteString.size());
    }

    public int read(@NotNull ByteBuffer byteBuffer) throws IOException {
        Intrinsics.checkNotNullParameter(byteBuffer, "sink");
        Segment segment = this.head;
        if (segment == null) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), segment.limit - segment.pos);
        byteBuffer.put(segment.data, segment.pos, min);
        int i11 = segment.pos + min;
        segment.pos = i11;
        this.size -= (long) min;
        if (i11 == segment.limit) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        }
        return min;
    }

    public long readAll(@NotNull Sink sink) throws IOException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        long size2 = size();
        if (size2 > 0) {
            sink.write(this, size2);
        }
        return size2;
    }

    @NotNull
    @JvmOverloads
    public final UnsafeCursor readAndWriteUnsafe() {
        return readAndWriteUnsafe$default(this, (UnsafeCursor) null, 1, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final UnsafeCursor readAndWriteUnsafe(@NotNull UnsafeCursor unsafeCursor) {
        Intrinsics.checkNotNullParameter(unsafeCursor, "unsafeCursor");
        return _BufferKt.commonReadAndWriteUnsafe(this, unsafeCursor);
    }

    public byte readByte() throws EOFException {
        if (size() != 0) {
            Segment segment = this.head;
            Intrinsics.checkNotNull(segment);
            int i11 = segment.pos;
            int i12 = segment.limit;
            int i13 = i11 + 1;
            byte b11 = segment.data[i11];
            setSize$okio(size() - 1);
            if (i13 == i12) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i13;
            }
            return b11;
        }
        throw new EOFException();
    }

    @NotNull
    public byte[] readByteArray() {
        return readByteArray(size());
    }

    @NotNull
    public ByteString readByteString() {
        return readByteString(size());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x009a, code lost:
        if (r2 == false) goto L_0x009e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x009c, code lost:
        r14 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x009e, code lost:
        r14 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x009f, code lost:
        if (r1 >= r14) goto L_0x00dc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00a9, code lost:
        if (size() == 0) goto L_0x00d6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00ab, code lost:
        if (r2 == false) goto L_0x00b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00ad, code lost:
        r1 = "Expected a digit";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00b0, code lost:
        r1 = "Expected a digit or '-'";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00d5, code lost:
        throw new java.lang.NumberFormatException(r1 + " but was 0x" + okio._UtilKt.toHexString(getByte(0)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00db, code lost:
        throw new java.io.EOFException();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00dc, code lost:
        if (r2 == false) goto L_0x00df;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:?, code lost:
        return -r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:?, code lost:
        return r8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long readDecimalLong() throws java.io.EOFException {
        /*
            r16 = this;
            r0 = r16
            long r1 = r16.size()
            r3 = 0
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 == 0) goto L_0x00e1
            r1 = 0
            r5 = -7
            r2 = r1
            r8 = r3
            r6 = r5
            r5 = r2
        L_0x0013:
            okio.Segment r10 = r0.head
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10)
            byte[] r11 = r10.data
            int r12 = r10.pos
            int r13 = r10.limit
        L_0x001e:
            if (r12 >= r13) goto L_0x0079
            byte r15 = r11[r12]
            r14 = 48
            byte r14 = (byte) r14
            if (r15 < r14) goto L_0x0066
            r3 = 57
            byte r3 = (byte) r3
            if (r15 > r3) goto L_0x0066
            int r14 = r14 - r15
            r3 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            int r3 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r3 < 0) goto L_0x0044
            if (r3 != 0) goto L_0x003e
            long r3 = (long) r14
            int r3 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r3 >= 0) goto L_0x003e
            goto L_0x0044
        L_0x003e:
            r3 = 10
            long r8 = r8 * r3
            long r3 = (long) r14
            long r8 = r8 + r3
            goto L_0x0071
        L_0x0044:
            okio.Buffer r1 = new okio.Buffer
            r1.<init>()
            okio.Buffer r1 = r1.writeDecimalLong((long) r8)
            okio.Buffer r1 = r1.writeByte((int) r15)
            if (r2 != 0) goto L_0x0056
            r1.readByte()
        L_0x0056:
            java.lang.NumberFormatException r2 = new java.lang.NumberFormatException
            java.lang.String r3 = "Number too large: "
            java.lang.String r1 = r1.readUtf8()
            java.lang.String r1 = kotlin.jvm.internal.Intrinsics.stringPlus(r3, r1)
            r2.<init>(r1)
            throw r2
        L_0x0066:
            r3 = 45
            byte r3 = (byte) r3
            if (r15 != r3) goto L_0x0078
            if (r1 != 0) goto L_0x0078
            r2 = 1
            long r6 = r6 - r2
            r2 = 1
        L_0x0071:
            int r12 = r12 + 1
            int r1 = r1 + 1
            r3 = 0
            goto L_0x001e
        L_0x0078:
            r5 = 1
        L_0x0079:
            if (r12 != r13) goto L_0x0085
            okio.Segment r3 = r10.pop()
            r0.head = r3
            okio.SegmentPool.recycle(r10)
            goto L_0x0087
        L_0x0085:
            r10.pos = r12
        L_0x0087:
            if (r5 != 0) goto L_0x0091
            okio.Segment r3 = r0.head
            if (r3 != 0) goto L_0x008e
            goto L_0x0091
        L_0x008e:
            r3 = 0
            goto L_0x0013
        L_0x0091:
            long r3 = r16.size()
            long r5 = (long) r1
            long r3 = r3 - r5
            r0.setSize$okio(r3)
            if (r2 == 0) goto L_0x009e
            r14 = 2
            goto L_0x009f
        L_0x009e:
            r14 = 1
        L_0x009f:
            if (r1 >= r14) goto L_0x00dc
            long r3 = r16.size()
            r5 = 0
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 == 0) goto L_0x00d6
            if (r2 == 0) goto L_0x00b0
            java.lang.String r1 = "Expected a digit"
            goto L_0x00b2
        L_0x00b0:
            java.lang.String r1 = "Expected a digit or '-'"
        L_0x00b2:
            java.lang.NumberFormatException r2 = new java.lang.NumberFormatException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r1)
            java.lang.String r1 = " but was 0x"
            r3.append(r1)
            r4 = 0
            byte r1 = r0.getByte(r4)
            java.lang.String r1 = okio._UtilKt.toHexString((byte) r1)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1)
            throw r2
        L_0x00d6:
            java.io.EOFException r1 = new java.io.EOFException
            r1.<init>()
            throw r1
        L_0x00dc:
            if (r2 == 0) goto L_0x00df
            goto L_0x00e0
        L_0x00df:
            long r8 = -r8
        L_0x00e0:
            return r8
        L_0x00e1:
            java.io.EOFException r1 = new java.io.EOFException
            r1.<init>()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Buffer.readDecimalLong():long");
    }

    @NotNull
    public final Buffer readFrom(@NotNull InputStream inputStream) throws IOException {
        Intrinsics.checkNotNullParameter(inputStream, "input");
        readFrom(inputStream, Long.MAX_VALUE, true);
        return this;
    }

    public void readFully(@NotNull Buffer buffer, long j11) throws EOFException {
        Intrinsics.checkNotNullParameter(buffer, "sink");
        if (size() >= j11) {
            buffer.write(this, j11);
        } else {
            buffer.write(this, size());
            throw new EOFException();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0084, code lost:
        if (r8 != r9) goto L_0x0090;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0086, code lost:
        r14.head = r6.pop();
        okio.SegmentPool.recycle(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0090, code lost:
        r6.pos = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0092, code lost:
        if (r1 != false) goto L_0x0098;
     */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0074 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long readHexadecimalUnsignedLong() throws java.io.EOFException {
        /*
            r14 = this;
            long r0 = r14.size()
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 == 0) goto L_0x00a2
            r0 = 0
            r1 = r0
            r4 = r2
        L_0x000d:
            okio.Segment r6 = r14.head
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)
            byte[] r7 = r6.data
            int r8 = r6.pos
            int r9 = r6.limit
        L_0x0018:
            if (r8 >= r9) goto L_0x0084
            byte r10 = r7[r8]
            r11 = 48
            byte r11 = (byte) r11
            if (r10 < r11) goto L_0x0029
            r12 = 57
            byte r12 = (byte) r12
            if (r10 > r12) goto L_0x0029
            int r11 = r10 - r11
            goto L_0x0043
        L_0x0029:
            r11 = 97
            byte r11 = (byte) r11
            if (r10 < r11) goto L_0x0038
            r12 = 102(0x66, float:1.43E-43)
            byte r12 = (byte) r12
            if (r10 > r12) goto L_0x0038
        L_0x0033:
            int r11 = r10 - r11
            int r11 = r11 + 10
            goto L_0x0043
        L_0x0038:
            r11 = 65
            byte r11 = (byte) r11
            if (r10 < r11) goto L_0x0070
            r12 = 70
            byte r12 = (byte) r12
            if (r10 > r12) goto L_0x0070
            goto L_0x0033
        L_0x0043:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r12 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r12 != 0) goto L_0x0053
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r0 = r0 + 1
            goto L_0x0018
        L_0x0053:
            okio.Buffer r0 = new okio.Buffer
            r0.<init>()
            okio.Buffer r0 = r0.writeHexadecimalUnsignedLong((long) r4)
            okio.Buffer r0 = r0.writeByte((int) r10)
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.String r2 = "Number too large: "
            java.lang.String r0 = r0.readUtf8()
            java.lang.String r0 = kotlin.jvm.internal.Intrinsics.stringPlus(r2, r0)
            r1.<init>(r0)
            throw r1
        L_0x0070:
            if (r0 == 0) goto L_0x0074
            r1 = 1
            goto L_0x0084
        L_0x0074:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.String r1 = "Expected leading [0-9a-fA-F] character but was 0x"
            java.lang.String r2 = okio._UtilKt.toHexString((byte) r10)
            java.lang.String r1 = kotlin.jvm.internal.Intrinsics.stringPlus(r1, r2)
            r0.<init>(r1)
            throw r0
        L_0x0084:
            if (r8 != r9) goto L_0x0090
            okio.Segment r7 = r6.pop()
            r14.head = r7
            okio.SegmentPool.recycle(r6)
            goto L_0x0092
        L_0x0090:
            r6.pos = r8
        L_0x0092:
            if (r1 != 0) goto L_0x0098
            okio.Segment r6 = r14.head
            if (r6 != 0) goto L_0x000d
        L_0x0098:
            long r1 = r14.size()
            long r6 = (long) r0
            long r1 = r1 - r6
            r14.setSize$okio(r1)
            return r4
        L_0x00a2:
            java.io.EOFException r0 = new java.io.EOFException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Buffer.readHexadecimalUnsignedLong():long");
    }

    public int readInt() throws EOFException {
        if (size() >= 4) {
            Segment segment = this.head;
            Intrinsics.checkNotNull(segment);
            int i11 = segment.pos;
            int i12 = segment.limit;
            if (((long) (i12 - i11)) < 4) {
                return ((readByte() & 255) << Ascii.CAN) | ((readByte() & 255) << Ascii.DLE) | ((readByte() & 255) << 8) | (readByte() & 255);
            }
            byte[] bArr = segment.data;
            int i13 = i11 + 1;
            int i14 = i13 + 1;
            byte b11 = ((bArr[i11] & 255) << Ascii.CAN) | ((bArr[i13] & 255) << Ascii.DLE);
            int i15 = i14 + 1;
            byte b12 = b11 | ((bArr[i14] & 255) << 8);
            int i16 = i15 + 1;
            byte b13 = b12 | (bArr[i15] & 255);
            setSize$okio(size() - 4);
            if (i16 == i12) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i16;
            }
            return b13;
        }
        throw new EOFException();
    }

    public int readIntLe() throws EOFException {
        return _UtilKt.reverseBytes(readInt());
    }

    public long readLong() throws EOFException {
        if (size() >= 8) {
            Segment segment = this.head;
            Intrinsics.checkNotNull(segment);
            int i11 = segment.pos;
            int i12 = segment.limit;
            if (((long) (i12 - i11)) < 8) {
                return ((((long) readInt()) & 4294967295L) << 32) | (4294967295L & ((long) readInt()));
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
            setSize$okio(size() - 8);
            if (i21 == i12) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i21;
            }
            return j12;
        }
        throw new EOFException();
    }

    public long readLongLe() throws EOFException {
        return _UtilKt.reverseBytes(readLong());
    }

    public short readShort() throws EOFException {
        if (size() >= 2) {
            Segment segment = this.head;
            Intrinsics.checkNotNull(segment);
            int i11 = segment.pos;
            int i12 = segment.limit;
            if (i12 - i11 < 2) {
                return (short) (((readByte() & 255) << 8) | (readByte() & 255));
            }
            byte[] bArr = segment.data;
            int i13 = i11 + 1;
            int i14 = i13 + 1;
            byte b11 = ((bArr[i11] & 255) << 8) | (bArr[i13] & 255);
            setSize$okio(size() - 2);
            if (i14 == i12) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i14;
            }
            return (short) b11;
        }
        throw new EOFException();
    }

    public short readShortLe() throws EOFException {
        return _UtilKt.reverseBytes(readShort());
    }

    @NotNull
    public String readString(@NotNull Charset charset) {
        Intrinsics.checkNotNullParameter(charset, "charset");
        return readString(this.size, charset);
    }

    @NotNull
    @JvmOverloads
    public final UnsafeCursor readUnsafe() {
        return readUnsafe$default(this, (UnsafeCursor) null, 1, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final UnsafeCursor readUnsafe(@NotNull UnsafeCursor unsafeCursor) {
        Intrinsics.checkNotNullParameter(unsafeCursor, "unsafeCursor");
        return _BufferKt.commonReadUnsafe(this, unsafeCursor);
    }

    @NotNull
    public String readUtf8() {
        return readString(this.size, Charsets.UTF_8);
    }

    public int readUtf8CodePoint() throws EOFException {
        byte b11;
        int i11;
        byte b12;
        if (size() != 0) {
            byte b13 = getByte(0);
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
                skip(1);
                return Utf8.REPLACEMENT_CODE_POINT;
            }
            long j11 = (long) i11;
            if (size() >= j11) {
                if (1 < i11) {
                    int i12 = 1;
                    while (true) {
                        int i13 = i12 + 1;
                        long j12 = (long) i12;
                        byte b14 = getByte(j12);
                        if ((b14 & 192) == 128) {
                            b12 = (b12 << 6) | (b14 & Utf8.REPLACEMENT_BYTE);
                            if (i13 >= i11) {
                                break;
                            }
                            i12 = i13;
                        } else {
                            skip(j12);
                            return Utf8.REPLACEMENT_CODE_POINT;
                        }
                    }
                }
                skip(j11);
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
            throw new EOFException("size < " + i11 + ": " + size() + " (to read code point prefixed 0x" + _UtilKt.toHexString(b13) + ')');
        }
        throw new EOFException();
    }

    @Nullable
    public String readUtf8Line() throws EOFException {
        long indexOf = indexOf((byte) 10);
        if (indexOf != -1) {
            return _BufferKt.readUtf8Line(this, indexOf);
        }
        if (size() != 0) {
            return readUtf8(size());
        }
        return null;
    }

    @NotNull
    public String readUtf8LineStrict() throws EOFException {
        return readUtf8LineStrict(Long.MAX_VALUE);
    }

    public boolean request(long j11) {
        return this.size >= j11;
    }

    public void require(long j11) throws EOFException {
        if (this.size < j11) {
            throw new EOFException();
        }
    }

    public int select(@NotNull Options options) {
        Intrinsics.checkNotNullParameter(options, "options");
        int selectPrefix$default = _BufferKt.selectPrefix$default(this, options, false, 2, (Object) null);
        if (selectPrefix$default == -1) {
            return -1;
        }
        skip((long) options.getByteStrings$okio()[selectPrefix$default].size());
        return selectPrefix$default;
    }

    public final void setSize$okio(long j11) {
        this.size = j11;
    }

    @NotNull
    public final ByteString sha1() {
        return digest("SHA-1");
    }

    @NotNull
    public final ByteString sha256() {
        return digest(Constants.SHA256);
    }

    @NotNull
    public final ByteString sha512() {
        return digest("SHA-512");
    }

    @JvmName(name = "size")
    public final long size() {
        return this.size;
    }

    public void skip(long j11) throws EOFException {
        while (j11 > 0) {
            Segment segment = this.head;
            if (segment != null) {
                int min = (int) Math.min(j11, (long) (segment.limit - segment.pos));
                long j12 = (long) min;
                setSize$okio(size() - j12);
                j11 -= j12;
                int i11 = segment.pos + min;
                segment.pos = i11;
                if (i11 == segment.limit) {
                    this.head = segment.pop();
                    SegmentPool.recycle(segment);
                }
            } else {
                throw new EOFException();
            }
        }
    }

    @NotNull
    public final ByteString snapshot() {
        if (size() <= 2147483647L) {
            return snapshot((int) size());
        }
        throw new IllegalStateException(Intrinsics.stringPlus("size > Int.MAX_VALUE: ", Long.valueOf(size())).toString());
    }

    @NotNull
    public Timeout timeout() {
        return Timeout.NONE;
    }

    @NotNull
    public String toString() {
        return snapshot().toString();
    }

    @NotNull
    public final Segment writableSegment$okio(int i11) {
        boolean z11 = true;
        if (i11 < 1 || i11 > 8192) {
            z11 = false;
        }
        if (z11) {
            Segment segment = this.head;
            if (segment == null) {
                Segment take = SegmentPool.take();
                this.head = take;
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

    public long writeAll(@NotNull Source source) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        long j11 = 0;
        while (true) {
            long read = source.read(this, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
            if (read == -1) {
                return j11;
            }
            j11 += read;
        }
    }

    @NotNull
    @JvmOverloads
    public final Buffer writeTo(@NotNull OutputStream outputStream) throws IOException {
        Intrinsics.checkNotNullParameter(outputStream, "out");
        return writeTo$default(this, outputStream, 0, 2, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final Buffer writeTo(@NotNull OutputStream outputStream, long j11) throws IOException {
        Intrinsics.checkNotNullParameter(outputStream, "out");
        _UtilKt.checkOffsetAndCount(this.size, 0, j11);
        Segment segment = this.head;
        while (j11 > 0) {
            Intrinsics.checkNotNull(segment);
            int min = (int) Math.min(j11, (long) (segment.limit - segment.pos));
            outputStream.write(segment.data, segment.pos, min);
            int i11 = segment.pos + min;
            segment.pos = i11;
            long j12 = (long) min;
            this.size -= j12;
            j11 -= j12;
            if (i11 == segment.limit) {
                Segment pop = segment.pop();
                this.head = pop;
                SegmentPool.recycle(segment);
                segment = pop;
            }
        }
        return this;
    }

    public static /* synthetic */ Buffer copyTo$default(Buffer buffer, Buffer buffer2, long j11, long j12, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            j11 = 0;
        }
        return buffer.copyTo(buffer2, j11, j12);
    }

    @NotNull
    public Buffer clone() {
        return copy();
    }

    public long indexOf(byte b11, long j11) {
        return indexOf(b11, j11, Long.MAX_VALUE);
    }

    public long indexOfElement(@NotNull ByteString byteString, long j11) {
        long j12;
        int i11;
        int i12;
        int i13;
        Intrinsics.checkNotNullParameter(byteString, "targetBytes");
        long j13 = 0;
        if (j11 >= 0) {
            Segment segment = this.head;
            if (segment == null) {
                return -1;
            }
            if (size() - j11 < j11) {
                j12 = size();
                while (j12 > j11) {
                    segment = segment.prev;
                    Intrinsics.checkNotNull(segment);
                    j12 -= (long) (segment.limit - segment.pos);
                }
                if (byteString.size() == 2) {
                    byte b11 = byteString.getByte(0);
                    byte b12 = byteString.getByte(1);
                    while (j12 < size()) {
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
                    return -1;
                }
                byte[] internalArray$okio = byteString.internalArray$okio();
                while (j12 < size()) {
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
                while (j12 < size()) {
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
                return -1;
            }
            byte[] internalArray$okio2 = byteString.internalArray$okio();
            while (j12 < size()) {
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
            return -1;
            i13 = segment.pos;
            return ((long) (i12 - i13)) + j12;
        }
        throw new IllegalArgumentException(Intrinsics.stringPlus("fromIndex < 0: ", Long.valueOf(j11)).toString());
    }

    public boolean rangeEquals(long j11, @NotNull ByteString byteString, int i11, int i12) {
        Intrinsics.checkNotNullParameter(byteString, "bytes");
        if (j11 < 0 || i11 < 0 || i12 < 0 || size() - j11 < ((long) i12) || byteString.size() - i11 < i12) {
            return false;
        }
        if (i12 > 0) {
            int i13 = 0;
            while (true) {
                int i14 = i13 + 1;
                if (getByte(((long) i13) + j11) != byteString.getByte(i13 + i11)) {
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

    @NotNull
    public byte[] readByteArray(long j11) throws EOFException {
        if (!(j11 >= 0 && j11 <= 2147483647L)) {
            throw new IllegalArgumentException(Intrinsics.stringPlus("byteCount: ", Long.valueOf(j11)).toString());
        } else if (size() >= j11) {
            byte[] bArr = new byte[((int) j11)];
            readFully(bArr);
            return bArr;
        } else {
            throw new EOFException();
        }
    }

    @NotNull
    public ByteString readByteString(long j11) throws EOFException {
        if (!(j11 >= 0 && j11 <= 2147483647L)) {
            throw new IllegalArgumentException(Intrinsics.stringPlus("byteCount: ", Long.valueOf(j11)).toString());
        } else if (size() < j11) {
            throw new EOFException();
        } else if (j11 < PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM) {
            return new ByteString(readByteArray(j11));
        } else {
            ByteString snapshot = snapshot((int) j11);
            skip(j11);
            return snapshot;
        }
    }

    @NotNull
    public final Buffer readFrom(@NotNull InputStream inputStream, long j11) throws IOException {
        Intrinsics.checkNotNullParameter(inputStream, "input");
        if (j11 >= 0) {
            readFrom(inputStream, j11, false);
            return this;
        }
        throw new IllegalArgumentException(Intrinsics.stringPlus("byteCount < 0: ", Long.valueOf(j11)).toString());
    }

    @NotNull
    public String readString(long j11, @NotNull Charset charset) throws EOFException {
        Intrinsics.checkNotNullParameter(charset, "charset");
        int i11 = (j11 > 0 ? 1 : (j11 == 0 ? 0 : -1));
        if (!(i11 >= 0 && j11 <= 2147483647L)) {
            throw new IllegalArgumentException(Intrinsics.stringPlus("byteCount: ", Long.valueOf(j11)).toString());
        } else if (this.size < j11) {
            throw new EOFException();
        } else if (i11 == 0) {
            return "";
        } else {
            Segment segment = this.head;
            Intrinsics.checkNotNull(segment);
            int i12 = segment.pos;
            if (((long) i12) + j11 > ((long) segment.limit)) {
                return new String(readByteArray(j11), charset);
            }
            int i13 = (int) j11;
            String str = new String(segment.data, i12, i13, charset);
            int i14 = segment.pos + i13;
            segment.pos = i14;
            this.size -= j11;
            if (i14 == segment.limit) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            }
            return str;
        }
    }

    @NotNull
    public String readUtf8(long j11) throws EOFException {
        return readString(j11, Charsets.UTF_8);
    }

    @NotNull
    public String readUtf8LineStrict(long j11) throws EOFException {
        if (j11 >= 0) {
            long j12 = Long.MAX_VALUE;
            if (j11 != Long.MAX_VALUE) {
                j12 = j11 + 1;
            }
            byte b11 = (byte) 10;
            long indexOf = indexOf(b11, 0, j12);
            if (indexOf != -1) {
                return _BufferKt.readUtf8Line(this, indexOf);
            }
            if (j12 < size() && getByte(j12 - 1) == ((byte) 13) && getByte(j12) == b11) {
                return _BufferKt.readUtf8Line(this, j12);
            }
            Buffer buffer = new Buffer();
            copyTo(buffer, 0, Math.min((long) 32, size()));
            throw new EOFException("\\n not found: limit=" + Math.min(size(), j11) + " content=" + buffer.readByteString().hex() + Typography.ellipsis);
        }
        throw new IllegalArgumentException(Intrinsics.stringPlus("limit < 0: ", Long.valueOf(j11)).toString());
    }

    @NotNull
    public Buffer writeByte(int i11) {
        Segment writableSegment$okio = writableSegment$okio(1);
        byte[] bArr = writableSegment$okio.data;
        int i12 = writableSegment$okio.limit;
        writableSegment$okio.limit = i12 + 1;
        bArr[i12] = (byte) i11;
        setSize$okio(size() + 1);
        return this;
    }

    @NotNull
    public Buffer writeDecimalLong(long j11) {
        boolean z11;
        int i11 = (j11 > 0 ? 1 : (j11 == 0 ? 0 : -1));
        if (i11 == 0) {
            return writeByte(48);
        }
        int i12 = 1;
        if (i11 < 0) {
            j11 = -j11;
            if (j11 < 0) {
                return writeUtf8("-9223372036854775808");
            }
            z11 = true;
        } else {
            z11 = false;
        }
        if (j11 >= 100000000) {
            i12 = j11 < MediaPeriodQueue.INITIAL_RENDERER_POSITION_OFFSET_US ? j11 < RealConnection.IDLE_CONNECTION_HEALTHY_NS ? j11 < C.NANOS_PER_SECOND ? 9 : 10 : j11 < 100000000000L ? 11 : 12 : j11 < 1000000000000000L ? j11 < 10000000000000L ? 13 : j11 < 100000000000000L ? 14 : 15 : j11 < 100000000000000000L ? j11 < 10000000000000000L ? 16 : 17 : j11 < 1000000000000000000L ? 18 : 19;
        } else if (j11 >= 10000) {
            i12 = j11 < 1000000 ? j11 < 100000 ? 5 : 6 : j11 < 10000000 ? 7 : 8;
        } else if (j11 >= 100) {
            i12 = j11 < 1000 ? 3 : 4;
        } else if (j11 >= 10) {
            i12 = 2;
        }
        if (z11) {
            i12++;
        }
        Segment writableSegment$okio = writableSegment$okio(i12);
        byte[] bArr = writableSegment$okio.data;
        int i13 = writableSegment$okio.limit + i12;
        while (j11 != 0) {
            long j12 = (long) 10;
            i13--;
            bArr[i13] = _BufferKt.getHEX_DIGIT_BYTES()[(int) (j11 % j12)];
            j11 /= j12;
        }
        if (z11) {
            bArr[i13 - 1] = (byte) 45;
        }
        writableSegment$okio.limit += i12;
        setSize$okio(size() + ((long) i12));
        return this;
    }

    @NotNull
    public Buffer writeHexadecimalUnsignedLong(long j11) {
        if (j11 == 0) {
            return writeByte(48);
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
        Segment writableSegment$okio = writableSegment$okio(i11);
        byte[] bArr = writableSegment$okio.data;
        int i12 = writableSegment$okio.limit;
        for (int i13 = (i12 + i11) - 1; i13 >= i12; i13--) {
            bArr[i13] = _BufferKt.getHEX_DIGIT_BYTES()[(int) (15 & j11)];
            j11 >>>= 4;
        }
        writableSegment$okio.limit += i11;
        setSize$okio(size() + ((long) i11));
        return this;
    }

    @NotNull
    public Buffer writeInt(int i11) {
        Segment writableSegment$okio = writableSegment$okio(4);
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
        setSize$okio(size() + 4);
        return this;
    }

    @NotNull
    public Buffer writeIntLe(int i11) {
        return writeInt(_UtilKt.reverseBytes(i11));
    }

    @NotNull
    public Buffer writeLong(long j11) {
        Segment writableSegment$okio = writableSegment$okio(8);
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
        setSize$okio(size() + 8);
        return this;
    }

    @NotNull
    public Buffer writeLongLe(long j11) {
        return writeLong(_UtilKt.reverseBytes(j11));
    }

    @NotNull
    public Buffer writeShort(int i11) {
        Segment writableSegment$okio = writableSegment$okio(2);
        byte[] bArr = writableSegment$okio.data;
        int i12 = writableSegment$okio.limit;
        int i13 = i12 + 1;
        bArr[i12] = (byte) ((i11 >>> 8) & 255);
        bArr[i13] = (byte) (i11 & 255);
        writableSegment$okio.limit = i13 + 1;
        setSize$okio(size() + 2);
        return this;
    }

    @NotNull
    public Buffer writeShortLe(int i11) {
        return writeShort((int) _UtilKt.reverseBytes((short) i11));
    }

    @NotNull
    public Buffer writeUtf8CodePoint(int i11) {
        if (i11 < 128) {
            writeByte(i11);
        } else if (i11 < 2048) {
            Segment writableSegment$okio = writableSegment$okio(2);
            byte[] bArr = writableSegment$okio.data;
            int i12 = writableSegment$okio.limit;
            bArr[i12] = (byte) ((i11 >> 6) | 192);
            bArr[i12 + 1] = (byte) ((i11 & 63) | 128);
            writableSegment$okio.limit = i12 + 2;
            setSize$okio(size() + 2);
        } else {
            boolean z11 = false;
            if (55296 <= i11 && i11 <= 57343) {
                z11 = true;
            }
            if (z11) {
                writeByte(63);
            } else if (i11 < 65536) {
                Segment writableSegment$okio2 = writableSegment$okio(3);
                byte[] bArr2 = writableSegment$okio2.data;
                int i13 = writableSegment$okio2.limit;
                bArr2[i13] = (byte) ((i11 >> 12) | 224);
                bArr2[i13 + 1] = (byte) (((i11 >> 6) & 63) | 128);
                bArr2[i13 + 2] = (byte) ((i11 & 63) | 128);
                writableSegment$okio2.limit = i13 + 3;
                setSize$okio(size() + 3);
            } else if (i11 <= 1114111) {
                Segment writableSegment$okio3 = writableSegment$okio(4);
                byte[] bArr3 = writableSegment$okio3.data;
                int i14 = writableSegment$okio3.limit;
                bArr3[i14] = (byte) ((i11 >> 18) | PsExtractor.VIDEO_STREAM_MASK);
                bArr3[i14 + 1] = (byte) (((i11 >> 12) & 63) | 128);
                bArr3[i14 + 2] = (byte) (((i11 >> 6) & 63) | 128);
                bArr3[i14 + 3] = (byte) ((i11 & 63) | 128);
                writableSegment$okio3.limit = i14 + 4;
                setSize$okio(size() + 4);
            } else {
                throw new IllegalArgumentException(Intrinsics.stringPlus("Unexpected code point: 0x", _UtilKt.toHexString(i11)));
            }
        }
        return this;
    }

    public static /* synthetic */ Buffer copyTo$default(Buffer buffer, Buffer buffer2, long j11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            j11 = 0;
        }
        return buffer.copyTo(buffer2, j11);
    }

    public long indexOf(@NotNull ByteString byteString) throws IOException {
        Intrinsics.checkNotNullParameter(byteString, "bytes");
        return indexOf(byteString, 0);
    }

    @NotNull
    public Buffer writeString(@NotNull String str, @NotNull Charset charset) {
        Intrinsics.checkNotNullParameter(str, TypedValues.Custom.S_STRING);
        Intrinsics.checkNotNullParameter(charset, "charset");
        return writeString(str, 0, str.length(), charset);
    }

    @NotNull
    public Buffer writeUtf8(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, TypedValues.Custom.S_STRING);
        return writeUtf8(str, 0, str.length());
    }

    private final void readFrom(InputStream inputStream, long j11, boolean z11) throws IOException {
        while (true) {
            if (j11 > 0 || z11) {
                Segment writableSegment$okio = writableSegment$okio(1);
                int read = inputStream.read(writableSegment$okio.data, writableSegment$okio.limit, (int) Math.min(j11, (long) (8192 - writableSegment$okio.limit)));
                if (read == -1) {
                    if (writableSegment$okio.pos == writableSegment$okio.limit) {
                        this.head = writableSegment$okio.pop();
                        SegmentPool.recycle(writableSegment$okio);
                    }
                    if (!z11) {
                        throw new EOFException();
                    }
                    return;
                }
                writableSegment$okio.limit += read;
                long j12 = (long) read;
                this.size += j12;
                j11 -= j12;
            } else {
                return;
            }
        }
    }

    public long indexOf(byte b11, long j11, long j12) {
        Segment segment;
        long j13;
        int i11;
        long j14 = 0;
        boolean z11 = false;
        if (0 <= j11 && j11 <= j12) {
            z11 = true;
        }
        if (z11) {
            if (j12 > size()) {
                j12 = size();
            }
            long j15 = j12;
            if (j11 == j15 || (segment = this.head) == null) {
                return -1;
            }
            if (size() - j11 < j11) {
                j13 = size();
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
        throw new IllegalArgumentException(("size=" + size() + " fromIndex=" + j11 + " toIndex=" + j12).toString());
    }

    @NotNull
    public final ByteString snapshot(int i11) {
        if (i11 == 0) {
            return ByteString.EMPTY;
        }
        _UtilKt.checkOffsetAndCount(size(), 0, (long) i11);
        Segment segment = this.head;
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
        Segment segment2 = this.head;
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
    public Buffer writeUtf8(@NotNull String str, int i11, int i12) {
        char charAt;
        Intrinsics.checkNotNullParameter(str, TypedValues.Custom.S_STRING);
        if (i11 >= 0) {
            if (i12 >= i11) {
                if (i12 <= str.length()) {
                    while (i11 < i12) {
                        char charAt2 = str.charAt(i11);
                        if (charAt2 < 128) {
                            Segment writableSegment$okio = writableSegment$okio(1);
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
                                    setSize$okio(size() + ((long) i16));
                                } else {
                                    i14 = i11 + 1;
                                    bArr[i11 + i13] = (byte) charAt;
                                }
                            }
                            int i152 = writableSegment$okio.limit;
                            int i162 = (i13 + i11) - i152;
                            writableSegment$okio.limit = i152 + i162;
                            setSize$okio(size() + ((long) i162));
                        } else {
                            if (charAt2 < 2048) {
                                Segment writableSegment$okio2 = writableSegment$okio(2);
                                byte[] bArr2 = writableSegment$okio2.data;
                                int i17 = writableSegment$okio2.limit;
                                bArr2[i17] = (byte) ((charAt2 >> 6) | 192);
                                bArr2[i17 + 1] = (byte) ((charAt2 & '?') | 128);
                                writableSegment$okio2.limit = i17 + 2;
                                setSize$okio(size() + 2);
                            } else if (charAt2 < 55296 || charAt2 > 57343) {
                                Segment writableSegment$okio3 = writableSegment$okio(3);
                                byte[] bArr3 = writableSegment$okio3.data;
                                int i18 = writableSegment$okio3.limit;
                                bArr3[i18] = (byte) ((charAt2 >> 12) | 224);
                                bArr3[i18 + 1] = (byte) ((63 & (charAt2 >> 6)) | 128);
                                bArr3[i18 + 2] = (byte) ((charAt2 & '?') | 128);
                                writableSegment$okio3.limit = i18 + 3;
                                setSize$okio(size() + 3);
                            } else {
                                int i19 = i11 + 1;
                                char charAt3 = i19 < i12 ? str.charAt(i19) : 0;
                                if (charAt2 <= 56319) {
                                    if (56320 <= charAt3 && charAt3 <= 57343) {
                                        int i21 = (((charAt2 & 1023) << 10) | (charAt3 & 1023)) + 0;
                                        Segment writableSegment$okio4 = writableSegment$okio(4);
                                        byte[] bArr4 = writableSegment$okio4.data;
                                        int i22 = writableSegment$okio4.limit;
                                        bArr4[i22] = (byte) ((i21 >> 18) | PsExtractor.VIDEO_STREAM_MASK);
                                        bArr4[i22 + 1] = (byte) (((i21 >> 12) & 63) | 128);
                                        bArr4[i22 + 2] = (byte) (((i21 >> 6) & 63) | 128);
                                        bArr4[i22 + 3] = (byte) ((i21 & 63) | 128);
                                        writableSegment$okio4.limit = i22 + 4;
                                        setSize$okio(size() + 4);
                                        i11 += 2;
                                    }
                                }
                                writeByte(63);
                                i11 = i19;
                            }
                            i11++;
                        }
                    }
                    return this;
                }
                throw new IllegalArgumentException(("endIndex > string.length: " + i12 + " > " + str.length()).toString());
            }
            throw new IllegalArgumentException(("endIndex < beginIndex: " + i12 + " < " + i11).toString());
        }
        throw new IllegalArgumentException(Intrinsics.stringPlus("beginIndex < 0: ", Integer.valueOf(i11)).toString());
    }

    public void readFully(@NotNull byte[] bArr) throws EOFException {
        Intrinsics.checkNotNullParameter(bArr, "sink");
        int i11 = 0;
        while (i11 < bArr.length) {
            int read = read(bArr, i11, bArr.length - i11);
            if (read != -1) {
                i11 += read;
            } else {
                throw new EOFException();
            }
        }
    }

    @NotNull
    public Buffer writeString(@NotNull String str, int i11, int i12, @NotNull Charset charset) {
        Intrinsics.checkNotNullParameter(str, TypedValues.Custom.S_STRING);
        Intrinsics.checkNotNullParameter(charset, "charset");
        boolean z11 = true;
        if (i11 >= 0) {
            if (i12 >= i11) {
                if (i12 > str.length()) {
                    z11 = false;
                }
                if (!z11) {
                    throw new IllegalArgumentException(("endIndex > string.length: " + i12 + " > " + str.length()).toString());
                } else if (Intrinsics.areEqual((Object) charset, (Object) Charsets.UTF_8)) {
                    return writeUtf8(str, i11, i12);
                } else {
                    String substring = str.substring(i11, i12);
                    Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    if (substring != null) {
                        byte[] bytes = substring.getBytes(charset);
                        Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
                        return write(bytes, 0, bytes.length);
                    }
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
            } else {
                throw new IllegalArgumentException(("endIndex < beginIndex: " + i12 + " < " + i11).toString());
            }
        } else {
            throw new IllegalArgumentException(Intrinsics.stringPlus("beginIndex < 0: ", Integer.valueOf(i11)).toString());
        }
    }

    public int write(@NotNull ByteBuffer byteBuffer) throws IOException {
        Intrinsics.checkNotNullParameter(byteBuffer, "source");
        int remaining = byteBuffer.remaining();
        int i11 = remaining;
        while (i11 > 0) {
            Segment writableSegment$okio = writableSegment$okio(1);
            int min = Math.min(i11, 8192 - writableSegment$okio.limit);
            byteBuffer.get(writableSegment$okio.data, writableSegment$okio.limit, min);
            i11 -= min;
            writableSegment$okio.limit += min;
        }
        this.size += (long) remaining;
        return remaining;
    }

    public int read(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "sink");
        return read(bArr, 0, bArr.length);
    }

    @NotNull
    public final Buffer copyTo(@NotNull Buffer buffer, long j11) {
        Intrinsics.checkNotNullParameter(buffer, "out");
        return copyTo(buffer, j11, this.size - j11);
    }

    public int read(@NotNull byte[] bArr, int i11, int i12) {
        Intrinsics.checkNotNullParameter(bArr, "sink");
        _UtilKt.checkOffsetAndCount((long) bArr.length, (long) i11, (long) i12);
        Segment segment = this.head;
        if (segment == null) {
            return -1;
        }
        int min = Math.min(i12, segment.limit - segment.pos);
        byte[] bArr2 = segment.data;
        int i13 = segment.pos;
        byte[] unused = ArraysKt___ArraysJvmKt.copyInto(bArr2, bArr, i11, i13, i13 + min);
        segment.pos += min;
        setSize$okio(size() - ((long) min));
        if (segment.pos == segment.limit) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        }
        return min;
    }

    @NotNull
    public final Buffer copyTo(@NotNull Buffer buffer, long j11, long j12) {
        Intrinsics.checkNotNullParameter(buffer, "out");
        _UtilKt.checkOffsetAndCount(size(), j11, j12);
        if (j12 != 0) {
            buffer.setSize$okio(buffer.size() + j12);
            Segment segment = this.head;
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
                Segment segment2 = buffer.head;
                if (segment2 == null) {
                    sharedCopy.prev = sharedCopy;
                    sharedCopy.next = sharedCopy;
                    buffer.head = sharedCopy;
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
        }
        return this;
    }

    @NotNull
    public Buffer write(@NotNull ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "byteString");
        byteString.write$okio(this, 0, byteString.size());
        return this;
    }

    @NotNull
    public Buffer write(@NotNull ByteString byteString, int i11, int i12) {
        Intrinsics.checkNotNullParameter(byteString, "byteString");
        byteString.write$okio(this, i11, i12);
        return this;
    }

    @NotNull
    public Buffer write(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "source");
        return write(bArr, 0, bArr.length);
    }

    @NotNull
    public Buffer write(@NotNull byte[] bArr, int i11, int i12) {
        Intrinsics.checkNotNullParameter(bArr, "source");
        long j11 = (long) i12;
        _UtilKt.checkOffsetAndCount((long) bArr.length, (long) i11, j11);
        int i13 = i12 + i11;
        while (i11 < i13) {
            Segment writableSegment$okio = writableSegment$okio(1);
            int min = Math.min(i13 - i11, 8192 - writableSegment$okio.limit);
            int i14 = i11 + min;
            byte[] unused = ArraysKt___ArraysJvmKt.copyInto(bArr, writableSegment$okio.data, writableSegment$okio.limit, i11, i14);
            writableSegment$okio.limit += min;
            i11 = i14;
        }
        setSize$okio(size() + j11);
        return this;
    }

    public long read(@NotNull Buffer buffer, long j11) {
        Intrinsics.checkNotNullParameter(buffer, "sink");
        if (!(j11 >= 0)) {
            throw new IllegalArgumentException(Intrinsics.stringPlus("byteCount < 0: ", Long.valueOf(j11)).toString());
        } else if (size() == 0) {
            return -1;
        } else {
            if (j11 > size()) {
                j11 = size();
            }
            buffer.write(this, j11);
            return j11;
        }
    }

    @NotNull
    public Buffer write(@NotNull Source source, long j11) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        while (j11 > 0) {
            long read = source.read(this, j11);
            if (read != -1) {
                j11 -= read;
            } else {
                throw new EOFException();
            }
        }
        return this;
    }

    public long indexOf(@NotNull ByteString byteString, long j11) throws IOException {
        Intrinsics.checkNotNullParameter(byteString, "bytes");
        if (byteString.size() > 0) {
            long j12 = 0;
            if (j11 >= 0) {
                Segment segment = this.head;
                if (segment != null) {
                    if (size() - j11 < j11) {
                        long size2 = size();
                        while (size2 > j11) {
                            segment = segment.prev;
                            Intrinsics.checkNotNull(segment);
                            size2 -= (long) (segment.limit - segment.pos);
                        }
                        byte[] internalArray$okio = byteString.internalArray$okio();
                        byte b11 = internalArray$okio[0];
                        int size3 = byteString.size();
                        long size4 = (size() - ((long) size3)) + 1;
                        long j13 = size2;
                        long j14 = j11;
                        while (j13 < size4) {
                            byte[] bArr = segment.data;
                            int min = (int) Math.min((long) segment.limit, (((long) segment.pos) + size4) - j13);
                            int i11 = (int) ((((long) segment.pos) + j14) - j13);
                            if (i11 < min) {
                                while (true) {
                                    int i12 = i11 + 1;
                                    if (bArr[i11] == b11 && _BufferKt.rangeEquals(segment, i12, internalArray$okio, 1, size3)) {
                                        return ((long) (i11 - segment.pos)) + j13;
                                    }
                                    if (i12 >= min) {
                                        break;
                                    }
                                    i11 = i12;
                                }
                            }
                            j13 += (long) (segment.limit - segment.pos);
                            segment = segment.next;
                            Intrinsics.checkNotNull(segment);
                            j14 = j13;
                        }
                    } else {
                        while (true) {
                            long j15 = ((long) (segment.limit - segment.pos)) + j12;
                            if (j15 > j11) {
                                break;
                            }
                            segment = segment.next;
                            Intrinsics.checkNotNull(segment);
                            j12 = j15;
                        }
                        byte[] internalArray$okio2 = byteString.internalArray$okio();
                        byte b12 = internalArray$okio2[0];
                        int size5 = byteString.size();
                        long size6 = (size() - ((long) size5)) + 1;
                        long j16 = j12;
                        long j17 = j11;
                        while (j16 < size6) {
                            byte[] bArr2 = segment.data;
                            long j18 = size6;
                            int min2 = (int) Math.min((long) segment.limit, (((long) segment.pos) + size6) - j16);
                            int i13 = (int) ((((long) segment.pos) + j17) - j16);
                            if (i13 < min2) {
                                while (true) {
                                    int i14 = i13 + 1;
                                    if (bArr2[i13] == b12 && _BufferKt.rangeEquals(segment, i14, internalArray$okio2, 1, size5)) {
                                        return ((long) (i13 - segment.pos)) + j16;
                                    }
                                    if (i14 >= min2) {
                                        break;
                                    }
                                    i13 = i14;
                                }
                            }
                            j16 += (long) (segment.limit - segment.pos);
                            segment = segment.next;
                            Intrinsics.checkNotNull(segment);
                            j17 = j16;
                            size6 = j18;
                        }
                    }
                }
                return -1;
            }
            throw new IllegalArgumentException(Intrinsics.stringPlus("fromIndex < 0: ", Long.valueOf(j11)).toString());
        }
        throw new IllegalArgumentException("bytes is empty".toString());
    }

    public void write(@NotNull Buffer buffer, long j11) {
        Segment segment;
        Intrinsics.checkNotNullParameter(buffer, "source");
        if (buffer != this) {
            _UtilKt.checkOffsetAndCount(buffer.size(), 0, j11);
            while (j11 > 0) {
                Segment segment2 = buffer.head;
                Intrinsics.checkNotNull(segment2);
                int i11 = segment2.limit;
                Segment segment3 = buffer.head;
                Intrinsics.checkNotNull(segment3);
                if (j11 < ((long) (i11 - segment3.pos))) {
                    Segment segment4 = this.head;
                    if (segment4 != null) {
                        Intrinsics.checkNotNull(segment4);
                        segment = segment4.prev;
                    } else {
                        segment = null;
                    }
                    if (segment != null && segment.owner) {
                        if ((((long) segment.limit) + j11) - ((long) (segment.shared ? 0 : segment.pos)) <= PlaybackStateCompat.ACTION_PLAY_FROM_URI) {
                            Segment segment5 = buffer.head;
                            Intrinsics.checkNotNull(segment5);
                            segment5.writeTo(segment, (int) j11);
                            buffer.setSize$okio(buffer.size() - j11);
                            setSize$okio(size() + j11);
                            return;
                        }
                    }
                    Segment segment6 = buffer.head;
                    Intrinsics.checkNotNull(segment6);
                    buffer.head = segment6.split((int) j11);
                }
                Segment segment7 = buffer.head;
                Intrinsics.checkNotNull(segment7);
                long j12 = (long) (segment7.limit - segment7.pos);
                buffer.head = segment7.pop();
                Segment segment8 = this.head;
                if (segment8 == null) {
                    this.head = segment7;
                    segment7.prev = segment7;
                    segment7.next = segment7;
                } else {
                    Intrinsics.checkNotNull(segment8);
                    Segment segment9 = segment8.prev;
                    Intrinsics.checkNotNull(segment9);
                    segment9.push(segment7).compact();
                }
                buffer.setSize$okio(buffer.size() - j12);
                setSize$okio(size() + j12);
                j11 -= j12;
            }
            return;
        }
        throw new IllegalArgumentException("source == this".toString());
    }
}
