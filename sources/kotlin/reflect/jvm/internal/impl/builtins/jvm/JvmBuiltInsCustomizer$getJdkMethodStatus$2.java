package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureBuildingUtilsKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.utils.DFS;
import org.jetbrains.annotations.NotNull;

public final class JvmBuiltInsCustomizer$getJdkMethodStatus$2 extends DFS.AbstractNodeHandler<ClassDescriptor, JvmBuiltInsCustomizer.JDKMemberStatus> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f24479a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<JvmBuiltInsCustomizer.JDKMemberStatus> f24480b;

    public JvmBuiltInsCustomizer$getJdkMethodStatus$2(String str, Ref.ObjectRef<JvmBuiltInsCustomizer.JDKMemberStatus> objectRef) {
        this.f24479a = str;
        this.f24480b = objectRef;
    }

    public boolean beforeChildren(@NotNull ClassDescriptor classDescriptor) {
        Intrinsics.checkNotNullParameter(classDescriptor, "javaClassDescriptor");
        String signature = MethodSignatureBuildingUtilsKt.signature(SignatureBuildingComponents.INSTANCE, classDescriptor, this.f24479a);
        JvmBuiltInsSignatures jvmBuiltInsSignatures = JvmBuiltInsSignatures.INSTANCE;
        if (jvmBuiltInsSignatures.getHIDDEN_METHOD_SIGNATURES().contains(signature)) {
            this.f24480b.element = JvmBuiltInsCustomizer.JDKMemberStatus.HIDDEN;
        } else if (jvmBuiltInsSignatures.getVISIBLE_METHOD_SIGNATURES().contains(signature)) {
            this.f24480b.element = JvmBuiltInsCustomizer.JDKMemberStatus.VISIBLE;
        } else if (jvmBuiltInsSignatures.getDROP_LIST_METHOD_SIGNATURES().contains(signature)) {
            this.f24480b.element = JvmBuiltInsCustomizer.JDKMemberStatus.DROP;
        }
        return this.f24480b.element == null;
    }

    @NotNull
    public JvmBuiltInsCustomizer.JDKMemberStatus result() {
        JvmBuiltInsCustomizer.JDKMemberStatus jDKMemberStatus = (JvmBuiltInsCustomizer.JDKMemberStatus) this.f24480b.element;
        return jDKMemberStatus == null ? JvmBuiltInsCustomizer.JDKMemberStatus.NOT_CONSIDERED : jDKMemberStatus;
    }
}
