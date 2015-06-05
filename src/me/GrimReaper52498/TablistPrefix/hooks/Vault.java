package me.GrimReaper52498.TablistPrefix.hooks;

import me.GrimReaper52498.TablistPrefix.TablistPrefix;
import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.plugin.RegisteredServiceProvider;

/**
 * Created by GrimReaper52498 on 6/4/2015.
 */
public class Vault
{
    private TablistPrefix pl;

    public Vault(TablistPrefix pl){
	this.pl = pl;
    }

    public boolean setupPermissions()
    {
	RegisteredServiceProvider<Permission> permissionProvider = pl.getServer().getServicesManager().getRegistration(net.milkbowl.vault.permission.Permission.class);
	if (permissionProvider != null)
	{
	    pl.permission = permissionProvider.getProvider();
	}
	return (pl.permission != null);
    }

    public boolean setupChat()
    {
	RegisteredServiceProvider<Chat> chatProvider = pl.getServer().getServicesManager().getRegistration(net.milkbowl.vault.chat.Chat.class);
	if (chatProvider != null)
	{
	    pl.chat = chatProvider.getProvider();
	}
	return (pl.chat != null);
    }
}
