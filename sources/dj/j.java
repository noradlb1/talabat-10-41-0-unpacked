package dj;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import com.talabat.darkstores.feature.home.HomeFragment;

public final /* synthetic */ class j implements ActivityResultCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HomeFragment f56744a;

    public /* synthetic */ j(HomeFragment homeFragment) {
        this.f56744a = homeFragment;
    }

    public final void onActivityResult(Object obj) {
        HomeFragment.m9951qCommerceVoucherBottomSheetWithPDPLauncher$lambda51(this.f56744a, (ActivityResult) obj);
    }
}
