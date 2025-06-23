-- Création de la base
CREATE DATABASE IF NOT EXISTS MyStore;
USE MyStore;

-- Table : utilisateurs (administrateur, médecin, secrétaire)
CREATE TABLE utilisateurs (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(100),
    prenom VARCHAR(100),
    email VARCHAR(150) UNIQUE,
    mot_de_passe VARCHAR(255),
    role ENUM('admin', 'medecin', 'secretaire') NOT NULL
);

-- Table : patients
CREATE TABLE patient (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(100),
    prenom VARCHAR(100),
    sexe CHAR(1),
    date_naissance DATE,
    numero_dossier VARCHAR(50) UNIQUE
);

-- Table : consultations
CREATE TABLE consultations (
    id INT AUTO_INCREMENT PRIMARY KEY,
    patient_id INT,
    medecin_id INT,
    date_consultation DATE,
    heure_consultation TIME,
    motif TEXT,
    diagnostic TEXT,
    traitement TEXT,
    FOREIGN KEY (patient_id) REFERENCES patients(id),
    FOREIGN KEY (medecin_id) REFERENCES utilisateurs(id)
);

-- Table : rendez_vous
CREATE TABLE rendez_vous (
    id INT AUTO_INCREMENT PRIMARY KEY,
    patient_id INT,
    medecin_id INT,
    date_rdv DATE,
    heure_rdv TIME,
    statut ENUM('prévu', 'annulé', 'effectué') DEFAULT 'prévu',
    FOREIGN KEY (patient_id) REFERENCES patients(id),
    FOREIGN KEY (medecin_id) REFERENCES utilisateurs(id)
);

-- Table : consultations urgentes
CREATE TABLE urgences (
    id INT AUTO_INCREMENT PRIMARY KEY,
    patient_id INT,
    date_urgence DATE,
    heure_urgence TIME,
    description TEXT,
    prise_en_charge TEXT,
    FOREIGN KEY (patient_id) REFERENCES patients(id)
);
