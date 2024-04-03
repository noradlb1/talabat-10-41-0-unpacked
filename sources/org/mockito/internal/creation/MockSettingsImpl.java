package org.mockito.internal.creation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.mockito.MockSettings;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.internal.creation.settings.CreationSettings;
import org.mockito.internal.debugging.VerboseMockInvocationLogger;
import org.mockito.internal.exceptions.Reporter;
import org.mockito.internal.util.Checks;
import org.mockito.internal.util.MockCreationValidator;
import org.mockito.internal.util.MockNameImpl;
import org.mockito.internal.util.collections.Sets;
import org.mockito.listeners.InvocationListener;
import org.mockito.listeners.StubbingLookupListener;
import org.mockito.listeners.VerificationStartedListener;
import org.mockito.mock.MockCreationSettings;
import org.mockito.mock.MockName;
import org.mockito.mock.SerializableMode;
import org.mockito.stubbing.Answer;

public class MockSettingsImpl<T> extends CreationSettings<T> implements MockSettings {
    private static final long serialVersionUID = 4475297236197939569L;
    private Object[] constructorArgs;
    private Object outerClassInstance;
    private boolean useConstructor;

    public static <T> void a(T[] tArr, List<T> list, String str) {
        if (tArr == null) {
            throw Reporter.methodDoesNotAcceptParameter(str, "null vararg array.");
        } else if (tArr.length != 0) {
            int length = tArr.length;
            int i11 = 0;
            while (i11 < length) {
                T t11 = tArr[i11];
                if (t11 != null) {
                    list.add(t11);
                    i11++;
                } else {
                    throw Reporter.methodDoesNotAcceptParameter(str, "null listeners.");
                }
            }
        } else {
            throw Reporter.requiresAtLeastOneListener(str);
        }
    }

    private boolean invocationListenersContainsType(Class<?> cls) {
        for (InvocationListener invocationListener : this.f63194i) {
            if (invocationListener.getClass().equals(cls)) {
                return true;
            }
        }
        return false;
    }

    private static Set<Class<?>> prepareExtraInterfaces(CreationSettings creationSettings) {
        HashSet hashSet = new HashSet(creationSettings.getExtraInterfaces());
        if (creationSettings.isSerializable()) {
            hashSet.add(Serializable.class);
        }
        return hashSet;
    }

    private static <T> CreationSettings<T> validatedSettings(Class<T> cls, CreationSettings<T> creationSettings) {
        MockCreationValidator mockCreationValidator = new MockCreationValidator();
        mockCreationValidator.validateType(cls);
        mockCreationValidator.validateExtraInterfaces(cls, creationSettings.getExtraInterfaces());
        mockCreationValidator.validateMockedType(cls, creationSettings.getSpiedInstance());
        mockCreationValidator.validateConstructorUse(creationSettings.isUsingConstructor(), creationSettings.getSerializableMode());
        CreationSettings<T> creationSettings2 = new CreationSettings<>(creationSettings);
        creationSettings2.setMockName(new MockNameImpl(creationSettings.getName(), cls, false));
        creationSettings2.setTypeToMock(cls);
        creationSettings2.setExtraInterfaces(prepareExtraInterfaces(creationSettings));
        return creationSettings2;
    }

    private static <T> CreationSettings<T> validatedStaticSettings(Class<T> cls, CreationSettings<T> creationSettings) {
        if (cls.isPrimitive()) {
            throw new MockitoException("Cannot create static mock of primitive type " + cls);
        } else if (!creationSettings.getExtraInterfaces().isEmpty()) {
            throw new MockitoException("Cannot specify additional interfaces for static mock of " + cls);
        } else if (creationSettings.getSpiedInstance() == null) {
            CreationSettings<T> creationSettings2 = new CreationSettings<>(creationSettings);
            creationSettings2.setMockName(new MockNameImpl(creationSettings.getName(), cls, true));
            creationSettings2.setTypeToMock(cls);
            return creationSettings2;
        } else {
            throw new MockitoException("Cannot specify spied instance for static mock of " + cls);
        }
    }

    public <T2> MockCreationSettings<T2> build(Class<T2> cls) {
        return validatedSettings(cls, this);
    }

    public <T2> MockCreationSettings<T2> buildStatic(Class<T2> cls) {
        return validatedStaticSettings(cls, this);
    }

    public MockSettings defaultAnswer(Answer answer) {
        this.f63191f = answer;
        if (answer != null) {
            return this;
        }
        throw Reporter.defaultAnswerDoesNotAcceptNullParameter();
    }

    public MockSettings extraInterfaces(Class<?>... clsArr) {
        if (clsArr == null || clsArr.length == 0) {
            throw Reporter.extraInterfacesRequiresAtLeastOneInterface();
        }
        int length = clsArr.length;
        int i11 = 0;
        while (i11 < length) {
            Class<?> cls = clsArr[i11];
            if (cls == null) {
                throw Reporter.extraInterfacesDoesNotAcceptNullParameters();
            } else if (cls.isInterface()) {
                i11++;
            } else {
                throw Reporter.extraInterfacesAcceptsOnlyInterfaces(cls);
            }
        }
        this.f63188c = Sets.newSet(clsArr);
        return this;
    }

    public Object[] getConstructorArgs() {
        if (this.outerClassInstance == null) {
            return this.constructorArgs;
        }
        ArrayList arrayList = new ArrayList(this.constructorArgs.length + 1);
        arrayList.add(this.outerClassInstance);
        arrayList.addAll(Arrays.asList(this.constructorArgs));
        return arrayList.toArray(new Object[(this.constructorArgs.length + 1)]);
    }

    public Answer<Object> getDefaultAnswer() {
        return this.f63191f;
    }

    public Set<Class<?>> getExtraInterfaces() {
        return this.f63188c;
    }

    public MockName getMockName() {
        return this.f63192g;
    }

    public Object getOuterClassInstance() {
        return this.outerClassInstance;
    }

    public Object getSpiedInstance() {
        return this.f63190e;
    }

    public Class<T> getTypeToMock() {
        return this.f63187b;
    }

    public boolean hasInvocationListeners() {
        return !getInvocationListeners().isEmpty();
    }

    public MockSettings invocationListeners(InvocationListener... invocationListenerArr) {
        a(invocationListenerArr, this.f63194i, "invocationListeners");
        return this;
    }

    public boolean isStubOnly() {
        return this.f63197l;
    }

    public boolean isUsingConstructor() {
        return this.useConstructor;
    }

    public MockSettings lenient() {
        this.f63199n = true;
        return this;
    }

    public MockSettings name(String str) {
        this.f63189d = str;
        return this;
    }

    public MockSettings outerInstance(Object obj) {
        this.outerClassInstance = obj;
        return this;
    }

    public MockSettings serializable() {
        return serializable(SerializableMode.BASIC);
    }

    public MockSettings spiedInstance(Object obj) {
        this.f63190e = obj;
        return this;
    }

    public MockSettings stubbingLookupListeners(StubbingLookupListener... stubbingLookupListenerArr) {
        a(stubbingLookupListenerArr, this.f63195j, "stubbingLookupListeners");
        return this;
    }

    public MockSettings useConstructor(Object... objArr) {
        Checks.checkNotNull(objArr, "constructorArgs", "If you need to pass null, please cast it to the right type, e.g.: useConstructor((String) null)");
        this.useConstructor = true;
        this.constructorArgs = objArr;
        return this;
    }

    public MockSettings verboseLogging() {
        if (!invocationListenersContainsType(VerboseMockInvocationLogger.class)) {
            invocationListeners(new VerboseMockInvocationLogger());
        }
        return this;
    }

    public MockSettings verificationStartedListeners(VerificationStartedListener... verificationStartedListenerArr) {
        a(verificationStartedListenerArr, this.f63196k, "verificationStartedListeners");
        return this;
    }

    public MockSettings withoutAnnotations() {
        this.f63198m = true;
        return this;
    }

    public MockSettings serializable(SerializableMode serializableMode) {
        this.f63193h = serializableMode;
        return this;
    }

    public MockSettingsImpl<T> stubOnly() {
        this.f63197l = true;
        return this;
    }
}
