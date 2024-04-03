package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.window.DialogProperties;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class AndroidAlertDialog_androidKt$AlertDialog$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f6325g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6326h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Modifier f6327i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6328j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6329k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6330l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6331m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Shape f6332n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ long f6333o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ long f6334p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ long f6335q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ long f6336r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ float f6337s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ DialogProperties f6338t;

    /* renamed from: u  reason: collision with root package name */
    public final /* synthetic */ int f6339u;

    /* renamed from: v  reason: collision with root package name */
    public final /* synthetic */ int f6340v;

    /* renamed from: w  reason: collision with root package name */
    public final /* synthetic */ int f6341w;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AndroidAlertDialog_androidKt$AlertDialog$2(Function0<Unit> function0, Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Function2<? super Composer, ? super Integer, Unit> function25, Shape shape, long j11, long j12, long j13, long j14, float f11, DialogProperties dialogProperties, int i11, int i12, int i13) {
        super(2);
        this.f6325g = function0;
        this.f6326h = function2;
        this.f6327i = modifier;
        this.f6328j = function22;
        this.f6329k = function23;
        this.f6330l = function24;
        this.f6331m = function25;
        this.f6332n = shape;
        this.f6333o = j11;
        this.f6334p = j12;
        this.f6335q = j13;
        this.f6336r = j14;
        this.f6337s = f11;
        this.f6338t = dialogProperties;
        this.f6339u = i11;
        this.f6340v = i12;
        this.f6341w = i13;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        Composer composer2 = composer;
        Function0<Unit> function0 = this.f6325g;
        Function0<Unit> function02 = function0;
        AndroidAlertDialog_androidKt.m1496AlertDialogOix01E0(function02, this.f6326h, this.f6327i, this.f6328j, this.f6329k, this.f6330l, this.f6331m, this.f6332n, this.f6333o, this.f6334p, this.f6335q, this.f6336r, this.f6337s, this.f6338t, composer2, this.f6339u | 1, this.f6340v, this.f6341w);
    }
}
