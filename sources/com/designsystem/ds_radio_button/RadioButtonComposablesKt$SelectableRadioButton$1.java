package com.designsystem.ds_radio_button;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class RadioButtonComposablesKt$SelectableRadioButton$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f32564g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f32565h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f32566i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f32567j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f32568k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RadioButtonComposablesKt$SelectableRadioButton$1(Modifier modifier, boolean z11, boolean z12, Function0<Unit> function0, int i11) {
        super(2);
        this.f32564g = modifier;
        this.f32565h = z11;
        this.f32566i = z12;
        this.f32567j = function0;
        this.f32568k = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        RadioButtonComposablesKt.SelectableRadioButton(this.f32564g, this.f32565h, this.f32566i, this.f32567j, composer, this.f32568k | 1);
    }
}
