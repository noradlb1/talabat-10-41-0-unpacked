package io.flutter.plugins.videoplayer;

import io.flutter.plugin.common.EventChannel;
import java.util.ArrayList;
import java.util.Iterator;

final class QueuingEventSink implements EventChannel.EventSink {
    private EventChannel.EventSink delegate;
    private boolean done = false;
    private final ArrayList<Object> eventQueue = new ArrayList<>();

    public static class EndOfStreamEvent {
    }

    public static class ErrorEvent {

        /* renamed from: a  reason: collision with root package name */
        public String f14388a;

        /* renamed from: b  reason: collision with root package name */
        public String f14389b;

        /* renamed from: c  reason: collision with root package name */
        public Object f14390c;

        public ErrorEvent(String str, String str2, Object obj) {
            this.f14388a = str;
            this.f14389b = str2;
            this.f14390c = obj;
        }
    }

    private void enqueue(Object obj) {
        if (!this.done) {
            this.eventQueue.add(obj);
        }
    }

    private void maybeFlush() {
        if (this.delegate != null) {
            Iterator<Object> it = this.eventQueue.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof EndOfStreamEvent) {
                    this.delegate.endOfStream();
                } else if (next instanceof ErrorEvent) {
                    ErrorEvent errorEvent = (ErrorEvent) next;
                    this.delegate.error(errorEvent.f14388a, errorEvent.f14389b, errorEvent.f14390c);
                } else {
                    this.delegate.success(next);
                }
            }
            this.eventQueue.clear();
        }
    }

    public void endOfStream() {
        enqueue(new EndOfStreamEvent());
        maybeFlush();
        this.done = true;
    }

    public void error(String str, String str2, Object obj) {
        enqueue(new ErrorEvent(str, str2, obj));
        maybeFlush();
    }

    public void setDelegate(EventChannel.EventSink eventSink) {
        this.delegate = eventSink;
        maybeFlush();
    }

    public void success(Object obj) {
        enqueue(obj);
        maybeFlush();
    }
}
