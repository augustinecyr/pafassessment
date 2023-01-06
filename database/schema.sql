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
    ), (
        'spongebob',
        '124 Conch Street, Bikini Bottom',
        'spongebob@yahoo.com'
    );

CREATE TABLE
    `order` (
        `order_id` char(8) NOT NULL,
        `delivery_id` VARCHAR(128) NOT NULL,
        `name` char(32) NOT NULL,
        `address` VARCHAR(128) NOT NULL,
        `email` VARCHAR(128) NOT NULL,
        `status` VARCHAR(128) NOT NULL,
        `order_date` DATETIME NOT NULL,
        PRIMARY KEY (`order_id`)
    );

create table
    lineitem (
        `item_id` int auto_increment not null,
        `item` text not null,
        `quantity` int default '1',
        `order_id` char(8) not null,
        primary key(item_id),
        constraint fk_order_id foreign key(order_id) references eshop.order(order_id)
    );

create table
    order_status (
        `order_id` char(8) NOT NULL,
        `delivery_id` VARCHAR(128) NOT NULL,
        `status` char(32) not null,
        `status_update` TIMESTAMP not null,
        primary key(order_id),
        constraint fk_order_id_status foreign key(order_id) references eshop.order(order_id)
    );