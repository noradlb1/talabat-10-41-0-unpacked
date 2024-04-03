package androidx.compose.material;

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

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class OutlinedTextFieldKt$OutlinedTextFieldLayout$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f4908g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f4909h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function3<Modifier, Composer, Integer, Unit> f4910i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f4911j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f4912k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f4913l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ boolean f4914m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ float f4915n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ Function1<Size, Unit> f4916o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f4917p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ PaddingValues f4918q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ int f4919r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ int f4920s;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OutlinedTextFieldKt$OutlinedTextFieldLayout$2(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Function3<? super Modifier, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, boolean z11, float f11, Function1<? super Size, Unit> function1, Function2<? super Composer, ? super Integer, Unit> function25, PaddingValues paddingValues, int i11, int i12) {
        super(2);
        this.f4908g = modifier;
        this.f4909h = function2;
        this.f4910i = function3;
        this.f4911j = function22;
        this.f4912k = function23;
        this.f4913l = function24;
        this.f4914m = z11;
        this.f4915n = f11;
        this.f4916o = function1;
        this.f4917p = function25;
        this.f4918q = paddingValues;
        this.f4919r = i11;
        this.f4920s = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        OutlinedTextFieldKt.OutlinedTextFieldLayout(this.f4908g, this.f4909h, this.f4910i, this.f4911j, this.f4912k, this.f4913l, this.f4914m, this.f4915n, this.f4916o, this.f4917p, this.f4918q, composer, this.f4919r | 1, this.f4920s);
    }
}
