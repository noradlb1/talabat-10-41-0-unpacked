package com.designsystem.ds_input_field;

import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class InputFieldCommonComposablesKt$TextInputWithAnimatedHint$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ BoxScope f31726g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f31727h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f31728i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Dp f31729j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f31730k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f31731l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ long f31732m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ TextStyle f31733n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ boolean f31734o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ int f31735p;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InputFieldCommonComposablesKt$TextInputWithAnimatedHint$2(BoxScope boxScope, String str, boolean z11, Dp dp2, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, long j11, TextStyle textStyle, boolean z12, int i11) {
        super(2);
        this.f31726g = boxScope;
        this.f31727h = str;
        this.f31728i = z11;
        this.f31729j = dp2;
        this.f31730k = function2;
        this.f31731l = function22;
        this.f31732m = j11;
        this.f31733n = textStyle;
        this.f31734o = z12;
        this.f31735p = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        InputFieldCommonComposablesKt.m8427TextInputWithAnimatedHintfD77gVg(this.f31726g, this.f31727h, this.f31728i, this.f31729j, this.f31730k, this.f31731l, this.f31732m, this.f31733n, this.f31734o, composer, this.f31735p | 1);
    }
}
