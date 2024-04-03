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
public final class LazyStaggeredGridDslKt$LazyVerticalStaggeredGrid$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ StaggeredGridCells f3089g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f3090h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ LazyStaggeredGridState f3091i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ PaddingValues f3092j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Arrangement.Vertical f3093k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Arrangement.Horizontal f3094l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ FlingBehavior f3095m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ boolean f3096n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ Function1<LazyStaggeredGridScope, Unit> f3097o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ int f3098p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ int f3099q;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyStaggeredGridDslKt$LazyVerticalStaggeredGrid$1(StaggeredGridCells staggeredGridCells, Modifier modifier, LazyStaggeredGridState lazyStaggeredGridState, PaddingValues paddingValues, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, FlingBehavior flingBehavior, boolean z11, Function1<? super LazyStaggeredGridScope, Unit> function1, int i11, int i12) {
        super(2);
        this.f3089g = staggeredGridCells;
        this.f3090h = modifier;
        this.f3091i = lazyStaggeredGridState;
        this.f3092j = paddingValues;
        this.f3093k = vertical;
        this.f3094l = horizontal;
        this.f3095m = flingBehavior;
        this.f3096n = z11;
        this.f3097o = function1;
        this.f3098p = i11;
        this.f3099q = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        LazyStaggeredGridDslKt.LazyVerticalStaggeredGrid(this.f3089g, this.f3090h, this.f3091i, this.f3092j, this.f3093k, this.f3094l, this.f3095m, this.f3096n, this.f3097o, composer, this.f3098p | 1, this.f3099q);
    }
}
