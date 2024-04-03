package dm;

import android.view.View;
import com.talabat.feature.darkstorescarrierbag.presentation.DarkstoresCarrierBagFragment;
import com.talabat.feature.darkstorescarrierbag.presentation.model.CarrierBagOption;

public final /* synthetic */ class b implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DarkstoresCarrierBagFragment f61935b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CarrierBagOption f61936c;

    public /* synthetic */ b(DarkstoresCarrierBagFragment darkstoresCarrierBagFragment, CarrierBagOption carrierBagOption) {
        this.f61935b = darkstoresCarrierBagFragment;
        this.f61936c = carrierBagOption;
    }

    public final void onClick(View view) {
        DarkstoresCarrierBagFragment.m10163updateOptionSelected$lambda5(this.f61935b, this.f61936c, view);
    }
}
