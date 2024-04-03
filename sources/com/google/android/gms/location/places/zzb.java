package com.google.android.gms.location.places;

import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@ShowFirstParty
public abstract class zzb extends AbstractSafeParcelable {
    public static <E> List<E> zzb(@Nullable Collection<E> collection) {
        if (collection == null || collection.isEmpty()) {
            return Collections.emptyList();
        }
        return new ArrayList(collection);
    }

    public abstract Set<String> getPlaceIds();

    public boolean isRestrictedToPlacesOpenNow() {
        return false;
    }

    public static <E> Set<E> zzb(List<E> list) {
        if (list == null || list.isEmpty()) {
            return Collections.emptySet();
        }
        return Collections.unmodifiableSet(new HashSet(list));
    }
}
