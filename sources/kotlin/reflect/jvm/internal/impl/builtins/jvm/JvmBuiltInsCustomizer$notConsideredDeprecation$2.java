package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import org.jetbrains.annotations.NotNull;

public final class JvmBuiltInsCustomizer$notConsideredDeprecation$2 extends Lambda implements Function0<Annotations> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ JvmBuiltInsCustomizer f24482g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JvmBuiltInsCustomizer$notConsideredDeprecation$2(JvmBuiltInsCustomizer jvmBuiltInsCustomizer) {
        super(0);
        this.f24482g = jvmBuiltInsCustomizer;
    }

    @NotNull
    public final Annotations invoke() {
        return Annotations.Companion.create(CollectionsKt__CollectionsJVMKt.listOf(AnnotationUtilKt.createDeprecatedAnnotation$default(this.f24482g.moduleDescriptor.getBuiltIns(), "This member is not fully supported by Kotlin compiler, so it may be absent or have different signature in next major version", (String) null, (String) null, 6, (Object) null)));
    }
}
