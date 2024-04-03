package com.talabat.talabatcommon.views.darkstores.lookingGlass.viewModel;

import android.content.Context;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.network.network.TalabatAPIBuilder;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.talabatcommon.feature.darkstores.lookingGlass.LookingGlassTracker;
import com.talabat.talabatcommon.feature.darkstores.lookingGlass.LookingGlassUseCase;
import com.talabat.talabatcommon.feature.darkstores.lookingGlass.network.LookingGlassService;
import com.talabat.talabatcommon.feature.darkstores.lookingGlass.repository.LookingGlassRepositoryImpl;
import com.talabat.talabatcore.platform.NetworkHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/talabat/talabatcommon/views/darkstores/lookingGlass/viewModel/LookingGlassViewModelBuilder;", "", "()V", "Companion", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LookingGlassViewModelBuilder {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/talabat/talabatcommon/views/darkstores/lookingGlass/viewModel/LookingGlassViewModelBuilder$Companion;", "", "()V", "getMyViewModel", "Lcom/talabat/talabatcommon/views/darkstores/lookingGlass/viewModel/LookingGlassViewModelImpl;", "context", "Landroid/content/Context;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final LookingGlassViewModelImpl getMyViewModel(@NotNull Context context, @NotNull CoroutineScope coroutineScope) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
            return new LookingGlassViewModelImpl(new LookingGlassUseCase(new LookingGlassRepositoryImpl(new NetworkHandler(context), ((ConfigurationRemoteCoreLibApi) AndroidComponentsKt.apiContainer(context).getFeature(ConfigurationRemoteCoreLibApi.class)).getLocationConfigurationRepository(), new LookingGlassService(new TalabatAPIBuilder())), coroutineScope, Dispatchers.getMain()), (ITalabatExperiment) null, (LookingGlassTracker) null, 6, (DefaultConstructorMarker) null);
        }
    }
}
