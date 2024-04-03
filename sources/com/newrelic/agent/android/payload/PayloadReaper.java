package com.newrelic.agent.android.payload;

import com.newrelic.agent.android.payload.PayloadSender;
import java.util.concurrent.Callable;

class PayloadReaper implements Callable<PayloadSender> {
    final PayloadSender.CompletionHandler handler;
    final PayloadSender sender;

    public PayloadReaper(PayloadSender payloadSender, PayloadSender.CompletionHandler completionHandler) {
        if (payloadSender != null) {
            this.sender = payloadSender;
            this.handler = completionHandler;
            return;
        }
        throw new NullPointerException("Must provide payload sender!");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PayloadReaper) {
            return this.sender.payload.equals(((PayloadReaper) obj).sender.payload);
        }
        return false;
    }

    public String getUuid() {
        return this.sender.getPayload().getUuid();
    }

    public PayloadSender call() throws Exception {
        try {
            PayloadSender call = this.sender.call();
            PayloadSender.CompletionHandler completionHandler = this.handler;
            if (completionHandler != null) {
                completionHandler.onResponse(call);
            }
            return call;
        } catch (Exception e11) {
            PayloadSender.CompletionHandler completionHandler2 = this.handler;
            if (completionHandler2 == null) {
                return null;
            }
            completionHandler2.onException(this.sender, e11);
            return null;
        }
    }
}
