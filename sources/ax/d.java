package ax;

import androidx.lifecycle.Observer;
import com.talabat.userandlocation.choosecountry.ui.fragment.ChooseCountryFragment;

public final /* synthetic */ class d implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ChooseCountryFragment f11663a;

    public /* synthetic */ d(ChooseCountryFragment chooseCountryFragment) {
        this.f11663a = chooseCountryFragment;
    }

    public final void onChanged(Object obj) {
        ChooseCountryFragment.m5888observeViewModel$lambda4(this.f11663a, (Boolean) obj);
    }
}
