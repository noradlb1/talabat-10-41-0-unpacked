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
public final class TabRowKt$TabRow$3 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f5859g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f5860h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ long f5861i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ long f5862j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function3<List<TabPosition>, Composer, Integer, Unit> f5863k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f5864l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f5865m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f5866n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ int f5867o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TabRowKt$TabRow$3(int i11, Modifier modifier, long j11, long j12, Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, int i12, int i13) {
        super(2);
        this.f5859g = i11;
        this.f5860h = modifier;
        this.f5861i = j11;
        this.f5862j = j12;
        this.f5863k = function3;
        this.f5864l = function2;
        this.f5865m = function22;
        this.f5866n = i12;
        this.f5867o = i13;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        TabRowKt.m1425TabRowpAZo6Ak(this.f5859g, this.f5860h, this.f5861i, this.f5862j, this.f5863k, this.f5864l, this.f5865m, composer, this.f5866n | 1, this.f5867o);
    }
}
