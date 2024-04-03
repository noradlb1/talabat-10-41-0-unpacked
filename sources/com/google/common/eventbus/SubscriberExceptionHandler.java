package com.google.common.eventbus;

@ElementTypesAreNonnullByDefault
public interface SubscriberExceptionHandler {
    void handleException(Throwable th2, SubscriberExceptionContext subscriberExceptionContext);
}
