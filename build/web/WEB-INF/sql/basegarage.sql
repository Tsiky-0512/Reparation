create user garage identified by 12345678;
grant dba to garage;

create table Utilisateur (
	idUtilisateur VARCHAR(10) CONSTRAINT PK_Utilisateur PRIMARY KEY,
	nomUtilisateur VARCHAR(30),
	prenomUtilisateur VARCHAR(50),
	mdp VARCHAR(20)
);

create table Client(
	idC VARCHAR(10) CONSTRAINT PK_Client PRIMARY KEY,
	nomClient VARCHAR(30),
	tel VARCHAR(30)
);

create table Voiture(
	idV VARCHAR(10) CONSTRAINT PK_Voiture PRIMARY KEY,
	idC VARCHAR(10) CONSTRAINT FK_idC REFERENCES Client,
	marqueVoiture VARCHAR(30),
	numero VARCHAR(30)
);
commit;

create table Reparation(
	idR VARCHAR(10) CONSTRAINT PK_Reparation PRIMARY KEY,
	idV VARCHAR(10) CONSTRAINT FK_idV REFERENCES Voiture,
	typedeRepar VARCHAR(50),
	daterep VARCHAR(20),
	etatrep VARCHAR(10)
);
commit;

create table Facture(
	idF VARCHAR(10) CONSTRAINT PK_Facture PRIMARY KEY,
	idR VARCHAR(10) CONSTRAINT FK_idR REFERENCES Reparation,	
	idC VARCHAR(10) CONSTRAINT FK_idC1 REFERENCES Client,
	prixpaye float(2),
	etatfact VARCHAR(20)
);
commit;

create sequence idCl
	start with 1
	MAXVALUE 999
	increment by 1;

create sequence idRepare
	start with 1
	MAXVALUE 999
	increment by 1;
commit;

create sequence idVoi
	start with 1
	MAXVALUE 999
	increment by 1;
commit;

create sequence idFact
	start with 1
	MAXVALUE 999
	increment by 1;
commit;


INSERT INTO Client VALUES (idCl.nextval,'RASOA','0324563782');
INSERT INTO Client VALUES (idCl.nextval,'RAKOTO','0343456781');
INSERT INTO Client VALUES (idCl.nextval,'RABE','0335467202');

create or replace view reparationvoiture as select Voiture.idC,Voiture.marqueVoiture,Voiture.numero,Reparation.typedeRepar,Reparation.etatrep from
Voiture,Reparation where Voiture.idV=Reparation.idV order by Reparation.idR desc;

