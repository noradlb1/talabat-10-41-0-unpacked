package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import fwfd.com.fwfsdk.constant.FWFConstants;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class JvmBuiltIns extends KotlinBuiltIns {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ KProperty<Object>[] f24465a = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(JvmBuiltIns.class), "customizer", "getCustomizer()Lorg/jetbrains/kotlin/builtins/jvm/JvmBuiltInsCustomizer;"))};
    @NotNull
    private final NotNullLazyValue customizer$delegate;
    @NotNull
    private final Kind kind;
    /* access modifiers changed from: private */
    @Nullable
    public Function0<Settings> settingsComputation;

    public enum Kind {
        FROM_DEPENDENCIES,
        FROM_CLASS_LOADER,
        FALLBACK
    }

    public static final class Settings {
        private final boolean isAdditionalBuiltInsFeatureSupported;
        @NotNull
        private final ModuleDescriptor ownerModuleDescriptor;

        public Settings(@NotNull ModuleDescriptor moduleDescriptor, boolean z11) {
            Intrinsics.checkNotNullParameter(moduleDescriptor, "ownerModuleDescriptor");
            this.ownerModuleDescriptor = moduleDescriptor;
            this.isAdditionalBuiltInsFeatureSupported = z11;
        }

        @NotNull
        public final ModuleDescriptor getOwnerModuleDescriptor() {
            return this.ownerModuleDescriptor;
        }

        public final boolean isAdditionalBuiltInsFeatureSupported() {
            return this.isAdditionalBuiltInsFeatureSupported;
        }
    }

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Kind.values().length];
            iArr[Kind.FROM_DEPENDENCIES.ordinal()] = 1;
            iArr[Kind.FROM_CLASS_LOADER.ordinal()] = 2;
            iArr[Kind.FALLBACK.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JvmBuiltIns(@NotNull StorageManager storageManager, @NotNull Kind kind2) {
        super(storageManager);
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics.checkNotNullParameter(kind2, FWFConstants.EXPLANATION_TYPE_KIND);
        this.kind = kind2;
        this.customizer$delegate = storageManager.createLazyValue(new JvmBuiltIns$customizer$2(this, storageManager));
        int i11 = WhenMappings.$EnumSwitchMapping$0[kind2.ordinal()];
        if (i11 == 2) {
            d(false);
        } else if (i11 == 3) {
            d(true);
        }
    }

    @NotNull
    public AdditionalClassPartsProvider e() {
        return getCustomizer();
    }

    @NotNull
    /* renamed from: g */
    public List<ClassDescriptorFactory> getClassDescriptorFactories() {
        Iterable<ClassDescriptorFactory> classDescriptorFactories = super.getClassDescriptorFactories();
        Intrinsics.checkNotNullExpressionValue(classDescriptorFactories, "super.getClassDescriptorFactories()");
        StorageManager f11 = f();
        Intrinsics.checkNotNullExpressionValue(f11, "storageManager");
        ModuleDescriptorImpl builtInsModule = getBuiltInsModule();
        Intrinsics.checkNotNullExpressionValue(builtInsModule, "builtInsModule");
        return CollectionsKt___CollectionsKt.plus(classDescriptorFactories, new JvmBuiltInClassDescriptorFactory(f11, builtInsModule, (Function1) null, 4, (DefaultConstructorMarker) null));
    }

    @NotNull
    public final JvmBuiltInsCustomizer getCustomizer() {
        return (JvmBuiltInsCustomizer) StorageKt.getValue(this.customizer$delegate, (Object) this, (KProperty<?>) f24465a[0]);
    }

    @NotNull
    public PlatformDependentDeclarationFilter getPlatformDependentDeclarationFilter() {
        return getCustomizer();
    }

    public final void initialize(@NotNull ModuleDescriptor moduleDescriptor, boolean z11) {
        Intrinsics.checkNotNullParameter(moduleDescriptor, "moduleDescriptor");
        setPostponedSettingsComputation(new JvmBuiltIns$initialize$1(moduleDescriptor, z11));
    }

    public final void setPostponedSettingsComputation(@NotNull Function0<Settings> function0) {
        Intrinsics.checkNotNullParameter(function0, "computation");
        this.settingsComputation = function0;
    }
}
