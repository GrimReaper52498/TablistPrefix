package me.GrimReaper52498.TablistPrefix.teams;

import me.GrimReaper52498.TablistPrefix.TablistPrefix;
import org.bukkit.ChatColor;

import java.util.logging.Level;

/**
 * Created by GrimReaper52498 on 6/4/2015.
 */
public class Teams
{

    private TablistPrefix pl;

    public Teams(TablistPrefix pl)
    {
	this.pl = pl;
    }

    public void registerTeams()
    {
	//Register team if not already registered
	pl.owner = pl.sb.getTeam("OWNER") == null ? pl.sb.registerNewTeam("OWNER") : pl.sb.getTeam("OWNER");
	pl.coowner = pl.sb.getTeam("COOWNER") == null ? pl.sb.registerNewTeam("COOWNER") : pl.sb.getTeam("COOWNER");
	pl.hadmin = pl.sb.getTeam("HADMIN") == null ? pl.sb.registerNewTeam("HADMIN") : pl.sb.getTeam("HADMIN");
	pl.admin = pl.sb.getTeam("ADMIN") == null ? pl.sb.registerNewTeam("ADMIN") : pl.sb.getTeam("ADMIN");
	pl.hmod = pl.sb.getTeam("HMOD") == null ? pl.sb.registerNewTeam("HMOD") : pl.sb.getTeam("HMOD");
	pl.mod = pl.sb.getTeam("MOD") == null ? pl.sb.registerNewTeam("MOD") : pl.sb.getTeam("MOD");
	pl.helper = pl.sb.getTeam("HELPER") == null ? pl.sb.registerNewTeam("HELPER") : pl.sb.getTeam("HELPER");
	pl.builder = pl.sb.getTeam("BUILDER") == null ? pl.sb.registerNewTeam("BUILDER") : pl.sb.getTeam("BUILDER");
	pl.developer = pl.sb.getTeam("DEVELOPER") == null ? pl.sb.registerNewTeam("DEVELOPER") : pl.sb.getTeam("DEVELOPER");
	pl.def = pl.sb.getTeam("DEFAULT") == null ? pl.sb.registerNewTeam("DEFAULT") : pl.sb.getTeam("DEFAULT");
	pl.donor1 = pl.sb.getTeam("DONOR1") == null ? pl.sb.registerNewTeam("DONOR1") : pl.sb.getTeam("DONOR1");
	pl.donor2 = pl.sb.getTeam("DONOR2") == null ? pl.sb.registerNewTeam("DONOR2") : pl.sb.getTeam("DONOR2");
	pl.donor3 = pl.sb.getTeam("DONOR3") == null ? pl.sb.registerNewTeam("DONOR3") : pl.sb.getTeam("DONOR3");
	pl.donor4 = pl.sb.getTeam("DONOR4") == null ? pl.sb.registerNewTeam("DONOR4") : pl.sb.getTeam("DONOR4");
	pl.donor5 = pl.sb.getTeam("DONOR5") == null ? pl.sb.registerNewTeam("DONOR5") : pl.sb.getTeam("DONOR5");
	pl.donor6 = pl.sb.getTeam("DONOR6") == null ? pl.sb.registerNewTeam("DONOR6") : pl.sb.getTeam("DONOR6");
	pl.donor7 = pl.sb.getTeam("DONOR7") == null ? pl.sb.registerNewTeam("DONOR7") : pl.sb.getTeam("DONOR7");
	pl.donor8 = pl.sb.getTeam("DONOR8") == null ? pl.sb.registerNewTeam("DONOR8") : pl.sb.getTeam("DONOR8");
	pl.donor9 = pl.sb.getTeam("DONOR9") == null ? pl.sb.registerNewTeam("DONOR9") : pl.sb.getTeam("DONOR9");
	pl.donor10 = pl.sb.getTeam("DONOR10") == null ? pl.sb.registerNewTeam("DONOR10") : pl.sb.getTeam("DONOR10");

	pl.getLogger().log(Level.INFO, "Teams Registered.");
    }

    public void setPrefixesAndSuffixes()
    {
	//Grab the prefixes from the config and set them.
	pl.owner.setPrefix(ChatColor.translateAlternateColorCodes('&', pl.getConfig().getString("Owner")));
	pl.coowner.setPrefix(ChatColor.translateAlternateColorCodes('&', pl.getConfig().getString("CoOwner")));
	pl.hadmin.setPrefix(ChatColor.translateAlternateColorCodes('&', pl.getConfig().getString("HeadAdmin")));
	pl.admin.setPrefix(ChatColor.translateAlternateColorCodes('&', pl.getConfig().getString("Admin")));
	pl.hmod.setPrefix(ChatColor.translateAlternateColorCodes('&', pl.getConfig().getString("HeadMod")));
	pl.mod.setPrefix(ChatColor.translateAlternateColorCodes('&', pl.getConfig().getString("Mod")));
	pl.helper.setPrefix(ChatColor.translateAlternateColorCodes('&', pl.getConfig().getString("Helper")));
	pl.builder.setPrefix(ChatColor.translateAlternateColorCodes('&', pl.getConfig().getString("Builder")));
	pl.developer.setPrefix(ChatColor.translateAlternateColorCodes('&', pl.getConfig().getString("Developer")));
	pl.def.setPrefix(ChatColor.translateAlternateColorCodes('&', pl.getConfig().getString("Default")));
	pl.donor1.setPrefix(ChatColor.translateAlternateColorCodes('&', pl.getConfig().getString("Donor1")));
	pl.donor2.setPrefix(ChatColor.translateAlternateColorCodes('&', pl.getConfig().getString("Donor2")));
	pl.donor3.setPrefix(ChatColor.translateAlternateColorCodes('&', pl.getConfig().getString("Donor3")));
	pl.donor4.setPrefix(ChatColor.translateAlternateColorCodes('&', pl.getConfig().getString("Donor4")));
	pl.donor5.setPrefix(ChatColor.translateAlternateColorCodes('&', pl.getConfig().getString("Donor5")));
	pl.donor6.setPrefix(ChatColor.translateAlternateColorCodes('&', pl.getConfig().getString("Donor6")));
	pl.donor7.setPrefix(ChatColor.translateAlternateColorCodes('&', pl.getConfig().getString("Donor7")));
	pl.donor8.setPrefix(ChatColor.translateAlternateColorCodes('&', pl.getConfig().getString("Donor8")));
	pl.donor9.setPrefix(ChatColor.translateAlternateColorCodes('&', pl.getConfig().getString("Donor9")));
	pl.donor10.setPrefix(ChatColor.translateAlternateColorCodes('&', pl.getConfig().getString("Donor10")));

	//Same as above but for suffixes
	if (pl.getConfig().getBoolean("Use-Suffixes"))
	{
	    pl.owner.setSuffix(ChatColor.translateAlternateColorCodes('&', pl.getConfig().getString("Owner-Suffix")));
	    pl.coowner.setSuffix(ChatColor.translateAlternateColorCodes('&', pl.getConfig().getString("CoOwner-Suffix")));
	    pl.hadmin.setSuffix(ChatColor.translateAlternateColorCodes('&', pl.getConfig().getString("HeadAdmin-Suffix")));
	    pl.admin.setSuffix(ChatColor.translateAlternateColorCodes('&', pl.getConfig().getString("Admin-Suffix")));
	    pl.hmod.setSuffix(ChatColor.translateAlternateColorCodes('&', pl.getConfig().getString("HeadMod-Suffix")));
	    pl.mod.setSuffix(ChatColor.translateAlternateColorCodes('&', pl.getConfig().getString("Mod-Suffix")));
	    pl.helper.setSuffix(ChatColor.translateAlternateColorCodes('&', pl.getConfig().getString("Helper-Suffix")));
	    pl.builder.setSuffix(ChatColor.translateAlternateColorCodes('&', pl.getConfig().getString("Builder-Suffix")));
	    pl.developer.setSuffix(ChatColor.translateAlternateColorCodes('&', pl.getConfig().getString("Developer-Suffix")));
	    pl.def.setSuffix(ChatColor.translateAlternateColorCodes('&', pl.getConfig().getString("Default-Suffix")));
	    pl.donor1.setSuffix(ChatColor.translateAlternateColorCodes('&', pl.getConfig().getString("Donor1-Suffix")));
	    pl.donor2.setSuffix(ChatColor.translateAlternateColorCodes('&', pl.getConfig().getString("Donor2-Suffix")));
	    pl.donor3.setSuffix(ChatColor.translateAlternateColorCodes('&', pl.getConfig().getString("Donor3-Suffix")));
	    pl.donor4.setSuffix(ChatColor.translateAlternateColorCodes('&', pl.getConfig().getString("Donor4-Suffix")));
	    pl.donor5.setSuffix(ChatColor.translateAlternateColorCodes('&', pl.getConfig().getString("Donor5-Suffix")));
	    pl.donor6.setSuffix(ChatColor.translateAlternateColorCodes('&', pl.getConfig().getString("Donor6-Suffix")));
	    pl.donor7.setSuffix(ChatColor.translateAlternateColorCodes('&', pl.getConfig().getString("Donor7-Suffix")));
	    pl.donor8.setSuffix(ChatColor.translateAlternateColorCodes('&', pl.getConfig().getString("Donor8-Suffix")));
	    pl.donor9.setSuffix(ChatColor.translateAlternateColorCodes('&', pl.getConfig().getString("Donor9-Suffix")));
	    pl.donor9.setSuffix(ChatColor.translateAlternateColorCodes('&', pl.getConfig().getString("Donor9-Suffix")));
	    pl.donor10.setSuffix(ChatColor.translateAlternateColorCodes('&', pl.getConfig().getString("Donor10-Suffix")));

	}

	pl.getLogger().log(Level.INFO, "Prefixes & Suffixes Set.");
    }
}
