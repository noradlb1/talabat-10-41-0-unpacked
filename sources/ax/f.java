package ax;

import android.content.DialogInterface;
import com.talabat.userandlocation.choosecountry.presentation.displaymodel.ClearCartConfirmationDialogDisplayModel;
import com.talabat.userandlocation.choosecountry.ui.fragment.ChooseCountryFragment;

public final /* synthetic */ class f implements DialogInterface.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ClearCartConfirmationDialogDisplayModel f11665b;

    public /* synthetic */ f(ClearCartConfirmationDialogDisplayModel clearCartConfirmationDialogDisplayModel) {
        this.f11665b = clearCartConfirmationDialogDisplayModel;
    }

    public final void onClick(DialogInterface dialogInterface, int i11) {
        ChooseCountryFragment.m5883handleClearCart$lambda7(this.f11665b, dialogInterface, i11);
    }
}
