package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import org.jetbrains.annotations.NotNull;

public final class LazyJavaAnnotationDescriptor$allValueArguments$2 extends Lambda implements Function0<Map<Name, ? extends ConstantValue<?>>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ LazyJavaAnnotationDescriptor f24600g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyJavaAnnotationDescriptor$allValueArguments$2(LazyJavaAnnotationDescriptor lazyJavaAnnotationDescriptor) {
        super(0);
        this.f24600g = lazyJavaAnnotationDescriptor;
    }

    @NotNull
    public final Map<Name, ConstantValue<?>> invoke() {
        LazyJavaAnnotationDescriptor lazyJavaAnnotationDescriptor = this.f24600g;
        ArrayList arrayList = new ArrayList();
        for (JavaAnnotationArgument javaAnnotationArgument : this.f24600g.javaAnnotation.getArguments()) {
            Name name2 = javaAnnotationArgument.getName();
            if (name2 == null) {
                name2 = JvmAnnotationNames.DEFAULT_ANNOTATION_MEMBER_NAME;
            }
            ConstantValue access$resolveAnnotationArgument = lazyJavaAnnotationDescriptor.resolveAnnotationArgument(javaAnnotationArgument);
            Pair pair = access$resolveAnnotationArgument != null ? TuplesKt.to(name2, access$resolveAnnotationArgument) : null;
            if (pair != null) {
                arrayList.add(pair);
            }
        }
        return MapsKt__MapsKt.toMap(arrayList);
    }
}
