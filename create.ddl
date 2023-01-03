CREATE TABLE Dozent (
  name            varchar2(255), 
  vorname         number(10), 
  grad            varchar2(255), 
  email           varchar2(255) NOT NULL, 
  Veranstaltungid number(10) NOT NULL, 
  PRIMARY KEY (email));
CREATE TABLE Gebaeude (
  nummer number(10) GENERATED AS IDENTITY, 
  name   varchar2(255), 
  PRIMARY KEY (nummer));
CREATE TABLE Labor (
  Veranstaltungid number(10) NOT NULL);
CREATE TABLE Lehrbeauftragter (
  Dozentemail varchar2(255) NOT NULL);
CREATE TABLE Mitarbeiter (
  bueroraum    number(10) NOT NULL, 
  sprechzeiten timestamp(7), 
  dozentemail  varchar2(255) NOT NULL, 
  Raumid       number(10) NOT NULL);
CREATE TABLE Professor (
  sprechzeiten timestamp(7), 
  bueroraum    number(10) NOT NULL, 
  dozentemail  varchar2(255) NOT NULL, 
  Raumid       number(10) NOT NULL);
CREATE TABLE Raum (
  gebaeudenummer number(10) NOT NULL, 
  raumnummer     number(10) NOT NULL, 
  name           varchar2(255), 
  id             number(10) GENERATED AS IDENTITY, 
  PRIMARY KEY (id));
CREATE TABLE Raum_Veranstaltung (
  veranstaltungid number(10) NOT NULL, 
  Raumid          number(10) NOT NULL);
CREATE TABLE Studiengang (
  name    varchar2(255), 
  kuerzel varchar2(35) NOT NULL, 
  PRIMARY KEY (kuerzel));
CREATE TABLE Stundenplan (
  studiengangkuerzel varchar2(35) NOT NULL, 
  id                 number(10) GENERATED AS IDENTITY, 
  PRIMARY KEY (id));
CREATE TABLE Uebung (
  Veranstaltungid number(10) NOT NULL);
CREATE TABLE Veranstaltung (
  name               varchar2(255), 
  id                 number(10) GENERATED AS IDENTITY, 
  wochentag          varchar2(255), 
  startzeit          timestamp(7), 
  endzeit            timestamp(7), 
  fachsemester       number(10), 
  haeufigkeit        varchar2(255), 
  Studiengangkuerzel varchar2(35) NOT NULL, 
  Stundenplanid      number(10) NOT NULL, 
  PRIMARY KEY (id));
CREATE TABLE Vorlesung (
  Veranstaltungid number(10) NOT NULL);
ALTER TABLE Stundenplan ADD CONSTRAINT FKStundenpla847626 FOREIGN KEY (studiengangkuerzel) REFERENCES Studiengang (kuerzel);
ALTER TABLE Professor ADD CONSTRAINT FKProfessor65313 FOREIGN KEY (dozentemail) REFERENCES Dozent (email);
ALTER TABLE Mitarbeiter ADD CONSTRAINT FKMitarbeite576035 FOREIGN KEY (dozentemail) REFERENCES Dozent (email);
ALTER TABLE Lehrbeauftragter ADD CONSTRAINT FKLehrbeauft246573 FOREIGN KEY (Dozentemail) REFERENCES Dozent (email);
ALTER TABLE Raum ADD CONSTRAINT FKRaum915267 FOREIGN KEY (gebaeudenummer) REFERENCES Gebaeude (nummer);
ALTER TABLE Mitarbeiter ADD CONSTRAINT FKMitarbeite897598 FOREIGN KEY (Raumid) REFERENCES Raum (id);
ALTER TABLE Professor ADD CONSTRAINT FKProfessor563269 FOREIGN KEY (Raumid) REFERENCES Raum (id);
ALTER TABLE Labor ADD CONSTRAINT FKLabor84908 FOREIGN KEY (Veranstaltungid) REFERENCES Veranstaltung (id);
ALTER TABLE Uebung ADD CONSTRAINT FKUebung531416 FOREIGN KEY (Veranstaltungid) REFERENCES Veranstaltung (id);
ALTER TABLE Vorlesung ADD CONSTRAINT FKVorlesung131319 FOREIGN KEY (Veranstaltungid) REFERENCES Veranstaltung (id);
ALTER TABLE Veranstaltung ADD CONSTRAINT FKVeranstalt211379 FOREIGN KEY (Studiengangkuerzel) REFERENCES Studiengang (kuerzel);
ALTER TABLE Raum_Veranstaltung ADD CONSTRAINT FKRaum_Veran228614 FOREIGN KEY (Raumid) REFERENCES Raum (id);
ALTER TABLE Raum_Veranstaltung ADD CONSTRAINT FKRaum_Veran323977 FOREIGN KEY (veranstaltungid) REFERENCES Veranstaltung (id);
ALTER TABLE Veranstaltung ADD CONSTRAINT FKVeranstalt289574 FOREIGN KEY (Stundenplanid) REFERENCES Stundenplan (id);
ALTER TABLE Dozent ADD CONSTRAINT FKDozent770203 FOREIGN KEY (Veranstaltungid) REFERENCES Veranstaltung (id);

