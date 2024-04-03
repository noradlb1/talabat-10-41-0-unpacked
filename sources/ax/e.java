package ax;

import androidx.lifecycle.Observer;
import com.talabat.userandlocation.choosecountry.ui.fragment.ChooseCountryFragment;

public final /* synthetic */ class e implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ChooseCountryFragment f11664a;

    public /* synthetic */ e(ChooseCountryFragment chooseCountryFragment) {
        this.f11664a = chooseCountryFragment;
    }

    public final void onChanged(Object obj) {
        ChooseCountryFragment.m5889observeViewModel$lambda5(this.f11664a, (String) obj);
    }
}
