CREATE TABLE devices (
  id BIGINT GENERATED BY DEFAULT AS IDENTITY,
  address VARCHAR(255),
  name VARCHAR(255),
  PRIMARY KEY (id)
  );