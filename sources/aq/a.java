package aq;

import com.deliveryhero.fluid.Host;
import com.deliveryhero.fluid.template.data.TemplateUiData;
import com.deliveryhero.fluid.template.data.TemplateUiDataHolder;
import com.talabat.fluid.homescreen.ui.widget.gem.GemModel;
import com.talabat.fluid.homescreen.ui.widget.gem.GemWidgetFactory;
import com.talabat.fluid.homescreen.ui.widget.gem.GemWidgetView;

public final /* synthetic */ class a implements TemplateUiDataHolder.Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GemWidgetFactory f58123a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GemWidgetView f58124b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ GemModel f58125c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Host f58126d;

    public /* synthetic */ a(GemWidgetFactory gemWidgetFactory, GemWidgetView gemWidgetView, GemModel gemModel, Host host) {
        this.f58123a = gemWidgetFactory;
        this.f58124b = gemWidgetView;
        this.f58125c = gemModel;
        this.f58126d = host;
    }

    public final void onChanged(TemplateUiData templateUiData) {
        GemWidgetFactory.m10463create$lambda1$lambda0(this.f58123a, this.f58124b, this.f58125c, this.f58126d, templateUiData);
    }
}
