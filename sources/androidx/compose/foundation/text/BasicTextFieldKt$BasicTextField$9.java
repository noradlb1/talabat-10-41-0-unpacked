package androidx.compose.foundation.text;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.VisualTransformation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class BasicTextFieldKt$BasicTextField$9 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TextFieldValue f3296g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function1<TextFieldValue, Unit> f3297h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Modifier f3298i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f3299j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ boolean f3300k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ TextStyle f3301l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ KeyboardOptions f3302m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ KeyboardActions f3303n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ boolean f3304o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ int f3305p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ VisualTransformation f3306q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ Function1<TextLayoutResult, Unit> f3307r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f3308s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ Brush f3309t;

    /* renamed from: u  reason: collision with root package name */
    public final /* synthetic */ Function3<Function2<? super Composer, ? super Integer, Unit>, Composer, Integer, Unit> f3310u;

    /* renamed from: v  reason: collision with root package name */
    public final /* synthetic */ int f3311v;

    /* renamed from: w  reason: collision with root package name */
    public final /* synthetic */ int f3312w;

    /* renamed from: x  reason: collision with root package name */
    public final /* synthetic */ int f3313x;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BasicTextFieldKt$BasicTextField$9(TextFieldValue textFieldValue, Function1<? super TextFieldValue, Unit> function1, Modifier modifier, boolean z11, boolean z12, TextStyle textStyle, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean z13, int i11, VisualTransformation visualTransformation, Function1<? super TextLayoutResult, Unit> function12, MutableInteractionSource mutableInteractionSource, Brush brush, Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function3, int i12, int i13, int i14) {
        super(2);
        this.f3296g = textFieldValue;
        this.f3297h = function1;
        this.f3298i = modifier;
        this.f3299j = z11;
        this.f3300k = z12;
        this.f3301l = textStyle;
        this.f3302m = keyboardOptions;
        this.f3303n = keyboardActions;
        this.f3304o = z13;
        this.f3305p = i11;
        this.f3306q = visualTransformation;
        this.f3307r = function12;
        this.f3308s = mutableInteractionSource;
        this.f3309t = brush;
        this.f3310u = function3;
        this.f3311v = i12;
        this.f3312w = i13;
        this.f3313x = i14;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        Composer composer2 = composer;
        TextFieldValue textFieldValue = this.f3296g;
        TextFieldValue textFieldValue2 = textFieldValue;
        BasicTextFieldKt.BasicTextField(textFieldValue2, (Function1<? super TextFieldValue, Unit>) this.f3297h, this.f3298i, this.f3299j, this.f3300k, this.f3301l, this.f3302m, this.f3303n, this.f3304o, this.f3305p, this.f3306q, (Function1<? super TextLayoutResult, Unit>) this.f3307r, this.f3308s, this.f3309t, (Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit>) this.f3310u, composer2, this.f3311v | 1, this.f3312w, this.f3313x);
    }
}
