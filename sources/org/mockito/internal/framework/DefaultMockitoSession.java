package org.mockito.internal.framework;

import java.util.ArrayList;
import java.util.List;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.MockitoSession;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.exceptions.misusing.RedundantListenerException;
import org.mockito.internal.exceptions.Reporter;
import org.mockito.internal.junit.TestFinishedEvent;
import org.mockito.internal.junit.UniversalTestListener;
import org.mockito.plugins.MockitoLogger;
import org.mockito.quality.Strictness;

public class DefaultMockitoSession implements MockitoSession {
    private final List<AutoCloseable> closeables = new ArrayList();
    private final UniversalTestListener listener;
    /* access modifiers changed from: private */

    /* renamed from: name  reason: collision with root package name */
    public final String f63202name;

    public DefaultMockitoSession(List<Object> list, String str, Strictness strictness, MockitoLogger mockitoLogger) {
        this.f63202name = str;
        UniversalTestListener universalTestListener = new UniversalTestListener(strictness, mockitoLogger);
        this.listener = universalTestListener;
        try {
            Mockito.framework().addListener(universalTestListener);
        } catch (RedundantListenerException unused) {
            Reporter.unfinishedMockingSession();
        }
        try {
            for (Object openMocks : list) {
                this.closeables.add(MockitoAnnotations.openMocks(openMocks));
            }
            return;
        } catch (RuntimeException e11) {
            release();
        } catch (Throwable th2) {
            e11.addSuppressed(th2);
        }
        this.listener.setListenerDirty();
        throw e11;
    }

    private void release() {
        for (AutoCloseable next : this.closeables) {
            try {
                next.close();
            } catch (Exception e11) {
                throw new MockitoException("Failed to release " + next, e11);
            }
        }
    }

    public void finishMocking() {
        finishMocking((Throwable) null);
    }

    public void setStrictness(Strictness strictness) {
        this.listener.setStrictness(strictness);
    }

    public void finishMocking(final Throwable th2) {
        try {
            Mockito.framework().removeListener(this.listener);
            this.listener.testFinished(new TestFinishedEvent() {
                public Throwable getFailure() {
                    return th2;
                }

                public String getTestName() {
                    return DefaultMockitoSession.this.f63202name;
                }
            });
            if (th2 == null) {
                Mockito.validateMockitoUsage();
            }
        } finally {
            release();
        }
    }
}
