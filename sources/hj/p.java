package hj;

import androidx.lifecycle.Observer;
import com.talabat.darkstores.feature.main.DarkstoresMainActivity;
import com.talabat.wrapper.EventWrapper;

public final /* synthetic */ class p implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DarkstoresMainActivity f56890a;

    public /* synthetic */ p(DarkstoresMainActivity darkstoresMainActivity) {
        this.f56890a = darkstoresMainActivity;
    }

    public final void onChanged(Object obj) {
        DarkstoresMainActivity.m9984observeCartListToastMessage$lambda34(this.f56890a, (EventWrapper) obj);
    }
}
