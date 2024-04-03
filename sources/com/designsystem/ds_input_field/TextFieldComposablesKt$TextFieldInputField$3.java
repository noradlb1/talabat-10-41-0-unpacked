package com.designsystem.ds_input_field;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.input.VisualTransformation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class TextFieldComposablesKt$TextFieldInputField$3 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f31918g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f31919h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ String f31920i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f31921j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function1<String, Unit> f31922k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function1<String, Unit> f31923l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ boolean f31924m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ OuterState f31925n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ Integer f31926o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ Integer f31927p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f31928q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ boolean f31929r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ KeyboardType f31930s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ ImeAction f31931t;

    /* renamed from: u  reason: collision with root package name */
    public final /* synthetic */ VisualTransformation f31932u;

    /* renamed from: v  reason: collision with root package name */
    public final /* synthetic */ Integer f31933v;

    /* renamed from: w  reason: collision with root package name */
    public final /* synthetic */ int f31934w;

    /* renamed from: x  reason: collision with root package name */
    public final /* synthetic */ int f31935x;

    /* renamed from: y  reason: collision with root package name */
    public final /* synthetic */ int f31936y;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextFieldComposablesKt$TextFieldInputField$3(Modifier modifier, String str, String str2, String str3, Function1<? super String, Unit> function1, Function1<? super String, Unit> function12, boolean z11, OuterState outerState, Integer num, Integer num2, Function0<Unit> function0, boolean z12, KeyboardType keyboardType, ImeAction imeAction, VisualTransformation visualTransformation, Integer num3, int i11, int i12, int i13) {
        super(2);
        this.f31918g = modifier;
        this.f31919h = str;
        this.f31920i = str2;
        this.f31921j = str3;
        this.f31922k = function1;
        this.f31923l = function12;
        this.f31924m = z11;
        this.f31925n = outerState;
        this.f31926o = num;
        this.f31927p = num2;
        this.f31928q = function0;
        this.f31929r = z12;
        this.f31930s = keyboardType;
        this.f31931t = imeAction;
        this.f31932u = visualTransformation;
        this.f31933v = num3;
        this.f31934w = i11;
        this.f31935x = i12;
        this.f31936y = i13;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        Composer composer2 = composer;
        Modifier modifier = this.f31918g;
        Modifier modifier2 = modifier;
        TextFieldComposablesKt.m8471TextFieldInputFieldqQH3efY(modifier2, this.f31919h, this.f31920i, this.f31921j, this.f31922k, this.f31923l, this.f31924m, this.f31925n, this.f31926o, this.f31927p, this.f31928q, this.f31929r, this.f31930s, this.f31931t, this.f31932u, this.f31933v, composer2, this.f31934w | 1, this.f31935x, this.f31936y);
    }
}
