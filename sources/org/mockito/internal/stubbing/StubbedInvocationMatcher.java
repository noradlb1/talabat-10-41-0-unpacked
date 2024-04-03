package org.mockito.internal.stubbing;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.mockito.internal.invocation.InvocationMatcher;
import org.mockito.invocation.DescribedInvocation;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.invocation.MatchableInvocation;
import org.mockito.quality.Strictness;
import org.mockito.stubbing.Answer;
import org.mockito.stubbing.Stubbing;

public class StubbedInvocationMatcher extends InvocationMatcher implements Stubbing {
    private static final long serialVersionUID = 4919105134123672727L;
    private final Queue<Answer> answers;
    private final Strictness strictness;
    private DescribedInvocation usedAt;
    private final Object usedAtLock = new Object[0];

    public StubbedInvocationMatcher(Answer answer, MatchableInvocation matchableInvocation, Strictness strictness2) {
        super(matchableInvocation.getInvocation(), matchableInvocation.getMatchers());
        ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
        this.answers = concurrentLinkedQueue;
        this.strictness = strictness2;
        concurrentLinkedQueue.add(answer);
    }

    public void addAnswer(Answer answer) {
        this.answers.add(answer);
    }

    public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
        Object poll;
        Answer answer;
        synchronized (this.answers) {
            if (this.answers.size() == 1) {
                poll = this.answers.peek();
            } else {
                poll = this.answers.poll();
            }
            answer = (Answer) poll;
        }
        return answer.answer(invocationOnMock);
    }

    public Strictness getStrictness() {
        return this.strictness;
    }

    public void markStubUsed(DescribedInvocation describedInvocation) {
        synchronized (this.usedAtLock) {
            this.usedAt = describedInvocation;
        }
    }

    public String toString() {
        return super.toString() + " stubbed with: " + this.answers;
    }

    public boolean wasUsed() {
        boolean z11;
        synchronized (this.usedAtLock) {
            if (this.usedAt != null) {
                z11 = true;
            } else {
                z11 = false;
            }
        }
        return z11;
    }
}
