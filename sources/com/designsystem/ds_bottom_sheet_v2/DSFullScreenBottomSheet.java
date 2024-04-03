package com.designsystem.ds_bottom_sheet_v2;

import android.os.Bundle;
import androidx.compose.runtime.internal.StabilityInferred;
import com.designsystem.marshmallow.R;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\"\u0010\u0007\u001a\u00020\u00068\u0014@\u0014X\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u000e\u001a\u00020\r8\u0014@\u0014X\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/designsystem/ds_bottom_sheet_v2/DSFullScreenBottomSheet;", "Lcom/designsystem/ds_bottom_sheet_v2/BottomSheet;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "", "maxBottomSheetHeightRatio", "D", "i0", "()D", "setMaxBottomSheetHeightRatio", "(D)V", "", "isFullScreen", "Z", "j0", "()Z", "setFullScreen", "(Z)V", "<init>", "()V", "marshmallow_release"}, k = 1, mv = {1, 5, 1})
public final class DSFullScreenBottomSheet extends BottomSheet {
    public static final int $stable = 8;
    private boolean isFullScreen = true;
    private double maxBottomSheetHeightRatio = 1.0d;

    public void _$_clearFindViewByIdCache() {
    }

    public double i0() {
        return this.maxBottomSheetHeightRatio;
    }

    public boolean j0() {
        return this.isFullScreen;
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.BaseBottomSheetDialogTheme);
    }
}
