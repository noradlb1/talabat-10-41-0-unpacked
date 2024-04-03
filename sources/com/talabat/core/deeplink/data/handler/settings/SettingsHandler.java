package com.talabat.core.deeplink.data.handler.settings;

import android.content.Context;
import android.os.Parcelable;
import com.talabat.core.deeplink.data.ParsedLinkModel;
import com.talabat.core.deeplink.data.handler.Handler;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy;
import com.talabat.core.fwfprojectskeys.domain.projects.user.UserExperimentsKeys;
import com.talabat.core.navigation.domain.Navigator;
import com.talabat.core.navigation.domain.screen.flutter.FlutterScreen;
import com.talabat.core.navigation.domain.screen.settings.SettingsScreen;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0019\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH@ø\u0001\u0000¢\u0006\u0002\u0010\u0010J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0015\u001a\u00020\rH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"Lcom/talabat/core/deeplink/data/handler/settings/SettingsHandler;", "Lcom/talabat/core/deeplink/data/handler/Handler;", "navigator", "Lcom/talabat/core/navigation/domain/Navigator;", "talabatExperiment", "Lcom/talabat/core/experiment/domain/ITalabatExperiment;", "(Lcom/talabat/core/navigation/domain/Navigator;Lcom/talabat/core/experiment/domain/ITalabatExperiment;)V", "oldScreenName", "", "screenName", "getScreenName", "()Ljava/lang/String;", "canHandle", "", "parsedLinkModel", "Lcom/talabat/core/deeplink/data/ParsedLinkModel;", "(Lcom/talabat/core/deeplink/data/ParsedLinkModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handle", "", "context", "Landroid/content/Context;", "isFlutterSettingsEnabled", "Companion", "com_talabat_core_deeplink_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SettingsHandler implements Handler {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String FLUTTER_DISABLED = "Control";
    @NotNull
    public static final String FLUTTER_ENABLED = "Variation1";
    @NotNull
    private final Navigator navigator;
    @NotNull
    private final String oldScreenName = "ss";
    @NotNull
    private final String screenName = "settings";
    @NotNull
    private final ITalabatExperiment talabatExperiment;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/talabat/core/deeplink/data/handler/settings/SettingsHandler$Companion;", "", "()V", "FLUTTER_DISABLED", "", "FLUTTER_ENABLED", "com_talabat_core_deeplink_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public SettingsHandler(@NotNull Navigator navigator2, @NotNull ITalabatExperiment iTalabatExperiment) {
        Intrinsics.checkNotNullParameter(navigator2, "navigator");
        Intrinsics.checkNotNullParameter(iTalabatExperiment, "talabatExperiment");
        this.navigator = navigator2;
        this.talabatExperiment = iTalabatExperiment;
    }

    private final boolean isFlutterSettingsEnabled() {
        return Intrinsics.areEqual((Object) this.talabatExperiment.getStringVariant(UserExperimentsKeys.EXP_USER_FLUTTER_SETTINGS_SCREEN, "Control", TalabatExperimentDataSourceStrategy.FWF), (Object) "Variation1");
    }

    @Nullable
    public Object canHandle(@NotNull ParsedLinkModel parsedLinkModel, @NotNull Continuation<? super Boolean> continuation) {
        boolean z11;
        if (Intrinsics.areEqual((Object) parsedLinkModel.getScreenName(), (Object) getScreenName()) || Intrinsics.areEqual((Object) parsedLinkModel.getScreenName(), (Object) this.oldScreenName)) {
            z11 = true;
        } else {
            z11 = false;
        }
        return Boxing.boxBoolean(z11);
    }

    @NotNull
    public String getScreenName() {
        return this.screenName;
    }

    public void handle(@NotNull Context context, @NotNull ParsedLinkModel parsedLinkModel) {
        boolean z11;
        boolean z12;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(parsedLinkModel, "parsedLinkModel");
        String str = parsedLinkModel.getData().get("open_language");
        if (str != null) {
            z11 = Boolean.parseBoolean(str);
        } else {
            z11 = false;
        }
        String str2 = parsedLinkModel.getData().get("hide_menu");
        if (str2 != null) {
            z12 = Boolean.parseBoolean(str2);
        } else {
            z12 = true;
        }
        if (isFlutterSettingsEnabled()) {
            Navigator.DefaultImpls.navigateTo$default(this.navigator, context, new FlutterScreen(new FlutterScreen.FlutterScreenData("talabat://?s=" + getScreenName() + "&open_language=" + z11 + "&hide_menu=" + z12)), (Function1) null, 4, (Object) null);
            return;
        }
        this.navigator.navigateTo(context, new SettingsScreen((Parcelable) null, 1, (DefaultConstructorMarker) null), new SettingsHandler$handle$1(z12, z11));
    }
}
