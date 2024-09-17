ALTER TABLE category
    ADD discount_percentage INT NULL;

ALTER TABLE category
    MODIFY discount_percentage INT NOT NULL;

ALTER TABLE product
    ADD number_of_orders BIGINT NULL;
