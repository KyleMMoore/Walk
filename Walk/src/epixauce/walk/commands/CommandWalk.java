/*
 * Author: Kyle Moore (Epixauce)
 * Purpose: To Slow users to a better walking pace
 * For: Legends of the Fallen Minecraft Server
 */

package epixauce.walk.commands;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import epixauce.walk.Walk;

public class CommandWalk implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String s, String[] sRay) {
		if(sender instanceof Player){//check to make sure command sender isn't console
			
			Player player = (Player) sender;//set player object to sender
			
			if(player.getWalkSpeed()==.2f){//check player speed to determine which speed to set
				
				player.sendMessage(ChatColor.GOLD + "*You slow down to a walking pace.");
				
				//if player was at default speed, slow down
				//gets the default walk speed from the config file
				player.setWalkSpeed((float)Walk.getInstance().getConfig().getDouble("WalkSpeed")); 
				return true;
				
			}else{
				
				player.sendMessage(ChatColor.GOLD + "*You speed up to a light jog.");
				player.setWalkSpeed(.2f); //if player was at any other speed, speed up
				return true;
				
			}
		}
		return false;
	}

}
