package com.pichillilorenzo.flutter_inappwebview.types;

public class PluginScript extends UserScript {
    private boolean requiredInAllContentWorlds;

    public PluginScript(String str, String str2, UserScriptInjectionTime userScriptInjectionTime, ContentWorld contentWorld, boolean z11) {
        super(str, str2, userScriptInjectionTime, contentWorld);
        this.requiredInAllContentWorlds = z11;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        return this.requiredInAllContentWorlds == ((PluginScript) obj).requiredInAllContentWorlds;
    }

    public int hashCode() {
        return (super.hashCode() * 31) + (this.requiredInAllContentWorlds ? 1 : 0);
    }

    public boolean isRequiredInAllContentWorlds() {
        return this.requiredInAllContentWorlds;
    }

    public void setRequiredInAllContentWorlds(boolean z11) {
        this.requiredInAllContentWorlds = z11;
    }

    public String toString() {
        return "PluginScript{requiredInContentWorld=" + this.requiredInAllContentWorlds + "} " + super.toString();
    }
}
