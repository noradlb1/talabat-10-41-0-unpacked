package kotlinx.serialization.json.internal;

import java.io.OutputStream;
import java.io.Writer;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eB\u001b\b\u0016\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\r\u0010\u0013J\u0012\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0014J\b\u0010\t\u001a\u00020\u0004H\u0016R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0014"}, d2 = {"Lkotlinx/serialization/json/internal/JsonToWriterStringBuilder;", "Lkotlinx/serialization/json/internal/JsonStringBuilder;", "", "sz", "", "flush", "oldSize", "additional", "a", "release", "Ljava/io/Writer;", "writer", "Ljava/io/Writer;", "<init>", "(Ljava/io/Writer;)V", "Ljava/io/OutputStream;", "os", "Ljava/nio/charset/Charset;", "charset", "(Ljava/io/OutputStream;Ljava/nio/charset/Charset;)V", "kotlinx-serialization-json"}, k = 1, mv = {1, 6, 0})
public final class JsonToWriterStringBuilder extends JsonStringBuilder {
    @NotNull
    private final Writer writer;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JsonToWriterStringBuilder(@NotNull Writer writer2) {
        super(new char[16384]);
        Intrinsics.checkNotNullParameter(writer2, "writer");
        this.writer = writer2;
    }

    public static /* synthetic */ void d(JsonToWriterStringBuilder jsonToWriterStringBuilder, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = jsonToWriterStringBuilder.b();
        }
        jsonToWriterStringBuilder.flush(i11);
    }

    private final void flush(int i11) {
        this.writer.write(this.f26443a, 0, i11);
        c(0);
    }

    public int a(int i11, int i12) {
        int i13 = i11 + i12;
        int length = this.f26443a.length;
        if (length > i13) {
            return i11;
        }
        flush(i11);
        if (i12 > length) {
            this.f26443a = new char[RangesKt___RangesKt.coerceAtLeast(i13, length * 2)];
        }
        return 0;
    }

    public void release() {
        d(this, 0, 1, (Object) null);
        this.writer.flush();
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public JsonToWriterStringBuilder(@org.jetbrains.annotations.NotNull java.io.OutputStream r2, @org.jetbrains.annotations.NotNull java.nio.charset.Charset r3) {
        /*
            r1 = this;
            java.lang.String r0 = "os"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "charset"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.io.OutputStreamWriter r0 = new java.io.OutputStreamWriter
            r0.<init>(r2, r3)
            boolean r2 = r0 instanceof java.io.BufferedWriter
            if (r2 == 0) goto L_0x0016
            java.io.BufferedWriter r0 = (java.io.BufferedWriter) r0
            goto L_0x001e
        L_0x0016:
            java.io.BufferedWriter r2 = new java.io.BufferedWriter
            r3 = 262144(0x40000, float:3.67342E-40)
            r2.<init>(r0, r3)
            r0 = r2
        L_0x001e:
            r1.<init>(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.json.internal.JsonToWriterStringBuilder.<init>(java.io.OutputStream, java.nio.charset.Charset):void");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ JsonToWriterStringBuilder(OutputStream outputStream, Charset charset, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(outputStream, (i11 & 2) != 0 ? Charsets.UTF_8 : charset);
    }
}
