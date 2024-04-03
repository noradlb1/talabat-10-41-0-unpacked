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
public final class FloatingActionButtonKt$SmallFloatingActionButton$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f7119g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f7120h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Shape f7121i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ long f7122j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ long f7123k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ FloatingActionButtonElevation f7124l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f7125m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f7126n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ int f7127o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ int f7128p;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FloatingActionButtonKt$SmallFloatingActionButton$2(Function0<Unit> function0, Modifier modifier, Shape shape, long j11, long j12, FloatingActionButtonElevation floatingActionButtonElevation, MutableInteractionSource mutableInteractionSource, Function2<? super Composer, ? super Integer, Unit> function2, int i11, int i12) {
        super(2);
        this.f7119g = function0;
        this.f7120h = modifier;
        this.f7121i = shape;
        this.f7122j = j11;
        this.f7123k = j12;
        this.f7124l = floatingActionButtonElevation;
        this.f7125m = mutableInteractionSource;
        this.f7126n = function2;
        this.f7127o = i11;
        this.f7128p = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        FloatingActionButtonKt.m1707SmallFloatingActionButtonXz6DiA(this.f7119g, this.f7120h, this.f7121i, this.f7122j, this.f7123k, this.f7124l, this.f7125m, this.f7126n, composer, this.f7127o | 1, this.f7128p);
    }
}
