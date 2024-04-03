package com.braze.ui.inappmessage.views;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.appboy.ui.R;
import com.braze.enums.inappmessage.ImageStyle;
import com.braze.models.inappmessage.IInAppMessageImmersive;
import com.braze.models.inappmessage.InAppMessageModal;
import com.braze.support.BrazeLogger;
import com.braze.ui.inappmessage.config.BrazeInAppMessageParams;
import com.braze.ui.inappmessage.utils.InAppMessageViewUtils;
import com.braze.ui.support.ViewUtils;
import d4.d;
import d4.e;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010+\u001a\u00020,2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0016\u0010-\u001a\b\u0012\u0004\u0012\u00020\b0.2\u0006\u0010/\u001a\u000200H\u0016J0\u00101\u001a\u00020,2\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u0002002\u0006\u00105\u001a\u0002002\u0006\u00106\u001a\u0002002\u0006\u00107\u001a\u000200H\u0014J\u0010\u00108\u001a\u00020,2\u0006\u00109\u001a\u000203H\u0016J\u001a\u0010:\u001a\u00020,2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0014J \u0010;\u001a\u00020,2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020<2\u0006\u0010\u0011\u001a\u00020=H\u0014J\u0010\u0010>\u001a\u00020,2\u0006\u0010?\u001a\u000200H\u0016R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u00188VX\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001b\u001a\u0004\u0018\u00010\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\nR\u0016\u0010\u001d\u001a\u0004\u0018\u00010\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\nR\u0016\u0010\u001f\u001a\u0004\u0018\u00010 8VX\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0016\u0010#\u001a\u0004\u0018\u00010 8VX\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\"R\u0016\u0010%\u001a\u0004\u0018\u00010&8VX\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0016\u0010)\u001a\u0004\u0018\u00010 8VX\u0004¢\u0006\u0006\u001a\u0004\b*\u0010\"¨\u0006@"}, d2 = {"Lcom/braze/ui/inappmessage/views/InAppMessageModalView;", "Lcom/braze/ui/inappmessage/views/InAppMessageImmersiveBaseView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "frameView", "Landroid/view/View;", "getFrameView", "()Landroid/view/View;", "inAppMessage", "Lcom/braze/models/inappmessage/InAppMessageModal;", "getInAppMessage", "()Lcom/braze/models/inappmessage/InAppMessageModal;", "setInAppMessage", "(Lcom/braze/models/inappmessage/InAppMessageModal;)V", "inAppMessageImageView", "Lcom/braze/ui/inappmessage/views/InAppMessageImageView;", "getInAppMessageImageView", "()Lcom/braze/ui/inappmessage/views/InAppMessageImageView;", "setInAppMessageImageView", "(Lcom/braze/ui/inappmessage/views/InAppMessageImageView;)V", "messageBackgroundObject", "Landroid/graphics/drawable/Drawable;", "getMessageBackgroundObject", "()Landroid/graphics/drawable/Drawable;", "messageClickableView", "getMessageClickableView", "messageCloseButtonView", "getMessageCloseButtonView", "messageHeaderTextView", "Landroid/widget/TextView;", "getMessageHeaderTextView", "()Landroid/widget/TextView;", "messageIconView", "getMessageIconView", "messageImageView", "Landroid/widget/ImageView;", "getMessageImageView", "()Landroid/widget/ImageView;", "messageTextView", "getMessageTextView", "applyInAppMessageParameters", "", "getMessageButtonViews", "", "numButtons", "", "onLayout", "changed", "", "left", "top", "right", "bottom", "resetMessageMargins", "imageRetrievalSuccessful", "resizeGraphicFrameIfAppropriate", "setInAppMessageImageViewAttributes", "Lcom/braze/models/inappmessage/IInAppMessageImmersive;", "Lcom/braze/ui/inappmessage/views/IInAppMessageImageView;", "setMessageBackgroundColor", "color", "android-sdk-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class InAppMessageModalView extends InAppMessageImmersiveBaseView {
    @Nullable
    private InAppMessageModal inAppMessage;
    @Nullable
    private InAppMessageImageView inAppMessageImageView;

    public InAppMessageModalView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: private */
    /* renamed from: resetMessageMargins$lambda-0  reason: not valid java name */
    public static final void m9221resetMessageMargins$lambda0(InAppMessageModalView inAppMessageModalView, View view) {
        Intrinsics.checkNotNullParameter(inAppMessageModalView, "this$0");
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) inAppMessageModalView, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) InAppMessageModalView$resetMessageMargins$1$1.INSTANCE, 7, (Object) null);
        View messageClickableView = inAppMessageModalView.getMessageClickableView();
        if (messageClickableView != null) {
            messageClickableView.performClick();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: resizeGraphicFrameIfAppropriate$lambda-2  reason: not valid java name */
    public static final void m9222resizeGraphicFrameIfAppropriate$lambda2(InAppMessageModalView inAppMessageModalView, int i11, int i12, int i13, double d11) {
        Intrinsics.checkNotNullParameter(inAppMessageModalView, "this$0");
        double min = (double) Math.min(inAppMessageModalView.getMeasuredWidth() - i11, i12);
        double min2 = (double) Math.min(inAppMessageModalView.getMeasuredHeight() - i11, i13);
        double d12 = min / min2;
        View findViewById = inAppMessageModalView.findViewById(R.id.com_braze_inappmessage_modal_graphic_bound);
        if (findViewById != null) {
            ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
            if (layoutParams != null) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                if (d11 >= d12) {
                    layoutParams2.width = (int) min;
                    layoutParams2.height = (int) (min / d11);
                } else {
                    layoutParams2.width = (int) (d11 * min2);
                    layoutParams2.height = (int) min2;
                }
                findViewById.setLayoutParams(layoutParams2);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        }
    }

    public void applyInAppMessageParameters(@NotNull Context context, @NotNull InAppMessageModal inAppMessageModal) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(inAppMessageModal, "inAppMessage");
        this.inAppMessage = inAppMessageModal;
        InAppMessageImageView inAppMessageImageView2 = (InAppMessageImageView) findViewById(R.id.com_braze_inappmessage_modal_imageview);
        this.inAppMessageImageView = inAppMessageImageView2;
        if (inAppMessageImageView2 != null) {
            setInAppMessageImageViewAttributes(context, inAppMessageModal, inAppMessageImageView2);
        }
        resizeGraphicFrameIfAppropriate(context, inAppMessageModal);
    }

    @Nullable
    public View getFrameView() {
        return findViewById(R.id.com_braze_inappmessage_modal_frame);
    }

    @Nullable
    public final InAppMessageModal getInAppMessage() {
        return this.inAppMessage;
    }

    @Nullable
    public final InAppMessageImageView getInAppMessageImageView() {
        return this.inAppMessageImageView;
    }

    @NotNull
    public List<View> getMessageButtonViews(int i11) {
        ArrayList arrayList = new ArrayList();
        if (i11 == 1) {
            View findViewById = findViewById(R.id.com_braze_inappmessage_modal_button_layout_single);
            if (findViewById != null) {
                findViewById.setVisibility(0);
            }
            View findViewById2 = findViewById(R.id.com_braze_inappmessage_modal_button_single_one);
            if (findViewById2 != null) {
                arrayList.add(findViewById2);
            }
        } else if (i11 == 2) {
            View findViewById3 = findViewById(R.id.com_braze_inappmessage_modal_button_layout_dual);
            if (findViewById3 != null) {
                findViewById3.setVisibility(0);
            }
            View findViewById4 = findViewById(R.id.com_braze_inappmessage_modal_button_dual_one);
            View findViewById5 = findViewById(R.id.com_braze_inappmessage_modal_button_dual_two);
            if (findViewById4 != null) {
                arrayList.add(findViewById4);
            }
            if (findViewById5 != null) {
                arrayList.add(findViewById5);
            }
        }
        return arrayList;
    }

    @Nullable
    public View getMessageClickableView() {
        return findViewById(R.id.com_braze_inappmessage_modal);
    }

    @Nullable
    public View getMessageCloseButtonView() {
        return findViewById(R.id.com_braze_inappmessage_modal_close_button);
    }

    @Nullable
    public TextView getMessageHeaderTextView() {
        return (TextView) findViewById(R.id.com_braze_inappmessage_modal_header_text);
    }

    @Nullable
    public TextView getMessageIconView() {
        return (TextView) findViewById(R.id.com_braze_inappmessage_modal_icon);
    }

    @Nullable
    public ImageView getMessageImageView() {
        return this.inAppMessageImageView;
    }

    @Nullable
    public TextView getMessageTextView() {
        return (TextView) findViewById(R.id.com_braze_inappmessage_modal_message);
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        super.onLayout(z11, i11, i12, i13, i14);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "this.context");
        resizeGraphicFrameIfAppropriate(context, this.inAppMessage);
    }

    public void resetMessageMargins(boolean z11) {
        super.resetMessageMargins(z11);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.com_braze_inappmessage_modal_image_layout);
        if ((z11 || getMessageIconView() != null) && relativeLayout != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(0, 0, 0, 0);
            relativeLayout.setLayoutParams(layoutParams);
        }
        View findViewById = findViewById(R.id.com_braze_inappmessage_modal_text_layout);
        if (findViewById != null) {
            findViewById.setOnClickListener(new e(this));
        }
    }

    public void resizeGraphicFrameIfAppropriate(@NotNull Context context, @Nullable InAppMessageModal inAppMessageModal) {
        Bitmap bitmap;
        Intrinsics.checkNotNullParameter(context, "context");
        if (inAppMessageModal == null) {
            bitmap = null;
        } else {
            bitmap = inAppMessageModal.getBitmap();
        }
        if (bitmap != null && inAppMessageModal.getImageStyle() == ImageStyle.GRAPHIC) {
            Resources resources = context.getResources();
            post(new d(this, resources.getDimensionPixelSize(R.dimen.com_braze_inappmessage_modal_margin), resources.getDimensionPixelSize(R.dimen.com_braze_inappmessage_modal_max_width), resources.getDimensionPixelSize(R.dimen.com_braze_inappmessage_modal_max_height), ((double) bitmap.getWidth()) / ((double) bitmap.getHeight())));
        }
    }

    public final void setInAppMessage(@Nullable InAppMessageModal inAppMessageModal) {
        this.inAppMessage = inAppMessageModal;
    }

    public final void setInAppMessageImageView(@Nullable InAppMessageImageView inAppMessageImageView2) {
        this.inAppMessageImageView = inAppMessageImageView2;
    }

    public void setInAppMessageImageViewAttributes(@NotNull Context context, @NotNull IInAppMessageImmersive iInAppMessageImmersive, @NotNull IInAppMessageImageView iInAppMessageImageView) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(iInAppMessageImmersive, "inAppMessage");
        Intrinsics.checkNotNullParameter(iInAppMessageImageView, "inAppMessageImageView");
        float convertDpToPixels = (float) ViewUtils.convertDpToPixels(context, BrazeInAppMessageParams.getModalizedImageRadiusDp());
        if (iInAppMessageImmersive.getImageStyle() == ImageStyle.GRAPHIC) {
            iInAppMessageImageView.setCornersRadiusPx(convertDpToPixels);
        } else {
            iInAppMessageImageView.setCornersRadiiPx(convertDpToPixels, convertDpToPixels, 0.0f, 0.0f);
        }
        iInAppMessageImageView.setInAppMessageImageCropType(iInAppMessageImmersive.getCropType());
    }

    public void setMessageBackgroundColor(int i11) {
        View findViewById = findViewById(R.id.com_braze_inappmessage_modal);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.com_braze_inappmessage_modal)");
        InAppMessageViewUtils.setViewBackgroundColorFilter(findViewById, i11);
    }

    @Nullable
    public Drawable getMessageBackgroundObject() {
        View messageClickableView = getMessageClickableView();
        if (messageClickableView == null) {
            return null;
        }
        return messageClickableView.getBackground();
    }
}
