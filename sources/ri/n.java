package ri;

import androidx.lifecycle.Observer;
import com.talabat.darkstores.feature.campaigns.CampaignProgressVisualisation;
import com.talabat.darkstores.feature.cart.views.CartProgressView;

public final /* synthetic */ class n implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CartProgressView f57327a;

    public /* synthetic */ n(CartProgressView cartProgressView) {
        this.f57327a = cartProgressView;
    }

    public final void onChanged(Object obj) {
        this.f57327a.visualise((CampaignProgressVisualisation) obj);
    }
}
