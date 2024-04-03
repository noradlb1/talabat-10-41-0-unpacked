package org.mockito.stubbing;

import org.mockito.CheckReturnValue;
import org.mockito.NotExtensible;

@NotExtensible
public interface LenientStubber extends BaseStubber {
    @CheckReturnValue
    <T> OngoingStubbing<T> when(T t11);
}
