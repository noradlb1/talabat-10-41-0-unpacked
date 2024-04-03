package com.designsystem.ds_input_field;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.input.VisualTransformation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSCreditCardFieldKt$DSCreditCardField$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f31369g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f31370h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ String f31371i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f31372j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function1<String, Unit> f31373k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function1<String, Unit> f31374l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ boolean f31375m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ DSInputFieldState f31376n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ int f31377o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ int f31378p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ VisualTransformation f31379q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ Integer f31380r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ int f31381s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ int f31382t;

    /* renamed from: u  reason: collision with root package name */
    public final /* synthetic */ int f31383u;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSCreditCardFieldKt$DSCreditCardField$2(Modifier modifier, String str, String str2, String str3, Function1<? super String, Unit> function1, Function1<? super String, Unit> function12, boolean z11, DSInputFieldState dSInputFieldState, int i11, int i12, VisualTransformation visualTransformation, Integer num, int i13, int i14, int i15) {
        super(2);
        this.f31369g = modifier;
        this.f31370h = str;
        this.f31371i = str2;
        this.f31372j = str3;
        this.f31373k = function1;
        this.f31374l = function12;
        this.f31375m = z11;
        this.f31376n = dSInputFieldState;
        this.f31377o = i11;
        this.f31378p = i12;
        this.f31379q = visualTransformation;
        this.f31380r = num;
        this.f31381s = i13;
        this.f31382t = i14;
        this.f31383u = i15;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        DSCreditCardFieldKt.m8371DSCreditCardFieldk7ZECbw(this.f31369g, this.f31370h, this.f31371i, this.f31372j, this.f31373k, this.f31374l, this.f31375m, this.f31376n, this.f31377o, this.f31378p, this.f31379q, this.f31380r, composer, this.f31381s | 1, this.f31382t, this.f31383u);
    }
}
