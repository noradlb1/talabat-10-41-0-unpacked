package com.talabat.feature.tpro.presentation.util;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Html;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import colorprovider.DSColorProvider;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.target.Target;
import com.designsystem.marshmallow.R;
import com.talabat.feature.subscriptions.domain.model.TProOnBoardingTitleSpanningModel;
import com.talabat.helpers.TalabatUtils;
import com.talabat.observability.squads.nfv.ObservableAttributesNames;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000j\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t\u001a\u0014\u0010\n\u001a\u00020\u000b*\u00020\f2\b\u0010\b\u001a\u0004\u0018\u00010\t\u001a\u0014\u0010\r\u001a\u00020\u000b*\u00020\u000e2\b\u0010\b\u001a\u0004\u0018\u00010\t\u001a\u0014\u0010\u000f\u001a\u00020\u000b*\u00020\u00102\b\u0010\b\u001a\u0004\u0018\u00010\t\u001a\u001a\u0010\u0011\u001a\u00020\u000b*\u00020\f2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0014\u001a\u0014\u0010\u0015\u001a\u00020\u000b*\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\t\u001a?\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019*\u00020\f2\u0006\u0010\u001b\u001a\u00020\t2%\b\u0002\u0010\u001c\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u001e0\u001d¢\u0006\u0002\b\u001f\u001a?\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019*\u00020\u00102\u0006\u0010\u001b\u001a\u00020\t2%\b\u0002\u0010\u001c\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u001e0\u001d¢\u0006\u0002\b\u001f\u001a\u0012\u0010 \u001a\u00020\u000b*\u00020\u00162\u0006\u0010!\u001a\u00020\t\u001a\u0018\u0010\"\u001a\u00020\u000b*\u00020\u00162\f\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$\u001a\u0018\u0010&\u001a\u00020\u000b*\u00020\u00162\f\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$\u001a\u0012\u0010'\u001a\u00020\u000b*\u00020\f2\u0006\u0010\u0017\u001a\u00020\t\u001a\u0012\u0010'\u001a\u00020\u000b*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\t\u001a\u0012\u0010(\u001a\u00020\u000b*\u00020\f2\u0006\u0010\u0017\u001a\u00020\t\u001a\u0012\u0010)\u001a\u00020\u000b*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\t\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"LINE_SPACING", "", "LINE_SPACING_MULTIPLIER", "LINE_SPACING_MULTIPLIER_ARABIC", "getForegroundSpan", "Landroid/text/style/ForegroundColorSpan;", "context", "Landroid/content/Context;", "color", "", "applyBgColor", "", "Landroid/view/View;", "applyCardBgColor", "Landroidx/cardview/widget/CardView;", "applyColorFilter", "Landroid/widget/ImageView;", "applyDrawableWithTint", "marshMellowColor", "drawable", "", "applyTextColor", "Landroid/widget/TextView;", "colorCode", "loadImage", "Lcom/bumptech/glide/request/target/CustomTarget;", "Landroid/graphics/drawable/Drawable;", "imageUrl", "builder", "Lkotlin/Function1;", "Lcom/bumptech/glide/RequestBuilder;", "Lkotlin/ExtensionFunctionType;", "renderContentAsHtml", "htmlContent", "renderSpannableText", "spannable", "", "Lcom/talabat/feature/subscriptions/domain/model/TProOnBoardingTitleSpanningModel;", "renderSpannableWithMultiplier", "setDsMarshMallowColor", "setSolidDsMarshMallowColor", "setTextDsMarshMallowColor", "com_talabat_feature_tpro_presentation_presentation"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ExtensionsKt {
    public static final float LINE_SPACING = 1.0f;
    public static final float LINE_SPACING_MULTIPLIER = 0.8f;
    public static final float LINE_SPACING_MULTIPLIER_ARABIC = 1.12f;

    public static final void applyBgColor(@NotNull View view, @Nullable String str) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Integer num = DSColorProvider.INSTANCE.getMarshmallowColorMap().get(str);
        if (num != null) {
            view.setBackgroundColor(ContextCompat.getColor(view.getContext(), num.intValue()));
        }
    }

    public static final void applyCardBgColor(@NotNull CardView cardView, @Nullable String str) {
        Intrinsics.checkNotNullParameter(cardView, "<this>");
        Integer num = DSColorProvider.INSTANCE.getMarshmallowColorMap().get(str);
        if (num != null) {
            cardView.setCardBackgroundColor(ContextCompat.getColor(cardView.getContext(), num.intValue()));
        }
    }

    public static final void applyColorFilter(@NotNull ImageView imageView, @Nullable String str) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Integer num = DSColorProvider.INSTANCE.getMarshmallowColorMap().get(str);
        if (num != null) {
            imageView.setColorFilter(ContextCompat.getColor(imageView.getContext(), num.intValue()));
        }
    }

    public static final void applyDrawableWithTint(@NotNull View view, @NotNull String str, int i11) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(str, "marshMellowColor");
        Integer num = DSColorProvider.INSTANCE.getMarshmallowColorMap().get(str);
        if (num != null) {
            int color = ContextCompat.getColor(view.getContext(), num.intValue());
            Drawable drawable = view.getContext().getDrawable(i11);
            if (drawable != null) {
                DrawableCompat.setTint(drawable, color);
                view.setBackground(drawable);
            }
        }
    }

    public static final void applyTextColor(@NotNull TextView textView, @Nullable String str) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        Integer num = DSColorProvider.INSTANCE.getMarshmallowColorMap().get(str);
        if (num != null) {
            textView.setTextColor(ContextCompat.getColor(textView.getContext(), num.intValue()));
        }
    }

    @NotNull
    public static final ForegroundColorSpan getForegroundSpan(@NotNull Context context, @NotNull String str) {
        int i11;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "color");
        Integer num = DSColorProvider.INSTANCE.getMarshmallowColorMap().get(str);
        if (num != null) {
            i11 = num.intValue();
        } else {
            i11 = R.color.ds_neutral_100;
        }
        return new ForegroundColorSpan(ContextCompat.getColor(context, i11));
    }

    @NotNull
    public static final CustomTarget<Drawable> loadImage(@NotNull View view, @NotNull String str, @NotNull Function1<? super RequestBuilder<Drawable>, ? extends RequestBuilder<Drawable>> function1) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(str, ObservableAttributesNames.IMAGE_URL_V2);
        Intrinsics.checkNotNullParameter(function1, "builder");
        RequestBuilder<Drawable> load = Glide.with(view.getContext()).load(str);
        Intrinsics.checkNotNullExpressionValue(load, "with(context).load(imageUrl)");
        Target into = ((RequestBuilder) function1.invoke(load)).into(new ExtensionsKt$loadImage$2(view));
        Intrinsics.checkNotNullExpressionValue(into, "View.loadImage(\n    imag…er: Drawable?) {\n    }\n})");
        return (CustomTarget) into;
    }

    public static /* synthetic */ CustomTarget loadImage$default(View view, String str, Function1 function1, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            function1 = ExtensionsKt$loadImage$1.INSTANCE;
        }
        return loadImage(view, str, (Function1<? super RequestBuilder<Drawable>, ? extends RequestBuilder<Drawable>>) function1);
    }

    public static final void renderContentAsHtml(@NotNull TextView textView, @NotNull String str) {
        Spanned spanned;
        Intrinsics.checkNotNullParameter(textView, "<this>");
        Intrinsics.checkNotNullParameter(str, "htmlContent");
        if (Build.VERSION.SDK_INT >= 24) {
            spanned = Html.fromHtml(str, 63);
        } else {
            spanned = Html.fromHtml(str);
        }
        textView.setText(spanned);
    }

    public static final void renderSpannableText(@NotNull TextView textView, @NotNull List<TProOnBoardingTitleSpanningModel> list) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        Intrinsics.checkNotNullParameter(list, "spannable");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("");
        int i11 = 0;
        for (Object next : list) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            TProOnBoardingTitleSpanningModel tProOnBoardingTitleSpanningModel = (TProOnBoardingTitleSpanningModel) next;
            SpannableString spannableString = new SpannableString(tProOnBoardingTitleSpanningModel.getText());
            Context context = textView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            spannableString.setSpan(getForegroundSpan(context, tProOnBoardingTitleSpanningModel.getColor()), 0, tProOnBoardingTitleSpanningModel.getText().length(), 33);
            spannableStringBuilder.append(spannableString);
            i11 = i12;
        }
        textView.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
    }

    public static final void renderSpannableWithMultiplier(@NotNull TextView textView, @NotNull List<TProOnBoardingTitleSpanningModel> list) {
        float f11;
        Intrinsics.checkNotNullParameter(textView, "<this>");
        Intrinsics.checkNotNullParameter(list, "spannable");
        renderSpannableText(textView, list);
        if (TalabatUtils.isArabic()) {
            f11 = 1.12f;
        } else {
            f11 = 0.8f;
        }
        textView.setLineSpacing(1.0f, f11);
    }

    public static final void setDsMarshMallowColor(@NotNull TextView textView, @NotNull String str) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        Intrinsics.checkNotNullParameter(str, "colorCode");
        Integer num = DSColorProvider.INSTANCE.getMarshmallowColorMap().get(str);
        if (num != null) {
            int intValue = num.intValue();
            Context context = textView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            textView.setBackground(CreateGradientDrawableKt.createGradientDrawable(context, intValue));
        }
    }

    public static final void setSolidDsMarshMallowColor(@NotNull View view, @NotNull String str) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(str, "colorCode");
        Integer num = DSColorProvider.INSTANCE.getMarshmallowColorMap().get(str);
        if (num != null) {
            view.setBackground(new ColorDrawable(num.intValue()));
        }
    }

    public static final void setTextDsMarshMallowColor(@NotNull TextView textView, @NotNull String str) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        Intrinsics.checkNotNullParameter(str, "colorCode");
        Integer num = DSColorProvider.INSTANCE.getMarshmallowColorMap().get(str);
        if (num != null) {
            textView.setTextColor(num.intValue());
        }
    }

    @NotNull
    public static final CustomTarget<Drawable> loadImage(@NotNull ImageView imageView, @NotNull String str, @NotNull Function1<? super RequestBuilder<Drawable>, ? extends RequestBuilder<Drawable>> function1) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(str, ObservableAttributesNames.IMAGE_URL_V2);
        Intrinsics.checkNotNullParameter(function1, "builder");
        RequestBuilder<Drawable> load = Glide.with(imageView.getContext()).load(str);
        Intrinsics.checkNotNullExpressionValue(load, "with(context).load(imageUrl)");
        Target into = ((RequestBuilder) function1.invoke(load)).into(new ExtensionsKt$loadImage$4(imageView));
        Intrinsics.checkNotNullExpressionValue(into, "ImageView.loadImage(\n   …er: Drawable?) {\n    }\n})");
        return (CustomTarget) into;
    }

    public static /* synthetic */ CustomTarget loadImage$default(ImageView imageView, String str, Function1 function1, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            function1 = ExtensionsKt$loadImage$3.INSTANCE;
        }
        return loadImage(imageView, str, (Function1<? super RequestBuilder<Drawable>, ? extends RequestBuilder<Drawable>>) function1);
    }

    public static final void setDsMarshMallowColor(@NotNull View view, @NotNull String str) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(str, "colorCode");
        Integer num = DSColorProvider.INSTANCE.getMarshmallowColorMap().get(str);
        if (num != null) {
            int intValue = num.intValue();
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            view.setBackground(CreateGradientDrawableKt.createGradientDrawable(context, intValue));
        }
    }
}
