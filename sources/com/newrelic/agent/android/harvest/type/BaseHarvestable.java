package com.newrelic.agent.android.harvest.type;

import com.newrelic.agent.android.harvest.type.Harvestable;
import com.newrelic.com.google.gson.JsonArray;
import com.newrelic.com.google.gson.JsonElement;
import com.newrelic.com.google.gson.JsonObject;
import com.newrelic.com.google.gson.JsonPrimitive;
import com.newrelic.com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.Map;

public class BaseHarvestable implements Harvestable {
    protected static final Type GSON_STRING_MAP_TYPE = new TypeToken<Map>() {
    }.getType();
    private final Harvestable.Type type;

    /* renamed from: com.newrelic.agent.android.harvest.type.BaseHarvestable$2  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$newrelic$agent$android$harvest$type$Harvestable$Type;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.newrelic.agent.android.harvest.type.Harvestable$Type[] r0 = com.newrelic.agent.android.harvest.type.Harvestable.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$newrelic$agent$android$harvest$type$Harvestable$Type = r0
                com.newrelic.agent.android.harvest.type.Harvestable$Type r1 = com.newrelic.agent.android.harvest.type.Harvestable.Type.OBJECT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$newrelic$agent$android$harvest$type$Harvestable$Type     // Catch:{ NoSuchFieldError -> 0x001d }
                com.newrelic.agent.android.harvest.type.Harvestable$Type r1 = com.newrelic.agent.android.harvest.type.Harvestable.Type.ARRAY     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$newrelic$agent$android$harvest$type$Harvestable$Type     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.newrelic.agent.android.harvest.type.Harvestable$Type r1 = com.newrelic.agent.android.harvest.type.Harvestable.Type.VALUE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.newrelic.agent.android.harvest.type.BaseHarvestable.AnonymousClass2.<clinit>():void");
        }
    }

    public BaseHarvestable(Harvestable.Type type2) {
        this.type = type2;
    }

    public JsonElement asJson() {
        int i11 = AnonymousClass2.$SwitchMap$com$newrelic$agent$android$harvest$type$Harvestable$Type[this.type.ordinal()];
        if (i11 == 1) {
            return asJsonObject();
        }
        if (i11 == 2) {
            return asJsonArray();
        }
        if (i11 != 3) {
            return null;
        }
        return asJsonPrimitive();
    }

    public JsonArray asJsonArray() {
        return null;
    }

    public JsonObject asJsonObject() {
        return null;
    }

    public JsonPrimitive asJsonPrimitive() {
        return null;
    }

    public Harvestable.Type getType() {
        return this.type;
    }

    public void notEmpty(String str) {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("Missing Harvestable field.");
        }
    }

    public void notNull(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Null field in Harvestable object");
        }
    }

    public String optional(String str) {
        return str == null ? "" : str;
    }

    public String toJsonString() {
        return asJson().toString();
    }
}
