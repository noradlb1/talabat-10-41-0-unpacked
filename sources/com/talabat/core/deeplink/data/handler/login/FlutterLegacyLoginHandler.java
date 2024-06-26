package com.talabat.core.deeplink.data.handler.login;

import android.content.Context;
import com.talabat.core.deeplink.data.ParsedLinkModel;
import com.talabat.core.deeplink.data.handler.Handler;
import com.talabat.core.navigation.domain.Navigator;
import com.talabat.core.navigation.domain.screen.legacylogin.FlutterLegacyLoginScreen;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00122\u00020\u0001:\u0003\u0012\u0013\u0014B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0019\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH@ø\u0001\u0000¢\u0006\u0002\u0010\rJ\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"Lcom/talabat/core/deeplink/data/handler/login/FlutterLegacyLoginHandler;", "Lcom/talabat/core/deeplink/data/handler/Handler;", "navigator", "Lcom/talabat/core/navigation/domain/Navigator;", "(Lcom/talabat/core/navigation/domain/Navigator;)V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "canHandle", "", "parsedLinkModel", "Lcom/talabat/core/deeplink/data/ParsedLinkModel;", "(Lcom/talabat/core/deeplink/data/ParsedLinkModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handle", "", "context", "Landroid/content/Context;", "Companion", "GlobalConstants", "ScreenNames", "com_talabat_core_deeplink_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FlutterLegacyLoginHandler implements Handler {
    @NotNull
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    @Deprecated
    public static final String PARAM_EVENT_ORIGIN = "eventOrigin";
    @NotNull
    @Deprecated
    public static final String PARAM_SHOW_GUEST_CHECKOUT = "showGuestCheckout";
    @NotNull
    private final Navigator navigator;
    @NotNull
    private final String screenName = "legacy-login";

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/talabat/core/deeplink/data/handler/login/FlutterLegacyLoginHandler$Companion;", "", "()V", "PARAM_EVENT_ORIGIN", "", "PARAM_SHOW_GUEST_CHECKOUT", "com_talabat_core_deeplink_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/talabat/core/deeplink/data/handler/login/FlutterLegacyLoginHandler$GlobalConstants;", "", "()V", "EVENT_ORIGIN", "", "FROM", "FROM_HOME_SCREEN_MAP", "IS_GLR_ENABLED_RESTAURANT", "IS_TALABAT_DELIVERY_AVAILABLE", "MAP_COMPULSORY", "NINE_COOKIES_ENABLED", "REDIRECT_BACK", "REDIRECT_NAVIGATION", "com_talabat_core_deeplink_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class GlobalConstants {
        @NotNull
        public static final String EVENT_ORIGIN = "eventOrigin";
        @NotNull
        public static final String FROM = "from";
        @NotNull
        public static final String FROM_HOME_SCREEN_MAP = "isFromHomeScreenMap";
        @NotNull
        public static final GlobalConstants INSTANCE = new GlobalConstants();
        @NotNull
        public static final String IS_GLR_ENABLED_RESTAURANT = "isGlrEnabledRes";
        @NotNull
        public static final String IS_TALABAT_DELIVERY_AVAILABLE = "talabatDeliveryAvailable";
        @NotNull
        public static final String MAP_COMPULSORY = "map_compulsory";
        @NotNull
        public static final String NINE_COOKIES_ENABLED = "nineCookiesEnabled";
        @NotNull
        public static final String REDIRECT_BACK = "redirect_back";
        @NotNull
        public static final String REDIRECT_NAVIGATION = "redirect_navigation";

        private GlobalConstants() {
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/core/deeplink/data/handler/login/FlutterLegacyLoginHandler$ScreenNames;", "", "()V", "CART", "", "com_talabat_core_deeplink_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ScreenNames {
        @NotNull
        public static final String CART = "Cart Screen";
        @NotNull
        public static final ScreenNames INSTANCE = new ScreenNames();

        private ScreenNames() {
        }
    }

    public FlutterLegacyLoginHandler(@NotNull Navigator navigator2) {
        Intrinsics.checkNotNullParameter(navigator2, "navigator");
        this.navigator = navigator2;
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
        boolean z11;
        Boolean booleanStrictOrNull;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(parsedLinkModel, "parsedLinkModel");
        String str = parsedLinkModel.getData().get("eventOrigin");
        if (str == null) {
            str = "";
        }
        String str2 = parsedLinkModel.getData().get(PARAM_SHOW_GUEST_CHECKOUT);
        if (str2 != null) {
            String lowerCase = str2.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            if (!(lowerCase == null || (booleanStrictOrNull = StringsKt__StringsKt.toBooleanStrictOrNull(lowerCase)) == null)) {
                z11 = booleanStrictOrNull.booleanValue();
                this.navigator.navigateTo(context, new FlutterLegacyLoginScreen((Void) null, 1, (DefaultConstructorMarker) null), new FlutterLegacyLoginHandler$handle$1(str, z11));
            }
        }
        z11 = false;
        this.navigator.navigateTo(context, new FlutterLegacyLoginScreen((Void) null, 1, (DefaultConstructorMarker) null), new FlutterLegacyLoginHandler$handle$1(str, z11));
    }
}
