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
public final class FloatingActionButtonKt$FloatingActionButton$3 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f7099g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f7100h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Shape f7101i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ long f7102j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ long f7103k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ FloatingActionButtonElevation f7104l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f7105m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f7106n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ int f7107o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ int f7108p;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FloatingActionButtonKt$FloatingActionButton$3(Function0<Unit> function0, Modifier modifier, Shape shape, long j11, long j12, FloatingActionButtonElevation floatingActionButtonElevation, MutableInteractionSource mutableInteractionSource, Function2<? super Composer, ? super Integer, Unit> function2, int i11, int i12) {
        super(2);
        this.f7099g = function0;
        this.f7100h = modifier;
        this.f7101i = shape;
        this.f7102j = j11;
        this.f7103k = j12;
        this.f7104l = floatingActionButtonElevation;
        this.f7105m = mutableInteractionSource;
        this.f7106n = function2;
        this.f7107o = i11;
        this.f7108p = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        FloatingActionButtonKt.m1705FloatingActionButtonXz6DiA(this.f7099g, this.f7100h, this.f7101i, this.f7102j, this.f7103k, this.f7104l, this.f7105m, this.f7106n, composer, this.f7107o | 1, this.f7108p);
    }
}
