package androidx.compose.material;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@ExperimentalMaterialApi
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J.\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0017ø\u0001\u0000¢\u0006\u0002\u0010\nJ.\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0017ø\u0001\u0000¢\u0006\u0002\u0010\n\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Landroidx/compose/material/TextFieldColorsWithIcons;", "Landroidx/compose/material/TextFieldColors;", "leadingIconColor", "Landroidx/compose/runtime/State;", "Landroidx/compose/ui/graphics/Color;", "enabled", "", "isError", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "(ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "trailingIconColor", "material_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface TextFieldColorsWithIcons extends TextFieldColors {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        @NotNull
        @Composable
        public static State<Color> leadingIconColor(@NotNull TextFieldColorsWithIcons textFieldColorsWithIcons, boolean z11, boolean z12, @NotNull InteractionSource interactionSource, @Nullable Composer composer, int i11) {
            Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
            composer.startReplaceableGroup(1279189910);
            State<Color> leadingIconColor = textFieldColorsWithIcons.leadingIconColor(z11, z12, composer, (i11 & 14) | (i11 & 112) | ((i11 >> 3) & 896));
            composer.endReplaceableGroup();
            return leadingIconColor;
        }

        @NotNull
        @Composable
        public static State<Color> trailingIconColor(@NotNull TextFieldColorsWithIcons textFieldColorsWithIcons, boolean z11, boolean z12, @NotNull InteractionSource interactionSource, @Nullable Composer composer, int i11) {
            Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
            composer.startReplaceableGroup(-712140408);
            State<Color> trailingIconColor = textFieldColorsWithIcons.trailingIconColor(z11, z12, composer, (i11 & 14) | (i11 & 112) | ((i11 >> 3) & 896));
            composer.endReplaceableGroup();
            return trailingIconColor;
        }
    }

    @NotNull
    @Composable
    State<Color> leadingIconColor(boolean z11, boolean z12, @NotNull InteractionSource interactionSource, @Nullable Composer composer, int i11);

    @NotNull
    @Composable
    State<Color> trailingIconColor(boolean z11, boolean z12, @NotNull InteractionSource interactionSource, @Nullable Composer composer, int i11);
}
