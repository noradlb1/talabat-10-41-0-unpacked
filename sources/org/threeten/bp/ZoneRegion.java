package org.threeten.bp;

import com.talabat.sidemenu.SideMenuRewardViewHolder;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.util.regex.Pattern;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.zone.ZoneRules;
import org.threeten.bp.zone.ZoneRulesException;
import org.threeten.bp.zone.ZoneRulesProvider;

final class ZoneRegion extends ZoneId {
    private static final Pattern PATTERN = Pattern.compile("[A-Za-z][A-Za-z0-9~/._+-]+");
    private static final long serialVersionUID = 8386373296231747096L;

    /* renamed from: id  reason: collision with root package name */
    private final String f63329id;
    private final transient ZoneRules rules;

    public ZoneRegion(String str, ZoneRules zoneRules) {
        this.f63329id = str;
        this.rules = zoneRules;
    }

    public static ZoneRegion b(String str, boolean z11) {
        ZoneRules zoneRules;
        Jdk8Methods.requireNonNull(str, "zoneId");
        if (str.length() < 2 || !PATTERN.matcher(str).matches()) {
            throw new DateTimeException("Invalid ID for region-based ZoneId, invalid format: " + str);
        }
        try {
            zoneRules = ZoneRulesProvider.getRules(str, true);
        } catch (ZoneRulesException e11) {
            if (str.equals("GMT0")) {
                zoneRules = ZoneOffset.UTC.getRules();
            } else if (!z11) {
                zoneRules = null;
            } else {
                throw e11;
            }
        }
        return new ZoneRegion(str, zoneRules);
    }

    public static ZoneId c(DataInput dataInput) throws IOException {
        return ofLenient(dataInput.readUTF());
    }

    private static ZoneRegion ofLenient(String str) {
        if (str.equals("Z") || str.startsWith("+") || str.startsWith(SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE)) {
            throw new DateTimeException("Invalid ID for region-based ZoneId, invalid format: " + str);
        } else if (str.equals("UTC") || str.equals("GMT") || str.equals("UT")) {
            return new ZoneRegion(str, ZoneOffset.UTC.getRules());
        } else {
            if (str.startsWith("UTC+") || str.startsWith("GMT+") || str.startsWith("UTC-") || str.startsWith("GMT-")) {
                ZoneOffset of2 = ZoneOffset.of(str.substring(3));
                if (of2.getTotalSeconds() == 0) {
                    return new ZoneRegion(str.substring(0, 3), of2.getRules());
                }
                return new ZoneRegion(str.substring(0, 3) + of2.getId(), of2.getRules());
            } else if (!str.startsWith("UT+") && !str.startsWith("UT-")) {
                return b(str, false);
            } else {
                ZoneOffset of3 = ZoneOffset.of(str.substring(2));
                if (of3.getTotalSeconds() == 0) {
                    return new ZoneRegion("UT", of3.getRules());
                }
                return new ZoneRegion("UT" + of3.getId(), of3.getRules());
            }
        }
    }

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new Ser((byte) 7, this);
    }

    public void a(DataOutput dataOutput) throws IOException {
        dataOutput.writeByte(7);
        d(dataOutput);
    }

    public void d(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(this.f63329id);
    }

    public String getId() {
        return this.f63329id;
    }

    public ZoneRules getRules() {
        ZoneRules zoneRules = this.rules;
        return zoneRules != null ? zoneRules : ZoneRulesProvider.getRules(this.f63329id, false);
    }
}
