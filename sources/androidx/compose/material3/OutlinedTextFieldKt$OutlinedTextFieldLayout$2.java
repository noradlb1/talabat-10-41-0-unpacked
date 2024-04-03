package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Size;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class OutlinedTextFieldKt$OutlinedTextFieldLayout$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f7755g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f7756h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function3<Modifier, Composer, Integer, Unit> f7757i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f7758j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f7759k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f7760l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ boolean f7761m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ float f7762n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ Function1<Size, Unit> f7763o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f7764p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f7765q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ PaddingValues f7766r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ int f7767s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ int f7768t;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OutlinedTextFieldKt$OutlinedTextFieldLayout$2(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Function3<? super Modifier, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, boolean z11, float f11, Function1<? super Size, Unit> function1, Function2<? super Composer, ? super Integer, Unit> function25, Function2<? super Composer, ? super Integer, Unit> function26, PaddingValues paddingValues, int i11, int i12) {
        super(2);
        this.f7755g = modifier;
        this.f7756h = function2;
        this.f7757i = function3;
        this.f7758j = function22;
        this.f7759k = function23;
        this.f7760l = function24;
        this.f7761m = z11;
        this.f7762n = f11;
        this.f7763o = function1;
        this.f7764p = function25;
        this.f7765q = function26;
        this.f7766r = paddingValues;
        this.f7767s = i11;
        this.f7768t = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        OutlinedTextFieldKt.OutlinedTextFieldLayout(this.f7755g, this.f7756h, this.f7757i, this.f7758j, this.f7759k, this.f7760l, this.f7761m, this.f7762n, this.f7763o, this.f7764p, this.f7765q, this.f7766r, composer, this.f7767s | 1, this.f7768t);
    }
}
