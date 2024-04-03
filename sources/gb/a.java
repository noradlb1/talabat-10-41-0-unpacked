package gb;

import android.os.Handler;
import android.os.Message;
import com.huawei.location.vdr.data.LW;

public final /* synthetic */ class a implements Handler.Callback {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LW f50636b;

    public /* synthetic */ a(LW lw2) {
        this.f50636b = lw2;
    }

    public final boolean handleMessage(Message message) {
        return this.f50636b.yn(message);
    }
}
