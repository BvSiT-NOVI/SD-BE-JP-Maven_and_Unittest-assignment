package nl.novi.javaprogrammeren.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AccountTest {

    private Account positiveAccount;

    @BeforeEach
    public void setup() {
        positiveAccount = new Account("Sjaak", 100, 1000);
    }

    @Test
    void depositingNegativeNumberShouldReturnFalse() {
        //Arrange
        Account account = new Account("Nick", 12, 400);

        //Act
        boolean isDeposited = account.deposit(-12);

        //Assert
        assertFalse(isDeposited);
    }

    @Test
    void givenNegativeAmountDepositShouldReturnFalse() {
        assertFalse(positiveAccount.deposit(-100));
    }

    @Test
    void givenPositiveAmountDepositShouldReturnTrue() {
        assertTrue(positiveAccount.deposit(100));
    }

    @Test
    void givenPositiveAmountDepositShouldAddAmountToTal() {
        positiveAccount.deposit(100);
        assertEquals(1100, positiveAccount.getBalance());
    }

    @Test
    void givenNegativeWithdrawlShouldReturnFalse() {
        assertFalse(positiveAccount.withdraw(-1000, 10));
    }

    @Test
    void givenNegativeFeeWithdrawlShouldReturnFalse() {
        assertFalse(positiveAccount.withdraw(10, -10));
    }

    @Test
    void givenEnoughBalanceCustomerShouldWithdraw() {
        assertTrue(positiveAccount.withdraw(40, 10));
    }

    /**
     * Toevoeging Nick:
     * Bij deze test kom je erachter dat er iets fout gaat in de withdraw-methode.
     *
     * Nadere inspectie laat zien dat isValidWithdrawl twee keer wordt aangeroepen. Dat twee keer aanroepen
     * is niet erg. Dat het tweede keer aanroepen echter na het update van de balance is, zorgt hier voor
     * een bug.
     */
    @Test
    void givenEnoughBalanceForWithdrawlAccountCanGoNegativeWithFee() {
        assertTrue(positiveAccount.withdraw(1000, 10));
    }

    @Test
    void givenEnoughBalanceCustomerBalanceShouldBeChanged() {
        positiveAccount.withdraw(40, 10);
        assertEquals(950, positiveAccount.getBalance());
    }

    @Test
    void givenEnoughBalanceBalanceShouldGoNegativeWithFee() {
        positiveAccount.withdraw(1000, 10);
        assertEquals(-10, positiveAccount.getBalance());
    }

    @Test
    void givenPositiveBalanceZeroWithdrawlIsPossible() {
        assertTrue(positiveAccount.withdraw(0, 10));
    }

    @Test
    void givenPositiveBalanceZeroFeeIsPossible() {
        assertTrue(positiveAccount.withdraw(10, 0));
    }

    @Test
    void givenNegativeBalanceNoWithdrawl() {
        Account negativeAccount = new Account("Brook", 501, -50);
        assertFalse(negativeAccount.withdraw(100, 10));
    }


    @Test
    void testAddingInterest() {
        positiveAccount.addInterest();
        assertEquals(1000*1.045, positiveAccount.getBalance());
    }

    //Toevoeging Nick:
    // Voor de volledigheid kun je getters en setters testen.
    // Ik doe dit meestal niet.
    @Test
    void testGetAccountNumber() {
        assertEquals(100, positiveAccount.getAccountNumber());
    }

    @Test
    void testToString() {
        /* ToString Methodes zijn altijd een draak om te testen.
        De numberformat werkte niet helemaal, dus deze heb ik herschreven in de Account.Java klasse.
        Daarnaast voegt de numberformat een non breaking space aan de String toe. Dat moeten we dus ook aan de
        expected kant toevoegen in de assertEquals. Dat is dit:s "\u00a0"
        */

        assertEquals(100 + "\t" + "Sjaak" + "\t" + "1,000.00"+ "\u00a0" +"€", positiveAccount.toString());
    }
}
