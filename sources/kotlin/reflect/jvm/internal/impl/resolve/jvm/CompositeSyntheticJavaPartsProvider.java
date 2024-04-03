package kotlin.reflect.jvm.internal.impl.resolve.jvm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;

public final class CompositeSyntheticJavaPartsProvider implements SyntheticJavaPartsProvider {
    @NotNull
    private final List<SyntheticJavaPartsProvider> inner;

    public CompositeSyntheticJavaPartsProvider(@NotNull List<? extends SyntheticJavaPartsProvider> list) {
        Intrinsics.checkNotNullParameter(list, "inner");
        this.inner = list;
    }

    public void generateConstructors(@NotNull ClassDescriptor classDescriptor, @NotNull List<ClassConstructorDescriptor> list) {
        Intrinsics.checkNotNullParameter(classDescriptor, "thisDescriptor");
        Intrinsics.checkNotNullParameter(list, "result");
        for (SyntheticJavaPartsProvider generateConstructors : this.inner) {
            generateConstructors.generateConstructors(classDescriptor, list);
        }
    }

    public void generateMethods(@NotNull ClassDescriptor classDescriptor, @NotNull Name name2, @NotNull Collection<SimpleFunctionDescriptor> collection) {
        Intrinsics.checkNotNullParameter(classDescriptor, "thisDescriptor");
        Intrinsics.checkNotNullParameter(name2, "name");
        Intrinsics.checkNotNullParameter(collection, "result");
        for (SyntheticJavaPartsProvider generateMethods : this.inner) {
            generateMethods.generateMethods(classDescriptor, name2, collection);
        }
    }

    public void generateStaticFunctions(@NotNull ClassDescriptor classDescriptor, @NotNull Name name2, @NotNull Collection<SimpleFunctionDescriptor> collection) {
        Intrinsics.checkNotNullParameter(classDescriptor, "thisDescriptor");
        Intrinsics.checkNotNullParameter(name2, "name");
        Intrinsics.checkNotNullParameter(collection, "result");
        for (SyntheticJavaPartsProvider generateStaticFunctions : this.inner) {
            generateStaticFunctions.generateStaticFunctions(classDescriptor, name2, collection);
        }
    }

    @NotNull
    public List<Name> getMethodNames(@NotNull ClassDescriptor classDescriptor) {
        Intrinsics.checkNotNullParameter(classDescriptor, "thisDescriptor");
        ArrayList arrayList = new ArrayList();
        for (SyntheticJavaPartsProvider methodNames : this.inner) {
            boolean unused = CollectionsKt__MutableCollectionsKt.addAll(arrayList, methodNames.getMethodNames(classDescriptor));
        }
        return arrayList;
    }

    @NotNull
    public List<Name> getStaticFunctionNames(@NotNull ClassDescriptor classDescriptor) {
        Intrinsics.checkNotNullParameter(classDescriptor, "thisDescriptor");
        ArrayList arrayList = new ArrayList();
        for (SyntheticJavaPartsProvider staticFunctionNames : this.inner) {
            boolean unused = CollectionsKt__MutableCollectionsKt.addAll(arrayList, staticFunctionNames.getStaticFunctionNames(classDescriptor));
        }
        return arrayList;
    }
}
