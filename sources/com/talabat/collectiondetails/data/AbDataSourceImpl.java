package com.talabat.collectiondetails.data;

import com.talabat.core.experiment.data.TalabatExperiment;
import com.talabat.core.experiment.data.TalabatExperimentConstants;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/talabat/collectiondetails/data/AbDataSourceImpl;", "Lcom/talabat/collectiondetails/data/AbDataSource;", "()V", "canShowNewListingSearch", "", "com_talabat_Components_collectiondetails_collectiondetails"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AbDataSourceImpl implements AbDataSource {
    public boolean canShowNewListingSearch() {
        return ITalabatExperiment.DefaultImpls.getBooleanVariant$default(TalabatExperiment.INSTANCE, TalabatExperimentConstants.CAN_ENABLE_LISTING_DHSEARCH, false, (TalabatExperimentDataSourceStrategy) null, 4, (Object) null);
    }
}
