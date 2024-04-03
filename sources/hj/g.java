package hj;

import androidx.lifecycle.Observer;
import com.talabat.darkstores.feature.main.DarkstoresMainActivity;
import com.talabat.wrapper.EventWrapper;

public final /* synthetic */ class g implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DarkstoresMainActivity f56880a;

    public /* synthetic */ g(DarkstoresMainActivity darkstoresMainActivity) {
        this.f56880a = darkstoresMainActivity;
    }

    public final void onChanged(Object obj) {
        DarkstoresMainActivity.m9999setupBottomCartView$lambda31(this.f56880a, (EventWrapper) obj);
    }
}
