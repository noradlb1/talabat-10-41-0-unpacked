package hj;

import android.content.DialogInterface;
import com.talabat.darkstores.feature.cart.CartFragmentViewModel;
import com.talabat.darkstores.feature.main.DarkstoresMainActivity;

public final /* synthetic */ class c implements DialogInterface.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DarkstoresMainActivity f56875b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CartFragmentViewModel.ClearCartPermissionData f56876c;

    public /* synthetic */ c(DarkstoresMainActivity darkstoresMainActivity, CartFragmentViewModel.ClearCartPermissionData clearCartPermissionData) {
        this.f56875b = darkstoresMainActivity;
        this.f56876c = clearCartPermissionData;
    }

    public final void onClick(DialogInterface dialogInterface, int i11) {
        DarkstoresMainActivity.m9989observeClearCartPermission$lambda16$lambda15(this.f56875b, this.f56876c, dialogInterface, i11);
    }
}
