package l30;

import j$.util.function.Predicate;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;

public final /* synthetic */ class j1 implements Predicate {
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
        return Files.isDirectory((Path) obj, new LinkOption[0]);
    }
}
