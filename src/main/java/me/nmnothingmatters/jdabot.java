package me.nmnothingmatters;

import me.nmnothingmatters.listeners.eventlistener;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;
import org.jetbrains.annotations.NotNull;
import net.dv8tion.jda.api.JDA;

import javax.security.auth.login.LoginException;
import java.util.List;

public class jdabot {

    private final ShardManager shardManager;

    public jdabot() throws LoginException {

        String token = "MTE3MDczNDIwNDIyNTU4OTI4OQ.GiQaac.ymViGDqd1AjlyxuDzg1kunUxhMWqqoHpgDU2Jk";

        DefaultShardManagerBuilder builder = DefaultShardManagerBuilder.createLight(token);
        builder.setStatus(OnlineStatus.DO_NOT_DISTURB);
        builder.setActivity(Activity.watching("hentai"));
        builder.enableIntents(GatewayIntent.GUILD_MEMBERS, GatewayIntent.GUILD_MESSAGES, GatewayIntent.GUILD_PRESENCES, GatewayIntent.DIRECT_MESSAGES, GatewayIntent.GUILD_MESSAGE_TYPING,GatewayIntent.MESSAGE_CONTENT);
        shardManager = builder.build();

        //Registering Listeners
        shardManager.addEventListener(new eventlistener());
    }



    public ShardManager getShardManager() {
        return shardManager;
    }

    public static void main(String[] args) throws LoginException {
        jdabot bot = new jdabot();
    }
}