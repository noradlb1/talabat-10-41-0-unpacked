package p4;

import androidx.lifecycle.Observer;
import com.deliveryhero.chatui.view.chatroom.ChatFragment;
import kotlin.Pair;

public final /* synthetic */ class g implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ChatFragment f34628a;

    public /* synthetic */ g(ChatFragment chatFragment) {
        this.f34628a = chatFragment;
    }

    public final void onChanged(Object obj) {
        ChatFragment.m8150configureViewModel$lambda14(this.f34628a, (Pair) obj);
    }
}
