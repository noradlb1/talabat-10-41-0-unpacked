package kotlin.io.path;

import java.nio.file.FileVisitOption;
import java.nio.file.LinkOption;
import java.util.Set;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0019\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\r\u001a\u00020\u000eR\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lkotlin/io/path/LinkFollowing;", "", "()V", "followLinkOption", "", "Ljava/nio/file/LinkOption;", "[Ljava/nio/file/LinkOption;", "followVisitOption", "", "Ljava/nio/file/FileVisitOption;", "nofollowLinkOption", "nofollowVisitOption", "toLinkOptions", "followLinks", "", "(Z)[Ljava/nio/file/LinkOption;", "toVisitOptions", "kotlin-stdlib-jdk7"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class LinkFollowing {
    @NotNull
    public static final LinkFollowing INSTANCE = new LinkFollowing();
    @NotNull
    private static final LinkOption[] followLinkOption = new LinkOption[0];
    @NotNull
    private static final Set<FileVisitOption> followVisitOption = SetsKt__SetsJVMKt.setOf(FileVisitOption.FOLLOW_LINKS);
    @NotNull
    private static final LinkOption[] nofollowLinkOption = {LinkOption.NOFOLLOW_LINKS};
    @NotNull
    private static final Set<FileVisitOption> nofollowVisitOption = SetsKt__SetsKt.emptySet();

    private LinkFollowing() {
    }

    @NotNull
    public final LinkOption[] toLinkOptions(boolean z11) {
        return z11 ? followLinkOption : nofollowLinkOption;
    }

    @NotNull
    public final Set<FileVisitOption> toVisitOptions(boolean z11) {
        return z11 ? followVisitOption : nofollowVisitOption;
    }
}
