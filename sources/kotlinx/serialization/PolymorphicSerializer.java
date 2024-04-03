package kotlinx.serialization;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.internal.AbstractPolymorphicSerializer;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u001b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B#\b\u0011\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tB\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0002\u0010\nJ\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u000f\u001a\u00020\u00108VX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0017"}, d2 = {"Lkotlinx/serialization/PolymorphicSerializer;", "T", "", "Lkotlinx/serialization/internal/AbstractPolymorphicSerializer;", "baseClass", "Lkotlin/reflect/KClass;", "classAnnotations", "", "", "(Lkotlin/reflect/KClass;[Ljava/lang/annotation/Annotation;)V", "(Lkotlin/reflect/KClass;)V", "_annotations", "", "getBaseClass", "()Lkotlin/reflect/KClass;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor$delegate", "Lkotlin/Lazy;", "toString", "", "kotlinx-serialization-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PolymorphicSerializer<T> extends AbstractPolymorphicSerializer<T> {
    /* access modifiers changed from: private */
    @NotNull
    public List<? extends Annotation> _annotations;
    @NotNull
    private final KClass<T> baseClass;
    @NotNull
    private final Lazy descriptor$delegate;

    public PolymorphicSerializer(@NotNull KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "baseClass");
        this.baseClass = kClass;
        this._annotations = CollectionsKt__CollectionsKt.emptyList();
        this.descriptor$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.PUBLICATION, new PolymorphicSerializer$descriptor$2(this));
    }

    @NotNull
    public KClass<T> getBaseClass() {
        return this.baseClass;
    }

    @NotNull
    public SerialDescriptor getDescriptor() {
        return (SerialDescriptor) this.descriptor$delegate.getValue();
    }

    @NotNull
    public String toString() {
        return "kotlinx.serialization.PolymorphicSerializer(baseClass: " + getBaseClass() + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @PublishedApi
    public PolymorphicSerializer(@NotNull KClass<T> kClass, @NotNull Annotation[] annotationArr) {
        this(kClass);
        Intrinsics.checkNotNullParameter(kClass, "baseClass");
        Intrinsics.checkNotNullParameter(annotationArr, "classAnnotations");
        this._annotations = ArraysKt___ArraysJvmKt.asList((T[]) annotationArr);
    }
}
