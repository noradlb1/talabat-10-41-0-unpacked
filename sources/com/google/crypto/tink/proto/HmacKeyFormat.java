package com.google.crypto.tink.proto;

import com.google.crypto.tink.proto.HmacParams;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.CodedInputStream;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class HmacKeyFormat extends GeneratedMessageLite<HmacKeyFormat, Builder> implements HmacKeyFormatOrBuilder {
    /* access modifiers changed from: private */
    public static final HmacKeyFormat DEFAULT_INSTANCE;
    public static final int KEY_SIZE_FIELD_NUMBER = 2;
    public static final int PARAMS_FIELD_NUMBER = 1;
    private static volatile Parser<HmacKeyFormat> PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 3;
    private int keySize_;
    private HmacParams params_;
    private int version_;

    /* renamed from: com.google.crypto.tink.proto.HmacKeyFormat$1  reason: invalid class name */
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.proto.HmacKeyFormat.AnonymousClass1.<clinit>():void");
        }
    }

    public static final class Builder extends GeneratedMessageLite.Builder<HmacKeyFormat, Builder> implements HmacKeyFormatOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 r12) {
            this();
        }

        public Builder clearKeySize() {
            copyOnWrite();
            ((HmacKeyFormat) this.instance).clearKeySize();
            return this;
        }

        public Builder clearParams() {
            copyOnWrite();
            ((HmacKeyFormat) this.instance).clearParams();
            return this;
        }

        public Builder clearVersion() {
            copyOnWrite();
            ((HmacKeyFormat) this.instance).clearVersion();
            return this;
        }

        public int getKeySize() {
            return ((HmacKeyFormat) this.instance).getKeySize();
        }

        public HmacParams getParams() {
            return ((HmacKeyFormat) this.instance).getParams();
        }

        public int getVersion() {
            return ((HmacKeyFormat) this.instance).getVersion();
        }

        public boolean hasParams() {
            return ((HmacKeyFormat) this.instance).hasParams();
        }

        public Builder mergeParams(HmacParams hmacParams) {
            copyOnWrite();
            ((HmacKeyFormat) this.instance).mergeParams(hmacParams);
            return this;
        }

        public Builder setKeySize(int i11) {
            copyOnWrite();
            ((HmacKeyFormat) this.instance).setKeySize(i11);
            return this;
        }

        public Builder setParams(HmacParams hmacParams) {
            copyOnWrite();
            ((HmacKeyFormat) this.instance).setParams(hmacParams);
            return this;
        }

        public Builder setVersion(int i11) {
            copyOnWrite();
            ((HmacKeyFormat) this.instance).setVersion(i11);
            return this;
        }

        private Builder() {
            super(HmacKeyFormat.DEFAULT_INSTANCE);
        }

        public Builder setParams(HmacParams.Builder builder) {
            copyOnWrite();
            ((HmacKeyFormat) this.instance).setParams((HmacParams) builder.build());
            return this;
        }
    }

    static {
        HmacKeyFormat hmacKeyFormat = new HmacKeyFormat();
        DEFAULT_INSTANCE = hmacKeyFormat;
        GeneratedMessageLite.registerDefaultInstance(HmacKeyFormat.class, hmacKeyFormat);
    }

    private HmacKeyFormat() {
    }

    /* access modifiers changed from: private */
    public void clearKeySize() {
        this.keySize_ = 0;
    }

    /* access modifiers changed from: private */
    public void clearParams() {
        this.params_ = null;
    }

    /* access modifiers changed from: private */
    public void clearVersion() {
        this.version_ = 0;
    }

    public static HmacKeyFormat getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* access modifiers changed from: private */
    public void mergeParams(HmacParams hmacParams) {
        hmacParams.getClass();
        HmacParams hmacParams2 = this.params_;
        if (hmacParams2 == null || hmacParams2 == HmacParams.getDefaultInstance()) {
            this.params_ = hmacParams;
        } else {
            this.params_ = (HmacParams) ((HmacParams.Builder) HmacParams.newBuilder(this.params_).mergeFrom(hmacParams)).buildPartial();
        }
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.createBuilder();
    }

    public static HmacKeyFormat parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (HmacKeyFormat) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static HmacKeyFormat parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (HmacKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<HmacKeyFormat> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* access modifiers changed from: private */
    public void setKeySize(int i11) {
        this.keySize_ = i11;
    }

    /* access modifiers changed from: private */
    public void setParams(HmacParams hmacParams) {
        hmacParams.getClass();
        this.params_ = hmacParams;
    }

    /* access modifiers changed from: private */
    public void setVersion(int i11) {
        this.version_ = i11;
    }

    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new HmacKeyFormat();
            case 2:
                return new Builder((AnonymousClass1) null);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0002\u000b\u0003\u000b", new Object[]{"params_", "keySize_", "version_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<HmacKeyFormat> parser = PARSER;
                if (parser == null) {
                    synchronized (HmacKeyFormat.class) {
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

    public int getKeySize() {
        return this.keySize_;
    }

    public HmacParams getParams() {
        HmacParams hmacParams = this.params_;
        return hmacParams == null ? HmacParams.getDefaultInstance() : hmacParams;
    }

    public int getVersion() {
        return this.version_;
    }

    public boolean hasParams() {
        return this.params_ != null;
    }

    public static Builder newBuilder(HmacKeyFormat hmacKeyFormat) {
        return (Builder) DEFAULT_INSTANCE.createBuilder(hmacKeyFormat);
    }

    public static HmacKeyFormat parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (HmacKeyFormat) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static HmacKeyFormat parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (HmacKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static HmacKeyFormat parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (HmacKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static HmacKeyFormat parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (HmacKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static HmacKeyFormat parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (HmacKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static HmacKeyFormat parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (HmacKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static HmacKeyFormat parseFrom(InputStream inputStream) throws IOException {
        return (HmacKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static HmacKeyFormat parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (HmacKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static HmacKeyFormat parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (HmacKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static HmacKeyFormat parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (HmacKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
