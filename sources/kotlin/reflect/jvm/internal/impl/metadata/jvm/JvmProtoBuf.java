package kotlin.reflect.jvm.internal.impl.metadata.jvm;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractParser;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Internal;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;
import kotlin.reflect.jvm.internal.impl.protobuf.WireFormat;

public final class JvmProtoBuf {
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Class, Integer> anonymousObjectOriginName;
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Class, List<ProtoBuf.Property>> classLocalVariable;
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Class, Integer> classModuleName;
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Constructor, JvmMethodSignature> constructorSignature;
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, Integer> flags;
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Type, Boolean> isRaw = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf.Type.getDefaultInstance(), Boolean.FALSE, (MessageLite) null, (Internal.EnumLiteMap<?>) null, 101, WireFormat.FieldType.BOOL, Boolean.class);
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Class, Integer> jvmClassFlags;
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Function, Integer> lambdaClassOriginName;
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Function, JvmMethodSignature> methodSignature;
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Package, List<ProtoBuf.Property>> packageLocalVariable;
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Package, Integer> packageModuleName;
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, JvmPropertySignature> propertySignature;
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Type, List<ProtoBuf.Annotation>> typeAnnotation;
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.TypeParameter, List<ProtoBuf.Annotation>> typeParameterAnnotation;

    public static final class JvmFieldSignature extends GeneratedMessageLite implements JvmFieldSignatureOrBuilder {
        public static Parser<JvmFieldSignature> PARSER = new AbstractParser<JvmFieldSignature>() {
            public JvmFieldSignature parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new JvmFieldSignature(codedInputStream, extensionRegistryLite);
            }
        };
        private static final JvmFieldSignature defaultInstance;
        /* access modifiers changed from: private */
        public int bitField0_;
        /* access modifiers changed from: private */
        public int desc_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        /* access modifiers changed from: private */
        public int name_;
        /* access modifiers changed from: private */
        public final ByteString unknownFields;

        public static final class Builder extends GeneratedMessageLite.Builder<JvmFieldSignature, Builder> implements JvmFieldSignatureOrBuilder {
            private int bitField0_;
            private int desc_;
            private int name_;

            private Builder() {
                maybeForceBuilderInitialization();
            }

            /* access modifiers changed from: private */
            public static Builder create() {
                return new Builder();
            }

            private void maybeForceBuilderInitialization() {
            }

            public JvmFieldSignature buildPartial() {
                JvmFieldSignature jvmFieldSignature = new JvmFieldSignature((GeneratedMessageLite.Builder) this);
                int i11 = this.bitField0_;
                int i12 = 1;
                if ((i11 & 1) != 1) {
                    i12 = 0;
                }
                int unused = jvmFieldSignature.name_ = this.name_;
                if ((i11 & 2) == 2) {
                    i12 |= 2;
                }
                int unused2 = jvmFieldSignature.desc_ = this.desc_;
                int unused3 = jvmFieldSignature.bitField0_ = i12;
                return jvmFieldSignature;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder setDesc(int i11) {
                this.bitField0_ |= 2;
                this.desc_ = i11;
                return this;
            }

            public Builder setName(int i11) {
                this.bitField0_ |= 1;
                this.name_ = i11;
                return this;
            }

            public JvmFieldSignature build() {
                JvmFieldSignature buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.a(buildPartial);
            }

            public JvmFieldSignature getDefaultInstanceForType() {
                return JvmFieldSignature.getDefaultInstance();
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Builder mergeFrom(JvmFieldSignature jvmFieldSignature) {
                if (jvmFieldSignature == JvmFieldSignature.getDefaultInstance()) {
                    return this;
                }
                if (jvmFieldSignature.hasName()) {
                    setName(jvmFieldSignature.getName());
                }
                if (jvmFieldSignature.hasDesc()) {
                    setDesc(jvmFieldSignature.getDesc());
                }
                setUnknownFields(getUnknownFields().concat(jvmFieldSignature.unknownFields));
                return this;
            }

            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                JvmFieldSignature jvmFieldSignature;
                JvmFieldSignature jvmFieldSignature2 = null;
                try {
                    JvmFieldSignature parsePartialFrom = JvmFieldSignature.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e11) {
                    jvmFieldSignature = (JvmFieldSignature) e11.getUnfinishedMessage();
                    throw e11;
                } catch (Throwable th2) {
                    th = th2;
                    jvmFieldSignature2 = jvmFieldSignature;
                }
                if (jvmFieldSignature2 != null) {
                    mergeFrom(jvmFieldSignature2);
                }
                throw th;
            }
        }

        static {
            JvmFieldSignature jvmFieldSignature = new JvmFieldSignature(true);
            defaultInstance = jvmFieldSignature;
            jvmFieldSignature.initFields();
        }

        public static JvmFieldSignature getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.name_ = 0;
            this.desc_ = 0;
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public int getDesc() {
            return this.desc_;
        }

        public int getName() {
            return this.name_;
        }

        public Parser<JvmFieldSignature> getParserForType() {
            return PARSER;
        }

        public int getSerializedSize() {
            int i11 = this.memoizedSerializedSize;
            if (i11 != -1) {
                return i11;
            }
            int i12 = 0;
            if ((this.bitField0_ & 1) == 1) {
                i12 = 0 + CodedOutputStream.computeInt32Size(1, this.name_);
            }
            if ((this.bitField0_ & 2) == 2) {
                i12 += CodedOutputStream.computeInt32Size(2, this.desc_);
            }
            int size = i12 + this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        public boolean hasDesc() {
            return (this.bitField0_ & 2) == 2;
        }

        public boolean hasName() {
            return (this.bitField0_ & 1) == 1;
        }

        public final boolean isInitialized() {
            byte b11 = this.memoizedIsInitialized;
            if (b11 == 1) {
                return true;
            }
            if (b11 == 0) {
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeInt32(1, this.name_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeInt32(2, this.desc_);
            }
            codedOutputStream.writeRawBytes(this.unknownFields);
        }

        public static Builder newBuilder(JvmFieldSignature jvmFieldSignature) {
            return newBuilder().mergeFrom(jvmFieldSignature);
        }

        public JvmFieldSignature getDefaultInstanceForType() {
            return defaultInstance;
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        private JvmFieldSignature(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private JvmFieldSignature(boolean z11) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        private JvmFieldSignature(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output newOutput = ByteString.newOutput();
            CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput, 1);
            boolean z11 = false;
            while (!z11) {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        if (readTag == 8) {
                            this.bitField0_ |= 1;
                            this.name_ = codedInputStream.readInt32();
                        } else if (readTag == 16) {
                            this.bitField0_ |= 2;
                            this.desc_ = codedInputStream.readInt32();
                        } else if (!f(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                        }
                    }
                    z11 = true;
                } catch (InvalidProtocolBufferException e11) {
                    throw e11.setUnfinishedMessage(this);
                } catch (IOException e12) {
                    throw new InvalidProtocolBufferException(e12.getMessage()).setUnfinishedMessage(this);
                } catch (Throwable th2) {
                    try {
                        newInstance.flush();
                    } catch (IOException unused) {
                    } catch (Throwable th3) {
                        this.unknownFields = newOutput.toByteString();
                        throw th3;
                    }
                    this.unknownFields = newOutput.toByteString();
                    e();
                    throw th2;
                }
            }
            try {
                newInstance.flush();
            } catch (IOException unused2) {
            } catch (Throwable th4) {
                this.unknownFields = newOutput.toByteString();
                throw th4;
            }
            this.unknownFields = newOutput.toByteString();
            e();
        }
    }

    public interface JvmFieldSignatureOrBuilder extends MessageLiteOrBuilder {
    }

    public static final class JvmMethodSignature extends GeneratedMessageLite implements JvmMethodSignatureOrBuilder {
        public static Parser<JvmMethodSignature> PARSER = new AbstractParser<JvmMethodSignature>() {
            public JvmMethodSignature parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new JvmMethodSignature(codedInputStream, extensionRegistryLite);
            }
        };
        private static final JvmMethodSignature defaultInstance;
        /* access modifiers changed from: private */
        public int bitField0_;
        /* access modifiers changed from: private */
        public int desc_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        /* access modifiers changed from: private */
        public int name_;
        /* access modifiers changed from: private */
        public final ByteString unknownFields;

        public static final class Builder extends GeneratedMessageLite.Builder<JvmMethodSignature, Builder> implements JvmMethodSignatureOrBuilder {
            private int bitField0_;
            private int desc_;
            private int name_;

            private Builder() {
                maybeForceBuilderInitialization();
            }

            /* access modifiers changed from: private */
            public static Builder create() {
                return new Builder();
            }

            private void maybeForceBuilderInitialization() {
            }

            public JvmMethodSignature buildPartial() {
                JvmMethodSignature jvmMethodSignature = new JvmMethodSignature((GeneratedMessageLite.Builder) this);
                int i11 = this.bitField0_;
                int i12 = 1;
                if ((i11 & 1) != 1) {
                    i12 = 0;
                }
                int unused = jvmMethodSignature.name_ = this.name_;
                if ((i11 & 2) == 2) {
                    i12 |= 2;
                }
                int unused2 = jvmMethodSignature.desc_ = this.desc_;
                int unused3 = jvmMethodSignature.bitField0_ = i12;
                return jvmMethodSignature;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder setDesc(int i11) {
                this.bitField0_ |= 2;
                this.desc_ = i11;
                return this;
            }

            public Builder setName(int i11) {
                this.bitField0_ |= 1;
                this.name_ = i11;
                return this;
            }

            public JvmMethodSignature build() {
                JvmMethodSignature buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.a(buildPartial);
            }

            public JvmMethodSignature getDefaultInstanceForType() {
                return JvmMethodSignature.getDefaultInstance();
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Builder mergeFrom(JvmMethodSignature jvmMethodSignature) {
                if (jvmMethodSignature == JvmMethodSignature.getDefaultInstance()) {
                    return this;
                }
                if (jvmMethodSignature.hasName()) {
                    setName(jvmMethodSignature.getName());
                }
                if (jvmMethodSignature.hasDesc()) {
                    setDesc(jvmMethodSignature.getDesc());
                }
                setUnknownFields(getUnknownFields().concat(jvmMethodSignature.unknownFields));
                return this;
            }

            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                JvmMethodSignature jvmMethodSignature;
                JvmMethodSignature jvmMethodSignature2 = null;
                try {
                    JvmMethodSignature parsePartialFrom = JvmMethodSignature.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e11) {
                    jvmMethodSignature = (JvmMethodSignature) e11.getUnfinishedMessage();
                    throw e11;
                } catch (Throwable th2) {
                    th = th2;
                    jvmMethodSignature2 = jvmMethodSignature;
                }
                if (jvmMethodSignature2 != null) {
                    mergeFrom(jvmMethodSignature2);
                }
                throw th;
            }
        }

        static {
            JvmMethodSignature jvmMethodSignature = new JvmMethodSignature(true);
            defaultInstance = jvmMethodSignature;
            jvmMethodSignature.initFields();
        }

        public static JvmMethodSignature getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.name_ = 0;
            this.desc_ = 0;
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public int getDesc() {
            return this.desc_;
        }

        public int getName() {
            return this.name_;
        }

        public Parser<JvmMethodSignature> getParserForType() {
            return PARSER;
        }

        public int getSerializedSize() {
            int i11 = this.memoizedSerializedSize;
            if (i11 != -1) {
                return i11;
            }
            int i12 = 0;
            if ((this.bitField0_ & 1) == 1) {
                i12 = 0 + CodedOutputStream.computeInt32Size(1, this.name_);
            }
            if ((this.bitField0_ & 2) == 2) {
                i12 += CodedOutputStream.computeInt32Size(2, this.desc_);
            }
            int size = i12 + this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        public boolean hasDesc() {
            return (this.bitField0_ & 2) == 2;
        }

        public boolean hasName() {
            return (this.bitField0_ & 1) == 1;
        }

        public final boolean isInitialized() {
            byte b11 = this.memoizedIsInitialized;
            if (b11 == 1) {
                return true;
            }
            if (b11 == 0) {
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeInt32(1, this.name_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeInt32(2, this.desc_);
            }
            codedOutputStream.writeRawBytes(this.unknownFields);
        }

        public static Builder newBuilder(JvmMethodSignature jvmMethodSignature) {
            return newBuilder().mergeFrom(jvmMethodSignature);
        }

        public JvmMethodSignature getDefaultInstanceForType() {
            return defaultInstance;
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        private JvmMethodSignature(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private JvmMethodSignature(boolean z11) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        private JvmMethodSignature(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output newOutput = ByteString.newOutput();
            CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput, 1);
            boolean z11 = false;
            while (!z11) {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        if (readTag == 8) {
                            this.bitField0_ |= 1;
                            this.name_ = codedInputStream.readInt32();
                        } else if (readTag == 16) {
                            this.bitField0_ |= 2;
                            this.desc_ = codedInputStream.readInt32();
                        } else if (!f(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                        }
                    }
                    z11 = true;
                } catch (InvalidProtocolBufferException e11) {
                    throw e11.setUnfinishedMessage(this);
                } catch (IOException e12) {
                    throw new InvalidProtocolBufferException(e12.getMessage()).setUnfinishedMessage(this);
                } catch (Throwable th2) {
                    try {
                        newInstance.flush();
                    } catch (IOException unused) {
                    } catch (Throwable th3) {
                        this.unknownFields = newOutput.toByteString();
                        throw th3;
                    }
                    this.unknownFields = newOutput.toByteString();
                    e();
                    throw th2;
                }
            }
            try {
                newInstance.flush();
            } catch (IOException unused2) {
            } catch (Throwable th4) {
                this.unknownFields = newOutput.toByteString();
                throw th4;
            }
            this.unknownFields = newOutput.toByteString();
            e();
        }
    }

    public interface JvmMethodSignatureOrBuilder extends MessageLiteOrBuilder {
    }

    public static final class JvmPropertySignature extends GeneratedMessageLite implements JvmPropertySignatureOrBuilder {
        public static Parser<JvmPropertySignature> PARSER = new AbstractParser<JvmPropertySignature>() {
            public JvmPropertySignature parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new JvmPropertySignature(codedInputStream, extensionRegistryLite);
            }
        };
        private static final JvmPropertySignature defaultInstance;
        /* access modifiers changed from: private */
        public int bitField0_;
        /* access modifiers changed from: private */
        public JvmMethodSignature delegateMethod_;
        /* access modifiers changed from: private */
        public JvmFieldSignature field_;
        /* access modifiers changed from: private */
        public JvmMethodSignature getter_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        /* access modifiers changed from: private */
        public JvmMethodSignature setter_;
        /* access modifiers changed from: private */
        public JvmMethodSignature syntheticMethod_;
        /* access modifiers changed from: private */
        public final ByteString unknownFields;

        public static final class Builder extends GeneratedMessageLite.Builder<JvmPropertySignature, Builder> implements JvmPropertySignatureOrBuilder {
            private int bitField0_;
            private JvmMethodSignature delegateMethod_ = JvmMethodSignature.getDefaultInstance();
            private JvmFieldSignature field_ = JvmFieldSignature.getDefaultInstance();
            private JvmMethodSignature getter_ = JvmMethodSignature.getDefaultInstance();
            private JvmMethodSignature setter_ = JvmMethodSignature.getDefaultInstance();
            private JvmMethodSignature syntheticMethod_ = JvmMethodSignature.getDefaultInstance();

            private Builder() {
                maybeForceBuilderInitialization();
            }

            /* access modifiers changed from: private */
            public static Builder create() {
                return new Builder();
            }

            private void maybeForceBuilderInitialization() {
            }

            public JvmPropertySignature buildPartial() {
                JvmPropertySignature jvmPropertySignature = new JvmPropertySignature((GeneratedMessageLite.Builder) this);
                int i11 = this.bitField0_;
                int i12 = 1;
                if ((i11 & 1) != 1) {
                    i12 = 0;
                }
                JvmFieldSignature unused = jvmPropertySignature.field_ = this.field_;
                if ((i11 & 2) == 2) {
                    i12 |= 2;
                }
                JvmMethodSignature unused2 = jvmPropertySignature.syntheticMethod_ = this.syntheticMethod_;
                if ((i11 & 4) == 4) {
                    i12 |= 4;
                }
                JvmMethodSignature unused3 = jvmPropertySignature.getter_ = this.getter_;
                if ((i11 & 8) == 8) {
                    i12 |= 8;
                }
                JvmMethodSignature unused4 = jvmPropertySignature.setter_ = this.setter_;
                if ((i11 & 16) == 16) {
                    i12 |= 16;
                }
                JvmMethodSignature unused5 = jvmPropertySignature.delegateMethod_ = this.delegateMethod_;
                int unused6 = jvmPropertySignature.bitField0_ = i12;
                return jvmPropertySignature;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeDelegateMethod(JvmMethodSignature jvmMethodSignature) {
                if ((this.bitField0_ & 16) != 16 || this.delegateMethod_ == JvmMethodSignature.getDefaultInstance()) {
                    this.delegateMethod_ = jvmMethodSignature;
                } else {
                    this.delegateMethod_ = JvmMethodSignature.newBuilder(this.delegateMethod_).mergeFrom(jvmMethodSignature).buildPartial();
                }
                this.bitField0_ |= 16;
                return this;
            }

            public Builder mergeField(JvmFieldSignature jvmFieldSignature) {
                if ((this.bitField0_ & 1) != 1 || this.field_ == JvmFieldSignature.getDefaultInstance()) {
                    this.field_ = jvmFieldSignature;
                } else {
                    this.field_ = JvmFieldSignature.newBuilder(this.field_).mergeFrom(jvmFieldSignature).buildPartial();
                }
                this.bitField0_ |= 1;
                return this;
            }

            public Builder mergeGetter(JvmMethodSignature jvmMethodSignature) {
                if ((this.bitField0_ & 4) != 4 || this.getter_ == JvmMethodSignature.getDefaultInstance()) {
                    this.getter_ = jvmMethodSignature;
                } else {
                    this.getter_ = JvmMethodSignature.newBuilder(this.getter_).mergeFrom(jvmMethodSignature).buildPartial();
                }
                this.bitField0_ |= 4;
                return this;
            }

            public Builder mergeSetter(JvmMethodSignature jvmMethodSignature) {
                if ((this.bitField0_ & 8) != 8 || this.setter_ == JvmMethodSignature.getDefaultInstance()) {
                    this.setter_ = jvmMethodSignature;
                } else {
                    this.setter_ = JvmMethodSignature.newBuilder(this.setter_).mergeFrom(jvmMethodSignature).buildPartial();
                }
                this.bitField0_ |= 8;
                return this;
            }

            public Builder mergeSyntheticMethod(JvmMethodSignature jvmMethodSignature) {
                if ((this.bitField0_ & 2) != 2 || this.syntheticMethod_ == JvmMethodSignature.getDefaultInstance()) {
                    this.syntheticMethod_ = jvmMethodSignature;
                } else {
                    this.syntheticMethod_ = JvmMethodSignature.newBuilder(this.syntheticMethod_).mergeFrom(jvmMethodSignature).buildPartial();
                }
                this.bitField0_ |= 2;
                return this;
            }

            public JvmPropertySignature build() {
                JvmPropertySignature buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.a(buildPartial);
            }

            public JvmPropertySignature getDefaultInstanceForType() {
                return JvmPropertySignature.getDefaultInstance();
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Builder mergeFrom(JvmPropertySignature jvmPropertySignature) {
                if (jvmPropertySignature == JvmPropertySignature.getDefaultInstance()) {
                    return this;
                }
                if (jvmPropertySignature.hasField()) {
                    mergeField(jvmPropertySignature.getField());
                }
                if (jvmPropertySignature.hasSyntheticMethod()) {
                    mergeSyntheticMethod(jvmPropertySignature.getSyntheticMethod());
                }
                if (jvmPropertySignature.hasGetter()) {
                    mergeGetter(jvmPropertySignature.getGetter());
                }
                if (jvmPropertySignature.hasSetter()) {
                    mergeSetter(jvmPropertySignature.getSetter());
                }
                if (jvmPropertySignature.hasDelegateMethod()) {
                    mergeDelegateMethod(jvmPropertySignature.getDelegateMethod());
                }
                setUnknownFields(getUnknownFields().concat(jvmPropertySignature.unknownFields));
                return this;
            }

            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                JvmPropertySignature jvmPropertySignature;
                JvmPropertySignature jvmPropertySignature2 = null;
                try {
                    JvmPropertySignature parsePartialFrom = JvmPropertySignature.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e11) {
                    jvmPropertySignature = (JvmPropertySignature) e11.getUnfinishedMessage();
                    throw e11;
                } catch (Throwable th2) {
                    th = th2;
                    jvmPropertySignature2 = jvmPropertySignature;
                }
                if (jvmPropertySignature2 != null) {
                    mergeFrom(jvmPropertySignature2);
                }
                throw th;
            }
        }

        static {
            JvmPropertySignature jvmPropertySignature = new JvmPropertySignature(true);
            defaultInstance = jvmPropertySignature;
            jvmPropertySignature.initFields();
        }

        public static JvmPropertySignature getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.field_ = JvmFieldSignature.getDefaultInstance();
            this.syntheticMethod_ = JvmMethodSignature.getDefaultInstance();
            this.getter_ = JvmMethodSignature.getDefaultInstance();
            this.setter_ = JvmMethodSignature.getDefaultInstance();
            this.delegateMethod_ = JvmMethodSignature.getDefaultInstance();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public JvmMethodSignature getDelegateMethod() {
            return this.delegateMethod_;
        }

        public JvmFieldSignature getField() {
            return this.field_;
        }

        public JvmMethodSignature getGetter() {
            return this.getter_;
        }

        public Parser<JvmPropertySignature> getParserForType() {
            return PARSER;
        }

        public int getSerializedSize() {
            int i11 = this.memoizedSerializedSize;
            if (i11 != -1) {
                return i11;
            }
            int i12 = 0;
            if ((this.bitField0_ & 1) == 1) {
                i12 = 0 + CodedOutputStream.computeMessageSize(1, this.field_);
            }
            if ((this.bitField0_ & 2) == 2) {
                i12 += CodedOutputStream.computeMessageSize(2, this.syntheticMethod_);
            }
            if ((this.bitField0_ & 4) == 4) {
                i12 += CodedOutputStream.computeMessageSize(3, this.getter_);
            }
            if ((this.bitField0_ & 8) == 8) {
                i12 += CodedOutputStream.computeMessageSize(4, this.setter_);
            }
            if ((this.bitField0_ & 16) == 16) {
                i12 += CodedOutputStream.computeMessageSize(5, this.delegateMethod_);
            }
            int size = i12 + this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        public JvmMethodSignature getSetter() {
            return this.setter_;
        }

        public JvmMethodSignature getSyntheticMethod() {
            return this.syntheticMethod_;
        }

        public boolean hasDelegateMethod() {
            return (this.bitField0_ & 16) == 16;
        }

        public boolean hasField() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean hasGetter() {
            return (this.bitField0_ & 4) == 4;
        }

        public boolean hasSetter() {
            return (this.bitField0_ & 8) == 8;
        }

        public boolean hasSyntheticMethod() {
            return (this.bitField0_ & 2) == 2;
        }

        public final boolean isInitialized() {
            byte b11 = this.memoizedIsInitialized;
            if (b11 == 1) {
                return true;
            }
            if (b11 == 0) {
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeMessage(1, this.field_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeMessage(2, this.syntheticMethod_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeMessage(3, this.getter_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeMessage(4, this.setter_);
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.writeMessage(5, this.delegateMethod_);
            }
            codedOutputStream.writeRawBytes(this.unknownFields);
        }

        public static Builder newBuilder(JvmPropertySignature jvmPropertySignature) {
            return newBuilder().mergeFrom(jvmPropertySignature);
        }

        public JvmPropertySignature getDefaultInstanceForType() {
            return defaultInstance;
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        private JvmPropertySignature(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private JvmPropertySignature(boolean z11) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmFieldSignature$Builder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmMethodSignature$Builder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v5, resolved type: kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmMethodSignature$Builder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v7, resolved type: kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmMethodSignature$Builder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v9, resolved type: kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmMethodSignature$Builder} */
        /* JADX WARNING: type inference failed for: r6v0 */
        /* JADX WARNING: type inference failed for: r6v11 */
        /* JADX WARNING: type inference failed for: r6v12 */
        /* JADX WARNING: type inference failed for: r6v13 */
        /* JADX WARNING: type inference failed for: r6v14 */
        /* JADX WARNING: type inference failed for: r6v15 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private JvmPropertySignature(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream r8, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite r9) throws kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException {
            /*
                r7 = this;
                r7.<init>()
                r0 = -1
                r7.memoizedIsInitialized = r0
                r7.memoizedSerializedSize = r0
                r7.initFields()
                kotlin.reflect.jvm.internal.impl.protobuf.ByteString$Output r0 = kotlin.reflect.jvm.internal.impl.protobuf.ByteString.newOutput()
                r1 = 1
                kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream r2 = kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream.newInstance(r0, r1)
                r3 = 0
            L_0x0015:
                if (r3 != 0) goto L_0x0131
                int r4 = r8.readTag()     // Catch:{ InvalidProtocolBufferException -> 0x0115, IOException -> 0x0106 }
                if (r4 == 0) goto L_0x0101
                r5 = 10
                r6 = 0
                if (r4 == r5) goto L_0x00da
                r5 = 18
                if (r4 == r5) goto L_0x00b2
                r5 = 26
                if (r4 == r5) goto L_0x008a
                r5 = 34
                if (r4 == r5) goto L_0x0062
                r5 = 42
                if (r4 == r5) goto L_0x003a
                boolean r4 = r7.f(r8, r2, r9, r4)     // Catch:{ InvalidProtocolBufferException -> 0x0115, IOException -> 0x0106 }
                if (r4 != 0) goto L_0x0015
                goto L_0x0101
            L_0x003a:
                int r4 = r7.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x0115, IOException -> 0x0106 }
                r5 = 16
                r4 = r4 & r5
                if (r4 != r5) goto L_0x0047
                kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmMethodSignature r4 = r7.delegateMethod_     // Catch:{ InvalidProtocolBufferException -> 0x0115, IOException -> 0x0106 }
                kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmMethodSignature$Builder r6 = r4.toBuilder()     // Catch:{ InvalidProtocolBufferException -> 0x0115, IOException -> 0x0106 }
            L_0x0047:
                kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmMethodSignature> r4 = kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmMethodSignature.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x0115, IOException -> 0x0106 }
                kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r4 = r8.readMessage(r4, (kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite) r9)     // Catch:{ InvalidProtocolBufferException -> 0x0115, IOException -> 0x0106 }
                kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmMethodSignature r4 = (kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmMethodSignature) r4     // Catch:{ InvalidProtocolBufferException -> 0x0115, IOException -> 0x0106 }
                r7.delegateMethod_ = r4     // Catch:{ InvalidProtocolBufferException -> 0x0115, IOException -> 0x0106 }
                if (r6 == 0) goto L_0x005c
                r6.mergeFrom((kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmMethodSignature) r4)     // Catch:{ InvalidProtocolBufferException -> 0x0115, IOException -> 0x0106 }
                kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmMethodSignature r4 = r6.buildPartial()     // Catch:{ InvalidProtocolBufferException -> 0x0115, IOException -> 0x0106 }
                r7.delegateMethod_ = r4     // Catch:{ InvalidProtocolBufferException -> 0x0115, IOException -> 0x0106 }
            L_0x005c:
                int r4 = r7.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x0115, IOException -> 0x0106 }
                r4 = r4 | r5
                r7.bitField0_ = r4     // Catch:{ InvalidProtocolBufferException -> 0x0115, IOException -> 0x0106 }
                goto L_0x0015
            L_0x0062:
                int r4 = r7.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x0115, IOException -> 0x0106 }
                r5 = 8
                r4 = r4 & r5
                if (r4 != r5) goto L_0x006f
                kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmMethodSignature r4 = r7.setter_     // Catch:{ InvalidProtocolBufferException -> 0x0115, IOException -> 0x0106 }
                kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmMethodSignature$Builder r6 = r4.toBuilder()     // Catch:{ InvalidProtocolBufferException -> 0x0115, IOException -> 0x0106 }
            L_0x006f:
                kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmMethodSignature> r4 = kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmMethodSignature.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x0115, IOException -> 0x0106 }
                kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r4 = r8.readMessage(r4, (kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite) r9)     // Catch:{ InvalidProtocolBufferException -> 0x0115, IOException -> 0x0106 }
                kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmMethodSignature r4 = (kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmMethodSignature) r4     // Catch:{ InvalidProtocolBufferException -> 0x0115, IOException -> 0x0106 }
                r7.setter_ = r4     // Catch:{ InvalidProtocolBufferException -> 0x0115, IOException -> 0x0106 }
                if (r6 == 0) goto L_0x0084
                r6.mergeFrom((kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmMethodSignature) r4)     // Catch:{ InvalidProtocolBufferException -> 0x0115, IOException -> 0x0106 }
                kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmMethodSignature r4 = r6.buildPartial()     // Catch:{ InvalidProtocolBufferException -> 0x0115, IOException -> 0x0106 }
                r7.setter_ = r4     // Catch:{ InvalidProtocolBufferException -> 0x0115, IOException -> 0x0106 }
            L_0x0084:
                int r4 = r7.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x0115, IOException -> 0x0106 }
                r4 = r4 | r5
                r7.bitField0_ = r4     // Catch:{ InvalidProtocolBufferException -> 0x0115, IOException -> 0x0106 }
                goto L_0x0015
            L_0x008a:
                int r4 = r7.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x0115, IOException -> 0x0106 }
                r5 = 4
                r4 = r4 & r5
                if (r4 != r5) goto L_0x0096
                kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmMethodSignature r4 = r7.getter_     // Catch:{ InvalidProtocolBufferException -> 0x0115, IOException -> 0x0106 }
                kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmMethodSignature$Builder r6 = r4.toBuilder()     // Catch:{ InvalidProtocolBufferException -> 0x0115, IOException -> 0x0106 }
            L_0x0096:
                kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmMethodSignature> r4 = kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmMethodSignature.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x0115, IOException -> 0x0106 }
                kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r4 = r8.readMessage(r4, (kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite) r9)     // Catch:{ InvalidProtocolBufferException -> 0x0115, IOException -> 0x0106 }
                kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmMethodSignature r4 = (kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmMethodSignature) r4     // Catch:{ InvalidProtocolBufferException -> 0x0115, IOException -> 0x0106 }
                r7.getter_ = r4     // Catch:{ InvalidProtocolBufferException -> 0x0115, IOException -> 0x0106 }
                if (r6 == 0) goto L_0x00ab
                r6.mergeFrom((kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmMethodSignature) r4)     // Catch:{ InvalidProtocolBufferException -> 0x0115, IOException -> 0x0106 }
                kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmMethodSignature r4 = r6.buildPartial()     // Catch:{ InvalidProtocolBufferException -> 0x0115, IOException -> 0x0106 }
                r7.getter_ = r4     // Catch:{ InvalidProtocolBufferException -> 0x0115, IOException -> 0x0106 }
            L_0x00ab:
                int r4 = r7.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x0115, IOException -> 0x0106 }
                r4 = r4 | r5
                r7.bitField0_ = r4     // Catch:{ InvalidProtocolBufferException -> 0x0115, IOException -> 0x0106 }
                goto L_0x0015
            L_0x00b2:
                int r4 = r7.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x0115, IOException -> 0x0106 }
                r5 = 2
                r4 = r4 & r5
                if (r4 != r5) goto L_0x00be
                kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmMethodSignature r4 = r7.syntheticMethod_     // Catch:{ InvalidProtocolBufferException -> 0x0115, IOException -> 0x0106 }
                kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmMethodSignature$Builder r6 = r4.toBuilder()     // Catch:{ InvalidProtocolBufferException -> 0x0115, IOException -> 0x0106 }
            L_0x00be:
                kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmMethodSignature> r4 = kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmMethodSignature.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x0115, IOException -> 0x0106 }
                kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r4 = r8.readMessage(r4, (kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite) r9)     // Catch:{ InvalidProtocolBufferException -> 0x0115, IOException -> 0x0106 }
                kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmMethodSignature r4 = (kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmMethodSignature) r4     // Catch:{ InvalidProtocolBufferException -> 0x0115, IOException -> 0x0106 }
                r7.syntheticMethod_ = r4     // Catch:{ InvalidProtocolBufferException -> 0x0115, IOException -> 0x0106 }
                if (r6 == 0) goto L_0x00d3
                r6.mergeFrom((kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmMethodSignature) r4)     // Catch:{ InvalidProtocolBufferException -> 0x0115, IOException -> 0x0106 }
                kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmMethodSignature r4 = r6.buildPartial()     // Catch:{ InvalidProtocolBufferException -> 0x0115, IOException -> 0x0106 }
                r7.syntheticMethod_ = r4     // Catch:{ InvalidProtocolBufferException -> 0x0115, IOException -> 0x0106 }
            L_0x00d3:
                int r4 = r7.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x0115, IOException -> 0x0106 }
                r4 = r4 | r5
                r7.bitField0_ = r4     // Catch:{ InvalidProtocolBufferException -> 0x0115, IOException -> 0x0106 }
                goto L_0x0015
            L_0x00da:
                int r4 = r7.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x0115, IOException -> 0x0106 }
                r4 = r4 & r1
                if (r4 != r1) goto L_0x00e5
                kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmFieldSignature r4 = r7.field_     // Catch:{ InvalidProtocolBufferException -> 0x0115, IOException -> 0x0106 }
                kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmFieldSignature$Builder r6 = r4.toBuilder()     // Catch:{ InvalidProtocolBufferException -> 0x0115, IOException -> 0x0106 }
            L_0x00e5:
                kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmFieldSignature> r4 = kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmFieldSignature.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x0115, IOException -> 0x0106 }
                kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r4 = r8.readMessage(r4, (kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite) r9)     // Catch:{ InvalidProtocolBufferException -> 0x0115, IOException -> 0x0106 }
                kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmFieldSignature r4 = (kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmFieldSignature) r4     // Catch:{ InvalidProtocolBufferException -> 0x0115, IOException -> 0x0106 }
                r7.field_ = r4     // Catch:{ InvalidProtocolBufferException -> 0x0115, IOException -> 0x0106 }
                if (r6 == 0) goto L_0x00fa
                r6.mergeFrom((kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmFieldSignature) r4)     // Catch:{ InvalidProtocolBufferException -> 0x0115, IOException -> 0x0106 }
                kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmFieldSignature r4 = r6.buildPartial()     // Catch:{ InvalidProtocolBufferException -> 0x0115, IOException -> 0x0106 }
                r7.field_ = r4     // Catch:{ InvalidProtocolBufferException -> 0x0115, IOException -> 0x0106 }
            L_0x00fa:
                int r4 = r7.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x0115, IOException -> 0x0106 }
                r4 = r4 | r1
                r7.bitField0_ = r4     // Catch:{ InvalidProtocolBufferException -> 0x0115, IOException -> 0x0106 }
                goto L_0x0015
            L_0x0101:
                r3 = r1
                goto L_0x0015
            L_0x0104:
                r8 = move-exception
                goto L_0x011b
            L_0x0106:
                r8 = move-exception
                kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException r9 = new kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException     // Catch:{ all -> 0x0104 }
                java.lang.String r8 = r8.getMessage()     // Catch:{ all -> 0x0104 }
                r9.<init>(r8)     // Catch:{ all -> 0x0104 }
                kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException r8 = r9.setUnfinishedMessage(r7)     // Catch:{ all -> 0x0104 }
                throw r8     // Catch:{ all -> 0x0104 }
            L_0x0115:
                r8 = move-exception
                kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException r8 = r8.setUnfinishedMessage(r7)     // Catch:{ all -> 0x0104 }
                throw r8     // Catch:{ all -> 0x0104 }
            L_0x011b:
                r2.flush()     // Catch:{ IOException -> 0x011e, all -> 0x0125 }
            L_0x011e:
                kotlin.reflect.jvm.internal.impl.protobuf.ByteString r9 = r0.toByteString()
                r7.unknownFields = r9
                goto L_0x012d
            L_0x0125:
                r8 = move-exception
                kotlin.reflect.jvm.internal.impl.protobuf.ByteString r9 = r0.toByteString()
                r7.unknownFields = r9
                throw r8
            L_0x012d:
                r7.e()
                throw r8
            L_0x0131:
                r2.flush()     // Catch:{ IOException -> 0x0134, all -> 0x013b }
            L_0x0134:
                kotlin.reflect.jvm.internal.impl.protobuf.ByteString r8 = r0.toByteString()
                r7.unknownFields = r8
                goto L_0x0143
            L_0x013b:
                r8 = move-exception
                kotlin.reflect.jvm.internal.impl.protobuf.ByteString r9 = r0.toByteString()
                r7.unknownFields = r9
                throw r8
            L_0x0143:
                r7.e()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmPropertySignature.<init>(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite):void");
        }
    }

    public interface JvmPropertySignatureOrBuilder extends MessageLiteOrBuilder {
    }

    public static final class StringTableTypes extends GeneratedMessageLite implements StringTableTypesOrBuilder {
        public static Parser<StringTableTypes> PARSER = new AbstractParser<StringTableTypes>() {
            public StringTableTypes parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new StringTableTypes(codedInputStream, extensionRegistryLite);
            }
        };
        private static final StringTableTypes defaultInstance;
        private int localNameMemoizedSerializedSize;
        /* access modifiers changed from: private */
        public List<Integer> localName_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        /* access modifiers changed from: private */
        public List<Record> record_;
        /* access modifiers changed from: private */
        public final ByteString unknownFields;

        public static final class Builder extends GeneratedMessageLite.Builder<StringTableTypes, Builder> implements StringTableTypesOrBuilder {
            private int bitField0_;
            private List<Integer> localName_ = Collections.emptyList();
            private List<Record> record_ = Collections.emptyList();

            private Builder() {
                maybeForceBuilderInitialization();
            }

            /* access modifiers changed from: private */
            public static Builder create() {
                return new Builder();
            }

            private void ensureLocalNameIsMutable() {
                if ((this.bitField0_ & 2) != 2) {
                    this.localName_ = new ArrayList(this.localName_);
                    this.bitField0_ |= 2;
                }
            }

            private void ensureRecordIsMutable() {
                if ((this.bitField0_ & 1) != 1) {
                    this.record_ = new ArrayList(this.record_);
                    this.bitField0_ |= 1;
                }
            }

            private void maybeForceBuilderInitialization() {
            }

            public StringTableTypes buildPartial() {
                StringTableTypes stringTableTypes = new StringTableTypes((GeneratedMessageLite.Builder) this);
                if ((this.bitField0_ & 1) == 1) {
                    this.record_ = Collections.unmodifiableList(this.record_);
                    this.bitField0_ &= -2;
                }
                List unused = stringTableTypes.record_ = this.record_;
                if ((this.bitField0_ & 2) == 2) {
                    this.localName_ = Collections.unmodifiableList(this.localName_);
                    this.bitField0_ &= -3;
                }
                List unused2 = stringTableTypes.localName_ = this.localName_;
                return stringTableTypes;
            }

            public final boolean isInitialized() {
                return true;
            }

            public StringTableTypes build() {
                StringTableTypes buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.a(buildPartial);
            }

            public StringTableTypes getDefaultInstanceForType() {
                return StringTableTypes.getDefaultInstance();
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Builder mergeFrom(StringTableTypes stringTableTypes) {
                if (stringTableTypes == StringTableTypes.getDefaultInstance()) {
                    return this;
                }
                if (!stringTableTypes.record_.isEmpty()) {
                    if (this.record_.isEmpty()) {
                        this.record_ = stringTableTypes.record_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureRecordIsMutable();
                        this.record_.addAll(stringTableTypes.record_);
                    }
                }
                if (!stringTableTypes.localName_.isEmpty()) {
                    if (this.localName_.isEmpty()) {
                        this.localName_ = stringTableTypes.localName_;
                        this.bitField0_ &= -3;
                    } else {
                        ensureLocalNameIsMutable();
                        this.localName_.addAll(stringTableTypes.localName_);
                    }
                }
                setUnknownFields(getUnknownFields().concat(stringTableTypes.unknownFields));
                return this;
            }

            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                StringTableTypes stringTableTypes;
                StringTableTypes stringTableTypes2 = null;
                try {
                    StringTableTypes parsePartialFrom = StringTableTypes.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e11) {
                    stringTableTypes = (StringTableTypes) e11.getUnfinishedMessage();
                    throw e11;
                } catch (Throwable th2) {
                    th = th2;
                    stringTableTypes2 = stringTableTypes;
                }
                if (stringTableTypes2 != null) {
                    mergeFrom(stringTableTypes2);
                }
                throw th;
            }
        }

        public static final class Record extends GeneratedMessageLite implements RecordOrBuilder {
            public static Parser<Record> PARSER = new AbstractParser<Record>() {
                public Record parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return new Record(codedInputStream, extensionRegistryLite);
                }
            };
            private static final Record defaultInstance;
            /* access modifiers changed from: private */
            public int bitField0_;
            private byte memoizedIsInitialized;
            private int memoizedSerializedSize;
            /* access modifiers changed from: private */
            public Operation operation_;
            /* access modifiers changed from: private */
            public int predefinedIndex_;
            /* access modifiers changed from: private */
            public int range_;
            private int replaceCharMemoizedSerializedSize;
            /* access modifiers changed from: private */
            public List<Integer> replaceChar_;
            /* access modifiers changed from: private */
            public Object string_;
            private int substringIndexMemoizedSerializedSize;
            /* access modifiers changed from: private */
            public List<Integer> substringIndex_;
            /* access modifiers changed from: private */
            public final ByteString unknownFields;

            public static final class Builder extends GeneratedMessageLite.Builder<Record, Builder> implements RecordOrBuilder {
                private int bitField0_;
                private Operation operation_ = Operation.NONE;
                private int predefinedIndex_;
                private int range_ = 1;
                private List<Integer> replaceChar_ = Collections.emptyList();
                private Object string_ = "";
                private List<Integer> substringIndex_ = Collections.emptyList();

                private Builder() {
                    maybeForceBuilderInitialization();
                }

                /* access modifiers changed from: private */
                public static Builder create() {
                    return new Builder();
                }

                private void ensureReplaceCharIsMutable() {
                    if ((this.bitField0_ & 32) != 32) {
                        this.replaceChar_ = new ArrayList(this.replaceChar_);
                        this.bitField0_ |= 32;
                    }
                }

                private void ensureSubstringIndexIsMutable() {
                    if ((this.bitField0_ & 16) != 16) {
                        this.substringIndex_ = new ArrayList(this.substringIndex_);
                        this.bitField0_ |= 16;
                    }
                }

                private void maybeForceBuilderInitialization() {
                }

                public Record buildPartial() {
                    Record record = new Record((GeneratedMessageLite.Builder) this);
                    int i11 = this.bitField0_;
                    int i12 = 1;
                    if ((i11 & 1) != 1) {
                        i12 = 0;
                    }
                    int unused = record.range_ = this.range_;
                    if ((i11 & 2) == 2) {
                        i12 |= 2;
                    }
                    int unused2 = record.predefinedIndex_ = this.predefinedIndex_;
                    if ((i11 & 4) == 4) {
                        i12 |= 4;
                    }
                    Object unused3 = record.string_ = this.string_;
                    if ((i11 & 8) == 8) {
                        i12 |= 8;
                    }
                    Operation unused4 = record.operation_ = this.operation_;
                    if ((this.bitField0_ & 16) == 16) {
                        this.substringIndex_ = Collections.unmodifiableList(this.substringIndex_);
                        this.bitField0_ &= -17;
                    }
                    List unused5 = record.substringIndex_ = this.substringIndex_;
                    if ((this.bitField0_ & 32) == 32) {
                        this.replaceChar_ = Collections.unmodifiableList(this.replaceChar_);
                        this.bitField0_ &= -33;
                    }
                    List unused6 = record.replaceChar_ = this.replaceChar_;
                    int unused7 = record.bitField0_ = i12;
                    return record;
                }

                public final boolean isInitialized() {
                    return true;
                }

                public Builder setOperation(Operation operation) {
                    operation.getClass();
                    this.bitField0_ |= 8;
                    this.operation_ = operation;
                    return this;
                }

                public Builder setPredefinedIndex(int i11) {
                    this.bitField0_ |= 2;
                    this.predefinedIndex_ = i11;
                    return this;
                }

                public Builder setRange(int i11) {
                    this.bitField0_ |= 1;
                    this.range_ = i11;
                    return this;
                }

                public Record build() {
                    Record buildPartial = buildPartial();
                    if (buildPartial.isInitialized()) {
                        return buildPartial;
                    }
                    throw AbstractMessageLite.Builder.a(buildPartial);
                }

                public Record getDefaultInstanceForType() {
                    return Record.getDefaultInstance();
                }

                public Builder clone() {
                    return create().mergeFrom(buildPartial());
                }

                public Builder mergeFrom(Record record) {
                    if (record == Record.getDefaultInstance()) {
                        return this;
                    }
                    if (record.hasRange()) {
                        setRange(record.getRange());
                    }
                    if (record.hasPredefinedIndex()) {
                        setPredefinedIndex(record.getPredefinedIndex());
                    }
                    if (record.hasString()) {
                        this.bitField0_ |= 4;
                        this.string_ = record.string_;
                    }
                    if (record.hasOperation()) {
                        setOperation(record.getOperation());
                    }
                    if (!record.substringIndex_.isEmpty()) {
                        if (this.substringIndex_.isEmpty()) {
                            this.substringIndex_ = record.substringIndex_;
                            this.bitField0_ &= -17;
                        } else {
                            ensureSubstringIndexIsMutable();
                            this.substringIndex_.addAll(record.substringIndex_);
                        }
                    }
                    if (!record.replaceChar_.isEmpty()) {
                        if (this.replaceChar_.isEmpty()) {
                            this.replaceChar_ = record.replaceChar_;
                            this.bitField0_ &= -33;
                        } else {
                            ensureReplaceCharIsMutable();
                            this.replaceChar_.addAll(record.replaceChar_);
                        }
                    }
                    setUnknownFields(getUnknownFields().concat(record.unknownFields));
                    return this;
                }

                public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                    Record record;
                    Record record2 = null;
                    try {
                        Record parsePartialFrom = Record.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e11) {
                        record = (Record) e11.getUnfinishedMessage();
                        throw e11;
                    } catch (Throwable th2) {
                        th = th2;
                        record2 = record;
                    }
                    if (record2 != null) {
                        mergeFrom(record2);
                    }
                    throw th;
                }
            }

            public enum Operation implements Internal.EnumLite {
                NONE(0, 0),
                INTERNAL_TO_CLASS_ID(1, 1),
                DESC_TO_CLASS_ID(2, 2);
                
                private static Internal.EnumLiteMap<Operation> internalValueMap;
                private final int value;

                /* access modifiers changed from: public */
                static {
                    internalValueMap = new Internal.EnumLiteMap<Operation>() {
                        public Operation findValueByNumber(int i11) {
                            return Operation.valueOf(i11);
                        }
                    };
                }

                private Operation(int i11, int i12) {
                    this.value = i12;
                }

                public final int getNumber() {
                    return this.value;
                }

                public static Operation valueOf(int i11) {
                    if (i11 == 0) {
                        return NONE;
                    }
                    if (i11 == 1) {
                        return INTERNAL_TO_CLASS_ID;
                    }
                    if (i11 != 2) {
                        return null;
                    }
                    return DESC_TO_CLASS_ID;
                }
            }

            static {
                Record record = new Record(true);
                defaultInstance = record;
                record.initFields();
            }

            public static Record getDefaultInstance() {
                return defaultInstance;
            }

            private void initFields() {
                this.range_ = 1;
                this.predefinedIndex_ = 0;
                this.string_ = "";
                this.operation_ = Operation.NONE;
                this.substringIndex_ = Collections.emptyList();
                this.replaceChar_ = Collections.emptyList();
            }

            public static Builder newBuilder() {
                return Builder.create();
            }

            public Operation getOperation() {
                return this.operation_;
            }

            public Parser<Record> getParserForType() {
                return PARSER;
            }

            public int getPredefinedIndex() {
                return this.predefinedIndex_;
            }

            public int getRange() {
                return this.range_;
            }

            public int getReplaceCharCount() {
                return this.replaceChar_.size();
            }

            public List<Integer> getReplaceCharList() {
                return this.replaceChar_;
            }

            public int getSerializedSize() {
                int i11;
                int i12 = this.memoizedSerializedSize;
                if (i12 != -1) {
                    return i12;
                }
                if ((this.bitField0_ & 1) == 1) {
                    i11 = CodedOutputStream.computeInt32Size(1, this.range_) + 0;
                } else {
                    i11 = 0;
                }
                if ((this.bitField0_ & 2) == 2) {
                    i11 += CodedOutputStream.computeInt32Size(2, this.predefinedIndex_);
                }
                if ((this.bitField0_ & 8) == 8) {
                    i11 += CodedOutputStream.computeEnumSize(3, this.operation_.getNumber());
                }
                int i13 = 0;
                for (int i14 = 0; i14 < this.substringIndex_.size(); i14++) {
                    i13 += CodedOutputStream.computeInt32SizeNoTag(this.substringIndex_.get(i14).intValue());
                }
                int i15 = i11 + i13;
                if (!getSubstringIndexList().isEmpty()) {
                    i15 = i15 + 1 + CodedOutputStream.computeInt32SizeNoTag(i13);
                }
                this.substringIndexMemoizedSerializedSize = i13;
                int i16 = 0;
                for (int i17 = 0; i17 < this.replaceChar_.size(); i17++) {
                    i16 += CodedOutputStream.computeInt32SizeNoTag(this.replaceChar_.get(i17).intValue());
                }
                int i18 = i15 + i16;
                if (!getReplaceCharList().isEmpty()) {
                    i18 = i18 + 1 + CodedOutputStream.computeInt32SizeNoTag(i16);
                }
                this.replaceCharMemoizedSerializedSize = i16;
                if ((this.bitField0_ & 4) == 4) {
                    i18 += CodedOutputStream.computeBytesSize(6, getStringBytes());
                }
                int size = i18 + this.unknownFields.size();
                this.memoizedSerializedSize = size;
                return size;
            }

            public String getString() {
                Object obj = this.string_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                ByteString byteString = (ByteString) obj;
                String stringUtf8 = byteString.toStringUtf8();
                if (byteString.isValidUtf8()) {
                    this.string_ = stringUtf8;
                }
                return stringUtf8;
            }

            public ByteString getStringBytes() {
                Object obj = this.string_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.string_ = copyFromUtf8;
                return copyFromUtf8;
            }

            public int getSubstringIndexCount() {
                return this.substringIndex_.size();
            }

            public List<Integer> getSubstringIndexList() {
                return this.substringIndex_;
            }

            public boolean hasOperation() {
                return (this.bitField0_ & 8) == 8;
            }

            public boolean hasPredefinedIndex() {
                return (this.bitField0_ & 2) == 2;
            }

            public boolean hasRange() {
                return (this.bitField0_ & 1) == 1;
            }

            public boolean hasString() {
                return (this.bitField0_ & 4) == 4;
            }

            public final boolean isInitialized() {
                byte b11 = this.memoizedIsInitialized;
                if (b11 == 1) {
                    return true;
                }
                if (b11 == 0) {
                    return false;
                }
                this.memoizedIsInitialized = 1;
                return true;
            }

            public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
                getSerializedSize();
                if ((this.bitField0_ & 1) == 1) {
                    codedOutputStream.writeInt32(1, this.range_);
                }
                if ((this.bitField0_ & 2) == 2) {
                    codedOutputStream.writeInt32(2, this.predefinedIndex_);
                }
                if ((this.bitField0_ & 8) == 8) {
                    codedOutputStream.writeEnum(3, this.operation_.getNumber());
                }
                if (getSubstringIndexList().size() > 0) {
                    codedOutputStream.writeRawVarint32(34);
                    codedOutputStream.writeRawVarint32(this.substringIndexMemoizedSerializedSize);
                }
                for (int i11 = 0; i11 < this.substringIndex_.size(); i11++) {
                    codedOutputStream.writeInt32NoTag(this.substringIndex_.get(i11).intValue());
                }
                if (getReplaceCharList().size() > 0) {
                    codedOutputStream.writeRawVarint32(42);
                    codedOutputStream.writeRawVarint32(this.replaceCharMemoizedSerializedSize);
                }
                for (int i12 = 0; i12 < this.replaceChar_.size(); i12++) {
                    codedOutputStream.writeInt32NoTag(this.replaceChar_.get(i12).intValue());
                }
                if ((this.bitField0_ & 4) == 4) {
                    codedOutputStream.writeBytes(6, getStringBytes());
                }
                codedOutputStream.writeRawBytes(this.unknownFields);
            }

            public static Builder newBuilder(Record record) {
                return newBuilder().mergeFrom(record);
            }

            public Record getDefaultInstanceForType() {
                return defaultInstance;
            }

            public Builder newBuilderForType() {
                return newBuilder();
            }

            public Builder toBuilder() {
                return newBuilder(this);
            }

            private Record(GeneratedMessageLite.Builder builder) {
                super(builder);
                this.substringIndexMemoizedSerializedSize = -1;
                this.replaceCharMemoizedSerializedSize = -1;
                this.memoizedIsInitialized = -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = builder.getUnknownFields();
            }

            private Record(boolean z11) {
                this.substringIndexMemoizedSerializedSize = -1;
                this.replaceCharMemoizedSerializedSize = -1;
                this.memoizedIsInitialized = -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = ByteString.EMPTY;
            }

            private Record(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                this.substringIndexMemoizedSerializedSize = -1;
                this.replaceCharMemoizedSerializedSize = -1;
                this.memoizedIsInitialized = -1;
                this.memoizedSerializedSize = -1;
                initFields();
                ByteString.Output newOutput = ByteString.newOutput();
                CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput, 1);
                boolean z11 = false;
                boolean z12 = false;
                while (!z11) {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 8) {
                                this.bitField0_ |= 1;
                                this.range_ = codedInputStream.readInt32();
                            } else if (readTag == 16) {
                                this.bitField0_ |= 2;
                                this.predefinedIndex_ = codedInputStream.readInt32();
                            } else if (readTag == 24) {
                                int readEnum = codedInputStream.readEnum();
                                Operation valueOf = Operation.valueOf(readEnum);
                                if (valueOf == null) {
                                    newInstance.writeRawVarint32(readTag);
                                    newInstance.writeRawVarint32(readEnum);
                                } else {
                                    this.bitField0_ |= 8;
                                    this.operation_ = valueOf;
                                }
                            } else if (readTag == 32) {
                                if (!(z12 & true)) {
                                    this.substringIndex_ = new ArrayList();
                                    z12 |= true;
                                }
                                this.substringIndex_.add(Integer.valueOf(codedInputStream.readInt32()));
                            } else if (readTag == 34) {
                                int pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                if (!(z12 & true) && codedInputStream.getBytesUntilLimit() > 0) {
                                    this.substringIndex_ = new ArrayList();
                                    z12 |= true;
                                }
                                while (codedInputStream.getBytesUntilLimit() > 0) {
                                    this.substringIndex_.add(Integer.valueOf(codedInputStream.readInt32()));
                                }
                                codedInputStream.popLimit(pushLimit);
                            } else if (readTag == 40) {
                                if (!(z12 & true)) {
                                    this.replaceChar_ = new ArrayList();
                                    z12 |= true;
                                }
                                this.replaceChar_.add(Integer.valueOf(codedInputStream.readInt32()));
                            } else if (readTag == 42) {
                                int pushLimit2 = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                if (!(z12 & true) && codedInputStream.getBytesUntilLimit() > 0) {
                                    this.replaceChar_ = new ArrayList();
                                    z12 |= true;
                                }
                                while (codedInputStream.getBytesUntilLimit() > 0) {
                                    this.replaceChar_.add(Integer.valueOf(codedInputStream.readInt32()));
                                }
                                codedInputStream.popLimit(pushLimit2);
                            } else if (readTag == 50) {
                                ByteString readBytes = codedInputStream.readBytes();
                                this.bitField0_ |= 4;
                                this.string_ = readBytes;
                            } else if (!f(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                            }
                        }
                        z11 = true;
                    } catch (InvalidProtocolBufferException e11) {
                        throw e11.setUnfinishedMessage(this);
                    } catch (IOException e12) {
                        throw new InvalidProtocolBufferException(e12.getMessage()).setUnfinishedMessage(this);
                    } catch (Throwable th2) {
                        if (z12 & true) {
                            this.substringIndex_ = Collections.unmodifiableList(this.substringIndex_);
                        }
                        if (z12 & true) {
                            this.replaceChar_ = Collections.unmodifiableList(this.replaceChar_);
                        }
                        try {
                            newInstance.flush();
                        } catch (IOException unused) {
                        } catch (Throwable th3) {
                            this.unknownFields = newOutput.toByteString();
                            throw th3;
                        }
                        this.unknownFields = newOutput.toByteString();
                        e();
                        throw th2;
                    }
                }
                if (z12 & true) {
                    this.substringIndex_ = Collections.unmodifiableList(this.substringIndex_);
                }
                if (z12 & true) {
                    this.replaceChar_ = Collections.unmodifiableList(this.replaceChar_);
                }
                try {
                    newInstance.flush();
                } catch (IOException unused2) {
                } catch (Throwable th4) {
                    this.unknownFields = newOutput.toByteString();
                    throw th4;
                }
                this.unknownFields = newOutput.toByteString();
                e();
            }
        }

        public interface RecordOrBuilder extends MessageLiteOrBuilder {
        }

        static {
            StringTableTypes stringTableTypes = new StringTableTypes(true);
            defaultInstance = stringTableTypes;
            stringTableTypes.initFields();
        }

        public static StringTableTypes getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.record_ = Collections.emptyList();
            this.localName_ = Collections.emptyList();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public static StringTableTypes parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public List<Integer> getLocalNameList() {
            return this.localName_;
        }

        public Parser<StringTableTypes> getParserForType() {
            return PARSER;
        }

        public List<Record> getRecordList() {
            return this.record_;
        }

        public int getSerializedSize() {
            int i11 = this.memoizedSerializedSize;
            if (i11 != -1) {
                return i11;
            }
            int i12 = 0;
            for (int i13 = 0; i13 < this.record_.size(); i13++) {
                i12 += CodedOutputStream.computeMessageSize(1, this.record_.get(i13));
            }
            int i14 = 0;
            for (int i15 = 0; i15 < this.localName_.size(); i15++) {
                i14 += CodedOutputStream.computeInt32SizeNoTag(this.localName_.get(i15).intValue());
            }
            int i16 = i12 + i14;
            if (!getLocalNameList().isEmpty()) {
                i16 = i16 + 1 + CodedOutputStream.computeInt32SizeNoTag(i14);
            }
            this.localNameMemoizedSerializedSize = i14;
            int size = i16 + this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        public final boolean isInitialized() {
            byte b11 = this.memoizedIsInitialized;
            if (b11 == 1) {
                return true;
            }
            if (b11 == 0) {
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            for (int i11 = 0; i11 < this.record_.size(); i11++) {
                codedOutputStream.writeMessage(1, this.record_.get(i11));
            }
            if (getLocalNameList().size() > 0) {
                codedOutputStream.writeRawVarint32(42);
                codedOutputStream.writeRawVarint32(this.localNameMemoizedSerializedSize);
            }
            for (int i12 = 0; i12 < this.localName_.size(); i12++) {
                codedOutputStream.writeInt32NoTag(this.localName_.get(i12).intValue());
            }
            codedOutputStream.writeRawBytes(this.unknownFields);
        }

        public static Builder newBuilder(StringTableTypes stringTableTypes) {
            return newBuilder().mergeFrom(stringTableTypes);
        }

        public StringTableTypes getDefaultInstanceForType() {
            return defaultInstance;
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        private StringTableTypes(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.localNameMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private StringTableTypes(boolean z11) {
            this.localNameMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        private StringTableTypes(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.localNameMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output newOutput = ByteString.newOutput();
            CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput, 1);
            boolean z11 = false;
            boolean z12 = false;
            while (!z11) {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        if (readTag == 10) {
                            if (!z12 || !true) {
                                this.record_ = new ArrayList();
                                z12 |= true;
                            }
                            this.record_.add(codedInputStream.readMessage(Record.PARSER, extensionRegistryLite));
                        } else if (readTag == 40) {
                            if (!(z12 & true)) {
                                this.localName_ = new ArrayList();
                                z12 |= true;
                            }
                            this.localName_.add(Integer.valueOf(codedInputStream.readInt32()));
                        } else if (readTag == 42) {
                            int pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                            if (!(z12 & true) && codedInputStream.getBytesUntilLimit() > 0) {
                                this.localName_ = new ArrayList();
                                z12 |= true;
                            }
                            while (codedInputStream.getBytesUntilLimit() > 0) {
                                this.localName_.add(Integer.valueOf(codedInputStream.readInt32()));
                            }
                            codedInputStream.popLimit(pushLimit);
                        } else if (!f(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                        }
                    }
                    z11 = true;
                } catch (InvalidProtocolBufferException e11) {
                    throw e11.setUnfinishedMessage(this);
                } catch (IOException e12) {
                    throw new InvalidProtocolBufferException(e12.getMessage()).setUnfinishedMessage(this);
                } catch (Throwable th2) {
                    if (z12 && true) {
                        this.record_ = Collections.unmodifiableList(this.record_);
                    }
                    if (z12 & true) {
                        this.localName_ = Collections.unmodifiableList(this.localName_);
                    }
                    try {
                        newInstance.flush();
                    } catch (IOException unused) {
                    } catch (Throwable th3) {
                        this.unknownFields = newOutput.toByteString();
                        throw th3;
                    }
                    this.unknownFields = newOutput.toByteString();
                    e();
                    throw th2;
                }
            }
            if (z12 && true) {
                this.record_ = Collections.unmodifiableList(this.record_);
            }
            if (z12 & true) {
                this.localName_ = Collections.unmodifiableList(this.localName_);
            }
            try {
                newInstance.flush();
            } catch (IOException unused2) {
            } catch (Throwable th4) {
                this.unknownFields = newOutput.toByteString();
                throw th4;
            }
            this.unknownFields = newOutput.toByteString();
            e();
        }
    }

    public interface StringTableTypesOrBuilder extends MessageLiteOrBuilder {
    }

    static {
        ProtoBuf.Constructor defaultInstance = ProtoBuf.Constructor.getDefaultInstance();
        JvmMethodSignature defaultInstance2 = JvmMethodSignature.getDefaultInstance();
        JvmMethodSignature defaultInstance3 = JvmMethodSignature.getDefaultInstance();
        WireFormat.FieldType fieldType = WireFormat.FieldType.MESSAGE;
        constructorSignature = GeneratedMessageLite.newSingularGeneratedExtension(defaultInstance, defaultInstance2, defaultInstance3, (Internal.EnumLiteMap<?>) null, 100, fieldType, JvmMethodSignature.class);
        WireFormat.FieldType fieldType2 = fieldType;
        methodSignature = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf.Function.getDefaultInstance(), JvmMethodSignature.getDefaultInstance(), JvmMethodSignature.getDefaultInstance(), (Internal.EnumLiteMap<?>) null, 100, fieldType2, JvmMethodSignature.class);
        ProtoBuf.Function defaultInstance4 = ProtoBuf.Function.getDefaultInstance();
        WireFormat.FieldType fieldType3 = WireFormat.FieldType.INT32;
        lambdaClassOriginName = GeneratedMessageLite.newSingularGeneratedExtension(defaultInstance4, null, (MessageLite) null, (Internal.EnumLiteMap<?>) null, 101, fieldType3, Integer.class);
        propertySignature = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf.Property.getDefaultInstance(), JvmPropertySignature.getDefaultInstance(), JvmPropertySignature.getDefaultInstance(), (Internal.EnumLiteMap<?>) null, 100, fieldType2, JvmPropertySignature.class);
        flags = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf.Property.getDefaultInstance(), null, (MessageLite) null, (Internal.EnumLiteMap<?>) null, 101, fieldType3, Integer.class);
        WireFormat.FieldType fieldType4 = fieldType;
        typeAnnotation = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf.Type.getDefaultInstance(), ProtoBuf.Annotation.getDefaultInstance(), (Internal.EnumLiteMap<?>) null, 100, fieldType4, false, ProtoBuf.Annotation.class);
        typeParameterAnnotation = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf.TypeParameter.getDefaultInstance(), ProtoBuf.Annotation.getDefaultInstance(), (Internal.EnumLiteMap<?>) null, 100, fieldType4, false, ProtoBuf.Annotation.class);
        classModuleName = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf.Class.getDefaultInstance(), null, (MessageLite) null, (Internal.EnumLiteMap<?>) null, 101, fieldType3, Integer.class);
        classLocalVariable = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf.Class.getDefaultInstance(), ProtoBuf.Property.getDefaultInstance(), (Internal.EnumLiteMap<?>) null, 102, fieldType4, false, ProtoBuf.Property.class);
        WireFormat.FieldType fieldType5 = fieldType3;
        anonymousObjectOriginName = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf.Class.getDefaultInstance(), null, (MessageLite) null, (Internal.EnumLiteMap<?>) null, 103, fieldType5, Integer.class);
        jvmClassFlags = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf.Class.getDefaultInstance(), null, (MessageLite) null, (Internal.EnumLiteMap<?>) null, 104, fieldType5, Integer.class);
        packageModuleName = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf.Package.getDefaultInstance(), null, (MessageLite) null, (Internal.EnumLiteMap<?>) null, 101, fieldType5, Integer.class);
        packageLocalVariable = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf.Package.getDefaultInstance(), ProtoBuf.Property.getDefaultInstance(), (Internal.EnumLiteMap<?>) null, 102, fieldType4, false, ProtoBuf.Property.class);
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
        extensionRegistryLite.add(constructorSignature);
        extensionRegistryLite.add(methodSignature);
        extensionRegistryLite.add(lambdaClassOriginName);
        extensionRegistryLite.add(propertySignature);
        extensionRegistryLite.add(flags);
        extensionRegistryLite.add(typeAnnotation);
        extensionRegistryLite.add(isRaw);
        extensionRegistryLite.add(typeParameterAnnotation);
        extensionRegistryLite.add(classModuleName);
        extensionRegistryLite.add(classLocalVariable);
        extensionRegistryLite.add(anonymousObjectOriginName);
        extensionRegistryLite.add(jvmClassFlags);
        extensionRegistryLite.add(packageModuleName);
        extensionRegistryLite.add(packageLocalVariable);
    }
}
