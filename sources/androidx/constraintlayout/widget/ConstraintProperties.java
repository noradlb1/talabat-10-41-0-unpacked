package androidx.constraintlayout.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.ads.AdError;

public class ConstraintProperties {
    public static final int BASELINE = 5;
    public static final int BOTTOM = 4;
    public static final int END = 7;
    public static final int LEFT = 1;
    public static final int MATCH_CONSTRAINT = 0;
    public static final int MATCH_CONSTRAINT_SPREAD = 0;
    public static final int MATCH_CONSTRAINT_WRAP = 1;
    public static final int PARENT_ID = 0;
    public static final int RIGHT = 2;
    public static final int START = 6;
    public static final int TOP = 3;
    public static final int UNSET = -1;
    public static final int WRAP_CONTENT = -2;

    /* renamed from: a  reason: collision with root package name */
    public ConstraintLayout.LayoutParams f11146a;

    /* renamed from: b  reason: collision with root package name */
    public View f11147b;

    public ConstraintProperties(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.LayoutParams) {
            this.f11146a = (ConstraintLayout.LayoutParams) layoutParams;
            this.f11147b = view;
            return;
        }
        throw new RuntimeException("Only children of ConstraintLayout.LayoutParams supported");
    }

    private String sideToString(int i11) {
        switch (i11) {
            case 1:
                return "left";
            case 2:
                return TtmlNode.RIGHT;
            case 3:
                return ViewHierarchyConstants.DIMENSION_TOP_KEY;
            case 4:
                return "bottom";
            case 5:
                return "baseline";
            case 6:
                return "start";
            case 7:
                return TtmlNode.END;
            default:
                return AdError.UNDEFINED_DOMAIN;
        }
    }

    public ConstraintProperties addToHorizontalChain(int i11, int i12) {
        int i13;
        int i14;
        if (i11 == 0) {
            i13 = 1;
        } else {
            i13 = 2;
        }
        connect(1, i11, i13, 0);
        if (i12 == 0) {
            i14 = 2;
        } else {
            i14 = 1;
        }
        connect(2, i12, i14, 0);
        if (i11 != 0) {
            new ConstraintProperties(((ViewGroup) this.f11147b.getParent()).findViewById(i11)).connect(2, this.f11147b.getId(), 1, 0);
        }
        if (i12 != 0) {
            new ConstraintProperties(((ViewGroup) this.f11147b.getParent()).findViewById(i12)).connect(1, this.f11147b.getId(), 2, 0);
        }
        return this;
    }

    public ConstraintProperties addToHorizontalChainRTL(int i11, int i12) {
        int i13;
        int i14;
        if (i11 == 0) {
            i13 = 6;
        } else {
            i13 = 7;
        }
        connect(6, i11, i13, 0);
        if (i12 == 0) {
            i14 = 7;
        } else {
            i14 = 6;
        }
        connect(7, i12, i14, 0);
        if (i11 != 0) {
            new ConstraintProperties(((ViewGroup) this.f11147b.getParent()).findViewById(i11)).connect(7, this.f11147b.getId(), 6, 0);
        }
        if (i12 != 0) {
            new ConstraintProperties(((ViewGroup) this.f11147b.getParent()).findViewById(i12)).connect(6, this.f11147b.getId(), 7, 0);
        }
        return this;
    }

    public ConstraintProperties addToVerticalChain(int i11, int i12) {
        int i13;
        int i14;
        if (i11 == 0) {
            i13 = 3;
        } else {
            i13 = 4;
        }
        connect(3, i11, i13, 0);
        if (i12 == 0) {
            i14 = 4;
        } else {
            i14 = 3;
        }
        connect(4, i12, i14, 0);
        if (i11 != 0) {
            new ConstraintProperties(((ViewGroup) this.f11147b.getParent()).findViewById(i11)).connect(4, this.f11147b.getId(), 3, 0);
        }
        if (i12 != 0) {
            new ConstraintProperties(((ViewGroup) this.f11147b.getParent()).findViewById(i12)).connect(3, this.f11147b.getId(), 4, 0);
        }
        return this;
    }

    public ConstraintProperties alpha(float f11) {
        this.f11147b.setAlpha(f11);
        return this;
    }

    public void apply() {
    }

    public ConstraintProperties center(int i11, int i12, int i13, int i14, int i15, int i16, float f11) {
        if (i13 < 0) {
            throw new IllegalArgumentException("margin must be > 0");
        } else if (i16 < 0) {
            throw new IllegalArgumentException("margin must be > 0");
        } else if (f11 <= 0.0f || f11 > 1.0f) {
            throw new IllegalArgumentException("bias must be between 0 and 1 inclusive");
        } else {
            if (i12 == 1 || i12 == 2) {
                connect(1, i11, i12, i13);
                connect(2, i14, i15, i16);
                this.f11146a.horizontalBias = f11;
            } else if (i12 == 6 || i12 == 7) {
                connect(6, i11, i12, i13);
                connect(7, i14, i15, i16);
                this.f11146a.horizontalBias = f11;
            } else {
                connect(3, i11, i12, i13);
                connect(4, i14, i15, i16);
                this.f11146a.verticalBias = f11;
            }
            return this;
        }
    }

    public ConstraintProperties centerHorizontally(int i11, int i12, int i13, int i14, int i15, int i16, float f11) {
        connect(1, i11, i12, i13);
        connect(2, i14, i15, i16);
        this.f11146a.horizontalBias = f11;
        return this;
    }

    public ConstraintProperties centerHorizontallyRtl(int i11, int i12, int i13, int i14, int i15, int i16, float f11) {
        connect(6, i11, i12, i13);
        connect(7, i14, i15, i16);
        this.f11146a.horizontalBias = f11;
        return this;
    }

    public ConstraintProperties centerVertically(int i11, int i12, int i13, int i14, int i15, int i16, float f11) {
        connect(3, i11, i12, i13);
        connect(4, i14, i15, i16);
        this.f11146a.verticalBias = f11;
        return this;
    }

    public ConstraintProperties connect(int i11, int i12, int i13, int i14) {
        switch (i11) {
            case 1:
                if (i13 == 1) {
                    ConstraintLayout.LayoutParams layoutParams = this.f11146a;
                    layoutParams.leftToLeft = i12;
                    layoutParams.leftToRight = -1;
                } else if (i13 == 2) {
                    ConstraintLayout.LayoutParams layoutParams2 = this.f11146a;
                    layoutParams2.leftToRight = i12;
                    layoutParams2.leftToLeft = -1;
                } else {
                    throw new IllegalArgumentException("Left to " + sideToString(i13) + " undefined");
                }
                this.f11146a.leftMargin = i14;
                break;
            case 2:
                if (i13 == 1) {
                    ConstraintLayout.LayoutParams layoutParams3 = this.f11146a;
                    layoutParams3.rightToLeft = i12;
                    layoutParams3.rightToRight = -1;
                } else if (i13 == 2) {
                    ConstraintLayout.LayoutParams layoutParams4 = this.f11146a;
                    layoutParams4.rightToRight = i12;
                    layoutParams4.rightToLeft = -1;
                } else {
                    throw new IllegalArgumentException("right to " + sideToString(i13) + " undefined");
                }
                this.f11146a.rightMargin = i14;
                break;
            case 3:
                if (i13 == 3) {
                    ConstraintLayout.LayoutParams layoutParams5 = this.f11146a;
                    layoutParams5.topToTop = i12;
                    layoutParams5.topToBottom = -1;
                    layoutParams5.baselineToBaseline = -1;
                    layoutParams5.baselineToTop = -1;
                    layoutParams5.baselineToBottom = -1;
                } else if (i13 == 4) {
                    ConstraintLayout.LayoutParams layoutParams6 = this.f11146a;
                    layoutParams6.topToBottom = i12;
                    layoutParams6.topToTop = -1;
                    layoutParams6.baselineToBaseline = -1;
                    layoutParams6.baselineToTop = -1;
                    layoutParams6.baselineToBottom = -1;
                } else {
                    throw new IllegalArgumentException("right to " + sideToString(i13) + " undefined");
                }
                this.f11146a.topMargin = i14;
                break;
            case 4:
                if (i13 == 4) {
                    ConstraintLayout.LayoutParams layoutParams7 = this.f11146a;
                    layoutParams7.bottomToBottom = i12;
                    layoutParams7.bottomToTop = -1;
                    layoutParams7.baselineToBaseline = -1;
                    layoutParams7.baselineToTop = -1;
                    layoutParams7.baselineToBottom = -1;
                } else if (i13 == 3) {
                    ConstraintLayout.LayoutParams layoutParams8 = this.f11146a;
                    layoutParams8.bottomToTop = i12;
                    layoutParams8.bottomToBottom = -1;
                    layoutParams8.baselineToBaseline = -1;
                    layoutParams8.baselineToTop = -1;
                    layoutParams8.baselineToBottom = -1;
                } else {
                    throw new IllegalArgumentException("right to " + sideToString(i13) + " undefined");
                }
                this.f11146a.bottomMargin = i14;
                break;
            case 5:
                if (i13 == 5) {
                    ConstraintLayout.LayoutParams layoutParams9 = this.f11146a;
                    layoutParams9.baselineToBaseline = i12;
                    layoutParams9.bottomToBottom = -1;
                    layoutParams9.bottomToTop = -1;
                    layoutParams9.topToTop = -1;
                    layoutParams9.topToBottom = -1;
                }
                if (i13 == 3) {
                    ConstraintLayout.LayoutParams layoutParams10 = this.f11146a;
                    layoutParams10.baselineToTop = i12;
                    layoutParams10.bottomToBottom = -1;
                    layoutParams10.bottomToTop = -1;
                    layoutParams10.topToTop = -1;
                    layoutParams10.topToBottom = -1;
                } else if (i13 == 4) {
                    ConstraintLayout.LayoutParams layoutParams11 = this.f11146a;
                    layoutParams11.baselineToBottom = i12;
                    layoutParams11.bottomToBottom = -1;
                    layoutParams11.bottomToTop = -1;
                    layoutParams11.topToTop = -1;
                    layoutParams11.topToBottom = -1;
                } else {
                    throw new IllegalArgumentException("right to " + sideToString(i13) + " undefined");
                }
                this.f11146a.baselineMargin = i14;
                break;
            case 6:
                if (i13 == 6) {
                    ConstraintLayout.LayoutParams layoutParams12 = this.f11146a;
                    layoutParams12.startToStart = i12;
                    layoutParams12.startToEnd = -1;
                } else if (i13 == 7) {
                    ConstraintLayout.LayoutParams layoutParams13 = this.f11146a;
                    layoutParams13.startToEnd = i12;
                    layoutParams13.startToStart = -1;
                } else {
                    throw new IllegalArgumentException("right to " + sideToString(i13) + " undefined");
                }
                this.f11146a.setMarginStart(i14);
                break;
            case 7:
                if (i13 == 7) {
                    ConstraintLayout.LayoutParams layoutParams14 = this.f11146a;
                    layoutParams14.endToEnd = i12;
                    layoutParams14.endToStart = -1;
                } else if (i13 == 6) {
                    ConstraintLayout.LayoutParams layoutParams15 = this.f11146a;
                    layoutParams15.endToStart = i12;
                    layoutParams15.endToEnd = -1;
                } else {
                    throw new IllegalArgumentException("right to " + sideToString(i13) + " undefined");
                }
                this.f11146a.setMarginEnd(i14);
                break;
            default:
                throw new IllegalArgumentException(sideToString(i11) + " to " + sideToString(i13) + " unknown");
        }
        return this;
    }

    public ConstraintProperties constrainDefaultHeight(int i11) {
        this.f11146a.matchConstraintDefaultHeight = i11;
        return this;
    }

    public ConstraintProperties constrainDefaultWidth(int i11) {
        this.f11146a.matchConstraintDefaultWidth = i11;
        return this;
    }

    public ConstraintProperties constrainHeight(int i11) {
        this.f11146a.height = i11;
        return this;
    }

    public ConstraintProperties constrainMaxHeight(int i11) {
        this.f11146a.matchConstraintMaxHeight = i11;
        return this;
    }

    public ConstraintProperties constrainMaxWidth(int i11) {
        this.f11146a.matchConstraintMaxWidth = i11;
        return this;
    }

    public ConstraintProperties constrainMinHeight(int i11) {
        this.f11146a.matchConstraintMinHeight = i11;
        return this;
    }

    public ConstraintProperties constrainMinWidth(int i11) {
        this.f11146a.matchConstraintMinWidth = i11;
        return this;
    }

    public ConstraintProperties constrainWidth(int i11) {
        this.f11146a.width = i11;
        return this;
    }

    public ConstraintProperties dimensionRatio(String str) {
        this.f11146a.dimensionRatio = str;
        return this;
    }

    public ConstraintProperties elevation(float f11) {
        this.f11147b.setElevation(f11);
        return this;
    }

    public ConstraintProperties goneMargin(int i11, int i12) {
        switch (i11) {
            case 1:
                this.f11146a.goneLeftMargin = i12;
                break;
            case 2:
                this.f11146a.goneRightMargin = i12;
                break;
            case 3:
                this.f11146a.goneTopMargin = i12;
                break;
            case 4:
                this.f11146a.goneBottomMargin = i12;
                break;
            case 5:
                throw new IllegalArgumentException("baseline does not support margins");
            case 6:
                this.f11146a.goneStartMargin = i12;
                break;
            case 7:
                this.f11146a.goneEndMargin = i12;
                break;
            default:
                throw new IllegalArgumentException("unknown constraint");
        }
        return this;
    }

    public ConstraintProperties horizontalBias(float f11) {
        this.f11146a.horizontalBias = f11;
        return this;
    }

    public ConstraintProperties horizontalChainStyle(int i11) {
        this.f11146a.horizontalChainStyle = i11;
        return this;
    }

    public ConstraintProperties horizontalWeight(float f11) {
        this.f11146a.horizontalWeight = f11;
        return this;
    }

    public ConstraintProperties margin(int i11, int i12) {
        switch (i11) {
            case 1:
                this.f11146a.leftMargin = i12;
                break;
            case 2:
                this.f11146a.rightMargin = i12;
                break;
            case 3:
                this.f11146a.topMargin = i12;
                break;
            case 4:
                this.f11146a.bottomMargin = i12;
                break;
            case 5:
                throw new IllegalArgumentException("baseline does not support margins");
            case 6:
                this.f11146a.setMarginStart(i12);
                break;
            case 7:
                this.f11146a.setMarginEnd(i12);
                break;
            default:
                throw new IllegalArgumentException("unknown constraint");
        }
        return this;
    }

    public ConstraintProperties removeConstraints(int i11) {
        switch (i11) {
            case 1:
                ConstraintLayout.LayoutParams layoutParams = this.f11146a;
                layoutParams.leftToRight = -1;
                layoutParams.leftToLeft = -1;
                layoutParams.leftMargin = -1;
                layoutParams.goneLeftMargin = Integer.MIN_VALUE;
                break;
            case 2:
                ConstraintLayout.LayoutParams layoutParams2 = this.f11146a;
                layoutParams2.rightToRight = -1;
                layoutParams2.rightToLeft = -1;
                layoutParams2.rightMargin = -1;
                layoutParams2.goneRightMargin = Integer.MIN_VALUE;
                break;
            case 3:
                ConstraintLayout.LayoutParams layoutParams3 = this.f11146a;
                layoutParams3.topToBottom = -1;
                layoutParams3.topToTop = -1;
                layoutParams3.topMargin = -1;
                layoutParams3.goneTopMargin = Integer.MIN_VALUE;
                break;
            case 4:
                ConstraintLayout.LayoutParams layoutParams4 = this.f11146a;
                layoutParams4.bottomToTop = -1;
                layoutParams4.bottomToBottom = -1;
                layoutParams4.bottomMargin = -1;
                layoutParams4.goneBottomMargin = Integer.MIN_VALUE;
                break;
            case 5:
                this.f11146a.baselineToBaseline = -1;
                break;
            case 6:
                ConstraintLayout.LayoutParams layoutParams5 = this.f11146a;
                layoutParams5.startToEnd = -1;
                layoutParams5.startToStart = -1;
                layoutParams5.setMarginStart(-1);
                this.f11146a.goneStartMargin = Integer.MIN_VALUE;
                break;
            case 7:
                ConstraintLayout.LayoutParams layoutParams6 = this.f11146a;
                layoutParams6.endToStart = -1;
                layoutParams6.endToEnd = -1;
                layoutParams6.setMarginEnd(-1);
                this.f11146a.goneEndMargin = Integer.MIN_VALUE;
                break;
            default:
                throw new IllegalArgumentException("unknown constraint");
        }
        return this;
    }

    public ConstraintProperties removeFromHorizontalChain() {
        ConstraintLayout.LayoutParams layoutParams = this.f11146a;
        int i11 = layoutParams.leftToRight;
        int i12 = layoutParams.rightToLeft;
        if (i11 == -1 && i12 == -1) {
            int i13 = layoutParams.startToEnd;
            int i14 = layoutParams.endToStart;
            if (!(i13 == -1 && i14 == -1)) {
                ConstraintProperties constraintProperties = new ConstraintProperties(((ViewGroup) this.f11147b.getParent()).findViewById(i13));
                ConstraintProperties constraintProperties2 = new ConstraintProperties(((ViewGroup) this.f11147b.getParent()).findViewById(i14));
                ConstraintLayout.LayoutParams layoutParams2 = this.f11146a;
                if (i13 != -1 && i14 != -1) {
                    constraintProperties.connect(7, i14, 6, 0);
                    constraintProperties2.connect(6, i11, 7, 0);
                } else if (!(i11 == -1 && i14 == -1)) {
                    int i15 = layoutParams2.rightToRight;
                    if (i15 != -1) {
                        constraintProperties.connect(7, i15, 7, 0);
                    } else {
                        int i16 = layoutParams2.leftToLeft;
                        if (i16 != -1) {
                            constraintProperties2.connect(6, i16, 6, 0);
                        }
                    }
                }
            }
            removeConstraints(6);
            removeConstraints(7);
        } else {
            ConstraintProperties constraintProperties3 = new ConstraintProperties(((ViewGroup) this.f11147b.getParent()).findViewById(i11));
            ConstraintProperties constraintProperties4 = new ConstraintProperties(((ViewGroup) this.f11147b.getParent()).findViewById(i12));
            ConstraintLayout.LayoutParams layoutParams3 = this.f11146a;
            if (i11 != -1 && i12 != -1) {
                constraintProperties3.connect(2, i12, 1, 0);
                constraintProperties4.connect(1, i11, 2, 0);
            } else if (!(i11 == -1 && i12 == -1)) {
                int i17 = layoutParams3.rightToRight;
                if (i17 != -1) {
                    constraintProperties3.connect(2, i17, 2, 0);
                } else {
                    int i18 = layoutParams3.leftToLeft;
                    if (i18 != -1) {
                        constraintProperties4.connect(1, i18, 1, 0);
                    }
                }
            }
            removeConstraints(1);
            removeConstraints(2);
        }
        return this;
    }

    public ConstraintProperties removeFromVerticalChain() {
        ConstraintLayout.LayoutParams layoutParams = this.f11146a;
        int i11 = layoutParams.topToBottom;
        int i12 = layoutParams.bottomToTop;
        if (!(i11 == -1 && i12 == -1)) {
            ConstraintProperties constraintProperties = new ConstraintProperties(((ViewGroup) this.f11147b.getParent()).findViewById(i11));
            ConstraintProperties constraintProperties2 = new ConstraintProperties(((ViewGroup) this.f11147b.getParent()).findViewById(i12));
            ConstraintLayout.LayoutParams layoutParams2 = this.f11146a;
            if (i11 != -1 && i12 != -1) {
                constraintProperties.connect(4, i12, 3, 0);
                constraintProperties2.connect(3, i11, 4, 0);
            } else if (!(i11 == -1 && i12 == -1)) {
                int i13 = layoutParams2.bottomToBottom;
                if (i13 != -1) {
                    constraintProperties.connect(4, i13, 4, 0);
                } else {
                    int i14 = layoutParams2.topToTop;
                    if (i14 != -1) {
                        constraintProperties2.connect(3, i14, 3, 0);
                    }
                }
            }
        }
        removeConstraints(3);
        removeConstraints(4);
        return this;
    }

    public ConstraintProperties rotation(float f11) {
        this.f11147b.setRotation(f11);
        return this;
    }

    public ConstraintProperties rotationX(float f11) {
        this.f11147b.setRotationX(f11);
        return this;
    }

    public ConstraintProperties rotationY(float f11) {
        this.f11147b.setRotationY(f11);
        return this;
    }

    public ConstraintProperties scaleX(float f11) {
        this.f11147b.setScaleY(f11);
        return this;
    }

    public ConstraintProperties scaleY(float f11) {
        return this;
    }

    public ConstraintProperties transformPivot(float f11, float f12) {
        this.f11147b.setPivotX(f11);
        this.f11147b.setPivotY(f12);
        return this;
    }

    public ConstraintProperties transformPivotX(float f11) {
        this.f11147b.setPivotX(f11);
        return this;
    }

    public ConstraintProperties transformPivotY(float f11) {
        this.f11147b.setPivotY(f11);
        return this;
    }

    public ConstraintProperties translation(float f11, float f12) {
        this.f11147b.setTranslationX(f11);
        this.f11147b.setTranslationY(f12);
        return this;
    }

    public ConstraintProperties translationX(float f11) {
        this.f11147b.setTranslationX(f11);
        return this;
    }

    public ConstraintProperties translationY(float f11) {
        this.f11147b.setTranslationY(f11);
        return this;
    }

    public ConstraintProperties translationZ(float f11) {
        this.f11147b.setTranslationZ(f11);
        return this;
    }

    public ConstraintProperties verticalBias(float f11) {
        this.f11146a.verticalBias = f11;
        return this;
    }

    public ConstraintProperties verticalChainStyle(int i11) {
        this.f11146a.verticalChainStyle = i11;
        return this;
    }

    public ConstraintProperties verticalWeight(float f11) {
        this.f11146a.verticalWeight = f11;
        return this;
    }

    public ConstraintProperties visibility(int i11) {
        this.f11147b.setVisibility(i11);
        return this;
    }

    public ConstraintProperties centerHorizontally(int i11) {
        if (i11 == 0) {
            center(0, 1, 0, 0, 2, 0, 0.5f);
        } else {
            center(i11, 2, 0, i11, 1, 0, 0.5f);
        }
        return this;
    }

    public ConstraintProperties centerHorizontallyRtl(int i11) {
        if (i11 == 0) {
            center(0, 6, 0, 0, 7, 0, 0.5f);
        } else {
            center(i11, 7, 0, i11, 6, 0, 0.5f);
        }
        return this;
    }

    public ConstraintProperties centerVertically(int i11) {
        if (i11 == 0) {
            center(0, 3, 0, 0, 4, 0, 0.5f);
        } else {
            center(i11, 4, 0, i11, 3, 0, 0.5f);
        }
        return this;
    }
}
