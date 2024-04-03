package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.AbstractMessageLite;
import androidx.datastore.preferences.protobuf.ArrayDecoders;
import androidx.datastore.preferences.protobuf.FieldSet;
import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import androidx.datastore.preferences.protobuf.GeneratedMessageLite.Builder;
import androidx.datastore.preferences.protobuf.Internal;
import androidx.datastore.preferences.protobuf.MessageLite;
import androidx.datastore.preferences.protobuf.WireFormat;
import com.huawei.agconnect.config.impl.Utils;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class GeneratedMessageLite<MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> extends AbstractMessageLite<MessageType, BuilderType> {
    private static Map<Object, GeneratedMessageLite<?, ?>> defaultInstanceMap = new ConcurrentHashMap();
    protected int memoizedSerializedSize = -1;
    protected UnknownFieldSetLite unknownFields = UnknownFieldSetLite.getDefaultInstance();

    /* renamed from: androidx.datastore.preferences.protobuf.GeneratedMessageLite$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f35782a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                androidx.datastore.preferences.protobuf.WireFormat$JavaType[] r0 = androidx.datastore.preferences.protobuf.WireFormat.JavaType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f35782a = r0
                androidx.datastore.preferences.protobuf.WireFormat$JavaType r1 = androidx.datastore.preferences.protobuf.WireFormat.JavaType.MESSAGE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f35782a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.datastore.preferences.protobuf.WireFormat$JavaType r1 = androidx.datastore.preferences.protobuf.WireFormat.JavaType.ENUM     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.GeneratedMessageLite.AnonymousClass1.<clinit>():void");
        }
    }

    public static abstract class Builder<MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> extends AbstractMessageLite.Builder<MessageType, BuilderType> {

        /* renamed from: b  reason: collision with root package name */
        public MessageType f35783b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f35784c = false;
        private final MessageType defaultInstance;

        public Builder(MessageType messagetype) {
            this.defaultInstance = messagetype;
            this.f35783b = (GeneratedMessageLite) messagetype.k(MethodToInvoke.NEW_MUTABLE_INSTANCE);
        }

        private void mergeFromInstance(MessageType messagetype, MessageType messagetype2) {
            Protobuf.getInstance().schemaFor(messagetype).mergeFrom(messagetype, messagetype2);
        }

        public void d() {
            if (this.f35784c) {
                MessageType messagetype = (GeneratedMessageLite) this.f35783b.k(MethodToInvoke.NEW_MUTABLE_INSTANCE);
                mergeFromInstance(messagetype, this.f35783b);
                this.f35783b = messagetype;
                this.f35784c = false;
            }
        }

        /* renamed from: e */
        public BuilderType b(MessageType messagetype) {
            return mergeFrom(messagetype);
        }

        public final boolean isInitialized() {
            return GeneratedMessageLite.q(this.f35783b, false);
        }

        public final MessageType build() {
            MessageType buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw AbstractMessageLite.Builder.c(buildPartial);
        }

        public MessageType buildPartial() {
            if (this.f35784c) {
                return this.f35783b;
            }
            this.f35783b.r();
            this.f35784c = true;
            return this.f35783b;
        }

        public final BuilderType clear() {
            this.f35783b = (GeneratedMessageLite) this.f35783b.k(MethodToInvoke.NEW_MUTABLE_INSTANCE);
            return this;
        }

        public MessageType getDefaultInstanceForType() {
            return this.defaultInstance;
        }

        public BuilderType clone() {
            BuilderType newBuilderForType = getDefaultInstanceForType().newBuilderForType();
            newBuilderForType.mergeFrom(buildPartial());
            return newBuilderForType;
        }

        public BuilderType mergeFrom(MessageType messagetype) {
            d();
            mergeFromInstance(this.f35783b, messagetype);
            return this;
        }

        public BuilderType mergeFrom(byte[] bArr, int i11, int i12, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            d();
            try {
                Protobuf.getInstance().schemaFor(this.f35783b).mergeFrom(this.f35783b, bArr, i11, i11 + i12, new ArrayDecoders.Registers(extensionRegistryLite));
                return this;
            } catch (InvalidProtocolBufferException e11) {
                throw e11;
            } catch (IndexOutOfBoundsException unused) {
                throw InvalidProtocolBufferException.j();
            } catch (IOException e12) {
                throw new RuntimeException("Reading from byte array should not throw IOException.", e12);
            }
        }

        public BuilderType mergeFrom(byte[] bArr, int i11, int i12) throws InvalidProtocolBufferException {
            return mergeFrom(bArr, i11, i12, ExtensionRegistryLite.getEmptyRegistry());
        }

        public BuilderType mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            d();
            try {
                Protobuf.getInstance().schemaFor(this.f35783b).mergeFrom(this.f35783b, CodedInputStreamReader.forCodedInput(codedInputStream), extensionRegistryLite);
                return this;
            } catch (RuntimeException e11) {
                if (e11.getCause() instanceof IOException) {
                    throw ((IOException) e11.getCause());
                }
                throw e11;
            }
        }
    }

    public static abstract class ExtendableBuilder<MessageType extends ExtendableMessage<MessageType, BuilderType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>> extends Builder<MessageType, BuilderType> implements ExtendableMessageOrBuilder<MessageType, BuilderType> {
        private FieldSet<ExtensionDescriptor> ensureExtensionsAreMutable() {
            FieldSet<ExtensionDescriptor> fieldSet = ((ExtendableMessage) this.f35783b).extensions;
            if (!fieldSet.isImmutable()) {
                return fieldSet;
            }
            FieldSet<ExtensionDescriptor> clone = fieldSet.clone();
            ((ExtendableMessage) this.f35783b).extensions = clone;
            return clone;
        }

        private void verifyExtensionContainingType(GeneratedExtension<MessageType, ?> generatedExtension) {
            if (generatedExtension.getContainingTypeDefaultInstance() != getDefaultInstanceForType()) {
                throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
            }
        }

        public final <Type> BuilderType addExtension(ExtensionLite<MessageType, List<Type>> extensionLite, Type type) {
            GeneratedExtension g11 = GeneratedMessageLite.checkIsLite(extensionLite);
            verifyExtensionContainingType(g11);
            d();
            ensureExtensionsAreMutable().addRepeatedField(g11.f35794d, g11.d(type));
            return this;
        }

        public final <Type> BuilderType clearExtension(ExtensionLite<MessageType, ?> extensionLite) {
            GeneratedExtension g11 = GeneratedMessageLite.checkIsLite(extensionLite);
            verifyExtensionContainingType(g11);
            d();
            ensureExtensionsAreMutable().clearField(g11.f35794d);
            return this;
        }

        public void d() {
            if (this.f35784c) {
                super.d();
                MessageType messagetype = this.f35783b;
                ((ExtendableMessage) messagetype).extensions = ((ExtendableMessage) messagetype).extensions.clone();
            }
        }

        public final <Type> Type getExtension(ExtensionLite<MessageType, Type> extensionLite) {
            return ((ExtendableMessage) this.f35783b).getExtension(extensionLite);
        }

        public final <Type> int getExtensionCount(ExtensionLite<MessageType, List<Type>> extensionLite) {
            return ((ExtendableMessage) this.f35783b).getExtensionCount(extensionLite);
        }

        public final <Type> boolean hasExtension(ExtensionLite<MessageType, Type> extensionLite) {
            return ((ExtendableMessage) this.f35783b).hasExtension(extensionLite);
        }

        public final <Type> BuilderType setExtension(ExtensionLite<MessageType, Type> extensionLite, Type type) {
            GeneratedExtension g11 = GeneratedMessageLite.checkIsLite(extensionLite);
            verifyExtensionContainingType(g11);
            d();
            ensureExtensionsAreMutable().setField(g11.f35794d, g11.e(type));
            return this;
        }

        /* JADX WARNING: type inference failed for: r2v0, types: [androidx.datastore.preferences.protobuf.ExtensionLite, androidx.datastore.preferences.protobuf.ExtensionLite<MessageType, java.util.List<Type>>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final <Type> Type getExtension(androidx.datastore.preferences.protobuf.ExtensionLite<MessageType, java.util.List<Type>> r2, int r3) {
            /*
                r1 = this;
                MessageType r0 = r1.f35783b
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtendableMessage r0 = (androidx.datastore.preferences.protobuf.GeneratedMessageLite.ExtendableMessage) r0
                java.lang.Object r2 = r0.getExtension(r2, r3)
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.GeneratedMessageLite.ExtendableBuilder.getExtension(androidx.datastore.preferences.protobuf.ExtensionLite, int):java.lang.Object");
        }

        public final MessageType buildPartial() {
            if (this.f35784c) {
                return (ExtendableMessage) this.f35783b;
            }
            ((ExtendableMessage) this.f35783b).extensions.makeImmutable();
            return (ExtendableMessage) super.buildPartial();
        }

        public final <Type> BuilderType setExtension(ExtensionLite<MessageType, List<Type>> extensionLite, int i11, Type type) {
            GeneratedExtension g11 = GeneratedMessageLite.checkIsLite(extensionLite);
            verifyExtensionContainingType(g11);
            d();
            ensureExtensionsAreMutable().setRepeatedField(g11.f35794d, i11, g11.d(type));
            return this;
        }
    }

    public interface ExtendableMessageOrBuilder<MessageType extends ExtendableMessage<MessageType, BuilderType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>> extends MessageLiteOrBuilder {
        <Type> Type getExtension(ExtensionLite<MessageType, Type> extensionLite);

        <Type> Type getExtension(ExtensionLite<MessageType, List<Type>> extensionLite, int i11);

        <Type> int getExtensionCount(ExtensionLite<MessageType, List<Type>> extensionLite);

        <Type> boolean hasExtension(ExtensionLite<MessageType, Type> extensionLite);
    }

    public static final class ExtensionDescriptor implements FieldSet.FieldDescriptorLite<ExtensionDescriptor> {

        /* renamed from: b  reason: collision with root package name */
        public final Internal.EnumLiteMap<?> f35786b;

        /* renamed from: c  reason: collision with root package name */
        public final int f35787c;

        /* renamed from: d  reason: collision with root package name */
        public final WireFormat.FieldType f35788d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f35789e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f35790f;

        public ExtensionDescriptor(Internal.EnumLiteMap<?> enumLiteMap, int i11, WireFormat.FieldType fieldType, boolean z11, boolean z12) {
            this.f35786b = enumLiteMap;
            this.f35787c = i11;
            this.f35788d = fieldType;
            this.f35789e = z11;
            this.f35790f = z12;
        }

        public Internal.EnumLiteMap<?> getEnumType() {
            return this.f35786b;
        }

        public WireFormat.JavaType getLiteJavaType() {
            return this.f35788d.getJavaType();
        }

        public WireFormat.FieldType getLiteType() {
            return this.f35788d;
        }

        public int getNumber() {
            return this.f35787c;
        }

        public MessageLite.Builder internalMergeFrom(MessageLite.Builder builder, MessageLite messageLite) {
            return ((Builder) builder).mergeFrom((GeneratedMessageLite) messageLite);
        }

        public boolean isPacked() {
            return this.f35790f;
        }

        public boolean isRepeated() {
            return this.f35789e;
        }

        public int compareTo(ExtensionDescriptor extensionDescriptor) {
            return this.f35787c - extensionDescriptor.f35787c;
        }
    }

    public static class GeneratedExtension<ContainingType extends MessageLite, Type> extends ExtensionLite<ContainingType, Type> {

        /* renamed from: a  reason: collision with root package name */
        public final ContainingType f35791a;

        /* renamed from: b  reason: collision with root package name */
        public final Type f35792b;

        /* renamed from: c  reason: collision with root package name */
        public final MessageLite f35793c;

        /* renamed from: d  reason: collision with root package name */
        public final ExtensionDescriptor f35794d;

        public GeneratedExtension(ContainingType containingtype, Type type, MessageLite messageLite, ExtensionDescriptor extensionDescriptor, Class cls) {
            if (containingtype == null) {
                throw new IllegalArgumentException("Null containingTypeDefaultInstance");
            } else if (extensionDescriptor.getLiteType() == WireFormat.FieldType.MESSAGE && messageLite == null) {
                throw new IllegalArgumentException("Null messageDefaultInstance");
            } else {
                this.f35791a = containingtype;
                this.f35792b = type;
                this.f35793c = messageLite;
                this.f35794d = extensionDescriptor;
            }
        }

        public Object b(Object obj) {
            if (!this.f35794d.isRepeated()) {
                return c(obj);
            }
            if (this.f35794d.getLiteJavaType() != WireFormat.JavaType.ENUM) {
                return obj;
            }
            ArrayList arrayList = new ArrayList();
            for (Object c11 : (List) obj) {
                arrayList.add(c(c11));
            }
            return arrayList;
        }

        public Object c(Object obj) {
            if (this.f35794d.getLiteJavaType() == WireFormat.JavaType.ENUM) {
                return this.f35794d.f35786b.findValueByNumber(((Integer) obj).intValue());
            }
            return obj;
        }

        public Object d(Object obj) {
            if (this.f35794d.getLiteJavaType() == WireFormat.JavaType.ENUM) {
                return Integer.valueOf(((Internal.EnumLite) obj).getNumber());
            }
            return obj;
        }

        public Object e(Object obj) {
            if (!this.f35794d.isRepeated()) {
                return d(obj);
            }
            if (this.f35794d.getLiteJavaType() != WireFormat.JavaType.ENUM) {
                return obj;
            }
            ArrayList arrayList = new ArrayList();
            for (Object d11 : (List) obj) {
                arrayList.add(d(d11));
            }
            return arrayList;
        }

        public ContainingType getContainingTypeDefaultInstance() {
            return this.f35791a;
        }

        public Type getDefaultValue() {
            return this.f35792b;
        }

        public WireFormat.FieldType getLiteType() {
            return this.f35794d.getLiteType();
        }

        public MessageLite getMessageDefaultInstance() {
            return this.f35793c;
        }

        public int getNumber() {
            return this.f35794d.getNumber();
        }

        public boolean isRepeated() {
            return this.f35794d.f35789e;
        }
    }

    public enum MethodToInvoke {
        GET_MEMOIZED_IS_INITIALIZED,
        SET_MEMOIZED_IS_INITIALIZED,
        BUILD_MESSAGE_INFO,
        NEW_MUTABLE_INSTANCE,
        NEW_BUILDER,
        GET_DEFAULT_INSTANCE,
        GET_PARSER
    }

    public static final class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        private final byte[] asBytes;
        private final Class<?> messageClass;
        private final String messageClassName;

        public SerializedForm(MessageLite messageLite) {
            Class<?> cls = messageLite.getClass();
            this.messageClass = cls;
            this.messageClassName = cls.getName();
            this.asBytes = messageLite.toByteArray();
        }

        public static SerializedForm of(MessageLite messageLite) {
            return new SerializedForm(messageLite);
        }

        @Deprecated
        private Object readResolveFallback() throws ObjectStreamException {
            try {
                Field declaredField = resolveMessageClass().getDeclaredField("defaultInstance");
                declaredField.setAccessible(true);
                return ((MessageLite) declaredField.get((Object) null)).newBuilderForType().mergeFrom(this.asBytes).buildPartial();
            } catch (ClassNotFoundException e11) {
                throw new RuntimeException("Unable to find proto buffer class: " + this.messageClassName, e11);
            } catch (NoSuchFieldException e12) {
                throw new RuntimeException("Unable to find defaultInstance in " + this.messageClassName, e12);
            } catch (SecurityException e13) {
                throw new RuntimeException("Unable to call defaultInstance in " + this.messageClassName, e13);
            } catch (IllegalAccessException e14) {
                throw new RuntimeException("Unable to call parsePartialFrom", e14);
            } catch (InvalidProtocolBufferException e15) {
                throw new RuntimeException("Unable to understand proto buffer", e15);
            }
        }

        private Class<?> resolveMessageClass() throws ClassNotFoundException {
            Class<?> cls = this.messageClass;
            return cls != null ? cls : Class.forName(this.messageClassName);
        }

        public Object readResolve() throws ObjectStreamException {
            try {
                Field declaredField = resolveMessageClass().getDeclaredField(Utils.DEFAULT_NAME);
                declaredField.setAccessible(true);
                return ((MessageLite) declaredField.get((Object) null)).newBuilderForType().mergeFrom(this.asBytes).buildPartial();
            } catch (ClassNotFoundException e11) {
                throw new RuntimeException("Unable to find proto buffer class: " + this.messageClassName, e11);
            } catch (NoSuchFieldException unused) {
                return readResolveFallback();
            } catch (SecurityException e12) {
                throw new RuntimeException("Unable to call DEFAULT_INSTANCE in " + this.messageClassName, e12);
            } catch (IllegalAccessException e13) {
                throw new RuntimeException("Unable to call parsePartialFrom", e13);
            } catch (InvalidProtocolBufferException e14) {
                throw new RuntimeException("Unable to understand proto buffer", e14);
            }
        }
    }

    public static <T extends GeneratedMessageLite<T, ?>> T A(T t11, CodedInputStream codedInputStream) throws InvalidProtocolBufferException {
        return B(t11, codedInputStream, ExtensionRegistryLite.getEmptyRegistry());
    }

    public static <T extends GeneratedMessageLite<T, ?>> T B(T t11, CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return checkMessageInitialized(I(t11, codedInputStream, extensionRegistryLite));
    }

    public static <T extends GeneratedMessageLite<T, ?>> T C(T t11, InputStream inputStream) throws InvalidProtocolBufferException {
        return checkMessageInitialized(I(t11, CodedInputStream.newInstance(inputStream), ExtensionRegistryLite.getEmptyRegistry()));
    }

    public static <T extends GeneratedMessageLite<T, ?>> T D(T t11, InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return checkMessageInitialized(I(t11, CodedInputStream.newInstance(inputStream), extensionRegistryLite));
    }

    public static <T extends GeneratedMessageLite<T, ?>> T E(T t11, ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return F(t11, byteBuffer, ExtensionRegistryLite.getEmptyRegistry());
    }

    public static <T extends GeneratedMessageLite<T, ?>> T F(T t11, ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return checkMessageInitialized(B(t11, CodedInputStream.newInstance(byteBuffer), extensionRegistryLite));
    }

    public static <T extends GeneratedMessageLite<T, ?>> T G(T t11, byte[] bArr) throws InvalidProtocolBufferException {
        return checkMessageInitialized(J(t11, bArr, 0, bArr.length, ExtensionRegistryLite.getEmptyRegistry()));
    }

    public static <T extends GeneratedMessageLite<T, ?>> T H(T t11, byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return checkMessageInitialized(J(t11, bArr, 0, bArr.length, extensionRegistryLite));
    }

    public static <T extends GeneratedMessageLite<T, ?>> T I(T t11, CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        T t12 = (GeneratedMessageLite) t11.k(MethodToInvoke.NEW_MUTABLE_INSTANCE);
        try {
            Schema schemaFor = Protobuf.getInstance().schemaFor(t12);
            schemaFor.mergeFrom(t12, CodedInputStreamReader.forCodedInput(codedInputStream), extensionRegistryLite);
            schemaFor.makeImmutable(t12);
            return t12;
        } catch (IOException e11) {
            if (e11.getCause() instanceof InvalidProtocolBufferException) {
                throw ((InvalidProtocolBufferException) e11.getCause());
            }
            throw new InvalidProtocolBufferException(e11.getMessage()).setUnfinishedMessage(t12);
        } catch (RuntimeException e12) {
            if (e12.getCause() instanceof InvalidProtocolBufferException) {
                throw ((InvalidProtocolBufferException) e12.getCause());
            }
            throw e12;
        }
    }

    public static <T extends GeneratedMessageLite<T, ?>> T J(T t11, byte[] bArr, int i11, int i12, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        T t12 = (GeneratedMessageLite) t11.k(MethodToInvoke.NEW_MUTABLE_INSTANCE);
        try {
            Schema schemaFor = Protobuf.getInstance().schemaFor(t12);
            schemaFor.mergeFrom(t12, bArr, i11, i11 + i12, new ArrayDecoders.Registers(extensionRegistryLite));
            schemaFor.makeImmutable(t12);
            if (t12.memoizedHashCode == 0) {
                return t12;
            }
            throw new RuntimeException();
        } catch (IOException e11) {
            if (e11.getCause() instanceof InvalidProtocolBufferException) {
                throw ((InvalidProtocolBufferException) e11.getCause());
            }
            throw new InvalidProtocolBufferException(e11.getMessage()).setUnfinishedMessage(t12);
        } catch (IndexOutOfBoundsException unused) {
            throw InvalidProtocolBufferException.j().setUnfinishedMessage(t12);
        }
    }

    public static <T extends GeneratedMessageLite<?, ?>> void L(Class<T> cls, T t11) {
        defaultInstanceMap.put(cls, t11);
    }

    /* access modifiers changed from: private */
    public static <MessageType extends ExtendableMessage<MessageType, BuilderType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>, T> GeneratedExtension<MessageType, T> checkIsLite(ExtensionLite<MessageType, T> extensionLite) {
        if (extensionLite.a()) {
            return (GeneratedExtension) extensionLite;
        }
        throw new IllegalArgumentException("Expected a lite extension.");
    }

    private static <T extends GeneratedMessageLite<T, ?>> T checkMessageInitialized(T t11) throws InvalidProtocolBufferException {
        if (t11 == null || t11.isInitialized()) {
            return t11;
        }
        throw t11.e().asInvalidProtocolBufferException().setUnfinishedMessage(t11);
    }

    private final void ensureUnknownFieldsInitialized() {
        if (this.unknownFields == UnknownFieldSetLite.getDefaultInstance()) {
            this.unknownFields = UnknownFieldSetLite.f();
        }
    }

    public static <E> Internal.ProtobufList<E> n() {
        return ProtobufArrayList.emptyList();
    }

    public static <ContainingType extends MessageLite, Type> GeneratedExtension<ContainingType, Type> newRepeatedGeneratedExtension(ContainingType containingtype, MessageLite messageLite, Internal.EnumLiteMap<?> enumLiteMap, int i11, WireFormat.FieldType fieldType, boolean z11, Class cls) {
        return new GeneratedExtension(containingtype, Collections.emptyList(), messageLite, new ExtensionDescriptor(enumLiteMap, i11, fieldType, true, z11), cls);
    }

    public static <ContainingType extends MessageLite, Type> GeneratedExtension<ContainingType, Type> newSingularGeneratedExtension(ContainingType containingtype, Type type, MessageLite messageLite, Internal.EnumLiteMap<?> enumLiteMap, int i11, WireFormat.FieldType fieldType, Class cls) {
        return new GeneratedExtension(containingtype, type, messageLite, new ExtensionDescriptor(enumLiteMap, i11, fieldType, false, false), cls);
    }

    public static <T extends GeneratedMessageLite<?, ?>> T o(Class<T> cls) {
        T t11 = (GeneratedMessageLite) defaultInstanceMap.get(cls);
        if (t11 == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t11 = (GeneratedMessageLite) defaultInstanceMap.get(cls);
            } catch (ClassNotFoundException e11) {
                throw new IllegalStateException("Class initialization cannot fail.", e11);
            }
        }
        if (t11 == null) {
            t11 = ((GeneratedMessageLite) UnsafeUtil.j(cls)).getDefaultInstanceForType();
            if (t11 != null) {
                defaultInstanceMap.put(cls, t11);
            } else {
                throw new IllegalStateException();
            }
        }
        return t11;
    }

    static Object p(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e11) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e11);
        } catch (InvocationTargetException e12) {
            Throwable cause = e12.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
        }
    }

    private static <T extends GeneratedMessageLite<T, ?>> T parsePartialDelimitedFrom(T t11, InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        try {
            int read = inputStream.read();
            if (read == -1) {
                return null;
            }
            CodedInputStream newInstance = CodedInputStream.newInstance((InputStream) new AbstractMessageLite.Builder.LimitedInputStream(inputStream, CodedInputStream.readRawVarint32(read, inputStream)));
            T I = I(t11, newInstance, extensionRegistryLite);
            try {
                newInstance.checkLastTagWas(0);
                return I;
            } catch (InvalidProtocolBufferException e11) {
                throw e11.setUnfinishedMessage(I);
            }
        } catch (IOException e12) {
            throw new InvalidProtocolBufferException(e12.getMessage());
        }
    }

    private static <T extends GeneratedMessageLite<T, ?>> T parsePartialFrom(T t11, ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        T I;
        try {
            CodedInputStream newCodedInput = byteString.newCodedInput();
            I = I(t11, newCodedInput, extensionRegistryLite);
            newCodedInput.checkLastTagWas(0);
            return I;
        } catch (InvalidProtocolBufferException e11) {
            throw e11.setUnfinishedMessage(I);
        } catch (InvalidProtocolBufferException e12) {
            throw e12;
        }
    }

    public static final <T extends GeneratedMessageLite<T, ?>> boolean q(T t11, boolean z11) {
        T t12;
        byte byteValue = ((Byte) t11.k(MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean isInitialized = Protobuf.getInstance().schemaFor(t11).isInitialized(t11);
        if (z11) {
            MethodToInvoke methodToInvoke = MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED;
            if (isInitialized) {
                t12 = t11;
            } else {
                t12 = null;
            }
            t11.l(methodToInvoke, t12);
        }
        return isInitialized;
    }

    public static <E> Internal.ProtobufList<E> u(Internal.ProtobufList<E> protobufList) {
        int i11;
        int size = protobufList.size();
        if (size == 0) {
            i11 = 10;
        } else {
            i11 = size * 2;
        }
        return protobufList.mutableCopyWithCapacity(i11);
    }

    public static Object v(MessageLite messageLite, String str, Object[] objArr) {
        return new RawMessageInfo(messageLite, str, objArr);
    }

    public static <T extends GeneratedMessageLite<T, ?>> T w(T t11, InputStream inputStream) throws InvalidProtocolBufferException {
        return checkMessageInitialized(parsePartialDelimitedFrom(t11, inputStream, ExtensionRegistryLite.getEmptyRegistry()));
    }

    public static <T extends GeneratedMessageLite<T, ?>> T x(T t11, InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return checkMessageInitialized(parsePartialDelimitedFrom(t11, inputStream, extensionRegistryLite));
    }

    public static <T extends GeneratedMessageLite<T, ?>> T y(T t11, ByteString byteString) throws InvalidProtocolBufferException {
        return checkMessageInitialized(z(t11, byteString, ExtensionRegistryLite.getEmptyRegistry()));
    }

    public static <T extends GeneratedMessageLite<T, ?>> T z(T t11, ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return checkMessageInitialized(parsePartialFrom(t11, byteString, extensionRegistryLite));
    }

    public boolean K(int i11, CodedInputStream codedInputStream) throws IOException {
        if (WireFormat.getTagWireType(i11) == 4) {
            return false;
        }
        ensureUnknownFieldsInitialized();
        return this.unknownFields.b(i11, codedInputStream);
    }

    /* access modifiers changed from: package-private */
    public int c() {
        return this.memoizedSerializedSize;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!getDefaultInstanceForType().getClass().isInstance(obj)) {
            return false;
        }
        return Protobuf.getInstance().schemaFor(this).equals(this, (GeneratedMessageLite) obj);
    }

    /* access modifiers changed from: package-private */
    public void f(int i11) {
        this.memoizedSerializedSize = i11;
    }

    public final Parser<MessageType> getParserForType() {
        return (Parser) k(MethodToInvoke.GET_PARSER);
    }

    public int getSerializedSize() {
        if (this.memoizedSerializedSize == -1) {
            this.memoizedSerializedSize = Protobuf.getInstance().schemaFor(this).getSerializedSize(this);
        }
        return this.memoizedSerializedSize;
    }

    /* access modifiers changed from: package-private */
    public Object h() throws Exception {
        return k(MethodToInvoke.BUILD_MESSAGE_INFO);
    }

    public int hashCode() {
        int i11 = this.memoizedHashCode;
        if (i11 != 0) {
            return i11;
        }
        int hashCode = Protobuf.getInstance().schemaFor(this).hashCode(this);
        this.memoizedHashCode = hashCode;
        return hashCode;
    }

    public final <MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> BuilderType i() {
        return (Builder) k(MethodToInvoke.NEW_BUILDER);
    }

    public final boolean isInitialized() {
        return q(this, true);
    }

    public final <MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> BuilderType j(MessageType messagetype) {
        return i().mergeFrom(messagetype);
    }

    public Object k(MethodToInvoke methodToInvoke) {
        return m(methodToInvoke, (Object) null, (Object) null);
    }

    public Object l(MethodToInvoke methodToInvoke, Object obj) {
        return m(methodToInvoke, obj, (Object) null);
    }

    public abstract Object m(MethodToInvoke methodToInvoke, Object obj, Object obj2);

    public void r() {
        Protobuf.getInstance().schemaFor(this).makeImmutable(this);
    }

    public void s(int i11, ByteString byteString) {
        ensureUnknownFieldsInitialized();
        this.unknownFields.c(i11, byteString);
    }

    public void t(int i11, int i12) {
        ensureUnknownFieldsInitialized();
        this.unknownFields.d(i11, i12);
    }

    public String toString() {
        return MessageLiteToString.b(this, super.toString());
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        Protobuf.getInstance().schemaFor(this).writeTo(this, CodedOutputStreamWriter.forCodedOutput(codedOutputStream));
    }

    public final MessageType getDefaultInstanceForType() {
        return (GeneratedMessageLite) k(MethodToInvoke.GET_DEFAULT_INSTANCE);
    }

    public final BuilderType newBuilderForType() {
        return (Builder) k(MethodToInvoke.NEW_BUILDER);
    }

    public final BuilderType toBuilder() {
        BuilderType buildertype = (Builder) k(MethodToInvoke.NEW_BUILDER);
        buildertype.mergeFrom(this);
        return buildertype;
    }

    public static class DefaultInstanceBasedParser<T extends GeneratedMessageLite<T, ?>> extends AbstractParser<T> {
        private final T defaultInstance;

        public DefaultInstanceBasedParser(T t11) {
            this.defaultInstance = t11;
        }

        public T parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return GeneratedMessageLite.I(this.defaultInstance, codedInputStream, extensionRegistryLite);
        }

        public T parsePartialFrom(byte[] bArr, int i11, int i12, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return GeneratedMessageLite.J(this.defaultInstance, bArr, i11, i12, extensionRegistryLite);
        }
    }

    public static abstract class ExtendableMessage<MessageType extends ExtendableMessage<MessageType, BuilderType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>> extends GeneratedMessageLite<MessageType, BuilderType> implements ExtendableMessageOrBuilder<MessageType, BuilderType> {
        protected FieldSet<ExtensionDescriptor> extensions = FieldSet.emptySet();

        public class ExtensionWriter {
            private final Iterator<Map.Entry<ExtensionDescriptor, Object>> iter;
            private final boolean messageSetWireFormat;
            private Map.Entry<ExtensionDescriptor, Object> next;

            private ExtensionWriter(boolean z11) {
                Iterator<Map.Entry<ExtensionDescriptor, Object>> it = ExtendableMessage.this.extensions.iterator();
                this.iter = it;
                if (it.hasNext()) {
                    this.next = it.next();
                }
                this.messageSetWireFormat = z11;
            }

            public void writeUntil(int i11, CodedOutputStream codedOutputStream) throws IOException {
                while (true) {
                    Map.Entry<ExtensionDescriptor, Object> entry = this.next;
                    if (entry != null && entry.getKey().getNumber() < i11) {
                        ExtensionDescriptor key = this.next.getKey();
                        if (!this.messageSetWireFormat || key.getLiteJavaType() != WireFormat.JavaType.MESSAGE || key.isRepeated()) {
                            FieldSet.writeField(key, this.next.getValue(), codedOutputStream);
                        } else {
                            codedOutputStream.writeMessageSetExtension(key.getNumber(), (MessageLite) this.next.getValue());
                        }
                        if (this.iter.hasNext()) {
                            this.next = this.iter.next();
                        } else {
                            this.next = null;
                        }
                    } else {
                        return;
                    }
                }
            }
        }

        private void eagerlyMergeMessageSetExtension(CodedInputStream codedInputStream, GeneratedExtension<?, ?> generatedExtension, ExtensionRegistryLite extensionRegistryLite, int i11) throws IOException {
            parseExtension(codedInputStream, extensionRegistryLite, generatedExtension, WireFormat.a(i11, 2), i11);
        }

        private void mergeMessageSetExtensionFromBytes(ByteString byteString, ExtensionRegistryLite extensionRegistryLite, GeneratedExtension<?, ?> generatedExtension) throws IOException {
            MessageLite.Builder builder;
            MessageLite messageLite = (MessageLite) this.extensions.getField(generatedExtension.f35794d);
            if (messageLite != null) {
                builder = messageLite.toBuilder();
            } else {
                builder = null;
            }
            if (builder == null) {
                builder = generatedExtension.getMessageDefaultInstance().newBuilderForType();
            }
            builder.mergeFrom(byteString, extensionRegistryLite);
            M().setField(generatedExtension.f35794d, generatedExtension.d(builder.build()));
        }

        private <MessageType extends MessageLite> void mergeMessageSetExtensionFromCodedStream(MessageType messagetype, CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int i11 = 0;
            ByteString byteString = null;
            GeneratedExtension generatedExtension = null;
            while (true) {
                int readTag = codedInputStream.readTag();
                if (readTag == 0) {
                    break;
                } else if (readTag == WireFormat.f35846c) {
                    i11 = codedInputStream.readUInt32();
                    if (i11 != 0) {
                        generatedExtension = extensionRegistryLite.findLiteExtensionByNumber(messagetype, i11);
                    }
                } else if (readTag == WireFormat.f35847d) {
                    if (i11 == 0 || generatedExtension == null) {
                        byteString = codedInputStream.readBytes();
                    } else {
                        eagerlyMergeMessageSetExtension(codedInputStream, generatedExtension, extensionRegistryLite, i11);
                        byteString = null;
                    }
                } else if (!codedInputStream.skipField(readTag)) {
                    break;
                }
            }
            codedInputStream.checkLastTagWas(WireFormat.f35845b);
            if (byteString != null && i11 != 0) {
                if (generatedExtension != null) {
                    mergeMessageSetExtensionFromBytes(byteString, extensionRegistryLite, generatedExtension);
                } else {
                    s(i11, byteString);
                }
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x0038  */
        /* JADX WARNING: Removed duplicated region for block: B:16:0x003d  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private boolean parseExtension(androidx.datastore.preferences.protobuf.CodedInputStream r6, androidx.datastore.preferences.protobuf.ExtensionRegistryLite r7, androidx.datastore.preferences.protobuf.GeneratedMessageLite.GeneratedExtension<?, ?> r8, int r9, int r10) throws java.io.IOException {
            /*
                r5 = this;
                int r0 = androidx.datastore.preferences.protobuf.WireFormat.getTagWireType(r9)
                r1 = 1
                r2 = 0
                if (r8 != 0) goto L_0x000b
            L_0x0008:
                r0 = r1
                r3 = r2
                goto L_0x0036
            L_0x000b:
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r3 = r8.f35794d
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r3 = r3.getLiteType()
                int r3 = androidx.datastore.preferences.protobuf.FieldSet.k(r3, r2)
                if (r0 != r3) goto L_0x001a
                r0 = r2
                r3 = r0
                goto L_0x0036
            L_0x001a:
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r3 = r8.f35794d
                boolean r4 = r3.f35789e
                if (r4 == 0) goto L_0x0008
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r3 = r3.f35788d
                boolean r3 = r3.isPackable()
                if (r3 == 0) goto L_0x0008
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r3 = r8.f35794d
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r3 = r3.getLiteType()
                int r3 = androidx.datastore.preferences.protobuf.FieldSet.k(r3, r1)
                if (r0 != r3) goto L_0x0008
                r3 = r1
                r0 = r2
            L_0x0036:
                if (r0 == 0) goto L_0x003d
                boolean r6 = r5.K(r9, r6)
                return r6
            L_0x003d:
                r5.M()
                if (r3 == 0) goto L_0x0094
                int r7 = r6.readRawVarint32()
                int r7 = r6.pushLimit(r7)
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r9 = r8.f35794d
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r9 = r9.getLiteType()
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r10 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.ENUM
                if (r9 != r10) goto L_0x0077
            L_0x0054:
                int r9 = r6.getBytesUntilLimit()
                if (r9 <= 0) goto L_0x008f
                int r9 = r6.readEnum()
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r10 = r8.f35794d
                androidx.datastore.preferences.protobuf.Internal$EnumLiteMap r10 = r10.getEnumType()
                androidx.datastore.preferences.protobuf.Internal$EnumLite r9 = r10.findValueByNumber(r9)
                if (r9 != 0) goto L_0x006b
                return r1
            L_0x006b:
                androidx.datastore.preferences.protobuf.FieldSet<androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor> r10 = r5.extensions
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r0 = r8.f35794d
                java.lang.Object r9 = r8.d(r9)
                r10.addRepeatedField(r0, r9)
                goto L_0x0054
            L_0x0077:
                int r9 = r6.getBytesUntilLimit()
                if (r9 <= 0) goto L_0x008f
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r9 = r8.f35794d
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r9 = r9.getLiteType()
                java.lang.Object r9 = androidx.datastore.preferences.protobuf.FieldSet.readPrimitiveField(r6, r9, r2)
                androidx.datastore.preferences.protobuf.FieldSet<androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor> r10 = r5.extensions
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r0 = r8.f35794d
                r10.addRepeatedField(r0, r9)
                goto L_0x0077
            L_0x008f:
                r6.popLimit(r7)
                goto L_0x0124
            L_0x0094:
                int[] r9 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.AnonymousClass1.f35782a
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r0 = r8.f35794d
                androidx.datastore.preferences.protobuf.WireFormat$JavaType r0 = r0.getLiteJavaType()
                int r0 = r0.ordinal()
                r9 = r9[r0]
                if (r9 == r1) goto L_0x00c8
                r7 = 2
                if (r9 == r7) goto L_0x00b2
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r7 = r8.f35794d
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r7 = r7.getLiteType()
                java.lang.Object r6 = androidx.datastore.preferences.protobuf.FieldSet.readPrimitiveField(r6, r7, r2)
                goto L_0x0105
            L_0x00b2:
                int r6 = r6.readEnum()
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r7 = r8.f35794d
                androidx.datastore.preferences.protobuf.Internal$EnumLiteMap r7 = r7.getEnumType()
                androidx.datastore.preferences.protobuf.Internal$EnumLite r7 = r7.findValueByNumber(r6)
                if (r7 != 0) goto L_0x00c6
                r5.t(r10, r6)
                return r1
            L_0x00c6:
                r6 = r7
                goto L_0x0105
            L_0x00c8:
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r9 = r8.f35794d
                boolean r9 = r9.isRepeated()
                if (r9 != 0) goto L_0x00e1
                androidx.datastore.preferences.protobuf.FieldSet<androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor> r9 = r5.extensions
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r10 = r8.f35794d
                java.lang.Object r9 = r9.getField(r10)
                androidx.datastore.preferences.protobuf.MessageLite r9 = (androidx.datastore.preferences.protobuf.MessageLite) r9
                if (r9 == 0) goto L_0x00e1
                androidx.datastore.preferences.protobuf.MessageLite$Builder r9 = r9.toBuilder()
                goto L_0x00e2
            L_0x00e1:
                r9 = 0
            L_0x00e2:
                if (r9 != 0) goto L_0x00ec
                androidx.datastore.preferences.protobuf.MessageLite r9 = r8.getMessageDefaultInstance()
                androidx.datastore.preferences.protobuf.MessageLite$Builder r9 = r9.newBuilderForType()
            L_0x00ec:
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r10 = r8.f35794d
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r10 = r10.getLiteType()
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r0 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.GROUP
                if (r10 != r0) goto L_0x00fe
                int r10 = r8.getNumber()
                r6.readGroup((int) r10, (androidx.datastore.preferences.protobuf.MessageLite.Builder) r9, (androidx.datastore.preferences.protobuf.ExtensionRegistryLite) r7)
                goto L_0x0101
            L_0x00fe:
                r6.readMessage((androidx.datastore.preferences.protobuf.MessageLite.Builder) r9, (androidx.datastore.preferences.protobuf.ExtensionRegistryLite) r7)
            L_0x0101:
                androidx.datastore.preferences.protobuf.MessageLite r6 = r9.build()
            L_0x0105:
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r7 = r8.f35794d
                boolean r7 = r7.isRepeated()
                if (r7 == 0) goto L_0x0119
                androidx.datastore.preferences.protobuf.FieldSet<androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor> r7 = r5.extensions
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r9 = r8.f35794d
                java.lang.Object r6 = r8.d(r6)
                r7.addRepeatedField(r9, r6)
                goto L_0x0124
            L_0x0119:
                androidx.datastore.preferences.protobuf.FieldSet<androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor> r7 = r5.extensions
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r9 = r8.f35794d
                java.lang.Object r6 = r8.d(r6)
                r7.setField(r9, r6)
            L_0x0124:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.GeneratedMessageLite.ExtendableMessage.parseExtension(androidx.datastore.preferences.protobuf.CodedInputStream, androidx.datastore.preferences.protobuf.ExtensionRegistryLite, androidx.datastore.preferences.protobuf.GeneratedMessageLite$GeneratedExtension, int, int):boolean");
        }

        private void verifyExtensionContainingType(GeneratedExtension<MessageType, ?> generatedExtension) {
            if (generatedExtension.getContainingTypeDefaultInstance() != getDefaultInstanceForType()) {
                throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
            }
        }

        public FieldSet<ExtensionDescriptor> M() {
            if (this.extensions.isImmutable()) {
                this.extensions = this.extensions.clone();
            }
            return this.extensions;
        }

        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return GeneratedMessageLite.super.getDefaultInstanceForType();
        }

        public final <Type> Type getExtension(ExtensionLite<MessageType, Type> extensionLite) {
            GeneratedExtension g11 = GeneratedMessageLite.checkIsLite(extensionLite);
            verifyExtensionContainingType(g11);
            Object field = this.extensions.getField(g11.f35794d);
            if (field == null) {
                return g11.f35792b;
            }
            return g11.b(field);
        }

        public final <Type> int getExtensionCount(ExtensionLite<MessageType, List<Type>> extensionLite) {
            GeneratedExtension g11 = GeneratedMessageLite.checkIsLite(extensionLite);
            verifyExtensionContainingType(g11);
            return this.extensions.getRepeatedFieldCount(g11.f35794d);
        }

        public final <Type> boolean hasExtension(ExtensionLite<MessageType, Type> extensionLite) {
            GeneratedExtension g11 = GeneratedMessageLite.checkIsLite(extensionLite);
            verifyExtensionContainingType(g11);
            return this.extensions.hasField(g11.f35794d);
        }

        public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
            return GeneratedMessageLite.super.newBuilderForType();
        }

        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return GeneratedMessageLite.super.toBuilder();
        }

        public final <Type> Type getExtension(ExtensionLite<MessageType, List<Type>> extensionLite, int i11) {
            GeneratedExtension g11 = GeneratedMessageLite.checkIsLite(extensionLite);
            verifyExtensionContainingType(g11);
            return g11.c(this.extensions.getRepeatedField(g11.f35794d, i11));
        }
    }

    private static <T extends GeneratedMessageLite<T, ?>> T parsePartialFrom(T t11, byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return checkMessageInitialized(J(t11, bArr, 0, bArr.length, extensionRegistryLite));
    }
}
