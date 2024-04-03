package com.designsystem.ds_button_v2.composables;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.text.TextStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class ButtonComposablesKt$ButtonCounter$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f30806g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Shape f30807h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ TextStyle f30808i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ long f30809j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f30810k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ButtonComposablesKt$ButtonCounter$1(int i11, Shape shape, TextStyle textStyle, long j11, int i12) {
        super(2);
        this.f30806g = i11;
        this.f30807h = shape;
        this.f30808i = textStyle;
        this.f30809j = j11;
        this.f30810k = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        ButtonComposablesKt.m8295ButtonCounterBx497Mc(this.f30806g, this.f30807h, this.f30808i, this.f30809j, composer, this.f30810k | 1);
    }
}
