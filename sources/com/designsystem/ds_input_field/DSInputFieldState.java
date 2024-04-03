package com.designsystem.ds_input_field;

import androidx.annotation.ColorRes;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.res.ColorResources_androidKt;
import com.designsystem.marshmallow.R;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B%\b\u0002\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0007J\u0018\u0010\u000e\u001a\u00020\u000fH\u0017ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0012\u001a\u00020\u000fH\u0017ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0013\u0010\u0011J\u000f\u0010\u0014\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0002\u0010\u000bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\tj\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u0018"}, d2 = {"Lcom/designsystem/ds_input_field/DSInputFieldState;", "", "Lcom/designsystem/ds_input_field/OuterState;", "color", "", "iconColor", "icon", "(Ljava/lang/String;IIILjava/lang/Integer;)V", "getColor", "()I", "getIcon", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getIconColor", "getIconStateColor", "Landroidx/compose/ui/graphics/Color;", "getIconStateColor-WaAFU9c", "(Landroidx/compose/runtime/Composer;I)J", "getStateColor", "getStateColor-WaAFU9c", "getStateIcon", "Normal", "Error", "Success", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public enum DSInputFieldState implements OuterState {
    Normal(R.color.ds_neutral_35, R.color.ds_neutral_70, (int) null),
    Error(r11, r11, Integer.valueOf(R.drawable.ds_error_filled)),
    Success(r5, r5, Integer.valueOf(R.drawable.ds_check_circle_filled));
    
    private final int color;
    @Nullable
    private final Integer icon;
    private final int iconColor;

    private DSInputFieldState(@ColorRes int i11, @ColorRes int i12, Integer num) {
        this.color = i11;
        this.iconColor = i12;
        this.icon = num;
    }

    public final int getColor() {
        return this.color;
    }

    @Nullable
    public final Integer getIcon() {
        return this.icon;
    }

    public final int getIconColor() {
        return this.iconColor;
    }

    @Composable
    /* renamed from: getIconStateColor-WaAFU9c  reason: not valid java name */
    public long m8372getIconStateColorWaAFU9c(@Nullable Composer composer, int i11) {
        composer.startReplaceableGroup(-1716484310);
        long colorResource = ColorResources_androidKt.colorResource(this.iconColor, composer, 0);
        composer.endReplaceableGroup();
        return colorResource;
    }

    @Composable
    /* renamed from: getStateColor-WaAFU9c  reason: not valid java name */
    public long m8373getStateColorWaAFU9c(@Nullable Composer composer, int i11) {
        composer.startReplaceableGroup(-1529758064);
        long colorResource = ColorResources_androidKt.colorResource(this.color, composer, 0);
        composer.endReplaceableGroup();
        return colorResource;
    }

    @Nullable
    public Integer getStateIcon() {
        return this.icon;
    }
}
