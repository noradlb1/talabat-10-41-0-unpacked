package kotlinx.serialization.internal;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.descriptors.StructureKind;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001B\u001f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0001¢\u0006\u0002\u0010\u0006J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\u001b\u001a\u00020\bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\bH\u0016J\u0010\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u0003H\u0016J\u0010\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\bH\u0016J\b\u0010 \u001a\u00020\bH\u0016J\u0010\u0010!\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\bH\u0016J\b\u0010\"\u001a\u00020\u0003H\u0016R\u0014\u0010\u0007\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000e8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\f\u0001\u0002#$¨\u0006%"}, d2 = {"Lkotlinx/serialization/internal/MapLikeDescriptor;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialName", "", "keyDescriptor", "valueDescriptor", "(Ljava/lang/String;Lkotlinx/serialization/descriptors/SerialDescriptor;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "elementsCount", "", "getElementsCount", "()I", "getKeyDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "kind", "Lkotlinx/serialization/descriptors/SerialKind;", "getKind", "()Lkotlinx/serialization/descriptors/SerialKind;", "getSerialName", "()Ljava/lang/String;", "getValueDescriptor", "equals", "", "other", "", "getElementAnnotations", "", "", "index", "getElementDescriptor", "getElementIndex", "name", "getElementName", "hashCode", "isElementOptional", "toString", "Lkotlinx/serialization/internal/LinkedHashMapClassDesc;", "Lkotlinx/serialization/internal/HashMapClassDesc;", "kotlinx-serialization-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class MapLikeDescriptor implements SerialDescriptor {
    private final int elementsCount;
    @NotNull
    private final SerialDescriptor keyDescriptor;
    @NotNull
    private final String serialName;
    @NotNull
    private final SerialDescriptor valueDescriptor;

    private MapLikeDescriptor(String str, SerialDescriptor serialDescriptor, SerialDescriptor serialDescriptor2) {
        this.serialName = str;
        this.keyDescriptor = serialDescriptor;
        this.valueDescriptor = serialDescriptor2;
        this.elementsCount = 2;
    }

    public /* synthetic */ MapLikeDescriptor(String str, SerialDescriptor serialDescriptor, SerialDescriptor serialDescriptor2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, serialDescriptor, serialDescriptor2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MapLikeDescriptor)) {
            return false;
        }
        MapLikeDescriptor mapLikeDescriptor = (MapLikeDescriptor) obj;
        if (Intrinsics.areEqual((Object) getSerialName(), (Object) mapLikeDescriptor.getSerialName()) && Intrinsics.areEqual((Object) this.keyDescriptor, (Object) mapLikeDescriptor.keyDescriptor) && Intrinsics.areEqual((Object) this.valueDescriptor, (Object) mapLikeDescriptor.valueDescriptor)) {
            return true;
        }
        return false;
    }

    @NotNull
    public List<Annotation> getAnnotations() {
        return SerialDescriptor.DefaultImpls.getAnnotations(this);
    }

    @NotNull
    public List<Annotation> getElementAnnotations(int i11) {
        boolean z11;
        if (i11 >= 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        throw new IllegalArgumentException(("Illegal index " + i11 + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + getSerialName() + " expects only non-negative indices").toString());
    }

    @NotNull
    public SerialDescriptor getElementDescriptor(int i11) {
        boolean z11;
        if (i11 >= 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            int i12 = i11 % 2;
            if (i12 == 0) {
                return this.keyDescriptor;
            }
            if (i12 == 1) {
                return this.valueDescriptor;
            }
            throw new IllegalStateException("Unreached".toString());
        }
        throw new IllegalArgumentException(("Illegal index " + i11 + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + getSerialName() + " expects only non-negative indices").toString());
    }

    public int getElementIndex(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        Integer intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(str);
        if (intOrNull != null) {
            return intOrNull.intValue();
        }
        throw new IllegalArgumentException(str + " is not a valid map index");
    }

    @NotNull
    public String getElementName(int i11) {
        return String.valueOf(i11);
    }

    public int getElementsCount() {
        return this.elementsCount;
    }

    @NotNull
    public final SerialDescriptor getKeyDescriptor() {
        return this.keyDescriptor;
    }

    @NotNull
    public SerialKind getKind() {
        return StructureKind.MAP.INSTANCE;
    }

    @NotNull
    public String getSerialName() {
        return this.serialName;
    }

    @NotNull
    public final SerialDescriptor getValueDescriptor() {
        return this.valueDescriptor;
    }

    public int hashCode() {
        return (((getSerialName().hashCode() * 31) + this.keyDescriptor.hashCode()) * 31) + this.valueDescriptor.hashCode();
    }

    public boolean isElementOptional(int i11) {
        if (i11 >= 0) {
            return false;
        }
        throw new IllegalArgumentException(("Illegal index " + i11 + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + getSerialName() + " expects only non-negative indices").toString());
    }

    public boolean isInline() {
        return SerialDescriptor.DefaultImpls.isInline(this);
    }

    public boolean isNullable() {
        return SerialDescriptor.DefaultImpls.isNullable(this);
    }

    @NotNull
    public String toString() {
        return getSerialName() + '(' + this.keyDescriptor + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + this.valueDescriptor + ')';
    }
}
