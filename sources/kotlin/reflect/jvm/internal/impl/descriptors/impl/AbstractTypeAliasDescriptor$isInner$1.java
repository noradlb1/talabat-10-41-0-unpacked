package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;

public final class AbstractTypeAliasDescriptor$isInner$1 extends Lambda implements Function1<UnwrappedType, Boolean> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ AbstractTypeAliasDescriptor f24503g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AbstractTypeAliasDescriptor$isInner$1(AbstractTypeAliasDescriptor abstractTypeAliasDescriptor) {
        super(1);
        this.f24503g = abstractTypeAliasDescriptor;
    }

    public final Boolean invoke(UnwrappedType unwrappedType) {
        Intrinsics.checkNotNullExpressionValue(unwrappedType, "type");
        boolean z11 = false;
        if (!KotlinTypeKt.isError(unwrappedType)) {
            AbstractTypeAliasDescriptor abstractTypeAliasDescriptor = this.f24503g;
            ClassifierDescriptor declarationDescriptor = unwrappedType.getConstructor().getDeclarationDescriptor();
            if ((declarationDescriptor instanceof TypeParameterDescriptor) && !Intrinsics.areEqual((Object) ((TypeParameterDescriptor) declarationDescriptor).getContainingDeclaration(), (Object) abstractTypeAliasDescriptor)) {
                z11 = true;
            }
        }
        return Boolean.valueOf(z11);
    }
}
