package kotlin.reflect.jvm.internal.impl.load.java.components;

import java.util.Map;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaEnumValueAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import org.jetbrains.annotations.NotNull;

public final class JavaTargetAnnotationDescriptor$allValueArguments$2 extends Lambda implements Function0<Map<Name, ? extends ConstantValue<? extends Object>>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ JavaTargetAnnotationDescriptor f24581g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JavaTargetAnnotationDescriptor$allValueArguments$2(JavaTargetAnnotationDescriptor javaTargetAnnotationDescriptor) {
        super(0);
        this.f24581g = javaTargetAnnotationDescriptor;
    }

    @NotNull
    public final Map<Name, ConstantValue<Object>> invoke() {
        ConstantValue<?> constantValue;
        JavaAnnotationArgument a11 = this.f24581g.a();
        Map<Name, ConstantValue<Object>> map = null;
        if (a11 instanceof JavaArrayAnnotationArgument) {
            constantValue = JavaAnnotationTargetMapper.INSTANCE.mapJavaTargetArguments$descriptors_jvm(((JavaArrayAnnotationArgument) this.f24581g.a()).getElements());
        } else {
            constantValue = a11 instanceof JavaEnumValueAnnotationArgument ? JavaAnnotationTargetMapper.INSTANCE.mapJavaTargetArguments$descriptors_jvm(CollectionsKt__CollectionsJVMKt.listOf(this.f24581g.a())) : null;
        }
        if (constantValue != null) {
            map = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(JavaAnnotationMapper.INSTANCE.getTARGET_ANNOTATION_ALLOWED_TARGETS$descriptors_jvm(), constantValue));
        }
        return map == null ? MapsKt__MapsKt.emptyMap() : map;
    }
}
