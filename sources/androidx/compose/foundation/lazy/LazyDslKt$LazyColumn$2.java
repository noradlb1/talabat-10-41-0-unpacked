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
public final class LazyDslKt$LazyColumn$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f2676g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ LazyListState f2677h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ PaddingValues f2678i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f2679j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Arrangement.Vertical f2680k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Alignment.Horizontal f2681l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ FlingBehavior f2682m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Function1<LazyListScope, Unit> f2683n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ int f2684o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ int f2685p;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyDslKt$LazyColumn$2(Modifier modifier, LazyListState lazyListState, PaddingValues paddingValues, boolean z11, Arrangement.Vertical vertical, Alignment.Horizontal horizontal, FlingBehavior flingBehavior, Function1<? super LazyListScope, Unit> function1, int i11, int i12) {
        super(2);
        this.f2676g = modifier;
        this.f2677h = lazyListState;
        this.f2678i = paddingValues;
        this.f2679j = z11;
        this.f2680k = vertical;
        this.f2681l = horizontal;
        this.f2682m = flingBehavior;
        this.f2683n = function1;
        this.f2684o = i11;
        this.f2685p = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        LazyDslKt.LazyColumn(this.f2676g, this.f2677h, this.f2678i, this.f2679j, this.f2680k, this.f2681l, this.f2682m, this.f2683n, composer, this.f2684o | 1, this.f2685p);
    }
}
