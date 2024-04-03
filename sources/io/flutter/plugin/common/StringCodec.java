package io.flutter.plugin.common;

import androidx.annotation.Nullable;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public final class StringCodec implements MessageCodec<String> {
    public static final StringCodec INSTANCE = new StringCodec();
    private static final Charset UTF8 = Charset.forName("UTF8");

    private StringCodec() {
    }

    @Nullable
    public String decodeMessage(@Nullable ByteBuffer byteBuffer) {
        int i11;
        byte[] bArr;
        if (byteBuffer == null) {
            return null;
        }
        int remaining = byteBuffer.remaining();
        if (byteBuffer.hasArray()) {
            bArr = byteBuffer.array();
            i11 = byteBuffer.arrayOffset();
        } else {
            bArr = new byte[remaining];
            byteBuffer.get(bArr);
            i11 = 0;
        }
        return new String(bArr, i11, remaining, UTF8);
    }

    @Nullable
    public ByteBuffer encodeMessage(@Nullable String str) {
        if (str == null) {
            return null;
        }
        byte[] bytes = str.getBytes(UTF8);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(bytes.length);
        allocateDirect.put(bytes);
        return allocateDirect;
    }
}
