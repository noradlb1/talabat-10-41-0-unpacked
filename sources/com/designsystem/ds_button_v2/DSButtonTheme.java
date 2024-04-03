package com.designsystem.ds_button_v2;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import com.designsystem.ds_spinner.DSSpinnerColor;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J.\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H'ø\u0001\u0000¢\u0006\u0002\u0010\tJ\u001d\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u00032\u0006\u0010\u0005\u001a\u00020\u0006H'¢\u0006\u0002\u0010\fJ\r\u0010\r\u001a\u00020\u000eH'¢\u0006\u0002\u0010\u000fJ\r\u0010\u0010\u001a\u00020\u0011H'¢\u0006\u0002\u0010\u0012J\u001e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H'ø\u0001\u0000¢\u0006\u0002\u0010\f\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"Lcom/designsystem/ds_button_v2/DSButtonTheme;", "", "backgroundColor", "Landroidx/compose/runtime/State;", "Landroidx/compose/ui/graphics/Color;", "isEnabled", "", "isLoading", "isPressed", "(ZZZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "borderStroke", "Landroidx/compose/foundation/BorderStroke;", "(ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "loadingAnimationColor", "Lcom/designsystem/ds_spinner/DSSpinnerColor;", "(Landroidx/compose/runtime/Composer;I)Lcom/designsystem/ds_spinner/DSSpinnerColor;", "shape", "Landroidx/compose/ui/graphics/Shape;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "textColor", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Stable
public interface DSButtonTheme {
    @NotNull
    @Composable
    State<Color> backgroundColor(boolean z11, boolean z12, boolean z13, @Nullable Composer composer, int i11);

    @NotNull
    @Composable
    State<BorderStroke> borderStroke(boolean z11, @Nullable Composer composer, int i11);

    @NotNull
    @Composable
    DSSpinnerColor loadingAnimationColor(@Nullable Composer composer, int i11);

    @NotNull
    @Composable
    Shape shape(@Nullable Composer composer, int i11);

    @NotNull
    @Composable
    State<Color> textColor(boolean z11, @Nullable Composer composer, int i11);
}
