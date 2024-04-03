package com.newrelic.com.google.flatbuffers;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.StandardCharsets;
import ne.a;
import z1.b;

public class Utf8Old extends Utf8 {
    private static final ThreadLocal<Cache> CACHE = new b(new a());

    public static class Cache {
        final CharsetDecoder decoder = StandardCharsets.UTF_8.newDecoder();
        final CharsetEncoder encoder = StandardCharsets.UTF_8.newEncoder();
        CharSequence lastInput = null;
        ByteBuffer lastOutput = null;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Cache lambda$static$0() {
        return new Cache();
    }

    public String decodeUtf8(ByteBuffer byteBuffer, int i11, int i12) {
        CharsetDecoder charsetDecoder = CACHE.get().decoder;
        charsetDecoder.reset();
        ByteBuffer duplicate = byteBuffer.duplicate();
        duplicate.position(i11);
        duplicate.limit(i11 + i12);
        try {
            CharBuffer decode = charsetDecoder.decode(duplicate);
            decode.flip();
            return decode.toString();
        } catch (CharacterCodingException e11) {
            throw new IllegalArgumentException("Bad encoding", e11);
        }
    }

    public void encodeUtf8(CharSequence charSequence, ByteBuffer byteBuffer) {
        Cache cache = CACHE.get();
        if (cache.lastInput != charSequence) {
            encodedLength(charSequence);
        }
        byteBuffer.put(cache.lastOutput);
    }

    public int encodedLength(CharSequence charSequence) {
        CharBuffer charBuffer;
        Cache cache = CACHE.get();
        int length = (int) (((float) charSequence.length()) * cache.encoder.maxBytesPerChar());
        ByteBuffer byteBuffer = cache.lastOutput;
        if (byteBuffer == null || byteBuffer.capacity() < length) {
            cache.lastOutput = ByteBuffer.allocate(Math.max(128, length));
        }
        cache.lastOutput.clear();
        cache.lastInput = charSequence;
        if (charSequence instanceof CharBuffer) {
            charBuffer = (CharBuffer) charSequence;
        } else {
            charBuffer = CharBuffer.wrap(charSequence);
        }
        CoderResult encode = cache.encoder.encode(charBuffer, cache.lastOutput, true);
        if (encode.isError()) {
            try {
                encode.throwException();
            } catch (CharacterCodingException e11) {
                throw new IllegalArgumentException("bad character encoding", e11);
            }
        }
        return cache.lastOutput.remaining();
    }
}
