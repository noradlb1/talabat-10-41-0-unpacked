package org.mockito.internal.stubbing;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.mockito.internal.invocation.StubInfoImpl;
import org.mockito.internal.progress.ThreadSafeMockingProgress;
import org.mockito.internal.verification.DefaultRegisteredInvocations;
import org.mockito.internal.verification.RegisteredInvocations;
import org.mockito.internal.verification.SingleRegisteredInvocation;
import org.mockito.invocation.Invocation;
import org.mockito.invocation.InvocationContainer;
import org.mockito.invocation.MatchableInvocation;
import org.mockito.mock.MockCreationSettings;
import org.mockito.quality.Strictness;
import org.mockito.stubbing.Answer;
import org.mockito.stubbing.Stubbing;
import org.mockito.stubbing.ValidableAnswer;

public class InvocationContainerImpl implements InvocationContainer, Serializable {
    private static final long serialVersionUID = -5334301962749537177L;
    private final DoAnswerStyleStubbing doAnswerStyleStubbing;
    private MatchableInvocation invocationForStubbing;
    private final Strictness mockStrictness;
    private final RegisteredInvocations registeredInvocations;
    private final LinkedList<StubbedInvocationMatcher> stubbed = new LinkedList<>();

    public InvocationContainerImpl(MockCreationSettings mockCreationSettings) {
        Strictness strictness;
        this.registeredInvocations = createRegisteredInvocations(mockCreationSettings);
        if (mockCreationSettings.isLenient()) {
            strictness = Strictness.LENIENT;
        } else {
            strictness = null;
        }
        this.mockStrictness = strictness;
        this.doAnswerStyleStubbing = new DoAnswerStyleStubbing();
    }

    private RegisteredInvocations createRegisteredInvocations(MockCreationSettings mockCreationSettings) {
        if (mockCreationSettings.isStubOnly()) {
            return new SingleRegisteredInvocation();
        }
        return new DefaultRegisteredInvocations();
    }

    public void addAnswer(Answer answer, Strictness strictness) {
        this.registeredInvocations.removeLast();
        addAnswer(answer, false, strictness);
    }

    public void addConsecutiveAnswer(Answer answer) {
        addAnswer(answer, true, (Strictness) null);
    }

    public void clearInvocations() {
        this.registeredInvocations.clear();
    }

    public StubbedInvocationMatcher findAnswerFor(Invocation invocation) {
        synchronized (this.stubbed) {
            Iterator<StubbedInvocationMatcher> it = this.stubbed.iterator();
            while (it.hasNext()) {
                StubbedInvocationMatcher next = it.next();
                if (next.matches(invocation)) {
                    next.markStubUsed(invocation);
                    invocation.markStubbed(new StubInfoImpl(next));
                    return next;
                }
            }
            return null;
        }
    }

    public MatchableInvocation getInvocationForStubbing() {
        return this.invocationForStubbing;
    }

    public List<Invocation> getInvocations() {
        return this.registeredInvocations.getAll();
    }

    public Collection<Stubbing> getStubbingsAscending() {
        LinkedList linkedList = new LinkedList(this.stubbed);
        Collections.reverse(linkedList);
        return linkedList;
    }

    public List<Stubbing> getStubbingsDescending() {
        return this.stubbed;
    }

    public boolean hasAnswersForStubbing() {
        return !this.doAnswerStyleStubbing.d();
    }

    public boolean hasInvocationForPotentialStubbing() {
        return !this.registeredInvocations.isEmpty();
    }

    public Object invokedMock() {
        return this.invocationForStubbing.getInvocation().getMock();
    }

    public void resetInvocationForPotentialStubbing(MatchableInvocation matchableInvocation) {
        this.invocationForStubbing = matchableInvocation;
    }

    public void setAnswersForStubbing(List<Answer<?>> list, Strictness strictness) {
        this.doAnswerStyleStubbing.e(list, strictness);
    }

    public void setInvocationForPotentialStubbing(MatchableInvocation matchableInvocation) {
        this.registeredInvocations.add(matchableInvocation.getInvocation());
        this.invocationForStubbing = matchableInvocation;
    }

    public void setMethodForStubbing(MatchableInvocation matchableInvocation) {
        boolean z11;
        this.invocationForStubbing = matchableInvocation;
        for (int i11 = 0; i11 < this.doAnswerStyleStubbing.b().size(); i11++) {
            Answer answer = this.doAnswerStyleStubbing.b().get(i11);
            if (i11 != 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            addAnswer(answer, z11, this.doAnswerStyleStubbing.c());
        }
        this.doAnswerStyleStubbing.a();
    }

    public String toString() {
        return "invocationForStubbing: " + this.invocationForStubbing;
    }

    public StubbedInvocationMatcher addAnswer(Answer answer, boolean z11, Strictness strictness) {
        StubbedInvocationMatcher first;
        Invocation invocation = this.invocationForStubbing.getInvocation();
        ThreadSafeMockingProgress.mockingProgress().stubbingCompleted();
        if (answer instanceof ValidableAnswer) {
            ((ValidableAnswer) answer).validateFor(invocation);
        }
        synchronized (this.stubbed) {
            if (z11) {
                try {
                    this.stubbed.getFirst().addAnswer(answer);
                } catch (Throwable th2) {
                    throw th2;
                }
            } else {
                if (strictness == null) {
                    strictness = this.mockStrictness;
                }
                this.stubbed.addFirst(new StubbedInvocationMatcher(answer, this.invocationForStubbing, strictness));
            }
            first = this.stubbed.getFirst();
        }
        return first;
    }
}
