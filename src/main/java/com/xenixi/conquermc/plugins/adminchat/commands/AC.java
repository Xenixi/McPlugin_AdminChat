package com.xenixi.conquermc.plugins.adminchat.commands;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class AC extends Command {

	public AC() {
		super("AC");
	}

	@SuppressWarnings("deprecation") // should probably switch this out later
	public void execute(CommandSender sender, String[] args) {
		if (sender instanceof ProxiedPlayer) {
			if(sender.hasPermission("adminchat.access")) {
			ProxiedPlayer player = (ProxiedPlayer) sender;
			if (args.length > 0) {
				StringBuilder sb = new StringBuilder();
				for (String s : args) {
					sb.append(s);
					sb.append(" ");
				}
				
				
				for(ProxiedPlayer p : ProxyServer.getInstance().getPlayers()) {
					if(p.hasPermission("adminchat.access")) {
					p.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.DARK_RED + "AC - " + ChatColor.BLUE
							+ ChatColor.BOLD + player.getServer().getInfo().getName() + ChatColor.DARK_GRAY + "] "
							+ ChatColor.DARK_AQUA + player.getDisplayName() + ": " + ChatColor.GREEN + sb.toString());
					}
					
				}
			}
		} else {
			sender.sendMessage(ChatColor.DARK_RED + "You have not been granted access to this command!");
		}
		} else {

			sender.sendMessage(ChatColor.RED + "AdminChat: " + "Command must be executed by a player!");
		}
	}

}
