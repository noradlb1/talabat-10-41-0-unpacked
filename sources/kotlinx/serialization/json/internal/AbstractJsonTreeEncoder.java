package kotlinx.serialization.json.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.PolymorphicSerializerKt;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.PolymorphicKind;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.descriptors.StructureKind;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.AbstractPolymorphicSerializer;
import kotlinx.serialization.internal.NamedValueEncoder;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonConfiguration;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonElementSerializer;
import kotlinx.serialization.json.JsonEncoder;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.modules.SerializersModule;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\n\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b3\u0018\u00002\u00020\u00012\u00020\u0002B%\b\u0004\u0012\u0006\u00108\u001a\u000207\u0012\u0012\u0010=\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050<¢\u0006\u0004\bH\u0010IJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0014J\u0018\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0013\u001a\u00020\u0003H&J\b\u0010\u0014\u001a\u00020\u0005H\u0016J\u0010\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\rH\u0014J\u0018\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\tH\u0014J\u0018\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0019H\u0014J\u0018\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u001bH\u0014J\u0018\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u001dH\u0014J\u0018\u0010 \u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u001fH\u0014J+\u0010$\u001a\u00020\u0005\"\u0004\b\u0000\u0010!2\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\"2\u0006\u0010\u0017\u001a\u00028\u0000H\u0016¢\u0006\u0004\b$\u0010%J\u0018\u0010'\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020&H\u0014J\u0018\u0010(\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u000bH\u0014J\u0018\u0010*\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020)H\u0014J\u0018\u0010+\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\rH\u0014J \u0010.\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010,\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\tH\u0014J\u0018\u00100\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020/H\u0014J\u0018\u00103\u001a\u0002022\u0006\u0010\u0015\u001a\u00020\r2\u0006\u00101\u001a\u00020\u0007H\u0014J\u0010\u00105\u001a\u0002042\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u00106\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0014R\u0017\u00108\u001a\u0002078\u0006¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;R \u0010=\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050<8\u0002X\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u0014\u0010A\u001a\u00020?8\u0004X\u0004¢\u0006\u0006\n\u0004\b6\u0010@R\u0018\u0010B\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\u0011\u0010G\u001a\u00020D8F¢\u0006\u0006\u001a\u0004\bE\u0010F\u0001\u0003JKL¨\u0006M"}, d2 = {"Lkotlinx/serialization/json/internal/AbstractJsonTreeEncoder;", "Lkotlinx/serialization/internal/NamedValueEncoder;", "Lkotlinx/serialization/json/JsonEncoder;", "Lkotlinx/serialization/json/JsonElement;", "element", "", "encodeJsonElement", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "", "index", "", "shouldEncodeElementDefault", "", "parentName", "childName", "f", "key", "putElement", "getCurrent", "encodeNull", "tag", "s", "value", "q", "", "k", "", "t", "", "r", "", "o", "T", "Lkotlinx/serialization/SerializationStrategy;", "serializer", "encodeSerializableValue", "(Lkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)V", "", "m", "j", "", "l", "u", "enumDescriptor", "ordinal", "n", "", "v", "inlineDescriptor", "Lkotlinx/serialization/encoding/Encoder;", "p", "Lkotlinx/serialization/encoding/CompositeEncoder;", "beginStructure", "a", "Lkotlinx/serialization/json/Json;", "json", "Lkotlinx/serialization/json/Json;", "getJson", "()Lkotlinx/serialization/json/Json;", "Lkotlin/Function1;", "nodeConsumer", "Lkotlin/jvm/functions/Function1;", "Lkotlinx/serialization/json/JsonConfiguration;", "Lkotlinx/serialization/json/JsonConfiguration;", "configuration", "polymorphicDiscriminator", "Ljava/lang/String;", "Lkotlinx/serialization/modules/SerializersModule;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "serializersModule", "<init>", "(Lkotlinx/serialization/json/Json;Lkotlin/jvm/functions/Function1;)V", "Lkotlinx/serialization/json/internal/JsonPrimitiveEncoder;", "Lkotlinx/serialization/json/internal/JsonTreeEncoder;", "Lkotlinx/serialization/json/internal/JsonTreeListEncoder;", "kotlinx-serialization-json"}, k = 1, mv = {1, 6, 0})
@ExperimentalSerializationApi
abstract class AbstractJsonTreeEncoder extends NamedValueEncoder implements JsonEncoder {
    @NotNull
    @JvmField

    /* renamed from: a  reason: collision with root package name */
    public final JsonConfiguration f26438a;
    @NotNull
    private final Json json;
    @NotNull
    private final Function1<JsonElement, Unit> nodeConsumer;
    @Nullable
    private String polymorphicDiscriminator;

    private AbstractJsonTreeEncoder(Json json2, Function1<? super JsonElement, Unit> function1) {
        this.json = json2;
        this.nodeConsumer = function1;
        this.f26438a = json2.getConfiguration();
    }

    public /* synthetic */ AbstractJsonTreeEncoder(Json json2, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this(json2, function1);
    }

    public static final /* synthetic */ String access$getCurrentTag(AbstractJsonTreeEncoder abstractJsonTreeEncoder) {
        return (String) abstractJsonTreeEncoder.b();
    }

    public void a(@NotNull SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        this.nodeConsumer.invoke(getCurrent());
    }

    @NotNull
    public CompositeEncoder beginStructure(@NotNull SerialDescriptor serialDescriptor) {
        Function1 function1;
        boolean z11;
        AbstractJsonTreeEncoder abstractJsonTreeEncoder;
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        if (c() == null) {
            function1 = this.nodeConsumer;
        } else {
            function1 = new AbstractJsonTreeEncoder$beginStructure$consumer$1(this);
        }
        SerialKind kind = serialDescriptor.getKind();
        if (Intrinsics.areEqual((Object) kind, (Object) StructureKind.LIST.INSTANCE)) {
            z11 = true;
        } else {
            z11 = kind instanceof PolymorphicKind;
        }
        if (z11) {
            abstractJsonTreeEncoder = new JsonTreeListEncoder(this.json, function1);
        } else if (Intrinsics.areEqual((Object) kind, (Object) StructureKind.MAP.INSTANCE)) {
            Json json2 = this.json;
            SerialDescriptor carrierDescriptor = WriteModeKt.carrierDescriptor(serialDescriptor.getElementDescriptor(0), json2.getSerializersModule());
            SerialKind kind2 = carrierDescriptor.getKind();
            if ((kind2 instanceof PrimitiveKind) || Intrinsics.areEqual((Object) kind2, (Object) SerialKind.ENUM.INSTANCE)) {
                abstractJsonTreeEncoder = new JsonTreeMapEncoder(this.json, function1);
            } else if (json2.getConfiguration().getAllowStructuredMapKeys()) {
                abstractJsonTreeEncoder = new JsonTreeListEncoder(this.json, function1);
            } else {
                throw JsonExceptionsKt.InvalidKeyKindException(carrierDescriptor);
            }
        } else {
            abstractJsonTreeEncoder = new JsonTreeEncoder(this.json, function1);
        }
        String str = this.polymorphicDiscriminator;
        if (str != null) {
            Intrinsics.checkNotNull(str);
            abstractJsonTreeEncoder.putElement(str, JsonElementKt.JsonPrimitive(serialDescriptor.getSerialName()));
            this.polymorphicDiscriminator = null;
        }
        return abstractJsonTreeEncoder;
    }

    public void encodeJsonElement(@NotNull JsonElement jsonElement) {
        Intrinsics.checkNotNullParameter(jsonElement, "element");
        encodeSerializableValue(JsonElementSerializer.INSTANCE, jsonElement);
    }

    public void encodeNull() {
        String str = (String) c();
        if (str == null) {
            this.nodeConsumer.invoke(JsonNull.INSTANCE);
        } else {
            encodeTaggedNull(str);
        }
    }

    public <T> void encodeSerializableValue(@NotNull SerializationStrategy<? super T> serializationStrategy, T t11) {
        Intrinsics.checkNotNullParameter(serializationStrategy, "serializer");
        if (c() == null && TreeJsonEncoderKt.getRequiresTopLevelTag(WriteModeKt.carrierDescriptor(serializationStrategy.getDescriptor(), getSerializersModule()))) {
            JsonPrimitiveEncoder jsonPrimitiveEncoder = new JsonPrimitiveEncoder(this.json, this.nodeConsumer);
            jsonPrimitiveEncoder.encodeSerializableValue(serializationStrategy, t11);
            jsonPrimitiveEncoder.a(serializationStrategy.getDescriptor());
        } else if (!(serializationStrategy instanceof AbstractPolymorphicSerializer) || getJson().getConfiguration().getUseArrayPolymorphism()) {
            serializationStrategy.serialize(this, t11);
        } else {
            AbstractPolymorphicSerializer abstractPolymorphicSerializer = (AbstractPolymorphicSerializer) serializationStrategy;
            String classDiscriminator = PolymorphicKt.classDiscriminator(serializationStrategy.getDescriptor(), getJson());
            if (t11 != null) {
                SerializationStrategy findPolymorphicSerializer = PolymorphicSerializerKt.findPolymorphicSerializer(abstractPolymorphicSerializer, (Encoder) this, t11);
                PolymorphicKt.validateIfSealed(abstractPolymorphicSerializer, findPolymorphicSerializer, classDiscriminator);
                PolymorphicKt.checkKind(findPolymorphicSerializer.getDescriptor().getKind());
                this.polymorphicDiscriminator = classDiscriminator;
                findPolymorphicSerializer.serialize(this, t11);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Any");
        }
    }

    @NotNull
    public String f(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "parentName");
        Intrinsics.checkNotNullParameter(str2, "childName");
        return str2;
    }

    @NotNull
    public abstract JsonElement getCurrent();

    @NotNull
    public final Json getJson() {
        return this.json;
    }

    @NotNull
    public final SerializersModule getSerializersModule() {
        return this.json.getSerializersModule();
    }

    /* renamed from: j */
    public void encodeTaggedBoolean(@NotNull String str, boolean z11) {
        Intrinsics.checkNotNullParameter(str, "tag");
        putElement(str, JsonElementKt.JsonPrimitive(Boolean.valueOf(z11)));
    }

    /* renamed from: k */
    public void encodeTaggedByte(@NotNull String str, byte b11) {
        Intrinsics.checkNotNullParameter(str, "tag");
        putElement(str, JsonElementKt.JsonPrimitive((Number) Byte.valueOf(b11)));
    }

    /* renamed from: l */
    public void encodeTaggedChar(@NotNull String str, char c11) {
        Intrinsics.checkNotNullParameter(str, "tag");
        putElement(str, JsonElementKt.JsonPrimitive(String.valueOf(c11)));
    }

    /* renamed from: m */
    public void encodeTaggedDouble(@NotNull String str, double d11) {
        boolean z11;
        Intrinsics.checkNotNullParameter(str, "tag");
        putElement(str, JsonElementKt.JsonPrimitive((Number) Double.valueOf(d11)));
        if (!this.f26438a.getAllowSpecialFloatingPointValues()) {
            if (Double.isInfinite(d11) || Double.isNaN(d11)) {
                z11 = false;
            } else {
                z11 = true;
            }
            if (!z11) {
                throw JsonExceptionsKt.InvalidFloatingPointEncoded(Double.valueOf(d11), str, getCurrent().toString());
            }
        }
    }

    /* renamed from: n */
    public void encodeTaggedEnum(@NotNull String str, @NotNull SerialDescriptor serialDescriptor, int i11) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(serialDescriptor, "enumDescriptor");
        putElement(str, JsonElementKt.JsonPrimitive(serialDescriptor.getElementName(i11)));
    }

    /* renamed from: o */
    public void encodeTaggedFloat(@NotNull String str, float f11) {
        boolean z11;
        Intrinsics.checkNotNullParameter(str, "tag");
        putElement(str, JsonElementKt.JsonPrimitive((Number) Float.valueOf(f11)));
        if (!this.f26438a.getAllowSpecialFloatingPointValues()) {
            if (Float.isInfinite(f11) || Float.isNaN(f11)) {
                z11 = false;
            } else {
                z11 = true;
            }
            if (!z11) {
                throw JsonExceptionsKt.InvalidFloatingPointEncoded(Float.valueOf(f11), str, getCurrent().toString());
            }
        }
    }

    @NotNull
    /* renamed from: p */
    public Encoder encodeTaggedInline(@NotNull String str, @NotNull SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(serialDescriptor, "inlineDescriptor");
        if (StreamingJsonEncoderKt.isUnsignedNumber(serialDescriptor)) {
            return new AbstractJsonTreeEncoder$encodeTaggedInline$1(this, str);
        }
        return super.encodeTaggedInline(str, serialDescriptor);
    }

    public abstract void putElement(@NotNull String str, @NotNull JsonElement jsonElement);

    /* renamed from: q */
    public void encodeTaggedInt(@NotNull String str, int i11) {
        Intrinsics.checkNotNullParameter(str, "tag");
        putElement(str, JsonElementKt.JsonPrimitive((Number) Integer.valueOf(i11)));
    }

    /* renamed from: r */
    public void encodeTaggedLong(@NotNull String str, long j11) {
        Intrinsics.checkNotNullParameter(str, "tag");
        putElement(str, JsonElementKt.JsonPrimitive((Number) Long.valueOf(j11)));
    }

    /* renamed from: s */
    public void encodeTaggedNull(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "tag");
        putElement(str, JsonNull.INSTANCE);
    }

    public boolean shouldEncodeElementDefault(@NotNull SerialDescriptor serialDescriptor, int i11) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        return this.f26438a.getEncodeDefaults();
    }

    /* renamed from: t */
    public void encodeTaggedShort(@NotNull String str, short s11) {
        Intrinsics.checkNotNullParameter(str, "tag");
        putElement(str, JsonElementKt.JsonPrimitive((Number) Short.valueOf(s11)));
    }

    /* renamed from: u */
    public void encodeTaggedString(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(str2, "value");
        putElement(str, JsonElementKt.JsonPrimitive(str2));
    }

    /* renamed from: v */
    public void encodeTaggedValue(@NotNull String str, @NotNull Object obj) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(obj, "value");
        putElement(str, JsonElementKt.JsonPrimitive(obj.toString()));
    }
}
