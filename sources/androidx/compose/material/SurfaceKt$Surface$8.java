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
public final class SurfaceKt$Surface$8 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f5567g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f5568h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Modifier f5569i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f5570j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Shape f5571k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ long f5572l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ long f5573m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ BorderStroke f5574n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ float f5575o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f5576p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f5577q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ int f5578r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ int f5579s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ int f5580t;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SurfaceKt$Surface$8(boolean z11, Function0<Unit> function0, Modifier modifier, boolean z12, Shape shape, long j11, long j12, BorderStroke borderStroke, float f11, MutableInteractionSource mutableInteractionSource, Function2<? super Composer, ? super Integer, Unit> function2, int i11, int i12, int i13) {
        super(2);
        this.f5567g = z11;
        this.f5568h = function0;
        this.f5569i = modifier;
        this.f5570j = z12;
        this.f5571k = shape;
        this.f5572l = j11;
        this.f5573m = j12;
        this.f5574n = borderStroke;
        this.f5575o = f11;
        this.f5576p = mutableInteractionSource;
        this.f5577q = function2;
        this.f5578r = i11;
        this.f5579s = i12;
        this.f5580t = i13;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        boolean z11 = this.f5567g;
        boolean z12 = z11;
        SurfaceKt.m1386SurfaceNy5ogXk(z12, this.f5568h, this.f5569i, this.f5570j, this.f5571k, this.f5572l, this.f5573m, this.f5574n, this.f5575o, this.f5576p, (Function2<? super Composer, ? super Integer, Unit>) this.f5577q, composer, this.f5578r | 1, this.f5579s, this.f5580t);
    }
}
