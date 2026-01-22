package com.loki.codes.state;

import com.loki.codes.enums.Coin;
import com.loki.codes.VendingMachine;
public class IdleState extends VendingMachineState{
    public IdleState(VendingMachine vendingMachine){
        super(vendingMachine);
    }

    @Override
    public void insertCoin(Coin coin) {

        System.out.println("IdleState");
        System.out.println("Select an item first");
    }

    @Override
    public void selectItem(String code) {
        System.out.println("IdleState");

        vendingMachine.setSelectedProductCode(code);
        vendingMachine.setState(new ItemSelectedState(vendingMachine));
        System.out.println("Item selected: "+code);
    }

    @Override
    public void dispense() {

        System.out.println("IdleState");
        System.out.println("No item selected");
    }

    @Override
    public void refund() {

        System.out.println("IdleState");
        System.out.println("No money to refund");
    }
}
