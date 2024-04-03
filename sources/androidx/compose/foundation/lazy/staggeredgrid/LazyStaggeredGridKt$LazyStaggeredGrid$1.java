package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class LazyStaggeredGridKt$LazyStaggeredGrid$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ LazyStaggeredGridState f3133g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Orientation f3134h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function2<Density, Constraints, int[]> f3135i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Modifier f3136j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ PaddingValues f3137k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ boolean f3138l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ FlingBehavior f3139m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ boolean f3140n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ Arrangement.Vertical f3141o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ Arrangement.Horizontal f3142p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ Function1<LazyStaggeredGridScope, Unit> f3143q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ int f3144r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ int f3145s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ int f3146t;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyStaggeredGridKt$LazyStaggeredGrid$1(LazyStaggeredGridState lazyStaggeredGridState, Orientation orientation, Function2<? super Density, ? super Constraints, int[]> function2, Modifier modifier, PaddingValues paddingValues, boolean z11, FlingBehavior flingBehavior, boolean z12, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, Function1<? super LazyStaggeredGridScope, Unit> function1, int i11, int i12, int i13) {
        super(2);
        this.f3133g = lazyStaggeredGridState;
        this.f3134h = orientation;
        this.f3135i = function2;
        this.f3136j = modifier;
        this.f3137k = paddingValues;
        this.f3138l = z11;
        this.f3139m = flingBehavior;
        this.f3140n = z12;
        this.f3141o = vertical;
        this.f3142p = horizontal;
        this.f3143q = function1;
        this.f3144r = i11;
        this.f3145s = i12;
        this.f3146t = i13;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        LazyStaggeredGridKt.LazyStaggeredGrid(this.f3133g, this.f3134h, this.f3135i, this.f3136j, this.f3137k, this.f3138l, this.f3139m, this.f3140n, this.f3141o, this.f3142p, this.f3143q, composer, this.f3144r | 1, this.f3145s, this.f3146t);
    }
}
