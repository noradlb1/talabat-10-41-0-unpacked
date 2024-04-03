package com.talabat.core.featureflag.domain.flags.location;

import com.talabat.core.fwfprojectskeys.domain.FWFKey;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/talabat/core/fwfprojectskeys/domain/FWFKey;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class LocationFeatureFlagConstants$Companion$LocationFlags$1 extends Lambda implements Function0<List<? extends FWFKey>> {
    public static final LocationFeatureFlagConstants$Companion$LocationFlags$1 INSTANCE = new LocationFeatureFlagConstants$Companion$LocationFlags$1();

    public LocationFeatureFlagConstants$Companion$LocationFlags$1() {
        super(0);
    }

    @NotNull
    public final List<FWFKey> invoke() {
        return SequencesKt___SequencesKt.toList(SequencesKt___SequencesKt.plus(SequencesKt___SequencesKt.plus(CollectionsKt___CollectionsKt.asSequence(new ArrayList()), LocationFeatureFlagConstants.LOCATION_REPO_REAL_AREAS), LocationFeatureFlagConstants.LOCATION_REPO_REAL_COUNTRIES));
    }
}
