package com.google.firebase.appindexing.builders;

import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.appindexing.Action;

public final class AssistActionBuilder extends Action.Builder {
    private String zza;

    public AssistActionBuilder() {
        super("AssistAction");
    }

    @NonNull
    public Action build() {
        String str;
        Preconditions.checkNotNull(this.zza, "setActionToken is required before calling build().");
        Preconditions.checkNotNull(zzc(), "setActionStatus is required before calling build().");
        put("actionToken", this.zza);
        if (zza() == null) {
            setName("AssistAction");
        }
        if (zzb() == null) {
            String valueOf = String.valueOf(this.zza);
            if (valueOf.length() != 0) {
                str = "https://developers.google.com/actions?invocation=".concat(valueOf);
            } else {
                str = new String("https://developers.google.com/actions?invocation=");
            }
            setUrl(str);
        }
        return super.build();
    }

    @NonNull
    public AssistActionBuilder setActionToken(@NonNull String str) {
        Preconditions.checkNotNull(str);
        this.zza = str;
        return this;
    }
}
