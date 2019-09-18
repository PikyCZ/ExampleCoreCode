package cz.pikyxos.core.commands;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.utils.TextFormat;
import cz.pikyxos.core.Core;

public class LobbyCommand extends Command {

    public LobbyCommand(String name) {
        super(name, "Teleport you to the server Lobby", "/lobby");
    }

    @Override
    public boolean execute(CommandSender cs, String string, String[] strings) {
        Player p = (Player) cs;
        if (cs instanceof Player) {
            if (cs.hasPermission("core.lobby")) {
                p.teleport(Core.getInstance().getServer().getDefaultLevel().getSafeSpawn());
                p.sendActionBar(TextFormat.YELLOW + " You have been teleported to Lobby");
            } else {
                cs.sendMessage(TextFormat.RED + " You don´t have permisions!");
            }
        } else {
            cs.sendMessage(Core.getPrefix() + TextFormat.RED + " You can only use in-game!");
        }
        return true;
    }
}