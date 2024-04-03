package ax;

import android.content.DialogInterface;
import com.talabat.userandlocation.choosecountry.presentation.displaymodel.ClearCartConfirmationDialogDisplayModel;
import com.talabat.userandlocation.choosecountry.ui.fragment.ChooseCountryFragment;

public final /* synthetic */ class g implements DialogInterface.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ClearCartConfirmationDialogDisplayModel f11666b;

    public /* synthetic */ g(ClearCartConfirmationDialogDisplayModel clearCartConfirmationDialogDisplayModel) {
        this.f11666b = clearCartConfirmationDialogDisplayModel;
    }

    public final void onClick(DialogInterface dialogInterface, int i11) {
        ChooseCountryFragment.m5884handleClearCart$lambda8(this.f11666b, dialogInterface, i11);
    }
}
