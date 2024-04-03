package com.talabat.splash.domain.model;

import com.talabat.configuration.language.Language;
import com.talabat.helpers.GlobalConstants;
import com.talabat.splash.core.exception.Failure;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b6\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\\\u001a\u00020\u00072\b\u0010]\u001a\u0004\u0018\u00010^R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0010\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\t\"\u0004\b\u0012\u0010\u000bR\u001a\u0010\u0013\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\t\"\u0004\b\u0015\u0010\u000bR\u001a\u0010\u0016\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\t\"\u0004\b\u0018\u0010\u000bR\u000e\u0010\u0019\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001eR\u001a\u0010\"\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001c\"\u0004\b$\u0010\u001eR\u000e\u0010%\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0011\u0010&\u001a\u00020'¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0014\u0010*\u001a\u00020\u0007XD¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\tR\u001a\u0010,\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\t\"\u0004\b.\u0010\u000bR\u0014\u0010/\u001a\u00020\u0007XD¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\tR\u001a\u00101\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\t\"\u0004\b3\u0010\u000bR\u0014\u00104\u001a\u00020\u0007XD¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\tR\u000e\u00106\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001a\u00108\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\t\"\u0004\b:\u0010\u000bR\u001a\u0010;\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\t\"\u0004\b=\u0010\u000bR\u001a\u0010>\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\t\"\u0004\b@\u0010\u000bR\u001a\u0010A\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\t\"\u0004\bC\u0010\u000bR\u001a\u0010D\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\t\"\u0004\bF\u0010\u000bR\u001a\u0010G\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\t\"\u0004\bI\u0010\u000bR\u001a\u0010J\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010\t\"\u0004\bL\u0010\u000bR\u001a\u0010M\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010\t\"\u0004\bO\u0010\u000bR\u001a\u0010P\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010\t\"\u0004\bR\u0010\u000bR\u001a\u0010S\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010\t\"\u0004\bU\u0010\u000bR\u001a\u0010V\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010\t\"\u0004\bX\u0010\u000bR\u001a\u0010Y\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010\t\"\u0004\b[\u0010\u000b¨\u0006_"}, d2 = {"Lcom/talabat/splash/domain/model/SplashDataUtils;", "", "()V", "AD_SCREEN", "", "COUNTRY_SELECTION_SCREEN", "DEEP_LINK_FLOW", "", "getDEEP_LINK_FLOW", "()I", "setDEEP_LINK_FLOW", "(I)V", "DEFAULT_COUNTRY_ID", "DIFFERED_DEEP_LINK", "getDIFFERED_DEEP_LINK", "setDIFFERED_DEEP_LINK", "DIFFERED_DEEP_LINK_FLOW", "getDIFFERED_DEEP_LINK_FLOW", "setDIFFERED_DEEP_LINK_FLOW", "DIFFERED_DEEP_LINK_WITH_WELCOME", "getDIFFERED_DEEP_LINK_WITH_WELCOME", "setDIFFERED_DEEP_LINK_WITH_WELCOME", "FORBIDDEN_ERROR_VIEW", "getFORBIDDEN_ERROR_VIEW", "setFORBIDDEN_ERROR_VIEW", "FORCE_UPDATE_SCREEN", "FWF_SPLASH_UI_VIEW_IMAGE", "getFWF_SPLASH_UI_VIEW_IMAGE", "()Ljava/lang/String;", "setFWF_SPLASH_UI_VIEW_IMAGE", "(Ljava/lang/String;)V", "FWF_SPLASH_UI_VIEW_TYPE_NORMAL_VIDEO", "getFWF_SPLASH_UI_VIEW_TYPE_NORMAL_VIDEO", "setFWF_SPLASH_UI_VIEW_TYPE_NORMAL_VIDEO", "FWF_SPLASH_UI_VIEW_TYPE_SPECIAL_VIDEO", "getFWF_SPLASH_UI_VIEW_TYPE_SPECIAL_VIDEO", "setFWF_SPLASH_UI_VIEW_TYPE_SPECIAL_VIDEO", "HOME_SCREEN", "LANGUAGE", "Lcom/talabat/configuration/language/Language;", "getLANGUAGE", "()Lcom/talabat/configuration/language/Language;", "LOCATION_GPS_DENY", "getLOCATION_GPS_DENY", "LOCATION_ONLY_REQUEST", "getLOCATION_ONLY_REQUEST", "setLOCATION_ONLY_REQUEST", "LOCATION_PERMISSION_DENY", "getLOCATION_PERMISSION_DENY", "LOCATION_RECEIVE_REQUEST", "getLOCATION_RECEIVE_REQUEST", "setLOCATION_RECEIVE_REQUEST", "LOCATION_SKIP", "getLOCATION_SKIP", "LOCATION_TRACKING_NOT_AVAIL", "NA", "NETWORK_ERROR_VEW", "getNETWORK_ERROR_VEW", "setNETWORK_ERROR_VEW", "NORMAL_DEEP_LINK", "getNORMAL_DEEP_LINK", "setNORMAL_DEEP_LINK", "NORMAL_FLOW", "getNORMAL_FLOW", "setNORMAL_FLOW", "NORMAL_WELCOME_DENY_FLOW", "getNORMAL_WELCOME_DENY_FLOW", "setNORMAL_WELCOME_DENY_FLOW", "NORMAL_WELCOME_FLOW", "getNORMAL_WELCOME_FLOW", "setNORMAL_WELCOME_FLOW", "NORMAL_WELCOME_SUCCESS_FLOW", "getNORMAL_WELCOME_SUCCESS_FLOW", "setNORMAL_WELCOME_SUCCESS_FLOW", "SERVER_ERROR_VIEW", "getSERVER_ERROR_VIEW", "setSERVER_ERROR_VIEW", "SPLASH_UI_IMAGE", "getSPLASH_UI_IMAGE", "setSPLASH_UI_IMAGE", "SPLASH_UI_NORMAL_VIDEO", "getSPLASH_UI_NORMAL_VIDEO", "setSPLASH_UI_NORMAL_VIDEO", "SPLASH_UI_SPECIAL_OCCASION_VIDEO", "getSPLASH_UI_SPECIAL_OCCASION_VIDEO", "setSPLASH_UI_SPECIAL_OCCASION_VIDEO", "TIMEOUT_ERROR_VIEW", "getTIMEOUT_ERROR_VIEW", "setTIMEOUT_ERROR_VIEW", "UNAUTHORIZED_ERROR_VIEW", "getUNAUTHORIZED_ERROR_VIEW", "setUNAUTHORIZED_ERROR_VIEW", "netWorkErrorCode", "failure", "Lcom/talabat/splash/core/exception/Failure;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SplashDataUtils {
    @NotNull
    public static final String AD_SCREEN = "Ad Screen";
    @NotNull
    public static final String COUNTRY_SELECTION_SCREEN = "Country Selection Screen";
    private static int DEEP_LINK_FLOW = 71;
    public static final int DEFAULT_COUNTRY_ID = 0;
    private static int DIFFERED_DEEP_LINK = 91;
    private static int DIFFERED_DEEP_LINK_FLOW = 72;
    private static int DIFFERED_DEEP_LINK_WITH_WELCOME = 73;
    private static int FORBIDDEN_ERROR_VIEW = 93;
    @NotNull
    public static final String FORCE_UPDATE_SCREEN = "Force Update Screen";
    @NotNull
    private static String FWF_SPLASH_UI_VIEW_IMAGE = "Image_splash";
    @NotNull
    private static String FWF_SPLASH_UI_VIEW_TYPE_NORMAL_VIDEO = "Normal_video_splash";
    @NotNull
    private static String FWF_SPLASH_UI_VIEW_TYPE_SPECIAL_VIDEO = "Special_occasion_Splash";
    @NotNull
    public static final String HOME_SCREEN = "Home Screen";
    @NotNull
    public static final SplashDataUtils INSTANCE = new SplashDataUtils();
    @NotNull
    private static final Language LANGUAGE = Language.UNKNOWN;
    private static final int LOCATION_GPS_DENY = 81;
    private static int LOCATION_ONLY_REQUEST = 83;
    private static final int LOCATION_PERMISSION_DENY = 80;
    private static int LOCATION_RECEIVE_REQUEST = 84;
    private static final int LOCATION_SKIP = 82;
    @NotNull
    public static final String LOCATION_TRACKING_NOT_AVAIL = "N/A";
    @NotNull
    public static final String NA = "NA";
    private static int NETWORK_ERROR_VEW = 90;
    private static int NORMAL_DEEP_LINK = 90;
    private static int NORMAL_FLOW = 70;
    private static int NORMAL_WELCOME_DENY_FLOW = 76;
    private static int NORMAL_WELCOME_FLOW = 74;
    private static int NORMAL_WELCOME_SUCCESS_FLOW = 75;
    private static int SERVER_ERROR_VIEW = 91;
    private static int SPLASH_UI_IMAGE;
    private static int SPLASH_UI_NORMAL_VIDEO = 1;
    private static int SPLASH_UI_SPECIAL_OCCASION_VIDEO = 2;
    private static int TIMEOUT_ERROR_VIEW = 94;
    private static int UNAUTHORIZED_ERROR_VIEW = 92;

    private SplashDataUtils() {
    }

    public final int getDEEP_LINK_FLOW() {
        return DEEP_LINK_FLOW;
    }

    public final int getDIFFERED_DEEP_LINK() {
        return DIFFERED_DEEP_LINK;
    }

    public final int getDIFFERED_DEEP_LINK_FLOW() {
        return DIFFERED_DEEP_LINK_FLOW;
    }

    public final int getDIFFERED_DEEP_LINK_WITH_WELCOME() {
        return DIFFERED_DEEP_LINK_WITH_WELCOME;
    }

    public final int getFORBIDDEN_ERROR_VIEW() {
        return FORBIDDEN_ERROR_VIEW;
    }

    @NotNull
    public final String getFWF_SPLASH_UI_VIEW_IMAGE() {
        return FWF_SPLASH_UI_VIEW_IMAGE;
    }

    @NotNull
    public final String getFWF_SPLASH_UI_VIEW_TYPE_NORMAL_VIDEO() {
        return FWF_SPLASH_UI_VIEW_TYPE_NORMAL_VIDEO;
    }

    @NotNull
    public final String getFWF_SPLASH_UI_VIEW_TYPE_SPECIAL_VIDEO() {
        return FWF_SPLASH_UI_VIEW_TYPE_SPECIAL_VIDEO;
    }

    @NotNull
    public final Language getLANGUAGE() {
        return LANGUAGE;
    }

    public final int getLOCATION_GPS_DENY() {
        return LOCATION_GPS_DENY;
    }

    public final int getLOCATION_ONLY_REQUEST() {
        return LOCATION_ONLY_REQUEST;
    }

    public final int getLOCATION_PERMISSION_DENY() {
        return LOCATION_PERMISSION_DENY;
    }

    public final int getLOCATION_RECEIVE_REQUEST() {
        return LOCATION_RECEIVE_REQUEST;
    }

    public final int getLOCATION_SKIP() {
        return LOCATION_SKIP;
    }

    public final int getNETWORK_ERROR_VEW() {
        return NETWORK_ERROR_VEW;
    }

    public final int getNORMAL_DEEP_LINK() {
        return NORMAL_DEEP_LINK;
    }

    public final int getNORMAL_FLOW() {
        return NORMAL_FLOW;
    }

    public final int getNORMAL_WELCOME_DENY_FLOW() {
        return NORMAL_WELCOME_DENY_FLOW;
    }

    public final int getNORMAL_WELCOME_FLOW() {
        return NORMAL_WELCOME_FLOW;
    }

    public final int getNORMAL_WELCOME_SUCCESS_FLOW() {
        return NORMAL_WELCOME_SUCCESS_FLOW;
    }

    public final int getSERVER_ERROR_VIEW() {
        return SERVER_ERROR_VIEW;
    }

    public final int getSPLASH_UI_IMAGE() {
        return SPLASH_UI_IMAGE;
    }

    public final int getSPLASH_UI_NORMAL_VIDEO() {
        return SPLASH_UI_NORMAL_VIDEO;
    }

    public final int getSPLASH_UI_SPECIAL_OCCASION_VIDEO() {
        return SPLASH_UI_SPECIAL_OCCASION_VIDEO;
    }

    public final int getTIMEOUT_ERROR_VIEW() {
        return TIMEOUT_ERROR_VIEW;
    }

    public final int getUNAUTHORIZED_ERROR_VIEW() {
        return UNAUTHORIZED_ERROR_VIEW;
    }

    public final int netWorkErrorCode(@Nullable Failure failure) {
        if (failure instanceof Failure.NetworkConnection) {
            return GlobalConstants.serverErrorCode.NO_INTERNET_CONNECTION_CODE;
        }
        if (failure instanceof Failure.ServerError) {
            return GlobalConstants.serverErrorCode.NOT_RESPONDING_ERROR_CODE;
        }
        if (failure instanceof Failure.BadRequest) {
            return GlobalConstants.serverErrorCode.CONNECTION_FAILED_ERROR_CODE;
        }
        if (failure instanceof Failure.Unauthorized) {
            return GlobalConstants.serverErrorCode.GEO_BLOCK_ERROR_CODE;
        }
        if (failure instanceof Failure.Forbidden) {
            return GlobalConstants.serverErrorCode.GEO_BLOCK_ERROR_CODE;
        }
        if (failure instanceof Failure.NotFound) {
            return GlobalConstants.serverErrorCode.NOT_RESPONDING_ERROR_CODE;
        }
        if (failure instanceof Failure.InternalServerError) {
            return GlobalConstants.serverErrorCode.NOT_RESPONDING_ERROR_CODE;
        }
        if (failure instanceof Failure.UnKnownError) {
            return GlobalConstants.serverErrorCode.CONNECTION_FAILED_ERROR_CODE;
        }
        if (failure instanceof Failure.TimeOutError) {
            return GlobalConstants.serverErrorCode.CONNECTION_TIMED_OUT_CODE;
        }
        return GlobalConstants.serverErrorCode.NO_INTERNET_CONNECTION_CODE;
    }

    public final void setDEEP_LINK_FLOW(int i11) {
        DEEP_LINK_FLOW = i11;
    }

    public final void setDIFFERED_DEEP_LINK(int i11) {
        DIFFERED_DEEP_LINK = i11;
    }

    public final void setDIFFERED_DEEP_LINK_FLOW(int i11) {
        DIFFERED_DEEP_LINK_FLOW = i11;
    }

    public final void setDIFFERED_DEEP_LINK_WITH_WELCOME(int i11) {
        DIFFERED_DEEP_LINK_WITH_WELCOME = i11;
    }

    public final void setFORBIDDEN_ERROR_VIEW(int i11) {
        FORBIDDEN_ERROR_VIEW = i11;
    }

    public final void setFWF_SPLASH_UI_VIEW_IMAGE(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        FWF_SPLASH_UI_VIEW_IMAGE = str;
    }

    public final void setFWF_SPLASH_UI_VIEW_TYPE_NORMAL_VIDEO(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        FWF_SPLASH_UI_VIEW_TYPE_NORMAL_VIDEO = str;
    }

    public final void setFWF_SPLASH_UI_VIEW_TYPE_SPECIAL_VIDEO(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        FWF_SPLASH_UI_VIEW_TYPE_SPECIAL_VIDEO = str;
    }

    public final void setLOCATION_ONLY_REQUEST(int i11) {
        LOCATION_ONLY_REQUEST = i11;
    }

    public final void setLOCATION_RECEIVE_REQUEST(int i11) {
        LOCATION_RECEIVE_REQUEST = i11;
    }

    public final void setNETWORK_ERROR_VEW(int i11) {
        NETWORK_ERROR_VEW = i11;
    }

    public final void setNORMAL_DEEP_LINK(int i11) {
        NORMAL_DEEP_LINK = i11;
    }

    public final void setNORMAL_FLOW(int i11) {
        NORMAL_FLOW = i11;
    }

    public final void setNORMAL_WELCOME_DENY_FLOW(int i11) {
        NORMAL_WELCOME_DENY_FLOW = i11;
    }

    public final void setNORMAL_WELCOME_FLOW(int i11) {
        NORMAL_WELCOME_FLOW = i11;
    }

    public final void setNORMAL_WELCOME_SUCCESS_FLOW(int i11) {
        NORMAL_WELCOME_SUCCESS_FLOW = i11;
    }

    public final void setSERVER_ERROR_VIEW(int i11) {
        SERVER_ERROR_VIEW = i11;
    }

    public final void setSPLASH_UI_IMAGE(int i11) {
        SPLASH_UI_IMAGE = i11;
    }

    public final void setSPLASH_UI_NORMAL_VIDEO(int i11) {
        SPLASH_UI_NORMAL_VIDEO = i11;
    }

    public final void setSPLASH_UI_SPECIAL_OCCASION_VIDEO(int i11) {
        SPLASH_UI_SPECIAL_OCCASION_VIDEO = i11;
    }

    public final void setTIMEOUT_ERROR_VIEW(int i11) {
        TIMEOUT_ERROR_VIEW = i11;
    }

    public final void setUNAUTHORIZED_ERROR_VIEW(int i11) {
        UNAUTHORIZED_ERROR_VIEW = i11;
    }
}
