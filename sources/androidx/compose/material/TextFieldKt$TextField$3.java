package androidx.compose.material;

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

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class TextFieldKt$TextField$3 extends Lambda implements Function2<Composer, Integer, Unit> {
    public final /* synthetic */ int A;
    public final /* synthetic */ int B;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f6023g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function1<String, Unit> f6024h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Modifier f6025i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f6026j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ boolean f6027k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ TextStyle f6028l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6029m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6030n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6031o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6032p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ boolean f6033q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ VisualTransformation f6034r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ KeyboardOptions f6035s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ KeyboardActions f6036t;

    /* renamed from: u  reason: collision with root package name */
    public final /* synthetic */ boolean f6037u;

    /* renamed from: v  reason: collision with root package name */
    public final /* synthetic */ int f6038v;

    /* renamed from: w  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f6039w;

    /* renamed from: x  reason: collision with root package name */
    public final /* synthetic */ Shape f6040x;

    /* renamed from: y  reason: collision with root package name */
    public final /* synthetic */ TextFieldColors f6041y;

    /* renamed from: z  reason: collision with root package name */
    public final /* synthetic */ int f6042z;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextFieldKt$TextField$3(String str, Function1<? super String, Unit> function1, Modifier modifier, boolean z11, boolean z12, TextStyle textStyle, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, boolean z13, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean z14, int i11, MutableInteractionSource mutableInteractionSource, Shape shape, TextFieldColors textFieldColors, int i12, int i13, int i14) {
        super(2);
        this.f6023g = str;
        this.f6024h = function1;
        this.f6025i = modifier;
        this.f6026j = z11;
        this.f6027k = z12;
        this.f6028l = textStyle;
        this.f6029m = function2;
        this.f6030n = function22;
        this.f6031o = function23;
        this.f6032p = function24;
        this.f6033q = z13;
        this.f6034r = visualTransformation;
        this.f6035s = keyboardOptions;
        this.f6036t = keyboardActions;
        this.f6037u = z14;
        this.f6038v = i11;
        this.f6039w = mutableInteractionSource;
        this.f6040x = shape;
        this.f6041y = textFieldColors;
        this.f6042z = i12;
        this.A = i13;
        this.B = i14;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        Composer composer2 = composer;
        String str = this.f6023g;
        String str2 = str;
        TextFieldKt.TextField(str2, (Function1<? super String, Unit>) this.f6024h, this.f6025i, this.f6026j, this.f6027k, this.f6028l, (Function2<? super Composer, ? super Integer, Unit>) this.f6029m, (Function2<? super Composer, ? super Integer, Unit>) this.f6030n, (Function2<? super Composer, ? super Integer, Unit>) this.f6031o, (Function2<? super Composer, ? super Integer, Unit>) this.f6032p, this.f6033q, this.f6034r, this.f6035s, this.f6036t, this.f6037u, this.f6038v, this.f6039w, this.f6040x, this.f6041y, composer2, this.f6042z | 1, this.A, this.B);
    }
}
