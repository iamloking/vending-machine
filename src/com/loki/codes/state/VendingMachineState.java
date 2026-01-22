package com.loki.codes.state;

import com.loki.codes.enums.Coin;
import com.loki.codes.VendingMachine;

public abstract class VendingMachineState {
    VendingMachine vendingMachine;

    VendingMachineState(VendingMachine machine){
        this.vendingMachine = machine;
    }

    public abstract  void insertCoin(Coin coin);
    public abstract void selectItem(String code);
    public abstract  void dispense();
    public abstract  void refund();

}
