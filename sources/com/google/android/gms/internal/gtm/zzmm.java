package com.google.android.gms.internal.gtm;

import android.support.annotation.Nullable;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.huawei.hms.flutter.map.constants.Param;
import com.talabat.talabatcommon.views.wallet.cardViewWidgets.view.DefaultCardView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzmm {
    @VisibleForTesting
    private static List<zzno> zza(JSONArray jSONArray, List<String> list) throws JSONException, zzml {
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i11);
            zznq zznq = new zznq();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                zznx zzme = zza(jSONObject.get(next), list).zzme();
                if ("push_after_evaluate".equals(next)) {
                    zznq.zzb(zzme);
                } else {
                    zznq.zza(next, zzme);
                }
            }
            arrayList.add(zznq.zzlv());
        }
        return arrayList;
    }

    public static zznm zzcd(String str) throws JSONException, zzml {
        String str2;
        Object obj = new JSONObject(str).get("resource");
        if (obj instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject) obj;
            zznn zznn = new zznn();
            zznn.zzcl(jSONObject.optString("version"));
            JSONArray jSONArray = jSONObject.getJSONArray("macros");
            ArrayList arrayList = new ArrayList();
            for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                arrayList.add(jSONArray.getJSONObject(i11).getString("instance_name"));
            }
            List<zzno> zza = zza(jSONObject.getJSONArray("tags"), (List<String>) arrayList);
            List<zzno> zza2 = zza(jSONObject.getJSONArray("predicates"), (List<String>) arrayList);
            for (zzno zzb : zza(jSONObject.getJSONArray("macros"), (List<String>) arrayList)) {
                zznn.zzb(zzb);
            }
            JSONArray jSONArray2 = jSONObject.getJSONArray("rules");
            for (int i12 = 0; i12 < jSONArray2.length(); i12++) {
                JSONArray jSONArray3 = jSONArray2.getJSONArray(i12);
                zznt zznt = new zznt();
                for (int i13 = 0; i13 < jSONArray3.length(); i13++) {
                    JSONArray jSONArray4 = jSONArray3.getJSONArray(i13);
                    int i14 = 1;
                    if (jSONArray4.getString(0).equals("if")) {
                        while (i14 < jSONArray4.length()) {
                            zznt.zzc(zza2.get(jSONArray4.getInt(i14)));
                            i14++;
                        }
                    } else if (jSONArray4.getString(0).equals("unless")) {
                        while (i14 < jSONArray4.length()) {
                            zznt.zzd(zza2.get(jSONArray4.getInt(i14)));
                            i14++;
                        }
                    } else if (jSONArray4.getString(0).equals(ProductAction.ACTION_ADD)) {
                        while (i14 < jSONArray4.length()) {
                            zznt.zze(zza.get(jSONArray4.getInt(i14)));
                            i14++;
                        }
                    } else if (jSONArray4.getString(0).equals("block")) {
                        while (i14 < jSONArray4.length()) {
                            zznt.zzf(zza.get(jSONArray4.getInt(i14)));
                            i14++;
                        }
                    } else {
                        String valueOf = String.valueOf(jSONArray4.getString(0));
                        if (valueOf.length() != 0) {
                            str2 = "Unknown Rule property: ".concat(valueOf);
                        } else {
                            str2 = new String("Unknown Rule property: ");
                        }
                        zzcf(str2);
                    }
                }
                zznn.zza(zznt.zzma());
            }
            return zznn.zzlt();
        }
        throw new zzml("Resource map not found");
    }

    @Nullable
    public static zznu zzce(String str) throws JSONException, zzml {
        JSONObject jSONObject = new JSONObject(str);
        JSONArray optJSONArray = jSONObject.optJSONArray("runtime");
        if (optJSONArray == null) {
            return null;
        }
        zznw zznw = new zznw();
        Object obj = jSONObject.get("resource");
        if (obj instanceof JSONObject) {
            zznw.zzcm(((JSONObject) obj).optString("version"));
            for (int i11 = 0; i11 < optJSONArray.length(); i11++) {
                Object obj2 = optJSONArray.get(i11);
                if (!(obj2 instanceof JSONArray) || ((JSONArray) obj2).length() != 0) {
                    zznw.zza(zzo(obj2));
                }
            }
            return zznw.zzmc();
        }
        throw new zzml("Resource map not found");
    }

    private static void zzcf(String str) throws zzml {
        zzev.zzav(str);
        throw new zzml(str);
    }

    public static zzgy zzo(Object obj) throws JSONException {
        JSONArray jSONArray;
        JSONArray jSONArray2;
        String str;
        boolean z11;
        if (obj instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject) obj;
            str = jSONObject.getString("name");
            jSONArray2 = jSONObject.getJSONArray(NativeProtocol.WEB_DIALOG_PARAMS);
            jSONArray = jSONObject.getJSONArray("instructions");
        } else if (obj instanceof JSONArray) {
            JSONArray jSONArray3 = (JSONArray) obj;
            if (jSONArray3.length() >= 3) {
                z11 = true;
            } else {
                z11 = false;
            }
            Preconditions.checkArgument(z11);
            str = jSONArray3.getString(1);
            JSONArray jSONArray4 = jSONArray3.getJSONArray(2);
            JSONArray jSONArray5 = new JSONArray();
            for (int i11 = 1; i11 < jSONArray4.length(); i11++) {
                Preconditions.checkArgument(jSONArray4.get(i11) instanceof String);
                jSONArray5.put(jSONArray4.get(i11));
            }
            JSONArray jSONArray6 = new JSONArray();
            for (int i12 = 3; i12 < jSONArray3.length(); i12++) {
                jSONArray6.put(jSONArray3.get(i12));
            }
            jSONArray = jSONArray6;
            jSONArray2 = jSONArray5;
        } else {
            throw new IllegalArgumentException("invalid JSON in runtime section");
        }
        ArrayList arrayList = new ArrayList();
        for (int i13 = 0; i13 < jSONArray2.length(); i13++) {
            arrayList.add(jSONArray2.getString(i13));
        }
        ArrayList arrayList2 = new ArrayList();
        for (int i14 = 0; i14 < jSONArray.length(); i14++) {
            JSONArray jSONArray7 = jSONArray.getJSONArray(i14);
            if (jSONArray7.length() != 0) {
                arrayList2.add(zza(jSONArray7));
            }
        }
        return new zzgy((zzfl) null, str, arrayList, arrayList2);
    }

    @VisibleForTesting
    private static zznz zza(Object obj, List<String> list) throws zzml, JSONException {
        zznz zznz;
        if (obj instanceof JSONArray) {
            JSONArray jSONArray = (JSONArray) obj;
            String string = jSONArray.getString(0);
            if (string.equals("escape")) {
                zznz zza = zza(jSONArray.get(1), list);
                for (int i11 = 2; i11 < jSONArray.length(); i11++) {
                    zza.zzab(jSONArray.getInt(i11));
                }
                return zza;
            } else if (string.equals(DefaultCardView.CARD_LIST)) {
                ArrayList arrayList = new ArrayList();
                for (int i12 = 1; i12 < jSONArray.length(); i12++) {
                    arrayList.add(zza(jSONArray.get(i12), list).zzme());
                }
                zznz = new zznz(2, arrayList);
                zznz.zzh(true);
            } else if (string.equals(Param.MAP)) {
                HashMap hashMap = new HashMap();
                for (int i13 = 1; i13 < jSONArray.length(); i13 += 2) {
                    hashMap.put(zza(jSONArray.get(i13), list).zzme(), zza(jSONArray.get(i13 + 1), list).zzme());
                }
                zznz = new zznz(3, hashMap);
                zznz.zzh(true);
            } else if (string.equals("macro")) {
                zznz zznz2 = new zznz(4, list.get(jSONArray.getInt(1)));
                zznz2.zzh(true);
                return zznz2;
            } else if (string.equals("template")) {
                ArrayList arrayList2 = new ArrayList();
                for (int i14 = 1; i14 < jSONArray.length(); i14++) {
                    arrayList2.add(zza(jSONArray.get(i14), list).zzme());
                }
                zznz = new zznz(7, arrayList2);
                zznz.zzh(true);
            } else {
                String valueOf = String.valueOf(obj);
                StringBuilder sb2 = new StringBuilder(valueOf.length() + 20);
                sb2.append("Invalid value type: ");
                sb2.append(valueOf);
                zzcf(sb2.toString());
                return null;
            }
        } else if (obj instanceof Boolean) {
            zznz = new zznz(8, obj);
        } else if (obj instanceof Integer) {
            zznz = new zznz(6, obj);
        } else if (obj instanceof String) {
            zznz = new zznz(1, obj);
        } else {
            String valueOf2 = String.valueOf(obj);
            StringBuilder sb3 = new StringBuilder(valueOf2.length() + 20);
            sb3.append("Invalid value type: ");
            sb3.append(valueOf2);
            zzcf(sb3.toString());
            return null;
        }
        return zznz;
    }

    private static zzol zza(JSONArray jSONArray) throws JSONException {
        Preconditions.checkArgument(jSONArray.length() > 0);
        String string = jSONArray.getString(0);
        ArrayList arrayList = new ArrayList();
        for (int i11 = 1; i11 < jSONArray.length(); i11++) {
            Object obj = jSONArray.get(i11);
            if (obj instanceof JSONArray) {
                JSONArray jSONArray2 = (JSONArray) obj;
                if (jSONArray2.length() != 0) {
                    arrayList.add(zza(jSONArray2));
                }
            } else if (obj == JSONObject.NULL) {
                arrayList.add(zzog.zzaul);
            } else {
                arrayList.add(zzoo.zzq(obj));
            }
        }
        return new zzol(string, arrayList);
    }
}
