--DROP TABLE IF EXISTS patient_diet_order;
CREATE TABLE IF NOT EXISTS patient_diet_order
(
  id            CHAR (36) PRIMARY KEY NOT NULL,
  created_at    BIGINT(40),
  last_modified BIGINT(40),
  value         VARCHAR(255)
);