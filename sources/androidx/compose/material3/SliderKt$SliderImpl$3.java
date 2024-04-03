package androidx.compose.material3;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.ClosedFloatingPointRange;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class SliderKt$SliderImpl$3 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f8072g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f8073h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f8074i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function1<Float, Unit> f8075j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f8076k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f8077l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ float f8078m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ ClosedFloatingPointRange<Float> f8079n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ Function3<SliderPositions, Composer, Integer, Unit> f8080o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ Function3<SliderPositions, Composer, Integer, Unit> f8081p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ int f8082q;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SliderKt$SliderImpl$3(Modifier modifier, boolean z11, MutableInteractionSource mutableInteractionSource, Function1<? super Float, Unit> function1, Function0<Unit> function0, int i11, float f11, ClosedFloatingPointRange<Float> closedFloatingPointRange, Function3<? super SliderPositions, ? super Composer, ? super Integer, Unit> function3, Function3<? super SliderPositions, ? super Composer, ? super Integer, Unit> function32, int i12) {
        super(2);
        this.f8072g = modifier;
        this.f8073h = z11;
        this.f8074i = mutableInteractionSource;
        this.f8075j = function1;
        this.f8076k = function0;
        this.f8077l = i11;
        this.f8078m = f11;
        this.f8079n = closedFloatingPointRange;
        this.f8080o = function3;
        this.f8081p = function32;
        this.f8082q = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        SliderKt.SliderImpl(this.f8072g, this.f8073h, this.f8074i, this.f8075j, this.f8076k, this.f8077l, this.f8078m, this.f8079n, this.f8080o, this.f8081p, composer, this.f8082q | 1);
    }
}
