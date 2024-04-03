package org.mockito.junit;

import org.junit.rules.MethodRule;
import org.mockito.quality.Strictness;

public interface MockitoRule extends MethodRule {
    MockitoRule silent();

    MockitoRule strictness(Strictness strictness);
}
