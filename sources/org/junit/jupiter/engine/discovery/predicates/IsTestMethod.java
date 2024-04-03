package org.junit.jupiter.engine.discovery.predicates;

import java.lang.reflect.Method;
import org.apiguardian.api.API;
import org.junit.jupiter.api.Test;

@API(since = "5.0", status = API.Status.INTERNAL)
public class IsTestMethod extends IsTestableMethod {
    public IsTestMethod() {
        super(Test.class, true);
    }

    public /* bridge */ /* synthetic */ boolean test(Method method) {
        return super.test(method);
    }
}
