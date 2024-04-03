package com.talabat.feature.bnpldashboard.presentation;

import androidx.activity.OnBackPressedCallback;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/talabat/feature/bnpldashboard/presentation/BNPLDashboardFlutterActivity$addBackPressCallback$1", "Landroidx/activity/OnBackPressedCallback;", "handleOnBackPressed", "", "com_talabat_feature_bnpl-dashboard_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BNPLDashboardFlutterActivity$addBackPressCallback$1 extends OnBackPressedCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BNPLDashboardFlutterActivity f58379a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BNPLDashboardFlutterActivity$addBackPressCallback$1(BNPLDashboardFlutterActivity bNPLDashboardFlutterActivity) {
        super(true);
        this.f58379a = bNPLDashboardFlutterActivity;
    }

    public void handleOnBackPressed() {
        this.f58379a.setResult(-1);
        this.f58379a.finish();
    }
}
