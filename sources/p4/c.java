package p4;

import androidx.lifecycle.Observer;
import com.deliveryhero.chatui.view.chatroom.ChatFragment;

public final /* synthetic */ class c implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ChatFragment f34624a;

    public /* synthetic */ c(ChatFragment chatFragment) {
        this.f34624a = chatFragment;
    }

    public final void onChanged(Object obj) {
        ChatFragment.m8152configureViewModel$lambda8(this.f34624a, (Integer) obj);
    }
}
