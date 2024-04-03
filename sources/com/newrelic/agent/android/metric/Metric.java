package com.newrelic.agent.android.metric;

import com.deliveryhero.performance.core.screenmetric.performance.RichContentLoadTimeTracer;
import com.newrelic.agent.android.harvest.type.HarvestableObject;
import com.newrelic.com.google.gson.JsonElement;
import com.newrelic.com.google.gson.JsonObject;
import com.newrelic.com.google.gson.JsonPrimitive;
import com.visa.checkout.PurchaseInfo;

public class Metric extends HarvestableObject {
    private long count;
    private Double exclusive;
    private Double max;
    private Double min;

    /* renamed from: name  reason: collision with root package name */
    private String f52786name;
    private String scope;
    private Double sumOfSquares;
    private Double total;

    public Metric(String str) {
        this(str, (String) null);
    }

    public void addExclusive(double d11) {
        Double d12 = this.exclusive;
        if (d12 == null) {
            this.exclusive = Double.valueOf(d11);
        } else {
            this.exclusive = Double.valueOf(d12.doubleValue() + d11);
        }
    }

    public void aggregate(Metric metric) {
        double d11;
        double d12;
        double d13;
        if (metric != null) {
            increment(metric.getCount());
            if (!metric.isCountOnly()) {
                Double d14 = this.total;
                if (d14 == null) {
                    d11 = metric.getTotal();
                } else {
                    d11 = d14.doubleValue() + metric.getTotal();
                }
                this.total = Double.valueOf(d11);
                Double d15 = this.sumOfSquares;
                if (d15 == null) {
                    d12 = metric.getSumOfSquares();
                } else {
                    d12 = d15.doubleValue() + metric.getSumOfSquares();
                }
                this.sumOfSquares = Double.valueOf(d12);
                Double d16 = this.exclusive;
                if (d16 == null) {
                    d13 = metric.getExclusive();
                } else {
                    d13 = d16.doubleValue() + metric.getExclusive();
                }
                this.exclusive = Double.valueOf(d13);
                setMin(Double.valueOf(metric.getMin()));
                setMax(Double.valueOf(metric.getMax()));
            }
        }
    }

    public JsonElement asJson() {
        if (isCountOnly()) {
            return new JsonPrimitive((Number) Long.valueOf(this.count));
        }
        return asJsonObject();
    }

    public JsonObject asJsonObject() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("count", new JsonPrimitive((Number) Long.valueOf(this.count)));
        Double d11 = this.total;
        if (d11 != null) {
            jsonObject.add(PurchaseInfo.TOTAL, new JsonPrimitive((Number) d11));
        }
        Double d12 = this.min;
        if (d12 != null) {
            jsonObject.add("min", new JsonPrimitive((Number) d12));
        }
        Double d13 = this.max;
        if (d13 != null) {
            jsonObject.add(RichContentLoadTimeTracer.MAX, new JsonPrimitive((Number) d13));
        }
        Double d14 = this.sumOfSquares;
        if (d14 != null) {
            jsonObject.add("sum_of_squares", new JsonPrimitive((Number) d14));
        }
        Double d15 = this.exclusive;
        if (d15 != null) {
            jsonObject.add("exclusive", new JsonPrimitive((Number) d15));
        }
        return jsonObject;
    }

    public void clear() {
        this.min = null;
        this.max = null;
        this.total = null;
        this.sumOfSquares = null;
        this.exclusive = null;
        this.count = 0;
    }

    public long getCount() {
        return this.count;
    }

    public double getExclusive() {
        Double d11 = this.exclusive;
        if (d11 == null || d11.doubleValue() < 0.0d) {
            return 0.0d;
        }
        return this.exclusive.doubleValue();
    }

    public double getMax() {
        Double d11 = this.max;
        if (d11 == null || d11.doubleValue() < 0.0d) {
            return 0.0d;
        }
        return this.max.doubleValue();
    }

    public double getMin() {
        Double d11 = this.min;
        if (d11 == null || d11.doubleValue() < 0.0d) {
            return 0.0d;
        }
        return this.min.doubleValue();
    }

    public String getName() {
        return this.f52786name;
    }

    public String getScope() {
        return this.scope;
    }

    public String getStringScope() {
        String str = this.scope;
        return str == null ? "" : str;
    }

    public double getSumOfSquares() {
        Double d11 = this.sumOfSquares;
        if (d11 == null || d11.doubleValue() < 0.0d) {
            return 0.0d;
        }
        return this.sumOfSquares.doubleValue();
    }

    public double getTotal() {
        Double d11 = this.total;
        if (d11 == null || d11.doubleValue() < 0.0d) {
            return 0.0d;
        }
        return this.total.doubleValue();
    }

    public void increment(long j11) {
        this.count += j11;
    }

    public boolean isCountOnly() {
        return this.total == null;
    }

    public boolean isScoped() {
        return this.scope != null;
    }

    public boolean isUnscoped() {
        return this.scope == null;
    }

    public void sample(double d11) {
        this.count++;
        Double d12 = this.total;
        if (d12 == null) {
            this.total = Double.valueOf(d11);
            this.sumOfSquares = Double.valueOf(d11 * d11);
        } else {
            this.total = Double.valueOf(d12.doubleValue() + d11);
            this.sumOfSquares = Double.valueOf(this.sumOfSquares.doubleValue() + (d11 * d11));
        }
        setMin(Double.valueOf(d11));
        setMax(Double.valueOf(d11));
    }

    public void sampleMetricDataUsage(double d11, double d12) {
        this.count++;
        Double d13 = this.total;
        if (d13 == null) {
            this.total = Double.valueOf(d11);
        } else {
            this.total = Double.valueOf(d13.doubleValue() + d11);
        }
        Double d14 = this.exclusive;
        if (d14 == null) {
            this.exclusive = Double.valueOf(d12);
        } else {
            this.exclusive = Double.valueOf(d14.doubleValue() + d12);
        }
        this.sumOfSquares = Double.valueOf(0.0d);
        this.min = Double.valueOf(0.0d);
        this.max = Double.valueOf(0.0d);
    }

    public void setCount(long j11) {
        this.count = j11;
    }

    public void setExclusive(Double d11) {
        this.exclusive = d11;
    }

    public void setMax(Double d11) {
        if (d11 != null) {
            if (this.max == null) {
                this.max = d11;
            } else if (d11.doubleValue() > this.max.doubleValue()) {
                this.max = d11;
            }
        }
    }

    public void setMaxFieldValue(Double d11) {
        this.max = d11;
    }

    public void setMin(Double d11) {
        if (d11 != null) {
            if (this.min == null) {
                this.min = d11;
            } else if (d11.doubleValue() < this.min.doubleValue()) {
                this.min = d11;
            }
        }
    }

    public void setMinFieldValue(Double d11) {
        this.min = d11;
    }

    public void setName(String str) {
        this.f52786name = str;
    }

    public void setScope(String str) {
        this.scope = str;
    }

    public void setSumOfSquares(Double d11) {
        this.sumOfSquares = d11;
    }

    public void setTotal(Double d11) {
        this.total = d11;
    }

    public String toString() {
        long j11 = this.count;
        Double d11 = this.total;
        Double d12 = this.max;
        Double d13 = this.min;
        String str = this.scope;
        String str2 = this.f52786name;
        Double d14 = this.exclusive;
        Double d15 = this.sumOfSquares;
        return "Metric{count=" + j11 + ", total=" + d11 + ", max=" + d12 + ", min=" + d13 + ", scope='" + str + "', name='" + str2 + "', exclusive='" + d14 + "', sumofsquares='" + d15 + "'}";
    }

    public Metric(String str, String str2) {
        this.f52786name = str;
        this.scope = str2;
        this.count = 0;
    }

    public void increment() {
        increment(1);
    }

    public Metric(Metric metric) {
        this.f52786name = metric.getName();
        this.scope = metric.getScope();
        this.min = Double.valueOf(metric.getMin());
        this.max = Double.valueOf(metric.getMax());
        this.total = Double.valueOf(metric.getTotal());
        this.sumOfSquares = Double.valueOf(metric.getSumOfSquares());
        this.exclusive = Double.valueOf(metric.getExclusive());
        this.count = metric.getCount();
    }
}
