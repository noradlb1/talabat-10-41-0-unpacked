package f5;

import com.deliveryhero.fluid.Host;
import com.deliveryhero.fluid.template.data.TemplateUiData;
import com.deliveryhero.fluid.template.data.TemplateUiDataHolder;
import com.deliveryhero.fluid.widgets.containers.EnhancedLinearLayout;
import com.deliveryhero.fluid.widgets.containers.row.RowFactory;
import com.deliveryhero.fluid.widgets.containers.row.RowModel;

public final /* synthetic */ class a implements TemplateUiDataHolder.Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RowFactory f34432a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ EnhancedLinearLayout f34433b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ RowModel f34434c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Host f34435d;

    public /* synthetic */ a(RowFactory rowFactory, EnhancedLinearLayout enhancedLinearLayout, RowModel rowModel, Host host) {
        this.f34432a = rowFactory;
        this.f34433b = enhancedLinearLayout;
        this.f34434c = rowModel;
        this.f34435d = host;
    }

    public final void onChanged(TemplateUiData templateUiData) {
        RowFactory.m8220createContainer$lambda1$lambda0(this.f34432a, this.f34433b, this.f34434c, this.f34435d, templateUiData);
    }
}
