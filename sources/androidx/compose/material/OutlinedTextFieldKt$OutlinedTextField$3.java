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
public final class OutlinedTextFieldKt$OutlinedTextField$3 extends Lambda implements Function2<Composer, Integer, Unit> {
    public final /* synthetic */ int A;
    public final /* synthetic */ int B;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f4847g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function1<String, Unit> f4848h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Modifier f4849i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f4850j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ boolean f4851k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ TextStyle f4852l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f4853m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f4854n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f4855o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f4856p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ boolean f4857q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ VisualTransformation f4858r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ KeyboardOptions f4859s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ KeyboardActions f4860t;

    /* renamed from: u  reason: collision with root package name */
    public final /* synthetic */ boolean f4861u;

    /* renamed from: v  reason: collision with root package name */
    public final /* synthetic */ int f4862v;

    /* renamed from: w  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f4863w;

    /* renamed from: x  reason: collision with root package name */
    public final /* synthetic */ Shape f4864x;

    /* renamed from: y  reason: collision with root package name */
    public final /* synthetic */ TextFieldColors f4865y;

    /* renamed from: z  reason: collision with root package name */
    public final /* synthetic */ int f4866z;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OutlinedTextFieldKt$OutlinedTextField$3(String str, Function1<? super String, Unit> function1, Modifier modifier, boolean z11, boolean z12, TextStyle textStyle, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, boolean z13, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean z14, int i11, MutableInteractionSource mutableInteractionSource, Shape shape, TextFieldColors textFieldColors, int i12, int i13, int i14) {
        super(2);
        this.f4847g = str;
        this.f4848h = function1;
        this.f4849i = modifier;
        this.f4850j = z11;
        this.f4851k = z12;
        this.f4852l = textStyle;
        this.f4853m = function2;
        this.f4854n = function22;
        this.f4855o = function23;
        this.f4856p = function24;
        this.f4857q = z13;
        this.f4858r = visualTransformation;
        this.f4859s = keyboardOptions;
        this.f4860t = keyboardActions;
        this.f4861u = z14;
        this.f4862v = i11;
        this.f4863w = mutableInteractionSource;
        this.f4864x = shape;
        this.f4865y = textFieldColors;
        this.f4866z = i12;
        this.A = i13;
        this.B = i14;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        Composer composer2 = composer;
        String str = this.f4847g;
        String str2 = str;
        OutlinedTextFieldKt.OutlinedTextField(str2, (Function1<? super String, Unit>) this.f4848h, this.f4849i, this.f4850j, this.f4851k, this.f4852l, (Function2<? super Composer, ? super Integer, Unit>) this.f4853m, (Function2<? super Composer, ? super Integer, Unit>) this.f4854n, (Function2<? super Composer, ? super Integer, Unit>) this.f4855o, (Function2<? super Composer, ? super Integer, Unit>) this.f4856p, this.f4857q, this.f4858r, this.f4859s, this.f4860t, this.f4861u, this.f4862v, this.f4863w, this.f4864x, this.f4865y, composer2, this.f4866z | 1, this.A, this.B);
    }
}
