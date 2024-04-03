package p4;

import androidx.lifecycle.Observer;
import com.deliveryhero.chatui.view.chatroom.ChatFragment;

public final /* synthetic */ class d implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ChatFragment f34625a;

    public /* synthetic */ d(ChatFragment chatFragment) {
        this.f34625a = chatFragment;
    }

    public final void onChanged(Object obj) {
        ChatFragment.m8153configureViewModel$lambda9(this.f34625a, (Boolean) obj);
    }
}
