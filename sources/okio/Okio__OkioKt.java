package okio;

import java.io.Closeable;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0007¢\u0006\u0002\b\u0002\u001a\n\u0010\u0003\u001a\u00020\u0004*\u00020\u0001\u001a\n\u0010\u0003\u001a\u00020\u0005*\u00020\u0006\u001aA\u0010\u0007\u001a\u0002H\b\"\u0010\b\u0000\u0010\t*\n\u0018\u00010\nj\u0004\u0018\u0001`\u000b\"\u0004\b\u0001\u0010\b*\u0002H\t2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\b0\rH\bø\u0001\u0000¢\u0006\u0002\u0010\u000e\u0002\u0007\n\u0005\b20\u0001¨\u0006\u000f"}, d2 = {"blackholeSink", "Lokio/Sink;", "blackhole", "buffer", "Lokio/BufferedSink;", "Lokio/BufferedSource;", "Lokio/Source;", "use", "R", "T", "Ljava/io/Closeable;", "Lokio/Closeable;", "block", "Lkotlin/Function1;", "(Ljava/io/Closeable;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "okio"}, k = 5, mv = {1, 5, 1}, xi = 48, xs = "okio/Okio")
final /* synthetic */ class Okio__OkioKt {
    @NotNull
    @JvmName(name = "blackhole")
    public static final Sink blackhole() {
        return new BlackholeSink();
    }

    @NotNull
    public static final BufferedSource buffer(@NotNull Source source) {
        Intrinsics.checkNotNullParameter(source, "<this>");
        return new RealBufferedSource(source);
    }

    public static final <T extends Closeable, R> R use(T t11, @NotNull Function1<? super T, ? extends R> function1) {
        R r11;
        Intrinsics.checkNotNullParameter(function1, "block");
        Throwable th2 = null;
        try {
            r11 = function1.invoke(t11);
        } catch (Throwable th3) {
            th2 = th3;
            r11 = null;
        }
        if (t11 != null) {
            try {
                t11.close();
            } catch (Throwable th4) {
                if (th2 == null) {
                    th2 = th4;
                } else {
                    ExceptionsKt__ExceptionsKt.addSuppressed(th2, th4);
                }
            }
        }
        if (th2 == null) {
            Intrinsics.checkNotNull(r11);
            return r11;
        }
        throw th2;
    }

    @NotNull
    public static final BufferedSink buffer(@NotNull Sink sink) {
        Intrinsics.checkNotNullParameter(sink, "<this>");
        return new RealBufferedSink(sink);
    }
}
