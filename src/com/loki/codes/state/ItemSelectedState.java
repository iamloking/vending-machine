package com.loki.codes.state;


import com.loki.codes.enums.Coin;
import com.loki.codes.VendingMachine;
public class ItemSelectedState extends VendingMachineState{
    public ItemSelectedState(VendingMachine vendingMachine){
        super(vendingMachine);
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("ItemSelectedState");

        System.out.println("Adding: "+coin.getValue()+" to balance");
        vendingMachine.addBalance(coin.getValue());
        int price = vendingMachine.getSelectedItem().getPrice();
        if(vendingMachine.getBalance()>= price){
            System.out.println("Sufficient money received.");
            vendingMachine.setState(new HasMoneyState(vendingMachine));
        }
    }

    @Override
    public void selectItem(String code) {
        System.out.println("ItemSelectedState");

        System.out.println("Item already selected, reset to set again");
    }

    @Override
    public void dispense() {
        System.out.println("ItemSelectedState");

        System.out.println("Please insert sufficient money.");
    }

    @Override
    public void refund() {
        System.out.println("ItemSelectedState");

        vendingMachine.reset();
    }
}
