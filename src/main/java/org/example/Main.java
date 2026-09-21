package org.example;

import org.telegram.telegrambots.longpolling.TelegramBotsLongPollingApplication;

public class Main {
    public static void main(String[] args) {
        new Main().run(args);
    }
    private void run(String[] args) {
        String botToken = System.getenv("BOT_TOKEN");
        if (botToken == null || botToken.isBlank()){
            System.err.println("Error! Bot Token is empty!");
            return;
        }
        EchoBot echoBot = new EchoBot(botToken);
        try (TelegramBotsLongPollingApplication botsApplication = new TelegramBotsLongPollingApplication()) {
            botsApplication.registerBot(botToken, echoBot);
            System.out.println("Бот работает!");
            Thread.currentThread().join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}