package kotlinx.serialization.internal;

import fwfd.com.fwfsdk.constant.FWFConstants;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0014\u001a\u00020\bH\u0016J\u0010\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\bH\u0016J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0003H\u0016J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\bH\u0016J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\bH\u0016J\b\u0010\u001b\u001a\u00020\u0003H\u0016R\u0014\u0010\u0007\u001a\u00020\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001c"}, d2 = {"Lkotlinx/serialization/internal/PrimitiveSerialDescriptor;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialName", "", "kind", "Lkotlinx/serialization/descriptors/PrimitiveKind;", "(Ljava/lang/String;Lkotlinx/serialization/descriptors/PrimitiveKind;)V", "elementsCount", "", "getElementsCount", "()I", "getKind", "()Lkotlinx/serialization/descriptors/PrimitiveKind;", "getSerialName", "()Ljava/lang/String;", "error", "", "getElementAnnotations", "", "", "index", "getElementDescriptor", "getElementIndex", "name", "getElementName", "isElementOptional", "", "toString", "kotlinx-serialization-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PrimitiveSerialDescriptor implements SerialDescriptor {
    @NotNull
    private final PrimitiveKind kind;
    @NotNull
    private final String serialName;

    public PrimitiveSerialDescriptor(@NotNull String str, @NotNull PrimitiveKind primitiveKind) {
        Intrinsics.checkNotNullParameter(str, "serialName");
        Intrinsics.checkNotNullParameter(primitiveKind, FWFConstants.EXPLANATION_TYPE_KIND);
        this.serialName = str;
        this.kind = primitiveKind;
    }

    private final Void error() {
        throw new IllegalStateException("Primitive descriptor does not have elements");
    }

    @NotNull
    public List<Annotation> getAnnotations() {
        return SerialDescriptor.DefaultImpls.getAnnotations(this);
    }

    @NotNull
    public List<Annotation> getElementAnnotations(int i11) {
        error();
        throw new KotlinNothingValueException();
    }

    @NotNull
    public SerialDescriptor getElementDescriptor(int i11) {
        error();
        throw new KotlinNothingValueException();
    }

    public int getElementIndex(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        error();
        throw new KotlinNothingValueException();
    }

    @NotNull
    public String getElementName(int i11) {
        error();
        throw new KotlinNothingValueException();
    }

    public int getElementsCount() {
        return 0;
    }

    @NotNull
    public String getSerialName() {
        return this.serialName;
    }

    public boolean isElementOptional(int i11) {
        error();
        throw new KotlinNothingValueException();
    }

    public boolean isInline() {
        return SerialDescriptor.DefaultImpls.isInline(this);
    }

    public boolean isNullable() {
        return SerialDescriptor.DefaultImpls.isNullable(this);
    }

    @NotNull
    public String toString() {
        return "PrimitiveDescriptor(" + getSerialName() + ')';
    }

    @NotNull
    public PrimitiveKind getKind() {
        return this.kind;
    }
}
