# Nbc-task

Założenia do aplikacji:
- Kwoty do inwestycji to zawsze liczby całkowite
- Dla uproszczenia sprawy uznałem, że kwota inwestycji nie przekroczy zakresu Integera

Normalnie dla działań na pieniądzach użyłbym BigDecimala.

Głównym punktem aplikacji jest klasa Investment gdzie znajdują się wszystkie obliczenia. Jest to klasa abstrakcyjna z implementacją metody calculate. Aby dokonać konkretnych obliczeń potrzebna jest klasa rozszerzająca Investment, która implementuje metodę decydującą o podziale procentowym na fundusze dla poszczególnych styli. Implementując rozwiązanie chciałem aby jak najprostrze było dodawanie nowych styli inwestowania oraz żeby dodawanie nowych funduszy nie psuło już zdefiniowanych styli inwestowania.

Klasa Investment powinna rzucić wyjątkiem jeżeli przekazane rodzaje funduszy w które chcemy zainwestować nie zgadzają się z tymi, które są zdefiniowane dla wybranego stylu inwestowania.

Investment rzuci wyjatkiem jeżeli będziemy próbowali inwestować ujemną lub zerową ilość pieniędzy.

Wynikiem działania programu jest klasa Report, w której znajdują się informacje o funduszach, zainwestowanych pieniadzach oraz ich procentowym udziale w całej inwestycji. Jest również informacja o nieprzydzielonej kwocie.

Dodatkowo dodałem do mavena plugin jacoco, który generuje raport pokrycia kodu testami jednostkowymy. Raport dostępny jest po zbudowaniu programu w katalogu /target/site/jacoco/index.html

Jak widać na raporcie pokrycie nie jest 100% dla wszystkich klas, ale pisanie testów jednostkowych dla generowanego kodu uważam za zbędne. Najważniejsza klasa Investment ma 100% pokrycia kodu testami.

Użyte technologie:
- Java 8
- Junit 4
- Jacoco
- Maven

