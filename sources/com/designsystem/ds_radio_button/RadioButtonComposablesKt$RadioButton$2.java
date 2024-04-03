package com.designsystem.ds_radio_button;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class RadioButtonComposablesKt$RadioButton$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f32558g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f32559h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f32560i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f32561j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RadioButtonComposablesKt$RadioButton$2(Modifier modifier, boolean z11, boolean z12, int i11) {
        super(2);
        this.f32558g = modifier;
        this.f32559h = z11;
        this.f32560i = z12;
        this.f32561j = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        RadioButtonComposablesKt.RadioButton(this.f32558g, this.f32559h, this.f32560i, composer, this.f32561j | 1);
    }
}
