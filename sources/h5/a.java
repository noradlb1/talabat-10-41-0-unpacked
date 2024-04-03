package h5;

import com.deliveryhero.fluid.Host;
import com.deliveryhero.fluid.template.data.TemplateUiData;
import com.deliveryhero.fluid.template.data.TemplateUiDataHolder;
import com.deliveryhero.fluid.widgets.image.ImageFactory;
import com.deliveryhero.fluid.widgets.image.ImageModel;
import com.deliveryhero.fluid.widgets.image.ImageWidget;

public final /* synthetic */ class a implements TemplateUiDataHolder.Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ImageFactory f34472a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ImageWidget f34473b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ImageModel f34474c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Host f34475d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ ImageModel f34476e;

    public /* synthetic */ a(ImageFactory imageFactory, ImageWidget imageWidget, ImageModel imageModel, Host host, ImageModel imageModel2) {
        this.f34472a = imageFactory;
        this.f34473b = imageWidget;
        this.f34474c = imageModel;
        this.f34475d = host;
        this.f34476e = imageModel2;
    }

    public final void onChanged(TemplateUiData templateUiData) {
        ImageFactory.m8222create$lambda1$lambda0(this.f34472a, this.f34473b, this.f34474c, this.f34475d, this.f34476e, templateUiData);
    }
}
