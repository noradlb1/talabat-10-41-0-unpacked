package androidx.window.layout;

import androidx.core.util.Consumer;
import kotlinx.coroutines.channels.Channel;

public final /* synthetic */ class a implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Channel f37955b;

    public /* synthetic */ a(Channel channel) {
        this.f37955b = channel;
    }

    public final void accept(Object obj) {
        WindowInfoTrackerImpl$windowLayoutInfo$1.m9130invokeSuspend$lambda0(this.f37955b, (WindowLayoutInfo) obj);
    }
}
