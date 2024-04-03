package androidx.compose.material3;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class FloatingActionButtonKt$ExtendedFloatingActionButton$6 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f7080g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f7081h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f7082i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Modifier f7083j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ boolean f7084k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Shape f7085l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ long f7086m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ long f7087n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ FloatingActionButtonElevation f7088o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f7089p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ int f7090q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ int f7091r;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FloatingActionButtonKt$ExtendedFloatingActionButton$6(Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function0<Unit> function0, Modifier modifier, boolean z11, Shape shape, long j11, long j12, FloatingActionButtonElevation floatingActionButtonElevation, MutableInteractionSource mutableInteractionSource, int i11, int i12) {
        super(2);
        this.f7080g = function2;
        this.f7081h = function22;
        this.f7082i = function0;
        this.f7083j = modifier;
        this.f7084k = z11;
        this.f7085l = shape;
        this.f7086m = j11;
        this.f7087n = j12;
        this.f7088o = floatingActionButtonElevation;
        this.f7089p = mutableInteractionSource;
        this.f7090q = i11;
        this.f7091r = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        FloatingActionButtonKt.m1703ExtendedFloatingActionButtonElI57k(this.f7080g, this.f7081h, this.f7082i, this.f7083j, this.f7084k, this.f7085l, this.f7086m, this.f7087n, this.f7088o, this.f7089p, composer, this.f7090q | 1, this.f7091r);
    }
}
