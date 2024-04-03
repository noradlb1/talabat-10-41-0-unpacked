package com.airbnb.lottie.parser.moshi;

import java.io.Closeable;
import java.io.IOException;
import java.util.Arrays;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;

public abstract class JsonReader implements Closeable {
    private static final String[] REPLACEMENT_CHARS = new String[128];

    /* renamed from: b  reason: collision with root package name */
    public int f40694b;

    /* renamed from: c  reason: collision with root package name */
    public int[] f40695c = new int[32];

    /* renamed from: d  reason: collision with root package name */
    public String[] f40696d = new String[32];

    /* renamed from: e  reason: collision with root package name */
    public int[] f40697e = new int[32];

    /* renamed from: f  reason: collision with root package name */
    public boolean f40698f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f40699g;

    public static final class Options {

        /* renamed from: a  reason: collision with root package name */
        public final String[] f40700a;

        /* renamed from: b  reason: collision with root package name */
        public final okio.Options f40701b;

        private Options(String[] strArr, okio.Options options) {
            this.f40700a = strArr;
            this.f40701b = options;
        }

        public static Options of(String... strArr) {
            try {
                ByteString[] byteStringArr = new ByteString[strArr.length];
                Buffer buffer = new Buffer();
                for (int i11 = 0; i11 < strArr.length; i11++) {
                    JsonReader.string(buffer, strArr[i11]);
                    buffer.readByte();
                    byteStringArr[i11] = buffer.readByteString();
                }
                return new Options((String[]) strArr.clone(), okio.Options.of(byteStringArr));
            } catch (IOException e11) {
                throw new AssertionError(e11);
            }
        }
    }

    public enum Token {
        BEGIN_ARRAY,
        END_ARRAY,
        BEGIN_OBJECT,
        END_OBJECT,
        NAME,
        STRING,
        NUMBER,
        BOOLEAN,
        NULL,
        END_DOCUMENT
    }

    static {
        for (int i11 = 0; i11 <= 31; i11++) {
            REPLACEMENT_CHARS[i11] = String.format("\\u%04x", new Object[]{Integer.valueOf(i11)});
        }
        String[] strArr = REPLACEMENT_CHARS;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
    }

    public static JsonReader of(BufferedSource bufferedSource) {
        return new JsonUtf8Reader(bufferedSource);
    }

    /* access modifiers changed from: private */
    public static void string(BufferedSink bufferedSink, String str) throws IOException {
        String str2;
        String[] strArr = REPLACEMENT_CHARS;
        bufferedSink.writeByte(34);
        int length = str.length();
        int i11 = 0;
        for (int i12 = 0; i12 < length; i12++) {
            char charAt = str.charAt(i12);
            if (charAt < 128) {
                str2 = strArr[charAt];
                if (str2 == null) {
                }
            } else if (charAt == 8232) {
                str2 = "\\u2028";
            } else if (charAt == 8233) {
                str2 = "\\u2029";
            }
            if (i11 < i12) {
                bufferedSink.writeUtf8(str, i11, i12);
            }
            bufferedSink.writeUtf8(str2);
            i11 = i12 + 1;
        }
        if (i11 < length) {
            bufferedSink.writeUtf8(str, i11, length);
        }
        bufferedSink.writeByte(34);
    }

    public final void b(int i11) {
        int i12 = this.f40694b;
        int[] iArr = this.f40695c;
        if (i12 == iArr.length) {
            if (i12 != 256) {
                this.f40695c = Arrays.copyOf(iArr, iArr.length * 2);
                String[] strArr = this.f40696d;
                this.f40696d = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
                int[] iArr2 = this.f40697e;
                this.f40697e = Arrays.copyOf(iArr2, iArr2.length * 2);
            } else {
                throw new JsonDataException("Nesting too deep at " + getPath());
            }
        }
        int[] iArr3 = this.f40695c;
        int i13 = this.f40694b;
        this.f40694b = i13 + 1;
        iArr3[i13] = i11;
    }

    public abstract void beginArray() throws IOException;

    public abstract void beginObject() throws IOException;

    public final JsonEncodingException c(String str) throws JsonEncodingException {
        throw new JsonEncodingException(str + " at path " + getPath());
    }

    public abstract void endArray() throws IOException;

    public abstract void endObject() throws IOException;

    public final String getPath() {
        return JsonScope.a(this.f40694b, this.f40695c, this.f40696d, this.f40697e);
    }

    public abstract boolean hasNext() throws IOException;

    public abstract boolean nextBoolean() throws IOException;

    public abstract double nextDouble() throws IOException;

    public abstract int nextInt() throws IOException;

    public abstract String nextName() throws IOException;

    public abstract String nextString() throws IOException;

    public abstract Token peek() throws IOException;

    public abstract int selectName(Options options) throws IOException;

    public abstract void skipName() throws IOException;

    public abstract void skipValue() throws IOException;
}
