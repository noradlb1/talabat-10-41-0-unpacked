package hj;

import androidx.lifecycle.Observer;
import com.talabat.darkstores.common.Result;
import com.talabat.darkstores.feature.main.DarkstoresMainActivity;

public final /* synthetic */ class e implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DarkstoresMainActivity f56878a;

    public /* synthetic */ e(DarkstoresMainActivity darkstoresMainActivity) {
        this.f56878a = darkstoresMainActivity;
    }

    public final void onChanged(Object obj) {
        DarkstoresMainActivity.m9997setupBottomCartView$lambda28(this.f56878a, (Result) obj);
    }
}
