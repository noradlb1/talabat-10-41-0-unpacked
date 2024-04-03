package androidx.compose.foundation.text;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.ImeOptions;
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
public final class CoreTextFieldKt$CoreTextField$6 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TextFieldValue f3417g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function1<TextFieldValue, Unit> f3418h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Modifier f3419i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ TextStyle f3420j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ VisualTransformation f3421k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function1<TextLayoutResult, Unit> f3422l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f3423m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Brush f3424n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ boolean f3425o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ int f3426p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ ImeOptions f3427q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ KeyboardActions f3428r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ boolean f3429s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ boolean f3430t;

    /* renamed from: u  reason: collision with root package name */
    public final /* synthetic */ Function3<Function2<? super Composer, ? super Integer, Unit>, Composer, Integer, Unit> f3431u;

    /* renamed from: v  reason: collision with root package name */
    public final /* synthetic */ int f3432v;

    /* renamed from: w  reason: collision with root package name */
    public final /* synthetic */ int f3433w;

    /* renamed from: x  reason: collision with root package name */
    public final /* synthetic */ int f3434x;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CoreTextFieldKt$CoreTextField$6(TextFieldValue textFieldValue, Function1<? super TextFieldValue, Unit> function1, Modifier modifier, TextStyle textStyle, VisualTransformation visualTransformation, Function1<? super TextLayoutResult, Unit> function12, MutableInteractionSource mutableInteractionSource, Brush brush, boolean z11, int i11, ImeOptions imeOptions, KeyboardActions keyboardActions, boolean z12, boolean z13, Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function3, int i12, int i13, int i14) {
        super(2);
        this.f3417g = textFieldValue;
        this.f3418h = function1;
        this.f3419i = modifier;
        this.f3420j = textStyle;
        this.f3421k = visualTransformation;
        this.f3422l = function12;
        this.f3423m = mutableInteractionSource;
        this.f3424n = brush;
        this.f3425o = z11;
        this.f3426p = i11;
        this.f3427q = imeOptions;
        this.f3428r = keyboardActions;
        this.f3429s = z12;
        this.f3430t = z13;
        this.f3431u = function3;
        this.f3432v = i12;
        this.f3433w = i13;
        this.f3434x = i14;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        Composer composer2 = composer;
        TextFieldValue textFieldValue = this.f3417g;
        TextFieldValue textFieldValue2 = textFieldValue;
        CoreTextFieldKt.CoreTextField(textFieldValue2, this.f3418h, this.f3419i, this.f3420j, this.f3421k, this.f3422l, this.f3423m, this.f3424n, this.f3425o, this.f3426p, this.f3427q, this.f3428r, this.f3429s, this.f3430t, this.f3431u, composer2, this.f3432v | 1, this.f3433w, this.f3434x);
    }
}
