package com.talabat.talabatnavigation.verticalsSquad;

import android.os.Bundle;
import com.talabat.talabatnavigation.base.NavigatorModel;
import com.tekartik.sqflite.Constant;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/talabat/talabatnavigation/verticalsSquad/VerticalsNavigatorActions;", "", "()V", "Companion", "com_talabat_NewArchi_TalabatNavigation_TalabatNavigation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VerticalsNavigatorActions {
    @NotNull
    public static final String ACTION_VERTICALS_DARKSTORES_BRIDGE = "talabat.action.Verticals.darkstores.bridge";
    @NotNull
    public static final String ACTION__HOME_SCREEN_ACTIVITY = "talabat.action.homeScreen";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String EXTRA_VERTICALS_DARKSTORES_BRIDGE = "darkstores_bridge_model";
    @NotNull
    public static final String EXTRA_VERTICALS_DARKSTORES_BRIDGE_RESTAURANT = "darkstores_bridge_restaurant";

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/talabat/talabatnavigation/verticalsSquad/VerticalsNavigatorActions$Companion;", "", "()V", "ACTION_VERTICALS_DARKSTORES_BRIDGE", "", "ACTION__HOME_SCREEN_ACTIVITY", "EXTRA_VERTICALS_DARKSTORES_BRIDGE", "EXTRA_VERTICALS_DARKSTORES_BRIDGE_RESTAURANT", "createNavigatorModelForDarkstoresBridge", "Lcom/talabat/talabatnavigation/base/NavigatorModel;", "arguments", "Landroid/os/Bundle;", "com_talabat_NewArchi_TalabatNavigation_TalabatNavigation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final NavigatorModel createNavigatorModelForDarkstoresBridge(@NotNull Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, Constant.PARAM_SQL_ARGUMENTS);
            return new NavigatorModel(VerticalsNavigatorActions.ACTION_VERTICALS_DARKSTORES_BRIDGE, bundle, (Function1) null, 4, (DefaultConstructorMarker) null);
        }
    }
}
