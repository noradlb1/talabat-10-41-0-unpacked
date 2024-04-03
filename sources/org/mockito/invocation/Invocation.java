package org.mockito.invocation;

import java.util.List;
import org.mockito.ArgumentMatcher;
import org.mockito.NotExtensible;

@NotExtensible
public interface Invocation extends InvocationOnMock, DescribedInvocation {
    List<ArgumentMatcher> getArgumentsAsMatchers();

    Location getLocation();

    Object[] getRawArguments();

    Class<?> getRawReturnType();

    int getSequenceNumber();

    void ignoreForVerification();

    boolean isIgnoredForVerification();

    boolean isVerified();

    void markStubbed(StubInfo stubInfo);

    void markVerified();

    StubInfo stubInfo();
}
