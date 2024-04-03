package com.braze.ui.inappmessage.utils;

import android.animation.StateListAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import android.widget.Button;
import com.appboy.ui.R;
import com.braze.models.inappmessage.MessageButton;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0007J\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\nH\u0007J(\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0007J$\u0010\u0015\u001a\u00020\u00112\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\u0017H\u0007¨\u0006\u001a"}, d2 = {"Lcom/braze/ui/inappmessage/utils/InAppMessageButtonViewUtils;", "", "()V", "getButtonDrawable", "Landroid/graphics/drawable/Drawable;", "context", "Landroid/content/Context;", "messageButton", "Lcom/braze/models/inappmessage/MessageButton;", "newStrokeWidth", "", "strokeFocusedWidth", "isFocused", "", "getDrawable", "drawableId", "setButton", "", "button", "Landroid/widget/Button;", "strokeWidth", "setButtons", "buttonViews", "", "Landroid/view/View;", "messageButtons", "android-sdk-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class InAppMessageButtonViewUtils {
    @NotNull
    public static final InAppMessageButtonViewUtils INSTANCE = new InAppMessageButtonViewUtils();

    private InAppMessageButtonViewUtils() {
    }

    @JvmStatic
    @NotNull
    public static final Drawable getButtonDrawable(@NotNull Context context, @NotNull MessageButton messageButton, int i11, int i12, boolean z11) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(messageButton, "messageButton");
        Drawable drawable = getDrawable(context, R.drawable.com_braze_inappmessage_button_background);
        drawable.mutate();
        Drawable findDrawableByLayerId = ((RippleDrawable) drawable).findDrawableByLayerId(R.id.com_braze_inappmessage_button_background_ripple_internal_gradient);
        if (findDrawableByLayerId != null) {
            GradientDrawable gradientDrawable = (GradientDrawable) findDrawableByLayerId;
            if (z11) {
                i11 = i12;
            }
            gradientDrawable.setStroke(i11, messageButton.getBorderColor());
            gradientDrawable.setColor(messageButton.getBackgroundColor());
            return drawable;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
    }

    @JvmStatic
    @NotNull
    public static final Drawable getDrawable(@NotNull Context context, int i11) {
        Intrinsics.checkNotNullParameter(context, "context");
        Drawable drawable = context.getResources().getDrawable(i11);
        Intrinsics.checkNotNullExpressionValue(drawable, "context.resources.getDrawable(drawableId)");
        return drawable;
    }

    @JvmStatic
    public static final void setButton(@NotNull Button button, @NotNull MessageButton messageButton, int i11, int i12) {
        Intrinsics.checkNotNullParameter(button, "button");
        Intrinsics.checkNotNullParameter(messageButton, "messageButton");
        button.setText(messageButton.getText());
        button.setContentDescription(messageButton.getText());
        InAppMessageViewUtils.setTextViewColor(button, messageButton.getTextColor());
        StateListDrawable stateListDrawable = new StateListDrawable();
        button.setStateListAnimator((StateListAnimator) null);
        Context context = button.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "button.context");
        Drawable buttonDrawable = getButtonDrawable(context, messageButton, i11, i12, false);
        Context context2 = button.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "button.context");
        Drawable buttonDrawable2 = getButtonDrawable(context2, messageButton, i11, i12, true);
        stateListDrawable.addState(new int[]{16842908}, buttonDrawable2);
        stateListDrawable.addState(new int[]{16842910}, buttonDrawable);
        button.setBackground(stateListDrawable);
    }

    @JvmStatic
    public static final void setButtons(@NotNull List<? extends View> list, @NotNull List<? extends MessageButton> list2) {
        Intrinsics.checkNotNullParameter(list, "buttonViews");
        Intrinsics.checkNotNullParameter(list2, "messageButtons");
        int size = list.size();
        int i11 = 0;
        while (i11 < size) {
            int i12 = i11 + 1;
            View view = (View) list.get(i11);
            MessageButton messageButton = (MessageButton) list2.get(i11);
            int dimensionPixelSize = view.getContext().getResources().getDimensionPixelSize(R.dimen.com_braze_inappmessage_button_border_stroke);
            int dimensionPixelSize2 = view.getContext().getResources().getDimensionPixelSize(R.dimen.com_braze_inappmessage_button_border_stroke_focused);
            if (list2.size() <= i11) {
                view.setVisibility(8);
            } else if (view instanceof Button) {
                setButton((Button) view, messageButton, dimensionPixelSize, dimensionPixelSize2);
            }
            i11 = i12;
        }
    }
}
