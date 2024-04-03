package cq;

import com.deliveryhero.fluid.Host;
import com.deliveryhero.fluid.template.data.TemplateUiData;
import com.deliveryhero.fluid.template.data.TemplateUiDataHolder;
import com.talabat.fluid.homescreen.ui.widget.ramadanclock.RamadanClockModel;
import com.talabat.fluid.homescreen.ui.widget.ramadanclock.RamadanClockWidgetFactory;
import com.talabat.fluid.homescreen.ui.widget.ramadanclock.RamadanClockWidgetView;

public final /* synthetic */ class a implements TemplateUiDataHolder.Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RamadanClockWidgetFactory f61798a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RamadanClockWidgetView f61799b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ RamadanClockModel f61800c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Host f61801d;

    public /* synthetic */ a(RamadanClockWidgetFactory ramadanClockWidgetFactory, RamadanClockWidgetView ramadanClockWidgetView, RamadanClockModel ramadanClockModel, Host host) {
        this.f61798a = ramadanClockWidgetFactory;
        this.f61799b = ramadanClockWidgetView;
        this.f61800c = ramadanClockModel;
        this.f61801d = host;
    }

    public final void onChanged(TemplateUiData templateUiData) {
        RamadanClockWidgetFactory.m10465create$lambda1$lambda0(this.f61798a, this.f61799b, this.f61800c, this.f61801d, templateUiData);
    }
}
