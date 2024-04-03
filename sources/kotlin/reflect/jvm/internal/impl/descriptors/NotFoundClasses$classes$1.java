package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;

public final class NotFoundClasses$classes$1 extends Lambda implements Function1<NotFoundClasses.ClassRequest, ClassDescriptor> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ NotFoundClasses f24484g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NotFoundClasses$classes$1(NotFoundClasses notFoundClasses) {
        super(1);
        this.f24484g = notFoundClasses;
    }

    @NotNull
    public final ClassDescriptor invoke(@NotNull NotFoundClasses.ClassRequest classRequest) {
        DeclarationDescriptor declarationDescriptor;
        Intrinsics.checkNotNullParameter(classRequest, "<name for destructuring parameter 0>");
        ClassId component1 = classRequest.component1();
        List<Integer> component2 = classRequest.component2();
        if (!component1.isLocal()) {
            ClassId outerClassId = component1.getOuterClassId();
            if (outerClassId == null || (declarationDescriptor = this.f24484g.getClass(outerClassId, CollectionsKt___CollectionsKt.drop(component2, 1))) == null) {
                MemoizedFunctionToNotNull access$getPackageFragments$p = this.f24484g.packageFragments;
                FqName packageFqName = component1.getPackageFqName();
                Intrinsics.checkNotNullExpressionValue(packageFqName, "classId.packageFqName");
                declarationDescriptor = (ClassOrPackageFragmentDescriptor) access$getPackageFragments$p.invoke(packageFqName);
            }
            DeclarationDescriptor declarationDescriptor2 = declarationDescriptor;
            boolean isNestedClass = component1.isNestedClass();
            StorageManager access$getStorageManager$p = this.f24484g.storageManager;
            Name shortClassName = component1.getShortClassName();
            Intrinsics.checkNotNullExpressionValue(shortClassName, "classId.shortClassName");
            Integer num = (Integer) CollectionsKt___CollectionsKt.firstOrNull(component2);
            return new NotFoundClasses.MockClassDescriptor(access$getStorageManager$p, declarationDescriptor2, shortClassName, isNestedClass, num != null ? num.intValue() : 0);
        }
        throw new UnsupportedOperationException("Unresolved local class: " + component1);
    }
}
