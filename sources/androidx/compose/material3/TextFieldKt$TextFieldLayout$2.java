package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class TextFieldKt$TextFieldLayout$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f8924g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f8925h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f8926i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function3<Modifier, Composer, Integer, Unit> f8927j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f8928k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f8929l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ boolean f8930m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ float f8931n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f8932o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f8933p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ PaddingValues f8934q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ int f8935r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ int f8936s;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextFieldKt$TextFieldLayout$2(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function3<? super Modifier, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, boolean z11, float f11, Function2<? super Composer, ? super Integer, Unit> function25, Function2<? super Composer, ? super Integer, Unit> function26, PaddingValues paddingValues, int i11, int i12) {
        super(2);
        this.f8924g = modifier;
        this.f8925h = function2;
        this.f8926i = function22;
        this.f8927j = function3;
        this.f8928k = function23;
        this.f8929l = function24;
        this.f8930m = z11;
        this.f8931n = f11;
        this.f8932o = function25;
        this.f8933p = function26;
        this.f8934q = paddingValues;
        this.f8935r = i11;
        this.f8936s = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        TextFieldKt.TextFieldLayout(this.f8924g, this.f8925h, this.f8926i, this.f8927j, this.f8928k, this.f8929l, this.f8930m, this.f8931n, this.f8932o, this.f8933p, this.f8934q, composer, this.f8935r | 1, this.f8936s);
    }
}
