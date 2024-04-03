package p4;

import androidx.lifecycle.Observer;
import com.deliveryhero.chatui.view.chatroom.ChatFragment;
import java.util.List;

public final /* synthetic */ class b implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ChatFragment f34623a;

    public /* synthetic */ b(ChatFragment chatFragment) {
        this.f34623a = chatFragment;
    }

    public final void onChanged(Object obj) {
        ChatFragment.m8151configureViewModel$lambda7(this.f34623a, (List) obj);
    }
}
