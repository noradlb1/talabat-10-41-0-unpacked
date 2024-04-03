package androidx.compose.material;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class TextFieldKt$TextFieldLayout$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f6076g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6077h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6078i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function3<Modifier, Composer, Integer, Unit> f6079j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6080k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6081l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ boolean f6082m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ float f6083n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ PaddingValues f6084o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ int f6085p;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextFieldKt$TextFieldLayout$2(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function3<? super Modifier, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, boolean z11, float f11, PaddingValues paddingValues, int i11) {
        super(2);
        this.f6076g = modifier;
        this.f6077h = function2;
        this.f6078i = function22;
        this.f6079j = function3;
        this.f6080k = function23;
        this.f6081l = function24;
        this.f6082m = z11;
        this.f6083n = f11;
        this.f6084o = paddingValues;
        this.f6085p = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        TextFieldKt.TextFieldLayout(this.f6076g, this.f6077h, this.f6078i, this.f6079j, this.f6080k, this.f6081l, this.f6082m, this.f6083n, this.f6084o, composer, this.f6085p | 1);
    }
}
