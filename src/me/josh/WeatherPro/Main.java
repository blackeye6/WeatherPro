package me.josh.WeatherPro;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

public class Main extends JavaPlugin {
	
	String prefix = ChatColor.DARK_GRAY + "[" + ChatColor.DARK_AQUA + "WeatherPro" + ChatColor.DARK_GRAY + "]";
	
	public void onEnable() {
		getLogger().info(getConfig().getName() + "By MinecraftJoshjr Has Been Enabled!");
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String CommandLabel, String[] args) {
		Player p = (Player)sender;
		    if (cmd.getName().equalsIgnoreCase("wt")) {
		    	if (p.hasPermission("wt.admin")) {
		    	    if (args.length == 0) {
		    		    p.sendMessage(ChatColor.GOLD + "-=-=-=-=-=-=- " + prefix + ChatColor.GOLD + " -=-=-=-=-=-=- ");
		    		    p.sendMessage(ChatColor.AQUA + "/wt on" + ChatColor.GREEN + "    Turn on auto day");
		    		    p.sendMessage(ChatColor.AQUA + "/wt off" + ChatColor.GREEN + "    Turn off auto day");
		    		    p.sendMessage(ChatColor.AQUA + "/wt set" + ChatColor.GREEN + "    Commands to change weather/time");
		    	        }
		            }
		        }
		    	if (args.length == 1) {
		    		if (args[0].equalsIgnoreCase("on")) {
		    			if (p.hasPermission("wt.admin")) {
		    			on(p);
		    			p.sendMessage(prefix + ChatColor.GREEN + " You have turned on auto day!");
		    		    }
		    	    }
		    	}
		    	if (args.length == 1) {
		    		if (args[0].equalsIgnoreCase("off")) {
		    			if (p.hasPermission("wt.admin")) {
		    			stopScheduler(this);
		    			p.sendMessage(prefix + ChatColor.GREEN + " You have turned off auto day!");
		    		    }
		    	    }
		    	}
		    	if (args.length == 1) {
		    		if (args[0].equalsIgnoreCase("set")) {
		    			if (p.hasPermission("wt.admin")) {
		    			p.sendMessage(ChatColor.GOLD + "-=-=-=-=-=- " + prefix + ChatColor.GOLD + " -=-=-=-=-=-");
		    			p.sendMessage(ChatColor.AQUA + "/wt set day" + ChatColor.GREEN + "    Set the time to day");
		    			p.sendMessage(ChatColor.AQUA + "/wt set night" + ChatColor.GREEN + "    Set the time to night");
		    			p.sendMessage(ChatColor.AQUA + "/wt set sun" + ChatColor.GREEN + "    Set the weather to sun");
		    			p.sendMessage(ChatColor.AQUA + "/wt set storm" + ChatColor.GREEN + "    Set the weather to storm");
		    		    }
		    	    }
		    	}
		    	if (args.length == 2) {
		    		if (args[0].equalsIgnoreCase("set")) {
		    			if (args[1].equalsIgnoreCase("day")) {
		    				if (p.hasPermission("wt.admin")) {
		    				p.getWorld().setTime(0);
		    				p.sendMessage(prefix + ChatColor.GREEN + " The time has been changed to day!");
		    			    }
		    		    }
		    	    }
		    	}
		    	if (args.length == 2) {
		    		if (args[0].equalsIgnoreCase("set")) {
		    			if (args[1].equalsIgnoreCase("night")) {
		    				if (p.hasPermission("wt.admin")) {
		    				p.getWorld().setTime(17000);
		    				p.sendMessage(prefix + ChatColor.GREEN + " The time has been changed to night!");
		    			    }
		    		    }
		    		}
		    	}
		    	if (args.length == 2) {
		    		if (args[0].equalsIgnoreCase("set")) {
		    			if (args[1].equalsIgnoreCase("storm")) {
		    				if (p.hasPermission("wt.admin")) {
		    				p.getWorld().setThundering(true);
		    				p.getWorld().setStorm(true);
		    				p.sendMessage(prefix + ChatColor.GREEN + " The weather has been changed to stormy!");
		    			    }
		    		    }
		    	    }
		    	}
		    	if (args.length == 2) {
		    		if (args[0].equalsIgnoreCase("set")) {
		    			if (args[1].equalsIgnoreCase("sun")) {
		    				if (p.hasPermission("wt.admin")) {
		    				p.getWorld().setThundering(false);
		    				p.getWorld().setStorm(false);
		    				p.sendMessage(prefix + ChatColor.GREEN + " The weather has been changed to sunny!");
			    	    }
		    		} 
		    	}
		    }
		return true;
	}
	
	public void on(final Player p) {
		BukkitScheduler schedular = Bukkit.getServer().getScheduler();
        schedular.scheduleSyncRepeatingTask(this, new Runnable() {
            @Override
            public void run() {
                p.getWorld().setTime(5000);
            }
        }, 0L, 100L);
    }
	
	public void stopScheduler(Main main){
	    Bukkit.getServer().getScheduler().cancelTasks(main);
	}
}
