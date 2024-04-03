package hj;

import androidx.lifecycle.Observer;
import com.talabat.darkstores.feature.main.DarkstoresMainActivity;

public final /* synthetic */ class k implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DarkstoresMainActivity f56885a;

    public /* synthetic */ k(DarkstoresMainActivity darkstoresMainActivity) {
        this.f56885a = darkstoresMainActivity;
    }

    public final void onChanged(Object obj) {
        DarkstoresMainActivity.m9985observeCartSyncWarning$lambda25(this.f56885a, (Boolean) obj);
    }
}
