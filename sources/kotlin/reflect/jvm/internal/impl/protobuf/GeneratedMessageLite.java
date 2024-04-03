package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.FieldSet;
import kotlin.reflect.jvm.internal.impl.protobuf.Internal;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.WireFormat;

public abstract class GeneratedMessageLite extends AbstractMessageLite implements Serializable {

    /* renamed from: kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f24750a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                kotlin.reflect.jvm.internal.impl.protobuf.WireFormat$JavaType[] r0 = kotlin.reflect.jvm.internal.impl.protobuf.WireFormat.JavaType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f24750a = r0
                kotlin.reflect.jvm.internal.impl.protobuf.WireFormat$JavaType r1 = kotlin.reflect.jvm.internal.impl.protobuf.WireFormat.JavaType.MESSAGE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f24750a     // Catch:{ NoSuchFieldError -> 0x001d }
                kotlin.reflect.jvm.internal.impl.protobuf.WireFormat$JavaType r1 = kotlin.reflect.jvm.internal.impl.protobuf.WireFormat.JavaType.ENUM     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.AnonymousClass1.<clinit>():void");
        }
    }

    public interface ExtendableMessageOrBuilder<MessageType extends ExtendableMessage> extends MessageLiteOrBuilder {
    }

    public static final class ExtensionDescriptor implements FieldSet.FieldDescriptorLite<ExtensionDescriptor> {

        /* renamed from: b  reason: collision with root package name */
        public final Internal.EnumLiteMap<?> f24752b;

        /* renamed from: c  reason: collision with root package name */
        public final int f24753c;

        /* renamed from: d  reason: collision with root package name */
        public final WireFormat.FieldType f24754d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f24755e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f24756f;

        public ExtensionDescriptor(Internal.EnumLiteMap<?> enumLiteMap, int i11, WireFormat.FieldType fieldType, boolean z11, boolean z12) {
            this.f24752b = enumLiteMap;
            this.f24753c = i11;
            this.f24754d = fieldType;
            this.f24755e = z11;
            this.f24756f = z12;
        }

        public Internal.EnumLiteMap<?> getEnumType() {
            return this.f24752b;
        }

        public WireFormat.JavaType getLiteJavaType() {
            return this.f24754d.getJavaType();
        }

        public WireFormat.FieldType getLiteType() {
            return this.f24754d;
        }

        public int getNumber() {
            return this.f24753c;
        }

        public MessageLite.Builder internalMergeFrom(MessageLite.Builder builder, MessageLite messageLite) {
            return ((Builder) builder).mergeFrom((GeneratedMessageLite) messageLite);
        }

        public boolean isPacked() {
            return this.f24756f;
        }

        public boolean isRepeated() {
            return this.f24755e;
        }

        public int compareTo(ExtensionDescriptor extensionDescriptor) {
            return this.f24753c - extensionDescriptor.f24753c;
        }
    }

    public static class GeneratedExtension<ContainingType extends MessageLite, Type> {

        /* renamed from: a  reason: collision with root package name */
        public final ContainingType f24757a;

        /* renamed from: b  reason: collision with root package name */
        public final Type f24758b;

        /* renamed from: c  reason: collision with root package name */
        public final MessageLite f24759c;

        /* renamed from: d  reason: collision with root package name */
        public final ExtensionDescriptor f24760d;

        /* renamed from: e  reason: collision with root package name */
        public final Class f24761e;

        /* renamed from: f  reason: collision with root package name */
        public final Method f24762f;

        public GeneratedExtension(ContainingType containingtype, Type type, MessageLite messageLite, ExtensionDescriptor extensionDescriptor, Class cls) {
            if (containingtype == null) {
                throw new IllegalArgumentException("Null containingTypeDefaultInstance");
            } else if (extensionDescriptor.getLiteType() == WireFormat.FieldType.MESSAGE && messageLite == null) {
                throw new IllegalArgumentException("Null messageDefaultInstance");
            } else {
                this.f24757a = containingtype;
                this.f24758b = type;
                this.f24759c = messageLite;
                this.f24760d = extensionDescriptor;
                this.f24761e = cls;
                if (Internal.EnumLite.class.isAssignableFrom(cls)) {
                    this.f24762f = GeneratedMessageLite.c(cls, "valueOf", Integer.TYPE);
                    return;
                }
                this.f24762f = null;
            }
        }

        public Object a(Object obj) {
            if (!this.f24760d.isRepeated()) {
                return b(obj);
            }
            if (this.f24760d.getLiteJavaType() != WireFormat.JavaType.ENUM) {
                return obj;
            }
            ArrayList arrayList = new ArrayList();
            for (Object b11 : (List) obj) {
                arrayList.add(b(b11));
            }
            return arrayList;
        }

        public Object b(Object obj) {
            if (this.f24760d.getLiteJavaType() != WireFormat.JavaType.ENUM) {
                return obj;
            }
            return GeneratedMessageLite.d(this.f24762f, (Object) null, (Integer) obj);
        }

        public Object c(Object obj) {
            if (this.f24760d.getLiteJavaType() == WireFormat.JavaType.ENUM) {
                return Integer.valueOf(((Internal.EnumLite) obj).getNumber());
            }
            return obj;
        }

        public ContainingType getContainingTypeDefaultInstance() {
            return this.f24757a;
        }

        public MessageLite getMessageDefaultInstance() {
            return this.f24759c;
        }

        public int getNumber() {
            return this.f24760d.getNumber();
        }
    }

    public GeneratedMessageLite() {
    }

    static Method c(Class cls, String str, Class... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException e11) {
            String name2 = cls.getName();
            String valueOf = String.valueOf(str);
            StringBuilder sb2 = new StringBuilder(name2.length() + 45 + valueOf.length());
            sb2.append("Generated message class \"");
            sb2.append(name2);
            sb2.append("\" missing method \"");
            sb2.append(valueOf);
            sb2.append("\".");
            throw new RuntimeException(sb2.toString(), e11);
        }
    }

    static Object d(Method method, Object obj, Object... objArr) {
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

    public static <ContainingType extends MessageLite, Type> GeneratedExtension<ContainingType, Type> newRepeatedGeneratedExtension(ContainingType containingtype, MessageLite messageLite, Internal.EnumLiteMap<?> enumLiteMap, int i11, WireFormat.FieldType fieldType, boolean z11, Class cls) {
        return new GeneratedExtension(containingtype, Collections.emptyList(), messageLite, new ExtensionDescriptor(enumLiteMap, i11, fieldType, true, z11), cls);
    }

    public static <ContainingType extends MessageLite, Type> GeneratedExtension<ContainingType, Type> newSingularGeneratedExtension(ContainingType containingtype, Type type, MessageLite messageLite, Internal.EnumLiteMap<?> enumLiteMap, int i11, WireFormat.FieldType fieldType, Class cls) {
        return new GeneratedExtension(containingtype, type, messageLite, new ExtensionDescriptor(enumLiteMap, i11, fieldType, false, false), cls);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0045  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <MessageType extends kotlin.reflect.jvm.internal.impl.protobuf.MessageLite> boolean parseUnknownField(kotlin.reflect.jvm.internal.impl.protobuf.FieldSet<kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtensionDescriptor> r5, MessageType r6, kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream r7, kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream r8, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite r9, int r10) throws java.io.IOException {
        /*
            int r0 = kotlin.reflect.jvm.internal.impl.protobuf.WireFormat.a(r10)
            int r1 = kotlin.reflect.jvm.internal.impl.protobuf.WireFormat.getTagFieldNumber(r10)
            kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$GeneratedExtension r6 = r9.findLiteExtensionByNumber(r6, r1)
            r1 = 1
            r2 = 0
            if (r6 != 0) goto L_0x0013
        L_0x0010:
            r0 = r1
            r3 = r2
            goto L_0x003e
        L_0x0013:
            kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$ExtensionDescriptor r3 = r6.f24760d
            kotlin.reflect.jvm.internal.impl.protobuf.WireFormat$FieldType r3 = r3.getLiteType()
            int r3 = kotlin.reflect.jvm.internal.impl.protobuf.FieldSet.a(r3, r2)
            if (r0 != r3) goto L_0x0022
            r0 = r2
            r3 = r0
            goto L_0x003e
        L_0x0022:
            kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$ExtensionDescriptor r3 = r6.f24760d
            boolean r4 = r3.f24755e
            if (r4 == 0) goto L_0x0010
            kotlin.reflect.jvm.internal.impl.protobuf.WireFormat$FieldType r3 = r3.f24754d
            boolean r3 = r3.isPackable()
            if (r3 == 0) goto L_0x0010
            kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$ExtensionDescriptor r3 = r6.f24760d
            kotlin.reflect.jvm.internal.impl.protobuf.WireFormat$FieldType r3 = r3.getLiteType()
            int r3 = kotlin.reflect.jvm.internal.impl.protobuf.FieldSet.a(r3, r1)
            if (r0 != r3) goto L_0x0010
            r3 = r1
            r0 = r2
        L_0x003e:
            if (r0 == 0) goto L_0x0045
            boolean r5 = r7.skipField(r10, r8)
            return r5
        L_0x0045:
            if (r3 == 0) goto L_0x0095
            int r8 = r7.readRawVarint32()
            int r8 = r7.pushLimit(r8)
            kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$ExtensionDescriptor r9 = r6.f24760d
            kotlin.reflect.jvm.internal.impl.protobuf.WireFormat$FieldType r9 = r9.getLiteType()
            kotlin.reflect.jvm.internal.impl.protobuf.WireFormat$FieldType r10 = kotlin.reflect.jvm.internal.impl.protobuf.WireFormat.FieldType.ENUM
            if (r9 != r10) goto L_0x007a
        L_0x0059:
            int r9 = r7.getBytesUntilLimit()
            if (r9 <= 0) goto L_0x0090
            int r9 = r7.readEnum()
            kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$ExtensionDescriptor r10 = r6.f24760d
            kotlin.reflect.jvm.internal.impl.protobuf.Internal$EnumLiteMap r10 = r10.getEnumType()
            kotlin.reflect.jvm.internal.impl.protobuf.Internal$EnumLite r9 = r10.findValueByNumber(r9)
            if (r9 != 0) goto L_0x0070
            return r1
        L_0x0070:
            kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$ExtensionDescriptor r10 = r6.f24760d
            java.lang.Object r9 = r6.c(r9)
            r5.addRepeatedField(r10, r9)
            goto L_0x0059
        L_0x007a:
            int r9 = r7.getBytesUntilLimit()
            if (r9 <= 0) goto L_0x0090
            kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$ExtensionDescriptor r9 = r6.f24760d
            kotlin.reflect.jvm.internal.impl.protobuf.WireFormat$FieldType r9 = r9.getLiteType()
            java.lang.Object r9 = kotlin.reflect.jvm.internal.impl.protobuf.FieldSet.readPrimitiveField(r7, r9, r2)
            kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$ExtensionDescriptor r10 = r6.f24760d
            r5.addRepeatedField(r10, r9)
            goto L_0x007a
        L_0x0090:
            r7.popLimit(r8)
            goto L_0x0122
        L_0x0095:
            int[] r0 = kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.AnonymousClass1.f24750a
            kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$ExtensionDescriptor r3 = r6.f24760d
            kotlin.reflect.jvm.internal.impl.protobuf.WireFormat$JavaType r3 = r3.getLiteJavaType()
            int r3 = r3.ordinal()
            r0 = r0[r3]
            if (r0 == r1) goto L_0x00cc
            r9 = 2
            if (r0 == r9) goto L_0x00b3
            kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$ExtensionDescriptor r8 = r6.f24760d
            kotlin.reflect.jvm.internal.impl.protobuf.WireFormat$FieldType r8 = r8.getLiteType()
            java.lang.Object r7 = kotlin.reflect.jvm.internal.impl.protobuf.FieldSet.readPrimitiveField(r7, r8, r2)
            goto L_0x0107
        L_0x00b3:
            int r7 = r7.readEnum()
            kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$ExtensionDescriptor r9 = r6.f24760d
            kotlin.reflect.jvm.internal.impl.protobuf.Internal$EnumLiteMap r9 = r9.getEnumType()
            kotlin.reflect.jvm.internal.impl.protobuf.Internal$EnumLite r9 = r9.findValueByNumber(r7)
            if (r9 != 0) goto L_0x00ca
            r8.writeRawVarint32(r10)
            r8.writeUInt32NoTag(r7)
            return r1
        L_0x00ca:
            r7 = r9
            goto L_0x0107
        L_0x00cc:
            kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$ExtensionDescriptor r8 = r6.f24760d
            boolean r8 = r8.isRepeated()
            if (r8 != 0) goto L_0x00e3
            kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$ExtensionDescriptor r8 = r6.f24760d
            java.lang.Object r8 = r5.getField(r8)
            kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r8 = (kotlin.reflect.jvm.internal.impl.protobuf.MessageLite) r8
            if (r8 == 0) goto L_0x00e3
            kotlin.reflect.jvm.internal.impl.protobuf.MessageLite$Builder r8 = r8.toBuilder()
            goto L_0x00e4
        L_0x00e3:
            r8 = 0
        L_0x00e4:
            if (r8 != 0) goto L_0x00ee
            kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r8 = r6.getMessageDefaultInstance()
            kotlin.reflect.jvm.internal.impl.protobuf.MessageLite$Builder r8 = r8.newBuilderForType()
        L_0x00ee:
            kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$ExtensionDescriptor r10 = r6.f24760d
            kotlin.reflect.jvm.internal.impl.protobuf.WireFormat$FieldType r10 = r10.getLiteType()
            kotlin.reflect.jvm.internal.impl.protobuf.WireFormat$FieldType r0 = kotlin.reflect.jvm.internal.impl.protobuf.WireFormat.FieldType.GROUP
            if (r10 != r0) goto L_0x0100
            int r10 = r6.getNumber()
            r7.readGroup(r10, r8, r9)
            goto L_0x0103
        L_0x0100:
            r7.readMessage((kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder) r8, (kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite) r9)
        L_0x0103:
            kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r7 = r8.build()
        L_0x0107:
            kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$ExtensionDescriptor r8 = r6.f24760d
            boolean r8 = r8.isRepeated()
            if (r8 == 0) goto L_0x0119
            kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$ExtensionDescriptor r8 = r6.f24760d
            java.lang.Object r6 = r6.c(r7)
            r5.addRepeatedField(r8, r6)
            goto L_0x0122
        L_0x0119:
            kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$ExtensionDescriptor r8 = r6.f24760d
            java.lang.Object r6 = r6.c(r7)
            r5.setField(r8, r6)
        L_0x0122:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.parseUnknownField(kotlin.reflect.jvm.internal.impl.protobuf.FieldSet, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite, kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite, int):boolean");
    }

    public void e() {
    }

    public boolean f(CodedInputStream codedInputStream, CodedOutputStream codedOutputStream, ExtensionRegistryLite extensionRegistryLite, int i11) throws IOException {
        return codedInputStream.skipField(i11, codedOutputStream);
    }

    public Parser<? extends MessageLite> getParserForType() {
        throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
    }

    public static abstract class Builder<MessageType extends GeneratedMessageLite, BuilderType extends Builder> extends AbstractMessageLite.Builder<BuilderType> {
        private ByteString unknownFields = ByteString.EMPTY;

        public abstract MessageType getDefaultInstanceForType();

        public final ByteString getUnknownFields() {
            return this.unknownFields;
        }

        public abstract BuilderType mergeFrom(MessageType messagetype);

        public final BuilderType setUnknownFields(ByteString byteString) {
            this.unknownFields = byteString;
            return this;
        }

        public BuilderType clone() {
            throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
        }
    }

    public static abstract class ExtendableMessage<MessageType extends ExtendableMessage<MessageType>> extends GeneratedMessageLite implements ExtendableMessageOrBuilder<MessageType> {
        /* access modifiers changed from: private */
        public final FieldSet<ExtensionDescriptor> extensions;

        public class ExtensionWriter {
            private final Iterator<Map.Entry<ExtensionDescriptor, Object>> iter;
            private final boolean messageSetWireFormat;
            private Map.Entry<ExtensionDescriptor, Object> next;

            public /* synthetic */ ExtensionWriter(ExtendableMessage extendableMessage, boolean z11, AnonymousClass1 r32) {
                this(z11);
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

            private ExtensionWriter(boolean z11) {
                Iterator<Map.Entry<ExtensionDescriptor, Object>> it = ExtendableMessage.this.extensions.iterator();
                this.iter = it;
                if (it.hasNext()) {
                    this.next = it.next();
                }
                this.messageSetWireFormat = z11;
            }
        }

        public ExtendableMessage() {
            this.extensions = FieldSet.newFieldSet();
        }

        private void verifyExtensionContainingType(GeneratedExtension<MessageType, ?> generatedExtension) {
            if (generatedExtension.getContainingTypeDefaultInstance() != getDefaultInstanceForType()) {
                throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
            }
        }

        public void e() {
            this.extensions.makeImmutable();
        }

        public boolean f(CodedInputStream codedInputStream, CodedOutputStream codedOutputStream, ExtensionRegistryLite extensionRegistryLite, int i11) throws IOException {
            return GeneratedMessageLite.parseUnknownField(this.extensions, getDefaultInstanceForType(), codedInputStream, codedOutputStream, extensionRegistryLite, i11);
        }

        public final <Type> Type getExtension(GeneratedExtension<MessageType, Type> generatedExtension) {
            verifyExtensionContainingType(generatedExtension);
            Object field = this.extensions.getField(generatedExtension.f24760d);
            if (field == null) {
                return generatedExtension.f24758b;
            }
            return generatedExtension.a(field);
        }

        public final <Type> int getExtensionCount(GeneratedExtension<MessageType, List<Type>> generatedExtension) {
            verifyExtensionContainingType(generatedExtension);
            return this.extensions.getRepeatedFieldCount(generatedExtension.f24760d);
        }

        public boolean h() {
            return this.extensions.isInitialized();
        }

        public final <Type> boolean hasExtension(GeneratedExtension<MessageType, Type> generatedExtension) {
            verifyExtensionContainingType(generatedExtension);
            return this.extensions.hasField(generatedExtension.f24760d);
        }

        public int i() {
            return this.extensions.getSerializedSize();
        }

        public ExtendableMessage<MessageType>.ExtensionWriter j() {
            return new ExtensionWriter(this, false, (AnonymousClass1) null);
        }

        public ExtendableMessage(ExtendableBuilder<MessageType, ?> extendableBuilder) {
            this.extensions = extendableBuilder.buildExtensions();
        }

        public final <Type> Type getExtension(GeneratedExtension<MessageType, List<Type>> generatedExtension, int i11) {
            verifyExtensionContainingType(generatedExtension);
            return generatedExtension.b(this.extensions.getRepeatedField(generatedExtension.f24760d, i11));
        }
    }

    public GeneratedMessageLite(Builder builder) {
    }

    public static abstract class ExtendableBuilder<MessageType extends ExtendableMessage<MessageType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>> extends Builder<MessageType, BuilderType> implements ExtendableMessageOrBuilder<MessageType> {
        private FieldSet<ExtensionDescriptor> extensions = FieldSet.emptySet();
        private boolean extensionsIsMutable;

        /* access modifiers changed from: private */
        public FieldSet<ExtensionDescriptor> buildExtensions() {
            this.extensions.makeImmutable();
            this.extensionsIsMutable = false;
            return this.extensions;
        }

        private void ensureExtensionsIsMutable() {
            if (!this.extensionsIsMutable) {
                this.extensions = this.extensions.clone();
                this.extensionsIsMutable = true;
            }
        }

        public boolean c() {
            return this.extensions.isInitialized();
        }

        public final void d(MessageType messagetype) {
            ensureExtensionsIsMutable();
            this.extensions.mergeFrom(messagetype.extensions);
        }

        public BuilderType clone() {
            throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
        }
    }
}
