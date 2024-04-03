package fwfd.com.fwfsdk.model.db;

public class FWFFallback {
    private FallbackTypes type;
    private Object value;

    public enum FallbackTypes {
        FROM_DB,
        FROM_VALUE
    }

    public FWFFallback(Object obj, FallbackTypes fallbackTypes) {
        this.value = obj;
        this.type = fallbackTypes;
    }

    public FallbackTypes getType() {
        return this.type;
    }

    public Object getValue() {
        return this.value;
    }
}
