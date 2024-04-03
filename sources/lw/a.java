package lw;

import android.view.View;
import com.talabat.talabatlife.ui.vendorList.VendorsListFragment;

public final /* synthetic */ class a implements View.OnFocusChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VendorsListFragment f23924b;

    public /* synthetic */ a(VendorsListFragment vendorsListFragment) {
        this.f23924b = vendorsListFragment;
    }

    public final void onFocusChange(View view, boolean z11) {
        VendorsListFragment.m5847addEditTextOnFocusListener$lambda24(this.f23924b, view, z11);
    }
}
