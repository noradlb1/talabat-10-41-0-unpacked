package bo.app;

import com.braze.enums.BrazeDateFormat;
import com.braze.models.outgoing.BrazeProperties;
import com.braze.support.BrazeLogger;
import com.braze.support.DateTimeUtils;
import com.braze.support.JsonUtils;
import java.util.Date;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public class c4 implements e2 {

    /* renamed from: f  reason: collision with root package name */
    private static final String f38354f = BrazeLogger.getBrazeLogTag((Class<?>) c4.class);

    /* renamed from: b  reason: collision with root package name */
    private final d4 f38355b;

    /* renamed from: c  reason: collision with root package name */
    private final String f38356c;

    /* renamed from: d  reason: collision with root package name */
    private final int f38357d;

    /* renamed from: e  reason: collision with root package name */
    private Object f38358e;

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f38359a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                bo.app.d4[] r0 = bo.app.d4.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f38359a = r0
                bo.app.d4 r1 = bo.app.d4.STRING     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f38359a     // Catch:{ NoSuchFieldError -> 0x001d }
                bo.app.d4 r1 = bo.app.d4.BOOLEAN     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f38359a     // Catch:{ NoSuchFieldError -> 0x0028 }
                bo.app.d4 r1 = bo.app.d4.DATE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f38359a     // Catch:{ NoSuchFieldError -> 0x0033 }
                bo.app.d4 r1 = bo.app.d4.NUMBER     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: bo.app.c4.a.<clinit>():void");
        }
    }

    public c4(d4 d4Var, String str, int i11) {
        this.f38355b = d4Var;
        this.f38356c = str;
        this.f38357d = i11;
    }

    private boolean b(Object obj) {
        if ((obj instanceof Integer) || (obj instanceof Double)) {
            double doubleValue = ((Number) obj).doubleValue();
            double doubleValue2 = ((Number) this.f38358e).doubleValue();
            int i11 = this.f38357d;
            if (i11 != 1) {
                if (i11 != 2) {
                    if (i11 != 3) {
                        if (i11 == 5 && doubleValue < doubleValue2) {
                            return true;
                        }
                        return false;
                    } else if (doubleValue > doubleValue2) {
                        return true;
                    } else {
                        return false;
                    }
                } else if (doubleValue != doubleValue2) {
                    return true;
                } else {
                    return false;
                }
            } else if (doubleValue == doubleValue2) {
                return true;
            } else {
                return false;
            }
        } else if (this.f38357d == 2) {
            return true;
        } else {
            return false;
        }
    }

    private boolean c(Object obj) {
        if (!(obj instanceof String)) {
            int i11 = this.f38357d;
            if (i11 == 2 || i11 == 17) {
                return true;
            }
            return false;
        }
        int i12 = this.f38357d;
        if (i12 == 1) {
            return obj.equals(this.f38358e);
        }
        if (i12 == 2) {
            return !obj.equals(this.f38358e);
        }
        if (i12 == 10) {
            return a((String) this.f38358e, (String) obj);
        }
        if (i12 != 17) {
            return false;
        }
        return !a((String) this.f38358e, (String) obj);
    }

    public boolean a(w2 w2Var) {
        Object obj;
        if (!(w2Var instanceof y2)) {
            return false;
        }
        BrazeProperties c11 = ((y2) w2Var).c();
        if (c11 != null) {
            try {
                obj = c11.forJsonPut().opt(this.f38356c);
            } catch (Exception e11) {
                BrazeLogger.e(f38354f, "Caught exception checking property filter condition.", e11);
                return false;
            }
        } else {
            obj = null;
        }
        if (obj == null) {
            int i11 = this.f38357d;
            if (i11 == 12 || i11 == 17 || i11 == 2) {
                return true;
            }
            return false;
        }
        int i12 = this.f38357d;
        if (i12 == 11) {
            return true;
        }
        if (i12 == 12) {
            return false;
        }
        int i13 = a.f38359a[this.f38355b.ordinal()];
        if (i13 == 1) {
            return c(obj);
        }
        if (i13 == 2) {
            return a(obj);
        }
        if (i13 == 3) {
            return a(obj, w2Var.b());
        }
        if (i13 != 4) {
            return false;
        }
        return b(obj);
    }

    /* renamed from: e */
    public JSONObject forJsonPut() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!this.f38355b.equals(d4.UNKNOWN)) {
                jSONObject.put("property_type", (Object) this.f38355b.toString());
            }
            jSONObject.put("property_key", (Object) this.f38356c);
            jSONObject.put("comparator", this.f38357d);
            jSONObject.put("property_value", this.f38358e);
        } catch (JSONException e11) {
            BrazeLogger.e(f38354f, "Caught exception creating property filter Json.", e11);
        }
        return jSONObject;
    }

    public c4(JSONObject jSONObject) {
        this((d4) JsonUtils.optEnum(jSONObject, "property_type", d4.class, d4.UNKNOWN), jSONObject.getString("property_key"), jSONObject.getInt("comparator"));
        if (!jSONObject.has("property_value")) {
            return;
        }
        if (this.f38355b.equals(d4.STRING)) {
            this.f38358e = jSONObject.getString("property_value");
        } else if (this.f38355b.equals(d4.BOOLEAN)) {
            this.f38358e = Boolean.valueOf(jSONObject.getBoolean("property_value"));
        } else if (this.f38355b.equals(d4.NUMBER)) {
            this.f38358e = Double.valueOf(jSONObject.getDouble("property_value"));
        } else if (this.f38355b.equals(d4.DATE)) {
            this.f38358e = Long.valueOf(jSONObject.getLong("property_value"));
        }
    }

    private boolean a(Object obj, long j11) {
        Date date = null;
        if (obj instanceof String) {
            try {
                date = DateTimeUtils.parseDate((String) obj, BrazeDateFormat.LONG);
            } catch (Exception e11) {
                BrazeLogger.e(f38354f, "Caught exception trying to parse date in compareTimestamps", e11);
            }
        }
        if (date != null) {
            long timeFromEpochInSeconds = DateTimeUtils.getTimeFromEpochInSeconds(date);
            long longValue = ((Number) this.f38358e).longValue();
            int i11 = this.f38357d;
            if (i11 != 15) {
                if (i11 != 16) {
                    switch (i11) {
                        case 1:
                            if (timeFromEpochInSeconds == longValue) {
                                return true;
                            }
                            return false;
                        case 2:
                            if (timeFromEpochInSeconds != longValue) {
                                return true;
                            }
                            return false;
                        case 3:
                            if (timeFromEpochInSeconds > longValue) {
                                return true;
                            }
                            return false;
                        case 4:
                            if (timeFromEpochInSeconds >= j11 - longValue) {
                                return true;
                            }
                            return false;
                        case 5:
                            if (timeFromEpochInSeconds < longValue) {
                                return true;
                            }
                            return false;
                        case 6:
                            if (timeFromEpochInSeconds <= j11 - longValue) {
                                return true;
                            }
                            return false;
                        default:
                            return false;
                    }
                } else if (timeFromEpochInSeconds > j11 + longValue) {
                    return true;
                } else {
                    return false;
                }
            } else if (timeFromEpochInSeconds < j11 + longValue) {
                return true;
            } else {
                return false;
            }
        } else if (this.f38357d == 2) {
            return true;
        } else {
            return false;
        }
    }

    private boolean a(Object obj) {
        if (obj instanceof Boolean) {
            int i11 = this.f38357d;
            if (i11 == 1) {
                return obj.equals(this.f38358e);
            }
            if (i11 != 2) {
                return false;
            }
            return !obj.equals(this.f38358e);
        } else if (this.f38357d == 2) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean a(String str, String str2) {
        return Pattern.compile(str, 2).matcher(str2).find();
    }
}
