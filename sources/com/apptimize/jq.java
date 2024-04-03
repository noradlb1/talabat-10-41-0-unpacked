package com.apptimize;

import android.view.View;
import java.util.Map;
import org.json.JSONException;

public class jq implements bf {

    /* renamed from: a  reason: collision with root package name */
    private static final String f43135a = bf.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private hl f43136b;

    /* renamed from: c  reason: collision with root package name */
    private View f43137c;

    /* renamed from: d  reason: collision with root package name */
    private Map<hj<?, ?, ?>, Object> f43138d;

    public jq(hl hlVar, View view, Map<hj<?, ?, ?>, Object> map) {
        this.f43136b = hlVar;
        this.f43137c = view;
        this.f43138d = map;
    }

    public Object a(String str) {
        hj<?, ?, ?> a11 = this.f43136b.a((Object) this.f43137c, str);
        if (a11 == null) {
            return Boolean.FALSE;
        }
        try {
            if (this.f43138d.containsKey(a11)) {
                return this.f43138d.get(a11);
            }
            return a11.a(this.f43137c);
        } catch (JSONException e11) {
            bo.f(f43135a, String.format("Unexpected exception when fetching property %s from view %s", new Object[]{str, this.f43137c}), e11);
            return null;
        } catch (hk e12) {
            bo.f(f43135a, String.format("Unexpected exception when fetching property %s from view %s", new Object[]{str, this.f43137c}), e12);
            return null;
        }
    }
}
