package kotlinx.serialization.internal;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.InternalSerializationApi;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.modules.SerializersModule;
import kotlinx.serialization.modules.SerializersModuleKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b%\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b'\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\be\u0010fJ\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u001b\u0010\n\u001a\u00028\u0000*\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H$¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00020\rH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00020\u0016H\u0014¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00020\u0019H\u0014¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00020\u001cH\u0014¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010 \u001a\u00020\u000f2\u0006\u0010\f\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00020\u001fH\u0014¢\u0006\u0004\b \u0010!J\u001f\u0010#\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00020\"H\u0014¢\u0006\u0004\b#\u0010$J\u001f\u0010%\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00020\bH\u0014¢\u0006\u0004\b%\u0010&J\u001f\u0010(\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00020'H\u0014¢\u0006\u0004\b(\u0010)J\u001f\u0010+\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00020*H\u0014¢\u0006\u0004\b+\u0010,J'\u0010/\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00028\u00002\u0006\u0010-\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u0006H\u0014¢\u0006\u0004\b/\u00100J\u001f\u00102\u001a\u00020\u00022\u0006\u0010\f\u001a\u00028\u00002\u0006\u00101\u001a\u00020\u0004H\u0014¢\u0006\u0004\b2\u00103J\u000e\u00104\u001a\u00020\u00022\u0006\u00101\u001a\u00020\u0004J\u0006\u00105\u001a\u00020\u000fJ\b\u00106\u001a\u00020\u000fH\u0016J\u000e\u00107\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\bJ\u000e\u00108\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u0016J\u000e\u00109\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u0019J\u000e\u0010:\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u0006J\u000e\u0010;\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u001cJ\u000e\u0010<\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u001fJ\u000e\u0010=\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\"J\u000e\u0010>\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020'J\u000e\u0010?\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020*J\u0016\u0010@\u001a\u00020\u000f2\u0006\u0010-\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0010\u0010B\u001a\u00020\u00032\u0006\u0010A\u001a\u00020\u0004H\u0016J\u000e\u0010C\u001a\u00020\u000f2\u0006\u0010A\u001a\u00020\u0004J\u0010\u0010D\u001a\u00020\u000f2\u0006\u0010A\u001a\u00020\u0004H\u0014J\u001e\u0010E\u001a\u00020\u000f2\u0006\u0010A\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\bJ\u001e\u0010F\u001a\u00020\u000f2\u0006\u0010A\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0016J\u001e\u0010G\u001a\u00020\u000f2\u0006\u0010A\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0019J\u001e\u0010H\u001a\u00020\u000f2\u0006\u0010A\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006J\u001e\u0010I\u001a\u00020\u000f2\u0006\u0010A\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u001cJ\u001e\u0010J\u001a\u00020\u000f2\u0006\u0010A\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u001fJ\u001e\u0010K\u001a\u00020\u000f2\u0006\u0010A\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\"J\u001e\u0010L\u001a\u00020\u000f2\u0006\u0010A\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020'J\u001e\u0010M\u001a\u00020\u000f2\u0006\u0010A\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020*J\u0016\u0010N\u001a\u00020\u00022\u0006\u0010A\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J;\u0010R\u001a\u00020\u000f\"\u0004\b\u0001\u0010O2\u0006\u0010A\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010Q\u001a\b\u0012\u0004\u0012\u00028\u00010P2\u0006\u0010\u000e\u001a\u00028\u0001H\u0016¢\u0006\u0004\bR\u0010SJA\u0010T\u001a\u00020\u000f\"\b\b\u0001\u0010O*\u00020\r2\u0006\u0010A\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010Q\u001a\b\u0012\u0004\u0012\u00028\u00010P2\b\u0010\u000e\u001a\u0004\u0018\u00018\u0001H\u0016¢\u0006\u0004\bT\u0010SJ\u0017\u0010V\u001a\u00020\u000f2\u0006\u0010U\u001a\u00028\u0000H\u0004¢\u0006\u0004\bV\u0010\u0013J\u000f\u0010W\u001a\u00028\u0000H\u0004¢\u0006\u0004\bW\u0010XR$\u0010[\u001a\u0012\u0012\u0004\u0012\u00028\u00000Yj\b\u0012\u0004\u0012\u00028\u0000`Z8\u0002X\u0004¢\u0006\u0006\n\u0004\b[\u0010\\R\u0014\u0010`\u001a\u00020]8VX\u0004¢\u0006\u0006\u001a\u0004\b^\u0010_R\u0014\u0010b\u001a\u00028\u00008DX\u0004¢\u0006\u0006\u001a\u0004\ba\u0010XR\u0016\u0010d\u001a\u0004\u0018\u00018\u00008DX\u0004¢\u0006\u0006\u001a\u0004\bc\u0010X¨\u0006g"}, d2 = {"Lkotlinx/serialization/internal/TaggedEncoder;", "Tag", "Lkotlinx/serialization/encoding/Encoder;", "Lkotlinx/serialization/encoding/CompositeEncoder;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "desc", "", "index", "", "encodeElement", "getTag", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Ljava/lang/Object;", "tag", "", "value", "", "encodeTaggedValue", "(Ljava/lang/Object;Ljava/lang/Object;)V", "encodeTaggedNull", "(Ljava/lang/Object;)V", "encodeTaggedInt", "(Ljava/lang/Object;I)V", "", "encodeTaggedByte", "(Ljava/lang/Object;B)V", "", "encodeTaggedShort", "(Ljava/lang/Object;S)V", "", "encodeTaggedLong", "(Ljava/lang/Object;J)V", "", "encodeTaggedFloat", "(Ljava/lang/Object;F)V", "", "encodeTaggedDouble", "(Ljava/lang/Object;D)V", "encodeTaggedBoolean", "(Ljava/lang/Object;Z)V", "", "encodeTaggedChar", "(Ljava/lang/Object;C)V", "", "encodeTaggedString", "(Ljava/lang/Object;Ljava/lang/String;)V", "enumDescriptor", "ordinal", "encodeTaggedEnum", "(Ljava/lang/Object;Lkotlinx/serialization/descriptors/SerialDescriptor;I)V", "inlineDescriptor", "encodeTaggedInline", "(Ljava/lang/Object;Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/encoding/Encoder;", "encodeInline", "encodeNotNullMark", "encodeNull", "encodeBoolean", "encodeByte", "encodeShort", "encodeInt", "encodeLong", "encodeFloat", "encodeDouble", "encodeChar", "encodeString", "encodeEnum", "descriptor", "beginStructure", "endStructure", "a", "encodeBooleanElement", "encodeByteElement", "encodeShortElement", "encodeIntElement", "encodeLongElement", "encodeFloatElement", "encodeDoubleElement", "encodeCharElement", "encodeStringElement", "encodeInlineElement", "T", "Lkotlinx/serialization/SerializationStrategy;", "serializer", "encodeSerializableElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;ILkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)V", "encodeNullableSerializableElement", "name", "e", "d", "()Ljava/lang/Object;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "tagStack", "Ljava/util/ArrayList;", "Lkotlinx/serialization/modules/SerializersModule;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "serializersModule", "b", "currentTag", "c", "currentTagOrNull", "<init>", "()V", "kotlinx-serialization-core"}, k = 1, mv = {1, 6, 0})
@InternalSerializationApi
public abstract class TaggedEncoder<Tag> implements Encoder, CompositeEncoder {
    @NotNull
    private final ArrayList<Tag> tagStack = new ArrayList<>();

    private final boolean encodeElement(SerialDescriptor serialDescriptor, int i11) {
        e(getTag(serialDescriptor, i11));
        return true;
    }

    public void a(@NotNull SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
    }

    public final Tag b() {
        return CollectionsKt___CollectionsKt.last(this.tagStack);
    }

    @NotNull
    public CompositeEncoder beginCollection(@NotNull SerialDescriptor serialDescriptor, int i11) {
        return Encoder.DefaultImpls.beginCollection(this, serialDescriptor, i11);
    }

    @NotNull
    public CompositeEncoder beginStructure(@NotNull SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        return this;
    }

    @Nullable
    public final Tag c() {
        return CollectionsKt___CollectionsKt.lastOrNull(this.tagStack);
    }

    public final Tag d() {
        if (!this.tagStack.isEmpty()) {
            ArrayList<Tag> arrayList = this.tagStack;
            return arrayList.remove(CollectionsKt__CollectionsKt.getLastIndex(arrayList));
        }
        throw new SerializationException("No tag in stack for requested element");
    }

    public final void e(Tag tag) {
        this.tagStack.add(tag);
    }

    public final void encodeBoolean(boolean z11) {
        encodeTaggedBoolean(d(), z11);
    }

    public final void encodeBooleanElement(@NotNull SerialDescriptor serialDescriptor, int i11, boolean z11) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        encodeTaggedBoolean(getTag(serialDescriptor, i11), z11);
    }

    public final void encodeByte(byte b11) {
        encodeTaggedByte(d(), b11);
    }

    public final void encodeByteElement(@NotNull SerialDescriptor serialDescriptor, int i11, byte b11) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        encodeTaggedByte(getTag(serialDescriptor, i11), b11);
    }

    public final void encodeChar(char c11) {
        encodeTaggedChar(d(), c11);
    }

    public final void encodeCharElement(@NotNull SerialDescriptor serialDescriptor, int i11, char c11) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        encodeTaggedChar(getTag(serialDescriptor, i11), c11);
    }

    public final void encodeDouble(double d11) {
        encodeTaggedDouble(d(), d11);
    }

    public final void encodeDoubleElement(@NotNull SerialDescriptor serialDescriptor, int i11, double d11) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        encodeTaggedDouble(getTag(serialDescriptor, i11), d11);
    }

    public final void encodeEnum(@NotNull SerialDescriptor serialDescriptor, int i11) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "enumDescriptor");
        encodeTaggedEnum(d(), serialDescriptor, i11);
    }

    public final void encodeFloat(float f11) {
        encodeTaggedFloat(d(), f11);
    }

    public final void encodeFloatElement(@NotNull SerialDescriptor serialDescriptor, int i11, float f11) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        encodeTaggedFloat(getTag(serialDescriptor, i11), f11);
    }

    @NotNull
    public final Encoder encodeInline(@NotNull SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "inlineDescriptor");
        return encodeTaggedInline(d(), serialDescriptor);
    }

    @NotNull
    public final Encoder encodeInlineElement(@NotNull SerialDescriptor serialDescriptor, int i11) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        return encodeTaggedInline(getTag(serialDescriptor, i11), serialDescriptor.getElementDescriptor(i11));
    }

    public final void encodeInt(int i11) {
        encodeTaggedInt(d(), i11);
    }

    public final void encodeIntElement(@NotNull SerialDescriptor serialDescriptor, int i11, int i12) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        encodeTaggedInt(getTag(serialDescriptor, i11), i12);
    }

    public final void encodeLong(long j11) {
        encodeTaggedLong(d(), j11);
    }

    public final void encodeLongElement(@NotNull SerialDescriptor serialDescriptor, int i11, long j11) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        encodeTaggedLong(getTag(serialDescriptor, i11), j11);
    }

    public final void encodeNotNullMark() {
    }

    public void encodeNull() {
        encodeTaggedNull(d());
    }

    public <T> void encodeNullableSerializableElement(@NotNull SerialDescriptor serialDescriptor, int i11, @NotNull SerializationStrategy<? super T> serializationStrategy, @Nullable T t11) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        Intrinsics.checkNotNullParameter(serializationStrategy, "serializer");
        if (encodeElement(serialDescriptor, i11)) {
            encodeNullableSerializableValue(serializationStrategy, t11);
        }
    }

    @ExperimentalSerializationApi
    public <T> void encodeNullableSerializableValue(@NotNull SerializationStrategy<? super T> serializationStrategy, @Nullable T t11) {
        Encoder.DefaultImpls.encodeNullableSerializableValue(this, serializationStrategy, t11);
    }

    public <T> void encodeSerializableElement(@NotNull SerialDescriptor serialDescriptor, int i11, @NotNull SerializationStrategy<? super T> serializationStrategy, T t11) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        Intrinsics.checkNotNullParameter(serializationStrategy, "serializer");
        if (encodeElement(serialDescriptor, i11)) {
            encodeSerializableValue(serializationStrategy, t11);
        }
    }

    public <T> void encodeSerializableValue(@NotNull SerializationStrategy<? super T> serializationStrategy, T t11) {
        Encoder.DefaultImpls.encodeSerializableValue(this, serializationStrategy, t11);
    }

    public final void encodeShort(short s11) {
        encodeTaggedShort(d(), s11);
    }

    public final void encodeShortElement(@NotNull SerialDescriptor serialDescriptor, int i11, short s11) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        encodeTaggedShort(getTag(serialDescriptor, i11), s11);
    }

    public final void encodeString(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        encodeTaggedString(d(), str);
    }

    public final void encodeStringElement(@NotNull SerialDescriptor serialDescriptor, int i11, @NotNull String str) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        Intrinsics.checkNotNullParameter(str, "value");
        encodeTaggedString(getTag(serialDescriptor, i11), str);
    }

    public void encodeTaggedBoolean(Tag tag, boolean z11) {
        encodeTaggedValue(tag, Boolean.valueOf(z11));
    }

    public void encodeTaggedByte(Tag tag, byte b11) {
        encodeTaggedValue(tag, Byte.valueOf(b11));
    }

    public void encodeTaggedChar(Tag tag, char c11) {
        encodeTaggedValue(tag, Character.valueOf(c11));
    }

    public void encodeTaggedDouble(Tag tag, double d11) {
        encodeTaggedValue(tag, Double.valueOf(d11));
    }

    public void encodeTaggedEnum(Tag tag, @NotNull SerialDescriptor serialDescriptor, int i11) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "enumDescriptor");
        encodeTaggedValue(tag, Integer.valueOf(i11));
    }

    public void encodeTaggedFloat(Tag tag, float f11) {
        encodeTaggedValue(tag, Float.valueOf(f11));
    }

    @NotNull
    public Encoder encodeTaggedInline(Tag tag, @NotNull SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "inlineDescriptor");
        e(tag);
        return this;
    }

    public void encodeTaggedInt(Tag tag, int i11) {
        encodeTaggedValue(tag, Integer.valueOf(i11));
    }

    public void encodeTaggedLong(Tag tag, long j11) {
        encodeTaggedValue(tag, Long.valueOf(j11));
    }

    public void encodeTaggedNull(Tag tag) {
        throw new SerializationException("null is not supported");
    }

    public void encodeTaggedShort(Tag tag, short s11) {
        encodeTaggedValue(tag, Short.valueOf(s11));
    }

    public void encodeTaggedString(Tag tag, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        encodeTaggedValue(tag, str);
    }

    public void encodeTaggedValue(Tag tag, @NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "value");
        throw new SerializationException("Non-serializable " + Reflection.getOrCreateKotlinClass(obj.getClass()) + " is not supported by " + Reflection.getOrCreateKotlinClass(getClass()) + " encoder");
    }

    public final void endStructure(@NotNull SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        if (!this.tagStack.isEmpty()) {
            d();
        }
        a(serialDescriptor);
    }

    @NotNull
    public SerializersModule getSerializersModule() {
        return SerializersModuleKt.getEmptySerializersModule();
    }

    public abstract Tag getTag(@NotNull SerialDescriptor serialDescriptor, int i11);

    @ExperimentalSerializationApi
    public boolean shouldEncodeElementDefault(@NotNull SerialDescriptor serialDescriptor, int i11) {
        return CompositeEncoder.DefaultImpls.shouldEncodeElementDefault(this, serialDescriptor, i11);
    }
}
