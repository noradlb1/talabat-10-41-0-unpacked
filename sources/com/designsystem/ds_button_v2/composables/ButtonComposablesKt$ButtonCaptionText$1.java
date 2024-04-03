package com.designsystem.ds_button_v2.composables;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.text.TextStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class ButtonComposablesKt$ButtonCaptionText$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f30801g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ long f30802h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ TextStyle f30803i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f30804j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f30805k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ButtonComposablesKt$ButtonCaptionText$1(String str, long j11, TextStyle textStyle, int i11, int i12) {
        super(2);
        this.f30801g = str;
        this.f30802h = j11;
        this.f30803i = textStyle;
        this.f30804j = i11;
        this.f30805k = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        ButtonComposablesKt.m8294ButtonCaptionText3IgeMak(this.f30801g, this.f30802h, this.f30803i, composer, this.f30804j | 1, this.f30805k);
    }
}
