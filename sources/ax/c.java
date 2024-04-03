package ax;

import androidx.lifecycle.Observer;
import com.talabat.userandlocation.choosecountry.presentation.displaymodel.ClearCartConfirmationDialogDisplayModel;
import com.talabat.userandlocation.choosecountry.ui.fragment.ChooseCountryFragment;

public final /* synthetic */ class c implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ChooseCountryFragment f11662a;

    public /* synthetic */ c(ChooseCountryFragment chooseCountryFragment) {
        this.f11662a = chooseCountryFragment;
    }

    public final void onChanged(Object obj) {
        ChooseCountryFragment.m5887observeViewModel$lambda3(this.f11662a, (ClearCartConfirmationDialogDisplayModel) obj);
    }
}
