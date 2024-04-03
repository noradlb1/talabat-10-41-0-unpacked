package g5;

import android.widget.FrameLayout;
import com.deliveryhero.fluid.Host;
import com.deliveryhero.fluid.template.data.TemplateUiData;
import com.deliveryhero.fluid.template.data.TemplateUiDataHolder;
import com.deliveryhero.fluid.widgets.containers.stack.StackFactory;
import com.deliveryhero.fluid.widgets.containers.stack.StackModel;

public final /* synthetic */ class a implements TemplateUiDataHolder.Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ StackFactory f34466a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FrameLayout f34467b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ StackModel f34468c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Host f34469d;

    public /* synthetic */ a(StackFactory stackFactory, FrameLayout frameLayout, StackModel stackModel, Host host) {
        this.f34466a = stackFactory;
        this.f34467b = frameLayout;
        this.f34468c = stackModel;
        this.f34469d = host;
    }

    public final void onChanged(TemplateUiData templateUiData) {
        StackFactory.m8221createContainer$lambda1$lambda0(this.f34466a, this.f34467b, this.f34468c, this.f34469d, templateUiData);
    }
}
