package com.google.gson;

public enum LongSerializationPolicy {
    DEFAULT {
        public JsonElement serialize(Long l11) {
            if (l11 == null) {
                return JsonNull.INSTANCE;
            }
            return new JsonPrimitive((Number) l11);
        }
    },
    STRING {
        public JsonElement serialize(Long l11) {
            if (l11 == null) {
                return JsonNull.INSTANCE;
            }
            return new JsonPrimitive(l11.toString());
        }
    };

    public abstract JsonElement serialize(Long l11);
}
