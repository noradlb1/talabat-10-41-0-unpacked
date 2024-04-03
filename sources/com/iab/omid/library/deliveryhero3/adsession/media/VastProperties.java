package com.iab.omid.library.deliveryhero3.adsession.media;

import com.iab.omid.library.deliveryhero3.utils.d;
import com.iab.omid.library.deliveryhero3.utils.g;
import org.json.JSONException;
import org.json.JSONObject;

public final class VastProperties {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f44930a;

    /* renamed from: b  reason: collision with root package name */
    private final Float f44931b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f44932c;

    /* renamed from: d  reason: collision with root package name */
    private final Position f44933d;

    private VastProperties(boolean z11, Float f11, boolean z12, Position position) {
        this.f44930a = z11;
        this.f44931b = f11;
        this.f44932c = z12;
        this.f44933d = position;
    }

    public static VastProperties createVastPropertiesForNonSkippableMedia(boolean z11, Position position) {
        g.a((Object) position, "Position is null");
        return new VastProperties(false, (Float) null, z11, position);
    }

    public static VastProperties createVastPropertiesForSkippableMedia(float f11, boolean z11, Position position) {
        g.a((Object) position, "Position is null");
        return new VastProperties(true, Float.valueOf(f11), z11, position);
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("skippable", this.f44930a);
            if (this.f44930a) {
                jSONObject.put("skipOffset", (Object) this.f44931b);
            }
            jSONObject.put("autoPlay", this.f44932c);
            jSONObject.put("position", (Object) this.f44933d);
        } catch (JSONException e11) {
            d.a("VastProperties: JSON error", e11);
        }
        return jSONObject;
    }

    public Position getPosition() {
        return this.f44933d;
    }

    public Float getSkipOffset() {
        return this.f44931b;
    }

    public boolean isAutoPlay() {
        return this.f44932c;
    }

    public boolean isSkippable() {
        return this.f44930a;
    }
}
