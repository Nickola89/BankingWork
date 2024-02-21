Create TABLE transactiondata.passports (
                                           id serial PRIMARY KEY NOT NULL ,
                                           number varchar(50) NOT NULL ,
                                           issuing_country varchar(50) not null ,
                                           date_of_issue date
);

CREATE TABLE transactiondata.customers (
                                           id serial NOT NULL,
                                           name varchar(50) NOT NULL,
                                           last_name varchar(50) NOT NULL,
                                           age INT NOT NULL,
                                           address varchar (50) ,
                                           phone_number varchar(50),
                                           email varchar(50),
                                           birthday date,
                                           registration_date date,
                                           passport_id  bigint,
                                           cash numeric,

                                           CONSTRAINT customers_pkey PRIMARY KEY (id),
                                           CONSTRAINT fk_passport FOREIGN KEY (passport_id) REFERENCES transactiondata.passports (id) ON delete cascade
);

CREATE TABLE transactiondata.accounts (
                                          id serial PRIMARY KEY NOT NULL ,
                                          account_number bigint,
                                          customer_id bigint,
                                          balance bigint,
                                          opening_date timestamp,
                                          FOREIGN KEY (customer_id) REFERENCES transactiondata.customers (id) ON delete cascade

);

Create table transactiondata.transactions (
                                              id serial primary key not null ,
                                              sender_account_id bigint ,
                                              recipient_account_id bigint,
                                              transaction_amount bigint ,
                                              date_time_transaction timestamp,
                                              transaction_type text,
                                              FOREIGN KEY (sender_account_id) REFERENCES transactiondata.accounts (id) ON delete cascade ,
                                              FOREIGN KEY (recipient_account_id) REFERENCES transactiondata.accounts (id) ON delete cascade
);
