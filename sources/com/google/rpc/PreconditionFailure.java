package com.google.rpc;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

public final class PreconditionFailure extends GeneratedMessageLite<PreconditionFailure, Builder> implements PreconditionFailureOrBuilder {
    /* access modifiers changed from: private */
    public static final PreconditionFailure DEFAULT_INSTANCE;
    private static volatile Parser<PreconditionFailure> PARSER = null;
    public static final int VIOLATIONS_FIELD_NUMBER = 1;
    private Internal.ProtobufList<Violation> violations_ = GeneratedMessageLite.emptyProtobufList();

    /* renamed from: com.google.rpc.PreconditionFailure$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke[] r0 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke = r0
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_BUILDER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x003e }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.GET_PARSER     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.rpc.PreconditionFailure.AnonymousClass1.<clinit>():void");
        }
    }

    public static final class Builder extends GeneratedMessageLite.Builder<PreconditionFailure, Builder> implements PreconditionFailureOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 r12) {
            this();
        }

        public Builder addAllViolations(Iterable<? extends Violation> iterable) {
            copyOnWrite();
            ((PreconditionFailure) this.instance).addAllViolations(iterable);
            return this;
        }

        public Builder addViolations(Violation violation) {
            copyOnWrite();
            ((PreconditionFailure) this.instance).addViolations(violation);
            return this;
        }

        public Builder clearViolations() {
            copyOnWrite();
            ((PreconditionFailure) this.instance).clearViolations();
            return this;
        }

        public Violation getViolations(int i11) {
            return ((PreconditionFailure) this.instance).getViolations(i11);
        }

        public int getViolationsCount() {
            return ((PreconditionFailure) this.instance).getViolationsCount();
        }

        public List<Violation> getViolationsList() {
            return Collections.unmodifiableList(((PreconditionFailure) this.instance).getViolationsList());
        }

        public Builder removeViolations(int i11) {
            copyOnWrite();
            ((PreconditionFailure) this.instance).removeViolations(i11);
            return this;
        }

        public Builder setViolations(int i11, Violation violation) {
            copyOnWrite();
            ((PreconditionFailure) this.instance).setViolations(i11, violation);
            return this;
        }

        private Builder() {
            super(PreconditionFailure.DEFAULT_INSTANCE);
        }

        public Builder addViolations(int i11, Violation violation) {
            copyOnWrite();
            ((PreconditionFailure) this.instance).addViolations(i11, violation);
            return this;
        }

        public Builder setViolations(int i11, Violation.Builder builder) {
            copyOnWrite();
            ((PreconditionFailure) this.instance).setViolations(i11, (Violation) builder.build());
            return this;
        }

        public Builder addViolations(Violation.Builder builder) {
            copyOnWrite();
            ((PreconditionFailure) this.instance).addViolations((Violation) builder.build());
            return this;
        }

        public Builder addViolations(int i11, Violation.Builder builder) {
            copyOnWrite();
            ((PreconditionFailure) this.instance).addViolations(i11, (Violation) builder.build());
            return this;
        }
    }

    public static final class Violation extends GeneratedMessageLite<Violation, Builder> implements ViolationOrBuilder {
        /* access modifiers changed from: private */
        public static final Violation DEFAULT_INSTANCE;
        public static final int DESCRIPTION_FIELD_NUMBER = 3;
        private static volatile Parser<Violation> PARSER = null;
        public static final int SUBJECT_FIELD_NUMBER = 2;
        public static final int TYPE_FIELD_NUMBER = 1;
        private String description_ = "";
        private String subject_ = "";
        private String type_ = "";

        public static final class Builder extends GeneratedMessageLite.Builder<Violation, Builder> implements ViolationOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 r12) {
                this();
            }

            public Builder clearDescription() {
                copyOnWrite();
                ((Violation) this.instance).clearDescription();
                return this;
            }

            public Builder clearSubject() {
                copyOnWrite();
                ((Violation) this.instance).clearSubject();
                return this;
            }

            public Builder clearType() {
                copyOnWrite();
                ((Violation) this.instance).clearType();
                return this;
            }

            public String getDescription() {
                return ((Violation) this.instance).getDescription();
            }

            public ByteString getDescriptionBytes() {
                return ((Violation) this.instance).getDescriptionBytes();
            }

            public String getSubject() {
                return ((Violation) this.instance).getSubject();
            }

            public ByteString getSubjectBytes() {
                return ((Violation) this.instance).getSubjectBytes();
            }

            public String getType() {
                return ((Violation) this.instance).getType();
            }

            public ByteString getTypeBytes() {
                return ((Violation) this.instance).getTypeBytes();
            }

            public Builder setDescription(String str) {
                copyOnWrite();
                ((Violation) this.instance).setDescription(str);
                return this;
            }

            public Builder setDescriptionBytes(ByteString byteString) {
                copyOnWrite();
                ((Violation) this.instance).setDescriptionBytes(byteString);
                return this;
            }

            public Builder setSubject(String str) {
                copyOnWrite();
                ((Violation) this.instance).setSubject(str);
                return this;
            }

            public Builder setSubjectBytes(ByteString byteString) {
                copyOnWrite();
                ((Violation) this.instance).setSubjectBytes(byteString);
                return this;
            }

            public Builder setType(String str) {
                copyOnWrite();
                ((Violation) this.instance).setType(str);
                return this;
            }

            public Builder setTypeBytes(ByteString byteString) {
                copyOnWrite();
                ((Violation) this.instance).setTypeBytes(byteString);
                return this;
            }

            private Builder() {
                super(Violation.DEFAULT_INSTANCE);
            }
        }

        static {
            Violation violation = new Violation();
            DEFAULT_INSTANCE = violation;
            GeneratedMessageLite.registerDefaultInstance(Violation.class, violation);
        }

        private Violation() {
        }

        /* access modifiers changed from: private */
        public void clearDescription() {
            this.description_ = getDefaultInstance().getDescription();
        }

        /* access modifiers changed from: private */
        public void clearSubject() {
            this.subject_ = getDefaultInstance().getSubject();
        }

        /* access modifiers changed from: private */
        public void clearType() {
            this.type_ = getDefaultInstance().getType();
        }

        public static Violation getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static Violation parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Violation) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Violation parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (Violation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<Violation> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* access modifiers changed from: private */
        public void setDescription(String str) {
            str.getClass();
            this.description_ = str;
        }

        /* access modifiers changed from: private */
        public void setDescriptionBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.description_ = byteString.toStringUtf8();
        }

        /* access modifiers changed from: private */
        public void setSubject(String str) {
            str.getClass();
            this.subject_ = str;
        }

        /* access modifiers changed from: private */
        public void setSubjectBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.subject_ = byteString.toStringUtf8();
        }

        /* access modifiers changed from: private */
        public void setType(String str) {
            str.getClass();
            this.type_ = str;
        }

        /* access modifiers changed from: private */
        public void setTypeBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.type_ = byteString.toStringUtf8();
        }

        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new Violation();
                case 2:
                    return new Builder((AnonymousClass1) null);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ", new Object[]{"type_", "subject_", "description_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<Violation> parser = PARSER;
                    if (parser == null) {
                        synchronized (Violation.class) {
                            parser = PARSER;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = parser;
                            }
                        }
                    }
                    return parser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public String getDescription() {
            return this.description_;
        }

        public ByteString getDescriptionBytes() {
            return ByteString.copyFromUtf8(this.description_);
        }

        public String getSubject() {
            return this.subject_;
        }

        public ByteString getSubjectBytes() {
            return ByteString.copyFromUtf8(this.subject_);
        }

        public String getType() {
            return this.type_;
        }

        public ByteString getTypeBytes() {
            return ByteString.copyFromUtf8(this.type_);
        }

        public static Builder newBuilder(Violation violation) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(violation);
        }

        public static Violation parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Violation) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Violation parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Violation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static Violation parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (Violation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Violation parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Violation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static Violation parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (Violation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static Violation parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Violation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Violation parseFrom(InputStream inputStream) throws IOException {
            return (Violation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Violation parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Violation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Violation parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Violation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static Violation parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Violation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    public interface ViolationOrBuilder extends MessageLiteOrBuilder {
        String getDescription();

        ByteString getDescriptionBytes();

        String getSubject();

        ByteString getSubjectBytes();

        String getType();

        ByteString getTypeBytes();
    }

    static {
        PreconditionFailure preconditionFailure = new PreconditionFailure();
        DEFAULT_INSTANCE = preconditionFailure;
        GeneratedMessageLite.registerDefaultInstance(PreconditionFailure.class, preconditionFailure);
    }

    private PreconditionFailure() {
    }

    /* access modifiers changed from: private */
    public void addAllViolations(Iterable<? extends Violation> iterable) {
        ensureViolationsIsMutable();
        AbstractMessageLite.addAll(iterable, this.violations_);
    }

    /* access modifiers changed from: private */
    public void addViolations(Violation violation) {
        violation.getClass();
        ensureViolationsIsMutable();
        this.violations_.add(violation);
    }

    /* access modifiers changed from: private */
    public void clearViolations() {
        this.violations_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureViolationsIsMutable() {
        Internal.ProtobufList<Violation> protobufList = this.violations_;
        if (!protobufList.isModifiable()) {
            this.violations_ = GeneratedMessageLite.mutableCopy(protobufList);
        }
    }

    public static PreconditionFailure getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.createBuilder();
    }

    public static PreconditionFailure parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (PreconditionFailure) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PreconditionFailure parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (PreconditionFailure) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<PreconditionFailure> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* access modifiers changed from: private */
    public void removeViolations(int i11) {
        ensureViolationsIsMutable();
        this.violations_.remove(i11);
    }

    /* access modifiers changed from: private */
    public void setViolations(int i11, Violation violation) {
        violation.getClass();
        ensureViolationsIsMutable();
        this.violations_.set(i11, violation);
    }

    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new PreconditionFailure();
            case 2:
                return new Builder((AnonymousClass1) null);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"violations_", Violation.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<PreconditionFailure> parser = PARSER;
                if (parser == null) {
                    synchronized (PreconditionFailure.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                }
                return parser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public Violation getViolations(int i11) {
        return this.violations_.get(i11);
    }

    public int getViolationsCount() {
        return this.violations_.size();
    }

    public List<Violation> getViolationsList() {
        return this.violations_;
    }

    public ViolationOrBuilder getViolationsOrBuilder(int i11) {
        return this.violations_.get(i11);
    }

    public List<? extends ViolationOrBuilder> getViolationsOrBuilderList() {
        return this.violations_;
    }

    public static Builder newBuilder(PreconditionFailure preconditionFailure) {
        return (Builder) DEFAULT_INSTANCE.createBuilder(preconditionFailure);
    }

    public static PreconditionFailure parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (PreconditionFailure) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static PreconditionFailure parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (PreconditionFailure) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static PreconditionFailure parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (PreconditionFailure) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    /* access modifiers changed from: private */
    public void addViolations(int i11, Violation violation) {
        violation.getClass();
        ensureViolationsIsMutable();
        this.violations_.add(i11, violation);
    }

    public static PreconditionFailure parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (PreconditionFailure) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static PreconditionFailure parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (PreconditionFailure) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PreconditionFailure parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (PreconditionFailure) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static PreconditionFailure parseFrom(InputStream inputStream) throws IOException {
        return (PreconditionFailure) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PreconditionFailure parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (PreconditionFailure) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static PreconditionFailure parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (PreconditionFailure) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static PreconditionFailure parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (PreconditionFailure) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
