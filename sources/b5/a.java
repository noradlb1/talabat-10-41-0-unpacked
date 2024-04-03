package b5;

import com.deliveryhero.fluid.Host;
import com.deliveryhero.fluid.template.data.TemplateUiData;
import com.deliveryhero.fluid.template.data.TemplateUiDataHolder;
import com.deliveryhero.fluid.widgets.collections.list.ListFactory;
import com.deliveryhero.fluid.widgets.collections.list.ListModel;
import com.deliveryhero.fluid.widgets.collections.list.ListWidget;

public final /* synthetic */ class a implements TemplateUiDataHolder.Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ListFactory f29315a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ListWidget f29316b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ListModel f29317c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Host f29318d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ ListModel f29319e;

    public /* synthetic */ a(ListFactory listFactory, ListWidget listWidget, ListModel listModel, Host host, ListModel listModel2) {
        this.f29315a = listFactory;
        this.f29316b = listWidget;
        this.f29317c = listModel;
        this.f29318d = host;
        this.f29319e = listModel2;
    }

    public final void onChanged(TemplateUiData templateUiData) {
        ListFactory.m8209create$lambda1$lambda0(this.f29315a, this.f29316b, this.f29317c, this.f29318d, this.f29319e, templateUiData);
    }
}
