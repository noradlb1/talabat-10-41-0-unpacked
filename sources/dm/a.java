package dm;

import android.view.View;
import com.talabat.feature.darkstorescarrierbag.presentation.DarkstoresCarrierBagFragment;
import com.talabat.feature.darkstorescarrierbag.presentation.model.CarrierBagOption;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DarkstoresCarrierBagFragment f61933b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CarrierBagOption f61934c;

    public /* synthetic */ a(DarkstoresCarrierBagFragment darkstoresCarrierBagFragment, CarrierBagOption carrierBagOption) {
        this.f61933b = darkstoresCarrierBagFragment;
        this.f61934c = carrierBagOption;
    }

    public final void onClick(View view) {
        DarkstoresCarrierBagFragment.m10162updateOptionSelected$lambda4(this.f61933b, this.f61934c, view);
    }
}
