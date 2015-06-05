package me.GrimReaper52498.TablistPrefix.teams;

import me.GrimReaper52498.TablistPrefix.TablistPrefix;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Team;

import java.util.regex.Pattern;

/**
 * Created by GrimReaper52498 on 6/4/2015.
 */
public class Prefix
{

    private TablistPrefix pl;

    public Prefix(TablistPrefix pl)
    {
	this.pl = pl;
    }

    public void refreshPrefix()
    {
	//Loop through all online players and set them to the right group

	if (pl.vault && pl.getConfig().getBoolean("GetPermPrefixes"))
	{
	    for (Player p : Bukkit.getOnlinePlayers())
	    {
		permPrefixes(p);
	    }
	}
	else
	{
	    for (Player p : Bukkit.getOnlinePlayers())
	    {
		if (p.hasPermission("rank.owner"))
		{
		    pl.owner.addPlayer(p);
		}
		else if (p.hasPermission("rank.coowner"))
		{
		    pl.coowner.addPlayer(p);
		}
		else if (p.hasPermission("rank.hadmin"))
		{
		    pl.hadmin.addPlayer(p);
		}
		else if (p.hasPermission("rank.admin"))
		{
		    pl.admin.addPlayer(p);
		}
		else if (p.hasPermission("rank.hmod"))
		{
		    pl.hmod.addPlayer(p);
		}
		else if (p.hasPermission("rank.mod"))
		{
		    pl.mod.addPlayer(p);
		}
		else if (p.hasPermission("rank.helper"))
		{
		    pl.helper.addPlayer(p);
		}
		else if (p.hasPermission("rank.builder"))
		{
		    pl.builder.addPlayer(p);
		}
		else if (p.hasPermission("rank.developer"))
		{
		    pl.developer.addPlayer(p);
		}
		else if (p.hasPermission("rank.donor1"))
		{
		    pl.donor1.addPlayer(p);
		}
		else if (p.hasPermission("rank.donor2"))
		{
		    pl.donor2.addPlayer(p);
		}
		else if (p.hasPermission("rank.donor3"))
		{
		    pl.donor3.addPlayer(p);
		}
		else if (p.hasPermission("rank.donor4"))
		{
		    pl.donor4.addPlayer(p);
		}
		else if (p.hasPermission("rank.donor5"))
		{
		    pl.donor5.addPlayer(p);
		}
		else if (p.hasPermission("rank.donor6"))
		{
		    pl.donor6.addPlayer(p);
		}
		else if (p.hasPermission("rank.donor7"))
		{
		    pl.donor7.addPlayer(p);
		}
		else if (p.hasPermission("rank.donor8"))
		{
		    pl.donor8.addPlayer(p);
		}
		else if (p.hasPermission("rank.donor9"))
		{
		    pl.donor9.addPlayer(p);
		}
		else if (p.hasPermission("rank.donor10"))
		{
		    pl.donor10.addPlayer(p);
		}
		else
		{
		    pl.def.addPlayer(p);
		}
	    }
	}
    }

    public void permPrefixes(Player p)
    {
	Team playerPrefix = pl.sb.getTeam(p.getName()) == null ? pl.sb.registerNewTeam(p.getName()) : pl.sb.getTeam(p.getName());
	if (pl.chat.getPlayerPrefix(p).length() <= 16)
	{
	    if (pl.getConfig().getBoolean("ReplaceBrackets"))
	    {
		String prefix = pl.chat.getPlayerPrefix(p);
		String finalPrefix = ChatColor.translateAlternateColorCodes('&', replaceBrackets(prefix));
		playerPrefix.setPrefix(finalPrefix);
		if (pl.getConfig().getBoolean("Use-Suffixes"))
		{
		    if (pl.chat.getPlayerSuffix(p).length() <= 16)
		    {
			String suffix = pl.chat.getPlayerSuffix(p);
			String finalSuffix = ChatColor.translateAlternateColorCodes('&', replaceBrackets(suffix));
			playerPrefix.setSuffix(finalSuffix);
		    }
		    else
		    {
			String suffix = pl.chat.getPlayerSuffix(p);
			String finalSuffix = ChatColor.translateAlternateColorCodes('&', cutString(replaceBrackets(suffix)));
			playerPrefix.setSuffix(finalSuffix);
		    }
		}
		playerPrefix.addPlayer(p);
	    }
	    else
	    {
		String prefix = pl.chat.getPlayerPrefix(p);
		String finalPrefix = ChatColor.translateAlternateColorCodes('&', prefix);
		if (finalPrefix.length() > 16)
		{
		    playerPrefix.setPrefix(finalPrefix);
		}
		else
		{
		    playerPrefix.setPrefix(cutString(finalPrefix));
		}

		if (pl.getConfig().getBoolean("Use-Suffixes"))
		{
		    if (pl.chat.getPlayerSuffix(p).length() <= 16)
		    {
			String suffix = pl.chat.getPlayerSuffix(p);
			String finalSuffix = ChatColor.translateAlternateColorCodes('&', suffix);
			playerPrefix.setSuffix(finalSuffix);
		    }
		    else
		    {
			String suffix = pl.chat.getPlayerSuffix(p);
			String finalSuffix = ChatColor.translateAlternateColorCodes('&', cutString(suffix));
			playerPrefix.setSuffix(finalSuffix);
		    }
		}
		playerPrefix.addPlayer(p);
	    }
	}
	else
	{
	    if (pl.getConfig().getBoolean("ReplaceBrackets"))
	    {
		String prefix = pl.chat.getPlayerPrefix(p);
		String finalPrefix = ChatColor.translateAlternateColorCodes('&', replaceBrackets(prefix));
		if (finalPrefix.length() <= 16)
		{
		    playerPrefix.setPrefix(finalPrefix);
		}
		else
		{
		    playerPrefix.setPrefix(cutString(finalPrefix));
		}
		if (pl.getConfig().getBoolean("Use-Suffixes"))
		{

		    String suffix = pl.chat.getPlayerSuffix(p);
		    String finalSuffix = ChatColor.translateAlternateColorCodes('&', replaceBrackets(suffix));
		    if (pl.chat.getPlayerSuffix(p).length() <= 16)
		    {
			playerPrefix.setSuffix(finalSuffix);
		    }
		    else
		    {
			playerPrefix.setSuffix(cutString(finalSuffix));
		    }
		}
		playerPrefix.addPlayer(p);
	    }
	    else
	    {
		Bukkit.getConsoleSender().sendMessage("[TabPrefix] Looks like your defined prefixes aren't 16 characters or less!");
	    }
	}
    }

    public String replaceBrackets(String toReplace)
    {
	String prefix1 = toReplace.replace("<", "").replace(">", "");
	String prefix2 = prefix1.replace("[", "").replace("]", "");
	String prefix3 = prefix2.replace("(", "").replace(")", "");
	String prefix4 = prefix3.replace("{", "").replace("}", "");
	return ChatColor.translateAlternateColorCodes('&', prefix4);
    }

    public String getFirstLetter(String string)
    {
	final Pattern pat = Pattern.compile("^[abcdefghijklmnopqrstuvwxyz]");
	String toReturn = "";

	if (pat.matcher(string).find())
	{
	    toReturn = String.valueOf(string.charAt(0));
	}
	else if (string.charAt(0) == '[')
	{
	    toReturn = "[" + String.valueOf(string.charAt(1)).toUpperCase() + "]";
	}
	else if (string.charAt(0) == '<')
	{
	    toReturn = "<" + String.valueOf(string.charAt(1)).toUpperCase() + ">";
	}
	else if (string.charAt(0) == '(')
	{
	    toReturn = "(" + String.valueOf(string.charAt(1)).toUpperCase() + ")";
	}
	else if (string.charAt(0) == '{')
	{
	    toReturn = "{" + String.valueOf(string.charAt(1)).toUpperCase() + "}";
	}

	return toReturn;
    }

    public String cutString(String string)
    {
	if (string.length() > 16)
	{
	    string = string.substring(0, 15);
	}
	return string;
    }

}
