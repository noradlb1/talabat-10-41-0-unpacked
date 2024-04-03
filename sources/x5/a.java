package x5;

import com.deliveryhero.perseus.hits.usecase.DeleteStaleEventsUseCase;
import java.util.Calendar;
import java.util.concurrent.Callable;

public final /* synthetic */ class a implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DeleteStaleEventsUseCase f34818b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Calendar f34819c;

    public /* synthetic */ a(DeleteStaleEventsUseCase deleteStaleEventsUseCase, Calendar calendar) {
        this.f34818b = deleteStaleEventsUseCase;
        this.f34819c = calendar;
    }

    public final Object call() {
        return DeleteStaleEventsUseCase.deleteStaleEvents$lambda$0(this.f34818b, this.f34819c);
    }
}
