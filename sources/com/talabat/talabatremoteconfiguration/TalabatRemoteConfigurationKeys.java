package com.talabat.talabatremoteconfiguration;

import com.talabat.core.fwfprojectskeys.domain.FWFKey;
import com.talabat.core.fwfprojectskeys.domain.FWFKeyObject;
import com.talabat.core.fwfprojectskeys.domain.FWFProjectName;
import com.talabat.talabatremoteconfiguration.keys.FreeCoffeeRemoteConfiguration;
import com.talabat.talabatremoteconfiguration.keys.IncentiveMenuRemoteConfiguration;
import com.talabat.talabatremoteconfiguration.keys.RewardsRemoteConfiguration;
import com.talabat.talabatremoteconfiguration.keys.SplashRemoteConfigurationKeys;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/talabat/talabatremoteconfiguration/TalabatRemoteConfigurationKeys;", "", "()V", "REMOTE_CONFIGURATION_KEYS", "", "Lcom/talabat/core/fwfprojectskeys/domain/FWFKey;", "getREMOTE_CONFIGURATION_KEYS", "()[Lcom/talabat/core/fwfprojectskeys/domain/FWFKey;", "[Lcom/talabat/core/fwfprojectskeys/domain/FWFKey;", "TIME_INTERVAL_API_KEY", "Lcom/talabat/core/fwfprojectskeys/domain/FWFKeyObject;", "getTIME_INTERVAL_API_KEY", "()Lcom/talabat/core/fwfprojectskeys/domain/FWFKeyObject;", "com_talabat_core_fwf-remote-configuration_fwf-remote-configuration"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TalabatRemoteConfigurationKeys {
    @NotNull
    public static final TalabatRemoteConfigurationKeys INSTANCE = new TalabatRemoteConfigurationKeys();
    @NotNull
    private static final FWFKey[] REMOTE_CONFIGURATION_KEYS;
    @NotNull
    private static final FWFKeyObject TIME_INTERVAL_API_KEY;

    static {
        FWFKeyObject fWFKeyObject = new FWFKeyObject("time-interval-for-api", (FWFProjectName) null, 2, (DefaultConstructorMarker) null);
        TIME_INTERVAL_API_KEY = fWFKeyObject;
        ArrayList arrayList = new ArrayList();
        boolean unused = CollectionsKt__MutableCollectionsKt.addAll(arrayList, (T[]) SplashRemoteConfigurationKeys.Companion.getSPLASH_KEYS());
        arrayList.add(fWFKeyObject);
        arrayList.add(IncentiveMenuRemoteConfiguration.INSTANCE.getMENU_INCENTIVE_WIDGET());
        arrayList.add(RewardsRemoteConfiguration.REWARDS_REDEMPTION_FLOW_BOTTOM_SHEET);
        arrayList.add(FreeCoffeeRemoteConfiguration.FREE_COFFEE_WELCOME_TEXTS);
        Object[] array = arrayList.toArray(new FWFKey[0]);
        if (array != null) {
            REMOTE_CONFIGURATION_KEYS = (FWFKey[]) array;
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    private TalabatRemoteConfigurationKeys() {
    }

    @NotNull
    public final FWFKey[] getREMOTE_CONFIGURATION_KEYS() {
        return REMOTE_CONFIGURATION_KEYS;
    }

    @NotNull
    public final FWFKeyObject getTIME_INTERVAL_API_KEY() {
        return TIME_INTERVAL_API_KEY;
    }
}
