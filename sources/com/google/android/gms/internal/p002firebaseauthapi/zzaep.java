package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;
import com.google.android.gms.common.util.Strings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaep  reason: invalid package */
public final class zzaep {
    private List zza;

    public zzaep() {
        this((List) null);
    }

    public final List zza() {
        return this.zza;
    }

    public zzaep(int i11, List list) {
        if (!list.isEmpty()) {
            for (int i12 = 0; i12 < list.size(); i12++) {
                list.set(i12, Strings.emptyToNull((String) list.get(i12)));
            }
            this.zza = Collections.unmodifiableList(list);
            return;
        }
        this.zza = Collections.emptyList();
    }

    public zzaep(@Nullable List list) {
        this.zza = new ArrayList();
    }
}
