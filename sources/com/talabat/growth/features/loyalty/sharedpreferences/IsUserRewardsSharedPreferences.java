package com.talabat.growth.features.loyalty.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.SharedPreferencesManager;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \f2\u00020\u0001:\u0001\fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/talabat/growth/features/loyalty/sharedpreferences/IsUserRewardsSharedPreferences;", "Lcom/talabat/growth/features/loyalty/sharedpreferences/IsUserRewards;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "sharedPreferences", "Landroid/content/SharedPreferences;", "getIsUserEligibleForRewardsProgram", "", "saveIsUserEligibleForRewardsProgram", "", "value", "Companion", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class IsUserRewardsSharedPreferences implements IsUserRewards {
    @NotNull
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    @Deprecated
    public static final String IS_USER_ELIGIBLE_FOR_REWARDS_PROGRAM = "IS_USER_ELIGIBLE_FOR_REWARDS_PROGRAM";
    @NotNull
    private final SharedPreferences sharedPreferences;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/growth/features/loyalty/sharedpreferences/IsUserRewardsSharedPreferences$Companion;", "", "()V", "IS_USER_ELIGIBLE_FOR_REWARDS_PROGRAM", "", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public IsUserRewardsSharedPreferences(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences sharedPreferences2 = context.getSharedPreferences(SharedPreferencesManager.TALABAT_PREFERENCE, 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences2, "context.getSharedPrefere…ontext.MODE_PRIVATE\n    )");
        this.sharedPreferences = sharedPreferences2;
    }

    public boolean getIsUserEligibleForRewardsProgram() {
        return this.sharedPreferences.getBoolean(IS_USER_ELIGIBLE_FOR_REWARDS_PROGRAM, false);
    }

    public void saveIsUserEligibleForRewardsProgram(boolean z11) {
        this.sharedPreferences.edit().putBoolean(IS_USER_ELIGIBLE_FOR_REWARDS_PROGRAM, z11).apply();
    }
}
