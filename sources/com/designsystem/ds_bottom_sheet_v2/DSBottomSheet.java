package com.designsystem.ds_bottom_sheet_v2;

import android.os.Bundle;
import androidx.compose.runtime.internal.StabilityInferred;
import com.designsystem.marshmallow.R;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R*\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00068\u0006@FX\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u000e\u001a\u00020\u00068\u0014@\u0014X\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\"\u0010\u0012\u001a\u00020\u00118\u0014@\u0014X\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/designsystem/ds_bottom_sheet_v2/DSBottomSheet;", "Lcom/designsystem/ds_bottom_sheet_v2/BottomSheet;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "", "value", "maxHeightRation", "D", "getMaxHeightRation", "()D", "setMaxHeightRation", "(D)V", "maxBottomSheetHeightRatio", "i0", "k0", "", "isFullScreen", "Z", "j0", "()Z", "setFullScreen", "(Z)V", "<init>", "()V", "marshmallow_release"}, k = 1, mv = {1, 5, 1})
public final class DSBottomSheet extends BottomSheet {
    public static final int $stable = 8;
    private boolean isFullScreen;
    private double maxBottomSheetHeightRatio = 1.0d;
    private double maxHeightRation = 1.0d;

    public void _$_clearFindViewByIdCache() {
    }

    public final double getMaxHeightRation() {
        return this.maxHeightRation;
    }

    public double i0() {
        return this.maxBottomSheetHeightRatio;
    }

    public boolean j0() {
        return this.isFullScreen;
    }

    public void k0(double d11) {
        this.maxBottomSheetHeightRatio = d11;
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.DynamicBottomSheetDialogTheme);
    }

    public final void setMaxHeightRation(double d11) {
        if (d11 > 0.0d) {
            int i11 = (d11 > 1.0d ? 1 : (d11 == 1.0d ? 0 : -1));
        }
        this.maxHeightRation = d11;
        k0(d11);
    }
}
