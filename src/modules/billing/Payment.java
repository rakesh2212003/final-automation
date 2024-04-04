package modules.billing;

import org.openqa.selenium.WebDriver;

import conditions.Condition;
import paths.billing.PaymentPaths;

public class Payment extends Condition implements PaymentPaths {

    public Payment(WebDriver driver) {
        super(driver);
    }

    public void create(String transactionId, String currencyCode, String amount, String paymentType) {
        goToModule();
        clickWhenClickable(newBtn);
        add(transactionId, currencyCode, amount, paymentType);
        cancelPopup(popup);
    }

    public void view() {
        goToModule();
        clickWhenClickable(rowSetting);
        clickWhenClickable(details);
    }

    public void edit(String transactionId, String currencyCode, String amount, String paymentType) {
        goToModule();
        clickWhenClickable(rowSetting);
        clickWhenClickable(edit);
        add(transactionId, currencyCode, amount, paymentType);
        cancelPopup(popup);
    }

    public void delete() {
        goToModule();
        clickWhenClickable(rowSetting);
        clickWhenClickable(delete);
        clickWhenClickable(yesBtn);
        cancelPopup(popup);
    }

    private void goToModule() {
        // cancelPopup(popup);
        moveToElement(menu);
        clickWhenClickable(module);
        clickWhenClickable(list);
    }

    private void add(String transactionId, String currencyCode, String amount, String paymentType) {
        sendKeysWhenVisible(transactionIdInput, transactionId);

        clickWhenClickable(currencyCodeDrp);
        clickWhenClickable(selectCurrencyCodeDrp.get(currencyCode));

        sendKeysWhenVisible(amountInput, amount);

        clickWhenClickable(paymentTypeDrp);
        clickWhenClickable(selectPaymentTypeDrp.get(paymentType));

        clickWhenClickable(saveBtn);
    }
}