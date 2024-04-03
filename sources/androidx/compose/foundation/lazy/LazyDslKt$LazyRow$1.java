package androidx.compose.foundation.lazy;

import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class LazyDslKt$LazyRow$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f2686g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ LazyListState f2687h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ PaddingValues f2688i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f2689j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Arrangement.Horizontal f2690k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Alignment.Vertical f2691l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ FlingBehavior f2692m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ boolean f2693n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ Function1<LazyListScope, Unit> f2694o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ int f2695p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ int f2696q;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyDslKt$LazyRow$1(Modifier modifier, LazyListState lazyListState, PaddingValues paddingValues, boolean z11, Arrangement.Horizontal horizontal, Alignment.Vertical vertical, FlingBehavior flingBehavior, boolean z12, Function1<? super LazyListScope, Unit> function1, int i11, int i12) {
        super(2);
        this.f2686g = modifier;
        this.f2687h = lazyListState;
        this.f2688i = paddingValues;
        this.f2689j = z11;
        this.f2690k = horizontal;
        this.f2691l = vertical;
        this.f2692m = flingBehavior;
        this.f2693n = z12;
        this.f2694o = function1;
        this.f2695p = i11;
        this.f2696q = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        LazyDslKt.LazyRow(this.f2686g, this.f2687h, this.f2688i, this.f2689j, this.f2690k, this.f2691l, this.f2692m, this.f2693n, this.f2694o, composer, this.f2695p | 1, this.f2696q);
    }
}
