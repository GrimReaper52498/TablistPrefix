package me.GrimReaper52498.TablistPrefix.events;

import me.GrimReaper52498.TablistPrefix.TablistPrefix;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * Created by GrimReaper52498 on 6/4/2015.
 */
public class OnJoin implements Listener
{

    private TablistPrefix pl;

    public OnJoin(TablistPrefix pl){
	this.pl = pl;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e)
    {
	pl.prefix.refreshPrefix();
	e.getPlayer().setScoreboard(pl.sb);
    }

}
