package com.deliveryhero.fluid.content;

import com.deliveryhero.fluid.template.Template;
import com.deliveryhero.fluid.template.data.TemplateUiData;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/deliveryhero/fluid/content/Content;", "", "data", "Lcom/deliveryhero/fluid/template/data/TemplateUiData;", "getData", "()Lcom/deliveryhero/fluid/template/data/TemplateUiData;", "template", "Lcom/deliveryhero/fluid/template/Template;", "getTemplate", "()Lcom/deliveryhero/fluid/template/Template;", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface Content {
    @NotNull
    TemplateUiData getData();

    @NotNull
    Template getTemplate();
}
