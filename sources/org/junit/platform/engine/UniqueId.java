package org.junit.platform.engine;

import j$.util.Optional;
import java.io.Serializable;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import m30.u;
import m30.v;
import org.apiguardian.api.API;
import org.junit.platform.commons.JUnitException;
import org.junit.platform.commons.util.Preconditions;
import org.junit.platform.commons.util.ToStringBuilder;

@API(since = "1.0", status = API.Status.STABLE)
public class UniqueId implements Cloneable, Serializable {
    private static final String ENGINE_SEGMENT_TYPE = "engine";
    private static final long serialVersionUID = 1;
    private transient int hashCode;
    private final List<Segment> segments;
    private transient SoftReference<String> toString;
    private final UniqueIdFormat uniqueIdFormat;

    @API(since = "1.0", status = API.Status.STABLE)
    public static class Segment implements Serializable {
        private static final long serialVersionUID = 1;
        private final String type;
        private final String value;

        public Segment(String str, String str2) {
            Preconditions.notBlank(str, "type must not be null or blank");
            Preconditions.notBlank(str2, "value must not be null or blank");
            this.type = str;
            this.value = str2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Segment segment = (Segment) obj;
            if (!Objects.equals(this.type, segment.type) || !Objects.equals(this.value, segment.value)) {
                return false;
            }
            return true;
        }

        public String getType() {
            return this.type;
        }

        public String getValue() {
            return this.value;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{this.type, this.value});
        }

        public String toString() {
            return new ToStringBuilder((Object) this).append("type", this.type).append("value", this.value).toString();
        }
    }

    private UniqueId(UniqueIdFormat uniqueIdFormat2, Segment segment) {
        this(uniqueIdFormat2, (List<Segment>) Collections.singletonList(segment));
    }

    public static UniqueId forEngine(String str) {
        Preconditions.notBlank(str, "engineId must not be null or blank");
        return root(ENGINE_SEGMENT_TYPE, str);
    }

    public static UniqueId parse(String str) throws JUnitException {
        Preconditions.notBlank(str, "Unique ID string must not be null or blank");
        return UniqueIdFormat.f().g(str);
    }

    public static UniqueId root(String str, String str2) {
        return new UniqueId(UniqueIdFormat.f(), new Segment(str, str2));
    }

    public final UniqueId append(String str, String str2) {
        return append(new Segment(str, str2));
    }

    @API(since = "1.8", status = API.Status.EXPERIMENTAL)
    public UniqueId appendEngine(String str) {
        return append(new Segment(ENGINE_SEGMENT_TYPE, str));
    }

    public final Optional<Segment> b() {
        return this.segments.isEmpty() ? Optional.empty() : Optional.of(this.segments.get(0));
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.segments.equals(((UniqueId) obj).segments);
    }

    public final Optional<String> getEngineId() {
        return b().filter(new u()).map(new v());
    }

    @API(since = "1.5", status = API.Status.STABLE)
    public Segment getLastSegment() {
        List<Segment> list = this.segments;
        return list.get(list.size() - 1);
    }

    public final List<Segment> getSegments() {
        return Collections.unmodifiableList(this.segments);
    }

    @API(since = "1.1", status = API.Status.STABLE)
    public boolean hasPrefix(UniqueId uniqueId) {
        Preconditions.notNull(uniqueId, "potentialPrefix must not be null");
        int size = this.segments.size();
        int size2 = uniqueId.segments.size();
        if (size < size2 || !this.segments.subList(0, size2).equals(uniqueId.segments)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i11 = this.hashCode;
        if (i11 == 0) {
            i11 = this.segments.hashCode();
            if (i11 == 0) {
                i11 = 1;
            }
            this.hashCode = i11;
        }
        return i11;
    }

    @API(since = "1.5", status = API.Status.STABLE)
    public UniqueId removeLastSegment() {
        boolean z11;
        if (this.segments.size() > 1) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.condition(z11, "Cannot remove last remaining segment");
        UniqueIdFormat uniqueIdFormat2 = this.uniqueIdFormat;
        List<Segment> list = this.segments;
        return new UniqueId(uniqueIdFormat2, (List<Segment>) new ArrayList(list.subList(0, list.size() - 1)));
    }

    public String toString() {
        String str;
        SoftReference<String> softReference = this.toString;
        if (softReference == null) {
            str = null;
        } else {
            str = softReference.get();
        }
        if (str != null) {
            return str;
        }
        String e11 = this.uniqueIdFormat.e(this);
        this.toString = new SoftReference<>(e11);
        return e11;
    }

    public UniqueId(UniqueIdFormat uniqueIdFormat2, List<Segment> list) {
        this.uniqueIdFormat = uniqueIdFormat2;
        this.segments = list;
    }

    @API(since = "1.1", status = API.Status.STABLE)
    public final UniqueId append(Segment segment) {
        Preconditions.notNull(segment, "segment must not be null");
        ArrayList arrayList = new ArrayList(this.segments.size() + 1);
        arrayList.addAll(this.segments);
        arrayList.add(segment);
        return new UniqueId(this.uniqueIdFormat, (List<Segment>) arrayList);
    }
}
