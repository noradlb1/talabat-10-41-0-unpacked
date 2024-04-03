package com.huawei.agconnect.common.api;

import android.text.TextUtils;
import com.huawei.agconnect.AGConnectInstance;
import com.huawei.agconnect.datastore.annotation.DefaultCrypto;
import com.huawei.agconnect.datastore.core.SharedPrefUtil;
import com.huawei.agconnect.exception.AGCException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;

public class RequestThrottle {
    private static final RequestThrottle INSTANCE = new RequestThrottle();
    private static final String TAG = "AGC_THROTTLE";
    private static final Object lock = new Object();
    private final Map<String, Throttle> throttleMap = new HashMap();

    public static class Throttle {
        private static final Object LOCK = new Object();
        private static final int MAX_REQUEST_COUNT_IN_INTERVAL = 20;
        private static final String SP_FILE_NAME = "com.huawei.agc.throttle";
        private static final long THROTTLE_INTERVAL_TIME = 3600000;
        private final ArrayDeque<Long> countDeque = new ArrayDeque<>();
        private Integer failCount;
        private Long failTime;
        private boolean isDeveloperMode;

        /* renamed from: name  reason: collision with root package name */
        private final String f47466name;

        public Throttle(String str) {
            this.f47466name = str;
            loadCache();
        }

        private long getFirst() {
            try {
                return this.countDeque.getFirst().longValue();
            } catch (NoSuchElementException unused) {
                return 0;
            }
        }

        private void loadCache() {
            SharedPrefUtil instance = SharedPrefUtil.getInstance();
            String[] split = ((String) instance.get(SP_FILE_NAME, this.f47466name + "-countDeque", String.class, "", DefaultCrypto.class)).split(",");
            int length = split.length;
            for (int i11 = 0; i11 < length; i11++) {
                String str = split[i11];
                try {
                    if (str.length() > 0) {
                        this.countDeque.addLast(Long.valueOf(str));
                    }
                } catch (NumberFormatException e11) {
                    Logger.e(RequestThrottle.TAG, "count deque", e11);
                }
            }
            SharedPrefUtil instance2 = SharedPrefUtil.getInstance();
            this.failCount = (Integer) instance2.get(SP_FILE_NAME, this.f47466name + "-failCount", Integer.class, 0, DefaultCrypto.class);
            SharedPrefUtil instance3 = SharedPrefUtil.getInstance();
            this.failTime = (Long) instance3.get(SP_FILE_NAME, this.f47466name + "-failTime", Long.class, 0L, DefaultCrypto.class);
        }

        private void saveCache() {
            StringBuilder sb2 = new StringBuilder();
            ArrayList arrayList = new ArrayList(this.countDeque);
            for (int i11 = 0; i11 < arrayList.size(); i11++) {
                sb2.append(arrayList.get(i11));
                if (i11 != arrayList.size() - 1) {
                    sb2.append(",");
                }
            }
            SharedPrefUtil instance = SharedPrefUtil.getInstance();
            instance.put(SP_FILE_NAME, this.f47466name + "-countDeque", String.class, sb2.toString(), DefaultCrypto.class);
            SharedPrefUtil instance2 = SharedPrefUtil.getInstance();
            instance2.put(SP_FILE_NAME, this.f47466name + "-failCount", Integer.class, this.failCount, DefaultCrypto.class);
            SharedPrefUtil instance3 = SharedPrefUtil.getInstance();
            instance3.put(SP_FILE_NAME, this.f47466name + "-failTime", Long.class, this.failTime, DefaultCrypto.class);
        }

        public void addForFail() {
            synchronized (LOCK) {
                this.failCount = Integer.valueOf(this.failCount.intValue() + 1);
                this.failTime = Long.valueOf(System.currentTimeMillis());
                saveCache();
            }
        }

        public void addForStart() {
            synchronized (LOCK) {
                if (this.countDeque.size() == 20) {
                    this.countDeque.pollFirst();
                }
                this.countDeque.addLast(Long.valueOf(System.currentTimeMillis()));
            }
        }

        public void addForSuccess() {
            synchronized (LOCK) {
                this.failCount = 0;
                this.failTime = 0L;
                saveCache();
            }
        }

        public boolean checkFail(Exception exc) {
            if (!(exc instanceof AGCException)) {
                return false;
            }
            AGCException aGCException = (AGCException) exc;
            return aGCException.getCode() == 429 || aGCException.getCode() == 500 || aGCException.getCode() == 502 || aGCException.getCode() == 503 || aGCException.getCode() == 504;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:22:0x007b, code lost:
            return 0;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public long getEndTime() {
            /*
                r10 = this;
                java.lang.Object r0 = LOCK
                monitor-enter(r0)
                boolean r1 = r10.isDeveloperMode     // Catch:{ all -> 0x007c }
                if (r1 != 0) goto L_0x002d
                java.util.ArrayDeque<java.lang.Long> r1 = r10.countDeque     // Catch:{ all -> 0x007c }
                int r1 = r1.size()     // Catch:{ all -> 0x007c }
                r2 = 20
                if (r1 < r2) goto L_0x002d
                long r1 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x007c }
                long r3 = r10.getFirst()     // Catch:{ all -> 0x007c }
                long r1 = r1 - r3
                r3 = 3600000(0x36ee80, double:1.7786363E-317)
                int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
                if (r1 >= 0) goto L_0x002d
                long r1 = r10.getFirst()     // Catch:{ all -> 0x007c }
                long r1 = r1 + r3
                long r3 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x007c }
                long r1 = r1 - r3
                monitor-exit(r0)     // Catch:{ all -> 0x007c }
                return r1
            L_0x002d:
                java.lang.Integer r1 = r10.failCount     // Catch:{ all -> 0x007c }
                int r1 = r1.intValue()     // Catch:{ all -> 0x007c }
                r2 = 0
                r4 = 1
                if (r1 <= r4) goto L_0x007a
                java.lang.Long r1 = r10.failTime     // Catch:{ all -> 0x007c }
                long r5 = r1.longValue()     // Catch:{ all -> 0x007c }
                int r1 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
                if (r1 <= 0) goto L_0x007a
                java.lang.Integer r1 = r10.failCount     // Catch:{ all -> 0x007c }
                int r1 = r1.intValue()     // Catch:{ all -> 0x007c }
                int r1 = r1 - r4
                r4 = 8
                int r1 = java.lang.Math.min(r1, r4)     // Catch:{ all -> 0x007c }
                double r4 = (double) r1     // Catch:{ all -> 0x007c }
                r6 = 4611686018427387904(0x4000000000000000, double:2.0)
                double r4 = java.lang.Math.pow(r6, r4)     // Catch:{ all -> 0x007c }
                long r4 = (long) r4     // Catch:{ all -> 0x007c }
                r6 = 60
                long r4 = r4 * r6
                r6 = 1000(0x3e8, double:4.94E-321)
                long r4 = r4 * r6
                long r6 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x007c }
                java.lang.Long r1 = r10.failTime     // Catch:{ all -> 0x007c }
                long r8 = r1.longValue()     // Catch:{ all -> 0x007c }
                long r8 = r8 + r4
                int r1 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
                if (r1 >= 0) goto L_0x007a
                java.lang.Long r1 = r10.failTime     // Catch:{ all -> 0x007c }
                long r1 = r1.longValue()     // Catch:{ all -> 0x007c }
                long r1 = r1 + r4
                long r3 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x007c }
                long r1 = r1 - r3
                monitor-exit(r0)     // Catch:{ all -> 0x007c }
                return r1
            L_0x007a:
                monitor-exit(r0)     // Catch:{ all -> 0x007c }
                return r2
            L_0x007c:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x007c }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.agconnect.common.api.RequestThrottle.Throttle.getEndTime():long");
        }

        public void setDeveloperMode(boolean z11) {
            this.isDeveloperMode = z11;
        }
    }

    private RequestThrottle() {
    }

    public static RequestThrottle getInstance() {
        return INSTANCE;
    }

    public Throttle get(AGConnectInstance aGConnectInstance, String str) {
        synchronized (lock) {
            if (!TextUtils.isEmpty(str)) {
                if (aGConnectInstance == null) {
                    aGConnectInstance = AGConnectInstance.getInstance();
                }
                String format = String.format(Locale.ENGLISH, "%s_%s", new Object[]{str, aGConnectInstance.getOptions().getIdentifier()});
                if (this.throttleMap.containsKey(format)) {
                    Throttle throttle = this.throttleMap.get(format);
                    return throttle;
                }
                Throttle throttle2 = new Throttle(format);
                this.throttleMap.put(format, throttle2);
                return throttle2;
            }
            throw new RuntimeException("throttle name can not be empty");
        }
    }

    public Throttle get(String str) {
        return get((AGConnectInstance) null, str);
    }
}
