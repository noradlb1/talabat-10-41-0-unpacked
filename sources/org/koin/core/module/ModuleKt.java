package org.koin.core.module;

import java.util.List;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.koin.core.error.DefinitionOverrideException;
import org.koin.core.instance.InstanceFactory;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u001a \u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006H\u0001\u001a!\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b*\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\tH\u0002¨\u0006\u000b"}, d2 = {"overrideError", "", "factory", "Lorg/koin/core/instance/InstanceFactory;", "mapping", "", "Lorg/koin/core/definition/IndexKey;", "plus", "", "Lorg/koin/core/module/Module;", "module", "koin-core"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class ModuleKt {
    @PublishedApi
    public static final void overrideError(@NotNull InstanceFactory<?> instanceFactory, @NotNull String str) {
        Intrinsics.checkNotNullParameter(instanceFactory, "factory");
        Intrinsics.checkNotNullParameter(str, "mapping");
        throw new DefinitionOverrideException("Already existing definition for " + instanceFactory.getBeanDefinition() + " at " + str);
    }

    @NotNull
    public static final List<Module> plus(@NotNull List<Module> list, @NotNull Module module) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(module, "module");
        return CollectionsKt___CollectionsKt.plus(list, CollectionsKt__CollectionsJVMKt.listOf(module));
    }
}
