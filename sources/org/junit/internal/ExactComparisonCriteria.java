package org.junit.internal;

import org.junit.Assert;

public class ExactComparisonCriteria extends ComparisonCriteria {
    public void a(Object obj, Object obj2) {
        Assert.assertEquals(obj, obj2);
    }
}
