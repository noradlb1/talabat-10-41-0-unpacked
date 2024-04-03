package com.huawei.location.callback;

import com.huawei.location.base.activity.callback.ATCallback;

public class Vw<ATCallBackInfo> extends FB {
    private static volatile Vw FB;
    private static final byte[] Vw = new byte[0];

    public static class yn extends LW {
        private ATCallback FB;

        public ATCallback FB() {
            return this.FB;
        }

        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (!(obj instanceof yn) || !this.FB.equals(((yn) obj).FB)) {
                return super.equals(obj);
            }
            return true;
        }

        public int hashCode() {
            return super.hashCode();
        }

        public void yn(ATCallback aTCallback) {
            this.FB = aTCallback;
        }
    }

    private Vw() {
    }

    public static Vw Vw() {
        if (FB == null) {
            synchronized (Vw) {
                if (FB == null) {
                    FB = new Vw();
                }
            }
        }
        return FB;
    }

    public String yn() {
        return "ATCallBackManager";
    }
}
