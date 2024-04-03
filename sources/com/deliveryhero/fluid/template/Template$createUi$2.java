package com.deliveryhero.fluid.template;

import android.view.View;
import com.deliveryhero.fluid.Host;
import com.deliveryhero.fluid.template.data.TemplateUiDataHolder;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroid/view/View;", "Lcom/deliveryhero/fluid/widgets/Widget;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class Template$createUi$2 extends Lambda implements Function0<View> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Host f30208g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Template f30209h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Template$createUi$2(Host host, Template template) {
        super(0);
        this.f30208g = host;
        this.f30209h = template;
    }

    @NotNull
    public final View invoke() {
        TemplateUiDataHolder templateUiDataHolder = new TemplateUiDataHolder();
        View create = this.f30208g.getWidgetFactories().get(this.f30209h.getWidget()).create(this.f30209h.getWidget(), this.f30208g, templateUiDataHolder);
        this.f30208g.getTemplateDataHolders().set(create, templateUiDataHolder);
        return create;
    }
}
