# IT_Conference

Serwis dla obsługi IT konferencji. Stworzona przy pomocy frameworku Spring Boot.
Użyta baza danych: PostgreSQL

Żeby otworzyć ten projekt, trzeba pobrać go, rozpakować i otworzyć projekt przez środowisko InteliJ. Za uruchomienie aplikacji odpowiada plik ItConferenceApplication.

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
```GET localhost:8080/api/prelections```

Wypisywanie listy zarejstrowanych uzytkownikow (imie, nazwisko, login, email):
```GET localhost:8080/api/users```

Wypisywanie wszystkich danych zarejstrowanych uzytkownikow razem z hasłem oraz ID:
```GET localhost:8080/api/users/devUsers```

Dodawanie użytkownika do tabeli users:
```
           POST localhost:8080/api/users
           {
                   "firstName": "Grzegorz",
                   "lastName": "Marcinczyk",
                   "login": "grzegorz99",
                   "password":"1234",
                   "email": "grzegorzM@gmail.com",
                   "dateOfBirth" : "1999-02-27"
           }
```
Usunięcie użytkownika z tabeli users:
                                     //Liczba po users to ID użytkownika /users/{id_uzytkownika}
```DELETE localhost:8080/api/users/6```

Zmiana maila użytkownika (przy zmianie email użtykownika, tak samo następuje zmiana na nowy email w tabeli z rezerwacjami) :
//                             /users/{id_uzytkownika}?email={nowy_email}
``PUT localhost:8080/api/users/1?email=mat@gmail.com```
 
