package j5;

import android.view.View;
import com.deliveryhero.fluid.Host;
import com.deliveryhero.fluid.template.data.TemplateUiData;
import com.deliveryhero.fluid.template.data.TemplateUiDataHolder;
import com.deliveryhero.fluid.widgets.plain.PlainFactory;
import com.deliveryhero.fluid.widgets.plain.PlainModel;

public final /* synthetic */ class a implements TemplateUiDataHolder.Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PlainFactory f34484a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f34485b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ PlainModel f34486c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Host f34487d;

    public /* synthetic */ a(PlainFactory plainFactory, View view, PlainModel plainModel, Host host) {
        this.f34484a = plainFactory;
        this.f34485b = view;
        this.f34486c = plainModel;
        this.f34487d = host;
    }

    public final void onChanged(TemplateUiData templateUiData) {
        PlainFactory.m8225create$lambda1$lambda0(this.f34484a, this.f34485b, this.f34486c, this.f34487d, templateUiData);
    }
}
