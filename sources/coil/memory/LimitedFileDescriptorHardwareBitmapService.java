package coil.memory;

import androidx.annotation.WorkerThread;
import coil.size.PixelSize;
import coil.size.Size;
import coil.util.Logger;
import com.talabat.darkstores.common.bindingAdapters.BindingAdaptersKt;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0003R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcoil/memory/LimitedFileDescriptorHardwareBitmapService;", "Lcoil/memory/HardwareBitmapService;", "()V", "FILE_DESCRIPTOR_CHECK_INTERVAL", "", "FILE_DESCRIPTOR_LIMIT", "MIN_SIZE_DIMENSION", "TAG", "", "decodesSinceLastFileDescriptorCheck", "fileDescriptorList", "Ljava/io/File;", "hasAvailableFileDescriptors", "", "allowHardware", "size", "Lcoil/size/Size;", "logger", "Lcoil/util/Logger;", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
final class LimitedFileDescriptorHardwareBitmapService extends HardwareBitmapService {
    private static final int FILE_DESCRIPTOR_CHECK_INTERVAL = 50;
    private static final int FILE_DESCRIPTOR_LIMIT = 750;
    @NotNull
    public static final LimitedFileDescriptorHardwareBitmapService INSTANCE = new LimitedFileDescriptorHardwareBitmapService();
    private static final int MIN_SIZE_DIMENSION = 75;
    @NotNull
    private static final String TAG = "LimitedFileDescriptorHardwareBitmapService";
    private static volatile int decodesSinceLastFileDescriptorCheck;
    @NotNull
    private static final File fileDescriptorList = new File("/proc/self/fd");
    private static volatile boolean hasAvailableFileDescriptors = true;

    private LimitedFileDescriptorHardwareBitmapService() {
        super((DefaultConstructorMarker) null);
    }

    @WorkerThread
    private final synchronized boolean hasAvailableFileDescriptors(Logger logger) {
        int i11 = decodesSinceLastFileDescriptorCheck;
        decodesSinceLastFileDescriptorCheck = i11 + 1;
        if (i11 >= 50) {
            boolean z11 = false;
            decodesSinceLastFileDescriptorCheck = 0;
            String[] list = fileDescriptorList.list();
            if (list == null) {
                list = new String[0];
            }
            int length = list.length;
            if (length < FILE_DESCRIPTOR_LIMIT) {
                z11 = true;
            }
            hasAvailableFileDescriptors = z11;
            if (!hasAvailableFileDescriptors) {
                if (logger != null) {
                    if (logger.getLevel() <= 5) {
                        logger.log(TAG, 5, Intrinsics.stringPlus("Unable to allocate more hardware bitmaps. Number of used file descriptors: ", Integer.valueOf(length)), (Throwable) null);
                    }
                }
            }
        }
        return hasAvailableFileDescriptors;
    }

    public boolean allowHardware(@NotNull Size size, @Nullable Logger logger) {
        Intrinsics.checkNotNullParameter(size, BindingAdaptersKt.QUERY_SIZE);
        if (size instanceof PixelSize) {
            PixelSize pixelSize = (PixelSize) size;
            if (pixelSize.getWidth() < 75 || pixelSize.getHeight() < 75) {
                return false;
            }
        }
        return hasAvailableFileDescriptors(logger);
    }
}
