package fwfd.com.fwfsdk.model.api;

import androidx.annotation.Nullable;
import fwfd.com.fwfsdk.util.FWFSubscribeObserverCallback;
import java.util.ArrayList;
import java.util.List;

public class FWFSubscribeObservable {
    private List<FWFSubscribeResultObserver> observers = new ArrayList();

    public static class FWFSubscribeResultObserver {
        private FWFSubscribeObserverCallback callback;
        private String environmentToken;

        public FWFSubscribeResultObserver(FWFSubscribeObserverCallback fWFSubscribeObserverCallback, @Nullable String str) {
            this.callback = fWFSubscribeObserverCallback;
            this.environmentToken = str;
        }

        public FWFSubscribeObserverCallback getCallback() {
            return this.callback;
        }

        public String getEnvironmentToken() {
            return this.environmentToken;
        }
    }

    public void addObserver(FWFSubscribeResultObserver fWFSubscribeResultObserver) {
        this.observers.add(fWFSubscribeResultObserver);
    }

    public void notify(String str, FWFSubscribeResult fWFSubscribeResult) {
        for (FWFSubscribeResultObserver next : this.observers) {
            if (next.getEnvironmentToken() == null) {
                next.getCallback().onFwfResponse(fWFSubscribeResult);
            } else if (next.getEnvironmentToken().equals(str)) {
                next.getCallback().onFwfResponse(fWFSubscribeResult);
            }
        }
    }
}
