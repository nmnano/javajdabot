package me.nmnothingmatters.listeners;

import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import static java.lang.Math.random;

public class eventlistener extends ListenerAdapter {
    @Override
    public void onMessageReactionAdd(@NotNull MessageReactionAddEvent event) {

        User user = event.getUser();
        String emoji = event.getReactionEmote().getAsReactionCode();
        String channelMention = event.getChannel().getAsMention();


        String channelId = "1170717395652968509";
        TextChannel channel = event.getGuild().getTextChannelById(channelId);
        TextChannel targetChannel = event.getGuild().getTextChannelById("1170717395652968509");

        if (channel != null && targetChannel != null) {
            String message = user.getAsTag() + " reacted to a message with " + emoji + " in the " + channelMention + " channel!";
            targetChannel.sendMessage(message).queue();
        } else {
            // Handle the case when either the specified channel or the target channel does not exist
            System.out.println("Either the specified channel or the target channel does not exist.");
        }
    }


    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        String command = event.getName();
        if (event.getName().equals("welcome")) {
        event.reply("Дадова Винни-пух").queue();
                if (event.getName().equals("1"))
                    event.reply("2");
        }
    }

    @Override
    public void onGuildReady(@NotNull GuildReadyEvent event) {
        List<CommandData> commandData = new ArrayList<>();
        commandData.add(Commands.slash("welcome", "Get welcomed by bot"));
        event.getGuild().updateCommands().addCommands(commandData).queue();
        
    }



    public void onMessageReceived(MessageReceivedEvent event) {
        String message = event.getMessage().getContentRaw();

        if (message.equalsIgnoreCase("!ping")) {
            event.getChannel().sendMessage("pong!").queue();
        }

        if (message.equalsIgnoreCase("!Date")) {
            Date now = new Date();
            event.getChannel().sendMessage(now.toString()).queue();


        }



        }


    }



