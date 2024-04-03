package s2;

import androidx.window.embedding.ExtensionEmbeddingBackend;
import java.util.List;

public final /* synthetic */ class f implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ExtensionEmbeddingBackend.SplitListenerWrapper f44398b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f44399c;

    public /* synthetic */ f(ExtensionEmbeddingBackend.SplitListenerWrapper splitListenerWrapper, List list) {
        this.f44398b = splitListenerWrapper;
        this.f44399c = list;
    }

    public final void run() {
        ExtensionEmbeddingBackend.SplitListenerWrapper.m9128accept$lambda1(this.f44398b, this.f44399c);
    }
}
