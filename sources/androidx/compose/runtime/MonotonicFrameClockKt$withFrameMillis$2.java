package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "R", "it", "", "invoke", "(J)Ljava/lang/Object;"}, k = 3, mv = {1, 7, 1}, xi = 176)
public final class MonotonicFrameClockKt$withFrameMillis$2 extends Lambda implements Function1<Long, R> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function1<Long, R> f9123g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MonotonicFrameClockKt$withFrameMillis$2(Function1<? super Long, ? extends R> function1) {
        super(1);
        this.f9123g = function1;
    }

    public final R invoke(long j11) {
        return this.f9123g.invoke(Long.valueOf(j11 / 1000000));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).longValue());
    }
}
