package ov;

import android.view.View;
import com.talabat.talabatcommon.views.promotionWidget.PromotionsWidgetView;
import com.talabat.talabatcommon.views.promotionWidget.model.PromotionsWidgetDisplayModel;

public final /* synthetic */ class b implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PromotionsWidgetView f24028b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ PromotionsWidgetDisplayModel f24029c;

    public /* synthetic */ b(PromotionsWidgetView promotionsWidgetView, PromotionsWidgetDisplayModel promotionsWidgetDisplayModel) {
        this.f24028b = promotionsWidgetView;
        this.f24029c = promotionsWidgetDisplayModel;
    }

    public final void onClick(View view) {
        PromotionsWidgetView.m5770populateViews$lambda5$lambda4(this.f24028b, this.f24029c, view);
    }
}
