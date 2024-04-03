package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import androidx.datastore.preferences.protobuf.Internal;
import androidx.datastore.preferences.protobuf.Method;
import androidx.datastore.preferences.protobuf.Mixin;
import androidx.datastore.preferences.protobuf.Option;
import androidx.datastore.preferences.protobuf.SourceContext;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

public final class Api extends GeneratedMessageLite<Api, Builder> implements ApiOrBuilder {
    /* access modifiers changed from: private */
    public static final Api DEFAULT_INSTANCE;
    public static final int METHODS_FIELD_NUMBER = 2;
    public static final int MIXINS_FIELD_NUMBER = 6;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int OPTIONS_FIELD_NUMBER = 3;
    private static volatile Parser<Api> PARSER = null;
    public static final int SOURCE_CONTEXT_FIELD_NUMBER = 5;
    public static final int SYNTAX_FIELD_NUMBER = 7;
    public static final int VERSION_FIELD_NUMBER = 4;
    private Internal.ProtobufList<Method> methods_ = GeneratedMessageLite.n();
    private Internal.ProtobufList<Mixin> mixins_ = GeneratedMessageLite.n();
    private String name_ = "";
    private Internal.ProtobufList<Option> options_ = GeneratedMessageLite.n();
    private SourceContext sourceContext_;
    private int syntax_;
    private String version_ = "";

    /* renamed from: androidx.datastore.preferences.protobuf.Api$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f35741a;

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
                f35741a = r0
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f35741a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_BUILDER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f35741a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f35741a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f35741a     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.GET_PARSER     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f35741a     // Catch:{ NoSuchFieldError -> 0x0049 }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f35741a     // Catch:{ NoSuchFieldError -> 0x0054 }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.Api.AnonymousClass1.<clinit>():void");
        }
    }

    public static final class Builder extends GeneratedMessageLite.Builder<Api, Builder> implements ApiOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 r12) {
            this();
        }

        public Builder addAllMethods(Iterable<? extends Method> iterable) {
            d();
            ((Api) this.f35783b).addAllMethods(iterable);
            return this;
        }

        public Builder addAllMixins(Iterable<? extends Mixin> iterable) {
            d();
            ((Api) this.f35783b).addAllMixins(iterable);
            return this;
        }

        public Builder addAllOptions(Iterable<? extends Option> iterable) {
            d();
            ((Api) this.f35783b).addAllOptions(iterable);
            return this;
        }

        public Builder addMethods(Method method) {
            d();
            ((Api) this.f35783b).addMethods(method);
            return this;
        }

        public Builder addMixins(Mixin mixin) {
            d();
            ((Api) this.f35783b).addMixins(mixin);
            return this;
        }

        public Builder addOptions(Option option) {
            d();
            ((Api) this.f35783b).addOptions(option);
            return this;
        }

        public Builder clearMethods() {
            d();
            ((Api) this.f35783b).clearMethods();
            return this;
        }

        public Builder clearMixins() {
            d();
            ((Api) this.f35783b).clearMixins();
            return this;
        }

        public Builder clearName() {
            d();
            ((Api) this.f35783b).clearName();
            return this;
        }

        public Builder clearOptions() {
            d();
            ((Api) this.f35783b).clearOptions();
            return this;
        }

        public Builder clearSourceContext() {
            d();
            ((Api) this.f35783b).clearSourceContext();
            return this;
        }

        public Builder clearSyntax() {
            d();
            ((Api) this.f35783b).clearSyntax();
            return this;
        }

        public Builder clearVersion() {
            d();
            ((Api) this.f35783b).clearVersion();
            return this;
        }

        public Method getMethods(int i11) {
            return ((Api) this.f35783b).getMethods(i11);
        }

        public int getMethodsCount() {
            return ((Api) this.f35783b).getMethodsCount();
        }

        public List<Method> getMethodsList() {
            return Collections.unmodifiableList(((Api) this.f35783b).getMethodsList());
        }

        public Mixin getMixins(int i11) {
            return ((Api) this.f35783b).getMixins(i11);
        }

        public int getMixinsCount() {
            return ((Api) this.f35783b).getMixinsCount();
        }

        public List<Mixin> getMixinsList() {
            return Collections.unmodifiableList(((Api) this.f35783b).getMixinsList());
        }

        public String getName() {
            return ((Api) this.f35783b).getName();
        }

        public ByteString getNameBytes() {
            return ((Api) this.f35783b).getNameBytes();
        }

        public Option getOptions(int i11) {
            return ((Api) this.f35783b).getOptions(i11);
        }

        public int getOptionsCount() {
            return ((Api) this.f35783b).getOptionsCount();
        }

        public List<Option> getOptionsList() {
            return Collections.unmodifiableList(((Api) this.f35783b).getOptionsList());
        }

        public SourceContext getSourceContext() {
            return ((Api) this.f35783b).getSourceContext();
        }

        public Syntax getSyntax() {
            return ((Api) this.f35783b).getSyntax();
        }

        public int getSyntaxValue() {
            return ((Api) this.f35783b).getSyntaxValue();
        }

        public String getVersion() {
            return ((Api) this.f35783b).getVersion();
        }

        public ByteString getVersionBytes() {
            return ((Api) this.f35783b).getVersionBytes();
        }

        public boolean hasSourceContext() {
            return ((Api) this.f35783b).hasSourceContext();
        }

        public Builder mergeSourceContext(SourceContext sourceContext) {
            d();
            ((Api) this.f35783b).mergeSourceContext(sourceContext);
            return this;
        }

        public Builder removeMethods(int i11) {
            d();
            ((Api) this.f35783b).removeMethods(i11);
            return this;
        }

        public Builder removeMixins(int i11) {
            d();
            ((Api) this.f35783b).removeMixins(i11);
            return this;
        }

        public Builder removeOptions(int i11) {
            d();
            ((Api) this.f35783b).removeOptions(i11);
            return this;
        }

        public Builder setMethods(int i11, Method method) {
            d();
            ((Api) this.f35783b).setMethods(i11, method);
            return this;
        }

        public Builder setMixins(int i11, Mixin mixin) {
            d();
            ((Api) this.f35783b).setMixins(i11, mixin);
            return this;
        }

        public Builder setName(String str) {
            d();
            ((Api) this.f35783b).setName(str);
            return this;
        }

        public Builder setNameBytes(ByteString byteString) {
            d();
            ((Api) this.f35783b).setNameBytes(byteString);
            return this;
        }

        public Builder setOptions(int i11, Option option) {
            d();
            ((Api) this.f35783b).setOptions(i11, option);
            return this;
        }

        public Builder setSourceContext(SourceContext sourceContext) {
            d();
            ((Api) this.f35783b).setSourceContext(sourceContext);
            return this;
        }

        public Builder setSyntax(Syntax syntax) {
            d();
            ((Api) this.f35783b).setSyntax(syntax);
            return this;
        }

        public Builder setSyntaxValue(int i11) {
            d();
            ((Api) this.f35783b).setSyntaxValue(i11);
            return this;
        }

        public Builder setVersion(String str) {
            d();
            ((Api) this.f35783b).setVersion(str);
            return this;
        }

        public Builder setVersionBytes(ByteString byteString) {
            d();
            ((Api) this.f35783b).setVersionBytes(byteString);
            return this;
        }

        private Builder() {
            super(Api.DEFAULT_INSTANCE);
        }

        public Builder addMethods(int i11, Method method) {
            d();
            ((Api) this.f35783b).addMethods(i11, method);
            return this;
        }

        public Builder addMixins(int i11, Mixin mixin) {
            d();
            ((Api) this.f35783b).addMixins(i11, mixin);
            return this;
        }

        public Builder addOptions(int i11, Option option) {
            d();
            ((Api) this.f35783b).addOptions(i11, option);
            return this;
        }

        public Builder setMethods(int i11, Method.Builder builder) {
            d();
            ((Api) this.f35783b).setMethods(i11, builder);
            return this;
        }

        public Builder setMixins(int i11, Mixin.Builder builder) {
            d();
            ((Api) this.f35783b).setMixins(i11, builder);
            return this;
        }

        public Builder setOptions(int i11, Option.Builder builder) {
            d();
            ((Api) this.f35783b).setOptions(i11, builder);
            return this;
        }

        public Builder setSourceContext(SourceContext.Builder builder) {
            d();
            ((Api) this.f35783b).setSourceContext(builder);
            return this;
        }

        public Builder addMethods(Method.Builder builder) {
            d();
            ((Api) this.f35783b).addMethods(builder);
            return this;
        }

        public Builder addMixins(Mixin.Builder builder) {
            d();
            ((Api) this.f35783b).addMixins(builder);
            return this;
        }

        public Builder addOptions(Option.Builder builder) {
            d();
            ((Api) this.f35783b).addOptions(builder);
            return this;
        }

        public Builder addMethods(int i11, Method.Builder builder) {
            d();
            ((Api) this.f35783b).addMethods(i11, builder);
            return this;
        }

        public Builder addMixins(int i11, Mixin.Builder builder) {
            d();
            ((Api) this.f35783b).addMixins(i11, builder);
            return this;
        }

        public Builder addOptions(int i11, Option.Builder builder) {
            d();
            ((Api) this.f35783b).addOptions(i11, builder);
            return this;
        }
    }

    static {
        Api api = new Api();
        DEFAULT_INSTANCE = api;
        GeneratedMessageLite.L(Api.class, api);
    }

    private Api() {
    }

    /* access modifiers changed from: private */
    public void addAllMethods(Iterable<? extends Method> iterable) {
        ensureMethodsIsMutable();
        AbstractMessageLite.a(iterable, this.methods_);
    }

    /* access modifiers changed from: private */
    public void addAllMixins(Iterable<? extends Mixin> iterable) {
        ensureMixinsIsMutable();
        AbstractMessageLite.a(iterable, this.mixins_);
    }

    /* access modifiers changed from: private */
    public void addAllOptions(Iterable<? extends Option> iterable) {
        ensureOptionsIsMutable();
        AbstractMessageLite.a(iterable, this.options_);
    }

    /* access modifiers changed from: private */
    public void addMethods(Method method) {
        method.getClass();
        ensureMethodsIsMutable();
        this.methods_.add(method);
    }

    /* access modifiers changed from: private */
    public void addMixins(Mixin mixin) {
        mixin.getClass();
        ensureMixinsIsMutable();
        this.mixins_.add(mixin);
    }

    /* access modifiers changed from: private */
    public void addOptions(Option option) {
        option.getClass();
        ensureOptionsIsMutable();
        this.options_.add(option);
    }

    /* access modifiers changed from: private */
    public void clearMethods() {
        this.methods_ = GeneratedMessageLite.n();
    }

    /* access modifiers changed from: private */
    public void clearMixins() {
        this.mixins_ = GeneratedMessageLite.n();
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
    public void clearSourceContext() {
        this.sourceContext_ = null;
    }

    /* access modifiers changed from: private */
    public void clearSyntax() {
        this.syntax_ = 0;
    }

    /* access modifiers changed from: private */
    public void clearVersion() {
        this.version_ = getDefaultInstance().getVersion();
    }

    private void ensureMethodsIsMutable() {
        if (!this.methods_.isModifiable()) {
            this.methods_ = GeneratedMessageLite.u(this.methods_);
        }
    }

    private void ensureMixinsIsMutable() {
        if (!this.mixins_.isModifiable()) {
            this.mixins_ = GeneratedMessageLite.u(this.mixins_);
        }
    }

    private void ensureOptionsIsMutable() {
        if (!this.options_.isModifiable()) {
            this.options_ = GeneratedMessageLite.u(this.options_);
        }
    }

    public static Api getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* access modifiers changed from: private */
    public void mergeSourceContext(SourceContext sourceContext) {
        sourceContext.getClass();
        SourceContext sourceContext2 = this.sourceContext_;
        if (sourceContext2 == null || sourceContext2 == SourceContext.getDefaultInstance()) {
            this.sourceContext_ = sourceContext;
        } else {
            this.sourceContext_ = (SourceContext) ((SourceContext.Builder) SourceContext.newBuilder(this.sourceContext_).mergeFrom(sourceContext)).buildPartial();
        }
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.i();
    }

    public static Api parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Api) GeneratedMessageLite.w(DEFAULT_INSTANCE, inputStream);
    }

    public static Api parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (Api) GeneratedMessageLite.E(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<Api> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* access modifiers changed from: private */
    public void removeMethods(int i11) {
        ensureMethodsIsMutable();
        this.methods_.remove(i11);
    }

    /* access modifiers changed from: private */
    public void removeMixins(int i11) {
        ensureMixinsIsMutable();
        this.mixins_.remove(i11);
    }

    /* access modifiers changed from: private */
    public void removeOptions(int i11) {
        ensureOptionsIsMutable();
        this.options_.remove(i11);
    }

    /* access modifiers changed from: private */
    public void setMethods(int i11, Method method) {
        method.getClass();
        ensureMethodsIsMutable();
        this.methods_.set(i11, method);
    }

    /* access modifiers changed from: private */
    public void setMixins(int i11, Mixin mixin) {
        mixin.getClass();
        ensureMixinsIsMutable();
        this.mixins_.set(i11, mixin);
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
    public void setSourceContext(SourceContext sourceContext) {
        sourceContext.getClass();
        this.sourceContext_ = sourceContext;
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

    /* access modifiers changed from: private */
    public void setVersion(String str) {
        str.getClass();
        this.version_ = str;
    }

    /* access modifiers changed from: private */
    public void setVersionBytes(ByteString byteString) {
        byteString.getClass();
        AbstractMessageLite.b(byteString);
        this.version_ = byteString.toStringUtf8();
    }

    public Method getMethods(int i11) {
        return this.methods_.get(i11);
    }

    public int getMethodsCount() {
        return this.methods_.size();
    }

    public List<Method> getMethodsList() {
        return this.methods_;
    }

    public MethodOrBuilder getMethodsOrBuilder(int i11) {
        return this.methods_.get(i11);
    }

    public List<? extends MethodOrBuilder> getMethodsOrBuilderList() {
        return this.methods_;
    }

    public Mixin getMixins(int i11) {
        return this.mixins_.get(i11);
    }

    public int getMixinsCount() {
        return this.mixins_.size();
    }

    public List<Mixin> getMixinsList() {
        return this.mixins_;
    }

    public MixinOrBuilder getMixinsOrBuilder(int i11) {
        return this.mixins_.get(i11);
    }

    public List<? extends MixinOrBuilder> getMixinsOrBuilderList() {
        return this.mixins_;
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

    public SourceContext getSourceContext() {
        SourceContext sourceContext = this.sourceContext_;
        return sourceContext == null ? SourceContext.getDefaultInstance() : sourceContext;
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

    public String getVersion() {
        return this.version_;
    }

    public ByteString getVersionBytes() {
        return ByteString.copyFromUtf8(this.version_);
    }

    public boolean hasSourceContext() {
        return this.sourceContext_ != null;
    }

    public final Object m(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.f35741a[methodToInvoke.ordinal()]) {
            case 1:
                return new Api();
            case 2:
                return new Builder((AnonymousClass1) null);
            case 3:
                return GeneratedMessageLite.v(DEFAULT_INSTANCE, "\u0000\u0007\u0000\u0000\u0001\u0007\u0007\u0000\u0003\u0000\u0001Ȉ\u0002\u001b\u0003\u001b\u0004Ȉ\u0005\t\u0006\u001b\u0007\f", new Object[]{"name_", "methods_", Method.class, "options_", Option.class, "version_", "sourceContext_", "mixins_", Mixin.class, "syntax_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Api> parser = PARSER;
                if (parser == null) {
                    synchronized (Api.class) {
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

    public static Builder newBuilder(Api api) {
        return (Builder) DEFAULT_INSTANCE.j(api);
    }

    public static Api parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Api) GeneratedMessageLite.x(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Api parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Api) GeneratedMessageLite.F(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Api parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (Api) GeneratedMessageLite.y(DEFAULT_INSTANCE, byteString);
    }

    /* access modifiers changed from: private */
    public void setSourceContext(SourceContext.Builder builder) {
        this.sourceContext_ = (SourceContext) builder.build();
    }

    /* access modifiers changed from: private */
    public void addMethods(int i11, Method method) {
        method.getClass();
        ensureMethodsIsMutable();
        this.methods_.add(i11, method);
    }

    /* access modifiers changed from: private */
    public void addMixins(int i11, Mixin mixin) {
        mixin.getClass();
        ensureMixinsIsMutable();
        this.mixins_.add(i11, mixin);
    }

    /* access modifiers changed from: private */
    public void addOptions(int i11, Option option) {
        option.getClass();
        ensureOptionsIsMutable();
        this.options_.add(i11, option);
    }

    public static Api parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Api) GeneratedMessageLite.z(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    /* access modifiers changed from: private */
    public void setMethods(int i11, Method.Builder builder) {
        ensureMethodsIsMutable();
        this.methods_.set(i11, builder.build());
    }

    /* access modifiers changed from: private */
    public void setMixins(int i11, Mixin.Builder builder) {
        ensureMixinsIsMutable();
        this.mixins_.set(i11, builder.build());
    }

    /* access modifiers changed from: private */
    public void setOptions(int i11, Option.Builder builder) {
        ensureOptionsIsMutable();
        this.options_.set(i11, builder.build());
    }

    public static Api parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (Api) GeneratedMessageLite.G(DEFAULT_INSTANCE, bArr);
    }

    public static Api parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Api) GeneratedMessageLite.H(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    /* access modifiers changed from: private */
    public void addMethods(Method.Builder builder) {
        ensureMethodsIsMutable();
        this.methods_.add(builder.build());
    }

    /* access modifiers changed from: private */
    public void addMixins(Mixin.Builder builder) {
        ensureMixinsIsMutable();
        this.mixins_.add(builder.build());
    }

    /* access modifiers changed from: private */
    public void addOptions(Option.Builder builder) {
        ensureOptionsIsMutable();
        this.options_.add(builder.build());
    }

    public static Api parseFrom(InputStream inputStream) throws IOException {
        return (Api) GeneratedMessageLite.C(DEFAULT_INSTANCE, inputStream);
    }

    public static Api parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Api) GeneratedMessageLite.D(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    /* access modifiers changed from: private */
    public void addMethods(int i11, Method.Builder builder) {
        ensureMethodsIsMutable();
        this.methods_.add(i11, builder.build());
    }

    /* access modifiers changed from: private */
    public void addMixins(int i11, Mixin.Builder builder) {
        ensureMixinsIsMutable();
        this.mixins_.add(i11, builder.build());
    }

    /* access modifiers changed from: private */
    public void addOptions(int i11, Option.Builder builder) {
        ensureOptionsIsMutable();
        this.options_.add(i11, builder.build());
    }

    public static Api parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Api) GeneratedMessageLite.A(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Api parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Api) GeneratedMessageLite.B(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
