package me.GrimReaper52498.TablistPrefix;

import me.GrimReaper52498.TablistPrefix.command.Command;
import me.GrimReaper52498.TablistPrefix.events.OnJoin;
import me.GrimReaper52498.TablistPrefix.hooks.Vault;
import me.GrimReaper52498.TablistPrefix.teams.Prefix;
import me.GrimReaper52498.TablistPrefix.teams.Teams;
import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import java.util.logging.Level;

/**
 * Created by GrimReaper52498 on 5/25/2015.
 */
public class TablistPrefix extends JavaPlugin implements Listener
{
    public Scoreboard sb;
    public Objective obj;
    public boolean vault;
    public Team owner;
    public Team coowner;
    public Team hadmin;
    public Team admin;
    public Team hmod;
    public Team mod;
    public Team helper;
    public Team builder;
    public Team developer;
    public Team def;
    public Team donor1;
    public Team donor2;
    public Team donor3;
    public Team donor4;
    public Team donor5;
    public Team donor6;
    public Team donor7;
    public Team donor8;
    public Team donor9;
    public Team donor10;

    public Permission permission = null;
    public Chat chat = null;

    public Teams teams = null;
    public Prefix prefix = null;
    public Vault vth = null;

    public void onEnable()
    {

	getConfig().options().copyDefaults(true);
	saveDefaultConfig();
	getServer().getPluginManager().registerEvents(this, this);

	//Register scoreboard and objective.

	sb = Bukkit.getScoreboardManager().getNewScoreboard();
	obj = sb.registerNewObjective("dummy", "begin");

	//Hook into vault if enabled
	if (getServer().getPluginManager().isPluginEnabled("Vault"))
	{
	    getLogger().log(Level.INFO, "Vault found!.");
	    vault = true;
	    vth = new Vault(this);
	    if(vth != null){
		vth.setupPermissions();
		vth.setupChat();
	    }
	}
	else
	{
	    getLogger().log(Level.INFO, "Vault not found.");
	    vault = false;
	}

	//Register OnJoinEvent
        getServer().getPluginManager().registerEvents(new OnJoin(this), this);
	//Register Command
	getCommand("tabprefix").setExecutor(new Command(this));
	//Set teames = Teams and if its not null then register them and set prefixes/suffixes
	teams = new Teams(this);
	if (teams != null)
	{
	    teams.registerTeams();
	    teams.setPrefixesAndSuffixes();

	}

	//Set prefix = Prefix
	prefix = new Prefix(this);

	//Start the task to refresh the prefixes every 300 seconds
	Bukkit.getScheduler().scheduleAsyncRepeatingTask(this, new BukkitRunnable()
	{
	    @Override public void run()
	    {
		    prefix.refreshPrefix();
	    }
	}, 0, 300 * 20);
    }

    public void onDisable()
    {
	saveDefaultConfig();
	Bukkit.getScheduler().cancelAllTasks();
    }

}
