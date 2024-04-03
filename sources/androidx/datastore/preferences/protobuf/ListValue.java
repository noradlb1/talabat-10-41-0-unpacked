package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import androidx.datastore.preferences.protobuf.Internal;
import androidx.datastore.preferences.protobuf.Value;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

public final class ListValue extends GeneratedMessageLite<ListValue, Builder> implements ListValueOrBuilder {
    /* access modifiers changed from: private */
    public static final ListValue DEFAULT_INSTANCE;
    private static volatile Parser<ListValue> PARSER = null;
    public static final int VALUES_FIELD_NUMBER = 1;
    private Internal.ProtobufList<Value> values_ = GeneratedMessageLite.n();

    /* renamed from: androidx.datastore.preferences.protobuf.ListValue$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f35805a;

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
                f35805a = r0
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f35805a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_BUILDER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f35805a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f35805a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f35805a     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.GET_PARSER     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f35805a     // Catch:{ NoSuchFieldError -> 0x0049 }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f35805a     // Catch:{ NoSuchFieldError -> 0x0054 }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.ListValue.AnonymousClass1.<clinit>():void");
        }
    }

    public static final class Builder extends GeneratedMessageLite.Builder<ListValue, Builder> implements ListValueOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 r12) {
            this();
        }

        public Builder addAllValues(Iterable<? extends Value> iterable) {
            d();
            ((ListValue) this.f35783b).addAllValues(iterable);
            return this;
        }

        public Builder addValues(Value value) {
            d();
            ((ListValue) this.f35783b).addValues(value);
            return this;
        }

        public Builder clearValues() {
            d();
            ((ListValue) this.f35783b).clearValues();
            return this;
        }

        public Value getValues(int i11) {
            return ((ListValue) this.f35783b).getValues(i11);
        }

        public int getValuesCount() {
            return ((ListValue) this.f35783b).getValuesCount();
        }

        public List<Value> getValuesList() {
            return Collections.unmodifiableList(((ListValue) this.f35783b).getValuesList());
        }

        public Builder removeValues(int i11) {
            d();
            ((ListValue) this.f35783b).removeValues(i11);
            return this;
        }

        public Builder setValues(int i11, Value value) {
            d();
            ((ListValue) this.f35783b).setValues(i11, value);
            return this;
        }

        private Builder() {
            super(ListValue.DEFAULT_INSTANCE);
        }

        public Builder addValues(int i11, Value value) {
            d();
            ((ListValue) this.f35783b).addValues(i11, value);
            return this;
        }

        public Builder setValues(int i11, Value.Builder builder) {
            d();
            ((ListValue) this.f35783b).setValues(i11, builder);
            return this;
        }

        public Builder addValues(Value.Builder builder) {
            d();
            ((ListValue) this.f35783b).addValues(builder);
            return this;
        }

        public Builder addValues(int i11, Value.Builder builder) {
            d();
            ((ListValue) this.f35783b).addValues(i11, builder);
            return this;
        }
    }

    static {
        ListValue listValue = new ListValue();
        DEFAULT_INSTANCE = listValue;
        GeneratedMessageLite.L(ListValue.class, listValue);
    }

    private ListValue() {
    }

    /* access modifiers changed from: private */
    public void addAllValues(Iterable<? extends Value> iterable) {
        ensureValuesIsMutable();
        AbstractMessageLite.a(iterable, this.values_);
    }

    /* access modifiers changed from: private */
    public void addValues(Value value) {
        value.getClass();
        ensureValuesIsMutable();
        this.values_.add(value);
    }

    /* access modifiers changed from: private */
    public void clearValues() {
        this.values_ = GeneratedMessageLite.n();
    }

    private void ensureValuesIsMutable() {
        if (!this.values_.isModifiable()) {
            this.values_ = GeneratedMessageLite.u(this.values_);
        }
    }

    public static ListValue getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.i();
    }

    public static ListValue parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (ListValue) GeneratedMessageLite.w(DEFAULT_INSTANCE, inputStream);
    }

    public static ListValue parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (ListValue) GeneratedMessageLite.E(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<ListValue> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* access modifiers changed from: private */
    public void removeValues(int i11) {
        ensureValuesIsMutable();
        this.values_.remove(i11);
    }

    /* access modifiers changed from: private */
    public void setValues(int i11, Value value) {
        value.getClass();
        ensureValuesIsMutable();
        this.values_.set(i11, value);
    }

    public Value getValues(int i11) {
        return this.values_.get(i11);
    }

    public int getValuesCount() {
        return this.values_.size();
    }

    public List<Value> getValuesList() {
        return this.values_;
    }

    public ValueOrBuilder getValuesOrBuilder(int i11) {
        return this.values_.get(i11);
    }

    public List<? extends ValueOrBuilder> getValuesOrBuilderList() {
        return this.values_;
    }

    public final Object m(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.f35805a[methodToInvoke.ordinal()]) {
            case 1:
                return new ListValue();
            case 2:
                return new Builder((AnonymousClass1) null);
            case 3:
                return GeneratedMessageLite.v(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"values_", Value.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<ListValue> parser = PARSER;
                if (parser == null) {
                    synchronized (ListValue.class) {
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

    public static Builder newBuilder(ListValue listValue) {
        return (Builder) DEFAULT_INSTANCE.j(listValue);
    }

    public static ListValue parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ListValue) GeneratedMessageLite.x(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ListValue parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ListValue) GeneratedMessageLite.F(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static ListValue parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (ListValue) GeneratedMessageLite.y(DEFAULT_INSTANCE, byteString);
    }

    /* access modifiers changed from: private */
    public void addValues(int i11, Value value) {
        value.getClass();
        ensureValuesIsMutable();
        this.values_.add(i11, value);
    }

    public static ListValue parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ListValue) GeneratedMessageLite.z(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    /* access modifiers changed from: private */
    public void setValues(int i11, Value.Builder builder) {
        ensureValuesIsMutable();
        this.values_.set(i11, builder.build());
    }

    public static ListValue parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (ListValue) GeneratedMessageLite.G(DEFAULT_INSTANCE, bArr);
    }

    public static ListValue parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ListValue) GeneratedMessageLite.H(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    /* access modifiers changed from: private */
    public void addValues(Value.Builder builder) {
        ensureValuesIsMutable();
        this.values_.add(builder.build());
    }

    public static ListValue parseFrom(InputStream inputStream) throws IOException {
        return (ListValue) GeneratedMessageLite.C(DEFAULT_INSTANCE, inputStream);
    }

    public static ListValue parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ListValue) GeneratedMessageLite.D(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    /* access modifiers changed from: private */
    public void addValues(int i11, Value.Builder builder) {
        ensureValuesIsMutable();
        this.values_.add(i11, builder.build());
    }

    public static ListValue parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (ListValue) GeneratedMessageLite.A(DEFAULT_INSTANCE, codedInputStream);
    }

    public static ListValue parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ListValue) GeneratedMessageLite.B(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
