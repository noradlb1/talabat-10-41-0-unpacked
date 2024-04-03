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
public final class OutlinedTextFieldKt$OutlinedTextField$3 extends Lambda implements Function2<Composer, Integer, Unit> {
    public final /* synthetic */ int A;
    public final /* synthetic */ int B;
    public final /* synthetic */ int C;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f7673g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function1<String, Unit> f7674h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Modifier f7675i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f7676j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ boolean f7677k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ TextStyle f7678l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f7679m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f7680n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f7681o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f7682p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f7683q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ boolean f7684r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ VisualTransformation f7685s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ KeyboardOptions f7686t;

    /* renamed from: u  reason: collision with root package name */
    public final /* synthetic */ KeyboardActions f7687u;

    /* renamed from: v  reason: collision with root package name */
    public final /* synthetic */ boolean f7688v;

    /* renamed from: w  reason: collision with root package name */
    public final /* synthetic */ int f7689w;

    /* renamed from: x  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f7690x;

    /* renamed from: y  reason: collision with root package name */
    public final /* synthetic */ Shape f7691y;

    /* renamed from: z  reason: collision with root package name */
    public final /* synthetic */ TextFieldColors f7692z;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OutlinedTextFieldKt$OutlinedTextField$3(String str, Function1<? super String, Unit> function1, Modifier modifier, boolean z11, boolean z12, TextStyle textStyle, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Function2<? super Composer, ? super Integer, Unit> function25, boolean z13, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean z14, int i11, MutableInteractionSource mutableInteractionSource, Shape shape, TextFieldColors textFieldColors, int i12, int i13, int i14) {
        super(2);
        this.f7673g = str;
        this.f7674h = function1;
        this.f7675i = modifier;
        this.f7676j = z11;
        this.f7677k = z12;
        this.f7678l = textStyle;
        this.f7679m = function2;
        this.f7680n = function22;
        this.f7681o = function23;
        this.f7682p = function24;
        this.f7683q = function25;
        this.f7684r = z13;
        this.f7685s = visualTransformation;
        this.f7686t = keyboardOptions;
        this.f7687u = keyboardActions;
        this.f7688v = z14;
        this.f7689w = i11;
        this.f7690x = mutableInteractionSource;
        this.f7691y = shape;
        this.f7692z = textFieldColors;
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
        String str = this.f7673g;
        String str2 = str;
        OutlinedTextFieldKt.OutlinedTextField(str2, (Function1<? super String, Unit>) this.f7674h, this.f7675i, this.f7676j, this.f7677k, this.f7678l, (Function2<? super Composer, ? super Integer, Unit>) this.f7679m, (Function2<? super Composer, ? super Integer, Unit>) this.f7680n, (Function2<? super Composer, ? super Integer, Unit>) this.f7681o, (Function2<? super Composer, ? super Integer, Unit>) this.f7682p, (Function2<? super Composer, ? super Integer, Unit>) this.f7683q, this.f7684r, this.f7685s, this.f7686t, this.f7687u, this.f7688v, this.f7689w, this.f7690x, this.f7691y, this.f7692z, composer2, this.A | 1, this.B, this.C);
    }
}
