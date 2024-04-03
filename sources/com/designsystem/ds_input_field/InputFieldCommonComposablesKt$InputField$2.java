package com.designsystem.ds_input_field;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class InputFieldCommonComposablesKt$InputField$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    public final /* synthetic */ boolean A;
    public final /* synthetic */ boolean B;
    public final /* synthetic */ int C;
    public final /* synthetic */ int D;
    public final /* synthetic */ int E;
    public final /* synthetic */ int F;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f31642g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f31643h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ String f31644i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f31645j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function1<String, Unit> f31646k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function1<String, Unit> f31647l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ boolean f31648m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ OuterState f31649n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f31650o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f31651p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f31652q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ int f31653r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ Dp f31654s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ Integer f31655t;

    /* renamed from: u  reason: collision with root package name */
    public final /* synthetic */ VisualTransformation f31656u;

    /* renamed from: v  reason: collision with root package name */
    public final /* synthetic */ float f31657v;

    /* renamed from: w  reason: collision with root package name */
    public final /* synthetic */ KeyboardType f31658w;

    /* renamed from: x  reason: collision with root package name */
    public final /* synthetic */ ImeAction f31659x;

    /* renamed from: y  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f31660y;

    /* renamed from: z  reason: collision with root package name */
    public final /* synthetic */ Function1<TextFieldValue, TextFieldValue> f31661z;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InputFieldCommonComposablesKt$InputField$2(Modifier modifier, String str, String str2, String str3, Function1<? super String, Unit> function1, Function1<? super String, Unit> function12, boolean z11, OuterState outerState, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, int i11, Dp dp2, Integer num, VisualTransformation visualTransformation, float f11, KeyboardType keyboardType, ImeAction imeAction, Function0<Unit> function0, Function1<? super TextFieldValue, TextFieldValue> function13, boolean z12, boolean z13, int i12, int i13, int i14, int i15) {
        super(2);
        this.f31642g = modifier;
        this.f31643h = str;
        this.f31644i = str2;
        this.f31645j = str3;
        this.f31646k = function1;
        this.f31647l = function12;
        this.f31648m = z11;
        this.f31649n = outerState;
        this.f31650o = function2;
        this.f31651p = function22;
        this.f31652q = function23;
        this.f31653r = i11;
        this.f31654s = dp2;
        this.f31655t = num;
        this.f31656u = visualTransformation;
        this.f31657v = f11;
        this.f31658w = keyboardType;
        this.f31659x = imeAction;
        this.f31660y = function0;
        this.f31661z = function13;
        this.A = z12;
        this.B = z13;
        this.C = i12;
        this.D = i13;
        this.E = i14;
        this.F = i15;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        Composer composer2 = composer;
        Modifier modifier = this.f31642g;
        Modifier modifier2 = modifier;
        InputFieldCommonComposablesKt.m8413InputFieldmytMHeg(modifier2, this.f31643h, this.f31644i, this.f31645j, this.f31646k, this.f31647l, this.f31648m, this.f31649n, this.f31650o, this.f31651p, this.f31652q, this.f31653r, this.f31654s, this.f31655t, this.f31656u, this.f31657v, this.f31658w, this.f31659x, this.f31660y, this.f31661z, this.A, this.B, composer2, this.C | 1, this.D, this.E, this.F);
    }
}
