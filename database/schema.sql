CREATE USER 'eshop' @'localhost' IDENTIFIED BY 'password';

GRANT
    ALL PRIVILEGES ON *.* TO 'eshop' @'localhost'
WITH
GRANT OPTION;

drop database if exists eshop;

create database eshop;

use eshop;

commit;

CREATE TABLE
    `customers` (
        `name` char(32) NOT NULL,
        `address` VARCHAR(128) NOT NULL,
        `email` VARCHAR(128) NOT NULL,
        PRIMARY KEY (`name`),
        UNIQUE (`name`)
    );

INSERT INTO
    customers (name, address, email)
VALUES (
        'fred',
        '201 Cobblestone Lane',
        'fredflintstone@bedrock.com'
    ), (
        'sherlock',
        '221B Baker Street, London',
        'sherlock@consultingdetective.org'
    ), (
        'jessica',
        '698 Candlewood Land, Cabot Cove',
        'fletcher@gmail.com'
    ), (
        'dursley',
        '4 Privet Drive,
    Little Whinging',
        'dursley@gmail.com'
    ) (
        'spongebob',
        '124 Conch Street, Bikini Bottom',
        'spongebob@yahoo.com'
    )


