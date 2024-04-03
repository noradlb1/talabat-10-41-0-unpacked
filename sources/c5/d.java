package c5;

import com.deliveryhero.fluid.Host;
import com.deliveryhero.fluid.template.data.TemplateUiData;
import com.deliveryhero.fluid.template.data.TemplateUiDataHolder;
import com.deliveryhero.fluid.widgets.collections.pager.PagerFactory;
import com.deliveryhero.fluid.widgets.collections.pager.PagerModel;
import com.deliveryhero.fluid.widgets.collections.pager.PagerWidget;

public final /* synthetic */ class d implements TemplateUiDataHolder.Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PagerFactory f29358a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PagerWidget f29359b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ PagerModel f29360c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Host f29361d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ PagerModel f29362e;

    public /* synthetic */ d(PagerFactory pagerFactory, PagerWidget pagerWidget, PagerModel pagerModel, Host host, PagerModel pagerModel2) {
        this.f29358a = pagerFactory;
        this.f29359b = pagerWidget;
        this.f29360c = pagerModel;
        this.f29361d = host;
        this.f29362e = pagerModel2;
    }

    public final void onChanged(TemplateUiData templateUiData) {
        PagerFactory.m8217create$lambda2$lambda1(this.f29358a, this.f29359b, this.f29360c, this.f29361d, this.f29362e, templateUiData);
    }
}
