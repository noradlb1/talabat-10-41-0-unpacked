package hj;

import androidx.lifecycle.Observer;
import com.talabat.darkstores.feature.main.DarkstoresMainActivity;
import com.talabat.wrapper.EventWrapper;

public final /* synthetic */ class m implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DarkstoresMainActivity f56887a;

    public /* synthetic */ m(DarkstoresMainActivity darkstoresMainActivity) {
        this.f56887a = darkstoresMainActivity;
    }

    public final void onChanged(Object obj) {
        DarkstoresMainActivity.m9993observeNavigationReady$lambda12(this.f56887a, (EventWrapper) obj);
    }
}
