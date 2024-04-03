package androidx.compose.material3;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.VisualTransformation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class TextFieldKt$TextField$3 extends Lambda implements Function2<Composer, Integer, Unit> {
    public final /* synthetic */ int A;
    public final /* synthetic */ int B;
    public final /* synthetic */ int C;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f8849g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function1<String, Unit> f8850h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Modifier f8851i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f8852j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ boolean f8853k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ TextStyle f8854l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f8855m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f8856n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f8857o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f8858p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f8859q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ boolean f8860r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ VisualTransformation f8861s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ KeyboardOptions f8862t;

    /* renamed from: u  reason: collision with root package name */
    public final /* synthetic */ KeyboardActions f8863u;

    /* renamed from: v  reason: collision with root package name */
    public final /* synthetic */ boolean f8864v;

    /* renamed from: w  reason: collision with root package name */
    public final /* synthetic */ int f8865w;

    /* renamed from: x  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f8866x;

    /* renamed from: y  reason: collision with root package name */
    public final /* synthetic */ Shape f8867y;

    /* renamed from: z  reason: collision with root package name */
    public final /* synthetic */ TextFieldColors f8868z;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextFieldKt$TextField$3(String str, Function1<? super String, Unit> function1, Modifier modifier, boolean z11, boolean z12, TextStyle textStyle, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Function2<? super Composer, ? super Integer, Unit> function25, boolean z13, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean z14, int i11, MutableInteractionSource mutableInteractionSource, Shape shape, TextFieldColors textFieldColors, int i12, int i13, int i14) {
        super(2);
        this.f8849g = str;
        this.f8850h = function1;
        this.f8851i = modifier;
        this.f8852j = z11;
        this.f8853k = z12;
        this.f8854l = textStyle;
        this.f8855m = function2;
        this.f8856n = function22;
        this.f8857o = function23;
        this.f8858p = function24;
        this.f8859q = function25;
        this.f8860r = z13;
        this.f8861s = visualTransformation;
        this.f8862t = keyboardOptions;
        this.f8863u = keyboardActions;
        this.f8864v = z14;
        this.f8865w = i11;
        this.f8866x = mutableInteractionSource;
        this.f8867y = shape;
        this.f8868z = textFieldColors;
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
        String str = this.f8849g;
        String str2 = str;
        TextFieldKt.TextField(str2, (Function1<? super String, Unit>) this.f8850h, this.f8851i, this.f8852j, this.f8853k, this.f8854l, (Function2<? super Composer, ? super Integer, Unit>) this.f8855m, (Function2<? super Composer, ? super Integer, Unit>) this.f8856n, (Function2<? super Composer, ? super Integer, Unit>) this.f8857o, (Function2<? super Composer, ? super Integer, Unit>) this.f8858p, (Function2<? super Composer, ? super Integer, Unit>) this.f8859q, this.f8860r, this.f8861s, this.f8862t, this.f8863u, this.f8864v, this.f8865w, this.f8866x, this.f8867y, this.f8868z, composer2, this.A | 1, this.B, this.C);
    }
}
