package com.google.crypto.tink.monitoring;

import com.google.crypto.tink.KeyStatus;
import com.google.crypto.tink.Parameters;
import com.google.crypto.tink.annotations.Alpha;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nullable;

@Immutable
@Alpha
public final class MonitoringKeysetInfo {
    private final MonitoringAnnotations annotations;
    private final List<Entry> entries;
    @Nullable
    private final Integer primaryKeyId;

    public static final class Builder {
        private MonitoringAnnotations builderAnnotations = MonitoringAnnotations.EMPTY;
        @Nullable
        private ArrayList<Entry> builderEntries = new ArrayList<>();
        @Nullable
        private Integer builderPrimaryKeyId = null;

        private boolean isKeyIdInEntries(int i11) {
            Iterator<Entry> it = this.builderEntries.iterator();
            while (it.hasNext()) {
                if (it.next().getKeyId() == i11) {
                    return true;
                }
            }
            return false;
        }

        public Builder addEntry(KeyStatus keyStatus, int i11, Parameters parameters) {
            ArrayList<Entry> arrayList = this.builderEntries;
            if (arrayList != null) {
                arrayList.add(new Entry(keyStatus, i11, parameters));
                return this;
            }
            throw new IllegalStateException("addEntry cannot be called after build()");
        }

        public MonitoringKeysetInfo build() throws GeneralSecurityException {
            if (this.builderEntries != null) {
                Integer num = this.builderPrimaryKeyId;
                if (num == null || isKeyIdInEntries(num.intValue())) {
                    MonitoringKeysetInfo monitoringKeysetInfo = new MonitoringKeysetInfo(this.builderAnnotations, Collections.unmodifiableList(this.builderEntries), this.builderPrimaryKeyId);
                    this.builderEntries = null;
                    return monitoringKeysetInfo;
                }
                throw new GeneralSecurityException("primary key ID is not present in entries");
            }
            throw new IllegalStateException("cannot call build() twice");
        }

        public Builder setAnnotations(MonitoringAnnotations monitoringAnnotations) {
            if (this.builderEntries != null) {
                this.builderAnnotations = monitoringAnnotations;
                return this;
            }
            throw new IllegalStateException("setAnnotations cannot be called after build()");
        }

        public Builder setPrimaryKeyId(int i11) {
            if (this.builderEntries != null) {
                this.builderPrimaryKeyId = Integer.valueOf(i11);
                return this;
            }
            throw new IllegalStateException("setPrimaryKeyId cannot be called after build()");
        }
    }

    @Immutable
    public static final class Entry {
        private final int keyId;
        private final Parameters parameters;
        private final KeyStatus status;

        public boolean equals(Object obj) {
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            if (this.status == entry.status && this.keyId == entry.keyId && this.parameters.equals(entry.parameters)) {
                return true;
            }
            return false;
        }

        public int getKeyId() {
            return this.keyId;
        }

        public Parameters getParameters() {
            return this.parameters;
        }

        public KeyStatus getStatus() {
            return this.status;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{this.status, Integer.valueOf(this.keyId), Integer.valueOf(this.parameters.hashCode())});
        }

        public String toString() {
            return String.format("(status=%s, keyId=%s, parameters='%s')", new Object[]{this.status, Integer.valueOf(this.keyId), this.parameters});
        }

        private Entry(KeyStatus keyStatus, int i11, Parameters parameters2) {
            this.status = keyStatus;
            this.keyId = i11;
            this.parameters = parameters2;
        }
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof MonitoringKeysetInfo)) {
            return false;
        }
        MonitoringKeysetInfo monitoringKeysetInfo = (MonitoringKeysetInfo) obj;
        if (!this.annotations.equals(monitoringKeysetInfo.annotations) || !this.entries.equals(monitoringKeysetInfo.entries) || !Objects.equals(this.primaryKeyId, monitoringKeysetInfo.primaryKeyId)) {
            return false;
        }
        return true;
    }

    public MonitoringAnnotations getAnnotations() {
        return this.annotations;
    }

    public List<Entry> getEntries() {
        return this.entries;
    }

    @Nullable
    public Integer getPrimaryKeyId() {
        return this.primaryKeyId;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.annotations, this.entries});
    }

    public String toString() {
        return String.format("(annotations=%s, entries=%s, primaryKeyId=%s)", new Object[]{this.annotations, this.entries, this.primaryKeyId});
    }

    private MonitoringKeysetInfo(MonitoringAnnotations monitoringAnnotations, List<Entry> list, Integer num) {
        this.annotations = monitoringAnnotations;
        this.entries = list;
        this.primaryKeyId = num;
    }
}
