package com.talabat.core.deeplink.data.handler.rewards;

import android.content.Context;
import com.talabat.core.deeplink.data.ParsedLinkModel;
import com.talabat.core.deeplink.data.handler.Handler;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.fwfprojectskeys.domain.projects.ecosystems.EcosystemsFeatureFlagsKeys;
import com.talabat.core.navigation.domain.Navigator;
import com.talabat.core.navigation.domain.screen.Screen;
import com.talabat.core.navigation.domain.screen.flutter.FlutterScreen;
import com.talabat.core.navigation.domain.screen.rewards.LoyaltyDashboardScreen;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0019\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\u001c\u0010\u0010\u001a\u00020\b2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0012H\u0002J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u0017\u001a\u00020\fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0019"}, d2 = {"Lcom/talabat/core/deeplink/data/handler/rewards/LoyaltyDashboardHandler;", "Lcom/talabat/core/deeplink/data/handler/Handler;", "navigator", "Lcom/talabat/core/navigation/domain/Navigator;", "talabatFeatureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "(Lcom/talabat/core/navigation/domain/Navigator;Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;)V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "canHandle", "", "parsedLinkModel", "Lcom/talabat/core/deeplink/data/ParsedLinkModel;", "(Lcom/talabat/core/deeplink/data/ParsedLinkModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getEventOrigin", "data", "", "handle", "", "context", "Landroid/content/Context;", "isFlutterDashboardEnabled", "Companion", "com_talabat_core_deeplink_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LoyaltyDashboardHandler implements Handler {
    @NotNull
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    @Deprecated
    public static final String EVENT_ORIGIN = "eventOrigin";
    /* access modifiers changed from: private */
    @NotNull
    @Deprecated
    public static final Function1<String, String> FLUTTER_REWARDS_DASHBOARD_DEEPLINK = LoyaltyDashboardHandler$Companion$FLUTTER_REWARDS_DASHBOARD_DEEPLINK$1.INSTANCE;
    @NotNull
    private final Navigator navigator;
    @NotNull
    private final String screenName = "loyalty";
    @NotNull
    private final ITalabatFeatureFlag talabatFeatureFlag;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R,\u0010\u0005\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/talabat/core/deeplink/data/handler/rewards/LoyaltyDashboardHandler$Companion;", "", "()V", "EVENT_ORIGIN", "", "FLUTTER_REWARDS_DASHBOARD_DEEPLINK", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "eventOrigin", "getFLUTTER_REWARDS_DASHBOARD_DEEPLINK", "()Lkotlin/jvm/functions/Function1;", "com_talabat_core_deeplink_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Function1<String, String> getFLUTTER_REWARDS_DASHBOARD_DEEPLINK() {
            return LoyaltyDashboardHandler.FLUTTER_REWARDS_DASHBOARD_DEEPLINK;
        }
    }

    public LoyaltyDashboardHandler(@NotNull Navigator navigator2, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Intrinsics.checkNotNullParameter(navigator2, "navigator");
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "talabatFeatureFlag");
        this.navigator = navigator2;
        this.talabatFeatureFlag = iTalabatFeatureFlag;
    }

    private final String getEventOrigin(Map<String, String> map) {
        String str = map.get("eventOrigin");
        if (str == null) {
            return LoyaltyDashboardScreen.RewardsCatalogueOrigin.CRM.getEventOrigin();
        }
        return str;
    }

    private final boolean isFlutterDashboardEnabled() {
        return ITalabatFeatureFlag.DefaultImpls.getFeatureFlag$default(this.talabatFeatureFlag, EcosystemsFeatureFlagsKeys.IS_FLUTTER_REWARDS_DASHBOARD_ENABLED, false, 2, (Object) null);
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
        Screen screen;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(parsedLinkModel, "parsedLinkModel");
        String eventOrigin = getEventOrigin(parsedLinkModel.getData());
        if (isFlutterDashboardEnabled()) {
            screen = new FlutterScreen(new FlutterScreen.FlutterScreenData(FLUTTER_REWARDS_DASHBOARD_DEEPLINK.invoke(eventOrigin)));
        } else {
            screen = new LoyaltyDashboardScreen(new LoyaltyDashboardScreen.LoyaltyDashboardData(eventOrigin));
        }
        Navigator.DefaultImpls.navigateTo$default(this.navigator, context, screen, (Function1) null, 4, (Object) null);
    }
}
