package p4;

import androidx.activity.result.ActivityResultCallback;
import com.deliveryhero.chatui.view.chatroom.ChatFragment;
import com.deliveryhero.contract.model.LocationData;

public final /* synthetic */ class a implements ActivityResultCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ChatFragment f34622a;

    public /* synthetic */ a(ChatFragment chatFragment) {
        this.f34622a = chatFragment;
    }

    public final void onActivityResult(Object obj) {
        ChatFragment.m8155onViewCreated$lambda1$lambda0(this.f34622a, (LocationData) obj);
    }
}
