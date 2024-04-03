package org.mockito.junit;

import org.junit.rules.TestRule;
import org.mockito.quality.Strictness;

public interface MockitoTestRule extends TestRule {
    MockitoTestRule silent();

    MockitoTestRule strictness(Strictness strictness);
}
