package com.designsystem.ds_checkbox_v2;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.state.ToggleableState;
import androidx.compose.ui.state.ToggleableStateKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSCheckboxKt$DSCheckbox$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f30894g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f30895h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function1<Boolean, Unit> f30896i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f30897j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Modifier f30898k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSCheckboxKt$DSCheckbox$1(boolean z11, boolean z12, Function1<? super Boolean, Unit> function1, int i11, Modifier modifier) {
        super(2);
        this.f30894g = z11;
        this.f30895h = z12;
        this.f30896i = function1;
        this.f30897j = i11;
        this.f30898k = modifier;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        Function0 function0;
        if (((i11 & 11) ^ 2) != 0 || !composer.getSkipping()) {
            ToggleableState ToggleableState = ToggleableStateKt.ToggleableState(this.f30894g);
            boolean z11 = this.f30895h;
            if (this.f30896i != null) {
                composer.startReplaceableGroup(-420346431);
                Function1<Boolean, Unit> function1 = this.f30896i;
                Boolean valueOf = Boolean.valueOf(this.f30894g);
                Function1<Boolean, Unit> function12 = this.f30896i;
                boolean z12 = this.f30894g;
                composer.startReplaceableGroup(-3686552);
                boolean changed = composer.changed((Object) function1) | composer.changed((Object) valueOf);
                Object rememberedValue = composer.rememberedValue();
                if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new DSCheckboxKt$DSCheckbox$1$1$1(function12, z12);
                    composer.updateRememberedValue(rememberedValue);
                }
                composer.endReplaceableGroup();
                function0 = (Function0) rememberedValue;
                composer.endReplaceableGroup();
            } else {
                composer.startReplaceableGroup(-145836201);
                composer.endReplaceableGroup();
                function0 = null;
            }
            Modifier modifier = this.f30898k;
            int i12 = this.f30897j;
            CheckboxComposablesKt.ToggleableCheckbox(ToggleableState, z11, function0, modifier, composer, ((i12 >> 3) & 112) | ((i12 << 9) & 7168), 0);
            return;
        }
        composer.skipToGroupEnd();
    }
}
