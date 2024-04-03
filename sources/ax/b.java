package ax;

import androidx.lifecycle.Observer;
import com.talabat.userandlocation.choosecountry.presentation.displaymodel.DismissScreenDisplayModel;
import com.talabat.userandlocation.choosecountry.ui.fragment.ChooseCountryFragment;

public final /* synthetic */ class b implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ChooseCountryFragment f11661a;

    public /* synthetic */ b(ChooseCountryFragment chooseCountryFragment) {
        this.f11661a = chooseCountryFragment;
    }

    public final void onChanged(Object obj) {
        ChooseCountryFragment.m5886observeViewModel$lambda2(this.f11661a, (DismissScreenDisplayModel) obj);
    }
}
