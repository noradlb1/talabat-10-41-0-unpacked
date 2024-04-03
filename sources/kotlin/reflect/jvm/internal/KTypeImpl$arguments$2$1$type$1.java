package kotlin.reflect.jvm.internal;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<no name provided>", "Ljava/lang/reflect/Type;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class KTypeImpl$arguments$2$1$type$1 extends Lambda implements Function0<Type> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ KTypeImpl f24435g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f24436h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Lazy<List<Type>> f24437i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KTypeImpl$arguments$2$1$type$1(KTypeImpl kTypeImpl, int i11, Lazy<? extends List<? extends Type>> lazy) {
        super(0);
        this.f24435g = kTypeImpl;
        this.f24436h = i11;
        this.f24437i = lazy;
    }

    @NotNull
    public final Type invoke() {
        Type javaType = this.f24435g.getJavaType();
        if (javaType instanceof Class) {
            Class cls = (Class) javaType;
            Class componentType = cls.isArray() ? cls.getComponentType() : Object.class;
            Intrinsics.checkNotNullExpressionValue(componentType, "{\n                      …                        }");
            return componentType;
        } else if (javaType instanceof GenericArrayType) {
            if (this.f24436h == 0) {
                Type genericComponentType = ((GenericArrayType) javaType).getGenericComponentType();
                Intrinsics.checkNotNullExpressionValue(genericComponentType, "{\n                      …                        }");
                return genericComponentType;
            }
            throw new KotlinReflectionInternalError("Array type has been queried for a non-0th argument: " + this.f24435g);
        } else if (javaType instanceof ParameterizedType) {
            Type type = (Type) KTypeImpl$arguments$2.m7563invoke$lambda0(this.f24437i).get(this.f24436h);
            if (type instanceof WildcardType) {
                WildcardType wildcardType = (WildcardType) type;
                Type[] lowerBounds = wildcardType.getLowerBounds();
                Intrinsics.checkNotNullExpressionValue(lowerBounds, "argument.lowerBounds");
                Type type2 = (Type) ArraysKt___ArraysKt.firstOrNull((T[]) lowerBounds);
                if (type2 == null) {
                    Type[] upperBounds = wildcardType.getUpperBounds();
                    Intrinsics.checkNotNullExpressionValue(upperBounds, "argument.upperBounds");
                    type = (Type) ArraysKt___ArraysKt.first((T[]) upperBounds);
                } else {
                    type = type2;
                }
            }
            Intrinsics.checkNotNullExpressionValue(type, "{\n                      …                        }");
            return type;
        } else {
            throw new KotlinReflectionInternalError("Non-generic type has been queried for arguments: " + this.f24435g);
        }
    }
}
