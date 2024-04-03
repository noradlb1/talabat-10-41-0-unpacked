package n8;

import android.os.Handler;
import android.os.Message;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class c implements Handler.Callback {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ListenerSet f35529b;

    public /* synthetic */ c(ListenerSet listenerSet) {
        this.f35529b = listenerSet;
    }

    public final boolean handleMessage(Message message) {
        return this.f35529b.handleMessage(message);
    }
}
