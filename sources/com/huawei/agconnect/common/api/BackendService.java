package com.huawei.agconnect.common.api;

import com.huawei.agconnect.AGConnectInstance;
import com.huawei.agconnect.common.api.RequestThrottle;
import com.huawei.agconnect.credential.obs.o;
import com.huawei.agconnect.https.Adapter;
import com.huawei.hmf.tasks.Task;
import java.util.concurrent.TimeUnit;

public class BackendService {

    public enum AccessTokenType {
        MUST,
        EXPECT
    }

    public static class Options {
        /* access modifiers changed from: private */
        public final boolean accessToken;
        private boolean accessTokenRefreshed;
        /* access modifiers changed from: private */
        public final AccessTokenType accessTokenType;
        /* access modifiers changed from: private */
        public final AGConnectInstance app;
        /* access modifiers changed from: private */
        public final boolean clientToken;
        private boolean clientTokenRefreshed;
        /* access modifiers changed from: private */
        public final Adapter.Factory factory;
        /* access modifiers changed from: private */
        public final RequestThrottle.Throttle throttle;
        /* access modifiers changed from: private */
        public final TimeUnit timeUnit;
        /* access modifiers changed from: private */
        public final long timeout;

        public static class Builder {
            private boolean accessToken;
            private AccessTokenType accessTokenType = AccessTokenType.MUST;
            private AGConnectInstance app;
            private boolean clientToken;
            private Adapter.Factory factory;
            private RequestThrottle.Throttle throttle;
            private TimeUnit timeUnit;
            private long timeout;

            public Builder() {
            }

            public Builder(Options options) {
                this.clientToken = options.clientToken;
                this.accessToken = options.accessToken;
                this.throttle = options.throttle;
                this.accessTokenType = options.accessTokenType;
                this.factory = options.factory;
                this.timeout = options.timeout;
                this.timeUnit = options.timeUnit;
                this.app = options.app;
            }

            public Builder accessToken(boolean z11) {
                this.accessToken = z11;
                return this;
            }

            public Builder accessTokenType(AccessTokenType accessTokenType2) {
                this.accessTokenType = accessTokenType2;
                return this;
            }

            public Builder app(AGConnectInstance aGConnectInstance) {
                this.app = aGConnectInstance;
                return this;
            }

            public Options build() {
                return new Options(this.clientToken, this.accessToken, this.throttle, this.accessTokenType, this.factory, this.timeout, this.timeUnit, this.app);
            }

            public Builder clientToken(boolean z11) {
                this.clientToken = z11;
                return this;
            }

            public Builder factory(Adapter.Factory factory2) {
                this.factory = factory2;
                return this;
            }

            public Builder throttle(RequestThrottle.Throttle throttle2) {
                this.throttle = throttle2;
                return this;
            }

            public Builder timeUnit(TimeUnit timeUnit2) {
                this.timeUnit = timeUnit2;
                return this;
            }

            public Builder timeout(long j11) {
                this.timeout = j11;
                return this;
            }
        }

        private Options(boolean z11, boolean z12, RequestThrottle.Throttle throttle2, AccessTokenType accessTokenType2, Adapter.Factory factory2, long j11, TimeUnit timeUnit2, AGConnectInstance aGConnectInstance) {
            this.clientToken = z11;
            this.accessToken = z12;
            this.throttle = throttle2;
            this.accessTokenType = accessTokenType2;
            this.factory = factory2;
            this.timeout = j11;
            this.timeUnit = timeUnit2;
            this.app = aGConnectInstance;
        }

        public AccessTokenType getAccessTokenType() {
            return this.accessTokenType;
        }

        public AGConnectInstance getApp() {
            return this.app;
        }

        public Adapter.Factory getFactory() {
            return this.factory;
        }

        public RequestThrottle.Throttle getThrottle() {
            return this.throttle;
        }

        public TimeUnit getTimeUnit() {
            return this.timeUnit;
        }

        public long getTimeout() {
            return this.timeout;
        }

        public boolean isAccessToken() {
            return this.accessToken;
        }

        public boolean isAccessTokenRefreshed() {
            return this.accessTokenRefreshed;
        }

        public boolean isClientToken() {
            return this.clientToken;
        }

        public boolean isClientTokenRefreshed() {
            return this.clientTokenRefreshed;
        }

        public Builder newBuilder() {
            return new Builder(this);
        }

        public void setAccessTokenRefreshed(boolean z11) {
            this.accessTokenRefreshed = z11;
        }

        public void setClientTokenRefreshed(boolean z11) {
            this.clientTokenRefreshed = z11;
        }
    }

    public static <Rsp> Task<Rsp> sendRequest(BaseRequest baseRequest, int i11, Class<Rsp> cls, Options options) {
        return o.a(baseRequest, i11, cls, options);
    }
}
