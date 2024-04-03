package com.newrelic.agent.android.payload;

import com.newrelic.agent.android.util.SafeJsonPrimitive;
import com.newrelic.com.google.gson.JsonObject;
import java.nio.ByteBuffer;
import java.util.UUID;

public class Payload {
    private boolean isPersistable;
    private ByteBuffer payload;
    private final long timestamp;
    private final String uuid;

    public Payload() {
        this.isPersistable = true;
        this.timestamp = System.currentTimeMillis();
        this.uuid = UUID.randomUUID().toString();
        this.isPersistable = true;
    }

    public String asJsonMeta() {
        return asJsonObject().toString();
    }

    public JsonObject asJsonObject() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("timestamp", SafeJsonPrimitive.factory((Number) Long.valueOf(this.timestamp)));
        jsonObject.add("uuid", SafeJsonPrimitive.factory(this.uuid));
        return jsonObject;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Payload)) {
            return false;
        }
        return this.uuid.equalsIgnoreCase(((Payload) obj).uuid);
    }

    public byte[] getBytes() {
        return this.payload.array();
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public String getUuid() {
        return this.uuid;
    }

    public boolean isPersisted() {
        return this.isPersistable;
    }

    public boolean isStale(long j11) {
        return this.timestamp + j11 <= System.currentTimeMillis();
    }

    public void putBytes(byte[] bArr) {
        this.payload = ByteBuffer.wrap(bArr);
    }

    public void setPersisted(boolean z11) {
        this.isPersistable = z11;
    }

    public Payload(byte[] bArr) {
        this();
        this.payload = ByteBuffer.wrap(bArr);
    }
}
