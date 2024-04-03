package com.deliveryhero.fluid.widgets.utils;

import android.view.View;
import com.deliveryhero.fluid.template.data.TemplateUiDataHolder;
import com.deliveryhero.fluid.values.Color;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u000e\u0010\u0006\u001a\u00020\u0001*\u00060\u0002j\u0002`\u0003\"\u001a\u0010\u0000\u001a\u00020\u0001*\u00060\u0002j\u0002`\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"widgetTags", "Lcom/deliveryhero/fluid/widgets/utils/WidgetTags;", "Landroid/view/View;", "Lcom/deliveryhero/fluid/widgets/Widget;", "getWidgetTags", "(Landroid/view/View;)Lcom/deliveryhero/fluid/widgets/utils/WidgetTags;", "initWidgetTags", "core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class WidgetTagsKt {
    @NotNull
    public static final WidgetTags getWidgetTags(@NotNull View view) {
        WidgetTags widgetTags;
        Intrinsics.checkNotNullParameter(view, "<this>");
        Object tag = view.getTag();
        if (tag instanceof WidgetTags) {
            widgetTags = (WidgetTags) tag;
        } else {
            widgetTags = null;
        }
        if (widgetTags == null) {
            return initWidgetTags(view);
        }
        return widgetTags;
    }

    @NotNull
    public static final WidgetTags initWidgetTags(@NotNull View view) {
        View view2 = view;
        Intrinsics.checkNotNullParameter(view2, "<this>");
        WidgetTags widgetTags = new WidgetTags(view.getBackground(), (String) null, (String) null, (String) null, (Integer) null, (List) null, 0.0f, 0.0f, 0.0f, 0.0f, 0, (Color) null, (TemplateUiDataHolder) null, 8190, (DefaultConstructorMarker) null);
        view2.setTag(widgetTags);
        return widgetTags;
    }
}
