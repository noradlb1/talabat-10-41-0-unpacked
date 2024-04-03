package org.mockito;

import java.io.Serializable;
import org.mockito.listeners.InvocationListener;
import org.mockito.listeners.StubbingLookupListener;
import org.mockito.listeners.VerificationStartedListener;
import org.mockito.mock.MockCreationSettings;
import org.mockito.mock.SerializableMode;
import org.mockito.stubbing.Answer;

@NotExtensible
public interface MockSettings extends Serializable {
    <T> MockCreationSettings<T> build(Class<T> cls);

    <T> MockCreationSettings<T> buildStatic(Class<T> cls);

    MockSettings defaultAnswer(Answer answer);

    MockSettings extraInterfaces(Class<?>... clsArr);

    MockSettings invocationListeners(InvocationListener... invocationListenerArr);

    MockSettings lenient();

    MockSettings name(String str);

    MockSettings outerInstance(Object obj);

    MockSettings serializable();

    MockSettings serializable(SerializableMode serializableMode);

    MockSettings spiedInstance(Object obj);

    MockSettings stubOnly();

    MockSettings stubbingLookupListeners(StubbingLookupListener... stubbingLookupListenerArr);

    MockSettings useConstructor(Object... objArr);

    MockSettings verboseLogging();

    MockSettings verificationStartedListeners(VerificationStartedListener... verificationStartedListenerArr);

    MockSettings withoutAnnotations();
}
