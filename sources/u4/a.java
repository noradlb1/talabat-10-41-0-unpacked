package u4;

import androidx.lifecycle.Observer;
import com.deliveryhero.chatui.view.root.CustomerChatActivity;

public final /* synthetic */ class a implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CustomerChatActivity f34692a;

    public /* synthetic */ a(CustomerChatActivity customerChatActivity) {
        this.f34692a = customerChatActivity;
    }

    public final void onChanged(Object obj) {
        CustomerChatActivity.m8170configureViews$lambda2(this.f34692a, (Integer) obj);
    }
}
