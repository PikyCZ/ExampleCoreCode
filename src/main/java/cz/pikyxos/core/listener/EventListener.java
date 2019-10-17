package cz.pikyxos.core.listener;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerInvalidMoveEvent;
import cn.nukkit.event.player.PlayerJoinEvent;

public class EventListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        /*For example check for player if is on server first time*/
        if(player.playedBefore)
            player.sendMessage("Welcome back " + player.getName());
        else
            player.sendMessage("Welcome on ..." + player.getName());

        e.setJoinMessage("");
    }

    @EventHandler
    public void onMove(PlayerInvalidMoveEvent e) {
        e.setCancelled();
    }

}
