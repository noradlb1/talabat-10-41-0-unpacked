package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import org.jetbrains.annotations.Nullable;

public final class LazyJavaClassDescriptor$moduleAnnotations$2 extends Lambda implements Function0<List<? extends JavaAnnotation>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ LazyJavaClassDescriptor f24607g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyJavaClassDescriptor$moduleAnnotations$2(LazyJavaClassDescriptor lazyJavaClassDescriptor) {
        super(0);
        this.f24607g = lazyJavaClassDescriptor;
    }

    @Nullable
    public final List<JavaAnnotation> invoke() {
        ClassId classId = DescriptorUtilsKt.getClassId(this.f24607g);
        if (classId != null) {
            return this.f24607g.getOuterContext().getComponents().getJavaModuleResolver().getAnnotationsForModuleOwnerOfClass(classId);
        }
        return null;
    }
}
