package com.designsystem.ds_button_v2.composables;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class ButtonComposablesKt$ButtonTitleText$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f30817g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ long f30818h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Modifier f30819i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ TextStyle f30820j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function1<TextLayoutResult, Unit> f30821k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f30822l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f30823m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ButtonComposablesKt$ButtonTitleText$2(String str, long j11, Modifier modifier, TextStyle textStyle, Function1<? super TextLayoutResult, Unit> function1, int i11, int i12) {
        super(2);
        this.f30817g = str;
        this.f30818h = j11;
        this.f30819i = modifier;
        this.f30820j = textStyle;
        this.f30821k = function1;
        this.f30822l = i11;
        this.f30823m = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        ButtonComposablesKt.m8297ButtonTitleText8V94_ZQ(this.f30817g, this.f30818h, this.f30819i, this.f30820j, this.f30821k, composer, this.f30822l | 1, this.f30823m);
    }
}
