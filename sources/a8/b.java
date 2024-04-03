package a8;

import android.os.Handler;
import android.os.Message;
import com.google.android.exoplayer2.source.ConcatenatingMediaSource;

public final /* synthetic */ class b implements Handler.Callback {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ConcatenatingMediaSource f34869b;

    public /* synthetic */ b(ConcatenatingMediaSource concatenatingMediaSource) {
        this.f34869b = concatenatingMediaSource;
    }

    public final boolean handleMessage(Message message) {
        return this.f34869b.handleMessage(message);
    }
}
