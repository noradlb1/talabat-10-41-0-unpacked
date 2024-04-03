package androidx.compose.foundation.text;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.VisualTransformation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class BasicTextFieldKt$BasicTextField$5 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f3276g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function1<String, Unit> f3277h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Modifier f3278i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f3279j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ boolean f3280k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ TextStyle f3281l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ KeyboardOptions f3282m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ KeyboardActions f3283n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ boolean f3284o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ int f3285p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ VisualTransformation f3286q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ Function1<TextLayoutResult, Unit> f3287r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f3288s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ Brush f3289t;

    /* renamed from: u  reason: collision with root package name */
    public final /* synthetic */ Function3<Function2<? super Composer, ? super Integer, Unit>, Composer, Integer, Unit> f3290u;

    /* renamed from: v  reason: collision with root package name */
    public final /* synthetic */ int f3291v;

    /* renamed from: w  reason: collision with root package name */
    public final /* synthetic */ int f3292w;

    /* renamed from: x  reason: collision with root package name */
    public final /* synthetic */ int f3293x;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BasicTextFieldKt$BasicTextField$5(String str, Function1<? super String, Unit> function1, Modifier modifier, boolean z11, boolean z12, TextStyle textStyle, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean z13, int i11, VisualTransformation visualTransformation, Function1<? super TextLayoutResult, Unit> function12, MutableInteractionSource mutableInteractionSource, Brush brush, Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function3, int i12, int i13, int i14) {
        super(2);
        this.f3276g = str;
        this.f3277h = function1;
        this.f3278i = modifier;
        this.f3279j = z11;
        this.f3280k = z12;
        this.f3281l = textStyle;
        this.f3282m = keyboardOptions;
        this.f3283n = keyboardActions;
        this.f3284o = z13;
        this.f3285p = i11;
        this.f3286q = visualTransformation;
        this.f3287r = function12;
        this.f3288s = mutableInteractionSource;
        this.f3289t = brush;
        this.f3290u = function3;
        this.f3291v = i12;
        this.f3292w = i13;
        this.f3293x = i14;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        Composer composer2 = composer;
        String str = this.f3276g;
        String str2 = str;
        BasicTextFieldKt.BasicTextField(str2, (Function1<? super String, Unit>) this.f3277h, this.f3278i, this.f3279j, this.f3280k, this.f3281l, this.f3282m, this.f3283n, this.f3284o, this.f3285p, this.f3286q, (Function1<? super TextLayoutResult, Unit>) this.f3287r, this.f3288s, this.f3289t, (Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit>) this.f3290u, composer2, this.f3291v | 1, this.f3292w, this.f3293x);
    }
}
