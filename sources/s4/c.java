package s4;

import android.view.View;
import com.deliveryhero.chatui.view.chatroom.LocationMessage;
import com.deliveryhero.chatui.view.chatroom.viewholder.MessageViewHolder;

public final /* synthetic */ class c implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MessageViewHolder f34661b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ LocationMessage.Location f34662c;

    public /* synthetic */ c(MessageViewHolder messageViewHolder, LocationMessage.Location location) {
        this.f34661b = messageViewHolder;
        this.f34662c = location;
    }

    public final void onClick(View view) {
        MessageViewHolder.m8167showLocationMessage$lambda2(this.f34661b, this.f34662c, view);
    }
}
