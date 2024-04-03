package com.talabat.core.fwf.data;

import com.talabat.core.fwfprojectskeys.domain.FWFKeyObject;
import com.talabat.core.fwfprojectskeys.domain.FWFProjectName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/talabat/core/fwf/data/FunWithFlagsConstants;", "", "()V", "ATTRIBUTE_COUNTRY", "", "ATTRIBUTE_GLOBAL_ENTITY_ID", "ATTRIBUTE_LANGUAGE", "ATTRIBUTE_USER_EMAIL", "ATTRIBUTE_USER_ID", "ATTRIBUTE_USER_LOGGED_IN", "LOGGED_OUT_USER_ID", "OBSERVE_CACHE_SUCCESS_FLAG", "Lcom/talabat/core/fwfprojectskeys/domain/FWFKeyObject;", "getOBSERVE_CACHE_SUCCESS_FLAG", "()Lcom/talabat/core/fwfprojectskeys/domain/FWFKeyObject;", "com_talabat_core_fwf_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FunWithFlagsConstants {
    @NotNull
    public static final String ATTRIBUTE_COUNTRY = "country";
    @NotNull
    public static final String ATTRIBUTE_GLOBAL_ENTITY_ID = "globalEntityId";
    @NotNull
    public static final String ATTRIBUTE_LANGUAGE = "appLanguage";
    @NotNull
    public static final String ATTRIBUTE_USER_EMAIL = "email";
    @NotNull
    public static final String ATTRIBUTE_USER_ID = "userId";
    @NotNull
    public static final String ATTRIBUTE_USER_LOGGED_IN = "userLoggedIn";
    @NotNull
    public static final FunWithFlagsConstants INSTANCE = new FunWithFlagsConstants();
    @NotNull
    public static final String LOGGED_OUT_USER_ID = "";
    @NotNull
    private static final FWFKeyObject OBSERVE_CACHE_SUCCESS_FLAG = new FWFKeyObject("android_fwf_observe_cache_success", (FWFProjectName) null, 2, (DefaultConstructorMarker) null);

    private FunWithFlagsConstants() {
    }

    @NotNull
    public final FWFKeyObject getOBSERVE_CACHE_SUCCESS_FLAG() {
        return OBSERVE_CACHE_SUCCESS_FLAG;
    }
}
