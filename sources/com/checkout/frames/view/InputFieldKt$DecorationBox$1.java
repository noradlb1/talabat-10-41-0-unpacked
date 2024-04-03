package com.checkout.frames.view;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.material3.TextFieldColors;
import androidx.compose.material3.TextFieldDefaults;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import net.bytebuddy.jar.asm.Opcodes;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class InputFieldKt$DecorationBox$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ int $$dirty1;
    final /* synthetic */ Shape $borderShape;
    final /* synthetic */ TextFieldColors $colors;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ float $focusedBorderThickness;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ boolean $isError;
    final /* synthetic */ float $unfocusedBorderThickness;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InputFieldKt$DecorationBox$1(boolean z11, boolean z12, MutableInteractionSource mutableInteractionSource, TextFieldColors textFieldColors, Shape shape, float f11, float f12, int i11, int i12) {
        super(2);
        this.$enabled = z11;
        this.$isError = z12;
        this.$interactionSource = mutableInteractionSource;
        this.$colors = textFieldColors;
        this.$borderShape = shape;
        this.$focusedBorderThickness = f11;
        this.$unfocusedBorderThickness = f12;
        this.$$dirty = i11;
        this.$$dirty1 = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if ((i11 & 11) != 2 || !composer.getSkipping()) {
            TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
            boolean z11 = this.$enabled;
            boolean z12 = this.$isError;
            MutableInteractionSource mutableInteractionSource = this.$interactionSource;
            TextFieldColors textFieldColors = this.$colors;
            Shape shape = this.$borderShape;
            float f11 = this.$focusedBorderThickness;
            float f12 = this.$unfocusedBorderThickness;
            int i12 = this.$$dirty;
            int i13 = this.$$dirty1;
            textFieldDefaults.m1908OutlinedBorderContainerBoxnbWgWpA(z11, z12, mutableInteractionSource, textFieldColors, shape, f11, f12, composer, ((i12 >> 21) & 896) | ((i12 >> 21) & 14) | 12582912 | ((i12 >> 21) & 112) | ((i13 << 9) & 7168) | ((i13 << 9) & 57344) | ((i13 << 9) & Opcodes.ASM7) | ((i13 << 9) & 3670016), 0);
            return;
        }
        composer.skipToGroupEnd();
    }
}
