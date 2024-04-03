package kotlin.reflect.jvm.internal.impl.load.java.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;

public final class UtilKt {
    @NotNull
    public static final List<ValueParameterDescriptor> copyValueParameters(@NotNull Collection<? extends KotlinType> collection, @NotNull Collection<? extends ValueParameterDescriptor> collection2, @NotNull CallableDescriptor callableDescriptor) {
        KotlinType kotlinType;
        Collection<? extends KotlinType> collection3 = collection;
        Collection<? extends ValueParameterDescriptor> collection4 = collection2;
        Intrinsics.checkNotNullParameter(collection3, "newValueParameterTypes");
        Intrinsics.checkNotNullParameter(collection4, "oldValueParameters");
        Intrinsics.checkNotNullParameter(callableDescriptor, "newOwner");
        collection.size();
        collection2.size();
        Iterable zip = CollectionsKt___CollectionsKt.zip(collection3, collection4);
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(zip, 10));
        Iterator it = zip.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            KotlinType kotlinType2 = (KotlinType) pair.component1();
            ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor) pair.component2();
            int index = valueParameterDescriptor.getIndex();
            Annotations annotations = valueParameterDescriptor.getAnnotations();
            Name name2 = valueParameterDescriptor.getName();
            Intrinsics.checkNotNullExpressionValue(name2, "oldParameter.name");
            boolean declaresDefaultValue = valueParameterDescriptor.declaresDefaultValue();
            boolean isCrossinline = valueParameterDescriptor.isCrossinline();
            boolean isNoinline = valueParameterDescriptor.isNoinline();
            if (valueParameterDescriptor.getVarargElementType() != null) {
                kotlinType = DescriptorUtilsKt.getModule(callableDescriptor).getBuiltIns().getArrayElementType(kotlinType2);
            } else {
                kotlinType = null;
            }
            SourceElement source = valueParameterDescriptor.getSource();
            Intrinsics.checkNotNullExpressionValue(source, "oldParameter.source");
            Iterator it2 = it;
            ValueParameterDescriptorImpl valueParameterDescriptorImpl = r3;
            ValueParameterDescriptorImpl valueParameterDescriptorImpl2 = new ValueParameterDescriptorImpl(callableDescriptor, (ValueParameterDescriptor) null, index, annotations, name2, kotlinType2, declaresDefaultValue, isCrossinline, isNoinline, kotlinType, source);
            arrayList.add(valueParameterDescriptorImpl);
            it = it2;
        }
        return arrayList;
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaStaticClassScope getParentJavaStaticClassScope(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r3) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r3 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getSuperClassNotAny(r3)
            r0 = 0
            if (r3 != 0) goto L_0x000d
            return r0
        L_0x000d:
            kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope r1 = r3.getStaticScope()
            boolean r2 = r1 instanceof kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaStaticClassScope
            if (r2 == 0) goto L_0x0018
            r0 = r1
            kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaStaticClassScope r0 = (kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaStaticClassScope) r0
        L_0x0018:
            if (r0 != 0) goto L_0x001e
            kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaStaticClassScope r0 = getParentJavaStaticClassScope(r3)
        L_0x001e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.descriptors.UtilKt.getParentJavaStaticClassScope(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor):kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaStaticClassScope");
    }
}
