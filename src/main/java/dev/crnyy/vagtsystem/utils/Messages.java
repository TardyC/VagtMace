package dev.crnyy.vagtsystem.utils;

import dev.crnyy.vagtsystem.files.Message;

public class Messages {

    private final Message message;

    public Messages(Message message) {
        this.message = message;
    }

    public String vagtshopBuyedItem(String type, int price) {
        String oldMessage = message.getMessages().getString("Vagtshop.buyed-item");
        String newMessageOne = oldMessage.replace("{0}", type);
        return newMessageOne.replace("{1}", String.valueOf(price));
    }

    public String vagtshopNoMoney(String type, int price) {
        String oldMessage = message.getMessages().getString("Vagtshop.no-money");
        String newMessageOne = oldMessage.replace("{0}", type);
        return newMessageOne.replace("{1}", String.valueOf(price));
    }

    public String vagtshopEnchant() {
        String oldMessage = message.getMessages().getString("Vagtshop.enchant-item");
        String newMessageOne = oldMessage.replace("{0}", "enchant");
        return newMessageOne.replace("{1}", "amount");
    }

    public String vagtpayPayout() {
        return message.getMessages().getString("Vagtpay.payout");
    }

    public String repairSignrepaired(String type, int price) {
        String oldMessage = message.getMessages().getString("repair.repair-text");
        String newMessageOne = oldMessage.replace("{0}", type);
        return newMessageOne.replace("{1}", String.valueOf(price));
    }


    public String repairSignnotmoney(String type, int price) {
        String oldMessage = message.getMessages().getString("repair.no-money");
        String newMessageOne = oldMessage.replace("{0}", type);
        return newMessageOne.replace("{1}", String.valueOf(price));
    }
}
