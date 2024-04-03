package androidx.compose.material;

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

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class FloatingActionButtonKt$FloatingActionButton$3 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f4595g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f4596h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f4597i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Shape f4598j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ long f4599k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ long f4600l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ FloatingActionButtonElevation f4601m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f4602n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ int f4603o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ int f4604p;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FloatingActionButtonKt$FloatingActionButton$3(Function0<Unit> function0, Modifier modifier, MutableInteractionSource mutableInteractionSource, Shape shape, long j11, long j12, FloatingActionButtonElevation floatingActionButtonElevation, Function2<? super Composer, ? super Integer, Unit> function2, int i11, int i12) {
        super(2);
        this.f4595g = function0;
        this.f4596h = modifier;
        this.f4597i = mutableInteractionSource;
        this.f4598j = shape;
        this.f4599k = j11;
        this.f4600l = j12;
        this.f4601m = floatingActionButtonElevation;
        this.f4602n = function2;
        this.f4603o = i11;
        this.f4604p = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        FloatingActionButtonKt.m1276FloatingActionButtonbogVsAg(this.f4595g, this.f4596h, this.f4597i, this.f4598j, this.f4599k, this.f4600l, this.f4601m, this.f4602n, composer, this.f4603o | 1, this.f4604p);
    }
}
