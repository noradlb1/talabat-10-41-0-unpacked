package lw;

import android.view.View;
import com.talabat.talabatlife.ui.vendorList.VendorsListFragment;

public final /* synthetic */ class i implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VendorsListFragment f23932b;

    public /* synthetic */ i(VendorsListFragment vendorsListFragment) {
        this.f23932b = vendorsListFragment;
    }

    public final void onClick(View view) {
        VendorsListFragment.m5845addCancelButtonListener$lambda23(this.f23932b, view);
    }
}
