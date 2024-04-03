package g30;

import j$.util.function.Consumer;
import java.io.IOException;

public final /* synthetic */ class l implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ IOException f62086b;

    public /* synthetic */ l(IOException iOException) {
        this.f62086b = iOException;
    }

    public final void accept(Object obj) {
        this.f62086b.addSuppressed((IOException) obj);
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }
}
