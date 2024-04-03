package c5;

import com.deliveryhero.fluid.Host;
import com.deliveryhero.fluid.template.data.TemplateUiData;
import com.deliveryhero.fluid.template.data.TemplateUiDataHolder;
import com.deliveryhero.fluid.widgets.collections.pager.CarouselFactory;
import com.deliveryhero.fluid.widgets.collections.pager.CarouselModel;
import com.deliveryhero.fluid.widgets.collections.pager.CarouselWidget;

public final /* synthetic */ class a implements TemplateUiDataHolder.Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CarouselFactory f29349a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CarouselWidget f29350b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CarouselModel f29351c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Host f29352d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ CarouselModel f29353e;

    public /* synthetic */ a(CarouselFactory carouselFactory, CarouselWidget carouselWidget, CarouselModel carouselModel, Host host, CarouselModel carouselModel2) {
        this.f29349a = carouselFactory;
        this.f29350b = carouselWidget;
        this.f29351c = carouselModel;
        this.f29352d = host;
        this.f29353e = carouselModel2;
    }

    public final void onChanged(TemplateUiData templateUiData) {
        CarouselFactory.m8210create$lambda2$lambda1(this.f29349a, this.f29350b, this.f29351c, this.f29352d, this.f29353e, templateUiData);
    }
}
