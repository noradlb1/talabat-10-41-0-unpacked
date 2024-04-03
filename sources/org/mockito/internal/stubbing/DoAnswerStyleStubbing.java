package org.mockito.internal.stubbing;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.mockito.quality.Strictness;
import org.mockito.stubbing.Answer;

class DoAnswerStyleStubbing implements Serializable {
    private final List<Answer<?>> answers = new ArrayList();
    private Strictness stubbingStrictness;

    public void a() {
        this.answers.clear();
        this.stubbingStrictness = null;
    }

    public List<Answer<?>> b() {
        return this.answers;
    }

    public Strictness c() {
        return this.stubbingStrictness;
    }

    public boolean d() {
        return this.answers.isEmpty();
    }

    public void e(List<Answer<?>> list, Strictness strictness) {
        this.stubbingStrictness = strictness;
        this.answers.addAll(list);
    }
}
