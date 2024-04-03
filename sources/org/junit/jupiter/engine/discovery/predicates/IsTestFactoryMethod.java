package org.junit.jupiter.engine.discovery.predicates;

import java.lang.reflect.Method;
import org.apiguardian.api.API;
import org.junit.jupiter.api.TestFactory;

@API(since = "5.0", status = API.Status.INTERNAL)
public class IsTestFactoryMethod extends IsTestableMethod {
    public IsTestFactoryMethod() {
        super(TestFactory.class, false);
    }

    public /* bridge */ /* synthetic */ boolean test(Method method) {
        return super.test(method);
    }
}
