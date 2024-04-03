package org.mockito.internal;

import org.mockito.MockedStatic;
import org.mockito.MockingDetails;
import org.mockito.Mockito;
import org.mockito.exceptions.base.MockitoAssertionError;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.internal.debugging.LocationImpl;
import org.mockito.internal.exceptions.Reporter;
import org.mockito.internal.invocation.InvocationMatcher;
import org.mockito.internal.listeners.VerificationStartedNotifier;
import org.mockito.internal.progress.MockingProgress;
import org.mockito.internal.progress.ThreadSafeMockingProgress;
import org.mockito.internal.util.MockUtil;
import org.mockito.internal.util.StringUtil;
import org.mockito.internal.verification.MockAwareVerificationMode;
import org.mockito.internal.verification.VerificationDataImpl;
import org.mockito.internal.verification.VerificationModeFactory;
import org.mockito.invocation.Location;
import org.mockito.plugins.MockMaker;
import org.mockito.stubbing.OngoingStubbing;
import org.mockito.verification.VerificationMode;
import s30.a;

public final class MockedStaticImpl<T> implements MockedStatic<T> {
    private boolean closed;
    private final MockMaker.StaticMockControl<T> control;
    private final Location location = new LocationImpl();

    public MockedStaticImpl(MockMaker.StaticMockControl<T> staticMockControl) {
        this.control = staticMockControl;
    }

    private void assertNotClosed() {
        if (this.closed) {
            throw new MockitoException(StringUtil.join("The static mock created at", this.location.toString(), "is already resolved and cannot longer be used"));
        }
    }

    public void clearInvocations() {
        assertNotClosed();
        MockingProgress mockingProgress = ThreadSafeMockingProgress.mockingProgress();
        mockingProgress.validateState();
        mockingProgress.reset();
        mockingProgress.resetOngoingStubbing();
        MockUtil.getInvocationContainer(this.control.getType()).clearInvocations();
    }

    public void close() {
        assertNotClosed();
        this.closed = true;
        this.control.disable();
    }

    public void closeOnDemand() {
        if (!this.closed) {
            close();
        }
    }

    public boolean isClosed() {
        return this.closed;
    }

    public void reset() {
        assertNotClosed();
        MockingProgress mockingProgress = ThreadSafeMockingProgress.mockingProgress();
        mockingProgress.validateState();
        mockingProgress.reset();
        mockingProgress.resetOngoingStubbing();
        MockUtil.resetMock(this.control.getType());
    }

    public String toString() {
        return "static mock for " + this.control.getType().getName();
    }

    public /* synthetic */ void verify(MockedStatic.Verification verification) {
        a.a(this, verification);
    }

    public void verify(MockedStatic.Verification verification, VerificationMode verificationMode) {
        assertNotClosed();
        MockingDetails mockingDetails = Mockito.mockingDetails(this.control.getType());
        VerificationStartedNotifier.notifyVerificationStarted(mockingDetails.getMockHandler().getMockSettings().getVerificationStartedListeners(), mockingDetails);
        MockingProgress mockingProgress = ThreadSafeMockingProgress.mockingProgress();
        mockingProgress.verificationStarted(new MockAwareVerificationMode(this.control.getType(), mockingProgress.maybeVerifyLazily(verificationMode), mockingProgress.verificationListeners()));
        try {
            verification.apply();
        } catch (MockitoAssertionError | MockitoException e11) {
            throw e11;
        } catch (Throwable th2) {
            throw new MockitoException(StringUtil.join("An unexpected error occurred while verifying a static stub", "", "To correctly verify a stub, invoke a single static method of " + this.control.getType().getName() + " in the provided lambda.", "For example, if a method 'sample' was defined, provide a lambda or anonymous class containing the code", "", "() -> " + this.control.getType().getSimpleName() + ".sample()", "or", this.control.getType().getSimpleName() + "::sample"), th2);
        }
    }

    public void verifyNoInteractions() {
        assertNotClosed();
        ThreadSafeMockingProgress.mockingProgress().validateState();
        VerificationModeFactory.noInteractions().verify(new VerificationDataImpl(MockUtil.getInvocationContainer(this.control.getType()), (InvocationMatcher) null));
    }

    public void verifyNoMoreInteractions() {
        assertNotClosed();
        ThreadSafeMockingProgress.mockingProgress().validateState();
        VerificationModeFactory.noMoreInteractions().verify(new VerificationDataImpl(MockUtil.getInvocationContainer(this.control.getType()), (InvocationMatcher) null));
    }

    public <S> OngoingStubbing<S> when(MockedStatic.Verification verification) {
        assertNotClosed();
        try {
            verification.apply();
        } catch (Throwable unused) {
        }
        MockingProgress mockingProgress = ThreadSafeMockingProgress.mockingProgress();
        mockingProgress.stubbingStarted();
        OngoingStubbing<?> pullOngoingStubbing = mockingProgress.pullOngoingStubbing();
        if (pullOngoingStubbing != null) {
            return pullOngoingStubbing;
        }
        mockingProgress.reset();
        throw Reporter.missingMethodInvocation();
    }
}
