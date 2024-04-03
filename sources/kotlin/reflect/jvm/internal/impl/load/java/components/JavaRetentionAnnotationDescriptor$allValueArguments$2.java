package kotlin.reflect.jvm.internal.impl.load.java.components;

import java.util.Map;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import org.jetbrains.annotations.NotNull;

public final class JavaRetentionAnnotationDescriptor$allValueArguments$2 extends Lambda implements Function0<Map<Name, ? extends ConstantValue<?>>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ JavaRetentionAnnotationDescriptor f24579g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JavaRetentionAnnotationDescriptor$allValueArguments$2(JavaRetentionAnnotationDescriptor javaRetentionAnnotationDescriptor) {
        super(0);
        this.f24579g = javaRetentionAnnotationDescriptor;
    }

    @NotNull
    public final Map<Name, ConstantValue<?>> invoke() {
        ConstantValue<?> mapJavaRetentionArgument$descriptors_jvm = JavaAnnotationTargetMapper.INSTANCE.mapJavaRetentionArgument$descriptors_jvm(this.f24579g.a());
        Map<Name, ConstantValue<?>> mapOf = mapJavaRetentionArgument$descriptors_jvm != null ? MapsKt__MapsJVMKt.mapOf(TuplesKt.to(JavaAnnotationMapper.INSTANCE.getRETENTION_ANNOTATION_VALUE$descriptors_jvm(), mapJavaRetentionArgument$descriptors_jvm)) : null;
        return mapOf == null ? MapsKt__MapsKt.emptyMap() : mapOf;
    }
}
