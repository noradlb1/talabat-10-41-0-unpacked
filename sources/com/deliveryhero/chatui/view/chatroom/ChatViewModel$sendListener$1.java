package com.deliveryhero.chatui.view.chatroom;

import androidx.lifecycle.ViewModelKt;
import com.deliveryhero.chatui.domain.imageselection.UploadImageConfirmationDialog;
import com.deliveryhero.chatui.view.chatroom.navigator.ImageSelectionNavigatorImpl;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"com/deliveryhero/chatui/view/chatroom/ChatViewModel$sendListener$1", "Lcom/deliveryhero/chatui/domain/imageselection/UploadImageConfirmationDialog$SendListener;", "onCancel", "", "onSend", "requestCode", "", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ChatViewModel$sendListener$1 implements UploadImageConfirmationDialog.SendListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ChatViewModel f29562a;

    public ChatViewModel$sendListener$1(ChatViewModel chatViewModel) {
        this.f29562a = chatViewModel;
    }

    public void onCancel() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this.f29562a), (CoroutineContext) null, (CoroutineStart) null, new ChatViewModel$sendListener$1$onCancel$1(this.f29562a, (Continuation<? super ChatViewModel$sendListener$1$onCancel$1>) null), 3, (Object) null);
    }

    public void onSend(int i11) {
        switch (i11) {
            case ImageSelectionNavigatorImpl.OPEN_CAMERA_REQUEST_CODE /*55660*/:
                this.f29562a.sendCameraPhoto();
                return;
            case ImageSelectionNavigatorImpl.OPEN_GALLERY_REQUEST_CODE /*55661*/:
                this.f29562a.sendGalleryPhoto();
                return;
            default:
                return;
        }
    }
}
