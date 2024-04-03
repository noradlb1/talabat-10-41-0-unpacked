package com.talabat.helpcenter.presentation.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import androidx.core.content.FileProvider;
import com.talabat.talabatcommon.utils.DateUtils;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.bytebuddy.utility.JavaConstant;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/talabat/helpcenter/presentation/utils/GlobalHelpCenterImageUtils;", "", "()V", "Companion", "com_talabat_NewArchi_TalabatHelpCenter_TalabatHelpCenter"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GlobalHelpCenterImageUtils {
    @NotNull
    private static final String AUTHORITY = "com.talabat.fileprovider";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String DATE_PATTERN = "yyyyMMdd_HHmmss";
    @NotNull
    private static final String FILE_PATH_PREFIX = "file:";
    @NotNull
    private static final String GALLERY_TYPE = "image/*";
    @NotNull
    private static final String IMAGE_NAME_PREFIX = "JPEG_";
    @NotNull
    private static final String IMAGE_SUFFIX = ".jpg";

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rJ\u001c\u0010\u000e\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0004\u0012\u00020\u00040\u000f2\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u0011\u001a\u00020\u0010R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/talabat/helpcenter/presentation/utils/GlobalHelpCenterImageUtils$Companion;", "", "()V", "AUTHORITY", "", "DATE_PATTERN", "FILE_PATH_PREFIX", "GALLERY_TYPE", "IMAGE_NAME_PREFIX", "IMAGE_SUFFIX", "createTempImageFile", "Ljava/io/File;", "context", "Landroid/content/Context;", "getCameraIntentAndImagePath", "Lkotlin/Pair;", "Landroid/content/Intent;", "getContentSelectionIntent", "com_talabat_NewArchi_TalabatHelpCenter_TalabatHelpCenter"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final File createTempImageFile(@NotNull Context context) throws IOException {
            Intrinsics.checkNotNullParameter(context, "context");
            String convertFromDateToString = DateUtils.Companion.convertFromDateToString(new Date(), "yyyyMMdd_HHmmss");
            return File.createTempFile(GlobalHelpCenterImageUtils.IMAGE_NAME_PREFIX + convertFromDateToString + JavaConstant.Dynamic.DEFAULT_NAME, ".jpg", context.getExternalFilesDir(Environment.DIRECTORY_PICTURES));
        }

        @NotNull
        public final Pair<Intent, String> getCameraIntentAndImagePath(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
            String str = "";
            if (intent.resolveActivity(context.getPackageManager()) != null) {
                intent.putExtra("PhotoPath", str);
                File createTempImageFile = createTempImageFile(context);
                if (createTempImageFile != null) {
                    str = GlobalHelpCenterImageUtils.FILE_PATH_PREFIX + createTempImageFile.getAbsolutePath();
                    intent.putExtra("output", FileProvider.getUriForFile(context, GlobalHelpCenterImageUtils.AUTHORITY, createTempImageFile));
                } else {
                    intent = null;
                }
            }
            return new Pair<>(intent, str);
        }

        @NotNull
        public final Intent getContentSelectionIntent() {
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.addCategory("android.intent.category.OPENABLE");
            intent.setType(GlobalHelpCenterImageUtils.GALLERY_TYPE);
            return intent;
        }
    }

    private GlobalHelpCenterImageUtils() {
    }
}
