package hj;

import androidx.lifecycle.Observer;
import com.talabat.darkstores.feature.main.DarkstoresMainActivity;
import com.talabat.wrapper.EventWrapper;

public final /* synthetic */ class n implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DarkstoresMainActivity f56888a;

    public /* synthetic */ n(DarkstoresMainActivity darkstoresMainActivity) {
        this.f56888a = darkstoresMainActivity;
    }

    public final void onChanged(Object obj) {
        DarkstoresMainActivity.m9995observeVoucherGenerationLiveData$lambda4(this.f56888a, (EventWrapper) obj);
    }
}
