package org.example;

import org.telegram.telegrambots.longpolling.TelegramBotsLongPollingApplication;

public class Main {

    public static void main(String[] args) {
        String botToken = System.getenv("BOT_TOKEN");

        try (TelegramBotsLongPollingApplication botsApplication = new TelegramBotsLongPollingApplication()) {
            botsApplication.registerBot(botToken, new EchoBot(botToken));
            System.out.println("Бот запущен...");
            Thread.currentThread().join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }git branch -M main

}