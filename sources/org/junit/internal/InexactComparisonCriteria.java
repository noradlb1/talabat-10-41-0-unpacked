package org.junit.internal;

import org.junit.Assert;

public class InexactComparisonCriteria extends ComparisonCriteria {
    public Object fDelta;

    public InexactComparisonCriteria(double d11) {
        this.fDelta = Double.valueOf(d11);
    }

    public void a(Object obj, Object obj2) {
        if (obj instanceof Double) {
            Assert.assertEquals(((Double) obj).doubleValue(), ((Double) obj2).doubleValue(), ((Double) this.fDelta).doubleValue());
        } else {
            Assert.assertEquals(((Float) obj).floatValue(), ((Float) obj2).floatValue(), ((Float) this.fDelta).floatValue());
        }
    }

    public InexactComparisonCriteria(float f11) {
        this.fDelta = Float.valueOf(f11);
    }
}
