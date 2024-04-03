package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.Field;
import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import androidx.datastore.preferences.protobuf.Internal;
import androidx.datastore.preferences.protobuf.Option;
import androidx.datastore.preferences.protobuf.SourceContext;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

public final class Type extends GeneratedMessageLite<Type, Builder> implements TypeOrBuilder {
    /* access modifiers changed from: private */
    public static final Type DEFAULT_INSTANCE;
    public static final int FIELDS_FIELD_NUMBER = 2;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int ONEOFS_FIELD_NUMBER = 3;
    public static final int OPTIONS_FIELD_NUMBER = 4;
    private static volatile Parser<Type> PARSER = null;
    public static final int SOURCE_CONTEXT_FIELD_NUMBER = 5;
    public static final int SYNTAX_FIELD_NUMBER = 6;
    private Internal.ProtobufList<Field> fields_ = GeneratedMessageLite.n();
    private String name_ = "";
    private Internal.ProtobufList<String> oneofs_ = GeneratedMessageLite.n();
    private Internal.ProtobufList<Option> options_ = GeneratedMessageLite.n();
    private SourceContext sourceContext_;
    private int syntax_;

    /* renamed from: androidx.datastore.preferences.protobuf.Type$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f35832a;

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
                f35832a = r0
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f35832a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_BUILDER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f35832a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f35832a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f35832a     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.GET_PARSER     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f35832a     // Catch:{ NoSuchFieldError -> 0x0049 }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f35832a     // Catch:{ NoSuchFieldError -> 0x0054 }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.Type.AnonymousClass1.<clinit>():void");
        }
    }

    public static final class Builder extends GeneratedMessageLite.Builder<Type, Builder> implements TypeOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 r12) {
            this();
        }

        public Builder addAllFields(Iterable<? extends Field> iterable) {
            d();
            ((Type) this.f35783b).addAllFields(iterable);
            return this;
        }

        public Builder addAllOneofs(Iterable<String> iterable) {
            d();
            ((Type) this.f35783b).addAllOneofs(iterable);
            return this;
        }

        public Builder addAllOptions(Iterable<? extends Option> iterable) {
            d();
            ((Type) this.f35783b).addAllOptions(iterable);
            return this;
        }

        public Builder addFields(Field field) {
            d();
            ((Type) this.f35783b).addFields(field);
            return this;
        }

        public Builder addOneofs(String str) {
            d();
            ((Type) this.f35783b).addOneofs(str);
            return this;
        }

        public Builder addOneofsBytes(ByteString byteString) {
            d();
            ((Type) this.f35783b).addOneofsBytes(byteString);
            return this;
        }

        public Builder addOptions(Option option) {
            d();
            ((Type) this.f35783b).addOptions(option);
            return this;
        }

        public Builder clearFields() {
            d();
            ((Type) this.f35783b).clearFields();
            return this;
        }

        public Builder clearName() {
            d();
            ((Type) this.f35783b).clearName();
            return this;
        }

        public Builder clearOneofs() {
            d();
            ((Type) this.f35783b).clearOneofs();
            return this;
        }

        public Builder clearOptions() {
            d();
            ((Type) this.f35783b).clearOptions();
            return this;
        }

        public Builder clearSourceContext() {
            d();
            ((Type) this.f35783b).clearSourceContext();
            return this;
        }

        public Builder clearSyntax() {
            d();
            ((Type) this.f35783b).clearSyntax();
            return this;
        }

        public Field getFields(int i11) {
            return ((Type) this.f35783b).getFields(i11);
        }

        public int getFieldsCount() {
            return ((Type) this.f35783b).getFieldsCount();
        }

        public List<Field> getFieldsList() {
            return Collections.unmodifiableList(((Type) this.f35783b).getFieldsList());
        }

        public String getName() {
            return ((Type) this.f35783b).getName();
        }

        public ByteString getNameBytes() {
            return ((Type) this.f35783b).getNameBytes();
        }

        public String getOneofs(int i11) {
            return ((Type) this.f35783b).getOneofs(i11);
        }

        public ByteString getOneofsBytes(int i11) {
            return ((Type) this.f35783b).getOneofsBytes(i11);
        }

        public int getOneofsCount() {
            return ((Type) this.f35783b).getOneofsCount();
        }

        public List<String> getOneofsList() {
            return Collections.unmodifiableList(((Type) this.f35783b).getOneofsList());
        }

        public Option getOptions(int i11) {
            return ((Type) this.f35783b).getOptions(i11);
        }

        public int getOptionsCount() {
            return ((Type) this.f35783b).getOptionsCount();
        }

        public List<Option> getOptionsList() {
            return Collections.unmodifiableList(((Type) this.f35783b).getOptionsList());
        }

        public SourceContext getSourceContext() {
            return ((Type) this.f35783b).getSourceContext();
        }

        public Syntax getSyntax() {
            return ((Type) this.f35783b).getSyntax();
        }

        public int getSyntaxValue() {
            return ((Type) this.f35783b).getSyntaxValue();
        }

        public boolean hasSourceContext() {
            return ((Type) this.f35783b).hasSourceContext();
        }

        public Builder mergeSourceContext(SourceContext sourceContext) {
            d();
            ((Type) this.f35783b).mergeSourceContext(sourceContext);
            return this;
        }

        public Builder removeFields(int i11) {
            d();
            ((Type) this.f35783b).removeFields(i11);
            return this;
        }

        public Builder removeOptions(int i11) {
            d();
            ((Type) this.f35783b).removeOptions(i11);
            return this;
        }

        public Builder setFields(int i11, Field field) {
            d();
            ((Type) this.f35783b).setFields(i11, field);
            return this;
        }

        public Builder setName(String str) {
            d();
            ((Type) this.f35783b).setName(str);
            return this;
        }

        public Builder setNameBytes(ByteString byteString) {
            d();
            ((Type) this.f35783b).setNameBytes(byteString);
            return this;
        }

        public Builder setOneofs(int i11, String str) {
            d();
            ((Type) this.f35783b).setOneofs(i11, str);
            return this;
        }

        public Builder setOptions(int i11, Option option) {
            d();
            ((Type) this.f35783b).setOptions(i11, option);
            return this;
        }

        public Builder setSourceContext(SourceContext sourceContext) {
            d();
            ((Type) this.f35783b).setSourceContext(sourceContext);
            return this;
        }

        public Builder setSyntax(Syntax syntax) {
            d();
            ((Type) this.f35783b).setSyntax(syntax);
            return this;
        }

        public Builder setSyntaxValue(int i11) {
            d();
            ((Type) this.f35783b).setSyntaxValue(i11);
            return this;
        }

        private Builder() {
            super(Type.DEFAULT_INSTANCE);
        }

        public Builder addFields(int i11, Field field) {
            d();
            ((Type) this.f35783b).addFields(i11, field);
            return this;
        }

        public Builder addOptions(int i11, Option option) {
            d();
            ((Type) this.f35783b).addOptions(i11, option);
            return this;
        }

        public Builder setFields(int i11, Field.Builder builder) {
            d();
            ((Type) this.f35783b).setFields(i11, builder);
            return this;
        }

        public Builder setOptions(int i11, Option.Builder builder) {
            d();
            ((Type) this.f35783b).setOptions(i11, builder);
            return this;
        }

        public Builder setSourceContext(SourceContext.Builder builder) {
            d();
            ((Type) this.f35783b).setSourceContext(builder);
            return this;
        }

        public Builder addFields(Field.Builder builder) {
            d();
            ((Type) this.f35783b).addFields(builder);
            return this;
        }

        public Builder addOptions(Option.Builder builder) {
            d();
            ((Type) this.f35783b).addOptions(builder);
            return this;
        }

        public Builder addFields(int i11, Field.Builder builder) {
            d();
            ((Type) this.f35783b).addFields(i11, builder);
            return this;
        }

        public Builder addOptions(int i11, Option.Builder builder) {
            d();
            ((Type) this.f35783b).addOptions(i11, builder);
            return this;
        }
    }

    static {
        Type type = new Type();
        DEFAULT_INSTANCE = type;
        GeneratedMessageLite.L(Type.class, type);
    }

    private Type() {
    }

    /* access modifiers changed from: private */
    public void addAllFields(Iterable<? extends Field> iterable) {
        ensureFieldsIsMutable();
        AbstractMessageLite.a(iterable, this.fields_);
    }

    /* access modifiers changed from: private */
    public void addAllOneofs(Iterable<String> iterable) {
        ensureOneofsIsMutable();
        AbstractMessageLite.a(iterable, this.oneofs_);
    }

    /* access modifiers changed from: private */
    public void addAllOptions(Iterable<? extends Option> iterable) {
        ensureOptionsIsMutable();
        AbstractMessageLite.a(iterable, this.options_);
    }

    /* access modifiers changed from: private */
    public void addFields(Field field) {
        field.getClass();
        ensureFieldsIsMutable();
        this.fields_.add(field);
    }

    /* access modifiers changed from: private */
    public void addOneofs(String str) {
        str.getClass();
        ensureOneofsIsMutable();
        this.oneofs_.add(str);
    }

    /* access modifiers changed from: private */
    public void addOneofsBytes(ByteString byteString) {
        byteString.getClass();
        AbstractMessageLite.b(byteString);
        ensureOneofsIsMutable();
        this.oneofs_.add(byteString.toStringUtf8());
    }

    /* access modifiers changed from: private */
    public void addOptions(Option option) {
        option.getClass();
        ensureOptionsIsMutable();
        this.options_.add(option);
    }

    /* access modifiers changed from: private */
    public void clearFields() {
        this.fields_ = GeneratedMessageLite.n();
    }

    /* access modifiers changed from: private */
    public void clearName() {
        this.name_ = getDefaultInstance().getName();
    }

    /* access modifiers changed from: private */
    public void clearOneofs() {
        this.oneofs_ = GeneratedMessageLite.n();
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

    private void ensureFieldsIsMutable() {
        if (!this.fields_.isModifiable()) {
            this.fields_ = GeneratedMessageLite.u(this.fields_);
        }
    }

    private void ensureOneofsIsMutable() {
        if (!this.oneofs_.isModifiable()) {
            this.oneofs_ = GeneratedMessageLite.u(this.oneofs_);
        }
    }

    private void ensureOptionsIsMutable() {
        if (!this.options_.isModifiable()) {
            this.options_ = GeneratedMessageLite.u(this.options_);
        }
    }

    public static Type getDefaultInstance() {
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

    public static Type parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Type) GeneratedMessageLite.w(DEFAULT_INSTANCE, inputStream);
    }

    public static Type parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (Type) GeneratedMessageLite.E(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<Type> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* access modifiers changed from: private */
    public void removeFields(int i11) {
        ensureFieldsIsMutable();
        this.fields_.remove(i11);
    }

    /* access modifiers changed from: private */
    public void removeOptions(int i11) {
        ensureOptionsIsMutable();
        this.options_.remove(i11);
    }

    /* access modifiers changed from: private */
    public void setFields(int i11, Field field) {
        field.getClass();
        ensureFieldsIsMutable();
        this.fields_.set(i11, field);
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
    public void setOneofs(int i11, String str) {
        str.getClass();
        ensureOneofsIsMutable();
        this.oneofs_.set(i11, str);
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

    public Field getFields(int i11) {
        return this.fields_.get(i11);
    }

    public int getFieldsCount() {
        return this.fields_.size();
    }

    public List<Field> getFieldsList() {
        return this.fields_;
    }

    public FieldOrBuilder getFieldsOrBuilder(int i11) {
        return this.fields_.get(i11);
    }

    public List<? extends FieldOrBuilder> getFieldsOrBuilderList() {
        return this.fields_;
    }

    public String getName() {
        return this.name_;
    }

    public ByteString getNameBytes() {
        return ByteString.copyFromUtf8(this.name_);
    }

    public String getOneofs(int i11) {
        return this.oneofs_.get(i11);
    }

    public ByteString getOneofsBytes(int i11) {
        return ByteString.copyFromUtf8(this.oneofs_.get(i11));
    }

    public int getOneofsCount() {
        return this.oneofs_.size();
    }

    public List<String> getOneofsList() {
        return this.oneofs_;
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

    public boolean hasSourceContext() {
        return this.sourceContext_ != null;
    }

    public final Object m(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.f35832a[methodToInvoke.ordinal()]) {
            case 1:
                return new Type();
            case 2:
                return new Builder((AnonymousClass1) null);
            case 3:
                return GeneratedMessageLite.v(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0000\u0001\u0006\u0006\u0000\u0003\u0000\u0001Ȉ\u0002\u001b\u0003Ț\u0004\u001b\u0005\t\u0006\f", new Object[]{"name_", "fields_", Field.class, "oneofs_", "options_", Option.class, "sourceContext_", "syntax_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Type> parser = PARSER;
                if (parser == null) {
                    synchronized (Type.class) {
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

    public static Builder newBuilder(Type type) {
        return (Builder) DEFAULT_INSTANCE.j(type);
    }

    public static Type parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Type) GeneratedMessageLite.x(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Type parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Type) GeneratedMessageLite.F(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Type parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (Type) GeneratedMessageLite.y(DEFAULT_INSTANCE, byteString);
    }

    /* access modifiers changed from: private */
    public void setSourceContext(SourceContext.Builder builder) {
        this.sourceContext_ = (SourceContext) builder.build();
    }

    /* access modifiers changed from: private */
    public void addFields(int i11, Field field) {
        field.getClass();
        ensureFieldsIsMutable();
        this.fields_.add(i11, field);
    }

    /* access modifiers changed from: private */
    public void addOptions(int i11, Option option) {
        option.getClass();
        ensureOptionsIsMutable();
        this.options_.add(i11, option);
    }

    public static Type parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Type) GeneratedMessageLite.z(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    /* access modifiers changed from: private */
    public void setFields(int i11, Field.Builder builder) {
        ensureFieldsIsMutable();
        this.fields_.set(i11, builder.build());
    }

    /* access modifiers changed from: private */
    public void setOptions(int i11, Option.Builder builder) {
        ensureOptionsIsMutable();
        this.options_.set(i11, builder.build());
    }

    public static Type parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (Type) GeneratedMessageLite.G(DEFAULT_INSTANCE, bArr);
    }

    public static Type parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Type) GeneratedMessageLite.H(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    /* access modifiers changed from: private */
    public void addFields(Field.Builder builder) {
        ensureFieldsIsMutable();
        this.fields_.add(builder.build());
    }

    /* access modifiers changed from: private */
    public void addOptions(Option.Builder builder) {
        ensureOptionsIsMutable();
        this.options_.add(builder.build());
    }

    public static Type parseFrom(InputStream inputStream) throws IOException {
        return (Type) GeneratedMessageLite.C(DEFAULT_INSTANCE, inputStream);
    }

    public static Type parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Type) GeneratedMessageLite.D(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    /* access modifiers changed from: private */
    public void addFields(int i11, Field.Builder builder) {
        ensureFieldsIsMutable();
        this.fields_.add(i11, builder.build());
    }

    /* access modifiers changed from: private */
    public void addOptions(int i11, Option.Builder builder) {
        ensureOptionsIsMutable();
        this.options_.add(i11, builder.build());
    }

    public static Type parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Type) GeneratedMessageLite.A(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Type parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Type) GeneratedMessageLite.B(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
