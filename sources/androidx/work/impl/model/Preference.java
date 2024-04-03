package androidx.work.impl.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@Entity
public class Preference {
    @ColumnInfo(name = "key")
    @NonNull
    @PrimaryKey
    public String mKey;
    @ColumnInfo(name = "long_value")
    @Nullable
    public Long mValue;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public Preference(@NonNull String str, boolean z11) {
        this(str, z11 ? 1 : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Preference)) {
            return false;
        }
        Preference preference = (Preference) obj;
        if (!this.mKey.equals(preference.mKey)) {
            return false;
        }
        Long l11 = this.mValue;
        Long l12 = preference.mValue;
        if (l11 != null) {
            return l11.equals(l12);
        }
        if (l12 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i11;
        int hashCode = this.mKey.hashCode() * 31;
        Long l11 = this.mValue;
        if (l11 != null) {
            i11 = l11.hashCode();
        } else {
            i11 = 0;
        }
        return hashCode + i11;
    }

    public Preference(@NonNull String str, long j11) {
        this.mKey = str;
        this.mValue = Long.valueOf(j11);
    }
}
