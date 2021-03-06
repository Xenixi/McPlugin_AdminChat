package com.xenixi.conquermc.plugins.adminchat;

import com.xenixi.conquermc.plugins.adminchat.commands.AC;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Plugin;

public class AChat extends Plugin{
	@Override
	public void onEnable() {
		ProxyServer.getInstance().getPluginManager().registerCommand(this, new AC());
		
	}
	@Override
	public void onDisable() {
		
	}
	
}
