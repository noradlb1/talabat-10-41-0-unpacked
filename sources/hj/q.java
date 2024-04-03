package hj;

import androidx.lifecycle.Observer;
import com.talabat.darkstores.feature.main.DarkstoresMainActivity;
import com.talabat.wrapper.EventWrapper;

public final /* synthetic */ class q implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DarkstoresMainActivity f56891a;

    public /* synthetic */ q(DarkstoresMainActivity darkstoresMainActivity) {
        this.f56891a = darkstoresMainActivity;
    }

    public final void onChanged(Object obj) {
        DarkstoresMainActivity.m9986observeCheckoutActionLiveData$lambda20(this.f56891a, (EventWrapper) obj);
    }
}
