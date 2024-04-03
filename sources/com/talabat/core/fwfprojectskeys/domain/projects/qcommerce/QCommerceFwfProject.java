package com.talabat.core.fwfprojectskeys.domain.projects.qcommerce;

import com.talabat.core.fwfprojectskeys.domain.FWFProject;
import com.talabat.core.fwfprojectskeys.domain.FWFProjectName;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/talabat/core/fwfprojectskeys/domain/projects/qcommerce/QCommerceFwfProject;", "Lcom/talabat/core/fwfprojectskeys/domain/FWFProject;", "()V", "fwfProjectName", "Lcom/talabat/core/fwfprojectskeys/domain/FWFProjectName;", "getFwfProjectName", "()Lcom/talabat/core/fwfprojectskeys/domain/FWFProjectName;", "getAllKeys", "", "", "com_talabat_core_fwf-projects-keys_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class QCommerceFwfProject extends FWFProject {
    @NotNull
    private final FWFProjectName fwfProjectName = FWFProjectName.Q_COMMERCE;

    @NotNull
    public List<String> getAllKeys() {
        QcommerceExperimentsKeys[] values = QcommerceExperimentsKeys.values();
        ArrayList arrayList = new ArrayList(values.length);
        for (QcommerceExperimentsKeys value : values) {
            arrayList.add(value.getValue());
        }
        QCommerceFeatureFlagsKeys[] values2 = QCommerceFeatureFlagsKeys.values();
        ArrayList arrayList2 = new ArrayList(values2.length);
        for (QCommerceFeatureFlagsKeys value2 : values2) {
            arrayList2.add(value2.getValue());
        }
        Collection plus = CollectionsKt___CollectionsKt.plus(arrayList, arrayList2);
        QCommerceRemoteConfigurationsKeys[] values3 = QCommerceRemoteConfigurationsKeys.values();
        ArrayList arrayList3 = new ArrayList(values3.length);
        for (QCommerceRemoteConfigurationsKeys value3 : values3) {
            arrayList3.add(value3.getValue());
        }
        return CollectionsKt___CollectionsKt.plus(plus, arrayList3);
    }

    @NotNull
    public FWFProjectName getFwfProjectName() {
        return this.fwfProjectName;
    }
}
