package com.google.common.math;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Doubles;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
@J2ktIncompatible
public final class PairedStatsAccumulator {
    private double sumOfProductsOfDeltas = 0.0d;
    private final StatsAccumulator xStats = new StatsAccumulator();
    private final StatsAccumulator yStats = new StatsAccumulator();

    private static double ensureInUnitRange(double d11) {
        return Doubles.constrainToRange(d11, -1.0d, 1.0d);
    }

    private double ensurePositive(double d11) {
        if (d11 > 0.0d) {
            return d11;
        }
        return Double.MIN_VALUE;
    }

    public void add(double d11, double d12) {
        this.xStats.add(d11);
        if (!Doubles.isFinite(d11) || !Doubles.isFinite(d12)) {
            this.sumOfProductsOfDeltas = Double.NaN;
        } else if (this.xStats.count() > 1) {
            this.sumOfProductsOfDeltas += (d11 - this.xStats.mean()) * (d12 - this.yStats.mean());
        }
        this.yStats.add(d12);
    }

    public void addAll(PairedStats pairedStats) {
        if (pairedStats.count() != 0) {
            this.xStats.addAll(pairedStats.xStats());
            if (this.yStats.count() == 0) {
                this.sumOfProductsOfDeltas = pairedStats.sumOfProductsOfDeltas();
            } else {
                this.sumOfProductsOfDeltas += pairedStats.sumOfProductsOfDeltas() + ((pairedStats.xStats().mean() - this.xStats.mean()) * (pairedStats.yStats().mean() - this.yStats.mean()) * ((double) pairedStats.count()));
            }
            this.yStats.addAll(pairedStats.yStats());
        }
    }

    public long count() {
        return this.xStats.count();
    }

    public final LinearTransformation leastSquaresFit() {
        boolean z11;
        boolean z12 = true;
        if (count() > 1) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkState(z11);
        if (Double.isNaN(this.sumOfProductsOfDeltas)) {
            return LinearTransformation.forNaN();
        }
        double sumOfSquaresOfDeltas = this.xStats.sumOfSquaresOfDeltas();
        if (sumOfSquaresOfDeltas <= 0.0d) {
            if (this.yStats.sumOfSquaresOfDeltas() <= 0.0d) {
                z12 = false;
            }
            Preconditions.checkState(z12);
            return LinearTransformation.vertical(this.xStats.mean());
        } else if (this.yStats.sumOfSquaresOfDeltas() > 0.0d) {
            return LinearTransformation.mapping(this.xStats.mean(), this.yStats.mean()).withSlope(this.sumOfProductsOfDeltas / sumOfSquaresOfDeltas);
        } else {
            return LinearTransformation.horizontal(this.yStats.mean());
        }
    }

    public final double pearsonsCorrelationCoefficient() {
        boolean z11;
        boolean z12;
        boolean z13 = true;
        if (count() > 1) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkState(z11);
        if (Double.isNaN(this.sumOfProductsOfDeltas)) {
            return Double.NaN;
        }
        double sumOfSquaresOfDeltas = this.xStats.sumOfSquaresOfDeltas();
        double sumOfSquaresOfDeltas2 = this.yStats.sumOfSquaresOfDeltas();
        if (sumOfSquaresOfDeltas > 0.0d) {
            z12 = true;
        } else {
            z12 = false;
        }
        Preconditions.checkState(z12);
        if (sumOfSquaresOfDeltas2 <= 0.0d) {
            z13 = false;
        }
        Preconditions.checkState(z13);
        return ensureInUnitRange(this.sumOfProductsOfDeltas / Math.sqrt(ensurePositive(sumOfSquaresOfDeltas * sumOfSquaresOfDeltas2)));
    }

    public double populationCovariance() {
        boolean z11;
        if (count() != 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkState(z11);
        return this.sumOfProductsOfDeltas / ((double) count());
    }

    public final double sampleCovariance() {
        boolean z11;
        if (count() > 1) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkState(z11);
        return this.sumOfProductsOfDeltas / ((double) (count() - 1));
    }

    public PairedStats snapshot() {
        return new PairedStats(this.xStats.snapshot(), this.yStats.snapshot(), this.sumOfProductsOfDeltas);
    }

    public Stats xStats() {
        return this.xStats.snapshot();
    }

    public Stats yStats() {
        return this.yStats.snapshot();
    }
}
