package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ReflectJavaArrayAnnotationArgument extends ReflectJavaAnnotationArgument implements JavaArrayAnnotationArgument {
    @NotNull
    private final Object[] values;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ReflectJavaArrayAnnotationArgument(@Nullable Name name2, @NotNull Object[] objArr) {
        super(name2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(objArr, "values");
        this.values = objArr;
    }

    @NotNull
    public List<ReflectJavaAnnotationArgument> getElements() {
        Object[] objArr = this.values;
        ArrayList arrayList = new ArrayList(objArr.length);
        for (Object obj : objArr) {
            ReflectJavaAnnotationArgument.Factory factory = ReflectJavaAnnotationArgument.Factory;
            Intrinsics.checkNotNull(obj);
            arrayList.add(factory.create(obj, (Name) null));
        }
        return arrayList;
    }
}
