package com.designsystem.ds_text;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSTextKt$DSText$3 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f33111g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f33112h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ float f33113i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ long f33114j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ long f33115k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ FontStyle f33116l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ FontWeight f33117m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ FontFamily f33118n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ long f33119o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ TextDecoration f33120p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ TextAlign f33121q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ long f33122r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ int f33123s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ boolean f33124t;

    /* renamed from: u  reason: collision with root package name */
    public final /* synthetic */ int f33125u;

    /* renamed from: v  reason: collision with root package name */
    public final /* synthetic */ Function1<TextLayoutResult, Unit> f33126v;

    /* renamed from: w  reason: collision with root package name */
    public final /* synthetic */ TextStyle f33127w;

    /* renamed from: x  reason: collision with root package name */
    public final /* synthetic */ int f33128x;

    /* renamed from: y  reason: collision with root package name */
    public final /* synthetic */ int f33129y;

    /* renamed from: z  reason: collision with root package name */
    public final /* synthetic */ int f33130z;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSTextKt$DSText$3(String str, Modifier modifier, float f11, long j11, long j12, FontStyle fontStyle, FontWeight fontWeight, FontFamily fontFamily, long j13, TextDecoration textDecoration, TextAlign textAlign, long j14, int i11, boolean z11, int i12, Function1<? super TextLayoutResult, Unit> function1, TextStyle textStyle, int i13, int i14, int i15) {
        super(2);
        this.f33111g = str;
        this.f33112h = modifier;
        this.f33113i = f11;
        this.f33114j = j11;
        this.f33115k = j12;
        this.f33116l = fontStyle;
        this.f33117m = fontWeight;
        this.f33118n = fontFamily;
        this.f33119o = j13;
        this.f33120p = textDecoration;
        this.f33121q = textAlign;
        this.f33122r = j14;
        this.f33123s = i11;
        this.f33124t = z11;
        this.f33125u = i12;
        this.f33126v = function1;
        this.f33127w = textStyle;
        this.f33128x = i13;
        this.f33129y = i14;
        this.f33130z = i15;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        Composer composer2 = composer;
        String str = this.f33111g;
        String str2 = str;
        DSTextKt.m8635DSTextqBUjsXY(str2, this.f33112h, this.f33113i, this.f33114j, this.f33115k, this.f33116l, this.f33117m, this.f33118n, this.f33119o, this.f33120p, this.f33121q, this.f33122r, this.f33123s, this.f33124t, this.f33125u, this.f33126v, this.f33127w, composer2, this.f33128x | 1, this.f33129y, this.f33130z);
    }
}
