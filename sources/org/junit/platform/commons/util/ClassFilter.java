package org.junit.platform.commons.util;

import j$.util.function.Predicate;
import l30.o;
import org.apiguardian.api.API;

@API(since = "1.1", status = API.Status.INTERNAL)
public class ClassFilter implements Predicate<Class<?>> {
    private final Predicate<Class<?>> classPredicate;
    private final Predicate<String> namePredicate;

    /* JADX WARNING: type inference failed for: r2v0, types: [java.lang.Object, j$.util.function.Predicate<java.lang.String>] */
    /* JADX WARNING: type inference failed for: r3v0, types: [j$.util.function.Predicate<java.lang.Class<?>>, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private ClassFilter(j$.util.function.Predicate<java.lang.String> r2, j$.util.function.Predicate<java.lang.Class<?>> r3) {
        /*
            r1 = this;
            r1.<init>()
            java.lang.String r0 = "name predicate must not be null"
            java.lang.Object r2 = org.junit.platform.commons.util.Preconditions.notNull(r2, (java.lang.String) r0)
            j$.util.function.Predicate r2 = (j$.util.function.Predicate) r2
            r1.namePredicate = r2
            java.lang.String r2 = "class predicate must not be null"
            java.lang.Object r2 = org.junit.platform.commons.util.Preconditions.notNull(r3, (java.lang.String) r2)
            j$.util.function.Predicate r2 = (j$.util.function.Predicate) r2
            r1.classPredicate = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.junit.platform.commons.util.ClassFilter.<init>(j$.util.function.Predicate, j$.util.function.Predicate):void");
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$of$0(String str) {
        return true;
    }

    public static ClassFilter of(Predicate<Class<?>> predicate) {
        return of(new o(), predicate);
    }

    public /* synthetic */ Predicate and(Predicate predicate) {
        return Predicate.CC.$default$and(this, predicate);
    }

    public boolean match(String str) {
        return this.namePredicate.test(str);
    }

    public /* synthetic */ Predicate negate() {
        return Predicate.CC.$default$negate(this);
    }

    public /* synthetic */ Predicate or(Predicate predicate) {
        return Predicate.CC.$default$or(this, predicate);
    }

    public static ClassFilter of(Predicate<String> predicate, Predicate<Class<?>> predicate2) {
        return new ClassFilter(predicate, predicate2);
    }

    public boolean match(Class<?> cls) {
        return this.classPredicate.test(cls);
    }

    public boolean test(Class<?> cls) {
        return match(cls.getName()) && match(cls);
    }
}
