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
public final class FloatingActionButtonKt$LargeFloatingActionButton$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f7109g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f7110h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Shape f7111i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ long f7112j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ long f7113k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ FloatingActionButtonElevation f7114l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f7115m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f7116n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ int f7117o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ int f7118p;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FloatingActionButtonKt$LargeFloatingActionButton$2(Function0<Unit> function0, Modifier modifier, Shape shape, long j11, long j12, FloatingActionButtonElevation floatingActionButtonElevation, MutableInteractionSource mutableInteractionSource, Function2<? super Composer, ? super Integer, Unit> function2, int i11, int i12) {
        super(2);
        this.f7109g = function0;
        this.f7110h = modifier;
        this.f7111i = shape;
        this.f7112j = j11;
        this.f7113k = j12;
        this.f7114l = floatingActionButtonElevation;
        this.f7115m = mutableInteractionSource;
        this.f7116n = function2;
        this.f7117o = i11;
        this.f7118p = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        FloatingActionButtonKt.m1706LargeFloatingActionButtonXz6DiA(this.f7109g, this.f7110h, this.f7111i, this.f7112j, this.f7113k, this.f7114l, this.f7115m, this.f7116n, composer, this.f7117o | 1, this.f7118p);
    }
}
