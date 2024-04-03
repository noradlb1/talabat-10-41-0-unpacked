package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMapper;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import org.jetbrains.annotations.NotNull;

public final class LazyJavaAnnotationDescriptor$type$2 extends Lambda implements Function0<SimpleType> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ LazyJavaAnnotationDescriptor f24602g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyJavaAnnotationDescriptor$type$2(LazyJavaAnnotationDescriptor lazyJavaAnnotationDescriptor) {
        super(0);
        this.f24602g = lazyJavaAnnotationDescriptor;
    }

    @NotNull
    public final SimpleType invoke() {
        FqName fqName = this.f24602g.getFqName();
        if (fqName == null) {
            return ErrorUtils.createErrorType(ErrorTypeKind.NOT_FOUND_FQNAME_FOR_JAVA_ANNOTATION, this.f24602g.javaAnnotation.toString());
        }
        ClassDescriptor mapJavaToKotlin$default = JavaToKotlinClassMapper.mapJavaToKotlin$default(JavaToKotlinClassMapper.INSTANCE, fqName, this.f24602g.f24599c.getModule().getBuiltIns(), (Integer) null, 4, (Object) null);
        if (mapJavaToKotlin$default == null) {
            JavaClass resolve = this.f24602g.javaAnnotation.resolve();
            mapJavaToKotlin$default = resolve != null ? this.f24602g.f24599c.getComponents().getModuleClassResolver().resolveClass(resolve) : null;
            if (mapJavaToKotlin$default == null) {
                mapJavaToKotlin$default = this.f24602g.createTypeForMissingDependencies(fqName);
            }
        }
        return mapJavaToKotlin$default.getDefaultType();
    }
}
