package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.utils.SmartList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class StaticScopeForKotlinEnum extends MemberScopeImpl {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ KProperty<Object>[] f24819a = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(StaticScopeForKotlinEnum.class), "functions", "getFunctions()Ljava/util/List;"))};
    /* access modifiers changed from: private */
    @NotNull
    public final ClassDescriptor containingClass;
    @NotNull
    private final NotNullLazyValue functions$delegate;

    public StaticScopeForKotlinEnum(@NotNull StorageManager storageManager, @NotNull ClassDescriptor classDescriptor) {
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics.checkNotNullParameter(classDescriptor, "containingClass");
        this.containingClass = classDescriptor;
        classDescriptor.getKind();
        ClassKind classKind = ClassKind.CLASS;
        this.functions$delegate = storageManager.createLazyValue(new StaticScopeForKotlinEnum$functions$2(this));
    }

    private final List<SimpleFunctionDescriptor> getFunctions() {
        return (List) StorageKt.getValue(this.functions$delegate, (Object) this, (KProperty<?>) f24819a[0]);
    }

    @Nullable
    public Void getContributedClassifier(@NotNull Name name2, @NotNull LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name2, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, "location");
        return null;
    }

    @NotNull
    public List<SimpleFunctionDescriptor> getContributedDescriptors(@NotNull DescriptorKindFilter descriptorKindFilter, @NotNull Function1<? super Name, Boolean> function1) {
        Intrinsics.checkNotNullParameter(descriptorKindFilter, "kindFilter");
        Intrinsics.checkNotNullParameter(function1, "nameFilter");
        return getFunctions();
    }

    @NotNull
    public SmartList<SimpleFunctionDescriptor> getContributedFunctions(@NotNull Name name2, @NotNull LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name2, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, "location");
        SmartList<SimpleFunctionDescriptor> smartList = new SmartList<>();
        for (Object next : getFunctions()) {
            if (Intrinsics.areEqual((Object) ((SimpleFunctionDescriptor) next).getName(), (Object) name2)) {
                smartList.add(next);
            }
        }
        return smartList;
    }
}
