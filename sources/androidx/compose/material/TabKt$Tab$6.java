package androidx.compose.material;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class TabKt$Tab$6 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f5756g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f5757h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Modifier f5758i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f5759j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f5760k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ long f5761l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ long f5762m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Function3<ColumnScope, Composer, Integer, Unit> f5763n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ int f5764o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ int f5765p;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TabKt$Tab$6(boolean z11, Function0<Unit> function0, Modifier modifier, boolean z12, MutableInteractionSource mutableInteractionSource, long j11, long j12, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, int i11, int i12) {
        super(2);
        this.f5756g = z11;
        this.f5757h = function0;
        this.f5758i = modifier;
        this.f5759j = z12;
        this.f5760k = mutableInteractionSource;
        this.f5761l = j11;
        this.f5762m = j12;
        this.f5763n = function3;
        this.f5764o = i11;
        this.f5765p = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        TabKt.m1409TabEVJuX4I(this.f5756g, this.f5757h, this.f5758i, this.f5759j, this.f5760k, this.f5761l, this.f5762m, this.f5763n, composer, this.f5764o | 1, this.f5765p);
    }
}
