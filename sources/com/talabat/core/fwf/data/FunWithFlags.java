package com.talabat.core.fwf.data;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import com.google.gson.JsonObject;
import com.google.gson.internal.LinkedTreeMap;
import com.talabat.configuration.country.Country;
import com.talabat.core.fwf.data.observability.FunWithFlagsObservability;
import com.talabat.core.fwf.data.observability.FunWithFlagsObservabilityImpl;
import com.talabat.core.fwf.data.sdkwrapper.FunWithFlagsSdkWrapper;
import com.talabat.core.fwf.domain.FunWithFlagsTrackingPort;
import com.talabat.core.fwf.domain.IFunWithFlags;
import com.talabat.core.fwf.domain.config.FunWithFlagsConfig;
import com.talabat.core.fwfprojectskeys.domain.FWFKey;
import com.talabat.core.fwfprojectskeys.domain.FWFProject;
import com.talabat.core.fwfprojectskeys.domain.FWFProjectName;
import com.talabat.darkstores.feature.main.DarkstoresMainActivity;
import com.talabat.secrets.Secrets;
import com.talabat.sidemenu.SideMenuRewardViewHolder;
import fwfd.com.fwfsdk.model.db.FWFFallback;
import fwfd.com.fwfsdk.model.db.FWFResult;
import fwfd.com.fwfsdk.model.db.FWFResultTrackInfo;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.bytebuddy.utility.JavaConstant;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sg.a;
import sg.b;

@Metadata(d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010&\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b'\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0018\bÆ\u0002\u0018\u00002\u00020\u0001B\u000b\b\u0002¢\u0006\u0006\b\u0001\u0010\u0001JK\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\b\b\u0002\u0010\n\u001a\u00020\t2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ4\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\f0\u0015H\u0016J\u0018\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J'\u0010\u001e\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u0018H\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u0012\u0010\u001f\u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u001a\u0010 \u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J?\u0010#\u001a\u00020\f2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0\u00062\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH\u0002¢\u0006\u0004\b#\u0010$J\u001d\u0010%\u001a\u00020\f2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0\u0006H\u0002¢\u0006\u0004\b%\u0010&J\f\u0010(\u001a\u00020\u0011*\u00020'H\u0002J\u0010\u0010+\u001a\u00020\u00182\u0006\u0010*\u001a\u00020)H\u0002J\u0010\u0010-\u001a\u00020\f2\u0006\u0010,\u001a\u00020\u0018H\u0002J\u0010\u0010.\u001a\u00020\u00132\u0006\u0010,\u001a\u00020\u0018H\u0002J\u0012\u0010/\u001a\u00020\u00182\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0018\u00102\u001a\u00020\f2\u0006\u00100\u001a\u00020\u00182\u0006\u00101\u001a\u00020\u0018H\u0007J\u0010\u00103\u001a\u00020\f2\u0006\u00101\u001a\u00020\u0018H\u0007J\u0010\u00105\u001a\u00020\f2\u0006\u00104\u001a\u00020\u0018H\u0007J\u0010\u00107\u001a\u00020\f2\u0006\u00106\u001a\u00020\u0018H\u0007J\u0018\u00109\u001a\u00020\f2\u0006\u00108\u001a\u00020\u00182\u0006\u00104\u001a\u00020\u0018H\u0007J\u0011\u0010<\u001a\u00020\f2\u0006\u0010;\u001a\u00020:H\u0004J\b\u0010=\u001a\u00020\fH\u0007J0\u0010C\u001a\u00020\f2\u0012\u0010?\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020'0>2\u0012\u0010B\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020A0@H\u0002J$\u0010E\u001a\u00020\f2\u0012\u0010?\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020'0>2\u0006\u0010D\u001a\u00020\u0018H\u0002J\u0018\u0010F\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u0018H\u0002J\u0018\u0010J\u001a\u00020\u00182\u0006\u0010G\u001a\u00020\u00182\u0006\u0010I\u001a\u00020HH\u0002J\u001a\u0010L\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u00182\b\u0010K\u001a\u0004\u0018\u00010'H\u0002J\u0018\u0010M\u001a\u00020\f2\u0006\u0010K\u001a\u00020'2\u0006\u0010\u001a\u001a\u00020\u0018H\u0002J2\u0010Q\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010N\u001a\u00020\u00182\b\u0010O\u001a\u0004\u0018\u00010\u00182\u0006\u0010P\u001a\u00020\u0018H\u0002J\u001c\u0010R\u001a\u00020\u00132\u0012\u0010?\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020'0>H\u0002J\b\u0010S\u001a\u00020\u0013H\u0002R\u001c\u0010T\u001a\b\u0012\u0004\u0012\u00020!0\u00068\u0002@\u0002X.¢\u0006\u0006\n\u0004\bT\u0010UR\u0014\u0010V\u001a\u00020\u00188\u0002XT¢\u0006\u0006\n\u0004\bV\u0010WR\u0014\u0010X\u001a\u00020\u00188\u0002XT¢\u0006\u0006\n\u0004\bX\u0010WR\u0014\u0010Y\u001a\u00020\u00188\u0002XT¢\u0006\u0006\n\u0004\bY\u0010WR\u0014\u0010Z\u001a\u00020\u00188\u0002XT¢\u0006\u0006\n\u0004\bZ\u0010WR\u0014\u0010[\u001a\u00020\u00188\u0002XT¢\u0006\u0006\n\u0004\b[\u0010WR\u0014\u0010\\\u001a\u00020\u00188\u0002XT¢\u0006\u0006\n\u0004\b\\\u0010WR\u0014\u0010]\u001a\u00020\u00188\u0002XT¢\u0006\u0006\n\u0004\b]\u0010WR\u0014\u0010^\u001a\u00020\u00188\u0002XT¢\u0006\u0006\n\u0004\b^\u0010WR\u0014\u0010_\u001a\u00020\u00188\u0002XT¢\u0006\u0006\n\u0004\b_\u0010WR\u0014\u0010`\u001a\u00020\u00188\u0006XT¢\u0006\u0006\n\u0004\b`\u0010WR\u0014\u0010a\u001a\u00020\u00188\u0006XT¢\u0006\u0006\n\u0004\ba\u0010WR\u0014\u0010b\u001a\u00020\u00188\u0006XT¢\u0006\u0006\n\u0004\bb\u0010WR\u0014\u0010c\u001a\u00020\u00188\u0006XT¢\u0006\u0006\n\u0004\bc\u0010WR\u0014\u0010d\u001a\u00020\u00188\u0006XT¢\u0006\u0006\n\u0004\bd\u0010WR\u0014\u0010e\u001a\u00020\u00188\u0006XT¢\u0006\u0006\n\u0004\be\u0010WR\u0014\u0010f\u001a\u00020\u00188\u0006XT¢\u0006\u0006\n\u0004\bf\u0010WR\u0014\u0010g\u001a\u00020\u00188\u0006XT¢\u0006\u0006\n\u0004\bg\u0010WR\u0014\u0010h\u001a\u00020\u00188\u0006XT¢\u0006\u0006\n\u0004\bh\u0010WR\u0014\u0010i\u001a\u00020\u00188\u0002XT¢\u0006\u0006\n\u0004\bi\u0010WR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\n\u0010jR\u0014\u0010k\u001a\u00020\u00138\u0002X\u0004¢\u0006\u0006\n\u0004\bk\u0010lR\u0014\u0010m\u001a\u00020\u00138\u0002XD¢\u0006\u0006\n\u0004\bm\u0010lR\u0014\u0010n\u001a\u00020\u00188\u0002X\u0004¢\u0006\u0006\n\u0004\bn\u0010WR\u0014\u0010o\u001a\u00020\u00138\u0002XD¢\u0006\u0006\n\u0004\bo\u0010lR\"\u0010q\u001a\u00020p8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\bq\u0010r\u001a\u0004\bs\u0010t\"\u0004\bu\u0010vR\"\u0010x\u001a\u00020w8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\bx\u0010y\u001a\u0004\bz\u0010{\"\u0004\b|\u0010}R \u0010~\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020'0@8\u0002X\u0004¢\u0006\u0006\n\u0004\b~\u0010R \u0010\u0001\u001a\t\u0012\u0004\u0012\u00020\u00180\u00018\u0002@\u0002X.¢\u0006\b\n\u0006\b\u0001\u0010\u0001R1\u0010\u0001\u001a\u001c\u0012\u0004\u0012\u00020)\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020A0\u00010\u00018\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R1\u0010\u0001\u001a\u001c\u0012\u0004\u0012\u00020)\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020A0\u00010\u00018\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u0018\u0010\u0001\u001a\u00030\u00018\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u0018\u0010\u0001\u001a\u00030\u00018\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R1\u0010\u0001\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R1\u0010\u0001\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R1\u0010\u0001\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R1\u0010\u0001\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R1\u0010\u0001\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001¨\u0006 \u0001"}, d2 = {"Lcom/talabat/core/fwf/data/FunWithFlags;", "Lcom/talabat/core/fwf/domain/IFunWithFlags;", "Landroid/content/Context;", "context", "Lcom/talabat/core/fwf/domain/config/FunWithFlagsConfig;", "config", "", "Lcom/talabat/core/fwfprojectskeys/domain/FWFKey;", "featuresKeys", "Lcom/talabat/secrets/Secrets;", "secrets", "Lkotlin/Function0;", "", "onFlagsFetched", "setup", "(Landroid/content/Context;Lcom/talabat/core/fwf/domain/config/FunWithFlagsConfig;[Lcom/talabat/core/fwfprojectskeys/domain/FWFKey;Lcom/talabat/secrets/Secrets;Lkotlin/jvm/functions/Function0;)V", "fwfKey", "", "defaultValue", "", "forceRequest", "Lkotlin/Function1;", "callback", "getVariation", "", "eventName", "flagKey", "flagVariation", "sendEvent$com_talabat_core_fwf_data_data", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "sendEvent", "configure", "setUserData", "Lcom/talabat/core/fwfprojectskeys/domain/FWFProject;", "projects", "subscribe", "([Lcom/talabat/core/fwfprojectskeys/domain/FWFProject;[Lcom/talabat/core/fwfprojectskeys/domain/FWFKey;Lkotlin/jvm/functions/Function0;)V", "observe", "([Lcom/talabat/core/fwfprojectskeys/domain/FWFProject;)V", "Lfwfd/com/fwfsdk/model/db/FWFResult;", "getVariationValue", "Lcom/talabat/core/fwfprojectskeys/domain/FWFProjectName;", "fwfProjectName", "getFWFProjectToken", "flagName", "handleIfFlagIsMissingFromInitialFlags", "isValidName", "getAppVersion", "attribute", "value", "setAttribute", "setGoogleClientId", "userId", "setUserId", "appLanguage", "setAppLanguage", "userEmail", "updateCustomerInfo", "Lcom/talabat/configuration/country/Country;", "selectedCountry", "updateSelectedCountry", "clearUserData", "", "flag", "", "", "map", "trackSelectedExperimentEvent", "it", "sendToObservability", "calculateFwfValidityId", "fwfValidityId", "", "ts", "calculateFwfValidityIdWithTs", "flagResult", "trackParticipatedExperimentEvent", "logHoldouts", "variation", "holdoutKey", "holdoutEval", "sendHoldoutEvent", "isFlagEnabled", "isTrackCacheSuccessEnabled", "fwfProjects", "[Lcom/talabat/core/fwfprojectskeys/domain/FWFProject;", "TAG", "Ljava/lang/String;", "FWF_QA_URL", "FWF_PROD_URL", "FWF_REGION", "ATTRIBUTE_DEVICE", "ATTRIBUTE_DEVICE_VALUE", "ATTRIBUTE_APP_VERSION", "ATTRIBUTE_GOOGLE_CLIENT_ID", "ATTRIBUTE_HAS_GOOGLE_SERVICES", "FLUTTER_MIGRATION_VERIFY_KEY", "FLUTTER_MIGRATION_VERIFY_VALUE", "FWF_VALIDITY_ID", "FWF_VALIDITY_TS", "FWF_VALIDITY_TS_WINDOW", "FWF_VALIDITY_ID_WITH_TS", "ENV_PROD", "ENV_QA", "BUILD_TYPE_RELEASE", "FWF_EXPLANATION_JSON_ERROR_KEY", "Lcom/talabat/secrets/Secrets;", "isProd", "Z", "isRelease", "endpoint", "isDebug", "Lcom/talabat/core/fwf/data/sdkwrapper/FunWithFlagsSdkWrapper;", "fwf", "Lcom/talabat/core/fwf/data/sdkwrapper/FunWithFlagsSdkWrapper;", "getFwf$com_talabat_core_fwf_data_data", "()Lcom/talabat/core/fwf/data/sdkwrapper/FunWithFlagsSdkWrapper;", "setFwf$com_talabat_core_fwf_data_data", "(Lcom/talabat/core/fwf/data/sdkwrapper/FunWithFlagsSdkWrapper;)V", "Lcom/talabat/core/fwf/data/observability/FunWithFlagsObservability;", "funWithFlagsObservability", "Lcom/talabat/core/fwf/data/observability/FunWithFlagsObservability;", "getFunWithFlagsObservability$com_talabat_core_fwf_data_data", "()Lcom/talabat/core/fwf/data/observability/FunWithFlagsObservability;", "setFunWithFlagsObservability$com_talabat_core_fwf_data_data", "(Lcom/talabat/core/fwf/data/observability/FunWithFlagsObservability;)V", "cache", "Ljava/util/Map;", "", "flagsNames", "Ljava/util/List;", "j$/util/concurrent/ConcurrentHashMap", "", "fwfProjectCounters", "Lj$/util/concurrent/ConcurrentHashMap;", "fwfLegacyKeysCounters", "Ljava/util/concurrent/atomic/AtomicInteger;", "fwfProjectCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "fwfLegacyKeysCount", "appVersionProvider", "Lkotlin/jvm/functions/Function0;", "getAppVersionProvider", "()Lkotlin/jvm/functions/Function0;", "setAppVersionProvider", "(Lkotlin/jvm/functions/Function0;)V", "countryThreeLetterCodeProvider", "getCountryThreeLetterCodeProvider", "setCountryThreeLetterCodeProvider", "customerIdProvider", "getCustomerIdProvider", "setCustomerIdProvider", "customerEmailProvider", "getCustomerEmailProvider", "setCustomerEmailProvider", "languageProvider", "getLanguageProvider", "setLanguageProvider", "<init>", "()V", "com_talabat_core_fwf_data_data"}, k = 1, mv = {1, 6, 0})
public final class FunWithFlags implements IFunWithFlags {
    @NotNull
    private static final String ATTRIBUTE_APP_VERSION = "appVersion";
    @NotNull
    private static final String ATTRIBUTE_DEVICE = "device";
    @NotNull
    private static final String ATTRIBUTE_DEVICE_VALUE = "Android";
    @NotNull
    private static final String ATTRIBUTE_GOOGLE_CLIENT_ID = "googleClientId";
    @NotNull
    private static final String ATTRIBUTE_HAS_GOOGLE_SERVICES = "hasGoogleServices";
    @NotNull
    public static final String BUILD_TYPE_RELEASE = "release";
    @NotNull
    public static final String ENV_PROD = "prod";
    @NotNull
    public static final String ENV_QA = "qa";
    @NotNull
    public static final String FLUTTER_MIGRATION_VERIFY_KEY = "trackingLibrarySource";
    @NotNull
    public static final String FLUTTER_MIGRATION_VERIFY_VALUE = "androidSDKSource";
    @NotNull
    private static final String FWF_EXPLANATION_JSON_ERROR_KEY = "error";
    @NotNull
    private static final String FWF_PROD_URL = "https://fwf-client-api.talabat.com";
    @NotNull
    private static final String FWF_QA_URL = "https://fwf-client-api-qa.dhhmena.com";
    @NotNull
    private static final String FWF_REGION = "eu";
    @NotNull
    public static final String FWF_VALIDITY_ID = "fwfValidityId";
    @NotNull
    public static final String FWF_VALIDITY_ID_WITH_TS = "fwfValidityIdWithTs";
    @NotNull
    public static final String FWF_VALIDITY_TS = "fwfValidityTs";
    @NotNull
    public static final String FWF_VALIDITY_TS_WINDOW = "fwfValidityTsWindow";
    @NotNull
    public static final FunWithFlags INSTANCE = new FunWithFlags();
    @NotNull
    private static final String TAG = "TalabatFunWithFlags";
    @Nullable
    private static Function0<String> appVersionProvider;
    /* access modifiers changed from: private */
    @NotNull
    public static final Map<String, FWFResult> cache = new LinkedHashMap();
    @Nullable
    private static Function0<String> countryThreeLetterCodeProvider;
    @Nullable
    private static Function0<String> customerEmailProvider;
    @Nullable
    private static Function0<String> customerIdProvider;
    @NotNull
    private static final String endpoint;
    /* access modifiers changed from: private */
    public static List<String> flagsNames;
    @NotNull
    private static FunWithFlagsObservability funWithFlagsObservability = FunWithFlagsObservabilityImpl.INSTANCE;
    @NotNull
    private static FunWithFlagsSdkWrapper fwf;
    @NotNull
    private static final AtomicInteger fwfLegacyKeysCount = new AtomicInteger();
    @NotNull
    private static final ConcurrentHashMap<FWFProjectName, Map<String, Integer>> fwfLegacyKeysCounters = new ConcurrentHashMap<>();
    @NotNull
    private static final AtomicInteger fwfProjectCount = new AtomicInteger();
    @NotNull
    private static final ConcurrentHashMap<FWFProjectName, Map<String, Integer>> fwfProjectCounters = new ConcurrentHashMap<>();
    private static FWFProject[] fwfProjects;
    private static final boolean isDebug = (!true);
    private static final boolean isProd;
    private static final boolean isRelease = true;
    @Nullable
    private static Function0<String> languageProvider;
    private static Secrets secrets;

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x002c, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) "release", (java.lang.Object) "release") == false) goto L_0x002f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0035  */
    static {
        /*
            com.talabat.core.fwf.data.FunWithFlags r0 = new com.talabat.core.fwf.data.FunWithFlags
            r0.<init>()
            INSTANCE = r0
            com.talabat.core.buildconfig.TalabatEnvironment r0 = com.talabat.core.buildconfig.TalabatEnvironment.INSTANCE
            java.lang.String r1 = r0.getEnvironment()
            java.lang.String r2 = "prod"
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
            r2 = 1
            if (r1 == 0) goto L_0x0018
        L_0x0016:
            r1 = r2
            goto L_0x002f
        L_0x0018:
            java.lang.String r0 = r0.getEnvironment()
            java.lang.String r1 = "qa"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            r1 = 0
            if (r0 == 0) goto L_0x0026
            goto L_0x002f
        L_0x0026:
            java.lang.String r0 = "release"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r0)
            if (r0 == 0) goto L_0x002f
            goto L_0x0016
        L_0x002f:
            isProd = r1
            isRelease = r2
            if (r1 == 0) goto L_0x0038
            java.lang.String r0 = "https://fwf-client-api.talabat.com"
            goto L_0x003a
        L_0x0038:
            java.lang.String r0 = "https://fwf-client-api-qa.dhhmena.com"
        L_0x003a:
            endpoint = r0
            r1 = r2 ^ r2
            isDebug = r1
            com.talabat.core.fwf.data.sdkwrapper.FunWithFlagsSdkWrapperImpl r1 = new com.talabat.core.fwf.data.sdkwrapper.FunWithFlagsSdkWrapperImpl
            r1.<init>(r0)
            fwf = r1
            com.talabat.core.fwf.data.observability.FunWithFlagsObservabilityImpl r0 = com.talabat.core.fwf.data.observability.FunWithFlagsObservabilityImpl.INSTANCE
            funWithFlagsObservability = r0
            java.util.LinkedHashMap r0 = new java.util.LinkedHashMap
            r0.<init>()
            cache = r0
            j$.util.concurrent.ConcurrentHashMap r0 = new j$.util.concurrent.ConcurrentHashMap
            r0.<init>()
            fwfProjectCounters = r0
            j$.util.concurrent.ConcurrentHashMap r0 = new j$.util.concurrent.ConcurrentHashMap
            r0.<init>()
            fwfLegacyKeysCounters = r0
            java.util.concurrent.atomic.AtomicInteger r0 = new java.util.concurrent.atomic.AtomicInteger
            r0.<init>()
            fwfProjectCount = r0
            java.util.concurrent.atomic.AtomicInteger r0 = new java.util.concurrent.atomic.AtomicInteger
            r0.<init>()
            fwfLegacyKeysCount = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.core.fwf.data.FunWithFlags.<clinit>():void");
    }

    private FunWithFlags() {
    }

    private final String calculateFwfValidityId(String str, String str2) {
        String str3;
        String str4;
        String str5;
        String str6;
        int i11;
        int i12;
        int i13;
        int i14;
        try {
            Function0<String> function0 = appVersionProvider;
            String str7 = null;
            if (function0 != null) {
                str3 = function0.invoke();
            } else {
                str3 = null;
            }
            Function0<String> function02 = countryThreeLetterCodeProvider;
            if (function02 != null) {
                str4 = function02.invoke();
            } else {
                str4 = null;
            }
            Function0<String> function03 = customerIdProvider;
            if (function03 != null) {
                str5 = function03.invoke();
            } else {
                str5 = null;
            }
            Function0<String> function04 = customerEmailProvider;
            if (function04 != null) {
                str6 = function04.invoke();
            } else {
                str6 = null;
            }
            Function0<String> function05 = languageProvider;
            if (function05 != null) {
                str7 = function05.invoke();
            }
            long j11 = (long) 31;
            long j12 = 1 * j11;
            int i15 = 0;
            if (str3 != null) {
                i11 = FwfUtilsKt.hash(str3);
            } else {
                i11 = 0;
            }
            long j13 = (j12 + ((long) i11)) * j11;
            if (str4 != null) {
                i12 = FwfUtilsKt.hash(str4);
            } else {
                i12 = 0;
            }
            long j14 = (j13 + ((long) i12)) * j11;
            if (str5 != null) {
                i13 = FwfUtilsKt.hash(str5);
            } else {
                i13 = 0;
            }
            long j15 = (j14 + ((long) i13)) * j11;
            if (str6 != null) {
                i14 = FwfUtilsKt.hash(str6);
            } else {
                i14 = 0;
            }
            long hash = (((j15 + ((long) i14)) * j11) + ((long) FwfUtilsKt.hash(str))) * j11;
            if (str7 != null) {
                i15 = FwfUtilsKt.hash(str7);
            }
            long hash2 = (j11 * (((hash + ((long) i15)) * j11) + ((long) FwfUtilsKt.hash("android")))) + ((long) FwfUtilsKt.hash(str2));
            StringBuilder sb2 = new StringBuilder();
            sb2.append("[FWF SDK Core Lib] fwfValidityId=");
            sb2.append(hash2);
            sb2.append(", appVersion=");
            sb2.append(str3);
            sb2.append(", country=");
            sb2.append(str4);
            sb2.append(", customer=(id=");
            sb2.append(str5);
            sb2.append(", email=");
            sb2.append(str6);
            sb2.append("), flagName=");
            sb2.append(str);
            sb2.append(", variation=");
            sb2.append(str2);
            sb2.append(", lang=");
            sb2.append(str7);
            sb2.append(", platform=android");
            return String.valueOf(hash2);
        } catch (Throwable unused) {
            return "";
        }
    }

    private final String calculateFwfValidityIdWithTs(String str, long j11) {
        try {
            long j12 = (long) 31;
            return String.valueOf((j12 * ((1 * j12) + ((long) FwfUtilsKt.hash(str)))) + ((long) ((int) (j11 / ((long) 10000)))));
        } catch (Throwable unused) {
            return "";
        }
    }

    @JvmStatic
    public static final void clearUserData() {
        if (!Intrinsics.areEqual((Object) fwf.getUserAttribute("email"), (Object) "") || !Intrinsics.areEqual((Object) fwf.getUserAttribute("userId"), (Object) "")) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("email", "");
            jsonObject.addProperty("userId", "");
            jsonObject.addProperty("userLoggedIn", Boolean.FALSE);
            fwfd.com.fwfsdk.FunWithFlags.getInstance().getUser().setAttributes(jsonObject);
        }
    }

    private final void configure(Context context) {
        FWFProject fWFProject;
        boolean z11;
        FWFProject[] fWFProjectArr = fwfProjects;
        Secrets secrets2 = null;
        if (fWFProjectArr == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fwfProjects");
            fWFProjectArr = null;
        }
        int length = fWFProjectArr.length;
        int i11 = 0;
        while (true) {
            if (i11 >= length) {
                fWFProject = null;
                break;
            }
            fWFProject = fWFProjectArr[i11];
            if (fWFProject.getFwfProjectName() == FWFProjectName.DEFAULT) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                break;
            }
            i11++;
        }
        if (fWFProject == null) {
            FWFProject[] fWFProjectArr2 = fwfProjects;
            if (fWFProjectArr2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fwfProjects");
                fWFProjectArr2 = null;
            }
            fWFProject = fWFProjectArr2[0];
        }
        FWFProjectName fwfProjectName = fWFProject.getFwfProjectName();
        FunWithFlagsSdkWrapper funWithFlagsSdkWrapper = fwf;
        Secrets secrets3 = secrets;
        if (secrets3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("secrets");
        } else {
            secrets2 = secrets3;
        }
        funWithFlagsSdkWrapper.configureWith(context, FWF_REGION, FWFProjectExtKt.getToken(fwfProjectName, secrets2), isDebug);
    }

    private final String getAppVersion(Context context) {
        PackageInfo packageInfo;
        String str;
        String replace$default;
        if (context == null) {
            return "";
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null || (packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0)) == null || (str = packageInfo.versionName) == null || (replace$default = StringsKt__StringsJVMKt.replace$default(str, "-beta", "", false, 4, (Object) null)) == null) {
                return "";
            }
            return replace$default;
        } catch (PackageManager.NameNotFoundException e11) {
            Log.e(TAG, e11.getMessage(), e11);
            return "";
        }
    }

    private final String getFWFProjectToken(FWFProjectName fWFProjectName) {
        boolean z11;
        boolean z12;
        FWFProject[] fWFProjectArr = fwfProjects;
        Secrets secrets2 = null;
        if (fWFProjectArr == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fwfProjects");
            fWFProjectArr = null;
        }
        if (fwfProjects != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            fWFProjectArr = null;
        }
        if (fWFProjectArr != null) {
            int length = fWFProjectArr.length;
            int i11 = 0;
            while (i11 < length) {
                FWFProject fWFProject = fWFProjectArr[i11];
                if (fWFProject.getFwfProjectName() == fWFProjectName) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if (z12) {
                    FWFProjectName fwfProjectName = fWFProject.getFwfProjectName();
                    Secrets secrets3 = secrets;
                    if (secrets3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("secrets");
                    } else {
                        secrets2 = secrets3;
                    }
                    String token = FWFProjectExtKt.getToken(fwfProjectName, secrets2);
                    if (token != null) {
                        return token;
                    }
                } else {
                    i11++;
                }
            }
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        }
        throw new RuntimeException("Please Setup the FWF Project Tokens");
    }

    /* access modifiers changed from: private */
    public final Object getVariationValue(FWFResult fWFResult) {
        Object obj = fWFResult.variation;
        if (obj instanceof LinkedTreeMap) {
            obj = fWFResult.getJsonVariation().toString();
        } else if (obj instanceof ArrayList) {
            obj = fWFResult.getJsonArrayVariation().toString();
        }
        Intrinsics.checkNotNullExpressionValue(obj, "when (this.variation) {\n…n\n            }\n        }");
        return obj;
    }

    private final void handleIfFlagIsMissingFromInitialFlags(String str) throws RuntimeException {
        List<String> list;
        if (!Intrinsics.areEqual((Object) "release", (Object) "release") && (list = flagsNames) != null) {
            if (list == null) {
                Intrinsics.throwUninitializedPropertyAccessException("flagsNames");
                list = null;
            }
            if (!list.contains(str)) {
                throw new RuntimeException("Please add " + str + " to TalabatFeatureFlagConstants.FEATURE_KEYS");
            }
        }
    }

    private final boolean isFlagEnabled(Map.Entry<String, ? extends FWFResult> entry) {
        FWFResultTrackInfo trackInfo = ((FWFResult) entry.getValue()).getTrackInfo();
        Boolean flagEnabled = trackInfo != null ? trackInfo.getFlagEnabled() : null;
        if (flagEnabled == null) {
            return false;
        }
        return flagEnabled.booleanValue();
    }

    private final boolean isTrackCacheSuccessEnabled() {
        FWFResult fWFResult = cache.get(FunWithFlagsConstants.INSTANCE.getOBSERVE_CACHE_SUCCESS_FLAG().getValue());
        Boolean bool = null;
        Object variationValue = fWFResult != null ? getVariationValue(fWFResult) : null;
        if (variationValue instanceof Boolean) {
            bool = (Boolean) variationValue;
        }
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    private final boolean isValidName(String str) {
        boolean z11;
        if (str.length() > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11 || StringsKt__StringsJVMKt.endsWith$default(str, SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE, false, 2, (Object) null) || StringsKt__StringsJVMKt.endsWith$default(str, JavaConstant.Dynamic.DEFAULT_NAME, false, 2, (Object) null) || StringsKt__StringsJVMKt.endsWith$default(str, "null", false, 2, (Object) null)) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0012 A[Catch:{ Exception -> 0x0048 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void logHoldouts(fwfd.com.fwfsdk.model.db.FWFResult r9, java.lang.String r10) {
        /*
            r8 = this;
            java.util.Map r0 = r9.getHoldoutsEvaluations()     // Catch:{ Exception -> 0x0048 }
            if (r0 == 0) goto L_0x000f
            boolean r0 = r0.isEmpty()     // Catch:{ Exception -> 0x0048 }
            if (r0 == 0) goto L_0x000d
            goto L_0x000f
        L_0x000d:
            r0 = 0
            goto L_0x0010
        L_0x000f:
            r0 = 1
        L_0x0010:
            if (r0 != 0) goto L_0x005f
            java.util.Map r0 = r9.getHoldoutsEvaluations()     // Catch:{ Exception -> 0x0048 }
            java.util.Set r0 = r0.entrySet()     // Catch:{ Exception -> 0x0048 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x0048 }
        L_0x001e:
            boolean r1 = r0.hasNext()     // Catch:{ Exception -> 0x0048 }
            if (r1 == 0) goto L_0x005f
            java.lang.Object r1 = r0.next()     // Catch:{ Exception -> 0x0048 }
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1     // Catch:{ Exception -> 0x0048 }
            com.talabat.core.fwf.data.FunWithFlags r2 = INSTANCE     // Catch:{ Exception -> 0x0048 }
            java.lang.String r3 = "holdout_group_participated"
            java.lang.Object r4 = r9.variation     // Catch:{ Exception -> 0x0048 }
            java.lang.String r5 = r4.toString()     // Catch:{ Exception -> 0x0048 }
            java.lang.Object r4 = r1.getKey()     // Catch:{ Exception -> 0x0048 }
            r6 = r4
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ Exception -> 0x0048 }
            java.lang.Object r1 = r1.getValue()     // Catch:{ Exception -> 0x0048 }
            java.lang.String r7 = java.lang.String.valueOf(r1)     // Catch:{ Exception -> 0x0048 }
            r4 = r10
            r2.sendHoldoutEvent(r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x0048 }
            goto L_0x001e
        L_0x0048:
            r9 = move-exception
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r0 = "ALOV FWF holdoutsEvaluations error :: "
            r10.append(r0)
            r10.append(r9)
            java.lang.String r10 = r10.toString()
            java.lang.String r0 = "ALOV FWF"
            android.util.Log.e(r0, r10, r9)
        L_0x005f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.core.fwf.data.FunWithFlags.logHoldouts(fwfd.com.fwfsdk.model.db.FWFResult, java.lang.String):void");
    }

    private final void observe(FWFProject[] fWFProjectArr) {
        for (FWFProject fwfProjectName : fWFProjectArr) {
            FunWithFlagsSdkWrapper funWithFlagsSdkWrapper = fwf;
            FWFProjectName fwfProjectName2 = fwfProjectName.getFwfProjectName();
            Secrets secrets2 = secrets;
            if (secrets2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("secrets");
                secrets2 = null;
            }
            funWithFlagsSdkWrapper.subscribeObserver(FWFProjectExtKt.getToken(fwfProjectName2, secrets2), FunWithFlags$observe$1$1.INSTANCE);
        }
    }

    private final void sendHoldoutEvent(String str, String str2, String str3, String str4, String str5) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(FwfTrackingConstantsKt.AB_GROUP_HOLDOUT_FEATURE_FLAG_KEY, str2);
        linkedHashMap.put(FwfTrackingConstantsKt.AB_GROUP_HOLDOUT_VARIATION, str3);
        linkedHashMap.put(FLUTTER_MIGRATION_VERIFY_KEY, FLUTTER_MIGRATION_VERIFY_VALUE);
        linkedHashMap.put("platform", "Android");
        if (str4 == null) {
            str4 = "";
        }
        linkedHashMap.put(FwfTrackingConstantsKt.AB_GROUP_HOLDOUT_HOLDOUT_KEY, str4);
        linkedHashMap.put(FwfTrackingConstantsKt.AB_GROUP_HOLDOUT_EVALUATION, str5);
        FunWithFlagsTrackingPort tracker = FunWithFlagsIntegratorKt.getTracker();
        if (tracker != null) {
            tracker.track(str, linkedHashMap);
        }
    }

    private final void sendToObservability(Map.Entry<String, ? extends FWFResult> entry, String str) {
        funWithFlagsObservability.observerTrackingEvent(entry.getKey(), str, ((FWFResult) entry.getValue()).variation.toString());
    }

    @JvmStatic
    public static final void setAppLanguage(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, FunWithFlagsConstants.ATTRIBUTE_LANGUAGE);
        if (!Intrinsics.areEqual((Object) fwf.getUserAttribute(FunWithFlagsConstants.ATTRIBUTE_LANGUAGE), (Object) str)) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty(FunWithFlagsConstants.ATTRIBUTE_LANGUAGE, str);
            fwfd.com.fwfsdk.FunWithFlags.getInstance().getUser().setAttributes(jsonObject);
        }
    }

    @JvmStatic
    public static final void setAttribute(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "attribute");
        Intrinsics.checkNotNullParameter(str2, "value");
        fwf.setAttribute(str, str2);
    }

    @JvmStatic
    public static final void setGoogleClientId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        fwf.setGoogleClientId(str);
    }

    private final void setUserData(Context context, FunWithFlagsConfig funWithFlagsConfig) {
        boolean z11;
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("device", "Android");
        jsonObject.addProperty("appVersion", INSTANCE.getAppVersion(context));
        jsonObject.addProperty(ATTRIBUTE_GOOGLE_CLIENT_ID, funWithFlagsConfig.getGoogleClientId());
        jsonObject.addProperty(ATTRIBUTE_HAS_GOOGLE_SERVICES, Boolean.valueOf(funWithFlagsConfig.getHasGoogleServices()));
        String appLanguage = funWithFlagsConfig.getAppLanguage();
        if (appLanguage != null) {
            jsonObject.addProperty(FunWithFlagsConstants.ATTRIBUTE_LANGUAGE, appLanguage);
        }
        Country country = funWithFlagsConfig.getCountry();
        if (country != null) {
            jsonObject.addProperty("country", country.threeLetterCodeUpperCase());
            jsonObject.addProperty(FunWithFlagsConstants.ATTRIBUTE_GLOBAL_ENTITY_ID, country.getGlobalEntityId());
        }
        String userEmail = funWithFlagsConfig.getUserEmail();
        if (userEmail != null) {
            jsonObject.addProperty("email", userEmail);
        }
        String userEmail2 = funWithFlagsConfig.getUserEmail();
        if (userEmail2 != null) {
            z11 = !StringsKt__StringsJVMKt.isBlank(userEmail2);
        } else {
            z11 = false;
        }
        jsonObject.addProperty("userLoggedIn", Boolean.valueOf(z11));
        String userID = funWithFlagsConfig.getUserID();
        if (userID != null) {
            jsonObject.addProperty("userId", userID);
        }
        fwfd.com.fwfsdk.FunWithFlags.getInstance().getUser().setAttributes(jsonObject);
    }

    @JvmStatic
    public static final void setUserId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "userId");
        fwf.setUserId(str);
    }

    public static /* synthetic */ void setup$default(FunWithFlags funWithFlags, Context context, FunWithFlagsConfig funWithFlagsConfig, FWFKey[] fWFKeyArr, Secrets secrets2, Function0 function0, int i11, Object obj) {
        FWFKey[] fWFKeyArr2;
        Function0 function02;
        if ((i11 & 4) != 0) {
            fWFKeyArr2 = null;
        } else {
            fWFKeyArr2 = fWFKeyArr;
        }
        if ((i11 & 8) != 0) {
            secrets2 = new Secrets();
        }
        Secrets secrets3 = secrets2;
        if ((i11 & 16) != 0) {
            function02 = null;
        } else {
            function02 = function0;
        }
        funWithFlags.setup(context, funWithFlagsConfig, fWFKeyArr2, secrets3, function02);
    }

    private final void subscribe(FWFProject[] fWFProjectArr, FWFKey[] fWFKeyArr, Function0<Unit> function0) {
        LinkedHashMap linkedHashMap;
        boolean z11;
        List list;
        fwfProjectCount.set(fWFProjectArr.length);
        for (FWFProject fwfProjectName : fWFProjectArr) {
            fwfProjectCounters.put(fwfProjectName.getFwfProjectName(), new LinkedHashMap());
        }
        int length = fWFProjectArr.length;
        int i11 = 0;
        while (true) {
            Secrets secrets2 = null;
            boolean z12 = true;
            if (i11 < length) {
                FWFProject fWFProject = fWFProjectArr[i11];
                Object[] array = fWFProject.getAllKeys().toArray(new String[0]);
                if (array != null) {
                    String[] strArr = (String[]) array;
                    if (strArr.length != 0) {
                        z12 = false;
                    }
                    if (z12) {
                        fwfProjectCount.decrementAndGet();
                    }
                    FunWithFlagsSdkWrapper funWithFlagsSdkWrapper = fwf;
                    FWFProjectName fwfProjectName2 = fWFProject.getFwfProjectName();
                    Secrets secrets3 = secrets;
                    if (secrets3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("secrets");
                    } else {
                        secrets2 = secrets3;
                    }
                    funWithFlagsSdkWrapper.subscribeFeatures(strArr, FWFProjectExtKt.getToken(fwfProjectName2, secrets2), new a(fWFProject, function0));
                    i11++;
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                }
            } else {
                if (fWFKeyArr == null || (list = ArraysKt___ArraysKt.toList((T[]) fWFKeyArr)) == null) {
                    linkedHashMap = null;
                } else {
                    linkedHashMap = new LinkedHashMap();
                    for (Object next : list) {
                        FWFProjectName projectName = ((FWFKey) next).getProjectName();
                        Object obj = linkedHashMap.get(projectName);
                        if (obj == null) {
                            obj = new ArrayList();
                            linkedHashMap.put(projectName, obj);
                        }
                        ((List) obj).add(next);
                    }
                }
                if (linkedHashMap != null) {
                    fwfLegacyKeysCount.set(linkedHashMap.size());
                    for (Map.Entry entry : linkedHashMap.entrySet()) {
                        Iterable<FWFKey> iterable = (Iterable) entry.getValue();
                        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
                        for (FWFKey value : iterable) {
                            arrayList.add(value.getValue());
                        }
                        Object[] array2 = arrayList.toArray(new String[0]);
                        if (array2 != null) {
                            String[] strArr2 = (String[]) array2;
                            if (strArr2.length == 0) {
                                z11 = true;
                            } else {
                                z11 = false;
                            }
                            if (z11) {
                                fwfLegacyKeysCount.decrementAndGet();
                            }
                            FunWithFlagsSdkWrapper funWithFlagsSdkWrapper2 = fwf;
                            FWFProjectName fWFProjectName = (FWFProjectName) entry.getKey();
                            Secrets secrets4 = secrets;
                            if (secrets4 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("secrets");
                                secrets4 = null;
                            }
                            funWithFlagsSdkWrapper2.subscribeFeatures(strArr2, FWFProjectExtKt.getToken(fWFProjectName, secrets4), new b(entry));
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                        }
                    }
                    return;
                }
                return;
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: subscribe$lambda-15$lambda-14  reason: not valid java name */
    public static final void m9589subscribe$lambda15$lambda14(FWFProject fWFProject, Function0 function0, HashMap hashMap) {
        Intrinsics.checkNotNullParameter(fWFProject, "$it");
        try {
            int decrementAndGet = fwfProjectCount.decrementAndGet();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Intrinsics.checkNotNullExpressionValue(hashMap, "fwfResult");
            for (Map.Entry trackSelectedExperimentEvent : hashMap.entrySet()) {
                INSTANCE.trackSelectedExperimentEvent(trackSelectedExperimentEvent, linkedHashMap);
            }
            ConcurrentHashMap<FWFProjectName, Map<String, Integer>> concurrentHashMap = fwfProjectCounters;
            concurrentHashMap.put(fWFProject.getFwfProjectName(), linkedHashMap);
            if (decrementAndGet <= 0) {
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                for (Map.Entry next : concurrentHashMap.entrySet()) {
                    FWFProjectName fWFProjectName = (FWFProjectName) next.getKey();
                    for (Map.Entry entry : ((Map) next.getValue()).entrySet()) {
                        String str = (String) entry.getKey();
                        int intValue = ((Number) entry.getValue()).intValue();
                        int i11 = linkedHashMap2.get(str);
                        if (i11 == null) {
                            i11 = 0;
                            linkedHashMap2.put(str, 0);
                        }
                        linkedHashMap2.put(str, Integer.valueOf(((Number) i11).intValue() + intValue));
                    }
                }
                if (function0 != null) {
                    function0.invoke();
                }
                funWithFlagsObservability.observerFwfCount("fwf_count_android", linkedHashMap2);
            }
        } catch (Throwable th2) {
            Log.e("ALOV FWF", "ALOV FWF projects error :: " + th2, th2);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: subscribe$lambda-24$lambda-23$lambda-22  reason: not valid java name */
    public static final void m9590subscribe$lambda24$lambda23$lambda22(Map.Entry entry, HashMap hashMap) {
        Intrinsics.checkNotNullParameter(entry, "$it");
        int decrementAndGet = fwfLegacyKeysCount.decrementAndGet();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Intrinsics.checkNotNullExpressionValue(hashMap, "fwfResult");
        for (Map.Entry trackSelectedExperimentEvent : hashMap.entrySet()) {
            INSTANCE.trackSelectedExperimentEvent(trackSelectedExperimentEvent, linkedHashMap);
        }
        ConcurrentHashMap<FWFProjectName, Map<String, Integer>> concurrentHashMap = fwfLegacyKeysCounters;
        concurrentHashMap.put(entry.getKey(), linkedHashMap);
        if (decrementAndGet <= 0) {
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (Map.Entry next : concurrentHashMap.entrySet()) {
                FWFProjectName fWFProjectName = (FWFProjectName) next.getKey();
                for (Map.Entry entry2 : ((Map) next.getValue()).entrySet()) {
                    String str = (String) entry2.getKey();
                    int intValue = ((Number) entry2.getValue()).intValue();
                    int i11 = linkedHashMap2.get(str);
                    if (i11 == null) {
                        i11 = 0;
                        linkedHashMap2.put(str, 0);
                    }
                    linkedHashMap2.put(str, Integer.valueOf(((Number) i11).intValue() + intValue));
                }
            }
            funWithFlagsObservability.observerFwfCount("fwf_count_android_legacy", linkedHashMap2);
        }
    }

    /* access modifiers changed from: private */
    public final void trackParticipatedExperimentEvent(String str, FWFResult fWFResult) {
        String str2;
        boolean z11;
        if (fWFResult != null) {
            FWFResultTrackInfo trackInfo = fWFResult.getTrackInfo();
            if (trackInfo != null) {
                str2 = trackInfo.getFlagType();
            } else {
                str2 = null;
            }
            if (Intrinsics.areEqual((Object) str2, (Object) "abntest")) {
                FWFResultTrackInfo trackInfo2 = fWFResult.getTrackInfo();
                if (trackInfo2 != null) {
                    z11 = Intrinsics.areEqual((Object) trackInfo2.getFlagEnabled(), (Object) Boolean.TRUE);
                } else {
                    z11 = false;
                }
                if (!z11 || !fWFResult.abtest) {
                    funWithFlagsObservability.observerTrackingEvent(str, FwfTrackingConstantsKt.AB_TEST_NOT_PARTICIPATED, fWFResult.variation.toString());
                } else {
                    funWithFlagsObservability.observerTrackingEvent(str, "ab_test_participated", fWFResult.variation.toString());
                    INSTANCE.sendEvent$com_talabat_core_fwf_data_data("ab_test_participated", str, fWFResult.variation.toString());
                }
            }
            INSTANCE.logHoldouts(fWFResult, str);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0056, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) com.huawei.hms.flutter.map.constants.Param.ERROR) != false) goto L_0x0058;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void trackSelectedExperimentEvent(java.util.Map.Entry<java.lang.String, ? extends fwfd.com.fwfsdk.model.db.FWFResult> r7, java.util.Map<java.lang.String, java.lang.Integer> r8) {
        /*
            r6 = this;
            java.lang.Object r0 = r7.getValue()
            fwfd.com.fwfsdk.model.db.FWFResult r0 = (fwfd.com.fwfsdk.model.db.FWFResult) r0
            fwfd.com.fwfsdk.model.db.FWFResultTrackInfo r0 = r0.getTrackInfo()
            r1 = 0
            if (r0 == 0) goto L_0x0012
            java.lang.String r0 = r0.getFlagType()
            goto L_0x0013
        L_0x0012:
            r0 = r1
        L_0x0013:
            if (r0 != 0) goto L_0x0018
            java.lang.String r0 = "unknown"
        L_0x0018:
            java.lang.Object r2 = r7.getValue()
            fwfd.com.fwfsdk.model.db.FWFResult r2 = (fwfd.com.fwfsdk.model.db.FWFResult) r2
            com.google.gson.JsonObject r2 = r2.getExplanation()
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x0069
            java.lang.String r5 = "error"
            com.google.gson.JsonElement r5 = r2.get(r5)
            if (r5 == 0) goto L_0x0033
            java.lang.String r5 = r5.getAsString()
            goto L_0x0034
        L_0x0033:
            r5 = r1
        L_0x0034:
            if (r5 == 0) goto L_0x003f
            boolean r5 = kotlin.text.StringsKt__StringsJVMKt.isBlank(r5)
            if (r5 == 0) goto L_0x003d
            goto L_0x003f
        L_0x003d:
            r5 = r4
            goto L_0x0040
        L_0x003f:
            r5 = r3
        L_0x0040:
            if (r5 == 0) goto L_0x0058
            java.lang.String r5 = "kind"
            com.google.gson.JsonElement r2 = r2.get(r5)
            if (r2 == 0) goto L_0x004f
            java.lang.String r2 = r2.getAsString()
            goto L_0x0050
        L_0x004f:
            r2 = r1
        L_0x0050:
            java.lang.String r5 = "ERROR"
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r5)
            if (r2 == 0) goto L_0x0069
        L_0x0058:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            java.lang.String r0 = "_error"
            r2.append(r0)
            java.lang.String r0 = r2.toString()
        L_0x0069:
            java.lang.Object r2 = r8.get(r0)
            if (r2 != 0) goto L_0x0076
            java.lang.Integer r2 = java.lang.Integer.valueOf(r4)
            r8.put(r0, r2)
        L_0x0076:
            java.lang.Number r2 = (java.lang.Number) r2
            int r2 = r2.intValue()
            int r2 = r2 + r3
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r8.put(r0, r2)
            java.lang.Object r8 = r7.getValue()
            fwfd.com.fwfsdk.model.db.FWFResult r8 = (fwfd.com.fwfsdk.model.db.FWFResult) r8
            fwfd.com.fwfsdk.model.db.FWFResultTrackInfo r8 = r8.getTrackInfo()
            if (r8 == 0) goto L_0x0094
            java.lang.String r1 = r8.getFlagType()
        L_0x0094:
            java.lang.String r8 = "multivariate"
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r8)
            if (r8 == 0) goto L_0x00ab
            java.lang.Object r8 = r7.getValue()
            fwfd.com.fwfsdk.model.db.FWFResult r8 = (fwfd.com.fwfsdk.model.db.FWFResult) r8
            boolean r8 = r8.abtest
            if (r8 != 0) goto L_0x00ab
            java.lang.String r8 = "feature_flag_participated"
            r6.sendToObservability(r7, r8)
        L_0x00ab:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.core.fwf.data.FunWithFlags.trackSelectedExperimentEvent(java.util.Map$Entry, java.util.Map):void");
    }

    @JvmStatic
    public static final void updateCustomerInfo(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "userEmail");
        Intrinsics.checkNotNullParameter(str2, "userId");
        JsonObject jsonObject = new JsonObject();
        if (!Intrinsics.areEqual((Object) fwf.getUserAttribute("email"), (Object) str)) {
            jsonObject.addProperty("email", str);
        }
        if (!Intrinsics.areEqual((Object) fwf.getUserAttribute("userId"), (Object) str2)) {
            jsonObject.addProperty("userId", str2);
        }
        if (!Boolean.parseBoolean(fwf.getUserAttribute("userLoggedIn"))) {
            jsonObject.addProperty("userLoggedIn", Boolean.TRUE);
        }
        Set<String> keySet = jsonObject.keySet();
        Intrinsics.checkNotNullExpressionValue(keySet, "it.keySet()");
        if (!(!keySet.isEmpty())) {
            jsonObject = null;
        }
        if (jsonObject != null) {
            fwfd.com.fwfsdk.FunWithFlags.getInstance().getUser().setAttributes(jsonObject);
        }
    }

    @JvmStatic
    public static final void updateSelectedCountry(@NotNull Country country) {
        Intrinsics.checkNotNullParameter(country, "selectedCountry");
        String threeLetterCodeUpperCase = country.threeLetterCodeUpperCase();
        String globalEntityId = country.getGlobalEntityId();
        if (!Intrinsics.areEqual((Object) fwf.getUserAttribute("country"), (Object) threeLetterCodeUpperCase) || !Intrinsics.areEqual((Object) fwf.getUserAttribute(FunWithFlagsConstants.ATTRIBUTE_GLOBAL_ENTITY_ID), (Object) globalEntityId)) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("country", threeLetterCodeUpperCase);
            jsonObject.addProperty(FunWithFlagsConstants.ATTRIBUTE_GLOBAL_ENTITY_ID, globalEntityId);
            fwfd.com.fwfsdk.FunWithFlags.getInstance().getUser().setAttributes(jsonObject);
        }
    }

    @Nullable
    public final Function0<String> getAppVersionProvider() {
        return appVersionProvider;
    }

    @Nullable
    public final Function0<String> getCountryThreeLetterCodeProvider() {
        return countryThreeLetterCodeProvider;
    }

    @Nullable
    public final Function0<String> getCustomerEmailProvider() {
        return customerEmailProvider;
    }

    @Nullable
    public final Function0<String> getCustomerIdProvider() {
        return customerIdProvider;
    }

    @NotNull
    public final FunWithFlagsObservability getFunWithFlagsObservability$com_talabat_core_fwf_data_data() {
        return funWithFlagsObservability;
    }

    @NotNull
    public final FunWithFlagsSdkWrapper getFwf$com_talabat_core_fwf_data_data() {
        return fwf;
    }

    @Nullable
    public final Function0<String> getLanguageProvider() {
        return languageProvider;
    }

    public void getVariation(@NotNull FWFKey fWFKey, @NotNull Object obj, boolean z11, @NotNull Function1<Object, Unit> function1) {
        Intrinsics.checkNotNullParameter(fWFKey, "fwfKey");
        Intrinsics.checkNotNullParameter(obj, "defaultValue");
        Intrinsics.checkNotNullParameter(function1, "callback");
        String value = fWFKey.getValue();
        FWFProjectName projectName = fWFKey.getProjectName();
        if (isValidName(value)) {
            handleIfFlagIsMissingFromInitialFlags(value);
            fwf.getVariation(getFWFProjectToken(projectName), value, new FWFFallback(obj, FWFFallback.FallbackTypes.FROM_VALUE), z11, new FunWithFlags$getVariation$1(value, function1, obj));
            return;
        }
        funWithFlagsObservability.observeAsyncInvalidFlagNameError(value);
        function1.invoke(obj);
    }

    public final void sendEvent$com_talabat_core_fwf_data_data(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        Intrinsics.checkNotNullParameter(str2, "flagKey");
        Intrinsics.checkNotNullParameter(str3, "flagVariation");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("experiment_name", str2);
        linkedHashMap.put("experimentVariation", str3);
        linkedHashMap.put(FLUTTER_MIGRATION_VERIFY_KEY, FLUTTER_MIGRATION_VERIFY_VALUE);
        linkedHashMap.put("platform", "Android");
        String calculateFwfValidityId = calculateFwfValidityId(str2, str3);
        long currentTimeMillis = System.currentTimeMillis();
        String calculateFwfValidityIdWithTs = calculateFwfValidityIdWithTs(calculateFwfValidityId, currentTimeMillis);
        linkedHashMap.put(FWF_VALIDITY_ID, calculateFwfValidityId);
        linkedHashMap.put(FWF_VALIDITY_TS, String.valueOf(currentTimeMillis));
        long j11 = currentTimeMillis / 10000;
        linkedHashMap.put(FWF_VALIDITY_TS_WINDOW, String.valueOf(j11));
        linkedHashMap.put(FWF_VALIDITY_ID_WITH_TS, calculateFwfValidityIdWithTs);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[FWF SDK Core Lib] Result: fwfValidityId=");
        sb2.append(calculateFwfValidityId);
        sb2.append(", fwfValidityTs=");
        sb2.append(currentTimeMillis);
        sb2.append(", window=");
        sb2.append(j11);
        sb2.append(", v=");
        sb2.append(calculateFwfValidityIdWithTs);
        FunWithFlagsTrackingPort tracker = FunWithFlagsIntegratorKt.getTracker();
        if (tracker != null) {
            tracker.track(str, linkedHashMap);
        }
    }

    public final void setAppVersionProvider(@Nullable Function0<String> function0) {
        appVersionProvider = function0;
    }

    public final void setCountryThreeLetterCodeProvider(@Nullable Function0<String> function0) {
        countryThreeLetterCodeProvider = function0;
    }

    public final void setCustomerEmailProvider(@Nullable Function0<String> function0) {
        customerEmailProvider = function0;
    }

    public final void setCustomerIdProvider(@Nullable Function0<String> function0) {
        customerIdProvider = function0;
    }

    public final void setFunWithFlagsObservability$com_talabat_core_fwf_data_data(@NotNull FunWithFlagsObservability funWithFlagsObservability2) {
        Intrinsics.checkNotNullParameter(funWithFlagsObservability2, "<set-?>");
        funWithFlagsObservability = funWithFlagsObservability2;
    }

    public final void setFwf$com_talabat_core_fwf_data_data(@NotNull FunWithFlagsSdkWrapper funWithFlagsSdkWrapper) {
        Intrinsics.checkNotNullParameter(funWithFlagsSdkWrapper, "<set-?>");
        fwf = funWithFlagsSdkWrapper;
    }

    public final void setLanguageProvider(@Nullable Function0<String> function0) {
        languageProvider = function0;
    }

    public final void setup(@NotNull Context context, @NotNull FunWithFlagsConfig funWithFlagsConfig, @Nullable FWFKey[] fWFKeyArr, @NotNull Secrets secrets2, @Nullable Function0<Unit> function0) {
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(funWithFlagsConfig, DarkstoresMainActivity.CONFIG_EXTRA_KEY);
        Intrinsics.checkNotNullParameter(secrets2, "secrets");
        secrets = secrets2;
        FWFProject[] projects = funWithFlagsConfig.getProjects();
        ArrayList arrayList2 = new ArrayList();
        for (FWFProject allKeys : projects) {
            boolean unused = CollectionsKt__MutableCollectionsKt.addAll(arrayList2, CollectionsKt___CollectionsKt.toList(allKeys.getAllKeys()));
        }
        Collection list = CollectionsKt___CollectionsKt.toList(arrayList2);
        if (fWFKeyArr != null) {
            ArrayList arrayList3 = new ArrayList(fWFKeyArr.length);
            for (FWFKey value : fWFKeyArr) {
                arrayList3.add(value.getValue());
            }
            arrayList = arrayList3;
        } else {
            arrayList = CollectionsKt__CollectionsKt.emptyList();
        }
        flagsNames = CollectionsKt___CollectionsKt.plus(list, arrayList);
        cache.clear();
        FWFProject[] projects2 = funWithFlagsConfig.getProjects();
        fwfProjects = projects2;
        if (projects2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fwfProjects");
            projects2 = null;
        }
        int length = projects2.length;
        setUserData(context, funWithFlagsConfig);
        configure(context);
        observe(funWithFlagsConfig.getProjects());
        subscribe(funWithFlagsConfig.getProjects(), fWFKeyArr, function0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0039, code lost:
        r4 = getVariationValue(r0);
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object getVariation(@org.jetbrains.annotations.NotNull com.talabat.core.fwfprojectskeys.domain.FWFKey r4, @org.jetbrains.annotations.NotNull java.lang.Object r5) {
        /*
            r3 = this;
            java.lang.String r0 = "fwfKey"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "defaultValue"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r4 = r4.getValue()
            boolean r0 = r3.isValidName(r4)
            if (r0 == 0) goto L_0x0042
            r3.handleIfFlagIsMissingFromInitialFlags(r4)
            java.util.Map<java.lang.String, fwfd.com.fwfsdk.model.db.FWFResult> r0 = cache
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto L_0x0025
            com.talabat.core.fwf.data.observability.FunWithFlagsObservability r1 = funWithFlagsObservability
            r1.observeEmptyCacheError(r4)
            goto L_0x002e
        L_0x0025:
            com.talabat.core.fwf.data.observability.FunWithFlagsObservability r1 = funWithFlagsObservability
            int r2 = r0.size()
            r1.observeFlagNotFoundInCacheError(r4, r2)
        L_0x002e:
            java.lang.Object r0 = r0.get(r4)
            fwfd.com.fwfsdk.model.db.FWFResult r0 = (fwfd.com.fwfsdk.model.db.FWFResult) r0
            r3.trackParticipatedExperimentEvent(r4, r0)
            if (r0 == 0) goto L_0x0041
            java.lang.Object r4 = r3.getVariationValue(r0)
            if (r4 != 0) goto L_0x0040
            goto L_0x0041
        L_0x0040:
            r5 = r4
        L_0x0041:
            return r5
        L_0x0042:
            com.talabat.core.fwf.data.observability.FunWithFlagsObservability r0 = funWithFlagsObservability
            r0.observeInvalidFlagNameError(r4)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.core.fwf.data.FunWithFlags.getVariation(com.talabat.core.fwfprojectskeys.domain.FWFKey, java.lang.Object):java.lang.Object");
    }
}
