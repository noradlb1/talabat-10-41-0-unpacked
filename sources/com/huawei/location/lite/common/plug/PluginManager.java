package com.huawei.location.lite.common.plug;

import java.util.List;

public class PluginManager {
    private PluginServiceLoader<IPlugin> pluginServiceLoader;

    public static final class PluginManagerHolder {
        /* access modifiers changed from: private */
        public static final PluginManager PLUGIN_MANAGER = new PluginManager();

        private PluginManagerHolder() {
        }
    }

    private PluginManager() {
        this.pluginServiceLoader = PluginServiceLoader.load(IPlugin.class);
    }

    public static PluginManager getInstance() {
        return PluginManagerHolder.PLUGIN_MANAGER;
    }

    public <T extends PluginRespResult> T startFunction(int i11, String str, PluginReqMessage pluginReqMessage) {
        List<IPlugin> loadService = this.pluginServiceLoader.loadService(i11);
        return loadService.isEmpty() ? new PluginRespResult() : loadService.get(0).startFunction(str, pluginReqMessage);
    }

    public <T extends PluginRespResult> void startFunction(int i11, String str, PluginReqMessage pluginReqMessage, IPluginResult<T> iPluginResult) {
        List<IPlugin> loadService = this.pluginServiceLoader.loadService(i11);
        if (!loadService.isEmpty()) {
            for (IPlugin startFunction : loadService) {
                startFunction.startFunction(str, pluginReqMessage, iPluginResult);
            }
        }
    }

    public <T extends PluginRespResult> void startFunction(String str, PluginReqMessage pluginReqMessage, IPluginResult<T> iPluginResult) {
        for (Integer intValue : this.pluginServiceLoader.getPlugins()) {
            List<IPlugin> loadService = this.pluginServiceLoader.loadService(intValue.intValue());
            if (!loadService.isEmpty()) {
                for (IPlugin startFunction : loadService) {
                    startFunction.startFunction(str, pluginReqMessage, iPluginResult);
                }
            } else {
                return;
            }
        }
    }
}
