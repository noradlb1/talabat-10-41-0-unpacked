package androidx.compose.material;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class SurfaceKt$Surface$11 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f5477g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function1<Boolean, Unit> f5478h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Modifier f5479i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f5480j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Shape f5481k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ long f5482l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ long f5483m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ BorderStroke f5484n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ float f5485o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f5486p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f5487q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ int f5488r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ int f5489s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ int f5490t;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SurfaceKt$Surface$11(boolean z11, Function1<? super Boolean, Unit> function1, Modifier modifier, boolean z12, Shape shape, long j11, long j12, BorderStroke borderStroke, float f11, MutableInteractionSource mutableInteractionSource, Function2<? super Composer, ? super Integer, Unit> function2, int i11, int i12, int i13) {
        super(2);
        this.f5477g = z11;
        this.f5478h = function1;
        this.f5479i = modifier;
        this.f5480j = z12;
        this.f5481k = shape;
        this.f5482l = j11;
        this.f5483m = j12;
        this.f5484n = borderStroke;
        this.f5485o = f11;
        this.f5486p = mutableInteractionSource;
        this.f5487q = function2;
        this.f5488r = i11;
        this.f5489s = i12;
        this.f5490t = i13;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        boolean z11 = this.f5477g;
        boolean z12 = z11;
        SurfaceKt.m1387SurfaceNy5ogXk(z12, (Function1<? super Boolean, Unit>) this.f5478h, this.f5479i, this.f5480j, this.f5481k, this.f5482l, this.f5483m, this.f5484n, this.f5485o, this.f5486p, (Function2<? super Composer, ? super Integer, Unit>) this.f5487q, composer, this.f5488r | 1, this.f5489s, this.f5490t);
    }
}
