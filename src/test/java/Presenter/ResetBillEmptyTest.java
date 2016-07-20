package Presenter;

import Model.PrintBillDetails.PrivilegeThreeForTwo;
import Model.PrintBillDetails.ShoppingListAll;
import Model.PrintBillDetails.SumOfBill;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by feng on 2016/7/19.
 */
public class ResetBillEmptyTest {

    ShoppingListAll shoppingList = new ShoppingListAll();
    PrivilegeThreeForTwo threeforTwo = new PrivilegeThreeForTwo();
    SumOfBill bill = new SumOfBill();
    ResetBillEmpty reset = new ResetBillEmpty();

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

    private PrivilegeThreeForTwo.ThreeForTwo addOneThreeforTwoRecord(String name, int count, String unit) {
        PrivilegeThreeForTwo.ThreeForTwo oneThreeForTwoRecord = new PrivilegeThreeForTwo.ThreeForTwo();
        oneThreeForTwoRecord.name = name;
        oneThreeForTwoRecord.count = count;
        oneThreeForTwoRecord.unit = unit;
        return oneThreeForTwoRecord;
    }

    @Test
    public void should_shoppingList_size_is_0_when_reset_shopping_list() {
        //Given
        shoppingList.shoppingArr.add(addOneBillingRecord("�ɿڿ���",3,"ƿ",3.00,6.00,0.0));
        shoppingList.shoppingArr.add(addOneBillingRecord("��ë��",5,"��",1.00,4.00,0.0));
        shoppingList.shoppingArr.add(addOneBillingRecord("ƻ��",2,"��",5.50,11.00,0.0));
        threeforTwo.threeForTwoArr.add(addOneThreeforTwoRecord("�ɿڿ���",1,"ƿ"));
        threeforTwo.threeForTwoArr.add(addOneThreeforTwoRecord("��ë��",1,"��"));
        bill.total = 21.00;
        bill.privilege = 4.00;
        //when
        reset.resetAll();

        //then
        assertThat(shoppingList.shoppingArr.size(), is(0));
        assertThat(threeforTwo.threeForTwoArr.size(), is(0));
        assertThat(bill.total, is(0.0));
        assertThat(bill.privilege, is(0.0));
    }

}