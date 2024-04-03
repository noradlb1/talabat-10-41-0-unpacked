package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 176)
public final class ComposablesKt$ReusableComposeNode$1 extends Lambda implements Function0<T> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function0<T> f9035g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ComposablesKt$ReusableComposeNode$1(Function0<? extends T> function0) {
        super(0);
        this.f9035g = function0;
    }

    @NotNull
    public final T invoke() {
        return this.f9035g.invoke();
    }
}
