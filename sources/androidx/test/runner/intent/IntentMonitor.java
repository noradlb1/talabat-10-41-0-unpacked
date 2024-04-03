package androidx.test.runner.intent;

public interface IntentMonitor {
    void addIntentCallback(IntentCallback intentCallback);

    void removeIntentCallback(IntentCallback intentCallback);
}
