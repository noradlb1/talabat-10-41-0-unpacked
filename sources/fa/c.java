package fa;

import android.content.Context;
import android.content.Intent;
import com.google.firebase.messaging.ServiceStarter;
import java.util.concurrent.Callable;

public final /* synthetic */ class c implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f50620b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Intent f50621c;

    public /* synthetic */ c(Context context, Intent intent) {
        this.f50620b = context;
        this.f50621c = intent;
    }

    public final Object call() {
        return Integer.valueOf(ServiceStarter.getInstance().startMessagingService(this.f50620b, this.f50621c));
    }
}
