package androidx.compose.material3;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class FloatingActionButtonKt$ExtendedFloatingActionButton$3 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f7064g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f7065h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Shape f7066i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ long f7067j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ long f7068k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ FloatingActionButtonElevation f7069l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f7070m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Function3<RowScope, Composer, Integer, Unit> f7071n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ int f7072o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ int f7073p;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FloatingActionButtonKt$ExtendedFloatingActionButton$3(Function0<Unit> function0, Modifier modifier, Shape shape, long j11, long j12, FloatingActionButtonElevation floatingActionButtonElevation, MutableInteractionSource mutableInteractionSource, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, int i11, int i12) {
        super(2);
        this.f7064g = function0;
        this.f7065h = modifier;
        this.f7066i = shape;
        this.f7067j = j11;
        this.f7068k = j12;
        this.f7069l = floatingActionButtonElevation;
        this.f7070m = mutableInteractionSource;
        this.f7071n = function3;
        this.f7072o = i11;
        this.f7073p = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        FloatingActionButtonKt.m1704ExtendedFloatingActionButtonXz6DiA(this.f7064g, this.f7065h, this.f7066i, this.f7067j, this.f7068k, this.f7069l, this.f7070m, this.f7071n, composer, this.f7072o | 1, this.f7073p);
    }
}
