package androidx.compose.material;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class SurfaceKt$Surface$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f5522g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Shape f5523h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ long f5524i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ long f5525j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ BorderStroke f5526k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ float f5527l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f5528m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f5529n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ int f5530o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SurfaceKt$Surface$2(Modifier modifier, Shape shape, long j11, long j12, BorderStroke borderStroke, float f11, Function2<? super Composer, ? super Integer, Unit> function2, int i11, int i12) {
        super(2);
        this.f5522g = modifier;
        this.f5523h = shape;
        this.f5524i = j11;
        this.f5525j = j12;
        this.f5526k = borderStroke;
        this.f5527l = f11;
        this.f5528m = function2;
        this.f5529n = i11;
        this.f5530o = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        SurfaceKt.m1384SurfaceFjzlyU(this.f5522g, this.f5523h, this.f5524i, this.f5525j, this.f5526k, this.f5527l, this.f5528m, composer, this.f5529n | 1, this.f5530o);
    }
}
