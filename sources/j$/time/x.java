package j$.time;

import com.google.common.net.HttpHeaders;
import com.talabat.sidemenu.SideMenuRewardViewHolder;
import j$.time.zone.f;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public abstract class x implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public static final Map f28502a;
    private static final long serialVersionUID = 8352817235686L;

    static {
        int i11 = 0;
        Map.Entry[] entryArr = {new AbstractMap.SimpleImmutableEntry("ACT", "Australia/Darwin"), new AbstractMap.SimpleImmutableEntry("AET", "Australia/Sydney"), new AbstractMap.SimpleImmutableEntry("AGT", "America/Argentina/Buenos_Aires"), new AbstractMap.SimpleImmutableEntry("ART", "Africa/Cairo"), new AbstractMap.SimpleImmutableEntry("AST", "America/Anchorage"), new AbstractMap.SimpleImmutableEntry("BET", "America/Sao_Paulo"), new AbstractMap.SimpleImmutableEntry("BST", "Asia/Dhaka"), new AbstractMap.SimpleImmutableEntry("CAT", "Africa/Harare"), new AbstractMap.SimpleImmutableEntry("CNT", "America/St_Johns"), new AbstractMap.SimpleImmutableEntry("CST", "America/Chicago"), new AbstractMap.SimpleImmutableEntry("CTT", "Asia/Shanghai"), new AbstractMap.SimpleImmutableEntry("EAT", "Africa/Addis_Ababa"), new AbstractMap.SimpleImmutableEntry(HttpHeaders.ECT, "Europe/Paris"), new AbstractMap.SimpleImmutableEntry("IET", "America/Indiana/Indianapolis"), new AbstractMap.SimpleImmutableEntry("IST", "Asia/Kolkata"), new AbstractMap.SimpleImmutableEntry("JST", "Asia/Tokyo"), new AbstractMap.SimpleImmutableEntry("MIT", "Pacific/Apia"), new AbstractMap.SimpleImmutableEntry("NET", "Asia/Yerevan"), new AbstractMap.SimpleImmutableEntry("NST", "Pacific/Auckland"), new AbstractMap.SimpleImmutableEntry("PLT", "Asia/Karachi"), new AbstractMap.SimpleImmutableEntry("PNT", "America/Phoenix"), new AbstractMap.SimpleImmutableEntry("PRT", "America/Puerto_Rico"), new AbstractMap.SimpleImmutableEntry("PST", "America/Los_Angeles"), new AbstractMap.SimpleImmutableEntry("SST", "Pacific/Guadalcanal"), new AbstractMap.SimpleImmutableEntry("VST", "Asia/Ho_Chi_Minh"), new AbstractMap.SimpleImmutableEntry("EST", "-05:00"), new AbstractMap.SimpleImmutableEntry("MST", "-07:00"), new AbstractMap.SimpleImmutableEntry("HST", "-10:00")};
        HashMap hashMap = new HashMap(28);
        while (i11 < 28) {
            Map.Entry entry = entryArr[i11];
            Object key = entry.getKey();
            Objects.requireNonNull(key);
            Object value = entry.getValue();
            Objects.requireNonNull(value);
            if (hashMap.put(key, value) == null) {
                i11++;
            } else {
                throw new IllegalArgumentException("duplicate key: " + key);
            }
        }
        f28502a = Collections.unmodifiableMap(hashMap);
    }

    x() {
        if (getClass() != ZoneOffset.class && getClass() != y.class) {
            throw new AssertionError("Invalid subclass");
        }
    }

    public static x C(String str, Map map) {
        Objects.requireNonNull(str, "zoneId");
        Objects.requireNonNull(map, "aliasMap");
        String str2 = (String) map.get(str);
        if (str2 != null) {
            str = str2;
        }
        return D(str, true);
    }

    static x D(String str, boolean z11) {
        int i11;
        Objects.requireNonNull(str, "zoneId");
        if (str.length() <= 1 || str.startsWith("+") || str.startsWith(SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE)) {
            return ZoneOffset.J(str);
        }
        if (str.startsWith("UTC") || str.startsWith("GMT")) {
            i11 = 3;
        } else if (!str.startsWith("UT")) {
            return y.H(str, z11);
        } else {
            i11 = 2;
        }
        return F(str, i11, z11);
    }

    public static x E(String str, ZoneOffset zoneOffset) {
        Objects.requireNonNull(str, "prefix");
        Objects.requireNonNull(zoneOffset, "offset");
        if (str.isEmpty()) {
            return zoneOffset;
        }
        if (str.equals("GMT") || str.equals("UTC") || str.equals("UT")) {
            if (zoneOffset.I() != 0) {
                str = str.concat(zoneOffset.e());
            }
            return new y(str, f.j(zoneOffset));
        }
        throw new IllegalArgumentException("prefix should be GMT, UTC or UT, is: ".concat(str));
    }

    private static x F(String str, int i11, boolean z11) {
        String substring = str.substring(0, i11);
        if (str.length() == i11) {
            return E(substring, ZoneOffset.UTC);
        }
        if (str.charAt(i11) != '+' && str.charAt(i11) != '-') {
            return y.H(str, z11);
        }
        try {
            ZoneOffset J = ZoneOffset.J(str.substring(i11));
            return J == ZoneOffset.UTC ? E(substring, J) : E(substring, J);
        } catch (b e11) {
            throw new b("Invalid ID for offset-based ZoneId: ".concat(str), e11);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new s((byte) 7, this);
    }

    public abstract f B();

    /* access modifiers changed from: package-private */
    public abstract void G(DataOutput dataOutput);

    public abstract String e();

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof x) {
            return e().equals(((x) obj).e());
        }
        return false;
    }

    public int hashCode() {
        return e().hashCode();
    }

    public String toString() {
        return e();
    }
}
