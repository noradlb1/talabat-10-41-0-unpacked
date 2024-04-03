package com.designsystem.ds_input_field;

import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class InputFieldCommonComposablesKt$TextInputWithHint$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ BoxScope f31740g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f31741h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ String f31742i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f31743j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Dp f31744k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f31745l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f31746m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ boolean f31747n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ int f31748o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InputFieldCommonComposablesKt$TextInputWithHint$2(BoxScope boxScope, String str, String str2, boolean z11, Dp dp2, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, boolean z12, int i11) {
        super(2);
        this.f31740g = boxScope;
        this.f31741h = str;
        this.f31742i = str2;
        this.f31743j = z11;
        this.f31744k = dp2;
        this.f31745l = function2;
        this.f31746m = function22;
        this.f31747n = z12;
        this.f31748o = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        InputFieldCommonComposablesKt.m8428TextInputWithHintUcWoP3I(this.f31740g, this.f31741h, this.f31742i, this.f31743j, this.f31744k, this.f31745l, this.f31746m, this.f31747n, composer, this.f31748o | 1);
    }
}
