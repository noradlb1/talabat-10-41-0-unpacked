package dj;

import androidx.lifecycle.Observer;
import com.talabat.darkstores.feature.home.HomeFragment;

public final /* synthetic */ class s implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HomeFragment f56755a;

    public /* synthetic */ s(HomeFragment homeFragment) {
        this.f56755a = homeFragment;
    }

    public final void onChanged(Object obj) {
        HomeFragment.m9955setupTalabatAiButton$lambda3(this.f56755a, (Boolean) obj);
    }
}
