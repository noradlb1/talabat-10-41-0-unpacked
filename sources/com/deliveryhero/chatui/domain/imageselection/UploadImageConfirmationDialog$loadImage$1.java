package com.deliveryhero.chatui.domain.imageselection;

import com.deliveryhero.contract.ChatLogger;
import com.deliveryhero.contract.model.Events;
import com.squareup.picasso.Callback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016¨\u0006\b"}, d2 = {"com/deliveryhero/chatui/domain/imageselection/UploadImageConfirmationDialog$loadImage$1", "Lcom/squareup/picasso/Callback;", "onError", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onSuccess", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UploadImageConfirmationDialog$loadImage$1 implements Callback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UploadImageConfirmationDialog f29424a;

    public UploadImageConfirmationDialog$loadImage$1(UploadImageConfirmationDialog uploadImageConfirmationDialog) {
        this.f29424a = uploadImageConfirmationDialog;
    }

    public void onError(@NotNull Exception exc) {
        Intrinsics.checkNotNullParameter(exc, "e");
        ChatLogger chatLogger = this.f29424a.getChatLogger();
        if (chatLogger != null) {
            chatLogger.log(Events.GCC_IMAGE_SENDING_FAILED, MapsKt__MapsKt.emptyMap(), exc);
        }
    }

    public void onSuccess() {
        this.f29424a.toggleSendButton(true);
    }
}
