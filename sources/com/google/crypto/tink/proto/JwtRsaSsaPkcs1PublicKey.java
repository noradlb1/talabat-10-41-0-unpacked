package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.AbstractMessageLite;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.CodedInputStream;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;
import com.google.crypto.tink.shaded.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class JwtRsaSsaPkcs1PublicKey extends GeneratedMessageLite<JwtRsaSsaPkcs1PublicKey, Builder> implements JwtRsaSsaPkcs1PublicKeyOrBuilder {
    public static final int ALGORITHM_FIELD_NUMBER = 2;
    public static final int CUSTOM_KID_FIELD_NUMBER = 5;
    /* access modifiers changed from: private */
    public static final JwtRsaSsaPkcs1PublicKey DEFAULT_INSTANCE;
    public static final int E_FIELD_NUMBER = 4;
    public static final int N_FIELD_NUMBER = 3;
    private static volatile Parser<JwtRsaSsaPkcs1PublicKey> PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 1;
    private int algorithm_;
    private CustomKid customKid_;
    private ByteString e_;
    private ByteString n_;
    private int version_;

    /* renamed from: com.google.crypto.tink.proto.JwtRsaSsaPkcs1PublicKey$1  reason: invalid class name */
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
                com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite$MethodToInvoke[] r0 = com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.MethodToInvoke.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke = r0
                com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_BUILDER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x003e }
                com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.MethodToInvoke.GET_PARSER     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.proto.JwtRsaSsaPkcs1PublicKey.AnonymousClass1.<clinit>():void");
        }
    }

    public static final class Builder extends GeneratedMessageLite.Builder<JwtRsaSsaPkcs1PublicKey, Builder> implements JwtRsaSsaPkcs1PublicKeyOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 r12) {
            this();
        }

        public Builder clearAlgorithm() {
            copyOnWrite();
            ((JwtRsaSsaPkcs1PublicKey) this.instance).clearAlgorithm();
            return this;
        }

        public Builder clearCustomKid() {
            copyOnWrite();
            ((JwtRsaSsaPkcs1PublicKey) this.instance).clearCustomKid();
            return this;
        }

        public Builder clearE() {
            copyOnWrite();
            ((JwtRsaSsaPkcs1PublicKey) this.instance).clearE();
            return this;
        }

        public Builder clearN() {
            copyOnWrite();
            ((JwtRsaSsaPkcs1PublicKey) this.instance).clearN();
            return this;
        }

        public Builder clearVersion() {
            copyOnWrite();
            ((JwtRsaSsaPkcs1PublicKey) this.instance).clearVersion();
            return this;
        }

        public JwtRsaSsaPkcs1Algorithm getAlgorithm() {
            return ((JwtRsaSsaPkcs1PublicKey) this.instance).getAlgorithm();
        }

        public int getAlgorithmValue() {
            return ((JwtRsaSsaPkcs1PublicKey) this.instance).getAlgorithmValue();
        }

        public CustomKid getCustomKid() {
            return ((JwtRsaSsaPkcs1PublicKey) this.instance).getCustomKid();
        }

        public ByteString getE() {
            return ((JwtRsaSsaPkcs1PublicKey) this.instance).getE();
        }

        public ByteString getN() {
            return ((JwtRsaSsaPkcs1PublicKey) this.instance).getN();
        }

        public int getVersion() {
            return ((JwtRsaSsaPkcs1PublicKey) this.instance).getVersion();
        }

        public boolean hasCustomKid() {
            return ((JwtRsaSsaPkcs1PublicKey) this.instance).hasCustomKid();
        }

        public Builder mergeCustomKid(CustomKid customKid) {
            copyOnWrite();
            ((JwtRsaSsaPkcs1PublicKey) this.instance).mergeCustomKid(customKid);
            return this;
        }

        public Builder setAlgorithm(JwtRsaSsaPkcs1Algorithm jwtRsaSsaPkcs1Algorithm) {
            copyOnWrite();
            ((JwtRsaSsaPkcs1PublicKey) this.instance).setAlgorithm(jwtRsaSsaPkcs1Algorithm);
            return this;
        }

        public Builder setAlgorithmValue(int i11) {
            copyOnWrite();
            ((JwtRsaSsaPkcs1PublicKey) this.instance).setAlgorithmValue(i11);
            return this;
        }

        public Builder setCustomKid(CustomKid customKid) {
            copyOnWrite();
            ((JwtRsaSsaPkcs1PublicKey) this.instance).setCustomKid(customKid);
            return this;
        }

        public Builder setE(ByteString byteString) {
            copyOnWrite();
            ((JwtRsaSsaPkcs1PublicKey) this.instance).setE(byteString);
            return this;
        }

        public Builder setN(ByteString byteString) {
            copyOnWrite();
            ((JwtRsaSsaPkcs1PublicKey) this.instance).setN(byteString);
            return this;
        }

        public Builder setVersion(int i11) {
            copyOnWrite();
            ((JwtRsaSsaPkcs1PublicKey) this.instance).setVersion(i11);
            return this;
        }

        private Builder() {
            super(JwtRsaSsaPkcs1PublicKey.DEFAULT_INSTANCE);
        }

        public Builder setCustomKid(CustomKid.Builder builder) {
            copyOnWrite();
            ((JwtRsaSsaPkcs1PublicKey) this.instance).setCustomKid((CustomKid) builder.build());
            return this;
        }
    }

    public static final class CustomKid extends GeneratedMessageLite<CustomKid, Builder> implements CustomKidOrBuilder {
        /* access modifiers changed from: private */
        public static final CustomKid DEFAULT_INSTANCE;
        private static volatile Parser<CustomKid> PARSER = null;
        public static final int VALUE_FIELD_NUMBER = 1;
        private String value_ = "";

        public static final class Builder extends GeneratedMessageLite.Builder<CustomKid, Builder> implements CustomKidOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 r12) {
                this();
            }

            public Builder clearValue() {
                copyOnWrite();
                ((CustomKid) this.instance).clearValue();
                return this;
            }

            public String getValue() {
                return ((CustomKid) this.instance).getValue();
            }

            public ByteString getValueBytes() {
                return ((CustomKid) this.instance).getValueBytes();
            }

            public Builder setValue(String str) {
                copyOnWrite();
                ((CustomKid) this.instance).setValue(str);
                return this;
            }

            public Builder setValueBytes(ByteString byteString) {
                copyOnWrite();
                ((CustomKid) this.instance).setValueBytes(byteString);
                return this;
            }

            private Builder() {
                super(CustomKid.DEFAULT_INSTANCE);
            }
        }

        static {
            CustomKid customKid = new CustomKid();
            DEFAULT_INSTANCE = customKid;
            GeneratedMessageLite.registerDefaultInstance(CustomKid.class, customKid);
        }

        private CustomKid() {
        }

        /* access modifiers changed from: private */
        public void clearValue() {
            this.value_ = getDefaultInstance().getValue();
        }

        public static CustomKid getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static CustomKid parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (CustomKid) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static CustomKid parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (CustomKid) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<CustomKid> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* access modifiers changed from: private */
        public void setValue(String str) {
            str.getClass();
            this.value_ = str;
        }

        /* access modifiers changed from: private */
        public void setValueBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.value_ = byteString.toStringUtf8();
        }

        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new CustomKid();
                case 2:
                    return new Builder((AnonymousClass1) null);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"value_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<CustomKid> parser = PARSER;
                    if (parser == null) {
                        synchronized (CustomKid.class) {
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

        public String getValue() {
            return this.value_;
        }

        public ByteString getValueBytes() {
            return ByteString.copyFromUtf8(this.value_);
        }

        public static Builder newBuilder(CustomKid customKid) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(customKid);
        }

        public static CustomKid parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (CustomKid) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static CustomKid parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (CustomKid) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static CustomKid parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (CustomKid) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static CustomKid parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (CustomKid) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static CustomKid parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (CustomKid) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static CustomKid parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (CustomKid) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static CustomKid parseFrom(InputStream inputStream) throws IOException {
            return (CustomKid) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static CustomKid parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (CustomKid) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static CustomKid parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (CustomKid) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static CustomKid parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (CustomKid) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    public interface CustomKidOrBuilder extends MessageLiteOrBuilder {
        String getValue();

        ByteString getValueBytes();
    }

    static {
        JwtRsaSsaPkcs1PublicKey jwtRsaSsaPkcs1PublicKey = new JwtRsaSsaPkcs1PublicKey();
        DEFAULT_INSTANCE = jwtRsaSsaPkcs1PublicKey;
        GeneratedMessageLite.registerDefaultInstance(JwtRsaSsaPkcs1PublicKey.class, jwtRsaSsaPkcs1PublicKey);
    }

    private JwtRsaSsaPkcs1PublicKey() {
        ByteString byteString = ByteString.EMPTY;
        this.n_ = byteString;
        this.e_ = byteString;
    }

    /* access modifiers changed from: private */
    public void clearAlgorithm() {
        this.algorithm_ = 0;
    }

    /* access modifiers changed from: private */
    public void clearCustomKid() {
        this.customKid_ = null;
    }

    /* access modifiers changed from: private */
    public void clearE() {
        this.e_ = getDefaultInstance().getE();
    }

    /* access modifiers changed from: private */
    public void clearN() {
        this.n_ = getDefaultInstance().getN();
    }

    /* access modifiers changed from: private */
    public void clearVersion() {
        this.version_ = 0;
    }

    public static JwtRsaSsaPkcs1PublicKey getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* access modifiers changed from: private */
    public void mergeCustomKid(CustomKid customKid) {
        customKid.getClass();
        CustomKid customKid2 = this.customKid_;
        if (customKid2 == null || customKid2 == CustomKid.getDefaultInstance()) {
            this.customKid_ = customKid;
        } else {
            this.customKid_ = (CustomKid) ((CustomKid.Builder) CustomKid.newBuilder(this.customKid_).mergeFrom(customKid)).buildPartial();
        }
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.createBuilder();
    }

    public static JwtRsaSsaPkcs1PublicKey parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (JwtRsaSsaPkcs1PublicKey) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static JwtRsaSsaPkcs1PublicKey parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (JwtRsaSsaPkcs1PublicKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<JwtRsaSsaPkcs1PublicKey> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* access modifiers changed from: private */
    public void setAlgorithm(JwtRsaSsaPkcs1Algorithm jwtRsaSsaPkcs1Algorithm) {
        this.algorithm_ = jwtRsaSsaPkcs1Algorithm.getNumber();
    }

    /* access modifiers changed from: private */
    public void setAlgorithmValue(int i11) {
        this.algorithm_ = i11;
    }

    /* access modifiers changed from: private */
    public void setCustomKid(CustomKid customKid) {
        customKid.getClass();
        this.customKid_ = customKid;
    }

    /* access modifiers changed from: private */
    public void setE(ByteString byteString) {
        byteString.getClass();
        this.e_ = byteString;
    }

    /* access modifiers changed from: private */
    public void setN(ByteString byteString) {
        byteString.getClass();
        this.n_ = byteString;
    }

    /* access modifiers changed from: private */
    public void setVersion(int i11) {
        this.version_ = i11;
    }

    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new JwtRsaSsaPkcs1PublicKey();
            case 2:
                return new Builder((AnonymousClass1) null);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001\u000b\u0002\f\u0003\n\u0004\n\u0005\t", new Object[]{"version_", "algorithm_", "n_", "e_", "customKid_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<JwtRsaSsaPkcs1PublicKey> parser = PARSER;
                if (parser == null) {
                    synchronized (JwtRsaSsaPkcs1PublicKey.class) {
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

    public JwtRsaSsaPkcs1Algorithm getAlgorithm() {
        JwtRsaSsaPkcs1Algorithm forNumber = JwtRsaSsaPkcs1Algorithm.forNumber(this.algorithm_);
        if (forNumber == null) {
            return JwtRsaSsaPkcs1Algorithm.UNRECOGNIZED;
        }
        return forNumber;
    }

    public int getAlgorithmValue() {
        return this.algorithm_;
    }

    public CustomKid getCustomKid() {
        CustomKid customKid = this.customKid_;
        return customKid == null ? CustomKid.getDefaultInstance() : customKid;
    }

    public ByteString getE() {
        return this.e_;
    }

    public ByteString getN() {
        return this.n_;
    }

    public int getVersion() {
        return this.version_;
    }

    public boolean hasCustomKid() {
        return this.customKid_ != null;
    }

    public static Builder newBuilder(JwtRsaSsaPkcs1PublicKey jwtRsaSsaPkcs1PublicKey) {
        return (Builder) DEFAULT_INSTANCE.createBuilder(jwtRsaSsaPkcs1PublicKey);
    }

    public static JwtRsaSsaPkcs1PublicKey parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (JwtRsaSsaPkcs1PublicKey) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static JwtRsaSsaPkcs1PublicKey parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (JwtRsaSsaPkcs1PublicKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static JwtRsaSsaPkcs1PublicKey parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (JwtRsaSsaPkcs1PublicKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static JwtRsaSsaPkcs1PublicKey parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (JwtRsaSsaPkcs1PublicKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static JwtRsaSsaPkcs1PublicKey parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (JwtRsaSsaPkcs1PublicKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static JwtRsaSsaPkcs1PublicKey parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (JwtRsaSsaPkcs1PublicKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static JwtRsaSsaPkcs1PublicKey parseFrom(InputStream inputStream) throws IOException {
        return (JwtRsaSsaPkcs1PublicKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static JwtRsaSsaPkcs1PublicKey parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (JwtRsaSsaPkcs1PublicKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static JwtRsaSsaPkcs1PublicKey parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (JwtRsaSsaPkcs1PublicKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static JwtRsaSsaPkcs1PublicKey parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (JwtRsaSsaPkcs1PublicKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
