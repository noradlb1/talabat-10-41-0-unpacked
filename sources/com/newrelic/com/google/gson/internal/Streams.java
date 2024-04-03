package com.newrelic.com.google.gson.internal;

import com.newrelic.com.google.gson.JsonElement;
import com.newrelic.com.google.gson.internal.bind.TypeAdapters;
import com.newrelic.com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.Writer;

public final class Streams {
    private Streams() {
        throw new UnsupportedOperationException();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001c, code lost:
        throw new com.newrelic.com.google.gson.JsonIOException((java.lang.Throwable) r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001d, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0023, code lost:
        throw new com.newrelic.com.google.gson.JsonSyntaxException((java.lang.Throwable) r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0024, code lost:
        r2 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0025, code lost:
        r0 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x002a, code lost:
        return com.newrelic.com.google.gson.JsonNull.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0030, code lost:
        throw new com.newrelic.com.google.gson.JsonSyntaxException((java.lang.Throwable) r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x000f, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
        throw new com.newrelic.com.google.gson.JsonSyntaxException((java.lang.Throwable) r2);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0016 A[ExcHandler: IOException (r2v5 'e' java.io.IOException A[CUSTOM_DECLARE]), Splitter:B:0:0x0000] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x001d A[ExcHandler: MalformedJsonException (r2v4 'e' com.newrelic.com.google.gson.stream.MalformedJsonException A[CUSTOM_DECLARE]), Splitter:B:0:0x0000] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0028  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x002b  */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x000f A[ExcHandler: NumberFormatException (r2v6 'e' java.lang.NumberFormatException A[CUSTOM_DECLARE]), Splitter:B:0:0x0000] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.newrelic.com.google.gson.JsonElement parse(com.newrelic.com.google.gson.stream.JsonReader r2) throws com.newrelic.com.google.gson.JsonParseException {
        /*
            r2.peek()     // Catch:{ EOFException -> 0x0024, MalformedJsonException -> 0x001d, IOException -> 0x0016, NumberFormatException -> 0x000f }
            r0 = 0
            com.newrelic.com.google.gson.TypeAdapter<com.newrelic.com.google.gson.JsonElement> r1 = com.newrelic.com.google.gson.internal.bind.TypeAdapters.JSON_ELEMENT     // Catch:{ EOFException -> 0x000d, MalformedJsonException -> 0x001d, IOException -> 0x0016, NumberFormatException -> 0x000f }
            java.lang.Object r2 = r1.read(r2)     // Catch:{ EOFException -> 0x000d, MalformedJsonException -> 0x001d, IOException -> 0x0016, NumberFormatException -> 0x000f }
            com.newrelic.com.google.gson.JsonElement r2 = (com.newrelic.com.google.gson.JsonElement) r2     // Catch:{ EOFException -> 0x000d, MalformedJsonException -> 0x001d, IOException -> 0x0016, NumberFormatException -> 0x000f }
            return r2
        L_0x000d:
            r2 = move-exception
            goto L_0x0026
        L_0x000f:
            r2 = move-exception
            com.newrelic.com.google.gson.JsonSyntaxException r0 = new com.newrelic.com.google.gson.JsonSyntaxException
            r0.<init>((java.lang.Throwable) r2)
            throw r0
        L_0x0016:
            r2 = move-exception
            com.newrelic.com.google.gson.JsonIOException r0 = new com.newrelic.com.google.gson.JsonIOException
            r0.<init>((java.lang.Throwable) r2)
            throw r0
        L_0x001d:
            r2 = move-exception
            com.newrelic.com.google.gson.JsonSyntaxException r0 = new com.newrelic.com.google.gson.JsonSyntaxException
            r0.<init>((java.lang.Throwable) r2)
            throw r0
        L_0x0024:
            r2 = move-exception
            r0 = 1
        L_0x0026:
            if (r0 == 0) goto L_0x002b
            com.newrelic.com.google.gson.JsonNull r2 = com.newrelic.com.google.gson.JsonNull.INSTANCE
            return r2
        L_0x002b:
            com.newrelic.com.google.gson.JsonSyntaxException r0 = new com.newrelic.com.google.gson.JsonSyntaxException
            r0.<init>((java.lang.Throwable) r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.newrelic.com.google.gson.internal.Streams.parse(com.newrelic.com.google.gson.stream.JsonReader):com.newrelic.com.google.gson.JsonElement");
    }

    public static void write(JsonElement jsonElement, JsonWriter jsonWriter) throws IOException {
        TypeAdapters.JSON_ELEMENT.write(jsonWriter, jsonElement);
    }

    public static Writer writerForAppendable(Appendable appendable) {
        return appendable instanceof Writer ? (Writer) appendable : new AppendableWriter(appendable);
    }

    public static final class AppendableWriter extends Writer {
        private final Appendable appendable;
        private final CurrentWrite currentWrite = new CurrentWrite();

        public static class CurrentWrite implements CharSequence {
            char[] chars;

            public char charAt(int i11) {
                return this.chars[i11];
            }

            public int length() {
                return this.chars.length;
            }

            public CharSequence subSequence(int i11, int i12) {
                return new String(this.chars, i11, i12 - i11);
            }
        }

        public AppendableWriter(Appendable appendable2) {
            this.appendable = appendable2;
        }

        public void close() {
        }

        public void flush() {
        }

        public void write(char[] cArr, int i11, int i12) throws IOException {
            CurrentWrite currentWrite2 = this.currentWrite;
            currentWrite2.chars = cArr;
            this.appendable.append(currentWrite2, i11, i12 + i11);
        }

        public void write(int i11) throws IOException {
            this.appendable.append((char) i11);
        }
    }
}
