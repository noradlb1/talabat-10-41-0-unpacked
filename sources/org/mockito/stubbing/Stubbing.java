package org.mockito.stubbing;

import org.mockito.NotExtensible;
import org.mockito.invocation.Invocation;
import org.mockito.quality.Strictness;

@NotExtensible
public interface Stubbing extends Answer {
    Invocation getInvocation();

    Strictness getStrictness();

    boolean wasUsed();
}
