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
public final class TextFieldKt$TextField$6 extends Lambda implements Function2<Composer, Integer, Unit> {
    public final /* synthetic */ int A;
    public final /* synthetic */ int B;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TextFieldValue f6056g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function1<TextFieldValue, Unit> f6057h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Modifier f6058i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f6059j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ boolean f6060k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ TextStyle f6061l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6062m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6063n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6064o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6065p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ boolean f6066q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ VisualTransformation f6067r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ KeyboardOptions f6068s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ KeyboardActions f6069t;

    /* renamed from: u  reason: collision with root package name */
    public final /* synthetic */ boolean f6070u;

    /* renamed from: v  reason: collision with root package name */
    public final /* synthetic */ int f6071v;

    /* renamed from: w  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f6072w;

    /* renamed from: x  reason: collision with root package name */
    public final /* synthetic */ Shape f6073x;

    /* renamed from: y  reason: collision with root package name */
    public final /* synthetic */ TextFieldColors f6074y;

    /* renamed from: z  reason: collision with root package name */
    public final /* synthetic */ int f6075z;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextFieldKt$TextField$6(TextFieldValue textFieldValue, Function1<? super TextFieldValue, Unit> function1, Modifier modifier, boolean z11, boolean z12, TextStyle textStyle, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, boolean z13, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean z14, int i11, MutableInteractionSource mutableInteractionSource, Shape shape, TextFieldColors textFieldColors, int i12, int i13, int i14) {
        super(2);
        this.f6056g = textFieldValue;
        this.f6057h = function1;
        this.f6058i = modifier;
        this.f6059j = z11;
        this.f6060k = z12;
        this.f6061l = textStyle;
        this.f6062m = function2;
        this.f6063n = function22;
        this.f6064o = function23;
        this.f6065p = function24;
        this.f6066q = z13;
        this.f6067r = visualTransformation;
        this.f6068s = keyboardOptions;
        this.f6069t = keyboardActions;
        this.f6070u = z14;
        this.f6071v = i11;
        this.f6072w = mutableInteractionSource;
        this.f6073x = shape;
        this.f6074y = textFieldColors;
        this.f6075z = i12;
        this.A = i13;
        this.B = i14;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        Composer composer2 = composer;
        TextFieldValue textFieldValue = this.f6056g;
        TextFieldValue textFieldValue2 = textFieldValue;
        TextFieldKt.TextField(textFieldValue2, (Function1<? super TextFieldValue, Unit>) this.f6057h, this.f6058i, this.f6059j, this.f6060k, this.f6061l, (Function2<? super Composer, ? super Integer, Unit>) this.f6062m, (Function2<? super Composer, ? super Integer, Unit>) this.f6063n, (Function2<? super Composer, ? super Integer, Unit>) this.f6064o, (Function2<? super Composer, ? super Integer, Unit>) this.f6065p, this.f6066q, this.f6067r, this.f6068s, this.f6069t, this.f6070u, this.f6071v, this.f6072w, this.f6073x, this.f6074y, composer2, this.f6075z | 1, this.A, this.B);
    }
}
