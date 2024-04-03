package org.mockito.internal.junit;

import org.junit.runners.model.Statement;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.MockitoSession;
import org.mockito.internal.session.MockitoSessionLoggerAdapter;
import org.mockito.plugins.MockitoLogger;
import org.mockito.quality.Strictness;

class JUnitSessionStore {

    /* renamed from: a  reason: collision with root package name */
    public Strictness f63209a;
    /* access modifiers changed from: private */
    public final MockitoLogger logger;
    /* access modifiers changed from: private */
    public MockitoSession session;

    public JUnitSessionStore(MockitoLogger mockitoLogger, Strictness strictness) {
        this.logger = mockitoLogger;
        this.f63209a = strictness;
    }

    public Statement d(final Statement statement, final String str, final Object obj) {
        return new Statement() {
            private Throwable evaluateSafely(Statement statement) {
                try {
                    statement.evaluate();
                    return null;
                } catch (Throwable th2) {
                    return th2;
                }
            }

            public void evaluate() throws Throwable {
                AutoCloseable autoCloseable;
                if (JUnitSessionStore.this.session == null) {
                    MockitoSession unused = JUnitSessionStore.this.session = Mockito.mockitoSession().name(str).strictness(JUnitSessionStore.this.f63209a).logger(new MockitoSessionLoggerAdapter(JUnitSessionStore.this.logger)).initMocks(obj).startMocking();
                    autoCloseable = null;
                } else {
                    autoCloseable = MockitoAnnotations.openMocks(obj);
                }
                Throwable evaluateSafely = evaluateSafely(statement);
                JUnitSessionStore.this.session.finishMocking(evaluateSafely);
                if (autoCloseable != null) {
                    autoCloseable.close();
                }
                if (evaluateSafely != null) {
                    throw evaluateSafely;
                }
            }
        };
    }

    public void e(Strictness strictness) {
        this.f63209a = strictness;
        MockitoSession mockitoSession = this.session;
        if (mockitoSession != null) {
            mockitoSession.setStrictness(strictness);
        }
    }
}
