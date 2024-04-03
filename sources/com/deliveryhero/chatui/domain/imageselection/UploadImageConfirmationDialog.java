package com.deliveryhero.chatui.domain.imageselection;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AlertDialog;
import com.deliveryhero.contract.ChatLogger;
import com.deliveryhero.contract.model.Events;
import com.deliveryhero.customerchat.R;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import o4.a;
import o4.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 &2\u00020\u0001:\u0002&'B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u001aJ\b\u0010\u001b\u001a\u00020\u0017H\u0002J\b\u0010\u001c\u001a\u00020\u0017H\u0002J \u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u0010H\u0003J\u0012\u0010\"\u001a\u00020\u00172\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0007J\u0010\u0010#\u001a\u00020\u00172\u0006\u0010$\u001a\u00020%H\u0002R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X.¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/deliveryhero/chatui/domain/imageselection/UploadImageConfirmationDialog;", "", "context", "Landroid/content/Context;", "chatLogger", "Lcom/deliveryhero/contract/ChatLogger;", "(Landroid/content/Context;Lcom/deliveryhero/contract/ChatLogger;)V", "getChatLogger", "()Lcom/deliveryhero/contract/ChatLogger;", "getContext", "()Landroid/content/Context;", "convertView", "Landroid/view/View;", "dialog", "Landroidx/appcompat/app/AlertDialog;", "imageFailedDrawableRes", "", "imageLoadingDrawableRes", "selectedImage", "Landroid/widget/ImageView;", "sendButton", "Landroid/widget/Button;", "bind", "", "requestCode", "sendListener", "Lcom/deliveryhero/chatui/domain/imageselection/UploadImageConfirmationDialog$SendListener;", "dismissDialog", "loadErrorImage", "loadImage", "imagePath", "", "targetWidth", "targetHeight", "showImage", "toggleSendButton", "enable", "", "Companion", "SendListener", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UploadImageConfirmationDialog {
    public static final float BUTTON_ALPHA_DISABLED = 0.5f;
    public static final float BUTTON_ALPHA_ENABLED = 1.0f;
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Nullable
    private final ChatLogger chatLogger;
    @NotNull
    private final Context context;
    @NotNull
    private View convertView;
    @NotNull
    private final AlertDialog dialog;
    private final int imageFailedDrawableRes = R.drawable.customer_chat_ic_error;
    private final int imageLoadingDrawableRes = R.drawable.customer_chat_loading_spinner;
    private ImageView selectedImage;
    private Button sendButton;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/deliveryhero/chatui/domain/imageselection/UploadImageConfirmationDialog$Companion;", "", "()V", "BUTTON_ALPHA_DISABLED", "", "BUTTON_ALPHA_ENABLED", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007"}, d2 = {"Lcom/deliveryhero/chatui/domain/imageselection/UploadImageConfirmationDialog$SendListener;", "", "onCancel", "", "onSend", "requestCode", "", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface SendListener {
        void onCancel();

        void onSend(int i11);
    }

    public UploadImageConfirmationDialog(@NotNull Context context2, @Nullable ChatLogger chatLogger2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
        this.chatLogger = chatLogger2;
        View inflate = View.inflate(context2, R.layout.customer_chat_layout_image_confirmation, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(context, R.layou…image_confirmation, null)");
        this.convertView = inflate;
        AlertDialog create = new AlertDialog.Builder(context2).create();
        Intrinsics.checkNotNullExpressionValue(create, "Builder(context).create()");
        this.dialog = create;
    }

    /* access modifiers changed from: private */
    /* renamed from: bind$lambda-0  reason: not valid java name */
    public static final void m8146bind$lambda0(SendListener sendListener, UploadImageConfirmationDialog uploadImageConfirmationDialog, View view) {
        Intrinsics.checkNotNullParameter(sendListener, "$sendListener");
        Intrinsics.checkNotNullParameter(uploadImageConfirmationDialog, "this$0");
        sendListener.onCancel();
        uploadImageConfirmationDialog.dismissDialog();
    }

    /* access modifiers changed from: private */
    /* renamed from: bind$lambda-1  reason: not valid java name */
    public static final void m8147bind$lambda1(SendListener sendListener, int i11, UploadImageConfirmationDialog uploadImageConfirmationDialog, View view) {
        Intrinsics.checkNotNullParameter(sendListener, "$sendListener");
        Intrinsics.checkNotNullParameter(uploadImageConfirmationDialog, "this$0");
        sendListener.onSend(i11);
        uploadImageConfirmationDialog.dismissDialog();
    }

    private final void dismissDialog() {
        this.dialog.dismiss();
    }

    private final void loadErrorImage() {
        RequestCreator fit = Picasso.get().load(this.imageFailedDrawableRes).placeholder(this.imageFailedDrawableRes).error(this.imageFailedDrawableRes).fit();
        ImageView imageView = this.selectedImage;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectedImage");
            imageView = null;
        }
        fit.into(imageView);
    }

    @SuppressLint({"LongLogTag"})
    private final void loadImage(String str, int i11, int i12) {
        RequestCreator onlyScaleDown = Picasso.get().load(new File(str)).memoryPolicy(MemoryPolicy.NO_CACHE, new MemoryPolicy[0]).error(this.imageFailedDrawableRes).placeholder(this.imageLoadingDrawableRes).resize(i11, i12).centerInside().onlyScaleDown();
        ImageView imageView = this.selectedImage;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectedImage");
            imageView = null;
        }
        onlyScaleDown.into(imageView, new UploadImageConfirmationDialog$loadImage$1(this));
    }

    /* access modifiers changed from: private */
    public final void toggleSendButton(boolean z11) {
        float f11;
        Button button = this.sendButton;
        Button button2 = null;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sendButton");
            button = null;
        }
        if (z11) {
            f11 = 1.0f;
        } else {
            f11 = 0.5f;
        }
        button.setAlpha(f11);
        Button button3 = this.sendButton;
        if (button3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sendButton");
            button3 = null;
        }
        button3.setClickable(z11);
        Button button4 = this.sendButton;
        if (button4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sendButton");
        } else {
            button2 = button4;
        }
        button2.setEnabled(z11);
    }

    public final void bind(int i11, @NotNull SendListener sendListener) {
        Intrinsics.checkNotNullParameter(sendListener, "sendListener");
        View findViewById = this.convertView.findViewById(R.id.cancel_button);
        Intrinsics.checkNotNullExpressionValue(findViewById, "convertView.findViewById(R.id.cancel_button)");
        ((Button) findViewById).setOnClickListener(new a(sendListener, this));
        View findViewById2 = this.convertView.findViewById(R.id.send_button);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "convertView.findViewById(R.id.send_button)");
        Button button = (Button) findViewById2;
        this.sendButton = button;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sendButton");
            button = null;
        }
        button.setOnClickListener(new b(sendListener, i11, this));
        toggleSendButton(false);
        View findViewById3 = this.convertView.findViewById(R.id.selected_image);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "convertView.findViewById(R.id.selected_image)");
        this.selectedImage = (ImageView) findViewById3;
        this.dialog.setView(this.convertView);
        this.dialog.show();
    }

    @Nullable
    public final ChatLogger getChatLogger() {
        return this.chatLogger;
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    @SuppressLint({"LongLogTag"})
    public final void showImage(@Nullable String str) {
        ImageView imageView = this.selectedImage;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectedImage");
            imageView = null;
        }
        int width = imageView.getWidth();
        ImageView imageView3 = this.selectedImage;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectedImage");
        } else {
            imageView2 = imageView3;
        }
        int height = imageView2.getHeight();
        if (str == null) {
            loadErrorImage();
            ChatLogger chatLogger2 = this.chatLogger;
            if (chatLogger2 != null) {
                chatLogger2.log(Events.GCC_IMAGE_SENDING_FAILED, MapsKt__MapsKt.emptyMap(), new IllegalArgumentException("Image Path is null!"));
            }
        } else if (height <= 0 || width <= 0) {
            loadErrorImage();
            ChatLogger chatLogger3 = this.chatLogger;
            if (chatLogger3 != null) {
                chatLogger3.log(Events.GCC_IMAGE_SENDING_FAILED, MapsKt__MapsKt.emptyMap(), new IllegalArgumentException("ImageView dimensions error!"));
            }
        } else {
            loadImage(str, width, height);
        }
    }
}
