package org.mockito;

import org.mockito.quality.Strictness;

@NotExtensible
public interface MockitoSession {
    void finishMocking();

    void finishMocking(Throwable th2);

    void setStrictness(Strictness strictness);
}
