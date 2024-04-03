package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ArrayValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class AnnotationTypeQualifierResolver extends AbstractAnnotationTypeQualifierResolver<AnnotationDescriptor> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AnnotationTypeQualifierResolver(@NotNull JavaTypeEnhancementState javaTypeEnhancementState) {
        super(javaTypeEnhancementState);
        Intrinsics.checkNotNullParameter(javaTypeEnhancementState, "javaTypeEnhancementState");
    }

    private final List<String> toEnumNames(ConstantValue<?> constantValue) {
        if (constantValue instanceof ArrayValue) {
            ArrayList arrayList = new ArrayList();
            for (ConstantValue enumNames : (Iterable) ((ArrayValue) constantValue).getValue()) {
                boolean unused = CollectionsKt__MutableCollectionsKt.addAll(arrayList, toEnumNames(enumNames));
            }
            return arrayList;
        } else if (constantValue instanceof EnumValue) {
            return CollectionsKt__CollectionsJVMKt.listOf(((EnumValue) constantValue).getEnumEntryName().getIdentifier());
        } else {
            return CollectionsKt__CollectionsKt.emptyList();
        }
    }

    @NotNull
    /* renamed from: a */
    public Iterable<String> enumArguments(@NotNull AnnotationDescriptor annotationDescriptor, boolean z11) {
        List<String> list;
        Intrinsics.checkNotNullParameter(annotationDescriptor, "<this>");
        Map<Name, ConstantValue<?>> allValueArguments = annotationDescriptor.getAllValueArguments();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry next : allValueArguments.entrySet()) {
            Name name2 = (Name) next.getKey();
            ConstantValue constantValue = (ConstantValue) next.getValue();
            if (!z11 || Intrinsics.areEqual((Object) name2, (Object) JvmAnnotationNames.DEFAULT_ANNOTATION_MEMBER_NAME)) {
                list = toEnumNames(constantValue);
            } else {
                list = CollectionsKt__CollectionsKt.emptyList();
            }
            boolean unused = CollectionsKt__MutableCollectionsKt.addAll(arrayList, list);
        }
        return arrayList;
    }

    @Nullable
    /* renamed from: b */
    public FqName getFqName(@NotNull AnnotationDescriptor annotationDescriptor) {
        Intrinsics.checkNotNullParameter(annotationDescriptor, "<this>");
        return annotationDescriptor.getFqName();
    }

    @NotNull
    /* renamed from: c */
    public Object getKey(@NotNull AnnotationDescriptor annotationDescriptor) {
        Intrinsics.checkNotNullParameter(annotationDescriptor, "<this>");
        ClassDescriptor annotationClass = DescriptorUtilsKt.getAnnotationClass(annotationDescriptor);
        Intrinsics.checkNotNull(annotationClass);
        return annotationClass;
    }

    @NotNull
    /* renamed from: d */
    public Iterable<AnnotationDescriptor> getMetaAnnotations(@NotNull AnnotationDescriptor annotationDescriptor) {
        Annotations annotations;
        Intrinsics.checkNotNullParameter(annotationDescriptor, "<this>");
        ClassDescriptor annotationClass = DescriptorUtilsKt.getAnnotationClass(annotationDescriptor);
        if (annotationClass == null || (annotations = annotationClass.getAnnotations()) == null) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return annotations;
    }
}
