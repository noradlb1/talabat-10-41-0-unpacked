package com.huawei.location.callback;

import com.huawei.location.base.activity.callback.ARCallback;

public class yn<ARCallBackInfo> extends FB {
    private static volatile yn FB;
    private static final byte[] Vw = new byte[0];

    /* renamed from: com.huawei.location.callback.yn$yn  reason: collision with other inner class name */
    public static class C0076yn extends LW {
        private ARCallback FB;

        public ARCallback FB() {
            return this.FB;
        }

        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (!(obj instanceof C0076yn) || !this.FB.equals(((C0076yn) obj).FB)) {
                return super.equals(obj);
            }
            return true;
        }

        public int hashCode() {
            return super.hashCode();
        }

        public void yn(ARCallback aRCallback) {
            this.FB = aRCallback;
        }
    }

    private yn() {
    }

    public static yn Vw() {
        if (FB == null) {
            synchronized (Vw) {
                if (FB == null) {
                    FB = new yn();
                }
            }
        }
        return FB;
    }

    public String yn() {
        return "ARCallbackManager";
    }
}
