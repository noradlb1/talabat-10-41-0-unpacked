package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class StarProjectionImplKt$buildStarProjectionTypeByTypeParameters$1 extends TypeConstructorSubstitution {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ List<TypeConstructor> f24957a;

    public StarProjectionImplKt$buildStarProjectionTypeByTypeParameters$1(List<? extends TypeConstructor> list) {
        this.f24957a = list;
    }

    @Nullable
    public TypeProjection get(@NotNull TypeConstructor typeConstructor) {
        Intrinsics.checkNotNullParameter(typeConstructor, "key");
        if (!this.f24957a.contains(typeConstructor)) {
            return null;
        }
        ClassifierDescriptor declarationDescriptor = typeConstructor.getDeclarationDescriptor();
        Intrinsics.checkNotNull(declarationDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeParameterDescriptor");
        return TypeUtils.makeStarProjection((TypeParameterDescriptor) declarationDescriptor);
    }
}
