package org.mockito.internal.junit;

import org.mockito.exceptions.verification.opentest4j.ArgumentsAreDifferent;
import org.mockito.internal.junit.ExceptionFactory;

public final /* synthetic */ class a implements ExceptionFactory.ExceptionFactoryImpl {
    public final AssertionError create(String str, String str2, String str3) {
        return new ArgumentsAreDifferent(str, str2, str3);
    }
}
