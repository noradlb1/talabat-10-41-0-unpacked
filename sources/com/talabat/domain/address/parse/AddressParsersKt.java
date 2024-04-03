package com.talabat.domain.address.parse;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0014\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0000¨\u0006\u0003"}, d2 = {"parseGrlId", "", "grl", "com_talabat_domain_address_address"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class AddressParsersKt {
    @Nullable
    public static final String parseGrlId(@Nullable String str) {
        boolean z11;
        if (str == null || StringsKt__StringsJVMKt.isBlank(str)) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return str;
        }
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONObject(str).getJSONArray("AddressElements");
            int length = jSONArray.length();
            for (int i11 = 0; i11 < length; i11++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i11);
                int i12 = jSONObject.getInt("AddressElementTypeCode");
                String string = jSONObject.getString("Value");
                Intrinsics.checkNotNullExpressionValue(string, "element.getString(\"Value\")");
                arrayList.add(new AddressJsonInternal(i12, string));
            }
            if (arrayList.size() > 4) {
                return ((AddressJsonInternal) arrayList.get(4)).getItem();
            }
            return str;
        } catch (Exception unused) {
            return str;
        }
    }
}
