package org.mockito.internal.progress;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import org.mockito.ArgumentMatcher;
import org.mockito.internal.exceptions.Reporter;
import org.mockito.internal.matchers.And;
import org.mockito.internal.matchers.LocalizedMatcher;
import org.mockito.internal.matchers.Not;
import org.mockito.internal.matchers.Or;

public class ArgumentMatcherStorageImpl implements ArgumentMatcherStorage {
    private static final int ONE_SUB_MATCHER = 1;
    private static final int TWO_SUB_MATCHERS = 2;
    private final Stack<LocalizedMatcher> matcherStack = new Stack<>();

    private void assertStateFor(String str, int i11) {
        if (this.matcherStack.isEmpty()) {
            throw Reporter.reportNoSubMatchersFound(str);
        } else if (this.matcherStack.size() < i11) {
            throw Reporter.incorrectUseOfAdditionalMatchers(str, i11, resetStack());
        }
    }

    private ArgumentMatcher<?> popMatcher() {
        return this.matcherStack.pop().getMatcher();
    }

    private List<LocalizedMatcher> resetStack() {
        ArrayList arrayList = new ArrayList(this.matcherStack);
        reset();
        return arrayList;
    }

    public List<LocalizedMatcher> pullLocalizedMatchers() {
        if (this.matcherStack.isEmpty()) {
            return Collections.emptyList();
        }
        return resetStack();
    }

    public void reportAnd() {
        assertStateFor("And(?)", 2);
        reportMatcher(new And(popMatcher(), popMatcher()));
    }

    public void reportMatcher(ArgumentMatcher<?> argumentMatcher) {
        this.matcherStack.push(new LocalizedMatcher(argumentMatcher));
    }

    public void reportNot() {
        assertStateFor("Not(?)", 1);
        reportMatcher(new Not(popMatcher()));
    }

    public void reportOr() {
        assertStateFor("Or(?)", 2);
        reportMatcher(new Or(popMatcher(), popMatcher()));
    }

    public void reset() {
        this.matcherStack.clear();
    }

    public void validateState() {
        if (!this.matcherStack.isEmpty()) {
            throw Reporter.misplacedArgumentMatcher(resetStack());
        }
    }
}
