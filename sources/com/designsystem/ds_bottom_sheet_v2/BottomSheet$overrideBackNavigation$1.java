package com.designsystem.ds_bottom_sheet_v2;

import androidx.activity.OnBackPressedCallback;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/designsystem/ds_bottom_sheet_v2/BottomSheet$overrideBackNavigation$1", "Landroidx/activity/OnBackPressedCallback;", "handleOnBackPressed", "", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class BottomSheet$overrideBackNavigation$1 extends OnBackPressedCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BottomSheet f30596a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BottomSheet$overrideBackNavigation$1(BottomSheet bottomSheet) {
        super(true);
        this.f30596a = bottomSheet;
    }

    public void handleOnBackPressed() {
        boolean unused = this.f30596a.navigateBack();
    }
}
