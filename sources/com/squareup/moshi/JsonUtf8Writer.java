package com.squareup.moshi;

import com.facebook.internal.security.CertificateUtil;
import java.io.IOException;
import javax.annotation.Nullable;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import okio.Buffer;
import okio.BufferedSink;
import okio.Okio;
import okio.Sink;
import okio.Timeout;

final class JsonUtf8Writer extends JsonWriter {
    private static final String[] REPLACEMENT_CHARS = new String[128];
    private String deferredName;
    private String separator = CertificateUtil.DELIMITER;
    /* access modifiers changed from: private */
    public final BufferedSink sink;

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

    public JsonUtf8Writer(BufferedSink bufferedSink) {
        if (bufferedSink != null) {
            this.sink = bufferedSink;
            c(6);
            return;
        }
        throw new NullPointerException("sink == null");
    }

    private void beforeName() throws IOException {
        int b11 = b();
        if (b11 == 5) {
            this.sink.writeByte(44);
        } else if (b11 != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        newline();
        d(4);
    }

    private void beforeValue() throws IOException {
        int b11 = b();
        int i11 = 2;
        if (b11 != 1) {
            if (b11 != 2) {
                if (b11 == 4) {
                    this.sink.writeUtf8(this.separator);
                    i11 = 5;
                } else if (b11 != 9) {
                    i11 = 7;
                    if (b11 != 6) {
                        if (b11 != 7) {
                            throw new IllegalStateException("Nesting problem.");
                        } else if (!this.f53282g) {
                            throw new IllegalStateException("JSON must have only one top-level value.");
                        }
                    }
                } else {
                    throw new IllegalStateException("Sink from valueSink() was not closed");
                }
                d(i11);
            }
            this.sink.writeByte(44);
        }
        newline();
        d(i11);
    }

    private JsonWriter close(int i11, int i12, char c11) throws IOException {
        int b11 = b();
        if (b11 != i12 && b11 != i11) {
            throw new IllegalStateException("Nesting problem.");
        } else if (this.deferredName == null) {
            int i13 = this.f53277b;
            int i14 = this.f53285j;
            if (i13 == (~i14)) {
                this.f53285j = ~i14;
                return this;
            }
            int i15 = i13 - 1;
            this.f53277b = i15;
            this.f53279d[i15] = null;
            int[] iArr = this.f53280e;
            int i16 = i15 - 1;
            iArr[i16] = iArr[i16] + 1;
            if (b11 == i12) {
                newline();
            }
            this.sink.writeByte(c11);
            return this;
        } else {
            throw new IllegalStateException("Dangling name: " + this.deferredName);
        }
    }

    public static void f(BufferedSink bufferedSink, String str) throws IOException {
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

    private void newline() throws IOException {
        if (this.f53281f != null) {
            this.sink.writeByte(10);
            int i11 = this.f53277b;
            for (int i12 = 1; i12 < i11; i12++) {
                this.sink.writeUtf8(this.f53281f);
            }
        }
    }

    private JsonWriter open(int i11, int i12, char c11) throws IOException {
        int i13 = this.f53277b;
        int i14 = this.f53285j;
        if (i13 == i14) {
            int[] iArr = this.f53278c;
            if (iArr[i13 - 1] == i11 || iArr[i13 - 1] == i12) {
                this.f53285j = ~i14;
                return this;
            }
        }
        beforeValue();
        a();
        c(i11);
        this.f53280e[this.f53277b - 1] = 0;
        this.sink.writeByte(c11);
        return this;
    }

    private void writeDeferredName() throws IOException {
        if (this.deferredName != null) {
            beforeName();
            f(this.sink, this.deferredName);
            this.deferredName = null;
        }
    }

    public JsonWriter beginArray() throws IOException {
        if (!this.f53284i) {
            writeDeferredName();
            return open(1, 2, '[');
        }
        throw new IllegalStateException("Array cannot be used as a map key in JSON at path " + getPath());
    }

    public JsonWriter beginObject() throws IOException {
        if (!this.f53284i) {
            writeDeferredName();
            return open(3, 5, AbstractJsonLexerKt.BEGIN_OBJ);
        }
        throw new IllegalStateException("Object cannot be used as a map key in JSON at path " + getPath());
    }

    public JsonWriter endArray() throws IOException {
        return close(1, 2, AbstractJsonLexerKt.END_LIST);
    }

    public JsonWriter endObject() throws IOException {
        this.f53284i = false;
        return close(3, 5, AbstractJsonLexerKt.END_OBJ);
    }

    public void flush() throws IOException {
        if (this.f53277b != 0) {
            this.sink.flush();
            return;
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    public JsonWriter name(String str) throws IOException {
        if (str == null) {
            throw new NullPointerException("name == null");
        } else if (this.f53277b != 0) {
            int b11 = b();
            if ((b11 == 3 || b11 == 5) && this.deferredName == null && !this.f53284i) {
                this.deferredName = str;
                this.f53279d[this.f53277b - 1] = str;
                return this;
            }
            throw new IllegalStateException("Nesting problem.");
        } else {
            throw new IllegalStateException("JsonWriter is closed.");
        }
    }

    public JsonWriter nullValue() throws IOException {
        if (!this.f53284i) {
            if (this.deferredName != null) {
                if (this.f53283h) {
                    writeDeferredName();
                } else {
                    this.deferredName = null;
                    return this;
                }
            }
            beforeValue();
            this.sink.writeUtf8("null");
            int[] iArr = this.f53280e;
            int i11 = this.f53277b - 1;
            iArr[i11] = iArr[i11] + 1;
            return this;
        }
        throw new IllegalStateException("null cannot be used as a map key in JSON at path " + getPath());
    }

    public void setIndent(String str) {
        String str2;
        super.setIndent(str);
        if (!str.isEmpty()) {
            str2 = ": ";
        } else {
            str2 = CertificateUtil.DELIMITER;
        }
        this.separator = str2;
    }

    public JsonWriter value(String str) throws IOException {
        if (str == null) {
            return nullValue();
        }
        if (this.f53284i) {
            this.f53284i = false;
            return name(str);
        }
        writeDeferredName();
        beforeValue();
        f(this.sink, str);
        int[] iArr = this.f53280e;
        int i11 = this.f53277b - 1;
        iArr[i11] = iArr[i11] + 1;
        return this;
    }

    public BufferedSink valueSink() throws IOException {
        if (!this.f53284i) {
            writeDeferredName();
            beforeValue();
            c(9);
            return Okio.buffer((Sink) new Sink() {
                public void close() {
                    if (JsonUtf8Writer.this.b() == 9) {
                        JsonUtf8Writer jsonUtf8Writer = JsonUtf8Writer.this;
                        int i11 = jsonUtf8Writer.f53277b - 1;
                        jsonUtf8Writer.f53277b = i11;
                        int[] iArr = jsonUtf8Writer.f53280e;
                        int i12 = i11 - 1;
                        iArr[i12] = iArr[i12] + 1;
                        return;
                    }
                    throw new AssertionError();
                }

                public void flush() throws IOException {
                    JsonUtf8Writer.this.sink.flush();
                }

                public Timeout timeout() {
                    return Timeout.NONE;
                }

                public void write(Buffer buffer, long j11) throws IOException {
                    JsonUtf8Writer.this.sink.write(buffer, j11);
                }
            });
        }
        throw new IllegalStateException("BufferedSink cannot be used as a map key in JSON at path " + getPath());
    }

    public JsonWriter value(boolean z11) throws IOException {
        if (!this.f53284i) {
            writeDeferredName();
            beforeValue();
            this.sink.writeUtf8(z11 ? "true" : "false");
            int[] iArr = this.f53280e;
            int i11 = this.f53277b - 1;
            iArr[i11] = iArr[i11] + 1;
            return this;
        }
        throw new IllegalStateException("Boolean cannot be used as a map key in JSON at path " + getPath());
    }

    public void close() throws IOException {
        this.sink.close();
        int i11 = this.f53277b;
        if (i11 > 1 || (i11 == 1 && this.f53278c[i11 - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.f53277b = 0;
    }

    public JsonWriter value(Boolean bool) throws IOException {
        if (bool == null) {
            return nullValue();
        }
        return value(bool.booleanValue());
    }

    public JsonWriter value(double d11) throws IOException {
        if (!this.f53282g && (Double.isNaN(d11) || Double.isInfinite(d11))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + d11);
        } else if (this.f53284i) {
            this.f53284i = false;
            return name(Double.toString(d11));
        } else {
            writeDeferredName();
            beforeValue();
            this.sink.writeUtf8(Double.toString(d11));
            int[] iArr = this.f53280e;
            int i11 = this.f53277b - 1;
            iArr[i11] = iArr[i11] + 1;
            return this;
        }
    }

    public JsonWriter value(long j11) throws IOException {
        if (this.f53284i) {
            this.f53284i = false;
            return name(Long.toString(j11));
        }
        writeDeferredName();
        beforeValue();
        this.sink.writeUtf8(Long.toString(j11));
        int[] iArr = this.f53280e;
        int i11 = this.f53277b - 1;
        iArr[i11] = iArr[i11] + 1;
        return this;
    }

    public JsonWriter value(@Nullable Number number) throws IOException {
        if (number == null) {
            return nullValue();
        }
        String obj = number.toString();
        if (!this.f53282g && (obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN"))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
        } else if (this.f53284i) {
            this.f53284i = false;
            return name(obj);
        } else {
            writeDeferredName();
            beforeValue();
            this.sink.writeUtf8(obj);
            int[] iArr = this.f53280e;
            int i11 = this.f53277b - 1;
            iArr[i11] = iArr[i11] + 1;
            return this;
        }
    }
}
