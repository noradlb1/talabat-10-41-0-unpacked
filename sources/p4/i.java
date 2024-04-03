package p4;

import com.deliveryhero.chatui.view.chatroom.ChatFragment;

public final /* synthetic */ class i implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f34630b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ChatFragment f34631c;

    public /* synthetic */ i(boolean z11, ChatFragment chatFragment) {
        this.f34630b = z11;
        this.f34631c = chatFragment;
    }

    public final void run() {
        ChatFragment.m8156updateData$lambda5(this.f34630b, this.f34631c);
    }
}
