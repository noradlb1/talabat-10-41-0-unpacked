package dm;

import android.view.View;
import com.talabat.feature.darkstorescarrierbag.presentation.DarkstoresCarrierBagFragment;
import com.talabat.feature.darkstorescarrierbag.presentation.model.CarrierBagOption;

public final /* synthetic */ class c implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DarkstoresCarrierBagFragment f61937b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CarrierBagOption f61938c;

    public /* synthetic */ c(DarkstoresCarrierBagFragment darkstoresCarrierBagFragment, CarrierBagOption carrierBagOption) {
        this.f61937b = darkstoresCarrierBagFragment;
        this.f61938c = carrierBagOption;
    }

    public final void onClick(View view) {
        DarkstoresCarrierBagFragment.m10159onViewCreated$lambda1$lambda0(this.f61937b, this.f61938c, view);
    }
}
