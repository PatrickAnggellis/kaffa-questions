package cnpj;

import java.util.Scanner;

import cnpj.CnpjUtils;

public class CnpjTest {

    public static void main(String[] args) {

        CnpjUtils cnpjUtils = new CnpjUtils();
        Scanner readCnpj = new Scanner(System.in);

        String CNPJ;
        System.out.println("Inform the CNPJ:");
        CNPJ = readCnpj.next();

        System.out.println("The CNPJ informed is: ");
        if (cnpjUtils.validateCnpj(CNPJ) == true)
            System.out.println("%s\n" + cnpjUtils.printedCnpj(CNPJ));
        else System.out.println("Error, CNPJ is invalid!");
    }
}

