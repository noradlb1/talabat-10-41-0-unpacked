package e5;

import com.deliveryhero.fluid.Host;
import com.deliveryhero.fluid.template.data.TemplateUiData;
import com.deliveryhero.fluid.template.data.TemplateUiDataHolder;
import com.deliveryhero.fluid.widgets.containers.EnhancedLinearLayout;
import com.deliveryhero.fluid.widgets.containers.column.ColumnFactory;
import com.deliveryhero.fluid.widgets.containers.column.ColumnModel;

public final /* synthetic */ class a implements TemplateUiDataHolder.Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ColumnFactory f34418a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ EnhancedLinearLayout f34419b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ColumnModel f34420c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Host f34421d;

    public /* synthetic */ a(ColumnFactory columnFactory, EnhancedLinearLayout enhancedLinearLayout, ColumnModel columnModel, Host host) {
        this.f34418a = columnFactory;
        this.f34419b = enhancedLinearLayout;
        this.f34420c = columnModel;
        this.f34421d = host;
    }

    public final void onChanged(TemplateUiData templateUiData) {
        ColumnFactory.m8219createContainer$lambda1$lambda0(this.f34418a, this.f34419b, this.f34420c, this.f34421d, templateUiData);
    }
}
