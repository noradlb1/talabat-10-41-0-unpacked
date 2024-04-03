package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class AlertDialogKt$AlertDialogContent$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6278g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f6279h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6280i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6281j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6282k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Shape f6283l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ long f6284m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ float f6285n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ long f6286o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ long f6287p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ long f6288q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ long f6289r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ int f6290s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ int f6291t;

    /* renamed from: u  reason: collision with root package name */
    public final /* synthetic */ int f6292u;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AlertDialogKt$AlertDialogContent$2(Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Shape shape, long j11, float f11, long j12, long j13, long j14, long j15, int i11, int i12, int i13) {
        super(2);
        this.f6278g = function2;
        this.f6279h = modifier;
        this.f6280i = function22;
        this.f6281j = function23;
        this.f6282k = function24;
        this.f6283l = shape;
        this.f6284m = j11;
        this.f6285n = f11;
        this.f6286o = j12;
        this.f6287p = j13;
        this.f6288q = j14;
        this.f6289r = j15;
        this.f6290s = i11;
        this.f6291t = i12;
        this.f6292u = i13;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        Composer composer2 = composer;
        Function2<Composer, Integer, Unit> function2 = this.f6278g;
        Function2<Composer, Integer, Unit> function22 = function2;
        AlertDialogKt.m1493AlertDialogContent4hvqGtA(function22, this.f6279h, this.f6280i, this.f6281j, this.f6282k, this.f6283l, this.f6284m, this.f6285n, this.f6286o, this.f6287p, this.f6288q, this.f6289r, composer2, this.f6290s | 1, this.f6291t, this.f6292u);
    }
}
