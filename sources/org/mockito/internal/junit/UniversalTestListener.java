package org.mockito.internal.junit;

import b40.a;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Set;
import org.mockito.internal.creation.settings.CreationSettings;
import org.mockito.internal.listeners.AutoCleanableListener;
import org.mockito.mock.MockCreationSettings;
import org.mockito.plugins.MockitoLogger;
import org.mockito.quality.Strictness;

public class UniversalTestListener implements MockitoTestListener, AutoCleanableListener {
    private Strictness currentStrictness;
    private boolean listenerDirty;
    private final MockitoLogger logger;
    private IdentityHashMap mocks = new IdentityHashMap();
    private final DefaultStubbingLookupListener stubbingLookupListener;

    /* renamed from: org.mockito.internal.junit.UniversalTestListener$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f63215a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                org.mockito.quality.Strictness[] r0 = org.mockito.quality.Strictness.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f63215a = r0
                org.mockito.quality.Strictness r1 = org.mockito.quality.Strictness.WARN     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f63215a     // Catch:{ NoSuchFieldError -> 0x001d }
                org.mockito.quality.Strictness r1 = org.mockito.quality.Strictness.STRICT_STUBS     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f63215a     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.mockito.quality.Strictness r1 = org.mockito.quality.Strictness.LENIENT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.mockito.internal.junit.UniversalTestListener.AnonymousClass1.<clinit>():void");
        }
    }

    public UniversalTestListener(Strictness strictness, MockitoLogger mockitoLogger) {
        this.currentStrictness = strictness;
        this.logger = mockitoLogger;
        this.stubbingLookupListener = new DefaultStubbingLookupListener(strictness);
    }

    private static void emitWarnings(MockitoLogger mockitoLogger, TestFinishedEvent testFinishedEvent, Collection<Object> collection) {
        if (testFinishedEvent.getFailure() != null) {
            new ArgMismatchFinder().a(collection).format(testFinishedEvent.getTestName(), mockitoLogger);
        } else {
            new UnusedStubbingsFinder().getUnusedStubbings(collection).a(testFinishedEvent.getTestName(), mockitoLogger);
        }
    }

    private void reportUnusedStubs(TestFinishedEvent testFinishedEvent, Collection<Object> collection) {
        if (testFinishedEvent.getFailure() == null && !this.stubbingLookupListener.a()) {
            new UnusedStubbingsFinder().getUnusedStubbings(collection).b();
        }
    }

    public boolean isListenerDirty() {
        return this.listenerDirty;
    }

    public void onMockCreated(Object obj, MockCreationSettings mockCreationSettings) {
        this.mocks.put(obj, mockCreationSettings);
        ((CreationSettings) mockCreationSettings).getStubbingLookupListeners().add(this.stubbingLookupListener);
    }

    public /* synthetic */ void onStaticMockCreated(Class cls, MockCreationSettings mockCreationSettings) {
        a.a(this, cls, mockCreationSettings);
    }

    public void setListenerDirty() {
        this.listenerDirty = true;
    }

    public void setStrictness(Strictness strictness) {
        this.currentStrictness = strictness;
        this.stubbingLookupListener.b(strictness);
    }

    public void testFinished(TestFinishedEvent testFinishedEvent) {
        Set keySet = this.mocks.keySet();
        this.mocks = new IdentityHashMap();
        int i11 = AnonymousClass1.f63215a[this.currentStrictness.ordinal()];
        if (i11 == 1) {
            emitWarnings(this.logger, testFinishedEvent, keySet);
        } else if (i11 == 2) {
            reportUnusedStubs(testFinishedEvent, keySet);
        } else if (i11 != 3) {
            throw new IllegalStateException("Unknown strictness: " + this.currentStrictness);
        }
    }
}
