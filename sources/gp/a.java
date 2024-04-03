package gp;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import com.talabat.feature.tpro.presentation.management.details.upgrade.details.TproUpgradeDetailsBottomSheetFragment;

public final /* synthetic */ class a implements ActivityResultCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TproUpgradeDetailsBottomSheetFragment f62113a;

    public /* synthetic */ a(TproUpgradeDetailsBottomSheetFragment tproUpgradeDetailsBottomSheetFragment) {
        this.f62113a = tproUpgradeDetailsBottomSheetFragment;
    }

    public final void onActivityResult(Object obj) {
        TproUpgradeDetailsBottomSheetFragment.m10409launcher$lambda4(this.f62113a, (ActivityResult) obj);
    }
}
