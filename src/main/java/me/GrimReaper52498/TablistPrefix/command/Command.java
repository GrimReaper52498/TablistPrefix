package me.GrimReaper52498.TablistPrefix.command;

import me.GrimReaper52498.TablistPrefix.TablistPrefix;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by GrimReaper52498 on 6/4/2015.
 */
public class Command implements CommandExecutor
{

    private TablistPrefix pl;

    public Command(TablistPrefix pl)
    {
	this.pl = pl;
    }

    public boolean onCommand(CommandSender sender, org.bukkit.command.Command cmd, String label, String[] args)
    {
	if (cmd.getName().equalsIgnoreCase("tabprefix"))
	{
	    if (sender instanceof Player)
	    {
		Player p = (Player) sender;
		if (args.length < 1)
		{
		    p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8&m-&c&m=&8&m-&c&m=&8&m&m-&c&m=&8&m-&c&m=&8&m-&c&m=&8&m-&c&m=&8&m-&c&m=&8&m-&c&m=&8&m-&c&m=&8&m-&c&m=&8&m-&c&m=&8&m-&c&m=&8&m-&c&m=&8&m-&c&m=&8&m-&c&m=&8&m-&c&m=&8&m-&c&m=&8&m-&c&m=&8&m-&c&m=&8&m-&c&m=&8&m-&c&m=&8&m-&c&m=&8&m-&c&m=&8&m-&c&m=&8&m-&c&m=&8&m-&c&m=&8&m-"));
		    p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&lAuthor: &7GrimReaper52498"));
		    p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&lIdea By: &7KevFive"));
		    p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&lVersion: &7" + pl.getDescription().getVersion()));
		    if (p.hasPermission("tabprefix.admin"))
		    {
			p.sendMessage("");
			p.sendMessage(ChatColor.translateAlternateColorCodes('&', "               &c&lCommands &b&l- &7&lHover over each for details"));
			p.sendMessage("");
//			new FancyMessage("/tabprefix reload").color(ChatColor.AQUA).style(ChatColor.BOLD).tooltip(ChatColor.translateAlternateColorCodes('&', "Reloads the config.")).send(p);
		    }
		    p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8&m-&c&m=&8&m-&c&m=&8&m&m-&c&m=&8&m-&c&m=&8&m-&c&m=&8&m-&c&m=&8&m-&c&m=&8&m-&c&m=&8&m-&c&m=&8&m-&c&m=&8&m-&c&m=&8&m-&c&m=&8&m-&c&m=&8&m-&c&m=&8&m-&c&m=&8&m-&c&m=&8&m-&c&m=&8&m-&c&m=&8&m-&c&m=&8&m-&c&m=&8&m-&c&m=&8&m-&c&m=&8&m-&c&m=&8&m-&c&m=&8&m-&c&m=&8&m-&c&m=&8&m-"));
		}
		else
		{
		    if (args.length == 1)
		    {
			if (args[0].equalsIgnoreCase("reload"))
			{
			    if (p.hasPermission("tabprefix.admin"))
			    {
				pl.reloadConfig();
				pl.prefix.refreshPrefix();
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8&l[&c&lTabPrefix&8&l] &a&lConfiguration reloaded."));
			    }
			    else
			    {
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8&l[&c&lTabPrefix&8&l] &c&lYou don't have permission for this."));

			    }
			}
			else
			{
			    p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8&l[&c&lTabPrefix&8&l] &c&lUnknown command."));
			}
		    }
		    else
		    {
			p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8&l[&c&lTabPrefix&8&l] &c&lUnknown command."));
		    }
		}

	    }
	    else
	    {
		if (args.length < 1)
		{
		    sender.sendMessage("Correct usage: /tabprefix reload");
		}
		else
		{
		    if (args.length == 1)
		    {
			if (args[0].equalsIgnoreCase("reload"))
			{
			    pl.reloadConfig();
			    pl.prefix.refreshPrefix();
			    sender.sendMessage("[TabPrefix] Configuration reloaded.");
			}
		    }
		}

	    }
	}
	return false;
    }
}

