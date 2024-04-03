package com.instabug.library.core.plugin;

import androidx.annotation.Nullable;
import com.instabug.library.core.plugin.PluginPromptOption;
import java.util.Iterator;

public abstract class d {
    @Nullable
    public static PluginPromptOption a(@PluginPromptOption.PromptOptionIdentifier int i11, boolean z11) {
        Iterator it = c.a(z11).iterator();
        while (it.hasNext()) {
            PluginPromptOption pluginPromptOption = (PluginPromptOption) it.next();
            if (pluginPromptOption.getPromptOptionIdentifier() == i11) {
                return pluginPromptOption;
            }
        }
        return null;
    }
}
