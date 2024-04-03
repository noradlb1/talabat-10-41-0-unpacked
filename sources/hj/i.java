package hj;

import androidx.lifecycle.Observer;
import com.talabat.darkstores.feature.main.DarkstoresMainActivity;
import com.talabat.wrapper.EventWrapper;

public final /* synthetic */ class i implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DarkstoresMainActivity f56883a;

    public /* synthetic */ i(DarkstoresMainActivity darkstoresMainActivity) {
        this.f56883a = darkstoresMainActivity;
    }

    public final void onChanged(Object obj) {
        DarkstoresMainActivity.m9983observeCartInitErrorLiveData$lambda36(this.f56883a, (EventWrapper) obj);
    }
}
