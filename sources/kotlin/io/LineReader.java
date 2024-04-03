package kotlin.io;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0014\u001a\u00020\u0004H\u0002J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0010H\u0002J\u0018\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0004H\u0002J\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fJ\b\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020!H\u0002J\u0010\u0010#\u001a\u00020!2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00060\u0012j\u0002`\u0013X\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lkotlin/io/LineReader;", "", "()V", "BUFFER_SIZE", "", "byteBuf", "Ljava/nio/ByteBuffer;", "bytes", "", "charBuf", "Ljava/nio/CharBuffer;", "chars", "", "decoder", "Ljava/nio/charset/CharsetDecoder;", "directEOL", "", "sb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "compactBytes", "decode", "endOfInput", "decodeEndOfInput", "nBytes", "nChars", "readLine", "", "inputStream", "Ljava/io/InputStream;", "charset", "Ljava/nio/charset/Charset;", "resetAll", "", "trimStringBuilder", "updateCharset", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class LineReader {
    private static final int BUFFER_SIZE = 32;
    @NotNull
    public static final LineReader INSTANCE = new LineReader();
    @NotNull
    private static final ByteBuffer byteBuf;
    @NotNull
    private static final byte[] bytes;
    @NotNull
    private static final CharBuffer charBuf;
    @NotNull
    private static final char[] chars;
    private static CharsetDecoder decoder;
    private static boolean directEOL;
    @NotNull

    /* renamed from: sb  reason: collision with root package name */
    private static final StringBuilder f23872sb = new StringBuilder();

    static {
        byte[] bArr = new byte[32];
        bytes = bArr;
        char[] cArr = new char[32];
        chars = cArr;
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        Intrinsics.checkNotNullExpressionValue(wrap, "wrap(bytes)");
        byteBuf = wrap;
        CharBuffer wrap2 = CharBuffer.wrap(cArr);
        Intrinsics.checkNotNullExpressionValue(wrap2, "wrap(chars)");
        charBuf = wrap2;
    }

    private LineReader() {
    }

    private final int compactBytes() {
        ByteBuffer byteBuffer = byteBuf;
        byteBuffer.compact();
        int position = byteBuffer.position();
        byteBuffer.position(0);
        return position;
    }

    private final int decode(boolean z11) {
        while (true) {
            CharsetDecoder charsetDecoder = decoder;
            if (charsetDecoder == null) {
                Intrinsics.throwUninitializedPropertyAccessException("decoder");
                charsetDecoder = null;
            }
            ByteBuffer byteBuffer = byteBuf;
            CharBuffer charBuffer = charBuf;
            CoderResult decode = charsetDecoder.decode(byteBuffer, charBuffer, z11);
            Intrinsics.checkNotNullExpressionValue(decode, "decoder.decode(byteBuf, charBuf, endOfInput)");
            if (decode.isError()) {
                resetAll();
                decode.throwException();
            }
            int position = charBuffer.position();
            if (!decode.isOverflow()) {
                return position;
            }
            StringBuilder sb2 = f23872sb;
            char[] cArr = chars;
            int i11 = position - 1;
            sb2.append(cArr, 0, i11);
            charBuffer.position(0);
            charBuffer.limit(32);
            charBuffer.put(cArr[i11]);
        }
    }

    private final int decodeEndOfInput(int i11, int i12) {
        ByteBuffer byteBuffer = byteBuf;
        byteBuffer.limit(i11);
        charBuf.position(i12);
        int decode = decode(true);
        CharsetDecoder charsetDecoder = decoder;
        if (charsetDecoder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("decoder");
            charsetDecoder = null;
        }
        charsetDecoder.reset();
        byteBuffer.position(0);
        return decode;
    }

    private final void resetAll() {
        CharsetDecoder charsetDecoder = decoder;
        if (charsetDecoder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("decoder");
            charsetDecoder = null;
        }
        charsetDecoder.reset();
        byteBuf.position(0);
        f23872sb.setLength(0);
    }

    private final void trimStringBuilder() {
        StringBuilder sb2 = f23872sb;
        sb2.setLength(32);
        sb2.trimToSize();
    }

    private final void updateCharset(Charset charset) {
        CharsetDecoder newDecoder = charset.newDecoder();
        Intrinsics.checkNotNullExpressionValue(newDecoder, "charset.newDecoder()");
        decoder = newDecoder;
        ByteBuffer byteBuffer = byteBuf;
        byteBuffer.clear();
        CharBuffer charBuffer = charBuf;
        charBuffer.clear();
        byteBuffer.put((byte) 10);
        byteBuffer.flip();
        CharsetDecoder charsetDecoder = decoder;
        if (charsetDecoder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("decoder");
            charsetDecoder = null;
        }
        boolean z11 = false;
        charsetDecoder.decode(byteBuffer, charBuffer, false);
        if (charBuffer.position() == 1 && charBuffer.get(0) == 10) {
            z11 = true;
        }
        directEOL = z11;
        resetAll();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003a, code lost:
        if (f23872sb.length() != 0) goto L_0x003e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003c, code lost:
        r11 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003e, code lost:
        r11 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003f, code lost:
        if (r11 == false) goto L_0x0047;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0041, code lost:
        if (r0 != 0) goto L_0x0047;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0043, code lost:
        if (r2 != 0) goto L_0x0047;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0046, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        r11 = decodeEndOfInput(r0, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0020, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0.charset(), (java.lang.Object) r12) == false) goto L_0x0022;
     */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized java.lang.String readLine(@org.jetbrains.annotations.NotNull java.io.InputStream r11, @org.jetbrains.annotations.NotNull java.nio.charset.Charset r12) {
        /*
            r10 = this;
            monitor-enter(r10)
            java.lang.String r0 = "inputStream"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)     // Catch:{ all -> 0x00c9 }
            java.lang.String r0 = "charset"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)     // Catch:{ all -> 0x00c9 }
            java.nio.charset.CharsetDecoder r0 = decoder     // Catch:{ all -> 0x00c9 }
            r1 = 0
            if (r0 == 0) goto L_0x0022
            if (r0 != 0) goto L_0x0018
            java.lang.String r0 = "decoder"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)     // Catch:{ all -> 0x00c9 }
            r0 = r1
        L_0x0018:
            java.nio.charset.Charset r0 = r0.charset()     // Catch:{ all -> 0x00c9 }
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r12)     // Catch:{ all -> 0x00c9 }
            if (r0 != 0) goto L_0x0025
        L_0x0022:
            r10.updateCharset(r12)     // Catch:{ all -> 0x00c9 }
        L_0x0025:
            r12 = 0
            r0 = r12
            r2 = r0
        L_0x0028:
            int r3 = r11.read()     // Catch:{ all -> 0x00c9 }
            r4 = 32
            r5 = 10
            r6 = -1
            r7 = 1
            if (r3 != r6) goto L_0x004c
            java.lang.StringBuilder r11 = f23872sb     // Catch:{ all -> 0x00c9 }
            int r11 = r11.length()     // Catch:{ all -> 0x00c9 }
            if (r11 != 0) goto L_0x003e
            r11 = r7
            goto L_0x003f
        L_0x003e:
            r11 = r12
        L_0x003f:
            if (r11 == 0) goto L_0x0047
            if (r0 != 0) goto L_0x0047
            if (r2 != 0) goto L_0x0047
            monitor-exit(r10)
            return r1
        L_0x0047:
            int r11 = r10.decodeEndOfInput(r0, r2)     // Catch:{ all -> 0x00c9 }
            goto L_0x007a
        L_0x004c:
            byte[] r6 = bytes     // Catch:{ all -> 0x00c9 }
            int r8 = r0 + 1
            byte r9 = (byte) r3     // Catch:{ all -> 0x00c9 }
            r6[r0] = r9     // Catch:{ all -> 0x00c9 }
            if (r3 == r5) goto L_0x005e
            if (r8 == r4) goto L_0x005e
            boolean r0 = directEOL     // Catch:{ all -> 0x00c9 }
            if (r0 != 0) goto L_0x005c
            goto L_0x005e
        L_0x005c:
            r0 = r8
            goto L_0x0028
        L_0x005e:
            java.nio.ByteBuffer r0 = byteBuf     // Catch:{ all -> 0x00c9 }
            r0.limit(r8)     // Catch:{ all -> 0x00c9 }
            java.nio.CharBuffer r3 = charBuf     // Catch:{ all -> 0x00c9 }
            r3.position(r2)     // Catch:{ all -> 0x00c9 }
            int r2 = r10.decode(r12)     // Catch:{ all -> 0x00c9 }
            if (r2 <= 0) goto L_0x00c3
            char[] r3 = chars     // Catch:{ all -> 0x00c9 }
            int r6 = r2 + -1
            char r3 = r3[r6]     // Catch:{ all -> 0x00c9 }
            if (r3 != r5) goto L_0x00c3
            r0.position(r12)     // Catch:{ all -> 0x00c9 }
            r11 = r2
        L_0x007a:
            if (r11 <= 0) goto L_0x0092
            char[] r0 = chars     // Catch:{ all -> 0x00c9 }
            int r1 = r11 + -1
            char r1 = r0[r1]     // Catch:{ all -> 0x00c9 }
            if (r1 != r5) goto L_0x0092
            int r11 = r11 + -1
            if (r11 <= 0) goto L_0x0092
            int r1 = r11 + -1
            char r0 = r0[r1]     // Catch:{ all -> 0x00c9 }
            r1 = 13
            if (r0 != r1) goto L_0x0092
            int r11 = r11 + -1
        L_0x0092:
            java.lang.StringBuilder r0 = f23872sb     // Catch:{ all -> 0x00c9 }
            int r1 = r0.length()     // Catch:{ all -> 0x00c9 }
            if (r1 != 0) goto L_0x009b
            goto L_0x009c
        L_0x009b:
            r7 = r12
        L_0x009c:
            if (r7 == 0) goto L_0x00a7
            java.lang.String r0 = new java.lang.String     // Catch:{ all -> 0x00c9 }
            char[] r1 = chars     // Catch:{ all -> 0x00c9 }
            r0.<init>(r1, r12, r11)     // Catch:{ all -> 0x00c9 }
            monitor-exit(r10)
            return r0
        L_0x00a7:
            char[] r1 = chars     // Catch:{ all -> 0x00c9 }
            r0.append(r1, r12, r11)     // Catch:{ all -> 0x00c9 }
            java.lang.String r11 = r0.toString()     // Catch:{ all -> 0x00c9 }
            java.lang.String r1 = "sb.toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r1)     // Catch:{ all -> 0x00c9 }
            int r1 = r0.length()     // Catch:{ all -> 0x00c9 }
            if (r1 <= r4) goto L_0x00be
            r10.trimStringBuilder()     // Catch:{ all -> 0x00c9 }
        L_0x00be:
            r0.setLength(r12)     // Catch:{ all -> 0x00c9 }
            monitor-exit(r10)
            return r11
        L_0x00c3:
            int r0 = r10.compactBytes()     // Catch:{ all -> 0x00c9 }
            goto L_0x0028
        L_0x00c9:
            r11 = move-exception
            monitor-exit(r10)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.LineReader.readLine(java.io.InputStream, java.nio.charset.Charset):java.lang.String");
    }
}
