package com.deliveryhero.fluid.widgets.utils;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout;
import com.deliveryhero.fluid.Host;
import com.deliveryhero.fluid.telemetry.log.LogLevel;
import com.deliveryhero.fluid.telemetry.log.Logger;
import com.deliveryhero.fluid.template.data.TemplateUiData;
import com.deliveryhero.fluid.utils.AndroidVersion;
import com.pichillilorenzo.flutter_inappwebview.credential_database.URLProtectionSpaceContract;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import n5.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\"\u0010\u0000\u001a\u00020\u0001*\u00060\u0002j\u0002`\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0000\u001a,\u0010\b\u001a\u00020\u0001*\u00060\u0002j\u0002`\u00032\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0000\u001a\"\u0010\u000f\u001a\u00020\u0001*\u00060\u0002j\u0002`\u00032\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002\u001a,\u0010\u0010\u001a\u00020\u0001*\u00060\u0002j\u0002`\u00032\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002¨\u0006\u0011"}, d2 = {"updateForeground", "", "Landroid/view/View;", "Lcom/deliveryhero/fluid/widgets/Widget;", "logger", "Lcom/deliveryhero/fluid/telemetry/log/Logger;", "drawable", "Landroid/graphics/drawable/Drawable;", "updateOnClick", "host", "Lcom/deliveryhero/fluid/Host;", "url", "", "data", "Lcom/deliveryhero/fluid/template/data/TemplateUiData;", "updateOnClickAnimation", "updateOnClickInternal", "core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ClickUtilsKt {
    public static final void updateForeground(@NotNull View view, @NotNull Logger logger, @Nullable Drawable drawable) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(logger, "logger");
        if (AndroidVersion.INSTANCE.isAtLeastMarshmallow()) {
            view.setForeground(drawable);
        } else if (view instanceof FrameLayout) {
            ((FrameLayout) view).setForeground(drawable);
        } else {
            LogLevel logLevel = LogLevel.WARNING;
            if (logLevel.compareTo(logger.getMinimumLevel()) >= 0) {
                String tag = logger.getTag();
                Logger.log$default(logger, tag, logLevel, view.getClass().getName() + " widget does not support foregrounds", (Throwable) null, (Pair[]) null, 24, (Object) null);
            }
        }
    }

    public static final void updateOnClick(@NotNull View view, @NotNull Host host, @Nullable String str, @Nullable TemplateUiData templateUiData) {
        WidgetTags widgetTags;
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(host, URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_HOST);
        updateOnClickAnimation(view, host, str);
        updateOnClickInternal(view, host, str, templateUiData);
        Object tag = view.getTag();
        if (tag instanceof WidgetTags) {
            widgetTags = (WidgetTags) tag;
        } else {
            widgetTags = null;
        }
        if (widgetTags == null) {
            widgetTags = WidgetTagsKt.initWidgetTags(view);
        }
        widgetTags.setOnClickUrl(str);
    }

    private static final void updateOnClickAnimation(View view, Host host, String str) {
        WidgetTags widgetTags;
        boolean z11;
        boolean z12;
        Object tag = view.getTag();
        if (tag instanceof WidgetTags) {
            widgetTags = (WidgetTags) tag;
        } else {
            widgetTags = null;
        }
        if (widgetTags == null) {
            widgetTags = WidgetTagsKt.initWidgetTags(view);
        }
        String onClickUrl = widgetTags.getOnClickUrl();
        boolean z13 = false;
        if (onClickUrl == null || onClickUrl.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            if (str == null || str.length() == 0) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (!z12) {
                updateForeground(view, host.getLogger(), host.getUiConfig().getClickDrawable().invoke());
                return;
            }
        }
        if (str == null || str.length() == 0) {
            z13 = true;
        }
        if (z13) {
            updateForeground(view, host.getLogger(), (Drawable) null);
        }
    }

    private static final void updateOnClickInternal(View view, Host host, String str, TemplateUiData templateUiData) {
        boolean z11;
        if (str == null || str.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            if (view.hasOnClickListeners()) {
                view.setOnClickListener((View.OnClickListener) null);
            }
            if (view.isClickable()) {
                view.setClickable(false);
                return;
            }
            return;
        }
        view.setOnClickListener(new a(host, str, templateUiData));
    }

    /* access modifiers changed from: private */
    /* renamed from: updateOnClickInternal$lambda-1  reason: not valid java name */
    public static final void m8228updateOnClickInternal$lambda1(Host host, String str, TemplateUiData templateUiData, View view) {
        Intrinsics.checkNotNullParameter(host, "$host");
        Logger logger = host.getLogger();
        LogLevel logLevel = LogLevel.DEBUG;
        if (logLevel.compareTo(logger.getMinimumLevel()) >= 0) {
            String tag = logger.getTag();
            Logger.log$default(logger, tag, logLevel, "onClick: " + str + ", data: " + templateUiData, (Throwable) null, (Pair[]) null, 24, (Object) null);
        }
        host.getInteractionListeners().getClick().onClick(str, templateUiData);
    }
}
