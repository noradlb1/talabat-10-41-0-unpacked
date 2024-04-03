package com.talabat.fluttercore.channels;

import com.talabat.core.fwfprojectskeys.domain.FWFKeyObject;
import java.util.HashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H&JP\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\bj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0001`\n2\u0006\u0010\u000b\u001a\u00020\u00052\"\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\bj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0001`\nH&¨\u0006\f"}, d2 = {"Lcom/talabat/fluttercore/channels/FeatureFlagMethodChannelCallback;", "", "getFeatureFlag", "", "featureFlagKey", "Lcom/talabat/core/fwfprojectskeys/domain/FWFKeyObject;", "defaultValue", "getRemoteConfig", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "remoteConfigKey", "com_talabat_NewArchi_TalabatFlutterCore_TalabatFlutterCore"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface FeatureFlagMethodChannelCallback {
    boolean getFeatureFlag(@NotNull FWFKeyObject fWFKeyObject, boolean z11);

    @NotNull
    HashMap<String, Object> getRemoteConfig(@NotNull FWFKeyObject fWFKeyObject, @NotNull HashMap<String, Object> hashMap);
}
