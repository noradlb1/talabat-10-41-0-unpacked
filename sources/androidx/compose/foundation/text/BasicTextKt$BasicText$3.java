package androidx.compose.foundation.text;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class BasicTextKt$BasicText$3 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f3315g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f3316h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ TextStyle f3317i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function1<TextLayoutResult, Unit> f3318j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f3319k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ boolean f3320l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f3321m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f3322n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ int f3323o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BasicTextKt$BasicText$3(String str, Modifier modifier, TextStyle textStyle, Function1<? super TextLayoutResult, Unit> function1, int i11, boolean z11, int i12, int i13, int i14) {
        super(2);
        this.f3315g = str;
        this.f3316h = modifier;
        this.f3317i = textStyle;
        this.f3318j = function1;
        this.f3319k = i11;
        this.f3320l = z11;
        this.f3321m = i12;
        this.f3322n = i13;
        this.f3323o = i14;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        BasicTextKt.m834BasicTextBpD7jsM(this.f3315g, this.f3316h, this.f3317i, this.f3318j, this.f3319k, this.f3320l, this.f3321m, composer, this.f3322n | 1, this.f3323o);
    }
}
