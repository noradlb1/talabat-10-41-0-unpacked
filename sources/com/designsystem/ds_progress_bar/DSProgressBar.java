package com.designsystem.ds_progress_bar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.res.ColorResources_androidKt;
import com.designsystem.ds_button_v2.DSBaseButton;
import com.designsystem.extensions.TypedArrayExtensionsKt;
import com.designsystem.marshmallow.R;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\r\u0010\u0019\u001a\u00020\u001aH\u0017¢\u0006\u0002\u0010\u001bR9\u0010\u000b\u001a\t\u0018\u00010\u0007¢\u0006\u0002\b\n2\r\u0010\t\u001a\t\u0018\u00010\u0007¢\u0006\u0002\b\n8F@FX\u0002¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR+\u0010\u0013\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\u00128F@FX\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u0011\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001c"}, d2 = {"Lcom/designsystem/ds_progress_bar/DSProgressBar;", "Lcom/designsystem/ds_button_v2/DSBaseButton;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "<set-?>", "Landroidx/annotation/ColorRes;", "color", "getColor", "()Ljava/lang/Integer;", "setColor", "(Ljava/lang/Integer;)V", "color$delegate", "Landroidx/compose/runtime/MutableState;", "", "progress", "getProgress", "()F", "setProgress", "(F)V", "progress$delegate", "Content", "", "(Landroidx/compose/runtime/Composer;I)V", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DSProgressBar extends DSBaseButton {
    public static final int $stable = 0;
    @NotNull
    private final MutableState color$delegate;
    @NotNull
    private final MutableState progress$delegate;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSProgressBar(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSProgressBar(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DSProgressBar(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    @Composable
    public void Content(@Nullable Composer composer, int i11) {
        int i12;
        Color color;
        int i13;
        Composer startRestartGroup = composer.startRestartGroup(-1460295750);
        if ((i11 & 14) == 0) {
            if (startRestartGroup.changed((Object) this)) {
                i13 = 4;
            } else {
                i13 = 2;
            }
            i12 = i13 | i11;
        } else {
            i12 = i11;
        }
        if (((i12 & 11) ^ 2) != 0 || !startRestartGroup.getSkipping()) {
            float progress = getProgress();
            Integer color2 = getColor();
            if (color2 == null) {
                startRestartGroup.startReplaceableGroup(1975475076);
                startRestartGroup.endReplaceableGroup();
                color = null;
            } else {
                startRestartGroup.startReplaceableGroup(-1460295651);
                long colorResource = ColorResources_androidKt.colorResource(color2.intValue(), startRestartGroup, 0);
                startRestartGroup.endReplaceableGroup();
                color = Color.m2909boximpl(colorResource);
            }
            DSProgressBarKt.m8514DSProgressBargKt5lHk((Modifier) null, progress, color, startRestartGroup, 0, 1);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new DSProgressBar$Content$2(this, i11));
        }
    }

    public void _$_clearFindViewByIdCache() {
    }

    @Nullable
    public final Integer getColor() {
        return (Integer) this.color$delegate.getValue();
    }

    public final float getProgress() {
        return ((Number) this.progress$delegate.getValue()).floatValue();
    }

    public final void setColor(@Nullable Integer num) {
        this.color$delegate.setValue(num);
    }

    public final void setProgress(float f11) {
        this.progress$delegate.setValue(Float.valueOf(f11));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSProgressBar(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        this.progress$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(0.0f), (SnapshotMutationPolicy) null, 2, (Object) null);
        this.color$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DSProgressBar, 0, 0);
            Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr…able.DSProgressBar, 0, 0)");
            setProgress(obtainStyledAttributes.getFloat(R.styleable.DSProgressBar_pb_progress, 0.0f));
            setColor(TypedArrayExtensionsKt.getResourceIdOrNull(obtainStyledAttributes, R.styleable.DSProgressBar_pb_color));
            obtainStyledAttributes.recycle();
        }
    }
}
