package org.mockito.internal.creation.settings;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import org.mockito.listeners.InvocationListener;
import org.mockito.listeners.StubbingLookupListener;
import org.mockito.listeners.VerificationStartedListener;
import org.mockito.mock.MockCreationSettings;
import org.mockito.mock.MockName;
import org.mockito.mock.SerializableMode;
import org.mockito.stubbing.Answer;

public class CreationSettings<T> implements MockCreationSettings<T>, Serializable {
    private static final long serialVersionUID = -6789800638070123629L;

    /* renamed from: b  reason: collision with root package name */
    public Class<T> f63187b;

    /* renamed from: c  reason: collision with root package name */
    public Set<Class<?>> f63188c = new LinkedHashSet();
    private Object[] constructorArgs;

    /* renamed from: d  reason: collision with root package name */
    public String f63189d;

    /* renamed from: e  reason: collision with root package name */
    public Object f63190e;

    /* renamed from: f  reason: collision with root package name */
    public Answer<Object> f63191f;

    /* renamed from: g  reason: collision with root package name */
    public MockName f63192g;

    /* renamed from: h  reason: collision with root package name */
    public SerializableMode f63193h = SerializableMode.NONE;

    /* renamed from: i  reason: collision with root package name */
    public List<InvocationListener> f63194i = new ArrayList();

    /* renamed from: j  reason: collision with root package name */
    public List<StubbingLookupListener> f63195j = new CopyOnWriteArrayList();

    /* renamed from: k  reason: collision with root package name */
    public List<VerificationStartedListener> f63196k = new LinkedList();

    /* renamed from: l  reason: collision with root package name */
    public boolean f63197l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f63198m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f63199n;
    private Object outerClassInstance;
    private boolean useConstructor;

    public CreationSettings() {
    }

    public Object[] getConstructorArgs() {
        return this.constructorArgs;
    }

    public Answer<Object> getDefaultAnswer() {
        return this.f63191f;
    }

    public Set<Class<?>> getExtraInterfaces() {
        return this.f63188c;
    }

    public List<InvocationListener> getInvocationListeners() {
        return this.f63194i;
    }

    public MockName getMockName() {
        return this.f63192g;
    }

    public String getName() {
        return this.f63189d;
    }

    public Object getOuterClassInstance() {
        return this.outerClassInstance;
    }

    public SerializableMode getSerializableMode() {
        return this.f63193h;
    }

    public Object getSpiedInstance() {
        return this.f63190e;
    }

    public List<StubbingLookupListener> getStubbingLookupListeners() {
        return this.f63195j;
    }

    public Class<T> getTypeToMock() {
        return this.f63187b;
    }

    public List<VerificationStartedListener> getVerificationStartedListeners() {
        return this.f63196k;
    }

    public boolean isLenient() {
        return this.f63199n;
    }

    public boolean isSerializable() {
        return this.f63193h != SerializableMode.NONE;
    }

    public boolean isStripAnnotations() {
        return this.f63198m;
    }

    public boolean isStubOnly() {
        return this.f63197l;
    }

    public boolean isUsingConstructor() {
        return this.useConstructor;
    }

    public CreationSettings<T> setExtraInterfaces(Set<Class<?>> set) {
        this.f63188c = set;
        return this;
    }

    public CreationSettings<T> setMockName(MockName mockName) {
        this.f63192g = mockName;
        return this;
    }

    public CreationSettings<T> setSerializableMode(SerializableMode serializableMode) {
        this.f63193h = serializableMode;
        return this;
    }

    public CreationSettings<T> setTypeToMock(Class<T> cls) {
        this.f63187b = cls;
        return this;
    }

    public CreationSettings(CreationSettings creationSettings) {
        this.f63187b = creationSettings.f63187b;
        this.f63188c = creationSettings.f63188c;
        this.f63189d = creationSettings.f63189d;
        this.f63190e = creationSettings.f63190e;
        this.f63191f = creationSettings.f63191f;
        this.f63192g = creationSettings.f63192g;
        this.f63193h = creationSettings.f63193h;
        this.f63194i = creationSettings.f63194i;
        this.f63195j = creationSettings.f63195j;
        this.f63196k = creationSettings.f63196k;
        this.f63197l = creationSettings.f63197l;
        this.useConstructor = creationSettings.isUsingConstructor();
        this.outerClassInstance = creationSettings.getOuterClassInstance();
        this.constructorArgs = creationSettings.getConstructorArgs();
        this.f63199n = creationSettings.f63199n;
        this.f63198m = creationSettings.f63198m;
    }
}
