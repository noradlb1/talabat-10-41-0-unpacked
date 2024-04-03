package org.mockito.internal.junit;

import b40.a;
import java.util.LinkedList;
import java.util.List;
import org.mockito.mock.MockCreationSettings;
import org.mockito.plugins.MockitoLogger;

public class MismatchReportingTestListener implements MockitoTestListener {
    private final MockitoLogger logger;
    private List<Object> mocks = new LinkedList();

    public MismatchReportingTestListener(MockitoLogger mockitoLogger) {
        this.logger = mockitoLogger;
    }

    public void onMockCreated(Object obj, MockCreationSettings mockCreationSettings) {
        this.mocks.add(obj);
    }

    public /* synthetic */ void onStaticMockCreated(Class cls, MockCreationSettings mockCreationSettings) {
        a.a(this, cls, mockCreationSettings);
    }

    public void testFinished(TestFinishedEvent testFinishedEvent) {
        List<Object> list = this.mocks;
        this.mocks = new LinkedList();
        if (testFinishedEvent.getFailure() != null) {
            new ArgMismatchFinder().a(list).format(testFinishedEvent.getTestName(), this.logger);
        }
    }
}
