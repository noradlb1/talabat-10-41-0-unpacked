package com.talabat.talabatlife.features.tLifeWidget.model;

import com.talabat.talabatcommon.extentions.IntKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.IntCompanionObject;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/talabat/talabatlife/features/tLifeWidget/model/TLifeSubscriptionStatusRequestModel;", "", "countryCode", "", "(I)V", "getCountryCode", "()I", "setCountryCode", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TLifeSubscriptionStatusRequestModel {
    private int countryCode;

    public TLifeSubscriptionStatusRequestModel() {
        this(0, 1, (DefaultConstructorMarker) null);
    }

    public TLifeSubscriptionStatusRequestModel(int i11) {
        this.countryCode = i11;
    }

    public final int getCountryCode() {
        return this.countryCode;
    }

    public final void setCountryCode(int i11) {
        this.countryCode = i11;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TLifeSubscriptionStatusRequestModel(int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? IntKt.orZero(IntCompanionObject.INSTANCE) : i11);
    }
}
