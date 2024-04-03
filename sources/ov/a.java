package ov;

import android.view.View;
import com.talabat.talabatcommon.feature.promotionWidget.model.response.WidgetInfo;
import com.talabat.talabatcommon.views.promotionWidget.PromotionsWidgetView;
import com.talabat.talabatcommon.views.promotionWidget.model.PromotionsWidgetDisplayModel;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PromotionsWidgetView f24025b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ WidgetInfo f24026c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ PromotionsWidgetDisplayModel f24027d;

    public /* synthetic */ a(PromotionsWidgetView promotionsWidgetView, WidgetInfo widgetInfo, PromotionsWidgetDisplayModel promotionsWidgetDisplayModel) {
        this.f24025b = promotionsWidgetView;
        this.f24026c = widgetInfo;
        this.f24027d = promotionsWidgetDisplayModel;
    }

    public final void onClick(View view) {
        PromotionsWidgetView.m5769populateViews$lambda5$lambda3(this.f24025b, this.f24026c, this.f24027d, view);
    }
}
