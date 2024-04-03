package com.talabat.gem.adapters.presentation.collections;

import com.talabat.gem.adapters.presentation.GemEntryViewConfigurations;
import com.talabat.gem.adapters.presentation.GemViewsDsl;
import com.talabat.talabatcommon.extentions.RxKt;
import io.reactivex.subjects.ReplaySubject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J!\u0010\u0002\u001a\u00020\u00032\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\b\u0007H\u0017¨\u0006\b"}, d2 = {"Lcom/talabat/gem/adapters/presentation/collections/GemCollectionsIntegration;", "", "withGemCollectionsView", "", "configurations", "Lkotlin/Function1;", "Lcom/talabat/gem/adapters/presentation/GemEntryViewConfigurations;", "Lkotlin/ExtensionFunctionType;", "com_talabat_Components_gem_gem"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface GemCollectionsIntegration {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        @GemViewsDsl
        public static void withGemCollectionsView(@NotNull GemCollectionsIntegration gemCollectionsIntegration, @NotNull Function1<? super GemEntryViewConfigurations, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "configurations");
            ReplaySubject<GemEntryViewConfigurations> gemCollectionsConfigurations = GemCollectionsIntegrationKt.getGemCollectionsConfigurations();
            GemEntryViewConfigurations gemEntryViewConfigurations = new GemEntryViewConfigurations();
            function1.invoke(gemEntryViewConfigurations);
            RxKt.plusAssign(gemCollectionsConfigurations, gemEntryViewConfigurations);
        }
    }

    @GemViewsDsl
    void withGemCollectionsView(@NotNull Function1<? super GemEntryViewConfigurations, Unit> function1);
}
