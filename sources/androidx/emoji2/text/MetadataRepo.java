package androidx.emoji2.text;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.util.SparseArray;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.os.TraceCompat;
import androidx.core.util.Preconditions;
import androidx.emoji2.text.flatbuffer.MetadataList;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

@RequiresApi(19)
@AnyThread
public final class MetadataRepo {
    private static final int DEFAULT_ROOT_SIZE = 1024;
    private static final String S_TRACE_CREATE_REPO = "EmojiCompat.MetadataRepo.create";
    @NonNull
    private final char[] mEmojiCharArray;
    @NonNull
    private final MetadataList mMetadataList;
    @NonNull
    private final Node mRootNode = new Node(1024);
    @NonNull
    private final Typeface mTypeface;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static class Node {
        private final SparseArray<Node> mChildren;
        private EmojiMetadata mData;

        private Node() {
            this(1);
        }

        public Node a(int i11) {
            SparseArray<Node> sparseArray = this.mChildren;
            if (sparseArray == null) {
                return null;
            }
            return sparseArray.get(i11);
        }

        public final EmojiMetadata b() {
            return this.mData;
        }

        public void c(@NonNull EmojiMetadata emojiMetadata, int i11, int i12) {
            Node a11 = a(emojiMetadata.getCodepointAt(i11));
            if (a11 == null) {
                a11 = new Node();
                this.mChildren.put(emojiMetadata.getCodepointAt(i11), a11);
            }
            if (i12 > i11) {
                a11.c(emojiMetadata, i11 + 1, i12);
            } else {
                a11.mData = emojiMetadata;
            }
        }

        public Node(int i11) {
            this.mChildren = new SparseArray<>(i11);
        }
    }

    private MetadataRepo(@NonNull Typeface typeface, @NonNull MetadataList metadataList) {
        this.mTypeface = typeface;
        this.mMetadataList = metadataList;
        this.mEmojiCharArray = new char[(metadataList.listLength() * 2)];
        constructIndex(metadataList);
    }

    private void constructIndex(MetadataList metadataList) {
        int listLength = metadataList.listLength();
        for (int i11 = 0; i11 < listLength; i11++) {
            EmojiMetadata emojiMetadata = new EmojiMetadata(this, i11);
            Character.toChars(emojiMetadata.getId(), this.mEmojiCharArray, i11 * 2);
            d(emojiMetadata);
        }
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.TESTS})
    public static MetadataRepo create(@NonNull Typeface typeface) {
        try {
            TraceCompat.beginSection(S_TRACE_CREATE_REPO);
            return new MetadataRepo(typeface, new MetadataList());
        } finally {
            TraceCompat.endSection();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int a() {
        return this.mMetadataList.version();
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Node b() {
        return this.mRootNode;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Typeface c() {
        return this.mTypeface;
    }

    @VisibleForTesting
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void d(@NonNull EmojiMetadata emojiMetadata) {
        boolean z11;
        Preconditions.checkNotNull(emojiMetadata, "emoji metadata cannot be null");
        if (emojiMetadata.getCodepointsLength() > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkArgument(z11, "invalid metadata codepoint length");
        this.mRootNode.c(emojiMetadata, 0, emojiMetadata.getCodepointsLength() - 1);
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public char[] getEmojiCharArray() {
        return this.mEmojiCharArray;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public MetadataList getMetadataList() {
        return this.mMetadataList;
    }

    @NonNull
    public static MetadataRepo create(@NonNull Typeface typeface, @NonNull InputStream inputStream) throws IOException {
        try {
            TraceCompat.beginSection(S_TRACE_CREATE_REPO);
            return new MetadataRepo(typeface, MetadataListReader.b(inputStream));
        } finally {
            TraceCompat.endSection();
        }
    }

    @NonNull
    public static MetadataRepo create(@NonNull Typeface typeface, @NonNull ByteBuffer byteBuffer) throws IOException {
        try {
            TraceCompat.beginSection(S_TRACE_CREATE_REPO);
            return new MetadataRepo(typeface, MetadataListReader.c(byteBuffer));
        } finally {
            TraceCompat.endSection();
        }
    }

    @NonNull
    public static MetadataRepo create(@NonNull AssetManager assetManager, @NonNull String str) throws IOException {
        try {
            TraceCompat.beginSection(S_TRACE_CREATE_REPO);
            return new MetadataRepo(Typeface.createFromAsset(assetManager, str), MetadataListReader.a(assetManager, str));
        } finally {
            TraceCompat.endSection();
        }
    }
}
