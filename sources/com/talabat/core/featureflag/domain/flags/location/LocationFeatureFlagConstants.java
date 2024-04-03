package com.talabat.core.featureflag.domain.flags.location;

import com.talabat.core.fwfprojectskeys.domain.FWFKey;
import com.talabat.core.fwfprojectskeys.domain.FWFProjectName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0001\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\u000eB\u0019\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lcom/talabat/core/featureflag/domain/flags/location/LocationFeatureFlagConstants;", "", "Lcom/talabat/core/fwfprojectskeys/domain/FWFKey;", "value", "", "projectName", "Lcom/talabat/core/fwfprojectskeys/domain/FWFProjectName;", "(Ljava/lang/String;ILjava/lang/String;Lcom/talabat/core/fwfprojectskeys/domain/FWFProjectName;)V", "getProjectName", "()Lcom/talabat/core/fwfprojectskeys/domain/FWFProjectName;", "getValue", "()Ljava/lang/String;", "LOCATION_REPO_REAL_AREAS", "LOCATION_REPO_REAL_COUNTRIES", "Companion", "com_talabat_core_feature-flag_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public enum LocationFeatureFlagConstants implements FWFKey {
    LOCATION_REPO_REAL_AREAS("location_repo_real_areas-v2", (int) null, 2, (FWFProjectName) null),
    LOCATION_REPO_REAL_COUNTRIES("location_repo_real_countries-v2", (int) null, 2, (FWFProjectName) null);
    
    @NotNull
    public static final Companion Companion = null;
    /* access modifiers changed from: private */
    @NotNull
    public static final Function0<List<FWFKey>> LocationFlags = null;
    @NotNull
    private final FWFProjectName projectName;
    @NotNull
    private final String value;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001d\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/talabat/core/featureflag/domain/flags/location/LocationFeatureFlagConstants$Companion;", "", "()V", "LocationFlags", "Lkotlin/Function0;", "", "Lcom/talabat/core/fwfprojectskeys/domain/FWFKey;", "getLocationFlags", "()Lkotlin/jvm/functions/Function0;", "com_talabat_core_feature-flag_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Function0<List<FWFKey>> getLocationFlags() {
            return LocationFeatureFlagConstants.LocationFlags;
        }
    }

    /* access modifiers changed from: public */
    static {
        Companion = new Companion((DefaultConstructorMarker) null);
        LocationFlags = LocationFeatureFlagConstants$Companion$LocationFlags$1.INSTANCE;
    }

    private LocationFeatureFlagConstants(String str, FWFProjectName fWFProjectName) {
        this.value = str;
        this.projectName = fWFProjectName;
    }

    @NotNull
    public FWFProjectName getProjectName() {
        return this.projectName;
    }

    @NotNull
    public String getValue() {
        return this.value;
    }
}
