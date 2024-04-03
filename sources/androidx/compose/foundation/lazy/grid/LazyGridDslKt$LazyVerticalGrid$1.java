package androidx.compose.foundation.lazy.grid;

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
public final class LazyGridDslKt$LazyVerticalGrid$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ GridCells f2840g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f2841h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ LazyGridState f2842i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ PaddingValues f2843j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ boolean f2844k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Arrangement.Vertical f2845l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Arrangement.Horizontal f2846m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ FlingBehavior f2847n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ boolean f2848o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ Function1<LazyGridScope, Unit> f2849p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ int f2850q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ int f2851r;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyGridDslKt$LazyVerticalGrid$1(GridCells gridCells, Modifier modifier, LazyGridState lazyGridState, PaddingValues paddingValues, boolean z11, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, FlingBehavior flingBehavior, boolean z12, Function1<? super LazyGridScope, Unit> function1, int i11, int i12) {
        super(2);
        this.f2840g = gridCells;
        this.f2841h = modifier;
        this.f2842i = lazyGridState;
        this.f2843j = paddingValues;
        this.f2844k = z11;
        this.f2845l = vertical;
        this.f2846m = horizontal;
        this.f2847n = flingBehavior;
        this.f2848o = z12;
        this.f2849p = function1;
        this.f2850q = i11;
        this.f2851r = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        LazyGridDslKt.LazyVerticalGrid(this.f2840g, this.f2841h, this.f2842i, this.f2843j, this.f2844k, this.f2845l, this.f2846m, this.f2847n, this.f2848o, this.f2849p, composer, this.f2850q | 1, this.f2851r);
    }
}
