package org.example;

import org.telegram.telegrambots.client.okhttp.OkHttpTelegramClient;
import org.telegram.telegrambots.longpolling.util.LongPollingSingleThreadUpdateConsumer;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.TelegramClient;

public class EchoBot implements LongPollingSingleThreadUpdateConsumer {
    private final TelegramClient telegramClient;
    public EchoBot(String botToken){
        this.telegramClient = new OkHttpTelegramClient(botToken);
    }
    @Override
    public void consume(Update update){
        if (update.hasMessage() && update.getMessage().hasText()) {
            SendMessage sendMessage = SendMessage.builder().chatId(update.getMessage().getChatId()).text(update.getMessage().getText()).build();
            try {
                telegramClient.execute(sendMessage);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }
}