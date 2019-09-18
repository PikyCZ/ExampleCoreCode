package cz.pikyxos.core;

import cn.nukkit.permission.Permission;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.plugin.PluginManager;
import cz.pikyxos.core.commands.LobbyCommand;
import cz.pikyxos.core.listener.EventListener;
import lombok.Getter;

public class Core extends PluginBase {

    @Getter private static Core instance;

    @Getter private static String prefix = "§f[Core]";

    @Override
    public void onLoad(){
        instance = this;
        /*Getting Logger*/ getLogger().info("Loading");
    }

    @Override
    public void onEnable(){
        getLogger().info("Enabled");
        /*Getting Server in main class otherwise you use Core.getInstance().getServer() or Server.getInstance()*/
        /*Example*/
        int players = getServer().getOnlinePlayers().size();
        getLogger().info("players online: " + players);
        /*Example*/

        regEvents();
        regCommands();
        regPerm();
    }

    @Override
    public void onDisable(){
        getLogger().info("Disabling");
    }

    private void regEvents() {
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new EventListener(), this);

    }

    private void regCommands() {
        getServer().getCommandMap().register("lobby", new LobbyCommand("lobby"));

    }

    private void regPerm() {
        PluginManager perm = getServer().getPluginManager();
        perm.addPermission(new Permission("core.lobby"));
    }
}
