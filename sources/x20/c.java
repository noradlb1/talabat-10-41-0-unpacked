package x20;

import j$.util.function.Consumer;
import org.opentest4j.MultipleFailuresError;

public final /* synthetic */ class c implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MultipleFailuresError f57966b;

    public /* synthetic */ c(MultipleFailuresError multipleFailuresError) {
        this.f57966b = multipleFailuresError;
    }

    public final void accept(Object obj) {
        this.f57966b.addSuppressed((Throwable) obj);
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }
}
