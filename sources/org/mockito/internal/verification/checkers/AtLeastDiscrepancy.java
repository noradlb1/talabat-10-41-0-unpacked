package org.mockito.internal.verification.checkers;

import org.mockito.internal.reporting.Discrepancy;

public class AtLeastDiscrepancy extends Discrepancy {
    public AtLeastDiscrepancy(int i11, int i12) {
        super(i11, i12);
    }

    public String getPluralizedWantedCount() {
        return "*at least* " + super.getPluralizedWantedCount();
    }
}
