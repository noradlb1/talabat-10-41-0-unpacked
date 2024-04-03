package y5;

import com.deliveryhero.perseus.logger.DatabaseInfoLogger;
import java.util.Calendar;
import java.util.concurrent.Callable;

public final /* synthetic */ class a implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DatabaseInfoLogger f34835b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Calendar f34836c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Integer f34837d;

    public /* synthetic */ a(DatabaseInfoLogger databaseInfoLogger, Calendar calendar, Integer num) {
        this.f34835b = databaseInfoLogger;
        this.f34836c = calendar;
        this.f34837d = num;
    }

    public final Object call() {
        return DatabaseInfoLogger.logBacklogInfo$lambda$0(this.f34835b, this.f34836c, this.f34837d);
    }
}
