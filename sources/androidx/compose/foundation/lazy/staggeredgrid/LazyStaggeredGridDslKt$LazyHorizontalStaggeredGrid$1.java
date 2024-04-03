package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class LazyStaggeredGridDslKt$LazyHorizontalStaggeredGrid$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ StaggeredGridCells f3078g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f3079h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ LazyStaggeredGridState f3080i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ PaddingValues f3081j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Arrangement.Vertical f3082k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Arrangement.Horizontal f3083l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ FlingBehavior f3084m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ boolean f3085n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ Function1<LazyStaggeredGridScope, Unit> f3086o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ int f3087p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ int f3088q;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyStaggeredGridDslKt$LazyHorizontalStaggeredGrid$1(StaggeredGridCells staggeredGridCells, Modifier modifier, LazyStaggeredGridState lazyStaggeredGridState, PaddingValues paddingValues, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, FlingBehavior flingBehavior, boolean z11, Function1<? super LazyStaggeredGridScope, Unit> function1, int i11, int i12) {
        super(2);
        this.f3078g = staggeredGridCells;
        this.f3079h = modifier;
        this.f3080i = lazyStaggeredGridState;
        this.f3081j = paddingValues;
        this.f3082k = vertical;
        this.f3083l = horizontal;
        this.f3084m = flingBehavior;
        this.f3085n = z11;
        this.f3086o = function1;
        this.f3087p = i11;
        this.f3088q = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        LazyStaggeredGridDslKt.LazyHorizontalStaggeredGrid(this.f3078g, this.f3079h, this.f3080i, this.f3081j, this.f3082k, this.f3083l, this.f3084m, this.f3085n, this.f3086o, composer, this.f3087p | 1, this.f3088q);
    }
}
