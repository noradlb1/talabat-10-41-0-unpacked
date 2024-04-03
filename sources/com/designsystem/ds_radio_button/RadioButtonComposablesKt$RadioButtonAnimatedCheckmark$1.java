package com.designsystem.ds_radio_button;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class RadioButtonComposablesKt$RadioButtonAnimatedCheckmark$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f32562g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f32563h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RadioButtonComposablesKt$RadioButtonAnimatedCheckmark$1(boolean z11, int i11) {
        super(2);
        this.f32562g = z11;
        this.f32563h = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        RadioButtonComposablesKt.RadioButtonAnimatedCheckmark(this.f32562g, composer, this.f32563h | 1);
    }
}
