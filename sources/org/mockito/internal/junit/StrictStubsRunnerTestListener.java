package org.mockito.internal.junit;

import b40.a;
import org.mockito.mock.MockCreationSettings;
import org.mockito.quality.Strictness;

public class StrictStubsRunnerTestListener implements MockitoTestListener {
    private final DefaultStubbingLookupListener stubbingLookupListener = new DefaultStubbingLookupListener(Strictness.STRICT_STUBS);

    public void onMockCreated(Object obj, MockCreationSettings mockCreationSettings) {
        mockCreationSettings.getStubbingLookupListeners().add(this.stubbingLookupListener);
    }

    public /* synthetic */ void onStaticMockCreated(Class cls, MockCreationSettings mockCreationSettings) {
        a.a(this, cls, mockCreationSettings);
    }

    public void testFinished(TestFinishedEvent testFinishedEvent) {
    }
}
