package mm;

import com.talabat.feature.darkstoresflutter.domain.channel.DarkstoreCartEventStreamHandlerImpl;
import io.reactivex.functions.Consumer;
import java.util.Map;

public final /* synthetic */ class a implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DarkstoreCartEventStreamHandlerImpl f62299b;

    public /* synthetic */ a(DarkstoreCartEventStreamHandlerImpl darkstoreCartEventStreamHandlerImpl) {
        this.f62299b = darkstoreCartEventStreamHandlerImpl;
    }

    public final void accept(Object obj) {
        this.f62299b.dispatchCart((Map) obj);
    }
}
