package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;

public final class JvmBuiltInClassDescriptorFactory$cloneable$2 extends Lambda implements Function0<ClassDescriptorImpl> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ JvmBuiltInClassDescriptorFactory f24463g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ StorageManager f24464h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JvmBuiltInClassDescriptorFactory$cloneable$2(JvmBuiltInClassDescriptorFactory jvmBuiltInClassDescriptorFactory, StorageManager storageManager) {
        super(0);
        this.f24463g = jvmBuiltInClassDescriptorFactory;
        this.f24464h = storageManager;
    }

    @NotNull
    public final ClassDescriptorImpl invoke() {
        ClassDescriptorImpl classDescriptorImpl = new ClassDescriptorImpl((DeclarationDescriptor) this.f24463g.computeContainingDeclaration.invoke(this.f24463g.moduleDescriptor), JvmBuiltInClassDescriptorFactory.CLONEABLE_NAME, Modality.ABSTRACT, ClassKind.INTERFACE, CollectionsKt__CollectionsJVMKt.listOf(this.f24463g.moduleDescriptor.getBuiltIns().getAnyType()), SourceElement.NO_SOURCE, false, this.f24464h);
        classDescriptorImpl.initialize(new CloneableClassScope(this.f24464h, classDescriptorImpl), SetsKt__SetsKt.emptySet(), (ClassConstructorDescriptor) null);
        return classDescriptorImpl;
    }
}
