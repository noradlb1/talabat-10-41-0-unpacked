package androidx.preference;

import androidx.annotation.Nullable;
import java.util.Set;

public abstract class PreferenceDataStore {
    public boolean getBoolean(String str, boolean z11) {
        return z11;
    }

    public float getFloat(String str, float f11) {
        return f11;
    }

    public int getInt(String str, int i11) {
        return i11;
    }

    public long getLong(String str, long j11) {
        return j11;
    }

    @Nullable
    public String getString(String str, @Nullable String str2) {
        return str2;
    }

    @Nullable
    public Set<String> getStringSet(String str, @Nullable Set<String> set) {
        return set;
    }

    public void putBoolean(String str, boolean z11) {
        throw new UnsupportedOperationException("Not implemented on this data store");
    }

    public void putFloat(String str, float f11) {
        throw new UnsupportedOperationException("Not implemented on this data store");
    }

    public void putInt(String str, int i11) {
        throw new UnsupportedOperationException("Not implemented on this data store");
    }

    public void putLong(String str, long j11) {
        throw new UnsupportedOperationException("Not implemented on this data store");
    }

    public void putString(String str, @Nullable String str2) {
        throw new UnsupportedOperationException("Not implemented on this data store");
    }

    public void putStringSet(String str, @Nullable Set<String> set) {
        throw new UnsupportedOperationException("Not implemented on this data store");
    }
}
