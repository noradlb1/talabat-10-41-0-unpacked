package kotlin.reflect.jvm.internal.impl.builtins.functions;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.GivenFunctionsMemberScope;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;

public final class FunctionClassScope extends GivenFunctionsMemberScope {

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FunctionClassKind.values().length];
            iArr[FunctionClassKind.Function.ordinal()] = 1;
            iArr[FunctionClassKind.SuspendFunction.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FunctionClassScope(@NotNull StorageManager storageManager, @NotNull FunctionClassDescriptor functionClassDescriptor) {
        super(storageManager, functionClassDescriptor);
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics.checkNotNullParameter(functionClassDescriptor, "containingClass");
    }

    @NotNull
    public List<FunctionDescriptor> a() {
        ClassDescriptor b11 = b();
        Intrinsics.checkNotNull(b11, "null cannot be cast to non-null type org.jetbrains.kotlin.builtins.functions.FunctionClassDescriptor");
        int i11 = WhenMappings.$EnumSwitchMapping$0[((FunctionClassDescriptor) b11).getFunctionKind().ordinal()];
        if (i11 == 1) {
            return CollectionsKt__CollectionsJVMKt.listOf(FunctionInvokeDescriptor.Factory.create((FunctionClassDescriptor) b(), false));
        }
        if (i11 != 2) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return CollectionsKt__CollectionsJVMKt.listOf(FunctionInvokeDescriptor.Factory.create((FunctionClassDescriptor) b(), true));
    }
}
