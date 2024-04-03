package ax;

import androidx.lifecycle.Observer;
import com.talabat.userandlocation.choosecountry.ui.fragment.ChooseCountryFragment;

public final /* synthetic */ class a implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ChooseCountryFragment f11660a;

    public /* synthetic */ a(ChooseCountryFragment chooseCountryFragment) {
        this.f11660a = chooseCountryFragment;
    }

    public final void onChanged(Object obj) {
        ChooseCountryFragment.m5885observeViewModel$lambda1(this.f11660a, (String) obj);
    }
}
