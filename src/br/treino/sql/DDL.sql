CREATE DATABASE IF NOT EXISTS locadora_db;
USE locadora_db;

CREATE TABLE IF NOT EXISTS clientes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cnh VARCHAR(20) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS veiculos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    tipo_veiculo ENUM('CARRO', 'MOTO') NOT NULL,
    placa VARCHAR(10) NOT NULL UNIQUE,
    modelo VARCHAR(50) NOT NULL,
    valor_diaria_base DECIMAL(10,2) NOT NULL,
    quantidade_portas INT NULL,
    ar_condicionado BOOLEAN NULL,
    cilindradas INT NULL
);