package com.talabat.core.deeplink.data.handler.tpro;

import android.content.Context;
import com.talabat.core.deeplink.data.ParsedLinkModel;
import com.talabat.core.deeplink.data.handler.Handler;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy;
import com.talabat.core.fwfprojectskeys.domain.projects.ecosystems.EcosystemsExperimentsKeys;
import com.talabat.core.navigation.domain.Navigator;
import com.talabat.core.navigation.domain.screen.flutter.FlutterScreen;
import com.talabat.core.navigation.domain.screen.tpro.SubscriptionDetailsScreen;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0019\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u0014\u001a\u00020\fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {"Lcom/talabat/core/deeplink/data/handler/tpro/SubscriptionManagementHandler;", "Lcom/talabat/core/deeplink/data/handler/Handler;", "navigator", "Lcom/talabat/core/navigation/domain/Navigator;", "talabatExperiment", "Lcom/talabat/core/experiment/domain/ITalabatExperiment;", "(Lcom/talabat/core/navigation/domain/Navigator;Lcom/talabat/core/experiment/domain/ITalabatExperiment;)V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "canHandle", "", "parsedLinkModel", "Lcom/talabat/core/deeplink/data/ParsedLinkModel;", "(Lcom/talabat/core/deeplink/data/ParsedLinkModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handle", "", "context", "Landroid/content/Context;", "isFlutterManagementScreenExperimentEnabled", "Companion", "com_talabat_core_deeplink_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SubscriptionManagementHandler implements Handler {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String VARIATION_TPRO_FLUTTER_MANAGEMENT_SCREEN_DISABLED = "Control";
    @NotNull
    public static final String VARIATION_TPRO_FLUTTER_MANAGEMENT_SCREEN_ENABLED = "Variation1";
    @NotNull
    private final Navigator navigator;
    @NotNull
    private final String screenName = "subscription/management";
    @NotNull
    private final ITalabatExperiment talabatExperiment;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/talabat/core/deeplink/data/handler/tpro/SubscriptionManagementHandler$Companion;", "", "()V", "VARIATION_TPRO_FLUTTER_MANAGEMENT_SCREEN_DISABLED", "", "VARIATION_TPRO_FLUTTER_MANAGEMENT_SCREEN_ENABLED", "com_talabat_core_deeplink_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public SubscriptionManagementHandler(@NotNull Navigator navigator2, @NotNull ITalabatExperiment iTalabatExperiment) {
        Intrinsics.checkNotNullParameter(navigator2, "navigator");
        Intrinsics.checkNotNullParameter(iTalabatExperiment, "talabatExperiment");
        this.navigator = navigator2;
        this.talabatExperiment = iTalabatExperiment;
    }

    private final boolean isFlutterManagementScreenExperimentEnabled() {
        return Intrinsics.areEqual((Object) this.talabatExperiment.getStringVariant(EcosystemsExperimentsKeys.TPRO_FLUTTER_MANAGEMENT_SCREEN, "Control", TalabatExperimentDataSourceStrategy.FWF), (Object) "Variation1");
    }

    @Nullable
    public Object canHandle(@NotNull ParsedLinkModel parsedLinkModel, @NotNull Continuation<? super Boolean> continuation) {
        return Boxing.boxBoolean(Intrinsics.areEqual((Object) parsedLinkModel.getScreenName(), (Object) getScreenName()));
    }

    @NotNull
    public String getScreenName() {
        return this.screenName;
    }

    public void handle(@NotNull Context context, @NotNull ParsedLinkModel parsedLinkModel) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(parsedLinkModel, "parsedLinkModel");
        if (isFlutterManagementScreenExperimentEnabled()) {
            Navigator navigator2 = this.navigator;
            String screenName2 = getScreenName();
            Navigator.DefaultImpls.navigateTo$default(navigator2, context, new FlutterScreen(new FlutterScreen.FlutterScreenData("talabat://?s=" + screenName2)), (Function1) null, 4, (Object) null);
            return;
        }
        Navigator.DefaultImpls.navigateTo$default(this.navigator, context, new SubscriptionDetailsScreen((Void) null, 1, (DefaultConstructorMarker) null), (Function1) null, 4, (Object) null);
    }
}
