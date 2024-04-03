package com.designsystem.ds_selection_indicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.compose.runtime.internal.StabilityInferred;
import com.designsystem.marshmallow.R;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0016B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002R$\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0017"}, d2 = {"Lcom/designsystem/ds_selection_indicator/DSSelectionIndicator;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "Lcom/designsystem/ds_selection_indicator/DSSelectionIndicator$DSSelectionIndicatorAxisType;", "axisType", "getAxisType", "()Lcom/designsystem/ds_selection_indicator/DSSelectionIndicator$DSSelectionIndicatorAxisType;", "setAxisType", "(Lcom/designsystem/ds_selection_indicator/DSSelectionIndicator$DSSelectionIndicatorAxisType;)V", "setEnabled", "", "enabled", "", "setIndicatorAxis", "setIndicatorEnabledState", "DSSelectionIndicatorAxisType", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DSSelectionIndicator extends FrameLayout {
    public static final int $stable = 8;
    @NotNull
    private DSSelectionIndicatorAxisType axisType;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/designsystem/ds_selection_indicator/DSSelectionIndicator$DSSelectionIndicatorAxisType;", "", "(Ljava/lang/String;I)V", "HORIZONTAL", "VERTICAL", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public enum DSSelectionIndicatorAxisType {
        HORIZONTAL,
        VERTICAL
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSSelectionIndicator(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSSelectionIndicator(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DSSelectionIndicator(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    private final void setIndicatorAxis(DSSelectionIndicatorAxisType dSSelectionIndicatorAxisType) {
        boolean z11;
        int i11;
        View findViewById = findViewById(R.id.viewHorizontal);
        Intrinsics.checkNotNullExpressionValue(findViewById, "viewHorizontal");
        boolean z12 = true;
        int i12 = 0;
        if (dSSelectionIndicatorAxisType == DSSelectionIndicatorAxisType.HORIZONTAL) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            i11 = 0;
        } else {
            i11 = 8;
        }
        findViewById.setVisibility(i11);
        View findViewById2 = findViewById(R.id.viewVertical);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "viewVertical");
        if (dSSelectionIndicatorAxisType != DSSelectionIndicatorAxisType.VERTICAL) {
            z12 = false;
        }
        if (!z12) {
            i12 = 8;
        }
        findViewById2.setVisibility(i12);
    }

    private final void setIndicatorEnabledState(boolean z11) {
        boolean z12;
        View findViewById = findViewById(R.id.viewHorizontal);
        boolean z13 = true;
        if (this.axisType != DSSelectionIndicatorAxisType.HORIZONTAL || !z11) {
            z12 = false;
        } else {
            z12 = true;
        }
        findViewById.setEnabled(z12);
        View findViewById2 = findViewById(R.id.viewVertical);
        if (this.axisType != DSSelectionIndicatorAxisType.VERTICAL || !z11) {
            z13 = false;
        }
        findViewById2.setEnabled(z13);
    }

    public void _$_clearFindViewByIdCache() {
    }

    @NotNull
    public final DSSelectionIndicatorAxisType getAxisType() {
        return this.axisType;
    }

    public final void setAxisType(@NotNull DSSelectionIndicatorAxisType dSSelectionIndicatorAxisType) {
        Intrinsics.checkNotNullParameter(dSSelectionIndicatorAxisType, "value");
        setIndicatorAxis(dSSelectionIndicatorAxisType);
        this.axisType = dSSelectionIndicatorAxisType;
    }

    public void setEnabled(boolean z11) {
        setIndicatorEnabledState(z11);
        super.setEnabled(z11);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSSelectionIndicator(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        DSSelectionIndicatorAxisType dSSelectionIndicatorAxisType = DSSelectionIndicatorAxisType.HORIZONTAL;
        this.axisType = dSSelectionIndicatorAxisType;
        LayoutInflater.from(context).inflate(R.layout.ds_selection_indicator, this, true);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DSSelectionIndicator, 0, 0);
            Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr…SelectionIndicator, 0, 0)");
            int i12 = obtainStyledAttributes.getInt(R.styleable.DSSelectionIndicator_si_axis, -1);
            setAxisType(i12 >= 0 ? DSSelectionIndicatorAxisType.values()[i12] : dSSelectionIndicatorAxisType);
            obtainStyledAttributes.recycle();
        }
    }
}
