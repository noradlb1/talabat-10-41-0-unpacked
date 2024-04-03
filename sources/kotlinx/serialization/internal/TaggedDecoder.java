package kotlinx.serialization.internal;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.InternalSerializationApi;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.modules.SerializersModule;
import kotlinx.serialization.modules.SerializersModuleKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0001\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b'\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\bi\u0010jJ+\u0010\b\u001a\u00028\u0001\"\u0004\b\u0001\u0010\u00042\u0006\u0010\u0005\u001a\u00028\u00002\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\r\u001a\u00028\u0000*\u00020\n2\u0006\u0010\f\u001a\u00020\u000bH$¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u0015\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0005\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0005\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010\"\u001a\u00020!2\u0006\u0010\u0005\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\"\u0010#J\u0017\u0010%\u001a\u00020$2\u0006\u0010\u0005\u001a\u00028\u0000H\u0014¢\u0006\u0004\b%\u0010&J\u0017\u0010(\u001a\u00020'2\u0006\u0010\u0005\u001a\u00028\u0000H\u0014¢\u0006\u0004\b(\u0010)J\u0017\u0010+\u001a\u00020*2\u0006\u0010\u0005\u001a\u00028\u0000H\u0014¢\u0006\u0004\b+\u0010,J\u001f\u0010.\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010-\u001a\u00020\nH\u0014¢\u0006\u0004\b.\u0010/J\u001f\u00101\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u00100\u001a\u00020\nH\u0014¢\u0006\u0004\b1\u00102J-\u00107\u001a\u00028\u0001\"\u0004\b\u0001\u001032\f\u00105\u001a\b\u0012\u0004\u0012\u00028\u0001042\b\u00106\u001a\u0004\u0018\u00018\u0001H\u0014¢\u0006\u0004\b7\u00108J\u000e\u00109\u001a\u00020\u00022\u0006\u00100\u001a\u00020\nJ\b\u0010:\u001a\u00020\u0012H\u0016J\b\u0010<\u001a\u0004\u0018\u00010;J\u0006\u0010=\u001a\u00020\u0012J\u0006\u0010>\u001a\u00020\u0016J\u0006\u0010?\u001a\u00020\u0019J\u0006\u0010@\u001a\u00020\u000bJ\u0006\u0010A\u001a\u00020\u001eJ\u0006\u0010B\u001a\u00020!J\u0006\u0010C\u001a\u00020$J\u0006\u0010D\u001a\u00020'J\u0006\u0010E\u001a\u00020*J\u000e\u0010F\u001a\u00020\u000b2\u0006\u0010-\u001a\u00020\nJ\u0010\u0010H\u001a\u00020\u00032\u0006\u0010G\u001a\u00020\nH\u0016J\u0010\u0010J\u001a\u00020I2\u0006\u0010G\u001a\u00020\nH\u0016J\u0016\u0010K\u001a\u00020\u00122\u0006\u0010G\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u000bJ\u0016\u0010L\u001a\u00020\u00162\u0006\u0010G\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u000bJ\u0016\u0010M\u001a\u00020\u00192\u0006\u0010G\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u000bJ\u0016\u0010N\u001a\u00020\u000b2\u0006\u0010G\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u000bJ\u0016\u0010O\u001a\u00020\u001e2\u0006\u0010G\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u000bJ\u0016\u0010P\u001a\u00020!2\u0006\u0010G\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u000bJ\u0016\u0010Q\u001a\u00020$2\u0006\u0010G\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u000bJ\u0016\u0010R\u001a\u00020'2\u0006\u0010G\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u000bJ\u0016\u0010S\u001a\u00020*2\u0006\u0010G\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u000bJ\u0016\u0010T\u001a\u00020\u00022\u0006\u0010G\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u000bJ;\u0010U\u001a\u00028\u0001\"\u0004\b\u0001\u001032\u0006\u0010G\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u000b2\f\u00105\u001a\b\u0012\u0004\u0012\u00028\u0001042\b\u00106\u001a\u0004\u0018\u00018\u0001¢\u0006\u0004\bU\u0010VJC\u0010W\u001a\u0004\u0018\u00018\u0001\"\b\b\u0001\u00103*\u00020\u000f2\u0006\u0010G\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u000b2\u000e\u00105\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u0001042\b\u00106\u001a\u0004\u0018\u00018\u0001¢\u0006\u0004\bW\u0010VJ\u0017\u0010Y\u001a\u00020I2\u0006\u0010X\u001a\u00028\u0000H\u0004¢\u0006\u0004\bY\u0010ZJ\u000f\u0010[\u001a\u00028\u0000H\u0004¢\u0006\u0004\b[\u0010\\R$\u0010_\u001a\u0012\u0012\u0004\u0012\u00028\u00000]j\b\u0012\u0004\u0012\u00028\u0000`^8\u0002X\u0004¢\u0006\u0006\n\u0004\b_\u0010`R\u0016\u0010a\u001a\u00020\u00128\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\ba\u0010bR\u0014\u0010f\u001a\u00020c8VX\u0004¢\u0006\u0006\u001a\u0004\bd\u0010eR\u0016\u0010h\u001a\u0004\u0018\u00018\u00008DX\u0004¢\u0006\u0006\u001a\u0004\bg\u0010\\¨\u0006k"}, d2 = {"Lkotlinx/serialization/internal/TaggedDecoder;", "Tag", "Lkotlinx/serialization/encoding/Decoder;", "Lkotlinx/serialization/encoding/CompositeDecoder;", "E", "tag", "Lkotlin/Function0;", "block", "tagBlock", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "", "index", "getTag", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Ljava/lang/Object;", "", "b", "(Ljava/lang/Object;)Ljava/lang/Object;", "", "decodeTaggedNotNullMark", "(Ljava/lang/Object;)Z", "decodeTaggedBoolean", "", "decodeTaggedByte", "(Ljava/lang/Object;)B", "", "decodeTaggedShort", "(Ljava/lang/Object;)S", "decodeTaggedInt", "(Ljava/lang/Object;)I", "", "decodeTaggedLong", "(Ljava/lang/Object;)J", "", "decodeTaggedFloat", "(Ljava/lang/Object;)F", "", "decodeTaggedDouble", "(Ljava/lang/Object;)D", "", "decodeTaggedChar", "(Ljava/lang/Object;)C", "", "decodeTaggedString", "(Ljava/lang/Object;)Ljava/lang/String;", "enumDescriptor", "decodeTaggedEnum", "(Ljava/lang/Object;Lkotlinx/serialization/descriptors/SerialDescriptor;)I", "inlineDescriptor", "decodeTaggedInline", "(Ljava/lang/Object;Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/encoding/Decoder;", "T", "Lkotlinx/serialization/DeserializationStrategy;", "deserializer", "previousValue", "a", "(Lkotlinx/serialization/DeserializationStrategy;Ljava/lang/Object;)Ljava/lang/Object;", "decodeInline", "decodeNotNullMark", "", "decodeNull", "decodeBoolean", "decodeByte", "decodeShort", "decodeInt", "decodeLong", "decodeFloat", "decodeDouble", "decodeChar", "decodeString", "decodeEnum", "descriptor", "beginStructure", "", "endStructure", "decodeBooleanElement", "decodeByteElement", "decodeShortElement", "decodeIntElement", "decodeLongElement", "decodeFloatElement", "decodeDoubleElement", "decodeCharElement", "decodeStringElement", "decodeInlineElement", "decodeSerializableElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;ILkotlinx/serialization/DeserializationStrategy;Ljava/lang/Object;)Ljava/lang/Object;", "decodeNullableSerializableElement", "name", "e", "(Ljava/lang/Object;)V", "d", "()Ljava/lang/Object;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "tagStack", "Ljava/util/ArrayList;", "flag", "Z", "Lkotlinx/serialization/modules/SerializersModule;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "serializersModule", "c", "currentTagOrNull", "<init>", "()V", "kotlinx-serialization-core"}, k = 1, mv = {1, 6, 0})
@InternalSerializationApi
public abstract class TaggedDecoder<Tag> implements Decoder, CompositeDecoder {
    private boolean flag;
    @NotNull
    private final ArrayList<Tag> tagStack = new ArrayList<>();

    private final <E> E tagBlock(Tag tag, Function0<? extends E> function0) {
        e(tag);
        E invoke = function0.invoke();
        if (!this.flag) {
            d();
        }
        this.flag = false;
        return invoke;
    }

    public <T> T a(@NotNull DeserializationStrategy<T> deserializationStrategy, @Nullable T t11) {
        Intrinsics.checkNotNullParameter(deserializationStrategy, "deserializer");
        return decodeSerializableValue(deserializationStrategy);
    }

    @NotNull
    public Object b(Tag tag) {
        throw new SerializationException(Reflection.getOrCreateKotlinClass(getClass()) + " can't retrieve untyped values");
    }

    @NotNull
    public CompositeDecoder beginStructure(@NotNull SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        return this;
    }

    @Nullable
    public final Tag c() {
        return CollectionsKt___CollectionsKt.lastOrNull(this.tagStack);
    }

    public final Tag d() {
        ArrayList<Tag> arrayList = this.tagStack;
        Tag remove = arrayList.remove(CollectionsKt__CollectionsKt.getLastIndex(arrayList));
        this.flag = true;
        return remove;
    }

    public final boolean decodeBoolean() {
        return decodeTaggedBoolean(d());
    }

    public final boolean decodeBooleanElement(@NotNull SerialDescriptor serialDescriptor, int i11) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        return decodeTaggedBoolean(getTag(serialDescriptor, i11));
    }

    public final byte decodeByte() {
        return decodeTaggedByte(d());
    }

    public final byte decodeByteElement(@NotNull SerialDescriptor serialDescriptor, int i11) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        return decodeTaggedByte(getTag(serialDescriptor, i11));
    }

    public final char decodeChar() {
        return decodeTaggedChar(d());
    }

    public final char decodeCharElement(@NotNull SerialDescriptor serialDescriptor, int i11) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        return decodeTaggedChar(getTag(serialDescriptor, i11));
    }

    public int decodeCollectionSize(@NotNull SerialDescriptor serialDescriptor) {
        return CompositeDecoder.DefaultImpls.decodeCollectionSize(this, serialDescriptor);
    }

    public final double decodeDouble() {
        return decodeTaggedDouble(d());
    }

    public final double decodeDoubleElement(@NotNull SerialDescriptor serialDescriptor, int i11) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        return decodeTaggedDouble(getTag(serialDescriptor, i11));
    }

    public final int decodeEnum(@NotNull SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "enumDescriptor");
        return decodeTaggedEnum(d(), serialDescriptor);
    }

    public final float decodeFloat() {
        return decodeTaggedFloat(d());
    }

    public final float decodeFloatElement(@NotNull SerialDescriptor serialDescriptor, int i11) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        return decodeTaggedFloat(getTag(serialDescriptor, i11));
    }

    @NotNull
    public final Decoder decodeInline(@NotNull SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "inlineDescriptor");
        return decodeTaggedInline(d(), serialDescriptor);
    }

    @NotNull
    public final Decoder decodeInlineElement(@NotNull SerialDescriptor serialDescriptor, int i11) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        return decodeTaggedInline(getTag(serialDescriptor, i11), serialDescriptor.getElementDescriptor(i11));
    }

    public final int decodeInt() {
        return decodeTaggedInt(d());
    }

    public final int decodeIntElement(@NotNull SerialDescriptor serialDescriptor, int i11) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        return decodeTaggedInt(getTag(serialDescriptor, i11));
    }

    public final long decodeLong() {
        return decodeTaggedLong(d());
    }

    public final long decodeLongElement(@NotNull SerialDescriptor serialDescriptor, int i11) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        return decodeTaggedLong(getTag(serialDescriptor, i11));
    }

    public boolean decodeNotNullMark() {
        Object c11 = c();
        if (c11 == null) {
            return false;
        }
        return decodeTaggedNotNullMark(c11);
    }

    @Nullable
    public final Void decodeNull() {
        return null;
    }

    @Nullable
    public final <T> T decodeNullableSerializableElement(@NotNull SerialDescriptor serialDescriptor, int i11, @NotNull DeserializationStrategy<T> deserializationStrategy, @Nullable T t11) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        Intrinsics.checkNotNullParameter(deserializationStrategy, "deserializer");
        return tagBlock(getTag(serialDescriptor, i11), new TaggedDecoder$decodeNullableSerializableElement$1(this, deserializationStrategy, t11));
    }

    @ExperimentalSerializationApi
    @Nullable
    public <T> T decodeNullableSerializableValue(@NotNull DeserializationStrategy<T> deserializationStrategy) {
        return Decoder.DefaultImpls.decodeNullableSerializableValue(this, deserializationStrategy);
    }

    @ExperimentalSerializationApi
    public boolean decodeSequentially() {
        return CompositeDecoder.DefaultImpls.decodeSequentially(this);
    }

    public final <T> T decodeSerializableElement(@NotNull SerialDescriptor serialDescriptor, int i11, @NotNull DeserializationStrategy<T> deserializationStrategy, @Nullable T t11) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        Intrinsics.checkNotNullParameter(deserializationStrategy, "deserializer");
        return tagBlock(getTag(serialDescriptor, i11), new TaggedDecoder$decodeSerializableElement$1(this, deserializationStrategy, t11));
    }

    public <T> T decodeSerializableValue(@NotNull DeserializationStrategy<T> deserializationStrategy) {
        return Decoder.DefaultImpls.decodeSerializableValue(this, deserializationStrategy);
    }

    public final short decodeShort() {
        return decodeTaggedShort(d());
    }

    public final short decodeShortElement(@NotNull SerialDescriptor serialDescriptor, int i11) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        return decodeTaggedShort(getTag(serialDescriptor, i11));
    }

    @NotNull
    public final String decodeString() {
        return decodeTaggedString(d());
    }

    @NotNull
    public final String decodeStringElement(@NotNull SerialDescriptor serialDescriptor, int i11) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        return decodeTaggedString(getTag(serialDescriptor, i11));
    }

    public boolean decodeTaggedBoolean(Tag tag) {
        return ((Boolean) b(tag)).booleanValue();
    }

    public byte decodeTaggedByte(Tag tag) {
        return ((Byte) b(tag)).byteValue();
    }

    public char decodeTaggedChar(Tag tag) {
        return ((Character) b(tag)).charValue();
    }

    public double decodeTaggedDouble(Tag tag) {
        return ((Double) b(tag)).doubleValue();
    }

    public int decodeTaggedEnum(Tag tag, @NotNull SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "enumDescriptor");
        return ((Integer) b(tag)).intValue();
    }

    public float decodeTaggedFloat(Tag tag) {
        return ((Float) b(tag)).floatValue();
    }

    @NotNull
    public Decoder decodeTaggedInline(Tag tag, @NotNull SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "inlineDescriptor");
        e(tag);
        return this;
    }

    public int decodeTaggedInt(Tag tag) {
        return ((Integer) b(tag)).intValue();
    }

    public long decodeTaggedLong(Tag tag) {
        return ((Long) b(tag)).longValue();
    }

    public boolean decodeTaggedNotNullMark(Tag tag) {
        return true;
    }

    public short decodeTaggedShort(Tag tag) {
        return ((Short) b(tag)).shortValue();
    }

    @NotNull
    public String decodeTaggedString(Tag tag) {
        return (String) b(tag);
    }

    public final void e(Tag tag) {
        this.tagStack.add(tag);
    }

    public void endStructure(@NotNull SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
    }

    @NotNull
    public SerializersModule getSerializersModule() {
        return SerializersModuleKt.getEmptySerializersModule();
    }

    public abstract Tag getTag(@NotNull SerialDescriptor serialDescriptor, int i11);
}
