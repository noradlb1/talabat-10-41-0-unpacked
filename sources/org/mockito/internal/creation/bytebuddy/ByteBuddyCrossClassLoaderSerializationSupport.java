package org.mockito.internal.creation.bytebuddy;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.mockito.exceptions.base.MockitoSerializationIssue;
import org.mockito.internal.configuration.plugins.Plugins;
import org.mockito.internal.creation.settings.CreationSettings;
import org.mockito.internal.util.MockUtil;
import org.mockito.internal.util.StringUtil;
import org.mockito.mock.MockCreationSettings;
import org.mockito.mock.MockName;
import org.mockito.mock.SerializableMode;
import org.mockito.plugins.MemberAccessor;

class ByteBuddyCrossClassLoaderSerializationSupport implements Serializable {
    private static final String MOCKITO_PROXY_MARKER = "ByteBuddyMockitoProxyMarker";
    private static final long serialVersionUID = 7411152578314420778L;
    private boolean instanceLocalCurrentlySerializingFlag = false;
    private final Lock mutex = new ReentrantLock();

    public interface CrossClassLoaderSerializableMock {
        Object writeReplace();
    }

    public static class CrossClassLoaderSerializationProxy implements Serializable {
        private static final long serialVersionUID = -7600267929109286514L;
        private final Set<Class<?>> extraInterfaces;
        private final byte[] serializedMock;
        private final Class<?> typeToMock;

        public CrossClassLoaderSerializationProxy(Object obj) throws IOException {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            MockitoMockObjectOutputStream mockitoMockObjectOutputStream = new MockitoMockObjectOutputStream(byteArrayOutputStream);
            mockitoMockObjectOutputStream.writeObject(obj);
            mockitoMockObjectOutputStream.close();
            byteArrayOutputStream.close();
            MockCreationSettings mockSettings = MockUtil.getMockSettings(obj);
            this.serializedMock = byteArrayOutputStream.toByteArray();
            this.typeToMock = mockSettings.getTypeToMock();
            this.extraInterfaces = mockSettings.getExtraInterfaces();
        }

        private Object readResolve() throws ObjectStreamException {
            try {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(this.serializedMock);
                MockitoMockObjectInputStream mockitoMockObjectInputStream = new MockitoMockObjectInputStream(byteArrayInputStream, this.typeToMock, this.extraInterfaces);
                Object readObject = mockitoMockObjectInputStream.readObject();
                byteArrayInputStream.close();
                mockitoMockObjectInputStream.close();
                return readObject;
            } catch (IOException e11) {
                throw new MockitoSerializationIssue(StringUtil.join("Mockito mock cannot be deserialized to a mock of '" + this.typeToMock.getCanonicalName() + "'. The error was :", "  " + e11.getMessage(), "If you are unsure what is the reason of this exception, feel free to contact us on the mailing list."), e11);
            } catch (ClassNotFoundException e12) {
                throw new MockitoSerializationIssue(StringUtil.join("A class couldn't be found while deserializing a Mockito mock, you should check your classpath. The error was :", "  " + e12.getMessage(), "If you are still unsure what is the reason of this exception, feel free to contact us on the mailing list."), e12);
            }
        }
    }

    public static class MockitoMockObjectInputStream extends ObjectInputStream {
        private final Set<Class<?>> extraInterfaces;
        private final Class<?> typeToMock;

        public MockitoMockObjectInputStream(InputStream inputStream, Class<?> cls, Set<Class<?>> set) throws IOException {
            super(inputStream);
            this.typeToMock = cls;
            this.extraInterfaces = set;
            enableResolveObject(true);
        }

        private void hackClassNameToMatchNewlyCreatedClass(ObjectStreamClass objectStreamClass, Class<?> cls) throws ObjectStreamException {
            Field declaredField;
            try {
                MemberAccessor memberAccessor = Plugins.getMemberAccessor();
                declaredField = objectStreamClass.getClass().getDeclaredField("name");
                memberAccessor.set(declaredField, objectStreamClass, cls.getCanonicalName());
            } catch (IllegalAccessException e11) {
                throw new MockitoSerializationIssue("Access to " + declaredField + " was denied", e11);
            } catch (NoSuchFieldException e12) {
                throw new MockitoSerializationIssue(StringUtil.join("Wow, the class 'ObjectStreamClass' in the JDK don't have the field 'name',", "this is definitely a bug in our code as it means the JDK team changed a few internal things.", "", "Please report an issue with the JDK used, a code sample and a link to download the JDK would be welcome."), e12);
            }
        }

        private boolean notMarkedAsAMockitoMock(Object obj) {
            return !ByteBuddyCrossClassLoaderSerializationSupport.MOCKITO_PROXY_MARKER.equals(obj);
        }

        public Class<?> resolveClass(ObjectStreamClass objectStreamClass) throws IOException, ClassNotFoundException {
            if (notMarkedAsAMockitoMock(readObject())) {
                return super.resolveClass(objectStreamClass);
            }
            try {
                Class<?> createMockType = ((ClassCreatingMockMaker) Plugins.getMockMaker()).createMockType(new CreationSettings().setTypeToMock(this.typeToMock).setExtraInterfaces(this.extraInterfaces).setSerializableMode(SerializableMode.ACROSS_CLASSLOADERS));
                hackClassNameToMatchNewlyCreatedClass(objectStreamClass, createMockType);
                return createMockType;
            } catch (ClassCastException e11) {
                throw new MockitoSerializationIssue(StringUtil.join("A Byte Buddy-generated mock cannot be deserialized into a non-Byte Buddy generated mock class", "", "The mock maker in use was: " + Plugins.getMockMaker().getClass()), e11);
            }
        }
    }

    public static class MockitoMockObjectOutputStream extends ObjectOutputStream {
        private static final String NOTHING = "";

        public MockitoMockObjectOutputStream(ByteArrayOutputStream byteArrayOutputStream) throws IOException {
            super(byteArrayOutputStream);
        }

        private String mockitoProxyClassMarker(Class<?> cls) {
            return CrossClassLoaderSerializableMock.class.isAssignableFrom(cls) ? ByteBuddyCrossClassLoaderSerializationSupport.MOCKITO_PROXY_MARKER : "";
        }

        public void annotateClass(Class<?> cls) throws IOException {
            writeObject(mockitoProxyClassMarker(cls));
        }
    }

    private boolean mockIsCurrentlyBeingReplaced() {
        return this.instanceLocalCurrentlySerializingFlag;
    }

    private void mockReplacementCompleted() {
        this.instanceLocalCurrentlySerializingFlag = false;
    }

    private void mockReplacementStarted() {
        this.instanceLocalCurrentlySerializingFlag = true;
    }

    public Object writeReplace(Object obj) throws ObjectStreamException {
        this.mutex.lock();
        try {
            if (mockIsCurrentlyBeingReplaced()) {
                mockReplacementCompleted();
                this.mutex.unlock();
                return obj;
            }
            mockReplacementStarted();
            CrossClassLoaderSerializationProxy crossClassLoaderSerializationProxy = new CrossClassLoaderSerializationProxy(obj);
            mockReplacementCompleted();
            this.mutex.unlock();
            return crossClassLoaderSerializationProxy;
        } catch (IOException e11) {
            MockName mockName = MockUtil.getMockName(obj);
            String canonicalName = MockUtil.getMockSettings(obj).getTypeToMock().getCanonicalName();
            throw new MockitoSerializationIssue(StringUtil.join("The mock '" + mockName + "' of type '" + canonicalName + "'", "The Java Standard Serialization reported an '" + e11.getClass().getSimpleName() + "' saying :", "  " + e11.getMessage()), e11);
        } catch (Throwable th2) {
            mockReplacementCompleted();
            this.mutex.unlock();
            throw th2;
        }
    }
}
