package kotlin.reflect.jvm.internal.impl.platform;

import org.jetbrains.annotations.NotNull;

public abstract class SimplePlatform {
    @NotNull
    private final String platformName;
    @NotNull
    private final TargetPlatformVersion targetPlatformVersion;

    @NotNull
    public String getTargetName() {
        return getTargetPlatformVersion().getDescription();
    }

    @NotNull
    public TargetPlatformVersion getTargetPlatformVersion() {
        return this.targetPlatformVersion;
    }

    @NotNull
    public String toString() {
        boolean z11;
        String targetName = getTargetName();
        if (targetName.length() > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            return this.platformName;
        }
        return this.platformName + " (" + targetName + ')';
    }
}
