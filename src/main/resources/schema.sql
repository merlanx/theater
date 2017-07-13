DROP SCHEMA PUBLIC CASCADE;
CREATE TABLE  USER(
  USER_ID BIGINT GENERATED BY DEFAULT AS IDENTITY(START WITH 100, INCREMENT BY 1) PRIMARY KEY,
  LAST_NAME VARCHAR(64),
  FIRST_NAME VARCHAR(64),
  EMAIL VARCHAR(64),
  BIRTHDAY DATE,
  NUMBER_OF_TICKETS INT
);
CREATE TABLE TICKET(
  TICKET_ID BIGINT GENERATED BY DEFAULT AS IDENTITY(START WITH 100, INCREMENT BY 1) PRIMARY KEY,
  USER_ID INT,
  EVENT_ID INT,
  PRICING_STRATEGY_ID INT,
  SEAT VARCHAR(64),
  PRICE DOUBLE
);

ALTER TABLE TICKET ADD FOREIGN KEY (USER_ID) REFERENCES USER(USER_ID);
CREATE INDEX IDX_USER_MAIL_ ON USER(EMAIL);
