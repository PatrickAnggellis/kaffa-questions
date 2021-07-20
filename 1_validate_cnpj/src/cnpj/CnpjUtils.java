package cnpj;

import java.util.InputMismatchException;

public class CnpjUtils {

    public static boolean validateCnpj(String CNPJ) {

        CNPJ = CNPJ.replace(".", "");
        CNPJ = CNPJ.replace("/", "");
        CNPJ = CNPJ.replace("-", "");

        //Check if it has a sequence of numbers
        if (CNPJ.equals("00000000000000") ||
                CNPJ.equals("11111111111111") ||
                CNPJ.equals("22222222222222") ||
                CNPJ.equals("33333333333333") ||
                CNPJ.equals("44444444444444") ||
                CNPJ.equals("55555555555555") ||
                CNPJ.equals("66666666666666") ||
                CNPJ.equals("77777777777777") ||
                CNPJ.equals("88888888888888") ||
                CNPJ.equals("99999999999999") ||
                (CNPJ.length() != 14))
            return (false);

        char digit_1;
        char digit_2;
        int sum;
        int weight;
        int verifying_digit;
        int number;

        // Use try for error
        try {
           sum = 0;
           weight = 2;
           // First calculate the 1st check digit
           for (int i = 11; i >= 0; i--){
               // turn char into int for each char
               //number = CNPJ.charAt(i);
               number = (int) CNPJ.charAt(i) - 48;
               sum = sum + (number * weight);
               weight++;
               // check if the weight is equal to ten and
               // if true return the weight value to 2
               if(weight == 10)
                   weight =2;
           }

           verifying_digit = sum % 11;
           if ((verifying_digit == 0) || (verifying_digit == 1))
               digit_1 = '0';
           else digit_1 = (char) ((11 - verifying_digit) + 48);


           //Second calculate the 2st check digit
           sum = 0;
           weight = 0;
           for (int i = 12; i >= 0; i--) {
               number = (int) CNPJ.charAt(i);
               sum =+ (number * weight);
               weight++;
               if (weight == 10)
                   weight =2;
           }

           verifying_digit = sum % 11;
           if ((verifying_digit == 0) || (verifying_digit == 1))
               digit_2 = '0';
           else digit_2 = (char) ((11 - verifying_digit) + 48);


           //Check if the digits are equals with digit_1 and digit_2
           if ((digit_1 == CNPJ.charAt(12)) && (digit_2 == CNPJ.charAt(13)))
                return true;
           else return false;

        } catch (InputMismatchException error) {
            return false;
        }
    }

    public static String printedCnpj (String CNPJ) {
        return (CNPJ.substring(0, 2) + "." + CNPJ.substring(2, 5) + "." + CNPJ.substring(5, 8) + "." + CNPJ.substring(8, 12) + "/" + CNPJ.substring(12, 14));
    }
}