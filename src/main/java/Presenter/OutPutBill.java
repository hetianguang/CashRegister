package Presenter;

import Model.PrintBillDetails.PrivilegeThreeforTwo;
import Model.PrintBillDetails.ShoppingListAll;
import Model.PrintBillDetails.SumOfBill;

/**
 * Created by feng on 2016/7/17.
 */
public class OutPutBill {

    ShoppingListAll shoppingList = new ShoppingListAll();
    PrivilegeThreeforTwo threeforTwo = new PrivilegeThreeforTwo();
    SumOfBill bill = new SumOfBill();
    public boolean printShoppingList() {
        int len = shoppingList.shoppingArr.size();
        if(len > 0) {
            printShoppingList(len);
            return true;
        }
        return false;
    }

    private void printShoppingList(int len) {
        System.out.println("```");
        System.out.println("***<ûǮ׬�̵�>�����嵥***");
        for(int i = 0; i < len; i++) {
            ShoppingListAll.Shopping oneShoppingRecord = shoppingList.shoppingArr.get(i);
            printOneShoppingRecord(oneShoppingRecord);
        }
        System.out.println("----------------------");
    }

    private void printOneShoppingRecord(ShoppingListAll.Shopping oneShoppingRecord) {
        System.out.print("���ƣ�"+oneShoppingRecord.name+"��");
        System.out.print("������"+oneShoppingRecord.count+oneShoppingRecord.unit+"��");
        System.out.print("���ۣ�"+String.format("%.2f", oneShoppingRecord.price)+"(Ԫ)��");
        System.out.print("С�ƣ�"+String.format("%.2f", oneShoppingRecord.subtotal)+"(Ԫ)");
        if( oneShoppingRecord.sale95 != 0.0 ) {
            System.out.println(",��ʡ��"+String.format("%.2f", oneShoppingRecord.sale95)+"(Ԫ)");
        }
        else  {
            System.out.println();
        }
    }

    public boolean printThreeforTwo() {
        int len = threeforTwo.threeforTwoArr.size();
        if( len > 0 ) {
            printThreeforTwo(len);
            return true;
        }
        return false;
    }

    private void printThreeforTwo(int len) {
        System.out.println("�����һ��Ʒ��");
        for(int i = 0; i < len; i++) {
            PrivilegeThreeforTwo.ThreeforTwo oneThreeforTwoRecord = threeforTwo.threeforTwoArr.get(i);
            printOneThreeforTwoRecord(oneThreeforTwoRecord);
        }
        System.out.println("----------------------");
    }

    private void printOneThreeforTwoRecord(PrivilegeThreeforTwo.ThreeforTwo oneThreeforTwoRecord) {
        System.out.print("���ƣ�"+oneThreeforTwoRecord.name+"��");
        System.out.println("������"+oneThreeforTwoRecord.count+oneThreeforTwoRecord.unit);
    }

    public boolean printSumOfBill() {
        System.out.println("�ܼƣ�"+String.format("%.2f",bill.total)+"(Ԫ)");
        System.out.println( bill.privilege > 0.0 ? "��ʡ��"+String.format("%.2f",bill.privilege)+"(Ԫ)": "");
        System.out.println("**********************");
        System.out.println("```");
        return true;
    }

    public boolean printFullBill() {
        printShoppingList();
        printThreeforTwo();
        printSumOfBill();
        return true;
    }

}
