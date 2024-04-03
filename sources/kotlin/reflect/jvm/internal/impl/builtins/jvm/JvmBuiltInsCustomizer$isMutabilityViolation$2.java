package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;

public final class JvmBuiltInsCustomizer$isMutabilityViolation$2 extends Lambda implements Function1<CallableMemberDescriptor, Boolean> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ JvmBuiltInsCustomizer f24481g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JvmBuiltInsCustomizer$isMutabilityViolation$2(JvmBuiltInsCustomizer jvmBuiltInsCustomizer) {
        super(1);
        this.f24481g = jvmBuiltInsCustomizer;
    }

    public final Boolean invoke(CallableMemberDescriptor callableMemberDescriptor) {
        boolean z11;
        if (callableMemberDescriptor.getKind() == CallableMemberDescriptor.Kind.DECLARATION) {
            JavaToKotlinClassMapper access$getJ2kClassMapper$p = this.f24481g.j2kClassMapper;
            DeclarationDescriptor containingDeclaration = callableMemberDescriptor.getContainingDeclaration();
            Intrinsics.checkNotNull(containingDeclaration, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            if (access$getJ2kClassMapper$p.isMutable((ClassDescriptor) containingDeclaration)) {
                z11 = true;
                return Boolean.valueOf(z11);
            }
        }
        z11 = false;
        return Boolean.valueOf(z11);
    }
}
