package p4;

import androidx.lifecycle.Observer;
import com.deliveryhero.chatui.view.chatroom.AttachmentViewOptions;
import com.deliveryhero.chatui.view.chatroom.ChatFragment;

public final /* synthetic */ class f implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ChatFragment f34627a;

    public /* synthetic */ f(ChatFragment chatFragment) {
        this.f34627a = chatFragment;
    }

    public final void onChanged(Object obj) {
        ChatFragment.m8149configureViewModel$lambda13(this.f34627a, (AttachmentViewOptions) obj);
    }
}
