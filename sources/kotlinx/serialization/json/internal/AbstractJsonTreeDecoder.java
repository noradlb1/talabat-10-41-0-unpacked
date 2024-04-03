package kotlinx.serialization.json.internal;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.adjust.sdk.Constants;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.descriptors.PolymorphicKind;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.descriptors.StructureKind;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.internal.NamedValueDecoder;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonConfiguration;
import kotlinx.serialization.json.JsonDecoder;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonLiteral;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;
import kotlinx.serialization.modules.SerializersModule;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000¼\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\b\u0004\u0012\u0006\u0010>\u001a\u00020=\u0012\u0006\u0010B\u001a\u00020\u0003¢\u0006\u0004\bN\u0010OJ\b\u0010\u0004\u001a\u00020\u0003H\u0002JA\u0010\t\u001a\u00028\u0000\"\b\b\u0000\u0010\u0006*\u00020\u0005*\u00020\u00072\u0006\u0010\t\u001a\u00020\b2\u0019\u0010\f\u001a\u0015\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00018\u00000\n¢\u0006\u0002\b\u000bH\b¢\u0006\u0004\b\t\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0014\u0010\u0012\u001a\u00020\u0011*\u00020\u00072\u0006\u0010\u0010\u001a\u00020\bH\u0002J\b\u0010\u0013\u001a\u00020\u0003H\u0016J#\u0010\u0016\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00062\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\bH\u0014J\u0010\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\u0010\u0010 \u001a\u00020\u001f2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\b\u0010\"\u001a\u00020!H\u0016J\u0010\u0010$\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\bH\u0004J\u0010\u0010%\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\bH$J\u0018\u0010(\u001a\u00020'2\u0006\u0010#\u001a\u00020\b2\u0006\u0010&\u001a\u00020\u001bH\u0014J\u0012\u0010)\u001a\u0004\u0018\u00010\u000e2\u0006\u0010#\u001a\u00020\bH\u0014J\u0010\u0010*\u001a\u00020!2\u0006\u0010#\u001a\u00020\bH\u0014J\u0010\u0010+\u001a\u00020!2\u0006\u0010#\u001a\u00020\bH\u0014J\u0010\u0010-\u001a\u00020,2\u0006\u0010#\u001a\u00020\bH\u0014J\u0010\u0010/\u001a\u00020.2\u0006\u0010#\u001a\u00020\bH\u0014J\u0010\u00100\u001a\u00020'2\u0006\u0010#\u001a\u00020\bH\u0014J\u0010\u00102\u001a\u0002012\u0006\u0010#\u001a\u00020\bH\u0014J\u0010\u00104\u001a\u0002032\u0006\u0010#\u001a\u00020\bH\u0014J\u0010\u00106\u001a\u0002052\u0006\u0010#\u001a\u00020\bH\u0014J\u0010\u00108\u001a\u0002072\u0006\u0010#\u001a\u00020\bH\u0014J\u0010\u00109\u001a\u00020\b2\u0006\u0010#\u001a\u00020\bH\u0014J\u0018\u0010<\u001a\u00020;2\u0006\u0010#\u001a\u00020\b2\u0006\u0010:\u001a\u00020\u001bH\u0014R\u001a\u0010>\u001a\u00020=8\u0016X\u0004¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010AR\u001a\u0010B\u001a\u00020\u00038\u0016X\u0004¢\u0006\f\n\u0004\bB\u0010C\u001a\u0004\bD\u0010ER\u0014\u0010I\u001a\u00020F8\u0004X\u0004¢\u0006\u0006\n\u0004\bG\u0010HR\u0014\u0010M\u001a\u00020J8VX\u0004¢\u0006\u0006\u001a\u0004\bK\u0010L\u0001\u0003PQR¨\u0006S"}, d2 = {"Lkotlinx/serialization/json/internal/AbstractJsonTreeDecoder;", "Lkotlinx/serialization/internal/NamedValueDecoder;", "Lkotlinx/serialization/json/JsonDecoder;", "Lkotlinx/serialization/json/JsonElement;", "currentObject", "", "T", "Lkotlinx/serialization/json/JsonPrimitive;", "", "primitive", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "block", "(Lkotlinx/serialization/json/JsonPrimitive;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "", "unparsedPrimitive", "type", "Lkotlinx/serialization/json/JsonLiteral;", "asLiteral", "decodeJsonElement", "Lkotlinx/serialization/DeserializationStrategy;", "deserializer", "decodeSerializableValue", "(Lkotlinx/serialization/DeserializationStrategy;)Ljava/lang/Object;", "parentName", "childName", "f", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "Lkotlinx/serialization/encoding/CompositeDecoder;", "beginStructure", "", "endStructure", "", "decodeNotNullMark", "tag", "x", "j", "enumDescriptor", "", "o", "u", "t", "k", "", "l", "", "v", "r", "", "s", "", "p", "", "n", "", "m", "w", "inlineDescriptor", "Lkotlinx/serialization/encoding/Decoder;", "q", "Lkotlinx/serialization/json/Json;", "json", "Lkotlinx/serialization/json/Json;", "getJson", "()Lkotlinx/serialization/json/Json;", "value", "Lkotlinx/serialization/json/JsonElement;", "getValue", "()Lkotlinx/serialization/json/JsonElement;", "Lkotlinx/serialization/json/JsonConfiguration;", "a", "Lkotlinx/serialization/json/JsonConfiguration;", "configuration", "Lkotlinx/serialization/modules/SerializersModule;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "serializersModule", "<init>", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/JsonElement;)V", "Lkotlinx/serialization/json/internal/JsonPrimitiveDecoder;", "Lkotlinx/serialization/json/internal/JsonTreeDecoder;", "Lkotlinx/serialization/json/internal/JsonTreeListDecoder;", "kotlinx-serialization-json"}, k = 1, mv = {1, 6, 0})
abstract class AbstractJsonTreeDecoder extends NamedValueDecoder implements JsonDecoder {
    @NotNull
    @JvmField

    /* renamed from: a  reason: collision with root package name */
    public final JsonConfiguration f26437a;
    @NotNull
    private final Json json;
    @NotNull
    private final JsonElement value;

    private AbstractJsonTreeDecoder(Json json2, JsonElement jsonElement) {
        this.json = json2;
        this.value = jsonElement;
        this.f26437a = getJson().getConfiguration();
    }

    public /* synthetic */ AbstractJsonTreeDecoder(Json json2, JsonElement jsonElement, DefaultConstructorMarker defaultConstructorMarker) {
        this(json2, jsonElement);
    }

    private final JsonLiteral asLiteral(JsonPrimitive jsonPrimitive, String str) {
        JsonLiteral jsonLiteral = jsonPrimitive instanceof JsonLiteral ? (JsonLiteral) jsonPrimitive : null;
        if (jsonLiteral != null) {
            return jsonLiteral;
        }
        throw JsonExceptionsKt.JsonDecodingException(-1, "Unexpected 'null' when " + str + " was expected");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
        r0 = j(r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final kotlinx.serialization.json.JsonElement currentObject() {
        /*
            r1 = this;
            java.lang.Object r0 = r1.c()
            java.lang.String r0 = (java.lang.String) r0
            if (r0 == 0) goto L_0x000e
            kotlinx.serialization.json.JsonElement r0 = r1.j(r0)
            if (r0 != 0) goto L_0x0012
        L_0x000e:
            kotlinx.serialization.json.JsonElement r0 = r1.getValue()
        L_0x0012:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.json.internal.AbstractJsonTreeDecoder.currentObject():kotlinx.serialization.json.JsonElement");
    }

    private final <T> T primitive(JsonPrimitive jsonPrimitive, String str, Function1<? super JsonPrimitive, ? extends T> function1) {
        try {
            T invoke = function1.invoke(jsonPrimitive);
            if (invoke != null) {
                return invoke;
            }
            unparsedPrimitive(str);
            throw new KotlinNothingValueException();
        } catch (IllegalArgumentException unused) {
            unparsedPrimitive(str);
            throw new KotlinNothingValueException();
        }
    }

    private final Void unparsedPrimitive(String str) {
        throw JsonExceptionsKt.JsonDecodingException(-1, "Failed to parse '" + str + '\'', currentObject().toString());
    }

    @NotNull
    public CompositeDecoder beginStructure(@NotNull SerialDescriptor serialDescriptor) {
        boolean z11;
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        JsonElement currentObject = currentObject();
        SerialKind kind = serialDescriptor.getKind();
        if (Intrinsics.areEqual((Object) kind, (Object) StructureKind.LIST.INSTANCE)) {
            z11 = true;
        } else {
            z11 = kind instanceof PolymorphicKind;
        }
        Class<JsonArray> cls = JsonArray.class;
        if (z11) {
            Json json2 = getJson();
            if (currentObject instanceof JsonArray) {
                return new JsonTreeListDecoder(json2, (JsonArray) currentObject);
            }
            throw JsonExceptionsKt.JsonDecodingException(-1, "Expected " + Reflection.getOrCreateKotlinClass(cls) + " as the serialized body of " + serialDescriptor.getSerialName() + ", but had " + Reflection.getOrCreateKotlinClass(currentObject.getClass()));
        }
        Class<JsonObject> cls2 = JsonObject.class;
        if (Intrinsics.areEqual((Object) kind, (Object) StructureKind.MAP.INSTANCE)) {
            Json json3 = getJson();
            SerialDescriptor carrierDescriptor = WriteModeKt.carrierDescriptor(serialDescriptor.getElementDescriptor(0), json3.getSerializersModule());
            SerialKind kind2 = carrierDescriptor.getKind();
            if ((kind2 instanceof PrimitiveKind) || Intrinsics.areEqual((Object) kind2, (Object) SerialKind.ENUM.INSTANCE)) {
                Json json4 = getJson();
                if (currentObject instanceof JsonObject) {
                    return new JsonTreeMapDecoder(json4, (JsonObject) currentObject);
                }
                throw JsonExceptionsKt.JsonDecodingException(-1, "Expected " + Reflection.getOrCreateKotlinClass(cls2) + " as the serialized body of " + serialDescriptor.getSerialName() + ", but had " + Reflection.getOrCreateKotlinClass(currentObject.getClass()));
            } else if (json3.getConfiguration().getAllowStructuredMapKeys()) {
                Json json5 = getJson();
                if (currentObject instanceof JsonArray) {
                    return new JsonTreeListDecoder(json5, (JsonArray) currentObject);
                }
                throw JsonExceptionsKt.JsonDecodingException(-1, "Expected " + Reflection.getOrCreateKotlinClass(cls) + " as the serialized body of " + serialDescriptor.getSerialName() + ", but had " + Reflection.getOrCreateKotlinClass(currentObject.getClass()));
            } else {
                throw JsonExceptionsKt.InvalidKeyKindException(carrierDescriptor);
            }
        } else {
            Json json6 = getJson();
            if (currentObject instanceof JsonObject) {
                return new JsonTreeDecoder(json6, (JsonObject) currentObject, (String) null, (SerialDescriptor) null, 12, (DefaultConstructorMarker) null);
            }
            throw JsonExceptionsKt.JsonDecodingException(-1, "Expected " + Reflection.getOrCreateKotlinClass(cls2) + " as the serialized body of " + serialDescriptor.getSerialName() + ", but had " + Reflection.getOrCreateKotlinClass(currentObject.getClass()));
        }
    }

    @NotNull
    public JsonElement decodeJsonElement() {
        return currentObject();
    }

    public boolean decodeNotNullMark() {
        return !(currentObject() instanceof JsonNull);
    }

    public <T> T decodeSerializableValue(@NotNull DeserializationStrategy<T> deserializationStrategy) {
        Intrinsics.checkNotNullParameter(deserializationStrategy, "deserializer");
        return PolymorphicKt.decodeSerializableValuePolymorphic(this, deserializationStrategy);
    }

    public void endStructure(@NotNull SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
    }

    @NotNull
    public String f(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "parentName");
        Intrinsics.checkNotNullParameter(str2, "childName");
        return str2;
    }

    @NotNull
    public Json getJson() {
        return this.json;
    }

    @NotNull
    public SerializersModule getSerializersModule() {
        return getJson().getSerializersModule();
    }

    @NotNull
    public JsonElement getValue() {
        return this.value;
    }

    @NotNull
    public abstract JsonElement j(@NotNull String str);

    /* renamed from: k */
    public boolean decodeTaggedBoolean(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "tag");
        JsonPrimitive x11 = x(str);
        if (getJson().getConfiguration().isLenient() || !asLiteral(x11, TypedValues.Custom.S_BOOLEAN).isString()) {
            try {
                Boolean booleanOrNull = JsonElementKt.getBooleanOrNull(x11);
                if (booleanOrNull != null) {
                    return booleanOrNull.booleanValue();
                }
                throw new IllegalArgumentException();
            } catch (IllegalArgumentException unused) {
                unparsedPrimitive(TypedValues.Custom.S_BOOLEAN);
                throw new KotlinNothingValueException();
            }
        } else {
            throw JsonExceptionsKt.JsonDecodingException(-1, "Boolean literal for key '" + str + "' should be unquoted.\nUse 'isLenient = true' in 'Json {}` builder to accept non-compliant JSON.", currentObject().toString());
        }
    }

    /* renamed from: l */
    public byte decodeTaggedByte(@NotNull String str) {
        Byte b11;
        Intrinsics.checkNotNullParameter(str, "tag");
        try {
            int i11 = JsonElementKt.getInt(x(str));
            boolean z11 = false;
            if (-128 <= i11 && i11 <= 127) {
                z11 = true;
            }
            if (z11) {
                b11 = Byte.valueOf((byte) i11);
            } else {
                b11 = null;
            }
            if (b11 != null) {
                return b11.byteValue();
            }
            unparsedPrimitive("byte");
            throw new KotlinNothingValueException();
        } catch (IllegalArgumentException unused) {
            unparsedPrimitive("byte");
            throw new KotlinNothingValueException();
        }
    }

    /* renamed from: m */
    public char decodeTaggedChar(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "tag");
        try {
            return StringsKt___StringsKt.single(x(str).getContent());
        } catch (IllegalArgumentException unused) {
            unparsedPrimitive("char");
            throw new KotlinNothingValueException();
        }
    }

    /* renamed from: n */
    public double decodeTaggedDouble(@NotNull String str) {
        boolean z11;
        Intrinsics.checkNotNullParameter(str, "tag");
        try {
            double d11 = JsonElementKt.getDouble(x(str));
            if (!getJson().getConfiguration().getAllowSpecialFloatingPointValues()) {
                if (Double.isInfinite(d11) || Double.isNaN(d11)) {
                    z11 = false;
                } else {
                    z11 = true;
                }
                if (!z11) {
                    throw JsonExceptionsKt.InvalidFloatingPointDecoded(Double.valueOf(d11), str, currentObject().toString());
                }
            }
            return d11;
        } catch (IllegalArgumentException unused) {
            unparsedPrimitive("double");
            throw new KotlinNothingValueException();
        }
    }

    /* renamed from: o */
    public int decodeTaggedEnum(@NotNull String str, @NotNull SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(serialDescriptor, "enumDescriptor");
        return JsonNamesMapKt.getJsonNameIndexOrThrow$default(serialDescriptor, getJson(), x(str).getContent(), (String) null, 4, (Object) null);
    }

    /* renamed from: p */
    public float decodeTaggedFloat(@NotNull String str) {
        boolean z11;
        Intrinsics.checkNotNullParameter(str, "tag");
        try {
            float f11 = JsonElementKt.getFloat(x(str));
            if (!getJson().getConfiguration().getAllowSpecialFloatingPointValues()) {
                if (Float.isInfinite(f11) || Float.isNaN(f11)) {
                    z11 = false;
                } else {
                    z11 = true;
                }
                if (!z11) {
                    throw JsonExceptionsKt.InvalidFloatingPointDecoded(Float.valueOf(f11), str, currentObject().toString());
                }
            }
            return f11;
        } catch (IllegalArgumentException unused) {
            unparsedPrimitive(TypedValues.Custom.S_FLOAT);
            throw new KotlinNothingValueException();
        }
    }

    @NotNull
    /* renamed from: q */
    public Decoder decodeTaggedInline(@NotNull String str, @NotNull SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(serialDescriptor, "inlineDescriptor");
        if (StreamingJsonEncoderKt.isUnsignedNumber(serialDescriptor)) {
            return new JsonDecoderForUnsignedTypes(new StringJsonLexer(x(str).getContent()), getJson());
        }
        return super.decodeTaggedInline(str, serialDescriptor);
    }

    /* renamed from: r */
    public int decodeTaggedInt(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "tag");
        try {
            return JsonElementKt.getInt(x(str));
        } catch (IllegalArgumentException unused) {
            unparsedPrimitive("int");
            throw new KotlinNothingValueException();
        }
    }

    /* renamed from: s */
    public long decodeTaggedLong(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "tag");
        try {
            return JsonElementKt.getLong(x(str));
        } catch (IllegalArgumentException unused) {
            unparsedPrimitive(Constants.LONG);
            throw new KotlinNothingValueException();
        }
    }

    /* renamed from: t */
    public boolean decodeTaggedNotNullMark(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "tag");
        if (j(str) != JsonNull.INSTANCE) {
            return true;
        }
        return false;
    }

    @Nullable
    /* renamed from: u */
    public Void decodeTaggedNull(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "tag");
        return null;
    }

    /* renamed from: v */
    public short decodeTaggedShort(@NotNull String str) {
        Short sh2;
        Intrinsics.checkNotNullParameter(str, "tag");
        try {
            int i11 = JsonElementKt.getInt(x(str));
            boolean z11 = false;
            if (-32768 <= i11 && i11 <= 32767) {
                z11 = true;
            }
            if (z11) {
                sh2 = Short.valueOf((short) i11);
            } else {
                sh2 = null;
            }
            if (sh2 != null) {
                return sh2.shortValue();
            }
            unparsedPrimitive("short");
            throw new KotlinNothingValueException();
        } catch (IllegalArgumentException unused) {
            unparsedPrimitive("short");
            throw new KotlinNothingValueException();
        }
    }

    @NotNull
    /* renamed from: w */
    public String decodeTaggedString(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "tag");
        JsonPrimitive x11 = x(str);
        if (!getJson().getConfiguration().isLenient() && !asLiteral(x11, TypedValues.Custom.S_STRING).isString()) {
            throw JsonExceptionsKt.JsonDecodingException(-1, "String literal for key '" + str + "' should be quoted.\nUse 'isLenient = true' in 'Json {}` builder to accept non-compliant JSON.", currentObject().toString());
        } else if (!(x11 instanceof JsonNull)) {
            return x11.getContent();
        } else {
            throw JsonExceptionsKt.JsonDecodingException(-1, "Unexpected 'null' value instead of string literal", currentObject().toString());
        }
    }

    @NotNull
    public final JsonPrimitive x(@NotNull String str) {
        JsonPrimitive jsonPrimitive;
        Intrinsics.checkNotNullParameter(str, "tag");
        JsonElement j11 = j(str);
        if (j11 instanceof JsonPrimitive) {
            jsonPrimitive = (JsonPrimitive) j11;
        } else {
            jsonPrimitive = null;
        }
        if (jsonPrimitive != null) {
            return jsonPrimitive;
        }
        throw JsonExceptionsKt.JsonDecodingException(-1, "Expected JsonPrimitive at " + str + ", found " + j11, currentObject().toString());
    }
}
