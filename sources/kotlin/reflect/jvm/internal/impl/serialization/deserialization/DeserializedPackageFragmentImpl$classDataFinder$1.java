package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource;
import org.jetbrains.annotations.NotNull;

public final class DeserializedPackageFragmentImpl$classDataFinder$1 extends Lambda implements Function1<ClassId, SourceElement> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DeserializedPackageFragmentImpl f24828g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeserializedPackageFragmentImpl$classDataFinder$1(DeserializedPackageFragmentImpl deserializedPackageFragmentImpl) {
        super(1);
        this.f24828g = deserializedPackageFragmentImpl;
    }

    @NotNull
    public final SourceElement invoke(@NotNull ClassId classId) {
        Intrinsics.checkNotNullParameter(classId, "it");
        DeserializedContainerSource access$getContainerSource$p = this.f24828g.containerSource;
        if (access$getContainerSource$p != null) {
            return access$getContainerSource$p;
        }
        SourceElement sourceElement = SourceElement.NO_SOURCE;
        Intrinsics.checkNotNullExpressionValue(sourceElement, "NO_SOURCE");
        return sourceElement;
    }
}
