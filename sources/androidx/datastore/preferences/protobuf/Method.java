package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import androidx.datastore.preferences.protobuf.Internal;
import androidx.datastore.preferences.protobuf.Option;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

public final class Method extends GeneratedMessageLite<Method, Builder> implements MethodOrBuilder {
    /* access modifiers changed from: private */
    public static final Method DEFAULT_INSTANCE;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int OPTIONS_FIELD_NUMBER = 6;
    private static volatile Parser<Method> PARSER = null;
    public static final int REQUEST_STREAMING_FIELD_NUMBER = 3;
    public static final int REQUEST_TYPE_URL_FIELD_NUMBER = 2;
    public static final int RESPONSE_STREAMING_FIELD_NUMBER = 5;
    public static final int RESPONSE_TYPE_URL_FIELD_NUMBER = 4;
    public static final int SYNTAX_FIELD_NUMBER = 7;
    private String name_ = "";
    private Internal.ProtobufList<Option> options_ = GeneratedMessageLite.n();
    private boolean requestStreaming_;
    private String requestTypeUrl_ = "";
    private boolean responseStreaming_;
    private String responseTypeUrl_ = "";
    private int syntax_;

    /* renamed from: androidx.datastore.preferences.protobuf.Method$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f35808a;

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
                f35808a = r0
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f35808a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_BUILDER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f35808a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f35808a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f35808a     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.GET_PARSER     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f35808a     // Catch:{ NoSuchFieldError -> 0x0049 }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f35808a     // Catch:{ NoSuchFieldError -> 0x0054 }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.Method.AnonymousClass1.<clinit>():void");
        }
    }

    public static final class Builder extends GeneratedMessageLite.Builder<Method, Builder> implements MethodOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 r12) {
            this();
        }

        public Builder addAllOptions(Iterable<? extends Option> iterable) {
            d();
            ((Method) this.f35783b).addAllOptions(iterable);
            return this;
        }

        public Builder addOptions(Option option) {
            d();
            ((Method) this.f35783b).addOptions(option);
            return this;
        }

        public Builder clearName() {
            d();
            ((Method) this.f35783b).clearName();
            return this;
        }

        public Builder clearOptions() {
            d();
            ((Method) this.f35783b).clearOptions();
            return this;
        }

        public Builder clearRequestStreaming() {
            d();
            ((Method) this.f35783b).clearRequestStreaming();
            return this;
        }

        public Builder clearRequestTypeUrl() {
            d();
            ((Method) this.f35783b).clearRequestTypeUrl();
            return this;
        }

        public Builder clearResponseStreaming() {
            d();
            ((Method) this.f35783b).clearResponseStreaming();
            return this;
        }

        public Builder clearResponseTypeUrl() {
            d();
            ((Method) this.f35783b).clearResponseTypeUrl();
            return this;
        }

        public Builder clearSyntax() {
            d();
            ((Method) this.f35783b).clearSyntax();
            return this;
        }

        public String getName() {
            return ((Method) this.f35783b).getName();
        }

        public ByteString getNameBytes() {
            return ((Method) this.f35783b).getNameBytes();
        }

        public Option getOptions(int i11) {
            return ((Method) this.f35783b).getOptions(i11);
        }

        public int getOptionsCount() {
            return ((Method) this.f35783b).getOptionsCount();
        }

        public List<Option> getOptionsList() {
            return Collections.unmodifiableList(((Method) this.f35783b).getOptionsList());
        }

        public boolean getRequestStreaming() {
            return ((Method) this.f35783b).getRequestStreaming();
        }

        public String getRequestTypeUrl() {
            return ((Method) this.f35783b).getRequestTypeUrl();
        }

        public ByteString getRequestTypeUrlBytes() {
            return ((Method) this.f35783b).getRequestTypeUrlBytes();
        }

        public boolean getResponseStreaming() {
            return ((Method) this.f35783b).getResponseStreaming();
        }

        public String getResponseTypeUrl() {
            return ((Method) this.f35783b).getResponseTypeUrl();
        }

        public ByteString getResponseTypeUrlBytes() {
            return ((Method) this.f35783b).getResponseTypeUrlBytes();
        }

        public Syntax getSyntax() {
            return ((Method) this.f35783b).getSyntax();
        }

        public int getSyntaxValue() {
            return ((Method) this.f35783b).getSyntaxValue();
        }

        public Builder removeOptions(int i11) {
            d();
            ((Method) this.f35783b).removeOptions(i11);
            return this;
        }

        public Builder setName(String str) {
            d();
            ((Method) this.f35783b).setName(str);
            return this;
        }

        public Builder setNameBytes(ByteString byteString) {
            d();
            ((Method) this.f35783b).setNameBytes(byteString);
            return this;
        }

        public Builder setOptions(int i11, Option option) {
            d();
            ((Method) this.f35783b).setOptions(i11, option);
            return this;
        }

        public Builder setRequestStreaming(boolean z11) {
            d();
            ((Method) this.f35783b).setRequestStreaming(z11);
            return this;
        }

        public Builder setRequestTypeUrl(String str) {
            d();
            ((Method) this.f35783b).setRequestTypeUrl(str);
            return this;
        }

        public Builder setRequestTypeUrlBytes(ByteString byteString) {
            d();
            ((Method) this.f35783b).setRequestTypeUrlBytes(byteString);
            return this;
        }

        public Builder setResponseStreaming(boolean z11) {
            d();
            ((Method) this.f35783b).setResponseStreaming(z11);
            return this;
        }

        public Builder setResponseTypeUrl(String str) {
            d();
            ((Method) this.f35783b).setResponseTypeUrl(str);
            return this;
        }

        public Builder setResponseTypeUrlBytes(ByteString byteString) {
            d();
            ((Method) this.f35783b).setResponseTypeUrlBytes(byteString);
            return this;
        }

        public Builder setSyntax(Syntax syntax) {
            d();
            ((Method) this.f35783b).setSyntax(syntax);
            return this;
        }

        public Builder setSyntaxValue(int i11) {
            d();
            ((Method) this.f35783b).setSyntaxValue(i11);
            return this;
        }

        private Builder() {
            super(Method.DEFAULT_INSTANCE);
        }

        public Builder addOptions(int i11, Option option) {
            d();
            ((Method) this.f35783b).addOptions(i11, option);
            return this;
        }

        public Builder setOptions(int i11, Option.Builder builder) {
            d();
            ((Method) this.f35783b).setOptions(i11, builder);
            return this;
        }

        public Builder addOptions(Option.Builder builder) {
            d();
            ((Method) this.f35783b).addOptions(builder);
            return this;
        }

        public Builder addOptions(int i11, Option.Builder builder) {
            d();
            ((Method) this.f35783b).addOptions(i11, builder);
            return this;
        }
    }

    static {
        Method method = new Method();
        DEFAULT_INSTANCE = method;
        GeneratedMessageLite.L(Method.class, method);
    }

    private Method() {
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
    public void clearOptions() {
        this.options_ = GeneratedMessageLite.n();
    }

    /* access modifiers changed from: private */
    public void clearRequestStreaming() {
        this.requestStreaming_ = false;
    }

    /* access modifiers changed from: private */
    public void clearRequestTypeUrl() {
        this.requestTypeUrl_ = getDefaultInstance().getRequestTypeUrl();
    }

    /* access modifiers changed from: private */
    public void clearResponseStreaming() {
        this.responseStreaming_ = false;
    }

    /* access modifiers changed from: private */
    public void clearResponseTypeUrl() {
        this.responseTypeUrl_ = getDefaultInstance().getResponseTypeUrl();
    }

    /* access modifiers changed from: private */
    public void clearSyntax() {
        this.syntax_ = 0;
    }

    private void ensureOptionsIsMutable() {
        if (!this.options_.isModifiable()) {
            this.options_ = GeneratedMessageLite.u(this.options_);
        }
    }

    public static Method getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.i();
    }

    public static Method parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Method) GeneratedMessageLite.w(DEFAULT_INSTANCE, inputStream);
    }

    public static Method parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (Method) GeneratedMessageLite.E(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<Method> parser() {
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
    public void setOptions(int i11, Option option) {
        option.getClass();
        ensureOptionsIsMutable();
        this.options_.set(i11, option);
    }

    /* access modifiers changed from: private */
    public void setRequestStreaming(boolean z11) {
        this.requestStreaming_ = z11;
    }

    /* access modifiers changed from: private */
    public void setRequestTypeUrl(String str) {
        str.getClass();
        this.requestTypeUrl_ = str;
    }

    /* access modifiers changed from: private */
    public void setRequestTypeUrlBytes(ByteString byteString) {
        byteString.getClass();
        AbstractMessageLite.b(byteString);
        this.requestTypeUrl_ = byteString.toStringUtf8();
    }

    /* access modifiers changed from: private */
    public void setResponseStreaming(boolean z11) {
        this.responseStreaming_ = z11;
    }

    /* access modifiers changed from: private */
    public void setResponseTypeUrl(String str) {
        str.getClass();
        this.responseTypeUrl_ = str;
    }

    /* access modifiers changed from: private */
    public void setResponseTypeUrlBytes(ByteString byteString) {
        byteString.getClass();
        AbstractMessageLite.b(byteString);
        this.responseTypeUrl_ = byteString.toStringUtf8();
    }

    /* access modifiers changed from: private */
    public void setSyntax(Syntax syntax) {
        syntax.getClass();
        this.syntax_ = syntax.getNumber();
    }

    /* access modifiers changed from: private */
    public void setSyntaxValue(int i11) {
        this.syntax_ = i11;
    }

    public String getName() {
        return this.name_;
    }

    public ByteString getNameBytes() {
        return ByteString.copyFromUtf8(this.name_);
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

    public boolean getRequestStreaming() {
        return this.requestStreaming_;
    }

    public String getRequestTypeUrl() {
        return this.requestTypeUrl_;
    }

    public ByteString getRequestTypeUrlBytes() {
        return ByteString.copyFromUtf8(this.requestTypeUrl_);
    }

    public boolean getResponseStreaming() {
        return this.responseStreaming_;
    }

    public String getResponseTypeUrl() {
        return this.responseTypeUrl_;
    }

    public ByteString getResponseTypeUrlBytes() {
        return ByteString.copyFromUtf8(this.responseTypeUrl_);
    }

    public Syntax getSyntax() {
        Syntax forNumber = Syntax.forNumber(this.syntax_);
        if (forNumber == null) {
            return Syntax.UNRECOGNIZED;
        }
        return forNumber;
    }

    public int getSyntaxValue() {
        return this.syntax_;
    }

    public final Object m(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.f35808a[methodToInvoke.ordinal()]) {
            case 1:
                return new Method();
            case 2:
                return new Builder((AnonymousClass1) null);
            case 3:
                return GeneratedMessageLite.v(DEFAULT_INSTANCE, "\u0000\u0007\u0000\u0000\u0001\u0007\u0007\u0000\u0001\u0000\u0001Ȉ\u0002Ȉ\u0003\u0007\u0004Ȉ\u0005\u0007\u0006\u001b\u0007\f", new Object[]{"name_", "requestTypeUrl_", "requestStreaming_", "responseTypeUrl_", "responseStreaming_", "options_", Option.class, "syntax_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Method> parser = PARSER;
                if (parser == null) {
                    synchronized (Method.class) {
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

    public static Builder newBuilder(Method method) {
        return (Builder) DEFAULT_INSTANCE.j(method);
    }

    public static Method parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Method) GeneratedMessageLite.x(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Method parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Method) GeneratedMessageLite.F(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Method parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (Method) GeneratedMessageLite.y(DEFAULT_INSTANCE, byteString);
    }

    /* access modifiers changed from: private */
    public void addOptions(int i11, Option option) {
        option.getClass();
        ensureOptionsIsMutable();
        this.options_.add(i11, option);
    }

    public static Method parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Method) GeneratedMessageLite.z(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    /* access modifiers changed from: private */
    public void setOptions(int i11, Option.Builder builder) {
        ensureOptionsIsMutable();
        this.options_.set(i11, builder.build());
    }

    public static Method parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (Method) GeneratedMessageLite.G(DEFAULT_INSTANCE, bArr);
    }

    public static Method parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Method) GeneratedMessageLite.H(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    /* access modifiers changed from: private */
    public void addOptions(Option.Builder builder) {
        ensureOptionsIsMutable();
        this.options_.add(builder.build());
    }

    public static Method parseFrom(InputStream inputStream) throws IOException {
        return (Method) GeneratedMessageLite.C(DEFAULT_INSTANCE, inputStream);
    }

    public static Method parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Method) GeneratedMessageLite.D(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    /* access modifiers changed from: private */
    public void addOptions(int i11, Option.Builder builder) {
        ensureOptionsIsMutable();
        this.options_.add(i11, builder.build());
    }

    public static Method parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Method) GeneratedMessageLite.A(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Method parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Method) GeneratedMessageLite.B(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
