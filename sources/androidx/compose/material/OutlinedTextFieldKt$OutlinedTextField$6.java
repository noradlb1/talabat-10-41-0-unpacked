package androidx.compose.material;

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

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class OutlinedTextFieldKt$OutlinedTextField$6 extends Lambda implements Function2<Composer, Integer, Unit> {
    public final /* synthetic */ int A;
    public final /* synthetic */ int B;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TextFieldValue f4888g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function1<TextFieldValue, Unit> f4889h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Modifier f4890i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f4891j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ boolean f4892k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ TextStyle f4893l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f4894m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f4895n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f4896o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f4897p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ boolean f4898q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ VisualTransformation f4899r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ KeyboardOptions f4900s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ KeyboardActions f4901t;

    /* renamed from: u  reason: collision with root package name */
    public final /* synthetic */ boolean f4902u;

    /* renamed from: v  reason: collision with root package name */
    public final /* synthetic */ int f4903v;

    /* renamed from: w  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f4904w;

    /* renamed from: x  reason: collision with root package name */
    public final /* synthetic */ Shape f4905x;

    /* renamed from: y  reason: collision with root package name */
    public final /* synthetic */ TextFieldColors f4906y;

    /* renamed from: z  reason: collision with root package name */
    public final /* synthetic */ int f4907z;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OutlinedTextFieldKt$OutlinedTextField$6(TextFieldValue textFieldValue, Function1<? super TextFieldValue, Unit> function1, Modifier modifier, boolean z11, boolean z12, TextStyle textStyle, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, boolean z13, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean z14, int i11, MutableInteractionSource mutableInteractionSource, Shape shape, TextFieldColors textFieldColors, int i12, int i13, int i14) {
        super(2);
        this.f4888g = textFieldValue;
        this.f4889h = function1;
        this.f4890i = modifier;
        this.f4891j = z11;
        this.f4892k = z12;
        this.f4893l = textStyle;
        this.f4894m = function2;
        this.f4895n = function22;
        this.f4896o = function23;
        this.f4897p = function24;
        this.f4898q = z13;
        this.f4899r = visualTransformation;
        this.f4900s = keyboardOptions;
        this.f4901t = keyboardActions;
        this.f4902u = z14;
        this.f4903v = i11;
        this.f4904w = mutableInteractionSource;
        this.f4905x = shape;
        this.f4906y = textFieldColors;
        this.f4907z = i12;
        this.A = i13;
        this.B = i14;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        Composer composer2 = composer;
        TextFieldValue textFieldValue = this.f4888g;
        TextFieldValue textFieldValue2 = textFieldValue;
        OutlinedTextFieldKt.OutlinedTextField(textFieldValue2, (Function1<? super TextFieldValue, Unit>) this.f4889h, this.f4890i, this.f4891j, this.f4892k, this.f4893l, (Function2<? super Composer, ? super Integer, Unit>) this.f4894m, (Function2<? super Composer, ? super Integer, Unit>) this.f4895n, (Function2<? super Composer, ? super Integer, Unit>) this.f4896o, (Function2<? super Composer, ? super Integer, Unit>) this.f4897p, this.f4898q, this.f4899r, this.f4900s, this.f4901t, this.f4902u, this.f4903v, this.f4904w, this.f4905x, this.f4906y, composer2, this.f4907z | 1, this.A, this.B);
    }
}
