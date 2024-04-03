package kotlin.reflect.jvm.internal;

import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Ljava/lang/reflect/Type;", "T", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class KClassImpl$Data$supertypes$2$1$1 extends Lambda implements Function0<Type> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ KotlinType f24387g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ KClassImpl<T>.Data f24388h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ KClassImpl<T> f24389i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KClassImpl$Data$supertypes$2$1$1(KotlinType kotlinType, KClassImpl<T>.Data data, KClassImpl<T> kClassImpl) {
        super(0);
        this.f24387g = kotlinType;
        this.f24388h = data;
        this.f24389i = kClassImpl;
    }

    @NotNull
    public final Type invoke() {
        ClassifierDescriptor declarationDescriptor = this.f24387g.getConstructor().getDeclarationDescriptor();
        if (declarationDescriptor instanceof ClassDescriptor) {
            Class<?> javaClass = UtilKt.toJavaClass((ClassDescriptor) declarationDescriptor);
            if (javaClass == null) {
                throw new KotlinReflectionInternalError("Unsupported superclass of " + this.f24388h + ": " + declarationDescriptor);
            } else if (Intrinsics.areEqual((Object) this.f24389i.getJClass().getSuperclass(), (Object) javaClass)) {
                Type genericSuperclass = this.f24389i.getJClass().getGenericSuperclass();
                Intrinsics.checkNotNullExpressionValue(genericSuperclass, "{\n                      …ass\n                    }");
                return genericSuperclass;
            } else {
                Class[] interfaces = this.f24389i.getJClass().getInterfaces();
                Intrinsics.checkNotNullExpressionValue(interfaces, "jClass.interfaces");
                int indexOf = ArraysKt___ArraysKt.indexOf((T[]) interfaces, javaClass);
                if (indexOf >= 0) {
                    Type type = this.f24389i.getJClass().getGenericInterfaces()[indexOf];
                    Intrinsics.checkNotNullExpressionValue(type, "{\n                      …ex]\n                    }");
                    return type;
                }
                throw new KotlinReflectionInternalError("No superclass of " + this.f24388h + " in Java reflection for " + declarationDescriptor);
            }
        } else {
            throw new KotlinReflectionInternalError("Supertype not a class: " + declarationDescriptor);
        }
    }
}
