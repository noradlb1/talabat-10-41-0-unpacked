package org.mockito.internal.session;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.mockito.MockitoSession;
import org.mockito.internal.configuration.plugins.Plugins;
import org.mockito.internal.framework.DefaultMockitoSession;
import org.mockito.plugins.MockitoLogger;
import org.mockito.quality.Strictness;
import org.mockito.session.MockitoSessionBuilder;
import org.mockito.session.MockitoSessionLogger;

public class DefaultMockitoSessionBuilder implements MockitoSessionBuilder {
    private MockitoSessionLogger logger;

    /* renamed from: name  reason: collision with root package name */
    private String f63237name;
    private Strictness strictness;
    private final List<Object> testClassInstances = new ArrayList();

    public MockitoSessionBuilder initMocks(Object obj) {
        if (obj != null) {
            this.testClassInstances.add(obj);
        }
        return this;
    }

    public MockitoSessionBuilder logger(MockitoSessionLogger mockitoSessionLogger) {
        this.logger = mockitoSessionLogger;
        return this;
    }

    public MockitoSessionBuilder name(String str) {
        this.f63237name = str;
        return this;
    }

    public MockitoSession startMocking() {
        String str;
        List list;
        MockitoLogger mockitoLogger;
        if (this.testClassInstances.isEmpty()) {
            list = Collections.emptyList();
            str = this.f63237name;
            if (str == null) {
                str = "<Unnamed Session>";
            }
        } else {
            list = new ArrayList(this.testClassInstances);
            List<Object> list2 = this.testClassInstances;
            Object obj = list2.get(list2.size() - 1);
            String str2 = this.f63237name;
            if (str2 == null) {
                str = obj.getClass().getName();
            } else {
                str = str2;
            }
        }
        Strictness strictness2 = this.strictness;
        if (strictness2 == null) {
            strictness2 = Strictness.STRICT_STUBS;
        }
        MockitoSessionLogger mockitoSessionLogger = this.logger;
        if (mockitoSessionLogger == null) {
            mockitoLogger = Plugins.getMockitoLogger();
        } else {
            mockitoLogger = new MockitoLoggerAdapter(mockitoSessionLogger);
        }
        return new DefaultMockitoSession(list, str, strictness2, mockitoLogger);
    }

    public MockitoSessionBuilder strictness(Strictness strictness2) {
        this.strictness = strictness2;
        return this;
    }

    public MockitoSessionBuilder initMocks(Object... objArr) {
        if (objArr != null) {
            for (Object initMocks : objArr) {
                initMocks(initMocks);
            }
        }
        return this;
    }
}
