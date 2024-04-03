package kotlinx.serialization.internal;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0001¢\u0006\u0002\u0010\u0004J\u0013\u0010 \u001a\u00020\u000f2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0002J\u0017\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010$\u001a\u00020\u000bH\u0001J\u0011\u0010%\u001a\u00020\u00012\u0006\u0010$\u001a\u00020\u000bH\u0001J\u0011\u0010&\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020\u0019H\u0001J\u0011\u0010(\u001a\u00020\u00192\u0006\u0010$\u001a\u00020\u000bH\u0001J\b\u0010)\u001a\u00020\u000bH\u0016J\u0011\u0010*\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020\u000bH\u0001J\b\u0010+\u001a\u00020\u0019H\u0016R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068VX\u0005¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000b8\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000f8VX\u0005¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u000f8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00138\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0003\u001a\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u001dX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u0006,"}, d2 = {"Lkotlinx/serialization/internal/SerialDescriptorForNullable;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "Lkotlinx/serialization/internal/CachedNames;", "original", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "elementsCount", "", "getElementsCount", "()I", "isInline", "", "()Z", "isNullable", "kind", "Lkotlinx/serialization/descriptors/SerialKind;", "getKind", "()Lkotlinx/serialization/descriptors/SerialKind;", "getOriginal$kotlinx_serialization_core", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialName", "", "getSerialName", "()Ljava/lang/String;", "serialNames", "", "getSerialNames", "()Ljava/util/Set;", "equals", "other", "", "getElementAnnotations", "index", "getElementDescriptor", "getElementIndex", "name", "getElementName", "hashCode", "isElementOptional", "toString", "kotlinx-serialization-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SerialDescriptorForNullable implements SerialDescriptor, CachedNames {
    @NotNull
    private final SerialDescriptor original;
    @NotNull
    private final String serialName;
    @NotNull
    private final Set<String> serialNames;

    public SerialDescriptorForNullable(@NotNull SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "original");
        this.original = serialDescriptor;
        this.serialName = serialDescriptor.getSerialName() + '?';
        this.serialNames = Platform_commonKt.cachedSerialNames(serialDescriptor);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof SerialDescriptorForNullable) && Intrinsics.areEqual((Object) this.original, (Object) ((SerialDescriptorForNullable) obj).original)) {
            return true;
        }
        return false;
    }

    @NotNull
    public List<Annotation> getAnnotations() {
        return this.original.getAnnotations();
    }

    @ExperimentalSerializationApi
    @NotNull
    public List<Annotation> getElementAnnotations(int i11) {
        return this.original.getElementAnnotations(i11);
    }

    @ExperimentalSerializationApi
    @NotNull
    public SerialDescriptor getElementDescriptor(int i11) {
        return this.original.getElementDescriptor(i11);
    }

    @ExperimentalSerializationApi
    public int getElementIndex(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        return this.original.getElementIndex(str);
    }

    @ExperimentalSerializationApi
    @NotNull
    public String getElementName(int i11) {
        return this.original.getElementName(i11);
    }

    public int getElementsCount() {
        return this.original.getElementsCount();
    }

    @NotNull
    public SerialKind getKind() {
        return this.original.getKind();
    }

    @NotNull
    public final SerialDescriptor getOriginal$kotlinx_serialization_core() {
        return this.original;
    }

    @NotNull
    public String getSerialName() {
        return this.serialName;
    }

    @NotNull
    public Set<String> getSerialNames() {
        return this.serialNames;
    }

    public int hashCode() {
        return this.original.hashCode() * 31;
    }

    @ExperimentalSerializationApi
    public boolean isElementOptional(int i11) {
        return this.original.isElementOptional(i11);
    }

    public boolean isInline() {
        return this.original.isInline();
    }

    public boolean isNullable() {
        return true;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.original);
        sb2.append('?');
        return sb2.toString();
    }
}
