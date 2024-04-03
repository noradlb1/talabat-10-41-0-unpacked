package p4;

import androidx.lifecycle.Observer;
import com.deliveryhero.chatui.view.chatroom.ChatFragment;
import java.util.List;

public final /* synthetic */ class e implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ChatFragment f34626a;

    public /* synthetic */ e(ChatFragment chatFragment) {
        this.f34626a = chatFragment;
    }

    public final void onChanged(Object obj) {
        ChatFragment.m8148configureViewModel$lambda11(this.f34626a, (List) obj);
    }
}
