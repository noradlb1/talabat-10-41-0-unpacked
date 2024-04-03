package io.flutter.embedding.engine.dart;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.nio.ByteBuffer;

public interface PlatformMessageHandler {
    void handleMessageFromDart(@NonNull String str, @Nullable ByteBuffer byteBuffer, int i11, long j11);

    void handlePlatformMessageResponse(int i11, @Nullable ByteBuffer byteBuffer);
}
