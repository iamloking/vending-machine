package com.loki.codes.state;


import com.loki.codes.enums.Coin;
import com.loki.codes.VendingMachine;

public class DispensingState extends VendingMachineState {
    public DispensingState(VendingMachine machine) {
        super(machine);
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Dispensing State.");
        System.out.println("Currently dispensing. Please wait.");
    }

    @Override
    public void selectItem(String code) {
        System.out.println("Dispensing State.");
        System.out.println("Currently dispensing. Please wait.");
    }

    @Override
    public void dispense() {
        // already triggered by HasMoneyState
        System.out.println("Dispensing State.");
        System.out.println("Item dispensed, thanks for shopping with us.");
        vendingMachine.reset();
    }

    @Override
    public void refund() {
        System.out.println("Dispensing State.");
        System.out.println("Dispensing in progress. Refund not allowed.");
    }
}