package com.designsystem.ds_checkbox_v2;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.state.ToggleableState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class CheckboxComposablesKt$Checkbox$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ToggleableState f30878g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f30879h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Modifier f30880i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f30881j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CheckboxComposablesKt$Checkbox$2(ToggleableState toggleableState, boolean z11, Modifier modifier, int i11) {
        super(2);
        this.f30878g = toggleableState;
        this.f30879h = z11;
        this.f30880i = modifier;
        this.f30881j = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        CheckboxComposablesKt.Checkbox(this.f30878g, this.f30879h, this.f30880i, composer, this.f30881j | 1);
    }
}
