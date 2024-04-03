package com.talabat.feature.tpro.presentation.util;

import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a(\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\b¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"getParcelableObj", "T", "Landroid/os/Parcelable;", "Landroid/os/Bundle;", "key", "", "(Landroid/os/Bundle;Ljava/lang/String;)Landroid/os/Parcelable;", "com_talabat_feature_tpro_presentation_presentation"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class BundleExtraKt {
    public static final /* synthetic */ <T extends Parcelable> T getParcelableObj(Bundle bundle, String str) {
        Intrinsics.checkNotNullParameter(bundle, "<this>");
        Intrinsics.checkNotNullParameter(str, "key");
        if (Build.VERSION.SDK_INT < 33) {
            return bundle.getParcelable(str);
        }
        Intrinsics.reifiedOperationMarker(4, "T");
        return (Parcelable) bundle.getParcelable(str, Parcelable.class);
    }
}
