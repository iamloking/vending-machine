package com.loki.codes.state;

import com.loki.codes.enums.Coin;
import com.loki.codes.VendingMachine;


public class HasMoneyState extends VendingMachineState{
    public HasMoneyState(VendingMachine vendingMachine){
        super(vendingMachine);
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("HasMoneyState");
        System.out.println("Sufficient money already added");
    }

    @Override
    public void selectItem(String code) {
        System.out.println("HasMoneyState");
        System.out.println("Item already selected, reset to set again");
    }

    @Override
    public void dispense() {
        System.out.println("HasMoneyState");
        System.out.println("Updating the inventory");
        vendingMachine.setState(new DispensingState(vendingMachine));
        vendingMachine.dispenseItem();
    }

    @Override
    public void refund() {
        System.out.println("HasMoneyState");
        vendingMachine.reset();
    }
}
