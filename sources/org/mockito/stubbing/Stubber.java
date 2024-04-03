package org.mockito.stubbing;

import org.mockito.CheckReturnValue;
import org.mockito.NotExtensible;

@CheckReturnValue
@NotExtensible
public interface Stubber extends BaseStubber {
    <T> T when(T t11);
}
