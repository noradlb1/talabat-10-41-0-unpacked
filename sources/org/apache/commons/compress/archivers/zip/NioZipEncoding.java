package org.apache.commons.compress.archivers.zip;

import com.checkout.frames.utils.constants.ExpiryDateConstantsKt;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;
import okio.Utf8;

class NioZipEncoding implements ZipEncoding, CharsetAccessor {
    private static final char[] HEX_CHARS = {'0', ExpiryDateConstantsKt.EXPIRY_DATE_ZERO_POSITION_CHECK, '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private static final char REPLACEMENT = '?';
    private static final byte[] REPLACEMENT_BYTES = {Utf8.REPLACEMENT_BYTE};
    private static final String REPLACEMENT_STRING = String.valueOf(REPLACEMENT);
    private final Charset charset;
    private final boolean useReplacement;

    public NioZipEncoding(Charset charset2, boolean z11) {
        this.charset = charset2;
        this.useReplacement = z11;
    }

    private static ByteBuffer encodeFully(CharsetEncoder charsetEncoder, CharBuffer charBuffer, ByteBuffer byteBuffer) {
        while (charBuffer.hasRemaining()) {
            if (charsetEncoder.encode(charBuffer, byteBuffer, false).isOverflow()) {
                byteBuffer = ZipEncodingHelper.growBufferBy(byteBuffer, estimateIncrementalEncodingSize(charsetEncoder, charBuffer.remaining()));
            }
        }
        return byteBuffer;
    }

    private static CharBuffer encodeSurrogate(CharBuffer charBuffer, char c11) {
        charBuffer.position(0).limit(6);
        charBuffer.put('%');
        charBuffer.put('U');
        char[] cArr = HEX_CHARS;
        charBuffer.put(cArr[(c11 >> 12) & 15]);
        charBuffer.put(cArr[(c11 >> 8) & 15]);
        charBuffer.put(cArr[(c11 >> 4) & 15]);
        charBuffer.put(cArr[c11 & 15]);
        charBuffer.flip();
        return charBuffer;
    }

    private static int estimateIncrementalEncodingSize(CharsetEncoder charsetEncoder, int i11) {
        return (int) Math.ceil((double) (((float) i11) * charsetEncoder.averageBytesPerChar()));
    }

    private static int estimateInitialBufferSize(CharsetEncoder charsetEncoder, int i11) {
        return (int) Math.ceil((double) (charsetEncoder.maxBytesPerChar() + (((float) (i11 - 1)) * charsetEncoder.averageBytesPerChar())));
    }

    private CharsetDecoder newDecoder() {
        if (!this.useReplacement) {
            return this.charset.newDecoder().onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT);
        }
        return this.charset.newDecoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE).replaceWith(REPLACEMENT_STRING);
    }

    private CharsetEncoder newEncoder() {
        if (this.useReplacement) {
            return this.charset.newEncoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE).replaceWith(REPLACEMENT_BYTES);
        }
        return this.charset.newEncoder().onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT);
    }

    public boolean canEncode(String str) {
        return newEncoder().canEncode(str);
    }

    public String decode(byte[] bArr) throws IOException {
        return newDecoder().decode(ByteBuffer.wrap(bArr)).toString();
    }

    public ByteBuffer encode(String str) {
        int i11;
        CharsetEncoder newEncoder = newEncoder();
        CharBuffer wrap = CharBuffer.wrap(str);
        ByteBuffer allocate = ByteBuffer.allocate(estimateInitialBufferSize(newEncoder, wrap.remaining()));
        CharBuffer charBuffer = null;
        while (wrap.hasRemaining()) {
            CoderResult encode = newEncoder.encode(wrap, allocate, false);
            if (!encode.isUnmappable() && !encode.isMalformed()) {
                if (!encode.isOverflow()) {
                    if (encode.isUnderflow() || encode.isError()) {
                        break;
                    }
                } else {
                    allocate = ZipEncodingHelper.growBufferBy(allocate, estimateIncrementalEncodingSize(newEncoder, wrap.remaining()));
                }
            } else {
                if (estimateIncrementalEncodingSize(newEncoder, encode.length() * 6) > allocate.remaining()) {
                    int i12 = 0;
                    for (int position = wrap.position(); position < wrap.limit(); position++) {
                        if (!newEncoder.canEncode(wrap.get(position))) {
                            i11 = 6;
                        } else {
                            i11 = 1;
                        }
                        i12 += i11;
                    }
                    allocate = ZipEncodingHelper.growBufferBy(allocate, estimateIncrementalEncodingSize(newEncoder, i12) - allocate.remaining());
                }
                if (charBuffer == null) {
                    charBuffer = CharBuffer.allocate(6);
                }
                for (int i13 = 0; i13 < encode.length(); i13++) {
                    allocate = encodeFully(newEncoder, encodeSurrogate(charBuffer, wrap.get()), allocate);
                }
            }
        }
        newEncoder.encode(wrap, allocate, true);
        allocate.limit(allocate.position());
        allocate.rewind();
        return allocate;
    }

    public Charset getCharset() {
        return this.charset;
    }
}
