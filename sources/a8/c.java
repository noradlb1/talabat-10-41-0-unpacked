package a8;

import android.os.Handler;
import android.os.Message;
import com.google.android.exoplayer2.source.ConcatenatingMediaSource2;

public final /* synthetic */ class c implements Handler.Callback {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ConcatenatingMediaSource2 f34870b;

    public /* synthetic */ c(ConcatenatingMediaSource2 concatenatingMediaSource2) {
        this.f34870b = concatenatingMediaSource2;
    }

    public final boolean handleMessage(Message message) {
        return this.f34870b.handleMessage(message);
    }
}
