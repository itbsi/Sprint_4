package validator;

import java.util.regex.Pattern;

public class Account {

        private final String name;

        public Account(String name) {
            this.name = name;
        }

        private static final String CARDHOLDER_NAME_PATTERN = "(?=^.{3,19}$)([a-zA-Z]{1,19}+\\s{1}+[a-zA-Z]{1,19})";

        public boolean checkNameToEmboss() {
            if (name == null) return false;
            return Pattern.matches(CARDHOLDER_NAME_PATTERN,name);
        }
}
