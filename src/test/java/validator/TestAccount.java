package validator;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestAccount {

    private final boolean excepted;
    private final Account account;

    public TestAccount(String name, boolean excepted) {
        this.excepted = excepted;
        account = new Account(name);
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                // Меньше 3х символов
                {"ab", false},

                // Больше 19ти символов
                {"abcdefgh ijklmnopqrs", false},

                // Минимальное допустимое значение
                {"i j", true},

                // Максимальное допустимое значение
                {"ijklmnop qrstuvwxyz", true},

                // Нет пробела
                {"abcdefghijklmno", false},

                // Два пробела подряд
                {"abcdef  ghijklm", false},

                // Пробел в начале
                {" abcdefghijklmno", false},

                // Пробел в конце
                {"abcdefghijklmno ", false}
        };
    }

    @Test
    @DisplayName("Валидация поля держателя карты")
    public void validateCardHolderName() {
        boolean actual = account.checkNameToEmboss();
        assertEquals("Ошибка валидации поля держателя карты", excepted, actual);
    }
}



