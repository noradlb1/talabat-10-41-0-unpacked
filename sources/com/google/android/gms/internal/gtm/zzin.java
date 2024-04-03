package com.google.android.gms.internal.gtm;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.common.internal.Preconditions;
import com.talabat.card_tokenization.CardTokenizationPlugin;

public final class zzin extends zzhb {
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        boolean z11;
        String str;
        Preconditions.checkArgument(true);
        if (zzoaArr.length == 1) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkArgument(z11);
        Preconditions.checkArgument(!(zzoaArr[0] instanceof zzol));
        Preconditions.checkArgument(true ^ zzoo.zzm(zzoaArr[0]));
        zzog zzog = zzoaArr[0];
        if (zzog == zzog.zzaum) {
            str = AdError.UNDEFINED_DOMAIN;
        } else if (zzog instanceof zzod) {
            str = TypedValues.Custom.S_BOOLEAN;
        } else if (zzog instanceof zzoe) {
            str = CardTokenizationPlugin.ARG_NUMBER_KEY;
        } else if (zzog instanceof zzom) {
            str = TypedValues.Custom.S_STRING;
        } else if (zzog instanceof zzof) {
            str = "function";
        } else {
            str = "object";
        }
        return new zzom(str);
    }
}
