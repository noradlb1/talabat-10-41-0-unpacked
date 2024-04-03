package androidx.compose.material;

import androidx.compose.foundation.BorderStroke;
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
public final class SurfaceKt$Surface$5 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f5542g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f5543h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f5544i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Shape f5545j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ long f5546k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ long f5547l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ BorderStroke f5548m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ float f5549n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f5550o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f5551p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ int f5552q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ int f5553r;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SurfaceKt$Surface$5(Function0<Unit> function0, Modifier modifier, boolean z11, Shape shape, long j11, long j12, BorderStroke borderStroke, float f11, MutableInteractionSource mutableInteractionSource, Function2<? super Composer, ? super Integer, Unit> function2, int i11, int i12) {
        super(2);
        this.f5542g = function0;
        this.f5543h = modifier;
        this.f5544i = z11;
        this.f5545j = shape;
        this.f5546k = j11;
        this.f5547l = j12;
        this.f5548m = borderStroke;
        this.f5549n = f11;
        this.f5550o = mutableInteractionSource;
        this.f5551p = function2;
        this.f5552q = i11;
        this.f5553r = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        SurfaceKt.m1385SurfaceLPr_se0(this.f5542g, this.f5543h, this.f5544i, this.f5545j, this.f5546k, this.f5547l, this.f5548m, this.f5549n, this.f5550o, this.f5551p, composer, this.f5552q | 1, this.f5553r);
    }
}
