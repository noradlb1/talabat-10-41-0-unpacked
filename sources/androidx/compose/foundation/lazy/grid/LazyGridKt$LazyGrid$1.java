package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class LazyGridKt$LazyGrid$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f2906g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ LazyGridState f2907h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function2<Density, Constraints, List<Integer>> f2908i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ PaddingValues f2909j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ boolean f2910k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ boolean f2911l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ FlingBehavior f2912m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ boolean f2913n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ Arrangement.Vertical f2914o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ Arrangement.Horizontal f2915p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ Function1<LazyGridScope, Unit> f2916q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ int f2917r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ int f2918s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ int f2919t;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyGridKt$LazyGrid$1(Modifier modifier, LazyGridState lazyGridState, Function2<? super Density, ? super Constraints, ? extends List<Integer>> function2, PaddingValues paddingValues, boolean z11, boolean z12, FlingBehavior flingBehavior, boolean z13, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, Function1<? super LazyGridScope, Unit> function1, int i11, int i12, int i13) {
        super(2);
        this.f2906g = modifier;
        this.f2907h = lazyGridState;
        this.f2908i = function2;
        this.f2909j = paddingValues;
        this.f2910k = z11;
        this.f2911l = z12;
        this.f2912m = flingBehavior;
        this.f2913n = z13;
        this.f2914o = vertical;
        this.f2915p = horizontal;
        this.f2916q = function1;
        this.f2917r = i11;
        this.f2918s = i12;
        this.f2919t = i13;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        LazyGridKt.LazyGrid(this.f2906g, this.f2907h, this.f2908i, this.f2909j, this.f2910k, this.f2911l, this.f2912m, this.f2913n, this.f2914o, this.f2915p, this.f2916q, composer, this.f2917r | 1, this.f2918s, this.f2919t);
    }
}
