package wartung;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.server.ServerListPingEvent;
import org.bukkit.plugin.java.JavaPlugin;

import ru.tehkode.permissions.bukkit.PermissionsEx;

public class wartung_main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        Bukkit.getServer().getPluginManager().registerEvents(this, this);
        getServer().getConsoleSender().sendMessage("§aDas §3Wartungs-Plugin §awurde erfolgreich aktiviert!");

    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage("§4Das §3Wartungs-Plugin §4wurde erfolgreich deaktiviert!");
    }

    @EventHandler
    public void onLogin(PlayerLoginEvent e) {
        Player p = e.getPlayer();

        if (PermissionsEx.getUser(p).inGroup("Admin") == false) {
            e.disallow(null, "§c§lWARTUNGARBEITEN!\n"
                    + "§6§lLocalhost §7ist derzeit in §c§lWartungarbeiten!\n\n"
                    + "§6§lLocalhost §7ist bald wieder §a§lonline§7!\n"
                    + "§4§lDanke f§r Ihr Verst§ndnis!");
        }
    }

    public void onMotd(ServerListPingEvent e) {

        e.setMotd("§4§lWartungsarbeiten!");
        e.setMaxPlayers(0);

    }
}
