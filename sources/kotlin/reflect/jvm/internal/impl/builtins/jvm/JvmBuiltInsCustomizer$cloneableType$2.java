package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import org.jetbrains.annotations.NotNull;

public final class JvmBuiltInsCustomizer$cloneableType$2 extends Lambda implements Function0<SimpleType> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ JvmBuiltInsCustomizer f24472g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ StorageManager f24473h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JvmBuiltInsCustomizer$cloneableType$2(JvmBuiltInsCustomizer jvmBuiltInsCustomizer, StorageManager storageManager) {
        super(0);
        this.f24472g = jvmBuiltInsCustomizer;
        this.f24473h = storageManager;
    }

    @NotNull
    public final SimpleType invoke() {
        return FindClassInModuleKt.findNonGenericClassAcrossDependencies(this.f24472g.getSettings().getOwnerModuleDescriptor(), JvmBuiltInClassDescriptorFactory.Companion.getCLONEABLE_CLASS_ID(), new NotFoundClasses(this.f24473h, this.f24472g.getSettings().getOwnerModuleDescriptor())).getDefaultType();
    }
}
