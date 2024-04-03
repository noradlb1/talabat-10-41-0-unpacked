package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import androidx.datastore.preferences.protobuf.Internal;
import androidx.datastore.preferences.protobuf.Option;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

public final class Field extends GeneratedMessageLite<Field, Builder> implements FieldOrBuilder {
    public static final int CARDINALITY_FIELD_NUMBER = 2;
    /* access modifiers changed from: private */
    public static final Field DEFAULT_INSTANCE;
    public static final int DEFAULT_VALUE_FIELD_NUMBER = 11;
    public static final int JSON_NAME_FIELD_NUMBER = 10;
    public static final int KIND_FIELD_NUMBER = 1;
    public static final int NAME_FIELD_NUMBER = 4;
    public static final int NUMBER_FIELD_NUMBER = 3;
    public static final int ONEOF_INDEX_FIELD_NUMBER = 7;
    public static final int OPTIONS_FIELD_NUMBER = 9;
    public static final int PACKED_FIELD_NUMBER = 8;
    private static volatile Parser<Field> PARSER = null;
    public static final int TYPE_URL_FIELD_NUMBER = 6;
    private int cardinality_;
    private String defaultValue_ = "";
    private String jsonName_ = "";
    private int kind_;
    private String name_ = "";
    private int number_;
    private int oneofIndex_;
    private Internal.ProtobufList<Option> options_ = GeneratedMessageLite.n();
    private boolean packed_;
    private String typeUrl_ = "";

    /* renamed from: androidx.datastore.preferences.protobuf.Field$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f35771a;

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
                f35771a = r0
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f35771a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_BUILDER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f35771a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f35771a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f35771a     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.GET_PARSER     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f35771a     // Catch:{ NoSuchFieldError -> 0x0049 }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f35771a     // Catch:{ NoSuchFieldError -> 0x0054 }
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$MethodToInvoke r1 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.Field.AnonymousClass1.<clinit>():void");
        }
    }

    public static final class Builder extends GeneratedMessageLite.Builder<Field, Builder> implements FieldOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 r12) {
            this();
        }

        public Builder addAllOptions(Iterable<? extends Option> iterable) {
            d();
            ((Field) this.f35783b).addAllOptions(iterable);
            return this;
        }

        public Builder addOptions(Option option) {
            d();
            ((Field) this.f35783b).addOptions(option);
            return this;
        }

        public Builder clearCardinality() {
            d();
            ((Field) this.f35783b).clearCardinality();
            return this;
        }

        public Builder clearDefaultValue() {
            d();
            ((Field) this.f35783b).clearDefaultValue();
            return this;
        }

        public Builder clearJsonName() {
            d();
            ((Field) this.f35783b).clearJsonName();
            return this;
        }

        public Builder clearKind() {
            d();
            ((Field) this.f35783b).clearKind();
            return this;
        }

        public Builder clearName() {
            d();
            ((Field) this.f35783b).clearName();
            return this;
        }

        public Builder clearNumber() {
            d();
            ((Field) this.f35783b).clearNumber();
            return this;
        }

        public Builder clearOneofIndex() {
            d();
            ((Field) this.f35783b).clearOneofIndex();
            return this;
        }

        public Builder clearOptions() {
            d();
            ((Field) this.f35783b).clearOptions();
            return this;
        }

        public Builder clearPacked() {
            d();
            ((Field) this.f35783b).clearPacked();
            return this;
        }

        public Builder clearTypeUrl() {
            d();
            ((Field) this.f35783b).clearTypeUrl();
            return this;
        }

        public Cardinality getCardinality() {
            return ((Field) this.f35783b).getCardinality();
        }

        public int getCardinalityValue() {
            return ((Field) this.f35783b).getCardinalityValue();
        }

        public String getDefaultValue() {
            return ((Field) this.f35783b).getDefaultValue();
        }

        public ByteString getDefaultValueBytes() {
            return ((Field) this.f35783b).getDefaultValueBytes();
        }

        public String getJsonName() {
            return ((Field) this.f35783b).getJsonName();
        }

        public ByteString getJsonNameBytes() {
            return ((Field) this.f35783b).getJsonNameBytes();
        }

        public Kind getKind() {
            return ((Field) this.f35783b).getKind();
        }

        public int getKindValue() {
            return ((Field) this.f35783b).getKindValue();
        }

        public String getName() {
            return ((Field) this.f35783b).getName();
        }

        public ByteString getNameBytes() {
            return ((Field) this.f35783b).getNameBytes();
        }

        public int getNumber() {
            return ((Field) this.f35783b).getNumber();
        }

        public int getOneofIndex() {
            return ((Field) this.f35783b).getOneofIndex();
        }

        public Option getOptions(int i11) {
            return ((Field) this.f35783b).getOptions(i11);
        }

        public int getOptionsCount() {
            return ((Field) this.f35783b).getOptionsCount();
        }

        public List<Option> getOptionsList() {
            return Collections.unmodifiableList(((Field) this.f35783b).getOptionsList());
        }

        public boolean getPacked() {
            return ((Field) this.f35783b).getPacked();
        }

        public String getTypeUrl() {
            return ((Field) this.f35783b).getTypeUrl();
        }

        public ByteString getTypeUrlBytes() {
            return ((Field) this.f35783b).getTypeUrlBytes();
        }

        public Builder removeOptions(int i11) {
            d();
            ((Field) this.f35783b).removeOptions(i11);
            return this;
        }

        public Builder setCardinality(Cardinality cardinality) {
            d();
            ((Field) this.f35783b).setCardinality(cardinality);
            return this;
        }

        public Builder setCardinalityValue(int i11) {
            d();
            ((Field) this.f35783b).setCardinalityValue(i11);
            return this;
        }

        public Builder setDefaultValue(String str) {
            d();
            ((Field) this.f35783b).setDefaultValue(str);
            return this;
        }

        public Builder setDefaultValueBytes(ByteString byteString) {
            d();
            ((Field) this.f35783b).setDefaultValueBytes(byteString);
            return this;
        }

        public Builder setJsonName(String str) {
            d();
            ((Field) this.f35783b).setJsonName(str);
            return this;
        }

        public Builder setJsonNameBytes(ByteString byteString) {
            d();
            ((Field) this.f35783b).setJsonNameBytes(byteString);
            return this;
        }

        public Builder setKind(Kind kind) {
            d();
            ((Field) this.f35783b).setKind(kind);
            return this;
        }

        public Builder setKindValue(int i11) {
            d();
            ((Field) this.f35783b).setKindValue(i11);
            return this;
        }

        public Builder setName(String str) {
            d();
            ((Field) this.f35783b).setName(str);
            return this;
        }

        public Builder setNameBytes(ByteString byteString) {
            d();
            ((Field) this.f35783b).setNameBytes(byteString);
            return this;
        }

        public Builder setNumber(int i11) {
            d();
            ((Field) this.f35783b).setNumber(i11);
            return this;
        }

        public Builder setOneofIndex(int i11) {
            d();
            ((Field) this.f35783b).setOneofIndex(i11);
            return this;
        }

        public Builder setOptions(int i11, Option option) {
            d();
            ((Field) this.f35783b).setOptions(i11, option);
            return this;
        }

        public Builder setPacked(boolean z11) {
            d();
            ((Field) this.f35783b).setPacked(z11);
            return this;
        }

        public Builder setTypeUrl(String str) {
            d();
            ((Field) this.f35783b).setTypeUrl(str);
            return this;
        }

        public Builder setTypeUrlBytes(ByteString byteString) {
            d();
            ((Field) this.f35783b).setTypeUrlBytes(byteString);
            return this;
        }

        private Builder() {
            super(Field.DEFAULT_INSTANCE);
        }

        public Builder addOptions(int i11, Option option) {
            d();
            ((Field) this.f35783b).addOptions(i11, option);
            return this;
        }

        public Builder setOptions(int i11, Option.Builder builder) {
            d();
            ((Field) this.f35783b).setOptions(i11, builder);
            return this;
        }

        public Builder addOptions(Option.Builder builder) {
            d();
            ((Field) this.f35783b).addOptions(builder);
            return this;
        }

        public Builder addOptions(int i11, Option.Builder builder) {
            d();
            ((Field) this.f35783b).addOptions(i11, builder);
            return this;
        }
    }

    public enum Cardinality implements Internal.EnumLite {
        CARDINALITY_UNKNOWN(0),
        CARDINALITY_OPTIONAL(1),
        CARDINALITY_REQUIRED(2),
        CARDINALITY_REPEATED(3),
        UNRECOGNIZED(-1);
        
        public static final int CARDINALITY_OPTIONAL_VALUE = 1;
        public static final int CARDINALITY_REPEATED_VALUE = 3;
        public static final int CARDINALITY_REQUIRED_VALUE = 2;
        public static final int CARDINALITY_UNKNOWN_VALUE = 0;
        private static final Internal.EnumLiteMap<Cardinality> internalValueMap = null;
        private final int value;

        public static final class CardinalityVerifier implements Internal.EnumVerifier {

            /* renamed from: a  reason: collision with root package name */
            public static final Internal.EnumVerifier f35772a = null;

            static {
                f35772a = new CardinalityVerifier();
            }

            private CardinalityVerifier() {
            }

            public boolean isInRange(int i11) {
                return Cardinality.forNumber(i11) != null;
            }
        }

        /* access modifiers changed from: public */
        static {
            internalValueMap = new Internal.EnumLiteMap<Cardinality>() {
                public Cardinality findValueByNumber(int i11) {
                    return Cardinality.forNumber(i11);
                }
            };
        }

        private Cardinality(int i11) {
            this.value = i11;
        }

        public static Cardinality forNumber(int i11) {
            if (i11 == 0) {
                return CARDINALITY_UNKNOWN;
            }
            if (i11 == 1) {
                return CARDINALITY_OPTIONAL;
            }
            if (i11 == 2) {
                return CARDINALITY_REQUIRED;
            }
            if (i11 != 3) {
                return null;
            }
            return CARDINALITY_REPEATED;
        }

        public static Internal.EnumLiteMap<Cardinality> internalGetValueMap() {
            return internalValueMap;
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return CardinalityVerifier.f35772a;
        }

        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static Cardinality valueOf(int i11) {
            return forNumber(i11);
        }
    }

    public enum Kind implements Internal.EnumLite {
        TYPE_UNKNOWN(0),
        TYPE_DOUBLE(1),
        TYPE_FLOAT(2),
        TYPE_INT64(3),
        TYPE_UINT64(4),
        TYPE_INT32(5),
        TYPE_FIXED64(6),
        TYPE_FIXED32(7),
        TYPE_BOOL(8),
        TYPE_STRING(9),
        TYPE_GROUP(10),
        TYPE_MESSAGE(11),
        TYPE_BYTES(12),
        TYPE_UINT32(13),
        TYPE_ENUM(14),
        TYPE_SFIXED32(15),
        TYPE_SFIXED64(16),
        TYPE_SINT32(17),
        TYPE_SINT64(18),
        UNRECOGNIZED(-1);
        
        public static final int TYPE_BOOL_VALUE = 8;
        public static final int TYPE_BYTES_VALUE = 12;
        public static final int TYPE_DOUBLE_VALUE = 1;
        public static final int TYPE_ENUM_VALUE = 14;
        public static final int TYPE_FIXED32_VALUE = 7;
        public static final int TYPE_FIXED64_VALUE = 6;
        public static final int TYPE_FLOAT_VALUE = 2;
        public static final int TYPE_GROUP_VALUE = 10;
        public static final int TYPE_INT32_VALUE = 5;
        public static final int TYPE_INT64_VALUE = 3;
        public static final int TYPE_MESSAGE_VALUE = 11;
        public static final int TYPE_SFIXED32_VALUE = 15;
        public static final int TYPE_SFIXED64_VALUE = 16;
        public static final int TYPE_SINT32_VALUE = 17;
        public static final int TYPE_SINT64_VALUE = 18;
        public static final int TYPE_STRING_VALUE = 9;
        public static final int TYPE_UINT32_VALUE = 13;
        public static final int TYPE_UINT64_VALUE = 4;
        public static final int TYPE_UNKNOWN_VALUE = 0;
        private static final Internal.EnumLiteMap<Kind> internalValueMap = null;
        private final int value;

        public static final class KindVerifier implements Internal.EnumVerifier {

            /* renamed from: a  reason: collision with root package name */
            public static final Internal.EnumVerifier f35773a = null;

            static {
                f35773a = new KindVerifier();
            }

            private KindVerifier() {
            }

            public boolean isInRange(int i11) {
                return Kind.forNumber(i11) != null;
            }
        }

        /* access modifiers changed from: public */
        static {
            internalValueMap = new Internal.EnumLiteMap<Kind>() {
                public Kind findValueByNumber(int i11) {
                    return Kind.forNumber(i11);
                }
            };
        }

        private Kind(int i11) {
            this.value = i11;
        }

        public static Kind forNumber(int i11) {
            switch (i11) {
                case 0:
                    return TYPE_UNKNOWN;
                case 1:
                    return TYPE_DOUBLE;
                case 2:
                    return TYPE_FLOAT;
                case 3:
                    return TYPE_INT64;
                case 4:
                    return TYPE_UINT64;
                case 5:
                    return TYPE_INT32;
                case 6:
                    return TYPE_FIXED64;
                case 7:
                    return TYPE_FIXED32;
                case 8:
                    return TYPE_BOOL;
                case 9:
                    return TYPE_STRING;
                case 10:
                    return TYPE_GROUP;
                case 11:
                    return TYPE_MESSAGE;
                case 12:
                    return TYPE_BYTES;
                case 13:
                    return TYPE_UINT32;
                case 14:
                    return TYPE_ENUM;
                case 15:
                    return TYPE_SFIXED32;
                case 16:
                    return TYPE_SFIXED64;
                case 17:
                    return TYPE_SINT32;
                case 18:
                    return TYPE_SINT64;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<Kind> internalGetValueMap() {
            return internalValueMap;
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return KindVerifier.f35773a;
        }

        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static Kind valueOf(int i11) {
            return forNumber(i11);
        }
    }

    static {
        Field field = new Field();
        DEFAULT_INSTANCE = field;
        GeneratedMessageLite.L(Field.class, field);
    }

    private Field() {
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
    public void clearCardinality() {
        this.cardinality_ = 0;
    }

    /* access modifiers changed from: private */
    public void clearDefaultValue() {
        this.defaultValue_ = getDefaultInstance().getDefaultValue();
    }

    /* access modifiers changed from: private */
    public void clearJsonName() {
        this.jsonName_ = getDefaultInstance().getJsonName();
    }

    /* access modifiers changed from: private */
    public void clearKind() {
        this.kind_ = 0;
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
    public void clearOneofIndex() {
        this.oneofIndex_ = 0;
    }

    /* access modifiers changed from: private */
    public void clearOptions() {
        this.options_ = GeneratedMessageLite.n();
    }

    /* access modifiers changed from: private */
    public void clearPacked() {
        this.packed_ = false;
    }

    /* access modifiers changed from: private */
    public void clearTypeUrl() {
        this.typeUrl_ = getDefaultInstance().getTypeUrl();
    }

    private void ensureOptionsIsMutable() {
        if (!this.options_.isModifiable()) {
            this.options_ = GeneratedMessageLite.u(this.options_);
        }
    }

    public static Field getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.i();
    }

    public static Field parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Field) GeneratedMessageLite.w(DEFAULT_INSTANCE, inputStream);
    }

    public static Field parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (Field) GeneratedMessageLite.E(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<Field> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* access modifiers changed from: private */
    public void removeOptions(int i11) {
        ensureOptionsIsMutable();
        this.options_.remove(i11);
    }

    /* access modifiers changed from: private */
    public void setCardinality(Cardinality cardinality) {
        cardinality.getClass();
        this.cardinality_ = cardinality.getNumber();
    }

    /* access modifiers changed from: private */
    public void setCardinalityValue(int i11) {
        this.cardinality_ = i11;
    }

    /* access modifiers changed from: private */
    public void setDefaultValue(String str) {
        str.getClass();
        this.defaultValue_ = str;
    }

    /* access modifiers changed from: private */
    public void setDefaultValueBytes(ByteString byteString) {
        byteString.getClass();
        AbstractMessageLite.b(byteString);
        this.defaultValue_ = byteString.toStringUtf8();
    }

    /* access modifiers changed from: private */
    public void setJsonName(String str) {
        str.getClass();
        this.jsonName_ = str;
    }

    /* access modifiers changed from: private */
    public void setJsonNameBytes(ByteString byteString) {
        byteString.getClass();
        AbstractMessageLite.b(byteString);
        this.jsonName_ = byteString.toStringUtf8();
    }

    /* access modifiers changed from: private */
    public void setKind(Kind kind) {
        kind.getClass();
        this.kind_ = kind.getNumber();
    }

    /* access modifiers changed from: private */
    public void setKindValue(int i11) {
        this.kind_ = i11;
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
    public void setOneofIndex(int i11) {
        this.oneofIndex_ = i11;
    }

    /* access modifiers changed from: private */
    public void setOptions(int i11, Option option) {
        option.getClass();
        ensureOptionsIsMutable();
        this.options_.set(i11, option);
    }

    /* access modifiers changed from: private */
    public void setPacked(boolean z11) {
        this.packed_ = z11;
    }

    /* access modifiers changed from: private */
    public void setTypeUrl(String str) {
        str.getClass();
        this.typeUrl_ = str;
    }

    /* access modifiers changed from: private */
    public void setTypeUrlBytes(ByteString byteString) {
        byteString.getClass();
        AbstractMessageLite.b(byteString);
        this.typeUrl_ = byteString.toStringUtf8();
    }

    public Cardinality getCardinality() {
        Cardinality forNumber = Cardinality.forNumber(this.cardinality_);
        if (forNumber == null) {
            return Cardinality.UNRECOGNIZED;
        }
        return forNumber;
    }

    public int getCardinalityValue() {
        return this.cardinality_;
    }

    public String getDefaultValue() {
        return this.defaultValue_;
    }

    public ByteString getDefaultValueBytes() {
        return ByteString.copyFromUtf8(this.defaultValue_);
    }

    public String getJsonName() {
        return this.jsonName_;
    }

    public ByteString getJsonNameBytes() {
        return ByteString.copyFromUtf8(this.jsonName_);
    }

    public Kind getKind() {
        Kind forNumber = Kind.forNumber(this.kind_);
        if (forNumber == null) {
            return Kind.UNRECOGNIZED;
        }
        return forNumber;
    }

    public int getKindValue() {
        return this.kind_;
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

    public int getOneofIndex() {
        return this.oneofIndex_;
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

    public boolean getPacked() {
        return this.packed_;
    }

    public String getTypeUrl() {
        return this.typeUrl_;
    }

    public ByteString getTypeUrlBytes() {
        return ByteString.copyFromUtf8(this.typeUrl_);
    }

    public final Object m(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.f35771a[methodToInvoke.ordinal()]) {
            case 1:
                return new Field();
            case 2:
                return new Builder((AnonymousClass1) null);
            case 3:
                return GeneratedMessageLite.v(DEFAULT_INSTANCE, "\u0000\n\u0000\u0000\u0001\u000b\n\u0000\u0001\u0000\u0001\f\u0002\f\u0003\u0004\u0004Ȉ\u0006Ȉ\u0007\u0004\b\u0007\t\u001b\nȈ\u000bȈ", new Object[]{"kind_", "cardinality_", "number_", "name_", "typeUrl_", "oneofIndex_", "packed_", "options_", Option.class, "jsonName_", "defaultValue_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Field> parser = PARSER;
                if (parser == null) {
                    synchronized (Field.class) {
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

    public static Builder newBuilder(Field field) {
        return (Builder) DEFAULT_INSTANCE.j(field);
    }

    public static Field parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Field) GeneratedMessageLite.x(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Field parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Field) GeneratedMessageLite.F(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Field parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (Field) GeneratedMessageLite.y(DEFAULT_INSTANCE, byteString);
    }

    /* access modifiers changed from: private */
    public void addOptions(int i11, Option option) {
        option.getClass();
        ensureOptionsIsMutable();
        this.options_.add(i11, option);
    }

    public static Field parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Field) GeneratedMessageLite.z(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    /* access modifiers changed from: private */
    public void setOptions(int i11, Option.Builder builder) {
        ensureOptionsIsMutable();
        this.options_.set(i11, builder.build());
    }

    public static Field parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (Field) GeneratedMessageLite.G(DEFAULT_INSTANCE, bArr);
    }

    public static Field parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Field) GeneratedMessageLite.H(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    /* access modifiers changed from: private */
    public void addOptions(Option.Builder builder) {
        ensureOptionsIsMutable();
        this.options_.add(builder.build());
    }

    public static Field parseFrom(InputStream inputStream) throws IOException {
        return (Field) GeneratedMessageLite.C(DEFAULT_INSTANCE, inputStream);
    }

    public static Field parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Field) GeneratedMessageLite.D(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    /* access modifiers changed from: private */
    public void addOptions(int i11, Option.Builder builder) {
        ensureOptionsIsMutable();
        this.options_.add(i11, builder.build());
    }

    public static Field parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Field) GeneratedMessageLite.A(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Field parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Field) GeneratedMessageLite.B(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
