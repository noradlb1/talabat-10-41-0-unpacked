package com.braze.ui.inappmessage.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.WindowInsetsCompat;
import com.braze.enums.inappmessage.TextAlign;
import com.braze.models.inappmessage.IInAppMessageWithImage;
import com.braze.support.BrazeLogger;
import com.braze.ui.inappmessage.utils.InAppMessageViewUtils;
import com.braze.ui.support.ViewUtils;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000 72\u00020\u00012\u00020\u0002:\u00017B\u0019\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0016J\u0010\u0010$\u001a\u00020!2\u0006\u0010%\u001a\u00020\tH\u0016J\u0010\u0010&\u001a\u00020!2\u0006\u0010'\u001a\u00020(H\u0016J\u0010\u0010)\u001a\u00020!2\u0006\u0010*\u001a\u00020+H\u0016J \u0010,\u001a\u00020!2\u0006\u0010-\u001a\u00020(2\u0006\u0010.\u001a\u00020+2\u0006\u0010/\u001a\u00020+H\u0016J\u0010\u00100\u001a\u00020!2\u0006\u00101\u001a\u000202H\u0016J\u0010\u00103\u001a\u00020!2\u0006\u00104\u001a\u000205H\u0016J\u0010\u00106\u001a\u00020!2\u0006\u0010*\u001a\u00020+H\u0016R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u00138VX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u0004\u0018\u00010\u0017X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u0004\u0018\u00010\u001bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u0004\u0018\u00010\u0017X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0019¨\u00068"}, d2 = {"Lcom/braze/ui/inappmessage/views/InAppMessageBaseView;", "Landroid/widget/RelativeLayout;", "Lcom/braze/ui/inappmessage/views/IInAppMessageView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "hasAppliedWindowInsets", "", "getHasAppliedWindowInsets", "()Z", "setHasAppliedWindowInsets", "(Z)V", "messageBackgroundObject", "", "getMessageBackgroundObject", "()Ljava/lang/Object;", "messageClickableView", "Landroid/view/View;", "getMessageClickableView", "()Landroid/view/View;", "messageIconView", "Landroid/widget/TextView;", "getMessageIconView", "()Landroid/widget/TextView;", "messageImageView", "Landroid/widget/ImageView;", "getMessageImageView", "()Landroid/widget/ImageView;", "messageTextView", "getMessageTextView", "applyWindowInsets", "", "insets", "Landroidx/core/view/WindowInsetsCompat;", "resetMessageMargins", "imageRetrievalSuccessful", "setMessage", "text", "", "setMessageBackgroundColor", "color", "", "setMessageIcon", "icon", "iconColor", "iconBackgroundColor", "setMessageImageView", "bitmap", "Landroid/graphics/Bitmap;", "setMessageTextAlign", "textAlign", "Lcom/braze/enums/inappmessage/TextAlign;", "setMessageTextColor", "Companion", "android-sdk-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class InAppMessageBaseView extends RelativeLayout implements IInAppMessageView {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private boolean hasAppliedWindowInsets;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/braze/ui/inappmessage/views/InAppMessageBaseView$Companion;", "", "()V", "getAppropriateImageUrl", "", "inAppMessage", "Lcom/braze/models/inappmessage/IInAppMessageWithImage;", "android-sdk-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @Nullable
        public final String getAppropriateImageUrl(@NotNull IInAppMessageWithImage iInAppMessageWithImage) {
            boolean z11;
            Intrinsics.checkNotNullParameter(iInAppMessageWithImage, "inAppMessage");
            String localImageUrl = iInAppMessageWithImage.getLocalImageUrl();
            if (localImageUrl == null || StringsKt__StringsJVMKt.isBlank(localImageUrl)) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z11) {
                if (new File(localImageUrl).exists()) {
                    return localImageUrl;
                }
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.D, (Throwable) null, false, (Function0) new InAppMessageBaseView$Companion$getAppropriateImageUrl$1(localImageUrl), 6, (Object) null);
            }
            return iInAppMessageWithImage.getRemoteImageUrl();
        }
    }

    public InAppMessageBaseView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @JvmStatic
    @Nullable
    public static final String getAppropriateImageUrl(@NotNull IInAppMessageWithImage iInAppMessageWithImage) {
        return Companion.getAppropriateImageUrl(iInAppMessageWithImage);
    }

    public void applyWindowInsets(@NotNull WindowInsetsCompat windowInsetsCompat) {
        Intrinsics.checkNotNullParameter(windowInsetsCompat, "insets");
        setHasAppliedWindowInsets(true);
    }

    public boolean getHasAppliedWindowInsets() {
        return this.hasAppliedWindowInsets;
    }

    @Nullable
    public abstract Object getMessageBackgroundObject();

    @Nullable
    public View getMessageClickableView() {
        return this;
    }

    @Nullable
    public abstract TextView getMessageIconView();

    @Nullable
    public abstract ImageView getMessageImageView();

    @Nullable
    public abstract TextView getMessageTextView();

    public void resetMessageMargins(boolean z11) {
        CharSequence text;
        String obj;
        ImageView messageImageView = getMessageImageView();
        if (messageImageView != null) {
            if (!z11) {
                ViewUtils.removeViewFromParent(messageImageView);
            } else {
                ViewUtils.removeViewFromParent(getMessageIconView());
            }
        }
        TextView messageIconView = getMessageIconView();
        boolean z12 = false;
        if (!(messageIconView == null || (text = messageIconView.getText()) == null || (obj = text.toString()) == null || !StringsKt__StringsJVMKt.isBlank(obj))) {
            z12 = true;
        }
        if (z12) {
            ViewUtils.removeViewFromParent(getMessageIconView());
        }
    }

    public void setHasAppliedWindowInsets(boolean z11) {
        this.hasAppliedWindowInsets = z11;
    }

    public void setMessage(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        TextView messageTextView = getMessageTextView();
        if (messageTextView != null) {
            messageTextView.setText(str);
        }
    }

    public void setMessageBackgroundColor(int i11) {
        Object messageBackgroundObject = getMessageBackgroundObject();
        if (messageBackgroundObject != null) {
            InAppMessageViewUtils.setViewBackgroundColor((View) messageBackgroundObject, i11);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
    }

    public void setMessageIcon(@NotNull String str, int i11, int i12) {
        Intrinsics.checkNotNullParameter(str, "icon");
        TextView messageIconView = getMessageIconView();
        if (messageIconView != null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            InAppMessageViewUtils.setIcon(context, str, i11, i12, messageIconView);
        }
    }

    public void setMessageImageView(@NotNull Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        ImageView messageImageView = getMessageImageView();
        if (messageImageView != null) {
            InAppMessageViewUtils.setImage(bitmap, messageImageView);
        }
    }

    public void setMessageTextAlign(@NotNull TextAlign textAlign) {
        Intrinsics.checkNotNullParameter(textAlign, TtmlNode.ATTR_TTS_TEXT_ALIGN);
        TextView messageTextView = getMessageTextView();
        if (messageTextView != null) {
            InAppMessageViewUtils.setTextAlignment(messageTextView, textAlign);
        }
    }

    public void setMessageTextColor(int i11) {
        TextView messageTextView = getMessageTextView();
        if (messageTextView != null) {
            InAppMessageViewUtils.setTextViewColor(messageTextView, i11);
        }
    }
}
