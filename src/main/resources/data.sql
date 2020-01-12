DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS accounts;

CREATE TABLE accounts
(
id              BIGINT AUTO_INCREMENT PRIMARY KEY,
account_balance DOUBLE
);

CREATE TABLE users
(
id              BIGINT AUTO_INCREMENT PRIMARY KEY,
first_name      VARCHAR(250) NOT NULL,
last_name       VARCHAR(250) NOT NULL,
date_of_birth   DATE,
account_id      BIGINT REFERENCES accounts (id)
);

INSERT INTO accounts (id, account_balance) VALUES
(1, 15200.60),
(2, 6800.75),
(3, 1258.30),
(4, 658.20),
(5, 23280.53),
(6, 1200.60),
(7, 18540.75),
(8, 5638.30),
(9, 9658.20),
(10, 3080.64);

INSERT INTO users (id, first_name, last_name, date_of_birth, account_id) VALUES
(1, 'Jan', 'Kowalski', '1985-10-03', 1),
(2, 'Adam', 'Adamowicz', '1990-05-05', 2),
(3, 'Wojciech', 'Wojtkowiak', '1980-07-09', 3),
(4, 'Edyta', 'Walczak', '1965-11-10', 4),
(5, 'Dawid', 'Nowak', '1986-01-25', 5),
(6, 'Adam', 'Wojnicki', '1970-05-06', 6),
(7, 'Maria', 'Adamowicz', '1982-07-12', 7),
(8, 'Adrianna', 'Nowak', '1995-07-16', 8),
(9, 'Filip', 'Walczak', '1965-11-10', 9),
(10, 'Dawid', 'Kowalczyk', '1975-04-09', 10);