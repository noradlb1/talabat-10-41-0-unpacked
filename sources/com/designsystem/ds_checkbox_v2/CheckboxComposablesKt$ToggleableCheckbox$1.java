package com.designsystem.ds_checkbox_v2;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.state.ToggleableState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class CheckboxComposablesKt$ToggleableCheckbox$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ToggleableState f30884g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f30885h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f30886i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Modifier f30887j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f30888k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f30889l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CheckboxComposablesKt$ToggleableCheckbox$1(ToggleableState toggleableState, boolean z11, Function0<Unit> function0, Modifier modifier, int i11, int i12) {
        super(2);
        this.f30884g = toggleableState;
        this.f30885h = z11;
        this.f30886i = function0;
        this.f30887j = modifier;
        this.f30888k = i11;
        this.f30889l = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        CheckboxComposablesKt.ToggleableCheckbox(this.f30884g, this.f30885h, this.f30886i, this.f30887j, composer, this.f30888k | 1, this.f30889l);
    }
}
