package com.google.common.math;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Doubles;
import java.util.Iterator;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
@J2ktIncompatible
public final class StatsAccumulator {
    private long count = 0;
    private double max = Double.NaN;
    private double mean = 0.0d;
    private double min = Double.NaN;
    private double sumOfSquaresOfDeltas = 0.0d;

    public static double calculateNewMeanNonFinite(double d11, double d12) {
        if (Doubles.isFinite(d11)) {
            return d12;
        }
        if (Doubles.isFinite(d12) || d11 == d12) {
            return d11;
        }
        return Double.NaN;
    }

    private void merge(long j11, double d11, double d12, double d13, double d14) {
        long j12 = j11;
        double d15 = d11;
        double d16 = d12;
        double d17 = d13;
        double d18 = d14;
        long j13 = this.count;
        if (j13 == 0) {
            this.count = j12;
            this.mean = d15;
            this.sumOfSquaresOfDeltas = d16;
            this.min = d17;
            this.max = d18;
            return;
        }
        this.count = j13 + j12;
        if (!Doubles.isFinite(this.mean) || !Doubles.isFinite(d11)) {
            this.mean = calculateNewMeanNonFinite(this.mean, d15);
            this.sumOfSquaresOfDeltas = Double.NaN;
        } else {
            double d19 = this.mean;
            double d21 = d15 - d19;
            double d22 = (double) j12;
            double d23 = d19 + ((d21 * d22) / ((double) this.count));
            this.mean = d23;
            this.sumOfSquaresOfDeltas += d16 + (d21 * (d15 - d23) * d22);
        }
        this.min = Math.min(this.min, d17);
        this.max = Math.max(this.max, d14);
    }

    public void add(double d11) {
        long j11 = this.count;
        if (j11 == 0) {
            this.count = 1;
            this.mean = d11;
            this.min = d11;
            this.max = d11;
            if (!Doubles.isFinite(d11)) {
                this.sumOfSquaresOfDeltas = Double.NaN;
                return;
            }
            return;
        }
        this.count = j11 + 1;
        if (!Doubles.isFinite(d11) || !Doubles.isFinite(this.mean)) {
            this.mean = calculateNewMeanNonFinite(this.mean, d11);
            this.sumOfSquaresOfDeltas = Double.NaN;
        } else {
            double d12 = this.mean;
            double d13 = d11 - d12;
            double d14 = d12 + (d13 / ((double) this.count));
            this.mean = d14;
            this.sumOfSquaresOfDeltas += d13 * (d11 - d14);
        }
        this.min = Math.min(this.min, d11);
        this.max = Math.max(this.max, d11);
    }

    public void addAll(Iterable<? extends Number> iterable) {
        for (Number doubleValue : iterable) {
            add(doubleValue.doubleValue());
        }
    }

    public long count() {
        return this.count;
    }

    public double max() {
        boolean z11;
        if (this.count != 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkState(z11);
        return this.max;
    }

    public double mean() {
        boolean z11;
        if (this.count != 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkState(z11);
        return this.mean;
    }

    public double min() {
        boolean z11;
        if (this.count != 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkState(z11);
        return this.min;
    }

    public final double populationStandardDeviation() {
        return Math.sqrt(populationVariance());
    }

    public final double populationVariance() {
        boolean z11;
        if (this.count != 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkState(z11);
        if (Double.isNaN(this.sumOfSquaresOfDeltas)) {
            return Double.NaN;
        }
        if (this.count == 1) {
            return 0.0d;
        }
        return DoubleUtils.ensureNonNegative(this.sumOfSquaresOfDeltas) / ((double) this.count);
    }

    public final double sampleStandardDeviation() {
        return Math.sqrt(sampleVariance());
    }

    public final double sampleVariance() {
        boolean z11;
        if (this.count > 1) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkState(z11);
        if (Double.isNaN(this.sumOfSquaresOfDeltas)) {
            return Double.NaN;
        }
        return DoubleUtils.ensureNonNegative(this.sumOfSquaresOfDeltas) / ((double) (this.count - 1));
    }

    public Stats snapshot() {
        return new Stats(this.count, this.mean, this.sumOfSquaresOfDeltas, this.min, this.max);
    }

    public final double sum() {
        return this.mean * ((double) this.count);
    }

    public double sumOfSquaresOfDeltas() {
        return this.sumOfSquaresOfDeltas;
    }

    public void addAll(Iterator<? extends Number> it) {
        while (it.hasNext()) {
            add(((Number) it.next()).doubleValue());
        }
    }

    public void addAll(double... dArr) {
        for (double add : dArr) {
            add(add);
        }
    }

    public void addAll(int... iArr) {
        for (int i11 : iArr) {
            add((double) i11);
        }
    }

    public void addAll(long... jArr) {
        for (long j11 : jArr) {
            add((double) j11);
        }
    }

    public void addAll(Stats stats) {
        if (stats.count() != 0) {
            merge(stats.count(), stats.mean(), stats.sumOfSquaresOfDeltas(), stats.min(), stats.max());
        }
    }

    public void addAll(StatsAccumulator statsAccumulator) {
        if (statsAccumulator.count() != 0) {
            merge(statsAccumulator.count(), statsAccumulator.mean(), statsAccumulator.sumOfSquaresOfDeltas(), statsAccumulator.min(), statsAccumulator.max());
        }
    }
}
