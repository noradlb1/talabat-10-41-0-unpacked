package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.load.java.components.DescriptorResolverUtils;
import kotlin.reflect.jvm.internal.impl.load.kotlin.BinaryClassAnnotationAndConstantLoaderImpl;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.AnnotationValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValueFactory;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class BinaryClassAnnotationAndConstantLoaderImpl$loadAnnotation$1 extends BinaryClassAnnotationAndConstantLoaderImpl.AbstractAnnotationArgumentVisitor {
    @NotNull
    private final HashMap<Name, ConstantValue<?>> arguments = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BinaryClassAnnotationAndConstantLoaderImpl f24727b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ClassDescriptor f24728c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ClassId f24729d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ List<AnnotationDescriptor> f24730e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ SourceElement f24731f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BinaryClassAnnotationAndConstantLoaderImpl$loadAnnotation$1(BinaryClassAnnotationAndConstantLoaderImpl binaryClassAnnotationAndConstantLoaderImpl, ClassDescriptor classDescriptor, ClassId classId, List<AnnotationDescriptor> list, SourceElement sourceElement) {
        super();
        this.f24727b = binaryClassAnnotationAndConstantLoaderImpl;
        this.f24728c = classDescriptor;
        this.f24729d = classId;
        this.f24730e = list;
        this.f24731f = sourceElement;
    }

    public void visitArrayValue(@Nullable Name name2, @NotNull ArrayList<ConstantValue<?>> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "elements");
        if (name2 != null) {
            ValueParameterDescriptor annotationParameterByName = DescriptorResolverUtils.getAnnotationParameterByName(name2, this.f24728c);
            if (annotationParameterByName != null) {
                HashMap<Name, ConstantValue<?>> hashMap = this.arguments;
                ConstantValueFactory constantValueFactory = ConstantValueFactory.INSTANCE;
                List<T> compact = CollectionsKt.compact(arrayList);
                KotlinType type = annotationParameterByName.getType();
                Intrinsics.checkNotNullExpressionValue(type, "parameter.type");
                hashMap.put(name2, constantValueFactory.createArrayValue((List<? extends ConstantValue<?>>) compact, type));
            } else if (this.f24727b.g(this.f24729d) && Intrinsics.areEqual((Object) name2.asString(), (Object) "value")) {
                ArrayList<AnnotationValue> arrayList2 = new ArrayList<>();
                for (T next : arrayList) {
                    if (next instanceof AnnotationValue) {
                        arrayList2.add(next);
                    }
                }
                Collection collection = this.f24730e;
                for (AnnotationValue value : arrayList2) {
                    collection.add((AnnotationDescriptor) value.getValue());
                }
            }
        }
    }

    public void visitConstantValue(@Nullable Name name2, @NotNull ConstantValue<?> constantValue) {
        Intrinsics.checkNotNullParameter(constantValue, "value");
        if (name2 != null) {
            this.arguments.put(name2, constantValue);
        }
    }

    public void visitEnd() {
        if (!this.f24727b.k(this.f24729d, this.arguments) && !this.f24727b.g(this.f24729d)) {
            this.f24730e.add(new AnnotationDescriptorImpl(this.f24728c.getDefaultType(), this.arguments, this.f24731f));
        }
    }
}
