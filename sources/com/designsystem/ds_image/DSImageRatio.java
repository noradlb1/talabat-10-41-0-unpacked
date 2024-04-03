package com.designsystem.ds_image;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/designsystem/ds_image/DSImageRatio;", "", "value", "", "(Ljava/lang/String;IF)V", "getValue", "()F", "OneToOne", "TwoToThree", "FourToThree", "TwoPointFiveToOne", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public enum DSImageRatio {
    OneToOne(1.0f),
    TwoToThree(0.6666667f),
    FourToThree(1.3333334f),
    TwoPointFiveToOne(2.5f);
    
    private final float value;

    private DSImageRatio(float f11) {
        this.value = f11;
    }

    public final float getValue() {
        return this.value;
    }
}
