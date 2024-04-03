package kotlin.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000X\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0017\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\b\u001a\u0017\u0010\u0000\u001a\u00020\u0005*\u00020\u00062\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\b\u001a\u001c\u0010\u0007\u001a\u00020\b*\u00020\u00022\u0006\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u001a\u001e\u0010\n\u001a\u00020\u000b*\u00020\u00022\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000b0\r\u001a\u0010\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010*\u00020\u0001\u001a\n\u0010\u0011\u001a\u00020\u0012*\u00020\u0013\u001a\u0010\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0015*\u00020\u0002\u001a\n\u0010\u0016\u001a\u00020\u000e*\u00020\u0002\u001a\u0017\u0010\u0016\u001a\u00020\u000e*\u00020\u00132\b\b\u0002\u0010\u0017\u001a\u00020\u0018H\b\u001a\r\u0010\u0019\u001a\u00020\u001a*\u00020\u000eH\b\u001a5\u0010\u001b\u001a\u0002H\u001c\"\u0004\b\u0000\u0010\u001c*\u00020\u00022\u0018\u0010\u001d\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u0010\u0012\u0004\u0012\u0002H\u001c0\rH\bø\u0001\u0000¢\u0006\u0002\u0010\u001e\u0002\u0007\n\u0005\b20\u0001¨\u0006\u001f"}, d2 = {"buffered", "Ljava/io/BufferedReader;", "Ljava/io/Reader;", "bufferSize", "", "Ljava/io/BufferedWriter;", "Ljava/io/Writer;", "copyTo", "", "out", "forEachLine", "", "action", "Lkotlin/Function1;", "", "lineSequence", "Lkotlin/sequences/Sequence;", "readBytes", "", "Ljava/net/URL;", "readLines", "", "readText", "charset", "Ljava/nio/charset/Charset;", "reader", "Ljava/io/StringReader;", "useLines", "T", "block", "(Ljava/io/Reader;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "kotlin-stdlib"}, k = 2, mv = {1, 7, 1}, xi = 48)
@JvmName(name = "TextStreamsKt")
public final class TextStreamsKt {
    @InlineOnly
    private static final BufferedReader buffered(Reader reader, int i11) {
        Intrinsics.checkNotNullParameter(reader, "<this>");
        return reader instanceof BufferedReader ? (BufferedReader) reader : new BufferedReader(reader, i11);
    }

    public static final long copyTo(@NotNull Reader reader, @NotNull Writer writer, int i11) {
        Intrinsics.checkNotNullParameter(reader, "<this>");
        Intrinsics.checkNotNullParameter(writer, "out");
        char[] cArr = new char[i11];
        int read = reader.read(cArr);
        long j11 = 0;
        while (read >= 0) {
            writer.write(cArr, 0, read);
            j11 += (long) read;
            read = reader.read(cArr);
        }
        return j11;
    }

    public static /* synthetic */ long copyTo$default(Reader reader, Writer writer, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i11 = 8192;
        }
        return copyTo(reader, writer, i11);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0038, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0039, code lost:
        kotlin.io.CloseableKt.closeFinally(r2, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003c, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void forEachLine(@org.jetbrains.annotations.NotNull java.io.Reader r2, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r3) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "action"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            boolean r0 = r2 instanceof java.io.BufferedReader
            if (r0 == 0) goto L_0x0011
            java.io.BufferedReader r2 = (java.io.BufferedReader) r2
            goto L_0x0019
        L_0x0011:
            java.io.BufferedReader r0 = new java.io.BufferedReader
            r1 = 8192(0x2000, float:1.14794E-41)
            r0.<init>(r2, r1)
            r2 = r0
        L_0x0019:
            kotlin.sequences.Sequence r0 = lineSequence(r2)     // Catch:{ all -> 0x0036 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0036 }
        L_0x0021:
            boolean r1 = r0.hasNext()     // Catch:{ all -> 0x0036 }
            if (r1 == 0) goto L_0x002f
            java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x0036 }
            r3.invoke(r1)     // Catch:{ all -> 0x0036 }
            goto L_0x0021
        L_0x002f:
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0036 }
            r3 = 0
            kotlin.io.CloseableKt.closeFinally(r2, r3)
            return
        L_0x0036:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x0038 }
        L_0x0038:
            r0 = move-exception
            kotlin.io.CloseableKt.closeFinally(r2, r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.TextStreamsKt.forEachLine(java.io.Reader, kotlin.jvm.functions.Function1):void");
    }

    @NotNull
    public static final Sequence<String> lineSequence(@NotNull BufferedReader bufferedReader) {
        Intrinsics.checkNotNullParameter(bufferedReader, "<this>");
        return SequencesKt__SequencesKt.constrainOnce(new LinesSequence(bufferedReader));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001d, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0019, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001a, code lost:
        kotlin.io.CloseableKt.closeFinally(r2, r0);
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final byte[] readBytes(@org.jetbrains.annotations.NotNull java.net.URL r2) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.io.InputStream r2 = com.google.firebase.perf.network.FirebasePerfUrlConnection.openStream(r2)
            java.lang.String r0 = "it"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r0)     // Catch:{ all -> 0x0017 }
            byte[] r0 = kotlin.io.ByteStreamsKt.readBytes(r2)     // Catch:{ all -> 0x0017 }
            r1 = 0
            kotlin.io.CloseableKt.closeFinally(r2, r1)
            return r0
        L_0x0017:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x0019 }
        L_0x0019:
            r1 = move-exception
            kotlin.io.CloseableKt.closeFinally(r2, r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.TextStreamsKt.readBytes(java.net.URL):byte[]");
    }

    @NotNull
    public static final List<String> readLines(@NotNull Reader reader) {
        Intrinsics.checkNotNullParameter(reader, "<this>");
        ArrayList arrayList = new ArrayList();
        forEachLine(reader, new TextStreamsKt$readLines$1(arrayList));
        return arrayList;
    }

    @NotNull
    public static final String readText(@NotNull Reader reader) {
        Intrinsics.checkNotNullParameter(reader, "<this>");
        StringWriter stringWriter = new StringWriter();
        copyTo$default(reader, stringWriter, 0, 2, (Object) null);
        String stringWriter2 = stringWriter.toString();
        Intrinsics.checkNotNullExpressionValue(stringWriter2, "buffer.toString()");
        return stringWriter2;
    }

    @InlineOnly
    private static final StringReader reader(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return new StringReader(str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002f, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0030, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        kotlin.io.CloseableKt.closeFinally(r2, r3);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0039, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> T useLines(@org.jetbrains.annotations.NotNull java.io.Reader r2, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super kotlin.sequences.Sequence<java.lang.String>, ? extends T> r3) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "block"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            boolean r0 = r2 instanceof java.io.BufferedReader
            if (r0 == 0) goto L_0x0011
            java.io.BufferedReader r2 = (java.io.BufferedReader) r2
            goto L_0x0019
        L_0x0011:
            java.io.BufferedReader r0 = new java.io.BufferedReader
            r1 = 8192(0x2000, float:1.14794E-41)
            r0.<init>(r2, r1)
            r2 = r0
        L_0x0019:
            r0 = 1
            kotlin.sequences.Sequence r1 = lineSequence(r2)     // Catch:{ all -> 0x002d }
            java.lang.Object r3 = r3.invoke(r1)     // Catch:{ all -> 0x002d }
            kotlin.jvm.internal.InlineMarker.finallyStart(r0)
            r1 = 0
            kotlin.io.CloseableKt.closeFinally(r2, r1)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r0)
            return r3
        L_0x002d:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x002f }
        L_0x002f:
            r1 = move-exception
            kotlin.jvm.internal.InlineMarker.finallyStart(r0)
            kotlin.io.CloseableKt.closeFinally(r2, r3)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.TextStreamsKt.useLines(java.io.Reader, kotlin.jvm.functions.Function1):java.lang.Object");
    }

    @InlineOnly
    private static final BufferedWriter buffered(Writer writer, int i11) {
        Intrinsics.checkNotNullParameter(writer, "<this>");
        return writer instanceof BufferedWriter ? (BufferedWriter) writer : new BufferedWriter(writer, i11);
    }

    @InlineOnly
    private static final String readText(URL url, Charset charset) {
        Intrinsics.checkNotNullParameter(url, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        return new String(readBytes(url), charset);
    }
}
