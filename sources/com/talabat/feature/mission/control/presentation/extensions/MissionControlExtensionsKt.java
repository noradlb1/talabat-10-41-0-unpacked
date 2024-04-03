package com.talabat.feature.mission.control.presentation.extensions;

import android.content.Context;
import android.graphics.Color;
import androidx.core.content.ContextCompat;
import com.designsystem.marshmallow.R;
import com.talabat.feature.darkstores.vendorlanding.domain.model.LifestyleMissionItem;
import com.talabat.feature.mission.control.domain.model.LifeStyleMissionControlData;
import com.talabat.feature.mission.control.domain.model.PrimaryMissionControlData;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0001H\u0002\u001a\u0012\u0010\u000f\u001a\u00020\u000b*\u00020\u00102\u0006\u0010\f\u001a\u00020\r\u001a\u0012\u0010\u000f\u001a\u00020\u000b*\u00020\u00112\u0006\u0010\f\u001a\u00020\r\u001a\n\u0010\u0012\u001a\u00020\u000b*\u00020\u0013\u001a\n\u0010\u0014\u001a\u00020\u000b*\u00020\u0013\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"PRIMARY_MISSION_CODE_ANNOUNCEMENT", "", "PRIMARY_MISSION_CODE_DELIVERY_BIKE", "PRIMARY_MISSION_CODE_FAVORITE", "PRIMARY_MISSION_CODE_GLOBE", "PRIMARY_MISSION_CODE_PROMO", "PRIMARY_MISSION_CODE_REORDER", "PRIMARY_MISSION_CODE_STAR", "PRIMARY_MISSION_CODE_THUMBS_UP", "PRIMARY_MISSION_CODE_TRENDING", "getColor", "", "context", "Landroid/content/Context;", "bgColor", "getBackgroundColor", "Lcom/talabat/feature/darkstores/vendorlanding/domain/model/LifestyleMissionItem;", "Lcom/talabat/feature/mission/control/domain/model/LifeStyleMissionControlData;", "getIcon", "Lcom/talabat/feature/mission/control/domain/model/PrimaryMissionControlData;", "getNewIcon", "com_talabat_feature_mission-control_presentation_presentation"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class MissionControlExtensionsKt {
    @NotNull
    private static final String PRIMARY_MISSION_CODE_ANNOUNCEMENT = "announcement";
    @NotNull
    private static final String PRIMARY_MISSION_CODE_DELIVERY_BIKE = "deliveryBike";
    @NotNull
    private static final String PRIMARY_MISSION_CODE_FAVORITE = "favorite";
    @NotNull
    private static final String PRIMARY_MISSION_CODE_GLOBE = "globe";
    @NotNull
    private static final String PRIMARY_MISSION_CODE_PROMO = "promo";
    @NotNull
    private static final String PRIMARY_MISSION_CODE_REORDER = "reorder";
    @NotNull
    private static final String PRIMARY_MISSION_CODE_STAR = "star";
    @NotNull
    private static final String PRIMARY_MISSION_CODE_THUMBS_UP = "thumbsUp";
    @NotNull
    private static final String PRIMARY_MISSION_CODE_TRENDING = "trending";

    public static final int getBackgroundColor(@NotNull LifeStyleMissionControlData lifeStyleMissionControlData, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(lifeStyleMissionControlData, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        return getColor(context, lifeStyleMissionControlData.getBgColor());
    }

    private static final int getColor(Context context, String str) {
        Integer num;
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            num = Result.m6329constructorimpl(Integer.valueOf(Color.parseColor(str)));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            num = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        if (Result.m6332exceptionOrNullimpl(num) != null) {
            try {
                obj = Result.m6329constructorimpl(Integer.valueOf(Color.parseColor("#" + str)));
            } catch (Throwable th3) {
                Result.Companion companion3 = Result.Companion;
                obj = Result.m6329constructorimpl(ResultKt.createFailure(th3));
            }
            num = obj;
        }
        Integer valueOf = Integer.valueOf(ContextCompat.getColor(context, R.color.ds_secondary_4));
        if (Result.m6335isFailureimpl(num)) {
            num = valueOf;
        }
        return ((Number) num).intValue();
    }

    public static final int getIcon(@NotNull PrimaryMissionControlData primaryMissionControlData) {
        Intrinsics.checkNotNullParameter(primaryMissionControlData, "<this>");
        String iconType = primaryMissionControlData.getIconType();
        switch (iconType.hashCode()) {
            case 3540562:
                if (iconType.equals(PRIMARY_MISSION_CODE_STAR)) {
                    return R.drawable.ds_star;
                }
                break;
            case 98449901:
                if (iconType.equals(PRIMARY_MISSION_CODE_GLOBE)) {
                    return R.drawable.ds_country;
                }
                break;
            case 106940687:
                if (iconType.equals("promo")) {
                    return R.drawable.ds_promo;
                }
                break;
            case 156781895:
                if (iconType.equals("announcement")) {
                    return R.drawable.ds_announcement;
                }
                break;
            case 681417205:
                if (iconType.equals(PRIMARY_MISSION_CODE_DELIVERY_BIKE)) {
                    return R.drawable.ds_delivery_bike;
                }
                break;
            case 1050790300:
                if (iconType.equals(PRIMARY_MISSION_CODE_FAVORITE)) {
                    return R.drawable.ds_favorite;
                }
                break;
            case 1093755131:
                if (iconType.equals("reorder")) {
                    return R.drawable.ds_reorder;
                }
                break;
            case 1394955557:
                if (iconType.equals(PRIMARY_MISSION_CODE_TRENDING)) {
                    return R.drawable.ds_trending;
                }
                break;
            case 1566945496:
                if (iconType.equals(PRIMARY_MISSION_CODE_THUMBS_UP)) {
                    return R.drawable.ds_thumbs_up;
                }
                break;
        }
        return R.drawable.ds_star;
    }

    public static final int getNewIcon(@NotNull PrimaryMissionControlData primaryMissionControlData) {
        Intrinsics.checkNotNullParameter(primaryMissionControlData, "<this>");
        String iconType = primaryMissionControlData.getIconType();
        switch (iconType.hashCode()) {
            case 3540562:
                if (iconType.equals(PRIMARY_MISSION_CODE_STAR)) {
                    return com.talabat.feature.mission.control.presentation.R.drawable.ic_primary_mission_star;
                }
                break;
            case 98449901:
                if (iconType.equals(PRIMARY_MISSION_CODE_GLOBE)) {
                    return com.talabat.feature.mission.control.presentation.R.drawable.ic_primary_mission_globe;
                }
                break;
            case 106940687:
                if (iconType.equals("promo")) {
                    return com.talabat.feature.mission.control.presentation.R.drawable.ic_primary_mission_promo;
                }
                break;
            case 156781895:
                if (iconType.equals("announcement")) {
                    return com.talabat.feature.mission.control.presentation.R.drawable.ic_primary_mission_announcement;
                }
                break;
            case 681417205:
                if (iconType.equals(PRIMARY_MISSION_CODE_DELIVERY_BIKE)) {
                    return com.talabat.feature.mission.control.presentation.R.drawable.ic_primary_mission_delivery_bike;
                }
                break;
            case 1050790300:
                if (iconType.equals(PRIMARY_MISSION_CODE_FAVORITE)) {
                    return com.talabat.feature.mission.control.presentation.R.drawable.ic_primary_mission_favorite;
                }
                break;
            case 1093755131:
                if (iconType.equals("reorder")) {
                    return com.talabat.feature.mission.control.presentation.R.drawable.ic_primary_mission_reorder;
                }
                break;
            case 1394955557:
                if (iconType.equals(PRIMARY_MISSION_CODE_TRENDING)) {
                    return com.talabat.feature.mission.control.presentation.R.drawable.ic_primary_mission_trending;
                }
                break;
            case 1566945496:
                if (iconType.equals(PRIMARY_MISSION_CODE_THUMBS_UP)) {
                    return com.talabat.feature.mission.control.presentation.R.drawable.ic_primary_mission_thumbs_up;
                }
                break;
        }
        return com.talabat.feature.mission.control.presentation.R.drawable.ic_primary_mission_star;
    }

    public static final int getBackgroundColor(@NotNull LifestyleMissionItem lifestyleMissionItem, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(lifestyleMissionItem, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        return getColor(context, lifestyleMissionItem.getBgColor());
    }
}
