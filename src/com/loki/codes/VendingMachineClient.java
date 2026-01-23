package com.loki.codes;

import com.loki.codes.enums.Coin;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class VendingMachineClient {
    public static void main(String[] args) {
        VendingMachine vendingMachine= VendingMachine.getInstance();
        vendingMachine.addItem("lays","Lays Chip",20,15);
        vendingMachine.selectItem("lays");
        vendingMachine.insertCoin(Coin.QUARTER);
        vendingMachine.dispense();
//        System.out.println("Vending machine Balance: "+vendingMachine.getBalance());
//        System.out.println("Vending machine Selected Item: "+vendingMachine.getSelectedItem());
    }
}