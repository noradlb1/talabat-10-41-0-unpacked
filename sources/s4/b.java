package s4;

import android.view.View;
import com.deliveryhero.chatui.view.chatroom.ImageMessage;
import com.deliveryhero.chatui.view.chatroom.viewholder.MessageViewHolder;

public final /* synthetic */ class b implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MessageViewHolder f34659b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ImageMessage f34660c;

    public /* synthetic */ b(MessageViewHolder messageViewHolder, ImageMessage imageMessage) {
        this.f34659b = messageViewHolder;
        this.f34660c = imageMessage;
    }

    public final void onClick(View view) {
        MessageViewHolder.m8166setImageMessage$lambda0(this.f34659b, this.f34660c, view);
    }
}
