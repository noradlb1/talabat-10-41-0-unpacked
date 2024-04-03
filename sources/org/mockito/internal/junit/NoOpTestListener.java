package org.mockito.internal.junit;

import b40.a;
import org.mockito.mock.MockCreationSettings;

public class NoOpTestListener implements MockitoTestListener {
    public void onMockCreated(Object obj, MockCreationSettings mockCreationSettings) {
    }

    public /* synthetic */ void onStaticMockCreated(Class cls, MockCreationSettings mockCreationSettings) {
        a.a(this, cls, mockCreationSettings);
    }

    public void testFinished(TestFinishedEvent testFinishedEvent) {
    }
}
