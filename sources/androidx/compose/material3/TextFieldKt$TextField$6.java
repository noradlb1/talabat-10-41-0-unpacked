package androidx.compose.material3;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.VisualTransformation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class TextFieldKt$TextField$6 extends Lambda implements Function2<Composer, Integer, Unit> {
    public final /* synthetic */ int A;
    public final /* synthetic */ int B;
    public final /* synthetic */ int C;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TextFieldValue f8904g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function1<TextFieldValue, Unit> f8905h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Modifier f8906i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f8907j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ boolean f8908k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ TextStyle f8909l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f8910m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f8911n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f8912o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f8913p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f8914q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ boolean f8915r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ VisualTransformation f8916s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ KeyboardOptions f8917t;

    /* renamed from: u  reason: collision with root package name */
    public final /* synthetic */ KeyboardActions f8918u;

    /* renamed from: v  reason: collision with root package name */
    public final /* synthetic */ boolean f8919v;

    /* renamed from: w  reason: collision with root package name */
    public final /* synthetic */ int f8920w;

    /* renamed from: x  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f8921x;

    /* renamed from: y  reason: collision with root package name */
    public final /* synthetic */ Shape f8922y;

    /* renamed from: z  reason: collision with root package name */
    public final /* synthetic */ TextFieldColors f8923z;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextFieldKt$TextField$6(TextFieldValue textFieldValue, Function1<? super TextFieldValue, Unit> function1, Modifier modifier, boolean z11, boolean z12, TextStyle textStyle, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Function2<? super Composer, ? super Integer, Unit> function25, boolean z13, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean z14, int i11, MutableInteractionSource mutableInteractionSource, Shape shape, TextFieldColors textFieldColors, int i12, int i13, int i14) {
        super(2);
        this.f8904g = textFieldValue;
        this.f8905h = function1;
        this.f8906i = modifier;
        this.f8907j = z11;
        this.f8908k = z12;
        this.f8909l = textStyle;
        this.f8910m = function2;
        this.f8911n = function22;
        this.f8912o = function23;
        this.f8913p = function24;
        this.f8914q = function25;
        this.f8915r = z13;
        this.f8916s = visualTransformation;
        this.f8917t = keyboardOptions;
        this.f8918u = keyboardActions;
        this.f8919v = z14;
        this.f8920w = i11;
        this.f8921x = mutableInteractionSource;
        this.f8922y = shape;
        this.f8923z = textFieldColors;
        this.A = i12;
        this.B = i13;
        this.C = i14;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        Composer composer2 = composer;
        TextFieldValue textFieldValue = this.f8904g;
        TextFieldValue textFieldValue2 = textFieldValue;
        TextFieldKt.TextField(textFieldValue2, (Function1<? super TextFieldValue, Unit>) this.f8905h, this.f8906i, this.f8907j, this.f8908k, this.f8909l, (Function2<? super Composer, ? super Integer, Unit>) this.f8910m, (Function2<? super Composer, ? super Integer, Unit>) this.f8911n, (Function2<? super Composer, ? super Integer, Unit>) this.f8912o, (Function2<? super Composer, ? super Integer, Unit>) this.f8913p, (Function2<? super Composer, ? super Integer, Unit>) this.f8914q, this.f8915r, this.f8916s, this.f8917t, this.f8918u, this.f8919v, this.f8920w, this.f8921x, this.f8922y, this.f8923z, composer2, this.A | 1, this.B, this.C);
    }
}
