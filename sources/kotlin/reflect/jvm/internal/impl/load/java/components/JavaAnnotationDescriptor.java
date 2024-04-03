package kotlin.reflect.jvm.internal.impl.load.java.components;

import com.apptimize.c;
import java.util.Collection;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.PossiblyExternalAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class JavaAnnotationDescriptor implements AnnotationDescriptor, PossiblyExternalAnnotationDescriptor {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ KProperty<Object>[] f24574a = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(JavaAnnotationDescriptor.class), "type", "getType()Lorg/jetbrains/kotlin/types/SimpleType;"))};
    @Nullable
    private final JavaAnnotationArgument firstArgument;
    @NotNull
    private final FqName fqName;
    private final boolean isIdeExternalAnnotation;
    @NotNull
    private final SourceElement source;
    @NotNull
    private final NotNullLazyValue type$delegate;

    public JavaAnnotationDescriptor(@NotNull LazyJavaResolverContext lazyJavaResolverContext, @Nullable JavaAnnotation javaAnnotation, @NotNull FqName fqName2) {
        SourceElement sourceElement;
        JavaAnnotationArgument javaAnnotationArgument;
        Collection<JavaAnnotationArgument> arguments;
        Intrinsics.checkNotNullParameter(lazyJavaResolverContext, c.f41585a);
        Intrinsics.checkNotNullParameter(fqName2, "fqName");
        this.fqName = fqName2;
        if (javaAnnotation == null || (sourceElement = lazyJavaResolverContext.getComponents().getSourceElementFactory().source(javaAnnotation)) == null) {
            sourceElement = SourceElement.NO_SOURCE;
            Intrinsics.checkNotNullExpressionValue(sourceElement, "NO_SOURCE");
        }
        this.source = sourceElement;
        this.type$delegate = lazyJavaResolverContext.getStorageManager().createLazyValue(new JavaAnnotationDescriptor$type$2(lazyJavaResolverContext, this));
        if (javaAnnotation == null || (arguments = javaAnnotation.getArguments()) == null) {
            javaAnnotationArgument = null;
        } else {
            javaAnnotationArgument = (JavaAnnotationArgument) CollectionsKt___CollectionsKt.firstOrNull(arguments);
        }
        this.firstArgument = javaAnnotationArgument;
        boolean z11 = false;
        if (javaAnnotation != null && javaAnnotation.isIdeExternalAnnotation()) {
            z11 = true;
        }
        this.isIdeExternalAnnotation = z11;
    }

    @Nullable
    public final JavaAnnotationArgument a() {
        return this.firstArgument;
    }

    @NotNull
    public Map<Name, ConstantValue<?>> getAllValueArguments() {
        return MapsKt__MapsKt.emptyMap();
    }

    @NotNull
    public FqName getFqName() {
        return this.fqName;
    }

    @NotNull
    public SourceElement getSource() {
        return this.source;
    }

    public boolean isIdeExternalAnnotation() {
        return this.isIdeExternalAnnotation;
    }

    @NotNull
    public SimpleType getType() {
        return (SimpleType) StorageKt.getValue(this.type$delegate, (Object) this, (KProperty<?>) f24574a[0]);
    }
}
