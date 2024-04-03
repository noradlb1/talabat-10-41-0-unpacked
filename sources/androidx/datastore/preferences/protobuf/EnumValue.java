package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import androidx.datastore.preferences.protobuf.Internal;
import androidx.datastore.preferences.protobuf.Option;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

public final class EnumValue extends GeneratedMessageLite<EnumValue, Builder> implements EnumValueOrBuilder {
    /* access modifiers changed from: private */
    public static final EnumValue DEFAULT_INSTANCE;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int NUMBER_FIELD_NUMBER = 2;
    public static final int OPTIONS_FIELD_NUMBER = 3;
    private static volatile Parser<EnumValue> PARSER;
    private String name_ = "";
    private int number_;
    private Internal.ProtobufList<Option> options_ = GeneratedMessageLite.n();

    /* renamed from: androidx.datastore.preferences.protobuf.EnumValue$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f35767a;

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
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke[] r0 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f35767a = r0
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f35767a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_BUILDER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f35767a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f35767a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f35767a     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.GET_PARSER     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f35767a     // Catch:{ NoSuchFieldError -> 0x0049 }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f35767a     // Catch:{ NoSuchFieldError -> 0x0054 }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.EnumValue.AnonymousClass1.<clinit>():void");
        }
    }

    public static final class Builder extends GeneratedMessageLite.Builder<EnumValue, Builder> implements EnumValueOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 r12) {
            this();
        }

        public Builder addAllOptions(Iterable<? extends Option> iterable) {
            d();
            ((EnumValue) this.f35783b).addAllOptions(iterable);
            return this;
        }

        public Builder addOptions(Option option) {
            d();
            ((EnumValue) this.f35783b).addOptions(option);
            return this;
        }

        public Builder clearName() {
            d();
            ((EnumValue) this.f35783b).clearName();
            return this;
        }

        public Builder clearNumber() {
            d();
            ((EnumValue) this.f35783b).clearNumber();
            return this;
        }

        public Builder clearOptions() {
            d();
            ((EnumValue) this.f35783b).clearOptions();
            return this;
        }

        public String getName() {
            return ((EnumValue) this.f35783b).getName();
        }

        public ByteString getNameBytes() {
            return ((EnumValue) this.f35783b).getNameBytes();
        }

        public int getNumber() {
            return ((EnumValue) this.f35783b).getNumber();
        }

        public Option getOptions(int i11) {
            return ((EnumValue) this.f35783b).getOptions(i11);
        }

        public int getOptionsCount() {
            return ((EnumValue) this.f35783b).getOptionsCount();
        }

        public List<Option> getOptionsList() {
            return Collections.unmodifiableList(((EnumValue) this.f35783b).getOptionsList());
        }

        public Builder removeOptions(int i11) {
            d();
            ((EnumValue) this.f35783b).removeOptions(i11);
            return this;
        }

        public Builder setName(String str) {
            d();
            ((EnumValue) this.f35783b).setName(str);
            return this;
        }

        public Builder setNameBytes(ByteString byteString) {
            d();
            ((EnumValue) this.f35783b).setNameBytes(byteString);
            return this;
        }

        public Builder setNumber(int i11) {
            d();
            ((EnumValue) this.f35783b).setNumber(i11);
            return this;
        }

        public Builder setOptions(int i11, Option option) {
            d();
            ((EnumValue) this.f35783b).setOptions(i11, option);
            return this;
        }

        private Builder() {
            super(EnumValue.DEFAULT_INSTANCE);
        }

        public Builder addOptions(int i11, Option option) {
            d();
            ((EnumValue) this.f35783b).addOptions(i11, option);
            return this;
        }

        public Builder setOptions(int i11, Option.Builder builder) {
            d();
            ((EnumValue) this.f35783b).setOptions(i11, builder);
            return this;
        }

        public Builder addOptions(Option.Builder builder) {
            d();
            ((EnumValue) this.f35783b).addOptions(builder);
            return this;
        }

        public Builder addOptions(int i11, Option.Builder builder) {
            d();
            ((EnumValue) this.f35783b).addOptions(i11, builder);
            return this;
        }
    }

    static {
        EnumValue enumValue = new EnumValue();
        DEFAULT_INSTANCE = enumValue;
        GeneratedMessageLite.L(EnumValue.class, enumValue);
    }

    private EnumValue() {
    }

    /* access modifiers changed from: private */
    public void addAllOptions(Iterable<? extends Option> iterable) {
        ensureOptionsIsMutable();
        AbstractMessageLite.a(iterable, this.options_);
    }

    /* access modifiers changed from: private */
    public void addOptions(Option option) {
        option.getClass();
        ensureOptionsIsMutable();
        this.options_.add(option);
    }

    /* access modifiers changed from: private */
    public void clearName() {
        this.name_ = getDefaultInstance().getName();
    }

    /* access modifiers changed from: private */
    public void clearNumber() {
        this.number_ = 0;
    }

    /* access modifiers changed from: private */
    public void clearOptions() {
        this.options_ = GeneratedMessageLite.n();
    }

    private void ensureOptionsIsMutable() {
        if (!this.options_.isModifiable()) {
            this.options_ = GeneratedMessageLite.u(this.options_);
        }
    }

    public static EnumValue getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.i();
    }

    public static EnumValue parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (EnumValue) GeneratedMessageLite.w(DEFAULT_INSTANCE, inputStream);
    }

    public static EnumValue parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (EnumValue) GeneratedMessageLite.E(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<EnumValue> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* access modifiers changed from: private */
    public void removeOptions(int i11) {
        ensureOptionsIsMutable();
        this.options_.remove(i11);
    }

    /* access modifiers changed from: private */
    public void setName(String str) {
        str.getClass();
        this.name_ = str;
    }

    /* access modifiers changed from: private */
    public void setNameBytes(ByteString byteString) {
        byteString.getClass();
        AbstractMessageLite.b(byteString);
        this.name_ = byteString.toStringUtf8();
    }

    /* access modifiers changed from: private */
    public void setNumber(int i11) {
        this.number_ = i11;
    }

    /* access modifiers changed from: private */
    public void setOptions(int i11, Option option) {
        option.getClass();
        ensureOptionsIsMutable();
        this.options_.set(i11, option);
    }

    public String getName() {
        return this.name_;
    }

    public ByteString getNameBytes() {
        return ByteString.copyFromUtf8(this.name_);
    }

    public int getNumber() {
        return this.number_;
    }

    public Option getOptions(int i11) {
        return this.options_.get(i11);
    }

    public int getOptionsCount() {
        return this.options_.size();
    }

    public List<Option> getOptionsList() {
        return this.options_;
    }

    public OptionOrBuilder getOptionsOrBuilder(int i11) {
        return this.options_.get(i11);
    }

    public List<? extends OptionOrBuilder> getOptionsOrBuilderList() {
        return this.options_;
    }

    public final Object m(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.f35767a[methodToInvoke.ordinal()]) {
            case 1:
                return new EnumValue();
            case 2:
                return new Builder((AnonymousClass1) null);
            case 3:
                return GeneratedMessageLite.v(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0001\u0000\u0001Ȉ\u0002\u0004\u0003\u001b", new Object[]{"name_", "number_", "options_", Option.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<EnumValue> parser = PARSER;
                if (parser == null) {
                    synchronized (EnumValue.class) {
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

    public static Builder newBuilder(EnumValue enumValue) {
        return (Builder) DEFAULT_INSTANCE.j(enumValue);
    }

    public static EnumValue parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (EnumValue) GeneratedMessageLite.x(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static EnumValue parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (EnumValue) GeneratedMessageLite.F(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static EnumValue parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (EnumValue) GeneratedMessageLite.y(DEFAULT_INSTANCE, byteString);
    }

    /* access modifiers changed from: private */
    public void addOptions(int i11, Option option) {
        option.getClass();
        ensureOptionsIsMutable();
        this.options_.add(i11, option);
    }

    public static EnumValue parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (EnumValue) GeneratedMessageLite.z(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    /* access modifiers changed from: private */
    public void setOptions(int i11, Option.Builder builder) {
        ensureOptionsIsMutable();
        this.options_.set(i11, builder.build());
    }

    public static EnumValue parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (EnumValue) GeneratedMessageLite.G(DEFAULT_INSTANCE, bArr);
    }

    public static EnumValue parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (EnumValue) GeneratedMessageLite.H(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    /* access modifiers changed from: private */
    public void addOptions(Option.Builder builder) {
        ensureOptionsIsMutable();
        this.options_.add(builder.build());
    }

    public static EnumValue parseFrom(InputStream inputStream) throws IOException {
        return (EnumValue) GeneratedMessageLite.C(DEFAULT_INSTANCE, inputStream);
    }

    public static EnumValue parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (EnumValue) GeneratedMessageLite.D(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    /* access modifiers changed from: private */
    public void addOptions(int i11, Option.Builder builder) {
        ensureOptionsIsMutable();
        this.options_.add(i11, builder.build());
    }

    public static EnumValue parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (EnumValue) GeneratedMessageLite.A(DEFAULT_INSTANCE, codedInputStream);
    }

    public static EnumValue parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (EnumValue) GeneratedMessageLite.B(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
