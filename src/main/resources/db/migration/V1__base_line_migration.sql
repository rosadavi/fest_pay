CREATE TABLE event
(
    id              UUID NOT NULL,
    name            VARCHAR(255),
    description     VARCHAR(255),
    location        VARCHAR(255),
    date_initial    date,
    date_final      date,
    created_at      date,
    updated_at      date,
    user_updated_id UUID,
    CONSTRAINT pk_event PRIMARY KEY (id)
);

CREATE TABLE product
(
    id          UUID NOT NULL,
    name        VARCHAR(255),
    price       INTEGER,
    description VARCHAR(255),
    created_at  date,
    updated_at  date,
    stall_id    UUID,
    CONSTRAINT pk_product PRIMARY KEY (id)
);

CREATE TABLE product_item
(
    id         UUID NOT NULL,
    name       VARCHAR(255),
    created_at date,
    updated_at date,
    product_id UUID,
    CONSTRAINT pk_product_item PRIMARY KEY (id)
);

CREATE TABLE stall
(
    id              UUID NOT NULL,
    name            VARCHAR(255),
    description     VARCHAR(255),
    created_at      date,
    updated_at      date,
    user_updated_id UUID,
    event_id        UUID,
    CONSTRAINT pk_stall PRIMARY KEY (id)
);

CREATE TABLE user_default
(
    id         UUID NOT NULL,
    email      VARCHAR(255),
    created_at date,
    updated_at date,
    CONSTRAINT pk_user_default PRIMARY KEY (id)
);

CREATE TABLE user_updated
(
    id              UUID NOT NULL,
    social_name     VARCHAR(255),
    phone           VARCHAR(255),
    cpf_cnpj        VARCHAR(255),
    description     VARCHAR(255),
    role            SMALLINT,
    created_at      date,
    updated_at      date,
    user_default_id UUID,
    CONSTRAINT pk_user_updated PRIMARY KEY (id)
);

ALTER TABLE user_default
    ADD CONSTRAINT uc_user_default_email UNIQUE (email);

ALTER TABLE user_updated
    ADD CONSTRAINT uc_user_updated_cpf_cnpj UNIQUE (cpf_cnpj);

ALTER TABLE user_updated
    ADD CONSTRAINT uc_user_updated_phone UNIQUE (phone);

ALTER TABLE user_updated
    ADD CONSTRAINT uc_user_updated_user_default UNIQUE (user_default_id);

ALTER TABLE event
    ADD CONSTRAINT FK_EVENT_ON_USER_UPDATED FOREIGN KEY (user_updated_id) REFERENCES user_updated (id);

ALTER TABLE product_item
    ADD CONSTRAINT FK_PRODUCT_ITEM_ON_PRODUCT FOREIGN KEY (product_id) REFERENCES product (id);

ALTER TABLE product
    ADD CONSTRAINT FK_PRODUCT_ON_STALL FOREIGN KEY (stall_id) REFERENCES stall (id);

ALTER TABLE stall
    ADD CONSTRAINT FK_STALL_ON_EVENT FOREIGN KEY (event_id) REFERENCES event (id);

ALTER TABLE stall
    ADD CONSTRAINT FK_STALL_ON_USER_UPDATED FOREIGN KEY (user_updated_id) REFERENCES user_updated (id);

ALTER TABLE user_updated
    ADD CONSTRAINT FK_USER_UPDATED_ON_USER_DEFAULT FOREIGN KEY (user_default_id) REFERENCES user_default (id);