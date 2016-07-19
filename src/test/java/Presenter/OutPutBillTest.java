package Presenter;

import Model.PrintBillDetails.PrivilegeThreeforTwo;
import Model.PrintBillDetails.ShoppingListAll;
import Model.PrintBillDetails.SumOfBill;
import org.junit.After;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by feng on 2016/7/19.
 */
public class OutPutBillTest {

    ShoppingListAll shoppingList = new ShoppingListAll();
    PrivilegeThreeforTwo threeforTwo = new PrivilegeThreeforTwo();
    SumOfBill bill = new SumOfBill();
    OutPutBill printBill = new OutPutBill();

    private ShoppingListAll.Shopping addOneBillingRecord(String name, int count, String unit, double price, double subtotal, double sale95) {

        ShoppingListAll.Shopping oneBillingRecord = new ShoppingListAll.Shopping();
        oneBillingRecord.name = name ;
        oneBillingRecord.count = count ;
        oneBillingRecord.price = price ;
        oneBillingRecord.unit = unit ;
        oneBillingRecord.subtotal = subtotal ;
        oneBillingRecord.sale95 = sale95 ;
        return oneBillingRecord ;

    }

    private PrivilegeThreeforTwo.ThreeforTwo addOneThreeforTwoRecord(String name, int count, String unit) {
        PrivilegeThreeforTwo.ThreeforTwo oneThreeforTwoRecord = new PrivilegeThreeforTwo.ThreeforTwo();
        oneThreeforTwoRecord.name = name;
        oneThreeforTwoRecord.count = count;
        oneThreeforTwoRecord.unit = unit;
        return oneThreeforTwoRecord;
    }

    @After
    public void reset_bill_data() {
        ResetBillEmpty reset = new ResetBillEmpty();
        reset.resetAll();
    }

    @Test
    //�����嵥�����������һ����Ʒ
    public void should_print_shopping_list_when_Goods_have_commodity_of_three_for_two() {
        //Given
        shoppingList.shoppingArr.add(addOneBillingRecord("�ɿڿ���",3,"ƿ",3.00,6.00,0.0));
        shoppingList.shoppingArr.add(addOneBillingRecord("��ë��",5,"��",1.00,4.00,0.0));
        shoppingList.shoppingArr.add(addOneBillingRecord("ƻ��",2,"��",5.50,11.00,0.0));
        threeforTwo.threeforTwoArr.add(addOneThreeforTwoRecord("�ɿڿ���",1,"ƿ"));
        threeforTwo.threeforTwoArr.add(addOneThreeforTwoRecord("��ë��",1,"��"));
        bill.total = 21.00;
        bill.privilege = 4.00;

        //when
        boolean shoppingListStatus = printBill.printShoppingList();
        boolean threeforTwoStatus = printBill.printThreeforTwo();
        boolean billSum = printBill.printSumOfBill();

        //then
        assertThat(shoppingListStatus, is(true));
        assertThat(threeforTwoStatus, is(true));
        assertThat(billSum, is(true));
    }

    @Test
    //�����嵥�мȺ��������һ����Ʒ��Ҳ����95�۵���Ʒ
    public void should_print_shopping_list_when_Goods_have_commodity_of_three_for_two_and_sale95() {
        //Given
        shoppingList.shoppingArr.add(addOneBillingRecord("�ɿڿ���",3,"ƿ",3.00,6.00,0.0));
        shoppingList.shoppingArr.add(addOneBillingRecord("��ë��",5,"��",1.00,4.00,0.0));
        shoppingList.shoppingArr.add(addOneBillingRecord("ƻ��",2,"��",5.50,10.45,0.55));
        threeforTwo.threeforTwoArr.add(addOneThreeforTwoRecord("�ɿڿ���",1,"ƿ"));
        threeforTwo.threeforTwoArr.add(addOneThreeforTwoRecord("��ë��",1,"��"));
        bill.total = 20.45;
        bill.privilege = 4.55;

        //when
        boolean shoppingListStatus = printBill.printShoppingList();
        boolean threeforTwoStatus = printBill.printThreeforTwo();
        boolean billSum = printBill.printSumOfBill();

        //then
        assertThat(shoppingListStatus, is(true));
        assertThat(threeforTwoStatus, is(true));
        assertThat(billSum, is(true));
    }

    @Test
    //�����嵥����95�۵���Ʒ������û�������һ����Ʒ
    public void should_print_shopping_list_when_Goods_have_sale95_and_have_no_commodity_of_three_for_two() {
        //Given
        shoppingList.shoppingArr.add(addOneBillingRecord("�ɿڿ���",3,"ƿ",3.00,6.00,0.0));
        shoppingList.shoppingArr.add(addOneBillingRecord("��ë��",5,"��",1.00,4.00,0.0));
        shoppingList.shoppingArr.add(addOneBillingRecord("ƻ��",2,"��",5.50,10.45,0.55));
        bill.total = 24.45;
        bill.privilege = 0.55;

        //when
        boolean shoppingListStatus = printBill.printShoppingList();
        boolean threeforTwoStatus = printBill.printThreeforTwo();
        boolean billSum = printBill.printSumOfBill();

        //then
        assertThat(shoppingListStatus, is(true));
        assertThat(threeforTwoStatus, is(false));
        assertThat(billSum, is(true));
    }





}