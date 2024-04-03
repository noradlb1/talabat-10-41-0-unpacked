package org.mockito.internal.invocation;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import org.mockito.ArgumentMatcher;
import org.mockito.internal.exceptions.Reporter;
import org.mockito.internal.exceptions.VerificationAwareInvocation;
import org.mockito.internal.invocation.mockref.MockReference;
import org.mockito.internal.reporting.PrintSettings;
import org.mockito.invocation.Invocation;
import org.mockito.invocation.Location;
import org.mockito.invocation.StubInfo;

public class InterceptedInvocation implements Invocation, VerificationAwareInvocation {
    public static final RealMethod NO_OP = new RealMethod() {
        public Object invoke() throws Throwable {
            return null;
        }

        public boolean isInvokable() {
            return false;
        }
    };
    private static final long serialVersionUID = 475027563923510472L;
    private final Object[] arguments;
    private boolean isIgnoredForVerification;
    private final Location location;
    private final MockReference<Object> mockRef;
    private final MockitoMethod mockitoMethod;
    private final Object[] rawArguments;
    private final RealMethod realMethod;
    private final int sequenceNumber;
    private StubInfo stubInfo;
    private boolean verified;

    public InterceptedInvocation(MockReference<Object> mockReference, MockitoMethod mockitoMethod2, Object[] objArr, RealMethod realMethod2, Location location2, int i11) {
        this.mockRef = mockReference;
        this.mockitoMethod = mockitoMethod2;
        this.arguments = ArgumentsProcessor.expandArgs(mockitoMethod2, objArr);
        this.rawArguments = objArr;
        this.realMethod = realMethod2;
        this.location = location2;
        this.sequenceNumber = i11;
    }

    private boolean equalArguments(Object[] objArr) {
        return Arrays.equals(objArr, this.arguments);
    }

    public Object callRealMethod() throws Throwable {
        if (this.realMethod.isInvokable()) {
            return this.realMethod.invoke();
        }
        throw Reporter.cannotCallAbstractRealMethod();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof InterceptedInvocation)) {
            return false;
        }
        InterceptedInvocation interceptedInvocation = (InterceptedInvocation) obj;
        if (!this.mockRef.get().equals(interceptedInvocation.mockRef.get()) || !this.mockitoMethod.equals(interceptedInvocation.mockitoMethod) || !equalArguments(interceptedInvocation.arguments)) {
            return false;
        }
        return true;
    }

    public <T> T getArgument(int i11) {
        return this.arguments[i11];
    }

    public Object[] getArguments() {
        return this.arguments;
    }

    public List<ArgumentMatcher> getArgumentsAsMatchers() {
        return ArgumentsProcessor.argumentsToMatchers(getArguments());
    }

    public Location getLocation() {
        return this.location;
    }

    public Method getMethod() {
        return this.mockitoMethod.getJavaMethod();
    }

    public Object getMock() {
        return this.mockRef.get();
    }

    @Deprecated
    public MockReference<Object> getMockRef() {
        return this.mockRef;
    }

    @Deprecated
    public MockitoMethod getMockitoMethod() {
        return this.mockitoMethod;
    }

    public Object[] getRawArguments() {
        return this.rawArguments;
    }

    public Class<?> getRawReturnType() {
        return this.mockitoMethod.getReturnType();
    }

    @Deprecated
    public RealMethod getRealMethod() {
        return this.realMethod;
    }

    public int getSequenceNumber() {
        return this.sequenceNumber;
    }

    public int hashCode() {
        return 1;
    }

    public void ignoreForVerification() {
        this.isIgnoredForVerification = true;
    }

    public boolean isIgnoredForVerification() {
        return this.isIgnoredForVerification;
    }

    public boolean isVerified() {
        return this.verified || this.isIgnoredForVerification;
    }

    public void markStubbed(StubInfo stubInfo2) {
        this.stubInfo = stubInfo2;
    }

    public void markVerified() {
        this.verified = true;
    }

    public StubInfo stubInfo() {
        return this.stubInfo;
    }

    public String toString() {
        return new PrintSettings().print(getArgumentsAsMatchers(), this);
    }

    public <T> T getArgument(int i11, Class<T> cls) {
        return cls.cast(this.arguments[i11]);
    }
}
