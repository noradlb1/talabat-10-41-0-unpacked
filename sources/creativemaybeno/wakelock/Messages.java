package creativemaybeno.wakelock;

import com.tekartik.sqflite.Constant;
import io.flutter.plugin.common.StandardMessageCodec;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

public class Messages {

    public static class IsEnabledMessage {
        private Boolean enabled;

        public static IsEnabledMessage a(Map<String, Object> map) {
            IsEnabledMessage isEnabledMessage = new IsEnabledMessage();
            isEnabledMessage.enabled = (Boolean) map.get("enabled");
            return isEnabledMessage;
        }

        public Map<String, Object> b() {
            HashMap hashMap = new HashMap();
            hashMap.put("enabled", this.enabled);
            return hashMap;
        }

        public Boolean getEnabled() {
            return this.enabled;
        }

        public void setEnabled(Boolean bool) {
            this.enabled = bool;
        }
    }

    public static class ToggleMessage {
        private Boolean enable;

        public static ToggleMessage a(Map<String, Object> map) {
            ToggleMessage toggleMessage = new ToggleMessage();
            toggleMessage.enable = (Boolean) map.get("enable");
            return toggleMessage;
        }

        public Map<String, Object> b() {
            HashMap hashMap = new HashMap();
            hashMap.put("enable", this.enable);
            return hashMap;
        }

        public Boolean getEnable() {
            return this.enable;
        }

        public void setEnable(Boolean bool) {
            this.enable = bool;
        }
    }

    public interface WakelockApi {
        IsEnabledMessage isEnabled();

        void toggle(ToggleMessage toggleMessage);
    }

    public static class WakelockApiCodec extends StandardMessageCodec {
        public static final WakelockApiCodec INSTANCE = new WakelockApiCodec();

        private WakelockApiCodec() {
        }

        public Object e(byte b11, ByteBuffer byteBuffer) {
            if (b11 == Byte.MIN_VALUE) {
                return IsEnabledMessage.a((Map) d(byteBuffer));
            }
            if (b11 != -127) {
                return super.e(b11, byteBuffer);
            }
            return ToggleMessage.a((Map) d(byteBuffer));
        }

        public void n(ByteArrayOutputStream byteArrayOutputStream, Object obj) {
            if (obj instanceof IsEnabledMessage) {
                byteArrayOutputStream.write(128);
                n(byteArrayOutputStream, ((IsEnabledMessage) obj).b());
            } else if (obj instanceof ToggleMessage) {
                byteArrayOutputStream.write(129);
                n(byteArrayOutputStream, ((ToggleMessage) obj).b());
            } else {
                super.n(byteArrayOutputStream, obj);
            }
        }
    }

    /* access modifiers changed from: private */
    public static Map<String, Object> wrapError(Throwable th2) {
        HashMap hashMap = new HashMap();
        hashMap.put("message", th2.toString());
        hashMap.put(Constant.PARAM_ERROR_CODE, th2.getClass().getSimpleName());
        hashMap.put("details", (Object) null);
        return hashMap;
    }
}
