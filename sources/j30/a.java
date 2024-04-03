package j30;

import j$.util.function.Predicate;
import java.util.logging.LogRecord;

public final /* synthetic */ class a implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Class f24351a;

    public /* synthetic */ a(Class cls) {
        this.f24351a = cls;
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
        return ((LogRecord) obj).getLoggerName().equals(this.f24351a.getName());
    }
}
