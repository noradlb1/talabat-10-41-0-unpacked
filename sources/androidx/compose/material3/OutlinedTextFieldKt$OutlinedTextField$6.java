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
public final class OutlinedTextFieldKt$OutlinedTextField$6 extends Lambda implements Function2<Composer, Integer, Unit> {
    public final /* synthetic */ int A;
    public final /* synthetic */ int B;
    public final /* synthetic */ int C;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TextFieldValue f7735g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function1<TextFieldValue, Unit> f7736h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Modifier f7737i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f7738j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ boolean f7739k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ TextStyle f7740l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f7741m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f7742n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f7743o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f7744p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f7745q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ boolean f7746r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ VisualTransformation f7747s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ KeyboardOptions f7748t;

    /* renamed from: u  reason: collision with root package name */
    public final /* synthetic */ KeyboardActions f7749u;

    /* renamed from: v  reason: collision with root package name */
    public final /* synthetic */ boolean f7750v;

    /* renamed from: w  reason: collision with root package name */
    public final /* synthetic */ int f7751w;

    /* renamed from: x  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f7752x;

    /* renamed from: y  reason: collision with root package name */
    public final /* synthetic */ Shape f7753y;

    /* renamed from: z  reason: collision with root package name */
    public final /* synthetic */ TextFieldColors f7754z;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OutlinedTextFieldKt$OutlinedTextField$6(TextFieldValue textFieldValue, Function1<? super TextFieldValue, Unit> function1, Modifier modifier, boolean z11, boolean z12, TextStyle textStyle, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Function2<? super Composer, ? super Integer, Unit> function25, boolean z13, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean z14, int i11, MutableInteractionSource mutableInteractionSource, Shape shape, TextFieldColors textFieldColors, int i12, int i13, int i14) {
        super(2);
        this.f7735g = textFieldValue;
        this.f7736h = function1;
        this.f7737i = modifier;
        this.f7738j = z11;
        this.f7739k = z12;
        this.f7740l = textStyle;
        this.f7741m = function2;
        this.f7742n = function22;
        this.f7743o = function23;
        this.f7744p = function24;
        this.f7745q = function25;
        this.f7746r = z13;
        this.f7747s = visualTransformation;
        this.f7748t = keyboardOptions;
        this.f7749u = keyboardActions;
        this.f7750v = z14;
        this.f7751w = i11;
        this.f7752x = mutableInteractionSource;
        this.f7753y = shape;
        this.f7754z = textFieldColors;
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
        TextFieldValue textFieldValue = this.f7735g;
        TextFieldValue textFieldValue2 = textFieldValue;
        OutlinedTextFieldKt.OutlinedTextField(textFieldValue2, (Function1<? super TextFieldValue, Unit>) this.f7736h, this.f7737i, this.f7738j, this.f7739k, this.f7740l, (Function2<? super Composer, ? super Integer, Unit>) this.f7741m, (Function2<? super Composer, ? super Integer, Unit>) this.f7742n, (Function2<? super Composer, ? super Integer, Unit>) this.f7743o, (Function2<? super Composer, ? super Integer, Unit>) this.f7744p, (Function2<? super Composer, ? super Integer, Unit>) this.f7745q, this.f7746r, this.f7747s, this.f7748t, this.f7749u, this.f7750v, this.f7751w, this.f7752x, this.f7753y, this.f7754z, composer2, this.A | 1, this.B, this.C);
    }
}
