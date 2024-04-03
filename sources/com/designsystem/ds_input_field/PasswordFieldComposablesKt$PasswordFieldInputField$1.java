package com.designsystem.ds_input_field;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class PasswordFieldComposablesKt$PasswordFieldInputField$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f31768g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ MutableState<Boolean> f31769h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PasswordFieldComposablesKt$PasswordFieldInputField$1(int i11, MutableState<Boolean> mutableState) {
        super(2);
        this.f31768g = i11;
        this.f31769h = mutableState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if (((i11 & 11) ^ 2) != 0 || !composer.getSkipping()) {
            int i12 = this.f31768g;
            MutableState<Boolean> mutableState = this.f31769h;
            composer.startReplaceableGroup(-3686930);
            boolean changed = composer.changed((Object) mutableState);
            Object rememberedValue = composer.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new PasswordFieldComposablesKt$PasswordFieldInputField$1$1$1(mutableState);
                composer.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceableGroup();
            PasswordFieldComposablesKt.PasswordFieldTrailingIconContainer(i12, (Function0) rememberedValue, composer, 0, 0);
            return;
        }
        composer.skipToGroupEnd();
    }
}
