package com.talabat.core.deeplink.data.handler.gem;

import android.content.Context;
import com.talabat.core.deeplink.data.ParsedLinkModel;
import com.talabat.core.deeplink.data.handler.Handler;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy;
import com.talabat.core.fwfprojectskeys.domain.projects.adex.AdExExperimentsKeys;
import com.talabat.core.navigation.domain.Navigator;
import com.talabat.core.navigation.domain.screen.gem.FlutterGemCollectionScreen;
import com.talabat.core.navigation.domain.screen.gem.GemCollectionEntrypoint;
import com.talabat.core.navigation.domain.screen.gem.GemCollectionScreen;
import com.talabat.flutter.CollectionFlutterActivityKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0019\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"Lcom/talabat/core/deeplink/data/handler/gem/GemCollectionHandler;", "Lcom/talabat/core/deeplink/data/handler/Handler;", "navigator", "Lcom/talabat/core/navigation/domain/Navigator;", "talabatExperiment", "Lcom/talabat/core/experiment/domain/ITalabatExperiment;", "(Lcom/talabat/core/navigation/domain/Navigator;Lcom/talabat/core/experiment/domain/ITalabatExperiment;)V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "canHandle", "", "parsedLinkModel", "Lcom/talabat/core/deeplink/data/ParsedLinkModel;", "(Lcom/talabat/core/deeplink/data/ParsedLinkModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handle", "", "context", "Landroid/content/Context;", "com_talabat_core_deeplink_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GemCollectionHandler implements Handler {
    @NotNull
    private final Navigator navigator;
    @NotNull
    private final String screenName = "gem-collection";
    @NotNull
    private final ITalabatExperiment talabatExperiment;

    public GemCollectionHandler(@NotNull Navigator navigator2, @NotNull ITalabatExperiment iTalabatExperiment) {
        Intrinsics.checkNotNullParameter(navigator2, "navigator");
        Intrinsics.checkNotNullParameter(iTalabatExperiment, "talabatExperiment");
        this.navigator = navigator2;
        this.talabatExperiment = iTalabatExperiment;
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
        GemCollectionEntrypoint gemCollectionEntrypoint;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(parsedLinkModel, "parsedLinkModel");
        if (Intrinsics.areEqual((Object) CollectionFlutterActivityKt.FROM_FOOD_LIST, (Object) parsedLinkModel.getData().get("entrypoint"))) {
            gemCollectionEntrypoint = GemCollectionEntrypoint.FOOD_LIST;
        } else {
            gemCollectionEntrypoint = GemCollectionEntrypoint.HOME;
        }
        if (!Intrinsics.areEqual((Object) this.talabatExperiment.getStringVariant(AdExExperimentsKeys.SHOW_FLUTTER_GEM_COLLECTION, "Control", TalabatExperimentDataSourceStrategy.FWF), (Object) "Control")) {
            Navigator.DefaultImpls.navigateTo$default(this.navigator, context, new FlutterGemCollectionScreen(new FlutterGemCollectionScreen.FlutterGemCollectionData(gemCollectionEntrypoint)), (Function1) null, 4, (Object) null);
            return;
        }
        Navigator.DefaultImpls.navigateTo$default(this.navigator, context, new GemCollectionScreen(new GemCollectionScreen.GemCollectionData(gemCollectionEntrypoint)), (Function1) null, 4, (Object) null);
    }
}
