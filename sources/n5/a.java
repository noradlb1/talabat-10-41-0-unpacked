package n5;

import android.view.View;
import com.deliveryhero.fluid.Host;
import com.deliveryhero.fluid.template.data.TemplateUiData;
import com.deliveryhero.fluid.widgets.utils.ClickUtilsKt;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Host f34594b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f34595c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ TemplateUiData f34596d;

    public /* synthetic */ a(Host host, String str, TemplateUiData templateUiData) {
        this.f34594b = host;
        this.f34595c = str;
        this.f34596d = templateUiData;
    }

    public final void onClick(View view) {
        ClickUtilsKt.m8228updateOnClickInternal$lambda1(this.f34594b, this.f34595c, this.f34596d, view);
    }
}
