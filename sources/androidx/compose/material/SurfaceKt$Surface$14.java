package androidx.compose.material;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.semantics.Role;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class SurfaceKt$Surface$14 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f5506g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f5507h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Shape f5508i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ long f5509j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ long f5510k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ BorderStroke f5511l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ float f5512m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f5513n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ Indication f5514o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ boolean f5515p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ String f5516q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ Role f5517r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f5518s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ int f5519t;

    /* renamed from: u  reason: collision with root package name */
    public final /* synthetic */ int f5520u;

    /* renamed from: v  reason: collision with root package name */
    public final /* synthetic */ int f5521v;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SurfaceKt$Surface$14(Function0<Unit> function0, Modifier modifier, Shape shape, long j11, long j12, BorderStroke borderStroke, float f11, MutableInteractionSource mutableInteractionSource, Indication indication, boolean z11, String str, Role role, Function2<? super Composer, ? super Integer, Unit> function2, int i11, int i12, int i13) {
        super(2);
        this.f5506g = function0;
        this.f5507h = modifier;
        this.f5508i = shape;
        this.f5509j = j11;
        this.f5510k = j12;
        this.f5511l = borderStroke;
        this.f5512m = f11;
        this.f5513n = mutableInteractionSource;
        this.f5514o = indication;
        this.f5515p = z11;
        this.f5516q = str;
        this.f5517r = role;
        this.f5518s = function2;
        this.f5519t = i11;
        this.f5520u = i12;
        this.f5521v = i13;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        Composer composer2 = composer;
        Function0<Unit> function0 = this.f5506g;
        Function0<Unit> function02 = function0;
        SurfaceKt.m1383Surface9VG74zQ(function02, this.f5507h, this.f5508i, this.f5509j, this.f5510k, this.f5511l, this.f5512m, this.f5513n, this.f5514o, this.f5515p, this.f5516q, this.f5517r, this.f5518s, composer2, this.f5519t | 1, this.f5520u, this.f5521v);
    }
}
