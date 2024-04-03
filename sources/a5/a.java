package a5;

import com.deliveryhero.fluid.Host;
import com.deliveryhero.fluid.template.data.TemplateUiData;
import com.deliveryhero.fluid.template.data.TemplateUiDataHolder;
import com.deliveryhero.fluid.widgets.collections.grid.GridWidget;
import com.deliveryhero.fluid.widgets.collections.grid.vertical.VerticalGridFactory;
import com.deliveryhero.fluid.widgets.collections.grid.vertical.VerticalGridModel;

public final /* synthetic */ class a implements TemplateUiDataHolder.Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ VerticalGridFactory f29302a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GridWidget f29303b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ VerticalGridModel f29304c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Host f29305d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ VerticalGridModel f29306e;

    public /* synthetic */ a(VerticalGridFactory verticalGridFactory, GridWidget gridWidget, VerticalGridModel verticalGridModel, Host host, VerticalGridModel verticalGridModel2) {
        this.f29302a = verticalGridFactory;
        this.f29303b = gridWidget;
        this.f29304c = verticalGridModel;
        this.f29305d = host;
        this.f29306e = verticalGridModel2;
    }

    public final void onChanged(TemplateUiData templateUiData) {
        VerticalGridFactory.m8208create$lambda1$lambda0(this.f29302a, this.f29303b, this.f29304c, this.f29305d, this.f29306e, templateUiData);
    }
}
