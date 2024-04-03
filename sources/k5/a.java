package k5;

import android.widget.Space;
import com.deliveryhero.fluid.Host;
import com.deliveryhero.fluid.template.data.TemplateUiData;
import com.deliveryhero.fluid.template.data.TemplateUiDataHolder;
import com.deliveryhero.fluid.widgets.space.SpaceFactory;
import com.deliveryhero.fluid.widgets.space.SpaceModel;

public final /* synthetic */ class a implements TemplateUiDataHolder.Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SpaceFactory f34498a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Space f34499b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SpaceModel f34500c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Host f34501d;

    public /* synthetic */ a(SpaceFactory spaceFactory, Space space, SpaceModel spaceModel, Host host) {
        this.f34498a = spaceFactory;
        this.f34499b = space;
        this.f34500c = spaceModel;
        this.f34501d = host;
    }

    public final void onChanged(TemplateUiData templateUiData) {
        SpaceFactory.m8226create$lambda1$lambda0(this.f34498a, this.f34499b, this.f34500c, this.f34501d, templateUiData);
    }
}
