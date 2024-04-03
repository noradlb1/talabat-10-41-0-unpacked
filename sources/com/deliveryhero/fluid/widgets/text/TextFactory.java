package com.deliveryhero.fluid.widgets.text;

import android.content.Context;
import android.util.TypedValue;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.deliveryhero.fluid.Host;
import com.deliveryhero.fluid.template.data.TemplateUiData;
import com.deliveryhero.fluid.template.data.TemplateUiDataHolder;
import com.deliveryhero.fluid.widgets.AndroidWidgetFactory;
import com.deliveryhero.fluid.widgets.text.utils.LineUtilsKt;
import com.deliveryhero.fluid.widgets.text.utils.TextAlignmentUtilsKt;
import com.deliveryhero.fluid.widgets.text.utils.TextAppearanceUtilsKt;
import com.deliveryhero.fluid.widgets.text.utils.TextUtilsKt;
import com.deliveryhero.fluid.widgets.utils.WidgetTags;
import com.deliveryhero.fluid.widgets.utils.WidgetTagsKt;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.pichillilorenzo.flutter_inappwebview.credential_database.URLProtectionSpaceContract;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import l5.a;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/deliveryhero/fluid/widgets/text/TextFactory;", "Lcom/deliveryhero/fluid/widgets/AndroidWidgetFactory;", "Lcom/deliveryhero/fluid/widgets/text/TextModel;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "defaultsFactory", "Lkotlin/Function1;", "Landroid/widget/TextView;", "create", "Landroidx/appcompat/widget/AppCompatTextView;", "model", "host", "Lcom/deliveryhero/fluid/Host;", "holder", "Lcom/deliveryhero/fluid/template/data/TemplateUiDataHolder;", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class TextFactory extends AndroidWidgetFactory<TextModel> {
    @NotNull
    private final Function1<TextView, TextModel> defaultsFactory;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextFactory(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.defaultsFactory = new TextFactory$defaultsFactory$1(context, this);
    }

    /* access modifiers changed from: private */
    /* renamed from: create$lambda-1$lambda-0  reason: not valid java name */
    public static final void m8227create$lambda1$lambda0(TextFactory textFactory, AppCompatTextView appCompatTextView, TextModel textModel, Host host, TextModel textModel2, TemplateUiData templateUiData) {
        WidgetTags widgetTags;
        boolean z11;
        boolean z12;
        Intrinsics.checkNotNullParameter(textFactory, "this$0");
        Intrinsics.checkNotNullParameter(appCompatTextView, "$this_apply");
        Intrinsics.checkNotNullParameter(textModel, "$model");
        Intrinsics.checkNotNullParameter(host, "$host");
        Intrinsics.checkNotNullParameter(textModel2, "$defaults");
        textFactory.c(appCompatTextView, textModel.getBaseProperties(), host, templateUiData);
        Object tag = appCompatTextView.getTag();
        Map<String, Object> map = null;
        if (tag instanceof WidgetTags) {
            widgetTags = (WidgetTags) tag;
        } else {
            widgetTags = null;
        }
        if (widgetTags == null) {
            widgetTags = WidgetTagsKt.initWidgetTags(appCompatTextView);
        }
        TextAppearanceUtilsKt.updateTextAppearance(appCompatTextView, textModel, host, templateUiData, widgetTags, textModel2);
        TextAlignmentUtilsKt.updateTextAlignment(appCompatTextView, textModel.getTextAlignment().get(templateUiData, textModel2.getTextAlignment()));
        LineUtilsKt.updateMaxLines(appCompatTextView, textModel.getMaxLines().get(templateUiData, textModel2.getMaxLines()).intValue());
        LineUtilsKt.updateMinLines(appCompatTextView, textModel.getMinLines().get(templateUiData, textModel2.getMinLines()).intValue());
        LineUtilsKt.updateLineBreakMode(appCompatTextView, textModel.getLineBreakMode().get(templateUiData, textModel2.getLineBreakMode()));
        Context context = appCompatTextView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        boolean z13 = true;
        appCompatTextView.setLineSpacing(TypedValue.applyDimension(1, textModel.getLineSpacingExtra().get(templateUiData, textModel2.getLineSpacingExtra()).getValue(), context.getResources().getDisplayMetrics()), textModel.getLineSpacingMultiplier().get(templateUiData, textModel2.getLineSpacingMultiplier()).floatValue());
        String orNull = textModel.getRichText().getOrNull(templateUiData, textModel2.getRichText());
        String orNull2 = textModel.getPlainText().getOrNull(templateUiData, textModel2.getPlainText());
        int i11 = 0;
        if (orNull == null || orNull.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            if (orNull2 == null || orNull2.length() == 0) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (z12) {
                z13 = false;
            }
        }
        if (!z13) {
            i11 = 8;
        }
        appCompatTextView.setVisibility(i11);
        if (templateUiData != null) {
            map = templateUiData.getMetadata();
        }
        TextUtilsKt.updateRichOrPlainText(appCompatTextView, orNull, orNull2, map);
    }

    @NotNull
    public AppCompatTextView create(@NotNull TextModel textModel, @NotNull Host host, @NotNull TemplateUiDataHolder templateUiDataHolder) {
        Intrinsics.checkNotNullParameter(textModel, DeviceRequestsHelper.DEVICE_INFO_MODEL);
        Intrinsics.checkNotNullParameter(host, URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_HOST);
        Intrinsics.checkNotNullParameter(templateUiDataHolder, "holder");
        AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
        templateUiDataHolder.observe(new a(this, appCompatTextView, textModel, host, (TextModel) b(appCompatTextView, this.defaultsFactory)));
        return appCompatTextView;
    }
}
