package u4;

import android.view.MenuItem;
import com.deliveryhero.chatui.domain.call.CallStatus;
import com.deliveryhero.chatui.view.root.CustomerChatActivity;

public final /* synthetic */ class b implements MenuItem.OnMenuItemClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CustomerChatActivity f34693b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CallStatus f34694c;

    public /* synthetic */ b(CustomerChatActivity customerChatActivity, CallStatus callStatus) {
        this.f34693b = customerChatActivity;
        this.f34694c = callStatus;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        return CustomerChatActivity.m8171enableCallButton$lambda5(this.f34693b, this.f34694c, menuItem);
    }
}
