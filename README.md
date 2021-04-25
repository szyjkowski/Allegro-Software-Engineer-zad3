# Allegro-Software-Engineer-zad3

 Aplikacja działa na localhost na porcie 8080.
 Aplikacja została celowo rozdzielona osobno na listowanie i osobno na wyświetlanie sumy gwiazdek.

## 1. Sposób uruchomienia:
* Za pomocą skompliowanej paczki .jar w katalogu target.
* z poziomu konsoli znajdując się w głównym katalogu "github-api" poleceniem mvn spring-boot:run(wcześniej można wykonać polecenie mvn clean install).
* Z poziomu IDE.
    
2. Po uruchomieniu, włączamy przeglądarkę, korzystając z localhosta uruchamiamy api w następujący sposób:
## a) listowanie repozytoriów dla użytkownika, wpisujemy:
http://localhost:8080/github-api/list-repo?name=GitHubUserName - listowanie repozytorium dla użytkownika "GitHubUserName"
ex: http://localhost:8080/github-api/list-repo?name=szyjkowski
Należy podać z parametrem("?name=gitHubUserName") w przeciwnym wypadku otrzymamy komunikat:
U have to put param name. Example: http://localhost:8080/github-api/list-repo?name=GitHubUserName";
* Jeśli przekazana nazwa użytkownika jako parametr nie istnieje w githubie otrzymamy komunikat:
       Error 404 Not Found. User not exist.
* Jeśli wystąpi inny błąd otrzymamy:
Error /kod_bledu + status_bledu;
*     Jeśli użytkownik istnieje, ale nie ma repozytoriów otrzymamy:
User has no repositories

 ## b) zwracanie sumy gwiazdek we wszystkich repozytoriach użytkownika, wpisujemy:
       * http://localhost:8080/github-api/count-stars?name=GitHubUserName - sumowanie gwiazdek dla użytkownika "GitHubUserName"
              http://localhost:8080/github-api/count-stars?name=szyjkowski
              Należy podać z parametrem("?name=gitHubUserName") w przeciwnym wypadku otrzymamy komunikat:
              U have to put param name. Example: http://localhost:8080/github-api/count-stars?name=GitHubUserName";
       *    Jeśli przekazana nazwa użytkownika jako parametr nie istnieje w githubie otrzymamy komunikat:
              Error 404 Not Found. User not exist.
       *    Jeśli wystąpi inny błąd otrzymamy:
              Error /kod_bledu + status_bledu;
       *     Jeśli użytkownik istnieje, ale nie ma repozytoriów otrzymamy:
              User has no repositories
## Dodatkowe informacje: 
3. Aplikacja napisana z wykorzystaniem spring-boota w wersji 2.4.5, java 11 + maven + JUnit5, co pozwala na korzystanie z gotowych narzędzi i łatwiejsze rozwinięcie aplikacji w późniejszym czasie.
4. Aplikacja rozszerzona o testy jednostkowe.
5. Do wygodniejszego testowania oprogramowania, można by użyć Swaggera.


