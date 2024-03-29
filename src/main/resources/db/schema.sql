--CREATE TABLE PERSONS (
--    IDPERSON INTEGER NOT NULL AUTO_INCREMENT,
--    FULL_NAME VARCHAR(255) NOT NULL,
--    EMAIL VARCHAR(255) NOT NULL,
--    PHONE_NUMBER VARCHAR(255) NOT NULL,
--    CARDID VARCHAR(255) NOT NULL,
--    PRIMARY KEY (IDPERSON)
--);

	CREATE TABLE "PUBLIC"."PERSONS"(
    "IDPERSON" BIGINT NOT NULL,
    "FULL_NAME" VARCHAR(255) NOT NULL,
    "EMAIL" VARCHAR(255) NOT NULL,
    "PHONE_NUMBER" VARCHAR(255) NOT NULL,
    "CARDID" VARCHAR(255) NOT NULL
);


    CREATE TABLE "PUBLIC"."BANKS"(
    "ID" BIGINT NOT NULL,
    "IDCREDIT" BIGINT,
    "IDPERSON" BIGINT
);

	CREATE TABLE "PUBLIC"."CREDITS"(
    "IDCREDIT" BIGINT NOT NULL,
    "LIMITES" VARCHAR(255) NOT NULL,
    "PERCENT" VARCHAR(255)
);

    CREATE TABLE "PUBLIC"."CREDITS_OFFER"(
    "ID_OFFER" BIGINT NOT NULL,
    "CREDIT" VARCHAR(255),
    "FULL_CREDIT" VARCHAR(255),
    "NAME" VARCHAR(255),
    "IDCREDIT" BIGINT,
    "IDPERSON" BIGINT
);

    CREATE TABLE "PUBLIC"."DATE_OF_PAY"(
    "ID" BIGINT NOT NULL,
    "BODY" VARCHAR(255),
    "DATE" VARCHAR(255),
    "PAY" VARCHAR(255),
    "PERCENT" VARCHAR(255),
    "ID_OFFER" BIGINT
);