package androidx.compose.foundation.lazy.grid;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class LazyGridScopeImpl$item$3 extends Lambda implements Function1<Integer, Object> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Object f2953g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyGridScopeImpl$item$3(Object obj) {
        super(1);
        this.f2953g = obj;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).intValue());
    }

    @Nullable
    public final Object invoke(int i11) {
        return this.f2953g;
    }
}
