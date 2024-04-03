package org.mockito.internal.handler;

import org.mockito.internal.creation.settings.CreationSettings;
import org.mockito.internal.invocation.InvocationMatcher;
import org.mockito.internal.invocation.MatchersBinder;
import org.mockito.internal.listeners.StubbingLookupNotifier;
import org.mockito.internal.progress.ThreadSafeMockingProgress;
import org.mockito.internal.stubbing.InvocationContainerImpl;
import org.mockito.internal.stubbing.OngoingStubbingImpl;
import org.mockito.internal.stubbing.StubbedInvocationMatcher;
import org.mockito.internal.stubbing.answers.DefaultAnswerValidator;
import org.mockito.internal.util.MockUtil;
import org.mockito.internal.verification.MockAwareVerificationMode;
import org.mockito.internal.verification.VerificationDataImpl;
import org.mockito.invocation.Invocation;
import org.mockito.invocation.InvocationContainer;
import org.mockito.invocation.MockHandler;
import org.mockito.mock.MockCreationSettings;
import org.mockito.verification.VerificationMode;

public class MockHandlerImpl<T> implements MockHandler<T> {
    private static final long serialVersionUID = -2917871070982574165L;

    /* renamed from: b  reason: collision with root package name */
    public InvocationContainerImpl f63205b;

    /* renamed from: c  reason: collision with root package name */
    public MatchersBinder f63206c = new MatchersBinder();
    private final MockCreationSettings<T> mockSettings;

    public MockHandlerImpl(MockCreationSettings<T> mockCreationSettings) {
        this.mockSettings = mockCreationSettings;
        this.f63206c = new MatchersBinder();
        this.f63205b = new InvocationContainerImpl(mockCreationSettings);
    }

    public InvocationContainer getInvocationContainer() {
        return this.f63205b;
    }

    public MockCreationSettings<T> getMockSettings() {
        return this.mockSettings;
    }

    public Object handle(Invocation invocation) throws Throwable {
        if (this.f63205b.hasAnswersForStubbing()) {
            this.f63205b.setMethodForStubbing(this.f63206c.bindMatchers(ThreadSafeMockingProgress.mockingProgress().getArgumentMatcherStorage(), invocation));
            return null;
        }
        VerificationMode pullVerificationMode = ThreadSafeMockingProgress.mockingProgress().pullVerificationMode();
        InvocationMatcher bindMatchers = this.f63206c.bindMatchers(ThreadSafeMockingProgress.mockingProgress().getArgumentMatcherStorage(), invocation);
        ThreadSafeMockingProgress.mockingProgress().validateState();
        if (pullVerificationMode != null) {
            if (MockUtil.areSameMocks(((MockAwareVerificationMode) pullVerificationMode).getMock(), invocation.getMock())) {
                pullVerificationMode.verify(new VerificationDataImpl(this.f63205b, bindMatchers));
                return null;
            }
            ThreadSafeMockingProgress.mockingProgress().verificationStarted(pullVerificationMode);
        }
        this.f63205b.setInvocationForPotentialStubbing(bindMatchers);
        OngoingStubbingImpl ongoingStubbingImpl = new OngoingStubbingImpl(this.f63205b);
        ThreadSafeMockingProgress.mockingProgress().reportOngoingStubbing(ongoingStubbingImpl);
        StubbedInvocationMatcher findAnswerFor = this.f63205b.findAnswerFor(invocation);
        StubbingLookupNotifier.notifyStubbedAnswerLookup(invocation, findAnswerFor, this.f63205b.getStubbingsAscending(), (CreationSettings) this.mockSettings);
        if (findAnswerFor != null) {
            findAnswerFor.captureArgumentsFrom(invocation);
            try {
                return findAnswerFor.answer(invocation);
            } finally {
                ThreadSafeMockingProgress.mockingProgress().reportOngoingStubbing(ongoingStubbingImpl);
            }
        } else {
            Object answer = this.mockSettings.getDefaultAnswer().answer(invocation);
            DefaultAnswerValidator.validateReturnValueFor(invocation, answer);
            this.f63205b.resetInvocationForPotentialStubbing(bindMatchers);
            return answer;
        }
    }
}
