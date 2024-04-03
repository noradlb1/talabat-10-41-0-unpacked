package ov;

import androidx.lifecycle.Observer;
import com.talabat.talabatcommon.views.promotionWidget.PromotionsWidgetView;
import com.talabat.talabatcommon.views.promotionWidget.model.PromotionsWidgetDisplayModel;

public final /* synthetic */ class c implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PromotionsWidgetView f24030a;

    public /* synthetic */ c(PromotionsWidgetView promotionsWidgetView) {
        this.f24030a = promotionsWidgetView;
    }

    public final void onChanged(Object obj) {
        PromotionsWidgetView.m5768observatory$lambda2(this.f24030a, (PromotionsWidgetDisplayModel) obj);
    }
}
