package me.GrimReaper52498.TablistPrefix;

import net.md_5.bungee.api.ChatColor;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import java.util.logging.Level;

/**
 * Created by GrimReaper52498 on 5/25/2015.
 */
public class TablistPrefix extends JavaPlugin implements Listener {
    private Scoreboard sb;
    private Objective obj;
    private boolean vault;
    private Team prefix;
    private Team owner;
    private Team coowner;
    private Team hadmin;
    private Team admin;
    private Team hmod;
    private Team mod;
    private Team helper;
    private Team builder;
    private Team developer;
    private Team def;
    private Team donor1;
    private Team donor2;
    private Team donor3;
    private Team donor4;
    private Team donor5;
    private Team donor6;
    private Team donor7;
    private Team donor8;
    private Team donor9;
    private Team donor10;


    private Permission permission = null;

    public void onEnable() {

        getConfig().options().copyDefaults(true);
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(this, this);

        //Register scoreboard and objective.

        sb = Bukkit.getScoreboardManager().getNewScoreboard();
        obj = sb.registerNewObjective("dummy", "begin");

        //Hook into vault if enabled
        if (getServer().getPluginManager().isPluginEnabled("Vault")) {
            getLogger().log(Level.INFO, "Vault found!.");
            vault = true;
            setupPermissions();
        } else {
            getLogger().log(Level.INFO, "Vault not found.");
            vault = false;
        }

        registerTeams();
        setPrefixes();

        //Start the task to refresh the prefixes every 300 seconds
        Bukkit.getScheduler().scheduleAsyncRepeatingTask(this, new BukkitRunnable() {
            @Override
            public void run() {
                refreshPrefix();
            }
        }, 0, 300 * 20);
    }

    public void onDisable() {
        saveDefaultConfig();
        Bukkit.getScheduler().cancelAllTasks();
    }

    private boolean setupPermissions() {
        RegisteredServiceProvider<Permission> permissionProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.permission.Permission.class);
        if (permissionProvider != null) {
            permission = permissionProvider.getProvider();
        }
        return (permission != null);
    }

    public void registerTeams() {
        //Register team if not already registered
        owner = sb.getTeam("OWNER") == null ? sb.registerNewTeam("OWNER") : sb.getTeam("OWNER");
        coowner = sb.getTeam("COOWNER") == null ? sb.registerNewTeam("COOWNER") : sb.getTeam("COOWNER");
        hadmin = sb.getTeam("HADMIN") == null ? sb.registerNewTeam("HADMIN") : sb.getTeam("HADMIN");
        admin = sb.getTeam("ADMIN") == null ? sb.registerNewTeam("ADMIN") : sb.getTeam("ADMIN");
        hmod = sb.getTeam("HMOD") == null ? sb.registerNewTeam("HMOD") : sb.getTeam("HMOD");
        mod = sb.getTeam("MOD") == null ? sb.registerNewTeam("MOD") : sb.getTeam("MOD");
        helper = sb.getTeam("HELPER") == null ? sb.registerNewTeam("HELPER") : sb.getTeam("HELPER");
        builder = sb.getTeam("BUILDER") == null ? sb.registerNewTeam("BUILDER") : sb.getTeam("BUILDER");
        developer = sb.getTeam("DEVELOPER") == null ? sb.registerNewTeam("DEVELOPER") : sb.getTeam("DEVELOPER");
        def = sb.getTeam("DEFAULT") == null ? sb.registerNewTeam("DEFAULT") : sb.getTeam("DEFAULT");
        donor1 = sb.getTeam("DONOR1") == null ? sb.registerNewTeam("DONOR1") : sb.getTeam("DONOR1");
        donor2 = sb.getTeam("DONOR2") == null ? sb.registerNewTeam("DONOR2") : sb.getTeam("DONOR2");
        donor3 = sb.getTeam("DONOR3") == null ? sb.registerNewTeam("DONOR3") : sb.getTeam("DONOR3");
        donor4 = sb.getTeam("DONOR4") == null ? sb.registerNewTeam("DONOR4") : sb.getTeam("DONOR4");
        donor5 = sb.getTeam("DONOR5") == null ? sb.registerNewTeam("DONOR5") : sb.getTeam("DONOR5");
        donor6 = sb.getTeam("DONOR6") == null ? sb.registerNewTeam("DONOR6") : sb.getTeam("DONOR6");
        donor7 = sb.getTeam("DONOR7") == null ? sb.registerNewTeam("DONOR7") : sb.getTeam("DONOR7");
        donor8 = sb.getTeam("DONOR8") == null ? sb.registerNewTeam("DONOR8") : sb.getTeam("DONOR8");
        donor9 = sb.getTeam("DONOR9") == null ? sb.registerNewTeam("DONOR9") : sb.getTeam("DONOR9");
        donor10 = sb.getTeam("DONOR10") == null ? sb.registerNewTeam("DONOR10") : sb.getTeam("DONOR10");

        getLogger().log(Level.INFO, "Teams Registered.");
    }

    public void setPrefixes() {
        //Grab the prefixes from the config and set them.
        owner.setPrefix(ChatColor.translateAlternateColorCodes('&', getConfig().getString("Owner")));
        coowner.setPrefix(ChatColor.translateAlternateColorCodes('&', getConfig().getString("CoOwner")));
        hadmin.setPrefix(ChatColor.translateAlternateColorCodes('&', getConfig().getString("HeadAdmin")));
        admin.setPrefix(ChatColor.translateAlternateColorCodes('&', getConfig().getString("Admin")));
        hmod.setPrefix(ChatColor.translateAlternateColorCodes('&', getConfig().getString("HeadMod")));
        mod.setPrefix(ChatColor.translateAlternateColorCodes('&', getConfig().getString("Mod")));
        helper.setPrefix(ChatColor.translateAlternateColorCodes('&', getConfig().getString("Helper")));
        builder.setPrefix(ChatColor.translateAlternateColorCodes('&', getConfig().getString("Builder")));
        developer.setPrefix(ChatColor.translateAlternateColorCodes('&', getConfig().getString("Developer")));
        def.setPrefix(ChatColor.translateAlternateColorCodes('&', getConfig().getString("Default")));
        donor1.setPrefix(ChatColor.translateAlternateColorCodes('&', getConfig().getString("Donor1")));
        donor2.setPrefix(ChatColor.translateAlternateColorCodes('&', getConfig().getString("Donor2")));
        donor3.setPrefix(ChatColor.translateAlternateColorCodes('&', getConfig().getString("Donor3")));
        donor4.setPrefix(ChatColor.translateAlternateColorCodes('&', getConfig().getString("Donor4")));
        donor5.setPrefix(ChatColor.translateAlternateColorCodes('&', getConfig().getString("Donor5")));
        donor6.setPrefix(ChatColor.translateAlternateColorCodes('&', getConfig().getString("Donor6")));
        donor7.setPrefix(ChatColor.translateAlternateColorCodes('&', getConfig().getString("Donor7")));
        donor8.setPrefix(ChatColor.translateAlternateColorCodes('&', getConfig().getString("Donor8")));
        donor9.setPrefix(ChatColor.translateAlternateColorCodes('&', getConfig().getString("Donor9")));
        donor10.setPrefix(ChatColor.translateAlternateColorCodes('&', getConfig().getString("Donor10")));


        getLogger().log(Level.INFO, "Prefixes Set.");
    }

    //No use as of right now. Still a WIP.
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player pl = e.getPlayer();
        if (!(vault) || !(getConfig().getBoolean("GetPermPrefixes"))) {
            refreshPrefix();
        } else {
            int online = Bukkit.getOnlinePlayers().size();

            for (int i = 0; i < online; i++) {

            }
        }
        pl.setScoreboard(sb);
    }

    public void refreshPrefix() {
        //Loop through all online players and set them to the right group
        for (Player p : Bukkit.getOnlinePlayers()) {
            if (p.hasPermission("rank.owner")) {
                owner.addPlayer(p);
            } else if (p.hasPermission("rank.coowner")) {
                coowner.addPlayer(p);
            } else if (p.hasPermission("rank.hadmin")) {
                hadmin.addPlayer(p);
            } else if (p.hasPermission("rank.admin")) {
                admin.addPlayer(p);
            } else if (p.hasPermission("rank.hmod")) {
                hmod.addPlayer(p);
            } else if (p.hasPermission("rank.mod")) {
                mod.addPlayer(p);
            } else if (p.hasPermission("rank.helper")) {
                helper.addPlayer(p);
            } else if (p.hasPermission("rank.builder")) {
                builder.addPlayer(p);
            } else if (p.hasPermission("rank.developer")) {
                developer.addPlayer(p);
            } else if (p.hasPermission("rank.donor1")) {
                donor1.addPlayer(p);
            } else if (p.hasPermission("rank.donor2")) {
                donor2.addPlayer(p);
            } else if (p.hasPermission("rank.donor3")) {
                donor3.addPlayer(p);
            } else if (p.hasPermission("rank.donor4")) {
                donor4.addPlayer(p);
            } else if (p.hasPermission("rank.donor5")) {
                donor5.addPlayer(p);
            } else if (p.hasPermission("rank.donor6")) {
                donor6.addPlayer(p);
            } else if (p.hasPermission("rank.donor7")) {
                donor7.addPlayer(p);
            } else if (p.hasPermission("rank.donor8")) {
                donor8.addPlayer(p);
            } else if (p.hasPermission("rank.donor9")) {
                donor9.addPlayer(p);
            } else if (p.hasPermission("rank.donor10")) {
                donor10.addPlayer(p);
            } else {
                def.addPlayer(p);
            }
        }
    }
}
