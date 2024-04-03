package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import com.apptimize.c;
import java.util.Iterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaAnnotationMapper;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class LazyJavaAnnotations implements Annotations {
    @NotNull
    private final MemoizedFunctionToNullable<JavaAnnotation, AnnotationDescriptor> annotationDescriptors;
    @NotNull
    private final JavaAnnotationOwner annotationOwner;
    /* access modifiers changed from: private */
    public final boolean areAnnotationsFreshlySupported;
    /* access modifiers changed from: private */
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    public final LazyJavaResolverContext f24587c;

    public LazyJavaAnnotations(@NotNull LazyJavaResolverContext lazyJavaResolverContext, @NotNull JavaAnnotationOwner javaAnnotationOwner, boolean z11) {
        Intrinsics.checkNotNullParameter(lazyJavaResolverContext, c.f41585a);
        Intrinsics.checkNotNullParameter(javaAnnotationOwner, "annotationOwner");
        this.f24587c = lazyJavaResolverContext;
        this.annotationOwner = javaAnnotationOwner;
        this.areAnnotationsFreshlySupported = z11;
        this.annotationDescriptors = lazyJavaResolverContext.getComponents().getStorageManager().createMemoizedFunctionWithNullableValues(new LazyJavaAnnotations$annotationDescriptors$1(this));
    }

    @Nullable
    public AnnotationDescriptor findAnnotation(@NotNull FqName fqName) {
        AnnotationDescriptor invoke;
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        JavaAnnotation findAnnotation = this.annotationOwner.findAnnotation(fqName);
        if (findAnnotation == null || (invoke = this.annotationDescriptors.invoke(findAnnotation)) == null) {
            return JavaAnnotationMapper.INSTANCE.findMappedJavaAnnotation(fqName, this.annotationOwner, this.f24587c);
        }
        return invoke;
    }

    public boolean hasAnnotation(@NotNull FqName fqName) {
        return Annotations.DefaultImpls.hasAnnotation(this, fqName);
    }

    public boolean isEmpty() {
        return this.annotationOwner.getAnnotations().isEmpty() && !this.annotationOwner.isDeprecatedInJavaDoc();
    }

    @NotNull
    public Iterator<AnnotationDescriptor> iterator() {
        return SequencesKt___SequencesKt.filterNotNull(SequencesKt___SequencesKt.plus(SequencesKt___SequencesKt.map(CollectionsKt___CollectionsKt.asSequence(this.annotationOwner.getAnnotations()), this.annotationDescriptors), JavaAnnotationMapper.INSTANCE.findMappedJavaAnnotation(StandardNames.FqNames.deprecated, this.annotationOwner, this.f24587c))).iterator();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LazyJavaAnnotations(LazyJavaResolverContext lazyJavaResolverContext, JavaAnnotationOwner javaAnnotationOwner, boolean z11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(lazyJavaResolverContext, javaAnnotationOwner, (i11 & 4) != 0 ? false : z11);
    }
}
