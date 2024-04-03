package com.deliveryhero.fluid.widgets.text.utils;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.TypedValue;
import android.widget.TextView;
import androidx.annotation.StyleRes;
import androidx.core.content.res.TypedArrayKt;
import androidx.core.widget.TextViewCompat;
import com.deliveryhero.fluid.Host;
import com.deliveryhero.fluid.R;
import com.deliveryhero.fluid.expression.Expression;
import com.deliveryhero.fluid.telemetry.log.ErrorTypes;
import com.deliveryhero.fluid.telemetry.log.Logger;
import com.deliveryhero.fluid.telemetry.log.LoggerKt;
import com.deliveryhero.fluid.template.data.TemplateUiData;
import com.deliveryhero.fluid.utils.ContextUtilsKt;
import com.deliveryhero.fluid.values.Color;
import com.deliveryhero.fluid.values.ScalableLogicalPixel;
import com.deliveryhero.fluid.widgets.text.ResourceTextStyle;
import com.deliveryhero.fluid.widgets.text.TextAppearance;
import com.deliveryhero.fluid.widgets.text.TextModel;
import com.deliveryhero.fluid.widgets.text.TextStyle;
import com.deliveryhero.fluid.widgets.utils.WidgetTags;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.google.firebase.remoteconfig.RemoteConfigComponent;
import com.pichillilorenzo.flutter_inappwebview.credential_database.URLProtectionSpaceContract;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001c\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\b\b\u0001\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\t\u001a*\u0010\n\u001a\u00020\u0001*\u00020\u00022\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u001a4\u0010\u0012\u001a\u00020\u0013*\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0016\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u001a"}, d2 = {"defaultTextAppearanceId", "", "Landroid/content/Context;", "getDefaultTextAppearanceId", "(Landroid/content/Context;)I", "getTextAppearance", "Lcom/deliveryhero/fluid/widgets/text/TextAppearance;", "textAppearanceId", "logger", "Lcom/deliveryhero/fluid/telemetry/log/Logger;", "getTextAppearanceId", "textStyleExpression", "Lcom/deliveryhero/fluid/expression/Expression;", "Lcom/deliveryhero/fluid/widgets/text/TextStyle;", "host", "Lcom/deliveryhero/fluid/Host;", "data", "Lcom/deliveryhero/fluid/template/data/TemplateUiData;", "updateTextAppearance", "", "Landroid/widget/TextView;", "model", "Lcom/deliveryhero/fluid/widgets/text/TextModel;", "tags", "Lcom/deliveryhero/fluid/widgets/utils/WidgetTags;", "defaults", "core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class TextAppearanceUtilsKt {
    public static final int getDefaultTextAppearanceId(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return ContextUtilsKt.getThemeAttributeResourceId(context, 16842804);
    }

    @NotNull
    public static final TextAppearance getTextAppearance(@NotNull Context context, @StyleRes int i11, @NotNull Logger logger) {
        ColorStateList colorStateList;
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(logger, "logger");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i11, R.styleable.TextAppearance);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "obtainStyledAttributes(t…styleable.TextAppearance)");
        Float f11 = null;
        try {
            colorStateList = TypedArrayKt.getColorStateListOrThrow(obtainStyledAttributes, R.styleable.TextAppearance_android_textColor);
        } catch (Throwable th2) {
            LoggerKt.error$default(logger, th2, ErrorTypes.BINDING, (Map) null, 4, (Object) null);
            colorStateList = null;
        }
        try {
            f11 = Float.valueOf(TypedArrayKt.getDimensionOrThrow(obtainStyledAttributes, R.styleable.TextAppearance_android_textSize));
        } catch (Throwable th3) {
            LoggerKt.error$default(logger, th3, ErrorTypes.BINDING, (Map) null, 4, (Object) null);
        }
        TextAppearance textAppearance = new TextAppearance(colorStateList, f11);
        obtainStyledAttributes.recycle();
        return textAppearance;
    }

    public static final int getTextAppearanceId(@NotNull Context context, @NotNull Expression<TextStyle> expression, @NotNull Host host, @Nullable TemplateUiData templateUiData) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(expression, "textStyleExpression");
        Intrinsics.checkNotNullParameter(host, URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_HOST);
        TextStyle orNull = expression.getOrNull(templateUiData);
        Map<String, Expression<Object>> map = null;
        if (orNull == null) {
            Logger logger = host.getLogger();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Could not resolve resource text style " + expression);
            ErrorTypes errorTypes = ErrorTypes.BINDING;
            if (templateUiData != null) {
                map = templateUiData.getPlaceholderValues();
            }
            if (map == null) {
                map = MapsKt__MapsKt.emptyMap();
            }
            LoggerKt.error(logger, illegalArgumentException, errorTypes, map);
            return getDefaultTextAppearanceId(context);
        } else if (orNull instanceof ResourceTextStyle) {
            return ((ResourceTextStyle) orNull).getId();
        } else {
            Logger logger2 = host.getLogger();
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("Wrong text style type " + expression + ". Expected " + ResourceTextStyle.class.getName() + ", but was " + orNull.getClass().getName());
            ErrorTypes errorTypes2 = ErrorTypes.BINDING;
            if (templateUiData != null) {
                map = templateUiData.getPlaceholderValues();
            }
            if (map == null) {
                map = MapsKt__MapsKt.emptyMap();
            }
            LoggerKt.error(logger2, illegalArgumentException2, errorTypes2, map);
            return getDefaultTextAppearanceId(context);
        }
    }

    public static final void updateTextAppearance(@NotNull TextView textView, @NotNull TextModel textModel, @NotNull Host host, @Nullable TemplateUiData templateUiData, @NotNull WidgetTags widgetTags, @NotNull TextModel textModel2) {
        Integer num;
        Intrinsics.checkNotNullParameter(textView, "<this>");
        Intrinsics.checkNotNullParameter(textModel, DeviceRequestsHelper.DEVICE_INFO_MODEL);
        Intrinsics.checkNotNullParameter(host, URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_HOST);
        Intrinsics.checkNotNullParameter(widgetTags, "tags");
        Intrinsics.checkNotNullParameter(textModel2, RemoteConfigComponent.DEFAULTS_FILE_NAME);
        Context context = textView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        int textAppearanceId = getTextAppearanceId(context, textModel.getTextStyle(), host, templateUiData);
        Context context2 = textView.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        TextAppearance textAppearance = getTextAppearance(context2, textAppearanceId, host.getLogger());
        Integer textAppearanceId2 = widgetTags.getTextAppearanceId();
        if (textAppearanceId2 == null || textAppearanceId2.intValue() != textAppearanceId) {
            TextViewCompat.setTextAppearance(textView, textAppearanceId);
            widgetTags.setTextAppearanceId(Integer.valueOf(textAppearanceId));
        }
        Color orNull = textModel.getTextColor().getOrNull(templateUiData);
        Float f11 = null;
        if (orNull != null) {
            num = Integer.valueOf(orNull.getArgb());
        } else {
            num = null;
        }
        if (num != null) {
            textView.setTextColor(num.intValue());
        } else if (textAppearance.getColors() != null) {
            textView.setTextColor(textAppearance.getColors());
        } else {
            Color orNull2 = textModel2.getTextColor().getOrNull(templateUiData);
            Intrinsics.checkNotNull(orNull2);
            textView.setTextColor(orNull2.getArgb());
        }
        ScalableLogicalPixel orNull3 = textModel.getTextSize().getOrNull(templateUiData);
        if (orNull3 != null) {
            Context context3 = textView.getContext();
            Intrinsics.checkNotNullExpressionValue(context3, "context");
            f11 = Float.valueOf(TypedValue.applyDimension(2, orNull3.getValue(), context3.getResources().getDisplayMetrics()));
        }
        if (f11 != null) {
            textView.setTextSize(0, f11.floatValue());
        } else if (textAppearance.getSize() != null) {
            textView.setTextSize(0, textAppearance.getSize().floatValue());
        } else {
            ScalableLogicalPixel orNull4 = textModel2.getTextSize().getOrNull(templateUiData);
            Intrinsics.checkNotNull(orNull4);
            Context context4 = textView.getContext();
            Intrinsics.checkNotNullExpressionValue(context4, "context");
            textView.setTextSize(TypedValue.applyDimension(2, orNull4.getValue(), context4.getResources().getDisplayMetrics()));
        }
    }
}
