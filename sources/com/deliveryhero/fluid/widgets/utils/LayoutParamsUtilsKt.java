package com.deliveryhero.fluid.widgets.utils;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.core.view.GravityCompat;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.ViewCompat;
import com.deliveryhero.fluid.telemetry.log.LogLevel;
import com.deliveryhero.fluid.telemetry.log.Logger;
import com.deliveryhero.fluid.values.Size;
import com.deliveryhero.fluid.widgets.containers.EnhancedLinearLayout;
import com.deliveryhero.fluid.widgets.containers.HorizontalAlignment;
import com.deliveryhero.fluid.widgets.containers.VerticalAlignment;
import com.talabat.wallet.bnplmanager.domain.tracking.event.BnplFakeTestSubmissionEventKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a(\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0000\u001a@\u0010\n\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\n\u0010\u000b\u001a\u00060\fj\u0002`\r2\n\u0010\u000e\u001a\u00060\fj\u0002`\r2\n\u0010\u000f\u001a\u00060\fj\u0002`\r2\n\u0010\u0010\u001a\u00060\fj\u0002`\rH\u0000\u001a \u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\fH\u0000\u001a\u001a\u0010\u0014\u001a\u00020\f*\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\f\u001ax\u0010\u0019\u001a\u00020\u001a*\u00060\u001bj\u0002`\u001c2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\t2\n\u0010\u000b\u001a\u00060\fj\u0002`\r2\n\u0010\u000e\u001a\u00060\fj\u0002`\r2\n\u0010\u000f\u001a\u00060\fj\u0002`\r2\n\u0010\u0010\u001a\u00060\fj\u0002`\rH\u0000\u001a(\u0010!\u001a\u00020\u0001*\u00060\u001bj\u0002`\u001c2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u0015H\u0000¨\u0006\""}, d2 = {"updateAlignments", "", "logger", "Lcom/deliveryhero/fluid/telemetry/log/Logger;", "layoutParams", "Landroid/view/ViewGroup$MarginLayoutParams;", "horizontal", "Lcom/deliveryhero/fluid/widgets/containers/HorizontalAlignment;", "vertical", "Lcom/deliveryhero/fluid/widgets/containers/VerticalAlignment;", "updateMargins", "marginLeading", "", "Lcom/deliveryhero/fluid/values/PixelInt;", "marginTop", "marginTrailing", "marginBottom", "updateResistances", "expansionResistancePriority", "compressionResistancePriority", "toLayoutSize", "Lcom/deliveryhero/fluid/values/Size;", "context", "Landroid/content/Context;", "containerSize", "updateLayoutParams", "", "Landroid/view/View;", "Lcom/deliveryhero/fluid/widgets/Widget;", "width", "height", "horizontalAlignment", "verticalAlignment", "updateSize", "core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class LayoutParamsUtilsKt {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[HorizontalAlignment.values().length];
            iArr[HorizontalAlignment.LEADING.ordinal()] = 1;
            iArr[HorizontalAlignment.CENTER.ordinal()] = 2;
            iArr[HorizontalAlignment.TRAILING.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[VerticalAlignment.values().length];
            iArr2[VerticalAlignment.TOP.ordinal()] = 1;
            iArr2[VerticalAlignment.CENTER.ordinal()] = 2;
            iArr2[VerticalAlignment.BOTTOM.ordinal()] = 3;
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public static final int toLayoutSize(@NotNull Size size, @NotNull Context context, int i11) {
        Intrinsics.checkNotNullParameter(size, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        if (Intrinsics.areEqual((Object) size, (Object) Size.WrapContent.INSTANCE)) {
            return -2;
        }
        if (Intrinsics.areEqual((Object) size, (Object) Size.MatchParent.INSTANCE)) {
            return -1;
        }
        if (size instanceof Size.Absolute) {
            return (int) TypedValue.applyDimension(1, ((Size.Absolute) size).getValue().getValue(), context.getResources().getDisplayMetrics());
        }
        if (size instanceof Size.Relative) {
            return (int) (((float) i11) * ((Size.Relative) size).getPercentFractional());
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final boolean updateAlignments(@NotNull Logger logger, @NotNull ViewGroup.MarginLayoutParams marginLayoutParams, @NotNull HorizontalAlignment horizontalAlignment, @NotNull VerticalAlignment verticalAlignment) {
        int i11;
        int i12;
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(marginLayoutParams, "layoutParams");
        Intrinsics.checkNotNullParameter(horizontalAlignment, "horizontal");
        Intrinsics.checkNotNullParameter(verticalAlignment, BnplFakeTestSubmissionEventKt.ATTRIBUTE_KEY_VERTICAL);
        int i13 = WhenMappings.$EnumSwitchMapping$0[horizontalAlignment.ordinal()];
        if (i13 == 1) {
            i11 = GravityCompat.START;
        } else if (i13 == 2) {
            i11 = 1;
        } else if (i13 == 3) {
            i11 = GravityCompat.END;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        int i14 = WhenMappings.$EnumSwitchMapping$1[verticalAlignment.ordinal()];
        if (i14 == 1) {
            i12 = 48;
        } else if (i14 == 2) {
            i12 = 16;
        } else if (i14 == 3) {
            i12 = 80;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        int i15 = i11 | i12;
        if (marginLayoutParams instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) marginLayoutParams;
            if (layoutParams.gravity != i15) {
                layoutParams.gravity = i15;
                return true;
            }
        } else if (marginLayoutParams instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) marginLayoutParams;
            if (layoutParams2.gravity != i15) {
                layoutParams2.gravity = i15;
                return true;
            }
        } else {
            LogLevel logLevel = LogLevel.WARNING;
            if (logLevel.compareTo(logger.getMinimumLevel()) >= 0) {
                Logger.log$default(logger, logger.getTag(), logLevel, "Alignment is unsupported for `" + marginLayoutParams.getClass().getName() + "` class", (Throwable) null, (Pair[]) null, 24, (Object) null);
            }
        }
        return false;
    }

    public static final void updateLayoutParams(@NotNull View view, @NotNull Logger logger, @NotNull Size size, @NotNull Size size2, int i11, int i12, @NotNull HorizontalAlignment horizontalAlignment, @NotNull VerticalAlignment verticalAlignment, int i13, int i14, int i15, int i16) {
        View view2 = view;
        Size size3 = size;
        Size size4 = size2;
        Intrinsics.checkNotNullParameter(view2, "<this>");
        Logger logger2 = logger;
        Intrinsics.checkNotNullParameter(logger2, "logger");
        Intrinsics.checkNotNullParameter(size3, "width");
        Intrinsics.checkNotNullParameter(size4, "height");
        HorizontalAlignment horizontalAlignment2 = horizontalAlignment;
        Intrinsics.checkNotNullParameter(horizontalAlignment2, "horizontalAlignment");
        VerticalAlignment verticalAlignment2 = verticalAlignment;
        Intrinsics.checkNotNullParameter(verticalAlignment2, "verticalAlignment");
        LayoutParamsUtilsKt$updateLayoutParams$setLayoutProps$1 layoutParamsUtilsKt$updateLayoutParams$setLayoutProps$1 = r0;
        LayoutParamsUtilsKt$updateLayoutParams$setLayoutProps$1 layoutParamsUtilsKt$updateLayoutParams$setLayoutProps$12 = new LayoutParamsUtilsKt$updateLayoutParams$setLayoutProps$1(view, size, size2, logger2, horizontalAlignment2, verticalAlignment2, i13, i14, i15, i16, i11, i12);
        if ((size3 instanceof Size.Relative) || (size4 instanceof Size.Relative)) {
            Intrinsics.checkNotNullExpressionValue(OneShotPreDrawListener.add(view2, new LayoutParamsUtilsKt$updateLayoutParams$$inlined$doOnPreDraw$1(layoutParamsUtilsKt$updateLayoutParams$setLayoutProps$1, view2)), "View.doOnPreDraw(\n    crossinline action: (view: View) -> Unit\n): OneShotPreDrawListener = OneShotPreDrawListener.add(this) { action(this) }");
        } else if (ViewCompat.isAttachedToWindow(view)) {
            layoutParamsUtilsKt$updateLayoutParams$setLayoutProps$1.invoke(view2);
        } else {
            view2.addOnAttachStateChangeListener(new LayoutParamsUtilsKt$updateLayoutParams$$inlined$doOnAttach$1(view2, layoutParamsUtilsKt$updateLayoutParams$setLayoutProps$1));
        }
    }

    public static final boolean updateMargins(@NotNull ViewGroup.MarginLayoutParams marginLayoutParams, int i11, int i12, int i13, int i14) {
        Intrinsics.checkNotNullParameter(marginLayoutParams, "layoutParams");
        if (i11 == marginLayoutParams.getMarginStart() && i12 == marginLayoutParams.topMargin && i13 == marginLayoutParams.getMarginEnd() && i14 == marginLayoutParams.bottomMargin) {
            return false;
        }
        marginLayoutParams.setMarginStart(i11);
        marginLayoutParams.topMargin = i12;
        marginLayoutParams.setMarginEnd(i13);
        marginLayoutParams.bottomMargin = i14;
        return true;
    }

    public static final boolean updateResistances(@NotNull ViewGroup.MarginLayoutParams marginLayoutParams, int i11, int i12) {
        Intrinsics.checkNotNullParameter(marginLayoutParams, "layoutParams");
        if (!(marginLayoutParams instanceof EnhancedLinearLayout.LayoutParams)) {
            return false;
        }
        EnhancedLinearLayout.LayoutParams layoutParams = (EnhancedLinearLayout.LayoutParams) marginLayoutParams;
        if (layoutParams.getExpansionResistancePriority() == i11 && layoutParams.getCompressionResistancePriority() == i12) {
            return false;
        }
        layoutParams.setExpansionResistancePriority(i11);
        layoutParams.setCompressionResistancePriority(i12);
        return true;
    }

    public static final boolean updateSize(@NotNull View view, @NotNull ViewGroup.MarginLayoutParams marginLayoutParams, @NotNull Size size, @NotNull Size size2) {
        ViewGroup viewGroup;
        int i11;
        int i12;
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(marginLayoutParams, "layoutParams");
        Intrinsics.checkNotNullParameter(size, "width");
        Intrinsics.checkNotNullParameter(size2, "height");
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            viewGroup = (ViewGroup) parent;
        } else {
            viewGroup = null;
        }
        if (viewGroup != null) {
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            i11 = toLayoutSize(size, context, (viewGroup.getWidth() - viewGroup.getPaddingLeft()) - viewGroup.getPaddingRight());
            Context context2 = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            i12 = toLayoutSize(size2, context2, (viewGroup.getHeight() - viewGroup.getPaddingTop()) - viewGroup.getPaddingBottom());
        } else {
            Context context3 = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context3, "context");
            i11 = toLayoutSize(size, context3, 0);
            Context context4 = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context4, "context");
            i12 = toLayoutSize(size2, context4, 0);
        }
        if (i11 == marginLayoutParams.width && i12 == marginLayoutParams.height) {
            return false;
        }
        marginLayoutParams.width = i11;
        marginLayoutParams.height = i12;
        return true;
    }
}
