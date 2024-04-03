package com.apptimize;

import com.apptimize.ck;
import com.google.common.base.Ascii;
import com.talabat.sidemenu.SideMenuRewardViewHolder;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class cl implements bw, cs {

    /* renamed from: a  reason: collision with root package name */
    private static final String f41682a = "cl";

    /* renamed from: b  reason: collision with root package name */
    private final List<ck> f41683b;

    /* renamed from: c  reason: collision with root package name */
    private final bv f41684c;

    /* renamed from: d  reason: collision with root package name */
    private final cf f41685d;

    /* renamed from: e  reason: collision with root package name */
    private final List<ch> f41686e;

    /* renamed from: f  reason: collision with root package name */
    private final List<cs> f41687f;

    public static class a extends Exception {
        public a(String str) {
            super(str);
        }
    }

    private cl(List<ck> list, bv bvVar, cf cfVar, List<ch> list2) {
        this.f41683b = Collections.unmodifiableList(list);
        this.f41684c = bvVar;
        this.f41685d = cfVar;
        this.f41686e = Collections.unmodifiableList(list2);
        this.f41687f = Collections.unmodifiableList(new ArrayList(list2));
    }

    public static cl a(JSONObject jSONObject, au auVar) throws JSONException, ca {
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("seeds");
        if (optJSONArray != null) {
            for (int i11 = 0; i11 != optJSONArray.length(); i11++) {
                arrayList.add(ck.a(optJSONArray.getJSONObject(i11)));
            }
        }
        bv a11 = bv.a(jSONObject, auVar);
        cf a12 = cf.a(jSONObject, auVar);
        ArrayList arrayList2 = new ArrayList();
        JSONArray optJSONArray2 = jSONObject.optJSONArray("rangeGroups");
        if (optJSONArray2 != null) {
            for (int i12 = 0; i12 != optJSONArray2.length(); i12++) {
                arrayList2.add(ch.a(optJSONArray2.getJSONObject(i12), auVar));
            }
        }
        return new cl(arrayList, a11, a12, arrayList2);
    }

    public List<az> b() {
        return this.f41684c.a();
    }

    public List<az> c() {
        return this.f41685d.a();
    }

    public List<cs> e() {
        return this.f41687f;
    }

    public JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (!this.f41683b.isEmpty()) {
            JSONArray jSONArray = new JSONArray();
            for (ck a11 : this.f41683b) {
                jSONArray.put((Object) a11.a());
            }
            jSONObject.put("seeds", (Object) jSONArray);
        }
        this.f41684c.a(jSONObject);
        this.f41685d.a(jSONObject);
        if (!this.f41686e.isEmpty()) {
            JSONArray jSONArray2 = new JSONArray();
            for (ch a12 : this.f41686e) {
                jSONArray2.put((Object) a12.a());
            }
            jSONObject.put("rangeGroups", (Object) jSONArray2);
        }
        return jSONObject;
    }

    public Integer a(String str, String str2) {
        String str3;
        if (this.f41683b.isEmpty()) {
            bo.f(f41682a, "No seeds; seed group will be excluded");
            return null;
        }
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-1");
            if (str2 != null) {
                str3 = a("userId", str2.getBytes("UTF-8"), instance);
            } else {
                str3 = a(str, a(str), instance);
            }
            byte[] digest = instance.digest();
            int length = digest.length - 4;
            int i11 = (((digest[length + 0] & 255) << Ascii.CAN) | ((digest[length + 3] & 255) << 0) | ((digest[length + 2] & 255) << 8) | ((digest[length + 1] & 255) << Ascii.DLE)) & 1073741823;
            bo.f(f41682a, "Seed group: " + str3 + "generated seed: " + String.valueOf(i11));
            return Integer.valueOf(i11);
        } catch (NoSuchAlgorithmException e11) {
            bo.b(f41682a, "platform is missing SHA-1?", e11);
            return null;
        } catch (UnsupportedEncodingException e12) {
            bo.b(f41682a, "platform is missing utf-8?", e12);
            return null;
        } catch (IllegalArgumentException e13) {
            bo.f(f41682a, "Could not calculate seed: " + e13.getMessage());
            return null;
        } catch (a e14) {
            bo.f(f41682a, "Seed group will be excluded: " + e14.getMessage());
            return null;
        }
    }

    private String a(String str, byte[] bArr, MessageDigest messageDigest) throws NoSuchAlgorithmException, UnsupportedEncodingException, IllegalArgumentException, a {
        MessageDigest instance = MessageDigest.getInstance("SHA-1");
        String str2 = "";
        for (ck next : this.f41683b) {
            if (next instanceof ck.a) {
                String b11 = ((ck.a) next).b();
                instance.update(b11.getBytes("UTF-8"));
                messageDigest.update(instance.digest());
                str2 = str2 + b11 + "; ";
            } else if (next instanceof ck.b) {
                instance.update(bArr);
                messageDigest.update(instance.digest());
                str2 = str2 + str + "; ";
            } else {
                throw new a("Unrecognized seed type " + next);
            }
        }
        return str2;
    }

    private static byte[] a(String str) {
        String replace = str.replace(SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE, "");
        int length = replace.length();
        if (length % 2 == 0) {
            byte[] bArr = new byte[(length / 2)];
            for (int i11 = 0; i11 < length; i11 += 2) {
                int a11 = a(replace.charAt(i11));
                int a12 = a(replace.charAt(i11 + 1));
                if (a11 == -1 || a12 == -1) {
                    throw new IllegalArgumentException("Hex string contains illegal character: " + replace);
                }
                bArr[i11 / 2] = (byte) ((a11 * 16) + a12);
            }
            return bArr;
        }
        throw new IllegalArgumentException("Hex string needs to be even-length: " + replace);
    }

    private static int a(char c11) {
        return Character.digit(c11, 16);
    }

    public boolean a(co coVar) {
        return coVar.a(this);
    }
}
