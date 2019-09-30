-- ----------------------------------------------------------------
--  TABLE account_info
-- ----------------------------------------------------------------

CREATE TABLE test.account_info
(
   no      VARCHAR(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
   name    VARCHAR(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
   code    VARCHAR(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
   CONSTRAINT `FK_CODE` FOREIGN KEY(code)
      REFERENCES bank_info (`CODE`) ON UPDATE RESTRICT ON DELETE RESTRICT
)
ENGINE INNODB
COLLATE 'utf8mb4_0900_ai_ci'
ROW_FORMAT DEFAULT;


-- ----------------------------------------------------------------
--  TABLE bank_info
-- ----------------------------------------------------------------

CREATE TABLE test.bank_info
(
   `CODE`    VARCHAR(20)
               CHARACTER SET utf8mb4
               COLLATE utf8mb4_0900_ai_ci
               NOT NULL,
   `NAME`    VARCHAR(20)
               CHARACTER SET utf8mb4
               COLLATE utf8mb4_0900_ai_ci
               NULL,
   PRIMARY KEY(`CODE`)
)
ENGINE INNODB
COLLATE 'utf8mb4_0900_ai_ci'
ROW_FORMAT DEFAULT;


-- ----------------------------------------------------------------
--  TABLE deal_history
-- ----------------------------------------------------------------

CREATE TABLE test.deal_history
(
   deal_date     VARCHAR(20)
                   CHARACTER SET utf8mb4
                   COLLATE utf8mb4_0900_ai_ci
                   NULL,
   account_no    VARCHAR(20)
                   CHARACTER SET utf8mb4
                   COLLATE utf8mb4_0900_ai_ci
                   NULL,
   deal_no       INT(11) NULL,
   cash          INT(11) NULL,
   fee           INT(11) NULL,
   cancel_yn     CHAR(20)
                   CHARACTER SET utf8mb4
                   COLLATE utf8mb4_0900_ai_ci
                   NULL
)
ENGINE INNODB
COLLATE 'utf8mb4_0900_ai_ci'
ROW_FORMAT DEFAULT;