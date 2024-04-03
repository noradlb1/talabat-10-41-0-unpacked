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
public final class FloatingActionButtonKt$ExtendedFloatingActionButton$3 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f4577g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f4578h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Modifier f4579i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f4580j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f4581k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Shape f4582l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ long f4583m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ long f4584n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ FloatingActionButtonElevation f4585o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ int f4586p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ int f4587q;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FloatingActionButtonKt$ExtendedFloatingActionButton$3(Function2<? super Composer, ? super Integer, Unit> function2, Function0<Unit> function0, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function22, MutableInteractionSource mutableInteractionSource, Shape shape, long j11, long j12, FloatingActionButtonElevation floatingActionButtonElevation, int i11, int i12) {
        super(2);
        this.f4577g = function2;
        this.f4578h = function0;
        this.f4579i = modifier;
        this.f4580j = function22;
        this.f4581k = mutableInteractionSource;
        this.f4582l = shape;
        this.f4583m = j11;
        this.f4584n = j12;
        this.f4585o = floatingActionButtonElevation;
        this.f4586p = i11;
        this.f4587q = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        FloatingActionButtonKt.m1275ExtendedFloatingActionButtonwqdebIU(this.f4577g, this.f4578h, this.f4579i, this.f4580j, this.f4581k, this.f4582l, this.f4583m, this.f4584n, this.f4585o, composer, this.f4586p | 1, this.f4587q);
    }
}
