package androidx.datastore.preferences;

import androidx.datastore.preferences.protobuf.AbstractMessageLite;
import androidx.datastore.preferences.protobuf.ByteString;
import androidx.datastore.preferences.protobuf.CodedInputStream;
import androidx.datastore.preferences.protobuf.ExtensionRegistryLite;
import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import androidx.datastore.preferences.protobuf.Internal;
import androidx.datastore.preferences.protobuf.InvalidProtocolBufferException;
import androidx.datastore.preferences.protobuf.MapEntryLite;
import androidx.datastore.preferences.protobuf.MapFieldLite;
import androidx.datastore.preferences.protobuf.MessageLiteOrBuilder;
import androidx.datastore.preferences.protobuf.Parser;
import androidx.datastore.preferences.protobuf.WireFormat;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class PreferencesProto {

    /* renamed from: androidx.datastore.preferences.PreferencesProto$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f35720a;

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
                f35720a = r0
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f35720a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_BUILDER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f35720a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f35720a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f35720a     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.GET_PARSER     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f35720a     // Catch:{ NoSuchFieldError -> 0x0049 }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f35720a     // Catch:{ NoSuchFieldError -> 0x0054 }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.PreferencesProto.AnonymousClass1.<clinit>():void");
        }
    }

    public static final class PreferenceMap extends GeneratedMessageLite<PreferenceMap, Builder> implements PreferenceMapOrBuilder {
        /* access modifiers changed from: private */
        public static final PreferenceMap DEFAULT_INSTANCE;
        private static volatile Parser<PreferenceMap> PARSER = null;
        public static final int PREFERENCES_FIELD_NUMBER = 1;
        private MapFieldLite<String, Value> preferences_ = MapFieldLite.emptyMapField();

        public static final class Builder extends GeneratedMessageLite.Builder<PreferenceMap, Builder> implements PreferenceMapOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 r12) {
                this();
            }

            public Builder clearPreferences() {
                d();
                ((PreferenceMap) this.f35783b).getMutablePreferencesMap().clear();
                return this;
            }

            public boolean containsPreferences(String str) {
                str.getClass();
                return ((PreferenceMap) this.f35783b).getPreferencesMap().containsKey(str);
            }

            @Deprecated
            public Map<String, Value> getPreferences() {
                return getPreferencesMap();
            }

            public int getPreferencesCount() {
                return ((PreferenceMap) this.f35783b).getPreferencesMap().size();
            }

            public Map<String, Value> getPreferencesMap() {
                return Collections.unmodifiableMap(((PreferenceMap) this.f35783b).getPreferencesMap());
            }

            public Value getPreferencesOrDefault(String str, Value value) {
                str.getClass();
                Map<String, Value> preferencesMap = ((PreferenceMap) this.f35783b).getPreferencesMap();
                if (preferencesMap.containsKey(str)) {
                    return preferencesMap.get(str);
                }
                return value;
            }

            public Value getPreferencesOrThrow(String str) {
                str.getClass();
                Map<String, Value> preferencesMap = ((PreferenceMap) this.f35783b).getPreferencesMap();
                if (preferencesMap.containsKey(str)) {
                    return preferencesMap.get(str);
                }
                throw new IllegalArgumentException();
            }

            public Builder putAllPreferences(Map<String, Value> map) {
                d();
                ((PreferenceMap) this.f35783b).getMutablePreferencesMap().putAll(map);
                return this;
            }

            public Builder putPreferences(String str, Value value) {
                str.getClass();
                value.getClass();
                d();
                ((PreferenceMap) this.f35783b).getMutablePreferencesMap().put(str, value);
                return this;
            }

            public Builder removePreferences(String str) {
                str.getClass();
                d();
                ((PreferenceMap) this.f35783b).getMutablePreferencesMap().remove(str);
                return this;
            }

            private Builder() {
                super(PreferenceMap.DEFAULT_INSTANCE);
            }
        }

        public static final class PreferencesDefaultEntryHolder {

            /* renamed from: a  reason: collision with root package name */
            public static final MapEntryLite<String, Value> f35721a = MapEntryLite.newDefaultInstance(WireFormat.FieldType.STRING, "", WireFormat.FieldType.MESSAGE, Value.getDefaultInstance());

            private PreferencesDefaultEntryHolder() {
            }
        }

        static {
            PreferenceMap preferenceMap = new PreferenceMap();
            DEFAULT_INSTANCE = preferenceMap;
            GeneratedMessageLite.L(PreferenceMap.class, preferenceMap);
        }

        private PreferenceMap() {
        }

        public static PreferenceMap getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* access modifiers changed from: private */
        public Map<String, Value> getMutablePreferencesMap() {
            return internalGetMutablePreferences();
        }

        private MapFieldLite<String, Value> internalGetMutablePreferences() {
            if (!this.preferences_.isMutable()) {
                this.preferences_ = this.preferences_.mutableCopy();
            }
            return this.preferences_;
        }

        private MapFieldLite<String, Value> internalGetPreferences() {
            return this.preferences_;
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.i();
        }

        public static PreferenceMap parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (PreferenceMap) GeneratedMessageLite.w(DEFAULT_INSTANCE, inputStream);
        }

        public static PreferenceMap parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (PreferenceMap) GeneratedMessageLite.E(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<PreferenceMap> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        public boolean containsPreferences(String str) {
            str.getClass();
            return internalGetPreferences().containsKey(str);
        }

        @Deprecated
        public Map<String, Value> getPreferences() {
            return getPreferencesMap();
        }

        public int getPreferencesCount() {
            return internalGetPreferences().size();
        }

        public Map<String, Value> getPreferencesMap() {
            return Collections.unmodifiableMap(internalGetPreferences());
        }

        public Value getPreferencesOrDefault(String str, Value value) {
            str.getClass();
            MapFieldLite<String, Value> internalGetPreferences = internalGetPreferences();
            if (internalGetPreferences.containsKey(str)) {
                return internalGetPreferences.get(str);
            }
            return value;
        }

        public Value getPreferencesOrThrow(String str) {
            str.getClass();
            MapFieldLite<String, Value> internalGetPreferences = internalGetPreferences();
            if (internalGetPreferences.containsKey(str)) {
                return internalGetPreferences.get(str);
            }
            throw new IllegalArgumentException();
        }

        public final Object m(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (AnonymousClass1.f35720a[methodToInvoke.ordinal()]) {
                case 1:
                    return new PreferenceMap();
                case 2:
                    return new Builder((AnonymousClass1) null);
                case 3:
                    return GeneratedMessageLite.v(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u00012", new Object[]{"preferences_", PreferencesDefaultEntryHolder.f35721a});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<PreferenceMap> parser = PARSER;
                    if (parser == null) {
                        synchronized (PreferenceMap.class) {
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

        public static Builder newBuilder(PreferenceMap preferenceMap) {
            return (Builder) DEFAULT_INSTANCE.j(preferenceMap);
        }

        public static PreferenceMap parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (PreferenceMap) GeneratedMessageLite.x(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static PreferenceMap parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (PreferenceMap) GeneratedMessageLite.F(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static PreferenceMap parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (PreferenceMap) GeneratedMessageLite.y(DEFAULT_INSTANCE, byteString);
        }

        public static PreferenceMap parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (PreferenceMap) GeneratedMessageLite.z(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static PreferenceMap parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (PreferenceMap) GeneratedMessageLite.G(DEFAULT_INSTANCE, bArr);
        }

        public static PreferenceMap parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (PreferenceMap) GeneratedMessageLite.H(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static PreferenceMap parseFrom(InputStream inputStream) throws IOException {
            return (PreferenceMap) GeneratedMessageLite.C(DEFAULT_INSTANCE, inputStream);
        }

        public static PreferenceMap parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (PreferenceMap) GeneratedMessageLite.D(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static PreferenceMap parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (PreferenceMap) GeneratedMessageLite.A(DEFAULT_INSTANCE, codedInputStream);
        }

        public static PreferenceMap parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (PreferenceMap) GeneratedMessageLite.B(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    public interface PreferenceMapOrBuilder extends MessageLiteOrBuilder {
        boolean containsPreferences(String str);

        @Deprecated
        Map<String, Value> getPreferences();

        int getPreferencesCount();

        Map<String, Value> getPreferencesMap();

        Value getPreferencesOrDefault(String str, Value value);

        Value getPreferencesOrThrow(String str);
    }

    public static final class StringSet extends GeneratedMessageLite<StringSet, Builder> implements StringSetOrBuilder {
        /* access modifiers changed from: private */
        public static final StringSet DEFAULT_INSTANCE;
        private static volatile Parser<StringSet> PARSER = null;
        public static final int STRINGS_FIELD_NUMBER = 1;
        private Internal.ProtobufList<String> strings_ = GeneratedMessageLite.n();

        public static final class Builder extends GeneratedMessageLite.Builder<StringSet, Builder> implements StringSetOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 r12) {
                this();
            }

            public Builder addAllStrings(Iterable<String> iterable) {
                d();
                ((StringSet) this.f35783b).addAllStrings(iterable);
                return this;
            }

            public Builder addStrings(String str) {
                d();
                ((StringSet) this.f35783b).addStrings(str);
                return this;
            }

            public Builder addStringsBytes(ByteString byteString) {
                d();
                ((StringSet) this.f35783b).addStringsBytes(byteString);
                return this;
            }

            public Builder clearStrings() {
                d();
                ((StringSet) this.f35783b).clearStrings();
                return this;
            }

            public String getStrings(int i11) {
                return ((StringSet) this.f35783b).getStrings(i11);
            }

            public ByteString getStringsBytes(int i11) {
                return ((StringSet) this.f35783b).getStringsBytes(i11);
            }

            public int getStringsCount() {
                return ((StringSet) this.f35783b).getStringsCount();
            }

            public List<String> getStringsList() {
                return Collections.unmodifiableList(((StringSet) this.f35783b).getStringsList());
            }

            public Builder setStrings(int i11, String str) {
                d();
                ((StringSet) this.f35783b).setStrings(i11, str);
                return this;
            }

            private Builder() {
                super(StringSet.DEFAULT_INSTANCE);
            }
        }

        static {
            StringSet stringSet = new StringSet();
            DEFAULT_INSTANCE = stringSet;
            GeneratedMessageLite.L(StringSet.class, stringSet);
        }

        private StringSet() {
        }

        /* access modifiers changed from: private */
        public void addAllStrings(Iterable<String> iterable) {
            ensureStringsIsMutable();
            AbstractMessageLite.a(iterable, this.strings_);
        }

        /* access modifiers changed from: private */
        public void addStrings(String str) {
            str.getClass();
            ensureStringsIsMutable();
            this.strings_.add(str);
        }

        /* access modifiers changed from: private */
        public void addStringsBytes(ByteString byteString) {
            byteString.getClass();
            ensureStringsIsMutable();
            this.strings_.add(byteString.toStringUtf8());
        }

        /* access modifiers changed from: private */
        public void clearStrings() {
            this.strings_ = GeneratedMessageLite.n();
        }

        private void ensureStringsIsMutable() {
            if (!this.strings_.isModifiable()) {
                this.strings_ = GeneratedMessageLite.u(this.strings_);
            }
        }

        public static StringSet getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.i();
        }

        public static StringSet parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (StringSet) GeneratedMessageLite.w(DEFAULT_INSTANCE, inputStream);
        }

        public static StringSet parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (StringSet) GeneratedMessageLite.E(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<StringSet> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* access modifiers changed from: private */
        public void setStrings(int i11, String str) {
            str.getClass();
            ensureStringsIsMutable();
            this.strings_.set(i11, str);
        }

        public String getStrings(int i11) {
            return this.strings_.get(i11);
        }

        public ByteString getStringsBytes(int i11) {
            return ByteString.copyFromUtf8(this.strings_.get(i11));
        }

        public int getStringsCount() {
            return this.strings_.size();
        }

        public List<String> getStringsList() {
            return this.strings_;
        }

        public final Object m(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (AnonymousClass1.f35720a[methodToInvoke.ordinal()]) {
                case 1:
                    return new StringSet();
                case 2:
                    return new Builder((AnonymousClass1) null);
                case 3:
                    return GeneratedMessageLite.v(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001a", new Object[]{"strings_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<StringSet> parser = PARSER;
                    if (parser == null) {
                        synchronized (StringSet.class) {
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

        public static Builder newBuilder(StringSet stringSet) {
            return (Builder) DEFAULT_INSTANCE.j(stringSet);
        }

        public static StringSet parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (StringSet) GeneratedMessageLite.x(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static StringSet parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (StringSet) GeneratedMessageLite.F(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static StringSet parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (StringSet) GeneratedMessageLite.y(DEFAULT_INSTANCE, byteString);
        }

        public static StringSet parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (StringSet) GeneratedMessageLite.z(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static StringSet parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (StringSet) GeneratedMessageLite.G(DEFAULT_INSTANCE, bArr);
        }

        public static StringSet parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (StringSet) GeneratedMessageLite.H(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static StringSet parseFrom(InputStream inputStream) throws IOException {
            return (StringSet) GeneratedMessageLite.C(DEFAULT_INSTANCE, inputStream);
        }

        public static StringSet parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (StringSet) GeneratedMessageLite.D(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static StringSet parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (StringSet) GeneratedMessageLite.A(DEFAULT_INSTANCE, codedInputStream);
        }

        public static StringSet parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (StringSet) GeneratedMessageLite.B(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    public interface StringSetOrBuilder extends MessageLiteOrBuilder {
        String getStrings(int i11);

        ByteString getStringsBytes(int i11);

        int getStringsCount();

        List<String> getStringsList();
    }

    public static final class Value extends GeneratedMessageLite<Value, Builder> implements ValueOrBuilder {
        public static final int BOOLEAN_FIELD_NUMBER = 1;
        /* access modifiers changed from: private */
        public static final Value DEFAULT_INSTANCE;
        public static final int DOUBLE_FIELD_NUMBER = 7;
        public static final int FLOAT_FIELD_NUMBER = 2;
        public static final int INTEGER_FIELD_NUMBER = 3;
        public static final int LONG_FIELD_NUMBER = 4;
        private static volatile Parser<Value> PARSER = null;
        public static final int STRING_FIELD_NUMBER = 5;
        public static final int STRING_SET_FIELD_NUMBER = 6;
        private int bitField0_;
        private int valueCase_ = 0;
        private Object value_;

        public static final class Builder extends GeneratedMessageLite.Builder<Value, Builder> implements ValueOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 r12) {
                this();
            }

            public Builder clearBoolean() {
                d();
                ((Value) this.f35783b).clearBoolean();
                return this;
            }

            public Builder clearDouble() {
                d();
                ((Value) this.f35783b).clearDouble();
                return this;
            }

            public Builder clearFloat() {
                d();
                ((Value) this.f35783b).clearFloat();
                return this;
            }

            public Builder clearInteger() {
                d();
                ((Value) this.f35783b).clearInteger();
                return this;
            }

            public Builder clearLong() {
                d();
                ((Value) this.f35783b).clearLong();
                return this;
            }

            public Builder clearString() {
                d();
                ((Value) this.f35783b).clearString();
                return this;
            }

            public Builder clearStringSet() {
                d();
                ((Value) this.f35783b).clearStringSet();
                return this;
            }

            public Builder clearValue() {
                d();
                ((Value) this.f35783b).clearValue();
                return this;
            }

            public boolean getBoolean() {
                return ((Value) this.f35783b).getBoolean();
            }

            public double getDouble() {
                return ((Value) this.f35783b).getDouble();
            }

            public float getFloat() {
                return ((Value) this.f35783b).getFloat();
            }

            public int getInteger() {
                return ((Value) this.f35783b).getInteger();
            }

            public long getLong() {
                return ((Value) this.f35783b).getLong();
            }

            public String getString() {
                return ((Value) this.f35783b).getString();
            }

            public ByteString getStringBytes() {
                return ((Value) this.f35783b).getStringBytes();
            }

            public StringSet getStringSet() {
                return ((Value) this.f35783b).getStringSet();
            }

            public ValueCase getValueCase() {
                return ((Value) this.f35783b).getValueCase();
            }

            public boolean hasBoolean() {
                return ((Value) this.f35783b).hasBoolean();
            }

            public boolean hasDouble() {
                return ((Value) this.f35783b).hasDouble();
            }

            public boolean hasFloat() {
                return ((Value) this.f35783b).hasFloat();
            }

            public boolean hasInteger() {
                return ((Value) this.f35783b).hasInteger();
            }

            public boolean hasLong() {
                return ((Value) this.f35783b).hasLong();
            }

            public boolean hasString() {
                return ((Value) this.f35783b).hasString();
            }

            public boolean hasStringSet() {
                return ((Value) this.f35783b).hasStringSet();
            }

            public Builder mergeStringSet(StringSet stringSet) {
                d();
                ((Value) this.f35783b).mergeStringSet(stringSet);
                return this;
            }

            public Builder setBoolean(boolean z11) {
                d();
                ((Value) this.f35783b).setBoolean(z11);
                return this;
            }

            public Builder setDouble(double d11) {
                d();
                ((Value) this.f35783b).setDouble(d11);
                return this;
            }

            public Builder setFloat(float f11) {
                d();
                ((Value) this.f35783b).setFloat(f11);
                return this;
            }

            public Builder setInteger(int i11) {
                d();
                ((Value) this.f35783b).setInteger(i11);
                return this;
            }

            public Builder setLong(long j11) {
                d();
                ((Value) this.f35783b).setLong(j11);
                return this;
            }

            public Builder setString(String str) {
                d();
                ((Value) this.f35783b).setString(str);
                return this;
            }

            public Builder setStringBytes(ByteString byteString) {
                d();
                ((Value) this.f35783b).setStringBytes(byteString);
                return this;
            }

            public Builder setStringSet(StringSet stringSet) {
                d();
                ((Value) this.f35783b).setStringSet(stringSet);
                return this;
            }

            private Builder() {
                super(Value.DEFAULT_INSTANCE);
            }

            public Builder setStringSet(StringSet.Builder builder) {
                d();
                ((Value) this.f35783b).setStringSet(builder);
                return this;
            }
        }

        public enum ValueCase {
            BOOLEAN(1),
            FLOAT(2),
            INTEGER(3),
            LONG(4),
            STRING(5),
            STRING_SET(6),
            DOUBLE(7),
            VALUE_NOT_SET(0);
            
            private final int value;

            private ValueCase(int i11) {
                this.value = i11;
            }

            public static ValueCase forNumber(int i11) {
                switch (i11) {
                    case 0:
                        return VALUE_NOT_SET;
                    case 1:
                        return BOOLEAN;
                    case 2:
                        return FLOAT;
                    case 3:
                        return INTEGER;
                    case 4:
                        return LONG;
                    case 5:
                        return STRING;
                    case 6:
                        return STRING_SET;
                    case 7:
                        return DOUBLE;
                    default:
                        return null;
                }
            }

            public int getNumber() {
                return this.value;
            }

            @Deprecated
            public static ValueCase valueOf(int i11) {
                return forNumber(i11);
            }
        }

        static {
            Value value = new Value();
            DEFAULT_INSTANCE = value;
            GeneratedMessageLite.L(Value.class, value);
        }

        private Value() {
        }

        /* access modifiers changed from: private */
        public void clearBoolean() {
            if (this.valueCase_ == 1) {
                this.valueCase_ = 0;
                this.value_ = null;
            }
        }

        /* access modifiers changed from: private */
        public void clearDouble() {
            if (this.valueCase_ == 7) {
                this.valueCase_ = 0;
                this.value_ = null;
            }
        }

        /* access modifiers changed from: private */
        public void clearFloat() {
            if (this.valueCase_ == 2) {
                this.valueCase_ = 0;
                this.value_ = null;
            }
        }

        /* access modifiers changed from: private */
        public void clearInteger() {
            if (this.valueCase_ == 3) {
                this.valueCase_ = 0;
                this.value_ = null;
            }
        }

        /* access modifiers changed from: private */
        public void clearLong() {
            if (this.valueCase_ == 4) {
                this.valueCase_ = 0;
                this.value_ = null;
            }
        }

        /* access modifiers changed from: private */
        public void clearString() {
            if (this.valueCase_ == 5) {
                this.valueCase_ = 0;
                this.value_ = null;
            }
        }

        /* access modifiers changed from: private */
        public void clearStringSet() {
            if (this.valueCase_ == 6) {
                this.valueCase_ = 0;
                this.value_ = null;
            }
        }

        /* access modifiers changed from: private */
        public void clearValue() {
            this.valueCase_ = 0;
            this.value_ = null;
        }

        public static Value getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* access modifiers changed from: private */
        public void mergeStringSet(StringSet stringSet) {
            stringSet.getClass();
            if (this.valueCase_ != 6 || this.value_ == StringSet.getDefaultInstance()) {
                this.value_ = stringSet;
            } else {
                this.value_ = ((StringSet.Builder) StringSet.newBuilder((StringSet) this.value_).mergeFrom(stringSet)).buildPartial();
            }
            this.valueCase_ = 6;
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.i();
        }

        public static Value parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Value) GeneratedMessageLite.w(DEFAULT_INSTANCE, inputStream);
        }

        public static Value parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (Value) GeneratedMessageLite.E(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<Value> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* access modifiers changed from: private */
        public void setBoolean(boolean z11) {
            this.valueCase_ = 1;
            this.value_ = Boolean.valueOf(z11);
        }

        /* access modifiers changed from: private */
        public void setDouble(double d11) {
            this.valueCase_ = 7;
            this.value_ = Double.valueOf(d11);
        }

        /* access modifiers changed from: private */
        public void setFloat(float f11) {
            this.valueCase_ = 2;
            this.value_ = Float.valueOf(f11);
        }

        /* access modifiers changed from: private */
        public void setInteger(int i11) {
            this.valueCase_ = 3;
            this.value_ = Integer.valueOf(i11);
        }

        /* access modifiers changed from: private */
        public void setLong(long j11) {
            this.valueCase_ = 4;
            this.value_ = Long.valueOf(j11);
        }

        /* access modifiers changed from: private */
        public void setString(String str) {
            str.getClass();
            this.valueCase_ = 5;
            this.value_ = str;
        }

        /* access modifiers changed from: private */
        public void setStringBytes(ByteString byteString) {
            byteString.getClass();
            this.valueCase_ = 5;
            this.value_ = byteString.toStringUtf8();
        }

        /* access modifiers changed from: private */
        public void setStringSet(StringSet stringSet) {
            stringSet.getClass();
            this.value_ = stringSet;
            this.valueCase_ = 6;
        }

        public boolean getBoolean() {
            if (this.valueCase_ == 1) {
                return ((Boolean) this.value_).booleanValue();
            }
            return false;
        }

        public double getDouble() {
            if (this.valueCase_ == 7) {
                return ((Double) this.value_).doubleValue();
            }
            return 0.0d;
        }

        public float getFloat() {
            if (this.valueCase_ == 2) {
                return ((Float) this.value_).floatValue();
            }
            return 0.0f;
        }

        public int getInteger() {
            if (this.valueCase_ == 3) {
                return ((Integer) this.value_).intValue();
            }
            return 0;
        }

        public long getLong() {
            if (this.valueCase_ == 4) {
                return ((Long) this.value_).longValue();
            }
            return 0;
        }

        public String getString() {
            if (this.valueCase_ == 5) {
                return (String) this.value_;
            }
            return "";
        }

        public ByteString getStringBytes() {
            String str;
            if (this.valueCase_ == 5) {
                str = (String) this.value_;
            } else {
                str = "";
            }
            return ByteString.copyFromUtf8(str);
        }

        public StringSet getStringSet() {
            if (this.valueCase_ == 6) {
                return (StringSet) this.value_;
            }
            return StringSet.getDefaultInstance();
        }

        public ValueCase getValueCase() {
            return ValueCase.forNumber(this.valueCase_);
        }

        public boolean hasBoolean() {
            return this.valueCase_ == 1;
        }

        public boolean hasDouble() {
            return this.valueCase_ == 7;
        }

        public boolean hasFloat() {
            return this.valueCase_ == 2;
        }

        public boolean hasInteger() {
            return this.valueCase_ == 3;
        }

        public boolean hasLong() {
            return this.valueCase_ == 4;
        }

        public boolean hasString() {
            return this.valueCase_ == 5;
        }

        public boolean hasStringSet() {
            return this.valueCase_ == 6;
        }

        public final Object m(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (AnonymousClass1.f35720a[methodToInvoke.ordinal()]) {
                case 1:
                    return new Value();
                case 2:
                    return new Builder((AnonymousClass1) null);
                case 3:
                    return GeneratedMessageLite.v(DEFAULT_INSTANCE, "\u0001\u0007\u0001\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001:\u0000\u00024\u0000\u00037\u0000\u00045\u0000\u0005;\u0000\u0006<\u0000\u00073\u0000", new Object[]{"value_", "valueCase_", "bitField0_", StringSet.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<Value> parser = PARSER;
                    if (parser == null) {
                        synchronized (Value.class) {
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

        public static Builder newBuilder(Value value) {
            return (Builder) DEFAULT_INSTANCE.j(value);
        }

        public static Value parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Value) GeneratedMessageLite.x(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Value parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Value) GeneratedMessageLite.F(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static Value parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (Value) GeneratedMessageLite.y(DEFAULT_INSTANCE, byteString);
        }

        public static Value parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Value) GeneratedMessageLite.z(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        /* access modifiers changed from: private */
        public void setStringSet(StringSet.Builder builder) {
            this.value_ = builder.build();
            this.valueCase_ = 6;
        }

        public static Value parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (Value) GeneratedMessageLite.G(DEFAULT_INSTANCE, bArr);
        }

        public static Value parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Value) GeneratedMessageLite.H(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Value parseFrom(InputStream inputStream) throws IOException {
            return (Value) GeneratedMessageLite.C(DEFAULT_INSTANCE, inputStream);
        }

        public static Value parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Value) GeneratedMessageLite.D(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Value parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Value) GeneratedMessageLite.A(DEFAULT_INSTANCE, codedInputStream);
        }

        public static Value parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Value) GeneratedMessageLite.B(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    public interface ValueOrBuilder extends MessageLiteOrBuilder {
        boolean getBoolean();

        double getDouble();

        float getFloat();

        int getInteger();

        long getLong();

        String getString();

        ByteString getStringBytes();

        StringSet getStringSet();

        Value.ValueCase getValueCase();

        boolean hasBoolean();

        boolean hasDouble();

        boolean hasFloat();

        boolean hasInteger();

        boolean hasLong();

        boolean hasString();

        boolean hasStringSet();
    }

    private PreferencesProto() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }
}
