package androidx.emoji2.text;

import androidx.emoji2.text.EmojiCompat;
import androidx.emoji2.text.EmojiCompatInitializer;
import java.util.concurrent.ThreadPoolExecutor;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ EmojiCompatInitializer.BackgroundDefaultLoader f35910b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ EmojiCompat.MetadataRepoLoaderCallback f35911c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ThreadPoolExecutor f35912d;

    public /* synthetic */ b(EmojiCompatInitializer.BackgroundDefaultLoader backgroundDefaultLoader, EmojiCompat.MetadataRepoLoaderCallback metadataRepoLoaderCallback, ThreadPoolExecutor threadPoolExecutor) {
        this.f35910b = backgroundDefaultLoader;
        this.f35911c = metadataRepoLoaderCallback;
        this.f35912d = threadPoolExecutor;
    }

    public final void run() {
        this.f35910b.lambda$load$0(this.f35911c, this.f35912d);
    }
}
