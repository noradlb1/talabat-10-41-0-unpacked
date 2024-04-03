package di;

import com.talabat.darkstores.data.darkstores.DarkstoresRepo;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class w implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DarkstoresRepo f56723b;

    public /* synthetic */ w(DarkstoresRepo darkstoresRepo) {
        this.f56723b = darkstoresRepo;
    }

    public final void accept(Object obj) {
        this.f56723b.trackVendorError((Throwable) obj);
    }
}
