# IT_Conference

Serwis dla obsługi IT konferencji. Stworzona przy pomocy frameworku Spring Boot.
Użyta baza danych: PostgreSQL

Dla korzystania z bazy danych trzeba pobrać Docker Desktop, stworzyć plik docker-compose.yaml i skonfigurować go w następujący sposób:

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

Po tym w terminale wpisać:$ docker compose up -d
Nastepnie przejść do strony http://localhost:8077 i wpisać dane:
System: PostgreSQl
Server: db
Username: postgres
Password: 1234
Database: ItConference

Po kliknięciu Login odbędzie się połączenie z bazą danych.
