package hj;

import androidx.lifecycle.Observer;
import com.talabat.darkstores.common.Result;
import com.talabat.darkstores.feature.main.DarkstoresMainActivity;

public final /* synthetic */ class j implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DarkstoresMainActivity f56884a;

    public /* synthetic */ j(DarkstoresMainActivity darkstoresMainActivity) {
        this.f56884a = darkstoresMainActivity;
    }

    public final void onChanged(Object obj) {
        DarkstoresMainActivity.m9991observeDeliveryTierInfo$lambda8(this.f56884a, (Result) obj);
    }
}
