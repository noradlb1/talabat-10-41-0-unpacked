package hj;

import androidx.lifecycle.Observer;
import com.talabat.darkstores.feature.cart.model.BottomCartViewState;
import com.talabat.darkstores.feature.main.DarkstoresMainActivity;

public final /* synthetic */ class s implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DarkstoresMainActivity f56893a;

    public /* synthetic */ s(DarkstoresMainActivity darkstoresMainActivity) {
        this.f56893a = darkstoresMainActivity;
    }

    public final void onChanged(Object obj) {
        DarkstoresMainActivity.m9982observeBottomCartViewState$lambda32(this.f56893a, (BottomCartViewState) obj);
    }
}
