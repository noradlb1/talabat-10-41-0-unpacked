package l5;

import androidx.appcompat.widget.AppCompatTextView;
import com.deliveryhero.fluid.Host;
import com.deliveryhero.fluid.template.data.TemplateUiData;
import com.deliveryhero.fluid.template.data.TemplateUiDataHolder;
import com.deliveryhero.fluid.widgets.text.TextFactory;
import com.deliveryhero.fluid.widgets.text.TextModel;

public final /* synthetic */ class a implements TemplateUiDataHolder.Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TextFactory f34536a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AppCompatTextView f34537b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TextModel f34538c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Host f34539d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ TextModel f34540e;

    public /* synthetic */ a(TextFactory textFactory, AppCompatTextView appCompatTextView, TextModel textModel, Host host, TextModel textModel2) {
        this.f34536a = textFactory;
        this.f34537b = appCompatTextView;
        this.f34538c = textModel;
        this.f34539d = host;
        this.f34540e = textModel2;
    }

    public final void onChanged(TemplateUiData templateUiData) {
        TextFactory.m8227create$lambda1$lambda0(this.f34536a, this.f34537b, this.f34538c, this.f34539d, this.f34540e, templateUiData);
    }
}
