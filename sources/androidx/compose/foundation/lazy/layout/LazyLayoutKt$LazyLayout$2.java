package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class LazyLayoutKt$LazyLayout$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ LazyLayoutItemProvider f3024g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f3025h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ LazyLayoutPrefetchState f3026i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> f3027j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f3028k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f3029l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyLayoutKt$LazyLayout$2(LazyLayoutItemProvider lazyLayoutItemProvider, Modifier modifier, LazyLayoutPrefetchState lazyLayoutPrefetchState, Function2<? super LazyLayoutMeasureScope, ? super Constraints, ? extends MeasureResult> function2, int i11, int i12) {
        super(2);
        this.f3024g = lazyLayoutItemProvider;
        this.f3025h = modifier;
        this.f3026i = lazyLayoutPrefetchState;
        this.f3027j = function2;
        this.f3028k = i11;
        this.f3029l = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        LazyLayoutKt.LazyLayout(this.f3024g, this.f3025h, this.f3026i, this.f3027j, composer, this.f3028k | 1, this.f3029l);
    }
}
