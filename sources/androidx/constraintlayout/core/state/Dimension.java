package androidx.constraintlayout.core.state;

import androidx.constraintlayout.core.widgets.ConstraintWidget;

public class Dimension {
    public static final Object FIXED_DIMENSION = new Object();
    public static final Object PARENT_DIMENSION = new Object();
    public static final Object PERCENT_DIMENSION = new Object();
    public static final Object RATIO_DIMENSION = new Object();
    public static final Object SPREAD_DIMENSION = new Object();
    public static final Object WRAP_DIMENSION = new Object();
    private final int WRAP_CONTENT;

    /* renamed from: a  reason: collision with root package name */
    public int f10706a;

    /* renamed from: b  reason: collision with root package name */
    public int f10707b;

    /* renamed from: c  reason: collision with root package name */
    public float f10708c;

    /* renamed from: d  reason: collision with root package name */
    public int f10709d;

    /* renamed from: e  reason: collision with root package name */
    public String f10710e;

    /* renamed from: f  reason: collision with root package name */
    public Object f10711f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f10712g;

    public enum Type {
        FIXED,
        WRAP,
        MATCH_PARENT,
        MATCH_CONSTRAINT
    }

    private Dimension() {
        this.WRAP_CONTENT = -2;
        this.f10706a = 0;
        this.f10707b = Integer.MAX_VALUE;
        this.f10708c = 1.0f;
        this.f10709d = 0;
        this.f10710e = null;
        this.f10711f = WRAP_DIMENSION;
        this.f10712g = false;
    }

    public static Dimension Fixed(int i11) {
        Dimension dimension = new Dimension(FIXED_DIMENSION);
        dimension.fixed(i11);
        return dimension;
    }

    public static Dimension Parent() {
        return new Dimension(PARENT_DIMENSION);
    }

    public static Dimension Percent(Object obj, float f11) {
        Dimension dimension = new Dimension(PERCENT_DIMENSION);
        dimension.percent(obj, f11);
        return dimension;
    }

    public static Dimension Ratio(String str) {
        Dimension dimension = new Dimension(RATIO_DIMENSION);
        dimension.ratio(str);
        return dimension;
    }

    public static Dimension Spread() {
        return new Dimension(SPREAD_DIMENSION);
    }

    public static Dimension Suggested(int i11) {
        Dimension dimension = new Dimension();
        dimension.suggested(i11);
        return dimension;
    }

    public static Dimension Wrap() {
        return new Dimension(WRAP_DIMENSION);
    }

    public int a() {
        return this.f10709d;
    }

    public void apply(State state, ConstraintWidget constraintWidget, int i11) {
        String str = this.f10710e;
        if (str != null) {
            constraintWidget.setDimensionRatio(str);
        }
        int i12 = 2;
        if (i11 == 0) {
            if (this.f10712g) {
                constraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
                Object obj = this.f10711f;
                if (obj == WRAP_DIMENSION) {
                    i12 = 1;
                } else if (obj != PERCENT_DIMENSION) {
                    i12 = 0;
                }
                constraintWidget.setHorizontalMatchStyle(i12, this.f10706a, this.f10707b, this.f10708c);
                return;
            }
            int i13 = this.f10706a;
            if (i13 > 0) {
                constraintWidget.setMinWidth(i13);
            }
            int i14 = this.f10707b;
            if (i14 < Integer.MAX_VALUE) {
                constraintWidget.setMaxWidth(i14);
            }
            Object obj2 = this.f10711f;
            if (obj2 == WRAP_DIMENSION) {
                constraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
            } else if (obj2 == PARENT_DIMENSION) {
                constraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_PARENT);
            } else if (obj2 == null) {
                constraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                constraintWidget.setWidth(this.f10709d);
            }
        } else if (this.f10712g) {
            constraintWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
            Object obj3 = this.f10711f;
            if (obj3 == WRAP_DIMENSION) {
                i12 = 1;
            } else if (obj3 != PERCENT_DIMENSION) {
                i12 = 0;
            }
            constraintWidget.setVerticalMatchStyle(i12, this.f10706a, this.f10707b, this.f10708c);
        } else {
            int i15 = this.f10706a;
            if (i15 > 0) {
                constraintWidget.setMinHeight(i15);
            }
            int i16 = this.f10707b;
            if (i16 < Integer.MAX_VALUE) {
                constraintWidget.setMaxHeight(i16);
            }
            Object obj4 = this.f10711f;
            if (obj4 == WRAP_DIMENSION) {
                constraintWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
            } else if (obj4 == PARENT_DIMENSION) {
                constraintWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_PARENT);
            } else if (obj4 == null) {
                constraintWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                constraintWidget.setHeight(this.f10709d);
            }
        }
    }

    public boolean equalsFixedValue(int i11) {
        return this.f10711f == null && this.f10709d == i11;
    }

    public Dimension fixed(Object obj) {
        this.f10711f = obj;
        if (obj instanceof Integer) {
            this.f10709d = ((Integer) obj).intValue();
            this.f10711f = null;
        }
        return this;
    }

    public Dimension max(int i11) {
        if (this.f10707b >= 0) {
            this.f10707b = i11;
        }
        return this;
    }

    public Dimension min(int i11) {
        if (i11 >= 0) {
            this.f10706a = i11;
        }
        return this;
    }

    public Dimension percent(Object obj, float f11) {
        this.f10708c = f11;
        return this;
    }

    public Dimension ratio(String str) {
        this.f10710e = str;
        return this;
    }

    public Dimension suggested(int i11) {
        this.f10712g = true;
        if (i11 >= 0) {
            this.f10707b = i11;
        }
        return this;
    }

    public Dimension min(Object obj) {
        if (obj == WRAP_DIMENSION) {
            this.f10706a = -2;
        }
        return this;
    }

    public static Dimension Fixed(Object obj) {
        Dimension dimension = new Dimension(FIXED_DIMENSION);
        dimension.fixed(obj);
        return dimension;
    }

    public static Dimension Suggested(Object obj) {
        Dimension dimension = new Dimension();
        dimension.suggested(obj);
        return dimension;
    }

    public Dimension max(Object obj) {
        Object obj2 = WRAP_DIMENSION;
        if (obj == obj2 && this.f10712g) {
            this.f10711f = obj2;
            this.f10707b = Integer.MAX_VALUE;
        }
        return this;
    }

    public Dimension suggested(Object obj) {
        this.f10711f = obj;
        this.f10712g = true;
        return this;
    }

    public Dimension fixed(int i11) {
        this.f10711f = null;
        this.f10709d = i11;
        return this;
    }

    private Dimension(Object obj) {
        this.WRAP_CONTENT = -2;
        this.f10706a = 0;
        this.f10707b = Integer.MAX_VALUE;
        this.f10708c = 1.0f;
        this.f10709d = 0;
        this.f10710e = null;
        this.f10712g = false;
        this.f10711f = obj;
    }
}
