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
public final class LazyGridDslKt$LazyHorizontalGrid$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ GridCells f2828g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f2829h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ LazyGridState f2830i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ PaddingValues f2831j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ boolean f2832k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Arrangement.Horizontal f2833l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Arrangement.Vertical f2834m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ FlingBehavior f2835n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ boolean f2836o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ Function1<LazyGridScope, Unit> f2837p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ int f2838q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ int f2839r;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyGridDslKt$LazyHorizontalGrid$1(GridCells gridCells, Modifier modifier, LazyGridState lazyGridState, PaddingValues paddingValues, boolean z11, Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, FlingBehavior flingBehavior, boolean z12, Function1<? super LazyGridScope, Unit> function1, int i11, int i12) {
        super(2);
        this.f2828g = gridCells;
        this.f2829h = modifier;
        this.f2830i = lazyGridState;
        this.f2831j = paddingValues;
        this.f2832k = z11;
        this.f2833l = horizontal;
        this.f2834m = vertical;
        this.f2835n = flingBehavior;
        this.f2836o = z12;
        this.f2837p = function1;
        this.f2838q = i11;
        this.f2839r = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        LazyGridDslKt.LazyHorizontalGrid(this.f2828g, this.f2829h, this.f2830i, this.f2831j, this.f2832k, this.f2833l, this.f2834m, this.f2835n, this.f2836o, this.f2837p, composer, this.f2838q | 1, this.f2839r);
    }
}
