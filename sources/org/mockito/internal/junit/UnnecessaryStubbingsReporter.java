package org.mockito.internal.junit;

import b40.a;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import org.junit.runner.Description;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;
import org.mockito.internal.exceptions.Reporter;
import org.mockito.invocation.Invocation;
import org.mockito.listeners.MockCreationListener;
import org.mockito.mock.MockCreationSettings;

public class UnnecessaryStubbingsReporter implements MockCreationListener {
    private final List<Object> mocks = new LinkedList();

    public void onMockCreated(Object obj, MockCreationSettings mockCreationSettings) {
        this.mocks.add(obj);
    }

    public /* synthetic */ void onStaticMockCreated(Class cls, MockCreationSettings mockCreationSettings) {
        a.a(this, cls, mockCreationSettings);
    }

    public void validateUnusedStubs(Class<?> cls, RunNotifier runNotifier) {
        Collection<Invocation> unusedStubbingsByLocation = new UnusedStubbingsFinder().getUnusedStubbingsByLocation(this.mocks);
        if (!unusedStubbingsByLocation.isEmpty()) {
            runNotifier.fireTestFailure(new Failure(Description.createTestDescription(cls, "unnecessary Mockito stubbings"), Reporter.formatUnncessaryStubbingException(cls, unusedStubbingsByLocation)));
        }
    }
}
