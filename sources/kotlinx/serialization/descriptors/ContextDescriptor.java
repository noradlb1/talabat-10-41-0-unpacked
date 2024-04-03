package kotlinx.serialization.descriptors;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.text.Typography;
import kotlinx.serialization.ExperimentalSerializationApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004¢\u0006\u0002\u0010\u0005J\u0013\u0010\u001b\u001a\u00020\u00102\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0002J\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u001f\u001a\u00020\fH\u0001J\u0011\u0010 \u001a\u00020\u00012\u0006\u0010\u001f\u001a\u00020\fH\u0001J\u0011\u0010!\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\u0018H\u0001J\u0011\u0010#\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\fH\u0001J\b\u0010$\u001a\u00020\fH\u0016J\u0011\u0010%\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\fH\u0001J\b\u0010&\u001a\u00020\u0018H\u0016R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078VX\u0005¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00108VX\u0005¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00108VX\u0005¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0011R\u0014\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u00020\u00148\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0002\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006'"}, d2 = {"Lkotlinx/serialization/descriptors/ContextDescriptor;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "original", "kClass", "Lkotlin/reflect/KClass;", "(Lkotlinx/serialization/descriptors/SerialDescriptor;Lkotlin/reflect/KClass;)V", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "elementsCount", "", "getElementsCount", "()I", "isInline", "", "()Z", "isNullable", "kind", "Lkotlinx/serialization/descriptors/SerialKind;", "getKind", "()Lkotlinx/serialization/descriptors/SerialKind;", "serialName", "", "getSerialName", "()Ljava/lang/String;", "equals", "other", "", "getElementAnnotations", "index", "getElementDescriptor", "getElementIndex", "name", "getElementName", "hashCode", "isElementOptional", "toString", "kotlinx-serialization-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
final class ContextDescriptor implements SerialDescriptor {
    @NotNull
    @JvmField
    public final KClass<?> kClass;
    @NotNull
    private final SerialDescriptor original;
    @NotNull
    private final String serialName;

    public ContextDescriptor(@NotNull SerialDescriptor serialDescriptor, @NotNull KClass<?> kClass2) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "original");
        Intrinsics.checkNotNullParameter(kClass2, "kClass");
        this.original = serialDescriptor;
        this.kClass = kClass2;
        this.serialName = serialDescriptor.getSerialName() + Typography.less + kClass2.getSimpleName() + Typography.greater;
    }

    public boolean equals(@Nullable Object obj) {
        ContextDescriptor contextDescriptor;
        if (obj instanceof ContextDescriptor) {
            contextDescriptor = (ContextDescriptor) obj;
        } else {
            contextDescriptor = null;
        }
        if (contextDescriptor != null && Intrinsics.areEqual((Object) this.original, (Object) contextDescriptor.original) && Intrinsics.areEqual((Object) contextDescriptor.kClass, (Object) this.kClass)) {
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
    public String getSerialName() {
        return this.serialName;
    }

    public int hashCode() {
        return (this.kClass.hashCode() * 31) + getSerialName().hashCode();
    }

    @ExperimentalSerializationApi
    public boolean isElementOptional(int i11) {
        return this.original.isElementOptional(i11);
    }

    public boolean isInline() {
        return this.original.isInline();
    }

    public boolean isNullable() {
        return this.original.isNullable();
    }

    @NotNull
    public String toString() {
        return "ContextDescriptor(kClass: " + this.kClass + ", original: " + this.original + ')';
    }
}
