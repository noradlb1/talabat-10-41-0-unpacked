package com.designsystem.ds_checkbox_v2;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.state.ToggleableState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class CheckboxComposablesKt$CheckboxAnimatedCheckmark$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ToggleableState f30882g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f30883h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CheckboxComposablesKt$CheckboxAnimatedCheckmark$1(ToggleableState toggleableState, int i11) {
        super(2);
        this.f30882g = toggleableState;
        this.f30883h = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        CheckboxComposablesKt.CheckboxAnimatedCheckmark(this.f30882g, composer, this.f30883h | 1);
    }
}
