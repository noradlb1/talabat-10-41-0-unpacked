package z4;

import com.deliveryhero.fluid.Host;
import com.deliveryhero.fluid.template.data.TemplateUiData;
import com.deliveryhero.fluid.template.data.TemplateUiDataHolder;
import com.deliveryhero.fluid.widgets.collections.grid.GridWidget;
import com.deliveryhero.fluid.widgets.collections.grid.horizontal.HorizontalGridFactory;
import com.deliveryhero.fluid.widgets.collections.grid.horizontal.HorizontalGridModel;

public final /* synthetic */ class a implements TemplateUiDataHolder.Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HorizontalGridFactory f34845a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GridWidget f34846b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ HorizontalGridModel f34847c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Host f34848d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ HorizontalGridModel f34849e;

    public /* synthetic */ a(HorizontalGridFactory horizontalGridFactory, GridWidget gridWidget, HorizontalGridModel horizontalGridModel, Host host, HorizontalGridModel horizontalGridModel2) {
        this.f34845a = horizontalGridFactory;
        this.f34846b = gridWidget;
        this.f34847c = horizontalGridModel;
        this.f34848d = host;
        this.f34849e = horizontalGridModel2;
    }

    public final void onChanged(TemplateUiData templateUiData) {
        HorizontalGridFactory.m8204create$lambda1$lambda0(this.f34845a, this.f34846b, this.f34847c, this.f34848d, this.f34849e, templateUiData);
    }
}
