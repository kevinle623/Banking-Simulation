import java.util.Scanner;
import java.text.DecimalFormat;

public class Bank {

    public void title() {
        System.out.println("***********************");
        System.out.println("\\\\The TD Bank Canada//");
        System.out.println("***********************");

    }

    public static void main(String[] args) {
        Bank obj = new Bank();
        DecimalFormat obj1 = new DecimalFormat("$###,###,##0.00");
        Scanner input = new Scanner(System.in);
        obj.title();
        String name;
        char accounttype, currency, morgage;
        double total = 0, interest = 0, newbalance = 0, balance = 0, minbalance, loan, loaninterest, monthlypay;
        int penn, nick, dimes, quarters, fives, tens, twent, weeks, continuer = 0, accountnum, monthstopay = 0;
        System.out.print("Please enter your name: ");
        name = input.nextLine();
        do {
            continuer = 0;
            System.out.print("How many pennies are in your bank: ");
            penn = input.nextInt();
            System.out.print("How many nickels are in your bank: ");
            nick = input.nextInt();
            System.out.print("How many dimes are in your bank: ");
            dimes = input.nextInt();
            System.out.print("How many quarters are in your bank: ");
            quarters = input.nextInt();
            System.out.print("How many $5 bills are in your bank: ");
            fives = input.nextInt();
            System.out.print("How many $10 bills are in your bank: ");
            tens = input.nextInt();
            System.out.print("How many $20 bills are in your bank: ");
            twent = input.nextInt();
            System.out.print("How many weeks ahve you been saving your money (to the nearest week):");
            weeks = input.nextInt();
            if (weeks < 0 || penn < 0 || nick < 0 || dimes < 0 || quarters < 0 || fives < 0 || tens < 0 || twent < 0 || weeks < 0) {
                System.out.println("Invalid input. One of your inputs is invalid. Try again.");
                continuer = 1;
            } else {
                continuer = 0;
            }
        } while (continuer == 1);

        System.out.format("%15s %18s %13s", "Type of Coin", "Amount of Coins", "Total");
        System.out.print("\n");
        System.out.format("%15s %18s %13s", "Pennies", penn, obj1.format(penn * 0.01));
        System.out.print("\n");
        total += penn * 0.01;
        System.out.format("%15s %18s %13s", "Nickels", nick, obj1.format(nick * 0.05));
        System.out.print("\n");
        total += nick * 0.05;
        System.out.format("%15s %18s %13s", "Dimes", dimes, obj1.format(dimes * 0.1));
        System.out.print("\n");
        total += dimes * 0.1;
        System.out.format("%15s %18s %13s", "Quarters", quarters, obj1.format(quarters * 0.25));
        System.out.print("\n");
        total += quarters * 0.25;
        System.out.format("%15s %18s %13s", "$5 Bills", fives, obj1.format(fives * 5));
        System.out.print("\n");
        total += fives * 5;
        System.out.format("%15s %18s %13s", "$10 Bills", tens, obj1.format(tens * 10));
        System.out.print("\n");
        total += tens * 10;
        System.out.format("%15s %18s %13s", "$20 Bills", twent, obj1.format(twent * 20));
        System.out.print("\n");
        total += twent * 20;
        System.out.println();
        System.out.println("You have saved: " + obj1.format(total));
        System.out.println("You save about " + obj1.format(total / weeks) + " per week");
        System.out.println(name + ", at this rate you can save " + obj1.format((total / weeks) * 52) + " in one year.");

        System.out.println();
        System.out.println("Hi " + name + ", at this rate you can save " + obj1.format(((total / weeks) * 52) / 12));
        do {
            System.out.print("Enter the annual interest rate in percent: ");
            interest = input.nextDouble();
            if (interest < 0) {
                System.out.println("Invalid input. Enter a valid integer. Try again.");
                continuer = 1;
            } else {
                continuer = 0;
            }
        } while (continuer == 1);
        interest /= 100;
        interest /= 12;
        total = ((total / weeks) * 52) / 12;
        System.out.println("Here is what you have earned during the first 3 months of the investment: ");
        System.out.println("After the first month: " + obj1.format(total *= (1 + (interest))));
        System.out.println("After the second month: " + obj1.format(total *= (1 + (interest))));
        System.out.println("After the third month: " + obj1.format(total *= (1 + (interest))));
        balance = total * (1 + (interest));
        System.out.println();

        System.out.println("Now that you have reached your third month with TD Bank");
        do {
            System.out.print("Enter your account number: ");
            accountnum = input.nextInt();
            if (accountnum < 0) {
                System.out.println("Invalid input. Enter the correct account number.");
                continuer = 1;
            } else {
                continuer = 0;
            }
        } while (continuer == 1);
        do {
            System.out.println("S - Savings Account");
            System.out.println("C - Checkings");
            System.out.print("(Enter your desired account type):");
            accounttype = input.next().charAt(0);
            if (accounttype != 's' && accounttype != 'S' && accounttype != 'c' && accounttype != 'C') {
                continuer = 1;
            } else {
                continuer = 0;
            }
        } while (continuer == 1);
        do {
            System.out.print("Enter the minimum balance: ");
            minbalance = input.nextInt();
            if (minbalance < 0) {
                System.out.println("Invalid input. Enter a valid value.");
                continuer = 1;
            } else {
                continuer = 0;
            }
        } while (continuer == 1);
        if (accounttype == 's' || accounttype == 'S') {
            if (balance < minbalance) {
                newbalance = balance - 10;
            } else {
                newbalance = balance * 1.04;
            }

        } else if ((accounttype == 'C' || accounttype == 'c')) {
            if (balance < minbalance) {

                newbalance = balance - 25;
            } else if (balance > minbalance) {
                if (balance - minbalance <= 5000) {
                    newbalance = balance * 1.03;
                } else {
                    newbalance = balance * 1.05;
                }
            }

        }
        System.out.println("====STATUS ACCOUNT====");
        System.out.println("Account number: " + accountnum);
        if (accounttype == 'c' || accounttype == 'C') {
            System.out.println("Account type: Checkings");

        } else {
            System.out.println("Account type: Savings");
        }
        System.out.println("Starting balance: " + obj1.format(balance));
        System.out.println("New balance: " + obj1.format(newbalance));

        System.out.println();
        System.out.print("Would you like to make a loan? (y/n):");
        morgage = input.next().charAt(0);
        if (morgage == 'y') {
            System.out.println("=======LOAN SERVICE=======");
            System.out.print("Enter the loan amount: ");
            loan = input.nextDouble();
            System.out.print("Enter the interest per year (in percentage): ");
            loaninterest = input.nextDouble();
            loaninterest /= 100;
            loaninterest *= 0.75;
            loaninterest /= 12;

            do {
                System.out.print("Enter the monthly payment: ");
                monthlypay = input.nextDouble();
                if (monthlypay < ((loaninterest) * loan)) {
                    System.out.println("Monthly payment is too low. The loan cannot be repaid.");
                    continuer = 1;
                } else {
                    continuer = 0;
                }
            } while (continuer == 1);

            double lower = loan;
            double payoff;
            double thismonth;
            System.out.println("");
            System.out.println("=====PAYMENT HISTORY=====");
            System.out.println("Month #" + monthstopay + "||Initial loan:" + obj1.format(lower));
            do {
                monthstopay++;
                thismonth = lower * loaninterest;
                payoff = monthlypay - thismonth;
                lower -= payoff;
                System.out.println("Month #" + monthstopay + "|| Current loan:" + obj1.format(lower));
                System.out.println("Month #" + monthstopay + "|| Interest due:" + obj1.format(payoff));
            } while (monthlypay < lower);
            if (((int) monthstopay / 12) > 25) {
                double monthlyrepay;
                monthstopay=0;
                lower=loan;
                do {
                    System.out.println("Your payment will take too long.");
                    System.out.print("Enter a higher monthly payment: ");
                    monthlyrepay = input.nextDouble();
                    do {

                        monthstopay++;
                        thismonth = lower * loaninterest;

                        payoff = monthlyrepay - thismonth;
                        
                        lower -= payoff;
                        

                    } while (monthlypay < lower);
                    
                } while (((int) monthstopay / 12) < 25);
            }
            monthstopay++;
            System.out.println("");

            System.out.println(name + ", it will take " + (int) (monthstopay / 12) + " years and " + (int) (monthstopay % 12) + " months to repay the loan.");
        }
        System.out.println("");
        System.out.print("Would you like to use the currency conversion machine? (y/n): ");
        currency = input.next().charAt(0);
        if (currency == 'y') {
            double japanese, us, convert;
            System.out.println("====================CURRENCY EXCHANGE========================");
            System.out.print("Enter today's price of one US dollar in Japanese yen: ");
            japanese = input.nextDouble();
            System.out.println("=============================================================");
            do {
                System.out.print("Enter the amount of US dollars you would like to convert to yen (Enter 0 to stop): ");
                us = input.nextDouble();
                if (us == 0) {
                    break;
                }
                convert = us * japanese;
                System.out.println(obj1.format(us) + " USD is equal to " + obj1.format(convert) + " yen.");
            } while (us != 0);
            System.out.println("=============================================================");
            do {
                System.out.print("Enter the amount of Japense yen you would like to convert to USD (Enter 0 to stop): ");
                us = input.nextDouble();
                if (us == 0) {
                    break;
                }
                convert = us / japanese;
                System.out.println(obj1.format(us) + " yen is equal to " + obj1.format(convert) + " USD.");
            } while (us != 0);
            System.out.println("=============================================================");
        }
        System.out.println();
        System.out.println("=============================================================");
        System.out.println(name + " your current balance is: " + obj1.format(newbalance));
        System.out.println("If there is any problem. Please contact customer support. Otherwise, enjoy your day and thanks for using TD BANK.");
    }

}
