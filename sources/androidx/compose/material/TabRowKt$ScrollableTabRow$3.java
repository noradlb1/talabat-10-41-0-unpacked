package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class TabRowKt$ScrollableTabRow$3 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f5827g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f5828h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ long f5829i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ long f5830j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ float f5831k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function3<List<TabPosition>, Composer, Integer, Unit> f5832l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f5833m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f5834n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ int f5835o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ int f5836p;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TabRowKt$ScrollableTabRow$3(int i11, Modifier modifier, long j11, long j12, float f11, Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, int i12, int i13) {
        super(2);
        this.f5827g = i11;
        this.f5828h = modifier;
        this.f5829i = j11;
        this.f5830j = j12;
        this.f5831k = f11;
        this.f5832l = function3;
        this.f5833m = function2;
        this.f5834n = function22;
        this.f5835o = i12;
        this.f5836p = i13;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        TabRowKt.m1424ScrollableTabRowsKfQg0A(this.f5827g, this.f5828h, this.f5829i, this.f5830j, this.f5831k, this.f5832l, this.f5833m, this.f5834n, composer, this.f5835o | 1, this.f5836p);
    }
}
