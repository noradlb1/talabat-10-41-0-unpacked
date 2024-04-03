package org.mockito.junit;

import org.junit.rules.TestRule;
import org.mockito.exceptions.base.MockitoAssertionError;

public interface VerificationCollector extends TestRule {
    VerificationCollector assertLazily();

    void collectAndReport() throws MockitoAssertionError;
}
