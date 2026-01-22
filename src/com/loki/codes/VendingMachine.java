package com.loki.codes;

import com.loki.codes.entity.Product;
import com.loki.codes.enums.Coin;
import com.loki.codes.repository.Inventory;
import com.loki.codes.state.IdleState;
import com.loki.codes.state.VendingMachineState;

public class VendingMachine {
    private final static VendingMachine INSTANCE = new VendingMachine();
    private final Inventory inventory = new Inventory();
    private VendingMachineState state;
    private String selectedProductCode;
    private int balance = 0;

    private VendingMachine(){
        state = new IdleState(this);
    }

    public static VendingMachine getInstance(){
        return  INSTANCE;
    }

    public void insertCoin(Coin coin){
        state.insertCoin(coin);
    }

    public void addBalance(int  val){
        this.balance+=val;
    }

    public void refundBalance(){
        state.refund();
    }

    public void selectItem(String code){
        state.selectItem(code);
    }

    public void setSelectedProductCode(String code){
        if(!this.getInventory().isAvailable(code)){
            System.out.println("Item not available");

        }
        this.selectedProductCode=code;
    }

    public void dispense(){
        state.dispense();
    }

    public Inventory  getInventory(){
        return this.inventory;
    }

    public void setState(VendingMachineState vendingMachineState){
        this.state = vendingMachineState;
    }

    public Product getSelectedItem(){
        return this.inventory.getProduct(selectedProductCode);
    }

    public int getBalance(){
        return this.balance;
    }

    public void reset(){
        this.selectedProductCode = null;
        this.refundBalance();
        this.setState(new IdleState(this));
    }

    public Product addItem(String code, String name, int price, int quantity){
        Product product= new Product(code,price, name);
        inventory.addProduct(product,quantity);
        return product;
    }

    public void dispenseItem(){
        if(getInventory().isAvailable(selectedProductCode)){
            Product product = getInventory().getProduct(selectedProductCode);
            if(product.getPrice()<=getBalance()){
                getInventory().reduceStock(selectedProductCode);
                balance -=  getInventory().getProduct(selectedProductCode).getPrice();
                System.out.println("Dispensed: " + product.getName());
                if (balance > 0) {
                    System.out.println("Returning change: " + balance);
                }
            }
        }
        reset();
    }

}
