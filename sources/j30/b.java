package j30;

import j$.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import org.junit.platform.commons.logging.LogRecordListener;

public final /* synthetic */ class b implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Level f24352a;

    public /* synthetic */ b(Level level) {
        this.f24352a = level;
    }

    public /* synthetic */ Predicate and(Predicate predicate) {
        return Predicate.CC.$default$and(this, predicate);
    }

    public /* synthetic */ Predicate negate() {
        return Predicate.CC.$default$negate(this);
    }

    public /* synthetic */ Predicate or(Predicate predicate) {
        return Predicate.CC.$default$or(this, predicate);
    }

    public final boolean test(Object obj) {
        return LogRecordListener.lambda$stream$2(this.f24352a, (LogRecord) obj);
    }
}
