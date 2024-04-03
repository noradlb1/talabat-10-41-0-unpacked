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
public final class LazyDslKt$LazyRow$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f2697g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ LazyListState f2698h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ PaddingValues f2699i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f2700j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Arrangement.Horizontal f2701k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Alignment.Vertical f2702l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ FlingBehavior f2703m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Function1<LazyListScope, Unit> f2704n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ int f2705o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ int f2706p;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyDslKt$LazyRow$2(Modifier modifier, LazyListState lazyListState, PaddingValues paddingValues, boolean z11, Arrangement.Horizontal horizontal, Alignment.Vertical vertical, FlingBehavior flingBehavior, Function1<? super LazyListScope, Unit> function1, int i11, int i12) {
        super(2);
        this.f2697g = modifier;
        this.f2698h = lazyListState;
        this.f2699i = paddingValues;
        this.f2700j = z11;
        this.f2701k = horizontal;
        this.f2702l = vertical;
        this.f2703m = flingBehavior;
        this.f2704n = function1;
        this.f2705o = i11;
        this.f2706p = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        LazyDslKt.LazyRow(this.f2697g, this.f2698h, this.f2699i, this.f2700j, this.f2701k, this.f2702l, this.f2703m, this.f2704n, composer, this.f2705o | 1, this.f2706p);
    }
}
