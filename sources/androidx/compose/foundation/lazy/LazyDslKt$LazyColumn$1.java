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
public final class LazyDslKt$LazyColumn$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f2665g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ LazyListState f2666h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ PaddingValues f2667i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f2668j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Arrangement.Vertical f2669k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Alignment.Horizontal f2670l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ FlingBehavior f2671m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ boolean f2672n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ Function1<LazyListScope, Unit> f2673o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ int f2674p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ int f2675q;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyDslKt$LazyColumn$1(Modifier modifier, LazyListState lazyListState, PaddingValues paddingValues, boolean z11, Arrangement.Vertical vertical, Alignment.Horizontal horizontal, FlingBehavior flingBehavior, boolean z12, Function1<? super LazyListScope, Unit> function1, int i11, int i12) {
        super(2);
        this.f2665g = modifier;
        this.f2666h = lazyListState;
        this.f2667i = paddingValues;
        this.f2668j = z11;
        this.f2669k = vertical;
        this.f2670l = horizontal;
        this.f2671m = flingBehavior;
        this.f2672n = z12;
        this.f2673o = function1;
        this.f2674p = i11;
        this.f2675q = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        LazyDslKt.LazyColumn(this.f2665g, this.f2666h, this.f2667i, this.f2668j, this.f2669k, this.f2670l, this.f2671m, this.f2672n, this.f2673o, composer, this.f2674p | 1, this.f2675q);
    }
}
