package ri;

import com.talabat.darkstores.feature.cart.CartFragmentViewModel;
import io.reactivex.functions.Action;

public final /* synthetic */ class t0 implements Action {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CartFragmentViewModel f57355b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CartFragmentViewModel.ClearCartPermissionData f57356c;

    public /* synthetic */ t0(CartFragmentViewModel cartFragmentViewModel, CartFragmentViewModel.ClearCartPermissionData clearCartPermissionData) {
        this.f57355b = cartFragmentViewModel;
        this.f57356c = clearCartPermissionData;
    }

    public final void run() {
        CartFragmentViewModel.m9824onClearCartPermissionGranted$lambda49(this.f57355b, this.f57356c);
    }
}
