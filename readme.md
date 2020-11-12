# Oefenen met Maven en JUnit
## Antwoord-branch-Bonusvraag

Deze opdracht bestaat uit twee delen.
* Je gaat een **nieuw** Maven-project maken en je voegt de benodigde bestanden toe aan dit Maven Project.
* Je gaat Unit-testen schrijven voor de Account.java klasse.

Je kunt hier voorbeeld unittesten vinden: https://github.com/hogeschoolnovi/SD-BE-JP-Unittest-examples

Voor `AccountTest.java` heb ik alvast een beginnetje gemaakt:

```java

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

class AccountTest {

    @Test
    void depositingNegativeNumberShouldReturnFalse() {

        //Arrange
        Account account = new Account("Nick", 12, 400);

        //Act
        boolean isDeposited = account.deposit(-12);

        //Assert
        assertFalse(isDeposited);
    }
}

```

Takenlijst:
1. Maak een Maven Project
2. Plaats de readme.md, de .gitignore, BadMoney.java en Account.java op de correcte plek in het nieuw gemaakte Maven project.
3. Maak AccountTest.java aan op de correcte plek en voeg bovenstaande code toe. Je krijgt nu errors!
4. Voeg JUnit 5 aan je pom.xml toe.
5. Run `mvn clean test` om te kijken of alles werkt.
6. Maak voor elke methode in Account.java een Test in AccountTest.java.
7. Je zult bugs tegenkomen in de code door het schrijven van Unit-testen. Deze bugs mag je fixen!

Extra opgave (floats)
1. Bekijk de code in BadMoney.java
2. Run BadMoney.java
3. Zie je hier wat er fout gaat?
4. Controleer Account.java. Heeft Account.java ook dit probleem? Schrijf een test om dit testen.

## Antwoord BadMoney

Je ziet dat het werken met getallen in BadMoney.java niet goed gaat. In andere woorden,  het is gewoonweg niet
handig om Floats te gebruiken voor het werken met geld.
Meer informatie kun je hier vinden:
 * https://en.wikipedia.org/wiki/IEEE_754
 * https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html
 * https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/math/BigDecimal.html
 
 De falende Unit-testen zijn terug te vinden in AccountTest. Wil je dit fixen, dan dien je met BigDecimal te gaan
 werken.
 
 PS: Example 3 is niet af te vangen in Unit-testen, omdat deze bereking gebeurt voor het aanroepen van een methode in 
 `Account`.