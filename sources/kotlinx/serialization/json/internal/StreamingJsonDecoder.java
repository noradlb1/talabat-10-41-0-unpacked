package kotlinx.serialization.json.internal;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.instabug.library.model.session.config.SessionsConfigParameter;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.MissingFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.encoding.AbstractDecoder;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonConfiguration;
import kotlinx.serialization.json.JsonDecoder;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.modules.SerializersModule;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0010\u0018\u00002\u00020\u00012\u00020\u0002B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u000fH\u0002J\b\u0010\u001f\u001a\u00020\u001dH\u0016J\b\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020%H\u0016J\u0010\u0010&\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010'\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020\nH\u0016J\b\u0010)\u001a\u00020*H\u0016J\u0010\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\nH\u0016J\b\u0010.\u001a\u00020\u000fH\u0016J\b\u0010/\u001a\u000200H\u0016J\b\u00101\u001a\u00020\u000fH\u0002J\b\u00102\u001a\u000203H\u0016J\b\u00104\u001a\u00020\u000fH\u0002J\b\u00105\u001a\u00020\u001dH\u0016J\n\u00106\u001a\u0004\u0018\u000107H\u0016J\u0010\u00108\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\nH\u0002J;\u00109\u001a\u0002H:\"\u0004\b\u0000\u0010:2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u000f2\f\u0010;\u001a\b\u0012\u0004\u0012\u0002H:0<2\b\u0010=\u001a\u0004\u0018\u0001H:H\u0016¢\u0006\u0002\u0010>J!\u0010?\u001a\u0002H:\"\u0004\b\u0000\u0010:2\f\u0010;\u001a\b\u0012\u0004\u0012\u0002H:0<H\u0016¢\u0006\u0002\u0010@J\b\u0010A\u001a\u00020BH\u0016J\b\u0010C\u001a\u00020DH\u0016J\b\u0010E\u001a\u00020DH\u0002J\u0010\u0010F\u001a\u00020\u001b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010G\u001a\u00020\u001d2\u0006\u0010H\u001a\u00020DH\u0002J\u0010\u0010I\u001a\u00020\u001b2\u0006\u0010\t\u001a\u00020\nH\u0002R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0007\u001a\u00020\b8\u0000X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006J"}, d2 = {"Lkotlinx/serialization/json/internal/StreamingJsonDecoder;", "Lkotlinx/serialization/json/JsonDecoder;", "Lkotlinx/serialization/encoding/AbstractDecoder;", "json", "Lkotlinx/serialization/json/Json;", "mode", "Lkotlinx/serialization/json/internal/WriteMode;", "lexer", "Lkotlinx/serialization/json/internal/AbstractJsonLexer;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/internal/WriteMode;Lkotlinx/serialization/json/internal/AbstractJsonLexer;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "configuration", "Lkotlinx/serialization/json/JsonConfiguration;", "currentIndex", "", "elementMarker", "Lkotlinx/serialization/json/internal/JsonElementMarker;", "getJson", "()Lkotlinx/serialization/json/Json;", "serializersModule", "Lkotlinx/serialization/modules/SerializersModule;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "beginStructure", "Lkotlinx/serialization/encoding/CompositeDecoder;", "checkLeadingComma", "", "coerceInputValue", "", "index", "decodeBoolean", "decodeByte", "", "decodeChar", "", "decodeDouble", "", "decodeElementIndex", "decodeEnum", "enumDescriptor", "decodeFloat", "", "decodeInline", "Lkotlinx/serialization/encoding/Decoder;", "inlineDescriptor", "decodeInt", "decodeJsonElement", "Lkotlinx/serialization/json/JsonElement;", "decodeListIndex", "decodeLong", "", "decodeMapIndex", "decodeNotNullMark", "decodeNull", "", "decodeObjectIndex", "decodeSerializableElement", "T", "deserializer", "Lkotlinx/serialization/DeserializationStrategy;", "previousValue", "(Lkotlinx/serialization/descriptors/SerialDescriptor;ILkotlinx/serialization/DeserializationStrategy;Ljava/lang/Object;)Ljava/lang/Object;", "decodeSerializableValue", "(Lkotlinx/serialization/DeserializationStrategy;)Ljava/lang/Object;", "decodeShort", "", "decodeString", "", "decodeStringKey", "endStructure", "handleUnknown", "key", "skipLeftoverElements", "kotlinx-serialization-json"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class StreamingJsonDecoder extends AbstractDecoder implements JsonDecoder {
    @NotNull
    private final JsonConfiguration configuration;
    private int currentIndex = -1;
    @Nullable
    private final JsonElementMarker elementMarker;
    @NotNull
    private final Json json;
    @NotNull
    @JvmField
    public final AbstractJsonLexer lexer;
    @NotNull
    private final WriteMode mode;
    @NotNull
    private final SerializersModule serializersModule;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[WriteMode.values().length];
            iArr[WriteMode.LIST.ordinal()] = 1;
            iArr[WriteMode.MAP.ordinal()] = 2;
            iArr[WriteMode.POLY_OBJ.ordinal()] = 3;
            iArr[WriteMode.OBJ.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public StreamingJsonDecoder(@NotNull Json json2, @NotNull WriteMode writeMode, @NotNull AbstractJsonLexer abstractJsonLexer, @NotNull SerialDescriptor serialDescriptor) {
        JsonElementMarker jsonElementMarker;
        Intrinsics.checkNotNullParameter(json2, "json");
        Intrinsics.checkNotNullParameter(writeMode, SessionsConfigParameter.SYNC_MODE);
        Intrinsics.checkNotNullParameter(abstractJsonLexer, "lexer");
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        this.json = json2;
        this.mode = writeMode;
        this.lexer = abstractJsonLexer;
        this.serializersModule = json2.getSerializersModule();
        JsonConfiguration configuration2 = json2.getConfiguration();
        this.configuration = configuration2;
        if (configuration2.getExplicitNulls()) {
            jsonElementMarker = null;
        } else {
            jsonElementMarker = new JsonElementMarker(serialDescriptor);
        }
        this.elementMarker = jsonElementMarker;
    }

    private final void checkLeadingComma() {
        if (this.lexer.peekNextToken() == 4) {
            AbstractJsonLexer.fail$default(this.lexer, "Unexpected leading comma", 0, (String) null, 6, (Object) null);
            throw new KotlinNothingValueException();
        }
    }

    private final boolean coerceInputValue(SerialDescriptor serialDescriptor, int i11) {
        String peekString;
        Json json2 = this.json;
        SerialDescriptor elementDescriptor = serialDescriptor.getElementDescriptor(i11);
        if (!elementDescriptor.isNullable() && (!this.lexer.tryConsumeNotNull())) {
            return true;
        }
        if (!Intrinsics.areEqual((Object) elementDescriptor.getKind(), (Object) SerialKind.ENUM.INSTANCE) || (peekString = this.lexer.peekString(this.configuration.isLenient())) == null || JsonNamesMapKt.getJsonNameIndex(elementDescriptor, json2, peekString) != -3) {
            return false;
        }
        this.lexer.consumeString();
        return true;
    }

    private final int decodeListIndex() {
        boolean tryConsumeComma = this.lexer.tryConsumeComma();
        if (this.lexer.canConsumeValue()) {
            int i11 = this.currentIndex;
            if (i11 == -1 || tryConsumeComma) {
                int i12 = i11 + 1;
                this.currentIndex = i12;
                return i12;
            }
            AbstractJsonLexer.fail$default(this.lexer, "Expected end of the array or comma", 0, (String) null, 6, (Object) null);
            throw new KotlinNothingValueException();
        } else if (!tryConsumeComma) {
            return -1;
        } else {
            AbstractJsonLexer.fail$default(this.lexer, "Unexpected trailing comma", 0, (String) null, 6, (Object) null);
            throw new KotlinNothingValueException();
        }
    }

    private final int decodeMapIndex() {
        boolean z11;
        int i11 = this.currentIndex;
        boolean z12 = false;
        if (i11 % 2 != 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            this.lexer.consumeNextToken((char) AbstractJsonLexerKt.COLON);
        } else if (i11 != -1) {
            z12 = this.lexer.tryConsumeComma();
        }
        if (this.lexer.canConsumeValue()) {
            if (z11) {
                if (this.currentIndex == -1) {
                    AbstractJsonLexer abstractJsonLexer = this.lexer;
                    boolean z13 = !z12;
                    int access$getCurrentPosition$p = abstractJsonLexer.f26436a;
                    if (!z13) {
                        AbstractJsonLexer.fail$default(abstractJsonLexer, "Unexpected trailing comma", access$getCurrentPosition$p, (String) null, 4, (Object) null);
                        throw new KotlinNothingValueException();
                    }
                } else {
                    AbstractJsonLexer abstractJsonLexer2 = this.lexer;
                    int access$getCurrentPosition$p2 = abstractJsonLexer2.f26436a;
                    if (!z12) {
                        AbstractJsonLexer.fail$default(abstractJsonLexer2, "Expected comma after the key-value pair", access$getCurrentPosition$p2, (String) null, 4, (Object) null);
                        throw new KotlinNothingValueException();
                    }
                }
            }
            int i12 = this.currentIndex + 1;
            this.currentIndex = i12;
            return i12;
        } else if (!z12) {
            return -1;
        } else {
            AbstractJsonLexer.fail$default(this.lexer, "Expected '}', but had ',' instead", 0, (String) null, 6, (Object) null);
            throw new KotlinNothingValueException();
        }
    }

    private final int decodeObjectIndex(SerialDescriptor serialDescriptor) {
        boolean z11;
        boolean tryConsumeComma = this.lexer.tryConsumeComma();
        while (this.lexer.canConsumeValue()) {
            String decodeStringKey = decodeStringKey();
            this.lexer.consumeNextToken((char) AbstractJsonLexerKt.COLON);
            int jsonNameIndex = JsonNamesMapKt.getJsonNameIndex(serialDescriptor, this.json, decodeStringKey);
            boolean z12 = false;
            if (jsonNameIndex == -3) {
                z12 = true;
                z11 = false;
            } else if (!this.configuration.getCoerceInputValues() || !coerceInputValue(serialDescriptor, jsonNameIndex)) {
                JsonElementMarker jsonElementMarker = this.elementMarker;
                if (jsonElementMarker != null) {
                    jsonElementMarker.mark$kotlinx_serialization_json(jsonNameIndex);
                }
                return jsonNameIndex;
            } else {
                z11 = this.lexer.tryConsumeComma();
            }
            if (z12) {
                tryConsumeComma = handleUnknown(decodeStringKey);
            } else {
                tryConsumeComma = z11;
            }
        }
        if (!tryConsumeComma) {
            JsonElementMarker jsonElementMarker2 = this.elementMarker;
            if (jsonElementMarker2 != null) {
                return jsonElementMarker2.nextUnmarkedIndex$kotlinx_serialization_json();
            }
            return -1;
        }
        AbstractJsonLexer.fail$default(this.lexer, "Unexpected trailing comma", 0, (String) null, 6, (Object) null);
        throw new KotlinNothingValueException();
    }

    private final String decodeStringKey() {
        if (this.configuration.isLenient()) {
            return this.lexer.consumeStringLenientNotNull();
        }
        return this.lexer.consumeKeyString();
    }

    private final boolean handleUnknown(String str) {
        if (this.configuration.getIgnoreUnknownKeys()) {
            this.lexer.skipElement(this.configuration.isLenient());
        } else {
            this.lexer.failOnUnknownKey(str);
        }
        return this.lexer.tryConsumeComma();
    }

    private final void skipLeftoverElements(SerialDescriptor serialDescriptor) {
        do {
        } while (decodeElementIndex(serialDescriptor) != -1);
    }

    @NotNull
    public CompositeDecoder beginStructure(@NotNull SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        WriteMode switchMode = WriteModeKt.switchMode(this.json, serialDescriptor);
        this.lexer.path.pushDescriptor(serialDescriptor);
        this.lexer.consumeNextToken(switchMode.begin);
        checkLeadingComma();
        int i11 = WhenMappings.$EnumSwitchMapping$0[switchMode.ordinal()];
        if (i11 == 1 || i11 == 2 || i11 == 3) {
            return new StreamingJsonDecoder(this.json, switchMode, this.lexer, serialDescriptor);
        }
        if (this.mode != switchMode || !this.json.getConfiguration().getExplicitNulls()) {
            return new StreamingJsonDecoder(this.json, switchMode, this.lexer, serialDescriptor);
        }
        return this;
    }

    public boolean decodeBoolean() {
        if (this.configuration.isLenient()) {
            return this.lexer.consumeBooleanLenient();
        }
        return this.lexer.consumeBoolean();
    }

    public byte decodeByte() {
        long consumeNumericLiteral = this.lexer.consumeNumericLiteral();
        byte b11 = (byte) ((int) consumeNumericLiteral);
        if (consumeNumericLiteral == ((long) b11)) {
            return b11;
        }
        AbstractJsonLexer abstractJsonLexer = this.lexer;
        AbstractJsonLexer.fail$default(abstractJsonLexer, "Failed to parse byte for input '" + consumeNumericLiteral + '\'', 0, (String) null, 6, (Object) null);
        throw new KotlinNothingValueException();
    }

    public char decodeChar() {
        String consumeStringLenient = this.lexer.consumeStringLenient();
        if (consumeStringLenient.length() == 1) {
            return consumeStringLenient.charAt(0);
        }
        AbstractJsonLexer abstractJsonLexer = this.lexer;
        AbstractJsonLexer.fail$default(abstractJsonLexer, "Expected single char, but got '" + consumeStringLenient + '\'', 0, (String) null, 6, (Object) null);
        throw new KotlinNothingValueException();
    }

    public double decodeDouble() {
        boolean z11;
        AbstractJsonLexer abstractJsonLexer = this.lexer;
        String consumeStringLenient = abstractJsonLexer.consumeStringLenient();
        try {
            double parseDouble = Double.parseDouble(consumeStringLenient);
            if (!this.json.getConfiguration().getAllowSpecialFloatingPointValues()) {
                if (Double.isInfinite(parseDouble) || Double.isNaN(parseDouble)) {
                    z11 = false;
                } else {
                    z11 = true;
                }
                if (!z11) {
                    JsonExceptionsKt.throwInvalidFloatingPointDecoded(this.lexer, Double.valueOf(parseDouble));
                    throw new KotlinNothingValueException();
                }
            }
            return parseDouble;
        } catch (IllegalArgumentException unused) {
            AbstractJsonLexer.fail$default(abstractJsonLexer, "Failed to parse type '" + "double" + "' for input '" + consumeStringLenient + '\'', 0, (String) null, 6, (Object) null);
            throw new KotlinNothingValueException();
        }
    }

    public int decodeElementIndex(@NotNull SerialDescriptor serialDescriptor) {
        int i11;
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        int i12 = WhenMappings.$EnumSwitchMapping$0[this.mode.ordinal()];
        if (i12 == 2) {
            i11 = decodeMapIndex();
        } else if (i12 != 4) {
            i11 = decodeListIndex();
        } else {
            i11 = decodeObjectIndex(serialDescriptor);
        }
        if (this.mode != WriteMode.MAP) {
            this.lexer.path.updateDescriptorIndex(i11);
        }
        return i11;
    }

    public int decodeEnum(@NotNull SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "enumDescriptor");
        Json json2 = this.json;
        String decodeString = decodeString();
        return JsonNamesMapKt.getJsonNameIndexOrThrow(serialDescriptor, json2, decodeString, " at path " + this.lexer.path.getPath());
    }

    public float decodeFloat() {
        boolean z11;
        AbstractJsonLexer abstractJsonLexer = this.lexer;
        String consumeStringLenient = abstractJsonLexer.consumeStringLenient();
        try {
            float parseFloat = Float.parseFloat(consumeStringLenient);
            if (!this.json.getConfiguration().getAllowSpecialFloatingPointValues()) {
                if (Float.isInfinite(parseFloat) || Float.isNaN(parseFloat)) {
                    z11 = false;
                } else {
                    z11 = true;
                }
                if (!z11) {
                    JsonExceptionsKt.throwInvalidFloatingPointDecoded(this.lexer, Float.valueOf(parseFloat));
                    throw new KotlinNothingValueException();
                }
            }
            return parseFloat;
        } catch (IllegalArgumentException unused) {
            AbstractJsonLexer.fail$default(abstractJsonLexer, "Failed to parse type '" + TypedValues.Custom.S_FLOAT + "' for input '" + consumeStringLenient + '\'', 0, (String) null, 6, (Object) null);
            throw new KotlinNothingValueException();
        }
    }

    @NotNull
    public Decoder decodeInline(@NotNull SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "inlineDescriptor");
        if (StreamingJsonEncoderKt.isUnsignedNumber(serialDescriptor)) {
            return new JsonDecoderForUnsignedTypes(this.lexer, this.json);
        }
        return super.decodeInline(serialDescriptor);
    }

    public int decodeInt() {
        long consumeNumericLiteral = this.lexer.consumeNumericLiteral();
        int i11 = (int) consumeNumericLiteral;
        if (consumeNumericLiteral == ((long) i11)) {
            return i11;
        }
        AbstractJsonLexer abstractJsonLexer = this.lexer;
        AbstractJsonLexer.fail$default(abstractJsonLexer, "Failed to parse int for input '" + consumeNumericLiteral + '\'', 0, (String) null, 6, (Object) null);
        throw new KotlinNothingValueException();
    }

    @NotNull
    public JsonElement decodeJsonElement() {
        return new JsonTreeReader(this.json.getConfiguration(), this.lexer).read();
    }

    public long decodeLong() {
        return this.lexer.consumeNumericLiteral();
    }

    public boolean decodeNotNullMark() {
        JsonElementMarker jsonElementMarker = this.elementMarker;
        return !(jsonElementMarker != null ? jsonElementMarker.isUnmarkedNull$kotlinx_serialization_json() : false) && this.lexer.tryConsumeNotNull();
    }

    @Nullable
    public Void decodeNull() {
        return null;
    }

    public <T> T decodeSerializableElement(@NotNull SerialDescriptor serialDescriptor, int i11, @NotNull DeserializationStrategy<T> deserializationStrategy, @Nullable T t11) {
        boolean z11;
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        Intrinsics.checkNotNullParameter(deserializationStrategy, "deserializer");
        if (this.mode == WriteMode.MAP && (i11 & 1) == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            this.lexer.path.resetCurrentMapKey();
        }
        T decodeSerializableElement = super.decodeSerializableElement(serialDescriptor, i11, deserializationStrategy, t11);
        if (z11) {
            this.lexer.path.updateCurrentMapKey(decodeSerializableElement);
        }
        return decodeSerializableElement;
    }

    public <T> T decodeSerializableValue(@NotNull DeserializationStrategy<T> deserializationStrategy) {
        Intrinsics.checkNotNullParameter(deserializationStrategy, "deserializer");
        try {
            return PolymorphicKt.decodeSerializableValuePolymorphic(this, deserializationStrategy);
        } catch (MissingFieldException e11) {
            throw new MissingFieldException(e11.getMessage() + " at path: " + this.lexer.path.getPath(), (Throwable) e11);
        }
    }

    public short decodeShort() {
        long consumeNumericLiteral = this.lexer.consumeNumericLiteral();
        short s11 = (short) ((int) consumeNumericLiteral);
        if (consumeNumericLiteral == ((long) s11)) {
            return s11;
        }
        AbstractJsonLexer abstractJsonLexer = this.lexer;
        AbstractJsonLexer.fail$default(abstractJsonLexer, "Failed to parse short for input '" + consumeNumericLiteral + '\'', 0, (String) null, 6, (Object) null);
        throw new KotlinNothingValueException();
    }

    @NotNull
    public String decodeString() {
        if (this.configuration.isLenient()) {
            return this.lexer.consumeStringLenientNotNull();
        }
        return this.lexer.consumeString();
    }

    public void endStructure(@NotNull SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        if (this.json.getConfiguration().getIgnoreUnknownKeys() && serialDescriptor.getElementsCount() == 0) {
            skipLeftoverElements(serialDescriptor);
        }
        this.lexer.consumeNextToken(this.mode.end);
        this.lexer.path.popDescriptor();
    }

    @NotNull
    public final Json getJson() {
        return this.json;
    }

    @NotNull
    public SerializersModule getSerializersModule() {
        return this.serializersModule;
    }
}
