package hj;

import android.content.DialogInterface;
import com.talabat.darkstores.feature.cart.CartFragmentViewModel;
import com.talabat.darkstores.feature.main.DarkstoresMainActivity;

public final /* synthetic */ class b implements DialogInterface.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DarkstoresMainActivity f56873b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CartFragmentViewModel.ClearCartPermissionData f56874c;

    public /* synthetic */ b(DarkstoresMainActivity darkstoresMainActivity, CartFragmentViewModel.ClearCartPermissionData clearCartPermissionData) {
        this.f56873b = darkstoresMainActivity;
        this.f56874c = clearCartPermissionData;
    }

    public final void onClick(DialogInterface dialogInterface, int i11) {
        DarkstoresMainActivity.m9988observeClearCartPermission$lambda16$lambda14(this.f56873b, this.f56874c, dialogInterface, i11);
    }
}
