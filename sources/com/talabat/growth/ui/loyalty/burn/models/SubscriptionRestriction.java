package com.talabat.growth.ui.loyalty.burn.models;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/talabat/growth/ui/loyalty/burn/models/SubscriptionRestriction;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "UNRESTRICTED", "NON_T_PRO", "T_PRO", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public enum SubscriptionRestriction {
    UNRESTRICTED("1"),
    NON_T_PRO(ExifInterface.GPS_MEASUREMENT_2D),
    T_PRO(ExifInterface.GPS_MEASUREMENT_3D);
    
    @NotNull
    private final String value;

    private SubscriptionRestriction(String str) {
        this.value = str;
    }

    @NotNull
    public final String getValue() {
        return this.value;
    }
}
