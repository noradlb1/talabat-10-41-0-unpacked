package hj;

import androidx.lifecycle.Observer;
import com.talabat.darkstores.feature.cart.CartFragmentViewModel;
import com.talabat.darkstores.feature.main.DarkstoresMainActivity;

public final /* synthetic */ class l implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DarkstoresMainActivity f56886a;

    public /* synthetic */ l(DarkstoresMainActivity darkstoresMainActivity) {
        this.f56886a = darkstoresMainActivity;
    }

    public final void onChanged(Object obj) {
        DarkstoresMainActivity.m9987observeClearCartPermission$lambda16(this.f56886a, (CartFragmentViewModel.ClearCartPermissionData) obj);
    }
}
