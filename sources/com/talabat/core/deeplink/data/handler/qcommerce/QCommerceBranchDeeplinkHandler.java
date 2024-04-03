package com.talabat.core.deeplink.data.handler.qcommerce;

import android.content.Context;
import com.talabat.core.deeplink.data.ParsedLinkModel;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.navigation.domain.Navigator;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0019\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H@ø\u0001\u0000¢\u0006\u0002\u0010\u0011J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0014\u0010\t\u001a\u00020\nXD¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {"Lcom/talabat/core/deeplink/data/handler/qcommerce/QCommerceBranchDeeplinkHandler;", "Lcom/talabat/core/deeplink/data/handler/qcommerce/QCommerceDeeplinkHandler;", "navigator", "Lcom/talabat/core/navigation/domain/Navigator;", "talabatExperiment", "Lcom/talabat/core/experiment/domain/ITalabatExperiment;", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "(Lcom/talabat/core/navigation/domain/Navigator;Lcom/talabat/core/experiment/domain/ITalabatExperiment;Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;)V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "canHandle", "", "parsedLinkModel", "Lcom/talabat/core/deeplink/data/ParsedLinkModel;", "(Lcom/talabat/core/deeplink/data/ParsedLinkModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handle", "", "context", "Landroid/content/Context;", "com_talabat_core_deeplink_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class QCommerceBranchDeeplinkHandler extends QCommerceDeeplinkHandler {
    @NotNull
    private final String screenName = "mv";

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public QCommerceBranchDeeplinkHandler(@NotNull Navigator navigator, @NotNull ITalabatExperiment iTalabatExperiment, @NotNull IObservabilityManager iObservabilityManager) {
        super(navigator, iTalabatExperiment, iObservabilityManager);
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Intrinsics.checkNotNullParameter(iTalabatExperiment, "talabatExperiment");
        Intrinsics.checkNotNullParameter(iObservabilityManager, "observabilityManager");
    }

    @Nullable
    public Object canHandle(@NotNull ParsedLinkModel parsedLinkModel, @NotNull Continuation<? super Boolean> continuation) {
        if (!Intrinsics.areEqual((Object) parsedLinkModel.getScreenName(), (Object) getScreenName()) || !parsedLinkModel.getData().containsKey("bid")) {
            return Boxing.boxBoolean(false);
        }
        return super.canHandle(parsedLinkModel, continuation);
    }

    @NotNull
    public String getScreenName() {
        return this.screenName;
    }

    public void handle(@NotNull Context context, @NotNull ParsedLinkModel parsedLinkModel) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(parsedLinkModel, "parsedLinkModel");
        String str = parsedLinkModel.getData().get("bid");
        if (str == null) {
            str = "";
        }
        b(context, str, parsedLinkModel);
    }
}
