# IT_Conference

Serwis dla obsługi IT konferencji. Stworzona przy pomocy frameworku Spring Boot.
Użyta baza danych: PostgreSQL

Żeby otworzyć ten projekt, trzeba pobrać go, rozpakować i otworzyć projekt przez środowisko InteliJ. Za uruchomienie aplikacji odpowiada plik ItConferenceApplication.
Przy włączeniu projektu tworzy sie plan konferencji razem z prelekcjami oraz 6 użytkownikami. Po wyłączeniu tabeli są usuwane.
Dla korzystania z bazy danych trzeba pobrać Docker Desktop, stworzyć plik docker-compose.yaml i skonfigurować go w następujący sposób:
```
version: '3.8'

services:
  db:
    image: postgres:14.3
    container_name: postgres
    restart: always
    environment:
      POSTGRES_PASSWORD: 1234
    ports:
      - 5432:5432
    deploy:
        resources:
            limits:
              cpus: "2"
              memory: 1GB
            reservations:
              cpus: "2"
              memory: 1GB
  adminer:
    image: adminer:4.8.1
    container_name: adminer
    restart: always
    ports:
      - 8077:8080
```

Po tym w terminale wpisać:$ docker compose up -d
Nastepnie przejść do strony http://localhost:8077 i wpisać dane:
System: PostgreSQl
Server: db
Username: postgres
Password: 1234
Database: ItConference

Po kliknięciu Login odbędzie się połączenie z bazą danych.

Dla wysyłania takich komand jak POST, PUT, GET, DELETE itd lepiej używać aplikacje Postman (lub werjsa Ultimate InteliJ).

#Przykłady:

Wyświetlenie wszystkich prelekcji oraz informacji o nich:
```
GET localhost:8080/api/prelections
```

Wypisywanie listy zarejstrowanych uzytkownikow (imie, nazwisko, login, email):
```
GET localhost:8080/api/users
```

Wypisywanie wszystkich danych zarejstrowanych uzytkownikow razem z hasłem oraz ID:
```
GET localhost:8080/api/users/devUsers
```

Dodawanie użytkownika do tabeli users:
```
           POST localhost:8080/api/users
           {
                   "firstName": "Grzegorz",           //imie
                   "lastName": "Marcinczyk",          //nazwisko
                   "login": "grzegorz99",             //login
                   "password":"1234",                 //hasło
                   "email": "grzegorzM@gmail.com",    //email
                   "dateOfBirth" : "1999-02-27"       //rok, miesiąć, dzień urodzenia
           }
```
Usunięcie użytkownika z tabeli users:
(Liczba po users to ID użytkownika /users/{id_uzytkownika})
```
DELETE localhost:8080/api/users/6
```

Zmiana maila użytkownika (przy zmianie email użtykownika, tak samo następuje zmiana na nowy email w tabeli z rezerwacjami):
(/users/{id_uzytkownika}?email={nowy_email})
```
PUT localhost:8080/api/users/1?email=mat@gmail.com
```
 
Wyświetlenie wszystkich rezerwacji:
```
GET localhost:8080/conference/reservation
```

Wyświetlenie rezerwacje o podanym ID:
```
GET localhost:8080/conference/reservation/1
```
Wyświetla wszystkie rezerwacji użytkownika o podanym Loginie
```
GET localhost:8080/conference/reservation/usersReservations/FunTomAsh
```

Rezerwacja użytkownika w prelekcji:
```
    POST localhost:8080/conference/reservation
    {
            "userId": 1,                          //ID użytkownika
            "userLogin": "FunTomAsh",             //login
            "userEmail": "tomash342@gmail.com",   //email
            "prelecId" : 1,                       //ID prelekcji  
            "prelecTopic": "Computer graphics"    //scieżka
    }
```
Podczas tworzenia rezerwacji w funkcji createReservation w pliku ReservationService sprawdza się, czy użytkownik jest zarejestrowany, czy użytkownik już ma zarezerwowane miejsce w tej prelekcji, czy podany przez użytkonwika email nie jest zajęty, czy podany przez użytkonwika login nie jest zajęty, czy wprowadzona ścieżka istnieje oraz ile miejsc jest zarezerwowane w prelekcji (jezeli >5 to nie mozna zarezerwować miejsce).
Po udanej rezerwacji tworzy się plik, który jest potwierdzeniem rezerwacji.


Usunięcie rezerwacji:
```
                                                  //{id_rezerwacji}
    DELETE localhost:8080/conference/reservation/1
```

Usunięcie rezerwacji przy podaniu logina uzytkownika oraz id prelekcji:
```
                                                                 //{login_uzytkownika}?prelecId={id_prelekcji}
    DELETE localhost:8080/conference/reservation/usersReservations/FunTomAsh?prelecId=1
```
