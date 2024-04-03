package org.koin.dsl;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.koin.core.module.Module;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a9\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u001b\u0010\u0005\u001a\u0017\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00070\u0006j\u0002`\b¢\u0006\u0002\b\tH\u0007\u001a-\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u001b\u0010\u0005\u001a\u0017\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00070\u0006j\u0002`\b¢\u0006\u0002\b\t*,\u0010\n\"\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\t2\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\t¨\u0006\u000b"}, d2 = {"module", "Lorg/koin/core/module/Module;", "createdAtStart", "", "override", "moduleDeclaration", "Lkotlin/Function1;", "", "Lorg/koin/dsl/ModuleDeclaration;", "Lkotlin/ExtensionFunctionType;", "ModuleDeclaration", "koin-core"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class ModuleKt {
    @NotNull
    @Deprecated(message = "'override' parameter is not used anymore. See 'allowOverride' in KoinApplication")
    public static final Module module(boolean z11, boolean z12, @NotNull Function1<? super Module, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "moduleDeclaration");
        Module module = new Module(z11);
        function1.invoke(module);
        return module;
    }

    public static /* synthetic */ Module module$default(boolean z11, boolean z12, Function1 function1, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = false;
        }
        if ((i11 & 2) != 0) {
            z12 = false;
        }
        return module(z11, z12, function1);
    }

    public static /* synthetic */ Module module$default(boolean z11, Function1 function1, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = false;
        }
        return module(z11, function1);
    }

    @NotNull
    public static final Module module(boolean z11, @NotNull Function1<? super Module, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "moduleDeclaration");
        Module module = new Module(z11);
        function1.invoke(module);
        return module;
    }
}
