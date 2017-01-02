/**
 *
 *  @author Wijas Sebastian PD2185
 *
 */

/*
Napisać prosty kalkulator dla liczb typu BigDecimal.
Obliczenia mają być podawane jako argumenty wiersza poleceń w postaci:

liczba1 op liczba2

gdzie op jeden ze znaków +,- (minus), * (mnożenie), / (dzielenie), a  pomiędzy liczba1, op i liczba2 występuje jeden lub więcej białych znaków.

Obliczenia zrealizować w klasie Calc jako metodę String doCalc(String cmd), zwracająca  napisową reprezentację wyniku (uzyskanej liczby) lub napis "Invalid command to calc", jeśli wystąpią jakiekolwiek błędy.

Następująca  klasa Main::

public class Main {
  
  public static void main(String[] args) {
    Calc c = new Calc();
    String wynik = c.doCalc(args[0]);
    System.out.println(wynik);
  }

}
po uruchomieniu winna wyprowadzić na konsolę wynik obliczenia (np. jesli podano jako argument wiersza poleceń 
 "1 / 2" , to wynikiem powinine być napis 0.5.

Jeśli liczba wynikowa nie ma dokładnej reprezentacji (jak np. wynik dzielenia 1/3), to wynik powinien być pokazany z dokładnością co najmniej 7 miejsc dziesiętnych.

Uwaga 1: klasy Main nie wolno modyfikować i musi ona prawidłowo działać.

Uwaga 2: w  zadnej z klas programu nie wolno używać instrukcji if,  ani switch, ani operatora warunkowego, ani instrukcji for, ani isntrukcji while.  
*/


package zad1;


public class Main {

  public static void main(String[] args) {
    Calc c = new Calc();
    String wynik = c.doCalc(args[0]);
    System.out.println(wynik);
  }

}
