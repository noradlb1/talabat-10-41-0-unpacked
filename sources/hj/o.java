package hj;

import androidx.lifecycle.Observer;
import com.talabat.darkstores.feature.main.DarkstoresMainActivity;
import com.talabat.wrapper.EventWrapper;

public final /* synthetic */ class o implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DarkstoresMainActivity f56889a;

    public /* synthetic */ o(DarkstoresMainActivity darkstoresMainActivity) {
        this.f56889a = darkstoresMainActivity;
    }

    public final void onChanged(Object obj) {
        DarkstoresMainActivity.m9992observeNavigationActions$lambda9(this.f56889a, (EventWrapper) obj);
    }
}
