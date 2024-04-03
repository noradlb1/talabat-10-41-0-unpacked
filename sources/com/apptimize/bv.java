package com.apptimize;

import com.facebook.share.internal.ShareConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class bv {

    /* renamed from: a  reason: collision with root package name */
    public static final bv f41512a = new bv(Collections.emptyList(), Collections.emptyList());

    /* renamed from: b  reason: collision with root package name */
    private final List<az> f41513b;

    /* renamed from: c  reason: collision with root package name */
    private final List<az> f41514c;

    /* renamed from: d  reason: collision with root package name */
    private final List<az> f41515d;

    private bv(List<az> list, List<az> list2) {
        List<az> unmodifiableList = Collections.unmodifiableList(new ArrayList(list));
        this.f41513b = unmodifiableList;
        List<az> unmodifiableList2 = Collections.unmodifiableList(new ArrayList(list2));
        this.f41514c = unmodifiableList2;
        ArrayList arrayList = new ArrayList(unmodifiableList);
        arrayList.addAll(unmodifiableList2);
        this.f41515d = Collections.unmodifiableList(arrayList);
    }

    public static bv a(JSONObject jSONObject, au auVar) throws JSONException {
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray(ShareConstants.WEB_DIALOG_PARAM_FILTERS);
        if (optJSONArray != null) {
            for (int i11 = 0; i11 != optJSONArray.length(); i11++) {
                arrayList.add(az.a(optJSONArray.getJSONObject(i11), auVar));
            }
        }
        ArrayList arrayList2 = new ArrayList();
        JSONArray optJSONArray2 = jSONObject.optJSONArray("filters2");
        if (optJSONArray2 != null) {
            for (int i12 = 0; i12 != optJSONArray2.length(); i12++) {
                arrayList2.add(az.a(optJSONArray2.getJSONObject(i12), auVar));
            }
        }
        return new bv(arrayList, arrayList2);
    }

    public void a(JSONObject jSONObject) throws JSONException {
        if (!this.f41513b.isEmpty()) {
            JSONArray jSONArray = new JSONArray();
            for (az a11 : this.f41513b) {
                jSONArray.put((Object) a11.a());
            }
            jSONObject.put(ShareConstants.WEB_DIALOG_PARAM_FILTERS, (Object) jSONArray);
        }
        if (!this.f41514c.isEmpty()) {
            JSONArray jSONArray2 = new JSONArray();
            for (az a12 : this.f41514c) {
                jSONArray2.put((Object) a12.a());
            }
            jSONObject.put("filters2", (Object) jSONArray2);
        }
    }

    public List<az> a() {
        return this.f41515d;
    }
}
