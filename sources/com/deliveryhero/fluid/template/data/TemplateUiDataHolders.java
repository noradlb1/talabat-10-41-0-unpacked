package com.deliveryhero.fluid.template.data;

import android.view.View;
import com.deliveryhero.fluid.widgets.utils.WidgetTags;
import com.deliveryhero.fluid.widgets.utils.WidgetTagsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0017\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\u0010\u0005\u001a\u00060\u0006j\u0002`\u0007H\u0002J\u001d\u0010\b\u001a\u00020\t2\n\u0010\u0005\u001a\u00060\u0006j\u0002`\u00072\u0006\u0010\n\u001a\u00020\u0004H\u0002¨\u0006\u000b"}, d2 = {"Lcom/deliveryhero/fluid/template/data/TemplateUiDataHolders;", "", "()V", "get", "Lcom/deliveryhero/fluid/template/data/TemplateUiDataHolder;", "ui", "Landroid/view/View;", "Lcom/deliveryhero/fluid/widgets/Widget;", "set", "", "holder", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TemplateUiDataHolders {
    @Nullable
    public final TemplateUiDataHolder get(@NotNull View view) {
        WidgetTags widgetTags;
        Intrinsics.checkNotNullParameter(view, "ui");
        Object tag = view.getTag();
        if (tag instanceof WidgetTags) {
            widgetTags = (WidgetTags) tag;
        } else {
            widgetTags = null;
        }
        if (widgetTags == null) {
            widgetTags = WidgetTagsKt.initWidgetTags(view);
        }
        return widgetTags.getDataHolder();
    }

    public final void set(@NotNull View view, @NotNull TemplateUiDataHolder templateUiDataHolder) {
        WidgetTags widgetTags;
        Intrinsics.checkNotNullParameter(view, "ui");
        Intrinsics.checkNotNullParameter(templateUiDataHolder, "holder");
        Object tag = view.getTag();
        if (tag instanceof WidgetTags) {
            widgetTags = (WidgetTags) tag;
        } else {
            widgetTags = null;
        }
        if (widgetTags == null) {
            widgetTags = WidgetTagsKt.initWidgetTags(view);
        }
        widgetTags.setDataHolder(templateUiDataHolder);
    }
}
