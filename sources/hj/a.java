package hj;

import androidx.lifecycle.Observer;
import com.talabat.darkstores.feature.main.DarkstoresMainActivity;
import com.talabat.wrapper.EventWrapper;

public final /* synthetic */ class a implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DarkstoresMainActivity f56872a;

    public /* synthetic */ a(DarkstoresMainActivity darkstoresMainActivity) {
        this.f56872a = darkstoresMainActivity;
    }

    public final void onChanged(Object obj) {
        DarkstoresMainActivity.m9994observeProductErrors$lambda18(this.f56872a, (EventWrapper) obj);
    }
}
