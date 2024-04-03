package i5;

import com.deliveryhero.fluid.Host;
import com.deliveryhero.fluid.template.data.TemplateUiData;
import com.deliveryhero.fluid.template.data.TemplateUiDataHolder;
import com.deliveryhero.fluid.widgets.lottie.LottieModel;
import com.deliveryhero.fluid.widgets.lottie.LottieWidget;
import com.deliveryhero.fluid.widgets.lottie.LottieWidgetFactory;

public final /* synthetic */ class b implements TemplateUiDataHolder.Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LottieWidgetFactory f34479a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LottieWidget f34480b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ LottieModel f34481c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Host f34482d;

    public /* synthetic */ b(LottieWidgetFactory lottieWidgetFactory, LottieWidget lottieWidget, LottieModel lottieModel, Host host) {
        this.f34479a = lottieWidgetFactory;
        this.f34480b = lottieWidget;
        this.f34481c = lottieModel;
        this.f34482d = host;
    }

    public final void onChanged(TemplateUiData templateUiData) {
        LottieWidgetFactory.m8223create$lambda2$lambda1(this.f34479a, this.f34480b, this.f34481c, this.f34482d, templateUiData);
    }
}
