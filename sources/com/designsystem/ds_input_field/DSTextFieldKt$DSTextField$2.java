package com.designsystem.ds_input_field;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.input.VisualTransformation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSTextFieldKt$DSTextField$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f31522g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f31523h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ String f31524i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f31525j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function1<String, Unit> f31526k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function1<String, Unit> f31527l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ boolean f31528m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ DSInputFieldState f31529n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ Integer f31530o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ Integer f31531p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f31532q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ boolean f31533r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ int f31534s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ int f31535t;

    /* renamed from: u  reason: collision with root package name */
    public final /* synthetic */ VisualTransformation f31536u;

    /* renamed from: v  reason: collision with root package name */
    public final /* synthetic */ Integer f31537v;

    /* renamed from: w  reason: collision with root package name */
    public final /* synthetic */ int f31538w;

    /* renamed from: x  reason: collision with root package name */
    public final /* synthetic */ int f31539x;

    /* renamed from: y  reason: collision with root package name */
    public final /* synthetic */ int f31540y;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSTextFieldKt$DSTextField$2(Modifier modifier, String str, String str2, String str3, Function1<? super String, Unit> function1, Function1<? super String, Unit> function12, boolean z11, DSInputFieldState dSInputFieldState, Integer num, Integer num2, Function0<Unit> function0, boolean z12, int i11, int i12, VisualTransformation visualTransformation, Integer num3, int i13, int i14, int i15) {
        super(2);
        this.f31522g = modifier;
        this.f31523h = str;
        this.f31524i = str2;
        this.f31525j = str3;
        this.f31526k = function1;
        this.f31527l = function12;
        this.f31528m = z11;
        this.f31529n = dSInputFieldState;
        this.f31530o = num;
        this.f31531p = num2;
        this.f31532q = function0;
        this.f31533r = z12;
        this.f31534s = i11;
        this.f31535t = i12;
        this.f31536u = visualTransformation;
        this.f31537v = num3;
        this.f31538w = i13;
        this.f31539x = i14;
        this.f31540y = i15;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        Composer composer2 = composer;
        Modifier modifier = this.f31522g;
        Modifier modifier2 = modifier;
        DSTextFieldKt.m8389DSTextFieldjAliMPc(modifier2, this.f31523h, this.f31524i, this.f31525j, this.f31526k, this.f31527l, this.f31528m, this.f31529n, this.f31530o, this.f31531p, this.f31532q, this.f31533r, this.f31534s, this.f31535t, this.f31536u, this.f31537v, composer2, this.f31538w | 1, this.f31539x, this.f31540y);
    }
}
