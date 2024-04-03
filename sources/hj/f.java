package hj;

import androidx.lifecycle.Observer;
import com.talabat.darkstores.feature.campaigns.CampaignProgressVisualisation;
import com.talabat.darkstores.feature.main.DarkstoresMainActivity;

public final /* synthetic */ class f implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DarkstoresMainActivity f56879a;

    public /* synthetic */ f(DarkstoresMainActivity darkstoresMainActivity) {
        this.f56879a = darkstoresMainActivity;
    }

    public final void onChanged(Object obj) {
        DarkstoresMainActivity.m9998setupBottomCartView$lambda29(this.f56879a, (CampaignProgressVisualisation) obj);
    }
}
