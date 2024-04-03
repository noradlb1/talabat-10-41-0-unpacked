package kotlin.reflect.jvm.internal;

import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Ljava/lang/reflect/Type;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class KParameterImpl$type$1 extends Lambda implements Function0<Type> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ KParameterImpl f24416g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KParameterImpl$type$1(KParameterImpl kParameterImpl) {
        super(0);
        this.f24416g = kParameterImpl;
    }

    @NotNull
    public final Type invoke() {
        ParameterDescriptor access$getDescriptor = this.f24416g.getDescriptor();
        if (!(access$getDescriptor instanceof ReceiverParameterDescriptor) || !Intrinsics.areEqual((Object) UtilKt.getInstanceReceiverParameter(this.f24416g.getCallable().getDescriptor()), (Object) access$getDescriptor) || this.f24416g.getCallable().getDescriptor().getKind() != CallableMemberDescriptor.Kind.FAKE_OVERRIDE) {
            return this.f24416g.getCallable().getCaller().getParameterTypes().get(this.f24416g.getIndex());
        }
        DeclarationDescriptor containingDeclaration = this.f24416g.getCallable().getDescriptor().getContainingDeclaration();
        Intrinsics.checkNotNull(containingDeclaration, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        Class<?> javaClass = UtilKt.toJavaClass((ClassDescriptor) containingDeclaration);
        if (javaClass != null) {
            return javaClass;
        }
        throw new KotlinReflectionInternalError("Cannot determine receiver Java type of inherited declaration: " + access$getDescriptor);
    }
}
