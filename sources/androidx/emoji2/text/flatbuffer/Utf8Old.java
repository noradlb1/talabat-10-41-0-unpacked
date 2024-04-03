package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.StandardCharsets;
import z1.a;
import z1.b;

public class Utf8Old extends Utf8 {
    private static final ThreadLocal<Cache> CACHE = new b(new a());

    public static class Cache {

        /* renamed from: a  reason: collision with root package name */
        public final CharsetEncoder f35951a = StandardCharsets.UTF_8.newEncoder();

        /* renamed from: b  reason: collision with root package name */
        public final CharsetDecoder f35952b = StandardCharsets.UTF_8.newDecoder();

        /* renamed from: c  reason: collision with root package name */
        public CharSequence f35953c = null;

        /* renamed from: d  reason: collision with root package name */
        public ByteBuffer f35954d = null;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Cache lambda$static$0() {
        return new Cache();
    }

    public String decodeUtf8(ByteBuffer byteBuffer, int i11, int i12) {
        CharsetDecoder charsetDecoder = CACHE.get().f35952b;
        charsetDecoder.reset();
        ByteBuffer duplicate = byteBuffer.duplicate();
        duplicate.position(i11);
        duplicate.limit(i11 + i12);
        try {
            return charsetDecoder.decode(duplicate).toString();
        } catch (CharacterCodingException e11) {
            throw new IllegalArgumentException("Bad encoding", e11);
        }
    }

    public void encodeUtf8(CharSequence charSequence, ByteBuffer byteBuffer) {
        Cache cache = CACHE.get();
        if (cache.f35953c != charSequence) {
            encodedLength(charSequence);
        }
        byteBuffer.put(cache.f35954d);
    }

    public int encodedLength(CharSequence charSequence) {
        CharBuffer charBuffer;
        Cache cache = CACHE.get();
        int length = (int) (((float) charSequence.length()) * cache.f35951a.maxBytesPerChar());
        ByteBuffer byteBuffer = cache.f35954d;
        if (byteBuffer == null || byteBuffer.capacity() < length) {
            cache.f35954d = ByteBuffer.allocate(Math.max(128, length));
        }
        cache.f35954d.clear();
        cache.f35953c = charSequence;
        if (charSequence instanceof CharBuffer) {
            charBuffer = (CharBuffer) charSequence;
        } else {
            charBuffer = CharBuffer.wrap(charSequence);
        }
        CoderResult encode = cache.f35951a.encode(charBuffer, cache.f35954d, true);
        if (encode.isError()) {
            try {
                encode.throwException();
            } catch (CharacterCodingException e11) {
                throw new IllegalArgumentException("bad character encoding", e11);
            }
        }
        cache.f35954d.flip();
        return cache.f35954d.remaining();
    }
}
