package kotlin.reflect.jvm.internal.impl.metadata;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractParser;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Internal;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.LazyStringArrayList;
import kotlin.reflect.jvm.internal.impl.protobuf.LazyStringList;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;
import kotlin.reflect.jvm.internal.impl.protobuf.ProtocolStringList;
import net.bytebuddy.jar.asm.Opcodes;

public final class ProtoBuf {

    public static final class Annotation extends GeneratedMessageLite implements AnnotationOrBuilder {
        public static Parser<Annotation> PARSER = new AbstractParser<Annotation>() {
            public Annotation parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Annotation(codedInputStream, extensionRegistryLite);
            }
        };
        private static final Annotation defaultInstance;
        /* access modifiers changed from: private */
        public List<Argument> argument_;
        /* access modifiers changed from: private */
        public int bitField0_;
        /* access modifiers changed from: private */
        public int id_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        /* access modifiers changed from: private */
        public final ByteString unknownFields;

        public static final class Argument extends GeneratedMessageLite implements ArgumentOrBuilder {
            public static Parser<Argument> PARSER = new AbstractParser<Argument>() {
                public Argument parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return new Argument(codedInputStream, extensionRegistryLite);
                }
            };
            private static final Argument defaultInstance;
            /* access modifiers changed from: private */
            public int bitField0_;
            private byte memoizedIsInitialized;
            private int memoizedSerializedSize;
            /* access modifiers changed from: private */
            public int nameId_;
            /* access modifiers changed from: private */
            public final ByteString unknownFields;
            /* access modifiers changed from: private */
            public Value value_;

            public static final class Builder extends GeneratedMessageLite.Builder<Argument, Builder> implements ArgumentOrBuilder {
                private int bitField0_;
                private int nameId_;
                private Value value_ = Value.getDefaultInstance();

                private Builder() {
                    maybeForceBuilderInitialization();
                }

                /* access modifiers changed from: private */
                public static Builder create() {
                    return new Builder();
                }

                private void maybeForceBuilderInitialization() {
                }

                public Argument buildPartial() {
                    Argument argument = new Argument((GeneratedMessageLite.Builder) this);
                    int i11 = this.bitField0_;
                    int i12 = 1;
                    if ((i11 & 1) != 1) {
                        i12 = 0;
                    }
                    int unused = argument.nameId_ = this.nameId_;
                    if ((i11 & 2) == 2) {
                        i12 |= 2;
                    }
                    Value unused2 = argument.value_ = this.value_;
                    int unused3 = argument.bitField0_ = i12;
                    return argument;
                }

                public Value getValue() {
                    return this.value_;
                }

                public boolean hasNameId() {
                    return (this.bitField0_ & 1) == 1;
                }

                public boolean hasValue() {
                    return (this.bitField0_ & 2) == 2;
                }

                public final boolean isInitialized() {
                    if (hasNameId() && hasValue() && getValue().isInitialized()) {
                        return true;
                    }
                    return false;
                }

                public Builder mergeValue(Value value) {
                    if ((this.bitField0_ & 2) != 2 || this.value_ == Value.getDefaultInstance()) {
                        this.value_ = value;
                    } else {
                        this.value_ = Value.newBuilder(this.value_).mergeFrom(value).buildPartial();
                    }
                    this.bitField0_ |= 2;
                    return this;
                }

                public Builder setNameId(int i11) {
                    this.bitField0_ |= 1;
                    this.nameId_ = i11;
                    return this;
                }

                public Argument build() {
                    Argument buildPartial = buildPartial();
                    if (buildPartial.isInitialized()) {
                        return buildPartial;
                    }
                    throw AbstractMessageLite.Builder.a(buildPartial);
                }

                public Argument getDefaultInstanceForType() {
                    return Argument.getDefaultInstance();
                }

                public Builder clone() {
                    return create().mergeFrom(buildPartial());
                }

                public Builder mergeFrom(Argument argument) {
                    if (argument == Argument.getDefaultInstance()) {
                        return this;
                    }
                    if (argument.hasNameId()) {
                        setNameId(argument.getNameId());
                    }
                    if (argument.hasValue()) {
                        mergeValue(argument.getValue());
                    }
                    setUnknownFields(getUnknownFields().concat(argument.unknownFields));
                    return this;
                }

                public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                    Argument argument;
                    Argument argument2 = null;
                    try {
                        Argument parsePartialFrom = Argument.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e11) {
                        argument = (Argument) e11.getUnfinishedMessage();
                        throw e11;
                    } catch (Throwable th2) {
                        th = th2;
                        argument2 = argument;
                    }
                    if (argument2 != null) {
                        mergeFrom(argument2);
                    }
                    throw th;
                }
            }

            public static final class Value extends GeneratedMessageLite implements ValueOrBuilder {
                public static Parser<Value> PARSER = new AbstractParser<Value>() {
                    public Value parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                        return new Value(codedInputStream, extensionRegistryLite);
                    }
                };
                private static final Value defaultInstance;
                /* access modifiers changed from: private */
                public Annotation annotation_;
                /* access modifiers changed from: private */
                public int arrayDimensionCount_;
                /* access modifiers changed from: private */
                public List<Value> arrayElement_;
                /* access modifiers changed from: private */
                public int bitField0_;
                /* access modifiers changed from: private */
                public int classId_;
                /* access modifiers changed from: private */
                public double doubleValue_;
                /* access modifiers changed from: private */
                public int enumValueId_;
                /* access modifiers changed from: private */
                public int flags_;
                /* access modifiers changed from: private */
                public float floatValue_;
                /* access modifiers changed from: private */
                public long intValue_;
                private byte memoizedIsInitialized;
                private int memoizedSerializedSize;
                /* access modifiers changed from: private */
                public int stringValue_;
                /* access modifiers changed from: private */
                public Type type_;
                /* access modifiers changed from: private */
                public final ByteString unknownFields;

                public static final class Builder extends GeneratedMessageLite.Builder<Value, Builder> implements ValueOrBuilder {
                    private Annotation annotation_ = Annotation.getDefaultInstance();
                    private int arrayDimensionCount_;
                    private List<Value> arrayElement_ = Collections.emptyList();
                    private int bitField0_;
                    private int classId_;
                    private double doubleValue_;
                    private int enumValueId_;
                    private int flags_;
                    private float floatValue_;
                    private long intValue_;
                    private int stringValue_;
                    private Type type_ = Type.BYTE;

                    private Builder() {
                        maybeForceBuilderInitialization();
                    }

                    /* access modifiers changed from: private */
                    public static Builder create() {
                        return new Builder();
                    }

                    private void ensureArrayElementIsMutable() {
                        if ((this.bitField0_ & 256) != 256) {
                            this.arrayElement_ = new ArrayList(this.arrayElement_);
                            this.bitField0_ |= 256;
                        }
                    }

                    private void maybeForceBuilderInitialization() {
                    }

                    public Value buildPartial() {
                        Value value = new Value((GeneratedMessageLite.Builder) this);
                        int i11 = this.bitField0_;
                        int i12 = 1;
                        if ((i11 & 1) != 1) {
                            i12 = 0;
                        }
                        Type unused = value.type_ = this.type_;
                        if ((i11 & 2) == 2) {
                            i12 |= 2;
                        }
                        long unused2 = value.intValue_ = this.intValue_;
                        if ((i11 & 4) == 4) {
                            i12 |= 4;
                        }
                        float unused3 = value.floatValue_ = this.floatValue_;
                        if ((i11 & 8) == 8) {
                            i12 |= 8;
                        }
                        double unused4 = value.doubleValue_ = this.doubleValue_;
                        if ((i11 & 16) == 16) {
                            i12 |= 16;
                        }
                        int unused5 = value.stringValue_ = this.stringValue_;
                        if ((i11 & 32) == 32) {
                            i12 |= 32;
                        }
                        int unused6 = value.classId_ = this.classId_;
                        if ((i11 & 64) == 64) {
                            i12 |= 64;
                        }
                        int unused7 = value.enumValueId_ = this.enumValueId_;
                        if ((i11 & 128) == 128) {
                            i12 |= 128;
                        }
                        Annotation unused8 = value.annotation_ = this.annotation_;
                        if ((this.bitField0_ & 256) == 256) {
                            this.arrayElement_ = Collections.unmodifiableList(this.arrayElement_);
                            this.bitField0_ &= -257;
                        }
                        List unused9 = value.arrayElement_ = this.arrayElement_;
                        if ((i11 & 512) == 512) {
                            i12 |= 256;
                        }
                        int unused10 = value.arrayDimensionCount_ = this.arrayDimensionCount_;
                        if ((i11 & 1024) == 1024) {
                            i12 |= 512;
                        }
                        int unused11 = value.flags_ = this.flags_;
                        int unused12 = value.bitField0_ = i12;
                        return value;
                    }

                    public Annotation getAnnotation() {
                        return this.annotation_;
                    }

                    public Value getArrayElement(int i11) {
                        return this.arrayElement_.get(i11);
                    }

                    public int getArrayElementCount() {
                        return this.arrayElement_.size();
                    }

                    public boolean hasAnnotation() {
                        return (this.bitField0_ & 128) == 128;
                    }

                    public final boolean isInitialized() {
                        if (hasAnnotation() && !getAnnotation().isInitialized()) {
                            return false;
                        }
                        for (int i11 = 0; i11 < getArrayElementCount(); i11++) {
                            if (!getArrayElement(i11).isInitialized()) {
                                return false;
                            }
                        }
                        return true;
                    }

                    public Builder mergeAnnotation(Annotation annotation) {
                        if ((this.bitField0_ & 128) != 128 || this.annotation_ == Annotation.getDefaultInstance()) {
                            this.annotation_ = annotation;
                        } else {
                            this.annotation_ = Annotation.newBuilder(this.annotation_).mergeFrom(annotation).buildPartial();
                        }
                        this.bitField0_ |= 128;
                        return this;
                    }

                    public Builder setArrayDimensionCount(int i11) {
                        this.bitField0_ |= 512;
                        this.arrayDimensionCount_ = i11;
                        return this;
                    }

                    public Builder setClassId(int i11) {
                        this.bitField0_ |= 32;
                        this.classId_ = i11;
                        return this;
                    }

                    public Builder setDoubleValue(double d11) {
                        this.bitField0_ |= 8;
                        this.doubleValue_ = d11;
                        return this;
                    }

                    public Builder setEnumValueId(int i11) {
                        this.bitField0_ |= 64;
                        this.enumValueId_ = i11;
                        return this;
                    }

                    public Builder setFlags(int i11) {
                        this.bitField0_ |= 1024;
                        this.flags_ = i11;
                        return this;
                    }

                    public Builder setFloatValue(float f11) {
                        this.bitField0_ |= 4;
                        this.floatValue_ = f11;
                        return this;
                    }

                    public Builder setIntValue(long j11) {
                        this.bitField0_ |= 2;
                        this.intValue_ = j11;
                        return this;
                    }

                    public Builder setStringValue(int i11) {
                        this.bitField0_ |= 16;
                        this.stringValue_ = i11;
                        return this;
                    }

                    public Builder setType(Type type) {
                        type.getClass();
                        this.bitField0_ |= 1;
                        this.type_ = type;
                        return this;
                    }

                    public Value build() {
                        Value buildPartial = buildPartial();
                        if (buildPartial.isInitialized()) {
                            return buildPartial;
                        }
                        throw AbstractMessageLite.Builder.a(buildPartial);
                    }

                    public Value getDefaultInstanceForType() {
                        return Value.getDefaultInstance();
                    }

                    public Builder clone() {
                        return create().mergeFrom(buildPartial());
                    }

                    public Builder mergeFrom(Value value) {
                        if (value == Value.getDefaultInstance()) {
                            return this;
                        }
                        if (value.hasType()) {
                            setType(value.getType());
                        }
                        if (value.hasIntValue()) {
                            setIntValue(value.getIntValue());
                        }
                        if (value.hasFloatValue()) {
                            setFloatValue(value.getFloatValue());
                        }
                        if (value.hasDoubleValue()) {
                            setDoubleValue(value.getDoubleValue());
                        }
                        if (value.hasStringValue()) {
                            setStringValue(value.getStringValue());
                        }
                        if (value.hasClassId()) {
                            setClassId(value.getClassId());
                        }
                        if (value.hasEnumValueId()) {
                            setEnumValueId(value.getEnumValueId());
                        }
                        if (value.hasAnnotation()) {
                            mergeAnnotation(value.getAnnotation());
                        }
                        if (!value.arrayElement_.isEmpty()) {
                            if (this.arrayElement_.isEmpty()) {
                                this.arrayElement_ = value.arrayElement_;
                                this.bitField0_ &= -257;
                            } else {
                                ensureArrayElementIsMutable();
                                this.arrayElement_.addAll(value.arrayElement_);
                            }
                        }
                        if (value.hasArrayDimensionCount()) {
                            setArrayDimensionCount(value.getArrayDimensionCount());
                        }
                        if (value.hasFlags()) {
                            setFlags(value.getFlags());
                        }
                        setUnknownFields(getUnknownFields().concat(value.unknownFields));
                        return this;
                    }

                    public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                        Value value;
                        Value value2 = null;
                        try {
                            Value parsePartialFrom = Value.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                            if (parsePartialFrom != null) {
                                mergeFrom(parsePartialFrom);
                            }
                            return this;
                        } catch (InvalidProtocolBufferException e11) {
                            value = (Value) e11.getUnfinishedMessage();
                            throw e11;
                        } catch (Throwable th2) {
                            th = th2;
                            value2 = value;
                        }
                        if (value2 != null) {
                            mergeFrom(value2);
                        }
                        throw th;
                    }
                }

                public enum Type implements Internal.EnumLite {
                    BYTE(0, 0),
                    CHAR(1, 1),
                    SHORT(2, 2),
                    INT(3, 3),
                    LONG(4, 4),
                    FLOAT(5, 5),
                    DOUBLE(6, 6),
                    BOOLEAN(7, 7),
                    STRING(8, 8),
                    CLASS(9, 9),
                    ENUM(10, 10),
                    ANNOTATION(11, 11),
                    ARRAY(12, 12);
                    
                    private static Internal.EnumLiteMap<Type> internalValueMap;
                    private final int value;

                    /* access modifiers changed from: public */
                    static {
                        internalValueMap = new Internal.EnumLiteMap<Type>() {
                            public Type findValueByNumber(int i11) {
                                return Type.valueOf(i11);
                            }
                        };
                    }

                    private Type(int i11, int i12) {
                        this.value = i12;
                    }

                    public final int getNumber() {
                        return this.value;
                    }

                    public static Type valueOf(int i11) {
                        switch (i11) {
                            case 0:
                                return BYTE;
                            case 1:
                                return CHAR;
                            case 2:
                                return SHORT;
                            case 3:
                                return INT;
                            case 4:
                                return LONG;
                            case 5:
                                return FLOAT;
                            case 6:
                                return DOUBLE;
                            case 7:
                                return BOOLEAN;
                            case 8:
                                return STRING;
                            case 9:
                                return CLASS;
                            case 10:
                                return ENUM;
                            case 11:
                                return ANNOTATION;
                            case 12:
                                return ARRAY;
                            default:
                                return null;
                        }
                    }
                }

                static {
                    Value value = new Value(true);
                    defaultInstance = value;
                    value.initFields();
                }

                public static Value getDefaultInstance() {
                    return defaultInstance;
                }

                private void initFields() {
                    this.type_ = Type.BYTE;
                    this.intValue_ = 0;
                    this.floatValue_ = 0.0f;
                    this.doubleValue_ = 0.0d;
                    this.stringValue_ = 0;
                    this.classId_ = 0;
                    this.enumValueId_ = 0;
                    this.annotation_ = Annotation.getDefaultInstance();
                    this.arrayElement_ = Collections.emptyList();
                    this.arrayDimensionCount_ = 0;
                    this.flags_ = 0;
                }

                public static Builder newBuilder() {
                    return Builder.create();
                }

                public Annotation getAnnotation() {
                    return this.annotation_;
                }

                public int getArrayDimensionCount() {
                    return this.arrayDimensionCount_;
                }

                public Value getArrayElement(int i11) {
                    return this.arrayElement_.get(i11);
                }

                public int getArrayElementCount() {
                    return this.arrayElement_.size();
                }

                public List<Value> getArrayElementList() {
                    return this.arrayElement_;
                }

                public int getClassId() {
                    return this.classId_;
                }

                public double getDoubleValue() {
                    return this.doubleValue_;
                }

                public int getEnumValueId() {
                    return this.enumValueId_;
                }

                public int getFlags() {
                    return this.flags_;
                }

                public float getFloatValue() {
                    return this.floatValue_;
                }

                public long getIntValue() {
                    return this.intValue_;
                }

                public Parser<Value> getParserForType() {
                    return PARSER;
                }

                public int getSerializedSize() {
                    int i11;
                    int i12 = this.memoizedSerializedSize;
                    if (i12 != -1) {
                        return i12;
                    }
                    if ((this.bitField0_ & 1) == 1) {
                        i11 = CodedOutputStream.computeEnumSize(1, this.type_.getNumber()) + 0;
                    } else {
                        i11 = 0;
                    }
                    if ((this.bitField0_ & 2) == 2) {
                        i11 += CodedOutputStream.computeSInt64Size(2, this.intValue_);
                    }
                    if ((this.bitField0_ & 4) == 4) {
                        i11 += CodedOutputStream.computeFloatSize(3, this.floatValue_);
                    }
                    if ((this.bitField0_ & 8) == 8) {
                        i11 += CodedOutputStream.computeDoubleSize(4, this.doubleValue_);
                    }
                    if ((this.bitField0_ & 16) == 16) {
                        i11 += CodedOutputStream.computeInt32Size(5, this.stringValue_);
                    }
                    if ((this.bitField0_ & 32) == 32) {
                        i11 += CodedOutputStream.computeInt32Size(6, this.classId_);
                    }
                    if ((this.bitField0_ & 64) == 64) {
                        i11 += CodedOutputStream.computeInt32Size(7, this.enumValueId_);
                    }
                    if ((this.bitField0_ & 128) == 128) {
                        i11 += CodedOutputStream.computeMessageSize(8, this.annotation_);
                    }
                    for (int i13 = 0; i13 < this.arrayElement_.size(); i13++) {
                        i11 += CodedOutputStream.computeMessageSize(9, this.arrayElement_.get(i13));
                    }
                    if ((this.bitField0_ & 512) == 512) {
                        i11 += CodedOutputStream.computeInt32Size(10, this.flags_);
                    }
                    if ((this.bitField0_ & 256) == 256) {
                        i11 += CodedOutputStream.computeInt32Size(11, this.arrayDimensionCount_);
                    }
                    int size = i11 + this.unknownFields.size();
                    this.memoizedSerializedSize = size;
                    return size;
                }

                public int getStringValue() {
                    return this.stringValue_;
                }

                public Type getType() {
                    return this.type_;
                }

                public boolean hasAnnotation() {
                    return (this.bitField0_ & 128) == 128;
                }

                public boolean hasArrayDimensionCount() {
                    return (this.bitField0_ & 256) == 256;
                }

                public boolean hasClassId() {
                    return (this.bitField0_ & 32) == 32;
                }

                public boolean hasDoubleValue() {
                    return (this.bitField0_ & 8) == 8;
                }

                public boolean hasEnumValueId() {
                    return (this.bitField0_ & 64) == 64;
                }

                public boolean hasFlags() {
                    return (this.bitField0_ & 512) == 512;
                }

                public boolean hasFloatValue() {
                    return (this.bitField0_ & 4) == 4;
                }

                public boolean hasIntValue() {
                    return (this.bitField0_ & 2) == 2;
                }

                public boolean hasStringValue() {
                    return (this.bitField0_ & 16) == 16;
                }

                public boolean hasType() {
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
                    if (!hasAnnotation() || getAnnotation().isInitialized()) {
                        for (int i11 = 0; i11 < getArrayElementCount(); i11++) {
                            if (!getArrayElement(i11).isInitialized()) {
                                this.memoizedIsInitialized = 0;
                                return false;
                            }
                        }
                        this.memoizedIsInitialized = 1;
                        return true;
                    }
                    this.memoizedIsInitialized = 0;
                    return false;
                }

                public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
                    getSerializedSize();
                    if ((this.bitField0_ & 1) == 1) {
                        codedOutputStream.writeEnum(1, this.type_.getNumber());
                    }
                    if ((this.bitField0_ & 2) == 2) {
                        codedOutputStream.writeSInt64(2, this.intValue_);
                    }
                    if ((this.bitField0_ & 4) == 4) {
                        codedOutputStream.writeFloat(3, this.floatValue_);
                    }
                    if ((this.bitField0_ & 8) == 8) {
                        codedOutputStream.writeDouble(4, this.doubleValue_);
                    }
                    if ((this.bitField0_ & 16) == 16) {
                        codedOutputStream.writeInt32(5, this.stringValue_);
                    }
                    if ((this.bitField0_ & 32) == 32) {
                        codedOutputStream.writeInt32(6, this.classId_);
                    }
                    if ((this.bitField0_ & 64) == 64) {
                        codedOutputStream.writeInt32(7, this.enumValueId_);
                    }
                    if ((this.bitField0_ & 128) == 128) {
                        codedOutputStream.writeMessage(8, this.annotation_);
                    }
                    for (int i11 = 0; i11 < this.arrayElement_.size(); i11++) {
                        codedOutputStream.writeMessage(9, this.arrayElement_.get(i11));
                    }
                    if ((this.bitField0_ & 512) == 512) {
                        codedOutputStream.writeInt32(10, this.flags_);
                    }
                    if ((this.bitField0_ & 256) == 256) {
                        codedOutputStream.writeInt32(11, this.arrayDimensionCount_);
                    }
                    codedOutputStream.writeRawBytes(this.unknownFields);
                }

                public static Builder newBuilder(Value value) {
                    return newBuilder().mergeFrom(value);
                }

                public Value getDefaultInstanceForType() {
                    return defaultInstance;
                }

                public Builder newBuilderForType() {
                    return newBuilder();
                }

                public Builder toBuilder() {
                    return newBuilder(this);
                }

                private Value(GeneratedMessageLite.Builder builder) {
                    super(builder);
                    this.memoizedIsInitialized = -1;
                    this.memoizedSerializedSize = -1;
                    this.unknownFields = builder.getUnknownFields();
                }

                private Value(boolean z11) {
                    this.memoizedIsInitialized = -1;
                    this.memoizedSerializedSize = -1;
                    this.unknownFields = ByteString.EMPTY;
                }

                private Value(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            switch (readTag) {
                                case 0:
                                    z11 = true;
                                    break;
                                case 8:
                                    int readEnum = codedInputStream.readEnum();
                                    Type valueOf = Type.valueOf(readEnum);
                                    if (valueOf != null) {
                                        this.bitField0_ |= 1;
                                        this.type_ = valueOf;
                                        break;
                                    } else {
                                        newInstance.writeRawVarint32(readTag);
                                        newInstance.writeRawVarint32(readEnum);
                                        break;
                                    }
                                case 16:
                                    this.bitField0_ |= 2;
                                    this.intValue_ = codedInputStream.readSInt64();
                                    break;
                                case 29:
                                    this.bitField0_ |= 4;
                                    this.floatValue_ = codedInputStream.readFloat();
                                    break;
                                case 33:
                                    this.bitField0_ |= 8;
                                    this.doubleValue_ = codedInputStream.readDouble();
                                    break;
                                case 40:
                                    this.bitField0_ |= 16;
                                    this.stringValue_ = codedInputStream.readInt32();
                                    break;
                                case 48:
                                    this.bitField0_ |= 32;
                                    this.classId_ = codedInputStream.readInt32();
                                    break;
                                case 56:
                                    this.bitField0_ |= 64;
                                    this.enumValueId_ = codedInputStream.readInt32();
                                    break;
                                case 66:
                                    Builder builder = (this.bitField0_ & 128) == 128 ? this.annotation_.toBuilder() : null;
                                    Annotation annotation = (Annotation) codedInputStream.readMessage(Annotation.PARSER, extensionRegistryLite);
                                    this.annotation_ = annotation;
                                    if (builder != null) {
                                        builder.mergeFrom(annotation);
                                        this.annotation_ = builder.buildPartial();
                                    }
                                    this.bitField0_ |= 128;
                                    break;
                                case 74:
                                    if (!(z12 & true)) {
                                        this.arrayElement_ = new ArrayList();
                                        z12 |= true;
                                    }
                                    this.arrayElement_.add(codedInputStream.readMessage(PARSER, extensionRegistryLite));
                                    break;
                                case 80:
                                    this.bitField0_ |= 512;
                                    this.flags_ = codedInputStream.readInt32();
                                    break;
                                case 88:
                                    this.bitField0_ |= 256;
                                    this.arrayDimensionCount_ = codedInputStream.readInt32();
                                    break;
                                default:
                                    if (f(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                                        break;
                                    }
                                    z11 = true;
                                    break;
                            }
                        } catch (InvalidProtocolBufferException e11) {
                            throw e11.setUnfinishedMessage(this);
                        } catch (IOException e12) {
                            throw new InvalidProtocolBufferException(e12.getMessage()).setUnfinishedMessage(this);
                        } catch (Throwable th2) {
                            if (z12 & true) {
                                this.arrayElement_ = Collections.unmodifiableList(this.arrayElement_);
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
                        this.arrayElement_ = Collections.unmodifiableList(this.arrayElement_);
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

            public interface ValueOrBuilder extends MessageLiteOrBuilder {
            }

            static {
                Argument argument = new Argument(true);
                defaultInstance = argument;
                argument.initFields();
            }

            public static Argument getDefaultInstance() {
                return defaultInstance;
            }

            private void initFields() {
                this.nameId_ = 0;
                this.value_ = Value.getDefaultInstance();
            }

            public static Builder newBuilder() {
                return Builder.create();
            }

            public int getNameId() {
                return this.nameId_;
            }

            public Parser<Argument> getParserForType() {
                return PARSER;
            }

            public int getSerializedSize() {
                int i11 = this.memoizedSerializedSize;
                if (i11 != -1) {
                    return i11;
                }
                int i12 = 0;
                if ((this.bitField0_ & 1) == 1) {
                    i12 = 0 + CodedOutputStream.computeInt32Size(1, this.nameId_);
                }
                if ((this.bitField0_ & 2) == 2) {
                    i12 += CodedOutputStream.computeMessageSize(2, this.value_);
                }
                int size = i12 + this.unknownFields.size();
                this.memoizedSerializedSize = size;
                return size;
            }

            public Value getValue() {
                return this.value_;
            }

            public boolean hasNameId() {
                return (this.bitField0_ & 1) == 1;
            }

            public boolean hasValue() {
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
                if (!hasNameId()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                } else if (!hasValue()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                } else if (!getValue().isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                } else {
                    this.memoizedIsInitialized = 1;
                    return true;
                }
            }

            public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
                getSerializedSize();
                if ((this.bitField0_ & 1) == 1) {
                    codedOutputStream.writeInt32(1, this.nameId_);
                }
                if ((this.bitField0_ & 2) == 2) {
                    codedOutputStream.writeMessage(2, this.value_);
                }
                codedOutputStream.writeRawBytes(this.unknownFields);
            }

            public static Builder newBuilder(Argument argument) {
                return newBuilder().mergeFrom(argument);
            }

            public Argument getDefaultInstanceForType() {
                return defaultInstance;
            }

            public Builder newBuilderForType() {
                return newBuilder();
            }

            public Builder toBuilder() {
                return newBuilder(this);
            }

            private Argument(GeneratedMessageLite.Builder builder) {
                super(builder);
                this.memoizedIsInitialized = -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = builder.getUnknownFields();
            }

            private Argument(boolean z11) {
                this.memoizedIsInitialized = -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = ByteString.EMPTY;
            }

            private Argument(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                this.nameId_ = codedInputStream.readInt32();
                            } else if (readTag == 18) {
                                Value.Builder builder = (this.bitField0_ & 2) == 2 ? this.value_.toBuilder() : null;
                                Value value = (Value) codedInputStream.readMessage(Value.PARSER, extensionRegistryLite);
                                this.value_ = value;
                                if (builder != null) {
                                    builder.mergeFrom(value);
                                    this.value_ = builder.buildPartial();
                                }
                                this.bitField0_ |= 2;
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

        public interface ArgumentOrBuilder extends MessageLiteOrBuilder {
        }

        public static final class Builder extends GeneratedMessageLite.Builder<Annotation, Builder> implements AnnotationOrBuilder {
            private List<Argument> argument_ = Collections.emptyList();
            private int bitField0_;
            private int id_;

            private Builder() {
                maybeForceBuilderInitialization();
            }

            /* access modifiers changed from: private */
            public static Builder create() {
                return new Builder();
            }

            private void ensureArgumentIsMutable() {
                if ((this.bitField0_ & 2) != 2) {
                    this.argument_ = new ArrayList(this.argument_);
                    this.bitField0_ |= 2;
                }
            }

            private void maybeForceBuilderInitialization() {
            }

            public Annotation buildPartial() {
                Annotation annotation = new Annotation((GeneratedMessageLite.Builder) this);
                int i11 = 1;
                if ((this.bitField0_ & 1) != 1) {
                    i11 = 0;
                }
                int unused = annotation.id_ = this.id_;
                if ((this.bitField0_ & 2) == 2) {
                    this.argument_ = Collections.unmodifiableList(this.argument_);
                    this.bitField0_ &= -3;
                }
                List unused2 = annotation.argument_ = this.argument_;
                int unused3 = annotation.bitField0_ = i11;
                return annotation;
            }

            public Argument getArgument(int i11) {
                return this.argument_.get(i11);
            }

            public int getArgumentCount() {
                return this.argument_.size();
            }

            public boolean hasId() {
                return (this.bitField0_ & 1) == 1;
            }

            public final boolean isInitialized() {
                if (!hasId()) {
                    return false;
                }
                for (int i11 = 0; i11 < getArgumentCount(); i11++) {
                    if (!getArgument(i11).isInitialized()) {
                        return false;
                    }
                }
                return true;
            }

            public Builder setId(int i11) {
                this.bitField0_ |= 1;
                this.id_ = i11;
                return this;
            }

            public Annotation build() {
                Annotation buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.a(buildPartial);
            }

            public Annotation getDefaultInstanceForType() {
                return Annotation.getDefaultInstance();
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Builder mergeFrom(Annotation annotation) {
                if (annotation == Annotation.getDefaultInstance()) {
                    return this;
                }
                if (annotation.hasId()) {
                    setId(annotation.getId());
                }
                if (!annotation.argument_.isEmpty()) {
                    if (this.argument_.isEmpty()) {
                        this.argument_ = annotation.argument_;
                        this.bitField0_ &= -3;
                    } else {
                        ensureArgumentIsMutable();
                        this.argument_.addAll(annotation.argument_);
                    }
                }
                setUnknownFields(getUnknownFields().concat(annotation.unknownFields));
                return this;
            }

            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                Annotation annotation;
                Annotation annotation2 = null;
                try {
                    Annotation parsePartialFrom = Annotation.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e11) {
                    annotation = (Annotation) e11.getUnfinishedMessage();
                    throw e11;
                } catch (Throwable th2) {
                    th = th2;
                    annotation2 = annotation;
                }
                if (annotation2 != null) {
                    mergeFrom(annotation2);
                }
                throw th;
            }
        }

        static {
            Annotation annotation = new Annotation(true);
            defaultInstance = annotation;
            annotation.initFields();
        }

        public static Annotation getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.id_ = 0;
            this.argument_ = Collections.emptyList();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Argument getArgument(int i11) {
            return this.argument_.get(i11);
        }

        public int getArgumentCount() {
            return this.argument_.size();
        }

        public List<Argument> getArgumentList() {
            return this.argument_;
        }

        public int getId() {
            return this.id_;
        }

        public Parser<Annotation> getParserForType() {
            return PARSER;
        }

        public int getSerializedSize() {
            int i11;
            int i12 = this.memoizedSerializedSize;
            if (i12 != -1) {
                return i12;
            }
            if ((this.bitField0_ & 1) == 1) {
                i11 = CodedOutputStream.computeInt32Size(1, this.id_) + 0;
            } else {
                i11 = 0;
            }
            for (int i13 = 0; i13 < this.argument_.size(); i13++) {
                i11 += CodedOutputStream.computeMessageSize(2, this.argument_.get(i13));
            }
            int size = i11 + this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        public boolean hasId() {
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
            if (!hasId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            for (int i11 = 0; i11 < getArgumentCount(); i11++) {
                if (!getArgument(i11).isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeInt32(1, this.id_);
            }
            for (int i11 = 0; i11 < this.argument_.size(); i11++) {
                codedOutputStream.writeMessage(2, this.argument_.get(i11));
            }
            codedOutputStream.writeRawBytes(this.unknownFields);
        }

        public static Builder newBuilder(Annotation annotation) {
            return newBuilder().mergeFrom(annotation);
        }

        public Annotation getDefaultInstanceForType() {
            return defaultInstance;
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        private Annotation(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private Annotation(boolean z11) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        private Annotation(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            this.id_ = codedInputStream.readInt32();
                        } else if (readTag == 18) {
                            if (!(z12 & true)) {
                                this.argument_ = new ArrayList();
                                z12 |= true;
                            }
                            this.argument_.add(codedInputStream.readMessage(Argument.PARSER, extensionRegistryLite));
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
                        this.argument_ = Collections.unmodifiableList(this.argument_);
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
                this.argument_ = Collections.unmodifiableList(this.argument_);
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

    public interface AnnotationOrBuilder extends MessageLiteOrBuilder {
    }

    public static final class Class extends GeneratedMessageLite.ExtendableMessage<Class> implements ClassOrBuilder {
        public static Parser<Class> PARSER = new AbstractParser<Class>() {
            public Class parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Class(codedInputStream, extensionRegistryLite);
            }
        };
        private static final Class defaultInstance;
        /* access modifiers changed from: private */
        public int bitField0_;
        /* access modifiers changed from: private */
        public int companionObjectName_;
        /* access modifiers changed from: private */
        public List<Constructor> constructor_;
        private int contextReceiverTypeIdMemoizedSerializedSize;
        /* access modifiers changed from: private */
        public List<Integer> contextReceiverTypeId_;
        /* access modifiers changed from: private */
        public List<Type> contextReceiverType_;
        /* access modifiers changed from: private */
        public List<EnumEntry> enumEntry_;
        /* access modifiers changed from: private */
        public int flags_;
        /* access modifiers changed from: private */
        public int fqName_;
        /* access modifiers changed from: private */
        public List<Function> function_;
        /* access modifiers changed from: private */
        public int inlineClassUnderlyingPropertyName_;
        /* access modifiers changed from: private */
        public int inlineClassUnderlyingTypeId_;
        /* access modifiers changed from: private */
        public Type inlineClassUnderlyingType_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int multiFieldValueClassUnderlyingNameMemoizedSerializedSize;
        /* access modifiers changed from: private */
        public List<Integer> multiFieldValueClassUnderlyingName_;
        private int multiFieldValueClassUnderlyingTypeIdMemoizedSerializedSize;
        /* access modifiers changed from: private */
        public List<Integer> multiFieldValueClassUnderlyingTypeId_;
        /* access modifiers changed from: private */
        public List<Type> multiFieldValueClassUnderlyingType_;
        private int nestedClassNameMemoizedSerializedSize;
        /* access modifiers changed from: private */
        public List<Integer> nestedClassName_;
        /* access modifiers changed from: private */
        public List<Property> property_;
        private int sealedSubclassFqNameMemoizedSerializedSize;
        /* access modifiers changed from: private */
        public List<Integer> sealedSubclassFqName_;
        private int supertypeIdMemoizedSerializedSize;
        /* access modifiers changed from: private */
        public List<Integer> supertypeId_;
        /* access modifiers changed from: private */
        public List<Type> supertype_;
        /* access modifiers changed from: private */
        public List<TypeAlias> typeAlias_;
        /* access modifiers changed from: private */
        public List<TypeParameter> typeParameter_;
        /* access modifiers changed from: private */
        public TypeTable typeTable_;
        /* access modifiers changed from: private */
        public final ByteString unknownFields;
        /* access modifiers changed from: private */
        public VersionRequirementTable versionRequirementTable_;
        /* access modifiers changed from: private */
        public List<Integer> versionRequirement_;

        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<Class, Builder> implements ClassOrBuilder {
            private int bitField0_;
            private int companionObjectName_;
            private List<Constructor> constructor_ = Collections.emptyList();
            private List<Integer> contextReceiverTypeId_ = Collections.emptyList();
            private List<Type> contextReceiverType_ = Collections.emptyList();
            private List<EnumEntry> enumEntry_ = Collections.emptyList();
            private int flags_ = 6;
            private int fqName_;
            private List<Function> function_ = Collections.emptyList();
            private int inlineClassUnderlyingPropertyName_;
            private int inlineClassUnderlyingTypeId_;
            private Type inlineClassUnderlyingType_ = Type.getDefaultInstance();
            private List<Integer> multiFieldValueClassUnderlyingName_ = Collections.emptyList();
            private List<Integer> multiFieldValueClassUnderlyingTypeId_ = Collections.emptyList();
            private List<Type> multiFieldValueClassUnderlyingType_ = Collections.emptyList();
            private List<Integer> nestedClassName_ = Collections.emptyList();
            private List<Property> property_ = Collections.emptyList();
            private List<Integer> sealedSubclassFqName_ = Collections.emptyList();
            private List<Integer> supertypeId_ = Collections.emptyList();
            private List<Type> supertype_ = Collections.emptyList();
            private List<TypeAlias> typeAlias_ = Collections.emptyList();
            private List<TypeParameter> typeParameter_ = Collections.emptyList();
            private TypeTable typeTable_ = TypeTable.getDefaultInstance();
            private VersionRequirementTable versionRequirementTable_ = VersionRequirementTable.getDefaultInstance();
            private List<Integer> versionRequirement_ = Collections.emptyList();

            private Builder() {
                maybeForceBuilderInitialization();
            }

            /* access modifiers changed from: private */
            public static Builder create() {
                return new Builder();
            }

            private void ensureConstructorIsMutable() {
                if ((this.bitField0_ & 512) != 512) {
                    this.constructor_ = new ArrayList(this.constructor_);
                    this.bitField0_ |= 512;
                }
            }

            private void ensureContextReceiverTypeIdIsMutable() {
                if ((this.bitField0_ & 256) != 256) {
                    this.contextReceiverTypeId_ = new ArrayList(this.contextReceiverTypeId_);
                    this.bitField0_ |= 256;
                }
            }

            private void ensureContextReceiverTypeIsMutable() {
                if ((this.bitField0_ & 128) != 128) {
                    this.contextReceiverType_ = new ArrayList(this.contextReceiverType_);
                    this.bitField0_ |= 128;
                }
            }

            private void ensureEnumEntryIsMutable() {
                if ((this.bitField0_ & 8192) != 8192) {
                    this.enumEntry_ = new ArrayList(this.enumEntry_);
                    this.bitField0_ |= 8192;
                }
            }

            private void ensureFunctionIsMutable() {
                if ((this.bitField0_ & 1024) != 1024) {
                    this.function_ = new ArrayList(this.function_);
                    this.bitField0_ |= 1024;
                }
            }

            private void ensureMultiFieldValueClassUnderlyingNameIsMutable() {
                if ((this.bitField0_ & 262144) != 262144) {
                    this.multiFieldValueClassUnderlyingName_ = new ArrayList(this.multiFieldValueClassUnderlyingName_);
                    this.bitField0_ |= 262144;
                }
            }

            private void ensureMultiFieldValueClassUnderlyingTypeIdIsMutable() {
                if ((this.bitField0_ & 1048576) != 1048576) {
                    this.multiFieldValueClassUnderlyingTypeId_ = new ArrayList(this.multiFieldValueClassUnderlyingTypeId_);
                    this.bitField0_ |= 1048576;
                }
            }

            private void ensureMultiFieldValueClassUnderlyingTypeIsMutable() {
                if ((this.bitField0_ & 524288) != 524288) {
                    this.multiFieldValueClassUnderlyingType_ = new ArrayList(this.multiFieldValueClassUnderlyingType_);
                    this.bitField0_ |= 524288;
                }
            }

            private void ensureNestedClassNameIsMutable() {
                if ((this.bitField0_ & 64) != 64) {
                    this.nestedClassName_ = new ArrayList(this.nestedClassName_);
                    this.bitField0_ |= 64;
                }
            }

            private void ensurePropertyIsMutable() {
                if ((this.bitField0_ & 2048) != 2048) {
                    this.property_ = new ArrayList(this.property_);
                    this.bitField0_ |= 2048;
                }
            }

            private void ensureSealedSubclassFqNameIsMutable() {
                if ((this.bitField0_ & 16384) != 16384) {
                    this.sealedSubclassFqName_ = new ArrayList(this.sealedSubclassFqName_);
                    this.bitField0_ |= 16384;
                }
            }

            private void ensureSupertypeIdIsMutable() {
                if ((this.bitField0_ & 32) != 32) {
                    this.supertypeId_ = new ArrayList(this.supertypeId_);
                    this.bitField0_ |= 32;
                }
            }

            private void ensureSupertypeIsMutable() {
                if ((this.bitField0_ & 16) != 16) {
                    this.supertype_ = new ArrayList(this.supertype_);
                    this.bitField0_ |= 16;
                }
            }

            private void ensureTypeAliasIsMutable() {
                if ((this.bitField0_ & 4096) != 4096) {
                    this.typeAlias_ = new ArrayList(this.typeAlias_);
                    this.bitField0_ |= 4096;
                }
            }

            private void ensureTypeParameterIsMutable() {
                if ((this.bitField0_ & 8) != 8) {
                    this.typeParameter_ = new ArrayList(this.typeParameter_);
                    this.bitField0_ |= 8;
                }
            }

            private void ensureVersionRequirementIsMutable() {
                if ((this.bitField0_ & 4194304) != 4194304) {
                    this.versionRequirement_ = new ArrayList(this.versionRequirement_);
                    this.bitField0_ |= 4194304;
                }
            }

            private void maybeForceBuilderInitialization() {
            }

            public Class buildPartial() {
                Class classR = new Class((GeneratedMessageLite.ExtendableBuilder) this);
                int i11 = this.bitField0_;
                int i12 = 1;
                if ((i11 & 1) != 1) {
                    i12 = 0;
                }
                int unused = classR.flags_ = this.flags_;
                if ((i11 & 2) == 2) {
                    i12 |= 2;
                }
                int unused2 = classR.fqName_ = this.fqName_;
                if ((i11 & 4) == 4) {
                    i12 |= 4;
                }
                int unused3 = classR.companionObjectName_ = this.companionObjectName_;
                if ((this.bitField0_ & 8) == 8) {
                    this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                    this.bitField0_ &= -9;
                }
                List unused4 = classR.typeParameter_ = this.typeParameter_;
                if ((this.bitField0_ & 16) == 16) {
                    this.supertype_ = Collections.unmodifiableList(this.supertype_);
                    this.bitField0_ &= -17;
                }
                List unused5 = classR.supertype_ = this.supertype_;
                if ((this.bitField0_ & 32) == 32) {
                    this.supertypeId_ = Collections.unmodifiableList(this.supertypeId_);
                    this.bitField0_ &= -33;
                }
                List unused6 = classR.supertypeId_ = this.supertypeId_;
                if ((this.bitField0_ & 64) == 64) {
                    this.nestedClassName_ = Collections.unmodifiableList(this.nestedClassName_);
                    this.bitField0_ &= -65;
                }
                List unused7 = classR.nestedClassName_ = this.nestedClassName_;
                if ((this.bitField0_ & 128) == 128) {
                    this.contextReceiverType_ = Collections.unmodifiableList(this.contextReceiverType_);
                    this.bitField0_ &= -129;
                }
                List unused8 = classR.contextReceiverType_ = this.contextReceiverType_;
                if ((this.bitField0_ & 256) == 256) {
                    this.contextReceiverTypeId_ = Collections.unmodifiableList(this.contextReceiverTypeId_);
                    this.bitField0_ &= -257;
                }
                List unused9 = classR.contextReceiverTypeId_ = this.contextReceiverTypeId_;
                if ((this.bitField0_ & 512) == 512) {
                    this.constructor_ = Collections.unmodifiableList(this.constructor_);
                    this.bitField0_ &= -513;
                }
                List unused10 = classR.constructor_ = this.constructor_;
                if ((this.bitField0_ & 1024) == 1024) {
                    this.function_ = Collections.unmodifiableList(this.function_);
                    this.bitField0_ &= -1025;
                }
                List unused11 = classR.function_ = this.function_;
                if ((this.bitField0_ & 2048) == 2048) {
                    this.property_ = Collections.unmodifiableList(this.property_);
                    this.bitField0_ &= -2049;
                }
                List unused12 = classR.property_ = this.property_;
                if ((this.bitField0_ & 4096) == 4096) {
                    this.typeAlias_ = Collections.unmodifiableList(this.typeAlias_);
                    this.bitField0_ &= -4097;
                }
                List unused13 = classR.typeAlias_ = this.typeAlias_;
                if ((this.bitField0_ & 8192) == 8192) {
                    this.enumEntry_ = Collections.unmodifiableList(this.enumEntry_);
                    this.bitField0_ &= -8193;
                }
                List unused14 = classR.enumEntry_ = this.enumEntry_;
                if ((this.bitField0_ & 16384) == 16384) {
                    this.sealedSubclassFqName_ = Collections.unmodifiableList(this.sealedSubclassFqName_);
                    this.bitField0_ &= -16385;
                }
                List unused15 = classR.sealedSubclassFqName_ = this.sealedSubclassFqName_;
                if ((i11 & 32768) == 32768) {
                    i12 |= 8;
                }
                int unused16 = classR.inlineClassUnderlyingPropertyName_ = this.inlineClassUnderlyingPropertyName_;
                if ((i11 & 65536) == 65536) {
                    i12 |= 16;
                }
                Type unused17 = classR.inlineClassUnderlyingType_ = this.inlineClassUnderlyingType_;
                if ((i11 & 131072) == 131072) {
                    i12 |= 32;
                }
                int unused18 = classR.inlineClassUnderlyingTypeId_ = this.inlineClassUnderlyingTypeId_;
                if ((this.bitField0_ & 262144) == 262144) {
                    this.multiFieldValueClassUnderlyingName_ = Collections.unmodifiableList(this.multiFieldValueClassUnderlyingName_);
                    this.bitField0_ &= -262145;
                }
                List unused19 = classR.multiFieldValueClassUnderlyingName_ = this.multiFieldValueClassUnderlyingName_;
                if ((this.bitField0_ & 524288) == 524288) {
                    this.multiFieldValueClassUnderlyingType_ = Collections.unmodifiableList(this.multiFieldValueClassUnderlyingType_);
                    this.bitField0_ &= -524289;
                }
                List unused20 = classR.multiFieldValueClassUnderlyingType_ = this.multiFieldValueClassUnderlyingType_;
                if ((this.bitField0_ & 1048576) == 1048576) {
                    this.multiFieldValueClassUnderlyingTypeId_ = Collections.unmodifiableList(this.multiFieldValueClassUnderlyingTypeId_);
                    this.bitField0_ &= -1048577;
                }
                List unused21 = classR.multiFieldValueClassUnderlyingTypeId_ = this.multiFieldValueClassUnderlyingTypeId_;
                if ((i11 & 2097152) == 2097152) {
                    i12 |= 64;
                }
                TypeTable unused22 = classR.typeTable_ = this.typeTable_;
                if ((this.bitField0_ & 4194304) == 4194304) {
                    this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
                    this.bitField0_ &= -4194305;
                }
                List unused23 = classR.versionRequirement_ = this.versionRequirement_;
                if ((i11 & 8388608) == 8388608) {
                    i12 |= 128;
                }
                VersionRequirementTable unused24 = classR.versionRequirementTable_ = this.versionRequirementTable_;
                int unused25 = classR.bitField0_ = i12;
                return classR;
            }

            public Constructor getConstructor(int i11) {
                return this.constructor_.get(i11);
            }

            public int getConstructorCount() {
                return this.constructor_.size();
            }

            public Type getContextReceiverType(int i11) {
                return this.contextReceiverType_.get(i11);
            }

            public int getContextReceiverTypeCount() {
                return this.contextReceiverType_.size();
            }

            public EnumEntry getEnumEntry(int i11) {
                return this.enumEntry_.get(i11);
            }

            public int getEnumEntryCount() {
                return this.enumEntry_.size();
            }

            public Function getFunction(int i11) {
                return this.function_.get(i11);
            }

            public int getFunctionCount() {
                return this.function_.size();
            }

            public Type getInlineClassUnderlyingType() {
                return this.inlineClassUnderlyingType_;
            }

            public Type getMultiFieldValueClassUnderlyingType(int i11) {
                return this.multiFieldValueClassUnderlyingType_.get(i11);
            }

            public int getMultiFieldValueClassUnderlyingTypeCount() {
                return this.multiFieldValueClassUnderlyingType_.size();
            }

            public Property getProperty(int i11) {
                return this.property_.get(i11);
            }

            public int getPropertyCount() {
                return this.property_.size();
            }

            public Type getSupertype(int i11) {
                return this.supertype_.get(i11);
            }

            public int getSupertypeCount() {
                return this.supertype_.size();
            }

            public TypeAlias getTypeAlias(int i11) {
                return this.typeAlias_.get(i11);
            }

            public int getTypeAliasCount() {
                return this.typeAlias_.size();
            }

            public TypeParameter getTypeParameter(int i11) {
                return this.typeParameter_.get(i11);
            }

            public int getTypeParameterCount() {
                return this.typeParameter_.size();
            }

            public TypeTable getTypeTable() {
                return this.typeTable_;
            }

            public boolean hasFqName() {
                return (this.bitField0_ & 2) == 2;
            }

            public boolean hasInlineClassUnderlyingType() {
                return (this.bitField0_ & 65536) == 65536;
            }

            public boolean hasTypeTable() {
                return (this.bitField0_ & 2097152) == 2097152;
            }

            public final boolean isInitialized() {
                if (!hasFqName()) {
                    return false;
                }
                for (int i11 = 0; i11 < getTypeParameterCount(); i11++) {
                    if (!getTypeParameter(i11).isInitialized()) {
                        return false;
                    }
                }
                for (int i12 = 0; i12 < getSupertypeCount(); i12++) {
                    if (!getSupertype(i12).isInitialized()) {
                        return false;
                    }
                }
                for (int i13 = 0; i13 < getContextReceiverTypeCount(); i13++) {
                    if (!getContextReceiverType(i13).isInitialized()) {
                        return false;
                    }
                }
                for (int i14 = 0; i14 < getConstructorCount(); i14++) {
                    if (!getConstructor(i14).isInitialized()) {
                        return false;
                    }
                }
                for (int i15 = 0; i15 < getFunctionCount(); i15++) {
                    if (!getFunction(i15).isInitialized()) {
                        return false;
                    }
                }
                for (int i16 = 0; i16 < getPropertyCount(); i16++) {
                    if (!getProperty(i16).isInitialized()) {
                        return false;
                    }
                }
                for (int i17 = 0; i17 < getTypeAliasCount(); i17++) {
                    if (!getTypeAlias(i17).isInitialized()) {
                        return false;
                    }
                }
                for (int i18 = 0; i18 < getEnumEntryCount(); i18++) {
                    if (!getEnumEntry(i18).isInitialized()) {
                        return false;
                    }
                }
                if (hasInlineClassUnderlyingType() && !getInlineClassUnderlyingType().isInitialized()) {
                    return false;
                }
                for (int i19 = 0; i19 < getMultiFieldValueClassUnderlyingTypeCount(); i19++) {
                    if (!getMultiFieldValueClassUnderlyingType(i19).isInitialized()) {
                        return false;
                    }
                }
                if ((!hasTypeTable() || getTypeTable().isInitialized()) && c()) {
                    return true;
                }
                return false;
            }

            public Builder mergeInlineClassUnderlyingType(Type type) {
                if ((this.bitField0_ & 65536) != 65536 || this.inlineClassUnderlyingType_ == Type.getDefaultInstance()) {
                    this.inlineClassUnderlyingType_ = type;
                } else {
                    this.inlineClassUnderlyingType_ = Type.newBuilder(this.inlineClassUnderlyingType_).mergeFrom(type).buildPartial();
                }
                this.bitField0_ |= 65536;
                return this;
            }

            public Builder mergeTypeTable(TypeTable typeTable) {
                if ((this.bitField0_ & 2097152) != 2097152 || this.typeTable_ == TypeTable.getDefaultInstance()) {
                    this.typeTable_ = typeTable;
                } else {
                    this.typeTable_ = TypeTable.newBuilder(this.typeTable_).mergeFrom(typeTable).buildPartial();
                }
                this.bitField0_ |= 2097152;
                return this;
            }

            public Builder mergeVersionRequirementTable(VersionRequirementTable versionRequirementTable) {
                if ((this.bitField0_ & 8388608) != 8388608 || this.versionRequirementTable_ == VersionRequirementTable.getDefaultInstance()) {
                    this.versionRequirementTable_ = versionRequirementTable;
                } else {
                    this.versionRequirementTable_ = VersionRequirementTable.newBuilder(this.versionRequirementTable_).mergeFrom(versionRequirementTable).buildPartial();
                }
                this.bitField0_ |= 8388608;
                return this;
            }

            public Builder setCompanionObjectName(int i11) {
                this.bitField0_ |= 4;
                this.companionObjectName_ = i11;
                return this;
            }

            public Builder setFlags(int i11) {
                this.bitField0_ |= 1;
                this.flags_ = i11;
                return this;
            }

            public Builder setFqName(int i11) {
                this.bitField0_ |= 2;
                this.fqName_ = i11;
                return this;
            }

            public Builder setInlineClassUnderlyingPropertyName(int i11) {
                this.bitField0_ |= 32768;
                this.inlineClassUnderlyingPropertyName_ = i11;
                return this;
            }

            public Builder setInlineClassUnderlyingTypeId(int i11) {
                this.bitField0_ |= 131072;
                this.inlineClassUnderlyingTypeId_ = i11;
                return this;
            }

            public Class build() {
                Class buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.a(buildPartial);
            }

            public Class getDefaultInstanceForType() {
                return Class.getDefaultInstance();
            }

            public Builder mergeFrom(Class classR) {
                if (classR == Class.getDefaultInstance()) {
                    return this;
                }
                if (classR.hasFlags()) {
                    setFlags(classR.getFlags());
                }
                if (classR.hasFqName()) {
                    setFqName(classR.getFqName());
                }
                if (classR.hasCompanionObjectName()) {
                    setCompanionObjectName(classR.getCompanionObjectName());
                }
                if (!classR.typeParameter_.isEmpty()) {
                    if (this.typeParameter_.isEmpty()) {
                        this.typeParameter_ = classR.typeParameter_;
                        this.bitField0_ &= -9;
                    } else {
                        ensureTypeParameterIsMutable();
                        this.typeParameter_.addAll(classR.typeParameter_);
                    }
                }
                if (!classR.supertype_.isEmpty()) {
                    if (this.supertype_.isEmpty()) {
                        this.supertype_ = classR.supertype_;
                        this.bitField0_ &= -17;
                    } else {
                        ensureSupertypeIsMutable();
                        this.supertype_.addAll(classR.supertype_);
                    }
                }
                if (!classR.supertypeId_.isEmpty()) {
                    if (this.supertypeId_.isEmpty()) {
                        this.supertypeId_ = classR.supertypeId_;
                        this.bitField0_ &= -33;
                    } else {
                        ensureSupertypeIdIsMutable();
                        this.supertypeId_.addAll(classR.supertypeId_);
                    }
                }
                if (!classR.nestedClassName_.isEmpty()) {
                    if (this.nestedClassName_.isEmpty()) {
                        this.nestedClassName_ = classR.nestedClassName_;
                        this.bitField0_ &= -65;
                    } else {
                        ensureNestedClassNameIsMutable();
                        this.nestedClassName_.addAll(classR.nestedClassName_);
                    }
                }
                if (!classR.contextReceiverType_.isEmpty()) {
                    if (this.contextReceiverType_.isEmpty()) {
                        this.contextReceiverType_ = classR.contextReceiverType_;
                        this.bitField0_ &= -129;
                    } else {
                        ensureContextReceiverTypeIsMutable();
                        this.contextReceiverType_.addAll(classR.contextReceiverType_);
                    }
                }
                if (!classR.contextReceiverTypeId_.isEmpty()) {
                    if (this.contextReceiverTypeId_.isEmpty()) {
                        this.contextReceiverTypeId_ = classR.contextReceiverTypeId_;
                        this.bitField0_ &= -257;
                    } else {
                        ensureContextReceiverTypeIdIsMutable();
                        this.contextReceiverTypeId_.addAll(classR.contextReceiverTypeId_);
                    }
                }
                if (!classR.constructor_.isEmpty()) {
                    if (this.constructor_.isEmpty()) {
                        this.constructor_ = classR.constructor_;
                        this.bitField0_ &= -513;
                    } else {
                        ensureConstructorIsMutable();
                        this.constructor_.addAll(classR.constructor_);
                    }
                }
                if (!classR.function_.isEmpty()) {
                    if (this.function_.isEmpty()) {
                        this.function_ = classR.function_;
                        this.bitField0_ &= -1025;
                    } else {
                        ensureFunctionIsMutable();
                        this.function_.addAll(classR.function_);
                    }
                }
                if (!classR.property_.isEmpty()) {
                    if (this.property_.isEmpty()) {
                        this.property_ = classR.property_;
                        this.bitField0_ &= -2049;
                    } else {
                        ensurePropertyIsMutable();
                        this.property_.addAll(classR.property_);
                    }
                }
                if (!classR.typeAlias_.isEmpty()) {
                    if (this.typeAlias_.isEmpty()) {
                        this.typeAlias_ = classR.typeAlias_;
                        this.bitField0_ &= -4097;
                    } else {
                        ensureTypeAliasIsMutable();
                        this.typeAlias_.addAll(classR.typeAlias_);
                    }
                }
                if (!classR.enumEntry_.isEmpty()) {
                    if (this.enumEntry_.isEmpty()) {
                        this.enumEntry_ = classR.enumEntry_;
                        this.bitField0_ &= -8193;
                    } else {
                        ensureEnumEntryIsMutable();
                        this.enumEntry_.addAll(classR.enumEntry_);
                    }
                }
                if (!classR.sealedSubclassFqName_.isEmpty()) {
                    if (this.sealedSubclassFqName_.isEmpty()) {
                        this.sealedSubclassFqName_ = classR.sealedSubclassFqName_;
                        this.bitField0_ &= -16385;
                    } else {
                        ensureSealedSubclassFqNameIsMutable();
                        this.sealedSubclassFqName_.addAll(classR.sealedSubclassFqName_);
                    }
                }
                if (classR.hasInlineClassUnderlyingPropertyName()) {
                    setInlineClassUnderlyingPropertyName(classR.getInlineClassUnderlyingPropertyName());
                }
                if (classR.hasInlineClassUnderlyingType()) {
                    mergeInlineClassUnderlyingType(classR.getInlineClassUnderlyingType());
                }
                if (classR.hasInlineClassUnderlyingTypeId()) {
                    setInlineClassUnderlyingTypeId(classR.getInlineClassUnderlyingTypeId());
                }
                if (!classR.multiFieldValueClassUnderlyingName_.isEmpty()) {
                    if (this.multiFieldValueClassUnderlyingName_.isEmpty()) {
                        this.multiFieldValueClassUnderlyingName_ = classR.multiFieldValueClassUnderlyingName_;
                        this.bitField0_ &= -262145;
                    } else {
                        ensureMultiFieldValueClassUnderlyingNameIsMutable();
                        this.multiFieldValueClassUnderlyingName_.addAll(classR.multiFieldValueClassUnderlyingName_);
                    }
                }
                if (!classR.multiFieldValueClassUnderlyingType_.isEmpty()) {
                    if (this.multiFieldValueClassUnderlyingType_.isEmpty()) {
                        this.multiFieldValueClassUnderlyingType_ = classR.multiFieldValueClassUnderlyingType_;
                        this.bitField0_ &= -524289;
                    } else {
                        ensureMultiFieldValueClassUnderlyingTypeIsMutable();
                        this.multiFieldValueClassUnderlyingType_.addAll(classR.multiFieldValueClassUnderlyingType_);
                    }
                }
                if (!classR.multiFieldValueClassUnderlyingTypeId_.isEmpty()) {
                    if (this.multiFieldValueClassUnderlyingTypeId_.isEmpty()) {
                        this.multiFieldValueClassUnderlyingTypeId_ = classR.multiFieldValueClassUnderlyingTypeId_;
                        this.bitField0_ &= -1048577;
                    } else {
                        ensureMultiFieldValueClassUnderlyingTypeIdIsMutable();
                        this.multiFieldValueClassUnderlyingTypeId_.addAll(classR.multiFieldValueClassUnderlyingTypeId_);
                    }
                }
                if (classR.hasTypeTable()) {
                    mergeTypeTable(classR.getTypeTable());
                }
                if (!classR.versionRequirement_.isEmpty()) {
                    if (this.versionRequirement_.isEmpty()) {
                        this.versionRequirement_ = classR.versionRequirement_;
                        this.bitField0_ &= -4194305;
                    } else {
                        ensureVersionRequirementIsMutable();
                        this.versionRequirement_.addAll(classR.versionRequirement_);
                    }
                }
                if (classR.hasVersionRequirementTable()) {
                    mergeVersionRequirementTable(classR.getVersionRequirementTable());
                }
                d(classR);
                setUnknownFields(getUnknownFields().concat(classR.unknownFields));
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                Class classR;
                Class classR2 = null;
                try {
                    Class parsePartialFrom = Class.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e11) {
                    classR = (Class) e11.getUnfinishedMessage();
                    throw e11;
                } catch (Throwable th2) {
                    th = th2;
                    classR2 = classR;
                }
                if (classR2 != null) {
                    mergeFrom(classR2);
                }
                throw th;
            }
        }

        public enum Kind implements Internal.EnumLite {
            CLASS(0, 0),
            INTERFACE(1, 1),
            ENUM_CLASS(2, 2),
            ENUM_ENTRY(3, 3),
            ANNOTATION_CLASS(4, 4),
            OBJECT(5, 5),
            COMPANION_OBJECT(6, 6);
            
            private static Internal.EnumLiteMap<Kind> internalValueMap;
            private final int value;

            /* access modifiers changed from: public */
            static {
                internalValueMap = new Internal.EnumLiteMap<Kind>() {
                    public Kind findValueByNumber(int i11) {
                        return Kind.valueOf(i11);
                    }
                };
            }

            private Kind(int i11, int i12) {
                this.value = i12;
            }

            public final int getNumber() {
                return this.value;
            }

            public static Kind valueOf(int i11) {
                switch (i11) {
                    case 0:
                        return CLASS;
                    case 1:
                        return INTERFACE;
                    case 2:
                        return ENUM_CLASS;
                    case 3:
                        return ENUM_ENTRY;
                    case 4:
                        return ANNOTATION_CLASS;
                    case 5:
                        return OBJECT;
                    case 6:
                        return COMPANION_OBJECT;
                    default:
                        return null;
                }
            }
        }

        static {
            Class classR = new Class(true);
            defaultInstance = classR;
            classR.initFields();
        }

        public static Class getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.flags_ = 6;
            this.fqName_ = 0;
            this.companionObjectName_ = 0;
            this.typeParameter_ = Collections.emptyList();
            this.supertype_ = Collections.emptyList();
            this.supertypeId_ = Collections.emptyList();
            this.nestedClassName_ = Collections.emptyList();
            this.contextReceiverType_ = Collections.emptyList();
            this.contextReceiverTypeId_ = Collections.emptyList();
            this.constructor_ = Collections.emptyList();
            this.function_ = Collections.emptyList();
            this.property_ = Collections.emptyList();
            this.typeAlias_ = Collections.emptyList();
            this.enumEntry_ = Collections.emptyList();
            this.sealedSubclassFqName_ = Collections.emptyList();
            this.inlineClassUnderlyingPropertyName_ = 0;
            this.inlineClassUnderlyingType_ = Type.getDefaultInstance();
            this.inlineClassUnderlyingTypeId_ = 0;
            this.multiFieldValueClassUnderlyingName_ = Collections.emptyList();
            this.multiFieldValueClassUnderlyingType_ = Collections.emptyList();
            this.multiFieldValueClassUnderlyingTypeId_ = Collections.emptyList();
            this.typeTable_ = TypeTable.getDefaultInstance();
            this.versionRequirement_ = Collections.emptyList();
            this.versionRequirementTable_ = VersionRequirementTable.getDefaultInstance();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public static Class parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public int getCompanionObjectName() {
            return this.companionObjectName_;
        }

        public Constructor getConstructor(int i11) {
            return this.constructor_.get(i11);
        }

        public int getConstructorCount() {
            return this.constructor_.size();
        }

        public List<Constructor> getConstructorList() {
            return this.constructor_;
        }

        public Type getContextReceiverType(int i11) {
            return this.contextReceiverType_.get(i11);
        }

        public int getContextReceiverTypeCount() {
            return this.contextReceiverType_.size();
        }

        public List<Integer> getContextReceiverTypeIdList() {
            return this.contextReceiverTypeId_;
        }

        public List<Type> getContextReceiverTypeList() {
            return this.contextReceiverType_;
        }

        public EnumEntry getEnumEntry(int i11) {
            return this.enumEntry_.get(i11);
        }

        public int getEnumEntryCount() {
            return this.enumEntry_.size();
        }

        public List<EnumEntry> getEnumEntryList() {
            return this.enumEntry_;
        }

        public int getFlags() {
            return this.flags_;
        }

        public int getFqName() {
            return this.fqName_;
        }

        public Function getFunction(int i11) {
            return this.function_.get(i11);
        }

        public int getFunctionCount() {
            return this.function_.size();
        }

        public List<Function> getFunctionList() {
            return this.function_;
        }

        public int getInlineClassUnderlyingPropertyName() {
            return this.inlineClassUnderlyingPropertyName_;
        }

        public Type getInlineClassUnderlyingType() {
            return this.inlineClassUnderlyingType_;
        }

        public int getInlineClassUnderlyingTypeId() {
            return this.inlineClassUnderlyingTypeId_;
        }

        public int getMultiFieldValueClassUnderlyingNameCount() {
            return this.multiFieldValueClassUnderlyingName_.size();
        }

        public List<Integer> getMultiFieldValueClassUnderlyingNameList() {
            return this.multiFieldValueClassUnderlyingName_;
        }

        public Type getMultiFieldValueClassUnderlyingType(int i11) {
            return this.multiFieldValueClassUnderlyingType_.get(i11);
        }

        public int getMultiFieldValueClassUnderlyingTypeCount() {
            return this.multiFieldValueClassUnderlyingType_.size();
        }

        public int getMultiFieldValueClassUnderlyingTypeIdCount() {
            return this.multiFieldValueClassUnderlyingTypeId_.size();
        }

        public List<Integer> getMultiFieldValueClassUnderlyingTypeIdList() {
            return this.multiFieldValueClassUnderlyingTypeId_;
        }

        public List<Type> getMultiFieldValueClassUnderlyingTypeList() {
            return this.multiFieldValueClassUnderlyingType_;
        }

        public List<Integer> getNestedClassNameList() {
            return this.nestedClassName_;
        }

        public Parser<Class> getParserForType() {
            return PARSER;
        }

        public Property getProperty(int i11) {
            return this.property_.get(i11);
        }

        public int getPropertyCount() {
            return this.property_.size();
        }

        public List<Property> getPropertyList() {
            return this.property_;
        }

        public List<Integer> getSealedSubclassFqNameList() {
            return this.sealedSubclassFqName_;
        }

        public int getSerializedSize() {
            int i11;
            int i12 = this.memoizedSerializedSize;
            if (i12 != -1) {
                return i12;
            }
            if ((this.bitField0_ & 1) == 1) {
                i11 = CodedOutputStream.computeInt32Size(1, this.flags_) + 0;
            } else {
                i11 = 0;
            }
            int i13 = 0;
            for (int i14 = 0; i14 < this.supertypeId_.size(); i14++) {
                i13 += CodedOutputStream.computeInt32SizeNoTag(this.supertypeId_.get(i14).intValue());
            }
            int i15 = i11 + i13;
            if (!getSupertypeIdList().isEmpty()) {
                i15 = i15 + 1 + CodedOutputStream.computeInt32SizeNoTag(i13);
            }
            this.supertypeIdMemoizedSerializedSize = i13;
            if ((this.bitField0_ & 2) == 2) {
                i15 += CodedOutputStream.computeInt32Size(3, this.fqName_);
            }
            if ((this.bitField0_ & 4) == 4) {
                i15 += CodedOutputStream.computeInt32Size(4, this.companionObjectName_);
            }
            for (int i16 = 0; i16 < this.typeParameter_.size(); i16++) {
                i15 += CodedOutputStream.computeMessageSize(5, this.typeParameter_.get(i16));
            }
            for (int i17 = 0; i17 < this.supertype_.size(); i17++) {
                i15 += CodedOutputStream.computeMessageSize(6, this.supertype_.get(i17));
            }
            int i18 = 0;
            for (int i19 = 0; i19 < this.nestedClassName_.size(); i19++) {
                i18 += CodedOutputStream.computeInt32SizeNoTag(this.nestedClassName_.get(i19).intValue());
            }
            int i21 = i15 + i18;
            if (!getNestedClassNameList().isEmpty()) {
                i21 = i21 + 1 + CodedOutputStream.computeInt32SizeNoTag(i18);
            }
            this.nestedClassNameMemoizedSerializedSize = i18;
            for (int i22 = 0; i22 < this.constructor_.size(); i22++) {
                i21 += CodedOutputStream.computeMessageSize(8, this.constructor_.get(i22));
            }
            for (int i23 = 0; i23 < this.function_.size(); i23++) {
                i21 += CodedOutputStream.computeMessageSize(9, this.function_.get(i23));
            }
            for (int i24 = 0; i24 < this.property_.size(); i24++) {
                i21 += CodedOutputStream.computeMessageSize(10, this.property_.get(i24));
            }
            for (int i25 = 0; i25 < this.typeAlias_.size(); i25++) {
                i21 += CodedOutputStream.computeMessageSize(11, this.typeAlias_.get(i25));
            }
            for (int i26 = 0; i26 < this.enumEntry_.size(); i26++) {
                i21 += CodedOutputStream.computeMessageSize(13, this.enumEntry_.get(i26));
            }
            int i27 = 0;
            for (int i28 = 0; i28 < this.sealedSubclassFqName_.size(); i28++) {
                i27 += CodedOutputStream.computeInt32SizeNoTag(this.sealedSubclassFqName_.get(i28).intValue());
            }
            int i29 = i21 + i27;
            if (!getSealedSubclassFqNameList().isEmpty()) {
                i29 = i29 + 2 + CodedOutputStream.computeInt32SizeNoTag(i27);
            }
            this.sealedSubclassFqNameMemoizedSerializedSize = i27;
            if ((this.bitField0_ & 8) == 8) {
                i29 += CodedOutputStream.computeInt32Size(17, this.inlineClassUnderlyingPropertyName_);
            }
            if ((this.bitField0_ & 16) == 16) {
                i29 += CodedOutputStream.computeMessageSize(18, this.inlineClassUnderlyingType_);
            }
            if ((this.bitField0_ & 32) == 32) {
                i29 += CodedOutputStream.computeInt32Size(19, this.inlineClassUnderlyingTypeId_);
            }
            for (int i31 = 0; i31 < this.contextReceiverType_.size(); i31++) {
                i29 += CodedOutputStream.computeMessageSize(20, this.contextReceiverType_.get(i31));
            }
            int i32 = 0;
            for (int i33 = 0; i33 < this.contextReceiverTypeId_.size(); i33++) {
                i32 += CodedOutputStream.computeInt32SizeNoTag(this.contextReceiverTypeId_.get(i33).intValue());
            }
            int i34 = i29 + i32;
            if (!getContextReceiverTypeIdList().isEmpty()) {
                i34 = i34 + 2 + CodedOutputStream.computeInt32SizeNoTag(i32);
            }
            this.contextReceiverTypeIdMemoizedSerializedSize = i32;
            int i35 = 0;
            for (int i36 = 0; i36 < this.multiFieldValueClassUnderlyingName_.size(); i36++) {
                i35 += CodedOutputStream.computeInt32SizeNoTag(this.multiFieldValueClassUnderlyingName_.get(i36).intValue());
            }
            int i37 = i34 + i35;
            if (!getMultiFieldValueClassUnderlyingNameList().isEmpty()) {
                i37 = i37 + 2 + CodedOutputStream.computeInt32SizeNoTag(i35);
            }
            this.multiFieldValueClassUnderlyingNameMemoizedSerializedSize = i35;
            for (int i38 = 0; i38 < this.multiFieldValueClassUnderlyingType_.size(); i38++) {
                i37 += CodedOutputStream.computeMessageSize(23, this.multiFieldValueClassUnderlyingType_.get(i38));
            }
            int i39 = 0;
            for (int i41 = 0; i41 < this.multiFieldValueClassUnderlyingTypeId_.size(); i41++) {
                i39 += CodedOutputStream.computeInt32SizeNoTag(this.multiFieldValueClassUnderlyingTypeId_.get(i41).intValue());
            }
            int i42 = i37 + i39;
            if (!getMultiFieldValueClassUnderlyingTypeIdList().isEmpty()) {
                i42 = i42 + 2 + CodedOutputStream.computeInt32SizeNoTag(i39);
            }
            this.multiFieldValueClassUnderlyingTypeIdMemoizedSerializedSize = i39;
            if ((this.bitField0_ & 64) == 64) {
                i42 += CodedOutputStream.computeMessageSize(30, this.typeTable_);
            }
            int i43 = 0;
            for (int i44 = 0; i44 < this.versionRequirement_.size(); i44++) {
                i43 += CodedOutputStream.computeInt32SizeNoTag(this.versionRequirement_.get(i44).intValue());
            }
            int size = i42 + i43 + (getVersionRequirementList().size() * 2);
            if ((this.bitField0_ & 128) == 128) {
                size += CodedOutputStream.computeMessageSize(32, this.versionRequirementTable_);
            }
            int i45 = size + i() + this.unknownFields.size();
            this.memoizedSerializedSize = i45;
            return i45;
        }

        public Type getSupertype(int i11) {
            return this.supertype_.get(i11);
        }

        public int getSupertypeCount() {
            return this.supertype_.size();
        }

        public List<Integer> getSupertypeIdList() {
            return this.supertypeId_;
        }

        public List<Type> getSupertypeList() {
            return this.supertype_;
        }

        public TypeAlias getTypeAlias(int i11) {
            return this.typeAlias_.get(i11);
        }

        public int getTypeAliasCount() {
            return this.typeAlias_.size();
        }

        public List<TypeAlias> getTypeAliasList() {
            return this.typeAlias_;
        }

        public TypeParameter getTypeParameter(int i11) {
            return this.typeParameter_.get(i11);
        }

        public int getTypeParameterCount() {
            return this.typeParameter_.size();
        }

        public List<TypeParameter> getTypeParameterList() {
            return this.typeParameter_;
        }

        public TypeTable getTypeTable() {
            return this.typeTable_;
        }

        public List<Integer> getVersionRequirementList() {
            return this.versionRequirement_;
        }

        public VersionRequirementTable getVersionRequirementTable() {
            return this.versionRequirementTable_;
        }

        public boolean hasCompanionObjectName() {
            return (this.bitField0_ & 4) == 4;
        }

        public boolean hasFlags() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean hasFqName() {
            return (this.bitField0_ & 2) == 2;
        }

        public boolean hasInlineClassUnderlyingPropertyName() {
            return (this.bitField0_ & 8) == 8;
        }

        public boolean hasInlineClassUnderlyingType() {
            return (this.bitField0_ & 16) == 16;
        }

        public boolean hasInlineClassUnderlyingTypeId() {
            return (this.bitField0_ & 32) == 32;
        }

        public boolean hasTypeTable() {
            return (this.bitField0_ & 64) == 64;
        }

        public boolean hasVersionRequirementTable() {
            return (this.bitField0_ & 128) == 128;
        }

        public final boolean isInitialized() {
            byte b11 = this.memoizedIsInitialized;
            if (b11 == 1) {
                return true;
            }
            if (b11 == 0) {
                return false;
            }
            if (!hasFqName()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            for (int i11 = 0; i11 < getTypeParameterCount(); i11++) {
                if (!getTypeParameter(i11).isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            for (int i12 = 0; i12 < getSupertypeCount(); i12++) {
                if (!getSupertype(i12).isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            for (int i13 = 0; i13 < getContextReceiverTypeCount(); i13++) {
                if (!getContextReceiverType(i13).isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            for (int i14 = 0; i14 < getConstructorCount(); i14++) {
                if (!getConstructor(i14).isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            for (int i15 = 0; i15 < getFunctionCount(); i15++) {
                if (!getFunction(i15).isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            for (int i16 = 0; i16 < getPropertyCount(); i16++) {
                if (!getProperty(i16).isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            for (int i17 = 0; i17 < getTypeAliasCount(); i17++) {
                if (!getTypeAlias(i17).isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            for (int i18 = 0; i18 < getEnumEntryCount(); i18++) {
                if (!getEnumEntry(i18).isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            if (!hasInlineClassUnderlyingType() || getInlineClassUnderlyingType().isInitialized()) {
                for (int i19 = 0; i19 < getMultiFieldValueClassUnderlyingTypeCount(); i19++) {
                    if (!getMultiFieldValueClassUnderlyingType(i19).isInitialized()) {
                        this.memoizedIsInitialized = 0;
                        return false;
                    }
                }
                if (hasTypeTable() && !getTypeTable().isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                } else if (!h()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                } else {
                    this.memoizedIsInitialized = 1;
                    return true;
                }
            } else {
                this.memoizedIsInitialized = 0;
                return false;
            }
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter j11 = j();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeInt32(1, this.flags_);
            }
            if (getSupertypeIdList().size() > 0) {
                codedOutputStream.writeRawVarint32(18);
                codedOutputStream.writeRawVarint32(this.supertypeIdMemoizedSerializedSize);
            }
            for (int i11 = 0; i11 < this.supertypeId_.size(); i11++) {
                codedOutputStream.writeInt32NoTag(this.supertypeId_.get(i11).intValue());
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeInt32(3, this.fqName_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeInt32(4, this.companionObjectName_);
            }
            for (int i12 = 0; i12 < this.typeParameter_.size(); i12++) {
                codedOutputStream.writeMessage(5, this.typeParameter_.get(i12));
            }
            for (int i13 = 0; i13 < this.supertype_.size(); i13++) {
                codedOutputStream.writeMessage(6, this.supertype_.get(i13));
            }
            if (getNestedClassNameList().size() > 0) {
                codedOutputStream.writeRawVarint32(58);
                codedOutputStream.writeRawVarint32(this.nestedClassNameMemoizedSerializedSize);
            }
            for (int i14 = 0; i14 < this.nestedClassName_.size(); i14++) {
                codedOutputStream.writeInt32NoTag(this.nestedClassName_.get(i14).intValue());
            }
            for (int i15 = 0; i15 < this.constructor_.size(); i15++) {
                codedOutputStream.writeMessage(8, this.constructor_.get(i15));
            }
            for (int i16 = 0; i16 < this.function_.size(); i16++) {
                codedOutputStream.writeMessage(9, this.function_.get(i16));
            }
            for (int i17 = 0; i17 < this.property_.size(); i17++) {
                codedOutputStream.writeMessage(10, this.property_.get(i17));
            }
            for (int i18 = 0; i18 < this.typeAlias_.size(); i18++) {
                codedOutputStream.writeMessage(11, this.typeAlias_.get(i18));
            }
            for (int i19 = 0; i19 < this.enumEntry_.size(); i19++) {
                codedOutputStream.writeMessage(13, this.enumEntry_.get(i19));
            }
            if (getSealedSubclassFqNameList().size() > 0) {
                codedOutputStream.writeRawVarint32(130);
                codedOutputStream.writeRawVarint32(this.sealedSubclassFqNameMemoizedSerializedSize);
            }
            for (int i21 = 0; i21 < this.sealedSubclassFqName_.size(); i21++) {
                codedOutputStream.writeInt32NoTag(this.sealedSubclassFqName_.get(i21).intValue());
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeInt32(17, this.inlineClassUnderlyingPropertyName_);
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.writeMessage(18, this.inlineClassUnderlyingType_);
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.writeInt32(19, this.inlineClassUnderlyingTypeId_);
            }
            for (int i22 = 0; i22 < this.contextReceiverType_.size(); i22++) {
                codedOutputStream.writeMessage(20, this.contextReceiverType_.get(i22));
            }
            if (getContextReceiverTypeIdList().size() > 0) {
                codedOutputStream.writeRawVarint32(Opcodes.TABLESWITCH);
                codedOutputStream.writeRawVarint32(this.contextReceiverTypeIdMemoizedSerializedSize);
            }
            for (int i23 = 0; i23 < this.contextReceiverTypeId_.size(); i23++) {
                codedOutputStream.writeInt32NoTag(this.contextReceiverTypeId_.get(i23).intValue());
            }
            if (getMultiFieldValueClassUnderlyingNameList().size() > 0) {
                codedOutputStream.writeRawVarint32(Opcodes.GETSTATIC);
                codedOutputStream.writeRawVarint32(this.multiFieldValueClassUnderlyingNameMemoizedSerializedSize);
            }
            for (int i24 = 0; i24 < this.multiFieldValueClassUnderlyingName_.size(); i24++) {
                codedOutputStream.writeInt32NoTag(this.multiFieldValueClassUnderlyingName_.get(i24).intValue());
            }
            for (int i25 = 0; i25 < this.multiFieldValueClassUnderlyingType_.size(); i25++) {
                codedOutputStream.writeMessage(23, this.multiFieldValueClassUnderlyingType_.get(i25));
            }
            if (getMultiFieldValueClassUnderlyingTypeIdList().size() > 0) {
                codedOutputStream.writeRawVarint32(Opcodes.MONITORENTER);
                codedOutputStream.writeRawVarint32(this.multiFieldValueClassUnderlyingTypeIdMemoizedSerializedSize);
            }
            for (int i26 = 0; i26 < this.multiFieldValueClassUnderlyingTypeId_.size(); i26++) {
                codedOutputStream.writeInt32NoTag(this.multiFieldValueClassUnderlyingTypeId_.get(i26).intValue());
            }
            if ((this.bitField0_ & 64) == 64) {
                codedOutputStream.writeMessage(30, this.typeTable_);
            }
            for (int i27 = 0; i27 < this.versionRequirement_.size(); i27++) {
                codedOutputStream.writeInt32(31, this.versionRequirement_.get(i27).intValue());
            }
            if ((this.bitField0_ & 128) == 128) {
                codedOutputStream.writeMessage(32, this.versionRequirementTable_);
            }
            j11.writeUntil(19000, codedOutputStream);
            codedOutputStream.writeRawBytes(this.unknownFields);
        }

        public static Builder newBuilder(Class classR) {
            return newBuilder().mergeFrom(classR);
        }

        public Class getDefaultInstanceForType() {
            return defaultInstance;
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        private Class(GeneratedMessageLite.ExtendableBuilder<Class, ?> extendableBuilder) {
            super(extendableBuilder);
            this.supertypeIdMemoizedSerializedSize = -1;
            this.nestedClassNameMemoizedSerializedSize = -1;
            this.contextReceiverTypeIdMemoizedSerializedSize = -1;
            this.sealedSubclassFqNameMemoizedSerializedSize = -1;
            this.multiFieldValueClassUnderlyingNameMemoizedSerializedSize = -1;
            this.multiFieldValueClassUnderlyingTypeIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = extendableBuilder.getUnknownFields();
        }

        private Class(boolean z11) {
            this.supertypeIdMemoizedSerializedSize = -1;
            this.nestedClassNameMemoizedSerializedSize = -1;
            this.contextReceiverTypeIdMemoizedSerializedSize = -1;
            this.sealedSubclassFqNameMemoizedSerializedSize = -1;
            this.multiFieldValueClassUnderlyingNameMemoizedSerializedSize = -1;
            this.multiFieldValueClassUnderlyingTypeIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v0, resolved type: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type$Builder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v1, resolved type: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type$Builder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v3, resolved type: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type$Builder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v82, resolved type: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable$Builder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v6, resolved type: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type$Builder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v23, resolved type: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable$Builder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v8, resolved type: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type$Builder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v9, resolved type: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type$Builder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v10, resolved type: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type$Builder} */
        /* JADX WARNING: type inference failed for: r16v4, types: [kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable$Builder] */
        /* JADX WARNING: type inference failed for: r16v7, types: [kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable$Builder] */
        /* JADX WARNING: Code restructure failed: missing block: B:159:0x042a, code lost:
            r12 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:162:0x043a, code lost:
            r7 = r12;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:164:0x043f, code lost:
            r5 = r12;
         */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private Class(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream r18, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite r19) throws kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException {
            /*
                r17 = this;
                r1 = r17
                r2 = r18
                r3 = r19
                r17.<init>()
                r4 = -1
                r1.supertypeIdMemoizedSerializedSize = r4
                r1.nestedClassNameMemoizedSerializedSize = r4
                r1.contextReceiverTypeIdMemoizedSerializedSize = r4
                r1.sealedSubclassFqNameMemoizedSerializedSize = r4
                r1.multiFieldValueClassUnderlyingNameMemoizedSerializedSize = r4
                r1.multiFieldValueClassUnderlyingTypeIdMemoizedSerializedSize = r4
                r1.memoizedIsInitialized = r4
                r1.memoizedSerializedSize = r4
                r17.initFields()
                kotlin.reflect.jvm.internal.impl.protobuf.ByteString$Output r4 = kotlin.reflect.jvm.internal.impl.protobuf.ByteString.newOutput()
                r5 = 1
                kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream r6 = kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream.newInstance(r4, r5)
                r7 = 0
                r8 = r7
            L_0x0028:
                r9 = 524288(0x80000, float:7.34684E-40)
                r5 = 4194304(0x400000, float:5.877472E-39)
                r14 = 1048576(0x100000, float:1.469368E-39)
                r13 = 262144(0x40000, float:3.67342E-40)
                r11 = 128(0x80, float:1.794E-43)
                r10 = 64
                if (r7 != 0) goto L_0x0549
                int r15 = r18.readTag()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r16 = 0
                switch(r15) {
                    case 0: goto L_0x0439;
                    case 8: goto L_0x042c;
                    case 16: goto L_0x040e;
                    case 18: goto L_0x03d9;
                    case 24: goto L_0x03cc;
                    case 32: goto L_0x03bf;
                    case 42: goto L_0x03a4;
                    case 50: goto L_0x0388;
                    case 56: goto L_0x036c;
                    case 58: goto L_0x0338;
                    case 66: goto L_0x031c;
                    case 74: goto L_0x0300;
                    case 82: goto L_0x02e4;
                    case 90: goto L_0x02c8;
                    case 106: goto L_0x02ac;
                    case 128: goto L_0x028e;
                    case 130: goto L_0x0258;
                    case 136: goto L_0x0249;
                    case 146: goto L_0x021c;
                    case 152: goto L_0x020d;
                    case 162: goto L_0x01f1;
                    case 168: goto L_0x01d3;
                    case 170: goto L_0x019d;
                    case 176: goto L_0x0182;
                    case 178: goto L_0x014f;
                    case 186: goto L_0x0136;
                    case 192: goto L_0x011b;
                    case 194: goto L_0x00e8;
                    case 242: goto L_0x00bf;
                    case 248: goto L_0x00a4;
                    case 250: goto L_0x006f;
                    case 258: goto L_0x0046;
                    default: goto L_0x003f;
                }     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
            L_0x003f:
                r12 = 1
                boolean r5 = r1.f(r2, r6, r3, r15)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                goto L_0x043c
            L_0x0046:
                int r15 = r1.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r15 = r15 & r11
                if (r15 != r11) goto L_0x0051
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable r15 = r1.versionRequirementTable_     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable$Builder r16 = r15.toBuilder()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
            L_0x0051:
                r15 = r16
                kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable> r12 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.VersionRequirementTable.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r12 = r2.readMessage(r12, (kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite) r3)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable r12 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.VersionRequirementTable) r12     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r1.versionRequirementTable_ = r12     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                if (r15 == 0) goto L_0x0068
                r15.mergeFrom((kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.VersionRequirementTable) r12)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable r12 = r15.buildPartial()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r1.versionRequirementTable_ = r12     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
            L_0x0068:
                int r12 = r1.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r12 = r12 | r11
                r1.bitField0_ = r12     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                goto L_0x042a
            L_0x006f:
                int r12 = r18.readRawVarint32()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                int r12 = r2.pushLimit(r12)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r15 = r8 & r5
                if (r15 == r5) goto L_0x0089
                int r15 = r18.getBytesUntilLimit()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                if (r15 <= 0) goto L_0x0089
                java.util.ArrayList r15 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r15.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r1.versionRequirement_ = r15     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r8 = r8 | r5
            L_0x0089:
                int r15 = r18.getBytesUntilLimit()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                if (r15 <= 0) goto L_0x009f
                java.util.List<java.lang.Integer> r15 = r1.versionRequirement_     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                int r16 = r18.readInt32()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                java.lang.Integer r11 = java.lang.Integer.valueOf(r16)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r15.add(r11)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r11 = 128(0x80, float:1.794E-43)
                goto L_0x0089
            L_0x009f:
                r2.popLimit(r12)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                goto L_0x042a
            L_0x00a4:
                r11 = r8 & r5
                if (r11 == r5) goto L_0x00b0
                java.util.ArrayList r11 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r11.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r1.versionRequirement_ = r11     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r8 = r8 | r5
            L_0x00b0:
                java.util.List<java.lang.Integer> r11 = r1.versionRequirement_     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                int r12 = r18.readInt32()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r11.add(r12)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                goto L_0x042a
            L_0x00bf:
                int r11 = r1.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r11 = r11 & r10
                if (r11 != r10) goto L_0x00ca
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable r11 = r1.typeTable_     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable$Builder r16 = r11.toBuilder()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
            L_0x00ca:
                r11 = r16
                kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable> r12 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeTable.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r12 = r2.readMessage(r12, (kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite) r3)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable r12 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeTable) r12     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r1.typeTable_ = r12     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                if (r11 == 0) goto L_0x00e1
                r11.mergeFrom((kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeTable) r12)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable r11 = r11.buildPartial()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r1.typeTable_ = r11     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
            L_0x00e1:
                int r11 = r1.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r11 = r11 | r10
                r1.bitField0_ = r11     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                goto L_0x042a
            L_0x00e8:
                int r11 = r18.readRawVarint32()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                int r11 = r2.pushLimit(r11)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r12 = r8 & r14
                if (r12 == r14) goto L_0x0102
                int r12 = r18.getBytesUntilLimit()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                if (r12 <= 0) goto L_0x0102
                java.util.ArrayList r12 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r12.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r1.multiFieldValueClassUnderlyingTypeId_ = r12     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r8 = r8 | r14
            L_0x0102:
                int r12 = r18.getBytesUntilLimit()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                if (r12 <= 0) goto L_0x0116
                java.util.List<java.lang.Integer> r12 = r1.multiFieldValueClassUnderlyingTypeId_     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                int r15 = r18.readInt32()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                java.lang.Integer r15 = java.lang.Integer.valueOf(r15)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r12.add(r15)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                goto L_0x0102
            L_0x0116:
                r2.popLimit(r11)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                goto L_0x042a
            L_0x011b:
                r11 = r8 & r14
                if (r11 == r14) goto L_0x0127
                java.util.ArrayList r11 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r11.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r1.multiFieldValueClassUnderlyingTypeId_ = r11     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r8 = r8 | r14
            L_0x0127:
                java.util.List<java.lang.Integer> r11 = r1.multiFieldValueClassUnderlyingTypeId_     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                int r12 = r18.readInt32()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r11.add(r12)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                goto L_0x042a
            L_0x0136:
                r11 = r8 & r9
                if (r11 == r9) goto L_0x0142
                java.util.ArrayList r11 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r11.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r1.multiFieldValueClassUnderlyingType_ = r11     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r8 = r8 | r9
            L_0x0142:
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type> r11 = r1.multiFieldValueClassUnderlyingType_     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type> r12 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r12 = r2.readMessage(r12, (kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite) r3)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r11.add(r12)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                goto L_0x042a
            L_0x014f:
                int r11 = r18.readRawVarint32()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                int r11 = r2.pushLimit(r11)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r12 = r8 & r13
                if (r12 == r13) goto L_0x0169
                int r12 = r18.getBytesUntilLimit()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                if (r12 <= 0) goto L_0x0169
                java.util.ArrayList r12 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r12.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r1.multiFieldValueClassUnderlyingName_ = r12     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r8 = r8 | r13
            L_0x0169:
                int r12 = r18.getBytesUntilLimit()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                if (r12 <= 0) goto L_0x017d
                java.util.List<java.lang.Integer> r12 = r1.multiFieldValueClassUnderlyingName_     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                int r15 = r18.readInt32()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                java.lang.Integer r15 = java.lang.Integer.valueOf(r15)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r12.add(r15)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                goto L_0x0169
            L_0x017d:
                r2.popLimit(r11)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                goto L_0x042a
            L_0x0182:
                r11 = r8 & r13
                if (r11 == r13) goto L_0x018e
                java.util.ArrayList r11 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r11.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r1.multiFieldValueClassUnderlyingName_ = r11     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r8 = r8 | r13
            L_0x018e:
                java.util.List<java.lang.Integer> r11 = r1.multiFieldValueClassUnderlyingName_     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                int r12 = r18.readInt32()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r11.add(r12)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                goto L_0x042a
            L_0x019d:
                int r11 = r18.readRawVarint32()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                int r11 = r2.pushLimit(r11)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r12 = r8 & 256(0x100, float:3.59E-43)
                r15 = 256(0x100, float:3.59E-43)
                if (r12 == r15) goto L_0x01ba
                int r12 = r18.getBytesUntilLimit()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                if (r12 <= 0) goto L_0x01ba
                java.util.ArrayList r12 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r12.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r1.contextReceiverTypeId_ = r12     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r8 = r8 | 256(0x100, float:3.59E-43)
            L_0x01ba:
                int r12 = r18.getBytesUntilLimit()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                if (r12 <= 0) goto L_0x01ce
                java.util.List<java.lang.Integer> r12 = r1.contextReceiverTypeId_     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                int r15 = r18.readInt32()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                java.lang.Integer r15 = java.lang.Integer.valueOf(r15)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r12.add(r15)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                goto L_0x01ba
            L_0x01ce:
                r2.popLimit(r11)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                goto L_0x042a
            L_0x01d3:
                r11 = r8 & 256(0x100, float:3.59E-43)
                r12 = 256(0x100, float:3.59E-43)
                if (r11 == r12) goto L_0x01e2
                java.util.ArrayList r11 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r11.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r1.contextReceiverTypeId_ = r11     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r8 = r8 | 256(0x100, float:3.59E-43)
            L_0x01e2:
                java.util.List<java.lang.Integer> r11 = r1.contextReceiverTypeId_     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                int r12 = r18.readInt32()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r11.add(r12)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                goto L_0x042a
            L_0x01f1:
                r11 = r8 & 128(0x80, float:1.794E-43)
                r12 = 128(0x80, float:1.794E-43)
                if (r11 == r12) goto L_0x0200
                java.util.ArrayList r11 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r11.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r1.contextReceiverType_ = r11     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r8 = r8 | 128(0x80, float:1.794E-43)
            L_0x0200:
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type> r11 = r1.contextReceiverType_     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type> r12 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r12 = r2.readMessage(r12, (kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite) r3)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r11.add(r12)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                goto L_0x042a
            L_0x020d:
                int r11 = r1.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r12 = 32
                r11 = r11 | r12
                r1.bitField0_ = r11     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                int r11 = r18.readInt32()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r1.inlineClassUnderlyingTypeId_ = r11     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                goto L_0x042a
            L_0x021c:
                int r11 = r1.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r12 = 16
                r11 = r11 & r12
                if (r11 != r12) goto L_0x0229
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type r11 = r1.inlineClassUnderlyingType_     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type$Builder r16 = r11.toBuilder()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
            L_0x0229:
                r11 = r16
                kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type> r12 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r12 = r2.readMessage(r12, (kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite) r3)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type r12 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type) r12     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r1.inlineClassUnderlyingType_ = r12     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                if (r11 == 0) goto L_0x0240
                r11.mergeFrom((kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type) r12)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type r11 = r11.buildPartial()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r1.inlineClassUnderlyingType_ = r11     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
            L_0x0240:
                int r11 = r1.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r12 = 16
                r11 = r11 | r12
                r1.bitField0_ = r11     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                goto L_0x042a
            L_0x0249:
                int r11 = r1.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r12 = 8
                r11 = r11 | r12
                r1.bitField0_ = r11     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                int r11 = r18.readInt32()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r1.inlineClassUnderlyingPropertyName_ = r11     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                goto L_0x042a
            L_0x0258:
                int r11 = r18.readRawVarint32()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                int r11 = r2.pushLimit(r11)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r12 = r8 & 16384(0x4000, float:2.2959E-41)
                r15 = 16384(0x4000, float:2.2959E-41)
                if (r12 == r15) goto L_0x0275
                int r12 = r18.getBytesUntilLimit()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                if (r12 <= 0) goto L_0x0275
                java.util.ArrayList r12 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r12.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r1.sealedSubclassFqName_ = r12     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r8 = r8 | 16384(0x4000, float:2.2959E-41)
            L_0x0275:
                int r12 = r18.getBytesUntilLimit()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                if (r12 <= 0) goto L_0x0289
                java.util.List<java.lang.Integer> r12 = r1.sealedSubclassFqName_     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                int r15 = r18.readInt32()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                java.lang.Integer r15 = java.lang.Integer.valueOf(r15)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r12.add(r15)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                goto L_0x0275
            L_0x0289:
                r2.popLimit(r11)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                goto L_0x042a
            L_0x028e:
                r11 = r8 & 16384(0x4000, float:2.2959E-41)
                r12 = 16384(0x4000, float:2.2959E-41)
                if (r11 == r12) goto L_0x029d
                java.util.ArrayList r11 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r11.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r1.sealedSubclassFqName_ = r11     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r8 = r8 | 16384(0x4000, float:2.2959E-41)
            L_0x029d:
                java.util.List<java.lang.Integer> r11 = r1.sealedSubclassFqName_     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                int r12 = r18.readInt32()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r11.add(r12)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                goto L_0x042a
            L_0x02ac:
                r11 = r8 & 8192(0x2000, float:1.14794E-41)
                r12 = 8192(0x2000, float:1.14794E-41)
                if (r11 == r12) goto L_0x02bb
                java.util.ArrayList r11 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r11.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r1.enumEntry_ = r11     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r8 = r8 | 8192(0x2000, float:1.14794E-41)
            L_0x02bb:
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$EnumEntry> r11 = r1.enumEntry_     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$EnumEntry> r12 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.EnumEntry.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r12 = r2.readMessage(r12, (kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite) r3)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r11.add(r12)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                goto L_0x042a
            L_0x02c8:
                r11 = r8 & 4096(0x1000, float:5.74E-42)
                r12 = 4096(0x1000, float:5.74E-42)
                if (r11 == r12) goto L_0x02d7
                java.util.ArrayList r11 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r11.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r1.typeAlias_ = r11     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r8 = r8 | 4096(0x1000, float:5.74E-42)
            L_0x02d7:
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias> r11 = r1.typeAlias_     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias> r12 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeAlias.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r12 = r2.readMessage(r12, (kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite) r3)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r11.add(r12)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                goto L_0x042a
            L_0x02e4:
                r11 = r8 & 2048(0x800, float:2.87E-42)
                r12 = 2048(0x800, float:2.87E-42)
                if (r11 == r12) goto L_0x02f3
                java.util.ArrayList r11 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r11.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r1.property_ = r11     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r8 = r8 | 2048(0x800, float:2.87E-42)
            L_0x02f3:
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property> r11 = r1.property_     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property> r12 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r12 = r2.readMessage(r12, (kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite) r3)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r11.add(r12)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                goto L_0x042a
            L_0x0300:
                r11 = r8 & 1024(0x400, float:1.435E-42)
                r12 = 1024(0x400, float:1.435E-42)
                if (r11 == r12) goto L_0x030f
                java.util.ArrayList r11 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r11.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r1.function_ = r11     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r8 = r8 | 1024(0x400, float:1.435E-42)
            L_0x030f:
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function> r11 = r1.function_     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function> r12 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r12 = r2.readMessage(r12, (kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite) r3)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r11.add(r12)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                goto L_0x042a
            L_0x031c:
                r11 = r8 & 512(0x200, float:7.175E-43)
                r12 = 512(0x200, float:7.175E-43)
                if (r11 == r12) goto L_0x032b
                java.util.ArrayList r11 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r11.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r1.constructor_ = r11     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r8 = r8 | 512(0x200, float:7.175E-43)
            L_0x032b:
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor> r11 = r1.constructor_     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor> r12 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Constructor.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r12 = r2.readMessage(r12, (kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite) r3)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r11.add(r12)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                goto L_0x042a
            L_0x0338:
                int r11 = r18.readRawVarint32()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                int r11 = r2.pushLimit(r11)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r12 = r8 & 64
                if (r12 == r10) goto L_0x0353
                int r12 = r18.getBytesUntilLimit()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                if (r12 <= 0) goto L_0x0353
                java.util.ArrayList r12 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r12.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r1.nestedClassName_ = r12     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r8 = r8 | 64
            L_0x0353:
                int r12 = r18.getBytesUntilLimit()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                if (r12 <= 0) goto L_0x0367
                java.util.List<java.lang.Integer> r12 = r1.nestedClassName_     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                int r15 = r18.readInt32()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                java.lang.Integer r15 = java.lang.Integer.valueOf(r15)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r12.add(r15)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                goto L_0x0353
            L_0x0367:
                r2.popLimit(r11)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                goto L_0x042a
            L_0x036c:
                r11 = r8 & 64
                if (r11 == r10) goto L_0x0379
                java.util.ArrayList r11 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r11.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r1.nestedClassName_ = r11     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r8 = r8 | 64
            L_0x0379:
                java.util.List<java.lang.Integer> r11 = r1.nestedClassName_     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                int r12 = r18.readInt32()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r11.add(r12)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                goto L_0x042a
            L_0x0388:
                r11 = r8 & 16
                r12 = 16
                if (r11 == r12) goto L_0x0397
                java.util.ArrayList r11 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r11.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r1.supertype_ = r11     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r8 = r8 | 16
            L_0x0397:
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type> r11 = r1.supertype_     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type> r12 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r12 = r2.readMessage(r12, (kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite) r3)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r11.add(r12)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                goto L_0x042a
            L_0x03a4:
                r11 = r8 & 8
                r12 = 8
                if (r11 == r12) goto L_0x03b3
                java.util.ArrayList r11 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r11.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r1.typeParameter_ = r11     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r8 = r8 | 8
            L_0x03b3:
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter> r11 = r1.typeParameter_     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter> r12 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeParameter.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r12 = r2.readMessage(r12, (kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite) r3)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r11.add(r12)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                goto L_0x042a
            L_0x03bf:
                int r11 = r1.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r11 = r11 | 4
                r1.bitField0_ = r11     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                int r11 = r18.readInt32()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r1.companionObjectName_ = r11     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                goto L_0x042a
            L_0x03cc:
                int r11 = r1.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r11 = r11 | 2
                r1.bitField0_ = r11     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                int r11 = r18.readInt32()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r1.fqName_ = r11     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                goto L_0x042a
            L_0x03d9:
                int r11 = r18.readRawVarint32()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                int r11 = r2.pushLimit(r11)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r12 = r8 & 32
                r15 = 32
                if (r12 == r15) goto L_0x03f6
                int r12 = r18.getBytesUntilLimit()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                if (r12 <= 0) goto L_0x03f6
                java.util.ArrayList r12 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r12.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r1.supertypeId_ = r12     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r8 = r8 | 32
            L_0x03f6:
                int r12 = r18.getBytesUntilLimit()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                if (r12 <= 0) goto L_0x040a
                java.util.List<java.lang.Integer> r12 = r1.supertypeId_     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                int r15 = r18.readInt32()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                java.lang.Integer r15 = java.lang.Integer.valueOf(r15)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r12.add(r15)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                goto L_0x03f6
            L_0x040a:
                r2.popLimit(r11)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                goto L_0x042a
            L_0x040e:
                r11 = r8 & 32
                r12 = 32
                if (r11 == r12) goto L_0x041d
                java.util.ArrayList r11 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r11.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r1.supertypeId_ = r11     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r8 = r8 | 32
            L_0x041d:
                java.util.List<java.lang.Integer> r11 = r1.supertypeId_     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                int r12 = r18.readInt32()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r11.add(r12)     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
            L_0x042a:
                r12 = 1
                goto L_0x043f
            L_0x042c:
                int r11 = r1.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r12 = 1
                r11 = r11 | r12
                r1.bitField0_ = r11     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                int r11 = r18.readInt32()     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                r1.flags_ = r11     // Catch:{ InvalidProtocolBufferException -> 0x0455, IOException -> 0x0445 }
                goto L_0x043f
            L_0x0439:
                r12 = 1
            L_0x043a:
                r7 = r12
                goto L_0x043f
            L_0x043c:
                if (r5 != 0) goto L_0x043f
                goto L_0x043a
            L_0x043f:
                r5 = r12
                goto L_0x0028
            L_0x0442:
                r0 = move-exception
                r2 = r0
                goto L_0x045c
            L_0x0445:
                r0 = move-exception
                r2 = r0
                kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException r3 = new kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException     // Catch:{ all -> 0x0442 }
                java.lang.String r2 = r2.getMessage()     // Catch:{ all -> 0x0442 }
                r3.<init>(r2)     // Catch:{ all -> 0x0442 }
                kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException r2 = r3.setUnfinishedMessage(r1)     // Catch:{ all -> 0x0442 }
                throw r2     // Catch:{ all -> 0x0442 }
            L_0x0455:
                r0 = move-exception
                r2 = r0
                kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException r2 = r2.setUnfinishedMessage(r1)     // Catch:{ all -> 0x0442 }
                throw r2     // Catch:{ all -> 0x0442 }
            L_0x045c:
                r3 = r8 & 32
                r7 = 32
                if (r3 != r7) goto L_0x046a
                java.util.List<java.lang.Integer> r3 = r1.supertypeId_
                java.util.List r3 = java.util.Collections.unmodifiableList(r3)
                r1.supertypeId_ = r3
            L_0x046a:
                r3 = r8 & 8
                r7 = 8
                if (r3 != r7) goto L_0x0478
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter> r3 = r1.typeParameter_
                java.util.List r3 = java.util.Collections.unmodifiableList(r3)
                r1.typeParameter_ = r3
            L_0x0478:
                r3 = r8 & 16
                r7 = 16
                if (r3 != r7) goto L_0x0486
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type> r3 = r1.supertype_
                java.util.List r3 = java.util.Collections.unmodifiableList(r3)
                r1.supertype_ = r3
            L_0x0486:
                r3 = r8 & 64
                if (r3 != r10) goto L_0x0492
                java.util.List<java.lang.Integer> r3 = r1.nestedClassName_
                java.util.List r3 = java.util.Collections.unmodifiableList(r3)
                r1.nestedClassName_ = r3
            L_0x0492:
                r3 = r8 & 512(0x200, float:7.175E-43)
                r7 = 512(0x200, float:7.175E-43)
                if (r3 != r7) goto L_0x04a0
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor> r3 = r1.constructor_
                java.util.List r3 = java.util.Collections.unmodifiableList(r3)
                r1.constructor_ = r3
            L_0x04a0:
                r3 = r8 & 1024(0x400, float:1.435E-42)
                r7 = 1024(0x400, float:1.435E-42)
                if (r3 != r7) goto L_0x04ae
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function> r3 = r1.function_
                java.util.List r3 = java.util.Collections.unmodifiableList(r3)
                r1.function_ = r3
            L_0x04ae:
                r3 = r8 & 2048(0x800, float:2.87E-42)
                r7 = 2048(0x800, float:2.87E-42)
                if (r3 != r7) goto L_0x04bc
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property> r3 = r1.property_
                java.util.List r3 = java.util.Collections.unmodifiableList(r3)
                r1.property_ = r3
            L_0x04bc:
                r3 = r8 & 4096(0x1000, float:5.74E-42)
                r7 = 4096(0x1000, float:5.74E-42)
                if (r3 != r7) goto L_0x04ca
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias> r3 = r1.typeAlias_
                java.util.List r3 = java.util.Collections.unmodifiableList(r3)
                r1.typeAlias_ = r3
            L_0x04ca:
                r3 = r8 & 8192(0x2000, float:1.14794E-41)
                r7 = 8192(0x2000, float:1.14794E-41)
                if (r3 != r7) goto L_0x04d8
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$EnumEntry> r3 = r1.enumEntry_
                java.util.List r3 = java.util.Collections.unmodifiableList(r3)
                r1.enumEntry_ = r3
            L_0x04d8:
                r3 = r8 & 16384(0x4000, float:2.2959E-41)
                r7 = 16384(0x4000, float:2.2959E-41)
                if (r3 != r7) goto L_0x04e6
                java.util.List<java.lang.Integer> r3 = r1.sealedSubclassFqName_
                java.util.List r3 = java.util.Collections.unmodifiableList(r3)
                r1.sealedSubclassFqName_ = r3
            L_0x04e6:
                r3 = r8 & 128(0x80, float:1.794E-43)
                r7 = 128(0x80, float:1.794E-43)
                if (r3 != r7) goto L_0x04f4
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type> r3 = r1.contextReceiverType_
                java.util.List r3 = java.util.Collections.unmodifiableList(r3)
                r1.contextReceiverType_ = r3
            L_0x04f4:
                r3 = r8 & 256(0x100, float:3.59E-43)
                r7 = 256(0x100, float:3.59E-43)
                if (r3 != r7) goto L_0x0502
                java.util.List<java.lang.Integer> r3 = r1.contextReceiverTypeId_
                java.util.List r3 = java.util.Collections.unmodifiableList(r3)
                r1.contextReceiverTypeId_ = r3
            L_0x0502:
                r3 = r8 & r13
                if (r3 != r13) goto L_0x050e
                java.util.List<java.lang.Integer> r3 = r1.multiFieldValueClassUnderlyingName_
                java.util.List r3 = java.util.Collections.unmodifiableList(r3)
                r1.multiFieldValueClassUnderlyingName_ = r3
            L_0x050e:
                r3 = r8 & r9
                if (r3 != r9) goto L_0x051a
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type> r3 = r1.multiFieldValueClassUnderlyingType_
                java.util.List r3 = java.util.Collections.unmodifiableList(r3)
                r1.multiFieldValueClassUnderlyingType_ = r3
            L_0x051a:
                r3 = r8 & r14
                if (r3 != r14) goto L_0x0526
                java.util.List<java.lang.Integer> r3 = r1.multiFieldValueClassUnderlyingTypeId_
                java.util.List r3 = java.util.Collections.unmodifiableList(r3)
                r1.multiFieldValueClassUnderlyingTypeId_ = r3
            L_0x0526:
                r3 = r8 & r5
                if (r3 != r5) goto L_0x0532
                java.util.List<java.lang.Integer> r3 = r1.versionRequirement_
                java.util.List r3 = java.util.Collections.unmodifiableList(r3)
                r1.versionRequirement_ = r3
            L_0x0532:
                r6.flush()     // Catch:{ IOException -> 0x0535, all -> 0x053c }
            L_0x0535:
                kotlin.reflect.jvm.internal.impl.protobuf.ByteString r3 = r4.toByteString()
                r1.unknownFields = r3
                goto L_0x0545
            L_0x053c:
                r0 = move-exception
                r2 = r0
                kotlin.reflect.jvm.internal.impl.protobuf.ByteString r3 = r4.toByteString()
                r1.unknownFields = r3
                throw r2
            L_0x0545:
                r17.e()
                throw r2
            L_0x0549:
                r2 = r8 & 32
                r3 = 32
                if (r2 != r3) goto L_0x0557
                java.util.List<java.lang.Integer> r2 = r1.supertypeId_
                java.util.List r2 = java.util.Collections.unmodifiableList(r2)
                r1.supertypeId_ = r2
            L_0x0557:
                r2 = r8 & 8
                r3 = 8
                if (r2 != r3) goto L_0x0565
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter> r2 = r1.typeParameter_
                java.util.List r2 = java.util.Collections.unmodifiableList(r2)
                r1.typeParameter_ = r2
            L_0x0565:
                r2 = r8 & 16
                r3 = 16
                if (r2 != r3) goto L_0x0573
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type> r2 = r1.supertype_
                java.util.List r2 = java.util.Collections.unmodifiableList(r2)
                r1.supertype_ = r2
            L_0x0573:
                r2 = r8 & 64
                if (r2 != r10) goto L_0x057f
                java.util.List<java.lang.Integer> r2 = r1.nestedClassName_
                java.util.List r2 = java.util.Collections.unmodifiableList(r2)
                r1.nestedClassName_ = r2
            L_0x057f:
                r2 = r8 & 512(0x200, float:7.175E-43)
                r3 = 512(0x200, float:7.175E-43)
                if (r2 != r3) goto L_0x058d
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor> r2 = r1.constructor_
                java.util.List r2 = java.util.Collections.unmodifiableList(r2)
                r1.constructor_ = r2
            L_0x058d:
                r2 = r8 & 1024(0x400, float:1.435E-42)
                r3 = 1024(0x400, float:1.435E-42)
                if (r2 != r3) goto L_0x059b
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function> r2 = r1.function_
                java.util.List r2 = java.util.Collections.unmodifiableList(r2)
                r1.function_ = r2
            L_0x059b:
                r2 = r8 & 2048(0x800, float:2.87E-42)
                r3 = 2048(0x800, float:2.87E-42)
                if (r2 != r3) goto L_0x05a9
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property> r2 = r1.property_
                java.util.List r2 = java.util.Collections.unmodifiableList(r2)
                r1.property_ = r2
            L_0x05a9:
                r2 = r8 & 4096(0x1000, float:5.74E-42)
                r3 = 4096(0x1000, float:5.74E-42)
                if (r2 != r3) goto L_0x05b7
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias> r2 = r1.typeAlias_
                java.util.List r2 = java.util.Collections.unmodifiableList(r2)
                r1.typeAlias_ = r2
            L_0x05b7:
                r2 = r8 & 8192(0x2000, float:1.14794E-41)
                r3 = 8192(0x2000, float:1.14794E-41)
                if (r2 != r3) goto L_0x05c5
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$EnumEntry> r2 = r1.enumEntry_
                java.util.List r2 = java.util.Collections.unmodifiableList(r2)
                r1.enumEntry_ = r2
            L_0x05c5:
                r2 = r8 & 16384(0x4000, float:2.2959E-41)
                r3 = 16384(0x4000, float:2.2959E-41)
                if (r2 != r3) goto L_0x05d3
                java.util.List<java.lang.Integer> r2 = r1.sealedSubclassFqName_
                java.util.List r2 = java.util.Collections.unmodifiableList(r2)
                r1.sealedSubclassFqName_ = r2
            L_0x05d3:
                r2 = r8 & 128(0x80, float:1.794E-43)
                r3 = 128(0x80, float:1.794E-43)
                if (r2 != r3) goto L_0x05e1
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type> r2 = r1.contextReceiverType_
                java.util.List r2 = java.util.Collections.unmodifiableList(r2)
                r1.contextReceiverType_ = r2
            L_0x05e1:
                r2 = r8 & 256(0x100, float:3.59E-43)
                r3 = 256(0x100, float:3.59E-43)
                if (r2 != r3) goto L_0x05ef
                java.util.List<java.lang.Integer> r2 = r1.contextReceiverTypeId_
                java.util.List r2 = java.util.Collections.unmodifiableList(r2)
                r1.contextReceiverTypeId_ = r2
            L_0x05ef:
                r2 = r8 & r13
                if (r2 != r13) goto L_0x05fb
                java.util.List<java.lang.Integer> r2 = r1.multiFieldValueClassUnderlyingName_
                java.util.List r2 = java.util.Collections.unmodifiableList(r2)
                r1.multiFieldValueClassUnderlyingName_ = r2
            L_0x05fb:
                r2 = r8 & r9
                if (r2 != r9) goto L_0x0607
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type> r2 = r1.multiFieldValueClassUnderlyingType_
                java.util.List r2 = java.util.Collections.unmodifiableList(r2)
                r1.multiFieldValueClassUnderlyingType_ = r2
            L_0x0607:
                r2 = r8 & r14
                if (r2 != r14) goto L_0x0613
                java.util.List<java.lang.Integer> r2 = r1.multiFieldValueClassUnderlyingTypeId_
                java.util.List r2 = java.util.Collections.unmodifiableList(r2)
                r1.multiFieldValueClassUnderlyingTypeId_ = r2
            L_0x0613:
                r2 = r8 & r5
                if (r2 != r5) goto L_0x061f
                java.util.List<java.lang.Integer> r2 = r1.versionRequirement_
                java.util.List r2 = java.util.Collections.unmodifiableList(r2)
                r1.versionRequirement_ = r2
            L_0x061f:
                r6.flush()     // Catch:{ IOException -> 0x0622, all -> 0x0629 }
            L_0x0622:
                kotlin.reflect.jvm.internal.impl.protobuf.ByteString r2 = r4.toByteString()
                r1.unknownFields = r2
                goto L_0x0632
            L_0x0629:
                r0 = move-exception
                r2 = r0
                kotlin.reflect.jvm.internal.impl.protobuf.ByteString r3 = r4.toByteString()
                r1.unknownFields = r3
                throw r2
            L_0x0632:
                r17.e()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Class.<init>(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite):void");
        }
    }

    public interface ClassOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder {
    }

    public static final class Constructor extends GeneratedMessageLite.ExtendableMessage<Constructor> implements ConstructorOrBuilder {
        public static Parser<Constructor> PARSER = new AbstractParser<Constructor>() {
            public Constructor parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Constructor(codedInputStream, extensionRegistryLite);
            }
        };
        private static final Constructor defaultInstance;
        /* access modifiers changed from: private */
        public int bitField0_;
        /* access modifiers changed from: private */
        public int flags_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        /* access modifiers changed from: private */
        public final ByteString unknownFields;
        /* access modifiers changed from: private */
        public List<ValueParameter> valueParameter_;
        /* access modifiers changed from: private */
        public List<Integer> versionRequirement_;

        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<Constructor, Builder> implements ConstructorOrBuilder {
            private int bitField0_;
            private int flags_ = 6;
            private List<ValueParameter> valueParameter_ = Collections.emptyList();
            private List<Integer> versionRequirement_ = Collections.emptyList();

            private Builder() {
                maybeForceBuilderInitialization();
            }

            /* access modifiers changed from: private */
            public static Builder create() {
                return new Builder();
            }

            private void ensureValueParameterIsMutable() {
                if ((this.bitField0_ & 2) != 2) {
                    this.valueParameter_ = new ArrayList(this.valueParameter_);
                    this.bitField0_ |= 2;
                }
            }

            private void ensureVersionRequirementIsMutable() {
                if ((this.bitField0_ & 4) != 4) {
                    this.versionRequirement_ = new ArrayList(this.versionRequirement_);
                    this.bitField0_ |= 4;
                }
            }

            private void maybeForceBuilderInitialization() {
            }

            public Constructor buildPartial() {
                Constructor constructor = new Constructor((GeneratedMessageLite.ExtendableBuilder) this);
                int i11 = 1;
                if ((this.bitField0_ & 1) != 1) {
                    i11 = 0;
                }
                int unused = constructor.flags_ = this.flags_;
                if ((this.bitField0_ & 2) == 2) {
                    this.valueParameter_ = Collections.unmodifiableList(this.valueParameter_);
                    this.bitField0_ &= -3;
                }
                List unused2 = constructor.valueParameter_ = this.valueParameter_;
                if ((this.bitField0_ & 4) == 4) {
                    this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
                    this.bitField0_ &= -5;
                }
                List unused3 = constructor.versionRequirement_ = this.versionRequirement_;
                int unused4 = constructor.bitField0_ = i11;
                return constructor;
            }

            public ValueParameter getValueParameter(int i11) {
                return this.valueParameter_.get(i11);
            }

            public int getValueParameterCount() {
                return this.valueParameter_.size();
            }

            public final boolean isInitialized() {
                for (int i11 = 0; i11 < getValueParameterCount(); i11++) {
                    if (!getValueParameter(i11).isInitialized()) {
                        return false;
                    }
                }
                if (!c()) {
                    return false;
                }
                return true;
            }

            public Builder setFlags(int i11) {
                this.bitField0_ |= 1;
                this.flags_ = i11;
                return this;
            }

            public Constructor build() {
                Constructor buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.a(buildPartial);
            }

            public Constructor getDefaultInstanceForType() {
                return Constructor.getDefaultInstance();
            }

            public Builder mergeFrom(Constructor constructor) {
                if (constructor == Constructor.getDefaultInstance()) {
                    return this;
                }
                if (constructor.hasFlags()) {
                    setFlags(constructor.getFlags());
                }
                if (!constructor.valueParameter_.isEmpty()) {
                    if (this.valueParameter_.isEmpty()) {
                        this.valueParameter_ = constructor.valueParameter_;
                        this.bitField0_ &= -3;
                    } else {
                        ensureValueParameterIsMutable();
                        this.valueParameter_.addAll(constructor.valueParameter_);
                    }
                }
                if (!constructor.versionRequirement_.isEmpty()) {
                    if (this.versionRequirement_.isEmpty()) {
                        this.versionRequirement_ = constructor.versionRequirement_;
                        this.bitField0_ &= -5;
                    } else {
                        ensureVersionRequirementIsMutable();
                        this.versionRequirement_.addAll(constructor.versionRequirement_);
                    }
                }
                d(constructor);
                setUnknownFields(getUnknownFields().concat(constructor.unknownFields));
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                Constructor constructor;
                Constructor constructor2 = null;
                try {
                    Constructor parsePartialFrom = Constructor.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e11) {
                    constructor = (Constructor) e11.getUnfinishedMessage();
                    throw e11;
                } catch (Throwable th2) {
                    th = th2;
                    constructor2 = constructor;
                }
                if (constructor2 != null) {
                    mergeFrom(constructor2);
                }
                throw th;
            }
        }

        static {
            Constructor constructor = new Constructor(true);
            defaultInstance = constructor;
            constructor.initFields();
        }

        public static Constructor getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.flags_ = 6;
            this.valueParameter_ = Collections.emptyList();
            this.versionRequirement_ = Collections.emptyList();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public int getFlags() {
            return this.flags_;
        }

        public Parser<Constructor> getParserForType() {
            return PARSER;
        }

        public int getSerializedSize() {
            int i11;
            int i12 = this.memoizedSerializedSize;
            if (i12 != -1) {
                return i12;
            }
            if ((this.bitField0_ & 1) == 1) {
                i11 = CodedOutputStream.computeInt32Size(1, this.flags_) + 0;
            } else {
                i11 = 0;
            }
            for (int i13 = 0; i13 < this.valueParameter_.size(); i13++) {
                i11 += CodedOutputStream.computeMessageSize(2, this.valueParameter_.get(i13));
            }
            int i14 = 0;
            for (int i15 = 0; i15 < this.versionRequirement_.size(); i15++) {
                i14 += CodedOutputStream.computeInt32SizeNoTag(this.versionRequirement_.get(i15).intValue());
            }
            int size = i11 + i14 + (getVersionRequirementList().size() * 2) + i() + this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        public ValueParameter getValueParameter(int i11) {
            return this.valueParameter_.get(i11);
        }

        public int getValueParameterCount() {
            return this.valueParameter_.size();
        }

        public List<ValueParameter> getValueParameterList() {
            return this.valueParameter_;
        }

        public List<Integer> getVersionRequirementList() {
            return this.versionRequirement_;
        }

        public boolean hasFlags() {
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
            for (int i11 = 0; i11 < getValueParameterCount(); i11++) {
                if (!getValueParameter(i11).isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            if (!h()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter j11 = j();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeInt32(1, this.flags_);
            }
            for (int i11 = 0; i11 < this.valueParameter_.size(); i11++) {
                codedOutputStream.writeMessage(2, this.valueParameter_.get(i11));
            }
            for (int i12 = 0; i12 < this.versionRequirement_.size(); i12++) {
                codedOutputStream.writeInt32(31, this.versionRequirement_.get(i12).intValue());
            }
            j11.writeUntil(19000, codedOutputStream);
            codedOutputStream.writeRawBytes(this.unknownFields);
        }

        public static Builder newBuilder(Constructor constructor) {
            return newBuilder().mergeFrom(constructor);
        }

        public Constructor getDefaultInstanceForType() {
            return defaultInstance;
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        private Constructor(GeneratedMessageLite.ExtendableBuilder<Constructor, ?> extendableBuilder) {
            super(extendableBuilder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = extendableBuilder.getUnknownFields();
        }

        private Constructor(boolean z11) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        private Constructor(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            this.flags_ = codedInputStream.readInt32();
                        } else if (readTag == 18) {
                            if (!(z12 & true)) {
                                this.valueParameter_ = new ArrayList();
                                z12 |= true;
                            }
                            this.valueParameter_.add(codedInputStream.readMessage(ValueParameter.PARSER, extensionRegistryLite));
                        } else if (readTag == 248) {
                            if (!(z12 & true)) {
                                this.versionRequirement_ = new ArrayList();
                                z12 |= true;
                            }
                            this.versionRequirement_.add(Integer.valueOf(codedInputStream.readInt32()));
                        } else if (readTag == 250) {
                            int pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                            if (!(z12 & true) && codedInputStream.getBytesUntilLimit() > 0) {
                                this.versionRequirement_ = new ArrayList();
                                z12 |= true;
                            }
                            while (codedInputStream.getBytesUntilLimit() > 0) {
                                this.versionRequirement_.add(Integer.valueOf(codedInputStream.readInt32()));
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
                    if (z12 & true) {
                        this.valueParameter_ = Collections.unmodifiableList(this.valueParameter_);
                    }
                    if (z12 & true) {
                        this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
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
                this.valueParameter_ = Collections.unmodifiableList(this.valueParameter_);
            }
            if (z12 & true) {
                this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
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

    public interface ConstructorOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder {
    }

    public static final class Contract extends GeneratedMessageLite implements ContractOrBuilder {
        public static Parser<Contract> PARSER = new AbstractParser<Contract>() {
            public Contract parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Contract(codedInputStream, extensionRegistryLite);
            }
        };
        private static final Contract defaultInstance;
        /* access modifiers changed from: private */
        public List<Effect> effect_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        /* access modifiers changed from: private */
        public final ByteString unknownFields;

        public static final class Builder extends GeneratedMessageLite.Builder<Contract, Builder> implements ContractOrBuilder {
            private int bitField0_;
            private List<Effect> effect_ = Collections.emptyList();

            private Builder() {
                maybeForceBuilderInitialization();
            }

            /* access modifiers changed from: private */
            public static Builder create() {
                return new Builder();
            }

            private void ensureEffectIsMutable() {
                if ((this.bitField0_ & 1) != 1) {
                    this.effect_ = new ArrayList(this.effect_);
                    this.bitField0_ |= 1;
                }
            }

            private void maybeForceBuilderInitialization() {
            }

            public Contract buildPartial() {
                Contract contract = new Contract((GeneratedMessageLite.Builder) this);
                if ((this.bitField0_ & 1) == 1) {
                    this.effect_ = Collections.unmodifiableList(this.effect_);
                    this.bitField0_ &= -2;
                }
                List unused = contract.effect_ = this.effect_;
                return contract;
            }

            public Effect getEffect(int i11) {
                return this.effect_.get(i11);
            }

            public int getEffectCount() {
                return this.effect_.size();
            }

            public final boolean isInitialized() {
                for (int i11 = 0; i11 < getEffectCount(); i11++) {
                    if (!getEffect(i11).isInitialized()) {
                        return false;
                    }
                }
                return true;
            }

            public Contract build() {
                Contract buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.a(buildPartial);
            }

            public Contract getDefaultInstanceForType() {
                return Contract.getDefaultInstance();
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Builder mergeFrom(Contract contract) {
                if (contract == Contract.getDefaultInstance()) {
                    return this;
                }
                if (!contract.effect_.isEmpty()) {
                    if (this.effect_.isEmpty()) {
                        this.effect_ = contract.effect_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureEffectIsMutable();
                        this.effect_.addAll(contract.effect_);
                    }
                }
                setUnknownFields(getUnknownFields().concat(contract.unknownFields));
                return this;
            }

            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                Contract contract;
                Contract contract2 = null;
                try {
                    Contract parsePartialFrom = Contract.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e11) {
                    contract = (Contract) e11.getUnfinishedMessage();
                    throw e11;
                } catch (Throwable th2) {
                    th = th2;
                    contract2 = contract;
                }
                if (contract2 != null) {
                    mergeFrom(contract2);
                }
                throw th;
            }
        }

        static {
            Contract contract = new Contract(true);
            defaultInstance = contract;
            contract.initFields();
        }

        public static Contract getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.effect_ = Collections.emptyList();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Effect getEffect(int i11) {
            return this.effect_.get(i11);
        }

        public int getEffectCount() {
            return this.effect_.size();
        }

        public Parser<Contract> getParserForType() {
            return PARSER;
        }

        public int getSerializedSize() {
            int i11 = this.memoizedSerializedSize;
            if (i11 != -1) {
                return i11;
            }
            int i12 = 0;
            for (int i13 = 0; i13 < this.effect_.size(); i13++) {
                i12 += CodedOutputStream.computeMessageSize(1, this.effect_.get(i13));
            }
            int size = i12 + this.unknownFields.size();
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
            for (int i11 = 0; i11 < getEffectCount(); i11++) {
                if (!getEffect(i11).isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            for (int i11 = 0; i11 < this.effect_.size(); i11++) {
                codedOutputStream.writeMessage(1, this.effect_.get(i11));
            }
            codedOutputStream.writeRawBytes(this.unknownFields);
        }

        public static Builder newBuilder(Contract contract) {
            return newBuilder().mergeFrom(contract);
        }

        public Contract getDefaultInstanceForType() {
            return defaultInstance;
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        private Contract(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private Contract(boolean z11) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        private Contract(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                this.effect_ = new ArrayList();
                                z12 |= true;
                            }
                            this.effect_.add(codedInputStream.readMessage(Effect.PARSER, extensionRegistryLite));
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
                        this.effect_ = Collections.unmodifiableList(this.effect_);
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
                this.effect_ = Collections.unmodifiableList(this.effect_);
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

    public interface ContractOrBuilder extends MessageLiteOrBuilder {
    }

    public static final class Effect extends GeneratedMessageLite implements EffectOrBuilder {
        public static Parser<Effect> PARSER = new AbstractParser<Effect>() {
            public Effect parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Effect(codedInputStream, extensionRegistryLite);
            }
        };
        private static final Effect defaultInstance;
        /* access modifiers changed from: private */
        public int bitField0_;
        /* access modifiers changed from: private */
        public Expression conclusionOfConditionalEffect_;
        /* access modifiers changed from: private */
        public List<Expression> effectConstructorArgument_;
        /* access modifiers changed from: private */
        public EffectType effectType_;
        /* access modifiers changed from: private */
        public InvocationKind kind_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        /* access modifiers changed from: private */
        public final ByteString unknownFields;

        public static final class Builder extends GeneratedMessageLite.Builder<Effect, Builder> implements EffectOrBuilder {
            private int bitField0_;
            private Expression conclusionOfConditionalEffect_ = Expression.getDefaultInstance();
            private List<Expression> effectConstructorArgument_ = Collections.emptyList();
            private EffectType effectType_ = EffectType.RETURNS_CONSTANT;
            private InvocationKind kind_ = InvocationKind.AT_MOST_ONCE;

            private Builder() {
                maybeForceBuilderInitialization();
            }

            /* access modifiers changed from: private */
            public static Builder create() {
                return new Builder();
            }

            private void ensureEffectConstructorArgumentIsMutable() {
                if ((this.bitField0_ & 2) != 2) {
                    this.effectConstructorArgument_ = new ArrayList(this.effectConstructorArgument_);
                    this.bitField0_ |= 2;
                }
            }

            private void maybeForceBuilderInitialization() {
            }

            public Effect buildPartial() {
                Effect effect = new Effect((GeneratedMessageLite.Builder) this);
                int i11 = this.bitField0_;
                int i12 = 1;
                if ((i11 & 1) != 1) {
                    i12 = 0;
                }
                EffectType unused = effect.effectType_ = this.effectType_;
                if ((this.bitField0_ & 2) == 2) {
                    this.effectConstructorArgument_ = Collections.unmodifiableList(this.effectConstructorArgument_);
                    this.bitField0_ &= -3;
                }
                List unused2 = effect.effectConstructorArgument_ = this.effectConstructorArgument_;
                if ((i11 & 4) == 4) {
                    i12 |= 2;
                }
                Expression unused3 = effect.conclusionOfConditionalEffect_ = this.conclusionOfConditionalEffect_;
                if ((i11 & 8) == 8) {
                    i12 |= 4;
                }
                InvocationKind unused4 = effect.kind_ = this.kind_;
                int unused5 = effect.bitField0_ = i12;
                return effect;
            }

            public Expression getConclusionOfConditionalEffect() {
                return this.conclusionOfConditionalEffect_;
            }

            public Expression getEffectConstructorArgument(int i11) {
                return this.effectConstructorArgument_.get(i11);
            }

            public int getEffectConstructorArgumentCount() {
                return this.effectConstructorArgument_.size();
            }

            public boolean hasConclusionOfConditionalEffect() {
                return (this.bitField0_ & 4) == 4;
            }

            public final boolean isInitialized() {
                for (int i11 = 0; i11 < getEffectConstructorArgumentCount(); i11++) {
                    if (!getEffectConstructorArgument(i11).isInitialized()) {
                        return false;
                    }
                }
                if (!hasConclusionOfConditionalEffect() || getConclusionOfConditionalEffect().isInitialized()) {
                    return true;
                }
                return false;
            }

            public Builder mergeConclusionOfConditionalEffect(Expression expression) {
                if ((this.bitField0_ & 4) != 4 || this.conclusionOfConditionalEffect_ == Expression.getDefaultInstance()) {
                    this.conclusionOfConditionalEffect_ = expression;
                } else {
                    this.conclusionOfConditionalEffect_ = Expression.newBuilder(this.conclusionOfConditionalEffect_).mergeFrom(expression).buildPartial();
                }
                this.bitField0_ |= 4;
                return this;
            }

            public Builder setEffectType(EffectType effectType) {
                effectType.getClass();
                this.bitField0_ |= 1;
                this.effectType_ = effectType;
                return this;
            }

            public Builder setKind(InvocationKind invocationKind) {
                invocationKind.getClass();
                this.bitField0_ |= 8;
                this.kind_ = invocationKind;
                return this;
            }

            public Effect build() {
                Effect buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.a(buildPartial);
            }

            public Effect getDefaultInstanceForType() {
                return Effect.getDefaultInstance();
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Builder mergeFrom(Effect effect) {
                if (effect == Effect.getDefaultInstance()) {
                    return this;
                }
                if (effect.hasEffectType()) {
                    setEffectType(effect.getEffectType());
                }
                if (!effect.effectConstructorArgument_.isEmpty()) {
                    if (this.effectConstructorArgument_.isEmpty()) {
                        this.effectConstructorArgument_ = effect.effectConstructorArgument_;
                        this.bitField0_ &= -3;
                    } else {
                        ensureEffectConstructorArgumentIsMutable();
                        this.effectConstructorArgument_.addAll(effect.effectConstructorArgument_);
                    }
                }
                if (effect.hasConclusionOfConditionalEffect()) {
                    mergeConclusionOfConditionalEffect(effect.getConclusionOfConditionalEffect());
                }
                if (effect.hasKind()) {
                    setKind(effect.getKind());
                }
                setUnknownFields(getUnknownFields().concat(effect.unknownFields));
                return this;
            }

            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                Effect effect;
                Effect effect2 = null;
                try {
                    Effect parsePartialFrom = Effect.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e11) {
                    effect = (Effect) e11.getUnfinishedMessage();
                    throw e11;
                } catch (Throwable th2) {
                    th = th2;
                    effect2 = effect;
                }
                if (effect2 != null) {
                    mergeFrom(effect2);
                }
                throw th;
            }
        }

        public enum EffectType implements Internal.EnumLite {
            RETURNS_CONSTANT(0, 0),
            CALLS(1, 1),
            RETURNS_NOT_NULL(2, 2);
            
            private static Internal.EnumLiteMap<EffectType> internalValueMap;
            private final int value;

            /* access modifiers changed from: public */
            static {
                internalValueMap = new Internal.EnumLiteMap<EffectType>() {
                    public EffectType findValueByNumber(int i11) {
                        return EffectType.valueOf(i11);
                    }
                };
            }

            private EffectType(int i11, int i12) {
                this.value = i12;
            }

            public final int getNumber() {
                return this.value;
            }

            public static EffectType valueOf(int i11) {
                if (i11 == 0) {
                    return RETURNS_CONSTANT;
                }
                if (i11 == 1) {
                    return CALLS;
                }
                if (i11 != 2) {
                    return null;
                }
                return RETURNS_NOT_NULL;
            }
        }

        public enum InvocationKind implements Internal.EnumLite {
            AT_MOST_ONCE(0, 0),
            EXACTLY_ONCE(1, 1),
            AT_LEAST_ONCE(2, 2);
            
            private static Internal.EnumLiteMap<InvocationKind> internalValueMap;
            private final int value;

            /* access modifiers changed from: public */
            static {
                internalValueMap = new Internal.EnumLiteMap<InvocationKind>() {
                    public InvocationKind findValueByNumber(int i11) {
                        return InvocationKind.valueOf(i11);
                    }
                };
            }

            private InvocationKind(int i11, int i12) {
                this.value = i12;
            }

            public final int getNumber() {
                return this.value;
            }

            public static InvocationKind valueOf(int i11) {
                if (i11 == 0) {
                    return AT_MOST_ONCE;
                }
                if (i11 == 1) {
                    return EXACTLY_ONCE;
                }
                if (i11 != 2) {
                    return null;
                }
                return AT_LEAST_ONCE;
            }
        }

        static {
            Effect effect = new Effect(true);
            defaultInstance = effect;
            effect.initFields();
        }

        public static Effect getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.effectType_ = EffectType.RETURNS_CONSTANT;
            this.effectConstructorArgument_ = Collections.emptyList();
            this.conclusionOfConditionalEffect_ = Expression.getDefaultInstance();
            this.kind_ = InvocationKind.AT_MOST_ONCE;
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Expression getConclusionOfConditionalEffect() {
            return this.conclusionOfConditionalEffect_;
        }

        public Expression getEffectConstructorArgument(int i11) {
            return this.effectConstructorArgument_.get(i11);
        }

        public int getEffectConstructorArgumentCount() {
            return this.effectConstructorArgument_.size();
        }

        public EffectType getEffectType() {
            return this.effectType_;
        }

        public InvocationKind getKind() {
            return this.kind_;
        }

        public Parser<Effect> getParserForType() {
            return PARSER;
        }

        public int getSerializedSize() {
            int i11;
            int i12 = this.memoizedSerializedSize;
            if (i12 != -1) {
                return i12;
            }
            if ((this.bitField0_ & 1) == 1) {
                i11 = CodedOutputStream.computeEnumSize(1, this.effectType_.getNumber()) + 0;
            } else {
                i11 = 0;
            }
            for (int i13 = 0; i13 < this.effectConstructorArgument_.size(); i13++) {
                i11 += CodedOutputStream.computeMessageSize(2, this.effectConstructorArgument_.get(i13));
            }
            if ((this.bitField0_ & 2) == 2) {
                i11 += CodedOutputStream.computeMessageSize(3, this.conclusionOfConditionalEffect_);
            }
            if ((this.bitField0_ & 4) == 4) {
                i11 += CodedOutputStream.computeEnumSize(4, this.kind_.getNumber());
            }
            int size = i11 + this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        public boolean hasConclusionOfConditionalEffect() {
            return (this.bitField0_ & 2) == 2;
        }

        public boolean hasEffectType() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean hasKind() {
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
            for (int i11 = 0; i11 < getEffectConstructorArgumentCount(); i11++) {
                if (!getEffectConstructorArgument(i11).isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            if (!hasConclusionOfConditionalEffect() || getConclusionOfConditionalEffect().isInitialized()) {
                this.memoizedIsInitialized = 1;
                return true;
            }
            this.memoizedIsInitialized = 0;
            return false;
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeEnum(1, this.effectType_.getNumber());
            }
            for (int i11 = 0; i11 < this.effectConstructorArgument_.size(); i11++) {
                codedOutputStream.writeMessage(2, this.effectConstructorArgument_.get(i11));
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeMessage(3, this.conclusionOfConditionalEffect_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeEnum(4, this.kind_.getNumber());
            }
            codedOutputStream.writeRawBytes(this.unknownFields);
        }

        public static Builder newBuilder(Effect effect) {
            return newBuilder().mergeFrom(effect);
        }

        public Effect getDefaultInstanceForType() {
            return defaultInstance;
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        private Effect(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private Effect(boolean z11) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        private Effect(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            int readEnum = codedInputStream.readEnum();
                            EffectType valueOf = EffectType.valueOf(readEnum);
                            if (valueOf == null) {
                                newInstance.writeRawVarint32(readTag);
                                newInstance.writeRawVarint32(readEnum);
                            } else {
                                this.bitField0_ |= 1;
                                this.effectType_ = valueOf;
                            }
                        } else if (readTag == 18) {
                            if (!(z12 & true)) {
                                this.effectConstructorArgument_ = new ArrayList();
                                z12 |= true;
                            }
                            this.effectConstructorArgument_.add(codedInputStream.readMessage(Expression.PARSER, extensionRegistryLite));
                        } else if (readTag == 26) {
                            Expression.Builder builder = (this.bitField0_ & 2) == 2 ? this.conclusionOfConditionalEffect_.toBuilder() : null;
                            Expression expression = (Expression) codedInputStream.readMessage(Expression.PARSER, extensionRegistryLite);
                            this.conclusionOfConditionalEffect_ = expression;
                            if (builder != null) {
                                builder.mergeFrom(expression);
                                this.conclusionOfConditionalEffect_ = builder.buildPartial();
                            }
                            this.bitField0_ |= 2;
                        } else if (readTag == 32) {
                            int readEnum2 = codedInputStream.readEnum();
                            InvocationKind valueOf2 = InvocationKind.valueOf(readEnum2);
                            if (valueOf2 == null) {
                                newInstance.writeRawVarint32(readTag);
                                newInstance.writeRawVarint32(readEnum2);
                            } else {
                                this.bitField0_ |= 4;
                                this.kind_ = valueOf2;
                            }
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
                        this.effectConstructorArgument_ = Collections.unmodifiableList(this.effectConstructorArgument_);
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
                this.effectConstructorArgument_ = Collections.unmodifiableList(this.effectConstructorArgument_);
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

    public interface EffectOrBuilder extends MessageLiteOrBuilder {
    }

    public static final class EnumEntry extends GeneratedMessageLite.ExtendableMessage<EnumEntry> implements EnumEntryOrBuilder {
        public static Parser<EnumEntry> PARSER = new AbstractParser<EnumEntry>() {
            public EnumEntry parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new EnumEntry(codedInputStream, extensionRegistryLite);
            }
        };
        private static final EnumEntry defaultInstance;
        /* access modifiers changed from: private */
        public int bitField0_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        /* access modifiers changed from: private */
        public int name_;
        /* access modifiers changed from: private */
        public final ByteString unknownFields;

        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<EnumEntry, Builder> implements EnumEntryOrBuilder {
            private int bitField0_;
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

            public EnumEntry buildPartial() {
                EnumEntry enumEntry = new EnumEntry((GeneratedMessageLite.ExtendableBuilder) this);
                int i11 = 1;
                if ((this.bitField0_ & 1) != 1) {
                    i11 = 0;
                }
                int unused = enumEntry.name_ = this.name_;
                int unused2 = enumEntry.bitField0_ = i11;
                return enumEntry;
            }

            public final boolean isInitialized() {
                return c();
            }

            public Builder setName(int i11) {
                this.bitField0_ |= 1;
                this.name_ = i11;
                return this;
            }

            public EnumEntry build() {
                EnumEntry buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.a(buildPartial);
            }

            public EnumEntry getDefaultInstanceForType() {
                return EnumEntry.getDefaultInstance();
            }

            public Builder mergeFrom(EnumEntry enumEntry) {
                if (enumEntry == EnumEntry.getDefaultInstance()) {
                    return this;
                }
                if (enumEntry.hasName()) {
                    setName(enumEntry.getName());
                }
                d(enumEntry);
                setUnknownFields(getUnknownFields().concat(enumEntry.unknownFields));
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                EnumEntry enumEntry;
                EnumEntry enumEntry2 = null;
                try {
                    EnumEntry parsePartialFrom = EnumEntry.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e11) {
                    enumEntry = (EnumEntry) e11.getUnfinishedMessage();
                    throw e11;
                } catch (Throwable th2) {
                    th = th2;
                    enumEntry2 = enumEntry;
                }
                if (enumEntry2 != null) {
                    mergeFrom(enumEntry2);
                }
                throw th;
            }
        }

        static {
            EnumEntry enumEntry = new EnumEntry(true);
            defaultInstance = enumEntry;
            enumEntry.initFields();
        }

        public static EnumEntry getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.name_ = 0;
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public int getName() {
            return this.name_;
        }

        public Parser<EnumEntry> getParserForType() {
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
            int i13 = i12 + i() + this.unknownFields.size();
            this.memoizedSerializedSize = i13;
            return i13;
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
            if (!h()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter j11 = j();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeInt32(1, this.name_);
            }
            j11.writeUntil(200, codedOutputStream);
            codedOutputStream.writeRawBytes(this.unknownFields);
        }

        public static Builder newBuilder(EnumEntry enumEntry) {
            return newBuilder().mergeFrom(enumEntry);
        }

        public EnumEntry getDefaultInstanceForType() {
            return defaultInstance;
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        private EnumEntry(GeneratedMessageLite.ExtendableBuilder<EnumEntry, ?> extendableBuilder) {
            super(extendableBuilder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = extendableBuilder.getUnknownFields();
        }

        private EnumEntry(boolean z11) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        private EnumEntry(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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

    public interface EnumEntryOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder {
    }

    public static final class Expression extends GeneratedMessageLite implements ExpressionOrBuilder {
        public static Parser<Expression> PARSER = new AbstractParser<Expression>() {
            public Expression parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Expression(codedInputStream, extensionRegistryLite);
            }
        };
        private static final Expression defaultInstance;
        /* access modifiers changed from: private */
        public List<Expression> andArgument_;
        /* access modifiers changed from: private */
        public int bitField0_;
        /* access modifiers changed from: private */
        public ConstantValue constantValue_;
        /* access modifiers changed from: private */
        public int flags_;
        /* access modifiers changed from: private */
        public int isInstanceTypeId_;
        /* access modifiers changed from: private */
        public Type isInstanceType_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        /* access modifiers changed from: private */
        public List<Expression> orArgument_;
        /* access modifiers changed from: private */
        public final ByteString unknownFields;
        /* access modifiers changed from: private */
        public int valueParameterReference_;

        public static final class Builder extends GeneratedMessageLite.Builder<Expression, Builder> implements ExpressionOrBuilder {
            private List<Expression> andArgument_ = Collections.emptyList();
            private int bitField0_;
            private ConstantValue constantValue_ = ConstantValue.TRUE;
            private int flags_;
            private int isInstanceTypeId_;
            private Type isInstanceType_ = Type.getDefaultInstance();
            private List<Expression> orArgument_ = Collections.emptyList();
            private int valueParameterReference_;

            private Builder() {
                maybeForceBuilderInitialization();
            }

            /* access modifiers changed from: private */
            public static Builder create() {
                return new Builder();
            }

            private void ensureAndArgumentIsMutable() {
                if ((this.bitField0_ & 32) != 32) {
                    this.andArgument_ = new ArrayList(this.andArgument_);
                    this.bitField0_ |= 32;
                }
            }

            private void ensureOrArgumentIsMutable() {
                if ((this.bitField0_ & 64) != 64) {
                    this.orArgument_ = new ArrayList(this.orArgument_);
                    this.bitField0_ |= 64;
                }
            }

            private void maybeForceBuilderInitialization() {
            }

            public Expression buildPartial() {
                Expression expression = new Expression((GeneratedMessageLite.Builder) this);
                int i11 = this.bitField0_;
                int i12 = 1;
                if ((i11 & 1) != 1) {
                    i12 = 0;
                }
                int unused = expression.flags_ = this.flags_;
                if ((i11 & 2) == 2) {
                    i12 |= 2;
                }
                int unused2 = expression.valueParameterReference_ = this.valueParameterReference_;
                if ((i11 & 4) == 4) {
                    i12 |= 4;
                }
                ConstantValue unused3 = expression.constantValue_ = this.constantValue_;
                if ((i11 & 8) == 8) {
                    i12 |= 8;
                }
                Type unused4 = expression.isInstanceType_ = this.isInstanceType_;
                if ((i11 & 16) == 16) {
                    i12 |= 16;
                }
                int unused5 = expression.isInstanceTypeId_ = this.isInstanceTypeId_;
                if ((this.bitField0_ & 32) == 32) {
                    this.andArgument_ = Collections.unmodifiableList(this.andArgument_);
                    this.bitField0_ &= -33;
                }
                List unused6 = expression.andArgument_ = this.andArgument_;
                if ((this.bitField0_ & 64) == 64) {
                    this.orArgument_ = Collections.unmodifiableList(this.orArgument_);
                    this.bitField0_ &= -65;
                }
                List unused7 = expression.orArgument_ = this.orArgument_;
                int unused8 = expression.bitField0_ = i12;
                return expression;
            }

            public Expression getAndArgument(int i11) {
                return this.andArgument_.get(i11);
            }

            public int getAndArgumentCount() {
                return this.andArgument_.size();
            }

            public Type getIsInstanceType() {
                return this.isInstanceType_;
            }

            public Expression getOrArgument(int i11) {
                return this.orArgument_.get(i11);
            }

            public int getOrArgumentCount() {
                return this.orArgument_.size();
            }

            public boolean hasIsInstanceType() {
                return (this.bitField0_ & 8) == 8;
            }

            public final boolean isInitialized() {
                if (hasIsInstanceType() && !getIsInstanceType().isInitialized()) {
                    return false;
                }
                for (int i11 = 0; i11 < getAndArgumentCount(); i11++) {
                    if (!getAndArgument(i11).isInitialized()) {
                        return false;
                    }
                }
                for (int i12 = 0; i12 < getOrArgumentCount(); i12++) {
                    if (!getOrArgument(i12).isInitialized()) {
                        return false;
                    }
                }
                return true;
            }

            public Builder mergeIsInstanceType(Type type) {
                if ((this.bitField0_ & 8) != 8 || this.isInstanceType_ == Type.getDefaultInstance()) {
                    this.isInstanceType_ = type;
                } else {
                    this.isInstanceType_ = Type.newBuilder(this.isInstanceType_).mergeFrom(type).buildPartial();
                }
                this.bitField0_ |= 8;
                return this;
            }

            public Builder setConstantValue(ConstantValue constantValue) {
                constantValue.getClass();
                this.bitField0_ |= 4;
                this.constantValue_ = constantValue;
                return this;
            }

            public Builder setFlags(int i11) {
                this.bitField0_ |= 1;
                this.flags_ = i11;
                return this;
            }

            public Builder setIsInstanceTypeId(int i11) {
                this.bitField0_ |= 16;
                this.isInstanceTypeId_ = i11;
                return this;
            }

            public Builder setValueParameterReference(int i11) {
                this.bitField0_ |= 2;
                this.valueParameterReference_ = i11;
                return this;
            }

            public Expression build() {
                Expression buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.a(buildPartial);
            }

            public Expression getDefaultInstanceForType() {
                return Expression.getDefaultInstance();
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Builder mergeFrom(Expression expression) {
                if (expression == Expression.getDefaultInstance()) {
                    return this;
                }
                if (expression.hasFlags()) {
                    setFlags(expression.getFlags());
                }
                if (expression.hasValueParameterReference()) {
                    setValueParameterReference(expression.getValueParameterReference());
                }
                if (expression.hasConstantValue()) {
                    setConstantValue(expression.getConstantValue());
                }
                if (expression.hasIsInstanceType()) {
                    mergeIsInstanceType(expression.getIsInstanceType());
                }
                if (expression.hasIsInstanceTypeId()) {
                    setIsInstanceTypeId(expression.getIsInstanceTypeId());
                }
                if (!expression.andArgument_.isEmpty()) {
                    if (this.andArgument_.isEmpty()) {
                        this.andArgument_ = expression.andArgument_;
                        this.bitField0_ &= -33;
                    } else {
                        ensureAndArgumentIsMutable();
                        this.andArgument_.addAll(expression.andArgument_);
                    }
                }
                if (!expression.orArgument_.isEmpty()) {
                    if (this.orArgument_.isEmpty()) {
                        this.orArgument_ = expression.orArgument_;
                        this.bitField0_ &= -65;
                    } else {
                        ensureOrArgumentIsMutable();
                        this.orArgument_.addAll(expression.orArgument_);
                    }
                }
                setUnknownFields(getUnknownFields().concat(expression.unknownFields));
                return this;
            }

            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                Expression expression;
                Expression expression2 = null;
                try {
                    Expression parsePartialFrom = Expression.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e11) {
                    expression = (Expression) e11.getUnfinishedMessage();
                    throw e11;
                } catch (Throwable th2) {
                    th = th2;
                    expression2 = expression;
                }
                if (expression2 != null) {
                    mergeFrom(expression2);
                }
                throw th;
            }
        }

        public enum ConstantValue implements Internal.EnumLite {
            TRUE(0, 0),
            FALSE(1, 1),
            NULL(2, 2);
            
            private static Internal.EnumLiteMap<ConstantValue> internalValueMap;
            private final int value;

            /* access modifiers changed from: public */
            static {
                internalValueMap = new Internal.EnumLiteMap<ConstantValue>() {
                    public ConstantValue findValueByNumber(int i11) {
                        return ConstantValue.valueOf(i11);
                    }
                };
            }

            private ConstantValue(int i11, int i12) {
                this.value = i12;
            }

            public final int getNumber() {
                return this.value;
            }

            public static ConstantValue valueOf(int i11) {
                if (i11 == 0) {
                    return TRUE;
                }
                if (i11 == 1) {
                    return FALSE;
                }
                if (i11 != 2) {
                    return null;
                }
                return NULL;
            }
        }

        static {
            Expression expression = new Expression(true);
            defaultInstance = expression;
            expression.initFields();
        }

        public static Expression getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.flags_ = 0;
            this.valueParameterReference_ = 0;
            this.constantValue_ = ConstantValue.TRUE;
            this.isInstanceType_ = Type.getDefaultInstance();
            this.isInstanceTypeId_ = 0;
            this.andArgument_ = Collections.emptyList();
            this.orArgument_ = Collections.emptyList();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Expression getAndArgument(int i11) {
            return this.andArgument_.get(i11);
        }

        public int getAndArgumentCount() {
            return this.andArgument_.size();
        }

        public ConstantValue getConstantValue() {
            return this.constantValue_;
        }

        public int getFlags() {
            return this.flags_;
        }

        public Type getIsInstanceType() {
            return this.isInstanceType_;
        }

        public int getIsInstanceTypeId() {
            return this.isInstanceTypeId_;
        }

        public Expression getOrArgument(int i11) {
            return this.orArgument_.get(i11);
        }

        public int getOrArgumentCount() {
            return this.orArgument_.size();
        }

        public Parser<Expression> getParserForType() {
            return PARSER;
        }

        public int getSerializedSize() {
            int i11;
            int i12 = this.memoizedSerializedSize;
            if (i12 != -1) {
                return i12;
            }
            if ((this.bitField0_ & 1) == 1) {
                i11 = CodedOutputStream.computeInt32Size(1, this.flags_) + 0;
            } else {
                i11 = 0;
            }
            if ((this.bitField0_ & 2) == 2) {
                i11 += CodedOutputStream.computeInt32Size(2, this.valueParameterReference_);
            }
            if ((this.bitField0_ & 4) == 4) {
                i11 += CodedOutputStream.computeEnumSize(3, this.constantValue_.getNumber());
            }
            if ((this.bitField0_ & 8) == 8) {
                i11 += CodedOutputStream.computeMessageSize(4, this.isInstanceType_);
            }
            if ((this.bitField0_ & 16) == 16) {
                i11 += CodedOutputStream.computeInt32Size(5, this.isInstanceTypeId_);
            }
            for (int i13 = 0; i13 < this.andArgument_.size(); i13++) {
                i11 += CodedOutputStream.computeMessageSize(6, this.andArgument_.get(i13));
            }
            for (int i14 = 0; i14 < this.orArgument_.size(); i14++) {
                i11 += CodedOutputStream.computeMessageSize(7, this.orArgument_.get(i14));
            }
            int size = i11 + this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        public int getValueParameterReference() {
            return this.valueParameterReference_;
        }

        public boolean hasConstantValue() {
            return (this.bitField0_ & 4) == 4;
        }

        public boolean hasFlags() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean hasIsInstanceType() {
            return (this.bitField0_ & 8) == 8;
        }

        public boolean hasIsInstanceTypeId() {
            return (this.bitField0_ & 16) == 16;
        }

        public boolean hasValueParameterReference() {
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
            if (!hasIsInstanceType() || getIsInstanceType().isInitialized()) {
                for (int i11 = 0; i11 < getAndArgumentCount(); i11++) {
                    if (!getAndArgument(i11).isInitialized()) {
                        this.memoizedIsInitialized = 0;
                        return false;
                    }
                }
                for (int i12 = 0; i12 < getOrArgumentCount(); i12++) {
                    if (!getOrArgument(i12).isInitialized()) {
                        this.memoizedIsInitialized = 0;
                        return false;
                    }
                }
                this.memoizedIsInitialized = 1;
                return true;
            }
            this.memoizedIsInitialized = 0;
            return false;
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeInt32(1, this.flags_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeInt32(2, this.valueParameterReference_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeEnum(3, this.constantValue_.getNumber());
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeMessage(4, this.isInstanceType_);
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.writeInt32(5, this.isInstanceTypeId_);
            }
            for (int i11 = 0; i11 < this.andArgument_.size(); i11++) {
                codedOutputStream.writeMessage(6, this.andArgument_.get(i11));
            }
            for (int i12 = 0; i12 < this.orArgument_.size(); i12++) {
                codedOutputStream.writeMessage(7, this.orArgument_.get(i12));
            }
            codedOutputStream.writeRawBytes(this.unknownFields);
        }

        public static Builder newBuilder(Expression expression) {
            return newBuilder().mergeFrom(expression);
        }

        public Expression getDefaultInstanceForType() {
            return defaultInstance;
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        private Expression(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private Expression(boolean z11) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        private Expression(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            this.flags_ = codedInputStream.readInt32();
                        } else if (readTag == 16) {
                            this.bitField0_ |= 2;
                            this.valueParameterReference_ = codedInputStream.readInt32();
                        } else if (readTag == 24) {
                            int readEnum = codedInputStream.readEnum();
                            ConstantValue valueOf = ConstantValue.valueOf(readEnum);
                            if (valueOf == null) {
                                newInstance.writeRawVarint32(readTag);
                                newInstance.writeRawVarint32(readEnum);
                            } else {
                                this.bitField0_ |= 4;
                                this.constantValue_ = valueOf;
                            }
                        } else if (readTag == 34) {
                            Type.Builder builder = (this.bitField0_ & 8) == 8 ? this.isInstanceType_.toBuilder() : null;
                            Type type = (Type) codedInputStream.readMessage(Type.PARSER, extensionRegistryLite);
                            this.isInstanceType_ = type;
                            if (builder != null) {
                                builder.mergeFrom(type);
                                this.isInstanceType_ = builder.buildPartial();
                            }
                            this.bitField0_ |= 8;
                        } else if (readTag == 40) {
                            this.bitField0_ |= 16;
                            this.isInstanceTypeId_ = codedInputStream.readInt32();
                        } else if (readTag == 50) {
                            if (!(z12 & true)) {
                                this.andArgument_ = new ArrayList();
                                z12 |= true;
                            }
                            this.andArgument_.add(codedInputStream.readMessage(PARSER, extensionRegistryLite));
                        } else if (readTag == 58) {
                            if (!(z12 & true)) {
                                this.orArgument_ = new ArrayList();
                                z12 |= true;
                            }
                            this.orArgument_.add(codedInputStream.readMessage(PARSER, extensionRegistryLite));
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
                        this.andArgument_ = Collections.unmodifiableList(this.andArgument_);
                    }
                    if (z12 & true) {
                        this.orArgument_ = Collections.unmodifiableList(this.orArgument_);
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
                this.andArgument_ = Collections.unmodifiableList(this.andArgument_);
            }
            if (z12 & true) {
                this.orArgument_ = Collections.unmodifiableList(this.orArgument_);
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

    public interface ExpressionOrBuilder extends MessageLiteOrBuilder {
    }

    public static final class Function extends GeneratedMessageLite.ExtendableMessage<Function> implements FunctionOrBuilder {
        public static Parser<Function> PARSER = new AbstractParser<Function>() {
            public Function parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Function(codedInputStream, extensionRegistryLite);
            }
        };
        private static final Function defaultInstance;
        /* access modifiers changed from: private */
        public int bitField0_;
        private int contextReceiverTypeIdMemoizedSerializedSize;
        /* access modifiers changed from: private */
        public List<Integer> contextReceiverTypeId_;
        /* access modifiers changed from: private */
        public List<Type> contextReceiverType_;
        /* access modifiers changed from: private */
        public Contract contract_;
        /* access modifiers changed from: private */
        public int flags_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        /* access modifiers changed from: private */
        public int name_;
        /* access modifiers changed from: private */
        public int oldFlags_;
        /* access modifiers changed from: private */
        public int receiverTypeId_;
        /* access modifiers changed from: private */
        public Type receiverType_;
        /* access modifiers changed from: private */
        public int returnTypeId_;
        /* access modifiers changed from: private */
        public Type returnType_;
        /* access modifiers changed from: private */
        public List<TypeParameter> typeParameter_;
        /* access modifiers changed from: private */
        public TypeTable typeTable_;
        /* access modifiers changed from: private */
        public final ByteString unknownFields;
        /* access modifiers changed from: private */
        public List<ValueParameter> valueParameter_;
        /* access modifiers changed from: private */
        public List<Integer> versionRequirement_;

        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<Function, Builder> implements FunctionOrBuilder {
            private int bitField0_;
            private List<Integer> contextReceiverTypeId_ = Collections.emptyList();
            private List<Type> contextReceiverType_ = Collections.emptyList();
            private Contract contract_ = Contract.getDefaultInstance();
            private int flags_ = 6;
            private int name_;
            private int oldFlags_ = 6;
            private int receiverTypeId_;
            private Type receiverType_ = Type.getDefaultInstance();
            private int returnTypeId_;
            private Type returnType_ = Type.getDefaultInstance();
            private List<TypeParameter> typeParameter_ = Collections.emptyList();
            private TypeTable typeTable_ = TypeTable.getDefaultInstance();
            private List<ValueParameter> valueParameter_ = Collections.emptyList();
            private List<Integer> versionRequirement_ = Collections.emptyList();

            private Builder() {
                maybeForceBuilderInitialization();
            }

            /* access modifiers changed from: private */
            public static Builder create() {
                return new Builder();
            }

            private void ensureContextReceiverTypeIdIsMutable() {
                if ((this.bitField0_ & 512) != 512) {
                    this.contextReceiverTypeId_ = new ArrayList(this.contextReceiverTypeId_);
                    this.bitField0_ |= 512;
                }
            }

            private void ensureContextReceiverTypeIsMutable() {
                if ((this.bitField0_ & 256) != 256) {
                    this.contextReceiverType_ = new ArrayList(this.contextReceiverType_);
                    this.bitField0_ |= 256;
                }
            }

            private void ensureTypeParameterIsMutable() {
                if ((this.bitField0_ & 32) != 32) {
                    this.typeParameter_ = new ArrayList(this.typeParameter_);
                    this.bitField0_ |= 32;
                }
            }

            private void ensureValueParameterIsMutable() {
                if ((this.bitField0_ & 1024) != 1024) {
                    this.valueParameter_ = new ArrayList(this.valueParameter_);
                    this.bitField0_ |= 1024;
                }
            }

            private void ensureVersionRequirementIsMutable() {
                if ((this.bitField0_ & 4096) != 4096) {
                    this.versionRequirement_ = new ArrayList(this.versionRequirement_);
                    this.bitField0_ |= 4096;
                }
            }

            private void maybeForceBuilderInitialization() {
            }

            public Function buildPartial() {
                Function function = new Function((GeneratedMessageLite.ExtendableBuilder) this);
                int i11 = this.bitField0_;
                int i12 = 1;
                if ((i11 & 1) != 1) {
                    i12 = 0;
                }
                int unused = function.flags_ = this.flags_;
                if ((i11 & 2) == 2) {
                    i12 |= 2;
                }
                int unused2 = function.oldFlags_ = this.oldFlags_;
                if ((i11 & 4) == 4) {
                    i12 |= 4;
                }
                int unused3 = function.name_ = this.name_;
                if ((i11 & 8) == 8) {
                    i12 |= 8;
                }
                Type unused4 = function.returnType_ = this.returnType_;
                if ((i11 & 16) == 16) {
                    i12 |= 16;
                }
                int unused5 = function.returnTypeId_ = this.returnTypeId_;
                if ((this.bitField0_ & 32) == 32) {
                    this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                    this.bitField0_ &= -33;
                }
                List unused6 = function.typeParameter_ = this.typeParameter_;
                if ((i11 & 64) == 64) {
                    i12 |= 32;
                }
                Type unused7 = function.receiverType_ = this.receiverType_;
                if ((i11 & 128) == 128) {
                    i12 |= 64;
                }
                int unused8 = function.receiverTypeId_ = this.receiverTypeId_;
                if ((this.bitField0_ & 256) == 256) {
                    this.contextReceiverType_ = Collections.unmodifiableList(this.contextReceiverType_);
                    this.bitField0_ &= -257;
                }
                List unused9 = function.contextReceiverType_ = this.contextReceiverType_;
                if ((this.bitField0_ & 512) == 512) {
                    this.contextReceiverTypeId_ = Collections.unmodifiableList(this.contextReceiverTypeId_);
                    this.bitField0_ &= -513;
                }
                List unused10 = function.contextReceiverTypeId_ = this.contextReceiverTypeId_;
                if ((this.bitField0_ & 1024) == 1024) {
                    this.valueParameter_ = Collections.unmodifiableList(this.valueParameter_);
                    this.bitField0_ &= -1025;
                }
                List unused11 = function.valueParameter_ = this.valueParameter_;
                if ((i11 & 2048) == 2048) {
                    i12 |= 128;
                }
                TypeTable unused12 = function.typeTable_ = this.typeTable_;
                if ((this.bitField0_ & 4096) == 4096) {
                    this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
                    this.bitField0_ &= -4097;
                }
                List unused13 = function.versionRequirement_ = this.versionRequirement_;
                if ((i11 & 8192) == 8192) {
                    i12 |= 256;
                }
                Contract unused14 = function.contract_ = this.contract_;
                int unused15 = function.bitField0_ = i12;
                return function;
            }

            public Type getContextReceiverType(int i11) {
                return this.contextReceiverType_.get(i11);
            }

            public int getContextReceiverTypeCount() {
                return this.contextReceiverType_.size();
            }

            public Contract getContract() {
                return this.contract_;
            }

            public Type getReceiverType() {
                return this.receiverType_;
            }

            public Type getReturnType() {
                return this.returnType_;
            }

            public TypeParameter getTypeParameter(int i11) {
                return this.typeParameter_.get(i11);
            }

            public int getTypeParameterCount() {
                return this.typeParameter_.size();
            }

            public TypeTable getTypeTable() {
                return this.typeTable_;
            }

            public ValueParameter getValueParameter(int i11) {
                return this.valueParameter_.get(i11);
            }

            public int getValueParameterCount() {
                return this.valueParameter_.size();
            }

            public boolean hasContract() {
                return (this.bitField0_ & 8192) == 8192;
            }

            public boolean hasName() {
                return (this.bitField0_ & 4) == 4;
            }

            public boolean hasReceiverType() {
                return (this.bitField0_ & 64) == 64;
            }

            public boolean hasReturnType() {
                return (this.bitField0_ & 8) == 8;
            }

            public boolean hasTypeTable() {
                return (this.bitField0_ & 2048) == 2048;
            }

            public final boolean isInitialized() {
                if (!hasName()) {
                    return false;
                }
                if (hasReturnType() && !getReturnType().isInitialized()) {
                    return false;
                }
                for (int i11 = 0; i11 < getTypeParameterCount(); i11++) {
                    if (!getTypeParameter(i11).isInitialized()) {
                        return false;
                    }
                }
                if (hasReceiverType() && !getReceiverType().isInitialized()) {
                    return false;
                }
                for (int i12 = 0; i12 < getContextReceiverTypeCount(); i12++) {
                    if (!getContextReceiverType(i12).isInitialized()) {
                        return false;
                    }
                }
                for (int i13 = 0; i13 < getValueParameterCount(); i13++) {
                    if (!getValueParameter(i13).isInitialized()) {
                        return false;
                    }
                }
                if (hasTypeTable() && !getTypeTable().isInitialized()) {
                    return false;
                }
                if ((!hasContract() || getContract().isInitialized()) && c()) {
                    return true;
                }
                return false;
            }

            public Builder mergeContract(Contract contract) {
                if ((this.bitField0_ & 8192) != 8192 || this.contract_ == Contract.getDefaultInstance()) {
                    this.contract_ = contract;
                } else {
                    this.contract_ = Contract.newBuilder(this.contract_).mergeFrom(contract).buildPartial();
                }
                this.bitField0_ |= 8192;
                return this;
            }

            public Builder mergeReceiverType(Type type) {
                if ((this.bitField0_ & 64) != 64 || this.receiverType_ == Type.getDefaultInstance()) {
                    this.receiverType_ = type;
                } else {
                    this.receiverType_ = Type.newBuilder(this.receiverType_).mergeFrom(type).buildPartial();
                }
                this.bitField0_ |= 64;
                return this;
            }

            public Builder mergeReturnType(Type type) {
                if ((this.bitField0_ & 8) != 8 || this.returnType_ == Type.getDefaultInstance()) {
                    this.returnType_ = type;
                } else {
                    this.returnType_ = Type.newBuilder(this.returnType_).mergeFrom(type).buildPartial();
                }
                this.bitField0_ |= 8;
                return this;
            }

            public Builder mergeTypeTable(TypeTable typeTable) {
                if ((this.bitField0_ & 2048) != 2048 || this.typeTable_ == TypeTable.getDefaultInstance()) {
                    this.typeTable_ = typeTable;
                } else {
                    this.typeTable_ = TypeTable.newBuilder(this.typeTable_).mergeFrom(typeTable).buildPartial();
                }
                this.bitField0_ |= 2048;
                return this;
            }

            public Builder setFlags(int i11) {
                this.bitField0_ |= 1;
                this.flags_ = i11;
                return this;
            }

            public Builder setName(int i11) {
                this.bitField0_ |= 4;
                this.name_ = i11;
                return this;
            }

            public Builder setOldFlags(int i11) {
                this.bitField0_ |= 2;
                this.oldFlags_ = i11;
                return this;
            }

            public Builder setReceiverTypeId(int i11) {
                this.bitField0_ |= 128;
                this.receiverTypeId_ = i11;
                return this;
            }

            public Builder setReturnTypeId(int i11) {
                this.bitField0_ |= 16;
                this.returnTypeId_ = i11;
                return this;
            }

            public Function build() {
                Function buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.a(buildPartial);
            }

            public Function getDefaultInstanceForType() {
                return Function.getDefaultInstance();
            }

            public Builder mergeFrom(Function function) {
                if (function == Function.getDefaultInstance()) {
                    return this;
                }
                if (function.hasFlags()) {
                    setFlags(function.getFlags());
                }
                if (function.hasOldFlags()) {
                    setOldFlags(function.getOldFlags());
                }
                if (function.hasName()) {
                    setName(function.getName());
                }
                if (function.hasReturnType()) {
                    mergeReturnType(function.getReturnType());
                }
                if (function.hasReturnTypeId()) {
                    setReturnTypeId(function.getReturnTypeId());
                }
                if (!function.typeParameter_.isEmpty()) {
                    if (this.typeParameter_.isEmpty()) {
                        this.typeParameter_ = function.typeParameter_;
                        this.bitField0_ &= -33;
                    } else {
                        ensureTypeParameterIsMutable();
                        this.typeParameter_.addAll(function.typeParameter_);
                    }
                }
                if (function.hasReceiverType()) {
                    mergeReceiverType(function.getReceiverType());
                }
                if (function.hasReceiverTypeId()) {
                    setReceiverTypeId(function.getReceiverTypeId());
                }
                if (!function.contextReceiverType_.isEmpty()) {
                    if (this.contextReceiverType_.isEmpty()) {
                        this.contextReceiverType_ = function.contextReceiverType_;
                        this.bitField0_ &= -257;
                    } else {
                        ensureContextReceiverTypeIsMutable();
                        this.contextReceiverType_.addAll(function.contextReceiverType_);
                    }
                }
                if (!function.contextReceiverTypeId_.isEmpty()) {
                    if (this.contextReceiverTypeId_.isEmpty()) {
                        this.contextReceiverTypeId_ = function.contextReceiverTypeId_;
                        this.bitField0_ &= -513;
                    } else {
                        ensureContextReceiverTypeIdIsMutable();
                        this.contextReceiverTypeId_.addAll(function.contextReceiverTypeId_);
                    }
                }
                if (!function.valueParameter_.isEmpty()) {
                    if (this.valueParameter_.isEmpty()) {
                        this.valueParameter_ = function.valueParameter_;
                        this.bitField0_ &= -1025;
                    } else {
                        ensureValueParameterIsMutable();
                        this.valueParameter_.addAll(function.valueParameter_);
                    }
                }
                if (function.hasTypeTable()) {
                    mergeTypeTable(function.getTypeTable());
                }
                if (!function.versionRequirement_.isEmpty()) {
                    if (this.versionRequirement_.isEmpty()) {
                        this.versionRequirement_ = function.versionRequirement_;
                        this.bitField0_ &= -4097;
                    } else {
                        ensureVersionRequirementIsMutable();
                        this.versionRequirement_.addAll(function.versionRequirement_);
                    }
                }
                if (function.hasContract()) {
                    mergeContract(function.getContract());
                }
                d(function);
                setUnknownFields(getUnknownFields().concat(function.unknownFields));
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                Function function;
                Function function2 = null;
                try {
                    Function parsePartialFrom = Function.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e11) {
                    function = (Function) e11.getUnfinishedMessage();
                    throw e11;
                } catch (Throwable th2) {
                    th = th2;
                    function2 = function;
                }
                if (function2 != null) {
                    mergeFrom(function2);
                }
                throw th;
            }
        }

        static {
            Function function = new Function(true);
            defaultInstance = function;
            function.initFields();
        }

        public static Function getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.flags_ = 6;
            this.oldFlags_ = 6;
            this.name_ = 0;
            this.returnType_ = Type.getDefaultInstance();
            this.returnTypeId_ = 0;
            this.typeParameter_ = Collections.emptyList();
            this.receiverType_ = Type.getDefaultInstance();
            this.receiverTypeId_ = 0;
            this.contextReceiverType_ = Collections.emptyList();
            this.contextReceiverTypeId_ = Collections.emptyList();
            this.valueParameter_ = Collections.emptyList();
            this.typeTable_ = TypeTable.getDefaultInstance();
            this.versionRequirement_ = Collections.emptyList();
            this.contract_ = Contract.getDefaultInstance();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public static Function parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public Type getContextReceiverType(int i11) {
            return this.contextReceiverType_.get(i11);
        }

        public int getContextReceiverTypeCount() {
            return this.contextReceiverType_.size();
        }

        public List<Integer> getContextReceiverTypeIdList() {
            return this.contextReceiverTypeId_;
        }

        public List<Type> getContextReceiverTypeList() {
            return this.contextReceiverType_;
        }

        public Contract getContract() {
            return this.contract_;
        }

        public int getFlags() {
            return this.flags_;
        }

        public int getName() {
            return this.name_;
        }

        public int getOldFlags() {
            return this.oldFlags_;
        }

        public Parser<Function> getParserForType() {
            return PARSER;
        }

        public Type getReceiverType() {
            return this.receiverType_;
        }

        public int getReceiverTypeId() {
            return this.receiverTypeId_;
        }

        public Type getReturnType() {
            return this.returnType_;
        }

        public int getReturnTypeId() {
            return this.returnTypeId_;
        }

        public int getSerializedSize() {
            int i11;
            int i12 = this.memoizedSerializedSize;
            if (i12 != -1) {
                return i12;
            }
            if ((this.bitField0_ & 2) == 2) {
                i11 = CodedOutputStream.computeInt32Size(1, this.oldFlags_) + 0;
            } else {
                i11 = 0;
            }
            if ((this.bitField0_ & 4) == 4) {
                i11 += CodedOutputStream.computeInt32Size(2, this.name_);
            }
            if ((this.bitField0_ & 8) == 8) {
                i11 += CodedOutputStream.computeMessageSize(3, this.returnType_);
            }
            for (int i13 = 0; i13 < this.typeParameter_.size(); i13++) {
                i11 += CodedOutputStream.computeMessageSize(4, this.typeParameter_.get(i13));
            }
            if ((this.bitField0_ & 32) == 32) {
                i11 += CodedOutputStream.computeMessageSize(5, this.receiverType_);
            }
            for (int i14 = 0; i14 < this.valueParameter_.size(); i14++) {
                i11 += CodedOutputStream.computeMessageSize(6, this.valueParameter_.get(i14));
            }
            if ((this.bitField0_ & 16) == 16) {
                i11 += CodedOutputStream.computeInt32Size(7, this.returnTypeId_);
            }
            if ((this.bitField0_ & 64) == 64) {
                i11 += CodedOutputStream.computeInt32Size(8, this.receiverTypeId_);
            }
            if ((this.bitField0_ & 1) == 1) {
                i11 += CodedOutputStream.computeInt32Size(9, this.flags_);
            }
            for (int i15 = 0; i15 < this.contextReceiverType_.size(); i15++) {
                i11 += CodedOutputStream.computeMessageSize(10, this.contextReceiverType_.get(i15));
            }
            int i16 = 0;
            for (int i17 = 0; i17 < this.contextReceiverTypeId_.size(); i17++) {
                i16 += CodedOutputStream.computeInt32SizeNoTag(this.contextReceiverTypeId_.get(i17).intValue());
            }
            int i18 = i11 + i16;
            if (!getContextReceiverTypeIdList().isEmpty()) {
                i18 = i18 + 1 + CodedOutputStream.computeInt32SizeNoTag(i16);
            }
            this.contextReceiverTypeIdMemoizedSerializedSize = i16;
            if ((this.bitField0_ & 128) == 128) {
                i18 += CodedOutputStream.computeMessageSize(30, this.typeTable_);
            }
            int i19 = 0;
            for (int i21 = 0; i21 < this.versionRequirement_.size(); i21++) {
                i19 += CodedOutputStream.computeInt32SizeNoTag(this.versionRequirement_.get(i21).intValue());
            }
            int size = i18 + i19 + (getVersionRequirementList().size() * 2);
            if ((this.bitField0_ & 256) == 256) {
                size += CodedOutputStream.computeMessageSize(32, this.contract_);
            }
            int i22 = size + i() + this.unknownFields.size();
            this.memoizedSerializedSize = i22;
            return i22;
        }

        public TypeParameter getTypeParameter(int i11) {
            return this.typeParameter_.get(i11);
        }

        public int getTypeParameterCount() {
            return this.typeParameter_.size();
        }

        public List<TypeParameter> getTypeParameterList() {
            return this.typeParameter_;
        }

        public TypeTable getTypeTable() {
            return this.typeTable_;
        }

        public ValueParameter getValueParameter(int i11) {
            return this.valueParameter_.get(i11);
        }

        public int getValueParameterCount() {
            return this.valueParameter_.size();
        }

        public List<ValueParameter> getValueParameterList() {
            return this.valueParameter_;
        }

        public List<Integer> getVersionRequirementList() {
            return this.versionRequirement_;
        }

        public boolean hasContract() {
            return (this.bitField0_ & 256) == 256;
        }

        public boolean hasFlags() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean hasName() {
            return (this.bitField0_ & 4) == 4;
        }

        public boolean hasOldFlags() {
            return (this.bitField0_ & 2) == 2;
        }

        public boolean hasReceiverType() {
            return (this.bitField0_ & 32) == 32;
        }

        public boolean hasReceiverTypeId() {
            return (this.bitField0_ & 64) == 64;
        }

        public boolean hasReturnType() {
            return (this.bitField0_ & 8) == 8;
        }

        public boolean hasReturnTypeId() {
            return (this.bitField0_ & 16) == 16;
        }

        public boolean hasTypeTable() {
            return (this.bitField0_ & 128) == 128;
        }

        public final boolean isInitialized() {
            byte b11 = this.memoizedIsInitialized;
            if (b11 == 1) {
                return true;
            }
            if (b11 == 0) {
                return false;
            }
            if (!hasName()) {
                this.memoizedIsInitialized = 0;
                return false;
            } else if (!hasReturnType() || getReturnType().isInitialized()) {
                for (int i11 = 0; i11 < getTypeParameterCount(); i11++) {
                    if (!getTypeParameter(i11).isInitialized()) {
                        this.memoizedIsInitialized = 0;
                        return false;
                    }
                }
                if (!hasReceiverType() || getReceiverType().isInitialized()) {
                    for (int i12 = 0; i12 < getContextReceiverTypeCount(); i12++) {
                        if (!getContextReceiverType(i12).isInitialized()) {
                            this.memoizedIsInitialized = 0;
                            return false;
                        }
                    }
                    for (int i13 = 0; i13 < getValueParameterCount(); i13++) {
                        if (!getValueParameter(i13).isInitialized()) {
                            this.memoizedIsInitialized = 0;
                            return false;
                        }
                    }
                    if (hasTypeTable() && !getTypeTable().isInitialized()) {
                        this.memoizedIsInitialized = 0;
                        return false;
                    } else if (hasContract() && !getContract().isInitialized()) {
                        this.memoizedIsInitialized = 0;
                        return false;
                    } else if (!h()) {
                        this.memoizedIsInitialized = 0;
                        return false;
                    } else {
                        this.memoizedIsInitialized = 1;
                        return true;
                    }
                } else {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            } else {
                this.memoizedIsInitialized = 0;
                return false;
            }
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter j11 = j();
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeInt32(1, this.oldFlags_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeInt32(2, this.name_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeMessage(3, this.returnType_);
            }
            for (int i11 = 0; i11 < this.typeParameter_.size(); i11++) {
                codedOutputStream.writeMessage(4, this.typeParameter_.get(i11));
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.writeMessage(5, this.receiverType_);
            }
            for (int i12 = 0; i12 < this.valueParameter_.size(); i12++) {
                codedOutputStream.writeMessage(6, this.valueParameter_.get(i12));
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.writeInt32(7, this.returnTypeId_);
            }
            if ((this.bitField0_ & 64) == 64) {
                codedOutputStream.writeInt32(8, this.receiverTypeId_);
            }
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeInt32(9, this.flags_);
            }
            for (int i13 = 0; i13 < this.contextReceiverType_.size(); i13++) {
                codedOutputStream.writeMessage(10, this.contextReceiverType_.get(i13));
            }
            if (getContextReceiverTypeIdList().size() > 0) {
                codedOutputStream.writeRawVarint32(90);
                codedOutputStream.writeRawVarint32(this.contextReceiverTypeIdMemoizedSerializedSize);
            }
            for (int i14 = 0; i14 < this.contextReceiverTypeId_.size(); i14++) {
                codedOutputStream.writeInt32NoTag(this.contextReceiverTypeId_.get(i14).intValue());
            }
            if ((this.bitField0_ & 128) == 128) {
                codedOutputStream.writeMessage(30, this.typeTable_);
            }
            for (int i15 = 0; i15 < this.versionRequirement_.size(); i15++) {
                codedOutputStream.writeInt32(31, this.versionRequirement_.get(i15).intValue());
            }
            if ((this.bitField0_ & 256) == 256) {
                codedOutputStream.writeMessage(32, this.contract_);
            }
            j11.writeUntil(19000, codedOutputStream);
            codedOutputStream.writeRawBytes(this.unknownFields);
        }

        public static Builder newBuilder(Function function) {
            return newBuilder().mergeFrom(function);
        }

        public Function getDefaultInstanceForType() {
            return defaultInstance;
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        private Function(GeneratedMessageLite.ExtendableBuilder<Function, ?> extendableBuilder) {
            super(extendableBuilder);
            this.contextReceiverTypeIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = extendableBuilder.getUnknownFields();
        }

        private Function(boolean z11) {
            this.contextReceiverTypeIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type$Builder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v5, resolved type: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type$Builder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v18, resolved type: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable$Builder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v27, resolved type: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Contract$Builder} */
        /* JADX WARNING: type inference failed for: r11v0 */
        /* JADX WARNING: type inference failed for: r11v29 */
        /* JADX WARNING: type inference failed for: r11v30 */
        /* JADX WARNING: type inference failed for: r11v31 */
        /* JADX WARNING: type inference failed for: r11v32 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private Function(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream r14, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite r15) throws kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException {
            /*
                r13 = this;
                r13.<init>()
                r0 = -1
                r13.contextReceiverTypeIdMemoizedSerializedSize = r0
                r13.memoizedIsInitialized = r0
                r13.memoizedSerializedSize = r0
                r13.initFields()
                kotlin.reflect.jvm.internal.impl.protobuf.ByteString$Output r0 = kotlin.reflect.jvm.internal.impl.protobuf.ByteString.newOutput()
                r1 = 1
                kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream r2 = kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream.newInstance(r0, r1)
                r3 = 0
                r4 = r3
            L_0x0018:
                r5 = 1024(0x400, float:1.435E-42)
                r6 = 4096(0x1000, float:5.74E-42)
                r7 = 512(0x200, float:7.175E-43)
                r8 = 256(0x100, float:3.59E-43)
                r9 = 32
                if (r3 != 0) goto L_0x0272
                int r10 = r14.readTag()     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r11 = 0
                switch(r10) {
                    case 0: goto L_0x0203;
                    case 8: goto L_0x01f5;
                    case 16: goto L_0x01e7;
                    case 26: goto L_0x01be;
                    case 34: goto L_0x01a4;
                    case 42: goto L_0x017d;
                    case 50: goto L_0x0163;
                    case 56: goto L_0x0155;
                    case 64: goto L_0x0147;
                    case 72: goto L_0x013a;
                    case 82: goto L_0x0120;
                    case 88: goto L_0x0104;
                    case 90: goto L_0x00d0;
                    case 242: goto L_0x00a7;
                    case 248: goto L_0x008b;
                    case 250: goto L_0x0058;
                    case 258: goto L_0x0032;
                    default: goto L_0x002c;
                }     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
            L_0x002c:
                boolean r5 = r13.f(r14, r2, r15, r10)     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                goto L_0x0206
            L_0x0032:
                int r10 = r13.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r10 = r10 & r8
                if (r10 != r8) goto L_0x003d
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Contract r10 = r13.contract_     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Contract$Builder r11 = r10.toBuilder()     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
            L_0x003d:
                kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Contract> r10 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Contract.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r10 = r14.readMessage(r10, (kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite) r15)     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Contract r10 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Contract) r10     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r13.contract_ = r10     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                if (r11 == 0) goto L_0x0052
                r11.mergeFrom((kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Contract) r10)     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Contract r10 = r11.buildPartial()     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r13.contract_ = r10     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
            L_0x0052:
                int r10 = r13.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r10 = r10 | r8
                r13.bitField0_ = r10     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                goto L_0x0018
            L_0x0058:
                int r10 = r14.readRawVarint32()     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                int r10 = r14.pushLimit(r10)     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r11 = r4 & 4096(0x1000, float:5.74E-42)
                if (r11 == r6) goto L_0x0073
                int r11 = r14.getBytesUntilLimit()     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                if (r11 <= 0) goto L_0x0073
                java.util.ArrayList r11 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r11.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r13.versionRequirement_ = r11     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r4 = r4 | 4096(0x1000, float:5.74E-42)
            L_0x0073:
                int r11 = r14.getBytesUntilLimit()     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                if (r11 <= 0) goto L_0x0087
                java.util.List<java.lang.Integer> r11 = r13.versionRequirement_     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                int r12 = r14.readInt32()     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r11.add(r12)     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                goto L_0x0073
            L_0x0087:
                r14.popLimit(r10)     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                goto L_0x0018
            L_0x008b:
                r10 = r4 & 4096(0x1000, float:5.74E-42)
                if (r10 == r6) goto L_0x0098
                java.util.ArrayList r10 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r10.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r13.versionRequirement_ = r10     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r4 = r4 | 4096(0x1000, float:5.74E-42)
            L_0x0098:
                java.util.List<java.lang.Integer> r10 = r13.versionRequirement_     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                int r11 = r14.readInt32()     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r10.add(r11)     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                goto L_0x0018
            L_0x00a7:
                int r10 = r13.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r12 = 128(0x80, float:1.794E-43)
                r10 = r10 & r12
                if (r10 != r12) goto L_0x00b4
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable r10 = r13.typeTable_     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable$Builder r11 = r10.toBuilder()     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
            L_0x00b4:
                kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable> r10 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeTable.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r10 = r14.readMessage(r10, (kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite) r15)     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable r10 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeTable) r10     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r13.typeTable_ = r10     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                if (r11 == 0) goto L_0x00c9
                r11.mergeFrom((kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeTable) r10)     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable r10 = r11.buildPartial()     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r13.typeTable_ = r10     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
            L_0x00c9:
                int r10 = r13.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r10 = r10 | r12
                r13.bitField0_ = r10     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                goto L_0x0018
            L_0x00d0:
                int r10 = r14.readRawVarint32()     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                int r10 = r14.pushLimit(r10)     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r11 = r4 & 512(0x200, float:7.175E-43)
                if (r11 == r7) goto L_0x00eb
                int r11 = r14.getBytesUntilLimit()     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                if (r11 <= 0) goto L_0x00eb
                java.util.ArrayList r11 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r11.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r13.contextReceiverTypeId_ = r11     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r4 = r4 | 512(0x200, float:7.175E-43)
            L_0x00eb:
                int r11 = r14.getBytesUntilLimit()     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                if (r11 <= 0) goto L_0x00ff
                java.util.List<java.lang.Integer> r11 = r13.contextReceiverTypeId_     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                int r12 = r14.readInt32()     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r11.add(r12)     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                goto L_0x00eb
            L_0x00ff:
                r14.popLimit(r10)     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                goto L_0x0018
            L_0x0104:
                r10 = r4 & 512(0x200, float:7.175E-43)
                if (r10 == r7) goto L_0x0111
                java.util.ArrayList r10 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r10.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r13.contextReceiverTypeId_ = r10     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r4 = r4 | 512(0x200, float:7.175E-43)
            L_0x0111:
                java.util.List<java.lang.Integer> r10 = r13.contextReceiverTypeId_     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                int r11 = r14.readInt32()     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r10.add(r11)     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                goto L_0x0018
            L_0x0120:
                r10 = r4 & 256(0x100, float:3.59E-43)
                if (r10 == r8) goto L_0x012d
                java.util.ArrayList r10 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r10.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r13.contextReceiverType_ = r10     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r4 = r4 | 256(0x100, float:3.59E-43)
            L_0x012d:
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type> r10 = r13.contextReceiverType_     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type> r11 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r11 = r14.readMessage(r11, (kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite) r15)     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r10.add(r11)     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                goto L_0x0018
            L_0x013a:
                int r10 = r13.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r10 = r10 | r1
                r13.bitField0_ = r10     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                int r10 = r14.readInt32()     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r13.flags_ = r10     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                goto L_0x0018
            L_0x0147:
                int r10 = r13.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r10 = r10 | 64
                r13.bitField0_ = r10     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                int r10 = r14.readInt32()     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r13.receiverTypeId_ = r10     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                goto L_0x0018
            L_0x0155:
                int r10 = r13.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r10 = r10 | 16
                r13.bitField0_ = r10     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                int r10 = r14.readInt32()     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r13.returnTypeId_ = r10     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                goto L_0x0018
            L_0x0163:
                r10 = r4 & 1024(0x400, float:1.435E-42)
                if (r10 == r5) goto L_0x0170
                java.util.ArrayList r10 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r10.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r13.valueParameter_ = r10     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r4 = r4 | 1024(0x400, float:1.435E-42)
            L_0x0170:
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter> r10 = r13.valueParameter_     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter> r11 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.ValueParameter.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r11 = r14.readMessage(r11, (kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite) r15)     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r10.add(r11)     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                goto L_0x0018
            L_0x017d:
                int r10 = r13.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r10 = r10 & r9
                if (r10 != r9) goto L_0x0188
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type r10 = r13.receiverType_     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type$Builder r11 = r10.toBuilder()     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
            L_0x0188:
                kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type> r10 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r10 = r14.readMessage(r10, (kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite) r15)     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type r10 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type) r10     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r13.receiverType_ = r10     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                if (r11 == 0) goto L_0x019d
                r11.mergeFrom((kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type) r10)     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type r10 = r11.buildPartial()     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r13.receiverType_ = r10     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
            L_0x019d:
                int r10 = r13.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r10 = r10 | r9
                r13.bitField0_ = r10     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                goto L_0x0018
            L_0x01a4:
                r10 = r4 & 32
                if (r10 == r9) goto L_0x01b1
                java.util.ArrayList r10 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r10.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r13.typeParameter_ = r10     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r4 = r4 | 32
            L_0x01b1:
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter> r10 = r13.typeParameter_     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter> r11 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeParameter.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r11 = r14.readMessage(r11, (kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite) r15)     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r10.add(r11)     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                goto L_0x0018
            L_0x01be:
                int r10 = r13.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r12 = 8
                r10 = r10 & r12
                if (r10 != r12) goto L_0x01cb
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type r10 = r13.returnType_     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type$Builder r11 = r10.toBuilder()     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
            L_0x01cb:
                kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type> r10 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r10 = r14.readMessage(r10, (kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite) r15)     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type r10 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type) r10     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r13.returnType_ = r10     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                if (r11 == 0) goto L_0x01e0
                r11.mergeFrom((kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type) r10)     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type r10 = r11.buildPartial()     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r13.returnType_ = r10     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
            L_0x01e0:
                int r10 = r13.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r10 = r10 | r12
                r13.bitField0_ = r10     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                goto L_0x0018
            L_0x01e7:
                int r10 = r13.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r10 = r10 | 4
                r13.bitField0_ = r10     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                int r10 = r14.readInt32()     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r13.name_ = r10     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                goto L_0x0018
            L_0x01f5:
                int r10 = r13.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r10 = r10 | 2
                r13.bitField0_ = r10     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                int r10 = r14.readInt32()     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                r13.oldFlags_ = r10     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020b }
                goto L_0x0018
            L_0x0203:
                r3 = r1
                goto L_0x0018
            L_0x0206:
                if (r5 != 0) goto L_0x0018
                goto L_0x0203
            L_0x0209:
                r14 = move-exception
                goto L_0x0220
            L_0x020b:
                r14 = move-exception
                kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException r15 = new kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException     // Catch:{ all -> 0x0209 }
                java.lang.String r14 = r14.getMessage()     // Catch:{ all -> 0x0209 }
                r15.<init>(r14)     // Catch:{ all -> 0x0209 }
                kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException r14 = r15.setUnfinishedMessage(r13)     // Catch:{ all -> 0x0209 }
                throw r14     // Catch:{ all -> 0x0209 }
            L_0x021a:
                r14 = move-exception
                kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException r14 = r14.setUnfinishedMessage(r13)     // Catch:{ all -> 0x0209 }
                throw r14     // Catch:{ all -> 0x0209 }
            L_0x0220:
                r15 = r4 & 32
                if (r15 != r9) goto L_0x022c
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter> r15 = r13.typeParameter_
                java.util.List r15 = java.util.Collections.unmodifiableList(r15)
                r13.typeParameter_ = r15
            L_0x022c:
                r15 = r4 & 1024(0x400, float:1.435E-42)
                if (r15 != r5) goto L_0x0238
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter> r15 = r13.valueParameter_
                java.util.List r15 = java.util.Collections.unmodifiableList(r15)
                r13.valueParameter_ = r15
            L_0x0238:
                r15 = r4 & 256(0x100, float:3.59E-43)
                if (r15 != r8) goto L_0x0244
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type> r15 = r13.contextReceiverType_
                java.util.List r15 = java.util.Collections.unmodifiableList(r15)
                r13.contextReceiverType_ = r15
            L_0x0244:
                r15 = r4 & 512(0x200, float:7.175E-43)
                if (r15 != r7) goto L_0x0250
                java.util.List<java.lang.Integer> r15 = r13.contextReceiverTypeId_
                java.util.List r15 = java.util.Collections.unmodifiableList(r15)
                r13.contextReceiverTypeId_ = r15
            L_0x0250:
                r15 = r4 & 4096(0x1000, float:5.74E-42)
                if (r15 != r6) goto L_0x025c
                java.util.List<java.lang.Integer> r15 = r13.versionRequirement_
                java.util.List r15 = java.util.Collections.unmodifiableList(r15)
                r13.versionRequirement_ = r15
            L_0x025c:
                r2.flush()     // Catch:{ IOException -> 0x025f, all -> 0x0266 }
            L_0x025f:
                kotlin.reflect.jvm.internal.impl.protobuf.ByteString r15 = r0.toByteString()
                r13.unknownFields = r15
                goto L_0x026e
            L_0x0266:
                r14 = move-exception
                kotlin.reflect.jvm.internal.impl.protobuf.ByteString r15 = r0.toByteString()
                r13.unknownFields = r15
                throw r14
            L_0x026e:
                r13.e()
                throw r14
            L_0x0272:
                r14 = r4 & 32
                if (r14 != r9) goto L_0x027e
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter> r14 = r13.typeParameter_
                java.util.List r14 = java.util.Collections.unmodifiableList(r14)
                r13.typeParameter_ = r14
            L_0x027e:
                r14 = r4 & 1024(0x400, float:1.435E-42)
                if (r14 != r5) goto L_0x028a
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter> r14 = r13.valueParameter_
                java.util.List r14 = java.util.Collections.unmodifiableList(r14)
                r13.valueParameter_ = r14
            L_0x028a:
                r14 = r4 & 256(0x100, float:3.59E-43)
                if (r14 != r8) goto L_0x0296
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type> r14 = r13.contextReceiverType_
                java.util.List r14 = java.util.Collections.unmodifiableList(r14)
                r13.contextReceiverType_ = r14
            L_0x0296:
                r14 = r4 & 512(0x200, float:7.175E-43)
                if (r14 != r7) goto L_0x02a2
                java.util.List<java.lang.Integer> r14 = r13.contextReceiverTypeId_
                java.util.List r14 = java.util.Collections.unmodifiableList(r14)
                r13.contextReceiverTypeId_ = r14
            L_0x02a2:
                r14 = r4 & 4096(0x1000, float:5.74E-42)
                if (r14 != r6) goto L_0x02ae
                java.util.List<java.lang.Integer> r14 = r13.versionRequirement_
                java.util.List r14 = java.util.Collections.unmodifiableList(r14)
                r13.versionRequirement_ = r14
            L_0x02ae:
                r2.flush()     // Catch:{ IOException -> 0x02b1, all -> 0x02b8 }
            L_0x02b1:
                kotlin.reflect.jvm.internal.impl.protobuf.ByteString r14 = r0.toByteString()
                r13.unknownFields = r14
                goto L_0x02c0
            L_0x02b8:
                r14 = move-exception
                kotlin.reflect.jvm.internal.impl.protobuf.ByteString r15 = r0.toByteString()
                r13.unknownFields = r15
                throw r14
            L_0x02c0:
                r13.e()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function.<init>(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite):void");
        }
    }

    public interface FunctionOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder {
    }

    public enum MemberKind implements Internal.EnumLite {
        DECLARATION(0, 0),
        FAKE_OVERRIDE(1, 1),
        DELEGATION(2, 2),
        SYNTHESIZED(3, 3);
        
        private static Internal.EnumLiteMap<MemberKind> internalValueMap;
        private final int value;

        /* access modifiers changed from: public */
        static {
            internalValueMap = new Internal.EnumLiteMap<MemberKind>() {
                public MemberKind findValueByNumber(int i11) {
                    return MemberKind.valueOf(i11);
                }
            };
        }

        private MemberKind(int i11, int i12) {
            this.value = i12;
        }

        public final int getNumber() {
            return this.value;
        }

        public static MemberKind valueOf(int i11) {
            if (i11 == 0) {
                return DECLARATION;
            }
            if (i11 == 1) {
                return FAKE_OVERRIDE;
            }
            if (i11 == 2) {
                return DELEGATION;
            }
            if (i11 != 3) {
                return null;
            }
            return SYNTHESIZED;
        }
    }

    public enum Modality implements Internal.EnumLite {
        FINAL(0, 0),
        OPEN(1, 1),
        ABSTRACT(2, 2),
        SEALED(3, 3);
        
        private static Internal.EnumLiteMap<Modality> internalValueMap;
        private final int value;

        /* access modifiers changed from: public */
        static {
            internalValueMap = new Internal.EnumLiteMap<Modality>() {
                public Modality findValueByNumber(int i11) {
                    return Modality.valueOf(i11);
                }
            };
        }

        private Modality(int i11, int i12) {
            this.value = i12;
        }

        public final int getNumber() {
            return this.value;
        }

        public static Modality valueOf(int i11) {
            if (i11 == 0) {
                return FINAL;
            }
            if (i11 == 1) {
                return OPEN;
            }
            if (i11 == 2) {
                return ABSTRACT;
            }
            if (i11 != 3) {
                return null;
            }
            return SEALED;
        }
    }

    public static final class Package extends GeneratedMessageLite.ExtendableMessage<Package> implements PackageOrBuilder {
        public static Parser<Package> PARSER = new AbstractParser<Package>() {
            public Package parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Package(codedInputStream, extensionRegistryLite);
            }
        };
        private static final Package defaultInstance;
        /* access modifiers changed from: private */
        public int bitField0_;
        /* access modifiers changed from: private */
        public List<Function> function_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        /* access modifiers changed from: private */
        public List<Property> property_;
        /* access modifiers changed from: private */
        public List<TypeAlias> typeAlias_;
        /* access modifiers changed from: private */
        public TypeTable typeTable_;
        /* access modifiers changed from: private */
        public final ByteString unknownFields;
        /* access modifiers changed from: private */
        public VersionRequirementTable versionRequirementTable_;

        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<Package, Builder> implements PackageOrBuilder {
            private int bitField0_;
            private List<Function> function_ = Collections.emptyList();
            private List<Property> property_ = Collections.emptyList();
            private List<TypeAlias> typeAlias_ = Collections.emptyList();
            private TypeTable typeTable_ = TypeTable.getDefaultInstance();
            private VersionRequirementTable versionRequirementTable_ = VersionRequirementTable.getDefaultInstance();

            private Builder() {
                maybeForceBuilderInitialization();
            }

            /* access modifiers changed from: private */
            public static Builder create() {
                return new Builder();
            }

            private void ensureFunctionIsMutable() {
                if ((this.bitField0_ & 1) != 1) {
                    this.function_ = new ArrayList(this.function_);
                    this.bitField0_ |= 1;
                }
            }

            private void ensurePropertyIsMutable() {
                if ((this.bitField0_ & 2) != 2) {
                    this.property_ = new ArrayList(this.property_);
                    this.bitField0_ |= 2;
                }
            }

            private void ensureTypeAliasIsMutable() {
                if ((this.bitField0_ & 4) != 4) {
                    this.typeAlias_ = new ArrayList(this.typeAlias_);
                    this.bitField0_ |= 4;
                }
            }

            private void maybeForceBuilderInitialization() {
            }

            public Package buildPartial() {
                Package packageR = new Package((GeneratedMessageLite.ExtendableBuilder) this);
                int i11 = this.bitField0_;
                int i12 = 1;
                if ((i11 & 1) == 1) {
                    this.function_ = Collections.unmodifiableList(this.function_);
                    this.bitField0_ &= -2;
                }
                List unused = packageR.function_ = this.function_;
                if ((this.bitField0_ & 2) == 2) {
                    this.property_ = Collections.unmodifiableList(this.property_);
                    this.bitField0_ &= -3;
                }
                List unused2 = packageR.property_ = this.property_;
                if ((this.bitField0_ & 4) == 4) {
                    this.typeAlias_ = Collections.unmodifiableList(this.typeAlias_);
                    this.bitField0_ &= -5;
                }
                List unused3 = packageR.typeAlias_ = this.typeAlias_;
                if ((i11 & 8) != 8) {
                    i12 = 0;
                }
                TypeTable unused4 = packageR.typeTable_ = this.typeTable_;
                if ((i11 & 16) == 16) {
                    i12 |= 2;
                }
                VersionRequirementTable unused5 = packageR.versionRequirementTable_ = this.versionRequirementTable_;
                int unused6 = packageR.bitField0_ = i12;
                return packageR;
            }

            public Function getFunction(int i11) {
                return this.function_.get(i11);
            }

            public int getFunctionCount() {
                return this.function_.size();
            }

            public Property getProperty(int i11) {
                return this.property_.get(i11);
            }

            public int getPropertyCount() {
                return this.property_.size();
            }

            public TypeAlias getTypeAlias(int i11) {
                return this.typeAlias_.get(i11);
            }

            public int getTypeAliasCount() {
                return this.typeAlias_.size();
            }

            public TypeTable getTypeTable() {
                return this.typeTable_;
            }

            public boolean hasTypeTable() {
                return (this.bitField0_ & 8) == 8;
            }

            public final boolean isInitialized() {
                for (int i11 = 0; i11 < getFunctionCount(); i11++) {
                    if (!getFunction(i11).isInitialized()) {
                        return false;
                    }
                }
                for (int i12 = 0; i12 < getPropertyCount(); i12++) {
                    if (!getProperty(i12).isInitialized()) {
                        return false;
                    }
                }
                for (int i13 = 0; i13 < getTypeAliasCount(); i13++) {
                    if (!getTypeAlias(i13).isInitialized()) {
                        return false;
                    }
                }
                if ((!hasTypeTable() || getTypeTable().isInitialized()) && c()) {
                    return true;
                }
                return false;
            }

            public Builder mergeTypeTable(TypeTable typeTable) {
                if ((this.bitField0_ & 8) != 8 || this.typeTable_ == TypeTable.getDefaultInstance()) {
                    this.typeTable_ = typeTable;
                } else {
                    this.typeTable_ = TypeTable.newBuilder(this.typeTable_).mergeFrom(typeTable).buildPartial();
                }
                this.bitField0_ |= 8;
                return this;
            }

            public Builder mergeVersionRequirementTable(VersionRequirementTable versionRequirementTable) {
                if ((this.bitField0_ & 16) != 16 || this.versionRequirementTable_ == VersionRequirementTable.getDefaultInstance()) {
                    this.versionRequirementTable_ = versionRequirementTable;
                } else {
                    this.versionRequirementTable_ = VersionRequirementTable.newBuilder(this.versionRequirementTable_).mergeFrom(versionRequirementTable).buildPartial();
                }
                this.bitField0_ |= 16;
                return this;
            }

            public Package build() {
                Package buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.a(buildPartial);
            }

            public Package getDefaultInstanceForType() {
                return Package.getDefaultInstance();
            }

            public Builder mergeFrom(Package packageR) {
                if (packageR == Package.getDefaultInstance()) {
                    return this;
                }
                if (!packageR.function_.isEmpty()) {
                    if (this.function_.isEmpty()) {
                        this.function_ = packageR.function_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureFunctionIsMutable();
                        this.function_.addAll(packageR.function_);
                    }
                }
                if (!packageR.property_.isEmpty()) {
                    if (this.property_.isEmpty()) {
                        this.property_ = packageR.property_;
                        this.bitField0_ &= -3;
                    } else {
                        ensurePropertyIsMutable();
                        this.property_.addAll(packageR.property_);
                    }
                }
                if (!packageR.typeAlias_.isEmpty()) {
                    if (this.typeAlias_.isEmpty()) {
                        this.typeAlias_ = packageR.typeAlias_;
                        this.bitField0_ &= -5;
                    } else {
                        ensureTypeAliasIsMutable();
                        this.typeAlias_.addAll(packageR.typeAlias_);
                    }
                }
                if (packageR.hasTypeTable()) {
                    mergeTypeTable(packageR.getTypeTable());
                }
                if (packageR.hasVersionRequirementTable()) {
                    mergeVersionRequirementTable(packageR.getVersionRequirementTable());
                }
                d(packageR);
                setUnknownFields(getUnknownFields().concat(packageR.unknownFields));
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                Package packageR;
                Package packageR2 = null;
                try {
                    Package parsePartialFrom = Package.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e11) {
                    packageR = (Package) e11.getUnfinishedMessage();
                    throw e11;
                } catch (Throwable th2) {
                    th = th2;
                    packageR2 = packageR;
                }
                if (packageR2 != null) {
                    mergeFrom(packageR2);
                }
                throw th;
            }
        }

        static {
            Package packageR = new Package(true);
            defaultInstance = packageR;
            packageR.initFields();
        }

        public static Package getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.function_ = Collections.emptyList();
            this.property_ = Collections.emptyList();
            this.typeAlias_ = Collections.emptyList();
            this.typeTable_ = TypeTable.getDefaultInstance();
            this.versionRequirementTable_ = VersionRequirementTable.getDefaultInstance();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public static Package parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public Function getFunction(int i11) {
            return this.function_.get(i11);
        }

        public int getFunctionCount() {
            return this.function_.size();
        }

        public List<Function> getFunctionList() {
            return this.function_;
        }

        public Parser<Package> getParserForType() {
            return PARSER;
        }

        public Property getProperty(int i11) {
            return this.property_.get(i11);
        }

        public int getPropertyCount() {
            return this.property_.size();
        }

        public List<Property> getPropertyList() {
            return this.property_;
        }

        public int getSerializedSize() {
            int i11 = this.memoizedSerializedSize;
            if (i11 != -1) {
                return i11;
            }
            int i12 = 0;
            for (int i13 = 0; i13 < this.function_.size(); i13++) {
                i12 += CodedOutputStream.computeMessageSize(3, this.function_.get(i13));
            }
            for (int i14 = 0; i14 < this.property_.size(); i14++) {
                i12 += CodedOutputStream.computeMessageSize(4, this.property_.get(i14));
            }
            for (int i15 = 0; i15 < this.typeAlias_.size(); i15++) {
                i12 += CodedOutputStream.computeMessageSize(5, this.typeAlias_.get(i15));
            }
            if ((this.bitField0_ & 1) == 1) {
                i12 += CodedOutputStream.computeMessageSize(30, this.typeTable_);
            }
            if ((this.bitField0_ & 2) == 2) {
                i12 += CodedOutputStream.computeMessageSize(32, this.versionRequirementTable_);
            }
            int i16 = i12 + i() + this.unknownFields.size();
            this.memoizedSerializedSize = i16;
            return i16;
        }

        public TypeAlias getTypeAlias(int i11) {
            return this.typeAlias_.get(i11);
        }

        public int getTypeAliasCount() {
            return this.typeAlias_.size();
        }

        public List<TypeAlias> getTypeAliasList() {
            return this.typeAlias_;
        }

        public TypeTable getTypeTable() {
            return this.typeTable_;
        }

        public VersionRequirementTable getVersionRequirementTable() {
            return this.versionRequirementTable_;
        }

        public boolean hasTypeTable() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean hasVersionRequirementTable() {
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
            for (int i11 = 0; i11 < getFunctionCount(); i11++) {
                if (!getFunction(i11).isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            for (int i12 = 0; i12 < getPropertyCount(); i12++) {
                if (!getProperty(i12).isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            for (int i13 = 0; i13 < getTypeAliasCount(); i13++) {
                if (!getTypeAlias(i13).isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            if (hasTypeTable() && !getTypeTable().isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            } else if (!h()) {
                this.memoizedIsInitialized = 0;
                return false;
            } else {
                this.memoizedIsInitialized = 1;
                return true;
            }
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter j11 = j();
            for (int i11 = 0; i11 < this.function_.size(); i11++) {
                codedOutputStream.writeMessage(3, this.function_.get(i11));
            }
            for (int i12 = 0; i12 < this.property_.size(); i12++) {
                codedOutputStream.writeMessage(4, this.property_.get(i12));
            }
            for (int i13 = 0; i13 < this.typeAlias_.size(); i13++) {
                codedOutputStream.writeMessage(5, this.typeAlias_.get(i13));
            }
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeMessage(30, this.typeTable_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeMessage(32, this.versionRequirementTable_);
            }
            j11.writeUntil(200, codedOutputStream);
            codedOutputStream.writeRawBytes(this.unknownFields);
        }

        public static Builder newBuilder(Package packageR) {
            return newBuilder().mergeFrom(packageR);
        }

        public Package getDefaultInstanceForType() {
            return defaultInstance;
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        private Package(GeneratedMessageLite.ExtendableBuilder<Package, ?> extendableBuilder) {
            super(extendableBuilder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = extendableBuilder.getUnknownFields();
        }

        private Package(boolean z11) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v1, resolved type: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable$Builder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v3, resolved type: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable$Builder} */
        /* JADX WARNING: type inference failed for: r9v0 */
        /* JADX WARNING: type inference failed for: r9v5 */
        /* JADX WARNING: type inference failed for: r9v6 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private Package(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream r11, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite r12) throws kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException {
            /*
                r10 = this;
                r10.<init>()
                r0 = -1
                r10.memoizedIsInitialized = r0
                r10.memoizedSerializedSize = r0
                r10.initFields()
                kotlin.reflect.jvm.internal.impl.protobuf.ByteString$Output r0 = kotlin.reflect.jvm.internal.impl.protobuf.ByteString.newOutput()
                r1 = 1
                kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream r2 = kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream.newInstance(r0, r1)
                r3 = 0
                r4 = r3
            L_0x0016:
                r5 = 4
                r6 = 2
                if (r3 != 0) goto L_0x012b
                int r7 = r11.readTag()     // Catch:{ InvalidProtocolBufferException -> 0x00eb, IOException -> 0x00dc }
                if (r7 == 0) goto L_0x00d7
                r8 = 26
                if (r7 == r8) goto L_0x00bd
                r8 = 34
                if (r7 == r8) goto L_0x00a3
                r8 = 42
                if (r7 == r8) goto L_0x0089
                r8 = 242(0xf2, float:3.39E-43)
                r9 = 0
                if (r7 == r8) goto L_0x0063
                r8 = 258(0x102, float:3.62E-43)
                if (r7 == r8) goto L_0x003d
                boolean r5 = r10.f(r11, r2, r12, r7)     // Catch:{ InvalidProtocolBufferException -> 0x00eb, IOException -> 0x00dc }
                if (r5 != 0) goto L_0x0016
                goto L_0x00d7
            L_0x003d:
                int r7 = r10.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x00eb, IOException -> 0x00dc }
                r7 = r7 & r6
                if (r7 != r6) goto L_0x0048
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable r7 = r10.versionRequirementTable_     // Catch:{ InvalidProtocolBufferException -> 0x00eb, IOException -> 0x00dc }
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable$Builder r9 = r7.toBuilder()     // Catch:{ InvalidProtocolBufferException -> 0x00eb, IOException -> 0x00dc }
            L_0x0048:
                kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable> r7 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.VersionRequirementTable.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x00eb, IOException -> 0x00dc }
                kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r7 = r11.readMessage(r7, (kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite) r12)     // Catch:{ InvalidProtocolBufferException -> 0x00eb, IOException -> 0x00dc }
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable r7 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.VersionRequirementTable) r7     // Catch:{ InvalidProtocolBufferException -> 0x00eb, IOException -> 0x00dc }
                r10.versionRequirementTable_ = r7     // Catch:{ InvalidProtocolBufferException -> 0x00eb, IOException -> 0x00dc }
                if (r9 == 0) goto L_0x005d
                r9.mergeFrom((kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.VersionRequirementTable) r7)     // Catch:{ InvalidProtocolBufferException -> 0x00eb, IOException -> 0x00dc }
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable r7 = r9.buildPartial()     // Catch:{ InvalidProtocolBufferException -> 0x00eb, IOException -> 0x00dc }
                r10.versionRequirementTable_ = r7     // Catch:{ InvalidProtocolBufferException -> 0x00eb, IOException -> 0x00dc }
            L_0x005d:
                int r7 = r10.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x00eb, IOException -> 0x00dc }
                r7 = r7 | r6
                r10.bitField0_ = r7     // Catch:{ InvalidProtocolBufferException -> 0x00eb, IOException -> 0x00dc }
                goto L_0x0016
            L_0x0063:
                int r7 = r10.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x00eb, IOException -> 0x00dc }
                r7 = r7 & r1
                if (r7 != r1) goto L_0x006e
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable r7 = r10.typeTable_     // Catch:{ InvalidProtocolBufferException -> 0x00eb, IOException -> 0x00dc }
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable$Builder r9 = r7.toBuilder()     // Catch:{ InvalidProtocolBufferException -> 0x00eb, IOException -> 0x00dc }
            L_0x006e:
                kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable> r7 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeTable.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x00eb, IOException -> 0x00dc }
                kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r7 = r11.readMessage(r7, (kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite) r12)     // Catch:{ InvalidProtocolBufferException -> 0x00eb, IOException -> 0x00dc }
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable r7 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeTable) r7     // Catch:{ InvalidProtocolBufferException -> 0x00eb, IOException -> 0x00dc }
                r10.typeTable_ = r7     // Catch:{ InvalidProtocolBufferException -> 0x00eb, IOException -> 0x00dc }
                if (r9 == 0) goto L_0x0083
                r9.mergeFrom((kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeTable) r7)     // Catch:{ InvalidProtocolBufferException -> 0x00eb, IOException -> 0x00dc }
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable r7 = r9.buildPartial()     // Catch:{ InvalidProtocolBufferException -> 0x00eb, IOException -> 0x00dc }
                r10.typeTable_ = r7     // Catch:{ InvalidProtocolBufferException -> 0x00eb, IOException -> 0x00dc }
            L_0x0083:
                int r7 = r10.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x00eb, IOException -> 0x00dc }
                r7 = r7 | r1
                r10.bitField0_ = r7     // Catch:{ InvalidProtocolBufferException -> 0x00eb, IOException -> 0x00dc }
                goto L_0x0016
            L_0x0089:
                r7 = r4 & 4
                if (r7 == r5) goto L_0x0096
                java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x00eb, IOException -> 0x00dc }
                r7.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x00eb, IOException -> 0x00dc }
                r10.typeAlias_ = r7     // Catch:{ InvalidProtocolBufferException -> 0x00eb, IOException -> 0x00dc }
                r4 = r4 | 4
            L_0x0096:
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias> r7 = r10.typeAlias_     // Catch:{ InvalidProtocolBufferException -> 0x00eb, IOException -> 0x00dc }
                kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias> r8 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeAlias.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x00eb, IOException -> 0x00dc }
                kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r8 = r11.readMessage(r8, (kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite) r12)     // Catch:{ InvalidProtocolBufferException -> 0x00eb, IOException -> 0x00dc }
                r7.add(r8)     // Catch:{ InvalidProtocolBufferException -> 0x00eb, IOException -> 0x00dc }
                goto L_0x0016
            L_0x00a3:
                r7 = r4 & 2
                if (r7 == r6) goto L_0x00b0
                java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x00eb, IOException -> 0x00dc }
                r7.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x00eb, IOException -> 0x00dc }
                r10.property_ = r7     // Catch:{ InvalidProtocolBufferException -> 0x00eb, IOException -> 0x00dc }
                r4 = r4 | 2
            L_0x00b0:
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property> r7 = r10.property_     // Catch:{ InvalidProtocolBufferException -> 0x00eb, IOException -> 0x00dc }
                kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property> r8 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x00eb, IOException -> 0x00dc }
                kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r8 = r11.readMessage(r8, (kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite) r12)     // Catch:{ InvalidProtocolBufferException -> 0x00eb, IOException -> 0x00dc }
                r7.add(r8)     // Catch:{ InvalidProtocolBufferException -> 0x00eb, IOException -> 0x00dc }
                goto L_0x0016
            L_0x00bd:
                r7 = r4 & 1
                if (r7 == r1) goto L_0x00ca
                java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x00eb, IOException -> 0x00dc }
                r7.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x00eb, IOException -> 0x00dc }
                r10.function_ = r7     // Catch:{ InvalidProtocolBufferException -> 0x00eb, IOException -> 0x00dc }
                r4 = r4 | 1
            L_0x00ca:
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function> r7 = r10.function_     // Catch:{ InvalidProtocolBufferException -> 0x00eb, IOException -> 0x00dc }
                kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function> r8 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x00eb, IOException -> 0x00dc }
                kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r8 = r11.readMessage(r8, (kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite) r12)     // Catch:{ InvalidProtocolBufferException -> 0x00eb, IOException -> 0x00dc }
                r7.add(r8)     // Catch:{ InvalidProtocolBufferException -> 0x00eb, IOException -> 0x00dc }
                goto L_0x0016
            L_0x00d7:
                r3 = r1
                goto L_0x0016
            L_0x00da:
                r11 = move-exception
                goto L_0x00f1
            L_0x00dc:
                r11 = move-exception
                kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException r12 = new kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException     // Catch:{ all -> 0x00da }
                java.lang.String r11 = r11.getMessage()     // Catch:{ all -> 0x00da }
                r12.<init>(r11)     // Catch:{ all -> 0x00da }
                kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException r11 = r12.setUnfinishedMessage(r10)     // Catch:{ all -> 0x00da }
                throw r11     // Catch:{ all -> 0x00da }
            L_0x00eb:
                r11 = move-exception
                kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException r11 = r11.setUnfinishedMessage(r10)     // Catch:{ all -> 0x00da }
                throw r11     // Catch:{ all -> 0x00da }
            L_0x00f1:
                r12 = r4 & 1
                if (r12 != r1) goto L_0x00fd
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function> r12 = r10.function_
                java.util.List r12 = java.util.Collections.unmodifiableList(r12)
                r10.function_ = r12
            L_0x00fd:
                r12 = r4 & 2
                if (r12 != r6) goto L_0x0109
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property> r12 = r10.property_
                java.util.List r12 = java.util.Collections.unmodifiableList(r12)
                r10.property_ = r12
            L_0x0109:
                r12 = r4 & 4
                if (r12 != r5) goto L_0x0115
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias> r12 = r10.typeAlias_
                java.util.List r12 = java.util.Collections.unmodifiableList(r12)
                r10.typeAlias_ = r12
            L_0x0115:
                r2.flush()     // Catch:{ IOException -> 0x0118, all -> 0x011f }
            L_0x0118:
                kotlin.reflect.jvm.internal.impl.protobuf.ByteString r12 = r0.toByteString()
                r10.unknownFields = r12
                goto L_0x0127
            L_0x011f:
                r11 = move-exception
                kotlin.reflect.jvm.internal.impl.protobuf.ByteString r12 = r0.toByteString()
                r10.unknownFields = r12
                throw r11
            L_0x0127:
                r10.e()
                throw r11
            L_0x012b:
                r11 = r4 & 1
                if (r11 != r1) goto L_0x0137
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function> r11 = r10.function_
                java.util.List r11 = java.util.Collections.unmodifiableList(r11)
                r10.function_ = r11
            L_0x0137:
                r11 = r4 & 2
                if (r11 != r6) goto L_0x0143
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property> r11 = r10.property_
                java.util.List r11 = java.util.Collections.unmodifiableList(r11)
                r10.property_ = r11
            L_0x0143:
                r11 = r4 & 4
                if (r11 != r5) goto L_0x014f
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias> r11 = r10.typeAlias_
                java.util.List r11 = java.util.Collections.unmodifiableList(r11)
                r10.typeAlias_ = r11
            L_0x014f:
                r2.flush()     // Catch:{ IOException -> 0x0152, all -> 0x0159 }
            L_0x0152:
                kotlin.reflect.jvm.internal.impl.protobuf.ByteString r11 = r0.toByteString()
                r10.unknownFields = r11
                goto L_0x0161
            L_0x0159:
                r11 = move-exception
                kotlin.reflect.jvm.internal.impl.protobuf.ByteString r12 = r0.toByteString()
                r10.unknownFields = r12
                throw r11
            L_0x0161:
                r10.e()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Package.<init>(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite):void");
        }
    }

    public static final class PackageFragment extends GeneratedMessageLite.ExtendableMessage<PackageFragment> implements PackageFragmentOrBuilder {
        public static Parser<PackageFragment> PARSER = new AbstractParser<PackageFragment>() {
            public PackageFragment parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new PackageFragment(codedInputStream, extensionRegistryLite);
            }
        };
        private static final PackageFragment defaultInstance;
        /* access modifiers changed from: private */
        public int bitField0_;
        /* access modifiers changed from: private */
        public List<Class> class__;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        /* access modifiers changed from: private */
        public Package package_;
        /* access modifiers changed from: private */
        public QualifiedNameTable qualifiedNames_;
        /* access modifiers changed from: private */
        public StringTable strings_;
        /* access modifiers changed from: private */
        public final ByteString unknownFields;

        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<PackageFragment, Builder> implements PackageFragmentOrBuilder {
            private int bitField0_;
            private List<Class> class__ = Collections.emptyList();
            private Package package_ = Package.getDefaultInstance();
            private QualifiedNameTable qualifiedNames_ = QualifiedNameTable.getDefaultInstance();
            private StringTable strings_ = StringTable.getDefaultInstance();

            private Builder() {
                maybeForceBuilderInitialization();
            }

            /* access modifiers changed from: private */
            public static Builder create() {
                return new Builder();
            }

            private void ensureClass_IsMutable() {
                if ((this.bitField0_ & 8) != 8) {
                    this.class__ = new ArrayList(this.class__);
                    this.bitField0_ |= 8;
                }
            }

            private void maybeForceBuilderInitialization() {
            }

            public PackageFragment buildPartial() {
                PackageFragment packageFragment = new PackageFragment((GeneratedMessageLite.ExtendableBuilder) this);
                int i11 = this.bitField0_;
                int i12 = 1;
                if ((i11 & 1) != 1) {
                    i12 = 0;
                }
                StringTable unused = packageFragment.strings_ = this.strings_;
                if ((i11 & 2) == 2) {
                    i12 |= 2;
                }
                QualifiedNameTable unused2 = packageFragment.qualifiedNames_ = this.qualifiedNames_;
                if ((i11 & 4) == 4) {
                    i12 |= 4;
                }
                Package unused3 = packageFragment.package_ = this.package_;
                if ((this.bitField0_ & 8) == 8) {
                    this.class__ = Collections.unmodifiableList(this.class__);
                    this.bitField0_ &= -9;
                }
                List unused4 = packageFragment.class__ = this.class__;
                int unused5 = packageFragment.bitField0_ = i12;
                return packageFragment;
            }

            public Class getClass_(int i11) {
                return this.class__.get(i11);
            }

            public int getClass_Count() {
                return this.class__.size();
            }

            public Package getPackage() {
                return this.package_;
            }

            public QualifiedNameTable getQualifiedNames() {
                return this.qualifiedNames_;
            }

            public boolean hasPackage() {
                return (this.bitField0_ & 4) == 4;
            }

            public boolean hasQualifiedNames() {
                return (this.bitField0_ & 2) == 2;
            }

            public final boolean isInitialized() {
                if (hasQualifiedNames() && !getQualifiedNames().isInitialized()) {
                    return false;
                }
                if (hasPackage() && !getPackage().isInitialized()) {
                    return false;
                }
                for (int i11 = 0; i11 < getClass_Count(); i11++) {
                    if (!getClass_(i11).isInitialized()) {
                        return false;
                    }
                }
                if (!c()) {
                    return false;
                }
                return true;
            }

            public Builder mergePackage(Package packageR) {
                if ((this.bitField0_ & 4) != 4 || this.package_ == Package.getDefaultInstance()) {
                    this.package_ = packageR;
                } else {
                    this.package_ = Package.newBuilder(this.package_).mergeFrom(packageR).buildPartial();
                }
                this.bitField0_ |= 4;
                return this;
            }

            public Builder mergeQualifiedNames(QualifiedNameTable qualifiedNameTable) {
                if ((this.bitField0_ & 2) != 2 || this.qualifiedNames_ == QualifiedNameTable.getDefaultInstance()) {
                    this.qualifiedNames_ = qualifiedNameTable;
                } else {
                    this.qualifiedNames_ = QualifiedNameTable.newBuilder(this.qualifiedNames_).mergeFrom(qualifiedNameTable).buildPartial();
                }
                this.bitField0_ |= 2;
                return this;
            }

            public Builder mergeStrings(StringTable stringTable) {
                if ((this.bitField0_ & 1) != 1 || this.strings_ == StringTable.getDefaultInstance()) {
                    this.strings_ = stringTable;
                } else {
                    this.strings_ = StringTable.newBuilder(this.strings_).mergeFrom(stringTable).buildPartial();
                }
                this.bitField0_ |= 1;
                return this;
            }

            public PackageFragment build() {
                PackageFragment buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.a(buildPartial);
            }

            public PackageFragment getDefaultInstanceForType() {
                return PackageFragment.getDefaultInstance();
            }

            public Builder mergeFrom(PackageFragment packageFragment) {
                if (packageFragment == PackageFragment.getDefaultInstance()) {
                    return this;
                }
                if (packageFragment.hasStrings()) {
                    mergeStrings(packageFragment.getStrings());
                }
                if (packageFragment.hasQualifiedNames()) {
                    mergeQualifiedNames(packageFragment.getQualifiedNames());
                }
                if (packageFragment.hasPackage()) {
                    mergePackage(packageFragment.getPackage());
                }
                if (!packageFragment.class__.isEmpty()) {
                    if (this.class__.isEmpty()) {
                        this.class__ = packageFragment.class__;
                        this.bitField0_ &= -9;
                    } else {
                        ensureClass_IsMutable();
                        this.class__.addAll(packageFragment.class__);
                    }
                }
                d(packageFragment);
                setUnknownFields(getUnknownFields().concat(packageFragment.unknownFields));
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                PackageFragment packageFragment;
                PackageFragment packageFragment2 = null;
                try {
                    PackageFragment parsePartialFrom = PackageFragment.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e11) {
                    packageFragment = (PackageFragment) e11.getUnfinishedMessage();
                    throw e11;
                } catch (Throwable th2) {
                    th = th2;
                    packageFragment2 = packageFragment;
                }
                if (packageFragment2 != null) {
                    mergeFrom(packageFragment2);
                }
                throw th;
            }
        }

        static {
            PackageFragment packageFragment = new PackageFragment(true);
            defaultInstance = packageFragment;
            packageFragment.initFields();
        }

        public static PackageFragment getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.strings_ = StringTable.getDefaultInstance();
            this.qualifiedNames_ = QualifiedNameTable.getDefaultInstance();
            this.package_ = Package.getDefaultInstance();
            this.class__ = Collections.emptyList();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public static PackageFragment parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public Class getClass_(int i11) {
            return this.class__.get(i11);
        }

        public int getClass_Count() {
            return this.class__.size();
        }

        public List<Class> getClass_List() {
            return this.class__;
        }

        public Package getPackage() {
            return this.package_;
        }

        public Parser<PackageFragment> getParserForType() {
            return PARSER;
        }

        public QualifiedNameTable getQualifiedNames() {
            return this.qualifiedNames_;
        }

        public int getSerializedSize() {
            int i11;
            int i12 = this.memoizedSerializedSize;
            if (i12 != -1) {
                return i12;
            }
            if ((this.bitField0_ & 1) == 1) {
                i11 = CodedOutputStream.computeMessageSize(1, this.strings_) + 0;
            } else {
                i11 = 0;
            }
            if ((this.bitField0_ & 2) == 2) {
                i11 += CodedOutputStream.computeMessageSize(2, this.qualifiedNames_);
            }
            if ((this.bitField0_ & 4) == 4) {
                i11 += CodedOutputStream.computeMessageSize(3, this.package_);
            }
            for (int i13 = 0; i13 < this.class__.size(); i13++) {
                i11 += CodedOutputStream.computeMessageSize(4, this.class__.get(i13));
            }
            int i14 = i11 + i() + this.unknownFields.size();
            this.memoizedSerializedSize = i14;
            return i14;
        }

        public StringTable getStrings() {
            return this.strings_;
        }

        public boolean hasPackage() {
            return (this.bitField0_ & 4) == 4;
        }

        public boolean hasQualifiedNames() {
            return (this.bitField0_ & 2) == 2;
        }

        public boolean hasStrings() {
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
            if (hasQualifiedNames() && !getQualifiedNames().isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            } else if (!hasPackage() || getPackage().isInitialized()) {
                for (int i11 = 0; i11 < getClass_Count(); i11++) {
                    if (!getClass_(i11).isInitialized()) {
                        this.memoizedIsInitialized = 0;
                        return false;
                    }
                }
                if (!h()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
                this.memoizedIsInitialized = 1;
                return true;
            } else {
                this.memoizedIsInitialized = 0;
                return false;
            }
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter j11 = j();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeMessage(1, this.strings_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeMessage(2, this.qualifiedNames_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeMessage(3, this.package_);
            }
            for (int i11 = 0; i11 < this.class__.size(); i11++) {
                codedOutputStream.writeMessage(4, this.class__.get(i11));
            }
            j11.writeUntil(200, codedOutputStream);
            codedOutputStream.writeRawBytes(this.unknownFields);
        }

        public static Builder newBuilder(PackageFragment packageFragment) {
            return newBuilder().mergeFrom(packageFragment);
        }

        public PackageFragment getDefaultInstanceForType() {
            return defaultInstance;
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        private PackageFragment(GeneratedMessageLite.ExtendableBuilder<PackageFragment, ?> extendableBuilder) {
            super(extendableBuilder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = extendableBuilder.getUnknownFields();
        }

        private PackageFragment(boolean z11) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$StringTable$Builder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v3, resolved type: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$QualifiedNameTable$Builder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package$Builder} */
        /* JADX WARNING: type inference failed for: r8v0 */
        /* JADX WARNING: type inference failed for: r8v7 */
        /* JADX WARNING: type inference failed for: r8v8 */
        /* JADX WARNING: type inference failed for: r8v9 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private PackageFragment(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream r10, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite r11) throws kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException {
            /*
                r9 = this;
                r9.<init>()
                r0 = -1
                r9.memoizedIsInitialized = r0
                r9.memoizedSerializedSize = r0
                r9.initFields()
                kotlin.reflect.jvm.internal.impl.protobuf.ByteString$Output r0 = kotlin.reflect.jvm.internal.impl.protobuf.ByteString.newOutput()
                r1 = 1
                kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream r2 = kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream.newInstance(r0, r1)
                r3 = 0
                r4 = r3
            L_0x0016:
                r5 = 8
                if (r3 != 0) goto L_0x0104
                int r6 = r10.readTag()     // Catch:{ InvalidProtocolBufferException -> 0x00dc, IOException -> 0x00cd }
                if (r6 == 0) goto L_0x00c8
                r7 = 10
                r8 = 0
                if (r6 == r7) goto L_0x00a1
                r7 = 18
                if (r6 == r7) goto L_0x0079
                r7 = 26
                if (r6 == r7) goto L_0x0052
                r7 = 34
                if (r6 == r7) goto L_0x0039
                boolean r5 = r9.f(r10, r2, r11, r6)     // Catch:{ InvalidProtocolBufferException -> 0x00dc, IOException -> 0x00cd }
                if (r5 != 0) goto L_0x0016
                goto L_0x00c8
            L_0x0039:
                r6 = r4 & 8
                if (r6 == r5) goto L_0x0046
                java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x00dc, IOException -> 0x00cd }
                r6.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x00dc, IOException -> 0x00cd }
                r9.class__ = r6     // Catch:{ InvalidProtocolBufferException -> 0x00dc, IOException -> 0x00cd }
                r4 = r4 | 8
            L_0x0046:
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class> r6 = r9.class__     // Catch:{ InvalidProtocolBufferException -> 0x00dc, IOException -> 0x00cd }
                kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class> r7 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Class.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x00dc, IOException -> 0x00cd }
                kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r7 = r10.readMessage(r7, (kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite) r11)     // Catch:{ InvalidProtocolBufferException -> 0x00dc, IOException -> 0x00cd }
                r6.add(r7)     // Catch:{ InvalidProtocolBufferException -> 0x00dc, IOException -> 0x00cd }
                goto L_0x0016
            L_0x0052:
                int r6 = r9.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x00dc, IOException -> 0x00cd }
                r7 = 4
                r6 = r6 & r7
                if (r6 != r7) goto L_0x005e
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package r6 = r9.package_     // Catch:{ InvalidProtocolBufferException -> 0x00dc, IOException -> 0x00cd }
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package$Builder r8 = r6.toBuilder()     // Catch:{ InvalidProtocolBufferException -> 0x00dc, IOException -> 0x00cd }
            L_0x005e:
                kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package> r6 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Package.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x00dc, IOException -> 0x00cd }
                kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r6 = r10.readMessage(r6, (kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite) r11)     // Catch:{ InvalidProtocolBufferException -> 0x00dc, IOException -> 0x00cd }
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package r6 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Package) r6     // Catch:{ InvalidProtocolBufferException -> 0x00dc, IOException -> 0x00cd }
                r9.package_ = r6     // Catch:{ InvalidProtocolBufferException -> 0x00dc, IOException -> 0x00cd }
                if (r8 == 0) goto L_0x0073
                r8.mergeFrom((kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Package) r6)     // Catch:{ InvalidProtocolBufferException -> 0x00dc, IOException -> 0x00cd }
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package r6 = r8.buildPartial()     // Catch:{ InvalidProtocolBufferException -> 0x00dc, IOException -> 0x00cd }
                r9.package_ = r6     // Catch:{ InvalidProtocolBufferException -> 0x00dc, IOException -> 0x00cd }
            L_0x0073:
                int r6 = r9.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x00dc, IOException -> 0x00cd }
                r6 = r6 | r7
                r9.bitField0_ = r6     // Catch:{ InvalidProtocolBufferException -> 0x00dc, IOException -> 0x00cd }
                goto L_0x0016
            L_0x0079:
                int r6 = r9.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x00dc, IOException -> 0x00cd }
                r7 = 2
                r6 = r6 & r7
                if (r6 != r7) goto L_0x0085
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$QualifiedNameTable r6 = r9.qualifiedNames_     // Catch:{ InvalidProtocolBufferException -> 0x00dc, IOException -> 0x00cd }
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$QualifiedNameTable$Builder r8 = r6.toBuilder()     // Catch:{ InvalidProtocolBufferException -> 0x00dc, IOException -> 0x00cd }
            L_0x0085:
                kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$QualifiedNameTable> r6 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.QualifiedNameTable.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x00dc, IOException -> 0x00cd }
                kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r6 = r10.readMessage(r6, (kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite) r11)     // Catch:{ InvalidProtocolBufferException -> 0x00dc, IOException -> 0x00cd }
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$QualifiedNameTable r6 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.QualifiedNameTable) r6     // Catch:{ InvalidProtocolBufferException -> 0x00dc, IOException -> 0x00cd }
                r9.qualifiedNames_ = r6     // Catch:{ InvalidProtocolBufferException -> 0x00dc, IOException -> 0x00cd }
                if (r8 == 0) goto L_0x009a
                r8.mergeFrom((kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.QualifiedNameTable) r6)     // Catch:{ InvalidProtocolBufferException -> 0x00dc, IOException -> 0x00cd }
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$QualifiedNameTable r6 = r8.buildPartial()     // Catch:{ InvalidProtocolBufferException -> 0x00dc, IOException -> 0x00cd }
                r9.qualifiedNames_ = r6     // Catch:{ InvalidProtocolBufferException -> 0x00dc, IOException -> 0x00cd }
            L_0x009a:
                int r6 = r9.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x00dc, IOException -> 0x00cd }
                r6 = r6 | r7
                r9.bitField0_ = r6     // Catch:{ InvalidProtocolBufferException -> 0x00dc, IOException -> 0x00cd }
                goto L_0x0016
            L_0x00a1:
                int r6 = r9.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x00dc, IOException -> 0x00cd }
                r6 = r6 & r1
                if (r6 != r1) goto L_0x00ac
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$StringTable r6 = r9.strings_     // Catch:{ InvalidProtocolBufferException -> 0x00dc, IOException -> 0x00cd }
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$StringTable$Builder r8 = r6.toBuilder()     // Catch:{ InvalidProtocolBufferException -> 0x00dc, IOException -> 0x00cd }
            L_0x00ac:
                kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$StringTable> r6 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.StringTable.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x00dc, IOException -> 0x00cd }
                kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r6 = r10.readMessage(r6, (kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite) r11)     // Catch:{ InvalidProtocolBufferException -> 0x00dc, IOException -> 0x00cd }
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$StringTable r6 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.StringTable) r6     // Catch:{ InvalidProtocolBufferException -> 0x00dc, IOException -> 0x00cd }
                r9.strings_ = r6     // Catch:{ InvalidProtocolBufferException -> 0x00dc, IOException -> 0x00cd }
                if (r8 == 0) goto L_0x00c1
                r8.mergeFrom((kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.StringTable) r6)     // Catch:{ InvalidProtocolBufferException -> 0x00dc, IOException -> 0x00cd }
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$StringTable r6 = r8.buildPartial()     // Catch:{ InvalidProtocolBufferException -> 0x00dc, IOException -> 0x00cd }
                r9.strings_ = r6     // Catch:{ InvalidProtocolBufferException -> 0x00dc, IOException -> 0x00cd }
            L_0x00c1:
                int r6 = r9.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x00dc, IOException -> 0x00cd }
                r6 = r6 | r1
                r9.bitField0_ = r6     // Catch:{ InvalidProtocolBufferException -> 0x00dc, IOException -> 0x00cd }
                goto L_0x0016
            L_0x00c8:
                r3 = r1
                goto L_0x0016
            L_0x00cb:
                r10 = move-exception
                goto L_0x00e2
            L_0x00cd:
                r10 = move-exception
                kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException r11 = new kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException     // Catch:{ all -> 0x00cb }
                java.lang.String r10 = r10.getMessage()     // Catch:{ all -> 0x00cb }
                r11.<init>(r10)     // Catch:{ all -> 0x00cb }
                kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException r10 = r11.setUnfinishedMessage(r9)     // Catch:{ all -> 0x00cb }
                throw r10     // Catch:{ all -> 0x00cb }
            L_0x00dc:
                r10 = move-exception
                kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException r10 = r10.setUnfinishedMessage(r9)     // Catch:{ all -> 0x00cb }
                throw r10     // Catch:{ all -> 0x00cb }
            L_0x00e2:
                r11 = r4 & 8
                if (r11 != r5) goto L_0x00ee
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class> r11 = r9.class__
                java.util.List r11 = java.util.Collections.unmodifiableList(r11)
                r9.class__ = r11
            L_0x00ee:
                r2.flush()     // Catch:{ IOException -> 0x00f1, all -> 0x00f8 }
            L_0x00f1:
                kotlin.reflect.jvm.internal.impl.protobuf.ByteString r11 = r0.toByteString()
                r9.unknownFields = r11
                goto L_0x0100
            L_0x00f8:
                r10 = move-exception
                kotlin.reflect.jvm.internal.impl.protobuf.ByteString r11 = r0.toByteString()
                r9.unknownFields = r11
                throw r10
            L_0x0100:
                r9.e()
                throw r10
            L_0x0104:
                r10 = r4 & 8
                if (r10 != r5) goto L_0x0110
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class> r10 = r9.class__
                java.util.List r10 = java.util.Collections.unmodifiableList(r10)
                r9.class__ = r10
            L_0x0110:
                r2.flush()     // Catch:{ IOException -> 0x0113, all -> 0x011a }
            L_0x0113:
                kotlin.reflect.jvm.internal.impl.protobuf.ByteString r10 = r0.toByteString()
                r9.unknownFields = r10
                goto L_0x0122
            L_0x011a:
                r10 = move-exception
                kotlin.reflect.jvm.internal.impl.protobuf.ByteString r11 = r0.toByteString()
                r9.unknownFields = r11
                throw r10
            L_0x0122:
                r9.e()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.PackageFragment.<init>(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite):void");
        }
    }

    public interface PackageFragmentOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder {
    }

    public interface PackageOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder {
    }

    public static final class Property extends GeneratedMessageLite.ExtendableMessage<Property> implements PropertyOrBuilder {
        public static Parser<Property> PARSER = new AbstractParser<Property>() {
            public Property parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Property(codedInputStream, extensionRegistryLite);
            }
        };
        private static final Property defaultInstance;
        /* access modifiers changed from: private */
        public int bitField0_;
        private int contextReceiverTypeIdMemoizedSerializedSize;
        /* access modifiers changed from: private */
        public List<Integer> contextReceiverTypeId_;
        /* access modifiers changed from: private */
        public List<Type> contextReceiverType_;
        /* access modifiers changed from: private */
        public int flags_;
        /* access modifiers changed from: private */
        public int getterFlags_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        /* access modifiers changed from: private */
        public int name_;
        /* access modifiers changed from: private */
        public int oldFlags_;
        /* access modifiers changed from: private */
        public int receiverTypeId_;
        /* access modifiers changed from: private */
        public Type receiverType_;
        /* access modifiers changed from: private */
        public int returnTypeId_;
        /* access modifiers changed from: private */
        public Type returnType_;
        /* access modifiers changed from: private */
        public int setterFlags_;
        /* access modifiers changed from: private */
        public ValueParameter setterValueParameter_;
        /* access modifiers changed from: private */
        public List<TypeParameter> typeParameter_;
        /* access modifiers changed from: private */
        public final ByteString unknownFields;
        /* access modifiers changed from: private */
        public List<Integer> versionRequirement_;

        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<Property, Builder> implements PropertyOrBuilder {
            private int bitField0_;
            private List<Integer> contextReceiverTypeId_ = Collections.emptyList();
            private List<Type> contextReceiverType_ = Collections.emptyList();
            private int flags_ = 518;
            private int getterFlags_;
            private int name_;
            private int oldFlags_ = 2054;
            private int receiverTypeId_;
            private Type receiverType_ = Type.getDefaultInstance();
            private int returnTypeId_;
            private Type returnType_ = Type.getDefaultInstance();
            private int setterFlags_;
            private ValueParameter setterValueParameter_ = ValueParameter.getDefaultInstance();
            private List<TypeParameter> typeParameter_ = Collections.emptyList();
            private List<Integer> versionRequirement_ = Collections.emptyList();

            private Builder() {
                maybeForceBuilderInitialization();
            }

            /* access modifiers changed from: private */
            public static Builder create() {
                return new Builder();
            }

            private void ensureContextReceiverTypeIdIsMutable() {
                if ((this.bitField0_ & 512) != 512) {
                    this.contextReceiverTypeId_ = new ArrayList(this.contextReceiverTypeId_);
                    this.bitField0_ |= 512;
                }
            }

            private void ensureContextReceiverTypeIsMutable() {
                if ((this.bitField0_ & 256) != 256) {
                    this.contextReceiverType_ = new ArrayList(this.contextReceiverType_);
                    this.bitField0_ |= 256;
                }
            }

            private void ensureTypeParameterIsMutable() {
                if ((this.bitField0_ & 32) != 32) {
                    this.typeParameter_ = new ArrayList(this.typeParameter_);
                    this.bitField0_ |= 32;
                }
            }

            private void ensureVersionRequirementIsMutable() {
                if ((this.bitField0_ & 8192) != 8192) {
                    this.versionRequirement_ = new ArrayList(this.versionRequirement_);
                    this.bitField0_ |= 8192;
                }
            }

            private void maybeForceBuilderInitialization() {
            }

            public Property buildPartial() {
                Property property = new Property((GeneratedMessageLite.ExtendableBuilder) this);
                int i11 = this.bitField0_;
                int i12 = 1;
                if ((i11 & 1) != 1) {
                    i12 = 0;
                }
                int unused = property.flags_ = this.flags_;
                if ((i11 & 2) == 2) {
                    i12 |= 2;
                }
                int unused2 = property.oldFlags_ = this.oldFlags_;
                if ((i11 & 4) == 4) {
                    i12 |= 4;
                }
                int unused3 = property.name_ = this.name_;
                if ((i11 & 8) == 8) {
                    i12 |= 8;
                }
                Type unused4 = property.returnType_ = this.returnType_;
                if ((i11 & 16) == 16) {
                    i12 |= 16;
                }
                int unused5 = property.returnTypeId_ = this.returnTypeId_;
                if ((this.bitField0_ & 32) == 32) {
                    this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                    this.bitField0_ &= -33;
                }
                List unused6 = property.typeParameter_ = this.typeParameter_;
                if ((i11 & 64) == 64) {
                    i12 |= 32;
                }
                Type unused7 = property.receiverType_ = this.receiverType_;
                if ((i11 & 128) == 128) {
                    i12 |= 64;
                }
                int unused8 = property.receiverTypeId_ = this.receiverTypeId_;
                if ((this.bitField0_ & 256) == 256) {
                    this.contextReceiverType_ = Collections.unmodifiableList(this.contextReceiverType_);
                    this.bitField0_ &= -257;
                }
                List unused9 = property.contextReceiverType_ = this.contextReceiverType_;
                if ((this.bitField0_ & 512) == 512) {
                    this.contextReceiverTypeId_ = Collections.unmodifiableList(this.contextReceiverTypeId_);
                    this.bitField0_ &= -513;
                }
                List unused10 = property.contextReceiverTypeId_ = this.contextReceiverTypeId_;
                if ((i11 & 1024) == 1024) {
                    i12 |= 128;
                }
                ValueParameter unused11 = property.setterValueParameter_ = this.setterValueParameter_;
                if ((i11 & 2048) == 2048) {
                    i12 |= 256;
                }
                int unused12 = property.getterFlags_ = this.getterFlags_;
                if ((i11 & 4096) == 4096) {
                    i12 |= 512;
                }
                int unused13 = property.setterFlags_ = this.setterFlags_;
                if ((this.bitField0_ & 8192) == 8192) {
                    this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
                    this.bitField0_ &= -8193;
                }
                List unused14 = property.versionRequirement_ = this.versionRequirement_;
                int unused15 = property.bitField0_ = i12;
                return property;
            }

            public Type getContextReceiverType(int i11) {
                return this.contextReceiverType_.get(i11);
            }

            public int getContextReceiverTypeCount() {
                return this.contextReceiverType_.size();
            }

            public Type getReceiverType() {
                return this.receiverType_;
            }

            public Type getReturnType() {
                return this.returnType_;
            }

            public ValueParameter getSetterValueParameter() {
                return this.setterValueParameter_;
            }

            public TypeParameter getTypeParameter(int i11) {
                return this.typeParameter_.get(i11);
            }

            public int getTypeParameterCount() {
                return this.typeParameter_.size();
            }

            public boolean hasName() {
                return (this.bitField0_ & 4) == 4;
            }

            public boolean hasReceiverType() {
                return (this.bitField0_ & 64) == 64;
            }

            public boolean hasReturnType() {
                return (this.bitField0_ & 8) == 8;
            }

            public boolean hasSetterValueParameter() {
                return (this.bitField0_ & 1024) == 1024;
            }

            public final boolean isInitialized() {
                if (!hasName()) {
                    return false;
                }
                if (hasReturnType() && !getReturnType().isInitialized()) {
                    return false;
                }
                for (int i11 = 0; i11 < getTypeParameterCount(); i11++) {
                    if (!getTypeParameter(i11).isInitialized()) {
                        return false;
                    }
                }
                if (hasReceiverType() && !getReceiverType().isInitialized()) {
                    return false;
                }
                for (int i12 = 0; i12 < getContextReceiverTypeCount(); i12++) {
                    if (!getContextReceiverType(i12).isInitialized()) {
                        return false;
                    }
                }
                if ((!hasSetterValueParameter() || getSetterValueParameter().isInitialized()) && c()) {
                    return true;
                }
                return false;
            }

            public Builder mergeReceiverType(Type type) {
                if ((this.bitField0_ & 64) != 64 || this.receiverType_ == Type.getDefaultInstance()) {
                    this.receiverType_ = type;
                } else {
                    this.receiverType_ = Type.newBuilder(this.receiverType_).mergeFrom(type).buildPartial();
                }
                this.bitField0_ |= 64;
                return this;
            }

            public Builder mergeReturnType(Type type) {
                if ((this.bitField0_ & 8) != 8 || this.returnType_ == Type.getDefaultInstance()) {
                    this.returnType_ = type;
                } else {
                    this.returnType_ = Type.newBuilder(this.returnType_).mergeFrom(type).buildPartial();
                }
                this.bitField0_ |= 8;
                return this;
            }

            public Builder mergeSetterValueParameter(ValueParameter valueParameter) {
                if ((this.bitField0_ & 1024) != 1024 || this.setterValueParameter_ == ValueParameter.getDefaultInstance()) {
                    this.setterValueParameter_ = valueParameter;
                } else {
                    this.setterValueParameter_ = ValueParameter.newBuilder(this.setterValueParameter_).mergeFrom(valueParameter).buildPartial();
                }
                this.bitField0_ |= 1024;
                return this;
            }

            public Builder setFlags(int i11) {
                this.bitField0_ |= 1;
                this.flags_ = i11;
                return this;
            }

            public Builder setGetterFlags(int i11) {
                this.bitField0_ |= 2048;
                this.getterFlags_ = i11;
                return this;
            }

            public Builder setName(int i11) {
                this.bitField0_ |= 4;
                this.name_ = i11;
                return this;
            }

            public Builder setOldFlags(int i11) {
                this.bitField0_ |= 2;
                this.oldFlags_ = i11;
                return this;
            }

            public Builder setReceiverTypeId(int i11) {
                this.bitField0_ |= 128;
                this.receiverTypeId_ = i11;
                return this;
            }

            public Builder setReturnTypeId(int i11) {
                this.bitField0_ |= 16;
                this.returnTypeId_ = i11;
                return this;
            }

            public Builder setSetterFlags(int i11) {
                this.bitField0_ |= 4096;
                this.setterFlags_ = i11;
                return this;
            }

            public Property build() {
                Property buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.a(buildPartial);
            }

            public Property getDefaultInstanceForType() {
                return Property.getDefaultInstance();
            }

            public Builder mergeFrom(Property property) {
                if (property == Property.getDefaultInstance()) {
                    return this;
                }
                if (property.hasFlags()) {
                    setFlags(property.getFlags());
                }
                if (property.hasOldFlags()) {
                    setOldFlags(property.getOldFlags());
                }
                if (property.hasName()) {
                    setName(property.getName());
                }
                if (property.hasReturnType()) {
                    mergeReturnType(property.getReturnType());
                }
                if (property.hasReturnTypeId()) {
                    setReturnTypeId(property.getReturnTypeId());
                }
                if (!property.typeParameter_.isEmpty()) {
                    if (this.typeParameter_.isEmpty()) {
                        this.typeParameter_ = property.typeParameter_;
                        this.bitField0_ &= -33;
                    } else {
                        ensureTypeParameterIsMutable();
                        this.typeParameter_.addAll(property.typeParameter_);
                    }
                }
                if (property.hasReceiverType()) {
                    mergeReceiverType(property.getReceiverType());
                }
                if (property.hasReceiverTypeId()) {
                    setReceiverTypeId(property.getReceiverTypeId());
                }
                if (!property.contextReceiverType_.isEmpty()) {
                    if (this.contextReceiverType_.isEmpty()) {
                        this.contextReceiverType_ = property.contextReceiverType_;
                        this.bitField0_ &= -257;
                    } else {
                        ensureContextReceiverTypeIsMutable();
                        this.contextReceiverType_.addAll(property.contextReceiverType_);
                    }
                }
                if (!property.contextReceiverTypeId_.isEmpty()) {
                    if (this.contextReceiverTypeId_.isEmpty()) {
                        this.contextReceiverTypeId_ = property.contextReceiverTypeId_;
                        this.bitField0_ &= -513;
                    } else {
                        ensureContextReceiverTypeIdIsMutable();
                        this.contextReceiverTypeId_.addAll(property.contextReceiverTypeId_);
                    }
                }
                if (property.hasSetterValueParameter()) {
                    mergeSetterValueParameter(property.getSetterValueParameter());
                }
                if (property.hasGetterFlags()) {
                    setGetterFlags(property.getGetterFlags());
                }
                if (property.hasSetterFlags()) {
                    setSetterFlags(property.getSetterFlags());
                }
                if (!property.versionRequirement_.isEmpty()) {
                    if (this.versionRequirement_.isEmpty()) {
                        this.versionRequirement_ = property.versionRequirement_;
                        this.bitField0_ &= -8193;
                    } else {
                        ensureVersionRequirementIsMutable();
                        this.versionRequirement_.addAll(property.versionRequirement_);
                    }
                }
                d(property);
                setUnknownFields(getUnknownFields().concat(property.unknownFields));
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                Property property;
                Property property2 = null;
                try {
                    Property parsePartialFrom = Property.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e11) {
                    property = (Property) e11.getUnfinishedMessage();
                    throw e11;
                } catch (Throwable th2) {
                    th = th2;
                    property2 = property;
                }
                if (property2 != null) {
                    mergeFrom(property2);
                }
                throw th;
            }
        }

        static {
            Property property = new Property(true);
            defaultInstance = property;
            property.initFields();
        }

        public static Property getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.flags_ = 518;
            this.oldFlags_ = 2054;
            this.name_ = 0;
            this.returnType_ = Type.getDefaultInstance();
            this.returnTypeId_ = 0;
            this.typeParameter_ = Collections.emptyList();
            this.receiverType_ = Type.getDefaultInstance();
            this.receiverTypeId_ = 0;
            this.contextReceiverType_ = Collections.emptyList();
            this.contextReceiverTypeId_ = Collections.emptyList();
            this.setterValueParameter_ = ValueParameter.getDefaultInstance();
            this.getterFlags_ = 0;
            this.setterFlags_ = 0;
            this.versionRequirement_ = Collections.emptyList();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Type getContextReceiverType(int i11) {
            return this.contextReceiverType_.get(i11);
        }

        public int getContextReceiverTypeCount() {
            return this.contextReceiverType_.size();
        }

        public List<Integer> getContextReceiverTypeIdList() {
            return this.contextReceiverTypeId_;
        }

        public List<Type> getContextReceiverTypeList() {
            return this.contextReceiverType_;
        }

        public int getFlags() {
            return this.flags_;
        }

        public int getGetterFlags() {
            return this.getterFlags_;
        }

        public int getName() {
            return this.name_;
        }

        public int getOldFlags() {
            return this.oldFlags_;
        }

        public Parser<Property> getParserForType() {
            return PARSER;
        }

        public Type getReceiverType() {
            return this.receiverType_;
        }

        public int getReceiverTypeId() {
            return this.receiverTypeId_;
        }

        public Type getReturnType() {
            return this.returnType_;
        }

        public int getReturnTypeId() {
            return this.returnTypeId_;
        }

        public int getSerializedSize() {
            int i11;
            int i12 = this.memoizedSerializedSize;
            if (i12 != -1) {
                return i12;
            }
            if ((this.bitField0_ & 2) == 2) {
                i11 = CodedOutputStream.computeInt32Size(1, this.oldFlags_) + 0;
            } else {
                i11 = 0;
            }
            if ((this.bitField0_ & 4) == 4) {
                i11 += CodedOutputStream.computeInt32Size(2, this.name_);
            }
            if ((this.bitField0_ & 8) == 8) {
                i11 += CodedOutputStream.computeMessageSize(3, this.returnType_);
            }
            for (int i13 = 0; i13 < this.typeParameter_.size(); i13++) {
                i11 += CodedOutputStream.computeMessageSize(4, this.typeParameter_.get(i13));
            }
            if ((this.bitField0_ & 32) == 32) {
                i11 += CodedOutputStream.computeMessageSize(5, this.receiverType_);
            }
            if ((this.bitField0_ & 128) == 128) {
                i11 += CodedOutputStream.computeMessageSize(6, this.setterValueParameter_);
            }
            if ((this.bitField0_ & 256) == 256) {
                i11 += CodedOutputStream.computeInt32Size(7, this.getterFlags_);
            }
            if ((this.bitField0_ & 512) == 512) {
                i11 += CodedOutputStream.computeInt32Size(8, this.setterFlags_);
            }
            if ((this.bitField0_ & 16) == 16) {
                i11 += CodedOutputStream.computeInt32Size(9, this.returnTypeId_);
            }
            if ((this.bitField0_ & 64) == 64) {
                i11 += CodedOutputStream.computeInt32Size(10, this.receiverTypeId_);
            }
            if ((this.bitField0_ & 1) == 1) {
                i11 += CodedOutputStream.computeInt32Size(11, this.flags_);
            }
            for (int i14 = 0; i14 < this.contextReceiverType_.size(); i14++) {
                i11 += CodedOutputStream.computeMessageSize(12, this.contextReceiverType_.get(i14));
            }
            int i15 = 0;
            for (int i16 = 0; i16 < this.contextReceiverTypeId_.size(); i16++) {
                i15 += CodedOutputStream.computeInt32SizeNoTag(this.contextReceiverTypeId_.get(i16).intValue());
            }
            int i17 = i11 + i15;
            if (!getContextReceiverTypeIdList().isEmpty()) {
                i17 = i17 + 1 + CodedOutputStream.computeInt32SizeNoTag(i15);
            }
            this.contextReceiverTypeIdMemoizedSerializedSize = i15;
            int i18 = 0;
            for (int i19 = 0; i19 < this.versionRequirement_.size(); i19++) {
                i18 += CodedOutputStream.computeInt32SizeNoTag(this.versionRequirement_.get(i19).intValue());
            }
            int size = i17 + i18 + (getVersionRequirementList().size() * 2) + i() + this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        public int getSetterFlags() {
            return this.setterFlags_;
        }

        public ValueParameter getSetterValueParameter() {
            return this.setterValueParameter_;
        }

        public TypeParameter getTypeParameter(int i11) {
            return this.typeParameter_.get(i11);
        }

        public int getTypeParameterCount() {
            return this.typeParameter_.size();
        }

        public List<TypeParameter> getTypeParameterList() {
            return this.typeParameter_;
        }

        public List<Integer> getVersionRequirementList() {
            return this.versionRequirement_;
        }

        public boolean hasFlags() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean hasGetterFlags() {
            return (this.bitField0_ & 256) == 256;
        }

        public boolean hasName() {
            return (this.bitField0_ & 4) == 4;
        }

        public boolean hasOldFlags() {
            return (this.bitField0_ & 2) == 2;
        }

        public boolean hasReceiverType() {
            return (this.bitField0_ & 32) == 32;
        }

        public boolean hasReceiverTypeId() {
            return (this.bitField0_ & 64) == 64;
        }

        public boolean hasReturnType() {
            return (this.bitField0_ & 8) == 8;
        }

        public boolean hasReturnTypeId() {
            return (this.bitField0_ & 16) == 16;
        }

        public boolean hasSetterFlags() {
            return (this.bitField0_ & 512) == 512;
        }

        public boolean hasSetterValueParameter() {
            return (this.bitField0_ & 128) == 128;
        }

        public final boolean isInitialized() {
            byte b11 = this.memoizedIsInitialized;
            if (b11 == 1) {
                return true;
            }
            if (b11 == 0) {
                return false;
            }
            if (!hasName()) {
                this.memoizedIsInitialized = 0;
                return false;
            } else if (!hasReturnType() || getReturnType().isInitialized()) {
                for (int i11 = 0; i11 < getTypeParameterCount(); i11++) {
                    if (!getTypeParameter(i11).isInitialized()) {
                        this.memoizedIsInitialized = 0;
                        return false;
                    }
                }
                if (!hasReceiverType() || getReceiverType().isInitialized()) {
                    for (int i12 = 0; i12 < getContextReceiverTypeCount(); i12++) {
                        if (!getContextReceiverType(i12).isInitialized()) {
                            this.memoizedIsInitialized = 0;
                            return false;
                        }
                    }
                    if (hasSetterValueParameter() && !getSetterValueParameter().isInitialized()) {
                        this.memoizedIsInitialized = 0;
                        return false;
                    } else if (!h()) {
                        this.memoizedIsInitialized = 0;
                        return false;
                    } else {
                        this.memoizedIsInitialized = 1;
                        return true;
                    }
                } else {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            } else {
                this.memoizedIsInitialized = 0;
                return false;
            }
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter j11 = j();
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeInt32(1, this.oldFlags_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeInt32(2, this.name_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeMessage(3, this.returnType_);
            }
            for (int i11 = 0; i11 < this.typeParameter_.size(); i11++) {
                codedOutputStream.writeMessage(4, this.typeParameter_.get(i11));
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.writeMessage(5, this.receiverType_);
            }
            if ((this.bitField0_ & 128) == 128) {
                codedOutputStream.writeMessage(6, this.setterValueParameter_);
            }
            if ((this.bitField0_ & 256) == 256) {
                codedOutputStream.writeInt32(7, this.getterFlags_);
            }
            if ((this.bitField0_ & 512) == 512) {
                codedOutputStream.writeInt32(8, this.setterFlags_);
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.writeInt32(9, this.returnTypeId_);
            }
            if ((this.bitField0_ & 64) == 64) {
                codedOutputStream.writeInt32(10, this.receiverTypeId_);
            }
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeInt32(11, this.flags_);
            }
            for (int i12 = 0; i12 < this.contextReceiverType_.size(); i12++) {
                codedOutputStream.writeMessage(12, this.contextReceiverType_.get(i12));
            }
            if (getContextReceiverTypeIdList().size() > 0) {
                codedOutputStream.writeRawVarint32(106);
                codedOutputStream.writeRawVarint32(this.contextReceiverTypeIdMemoizedSerializedSize);
            }
            for (int i13 = 0; i13 < this.contextReceiverTypeId_.size(); i13++) {
                codedOutputStream.writeInt32NoTag(this.contextReceiverTypeId_.get(i13).intValue());
            }
            for (int i14 = 0; i14 < this.versionRequirement_.size(); i14++) {
                codedOutputStream.writeInt32(31, this.versionRequirement_.get(i14).intValue());
            }
            j11.writeUntil(19000, codedOutputStream);
            codedOutputStream.writeRawBytes(this.unknownFields);
        }

        public static Builder newBuilder(Property property) {
            return newBuilder().mergeFrom(property);
        }

        public Property getDefaultInstanceForType() {
            return defaultInstance;
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        private Property(GeneratedMessageLite.ExtendableBuilder<Property, ?> extendableBuilder) {
            super(extendableBuilder);
            this.contextReceiverTypeIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = extendableBuilder.getUnknownFields();
        }

        private Property(boolean z11) {
            this.contextReceiverTypeIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v1, resolved type: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type$Builder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v5, resolved type: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type$Builder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v7, resolved type: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter$Builder} */
        /* JADX WARNING: type inference failed for: r10v0 */
        /* JADX WARNING: type inference failed for: r10v25 */
        /* JADX WARNING: type inference failed for: r10v26 */
        /* JADX WARNING: type inference failed for: r10v27 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private Property(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream r13, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite r14) throws kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException {
            /*
                r12 = this;
                r12.<init>()
                r0 = -1
                r12.contextReceiverTypeIdMemoizedSerializedSize = r0
                r12.memoizedIsInitialized = r0
                r12.memoizedSerializedSize = r0
                r12.initFields()
                kotlin.reflect.jvm.internal.impl.protobuf.ByteString$Output r0 = kotlin.reflect.jvm.internal.impl.protobuf.ByteString.newOutput()
                r1 = 1
                kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream r2 = kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream.newInstance(r0, r1)
                r3 = 0
                r4 = r3
            L_0x0018:
                r5 = 256(0x100, float:3.59E-43)
                r6 = 8192(0x2000, float:1.14794E-41)
                r7 = 32
                r8 = 512(0x200, float:7.175E-43)
                if (r3 != 0) goto L_0x023d
                int r9 = r13.readTag()     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                r10 = 0
                switch(r9) {
                    case 0: goto L_0x01da;
                    case 8: goto L_0x01cc;
                    case 16: goto L_0x01be;
                    case 26: goto L_0x0195;
                    case 34: goto L_0x017b;
                    case 42: goto L_0x0154;
                    case 50: goto L_0x012b;
                    case 56: goto L_0x011e;
                    case 64: goto L_0x0111;
                    case 72: goto L_0x0103;
                    case 80: goto L_0x00f5;
                    case 88: goto L_0x00e8;
                    case 98: goto L_0x00ce;
                    case 104: goto L_0x00b2;
                    case 106: goto L_0x007e;
                    case 248: goto L_0x0063;
                    case 250: goto L_0x0030;
                    default: goto L_0x002a;
                }     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
            L_0x002a:
                boolean r5 = r12.f(r13, r2, r14, r9)     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                goto L_0x01dd
            L_0x0030:
                int r9 = r13.readRawVarint32()     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                int r9 = r13.pushLimit(r9)     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                r10 = r4 & 8192(0x2000, float:1.14794E-41)
                if (r10 == r6) goto L_0x004b
                int r10 = r13.getBytesUntilLimit()     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                if (r10 <= 0) goto L_0x004b
                java.util.ArrayList r10 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                r10.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                r12.versionRequirement_ = r10     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                r4 = r4 | 8192(0x2000, float:1.14794E-41)
            L_0x004b:
                int r10 = r13.getBytesUntilLimit()     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                if (r10 <= 0) goto L_0x005f
                java.util.List<java.lang.Integer> r10 = r12.versionRequirement_     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                int r11 = r13.readInt32()     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                r10.add(r11)     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                goto L_0x004b
            L_0x005f:
                r13.popLimit(r9)     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                goto L_0x0018
            L_0x0063:
                r9 = r4 & 8192(0x2000, float:1.14794E-41)
                if (r9 == r6) goto L_0x0070
                java.util.ArrayList r9 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                r9.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                r12.versionRequirement_ = r9     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                r4 = r4 | 8192(0x2000, float:1.14794E-41)
            L_0x0070:
                java.util.List<java.lang.Integer> r9 = r12.versionRequirement_     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                int r10 = r13.readInt32()     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                r9.add(r10)     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                goto L_0x0018
            L_0x007e:
                int r9 = r13.readRawVarint32()     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                int r9 = r13.pushLimit(r9)     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                r10 = r4 & 512(0x200, float:7.175E-43)
                if (r10 == r8) goto L_0x0099
                int r10 = r13.getBytesUntilLimit()     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                if (r10 <= 0) goto L_0x0099
                java.util.ArrayList r10 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                r10.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                r12.contextReceiverTypeId_ = r10     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                r4 = r4 | 512(0x200, float:7.175E-43)
            L_0x0099:
                int r10 = r13.getBytesUntilLimit()     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                if (r10 <= 0) goto L_0x00ad
                java.util.List<java.lang.Integer> r10 = r12.contextReceiverTypeId_     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                int r11 = r13.readInt32()     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                r10.add(r11)     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                goto L_0x0099
            L_0x00ad:
                r13.popLimit(r9)     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                goto L_0x0018
            L_0x00b2:
                r9 = r4 & 512(0x200, float:7.175E-43)
                if (r9 == r8) goto L_0x00bf
                java.util.ArrayList r9 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                r9.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                r12.contextReceiverTypeId_ = r9     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                r4 = r4 | 512(0x200, float:7.175E-43)
            L_0x00bf:
                java.util.List<java.lang.Integer> r9 = r12.contextReceiverTypeId_     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                int r10 = r13.readInt32()     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                r9.add(r10)     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                goto L_0x0018
            L_0x00ce:
                r9 = r4 & 256(0x100, float:3.59E-43)
                if (r9 == r5) goto L_0x00db
                java.util.ArrayList r9 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                r9.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                r12.contextReceiverType_ = r9     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                r4 = r4 | 256(0x100, float:3.59E-43)
            L_0x00db:
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type> r9 = r12.contextReceiverType_     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type> r10 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r10 = r13.readMessage(r10, (kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite) r14)     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                r9.add(r10)     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                goto L_0x0018
            L_0x00e8:
                int r9 = r12.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                r9 = r9 | r1
                r12.bitField0_ = r9     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                int r9 = r13.readInt32()     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                r12.flags_ = r9     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                goto L_0x0018
            L_0x00f5:
                int r9 = r12.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                r9 = r9 | 64
                r12.bitField0_ = r9     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                int r9 = r13.readInt32()     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                r12.receiverTypeId_ = r9     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                goto L_0x0018
            L_0x0103:
                int r9 = r12.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                r9 = r9 | 16
                r12.bitField0_ = r9     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                int r9 = r13.readInt32()     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                r12.returnTypeId_ = r9     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                goto L_0x0018
            L_0x0111:
                int r9 = r12.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                r9 = r9 | r8
                r12.bitField0_ = r9     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                int r9 = r13.readInt32()     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                r12.setterFlags_ = r9     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                goto L_0x0018
            L_0x011e:
                int r9 = r12.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                r9 = r9 | r5
                r12.bitField0_ = r9     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                int r9 = r13.readInt32()     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                r12.getterFlags_ = r9     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                goto L_0x0018
            L_0x012b:
                int r9 = r12.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                r11 = 128(0x80, float:1.794E-43)
                r9 = r9 & r11
                if (r9 != r11) goto L_0x0138
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter r9 = r12.setterValueParameter_     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter$Builder r10 = r9.toBuilder()     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
            L_0x0138:
                kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter> r9 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.ValueParameter.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r9 = r13.readMessage(r9, (kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite) r14)     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter r9 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.ValueParameter) r9     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                r12.setterValueParameter_ = r9     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                if (r10 == 0) goto L_0x014d
                r10.mergeFrom((kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.ValueParameter) r9)     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter r9 = r10.buildPartial()     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                r12.setterValueParameter_ = r9     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
            L_0x014d:
                int r9 = r12.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                r9 = r9 | r11
                r12.bitField0_ = r9     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                goto L_0x0018
            L_0x0154:
                int r9 = r12.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                r9 = r9 & r7
                if (r9 != r7) goto L_0x015f
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type r9 = r12.receiverType_     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type$Builder r10 = r9.toBuilder()     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
            L_0x015f:
                kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type> r9 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r9 = r13.readMessage(r9, (kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite) r14)     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type r9 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type) r9     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                r12.receiverType_ = r9     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                if (r10 == 0) goto L_0x0174
                r10.mergeFrom((kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type) r9)     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type r9 = r10.buildPartial()     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                r12.receiverType_ = r9     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
            L_0x0174:
                int r9 = r12.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                r9 = r9 | r7
                r12.bitField0_ = r9     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                goto L_0x0018
            L_0x017b:
                r9 = r4 & 32
                if (r9 == r7) goto L_0x0188
                java.util.ArrayList r9 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                r9.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                r12.typeParameter_ = r9     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                r4 = r4 | 32
            L_0x0188:
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter> r9 = r12.typeParameter_     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter> r10 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeParameter.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r10 = r13.readMessage(r10, (kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite) r14)     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                r9.add(r10)     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                goto L_0x0018
            L_0x0195:
                int r9 = r12.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                r11 = 8
                r9 = r9 & r11
                if (r9 != r11) goto L_0x01a2
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type r9 = r12.returnType_     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type$Builder r10 = r9.toBuilder()     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
            L_0x01a2:
                kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type> r9 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r9 = r13.readMessage(r9, (kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite) r14)     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type r9 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type) r9     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                r12.returnType_ = r9     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                if (r10 == 0) goto L_0x01b7
                r10.mergeFrom((kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type) r9)     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type r9 = r10.buildPartial()     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                r12.returnType_ = r9     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
            L_0x01b7:
                int r9 = r12.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                r9 = r9 | r11
                r12.bitField0_ = r9     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                goto L_0x0018
            L_0x01be:
                int r9 = r12.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                r9 = r9 | 4
                r12.bitField0_ = r9     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                int r9 = r13.readInt32()     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                r12.name_ = r9     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                goto L_0x0018
            L_0x01cc:
                int r9 = r12.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                r9 = r9 | 2
                r12.bitField0_ = r9     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                int r9 = r13.readInt32()     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                r12.oldFlags_ = r9     // Catch:{ InvalidProtocolBufferException -> 0x01f1, IOException -> 0x01e2 }
                goto L_0x0018
            L_0x01da:
                r3 = r1
                goto L_0x0018
            L_0x01dd:
                if (r5 != 0) goto L_0x0018
                goto L_0x01da
            L_0x01e0:
                r13 = move-exception
                goto L_0x01f7
            L_0x01e2:
                r13 = move-exception
                kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException r14 = new kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException     // Catch:{ all -> 0x01e0 }
                java.lang.String r13 = r13.getMessage()     // Catch:{ all -> 0x01e0 }
                r14.<init>(r13)     // Catch:{ all -> 0x01e0 }
                kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException r13 = r14.setUnfinishedMessage(r12)     // Catch:{ all -> 0x01e0 }
                throw r13     // Catch:{ all -> 0x01e0 }
            L_0x01f1:
                r13 = move-exception
                kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException r13 = r13.setUnfinishedMessage(r12)     // Catch:{ all -> 0x01e0 }
                throw r13     // Catch:{ all -> 0x01e0 }
            L_0x01f7:
                r14 = r4 & 32
                if (r14 != r7) goto L_0x0203
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter> r14 = r12.typeParameter_
                java.util.List r14 = java.util.Collections.unmodifiableList(r14)
                r12.typeParameter_ = r14
            L_0x0203:
                r14 = r4 & 256(0x100, float:3.59E-43)
                if (r14 != r5) goto L_0x020f
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type> r14 = r12.contextReceiverType_
                java.util.List r14 = java.util.Collections.unmodifiableList(r14)
                r12.contextReceiverType_ = r14
            L_0x020f:
                r14 = r4 & 512(0x200, float:7.175E-43)
                if (r14 != r8) goto L_0x021b
                java.util.List<java.lang.Integer> r14 = r12.contextReceiverTypeId_
                java.util.List r14 = java.util.Collections.unmodifiableList(r14)
                r12.contextReceiverTypeId_ = r14
            L_0x021b:
                r14 = r4 & 8192(0x2000, float:1.14794E-41)
                if (r14 != r6) goto L_0x0227
                java.util.List<java.lang.Integer> r14 = r12.versionRequirement_
                java.util.List r14 = java.util.Collections.unmodifiableList(r14)
                r12.versionRequirement_ = r14
            L_0x0227:
                r2.flush()     // Catch:{ IOException -> 0x022a, all -> 0x0231 }
            L_0x022a:
                kotlin.reflect.jvm.internal.impl.protobuf.ByteString r14 = r0.toByteString()
                r12.unknownFields = r14
                goto L_0x0239
            L_0x0231:
                r13 = move-exception
                kotlin.reflect.jvm.internal.impl.protobuf.ByteString r14 = r0.toByteString()
                r12.unknownFields = r14
                throw r13
            L_0x0239:
                r12.e()
                throw r13
            L_0x023d:
                r13 = r4 & 32
                if (r13 != r7) goto L_0x0249
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter> r13 = r12.typeParameter_
                java.util.List r13 = java.util.Collections.unmodifiableList(r13)
                r12.typeParameter_ = r13
            L_0x0249:
                r13 = r4 & 256(0x100, float:3.59E-43)
                if (r13 != r5) goto L_0x0255
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type> r13 = r12.contextReceiverType_
                java.util.List r13 = java.util.Collections.unmodifiableList(r13)
                r12.contextReceiverType_ = r13
            L_0x0255:
                r13 = r4 & 512(0x200, float:7.175E-43)
                if (r13 != r8) goto L_0x0261
                java.util.List<java.lang.Integer> r13 = r12.contextReceiverTypeId_
                java.util.List r13 = java.util.Collections.unmodifiableList(r13)
                r12.contextReceiverTypeId_ = r13
            L_0x0261:
                r13 = r4 & 8192(0x2000, float:1.14794E-41)
                if (r13 != r6) goto L_0x026d
                java.util.List<java.lang.Integer> r13 = r12.versionRequirement_
                java.util.List r13 = java.util.Collections.unmodifiableList(r13)
                r12.versionRequirement_ = r13
            L_0x026d:
                r2.flush()     // Catch:{ IOException -> 0x0270, all -> 0x0277 }
            L_0x0270:
                kotlin.reflect.jvm.internal.impl.protobuf.ByteString r13 = r0.toByteString()
                r12.unknownFields = r13
                goto L_0x027f
            L_0x0277:
                r13 = move-exception
                kotlin.reflect.jvm.internal.impl.protobuf.ByteString r14 = r0.toByteString()
                r12.unknownFields = r14
                throw r13
            L_0x027f:
                r12.e()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property.<init>(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite):void");
        }
    }

    public interface PropertyOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder {
    }

    public static final class QualifiedNameTable extends GeneratedMessageLite implements QualifiedNameTableOrBuilder {
        public static Parser<QualifiedNameTable> PARSER = new AbstractParser<QualifiedNameTable>() {
            public QualifiedNameTable parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new QualifiedNameTable(codedInputStream, extensionRegistryLite);
            }
        };
        private static final QualifiedNameTable defaultInstance;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        /* access modifiers changed from: private */
        public List<QualifiedName> qualifiedName_;
        /* access modifiers changed from: private */
        public final ByteString unknownFields;

        public static final class Builder extends GeneratedMessageLite.Builder<QualifiedNameTable, Builder> implements QualifiedNameTableOrBuilder {
            private int bitField0_;
            private List<QualifiedName> qualifiedName_ = Collections.emptyList();

            private Builder() {
                maybeForceBuilderInitialization();
            }

            /* access modifiers changed from: private */
            public static Builder create() {
                return new Builder();
            }

            private void ensureQualifiedNameIsMutable() {
                if ((this.bitField0_ & 1) != 1) {
                    this.qualifiedName_ = new ArrayList(this.qualifiedName_);
                    this.bitField0_ |= 1;
                }
            }

            private void maybeForceBuilderInitialization() {
            }

            public QualifiedNameTable buildPartial() {
                QualifiedNameTable qualifiedNameTable = new QualifiedNameTable((GeneratedMessageLite.Builder) this);
                if ((this.bitField0_ & 1) == 1) {
                    this.qualifiedName_ = Collections.unmodifiableList(this.qualifiedName_);
                    this.bitField0_ &= -2;
                }
                List unused = qualifiedNameTable.qualifiedName_ = this.qualifiedName_;
                return qualifiedNameTable;
            }

            public QualifiedName getQualifiedName(int i11) {
                return this.qualifiedName_.get(i11);
            }

            public int getQualifiedNameCount() {
                return this.qualifiedName_.size();
            }

            public final boolean isInitialized() {
                for (int i11 = 0; i11 < getQualifiedNameCount(); i11++) {
                    if (!getQualifiedName(i11).isInitialized()) {
                        return false;
                    }
                }
                return true;
            }

            public QualifiedNameTable build() {
                QualifiedNameTable buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.a(buildPartial);
            }

            public QualifiedNameTable getDefaultInstanceForType() {
                return QualifiedNameTable.getDefaultInstance();
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Builder mergeFrom(QualifiedNameTable qualifiedNameTable) {
                if (qualifiedNameTable == QualifiedNameTable.getDefaultInstance()) {
                    return this;
                }
                if (!qualifiedNameTable.qualifiedName_.isEmpty()) {
                    if (this.qualifiedName_.isEmpty()) {
                        this.qualifiedName_ = qualifiedNameTable.qualifiedName_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureQualifiedNameIsMutable();
                        this.qualifiedName_.addAll(qualifiedNameTable.qualifiedName_);
                    }
                }
                setUnknownFields(getUnknownFields().concat(qualifiedNameTable.unknownFields));
                return this;
            }

            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                QualifiedNameTable qualifiedNameTable;
                QualifiedNameTable qualifiedNameTable2 = null;
                try {
                    QualifiedNameTable parsePartialFrom = QualifiedNameTable.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e11) {
                    qualifiedNameTable = (QualifiedNameTable) e11.getUnfinishedMessage();
                    throw e11;
                } catch (Throwable th2) {
                    th = th2;
                    qualifiedNameTable2 = qualifiedNameTable;
                }
                if (qualifiedNameTable2 != null) {
                    mergeFrom(qualifiedNameTable2);
                }
                throw th;
            }
        }

        public static final class QualifiedName extends GeneratedMessageLite implements QualifiedNameOrBuilder {
            public static Parser<QualifiedName> PARSER = new AbstractParser<QualifiedName>() {
                public QualifiedName parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return new QualifiedName(codedInputStream, extensionRegistryLite);
                }
            };
            private static final QualifiedName defaultInstance;
            /* access modifiers changed from: private */
            public int bitField0_;
            /* access modifiers changed from: private */
            public Kind kind_;
            private byte memoizedIsInitialized;
            private int memoizedSerializedSize;
            /* access modifiers changed from: private */
            public int parentQualifiedName_;
            /* access modifiers changed from: private */
            public int shortName_;
            /* access modifiers changed from: private */
            public final ByteString unknownFields;

            public static final class Builder extends GeneratedMessageLite.Builder<QualifiedName, Builder> implements QualifiedNameOrBuilder {
                private int bitField0_;
                private Kind kind_ = Kind.PACKAGE;
                private int parentQualifiedName_ = -1;
                private int shortName_;

                private Builder() {
                    maybeForceBuilderInitialization();
                }

                /* access modifiers changed from: private */
                public static Builder create() {
                    return new Builder();
                }

                private void maybeForceBuilderInitialization() {
                }

                public QualifiedName buildPartial() {
                    QualifiedName qualifiedName = new QualifiedName((GeneratedMessageLite.Builder) this);
                    int i11 = this.bitField0_;
                    int i12 = 1;
                    if ((i11 & 1) != 1) {
                        i12 = 0;
                    }
                    int unused = qualifiedName.parentQualifiedName_ = this.parentQualifiedName_;
                    if ((i11 & 2) == 2) {
                        i12 |= 2;
                    }
                    int unused2 = qualifiedName.shortName_ = this.shortName_;
                    if ((i11 & 4) == 4) {
                        i12 |= 4;
                    }
                    Kind unused3 = qualifiedName.kind_ = this.kind_;
                    int unused4 = qualifiedName.bitField0_ = i12;
                    return qualifiedName;
                }

                public boolean hasShortName() {
                    return (this.bitField0_ & 2) == 2;
                }

                public final boolean isInitialized() {
                    return hasShortName();
                }

                public Builder setKind(Kind kind) {
                    kind.getClass();
                    this.bitField0_ |= 4;
                    this.kind_ = kind;
                    return this;
                }

                public Builder setParentQualifiedName(int i11) {
                    this.bitField0_ |= 1;
                    this.parentQualifiedName_ = i11;
                    return this;
                }

                public Builder setShortName(int i11) {
                    this.bitField0_ |= 2;
                    this.shortName_ = i11;
                    return this;
                }

                public QualifiedName build() {
                    QualifiedName buildPartial = buildPartial();
                    if (buildPartial.isInitialized()) {
                        return buildPartial;
                    }
                    throw AbstractMessageLite.Builder.a(buildPartial);
                }

                public QualifiedName getDefaultInstanceForType() {
                    return QualifiedName.getDefaultInstance();
                }

                public Builder clone() {
                    return create().mergeFrom(buildPartial());
                }

                public Builder mergeFrom(QualifiedName qualifiedName) {
                    if (qualifiedName == QualifiedName.getDefaultInstance()) {
                        return this;
                    }
                    if (qualifiedName.hasParentQualifiedName()) {
                        setParentQualifiedName(qualifiedName.getParentQualifiedName());
                    }
                    if (qualifiedName.hasShortName()) {
                        setShortName(qualifiedName.getShortName());
                    }
                    if (qualifiedName.hasKind()) {
                        setKind(qualifiedName.getKind());
                    }
                    setUnknownFields(getUnknownFields().concat(qualifiedName.unknownFields));
                    return this;
                }

                public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                    QualifiedName qualifiedName;
                    QualifiedName qualifiedName2 = null;
                    try {
                        QualifiedName parsePartialFrom = QualifiedName.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e11) {
                        qualifiedName = (QualifiedName) e11.getUnfinishedMessage();
                        throw e11;
                    } catch (Throwable th2) {
                        th = th2;
                        qualifiedName2 = qualifiedName;
                    }
                    if (qualifiedName2 != null) {
                        mergeFrom(qualifiedName2);
                    }
                    throw th;
                }
            }

            public enum Kind implements Internal.EnumLite {
                CLASS(0, 0),
                PACKAGE(1, 1),
                LOCAL(2, 2);
                
                private static Internal.EnumLiteMap<Kind> internalValueMap;
                private final int value;

                /* access modifiers changed from: public */
                static {
                    internalValueMap = new Internal.EnumLiteMap<Kind>() {
                        public Kind findValueByNumber(int i11) {
                            return Kind.valueOf(i11);
                        }
                    };
                }

                private Kind(int i11, int i12) {
                    this.value = i12;
                }

                public final int getNumber() {
                    return this.value;
                }

                public static Kind valueOf(int i11) {
                    if (i11 == 0) {
                        return CLASS;
                    }
                    if (i11 == 1) {
                        return PACKAGE;
                    }
                    if (i11 != 2) {
                        return null;
                    }
                    return LOCAL;
                }
            }

            static {
                QualifiedName qualifiedName = new QualifiedName(true);
                defaultInstance = qualifiedName;
                qualifiedName.initFields();
            }

            public static QualifiedName getDefaultInstance() {
                return defaultInstance;
            }

            private void initFields() {
                this.parentQualifiedName_ = -1;
                this.shortName_ = 0;
                this.kind_ = Kind.PACKAGE;
            }

            public static Builder newBuilder() {
                return Builder.create();
            }

            public Kind getKind() {
                return this.kind_;
            }

            public int getParentQualifiedName() {
                return this.parentQualifiedName_;
            }

            public Parser<QualifiedName> getParserForType() {
                return PARSER;
            }

            public int getSerializedSize() {
                int i11 = this.memoizedSerializedSize;
                if (i11 != -1) {
                    return i11;
                }
                int i12 = 0;
                if ((this.bitField0_ & 1) == 1) {
                    i12 = 0 + CodedOutputStream.computeInt32Size(1, this.parentQualifiedName_);
                }
                if ((this.bitField0_ & 2) == 2) {
                    i12 += CodedOutputStream.computeInt32Size(2, this.shortName_);
                }
                if ((this.bitField0_ & 4) == 4) {
                    i12 += CodedOutputStream.computeEnumSize(3, this.kind_.getNumber());
                }
                int size = i12 + this.unknownFields.size();
                this.memoizedSerializedSize = size;
                return size;
            }

            public int getShortName() {
                return this.shortName_;
            }

            public boolean hasKind() {
                return (this.bitField0_ & 4) == 4;
            }

            public boolean hasParentQualifiedName() {
                return (this.bitField0_ & 1) == 1;
            }

            public boolean hasShortName() {
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
                if (!hasShortName()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
                this.memoizedIsInitialized = 1;
                return true;
            }

            public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
                getSerializedSize();
                if ((this.bitField0_ & 1) == 1) {
                    codedOutputStream.writeInt32(1, this.parentQualifiedName_);
                }
                if ((this.bitField0_ & 2) == 2) {
                    codedOutputStream.writeInt32(2, this.shortName_);
                }
                if ((this.bitField0_ & 4) == 4) {
                    codedOutputStream.writeEnum(3, this.kind_.getNumber());
                }
                codedOutputStream.writeRawBytes(this.unknownFields);
            }

            public static Builder newBuilder(QualifiedName qualifiedName) {
                return newBuilder().mergeFrom(qualifiedName);
            }

            public QualifiedName getDefaultInstanceForType() {
                return defaultInstance;
            }

            public Builder newBuilderForType() {
                return newBuilder();
            }

            public Builder toBuilder() {
                return newBuilder(this);
            }

            private QualifiedName(GeneratedMessageLite.Builder builder) {
                super(builder);
                this.memoizedIsInitialized = -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = builder.getUnknownFields();
            }

            private QualifiedName(boolean z11) {
                this.memoizedIsInitialized = -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = ByteString.EMPTY;
            }

            private QualifiedName(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                this.parentQualifiedName_ = codedInputStream.readInt32();
                            } else if (readTag == 16) {
                                this.bitField0_ |= 2;
                                this.shortName_ = codedInputStream.readInt32();
                            } else if (readTag == 24) {
                                int readEnum = codedInputStream.readEnum();
                                Kind valueOf = Kind.valueOf(readEnum);
                                if (valueOf == null) {
                                    newInstance.writeRawVarint32(readTag);
                                    newInstance.writeRawVarint32(readEnum);
                                } else {
                                    this.bitField0_ |= 4;
                                    this.kind_ = valueOf;
                                }
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

        public interface QualifiedNameOrBuilder extends MessageLiteOrBuilder {
        }

        static {
            QualifiedNameTable qualifiedNameTable = new QualifiedNameTable(true);
            defaultInstance = qualifiedNameTable;
            qualifiedNameTable.initFields();
        }

        public static QualifiedNameTable getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.qualifiedName_ = Collections.emptyList();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Parser<QualifiedNameTable> getParserForType() {
            return PARSER;
        }

        public QualifiedName getQualifiedName(int i11) {
            return this.qualifiedName_.get(i11);
        }

        public int getQualifiedNameCount() {
            return this.qualifiedName_.size();
        }

        public int getSerializedSize() {
            int i11 = this.memoizedSerializedSize;
            if (i11 != -1) {
                return i11;
            }
            int i12 = 0;
            for (int i13 = 0; i13 < this.qualifiedName_.size(); i13++) {
                i12 += CodedOutputStream.computeMessageSize(1, this.qualifiedName_.get(i13));
            }
            int size = i12 + this.unknownFields.size();
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
            for (int i11 = 0; i11 < getQualifiedNameCount(); i11++) {
                if (!getQualifiedName(i11).isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            for (int i11 = 0; i11 < this.qualifiedName_.size(); i11++) {
                codedOutputStream.writeMessage(1, this.qualifiedName_.get(i11));
            }
            codedOutputStream.writeRawBytes(this.unknownFields);
        }

        public static Builder newBuilder(QualifiedNameTable qualifiedNameTable) {
            return newBuilder().mergeFrom(qualifiedNameTable);
        }

        public QualifiedNameTable getDefaultInstanceForType() {
            return defaultInstance;
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        private QualifiedNameTable(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private QualifiedNameTable(boolean z11) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        private QualifiedNameTable(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                this.qualifiedName_ = new ArrayList();
                                z12 |= true;
                            }
                            this.qualifiedName_.add(codedInputStream.readMessage(QualifiedName.PARSER, extensionRegistryLite));
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
                        this.qualifiedName_ = Collections.unmodifiableList(this.qualifiedName_);
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
                this.qualifiedName_ = Collections.unmodifiableList(this.qualifiedName_);
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

    public interface QualifiedNameTableOrBuilder extends MessageLiteOrBuilder {
    }

    public static final class StringTable extends GeneratedMessageLite implements StringTableOrBuilder {
        public static Parser<StringTable> PARSER = new AbstractParser<StringTable>() {
            public StringTable parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new StringTable(codedInputStream, extensionRegistryLite);
            }
        };
        private static final StringTable defaultInstance;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        /* access modifiers changed from: private */
        public LazyStringList string_;
        /* access modifiers changed from: private */
        public final ByteString unknownFields;

        public static final class Builder extends GeneratedMessageLite.Builder<StringTable, Builder> implements StringTableOrBuilder {
            private int bitField0_;
            private LazyStringList string_ = LazyStringArrayList.EMPTY;

            private Builder() {
                maybeForceBuilderInitialization();
            }

            /* access modifiers changed from: private */
            public static Builder create() {
                return new Builder();
            }

            private void ensureStringIsMutable() {
                if ((this.bitField0_ & 1) != 1) {
                    this.string_ = new LazyStringArrayList(this.string_);
                    this.bitField0_ |= 1;
                }
            }

            private void maybeForceBuilderInitialization() {
            }

            public StringTable buildPartial() {
                StringTable stringTable = new StringTable((GeneratedMessageLite.Builder) this);
                if ((this.bitField0_ & 1) == 1) {
                    this.string_ = this.string_.getUnmodifiableView();
                    this.bitField0_ &= -2;
                }
                LazyStringList unused = stringTable.string_ = this.string_;
                return stringTable;
            }

            public final boolean isInitialized() {
                return true;
            }

            public StringTable build() {
                StringTable buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.a(buildPartial);
            }

            public StringTable getDefaultInstanceForType() {
                return StringTable.getDefaultInstance();
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Builder mergeFrom(StringTable stringTable) {
                if (stringTable == StringTable.getDefaultInstance()) {
                    return this;
                }
                if (!stringTable.string_.isEmpty()) {
                    if (this.string_.isEmpty()) {
                        this.string_ = stringTable.string_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureStringIsMutable();
                        this.string_.addAll(stringTable.string_);
                    }
                }
                setUnknownFields(getUnknownFields().concat(stringTable.unknownFields));
                return this;
            }

            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                StringTable stringTable;
                StringTable stringTable2 = null;
                try {
                    StringTable parsePartialFrom = StringTable.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e11) {
                    stringTable = (StringTable) e11.getUnfinishedMessage();
                    throw e11;
                } catch (Throwable th2) {
                    th = th2;
                    stringTable2 = stringTable;
                }
                if (stringTable2 != null) {
                    mergeFrom(stringTable2);
                }
                throw th;
            }
        }

        static {
            StringTable stringTable = new StringTable(true);
            defaultInstance = stringTable;
            stringTable.initFields();
        }

        public static StringTable getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.string_ = LazyStringArrayList.EMPTY;
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Parser<StringTable> getParserForType() {
            return PARSER;
        }

        public int getSerializedSize() {
            int i11 = this.memoizedSerializedSize;
            if (i11 != -1) {
                return i11;
            }
            int i12 = 0;
            for (int i13 = 0; i13 < this.string_.size(); i13++) {
                i12 += CodedOutputStream.computeBytesSizeNoTag(this.string_.getByteString(i13));
            }
            int size = 0 + i12 + (getStringList().size() * 1) + this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        public String getString(int i11) {
            return (String) this.string_.get(i11);
        }

        public ProtocolStringList getStringList() {
            return this.string_;
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
            for (int i11 = 0; i11 < this.string_.size(); i11++) {
                codedOutputStream.writeBytes(1, this.string_.getByteString(i11));
            }
            codedOutputStream.writeRawBytes(this.unknownFields);
        }

        public static Builder newBuilder(StringTable stringTable) {
            return newBuilder().mergeFrom(stringTable);
        }

        public StringTable getDefaultInstanceForType() {
            return defaultInstance;
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        private StringTable(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private StringTable(boolean z11) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        private StringTable(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            ByteString readBytes = codedInputStream.readBytes();
                            if (!z12 || !true) {
                                this.string_ = new LazyStringArrayList();
                                z12 |= true;
                            }
                            this.string_.add(readBytes);
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
                        this.string_ = this.string_.getUnmodifiableView();
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
                this.string_ = this.string_.getUnmodifiableView();
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

    public interface StringTableOrBuilder extends MessageLiteOrBuilder {
    }

    public static final class Type extends GeneratedMessageLite.ExtendableMessage<Type> implements TypeOrBuilder {
        public static Parser<Type> PARSER = new AbstractParser<Type>() {
            public Type parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Type(codedInputStream, extensionRegistryLite);
            }
        };
        private static final Type defaultInstance;
        /* access modifiers changed from: private */
        public int abbreviatedTypeId_;
        /* access modifiers changed from: private */
        public Type abbreviatedType_;
        /* access modifiers changed from: private */
        public List<Argument> argument_;
        /* access modifiers changed from: private */
        public int bitField0_;
        /* access modifiers changed from: private */
        public int className_;
        /* access modifiers changed from: private */
        public int flags_;
        /* access modifiers changed from: private */
        public int flexibleTypeCapabilitiesId_;
        /* access modifiers changed from: private */
        public int flexibleUpperBoundId_;
        /* access modifiers changed from: private */
        public Type flexibleUpperBound_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        /* access modifiers changed from: private */
        public boolean nullable_;
        /* access modifiers changed from: private */
        public int outerTypeId_;
        /* access modifiers changed from: private */
        public Type outerType_;
        /* access modifiers changed from: private */
        public int typeAliasName_;
        /* access modifiers changed from: private */
        public int typeParameterName_;
        /* access modifiers changed from: private */
        public int typeParameter_;
        /* access modifiers changed from: private */
        public final ByteString unknownFields;

        public static final class Argument extends GeneratedMessageLite implements ArgumentOrBuilder {
            public static Parser<Argument> PARSER = new AbstractParser<Argument>() {
                public Argument parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return new Argument(codedInputStream, extensionRegistryLite);
                }
            };
            private static final Argument defaultInstance;
            /* access modifiers changed from: private */
            public int bitField0_;
            private byte memoizedIsInitialized;
            private int memoizedSerializedSize;
            /* access modifiers changed from: private */
            public Projection projection_;
            /* access modifiers changed from: private */
            public int typeId_;
            /* access modifiers changed from: private */
            public Type type_;
            /* access modifiers changed from: private */
            public final ByteString unknownFields;

            public static final class Builder extends GeneratedMessageLite.Builder<Argument, Builder> implements ArgumentOrBuilder {
                private int bitField0_;
                private Projection projection_ = Projection.INV;
                private int typeId_;
                private Type type_ = Type.getDefaultInstance();

                private Builder() {
                    maybeForceBuilderInitialization();
                }

                /* access modifiers changed from: private */
                public static Builder create() {
                    return new Builder();
                }

                private void maybeForceBuilderInitialization() {
                }

                public Argument buildPartial() {
                    Argument argument = new Argument((GeneratedMessageLite.Builder) this);
                    int i11 = this.bitField0_;
                    int i12 = 1;
                    if ((i11 & 1) != 1) {
                        i12 = 0;
                    }
                    Projection unused = argument.projection_ = this.projection_;
                    if ((i11 & 2) == 2) {
                        i12 |= 2;
                    }
                    Type unused2 = argument.type_ = this.type_;
                    if ((i11 & 4) == 4) {
                        i12 |= 4;
                    }
                    int unused3 = argument.typeId_ = this.typeId_;
                    int unused4 = argument.bitField0_ = i12;
                    return argument;
                }

                public Type getType() {
                    return this.type_;
                }

                public boolean hasType() {
                    return (this.bitField0_ & 2) == 2;
                }

                public final boolean isInitialized() {
                    if (!hasType() || getType().isInitialized()) {
                        return true;
                    }
                    return false;
                }

                public Builder mergeType(Type type) {
                    if ((this.bitField0_ & 2) != 2 || this.type_ == Type.getDefaultInstance()) {
                        this.type_ = type;
                    } else {
                        this.type_ = Type.newBuilder(this.type_).mergeFrom(type).buildPartial();
                    }
                    this.bitField0_ |= 2;
                    return this;
                }

                public Builder setProjection(Projection projection) {
                    projection.getClass();
                    this.bitField0_ |= 1;
                    this.projection_ = projection;
                    return this;
                }

                public Builder setTypeId(int i11) {
                    this.bitField0_ |= 4;
                    this.typeId_ = i11;
                    return this;
                }

                public Argument build() {
                    Argument buildPartial = buildPartial();
                    if (buildPartial.isInitialized()) {
                        return buildPartial;
                    }
                    throw AbstractMessageLite.Builder.a(buildPartial);
                }

                public Argument getDefaultInstanceForType() {
                    return Argument.getDefaultInstance();
                }

                public Builder clone() {
                    return create().mergeFrom(buildPartial());
                }

                public Builder mergeFrom(Argument argument) {
                    if (argument == Argument.getDefaultInstance()) {
                        return this;
                    }
                    if (argument.hasProjection()) {
                        setProjection(argument.getProjection());
                    }
                    if (argument.hasType()) {
                        mergeType(argument.getType());
                    }
                    if (argument.hasTypeId()) {
                        setTypeId(argument.getTypeId());
                    }
                    setUnknownFields(getUnknownFields().concat(argument.unknownFields));
                    return this;
                }

                public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                    Argument argument;
                    Argument argument2 = null;
                    try {
                        Argument parsePartialFrom = Argument.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e11) {
                        argument = (Argument) e11.getUnfinishedMessage();
                        throw e11;
                    } catch (Throwable th2) {
                        th = th2;
                        argument2 = argument;
                    }
                    if (argument2 != null) {
                        mergeFrom(argument2);
                    }
                    throw th;
                }
            }

            public enum Projection implements Internal.EnumLite {
                IN(0, 0),
                OUT(1, 1),
                INV(2, 2),
                STAR(3, 3);
                
                private static Internal.EnumLiteMap<Projection> internalValueMap;
                private final int value;

                /* access modifiers changed from: public */
                static {
                    internalValueMap = new Internal.EnumLiteMap<Projection>() {
                        public Projection findValueByNumber(int i11) {
                            return Projection.valueOf(i11);
                        }
                    };
                }

                private Projection(int i11, int i12) {
                    this.value = i12;
                }

                public final int getNumber() {
                    return this.value;
                }

                public static Projection valueOf(int i11) {
                    if (i11 == 0) {
                        return IN;
                    }
                    if (i11 == 1) {
                        return OUT;
                    }
                    if (i11 == 2) {
                        return INV;
                    }
                    if (i11 != 3) {
                        return null;
                    }
                    return STAR;
                }
            }

            static {
                Argument argument = new Argument(true);
                defaultInstance = argument;
                argument.initFields();
            }

            public static Argument getDefaultInstance() {
                return defaultInstance;
            }

            private void initFields() {
                this.projection_ = Projection.INV;
                this.type_ = Type.getDefaultInstance();
                this.typeId_ = 0;
            }

            public static Builder newBuilder() {
                return Builder.create();
            }

            public Parser<Argument> getParserForType() {
                return PARSER;
            }

            public Projection getProjection() {
                return this.projection_;
            }

            public int getSerializedSize() {
                int i11 = this.memoizedSerializedSize;
                if (i11 != -1) {
                    return i11;
                }
                int i12 = 0;
                if ((this.bitField0_ & 1) == 1) {
                    i12 = 0 + CodedOutputStream.computeEnumSize(1, this.projection_.getNumber());
                }
                if ((this.bitField0_ & 2) == 2) {
                    i12 += CodedOutputStream.computeMessageSize(2, this.type_);
                }
                if ((this.bitField0_ & 4) == 4) {
                    i12 += CodedOutputStream.computeInt32Size(3, this.typeId_);
                }
                int size = i12 + this.unknownFields.size();
                this.memoizedSerializedSize = size;
                return size;
            }

            public Type getType() {
                return this.type_;
            }

            public int getTypeId() {
                return this.typeId_;
            }

            public boolean hasProjection() {
                return (this.bitField0_ & 1) == 1;
            }

            public boolean hasType() {
                return (this.bitField0_ & 2) == 2;
            }

            public boolean hasTypeId() {
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
                if (!hasType() || getType().isInitialized()) {
                    this.memoizedIsInitialized = 1;
                    return true;
                }
                this.memoizedIsInitialized = 0;
                return false;
            }

            public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
                getSerializedSize();
                if ((this.bitField0_ & 1) == 1) {
                    codedOutputStream.writeEnum(1, this.projection_.getNumber());
                }
                if ((this.bitField0_ & 2) == 2) {
                    codedOutputStream.writeMessage(2, this.type_);
                }
                if ((this.bitField0_ & 4) == 4) {
                    codedOutputStream.writeInt32(3, this.typeId_);
                }
                codedOutputStream.writeRawBytes(this.unknownFields);
            }

            public static Builder newBuilder(Argument argument) {
                return newBuilder().mergeFrom(argument);
            }

            public Argument getDefaultInstanceForType() {
                return defaultInstance;
            }

            public Builder newBuilderForType() {
                return newBuilder();
            }

            public Builder toBuilder() {
                return newBuilder(this);
            }

            private Argument(GeneratedMessageLite.Builder builder) {
                super(builder);
                this.memoizedIsInitialized = -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = builder.getUnknownFields();
            }

            private Argument(boolean z11) {
                this.memoizedIsInitialized = -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = ByteString.EMPTY;
            }

            private Argument(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                int readEnum = codedInputStream.readEnum();
                                Projection valueOf = Projection.valueOf(readEnum);
                                if (valueOf == null) {
                                    newInstance.writeRawVarint32(readTag);
                                    newInstance.writeRawVarint32(readEnum);
                                } else {
                                    this.bitField0_ |= 1;
                                    this.projection_ = valueOf;
                                }
                            } else if (readTag == 18) {
                                Builder builder = (this.bitField0_ & 2) == 2 ? this.type_.toBuilder() : null;
                                Type type = (Type) codedInputStream.readMessage(Type.PARSER, extensionRegistryLite);
                                this.type_ = type;
                                if (builder != null) {
                                    builder.mergeFrom(type);
                                    this.type_ = builder.buildPartial();
                                }
                                this.bitField0_ |= 2;
                            } else if (readTag == 24) {
                                this.bitField0_ |= 4;
                                this.typeId_ = codedInputStream.readInt32();
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

        public interface ArgumentOrBuilder extends MessageLiteOrBuilder {
        }

        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<Type, Builder> implements TypeOrBuilder {
            private int abbreviatedTypeId_;
            private Type abbreviatedType_ = Type.getDefaultInstance();
            private List<Argument> argument_ = Collections.emptyList();
            private int bitField0_;
            private int className_;
            private int flags_;
            private int flexibleTypeCapabilitiesId_;
            private int flexibleUpperBoundId_;
            private Type flexibleUpperBound_ = Type.getDefaultInstance();
            private boolean nullable_;
            private int outerTypeId_;
            private Type outerType_ = Type.getDefaultInstance();
            private int typeAliasName_;
            private int typeParameterName_;
            private int typeParameter_;

            private Builder() {
                maybeForceBuilderInitialization();
            }

            /* access modifiers changed from: private */
            public static Builder create() {
                return new Builder();
            }

            private void ensureArgumentIsMutable() {
                if ((this.bitField0_ & 1) != 1) {
                    this.argument_ = new ArrayList(this.argument_);
                    this.bitField0_ |= 1;
                }
            }

            private void maybeForceBuilderInitialization() {
            }

            public Type buildPartial() {
                Type type = new Type((GeneratedMessageLite.ExtendableBuilder) this);
                int i11 = this.bitField0_;
                int i12 = 1;
                if ((i11 & 1) == 1) {
                    this.argument_ = Collections.unmodifiableList(this.argument_);
                    this.bitField0_ &= -2;
                }
                List unused = type.argument_ = this.argument_;
                if ((i11 & 2) != 2) {
                    i12 = 0;
                }
                boolean unused2 = type.nullable_ = this.nullable_;
                if ((i11 & 4) == 4) {
                    i12 |= 2;
                }
                int unused3 = type.flexibleTypeCapabilitiesId_ = this.flexibleTypeCapabilitiesId_;
                if ((i11 & 8) == 8) {
                    i12 |= 4;
                }
                Type unused4 = type.flexibleUpperBound_ = this.flexibleUpperBound_;
                if ((i11 & 16) == 16) {
                    i12 |= 8;
                }
                int unused5 = type.flexibleUpperBoundId_ = this.flexibleUpperBoundId_;
                if ((i11 & 32) == 32) {
                    i12 |= 16;
                }
                int unused6 = type.className_ = this.className_;
                if ((i11 & 64) == 64) {
                    i12 |= 32;
                }
                int unused7 = type.typeParameter_ = this.typeParameter_;
                if ((i11 & 128) == 128) {
                    i12 |= 64;
                }
                int unused8 = type.typeParameterName_ = this.typeParameterName_;
                if ((i11 & 256) == 256) {
                    i12 |= 128;
                }
                int unused9 = type.typeAliasName_ = this.typeAliasName_;
                if ((i11 & 512) == 512) {
                    i12 |= 256;
                }
                Type unused10 = type.outerType_ = this.outerType_;
                if ((i11 & 1024) == 1024) {
                    i12 |= 512;
                }
                int unused11 = type.outerTypeId_ = this.outerTypeId_;
                if ((i11 & 2048) == 2048) {
                    i12 |= 1024;
                }
                Type unused12 = type.abbreviatedType_ = this.abbreviatedType_;
                if ((i11 & 4096) == 4096) {
                    i12 |= 2048;
                }
                int unused13 = type.abbreviatedTypeId_ = this.abbreviatedTypeId_;
                if ((i11 & 8192) == 8192) {
                    i12 |= 4096;
                }
                int unused14 = type.flags_ = this.flags_;
                int unused15 = type.bitField0_ = i12;
                return type;
            }

            public Type getAbbreviatedType() {
                return this.abbreviatedType_;
            }

            public Argument getArgument(int i11) {
                return this.argument_.get(i11);
            }

            public int getArgumentCount() {
                return this.argument_.size();
            }

            public Type getFlexibleUpperBound() {
                return this.flexibleUpperBound_;
            }

            public Type getOuterType() {
                return this.outerType_;
            }

            public boolean hasAbbreviatedType() {
                return (this.bitField0_ & 2048) == 2048;
            }

            public boolean hasFlexibleUpperBound() {
                return (this.bitField0_ & 8) == 8;
            }

            public boolean hasOuterType() {
                return (this.bitField0_ & 512) == 512;
            }

            public final boolean isInitialized() {
                for (int i11 = 0; i11 < getArgumentCount(); i11++) {
                    if (!getArgument(i11).isInitialized()) {
                        return false;
                    }
                }
                if (hasFlexibleUpperBound() && !getFlexibleUpperBound().isInitialized()) {
                    return false;
                }
                if (hasOuterType() && !getOuterType().isInitialized()) {
                    return false;
                }
                if ((!hasAbbreviatedType() || getAbbreviatedType().isInitialized()) && c()) {
                    return true;
                }
                return false;
            }

            public Builder mergeAbbreviatedType(Type type) {
                if ((this.bitField0_ & 2048) != 2048 || this.abbreviatedType_ == Type.getDefaultInstance()) {
                    this.abbreviatedType_ = type;
                } else {
                    this.abbreviatedType_ = Type.newBuilder(this.abbreviatedType_).mergeFrom(type).buildPartial();
                }
                this.bitField0_ |= 2048;
                return this;
            }

            public Builder mergeFlexibleUpperBound(Type type) {
                if ((this.bitField0_ & 8) != 8 || this.flexibleUpperBound_ == Type.getDefaultInstance()) {
                    this.flexibleUpperBound_ = type;
                } else {
                    this.flexibleUpperBound_ = Type.newBuilder(this.flexibleUpperBound_).mergeFrom(type).buildPartial();
                }
                this.bitField0_ |= 8;
                return this;
            }

            public Builder mergeOuterType(Type type) {
                if ((this.bitField0_ & 512) != 512 || this.outerType_ == Type.getDefaultInstance()) {
                    this.outerType_ = type;
                } else {
                    this.outerType_ = Type.newBuilder(this.outerType_).mergeFrom(type).buildPartial();
                }
                this.bitField0_ |= 512;
                return this;
            }

            public Builder setAbbreviatedTypeId(int i11) {
                this.bitField0_ |= 4096;
                this.abbreviatedTypeId_ = i11;
                return this;
            }

            public Builder setClassName(int i11) {
                this.bitField0_ |= 32;
                this.className_ = i11;
                return this;
            }

            public Builder setFlags(int i11) {
                this.bitField0_ |= 8192;
                this.flags_ = i11;
                return this;
            }

            public Builder setFlexibleTypeCapabilitiesId(int i11) {
                this.bitField0_ |= 4;
                this.flexibleTypeCapabilitiesId_ = i11;
                return this;
            }

            public Builder setFlexibleUpperBoundId(int i11) {
                this.bitField0_ |= 16;
                this.flexibleUpperBoundId_ = i11;
                return this;
            }

            public Builder setNullable(boolean z11) {
                this.bitField0_ |= 2;
                this.nullable_ = z11;
                return this;
            }

            public Builder setOuterTypeId(int i11) {
                this.bitField0_ |= 1024;
                this.outerTypeId_ = i11;
                return this;
            }

            public Builder setTypeAliasName(int i11) {
                this.bitField0_ |= 256;
                this.typeAliasName_ = i11;
                return this;
            }

            public Builder setTypeParameter(int i11) {
                this.bitField0_ |= 64;
                this.typeParameter_ = i11;
                return this;
            }

            public Builder setTypeParameterName(int i11) {
                this.bitField0_ |= 128;
                this.typeParameterName_ = i11;
                return this;
            }

            public Type build() {
                Type buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.a(buildPartial);
            }

            public Type getDefaultInstanceForType() {
                return Type.getDefaultInstance();
            }

            public Builder mergeFrom(Type type) {
                if (type == Type.getDefaultInstance()) {
                    return this;
                }
                if (!type.argument_.isEmpty()) {
                    if (this.argument_.isEmpty()) {
                        this.argument_ = type.argument_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureArgumentIsMutable();
                        this.argument_.addAll(type.argument_);
                    }
                }
                if (type.hasNullable()) {
                    setNullable(type.getNullable());
                }
                if (type.hasFlexibleTypeCapabilitiesId()) {
                    setFlexibleTypeCapabilitiesId(type.getFlexibleTypeCapabilitiesId());
                }
                if (type.hasFlexibleUpperBound()) {
                    mergeFlexibleUpperBound(type.getFlexibleUpperBound());
                }
                if (type.hasFlexibleUpperBoundId()) {
                    setFlexibleUpperBoundId(type.getFlexibleUpperBoundId());
                }
                if (type.hasClassName()) {
                    setClassName(type.getClassName());
                }
                if (type.hasTypeParameter()) {
                    setTypeParameter(type.getTypeParameter());
                }
                if (type.hasTypeParameterName()) {
                    setTypeParameterName(type.getTypeParameterName());
                }
                if (type.hasTypeAliasName()) {
                    setTypeAliasName(type.getTypeAliasName());
                }
                if (type.hasOuterType()) {
                    mergeOuterType(type.getOuterType());
                }
                if (type.hasOuterTypeId()) {
                    setOuterTypeId(type.getOuterTypeId());
                }
                if (type.hasAbbreviatedType()) {
                    mergeAbbreviatedType(type.getAbbreviatedType());
                }
                if (type.hasAbbreviatedTypeId()) {
                    setAbbreviatedTypeId(type.getAbbreviatedTypeId());
                }
                if (type.hasFlags()) {
                    setFlags(type.getFlags());
                }
                d(type);
                setUnknownFields(getUnknownFields().concat(type.unknownFields));
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                Type type;
                Type type2 = null;
                try {
                    Type parsePartialFrom = Type.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e11) {
                    type = (Type) e11.getUnfinishedMessage();
                    throw e11;
                } catch (Throwable th2) {
                    th = th2;
                    type2 = type;
                }
                if (type2 != null) {
                    mergeFrom(type2);
                }
                throw th;
            }
        }

        static {
            Type type = new Type(true);
            defaultInstance = type;
            type.initFields();
        }

        public static Type getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.argument_ = Collections.emptyList();
            this.nullable_ = false;
            this.flexibleTypeCapabilitiesId_ = 0;
            this.flexibleUpperBound_ = getDefaultInstance();
            this.flexibleUpperBoundId_ = 0;
            this.className_ = 0;
            this.typeParameter_ = 0;
            this.typeParameterName_ = 0;
            this.typeAliasName_ = 0;
            this.outerType_ = getDefaultInstance();
            this.outerTypeId_ = 0;
            this.abbreviatedType_ = getDefaultInstance();
            this.abbreviatedTypeId_ = 0;
            this.flags_ = 0;
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Type getAbbreviatedType() {
            return this.abbreviatedType_;
        }

        public int getAbbreviatedTypeId() {
            return this.abbreviatedTypeId_;
        }

        public Argument getArgument(int i11) {
            return this.argument_.get(i11);
        }

        public int getArgumentCount() {
            return this.argument_.size();
        }

        public List<Argument> getArgumentList() {
            return this.argument_;
        }

        public int getClassName() {
            return this.className_;
        }

        public int getFlags() {
            return this.flags_;
        }

        public int getFlexibleTypeCapabilitiesId() {
            return this.flexibleTypeCapabilitiesId_;
        }

        public Type getFlexibleUpperBound() {
            return this.flexibleUpperBound_;
        }

        public int getFlexibleUpperBoundId() {
            return this.flexibleUpperBoundId_;
        }

        public boolean getNullable() {
            return this.nullable_;
        }

        public Type getOuterType() {
            return this.outerType_;
        }

        public int getOuterTypeId() {
            return this.outerTypeId_;
        }

        public Parser<Type> getParserForType() {
            return PARSER;
        }

        public int getSerializedSize() {
            int i11;
            int i12 = this.memoizedSerializedSize;
            if (i12 != -1) {
                return i12;
            }
            if ((this.bitField0_ & 4096) == 4096) {
                i11 = CodedOutputStream.computeInt32Size(1, this.flags_) + 0;
            } else {
                i11 = 0;
            }
            for (int i13 = 0; i13 < this.argument_.size(); i13++) {
                i11 += CodedOutputStream.computeMessageSize(2, this.argument_.get(i13));
            }
            if ((this.bitField0_ & 1) == 1) {
                i11 += CodedOutputStream.computeBoolSize(3, this.nullable_);
            }
            if ((this.bitField0_ & 2) == 2) {
                i11 += CodedOutputStream.computeInt32Size(4, this.flexibleTypeCapabilitiesId_);
            }
            if ((this.bitField0_ & 4) == 4) {
                i11 += CodedOutputStream.computeMessageSize(5, this.flexibleUpperBound_);
            }
            if ((this.bitField0_ & 16) == 16) {
                i11 += CodedOutputStream.computeInt32Size(6, this.className_);
            }
            if ((this.bitField0_ & 32) == 32) {
                i11 += CodedOutputStream.computeInt32Size(7, this.typeParameter_);
            }
            if ((this.bitField0_ & 8) == 8) {
                i11 += CodedOutputStream.computeInt32Size(8, this.flexibleUpperBoundId_);
            }
            if ((this.bitField0_ & 64) == 64) {
                i11 += CodedOutputStream.computeInt32Size(9, this.typeParameterName_);
            }
            if ((this.bitField0_ & 256) == 256) {
                i11 += CodedOutputStream.computeMessageSize(10, this.outerType_);
            }
            if ((this.bitField0_ & 512) == 512) {
                i11 += CodedOutputStream.computeInt32Size(11, this.outerTypeId_);
            }
            if ((this.bitField0_ & 128) == 128) {
                i11 += CodedOutputStream.computeInt32Size(12, this.typeAliasName_);
            }
            if ((this.bitField0_ & 1024) == 1024) {
                i11 += CodedOutputStream.computeMessageSize(13, this.abbreviatedType_);
            }
            if ((this.bitField0_ & 2048) == 2048) {
                i11 += CodedOutputStream.computeInt32Size(14, this.abbreviatedTypeId_);
            }
            int i14 = i11 + i() + this.unknownFields.size();
            this.memoizedSerializedSize = i14;
            return i14;
        }

        public int getTypeAliasName() {
            return this.typeAliasName_;
        }

        public int getTypeParameter() {
            return this.typeParameter_;
        }

        public int getTypeParameterName() {
            return this.typeParameterName_;
        }

        public boolean hasAbbreviatedType() {
            return (this.bitField0_ & 1024) == 1024;
        }

        public boolean hasAbbreviatedTypeId() {
            return (this.bitField0_ & 2048) == 2048;
        }

        public boolean hasClassName() {
            return (this.bitField0_ & 16) == 16;
        }

        public boolean hasFlags() {
            return (this.bitField0_ & 4096) == 4096;
        }

        public boolean hasFlexibleTypeCapabilitiesId() {
            return (this.bitField0_ & 2) == 2;
        }

        public boolean hasFlexibleUpperBound() {
            return (this.bitField0_ & 4) == 4;
        }

        public boolean hasFlexibleUpperBoundId() {
            return (this.bitField0_ & 8) == 8;
        }

        public boolean hasNullable() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean hasOuterType() {
            return (this.bitField0_ & 256) == 256;
        }

        public boolean hasOuterTypeId() {
            return (this.bitField0_ & 512) == 512;
        }

        public boolean hasTypeAliasName() {
            return (this.bitField0_ & 128) == 128;
        }

        public boolean hasTypeParameter() {
            return (this.bitField0_ & 32) == 32;
        }

        public boolean hasTypeParameterName() {
            return (this.bitField0_ & 64) == 64;
        }

        public final boolean isInitialized() {
            byte b11 = this.memoizedIsInitialized;
            if (b11 == 1) {
                return true;
            }
            if (b11 == 0) {
                return false;
            }
            for (int i11 = 0; i11 < getArgumentCount(); i11++) {
                if (!getArgument(i11).isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            if (hasFlexibleUpperBound() && !getFlexibleUpperBound().isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            } else if (hasOuterType() && !getOuterType().isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            } else if (hasAbbreviatedType() && !getAbbreviatedType().isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            } else if (!h()) {
                this.memoizedIsInitialized = 0;
                return false;
            } else {
                this.memoizedIsInitialized = 1;
                return true;
            }
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter j11 = j();
            if ((this.bitField0_ & 4096) == 4096) {
                codedOutputStream.writeInt32(1, this.flags_);
            }
            for (int i11 = 0; i11 < this.argument_.size(); i11++) {
                codedOutputStream.writeMessage(2, this.argument_.get(i11));
            }
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeBool(3, this.nullable_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeInt32(4, this.flexibleTypeCapabilitiesId_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeMessage(5, this.flexibleUpperBound_);
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.writeInt32(6, this.className_);
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.writeInt32(7, this.typeParameter_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeInt32(8, this.flexibleUpperBoundId_);
            }
            if ((this.bitField0_ & 64) == 64) {
                codedOutputStream.writeInt32(9, this.typeParameterName_);
            }
            if ((this.bitField0_ & 256) == 256) {
                codedOutputStream.writeMessage(10, this.outerType_);
            }
            if ((this.bitField0_ & 512) == 512) {
                codedOutputStream.writeInt32(11, this.outerTypeId_);
            }
            if ((this.bitField0_ & 128) == 128) {
                codedOutputStream.writeInt32(12, this.typeAliasName_);
            }
            if ((this.bitField0_ & 1024) == 1024) {
                codedOutputStream.writeMessage(13, this.abbreviatedType_);
            }
            if ((this.bitField0_ & 2048) == 2048) {
                codedOutputStream.writeInt32(14, this.abbreviatedTypeId_);
            }
            j11.writeUntil(200, codedOutputStream);
            codedOutputStream.writeRawBytes(this.unknownFields);
        }

        public static Builder newBuilder(Type type) {
            return newBuilder().mergeFrom(type);
        }

        public Type getDefaultInstanceForType() {
            return defaultInstance;
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        private Type(GeneratedMessageLite.ExtendableBuilder<Type, ?> extendableBuilder) {
            super(extendableBuilder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = extendableBuilder.getUnknownFields();
        }

        private Type(boolean z11) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        private Type(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                    Builder builder = null;
                    switch (readTag) {
                        case 0:
                            z11 = true;
                            break;
                        case 8:
                            this.bitField0_ |= 4096;
                            this.flags_ = codedInputStream.readInt32();
                            break;
                        case 18:
                            if (!z12 || !true) {
                                this.argument_ = new ArrayList();
                                z12 |= true;
                            }
                            this.argument_.add(codedInputStream.readMessage(Argument.PARSER, extensionRegistryLite));
                            break;
                        case 24:
                            this.bitField0_ |= 1;
                            this.nullable_ = codedInputStream.readBool();
                            break;
                        case 32:
                            this.bitField0_ |= 2;
                            this.flexibleTypeCapabilitiesId_ = codedInputStream.readInt32();
                            break;
                        case 42:
                            builder = (this.bitField0_ & 4) == 4 ? this.flexibleUpperBound_.toBuilder() : builder;
                            Type type = (Type) codedInputStream.readMessage(PARSER, extensionRegistryLite);
                            this.flexibleUpperBound_ = type;
                            if (builder != null) {
                                builder.mergeFrom(type);
                                this.flexibleUpperBound_ = builder.buildPartial();
                            }
                            this.bitField0_ |= 4;
                            break;
                        case 48:
                            this.bitField0_ |= 16;
                            this.className_ = codedInputStream.readInt32();
                            break;
                        case 56:
                            this.bitField0_ |= 32;
                            this.typeParameter_ = codedInputStream.readInt32();
                            break;
                        case 64:
                            this.bitField0_ |= 8;
                            this.flexibleUpperBoundId_ = codedInputStream.readInt32();
                            break;
                        case 72:
                            this.bitField0_ |= 64;
                            this.typeParameterName_ = codedInputStream.readInt32();
                            break;
                        case 82:
                            builder = (this.bitField0_ & 256) == 256 ? this.outerType_.toBuilder() : builder;
                            Type type2 = (Type) codedInputStream.readMessage(PARSER, extensionRegistryLite);
                            this.outerType_ = type2;
                            if (builder != null) {
                                builder.mergeFrom(type2);
                                this.outerType_ = builder.buildPartial();
                            }
                            this.bitField0_ |= 256;
                            break;
                        case 88:
                            this.bitField0_ |= 512;
                            this.outerTypeId_ = codedInputStream.readInt32();
                            break;
                        case 96:
                            this.bitField0_ |= 128;
                            this.typeAliasName_ = codedInputStream.readInt32();
                            break;
                        case 106:
                            builder = (this.bitField0_ & 1024) == 1024 ? this.abbreviatedType_.toBuilder() : builder;
                            Type type3 = (Type) codedInputStream.readMessage(PARSER, extensionRegistryLite);
                            this.abbreviatedType_ = type3;
                            if (builder != null) {
                                builder.mergeFrom(type3);
                                this.abbreviatedType_ = builder.buildPartial();
                            }
                            this.bitField0_ |= 1024;
                            break;
                        case 112:
                            this.bitField0_ |= 2048;
                            this.abbreviatedTypeId_ = codedInputStream.readInt32();
                            break;
                        default:
                            if (f(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                                break;
                            }
                            z11 = true;
                            break;
                    }
                } catch (InvalidProtocolBufferException e11) {
                    throw e11.setUnfinishedMessage(this);
                } catch (IOException e12) {
                    throw new InvalidProtocolBufferException(e12.getMessage()).setUnfinishedMessage(this);
                } catch (Throwable th2) {
                    if (z12 && true) {
                        this.argument_ = Collections.unmodifiableList(this.argument_);
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
                this.argument_ = Collections.unmodifiableList(this.argument_);
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

    public static final class TypeAlias extends GeneratedMessageLite.ExtendableMessage<TypeAlias> implements TypeAliasOrBuilder {
        public static Parser<TypeAlias> PARSER = new AbstractParser<TypeAlias>() {
            public TypeAlias parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new TypeAlias(codedInputStream, extensionRegistryLite);
            }
        };
        private static final TypeAlias defaultInstance;
        /* access modifiers changed from: private */
        public List<Annotation> annotation_;
        /* access modifiers changed from: private */
        public int bitField0_;
        /* access modifiers changed from: private */
        public int expandedTypeId_;
        /* access modifiers changed from: private */
        public Type expandedType_;
        /* access modifiers changed from: private */
        public int flags_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        /* access modifiers changed from: private */
        public int name_;
        /* access modifiers changed from: private */
        public List<TypeParameter> typeParameter_;
        /* access modifiers changed from: private */
        public int underlyingTypeId_;
        /* access modifiers changed from: private */
        public Type underlyingType_;
        /* access modifiers changed from: private */
        public final ByteString unknownFields;
        /* access modifiers changed from: private */
        public List<Integer> versionRequirement_;

        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<TypeAlias, Builder> implements TypeAliasOrBuilder {
            private List<Annotation> annotation_ = Collections.emptyList();
            private int bitField0_;
            private int expandedTypeId_;
            private Type expandedType_ = Type.getDefaultInstance();
            private int flags_ = 6;
            private int name_;
            private List<TypeParameter> typeParameter_ = Collections.emptyList();
            private int underlyingTypeId_;
            private Type underlyingType_ = Type.getDefaultInstance();
            private List<Integer> versionRequirement_ = Collections.emptyList();

            private Builder() {
                maybeForceBuilderInitialization();
            }

            /* access modifiers changed from: private */
            public static Builder create() {
                return new Builder();
            }

            private void ensureAnnotationIsMutable() {
                if ((this.bitField0_ & 128) != 128) {
                    this.annotation_ = new ArrayList(this.annotation_);
                    this.bitField0_ |= 128;
                }
            }

            private void ensureTypeParameterIsMutable() {
                if ((this.bitField0_ & 4) != 4) {
                    this.typeParameter_ = new ArrayList(this.typeParameter_);
                    this.bitField0_ |= 4;
                }
            }

            private void ensureVersionRequirementIsMutable() {
                if ((this.bitField0_ & 256) != 256) {
                    this.versionRequirement_ = new ArrayList(this.versionRequirement_);
                    this.bitField0_ |= 256;
                }
            }

            private void maybeForceBuilderInitialization() {
            }

            public TypeAlias buildPartial() {
                TypeAlias typeAlias = new TypeAlias((GeneratedMessageLite.ExtendableBuilder) this);
                int i11 = this.bitField0_;
                int i12 = 1;
                if ((i11 & 1) != 1) {
                    i12 = 0;
                }
                int unused = typeAlias.flags_ = this.flags_;
                if ((i11 & 2) == 2) {
                    i12 |= 2;
                }
                int unused2 = typeAlias.name_ = this.name_;
                if ((this.bitField0_ & 4) == 4) {
                    this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                    this.bitField0_ &= -5;
                }
                List unused3 = typeAlias.typeParameter_ = this.typeParameter_;
                if ((i11 & 8) == 8) {
                    i12 |= 4;
                }
                Type unused4 = typeAlias.underlyingType_ = this.underlyingType_;
                if ((i11 & 16) == 16) {
                    i12 |= 8;
                }
                int unused5 = typeAlias.underlyingTypeId_ = this.underlyingTypeId_;
                if ((i11 & 32) == 32) {
                    i12 |= 16;
                }
                Type unused6 = typeAlias.expandedType_ = this.expandedType_;
                if ((i11 & 64) == 64) {
                    i12 |= 32;
                }
                int unused7 = typeAlias.expandedTypeId_ = this.expandedTypeId_;
                if ((this.bitField0_ & 128) == 128) {
                    this.annotation_ = Collections.unmodifiableList(this.annotation_);
                    this.bitField0_ &= -129;
                }
                List unused8 = typeAlias.annotation_ = this.annotation_;
                if ((this.bitField0_ & 256) == 256) {
                    this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
                    this.bitField0_ &= -257;
                }
                List unused9 = typeAlias.versionRequirement_ = this.versionRequirement_;
                int unused10 = typeAlias.bitField0_ = i12;
                return typeAlias;
            }

            public Annotation getAnnotation(int i11) {
                return this.annotation_.get(i11);
            }

            public int getAnnotationCount() {
                return this.annotation_.size();
            }

            public Type getExpandedType() {
                return this.expandedType_;
            }

            public TypeParameter getTypeParameter(int i11) {
                return this.typeParameter_.get(i11);
            }

            public int getTypeParameterCount() {
                return this.typeParameter_.size();
            }

            public Type getUnderlyingType() {
                return this.underlyingType_;
            }

            public boolean hasExpandedType() {
                return (this.bitField0_ & 32) == 32;
            }

            public boolean hasName() {
                return (this.bitField0_ & 2) == 2;
            }

            public boolean hasUnderlyingType() {
                return (this.bitField0_ & 8) == 8;
            }

            public final boolean isInitialized() {
                if (!hasName()) {
                    return false;
                }
                for (int i11 = 0; i11 < getTypeParameterCount(); i11++) {
                    if (!getTypeParameter(i11).isInitialized()) {
                        return false;
                    }
                }
                if (hasUnderlyingType() && !getUnderlyingType().isInitialized()) {
                    return false;
                }
                if (hasExpandedType() && !getExpandedType().isInitialized()) {
                    return false;
                }
                for (int i12 = 0; i12 < getAnnotationCount(); i12++) {
                    if (!getAnnotation(i12).isInitialized()) {
                        return false;
                    }
                }
                if (!c()) {
                    return false;
                }
                return true;
            }

            public Builder mergeExpandedType(Type type) {
                if ((this.bitField0_ & 32) != 32 || this.expandedType_ == Type.getDefaultInstance()) {
                    this.expandedType_ = type;
                } else {
                    this.expandedType_ = Type.newBuilder(this.expandedType_).mergeFrom(type).buildPartial();
                }
                this.bitField0_ |= 32;
                return this;
            }

            public Builder mergeUnderlyingType(Type type) {
                if ((this.bitField0_ & 8) != 8 || this.underlyingType_ == Type.getDefaultInstance()) {
                    this.underlyingType_ = type;
                } else {
                    this.underlyingType_ = Type.newBuilder(this.underlyingType_).mergeFrom(type).buildPartial();
                }
                this.bitField0_ |= 8;
                return this;
            }

            public Builder setExpandedTypeId(int i11) {
                this.bitField0_ |= 64;
                this.expandedTypeId_ = i11;
                return this;
            }

            public Builder setFlags(int i11) {
                this.bitField0_ |= 1;
                this.flags_ = i11;
                return this;
            }

            public Builder setName(int i11) {
                this.bitField0_ |= 2;
                this.name_ = i11;
                return this;
            }

            public Builder setUnderlyingTypeId(int i11) {
                this.bitField0_ |= 16;
                this.underlyingTypeId_ = i11;
                return this;
            }

            public TypeAlias build() {
                TypeAlias buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.a(buildPartial);
            }

            public TypeAlias getDefaultInstanceForType() {
                return TypeAlias.getDefaultInstance();
            }

            public Builder mergeFrom(TypeAlias typeAlias) {
                if (typeAlias == TypeAlias.getDefaultInstance()) {
                    return this;
                }
                if (typeAlias.hasFlags()) {
                    setFlags(typeAlias.getFlags());
                }
                if (typeAlias.hasName()) {
                    setName(typeAlias.getName());
                }
                if (!typeAlias.typeParameter_.isEmpty()) {
                    if (this.typeParameter_.isEmpty()) {
                        this.typeParameter_ = typeAlias.typeParameter_;
                        this.bitField0_ &= -5;
                    } else {
                        ensureTypeParameterIsMutable();
                        this.typeParameter_.addAll(typeAlias.typeParameter_);
                    }
                }
                if (typeAlias.hasUnderlyingType()) {
                    mergeUnderlyingType(typeAlias.getUnderlyingType());
                }
                if (typeAlias.hasUnderlyingTypeId()) {
                    setUnderlyingTypeId(typeAlias.getUnderlyingTypeId());
                }
                if (typeAlias.hasExpandedType()) {
                    mergeExpandedType(typeAlias.getExpandedType());
                }
                if (typeAlias.hasExpandedTypeId()) {
                    setExpandedTypeId(typeAlias.getExpandedTypeId());
                }
                if (!typeAlias.annotation_.isEmpty()) {
                    if (this.annotation_.isEmpty()) {
                        this.annotation_ = typeAlias.annotation_;
                        this.bitField0_ &= -129;
                    } else {
                        ensureAnnotationIsMutable();
                        this.annotation_.addAll(typeAlias.annotation_);
                    }
                }
                if (!typeAlias.versionRequirement_.isEmpty()) {
                    if (this.versionRequirement_.isEmpty()) {
                        this.versionRequirement_ = typeAlias.versionRequirement_;
                        this.bitField0_ &= -257;
                    } else {
                        ensureVersionRequirementIsMutable();
                        this.versionRequirement_.addAll(typeAlias.versionRequirement_);
                    }
                }
                d(typeAlias);
                setUnknownFields(getUnknownFields().concat(typeAlias.unknownFields));
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                TypeAlias typeAlias;
                TypeAlias typeAlias2 = null;
                try {
                    TypeAlias parsePartialFrom = TypeAlias.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e11) {
                    typeAlias = (TypeAlias) e11.getUnfinishedMessage();
                    throw e11;
                } catch (Throwable th2) {
                    th = th2;
                    typeAlias2 = typeAlias;
                }
                if (typeAlias2 != null) {
                    mergeFrom(typeAlias2);
                }
                throw th;
            }
        }

        static {
            TypeAlias typeAlias = new TypeAlias(true);
            defaultInstance = typeAlias;
            typeAlias.initFields();
        }

        public static TypeAlias getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.flags_ = 6;
            this.name_ = 0;
            this.typeParameter_ = Collections.emptyList();
            this.underlyingType_ = Type.getDefaultInstance();
            this.underlyingTypeId_ = 0;
            this.expandedType_ = Type.getDefaultInstance();
            this.expandedTypeId_ = 0;
            this.annotation_ = Collections.emptyList();
            this.versionRequirement_ = Collections.emptyList();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public static TypeAlias parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public Annotation getAnnotation(int i11) {
            return this.annotation_.get(i11);
        }

        public int getAnnotationCount() {
            return this.annotation_.size();
        }

        public List<Annotation> getAnnotationList() {
            return this.annotation_;
        }

        public Type getExpandedType() {
            return this.expandedType_;
        }

        public int getExpandedTypeId() {
            return this.expandedTypeId_;
        }

        public int getFlags() {
            return this.flags_;
        }

        public int getName() {
            return this.name_;
        }

        public Parser<TypeAlias> getParserForType() {
            return PARSER;
        }

        public int getSerializedSize() {
            int i11;
            int i12 = this.memoizedSerializedSize;
            if (i12 != -1) {
                return i12;
            }
            if ((this.bitField0_ & 1) == 1) {
                i11 = CodedOutputStream.computeInt32Size(1, this.flags_) + 0;
            } else {
                i11 = 0;
            }
            if ((this.bitField0_ & 2) == 2) {
                i11 += CodedOutputStream.computeInt32Size(2, this.name_);
            }
            for (int i13 = 0; i13 < this.typeParameter_.size(); i13++) {
                i11 += CodedOutputStream.computeMessageSize(3, this.typeParameter_.get(i13));
            }
            if ((this.bitField0_ & 4) == 4) {
                i11 += CodedOutputStream.computeMessageSize(4, this.underlyingType_);
            }
            if ((this.bitField0_ & 8) == 8) {
                i11 += CodedOutputStream.computeInt32Size(5, this.underlyingTypeId_);
            }
            if ((this.bitField0_ & 16) == 16) {
                i11 += CodedOutputStream.computeMessageSize(6, this.expandedType_);
            }
            if ((this.bitField0_ & 32) == 32) {
                i11 += CodedOutputStream.computeInt32Size(7, this.expandedTypeId_);
            }
            for (int i14 = 0; i14 < this.annotation_.size(); i14++) {
                i11 += CodedOutputStream.computeMessageSize(8, this.annotation_.get(i14));
            }
            int i15 = 0;
            for (int i16 = 0; i16 < this.versionRequirement_.size(); i16++) {
                i15 += CodedOutputStream.computeInt32SizeNoTag(this.versionRequirement_.get(i16).intValue());
            }
            int size = i11 + i15 + (getVersionRequirementList().size() * 2) + i() + this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        public TypeParameter getTypeParameter(int i11) {
            return this.typeParameter_.get(i11);
        }

        public int getTypeParameterCount() {
            return this.typeParameter_.size();
        }

        public List<TypeParameter> getTypeParameterList() {
            return this.typeParameter_;
        }

        public Type getUnderlyingType() {
            return this.underlyingType_;
        }

        public int getUnderlyingTypeId() {
            return this.underlyingTypeId_;
        }

        public List<Integer> getVersionRequirementList() {
            return this.versionRequirement_;
        }

        public boolean hasExpandedType() {
            return (this.bitField0_ & 16) == 16;
        }

        public boolean hasExpandedTypeId() {
            return (this.bitField0_ & 32) == 32;
        }

        public boolean hasFlags() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean hasName() {
            return (this.bitField0_ & 2) == 2;
        }

        public boolean hasUnderlyingType() {
            return (this.bitField0_ & 4) == 4;
        }

        public boolean hasUnderlyingTypeId() {
            return (this.bitField0_ & 8) == 8;
        }

        public final boolean isInitialized() {
            byte b11 = this.memoizedIsInitialized;
            if (b11 == 1) {
                return true;
            }
            if (b11 == 0) {
                return false;
            }
            if (!hasName()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            for (int i11 = 0; i11 < getTypeParameterCount(); i11++) {
                if (!getTypeParameter(i11).isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            if (hasUnderlyingType() && !getUnderlyingType().isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            } else if (!hasExpandedType() || getExpandedType().isInitialized()) {
                for (int i12 = 0; i12 < getAnnotationCount(); i12++) {
                    if (!getAnnotation(i12).isInitialized()) {
                        this.memoizedIsInitialized = 0;
                        return false;
                    }
                }
                if (!h()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
                this.memoizedIsInitialized = 1;
                return true;
            } else {
                this.memoizedIsInitialized = 0;
                return false;
            }
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter j11 = j();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeInt32(1, this.flags_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeInt32(2, this.name_);
            }
            for (int i11 = 0; i11 < this.typeParameter_.size(); i11++) {
                codedOutputStream.writeMessage(3, this.typeParameter_.get(i11));
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeMessage(4, this.underlyingType_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeInt32(5, this.underlyingTypeId_);
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.writeMessage(6, this.expandedType_);
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.writeInt32(7, this.expandedTypeId_);
            }
            for (int i12 = 0; i12 < this.annotation_.size(); i12++) {
                codedOutputStream.writeMessage(8, this.annotation_.get(i12));
            }
            for (int i13 = 0; i13 < this.versionRequirement_.size(); i13++) {
                codedOutputStream.writeInt32(31, this.versionRequirement_.get(i13).intValue());
            }
            j11.writeUntil(200, codedOutputStream);
            codedOutputStream.writeRawBytes(this.unknownFields);
        }

        public static Builder newBuilder(TypeAlias typeAlias) {
            return newBuilder().mergeFrom(typeAlias);
        }

        public TypeAlias getDefaultInstanceForType() {
            return defaultInstance;
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        private TypeAlias(GeneratedMessageLite.ExtendableBuilder<TypeAlias, ?> extendableBuilder) {
            super(extendableBuilder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = extendableBuilder.getUnknownFields();
        }

        private TypeAlias(boolean z11) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        private TypeAlias(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                    Type.Builder builder = null;
                    switch (readTag) {
                        case 0:
                            z11 = true;
                            break;
                        case 8:
                            this.bitField0_ |= 1;
                            this.flags_ = codedInputStream.readInt32();
                            break;
                        case 16:
                            this.bitField0_ |= 2;
                            this.name_ = codedInputStream.readInt32();
                            break;
                        case 26:
                            if (!(z12 & true)) {
                                this.typeParameter_ = new ArrayList();
                                z12 |= true;
                            }
                            this.typeParameter_.add(codedInputStream.readMessage(TypeParameter.PARSER, extensionRegistryLite));
                            break;
                        case 34:
                            builder = (this.bitField0_ & 4) == 4 ? this.underlyingType_.toBuilder() : builder;
                            Type type = (Type) codedInputStream.readMessage(Type.PARSER, extensionRegistryLite);
                            this.underlyingType_ = type;
                            if (builder != null) {
                                builder.mergeFrom(type);
                                this.underlyingType_ = builder.buildPartial();
                            }
                            this.bitField0_ |= 4;
                            break;
                        case 40:
                            this.bitField0_ |= 8;
                            this.underlyingTypeId_ = codedInputStream.readInt32();
                            break;
                        case 50:
                            builder = (this.bitField0_ & 16) == 16 ? this.expandedType_.toBuilder() : builder;
                            Type type2 = (Type) codedInputStream.readMessage(Type.PARSER, extensionRegistryLite);
                            this.expandedType_ = type2;
                            if (builder != null) {
                                builder.mergeFrom(type2);
                                this.expandedType_ = builder.buildPartial();
                            }
                            this.bitField0_ |= 16;
                            break;
                        case 56:
                            this.bitField0_ |= 32;
                            this.expandedTypeId_ = codedInputStream.readInt32();
                            break;
                        case 66:
                            if (!(z12 & true)) {
                                this.annotation_ = new ArrayList();
                                z12 |= true;
                            }
                            this.annotation_.add(codedInputStream.readMessage(Annotation.PARSER, extensionRegistryLite));
                            break;
                        case 248:
                            if (!(z12 & true)) {
                                this.versionRequirement_ = new ArrayList();
                                z12 |= true;
                            }
                            this.versionRequirement_.add(Integer.valueOf(codedInputStream.readInt32()));
                            break;
                        case 250:
                            int pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                            if (!(z12 & true) && codedInputStream.getBytesUntilLimit() > 0) {
                                this.versionRequirement_ = new ArrayList();
                                z12 |= true;
                            }
                            while (codedInputStream.getBytesUntilLimit() > 0) {
                                this.versionRequirement_.add(Integer.valueOf(codedInputStream.readInt32()));
                            }
                            codedInputStream.popLimit(pushLimit);
                            break;
                        default:
                            if (f(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                                break;
                            }
                            z11 = true;
                            break;
                    }
                } catch (InvalidProtocolBufferException e11) {
                    throw e11.setUnfinishedMessage(this);
                } catch (IOException e12) {
                    throw new InvalidProtocolBufferException(e12.getMessage()).setUnfinishedMessage(this);
                } catch (Throwable th2) {
                    if (z12 & true) {
                        this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                    }
                    if (z12 & true) {
                        this.annotation_ = Collections.unmodifiableList(this.annotation_);
                    }
                    if (z12 & true) {
                        this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
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
                this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
            }
            if (z12 & true) {
                this.annotation_ = Collections.unmodifiableList(this.annotation_);
            }
            if (z12 & true) {
                this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
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

    public interface TypeAliasOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder {
    }

    public interface TypeOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder {
    }

    public static final class TypeParameter extends GeneratedMessageLite.ExtendableMessage<TypeParameter> implements TypeParameterOrBuilder {
        public static Parser<TypeParameter> PARSER = new AbstractParser<TypeParameter>() {
            public TypeParameter parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new TypeParameter(codedInputStream, extensionRegistryLite);
            }
        };
        private static final TypeParameter defaultInstance;
        /* access modifiers changed from: private */
        public int bitField0_;
        /* access modifiers changed from: private */
        public int id_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        /* access modifiers changed from: private */
        public int name_;
        /* access modifiers changed from: private */
        public boolean reified_;
        /* access modifiers changed from: private */
        public final ByteString unknownFields;
        private int upperBoundIdMemoizedSerializedSize;
        /* access modifiers changed from: private */
        public List<Integer> upperBoundId_;
        /* access modifiers changed from: private */
        public List<Type> upperBound_;
        /* access modifiers changed from: private */
        public Variance variance_;

        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<TypeParameter, Builder> implements TypeParameterOrBuilder {
            private int bitField0_;
            private int id_;
            private int name_;
            private boolean reified_;
            private List<Integer> upperBoundId_ = Collections.emptyList();
            private List<Type> upperBound_ = Collections.emptyList();
            private Variance variance_ = Variance.INV;

            private Builder() {
                maybeForceBuilderInitialization();
            }

            /* access modifiers changed from: private */
            public static Builder create() {
                return new Builder();
            }

            private void ensureUpperBoundIdIsMutable() {
                if ((this.bitField0_ & 32) != 32) {
                    this.upperBoundId_ = new ArrayList(this.upperBoundId_);
                    this.bitField0_ |= 32;
                }
            }

            private void ensureUpperBoundIsMutable() {
                if ((this.bitField0_ & 16) != 16) {
                    this.upperBound_ = new ArrayList(this.upperBound_);
                    this.bitField0_ |= 16;
                }
            }

            private void maybeForceBuilderInitialization() {
            }

            public TypeParameter buildPartial() {
                TypeParameter typeParameter = new TypeParameter((GeneratedMessageLite.ExtendableBuilder) this);
                int i11 = this.bitField0_;
                int i12 = 1;
                if ((i11 & 1) != 1) {
                    i12 = 0;
                }
                int unused = typeParameter.id_ = this.id_;
                if ((i11 & 2) == 2) {
                    i12 |= 2;
                }
                int unused2 = typeParameter.name_ = this.name_;
                if ((i11 & 4) == 4) {
                    i12 |= 4;
                }
                boolean unused3 = typeParameter.reified_ = this.reified_;
                if ((i11 & 8) == 8) {
                    i12 |= 8;
                }
                Variance unused4 = typeParameter.variance_ = this.variance_;
                if ((this.bitField0_ & 16) == 16) {
                    this.upperBound_ = Collections.unmodifiableList(this.upperBound_);
                    this.bitField0_ &= -17;
                }
                List unused5 = typeParameter.upperBound_ = this.upperBound_;
                if ((this.bitField0_ & 32) == 32) {
                    this.upperBoundId_ = Collections.unmodifiableList(this.upperBoundId_);
                    this.bitField0_ &= -33;
                }
                List unused6 = typeParameter.upperBoundId_ = this.upperBoundId_;
                int unused7 = typeParameter.bitField0_ = i12;
                return typeParameter;
            }

            public Type getUpperBound(int i11) {
                return this.upperBound_.get(i11);
            }

            public int getUpperBoundCount() {
                return this.upperBound_.size();
            }

            public boolean hasId() {
                return (this.bitField0_ & 1) == 1;
            }

            public boolean hasName() {
                return (this.bitField0_ & 2) == 2;
            }

            public final boolean isInitialized() {
                if (!hasId() || !hasName()) {
                    return false;
                }
                for (int i11 = 0; i11 < getUpperBoundCount(); i11++) {
                    if (!getUpperBound(i11).isInitialized()) {
                        return false;
                    }
                }
                if (!c()) {
                    return false;
                }
                return true;
            }

            public Builder setId(int i11) {
                this.bitField0_ |= 1;
                this.id_ = i11;
                return this;
            }

            public Builder setName(int i11) {
                this.bitField0_ |= 2;
                this.name_ = i11;
                return this;
            }

            public Builder setReified(boolean z11) {
                this.bitField0_ |= 4;
                this.reified_ = z11;
                return this;
            }

            public Builder setVariance(Variance variance) {
                variance.getClass();
                this.bitField0_ |= 8;
                this.variance_ = variance;
                return this;
            }

            public TypeParameter build() {
                TypeParameter buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.a(buildPartial);
            }

            public TypeParameter getDefaultInstanceForType() {
                return TypeParameter.getDefaultInstance();
            }

            public Builder mergeFrom(TypeParameter typeParameter) {
                if (typeParameter == TypeParameter.getDefaultInstance()) {
                    return this;
                }
                if (typeParameter.hasId()) {
                    setId(typeParameter.getId());
                }
                if (typeParameter.hasName()) {
                    setName(typeParameter.getName());
                }
                if (typeParameter.hasReified()) {
                    setReified(typeParameter.getReified());
                }
                if (typeParameter.hasVariance()) {
                    setVariance(typeParameter.getVariance());
                }
                if (!typeParameter.upperBound_.isEmpty()) {
                    if (this.upperBound_.isEmpty()) {
                        this.upperBound_ = typeParameter.upperBound_;
                        this.bitField0_ &= -17;
                    } else {
                        ensureUpperBoundIsMutable();
                        this.upperBound_.addAll(typeParameter.upperBound_);
                    }
                }
                if (!typeParameter.upperBoundId_.isEmpty()) {
                    if (this.upperBoundId_.isEmpty()) {
                        this.upperBoundId_ = typeParameter.upperBoundId_;
                        this.bitField0_ &= -33;
                    } else {
                        ensureUpperBoundIdIsMutable();
                        this.upperBoundId_.addAll(typeParameter.upperBoundId_);
                    }
                }
                d(typeParameter);
                setUnknownFields(getUnknownFields().concat(typeParameter.unknownFields));
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                TypeParameter typeParameter;
                TypeParameter typeParameter2 = null;
                try {
                    TypeParameter parsePartialFrom = TypeParameter.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e11) {
                    typeParameter = (TypeParameter) e11.getUnfinishedMessage();
                    throw e11;
                } catch (Throwable th2) {
                    th = th2;
                    typeParameter2 = typeParameter;
                }
                if (typeParameter2 != null) {
                    mergeFrom(typeParameter2);
                }
                throw th;
            }
        }

        public enum Variance implements Internal.EnumLite {
            IN(0, 0),
            OUT(1, 1),
            INV(2, 2);
            
            private static Internal.EnumLiteMap<Variance> internalValueMap;
            private final int value;

            /* access modifiers changed from: public */
            static {
                internalValueMap = new Internal.EnumLiteMap<Variance>() {
                    public Variance findValueByNumber(int i11) {
                        return Variance.valueOf(i11);
                    }
                };
            }

            private Variance(int i11, int i12) {
                this.value = i12;
            }

            public final int getNumber() {
                return this.value;
            }

            public static Variance valueOf(int i11) {
                if (i11 == 0) {
                    return IN;
                }
                if (i11 == 1) {
                    return OUT;
                }
                if (i11 != 2) {
                    return null;
                }
                return INV;
            }
        }

        static {
            TypeParameter typeParameter = new TypeParameter(true);
            defaultInstance = typeParameter;
            typeParameter.initFields();
        }

        public static TypeParameter getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.id_ = 0;
            this.name_ = 0;
            this.reified_ = false;
            this.variance_ = Variance.INV;
            this.upperBound_ = Collections.emptyList();
            this.upperBoundId_ = Collections.emptyList();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public int getId() {
            return this.id_;
        }

        public int getName() {
            return this.name_;
        }

        public Parser<TypeParameter> getParserForType() {
            return PARSER;
        }

        public boolean getReified() {
            return this.reified_;
        }

        public int getSerializedSize() {
            int i11;
            int i12 = this.memoizedSerializedSize;
            if (i12 != -1) {
                return i12;
            }
            if ((this.bitField0_ & 1) == 1) {
                i11 = CodedOutputStream.computeInt32Size(1, this.id_) + 0;
            } else {
                i11 = 0;
            }
            if ((this.bitField0_ & 2) == 2) {
                i11 += CodedOutputStream.computeInt32Size(2, this.name_);
            }
            if ((this.bitField0_ & 4) == 4) {
                i11 += CodedOutputStream.computeBoolSize(3, this.reified_);
            }
            if ((this.bitField0_ & 8) == 8) {
                i11 += CodedOutputStream.computeEnumSize(4, this.variance_.getNumber());
            }
            for (int i13 = 0; i13 < this.upperBound_.size(); i13++) {
                i11 += CodedOutputStream.computeMessageSize(5, this.upperBound_.get(i13));
            }
            int i14 = 0;
            for (int i15 = 0; i15 < this.upperBoundId_.size(); i15++) {
                i14 += CodedOutputStream.computeInt32SizeNoTag(this.upperBoundId_.get(i15).intValue());
            }
            int i16 = i11 + i14;
            if (!getUpperBoundIdList().isEmpty()) {
                i16 = i16 + 1 + CodedOutputStream.computeInt32SizeNoTag(i14);
            }
            this.upperBoundIdMemoizedSerializedSize = i14;
            int i17 = i16 + i() + this.unknownFields.size();
            this.memoizedSerializedSize = i17;
            return i17;
        }

        public Type getUpperBound(int i11) {
            return this.upperBound_.get(i11);
        }

        public int getUpperBoundCount() {
            return this.upperBound_.size();
        }

        public List<Integer> getUpperBoundIdList() {
            return this.upperBoundId_;
        }

        public List<Type> getUpperBoundList() {
            return this.upperBound_;
        }

        public Variance getVariance() {
            return this.variance_;
        }

        public boolean hasId() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean hasName() {
            return (this.bitField0_ & 2) == 2;
        }

        public boolean hasReified() {
            return (this.bitField0_ & 4) == 4;
        }

        public boolean hasVariance() {
            return (this.bitField0_ & 8) == 8;
        }

        public final boolean isInitialized() {
            byte b11 = this.memoizedIsInitialized;
            if (b11 == 1) {
                return true;
            }
            if (b11 == 0) {
                return false;
            }
            if (!hasId()) {
                this.memoizedIsInitialized = 0;
                return false;
            } else if (!hasName()) {
                this.memoizedIsInitialized = 0;
                return false;
            } else {
                for (int i11 = 0; i11 < getUpperBoundCount(); i11++) {
                    if (!getUpperBound(i11).isInitialized()) {
                        this.memoizedIsInitialized = 0;
                        return false;
                    }
                }
                if (!h()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
                this.memoizedIsInitialized = 1;
                return true;
            }
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter j11 = j();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeInt32(1, this.id_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeInt32(2, this.name_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeBool(3, this.reified_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeEnum(4, this.variance_.getNumber());
            }
            for (int i11 = 0; i11 < this.upperBound_.size(); i11++) {
                codedOutputStream.writeMessage(5, this.upperBound_.get(i11));
            }
            if (getUpperBoundIdList().size() > 0) {
                codedOutputStream.writeRawVarint32(50);
                codedOutputStream.writeRawVarint32(this.upperBoundIdMemoizedSerializedSize);
            }
            for (int i12 = 0; i12 < this.upperBoundId_.size(); i12++) {
                codedOutputStream.writeInt32NoTag(this.upperBoundId_.get(i12).intValue());
            }
            j11.writeUntil(1000, codedOutputStream);
            codedOutputStream.writeRawBytes(this.unknownFields);
        }

        public static Builder newBuilder(TypeParameter typeParameter) {
            return newBuilder().mergeFrom(typeParameter);
        }

        public TypeParameter getDefaultInstanceForType() {
            return defaultInstance;
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        private TypeParameter(GeneratedMessageLite.ExtendableBuilder<TypeParameter, ?> extendableBuilder) {
            super(extendableBuilder);
            this.upperBoundIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = extendableBuilder.getUnknownFields();
        }

        private TypeParameter(boolean z11) {
            this.upperBoundIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        private TypeParameter(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.upperBoundIdMemoizedSerializedSize = -1;
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
                            this.id_ = codedInputStream.readInt32();
                        } else if (readTag == 16) {
                            this.bitField0_ |= 2;
                            this.name_ = codedInputStream.readInt32();
                        } else if (readTag == 24) {
                            this.bitField0_ |= 4;
                            this.reified_ = codedInputStream.readBool();
                        } else if (readTag == 32) {
                            int readEnum = codedInputStream.readEnum();
                            Variance valueOf = Variance.valueOf(readEnum);
                            if (valueOf == null) {
                                newInstance.writeRawVarint32(readTag);
                                newInstance.writeRawVarint32(readEnum);
                            } else {
                                this.bitField0_ |= 8;
                                this.variance_ = valueOf;
                            }
                        } else if (readTag == 42) {
                            if (!(z12 & true)) {
                                this.upperBound_ = new ArrayList();
                                z12 |= true;
                            }
                            this.upperBound_.add(codedInputStream.readMessage(Type.PARSER, extensionRegistryLite));
                        } else if (readTag == 48) {
                            if (!(z12 & true)) {
                                this.upperBoundId_ = new ArrayList();
                                z12 |= true;
                            }
                            this.upperBoundId_.add(Integer.valueOf(codedInputStream.readInt32()));
                        } else if (readTag == 50) {
                            int pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                            if (!(z12 & true) && codedInputStream.getBytesUntilLimit() > 0) {
                                this.upperBoundId_ = new ArrayList();
                                z12 |= true;
                            }
                            while (codedInputStream.getBytesUntilLimit() > 0) {
                                this.upperBoundId_.add(Integer.valueOf(codedInputStream.readInt32()));
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
                    if (z12 & true) {
                        this.upperBound_ = Collections.unmodifiableList(this.upperBound_);
                    }
                    if (z12 & true) {
                        this.upperBoundId_ = Collections.unmodifiableList(this.upperBoundId_);
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
                this.upperBound_ = Collections.unmodifiableList(this.upperBound_);
            }
            if (z12 & true) {
                this.upperBoundId_ = Collections.unmodifiableList(this.upperBoundId_);
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

    public interface TypeParameterOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder {
    }

    public static final class TypeTable extends GeneratedMessageLite implements TypeTableOrBuilder {
        public static Parser<TypeTable> PARSER = new AbstractParser<TypeTable>() {
            public TypeTable parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new TypeTable(codedInputStream, extensionRegistryLite);
            }
        };
        private static final TypeTable defaultInstance;
        /* access modifiers changed from: private */
        public int bitField0_;
        /* access modifiers changed from: private */
        public int firstNullable_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        /* access modifiers changed from: private */
        public List<Type> type_;
        /* access modifiers changed from: private */
        public final ByteString unknownFields;

        public static final class Builder extends GeneratedMessageLite.Builder<TypeTable, Builder> implements TypeTableOrBuilder {
            private int bitField0_;
            private int firstNullable_ = -1;
            private List<Type> type_ = Collections.emptyList();

            private Builder() {
                maybeForceBuilderInitialization();
            }

            /* access modifiers changed from: private */
            public static Builder create() {
                return new Builder();
            }

            private void ensureTypeIsMutable() {
                if ((this.bitField0_ & 1) != 1) {
                    this.type_ = new ArrayList(this.type_);
                    this.bitField0_ |= 1;
                }
            }

            private void maybeForceBuilderInitialization() {
            }

            public TypeTable buildPartial() {
                TypeTable typeTable = new TypeTable((GeneratedMessageLite.Builder) this);
                int i11 = this.bitField0_;
                int i12 = 1;
                if ((i11 & 1) == 1) {
                    this.type_ = Collections.unmodifiableList(this.type_);
                    this.bitField0_ &= -2;
                }
                List unused = typeTable.type_ = this.type_;
                if ((i11 & 2) != 2) {
                    i12 = 0;
                }
                int unused2 = typeTable.firstNullable_ = this.firstNullable_;
                int unused3 = typeTable.bitField0_ = i12;
                return typeTable;
            }

            public Type getType(int i11) {
                return this.type_.get(i11);
            }

            public int getTypeCount() {
                return this.type_.size();
            }

            public final boolean isInitialized() {
                for (int i11 = 0; i11 < getTypeCount(); i11++) {
                    if (!getType(i11).isInitialized()) {
                        return false;
                    }
                }
                return true;
            }

            public Builder setFirstNullable(int i11) {
                this.bitField0_ |= 2;
                this.firstNullable_ = i11;
                return this;
            }

            public TypeTable build() {
                TypeTable buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.a(buildPartial);
            }

            public TypeTable getDefaultInstanceForType() {
                return TypeTable.getDefaultInstance();
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Builder mergeFrom(TypeTable typeTable) {
                if (typeTable == TypeTable.getDefaultInstance()) {
                    return this;
                }
                if (!typeTable.type_.isEmpty()) {
                    if (this.type_.isEmpty()) {
                        this.type_ = typeTable.type_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureTypeIsMutable();
                        this.type_.addAll(typeTable.type_);
                    }
                }
                if (typeTable.hasFirstNullable()) {
                    setFirstNullable(typeTable.getFirstNullable());
                }
                setUnknownFields(getUnknownFields().concat(typeTable.unknownFields));
                return this;
            }

            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                TypeTable typeTable;
                TypeTable typeTable2 = null;
                try {
                    TypeTable parsePartialFrom = TypeTable.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e11) {
                    typeTable = (TypeTable) e11.getUnfinishedMessage();
                    throw e11;
                } catch (Throwable th2) {
                    th = th2;
                    typeTable2 = typeTable;
                }
                if (typeTable2 != null) {
                    mergeFrom(typeTable2);
                }
                throw th;
            }
        }

        static {
            TypeTable typeTable = new TypeTable(true);
            defaultInstance = typeTable;
            typeTable.initFields();
        }

        public static TypeTable getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.type_ = Collections.emptyList();
            this.firstNullable_ = -1;
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public int getFirstNullable() {
            return this.firstNullable_;
        }

        public Parser<TypeTable> getParserForType() {
            return PARSER;
        }

        public int getSerializedSize() {
            int i11 = this.memoizedSerializedSize;
            if (i11 != -1) {
                return i11;
            }
            int i12 = 0;
            for (int i13 = 0; i13 < this.type_.size(); i13++) {
                i12 += CodedOutputStream.computeMessageSize(1, this.type_.get(i13));
            }
            if ((this.bitField0_ & 1) == 1) {
                i12 += CodedOutputStream.computeInt32Size(2, this.firstNullable_);
            }
            int size = i12 + this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        public Type getType(int i11) {
            return this.type_.get(i11);
        }

        public int getTypeCount() {
            return this.type_.size();
        }

        public List<Type> getTypeList() {
            return this.type_;
        }

        public boolean hasFirstNullable() {
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
            for (int i11 = 0; i11 < getTypeCount(); i11++) {
                if (!getType(i11).isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            for (int i11 = 0; i11 < this.type_.size(); i11++) {
                codedOutputStream.writeMessage(1, this.type_.get(i11));
            }
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeInt32(2, this.firstNullable_);
            }
            codedOutputStream.writeRawBytes(this.unknownFields);
        }

        public static Builder newBuilder(TypeTable typeTable) {
            return newBuilder().mergeFrom(typeTable);
        }

        public TypeTable getDefaultInstanceForType() {
            return defaultInstance;
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        private TypeTable(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private TypeTable(boolean z11) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        private TypeTable(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                this.type_ = new ArrayList();
                                z12 |= true;
                            }
                            this.type_.add(codedInputStream.readMessage(Type.PARSER, extensionRegistryLite));
                        } else if (readTag == 16) {
                            this.bitField0_ |= 1;
                            this.firstNullable_ = codedInputStream.readInt32();
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
                        this.type_ = Collections.unmodifiableList(this.type_);
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
                this.type_ = Collections.unmodifiableList(this.type_);
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

    public interface TypeTableOrBuilder extends MessageLiteOrBuilder {
    }

    public static final class ValueParameter extends GeneratedMessageLite.ExtendableMessage<ValueParameter> implements ValueParameterOrBuilder {
        public static Parser<ValueParameter> PARSER = new AbstractParser<ValueParameter>() {
            public ValueParameter parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new ValueParameter(codedInputStream, extensionRegistryLite);
            }
        };
        private static final ValueParameter defaultInstance;
        /* access modifiers changed from: private */
        public int bitField0_;
        /* access modifiers changed from: private */
        public int flags_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        /* access modifiers changed from: private */
        public int name_;
        /* access modifiers changed from: private */
        public int typeId_;
        /* access modifiers changed from: private */
        public Type type_;
        /* access modifiers changed from: private */
        public final ByteString unknownFields;
        /* access modifiers changed from: private */
        public int varargElementTypeId_;
        /* access modifiers changed from: private */
        public Type varargElementType_;

        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<ValueParameter, Builder> implements ValueParameterOrBuilder {
            private int bitField0_;
            private int flags_;
            private int name_;
            private int typeId_;
            private Type type_ = Type.getDefaultInstance();
            private int varargElementTypeId_;
            private Type varargElementType_ = Type.getDefaultInstance();

            private Builder() {
                maybeForceBuilderInitialization();
            }

            /* access modifiers changed from: private */
            public static Builder create() {
                return new Builder();
            }

            private void maybeForceBuilderInitialization() {
            }

            public ValueParameter buildPartial() {
                ValueParameter valueParameter = new ValueParameter((GeneratedMessageLite.ExtendableBuilder) this);
                int i11 = this.bitField0_;
                int i12 = 1;
                if ((i11 & 1) != 1) {
                    i12 = 0;
                }
                int unused = valueParameter.flags_ = this.flags_;
                if ((i11 & 2) == 2) {
                    i12 |= 2;
                }
                int unused2 = valueParameter.name_ = this.name_;
                if ((i11 & 4) == 4) {
                    i12 |= 4;
                }
                Type unused3 = valueParameter.type_ = this.type_;
                if ((i11 & 8) == 8) {
                    i12 |= 8;
                }
                int unused4 = valueParameter.typeId_ = this.typeId_;
                if ((i11 & 16) == 16) {
                    i12 |= 16;
                }
                Type unused5 = valueParameter.varargElementType_ = this.varargElementType_;
                if ((i11 & 32) == 32) {
                    i12 |= 32;
                }
                int unused6 = valueParameter.varargElementTypeId_ = this.varargElementTypeId_;
                int unused7 = valueParameter.bitField0_ = i12;
                return valueParameter;
            }

            public Type getType() {
                return this.type_;
            }

            public Type getVarargElementType() {
                return this.varargElementType_;
            }

            public boolean hasName() {
                return (this.bitField0_ & 2) == 2;
            }

            public boolean hasType() {
                return (this.bitField0_ & 4) == 4;
            }

            public boolean hasVarargElementType() {
                return (this.bitField0_ & 16) == 16;
            }

            public final boolean isInitialized() {
                if (!hasName()) {
                    return false;
                }
                if (hasType() && !getType().isInitialized()) {
                    return false;
                }
                if ((!hasVarargElementType() || getVarargElementType().isInitialized()) && c()) {
                    return true;
                }
                return false;
            }

            public Builder mergeType(Type type) {
                if ((this.bitField0_ & 4) != 4 || this.type_ == Type.getDefaultInstance()) {
                    this.type_ = type;
                } else {
                    this.type_ = Type.newBuilder(this.type_).mergeFrom(type).buildPartial();
                }
                this.bitField0_ |= 4;
                return this;
            }

            public Builder mergeVarargElementType(Type type) {
                if ((this.bitField0_ & 16) != 16 || this.varargElementType_ == Type.getDefaultInstance()) {
                    this.varargElementType_ = type;
                } else {
                    this.varargElementType_ = Type.newBuilder(this.varargElementType_).mergeFrom(type).buildPartial();
                }
                this.bitField0_ |= 16;
                return this;
            }

            public Builder setFlags(int i11) {
                this.bitField0_ |= 1;
                this.flags_ = i11;
                return this;
            }

            public Builder setName(int i11) {
                this.bitField0_ |= 2;
                this.name_ = i11;
                return this;
            }

            public Builder setTypeId(int i11) {
                this.bitField0_ |= 8;
                this.typeId_ = i11;
                return this;
            }

            public Builder setVarargElementTypeId(int i11) {
                this.bitField0_ |= 32;
                this.varargElementTypeId_ = i11;
                return this;
            }

            public ValueParameter build() {
                ValueParameter buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.a(buildPartial);
            }

            public ValueParameter getDefaultInstanceForType() {
                return ValueParameter.getDefaultInstance();
            }

            public Builder mergeFrom(ValueParameter valueParameter) {
                if (valueParameter == ValueParameter.getDefaultInstance()) {
                    return this;
                }
                if (valueParameter.hasFlags()) {
                    setFlags(valueParameter.getFlags());
                }
                if (valueParameter.hasName()) {
                    setName(valueParameter.getName());
                }
                if (valueParameter.hasType()) {
                    mergeType(valueParameter.getType());
                }
                if (valueParameter.hasTypeId()) {
                    setTypeId(valueParameter.getTypeId());
                }
                if (valueParameter.hasVarargElementType()) {
                    mergeVarargElementType(valueParameter.getVarargElementType());
                }
                if (valueParameter.hasVarargElementTypeId()) {
                    setVarargElementTypeId(valueParameter.getVarargElementTypeId());
                }
                d(valueParameter);
                setUnknownFields(getUnknownFields().concat(valueParameter.unknownFields));
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                ValueParameter valueParameter;
                ValueParameter valueParameter2 = null;
                try {
                    ValueParameter parsePartialFrom = ValueParameter.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e11) {
                    valueParameter = (ValueParameter) e11.getUnfinishedMessage();
                    throw e11;
                } catch (Throwable th2) {
                    th = th2;
                    valueParameter2 = valueParameter;
                }
                if (valueParameter2 != null) {
                    mergeFrom(valueParameter2);
                }
                throw th;
            }
        }

        static {
            ValueParameter valueParameter = new ValueParameter(true);
            defaultInstance = valueParameter;
            valueParameter.initFields();
        }

        public static ValueParameter getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.flags_ = 0;
            this.name_ = 0;
            this.type_ = Type.getDefaultInstance();
            this.typeId_ = 0;
            this.varargElementType_ = Type.getDefaultInstance();
            this.varargElementTypeId_ = 0;
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public int getFlags() {
            return this.flags_;
        }

        public int getName() {
            return this.name_;
        }

        public Parser<ValueParameter> getParserForType() {
            return PARSER;
        }

        public int getSerializedSize() {
            int i11 = this.memoizedSerializedSize;
            if (i11 != -1) {
                return i11;
            }
            int i12 = 0;
            if ((this.bitField0_ & 1) == 1) {
                i12 = 0 + CodedOutputStream.computeInt32Size(1, this.flags_);
            }
            if ((this.bitField0_ & 2) == 2) {
                i12 += CodedOutputStream.computeInt32Size(2, this.name_);
            }
            if ((this.bitField0_ & 4) == 4) {
                i12 += CodedOutputStream.computeMessageSize(3, this.type_);
            }
            if ((this.bitField0_ & 16) == 16) {
                i12 += CodedOutputStream.computeMessageSize(4, this.varargElementType_);
            }
            if ((this.bitField0_ & 8) == 8) {
                i12 += CodedOutputStream.computeInt32Size(5, this.typeId_);
            }
            if ((this.bitField0_ & 32) == 32) {
                i12 += CodedOutputStream.computeInt32Size(6, this.varargElementTypeId_);
            }
            int i13 = i12 + i() + this.unknownFields.size();
            this.memoizedSerializedSize = i13;
            return i13;
        }

        public Type getType() {
            return this.type_;
        }

        public int getTypeId() {
            return this.typeId_;
        }

        public Type getVarargElementType() {
            return this.varargElementType_;
        }

        public int getVarargElementTypeId() {
            return this.varargElementTypeId_;
        }

        public boolean hasFlags() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean hasName() {
            return (this.bitField0_ & 2) == 2;
        }

        public boolean hasType() {
            return (this.bitField0_ & 4) == 4;
        }

        public boolean hasTypeId() {
            return (this.bitField0_ & 8) == 8;
        }

        public boolean hasVarargElementType() {
            return (this.bitField0_ & 16) == 16;
        }

        public boolean hasVarargElementTypeId() {
            return (this.bitField0_ & 32) == 32;
        }

        public final boolean isInitialized() {
            byte b11 = this.memoizedIsInitialized;
            if (b11 == 1) {
                return true;
            }
            if (b11 == 0) {
                return false;
            }
            if (!hasName()) {
                this.memoizedIsInitialized = 0;
                return false;
            } else if (hasType() && !getType().isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            } else if (hasVarargElementType() && !getVarargElementType().isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            } else if (!h()) {
                this.memoizedIsInitialized = 0;
                return false;
            } else {
                this.memoizedIsInitialized = 1;
                return true;
            }
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter j11 = j();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeInt32(1, this.flags_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeInt32(2, this.name_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeMessage(3, this.type_);
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.writeMessage(4, this.varargElementType_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeInt32(5, this.typeId_);
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.writeInt32(6, this.varargElementTypeId_);
            }
            j11.writeUntil(200, codedOutputStream);
            codedOutputStream.writeRawBytes(this.unknownFields);
        }

        public static Builder newBuilder(ValueParameter valueParameter) {
            return newBuilder().mergeFrom(valueParameter);
        }

        public ValueParameter getDefaultInstanceForType() {
            return defaultInstance;
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        private ValueParameter(GeneratedMessageLite.ExtendableBuilder<ValueParameter, ?> extendableBuilder) {
            super(extendableBuilder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = extendableBuilder.getUnknownFields();
        }

        private ValueParameter(boolean z11) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        private ValueParameter(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            this.flags_ = codedInputStream.readInt32();
                        } else if (readTag != 16) {
                            Type.Builder builder = null;
                            if (readTag == 26) {
                                builder = (this.bitField0_ & 4) == 4 ? this.type_.toBuilder() : builder;
                                Type type = (Type) codedInputStream.readMessage(Type.PARSER, extensionRegistryLite);
                                this.type_ = type;
                                if (builder != null) {
                                    builder.mergeFrom(type);
                                    this.type_ = builder.buildPartial();
                                }
                                this.bitField0_ |= 4;
                            } else if (readTag == 34) {
                                builder = (this.bitField0_ & 16) == 16 ? this.varargElementType_.toBuilder() : builder;
                                Type type2 = (Type) codedInputStream.readMessage(Type.PARSER, extensionRegistryLite);
                                this.varargElementType_ = type2;
                                if (builder != null) {
                                    builder.mergeFrom(type2);
                                    this.varargElementType_ = builder.buildPartial();
                                }
                                this.bitField0_ |= 16;
                            } else if (readTag == 40) {
                                this.bitField0_ |= 8;
                                this.typeId_ = codedInputStream.readInt32();
                            } else if (readTag == 48) {
                                this.bitField0_ |= 32;
                                this.varargElementTypeId_ = codedInputStream.readInt32();
                            } else if (!f(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                            }
                        } else {
                            this.bitField0_ |= 2;
                            this.name_ = codedInputStream.readInt32();
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

    public interface ValueParameterOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder {
    }

    public static final class VersionRequirement extends GeneratedMessageLite implements VersionRequirementOrBuilder {
        public static Parser<VersionRequirement> PARSER = new AbstractParser<VersionRequirement>() {
            public VersionRequirement parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new VersionRequirement(codedInputStream, extensionRegistryLite);
            }
        };
        private static final VersionRequirement defaultInstance;
        /* access modifiers changed from: private */
        public int bitField0_;
        /* access modifiers changed from: private */
        public int errorCode_;
        /* access modifiers changed from: private */
        public Level level_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        /* access modifiers changed from: private */
        public int message_;
        /* access modifiers changed from: private */
        public final ByteString unknownFields;
        /* access modifiers changed from: private */
        public int versionFull_;
        /* access modifiers changed from: private */
        public VersionKind versionKind_;
        /* access modifiers changed from: private */
        public int version_;

        public static final class Builder extends GeneratedMessageLite.Builder<VersionRequirement, Builder> implements VersionRequirementOrBuilder {
            private int bitField0_;
            private int errorCode_;
            private Level level_ = Level.ERROR;
            private int message_;
            private int versionFull_;
            private VersionKind versionKind_ = VersionKind.LANGUAGE_VERSION;
            private int version_;

            private Builder() {
                maybeForceBuilderInitialization();
            }

            /* access modifiers changed from: private */
            public static Builder create() {
                return new Builder();
            }

            private void maybeForceBuilderInitialization() {
            }

            public VersionRequirement buildPartial() {
                VersionRequirement versionRequirement = new VersionRequirement((GeneratedMessageLite.Builder) this);
                int i11 = this.bitField0_;
                int i12 = 1;
                if ((i11 & 1) != 1) {
                    i12 = 0;
                }
                int unused = versionRequirement.version_ = this.version_;
                if ((i11 & 2) == 2) {
                    i12 |= 2;
                }
                int unused2 = versionRequirement.versionFull_ = this.versionFull_;
                if ((i11 & 4) == 4) {
                    i12 |= 4;
                }
                Level unused3 = versionRequirement.level_ = this.level_;
                if ((i11 & 8) == 8) {
                    i12 |= 8;
                }
                int unused4 = versionRequirement.errorCode_ = this.errorCode_;
                if ((i11 & 16) == 16) {
                    i12 |= 16;
                }
                int unused5 = versionRequirement.message_ = this.message_;
                if ((i11 & 32) == 32) {
                    i12 |= 32;
                }
                VersionKind unused6 = versionRequirement.versionKind_ = this.versionKind_;
                int unused7 = versionRequirement.bitField0_ = i12;
                return versionRequirement;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder setErrorCode(int i11) {
                this.bitField0_ |= 8;
                this.errorCode_ = i11;
                return this;
            }

            public Builder setLevel(Level level) {
                level.getClass();
                this.bitField0_ |= 4;
                this.level_ = level;
                return this;
            }

            public Builder setMessage(int i11) {
                this.bitField0_ |= 16;
                this.message_ = i11;
                return this;
            }

            public Builder setVersion(int i11) {
                this.bitField0_ |= 1;
                this.version_ = i11;
                return this;
            }

            public Builder setVersionFull(int i11) {
                this.bitField0_ |= 2;
                this.versionFull_ = i11;
                return this;
            }

            public Builder setVersionKind(VersionKind versionKind) {
                versionKind.getClass();
                this.bitField0_ |= 32;
                this.versionKind_ = versionKind;
                return this;
            }

            public VersionRequirement build() {
                VersionRequirement buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.a(buildPartial);
            }

            public VersionRequirement getDefaultInstanceForType() {
                return VersionRequirement.getDefaultInstance();
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Builder mergeFrom(VersionRequirement versionRequirement) {
                if (versionRequirement == VersionRequirement.getDefaultInstance()) {
                    return this;
                }
                if (versionRequirement.hasVersion()) {
                    setVersion(versionRequirement.getVersion());
                }
                if (versionRequirement.hasVersionFull()) {
                    setVersionFull(versionRequirement.getVersionFull());
                }
                if (versionRequirement.hasLevel()) {
                    setLevel(versionRequirement.getLevel());
                }
                if (versionRequirement.hasErrorCode()) {
                    setErrorCode(versionRequirement.getErrorCode());
                }
                if (versionRequirement.hasMessage()) {
                    setMessage(versionRequirement.getMessage());
                }
                if (versionRequirement.hasVersionKind()) {
                    setVersionKind(versionRequirement.getVersionKind());
                }
                setUnknownFields(getUnknownFields().concat(versionRequirement.unknownFields));
                return this;
            }

            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                VersionRequirement versionRequirement;
                VersionRequirement versionRequirement2 = null;
                try {
                    VersionRequirement parsePartialFrom = VersionRequirement.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e11) {
                    versionRequirement = (VersionRequirement) e11.getUnfinishedMessage();
                    throw e11;
                } catch (Throwable th2) {
                    th = th2;
                    versionRequirement2 = versionRequirement;
                }
                if (versionRequirement2 != null) {
                    mergeFrom(versionRequirement2);
                }
                throw th;
            }
        }

        public enum Level implements Internal.EnumLite {
            WARNING(0, 0),
            ERROR(1, 1),
            HIDDEN(2, 2);
            
            private static Internal.EnumLiteMap<Level> internalValueMap;
            private final int value;

            /* access modifiers changed from: public */
            static {
                internalValueMap = new Internal.EnumLiteMap<Level>() {
                    public Level findValueByNumber(int i11) {
                        return Level.valueOf(i11);
                    }
                };
            }

            private Level(int i11, int i12) {
                this.value = i12;
            }

            public final int getNumber() {
                return this.value;
            }

            public static Level valueOf(int i11) {
                if (i11 == 0) {
                    return WARNING;
                }
                if (i11 == 1) {
                    return ERROR;
                }
                if (i11 != 2) {
                    return null;
                }
                return HIDDEN;
            }
        }

        public enum VersionKind implements Internal.EnumLite {
            LANGUAGE_VERSION(0, 0),
            COMPILER_VERSION(1, 1),
            API_VERSION(2, 2);
            
            private static Internal.EnumLiteMap<VersionKind> internalValueMap;
            private final int value;

            /* access modifiers changed from: public */
            static {
                internalValueMap = new Internal.EnumLiteMap<VersionKind>() {
                    public VersionKind findValueByNumber(int i11) {
                        return VersionKind.valueOf(i11);
                    }
                };
            }

            private VersionKind(int i11, int i12) {
                this.value = i12;
            }

            public final int getNumber() {
                return this.value;
            }

            public static VersionKind valueOf(int i11) {
                if (i11 == 0) {
                    return LANGUAGE_VERSION;
                }
                if (i11 == 1) {
                    return COMPILER_VERSION;
                }
                if (i11 != 2) {
                    return null;
                }
                return API_VERSION;
            }
        }

        static {
            VersionRequirement versionRequirement = new VersionRequirement(true);
            defaultInstance = versionRequirement;
            versionRequirement.initFields();
        }

        public static VersionRequirement getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.version_ = 0;
            this.versionFull_ = 0;
            this.level_ = Level.ERROR;
            this.errorCode_ = 0;
            this.message_ = 0;
            this.versionKind_ = VersionKind.LANGUAGE_VERSION;
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public int getErrorCode() {
            return this.errorCode_;
        }

        public Level getLevel() {
            return this.level_;
        }

        public int getMessage() {
            return this.message_;
        }

        public Parser<VersionRequirement> getParserForType() {
            return PARSER;
        }

        public int getSerializedSize() {
            int i11 = this.memoizedSerializedSize;
            if (i11 != -1) {
                return i11;
            }
            int i12 = 0;
            if ((this.bitField0_ & 1) == 1) {
                i12 = 0 + CodedOutputStream.computeInt32Size(1, this.version_);
            }
            if ((this.bitField0_ & 2) == 2) {
                i12 += CodedOutputStream.computeInt32Size(2, this.versionFull_);
            }
            if ((this.bitField0_ & 4) == 4) {
                i12 += CodedOutputStream.computeEnumSize(3, this.level_.getNumber());
            }
            if ((this.bitField0_ & 8) == 8) {
                i12 += CodedOutputStream.computeInt32Size(4, this.errorCode_);
            }
            if ((this.bitField0_ & 16) == 16) {
                i12 += CodedOutputStream.computeInt32Size(5, this.message_);
            }
            if ((this.bitField0_ & 32) == 32) {
                i12 += CodedOutputStream.computeEnumSize(6, this.versionKind_.getNumber());
            }
            int size = i12 + this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        public int getVersion() {
            return this.version_;
        }

        public int getVersionFull() {
            return this.versionFull_;
        }

        public VersionKind getVersionKind() {
            return this.versionKind_;
        }

        public boolean hasErrorCode() {
            return (this.bitField0_ & 8) == 8;
        }

        public boolean hasLevel() {
            return (this.bitField0_ & 4) == 4;
        }

        public boolean hasMessage() {
            return (this.bitField0_ & 16) == 16;
        }

        public boolean hasVersion() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean hasVersionFull() {
            return (this.bitField0_ & 2) == 2;
        }

        public boolean hasVersionKind() {
            return (this.bitField0_ & 32) == 32;
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
                codedOutputStream.writeInt32(1, this.version_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeInt32(2, this.versionFull_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeEnum(3, this.level_.getNumber());
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeInt32(4, this.errorCode_);
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.writeInt32(5, this.message_);
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.writeEnum(6, this.versionKind_.getNumber());
            }
            codedOutputStream.writeRawBytes(this.unknownFields);
        }

        public static Builder newBuilder(VersionRequirement versionRequirement) {
            return newBuilder().mergeFrom(versionRequirement);
        }

        public VersionRequirement getDefaultInstanceForType() {
            return defaultInstance;
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        private VersionRequirement(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private VersionRequirement(boolean z11) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        private VersionRequirement(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            this.version_ = codedInputStream.readInt32();
                        } else if (readTag == 16) {
                            this.bitField0_ |= 2;
                            this.versionFull_ = codedInputStream.readInt32();
                        } else if (readTag == 24) {
                            int readEnum = codedInputStream.readEnum();
                            Level valueOf = Level.valueOf(readEnum);
                            if (valueOf == null) {
                                newInstance.writeRawVarint32(readTag);
                                newInstance.writeRawVarint32(readEnum);
                            } else {
                                this.bitField0_ |= 4;
                                this.level_ = valueOf;
                            }
                        } else if (readTag == 32) {
                            this.bitField0_ |= 8;
                            this.errorCode_ = codedInputStream.readInt32();
                        } else if (readTag == 40) {
                            this.bitField0_ |= 16;
                            this.message_ = codedInputStream.readInt32();
                        } else if (readTag == 48) {
                            int readEnum2 = codedInputStream.readEnum();
                            VersionKind valueOf2 = VersionKind.valueOf(readEnum2);
                            if (valueOf2 == null) {
                                newInstance.writeRawVarint32(readTag);
                                newInstance.writeRawVarint32(readEnum2);
                            } else {
                                this.bitField0_ |= 32;
                                this.versionKind_ = valueOf2;
                            }
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

    public interface VersionRequirementOrBuilder extends MessageLiteOrBuilder {
    }

    public static final class VersionRequirementTable extends GeneratedMessageLite implements VersionRequirementTableOrBuilder {
        public static Parser<VersionRequirementTable> PARSER = new AbstractParser<VersionRequirementTable>() {
            public VersionRequirementTable parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new VersionRequirementTable(codedInputStream, extensionRegistryLite);
            }
        };
        private static final VersionRequirementTable defaultInstance;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        /* access modifiers changed from: private */
        public List<VersionRequirement> requirement_;
        /* access modifiers changed from: private */
        public final ByteString unknownFields;

        public static final class Builder extends GeneratedMessageLite.Builder<VersionRequirementTable, Builder> implements VersionRequirementTableOrBuilder {
            private int bitField0_;
            private List<VersionRequirement> requirement_ = Collections.emptyList();

            private Builder() {
                maybeForceBuilderInitialization();
            }

            /* access modifiers changed from: private */
            public static Builder create() {
                return new Builder();
            }

            private void ensureRequirementIsMutable() {
                if ((this.bitField0_ & 1) != 1) {
                    this.requirement_ = new ArrayList(this.requirement_);
                    this.bitField0_ |= 1;
                }
            }

            private void maybeForceBuilderInitialization() {
            }

            public VersionRequirementTable buildPartial() {
                VersionRequirementTable versionRequirementTable = new VersionRequirementTable((GeneratedMessageLite.Builder) this);
                if ((this.bitField0_ & 1) == 1) {
                    this.requirement_ = Collections.unmodifiableList(this.requirement_);
                    this.bitField0_ &= -2;
                }
                List unused = versionRequirementTable.requirement_ = this.requirement_;
                return versionRequirementTable;
            }

            public final boolean isInitialized() {
                return true;
            }

            public VersionRequirementTable build() {
                VersionRequirementTable buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.a(buildPartial);
            }

            public VersionRequirementTable getDefaultInstanceForType() {
                return VersionRequirementTable.getDefaultInstance();
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Builder mergeFrom(VersionRequirementTable versionRequirementTable) {
                if (versionRequirementTable == VersionRequirementTable.getDefaultInstance()) {
                    return this;
                }
                if (!versionRequirementTable.requirement_.isEmpty()) {
                    if (this.requirement_.isEmpty()) {
                        this.requirement_ = versionRequirementTable.requirement_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureRequirementIsMutable();
                        this.requirement_.addAll(versionRequirementTable.requirement_);
                    }
                }
                setUnknownFields(getUnknownFields().concat(versionRequirementTable.unknownFields));
                return this;
            }

            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                VersionRequirementTable versionRequirementTable;
                VersionRequirementTable versionRequirementTable2 = null;
                try {
                    VersionRequirementTable parsePartialFrom = VersionRequirementTable.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e11) {
                    versionRequirementTable = (VersionRequirementTable) e11.getUnfinishedMessage();
                    throw e11;
                } catch (Throwable th2) {
                    th = th2;
                    versionRequirementTable2 = versionRequirementTable;
                }
                if (versionRequirementTable2 != null) {
                    mergeFrom(versionRequirementTable2);
                }
                throw th;
            }
        }

        static {
            VersionRequirementTable versionRequirementTable = new VersionRequirementTable(true);
            defaultInstance = versionRequirementTable;
            versionRequirementTable.initFields();
        }

        public static VersionRequirementTable getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.requirement_ = Collections.emptyList();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Parser<VersionRequirementTable> getParserForType() {
            return PARSER;
        }

        public int getRequirementCount() {
            return this.requirement_.size();
        }

        public List<VersionRequirement> getRequirementList() {
            return this.requirement_;
        }

        public int getSerializedSize() {
            int i11 = this.memoizedSerializedSize;
            if (i11 != -1) {
                return i11;
            }
            int i12 = 0;
            for (int i13 = 0; i13 < this.requirement_.size(); i13++) {
                i12 += CodedOutputStream.computeMessageSize(1, this.requirement_.get(i13));
            }
            int size = i12 + this.unknownFields.size();
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
            for (int i11 = 0; i11 < this.requirement_.size(); i11++) {
                codedOutputStream.writeMessage(1, this.requirement_.get(i11));
            }
            codedOutputStream.writeRawBytes(this.unknownFields);
        }

        public static Builder newBuilder(VersionRequirementTable versionRequirementTable) {
            return newBuilder().mergeFrom(versionRequirementTable);
        }

        public VersionRequirementTable getDefaultInstanceForType() {
            return defaultInstance;
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        private VersionRequirementTable(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private VersionRequirementTable(boolean z11) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        private VersionRequirementTable(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                this.requirement_ = new ArrayList();
                                z12 |= true;
                            }
                            this.requirement_.add(codedInputStream.readMessage(VersionRequirement.PARSER, extensionRegistryLite));
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
                        this.requirement_ = Collections.unmodifiableList(this.requirement_);
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
                this.requirement_ = Collections.unmodifiableList(this.requirement_);
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

    public interface VersionRequirementTableOrBuilder extends MessageLiteOrBuilder {
    }

    public enum Visibility implements Internal.EnumLite {
        INTERNAL(0, 0),
        PRIVATE(1, 1),
        PROTECTED(2, 2),
        PUBLIC(3, 3),
        PRIVATE_TO_THIS(4, 4),
        LOCAL(5, 5);
        
        private static Internal.EnumLiteMap<Visibility> internalValueMap;
        private final int value;

        /* access modifiers changed from: public */
        static {
            internalValueMap = new Internal.EnumLiteMap<Visibility>() {
                public Visibility findValueByNumber(int i11) {
                    return Visibility.valueOf(i11);
                }
            };
        }

        private Visibility(int i11, int i12) {
            this.value = i12;
        }

        public final int getNumber() {
            return this.value;
        }

        public static Visibility valueOf(int i11) {
            if (i11 == 0) {
                return INTERNAL;
            }
            if (i11 == 1) {
                return PRIVATE;
            }
            if (i11 == 2) {
                return PROTECTED;
            }
            if (i11 == 3) {
                return PUBLIC;
            }
            if (i11 == 4) {
                return PRIVATE_TO_THIS;
            }
            if (i11 != 5) {
                return null;
            }
            return LOCAL;
        }
    }
}
