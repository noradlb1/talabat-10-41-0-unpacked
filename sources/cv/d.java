package cv;

import androidx.lifecycle.Observer;
import com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.presentation.displaymodel.OrderConfirmationRiderTipDisplayModel;
import com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.view.OrderConfirmationRiderTipView;

public final /* synthetic */ class d implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ OrderConfirmationRiderTipView f61825a;

    public /* synthetic */ d(OrderConfirmationRiderTipView orderConfirmationRiderTipView) {
        this.f61825a = orderConfirmationRiderTipView;
    }

    public final void onChanged(Object obj) {
        OrderConfirmationRiderTipView.m10929riderTipStatusDataObserver$lambda4(this.f61825a, (OrderConfirmationRiderTipDisplayModel) obj);
    }
}
