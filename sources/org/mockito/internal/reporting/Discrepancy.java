package org.mockito.internal.reporting;

public class Discrepancy {
    private final int actualCount;
    private final int wantedCount;

    public Discrepancy(int i11, int i12) {
        this.wantedCount = i11;
        this.actualCount = i12;
    }

    public int getActualCount() {
        return this.actualCount;
    }

    public String getPluralizedActualCount() {
        return Pluralizer.pluralize(this.actualCount);
    }

    public String getPluralizedWantedCount() {
        return Pluralizer.pluralize(this.wantedCount);
    }

    public int getWantedCount() {
        return this.wantedCount;
    }
}
