package com.newrelic.agent.android.instrumentation.io;

import java.util.ArrayList;
import java.util.List;

class StreamCompleteListenerManager {
    private boolean streamComplete = false;
    private ArrayList<StreamCompleteListener> streamCompleteListeners = new ArrayList<>();

    private boolean checkComplete() {
        boolean isComplete;
        synchronized (this) {
            isComplete = isComplete();
            if (!isComplete) {
                this.streamComplete = true;
            }
        }
        return isComplete;
    }

    private List<StreamCompleteListener> getStreamCompleteListeners() {
        ArrayList arrayList;
        synchronized (this.streamCompleteListeners) {
            arrayList = new ArrayList(this.streamCompleteListeners);
            this.streamCompleteListeners.clear();
        }
        return arrayList;
    }

    public void addStreamCompleteListener(StreamCompleteListener streamCompleteListener) {
        synchronized (this.streamCompleteListeners) {
            this.streamCompleteListeners.add(streamCompleteListener);
        }
    }

    public boolean isComplete() {
        boolean z11;
        synchronized (this) {
            z11 = this.streamComplete;
        }
        return z11;
    }

    public void notifyStreamComplete(StreamCompleteEvent streamCompleteEvent) {
        if (!checkComplete()) {
            for (StreamCompleteListener streamComplete2 : getStreamCompleteListeners()) {
                streamComplete2.streamComplete(streamCompleteEvent);
            }
        }
    }

    public void notifyStreamError(StreamCompleteEvent streamCompleteEvent) {
        if (!checkComplete()) {
            for (StreamCompleteListener streamError : getStreamCompleteListeners()) {
                streamError.streamError(streamCompleteEvent);
            }
        }
    }

    public void removeStreamCompleteListener(StreamCompleteListener streamCompleteListener) {
        synchronized (this.streamCompleteListeners) {
            this.streamCompleteListeners.remove(streamCompleteListener);
        }
    }
}
