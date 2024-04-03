package com.newrelic.agent.android.harvest;

import com.huawei.location.lite.common.http.exception.ErrorCode;
import com.instabug.library.networkv2.RequestResponse;

public class HarvestResponse {
    private static final String DISABLE_STRING = "DISABLE_NEW_RELIC";
    private String responseBody;
    private long responseTime;
    private int statusCode;

    /* renamed from: com.newrelic.agent.android.harvest.HarvestResponse$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$newrelic$agent$android$harvest$HarvestResponse$Code;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.newrelic.agent.android.harvest.HarvestResponse$Code[] r0 = com.newrelic.agent.android.harvest.HarvestResponse.Code.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$newrelic$agent$android$harvest$HarvestResponse$Code = r0
                com.newrelic.agent.android.harvest.HarvestResponse$Code r1 = com.newrelic.agent.android.harvest.HarvestResponse.Code.OK     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$newrelic$agent$android$harvest$HarvestResponse$Code     // Catch:{ NoSuchFieldError -> 0x001d }
                com.newrelic.agent.android.harvest.HarvestResponse$Code r1 = com.newrelic.agent.android.harvest.HarvestResponse.Code.ACCEPTED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.newrelic.agent.android.harvest.HarvestResponse.AnonymousClass1.<clinit>():void");
        }
    }

    public enum Code {
        OK(200),
        ACCEPTED(202),
        UNAUTHORIZED(401),
        FORBIDDEN(403),
        REQUEST_TIMEOUT(ErrorCode.HTTP_CLIENT_TIMEOUT),
        ENTITY_TOO_LARGE(ErrorCode.HTTP_ENTITY_TOO_LARGE),
        UNSUPPORTED_MEDIA_TYPE(ErrorCode.HTTP_UNSUPPORTED_TYPE),
        TOO_MANY_REQUESTS(RequestResponse.HttpStatusCode._4xx.RATE_LIMIT_REACHED),
        INVALID_AGENT_ID(450),
        INTERNAL_SERVER_ERROR(500),
        UNKNOWN(-1);
        
        int statusCode;

        private Code(int i11) {
            this.statusCode = i11;
        }

        public int getStatusCode() {
            return this.statusCode;
        }

        public boolean isError() {
            return !isOK();
        }

        public boolean isOK() {
            int i11 = AnonymousClass1.$SwitchMap$com$newrelic$agent$android$harvest$HarvestResponse$Code[ordinal()];
            return i11 == 1 || i11 == 2;
        }
    }

    public String getResponseBody() {
        return this.responseBody;
    }

    public Code getResponseCode() {
        for (Code code : Code.values()) {
            if (code.getStatusCode() == this.statusCode) {
                return code;
            }
        }
        return Code.UNKNOWN;
    }

    public long getResponseTime() {
        return this.responseTime;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public boolean isDisableCommand() {
        return Code.FORBIDDEN == getResponseCode() && DISABLE_STRING.equals(getResponseBody());
    }

    public boolean isError() {
        return this.statusCode >= 400;
    }

    public boolean isOK() {
        int i11 = this.statusCode;
        return i11 == 200 || i11 == 201;
    }

    public boolean isUnknown() {
        return getResponseCode() == Code.UNKNOWN;
    }

    public void setResponseBody(String str) {
        this.responseBody = str;
    }

    public void setResponseTime(long j11) {
        this.responseTime = j11;
    }

    public void setStatusCode(int i11) {
        this.statusCode = i11;
    }
}
