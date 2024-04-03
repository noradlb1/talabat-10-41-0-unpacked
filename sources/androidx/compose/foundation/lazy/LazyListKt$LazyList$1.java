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
public final class LazyListKt$LazyList$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f2752g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ LazyListState f2753h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ PaddingValues f2754i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f2755j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ boolean f2756k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ FlingBehavior f2757l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ boolean f2758m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Alignment.Horizontal f2759n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ Arrangement.Vertical f2760o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ Alignment.Vertical f2761p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ Arrangement.Horizontal f2762q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ Function1<LazyListScope, Unit> f2763r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ int f2764s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ int f2765t;

    /* renamed from: u  reason: collision with root package name */
    public final /* synthetic */ int f2766u;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyListKt$LazyList$1(Modifier modifier, LazyListState lazyListState, PaddingValues paddingValues, boolean z11, boolean z12, FlingBehavior flingBehavior, boolean z13, Alignment.Horizontal horizontal, Arrangement.Vertical vertical, Alignment.Vertical vertical2, Arrangement.Horizontal horizontal2, Function1<? super LazyListScope, Unit> function1, int i11, int i12, int i13) {
        super(2);
        this.f2752g = modifier;
        this.f2753h = lazyListState;
        this.f2754i = paddingValues;
        this.f2755j = z11;
        this.f2756k = z12;
        this.f2757l = flingBehavior;
        this.f2758m = z13;
        this.f2759n = horizontal;
        this.f2760o = vertical;
        this.f2761p = vertical2;
        this.f2762q = horizontal2;
        this.f2763r = function1;
        this.f2764s = i11;
        this.f2765t = i12;
        this.f2766u = i13;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        LazyListKt.LazyList(this.f2752g, this.f2753h, this.f2754i, this.f2755j, this.f2756k, this.f2757l, this.f2758m, this.f2759n, this.f2760o, this.f2761p, this.f2762q, this.f2763r, composer, this.f2764s | 1, this.f2765t, this.f2766u);
    }
}
